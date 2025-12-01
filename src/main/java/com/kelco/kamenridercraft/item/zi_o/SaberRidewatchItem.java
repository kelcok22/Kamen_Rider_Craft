package com.kelco.kamenridercraft.item.zi_o;

import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.summons.GrandSummonEntity;
import com.kelco.kamenridercraft.item.BaseItems.CopyFormChangeItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.Saber_Rider_Items;
import com.kelco.kamenridercraft.item.Zi_O_Rider_Items;
import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.HashMap;
import java.util.Map;


public class SaberRidewatchItem extends RiderFormChangeItem {
    private Map<String, String[]> summonAltForms = new HashMap<>();
    private Map<String, String[]> summonAltWeapons = new HashMap<>();

    public SaberRidewatchItem(Properties properties, int belt, String formName, String ridername, String beltTex, MobEffectInstance... effects) {
        super(properties, belt, formName, ridername, beltTex, effects);
    }

    public SaberRidewatchItem addAltForm(String item, String... forms) {
        this.summonAltForms.put(item, forms);
        return this;
    }

    public SaberRidewatchItem addAltWeapon(String item, String... weapons) {
        this.summonAltWeapons.put(item, weapons);
        return this;
    }

    public void summon(Level level, Player player) {
		GrandSummonEntity summon = MobsCore.GRAND_SUMMON.get().create(level);
		if (summon != null) {
            summon.allowFormChanges(true);
            RiderDriverItem belt = (RiderDriverItem) Saber_Rider_Items.SEIKEN_SWORDRIVER_DRIVER_SABER.get();
            summon.moveTo(player.getX(), player.getY()+1, player.getZ(), player.getYRot(), player.getXRot());
            summon.setItemSlot(EquipmentSlot.HEAD, new ItemStack(belt.HEAD));
            summon.setItemSlot(EquipmentSlot.CHEST, new ItemStack(belt.TORSO));
            summon.setItemSlot(EquipmentSlot.LEGS, new ItemStack(belt.LEGS));
            summon.setItemSlot(EquipmentSlot.FEET, new ItemStack(belt));
            Item key = player.getOffhandItem().getItem();

            if (this.summonAltWeapons.containsKey(key.toString())) {
                summon.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse(this.summonAltWeapons.get(key.toString())[0]))));
                if (this.summonAltWeapons.get(key.toString()).length > 1) summon.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse(this.summonAltWeapons.get(key.toString())[1]))));
            } else summon.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Saber_Rider_Items.KAENKEN_REKKA.get()));
            for (ItemStack weapon : summon.getHandSlots()) weapon.set(DataComponents.ITEM_NAME, Component.translatable("owner.kamenridercraft.zi_o", weapon.getHoverName()));

            if (key instanceof RiderFormChangeItem || key instanceof CopyFormChangeItem) key.interactLivingEntity(player.getOffhandItem(), player, summon, InteractionHand.OFF_HAND);
            if (this.summonAltForms.containsKey(key.toString())) {
                for (String str : this.summonAltForms.get(key.toString())) {
                    RiderFormChangeItem form = (RiderFormChangeItem) BuiltInRegistries.ITEM.get(ResourceLocation.parse(str));
                    RiderDriverItem.set_Form_Item(summon.getItemBySlot(EquipmentSlot.FEET), form, form.getSlot());
                }
            }
        
			level.addFreshEntity(summon);
			summon.bindToPlayer(player);
            summon.allowFormChanges(false);
            if (!player.isCreative()) player.getCooldowns().addCooldown(this, 200);
            player.awardStat(Stats.ITEM_USED.get(this));
		}
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack itemstack = player.getItemInHand(usedHand);
        ItemStack BELT = player.getItemBySlot(EquipmentSlot.FEET);

        if (level.getGameRules().getBoolean(ModGameRules.RULE_REIWA_RIDEWATCHES) && player.isShiftKeyDown() && BELT.getItem() instanceof RiderDriverItem driver && driver.isTransformed(player)
        && (RiderDriverItem.get_Form_Item(BELT, 1) == Zi_O_Rider_Items.UNFINISHED_OHMA_ZI_O_DRIVER_L.get()
        || RiderDriverItem.get_Form_Item(BELT, 1) == Zi_O_Rider_Items.OHMA_ZI_O_RIDEWATCH.get())) {
            summon(level, player);
            return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
        }
        return super.use(level, player, usedHand);

    }
}
