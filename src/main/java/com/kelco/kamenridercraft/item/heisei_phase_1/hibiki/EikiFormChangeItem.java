package com.kelco.kamenridercraft.item.heisei_phase_1.hibiki;

import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.item.ModdedItemCore;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.base_items.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.heisei_phase_1.HibikiRiderItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class EikiFormChangeItem extends RiderFormChangeItem {
    public EikiFormChangeItem(Properties properties, String formName, String riderName, String beltTex, MobEffectInstance... effects) {
        super(properties, formName, riderName, beltTex, effects);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack BELT = player.getItemBySlot(EquipmentSlot.FEET);

        if (!level.isClientSide() && !player.hasEffect(EffectCore.FORM_LOCK)) {
            if (BELT.getItem() instanceof RiderDriverItem belt) {
                if (canChange(player, belt, BELT) || RiderDriverItem.getFormItem(BELT, 1) == HibikiRiderItems.HENSHIN_ONSA_AKATSUKI.get()) {
                    if (RiderDriverItem.getFormItem(BELT, 2) == ModdedItemCore.BLANK_FORM.get())
                        RiderDriverItem.setFormItem(BELT, HibikiRiderItems.MASKLESS_ONI.get(), 2);
                    else RiderDriverItem.setFormItem(BELT, ModdedItemCore.BLANK_FORM.get(), 2);
                }
            }
        }
        return super.use(level, player, usedHand);
    }
}
