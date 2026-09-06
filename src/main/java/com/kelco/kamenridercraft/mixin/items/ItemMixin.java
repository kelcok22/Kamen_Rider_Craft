package com.kelco.kamenridercraft.mixin.items;

import com.kelco.kamenridercraft.effects.EffectCore;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = Item.class, priority = 899)
public class ItemMixin {
    @ModifyExpressionValue(method = "use", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Player;canEat(Z)Z"))
    public boolean use(boolean original, @Local(argsOnly = true) Player player) {
        return original && !player.hasEffect(EffectCore.GHOST);
    }
}