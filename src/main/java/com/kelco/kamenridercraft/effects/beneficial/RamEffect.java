package com.kelco.kamenridercraft.effects.beneficial;

import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.entity.vehicles.baseBikeEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.sounds.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;
import java.util.Random;


public class RamEffect extends InstantenousMobEffect {


    public RamEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }


    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (livingEntity.level() instanceof ServerLevel serverLevel && livingEntity instanceof Player player) {
            if (player.isSprinting() || !player.onGround() || player.isPassenger()) {
                if (player.onGround()) {
                    double d0 = livingEntity.getX() + (double) Mth.randomBetween(serverLevel.random, -0.7F, 0.7F);
                    double d1 = livingEntity.getY();
                    double d2 = livingEntity.getZ() + (double) Mth.randomBetween(serverLevel.random, -0.7F, 0.7F);

                    BlockState blockstate = livingEntity.getBlockStateOn();
                    serverLevel.sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, blockstate), d0, d1, d2, 25, 0, 0, 0, 0);
                } else {
                    serverLevel.sendParticles(ParticleTypes.CRIMSON_SPORE, livingEntity.getX(), livingEntity.getEyeY() - livingEntity.getScale() * 0.75, livingEntity.getZ(), 10, 0, 0, 0, 0);
                }

                List<LivingEntity> nearbyEnemies = serverLevel.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(1.5), entity ->
                        (entity instanceof Player && entity != player)
                                || (entity instanceof Mob));
                for (LivingEntity enemy : nearbyEnemies) {
                    if (!enemy.isPassengerOfSameVehicle(player) && !enemy.isVehicle() && !enemy.isAlliedTo(player) && !(enemy instanceof baseBikeEntity)) {
                        double subX = enemy.getX() - player.getX();
                        double subY = enemy.getY() - player.getY();
                        double subZ = enemy.getZ() - player.getZ();
                        float r = Mth.sqrt((float) (Mth.square(subX) + Mth.square(subY) + Mth.square(subZ))) * 8;
                        enemy.push(subX / r, subY / r, subZ / r);
                        enemy.hurt(player.damageSources().playerAttack(player), 2.0F);
                    }
                }
            }
        }
        return true;
    }

    public static class DrillEffect extends InstantenousMobEffect {


        public DrillEffect(MobEffectCategory mobEffectCategory, int color) {
            super(mobEffectCategory, color);
        }

        @Override
        public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
            if (livingEntity.level() instanceof ServerLevel && livingEntity.isShiftKeyDown()) {
                BlockPos pos = new BlockPos(livingEntity.getBlockX(), livingEntity.getBlockY() - 1, livingEntity.getBlockZ());
                if (livingEntity.level().getBlockState(pos) == Blocks.STONE.defaultBlockState()
                        || livingEntity.level().getBlockState(pos) == Blocks.NETHERRACK.defaultBlockState())
                    livingEntity.level().destroyBlock(pos, true);
            }
            return true;
        }
    }

    public static class NoteEffect extends InstantenousMobEffect {


        public NoteEffect(MobEffectCategory mobEffectCategory, int color) {
            super(mobEffectCategory, color);
        }


        @Override
        public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
            Random rand = new Random();
            livingEntity.level().playLocalSound(livingEntity, ModSounds.MASKED_RIDER.get(), SoundSource.RECORDS, 1, rand.nextInt(10));

            if (livingEntity.level() instanceof ServerLevel serverLevel) {
                serverLevel.sendParticles(ParticleTypes.NOTE, livingEntity.getX() + rand.nextFloat(.3F), livingEntity.getEyeY(), livingEntity.getZ() + rand.nextFloat(.4F), 1, 0, 0, 0, 0.1);
                serverLevel.sendParticles(ParticleTypes.NOTE, livingEntity.getX() + rand.nextFloat(.5F), livingEntity.getEyeY(), livingEntity.getZ() - rand.nextFloat(.8F), 1, 0, 0, 0, 0.1);
                serverLevel.sendParticles(ParticleTypes.NOTE, livingEntity.getX() - rand.nextFloat(.7F), livingEntity.getEyeY(), livingEntity.getZ() + rand.nextFloat(.9F), 1, 0, 0, 0, 0.1);
            }
            return true;
        }
    }

    public static class WonderEffect extends InstantenousMobEffect {


        public WonderEffect(MobEffectCategory mobEffectCategory, int color) {
            super(mobEffectCategory, color);
        }


        @Override
        public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
            if (!livingEntity.level().isClientSide() && livingEntity instanceof Player player) {
                ItemStack stack = livingEntity.getItemBySlot(EquipmentSlot.FEET);
                if (stack.getItem() instanceof RiderDriverItem && stack.has(DataComponents.CUSTOM_DATA)) {
                    CompoundTag tag = stack.get(DataComponents.CUSTOM_DATA).getUnsafe();
                    if (tag.getDouble("use_ability") != 0 & amplifier != 2) {
                        int small = 0;
                        int big = 0;
                        if (player.hasEffect(EffectCore.SMALL))
                            small = player.getEffect(EffectCore.SMALL).getAmplifier();
                        if (player.hasEffect(EffectCore.BIG))
                            big = player.getEffect(EffectCore.BIG).getAmplifier();
                        if (player.isShiftKeyDown()) {
                            big = big - 1;
                            small = small + 1;
                        } else {
                            big = big + 1;
                            small = small - 1;
                        }
                        player.removeEffect(EffectCore.SMALL);
                        player.removeEffect(EffectCore.BIG);

                        if (big > -1)
                            player.addEffect(new MobEffectInstance(EffectCore.BIG, 120, big, false, false));
                        if (small > -1)
                            player.addEffect(new MobEffectInstance(EffectCore.SMALL, 120, small, false, false));
                        player.addEffect(new MobEffectInstance(EffectCore.WONDER, 10, 2, false, false));
                    }
                }
            }
            return true;
        }
    }
}


