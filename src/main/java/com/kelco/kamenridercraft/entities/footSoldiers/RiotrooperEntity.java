package com.kelco.kamenridercraft.entities.footSoldiers;

import com.kelco.kamenridercraft.ServerConfig;
import com.kelco.kamenridercraft.block.Rider_Blocks;
import com.kelco.kamenridercraft.KamenRiderCraftCore;

import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.item.Faiz_Rider_Items;
import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class RiotrooperEntity extends BaseHenchmenEntity{
	
	private BaseHenchmenEntity boss;
	
    public RiotrooperEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="riotrooper";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Faiz_Rider_Items.FAIZHELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Faiz_Rider_Items.FAIZCHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Faiz_Rider_Items.FAIZLEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Faiz_Rider_Items.SMARTBUCKLE.get()));
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Faiz_Rider_Items.AXEL_RAY_GUN.get()));
		this.setMeleeOnSpawn(40.0D);
    }


	public void remove(RemovalReason p_149847_) {

		if ( this.isDeadOrDying()) {
			if (this.level() instanceof ServerLevel serverlevel) {
				BlockParticleOption sand = new BlockParticleOption(ParticleTypes.BLOCK, Rider_Blocks.IMAGIN_SAND_BLOCK.get().defaultBlockState());
				serverlevel.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, this.getX(), this.getY(), this.getZ(), 20, 0, 0, 0, 0.05);
				serverlevel.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, this.getX(), this.getY()+1, this.getZ(), 20, 0, 0, 0, 0.05);
				serverlevel.sendParticles(sand, this.getX(), this.getY(), this.getZ(), 30, 0, 0, 0, 0.05);
				serverlevel.sendParticles(sand, this.getX(), this.getY()+1, this.getZ(), 30, 0, 0, 0, 0.05);
			}
			if (this.random.nextDouble() * 100.0 <= ServerConfig.bossSpawnRate) {
				int bossChoice = this.random.nextInt(2);
				switch (bossChoice) {
					case 0:
						boss = MobsCore.ORGA.get().create(this.level());
						if (boss != null && this.getLastAttacker() instanceof Player playerIn){
							playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.horse_orphnoch"));
						}
						break;
					case 1:
						boss = MobsCore.MUEZ.get().create(this.level());
						if (boss != null && this.getLastAttacker()instanceof Player playerIn) {
							playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.muez"));
						}
						break;
					default:
				}
				if (boss != null) {
					boss.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
					this.level().addFreshEntity(boss);
				}
			}
		}
		super.remove(p_149847_);
	}

}