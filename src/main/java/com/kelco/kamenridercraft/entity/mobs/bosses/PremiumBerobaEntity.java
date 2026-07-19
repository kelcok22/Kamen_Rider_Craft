package com.kelco.kamenridercraft.entity.mobs.bosses;

import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.BuildRiderItems;
import com.kelco.kamenridercraft.item.reiwa.GeatsRiderItems;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.world.BossEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class PremiumBerobaEntity extends BaseHenchmenEntity {

    private final ServerBossEvent bossEvent = new ServerBossEvent(Component.translatable(getDisplayName().getString()).withStyle(ChatFormatting.GOLD), BossEvent.BossBarColor.GREEN, BossEvent.BossBarOverlay.PROGRESS);


    public PremiumBerobaEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME = "beroba_premium";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(GeatsRiderItems.GEATS_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(GeatsRiderItems.GEATS_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(GeatsRiderItems.GEATS_LEGGINGS.get()));
        ItemStack rider = new ItemStack(GeatsRiderItems.RAISE_RISER_BELT_BEROBA.get());
        RiderDriverItem.setUpdateForm(rider);
        this.setItemSlot(EquipmentSlot.FEET, rider);
        RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), GeatsRiderItems.BEROBA_BLACK_RAISE_RISER_CARD.get(), 1);
    }

 
    
    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 135.0D)
        		.add(Attributes.MOVEMENT_SPEED, 0.23F)
        		.add(Attributes.ATTACK_DAMAGE, 10.0D)
        		.add(Attributes.ARMOR, 3.0D)
        		.add(Attributes.MAX_HEALTH, 200.0D);
     }
    

}