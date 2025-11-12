package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.Gotchard_Rider_Items;
import com.kelco.kamenridercraft.item.Zero_One_Rider_Items;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class DoradoEntity extends BaseHenchmenEntity {



    public DoradoEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="dorado";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Gotchard_Rider_Items.GOTCHARD_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Gotchard_Rider_Items.GOTCHARD_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Gotchard_Rider_Items.GOTCHARD_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Gotchard_Rider_Items.ELDORADRIVER.get()));
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Gotchard_Rider_Items.DORADO_SCYTHE.get()));
    }
    

    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 135.0D)
        		.add(Attributes.MOVEMENT_SPEED, 0.3F)
        		.add(Attributes.ATTACK_DAMAGE, 10.0D)
        		.add(Attributes.ARMOR, 3.0D)
        		.add(Attributes.MAX_HEALTH, 200.0D);
     }
    

}