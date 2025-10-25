package com.kelco.kamenridercraft.entities.bosses;


import com.kelco.kamenridercraft.entities.ai.FlyingBossControl;
import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.Gavv_Rider_Items;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class LangoEntity extends BaseHenchmenEntity {



    public LangoEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="lango_stomach";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Gavv_Rider_Items.GAVV_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Gavv_Rider_Items.GAVV_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Gavv_Rider_Items.GAVV_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Gavv_Rider_Items.LANGO_MIMICDEVISER.get()));
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Gavv_Rider_Items.LANGO_SWORD.get()));
        this.moveControl = new FlyingBossControl(this, 20);
    }


    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 135.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3F)
                .add(Attributes.FLYING_SPEED, 0.3F)
                .add(Attributes.ATTACK_DAMAGE, 10.0D)
                .add(Attributes.ARMOR, 3.0D)
                .add(Attributes.MAX_HEALTH, 200.0D);
    }


}