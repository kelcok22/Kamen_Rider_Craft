package com.kelco.kamenridercraft.item.heisei_phase_1.blade;


import com.kelco.kamenridercraft.entity.projectiles.RouzeCardEntity;
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
            RouzeCardEntity rouzeCard = new RouzeCardEntity(level, serverPlayer, "blank_rouze",
                    0, 0, effects);
            rouzeCard.setTexture(sealingType);
            rouzeCard.setModel("card");
            rouzeCard.setProjectile("blank_rouze");
            rouzeCard.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1f, 1F);
            level.addFreshEntity(rouzeCard);

            serverPlayer.awardStat(Stats.ITEM_USED.get(this));
            serverPlayer.setItemInHand(usedHand, serverPlayer.getItemInHand(usedHand));
            serverPlayer.getItemInHand(usedHand).consume(1, player);
            serverPlayer.getCooldowns().addCooldown(BLANK_ROUZECARD.get(), 40);
        }
        return super.use(level, player, usedHand);
    }
}