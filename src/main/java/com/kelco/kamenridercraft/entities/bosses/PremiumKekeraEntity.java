package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Geats_Rider_Items;
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

public class PremiumKekeraEntity extends BaseHenchmenEntity {

    private final ServerBossEvent bossEvent = new ServerBossEvent(Component.translatable(getDisplayName().getString()).withStyle(ChatFormatting.GREEN), BossEvent.BossBarColor.GREEN, BossEvent.BossBarOverlay.PROGRESS);


    public PremiumKekeraEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME = "kekera_premium";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Geats_Rider_Items.GEATS_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Geats_Rider_Items.GEATS_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Geats_Rider_Items.GEATS_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Geats_Rider_Items.RAISE_RISER_BELT_KEKERA.get()));
        RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Geats_Rider_Items.KEKERA_BLACK_RAISE_RISER_CARD.get(), 1);
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