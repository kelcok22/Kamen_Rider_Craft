package com.kelco.kamenridercraft.item.reiwa.geats;

import com.kelco.kamenridercraft.entity.vehicles.BoostrikerEntity;
import com.kelco.kamenridercraft.item.base_items.RiderFormChangeItem;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;


public class RiderCoreIDItem extends RiderFormChangeItem {
    private String riderLogo;

    public RiderCoreIDItem(Properties properties, String formName, String riderName, String beltTex, MobEffectInstance... effects) {
        super(properties, formName, riderName, beltTex, effects);
    }

    public RiderCoreIDItem setRiderLogo(String logo) {
        this.riderLogo = logo;
        return this;
    }

    @Override
    public @NotNull InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity interactionTarget, InteractionHand usedHand) {
        if (interactionTarget instanceof BoostrikerEntity boost) {
            boost.setRiderLogo(riderLogo);
            boost.MAX_SPEED = 0.01f;
            return InteractionResult.PASS;
        }
        return super.interactLivingEntity(stack, player, interactionTarget, usedHand);
    }
}