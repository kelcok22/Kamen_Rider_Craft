package com.kelco.kamenridercraft.effects.beneficial;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.util.DimensionUtil;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.server.ServerLifecycleHooks;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

import static com.kelco.kamenridercraft.util.DimensionUtil.teleportToDreamDimension;

public class SleepEffect extends InstantenousMobEffect {

    public SleepEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (livingEntity instanceof ServerPlayer rider) {
            if (rider.level().dimension() == Level.OVERWORLD && (!rider.hasEffect(EffectCore.INSOMNIA) && !rider.isCreative() || rider.isCreative()) &&
                    rider.getItemBySlot(EquipmentSlot.FEET).is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "gear/can_dream")))) {
                rider.stopSleeping();
                Level level = rider.level();
                ResourceKey<Level> dreamDimension = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("kamenridercraft:dream"));

                MinecraftServer Server = rider.getServer();
                List<TamableAnimal> nearbyAllies = level.getEntitiesOfClass(TamableAnimal.class, rider.getBoundingBox().inflate(30), entity ->
                        (entity.getOwner() == rider && !entity.isOrderedToSit() && !entity.isSleeping()));
                if (level.dimension() == dreamDimension) {
                    teleportToDreamDimension(Server.overworld(), rider);
                    for (LivingEntity ally : nearbyAllies)
                        ally.teleportTo(Server.overworld(), rider.getX(), rider.getY() + 1, rider.getZ(), new HashSet<>(), 0, 0);
                } else {
                    teleportToDreamDimension(Server.getLevel(dreamDimension), rider);
                    for (LivingEntity ally : nearbyAllies)
                        ally.teleportTo(Objects.requireNonNull(Server.getLevel(dreamDimension)), rider.getX(), rider.getY() + 1, rider.getZ(), new HashSet<>(), 0, 0);
                }
            } else {
                ServerLifecycleHooks.getCurrentServer().getLevel(Level.OVERWORLD).setDayTime(0);
            }
        }
        return false;
    }
}