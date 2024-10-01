package com.kelco.kamenridercraft.entities.footSoldiers;

import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.item.Revice_Rider_Items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class GiffJuniorEntity extends BaseHenchmenEntity {
	
    public GiffJuniorEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="giff_junior";

		this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Revice_Rider_Items.GIFF_JUNIOR_SWORD.get()));
    }


    public void remove(Entity.RemovalReason p_149847_) {

		if ( this.isDeadOrDying()) {
			
			if (this.random.nextInt(10) == 1) {
				BaseHenchmenEntity boss = MobsCore.EVIL.get().create(this.level());
				if (boss != null) {
					boss.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
					this.level().addFreshEntity(boss);
					if (this.getLastAttacker()instanceof Player playerIn) {
						playerIn.sendSystemMessage(Component.translatable("Versus Up!\nMadness! Hopeless! Darkness! Bat! Hehe! Kamen Rider Evil! Yeah-haha!").withStyle(ChatFormatting.AQUA));
					}
				}
			} else if (this.random.nextInt(9) == 1) {
				BaseHenchmenEntity boss = MobsCore.DAIOUIKA_DEADMAN.get().create(this.level());
				if (boss != null) {
					boss.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
					this.level().addFreshEntity(boss);
					if (this.getLastAttacker()instanceof Player playerIn) {
						playerIn.sendSystemMessage(Component.translatable("Daiouika!").withStyle(ChatFormatting.LIGHT_PURPLE));
					}
				}
			}
		}
		super.remove(p_149847_);
	}
    
    public static AttributeSupplier.Builder setAttributes() {
    
        return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 35.0D)
        		.add(Attributes.MOVEMENT_SPEED,(double)0.23F)
        		.add(Attributes.ATTACK_DAMAGE, 4.0D)
        		.add(Attributes.ARMOR, 3.0D)
        		.add(Attributes.MAX_HEALTH, 30.0D)
        		.add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
     }
}