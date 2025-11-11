package com.kelco.kamenridercraft.entities.footSoldiers;

import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.item.Reboot_Rider_Items;
import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BattaAugmentEntity extends BaseHenchmenEntity {

    public BattaAugmentEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
		super(type, level);
		NAME="batta_augment";
	    this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Reboot_Rider_Items.SHIN_ICHIGO_HELMET.get()));
	    this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Reboot_Rider_Items.SHIN_ICHIGO_CHESTPLATE.get()));
	    this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Reboot_Rider_Items.SHIN_ICHIGO_LEGGINGS.get()));
	    this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Reboot_Rider_Items.SIMPLIFIED_TYPHOON.get()));
    }


 public void remove(RemovalReason p_149847_) {

     if ( this.isDeadOrDying()) {
         if (this.random.nextDouble() * 100.0 <= this.level().getGameRules().getInt(ModGameRules.RULE_BOSS_SPAWN_PERCENTAGE)) {

             BaseHenchmenEntity boss = MobsCore.SHIN_NO_0.get().create(this.level());
             if (boss != null && this.getLastAttacker()instanceof Player playerIn && this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUCEMENTS)) {
                 playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.shin_no_0"));
             }

             if (boss != null) {
                 boss.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                 this.level().addFreshEntity(boss);
             }
         }
     }
     super.remove(p_149847_);
 }

	public static AttributeSupplier.Builder setAttributes() {

		return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 135.0D)
                .add(Attributes.MOVEMENT_SPEED,0.3F)
                .add(Attributes.ATTACK_DAMAGE, 7.0D)
                .add(Attributes.ARMOR, 3.0D)
                .add(Attributes.MAX_HEALTH, 45.0D);
	}

}