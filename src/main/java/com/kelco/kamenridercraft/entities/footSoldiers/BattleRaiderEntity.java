package com.kelco.kamenridercraft.entities.footSoldiers;

import java.util.Random;

import javax.annotation.Nullable;

import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.Zero_One_Rider_Items;
import com.kelco.kamenridercraft.item.Ichigo_Rider_Items;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

public class BattleRaiderEntity extends BaseHenchmenEntity {
	

	
    public BattleRaiderEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="raider_horseshoe_crab";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Zero_One_Rider_Items.ZERO_ONE_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Zero_One_Rider_Items.ZERO_ONE_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Zero_One_Rider_Items.ZERO_ONE_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Zero_One_Rider_Items.RAIDRISER_BATTLE.get()));
    }


    public void remove(Entity.RemovalReason p_149847_) {

		if ( this.isDeadOrDying()) {
			int bossChance = this.random.nextInt(50);
			switch (bossChance) {
				case 0:
					BaseHenchmenEntity boss = MobsCore.RAIDER.get().create(this.level());
					if (boss != null) {
						boss.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
						this.level().addFreshEntity(boss);
						if (this.getLastAttacker()instanceof Player playerIn) {
							playerIn.sendSystemMessage(Component.translatable("Raidrise!").withStyle(ChatFormatting.DARK_RED));
						}
					}
					break;
				case 1:
					BaseHenchmenEntity boss2 = MobsCore.NAKI.get().create(this.level());
					if (boss2 != null) {
						boss2.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
						this.level().addFreshEntity(boss2);
						if (this.getLastAttacker()instanceof Player playerIn) {
							playerIn.sendSystemMessage(Component.translatable("Forcerise! Japanese Wolf! Break down.").withStyle(ChatFormatting.WHITE));
						}
					}
					break;
				case 2:
					BaseHenchmenEntity boss3 = MobsCore.ZAIA.get().create(this.level());
					if (boss3 != null) {
						boss3.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
						this.level().addFreshEntity(boss3);
						if (this.getLastAttacker()instanceof Player playerIn) {
							playerIn.sendSystemMessage(Component.translatable("Perfectrise! When the five weapons cross, the jet-black soldier ZAIA is born!").withStyle(ChatFormatting.RED));
							playerIn.sendSystemMessage(Component.translatable("I AM THE PRESIDENT!").withStyle(ChatFormatting.RED));
						}
					}
					break;
				case 3:
					BaseHenchmenEntity boss4 = MobsCore.DIRE_WOLF_SOLD_MAGIA.get().create(this.level());
					if (boss4 != null) {
						boss4.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
						this.level().addFreshEntity(boss4);
						if (this.getLastAttacker()instanceof Player playerIn) {
							playerIn.sendSystemMessage(Component.translatable("Dire Wolf!").withStyle(ChatFormatting.BLUE));
						}
					}
					break;
				case 4:
					BaseHenchmenEntity boss5 = MobsCore.SERVAL_TIGER_SOLD_MAGIA.get().create(this.level());
					if (boss5 != null) {
						boss5.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
						this.level().addFreshEntity(boss5);
						if (this.getLastAttacker()instanceof Player playerIn) {
							playerIn.sendSystemMessage(Component.translatable("Serval Tiger!").withStyle(ChatFormatting.GOLD));
						}
					}
					break;
				default:
			}
		}
		super.remove(p_149847_);
	}
    
    public static AttributeSupplier.Builder setAttributes() {
    
        return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 35.0D)
        		.add(Attributes.MOVEMENT_SPEED,(double)0.23F)
        		.add(Attributes.ATTACK_DAMAGE, 8.0D)
        		.add(Attributes.ARMOR, 3.0D)
        		.add(Attributes.MAX_HEALTH, 30.0D)
        		.add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
     }
    

}