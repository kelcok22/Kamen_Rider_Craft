package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.Saber_Rider_Items;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class LegeielForbiddenEntity extends BaseHenchmenEntity {

    public LegeielForbiddenEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="legeiel_forbidden";
    }

	public void remove(RemovalReason p_149847_) {

		if ( this.isDeadOrDying()) {
    		if(this.getLastAttacker() instanceof Player playerIn && playerIn.getInventory().countItem(Saber_Rider_Items.PRIMITIVE_DRAGON_WONDER_RIDE_BOOK.get())!=0){
                ItemEntity key = new ItemEntity(playerIn.level(), playerIn.getX(), playerIn.getY(), playerIn.getZ(), new ItemStack(Saber_Rider_Items.ELEMENTAL_DRAGON_WONDER_RIDE_BOOK.get(), 1), 0, 0, 0);
			    key.setPickUpDelay(0);
			    playerIn.level().addFreshEntity(key);
		        playerIn.sendSystemMessage(Component.translatable("loot.kamenridercraft.elemental_dragon"));
    		}
    	}
		super.remove(p_149847_);
	}
    

    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 135.0D)
        		.add(Attributes.MOVEMENT_SPEED, 0.4F)
        		.add(Attributes.ATTACK_DAMAGE, 10.0D)
        		.add(Attributes.ARMOR, 10.0D)
        		.add(Attributes.MAX_HEALTH, 200.0D);
     }
    

}
