package com.kelco.kamenridercraft.entity.mobs.bosses;

import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_1.BladeRiderItems;
import com.kelco.kamenridercraft.item.reiwa.ZeztzRiderItems;
import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.world.BossEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.Random;

public class JokerUndeadEntity extends BaseHenchmenEntity {
    private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(GodaEntity.class, EntityDataSerializers.BYTE);
    private final ServerBossEvent bossEvent = new ServerBossEvent(Component.translatable(getDisplayName().getString()).withStyle(ChatFormatting.GREEN), BossEvent.BossBarColor.GREEN, BossEvent.BossBarOverlay.PROGRESS);

		public JokerUndeadEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="ace_undead";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(BladeRiderItems.BLADEHELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(BladeRiderItems.BLADECHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(BladeRiderItems.BLADELEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(BladeRiderItems.BLACK_JOKERROUZER.get()));
    }

    protected void customServerAiStep() {
        super.customServerAiStep();
        this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
    }

    public void readAdditionalSaveData(CompoundTag p_31474_) {
        super.readAdditionalSaveData(p_31474_);
        if (this.hasCustomName()) {
            this.bossEvent.setName(this.getDisplayName());
        }
    }

    public void setCustomName(@Nullable Component p_31476_) {
        super.setCustomName(p_31476_);
        this.bossEvent.setName(this.getDisplayName());
    }

    @Override
    public void actuallyHurt(DamageSource source, float amount) {
        super.actuallyHurt(source, amount);
        if (!this.level().isClientSide() && source.getEntity() instanceof Player playerIn && this.getItemInHand(InteractionHand.MAIN_HAND).isEmpty() && this.getHealth() < 75) {
            if (new Random().nextInt(100) <= 98) {
                setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(BladeRiderItems.JOKER_MANTIS.get()));
                setItemInHand(InteractionHand.OFF_HAND, new ItemStack(BladeRiderItems.JOKER_MANTIS.get()));
            } else {
                setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(BladeRiderItems.CAUCASUS_ALL_OVER.get()));
            }
            }
}
	public static AttributeSupplier.Builder setAttributes() {
		return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 128.0D)
        		.add(Attributes.MOVEMENT_SPEED, 0.30F)
        		.add(Attributes.ATTACK_DAMAGE, 5.0D)
        		.add(Attributes.MAX_HEALTH, 150.0D);
     }
    

}