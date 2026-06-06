package com.kelco.kamenridercraft.item.heisei_phase_2.gaim;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.base_items.BaseItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


public class HimawariLockseedItem extends BaseItem {
    public HimawariLockseedItem(Properties properties) {
        super(properties);
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        super.use(level, player, interactionHand);
        ItemStack itemstack = player.getItemInHand(interactionHand);
        if (!level.isClientSide() && player.getItemBySlot(EquipmentSlot.FEET).is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "belts/gaim_armor")))) {
            player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 100, 0, false, true));
            player.getCooldowns().addCooldown(this, 200);
            if (!player.isCreative()) {
                itemstack.consume(1, player);
            }
            player.awardStat(Stats.ITEM_USED.get(this));
        }

        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
    }

}