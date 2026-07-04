package com.kelco.kamenridercraft.item.heisei_phase_2.build;

import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.base_items.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.BuildRiderItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class HazardTriggerItem extends RiderFormChangeItem {


    public HazardTriggerItem(Properties properties, String formName, String ridername, String beltTex, MobEffectInstance... effects) {
        super(properties, formName, ridername, beltTex, effects);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack itemstack = player.getItemInHand(usedHand);
        ItemStack BELT = player.getItemBySlot(EquipmentSlot.FEET);

        if (!level.isClientSide()) {
            if (!player.hasEffect(EffectCore.FORM_LOCK) && BELT.getItem() instanceof BuildDriverItem belt && canChange(player, belt, BELT)) {
                RiderDriverItem.setFormItem(player.getItemBySlot(EquipmentSlot.FEET), BuildRiderItems.FULL_BOTTLE.get(), 3);
                if (BuildDriverItem.CanHazard(BELT)) {
                    super.use(level, player, usedHand);
                }
            }
        }
        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
    }
}