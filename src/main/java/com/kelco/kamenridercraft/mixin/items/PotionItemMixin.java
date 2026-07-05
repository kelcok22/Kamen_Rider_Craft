package com.kelco.kamenridercraft.mixin.items;

import com.kelco.kamenridercraft.effects.EffectCore;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = PotionItem.class, priority = 899)
public class PotionItemMixin {
    @Inject(method = "use", at = @At("HEAD"), cancellable = true)
    public void use(Level level, Player player, InteractionHand usedHand, CallbackInfoReturnable<InteractionResultHolder> ci) {
        ItemStack itemstack = player.getItemInHand(usedHand);
        if (player.hasEffect(EffectCore.GHOST)) {
            ci.setReturnValue(InteractionResultHolder.fail(itemstack));
        }
    }
}