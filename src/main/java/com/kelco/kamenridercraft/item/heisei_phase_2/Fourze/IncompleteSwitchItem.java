package com.kelco.kamenridercraft.item.heisei_phase_2.Fourze;

import com.kelco.kamenridercraft.item.base_items.BaseItem;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;


public class IncompleteSwitchItem extends BaseItem {
    CompoundTag tag = new CompoundTag();

    public IncompleteSwitchItem(Properties properties) {
        super(properties);
        tag.putInt("danger", 0);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        if (player instanceof ServerPlayer) {
            player.level().playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.UI_BUTTON_CLICK, SoundSource.PLAYERS, 1.0F, 8F);
            player.getCooldowns().addCooldown(this, 10);
            if (tag.getInt("danger") > 8) {
                tag.putInt("danger", 0);
                player.level().playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.GENERIC_EXPLODE, SoundSource.PLAYERS, 1.0F, 1F);
                ((ServerLevel) player.level()).sendParticles(ParticleTypes.EXPLOSION_EMITTER,
                        player.getX(), player.getY() + 1,
                        player.getZ(), 10, 0, 0, 0, 0.05);
                player.displayClientMessage(Component.literal("§l§4GOODBYE!"), true);
            } else {
                tag.putInt("danger", tag.getInt("danger") + 1);
                player.displayClientMessage(Component.literal("§l§4DANGER!"), true);
            }
        }
        return super.use(level, player, usedHand);
    }
}