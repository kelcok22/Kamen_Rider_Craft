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

import static com.kelco.kamenridercraft.attachments.AttachmentTypes.MOB_STATE;

public class CaucasusEntity extends BaseHenchmenEntity {
    public CaucasusEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME = "caucasus";
        setItemSlot(EquipmentSlot.HEAD, new ItemStack(KabutoRiderItems.KABUTOHELMET.get()));
        setItemSlot(EquipmentSlot.CHEST, new ItemStack(KabutoRiderItems.KABUTOCHESTPLATE.get()));
        setItemSlot(EquipmentSlot.LEGS, new ItemStack(KabutoRiderItems.KABUTOLEGGINGS.get()));
        setItemSlot(EquipmentSlot.FEET, new ItemStack(KabutoRiderItems.CAUCASUS_RIDER_BELT.get()));
    }

    @Override
    public void actuallyHurt(DamageSource source, float amount) {
        super.actuallyHurt(source, amount);
        if (!level().isClientSide() && !getData(MOB_STATE).equals("hyper_clock_up") && source.getEntity() instanceof Player player && getHealth() < 50) {
            player.sendSystemMessage(Component.translatable("attack.kamenridercraft.hyper_clock_up"));

            getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(1);
            getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(10.0D);
            getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(128.0D);
            setData(MOB_STATE, "hyper_clock_up");
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