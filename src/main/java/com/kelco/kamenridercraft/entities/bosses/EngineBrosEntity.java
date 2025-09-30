package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Build_Rider_Items;
import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.network.chat.Component;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;

public class EngineBrosEntity extends BaseHenchmenEntity {

		public EngineBrosEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="hell_bros_engine";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Build_Rider_Items.BUILD_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Build_Rider_Items.BUILD_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Build_Rider_Items.BUILD_LEGGINGS.get()));
		this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Build_Rider_Items.NEBULASTEAM_GUN.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Build_Rider_Items.NEBULA_STEAM_GUN_HELL_BROS.get()));
            RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Build_Rider_Items.GEAR_ENGINE.get(), 1);
    }
    @Override
    public void actuallyHurt(DamageSource source, float amount) {
        super.actuallyHurt(source, amount);
        if(!this.level().isClientSide() && source.getEntity() instanceof Player playerIn) {
            if (playerIn.getInventory().countItem(Build_Rider_Items.GEAR_REMOCON.get())!=0 && RiderDriverItem.get_Form_Item(this.getItemBySlot(EquipmentSlot.FEET),1)!=Build_Rider_Items.GEAR_HELL_BROS.get()) {
                if (this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUCEMENTS)) playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.hell_bros2"));
                this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.4);
                this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(12.0D);
                this.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(128.0D);
                RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Build_Rider_Items.GEAR_HELL_BROS.get(), 1);
            }
        }
    }
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData) {

        BaseHenchmenEntity boss = MobsCore.REMOCON_BROS.get().create(this.level());
        if (boss != null) {
            boss.moveTo(this.getX(), this.getY(), this.getZ()-1, this.getYRot(), 0.0F);
            this.level().addFreshEntity(boss);
        }
        spawnGroupData =  super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
        return spawnGroupData;
    }

	public static AttributeSupplier.Builder setAttributes() {
		return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 128.0D)
        		.add(Attributes.MOVEMENT_SPEED,(double)0.30F)
        		.add(Attributes.ATTACK_DAMAGE, 5.0D)
        		.add(Attributes.MAX_HEALTH, 60.0D);
     }
    

}