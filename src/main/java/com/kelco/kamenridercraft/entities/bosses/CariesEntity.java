package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Gavv_Rider_Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.BossEvent;
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

public class CariesEntity extends BaseHenchmenEntity {

    private final ServerBossEvent bossEvent = new ServerBossEvent(getDisplayName(), BossEvent.BossBarColor.PURPLE, BossEvent.BossBarOverlay.PROGRESS);

		public CariesEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="caries";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Gavv_Rider_Items.GAVV_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Gavv_Rider_Items.GAVV_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Gavv_Rider_Items.GAVV_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Gavv_Rider_Items.HENSHIN_BELT_CARIES_GAVV.get()));
    }
    @Override
    public void actuallyHurt(DamageSource source, float amount) {
        super.actuallyHurt(source, amount);
        if (!this.level().isClientSide() && source.getEntity() instanceof Player playerIn && this.getHealth() < 100
                && this.getItemBySlot(EquipmentSlot.FEET).getItem() == Gavv_Rider_Items.HENSHIN_BELT_CARIES_GAVV.get() && RiderDriverItem.get_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), 1) != Gavv_Rider_Items.TERROR_GOCHIZO_C3.get()) {
            playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.caries_c3"));

            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.5);
            this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(12.0D);
            this.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(128.0D);
            RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Gavv_Rider_Items.TERROR_GOCHIZO_C3.get(), 1);
        }
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

    public void startSeenByPlayer(ServerPlayer p_31483_) {
        super.startSeenByPlayer(p_31483_);
        this.bossEvent.addPlayer(p_31483_);
    }

    public void stopSeenByPlayer(ServerPlayer p_31488_) {
        super.stopSeenByPlayer(p_31488_);
        this.bossEvent.removePlayer(p_31488_);
    }


        public static AttributeSupplier.Builder setAttributes() {
		return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 128.0D)
        		.add(Attributes.MOVEMENT_SPEED, 0.30F)
        		.add(Attributes.ATTACK_DAMAGE, 9.0D)
        		.add(Attributes.MAX_HEALTH, 200.0D);
     }
    

}