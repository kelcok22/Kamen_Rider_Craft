package com.kelco.kamenridercraft.item.ooo;

import java.util.List;
import java.util.Objects;

import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.summons.RiderSummonEntity;
import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.OOO_Rider_Items;

import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ColorParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.OwnableEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class oScannerItem extends BaseItem {

	public oScannerItem(Properties prop) {
		super(prop);
	}

	public void inventoryTick(ItemStack p_41404_, Level p_41405_, Entity p_41406_, int p_41407_, boolean p_41408_) {

		if (p_41406_ instanceof Player player){
			if (player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem belt
			&& belt == OOO_Rider_Items.OOODRIVER.get() && belt.isTransformed(player)){
				ItemStack Belt = player.getItemBySlot(EquipmentSlot.FEET);

				if (Objects.equals(RiderDriverItem.get_Form_Item(Belt, 1).getFormName(false), "_taka") &
                        Objects.equals(RiderDriverItem.get_Form_Item(Belt, 2).getFormName(false), "_kujaku") &
                        Objects.equals(RiderDriverItem.get_Form_Item(Belt, 3).getFormName(false), "_condor")) {
					player.addEffect(new MobEffectInstance(Effect_core.GLIDE,40,0,true,false));

				} else  if (Objects.equals(RiderDriverItem.get_Form_Item(Belt, 1).getFormName(false), "_lion") &
                        Objects.equals(RiderDriverItem.get_Form_Item(Belt, 2).getFormName(false), "_tora") &
                        Objects.equals(RiderDriverItem.get_Form_Item(Belt, 3).getFormName(false), "_cheetah")) {
					player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,40,6,true,false));	

				} else  if (Objects.equals(RiderDriverItem.get_Form_Item(Belt, 1).getFormName(false), "_kuwagata") &
                        Objects.equals(RiderDriverItem.get_Form_Item(Belt, 2).getFormName(false), "_kamakiri") &
                        Objects.equals(RiderDriverItem.get_Form_Item(Belt, 3).getFormName(false), "_batta")) {
					player.addEffect(new MobEffectInstance(MobEffects.JUMP,40,6,true,false));	

				}  else  if (Objects.equals(RiderDriverItem.get_Form_Item(Belt, 1).getFormName(false), "_sai") &
                        Objects.equals(RiderDriverItem.get_Form_Item(Belt, 2).getFormName(false), "_gorilla") &
                        Objects.equals(RiderDriverItem.get_Form_Item(Belt, 3).getFormName(false), "_zou")) {
					player.addEffect(new MobEffectInstance(Effect_core.PUNCH,40,5,true,false));

				}  else  if (Objects.equals(RiderDriverItem.get_Form_Item(Belt, 1).getFormName(false), "_shachi") &
                        Objects.equals(RiderDriverItem.get_Form_Item(Belt, 2).getFormName(false), "_unagi") &
                        Objects.equals(RiderDriverItem.get_Form_Item(Belt, 3).getFormName(false), "_tako")) {
					player.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE,40,0,true,false));	

				}  else  if (Objects.equals(RiderDriverItem.get_Form_Item(Belt, 1).getFormName(false), "_ptera") &
                        Objects.equals(RiderDriverItem.get_Form_Item(Belt, 2).getFormName(false), "_tricera") &
                        Objects.equals(RiderDriverItem.get_Form_Item(Belt, 3).getFormName(false), "_tyranno")) {
					player.addEffect(new MobEffectInstance(Effect_core.FLYING,400,0,true,false));

				} else if (Objects.equals(RiderDriverItem.get_Form_Item(Belt, 1).getFormName(false), "_taka_eternity") &
                        Objects.equals(RiderDriverItem.get_Form_Item(Belt, 2).getFormName(false), "_kujaku_eternity") &
                        Objects.equals(RiderDriverItem.get_Form_Item(Belt, 3).getFormName(false), "_condor_eternity")) {
					player.addEffect(new MobEffectInstance(Effect_core.FLYING,400,0,true,false));
				}
			}
		}
	}

	public boolean inventoryOrHolderContains(Player player, Item item) {
		NonNullList<ItemStack> inv = NonNullList.create();
		inv.addAll(player.getInventory().items);
		inv.addAll(player.getInventory().armor);
		inv.add(player.getInventory().offhand.getFirst());

		if (player.getInventory().countItem(item)!=0) return true;
		else for (ItemStack itemStack : inv) {
            if (itemStack.has(DataComponents.CONTAINER)) {
                for (ItemStack stack : itemStack.getComponents().get(DataComponents.CONTAINER).nonEmptyItems())
                    if (stack.getItem() == item) return true;
            } else if (itemStack.has(DataComponents.BUNDLE_CONTENTS))
                for (ItemStack stack : itemStack.getComponents().get(DataComponents.BUNDLE_CONTENTS).items())
                    if (stack.getItem() == item) return true;
        }
		return false;
	}

	public InteractionResultHolder<ItemStack> use(Level p_41128_, Player p_41129_, InteractionHand p_41130_) {
		ItemStack itemstack = p_41129_.getItemInHand(p_41130_);
		
		if (p_41129_.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem belt
		&& belt == OOO_Rider_Items.OOODRIVER.get() && belt.isTransformed(p_41129_)){
			ItemStack Belt = p_41129_.getItemBySlot(EquipmentSlot.FEET);
			
			if (RiderDriverItem.get_Form_Item(Belt, 1) == OOO_Rider_Items.KUWAGATA_MEDAL.get() &&
                    RiderDriverItem.get_Form_Item(Belt, 2) == OOO_Rider_Items.KAMAKIRI_MEDAL.get() &&
                    RiderDriverItem.get_Form_Item(Belt, 3) == OOO_Rider_Items.BATTA_MEDAL.get()) {
				if (!p_41129_.isShiftKeyDown()) {
					RiderSummonEntity summon = MobsCore.RIDER_SUMMON.get().create(p_41128_);
					if (summon != null) {
						summon.moveTo(p_41129_.getX(), p_41129_.getY()+1, p_41129_.getZ(), p_41129_.getYRot(), p_41129_.getXRot());
						summon.setItemSlot(EquipmentSlot.HEAD, new ItemStack(OOO_Rider_Items.OOOHELMET.get()));
						summon.setItemSlot(EquipmentSlot.CHEST, new ItemStack(OOO_Rider_Items.OOOCHESTPLATE.get()));
						summon.setItemSlot(EquipmentSlot.LEGS, new ItemStack(OOO_Rider_Items.OOOLEGGINGS.get()));
						summon.setItemSlot(EquipmentSlot.FEET, new ItemStack(OOO_Rider_Items.OOODRIVER.get()));
						RiderDriverItem.set_Form_Item(summon.getItemBySlot(EquipmentSlot.FEET), OOO_Rider_Items.KUWAGATA_MEDAL.get(), 1);
						RiderDriverItem.set_Form_Item(summon.getItemBySlot(EquipmentSlot.FEET), OOO_Rider_Items.KAMAKIRI_MEDAL.get(), 2);

						p_41128_.addFreshEntity(summon);
						summon.bindToPlayer(p_41129_);
						summon.setRequiredForms(p_41129_);
						summon.mustMatchAllForms(true);
						if (!p_41129_.isCreative()) p_41129_.getCooldowns().addCooldown(this, 200);
						p_41129_.awardStat(Stats.ITEM_USED.get(this));
					}
				} else if (inventoryOrHolderContains(p_41129_, OOO_Rider_Items.TAKA_MEDAL.get())
				&&inventoryOrHolderContains(p_41129_, OOO_Rider_Items.KUJAKU_MEDAL.get())
				&&inventoryOrHolderContains(p_41129_, OOO_Rider_Items.CONDOR_MEDAL.get())
				&&inventoryOrHolderContains(p_41129_, OOO_Rider_Items.LION_MEDAL.get())
				&&inventoryOrHolderContains(p_41129_, OOO_Rider_Items.TORA_MEDAL.get())
				&&inventoryOrHolderContains(p_41129_, OOO_Rider_Items.CHEETAH_MEDAL.get())
				&&inventoryOrHolderContains(p_41129_, OOO_Rider_Items.SAI_MEDAL.get())
				&&inventoryOrHolderContains(p_41129_, OOO_Rider_Items.GORILLA_MEDAL.get())
				&&inventoryOrHolderContains(p_41129_, OOO_Rider_Items.ZOU_MEDAL.get())
				&&inventoryOrHolderContains(p_41129_, OOO_Rider_Items.SHACHI_MEDAL.get())
				&&inventoryOrHolderContains(p_41129_, OOO_Rider_Items.UNAGI_MEDAL.get())
				&&inventoryOrHolderContains(p_41129_, OOO_Rider_Items.TAKO_MEDAL.get())
				&&inventoryOrHolderContains(p_41129_, OOO_Rider_Items.PTERA_MEDAL.get())
				&&inventoryOrHolderContains(p_41129_, OOO_Rider_Items.TRICERA_MEDAL.get())
				&&inventoryOrHolderContains(p_41129_, OOO_Rider_Items.TYRANNO_MEDAL.get())
				&&inventoryOrHolderContains(p_41129_, OOO_Rider_Items.COBRA_MEDAL.get())
				&&inventoryOrHolderContains(p_41129_, OOO_Rider_Items.KAME_MEDAL.get())
				&&inventoryOrHolderContains(p_41129_, OOO_Rider_Items.WANI_MEDAL.get())) {
					List<RiderSummonEntity> clones = p_41128_.getEntitiesOfClass(RiderSummonEntity.class, p_41129_.getBoundingBox().inflate(10), entity ->
						(entity.getOwner() == p_41129_ && RiderDriverItem.get_Form_Item(entity.getItemBySlot(EquipmentSlot.FEET), 1) == OOO_Rider_Items.KUWAGATA_MEDAL.get()));
					if (clones.size() >= 7) {
						RiderDriverItem.set_Form_Item(clones.getFirst().getItemBySlot(EquipmentSlot.FEET), OOO_Rider_Items.TAKA_MEDAL.get(), 1);
						RiderDriverItem.set_Form_Item(clones.get(0).getItemBySlot(EquipmentSlot.FEET), OOO_Rider_Items.KUJAKU_MEDAL.get(), 2);
						RiderDriverItem.set_Form_Item(clones.get(0).getItemBySlot(EquipmentSlot.FEET), OOO_Rider_Items.CONDOR_MEDAL.get(), 3);
						RiderDriverItem.set_Form_Item(clones.get(1).getItemBySlot(EquipmentSlot.FEET), OOO_Rider_Items.LION_MEDAL.get(), 1);
						RiderDriverItem.set_Form_Item(clones.get(1).getItemBySlot(EquipmentSlot.FEET), OOO_Rider_Items.TORA_MEDAL.get(), 2);
						RiderDriverItem.set_Form_Item(clones.get(1).getItemBySlot(EquipmentSlot.FEET), OOO_Rider_Items.CHEETAH_MEDAL.get(), 3);
						RiderDriverItem.set_Form_Item(clones.get(2).getItemBySlot(EquipmentSlot.FEET), OOO_Rider_Items.SAI_MEDAL.get(), 1);
						RiderDriverItem.set_Form_Item(clones.get(2).getItemBySlot(EquipmentSlot.FEET), OOO_Rider_Items.GORILLA_MEDAL.get(), 2);
						RiderDriverItem.set_Form_Item(clones.get(2).getItemBySlot(EquipmentSlot.FEET), OOO_Rider_Items.ZOU_MEDAL.get(), 3);
						RiderDriverItem.set_Form_Item(clones.get(3).getItemBySlot(EquipmentSlot.FEET), OOO_Rider_Items.SHACHI_MEDAL.get(), 1);
						RiderDriverItem.set_Form_Item(clones.get(3).getItemBySlot(EquipmentSlot.FEET), OOO_Rider_Items.UNAGI_MEDAL.get(), 2);
						RiderDriverItem.set_Form_Item(clones.get(3).getItemBySlot(EquipmentSlot.FEET), OOO_Rider_Items.TAKO_MEDAL.get(), 3);
						RiderDriverItem.set_Form_Item(clones.get(4).getItemBySlot(EquipmentSlot.FEET), OOO_Rider_Items.PTERA_MEDAL.get(), 1);
						RiderDriverItem.set_Form_Item(clones.get(4).getItemBySlot(EquipmentSlot.FEET), OOO_Rider_Items.TRICERA_MEDAL.get(), 2);
						RiderDriverItem.set_Form_Item(clones.get(4).getItemBySlot(EquipmentSlot.FEET), OOO_Rider_Items.TYRANNO_MEDAL.get(), 3);
						RiderDriverItem.set_Form_Item(clones.get(5).getItemBySlot(EquipmentSlot.FEET), OOO_Rider_Items.COBRA_MEDAL.get(), 1);
						RiderDriverItem.set_Form_Item(clones.get(5).getItemBySlot(EquipmentSlot.FEET), OOO_Rider_Items.KAME_MEDAL.get(), 2);
						RiderDriverItem.set_Form_Item(clones.get(5).getItemBySlot(EquipmentSlot.FEET), OOO_Rider_Items.WANI_MEDAL.get(), 3);
						RiderDriverItem.set_Form_Item(clones.get(6).getItemBySlot(EquipmentSlot.FEET), OOO_Rider_Items.TAKA_MEDAL.get(), 1);
						RiderDriverItem.set_Form_Item(clones.get(6).getItemBySlot(EquipmentSlot.FEET), OOO_Rider_Items.TORA_MEDAL.get(), 2);
						p_41129_.playSound(SoundEvents.PLAYER_LEVELUP, 1.0F, 1.35F);
						if (!p_41129_.isCreative()) p_41129_.getCooldowns().addCooldown(this, 200);
						p_41129_.awardStat(Stats.ITEM_USED.get(this));
					}
				}
			} else if (RiderDriverItem.get_Form_Item(Belt, 1) == OOO_Rider_Items.LION_MEDAL.get() &&
                    RiderDriverItem.get_Form_Item(Belt, 2) == OOO_Rider_Items.TORA_MEDAL.get() &&
                    RiderDriverItem.get_Form_Item(Belt, 3) == OOO_Rider_Items.CHEETAH_MEDAL.get()) {
        		Vec3 playerPos = p_41129_.getEyePosition(1.0f);
				List<LivingEntity> toIgnite = p_41128_.getEntitiesOfClass(LivingEntity.class, p_41129_.getBoundingBox().inflate(3), entity ->
																  entity != p_41129_ && !(entity instanceof OwnableEntity owned && owned.getOwner() == p_41129_));
				List<LivingEntity> toBlind = p_41128_.getEntitiesOfClass(LivingEntity.class, p_41129_.getBoundingBox().inflate(6), entity ->
																  entity != p_41129_ && !(entity instanceof OwnableEntity owned && owned.getOwner() == p_41129_));
				for (Entity target : toIgnite) {
					target.hurt(p_41129_.damageSources().playerAttack(p_41129_), 10.0F);
					target.setRemainingFireTicks(200);
				}
				for (LivingEntity target : toBlind) target.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100,0,true,true));
				
				if (p_41128_ instanceof ServerLevel level) level.sendParticles(ParticleTypes.FLAME, playerPos.x, playerPos.y, playerPos.z, 100, 1.5, 1.5, 1.5, 0.01);
				p_41129_.playSound(SoundEvents.FIRECHARGE_USE, 1.0F, (p_41128_.getRandom().nextFloat() - p_41128_.getRandom().nextFloat()) * 0.2F + 1.0F);
				if (!p_41129_.isCreative()) p_41129_.getCooldowns().addCooldown(this, 200);
				p_41129_.awardStat(Stats.ITEM_USED.get(this));
			} else if (RiderDriverItem.get_Form_Item(Belt, 1) == OOO_Rider_Items.SAI_MEDAL.get() &&
                    RiderDriverItem.get_Form_Item(Belt, 2) == OOO_Rider_Items.GORILLA_MEDAL.get() &&
                    RiderDriverItem.get_Form_Item(Belt, 3) == OOO_Rider_Items.ZOU_MEDAL.get()) {
        		Vec3 playerPos = p_41129_.getEyePosition(1.0f);
				List<LivingEntity> nearbyTargets = p_41128_.getEntitiesOfClass(LivingEntity.class, p_41129_.getBoundingBox().inflate(5), entity ->
																  entity != p_41129_ && !(entity instanceof OwnableEntity owned && owned.getOwner() == p_41129_));
				for (LivingEntity target : nearbyTargets) {
					target.hurt(p_41129_.damageSources().playerAttack(p_41129_), 10.0F);
					target.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 40,0,true,false));
				}

				if (p_41128_ instanceof ServerLevel level) level.sendParticles(ParticleTypes.GUST_EMITTER_LARGE, playerPos.x, playerPos.y, playerPos.z, 2, 1.5, 0.5, 1.5, 0.01);
				if (!p_41129_.isCreative()) p_41129_.getCooldowns().addCooldown(this, 200);
				p_41129_.awardStat(Stats.ITEM_USED.get(this));
			} else if (RiderDriverItem.get_Form_Item(Belt, 1) == OOO_Rider_Items.SHACHI_MEDAL.get() &&
                    RiderDriverItem.get_Form_Item(Belt, 2) == OOO_Rider_Items.UNAGI_MEDAL.get() &&
                    RiderDriverItem.get_Form_Item(Belt, 3) == OOO_Rider_Items.TAKO_MEDAL.get()) {
        		Vec3 playerPos = p_41129_.getEyePosition(1.0f);
				List<LivingEntity> nearbyTargets = p_41128_.getEntitiesOfClass(LivingEntity.class, p_41129_.getBoundingBox().inflate(5), entity ->
																  entity != p_41129_ && !(entity instanceof OwnableEntity owned && owned.getOwner() == p_41129_));
				for (LivingEntity target : nearbyTargets) {
					target.hurt(p_41129_.damageSources().playerAttack(p_41129_), 10.0F);
					target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100,9,true,true));
				}

				if (p_41128_ instanceof ServerLevel level) level.sendParticles(ParticleTypes.ELECTRIC_SPARK, playerPos.x, playerPos.y, playerPos.z, 200, 1.5, 1.5, 1.5, 0.01);
				if (!p_41129_.isCreative()) p_41129_.getCooldowns().addCooldown(this, 200);
				p_41129_.awardStat(Stats.ITEM_USED.get(this));
			} else if (RiderDriverItem.get_Form_Item(Belt, 1) == OOO_Rider_Items.TAKA_MEDAL.get() &&
                    RiderDriverItem.get_Form_Item(Belt, 2) == OOO_Rider_Items.KUJAKU_MEDAL.get() &&
                    RiderDriverItem.get_Form_Item(Belt, 3) == OOO_Rider_Items.CONDOR_MEDAL.get()) {

				LargeFireball largefireball = new LargeFireball(p_41129_.level(), p_41129_, p_41129_.getLookAngle().normalize(), 1);
				largefireball.setPos(largefireball.getX(), p_41129_.getY(0.5) + 0.5, largefireball.getZ());
				p_41129_.level().addFreshEntity(largefireball);

				if (!p_41129_.isCreative()) p_41129_.getCooldowns().addCooldown(this, 200);
				p_41129_.awardStat(Stats.ITEM_USED.get(this));
			} else if (RiderDriverItem.get_Form_Item(Belt, 1) == OOO_Rider_Items.PTERA_MEDAL.get() &&
                    RiderDriverItem.get_Form_Item(Belt, 2) == OOO_Rider_Items.TRICERA_MEDAL.get() &&
                    RiderDriverItem.get_Form_Item(Belt, 3) == OOO_Rider_Items.TYRANNO_MEDAL.get()) {
        		Vec3 playerPos = p_41129_.getEyePosition(1.0f);
				List<LivingEntity> nearbyTargets = p_41128_.getEntitiesOfClass(LivingEntity.class, p_41129_.getBoundingBox().inflate(5), entity ->
																  entity != p_41129_ && !(entity instanceof OwnableEntity owned && owned.getOwner() == p_41129_));
				for (LivingEntity target : nearbyTargets) {
					target.hurt(p_41129_.damageSources().playerAttack(p_41129_), 10.0F);
					target.setTicksFrozen(340);
					target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100,3,true,false));
				}
				p_41129_.addEffect(new MobEffectInstance(Effect_core.BLIZZARD, 10, 0, true,false));
				if (p_41128_ instanceof ServerLevel level) level.sendParticles(ParticleTypes.SNOWFLAKE, playerPos.x, playerPos.y, playerPos.z, 50, 1.5, 0.5, 1.5, 0.01);
				if (!p_41129_.isCreative()) p_41129_.getCooldowns().addCooldown(this, 200);
				p_41129_.awardStat(Stats.ITEM_USED.get(this));
			} else if (RiderDriverItem.get_Form_Item(Belt, 1) == OOO_Rider_Items.COBRA_MEDAL.get() &&
                    RiderDriverItem.get_Form_Item(Belt, 2) == OOO_Rider_Items.KAME_MEDAL.get() &&
                    RiderDriverItem.get_Form_Item(Belt, 3) == OOO_Rider_Items.WANI_MEDAL.get()) {
        		Vec3 playerPos = p_41129_.getEyePosition(1.0f);

				p_41129_.removeEffect(MobEffects.POISON);
				p_41129_.removeEffect(MobEffects.WITHER);
				if (p_41128_ instanceof ServerLevel level) level.sendParticles(ColorParticleOption.create(ParticleTypes.ENTITY_EFFECT, 1.0F, 0.8F, 0.5F), playerPos.x, playerPos.y, playerPos.z, 25, 0.5, 0.5, 0.5, 0.01);
				if (!p_41129_.isCreative()) p_41129_.getCooldowns().addCooldown(this, 200);
				p_41129_.awardStat(Stats.ITEM_USED.get(this));
			} else if (RiderDriverItem.get_Form_Item(Belt, 1) == OOO_Rider_Items.SUPER_TAKA_MEDAL.get() &&
                    RiderDriverItem.get_Form_Item(Belt, 2) == OOO_Rider_Items.SUPER_TORA_MEDAL.get() &&
                    RiderDriverItem.get_Form_Item(Belt, 3) == OOO_Rider_Items.SUPER_BATTA_MEDAL.get()) {
        		Vec3 playerPos = p_41129_.getEyePosition(1.0f);

				p_41129_.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
				p_41129_.removeEffect(MobEffects.DIG_SLOWDOWN);
				p_41129_.removeEffect(Effect_core.PAUSE);
				if (p_41128_ instanceof ServerLevel level) level.sendParticles(ParticleTypes.ELECTRIC_SPARK, playerPos.x, playerPos.y, playerPos.z, 25, 0.5, 0.5, 0.5, 0.01);
				if (!p_41129_.isCreative()) p_41129_.getCooldowns().addCooldown(this, 200);
				p_41129_.awardStat(Stats.ITEM_USED.get(this));
			} else if (RiderDriverItem.get_Form_Item(Belt, 1) == OOO_Rider_Items.TAKA_ETERNITY_MEDAL.get() &&
                    RiderDriverItem.get_Form_Item(Belt, 2) == OOO_Rider_Items.KUJAKU_ETERNITY_MEDAL.get() &&
                    RiderDriverItem.get_Form_Item(Belt, 3) == OOO_Rider_Items.CONDOR_ETERNITY_MEDAL.get()) {

				LargeFireball largefireball = new LargeFireball(p_41129_.level(), p_41129_, p_41129_.getLookAngle().normalize(), 3);
				largefireball.setPos(largefireball.getX(), p_41129_.getY(0.5) + 0.5, largefireball.getZ());
				p_41129_.level().addFreshEntity(largefireball);

				if (!p_41129_.isCreative()) p_41129_.getCooldowns().addCooldown(this, 200);
				p_41129_.awardStat(Stats.ITEM_USED.get(this));
			} 
		}
		return InteractionResultHolder.sidedSuccess(itemstack, p_41128_.isClientSide());
	}
}

