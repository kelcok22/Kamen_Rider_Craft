package com.kelco.kamenridercraft.entities.bikes;

import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.item.OOO_Rider_Items;
import com.kelco.kamenridercraft.item.Reboot_Rider_Items;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RidevendorVendingModeEntity extends baseBikeEntity {

	public static List<Item> CANDROID= new ArrayList<Item>();

	public RidevendorVendingModeEntity(EntityType<? extends baseBikeEntity> entityType, Level level) {
		super(entityType, level);
		NAME ="ridevendor_vending";
		NAME_MODEL ="ridevendor_vending";
		}

	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		if (!level().isClientSide()) {
		 if (player.isShiftKeyDown()){
				if (this.level() instanceof ServerLevel) {
					BlockPos pos = this.blockPosition();
					baseBikeEntity boss = MobsCore.RIDEVENDOR.get().create(this.level());
					if (boss != null) {
						boss.moveTo(pos.getX(), pos.getY(), pos.getZ(), this.getYRot(), this.getXRot());
						boss.yRotO = getYRot();
						boss.xRotO = getXRot();
						setRot(getYRot(), getXRot());
						boss.yBodyRot = this.getYRot();
						boss.yHeadRot = this.yBodyRot;
						if (boss.level() instanceof ServerLevel sl) {
							sl.sendParticles(ParticleTypes.GUST,
									boss.getX(), boss.getY() + 1.0,
									boss.getZ(), 1, 0, 0, 0, 1);
						}
						this.level().addFreshEntity(boss);
						this.remove(RemovalReason.DISCARDED);
					}
				}
			}else if (player.getItemInHand(hand).getItem()== OOO_Rider_Items.CELL_MEDAL.asItem()){
			 process(player, player.level(), hand,  getCanDrop(0));
		 }else return InteractionResult.PASS;
		}
		return InteractionResult.PASS;
	}

	public void process(Player player, Level world, InteractionHand hand, Item... items) {
		// world.playSound((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, SoundEvents.BLOCK_NOTE_BELL, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
		for(Item item : items) player.drop(new ItemStack(item), false);
		player.getItemInHand(hand).shrink(1);}

	private Item getCanDrop(int num) {
		Random generator = new Random();
		int rand = generator.nextInt(CANDROID.size());
		return CANDROID.get(rand);
	}

	public static AttributeSupplier.Builder setAttributes() {
		return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, (double)0.3F).add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.ATTACK_DAMAGE, 2.0D);
	}
}
