package com.kelco.kamenridercraft.item.gavv;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.Gavv_Rider_Items;
import com.kelco.kamenridercraft.item.BaseItems.BaseItem;

import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class HitpressItem extends BaseItem {
	public HitpressItem(Properties prop) {
		super(prop);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player playerIn, InteractionHand p_41434_) {
        ItemStack weapon = playerIn.getOffhandItem();
		if (world instanceof ServerLevel level && playerIn.getMainHandItem().getItem() == this
        && weapon.is(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "arsenal/can_free_hitpress")))) {
            EntityType.VILLAGER.spawn(level, playerIn.blockPosition(), MobSpawnType.SPAWN_EGG);
			world.playSound(null, playerIn.getOnPos().above(), this.getBreakingSound(), SoundSource.PLAYERS, 1.0F, 1.0F);
			level.sendParticles(new ItemParticleOption(ParticleTypes.ITEM, new ItemStack(Gavv_Rider_Items.HEATPRESS.get())), playerIn.getX(), playerIn.getY()+1, playerIn.getZ(), 10, 0.0, 0.0, 0.0, 0.1);
            playerIn.getMainHandItem().shrink(1);
			playerIn.getOffhandItem().hurtAndBreak(1, playerIn, EquipmentSlot.OFFHAND);
		}
		return super.use(world, playerIn, p_41434_);
	}
}