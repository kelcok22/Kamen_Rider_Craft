package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.Gotchard_Rider_Items;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class GigistEntity extends BaseHenchmenEntity {

    public GigistEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="gigist";
    }

    public void remove(Entity.RemovalReason p_149847_) {
        if ( this.isDeadOrDying() && !this.level().isClientSide && this.getLastAttacker() instanceof Player player) {
            if (player.getInventory().countItem(Gotchard_Rider_Items.MACHWHEEL_RIDE_CHEMY_CARD.get()) != 0
                && player.getInventory().countItem(Gotchard_Rider_Items.DAIOHNI_RIDE_CHEMY_CARD.get()) != 0) {
                if (player.getInventory().getItem(40).getItem() == Gotchard_Rider_Items.MACHWHEEL_RIDE_CHEMY_CARD.get()) player.getInventory().removeItem(40, 1);
                else player.getInventory().removeItem(player.getInventory().findSlotMatchingItem(new ItemStack(Gotchard_Rider_Items.MACHWHEEL_RIDE_CHEMY_CARD.get())), 1);
                if (player.getInventory().getItem(40).getItem() == Gotchard_Rider_Items.DAIOHNI_RIDE_CHEMY_CARD.get()) player.getInventory().removeItem(40, 1);
                else player.getInventory().removeItem(player.getInventory().findSlotMatchingItem(new ItemStack(Gotchard_Rider_Items.DAIOHNI_RIDE_CHEMY_CARD.get())), 1);
                ItemEntity stamp = new ItemEntity(this.level(), player.getX(), player.getY(), player.getZ(), new ItemStack(Gotchard_Rider_Items.METAL_MACHWHEEL_RIDE_CHEMY_CARD.get(), 1), 0, 0, 0);
                stamp.setPickUpDelay(0);
                ItemEntity stamp1 = new ItemEntity(this.level(), player.getX(), player.getY(), player.getZ(), new ItemStack(Gotchard_Rider_Items.METAL_DAIOHNI_RIDE_CHEMY_CARD.get(), 1), 0, 0, 0);
                stamp1.setPickUpDelay(0);
                this.level().addFreshEntity(stamp);
                this.level().addFreshEntity(stamp1);
            }
        }
        super.remove(p_149847_);
    }
    

    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 135.0D)
        		.add(Attributes.MOVEMENT_SPEED, 0.4F)
        		.add(Attributes.ATTACK_DAMAGE, 10.0D)
        		.add(Attributes.ARMOR, 3.0D)
        		.add(Attributes.MAX_HEALTH, 100.0D);
     }
    

}
