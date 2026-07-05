package com.kelco.kamenridercraft.item.reiwa.saber;

import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.bosses.FalchionEntity;
import com.kelco.kamenridercraft.item.base_items.BaseItem;
import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.Difficulty;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;


public class BookOfRuinItem extends BaseItem {

    public BookOfRuinItem(Properties properties) {
        super(properties);
    }

    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemstack = player.getItemInHand(interactionHand);
        if (!level.isClientSide() && level.getDifficulty() != Difficulty.PEACEFUL) {
            Vec3 look = player.getLookAngle();

            FalchionEntity falchion = MobsCore.FALCHION.get().create(level);
            if (falchion != null) {
                if (level.getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUCEMENTS))
                    player.sendSystemMessage(Component.translatable("henshin.kamenridercraft.falchion"));
                falchion.moveTo((player.getX() + look.x * 3), player.getY(), (player.getZ() + look.z * 3), player.getYRot(), 0.0F);
                level.addFreshEntity(falchion);
                itemstack.shrink(1);
                player.awardStat(Stats.ITEM_USED.get(this));
            }
        }
        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
    }
}