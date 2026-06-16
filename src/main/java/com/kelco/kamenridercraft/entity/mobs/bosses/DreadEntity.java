package com.kelco.kamenridercraft.entity.mobs.bosses;

import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.reiwa.GotchardRiderItems;
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
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;

public class DreadEntity extends BaseHenchmenEntity {

		public DreadEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="dread";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(GotchardRiderItems.GOTCHARD_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(GotchardRiderItems.GOTCHARD_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(GotchardRiderItems.GOTCHARD_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(GotchardRiderItems.DREADRIVER.get()));
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(GotchardRiderItems.BLOODY_AB.get()));
    }

    @Override
    public void actuallyHurt(DamageSource source, float amount) {
        super.actuallyHurt(source, amount);
        if(!this.level().isClientSide() && source.getEntity() instanceof Player playerIn) {
            if (this.getHealth()<75 && playerIn.getInventory().countItem(GotchardRiderItems.TENLINER_RIDE_CHEMY_CARD.get().asItem())!=0 && RiderDriverItem.getFormItem(this.getItemBySlot(EquipmentSlot.FEET),1)!= GotchardRiderItems.DREAD_TYPE_THREE_CARDS.get()) {
                if (this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUCEMENTS)) playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.dread_type_three"));
                RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), GotchardRiderItems.DREAD_TYPE_THREE_CARDS.get(), 1);
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(GotchardRiderItems.BLOODY_UC.get()));
                this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(GotchardRiderItems.BLOODY_DO.get()));
            }
        }
    }

    public void remove(RemovalReason p_149847_) {

        if ( this.isDeadOrDying()) {
            if(this.getLastAttacker() instanceof Player playerIn && playerIn.getInventory().countItem(GotchardRiderItems.TENLINER_RIDE_CHEMY_CARD.get())!=0){
                ItemEntity key = new ItemEntity(playerIn.level(), playerIn.getX(), playerIn.getY(), playerIn.getZ(), new ItemStack(GotchardRiderItems.CROSSHOPPER_RIDE_CHEMY_CARD.get(), 1), 0, 0, 0);
                key.setPickUpDelay(0);
                playerIn.level().addFreshEntity(key);
                playerIn.sendSystemMessage(Component.translatable("loot.kamenridercraft.crosshopper"));
            }
        }
        super.remove(p_149847_);
    }

	public static AttributeSupplier.Builder setAttributes() {
		return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 128.0D)
        		.add(Attributes.MOVEMENT_SPEED, 0.30F)
        		.add(Attributes.ATTACK_DAMAGE, 5.0D)
        		.add(Attributes.MAX_HEALTH, 100.0D);
     }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_34297_, DifficultyInstance p_34298_, MobSpawnType p_34299_, @Nullable SpawnGroupData p_34300_) {
        p_34300_ = super.finalizeSpawn(p_34297_, p_34298_, p_34299_, p_34300_);

        if (p_34297_.getRandom().nextInt(2) == 1) {
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(GotchardRiderItems.BLOODY_BB.get()));
        }
        return p_34300_;
    }
}