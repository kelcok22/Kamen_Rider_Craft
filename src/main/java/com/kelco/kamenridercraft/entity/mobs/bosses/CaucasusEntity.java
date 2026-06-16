package com.kelco.kamenridercraft.entity.mobs.bosses;

import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.heisei_phase_1.KabutoRiderItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import static com.kelco.kamenridercraft.world.data_attachments.AttachmentTypes.MOB_TRANSFORMED;

public class CaucasusEntity extends BaseHenchmenEntity {
    public CaucasusEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME = "caucasus";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(KabutoRiderItems.KABUTOHELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(KabutoRiderItems.KABUTOCHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(KabutoRiderItems.KABUTOLEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(KabutoRiderItems.CAUCASUS_RIDER_BELT.get()));
    }

    @Override
    public void actuallyHurt(DamageSource source, float amount) {
        super.actuallyHurt(source, amount);
        if (!this.level().isClientSide() && !this.getData(MOB_TRANSFORMED) && source.getEntity() instanceof Player playerIn && this.getHealth() < 50) {
            playerIn.sendSystemMessage(Component.translatable("attack.kamenridercraft.hyper_clock_up"));

            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(1);
            this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(10.0D);
            this.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(128.0D);
            this.setData(MOB_TRANSFORMED, true);
        }
    }

    public static AttributeSupplier.Builder setAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 128.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.30F)
                .add(Attributes.ATTACK_DAMAGE, 5.0D)
                .add(Attributes.MAX_HEALTH, 100.0D);
    }
}