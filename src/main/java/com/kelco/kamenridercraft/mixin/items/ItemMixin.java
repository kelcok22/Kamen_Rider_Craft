package com.kelco.kamenridercraft.mixin.items;

import com.kelco.kamenridercraft.effects.EffectCore;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = Item.class, priority = 899)
public class ItemMixin {
    @Inject(method = "use", at = @At("HEAD"), cancellable = true)
    public void use(Level level, Player player, InteractionHand usedHand, CallbackInfoReturnable<InteractionResultHolder> ci) {
        ItemStack itemstack = player.getItemInHand(usedHand);
        FoodProperties foodproperties = itemstack.getFoodProperties(player);
        var item = ((Item) (Object) this);

        if (foodproperties != null && player.hasEffect(EffectCore.GHOST)) {
            ci.setReturnValue(InteractionResultHolder.fail(itemstack));
        }
    }
}