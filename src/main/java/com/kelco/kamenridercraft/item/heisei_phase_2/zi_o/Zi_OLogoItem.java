package com.kelco.kamenridercraft.item.heisei_phase_2.zi_o;

import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.summons.GrandSummonEntity;
import com.kelco.kamenridercraft.item.base_items.BaseBannerPatternItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.GaimRiderItems;
import com.kelco.kamenridercraft.item.heisei_phase_2.ZiORiderItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.Stats;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BannerPattern;

import java.util.HashMap;
import java.util.Map;

public class Zi_OLogoItem extends BaseBannerPatternItem {
    private Map<String, String> summonBelts = new HashMap<>();
    private Map<String, String[]> summonWeapons = new HashMap<>();

    public Zi_OLogoItem(TagKey<BannerPattern> bannerPattern, Item.Properties properties) {
        super(bannerPattern, properties);
    }

    public Zi_OLogoItem addBelt(String item, String belt) {
        this.summonBelts.put(item, belt);
        return this;
    }

    public Zi_OLogoItem addWeapon(String item, String... weapons) {
        this.summonWeapons.put(item, weapons);
        return this;
    }

    public void summon(ItemStack stack, Level level, Player player) {
		GrandSummonEntity summon = MobsCore.GRAND_SUMMON.get().create(level);
		if (summon != null) {
			summon.moveTo(player.getX(), player.getY()+1, player.getZ(), player.getYRot(), player.getXRot());
            Item key = player.getOffhandItem().getItem();
            RiderDriverItem belt = (RiderDriverItem)BuiltInRegistries.ITEM.get(ResourceLocation.parse(this.summonBelts.get(key.toString())));
            summon.setItemSlot(EquipmentSlot.FEET, new ItemStack(belt));
			summon.setItemSlot(EquipmentSlot.HEAD, new ItemStack(belt.HEAD));
			summon.setItemSlot(EquipmentSlot.CHEST, new ItemStack(belt.TORSO));
			summon.setItemSlot(EquipmentSlot.LEGS, new ItemStack(belt.LEGS));

            if (this.summonWeapons.containsKey(key.toString())) {
                String[] weapons = this.summonWeapons.get(key.toString());
                summon.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse(weapons[0]))));
                if (this.summonWeapons.get(key.toString()).length > 1) summon.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse(weapons[1]))));
            }
            if (belt == GaimRiderItems.SENGOKU_DRIVER_ZENGETSU.get()) RiderDriverItem.setFormItem(summon.getItemBySlot(EquipmentSlot.FEET), GaimRiderItems.ZANGETSU_KACHIDOKI_LOCKSEED.get(), 1);
        
			level.addFreshEntity(summon);
			summon.bindToPlayer(player);
            if (!player.isCreative()) player.getCooldowns().addCooldown(this, 200);
            player.awardStat(Stats.ITEM_USED.get(this));
		}
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack itemstack = player.getItemInHand(usedHand);
        Item BELT = player.getItemBySlot(EquipmentSlot.FEET).getItem();

        if (player.isShiftKeyDown() && BELT instanceof RiderDriverItem driver && driver.isTransformed(player)
        && (RiderDriverItem.getFormItem(player.getItemBySlot(EquipmentSlot.FEET), 1) == ZiORiderItems.UNFINISHED_OHMA_ZI_O_DRIVER_L.get()
        || RiderDriverItem.getFormItem(player.getItemBySlot(EquipmentSlot.FEET), 1) == ZiORiderItems.OHMA_ZI_O_RIDEWATCH.get())
        && this.summonBelts.containsKey(player.getOffhandItem().getItem().toString())) {
            summon(itemstack, level, player);
            return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
        }
        return super.use(level, player, usedHand);

    }
}
