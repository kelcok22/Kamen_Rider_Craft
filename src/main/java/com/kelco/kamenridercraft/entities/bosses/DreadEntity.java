package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Gotchard_Rider_Items;
import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class DreadEntity extends BaseHenchmenEntity {

		public DreadEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="dread";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Gotchard_Rider_Items.GOTCHARD_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Gotchard_Rider_Items.GOTCHARD_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Gotchard_Rider_Items.GOTCHARD_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Gotchard_Rider_Items.DREADRIVER.get()));
    }

    @Override
    public void actuallyHurt(DamageSource source, float amount) {
        super.actuallyHurt(source, amount);
        if(!this.level().isClientSide() && source.getEntity() instanceof Player playerIn) {
            if (this.getHealth()<75 && playerIn.getInventory().countItem(Gotchard_Rider_Items.TENLINER_RIDE_CHEMY_CARD.get().asItem())!=0 && RiderDriverItem.get_Form_Item(this.getItemBySlot(EquipmentSlot.FEET),1)!=Gotchard_Rider_Items.DREAD_TYPE_THREE_CARDS.get()) {
                if (this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUCEMENTS)) playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.dread_type_three"));
                RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Gotchard_Rider_Items.DREAD_TYPE_THREE_CARDS.get(), 1);
            }
        }
    }

    public void remove(RemovalReason p_149847_) {

        if ( this.isDeadOrDying()) {
            if(this.getLastAttacker() instanceof Player playerIn && playerIn.getInventory().countItem(Gotchard_Rider_Items.TENLINER_RIDE_CHEMY_CARD.get())!=0){
                ItemEntity key = new ItemEntity(playerIn.level(), playerIn.getX(), playerIn.getY(), playerIn.getZ(), new ItemStack(Gotchard_Rider_Items.CROSSHOPPER_RIDE_CHEMY_CARD.get(), 1), 0, 0, 0);
                key.setPickUpDelay(0);
                playerIn.level().addFreshEntity(key);
                playerIn.sendSystemMessage(Component.translatable("loot.kamenridercraft.crosshopper"));
            }
        }
        super.remove(p_149847_);
    }

	public static AttributeSupplier.Builder setAttributes() {
		return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 128.0D)
        		.add(Attributes.MOVEMENT_SPEED, 0.30F)
        		.add(Attributes.ATTACK_DAMAGE, 5.0D)
        		.add(Attributes.MAX_HEALTH, 100.0D);
     }
    

}