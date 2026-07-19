package com.kelco.kamenridercraft.entity.mobs.bosses;


import com.kelco.kamenridercraft.entity.ai.FlyingBossControl;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.OOORiderItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class AnkhLostEntity extends BaseHenchmenEntity {


	
	public AnkhLostEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="ankh_lost";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(OOORiderItems.OOOHELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(OOORiderItems.OOOCHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(OOORiderItems.OOOLEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(OOORiderItems.GREEED_BLET_ANKH_LOST.get()));
        RiderDriverItem.setUpdateForm(this.getItemBySlot(EquipmentSlot.FEET));
        this.moveControl = new FlyingBossControl(this, 20);
    }

    
    


    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 35.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.2F)
                .add(Attributes.FLYING_SPEED, 0.2F)
        		.add(Attributes.ATTACK_DAMAGE, 10.0D)
        		.add(Attributes.ARMOR, 4.0D)
        		.add(Attributes.MAX_HEALTH, 60.0D);
     }
}