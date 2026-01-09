package com.kelco.kamenridercraft.item.geats;

import com.kelco.kamenridercraft.entities.bikes.BoostrikerEntity;
import com.kelco.kamenridercraft.item.BaseItems.RiderFormChangeItem;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;


public class RiderCoreIDItem extends RiderFormChangeItem {
    private String riderLogo;

    public RiderCoreIDItem(Properties properties, int belt, String formName, String ridername, String beltTex, MobEffectInstance... effects) {
        super(properties, belt, formName, ridername, beltTex, effects);
    }

    public RiderCoreIDItem setRiderLogo(String logo) {
        this.riderLogo = logo;
        return this;
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity interactionTarget, InteractionHand usedHand) {
        if (interactionTarget instanceof BoostrikerEntity boost) {
            boost.setRiderLogo(riderLogo);
            boost.MAX_SPEED = 0.01f;
            return InteractionResult.PASS;
        }
        return super.interactLivingEntity(stack, player, interactionTarget, usedHand);
    }
}
