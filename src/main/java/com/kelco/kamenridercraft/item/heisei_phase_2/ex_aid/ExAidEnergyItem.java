package com.kelco.kamenridercraft.item.heisei_phase_2.ex_aid;

import com.google.common.collect.Lists;
import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.item.base_items.BaseItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.ExAidRiderItems;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;


public class ExAidEnergyItem extends BaseItem {
    private List<MobEffectInstance> potionEffectList;

    public ExAidEnergyItem(Properties properties, MobEffectInstance... effects) {
        super(properties);
        potionEffectList = Lists.newArrayList(effects);
    }


    public void useEnergyItem(ItemStack itemstack, Level level, Player player) {
        if (!level.isClientSide()) {
            for (MobEffectInstance effect : potionEffectList) {
				player.addEffect(new MobEffectInstance(effect.getEffect(), effect.getDuration(), effect.getAmplifier(), true, false));
            }
            itemstack.shrink(1);
			player.awardStat(Stats.ITEM_USED.get(this));
        }
    }

    @Override
    public void inventoryTick(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull Entity entity, int num, boolean flag) {
        if (entity instanceof Player player
                && !player.hasEffect(EffectCore.BUGSTER)
                && player.getInventory().countItem(ExAidRiderItems.ENERGY_ITEM_HOLDER.get()) == 0)
            this.useEnergyItem(itemStack, level, player);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemstack = player.getItemInHand(interactionHand);

        this.useEnergyItem(itemstack, level, player);
        return InteractionResultHolder.consume(itemstack);
    }
}