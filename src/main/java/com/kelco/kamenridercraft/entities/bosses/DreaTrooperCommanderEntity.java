package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Gotchard_Rider_Items;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class DreaTrooperCommanderEntity extends BaseHenchmenEntity {

    public DreaTrooperCommanderEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="dread";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Gotchard_Rider_Items.GOTCHARD_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Gotchard_Rider_Items.GOTCHARD_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Gotchard_Rider_Items.GOTCHARD_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Gotchard_Rider_Items.DREADRIVER.get()));

        switch (this.getRandom().nextInt(5)) {
            case 0:
                RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Gotchard_Rider_Items.STEAMLINER_REPLI_CHEMY_CARD.get(), 1);
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Gotchard_Rider_Items.BLOODY_AB.get()));
                break;
            case 1:
                RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Gotchard_Rider_Items.STEAMLINER_REPLI_CHEMY_CARD.get(), 1);
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Gotchard_Rider_Items.BLOODY_BB.get()));
                break;
            case 2:
                RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Gotchard_Rider_Items.UNICON_REPLI_CHEMY_CARD.get(), 1);
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Gotchard_Rider_Items.BLOODY_UC.get()));
                break;
            case 3:
                RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Gotchard_Rider_Items.DAIOHNI_REPLI_CHEMY_CARD.get(), 1);
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Gotchard_Rider_Items.BLOODY_DO.get()));
                break;
            case 4:
                RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Gotchard_Rider_Items.DREAD_TYPE_THREE_CARDS.get(), 1);
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Gotchard_Rider_Items.BLOODY_UC.get()));
                this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(Gotchard_Rider_Items.BLOODY_DO.get()));
                break;
        }
    }

    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 135.0D)
        		.add(Attributes.MOVEMENT_SPEED, 0.23F)
        		.add(Attributes.ATTACK_DAMAGE, 6.0D)
        		.add(Attributes.ARMOR, 3.0D)
        		.add(Attributes.MAX_HEALTH, 45.0D);
     }
}