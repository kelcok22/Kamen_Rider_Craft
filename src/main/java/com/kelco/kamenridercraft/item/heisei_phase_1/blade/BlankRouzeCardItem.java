package com.kelco.kamenridercraft.item.heisei_phase_1.blade;


import com.kelco.kamenridercraft.entity.base_entities.BaseProjectileEntity;
import com.kelco.kamenridercraft.item.base_items.BaseItem;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import static com.kelco.kamenridercraft.item.heisei_phase_1.BladeRiderItems.BLANK_ROUZECARD;


public class BlankRouzeCardItem extends BaseItem {
    private String sealingType = "blank_rouze";
    private String[] effects;

    public BlankRouzeCardItem(Properties prop) {
        super(prop);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        if (player instanceof ServerPlayer serverPlayer && usedHand == InteractionHand.MAIN_HAND) {
            BaseProjectileEntity baseProjectile = new BaseProjectileEntity(level, serverPlayer, "blank_rouze", 0, 0, effects);
            baseProjectile.setTexture(sealingType);
            baseProjectile.setModel("card");
            baseProjectile.setProjectile("blank_rouze");
            baseProjectile.setGlowing(false);
            baseProjectile.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2f, 1F);
            level.addFreshEntity(baseProjectile);

            serverPlayer.awardStat(Stats.ITEM_USED.get(this));
            serverPlayer.setItemInHand(usedHand, serverPlayer.getItemInHand(usedHand));
            serverPlayer.getItemInHand(usedHand).consume(1, player);
            serverPlayer.getCooldowns().addCooldown(BLANK_ROUZECARD.get(), 40);
        }
        return super.use(level, player, usedHand);
    }
}