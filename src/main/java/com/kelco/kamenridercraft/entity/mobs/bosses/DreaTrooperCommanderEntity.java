package com.kelco.kamenridercraft.entity.mobs.bosses;

import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.reiwa.GotchardRiderItems;
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
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(GotchardRiderItems.GOTCHARD_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(GotchardRiderItems.GOTCHARD_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(GotchardRiderItems.GOTCHARD_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(GotchardRiderItems.DREADRIVER.get()));

        switch (this.getRandom().nextInt(5)) {
            case 0:
                RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), GotchardRiderItems.STEAMLINER_REPLI_CHEMY_CARD.get(), 1);
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(GotchardRiderItems.BLOODY_AB.get()));
                break;
            case 1:
                RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), GotchardRiderItems.STEAMLINER_REPLI_CHEMY_CARD.get(), 1);
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(GotchardRiderItems.BLOODY_BB.get()));
                break;
            case 2:
                RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), GotchardRiderItems.UNICON_REPLI_CHEMY_CARD.get(), 1);
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(GotchardRiderItems.BLOODY_UC.get()));
                break;
            case 3:
                RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), GotchardRiderItems.DAIOHNI_REPLI_CHEMY_CARD.get(), 1);
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(GotchardRiderItems.BLOODY_DO.get()));
                break;
            case 4:
                RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), GotchardRiderItems.DREAD_TYPE_THREE_CARDS.get(), 1);
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(GotchardRiderItems.BLOODY_UC.get()));
                this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(GotchardRiderItems.BLOODY_DO.get()));
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