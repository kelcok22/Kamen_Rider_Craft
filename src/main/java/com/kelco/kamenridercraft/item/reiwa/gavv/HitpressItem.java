package com.kelco.kamenridercraft.item.reiwa.gavv;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.base_items.BaseItem;
import com.kelco.kamenridercraft.item.reiwa.GavvRiderItems;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class HitpressItem extends BaseItem {
    public HitpressItem(Properties prop) {
        super(prop);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand p_41434_) {
        ItemStack weapon = player.getOffhandItem();
        if (level instanceof ServerLevel serverLevel && player.getMainHandItem().getItem() == this
                && weapon.is(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "arsenal/can_free_hitpress")))) {
            EntityType.VILLAGER.spawn(serverLevel, player.blockPosition(), MobSpawnType.SPAWN_EGG);
            level.playSound(null, player.getOnPos().above(), this.getBreakingSound(), SoundSource.PLAYERS, 1.0F, 1.0F);
            serverLevel.sendParticles(new ItemParticleOption(ParticleTypes.ITEM, new ItemStack(GavvRiderItems.HEATPRESS.get())), player.getX(), player.getY() + 1, player.getZ(), 10, 0.0, 0.0, 0.0, 0.1);
            player.getMainHandItem().shrink(1);
            player.getOffhandItem().hurtAndBreak(1, player, EquipmentSlot.OFFHAND);
        }
        return super.use(level, player, p_41434_);
    }
}