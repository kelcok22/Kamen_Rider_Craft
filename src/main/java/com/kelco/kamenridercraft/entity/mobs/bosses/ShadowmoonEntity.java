package com.kelco.kamenridercraft.entity.mobs.bosses;

import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.BuildRiderItems;
import com.kelco.kamenridercraft.item.misc_items.MusicDiscItems;
import com.kelco.kamenridercraft.item.showa.BlackRiderItems;
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
	
	public static final Item[] belt = new Item[] {BlackRiderItems.SHADOW_CHARGER.get()};

	
    public ShadowmoonEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="shadow_moon";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(BlackRiderItems.BLACKHELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(BlackRiderItems.BLACKCHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(BlackRiderItems.BLACKLEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(BlackRiderItems.SATANSABER.get()));
        ItemStack rider = new ItemStack(BlackRiderItems.SHADOW_CHARGER.get());
        RiderDriverItem.setUpdateForm(rider);
        this.setItemSlot(EquipmentSlot.FEET, rider);
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
        if(!this.level().isClientSide() && source.getEntity() instanceof LivingEntity living && living.hasEffect(EffectCore.HAPPY_MODE) && !this.hasEffect(EffectCore.SD)) {
            this.addEffect(new MobEffectInstance(EffectCore.SD, MobEffectInstance.INFINITE_DURATION, 0, true, false));
            ((ServerLevel) this.level()).sendParticles(ParticleTypes.HAPPY_VILLAGER, this.getX(), this.getY() + 1, this.getZ(),
                15, 0.2, 0.2, 0.2, 1);
        }
    }

    public void remove(RemovalReason reason) {
        if (reason == RemovalReason.KILLED) {
            LocalDate localdate = LocalDate.now();
            if (localdate.getMonthValue() == 4 && localdate.getDayOfMonth() == 1 && this.lastHurtByPlayer!=null) this.lastHurtByPlayer.drop(new ItemStack(MusicDiscItems.MASKED_RIDER_MUSIC_DISC.get(), 1), false);
        }
        super.remove(reason);
    }
}