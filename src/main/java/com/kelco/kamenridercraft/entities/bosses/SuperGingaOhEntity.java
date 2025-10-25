package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.ai.FlyingBossControl;
import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.Fourze_Rider_Items;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class SuperGingaOhEntity extends BaseHenchmenEntity {
   
    public SuperGingaOhEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="super_gingaoh";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Fourze_Rider_Items.FOURZE_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Fourze_Rider_Items.FOURZE_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Fourze_Rider_Items.FOURZE_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Fourze_Rider_Items.GINGA_OH_DRIVER.get()));
        this.moveControl = new FlyingBossControl(this, 20);
    }
    

    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 135.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.35F)
                .add(Attributes.FLYING_SPEED, 0.35F)
        		.add(Attributes.ATTACK_DAMAGE, 10.0D)
        		.add(Attributes.ARMOR, 3.0D)
        		.add(Attributes.MAX_HEALTH, 300.0D);
     }
}