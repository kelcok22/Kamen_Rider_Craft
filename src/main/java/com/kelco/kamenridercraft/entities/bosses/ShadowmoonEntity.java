package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.Ichigo_Rider_Items;
import com.kelco.kamenridercraft.item.Modded_item_core;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.time.LocalDate;
import java.util.Random;

public class ShadowmoonEntity extends BaseHenchmenEntity {
	
	public static final Item[] belt = new Item[] {Ichigo_Rider_Items.SHADOW_CHARGER.get()};

	
    public ShadowmoonEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="shadow_moon";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Ichigo_Rider_Items.BLACKHELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Ichigo_Rider_Items.BLACKCHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Ichigo_Rider_Items.BLACKLEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Ichigo_Rider_Items.SATANSABER.get()));
        Random generator = new Random();
		int rand = generator.nextInt(belt.length);
	
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(belt[rand]));
    }


        public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 135.0D)
                .add(Attributes.MOVEMENT_SPEED,0.23F)
                .add(Attributes.ATTACK_DAMAGE, 6.0D)
                .add(Attributes.ARMOR, 3.0D)
                .add(Attributes.MAX_HEALTH, 45.0D);
    }

    @Override
    public void actuallyHurt(DamageSource source, float amount) {
        super.actuallyHurt(source, amount);
        if(!this.level().isClientSide() && source.getEntity() instanceof LivingEntity living && living.hasEffect(Effect_core.HAPPY_MODE) && !this.hasEffect(Effect_core.SD)) {
            this.addEffect(new MobEffectInstance(Effect_core.SD, MobEffectInstance.INFINITE_DURATION, 0, true, false));
            ((ServerLevel) this.level()).sendParticles(ParticleTypes.HAPPY_VILLAGER, this.getX(), this.getY() + 1, this.getZ(),
                15, 0.2, 0.2, 0.2, 1);
        }
    }

    public void remove(RemovalReason reason) {
        if (reason == RemovalReason.KILLED) {
            LocalDate localdate = LocalDate.now();
            if (localdate.getMonthValue() == 4 && localdate.getDayOfMonth() == 1 && this.lastHurtByPlayer!=null) this.lastHurtByPlayer.drop(new ItemStack(Modded_item_core.MASKED_RIDER_MUSIC_DISC.get(), 1), false);
        }
        super.remove(reason);
    }
}