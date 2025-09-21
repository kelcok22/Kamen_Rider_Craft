package com.kelco.kamenridercraft.item.gotchard;

import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.summons.LegendarySummonEntity;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.Geats_Rider_Items;
import com.kelco.kamenridercraft.item.Gotchard_Rider_Items;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.*;

public class LegendChemyCardItem extends RiderFormChangeItem {
    private RiderDriverItem baseForm;
    private final List<RiderFormChangeItem> baseFormItems = new ArrayList<>();
    private RiderDriverItem superForm;
    private final List<RiderFormChangeItem> superFormItems = new ArrayList<>();
    public LegendChemyCardItem(Properties properties, int belt, String formName, String ridername, String beltTex, MobEffectInstance... effects) {
        super(properties, belt, formName, ridername, beltTex, effects);
    }

    public LegendChemyCardItem setBaseSummon(RiderDriverItem belt) {
        baseForm = belt;
        return this;
    }
    public LegendChemyCardItem setBaseSummon(RiderDriverItem belt, RiderFormChangeItem... forms) {
        baseForm = belt;
        if (forms != null) baseFormItems.addAll(List.of(forms));
        return this;
    }

    public LegendChemyCardItem setSuperSummon(RiderDriverItem belt) {
        superForm = belt;
        return this;
    }
    public LegendChemyCardItem setSuperSummon(RiderDriverItem belt, RiderFormChangeItem... forms) {
        superForm = belt;
        if (forms != null) superFormItems.addAll(List.of(forms));
        return this;
    }

    public boolean canSummonLegends(Player player) {
        return player.isShiftKeyDown() && player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof LegenDriverItem driver && driver.isTransformed(player)
                && RiderDriverItem.get_Form_Item(player.getItemBySlot(EquipmentSlot.FEET), 1) == this;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        if (canSummonLegends(player)) {
            LegendarySummonEntity summon = MobsCore.LEGENDARY_SUMMON.get().create(level);
            if (summon != null) {
                summon.moveTo(player.getX(), player.getY() + 1, player.getZ(), player.getYRot(), player.getXRot());
                summon.setItemSlot(EquipmentSlot.HEAD, new ItemStack(baseForm.HEAD));
                summon.setItemSlot(EquipmentSlot.CHEST, new ItemStack(baseForm.TORSO));
                summon.setItemSlot(EquipmentSlot.LEGS, new ItemStack(baseForm.LEGS));
                summon.setItemSlot(EquipmentSlot.FEET, new ItemStack(baseForm));
                if (!baseFormItems.isEmpty())
                    for (RiderFormChangeItem form : baseFormItems) RiderDriverItem.set_Form_Item(summon.getItemBySlot(EquipmentSlot.FEET), form, form.getSlot());
                if (this == Gotchard_Rider_Items.GEATS_IX_RIDE_CHEMY_CARD.get()) RiderDriverItem.set_Form_Item(summon.getItemBySlot(EquipmentSlot.FEET), Geats_Rider_Items.BOOST_RAISE_BUCKLE.get(), 3);

                level.addFreshEntity(summon);
                summon.bindToPlayer(player);
                summon.addRequiredForm(this, 1);
            }

            LegendarySummonEntity summon2 = MobsCore.LEGENDARY_SUMMON.get().create(level);
            if (summon2 != null) {
                summon2.moveTo(player.getX(), player.getY() + 1, player.getZ(), player.getYRot(), player.getXRot());
                summon2.setItemSlot(EquipmentSlot.HEAD, new ItemStack(superForm.HEAD));
                summon2.setItemSlot(EquipmentSlot.CHEST, new ItemStack(superForm.TORSO));
                summon2.setItemSlot(EquipmentSlot.LEGS, new ItemStack(superForm.LEGS));
                summon2.setItemSlot(EquipmentSlot.FEET, new ItemStack(superForm));
                if (!superFormItems.isEmpty())
                    for (RiderFormChangeItem form : superFormItems) RiderDriverItem.set_Form_Item(summon2.getItemBySlot(EquipmentSlot.FEET), form, form.getSlot());
                if (this == Gotchard_Rider_Items.GEATS_IX_RIDE_CHEMY_CARD.get()) RiderDriverItem.set_Form_Item(summon2.getItemBySlot(EquipmentSlot.FEET), Geats_Rider_Items.BOOST_MKII_RAISE_BUCKLE.get(), 3);

                level.addFreshEntity(summon2);
                summon2.bindToPlayer(player);
                summon2.addRequiredForm(this, 1);
            }
            if (!player.isCreative()) player.getCooldowns().addCooldown(this, 750);
            player.awardStat(Stats.ITEM_USED.get(this));
            return InteractionResultHolder.sidedSuccess(player.getItemInHand(usedHand), level.isClientSide());
        }
        return super.use(level, player, usedHand);
    }
}
