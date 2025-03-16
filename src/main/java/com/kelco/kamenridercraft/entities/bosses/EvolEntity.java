package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.block.Rider_Blocks;
import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Build_Rider_Items;
import com.kelco.kamenridercraft.item.Saber_Rider_Items;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EvolEntity extends BaseHenchmenEntity {



    public EvolEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="evol";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Build_Rider_Items.BUILD_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Build_Rider_Items.BUILD_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Build_Rider_Items.BUILD_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Build_Rider_Items.EVOL_DRIVER.get()));
    }

	@Override
    public void actuallyHurt(DamageSource source, float amount) {
        super.actuallyHurt(source, amount);
    	if(!this.level().isClientSide() && source.getEntity() instanceof Player playerIn && this.getHealth()<100)
        if (playerIn.getInventory().countItem(Item.byBlock(Rider_Blocks.PANDORA_BOX.get()))!=0 && RiderDriverItem.get_Form_Item(this.getItemBySlot(EquipmentSlot.FEET),1)!=Build_Rider_Items.EVOL_TRIGGER.get()) {
            playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.evol_black_hole"));
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.5);
			this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(12.0D);
			this.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(128.0D);
			RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Build_Rider_Items.EVOL_TRIGGER.get(), 1);
    	}
        if(!this.level().isClientSide() && source.getEntity() instanceof Player playerIn && this.getHealth()<50)
            if (playerIn.getInventory().countItem(Build_Rider_Items.LAST_PANDORA_PANEL_BLACK.get())!=0 && RiderDriverItem.get_Form_Item(this.getItemBySlot(EquipmentSlot.FEET),1)!=Build_Rider_Items.EVOL_TRIGGER.get()) {
                playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.evolto"));
                this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(1);
                this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(15.0D);
                this.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(128.0D);
                RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Build_Rider_Items.EVOL_TRIGGER_KAIJIN.get(), 1);
            }
    }


    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 135.0D)
        		.add(Attributes.MOVEMENT_SPEED,(double)0.3F)
        		.add(Attributes.ATTACK_DAMAGE, 10.0D)
        		.add(Attributes.ARMOR, 3.0D)
        		.add(Attributes.MAX_HEALTH, 200.0D);
     }
    

}
