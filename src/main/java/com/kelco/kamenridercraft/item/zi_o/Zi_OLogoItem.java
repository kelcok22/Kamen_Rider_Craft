package com.kelco.kamenridercraft.item.zi_o;

import java.util.HashMap;
import java.util.Map;

import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.summons.GrandSummonEntity;
import com.kelco.kamenridercraft.item.Gaim_Rider_Items;
import com.kelco.kamenridercraft.item.Zi_O_Rider_Items;
import com.kelco.kamenridercraft.item.BaseItems.BaseBannerPatternItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
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
            Item key = player.getItemBySlot(EquipmentSlot.OFFHAND).getItem();
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
            if (belt == Gaim_Rider_Items.SENGOKU_DRIVER_ZENGETSU.get()) RiderDriverItem.set_Form_Item(summon.getItemBySlot(EquipmentSlot.FEET), Gaim_Rider_Items.ZANGETSU_KACHIDOKI_LOCKSEED.get(), 1);
        
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
        && (RiderDriverItem.get_Form_Item(player.getItemBySlot(EquipmentSlot.FEET), 1) == Zi_O_Rider_Items.UNFINISHED_OHMA_ZI_O_DRIVER_L.get()
        || RiderDriverItem.get_Form_Item(player.getItemBySlot(EquipmentSlot.FEET), 1) == Zi_O_Rider_Items.OHMA_ZI_O_RIDEWATCH.get())
        && this.summonBelts.containsKey(player.getOffhandItem().getItem().toString())) {
            summon(itemstack, level, player);
            return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
        }
        return super.use(level, player, usedHand);

    }
}
