package com.kelco.kamenridercraft.entities.summons;

import com.kelco.kamenridercraft.ServerConfig;
import com.kelco.kamenridercraft.item.Zi_O_Rider_Items;
import com.kelco.kamenridercraft.item.BaseItems.RiderFormChangeItem;

import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class GrandSummonEntity extends RiderSummonEntity {

	public GrandSummonEntity(EntityType<? extends GrandSummonEntity> type, Level level) {
		super(type, level);
		NAME="rider_summon";
        this.addRequiredForm((RiderFormChangeItem)Zi_O_Rider_Items.GRAND_ZI_O_RIDEWATCH.get(), 1);
        this.addRequiredForm((RiderFormChangeItem)Zi_O_Rider_Items.UNFINISHED_OHMA_ZI_O_DRIVER_L.get(), 1);
        this.addRequiredForm((RiderFormChangeItem)Zi_O_Rider_Items.OHMA_ZI_O_RIDEWATCH.get(), 1);
	}

	public static AttributeSupplier.Builder setAttributes() {
		return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, (double)0.35F).add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.ARMOR, 0.0D).add(Attributes.ATTACK_DAMAGE, 4.0D);
	}
	
    @Override
    public void setItemSlot(EquipmentSlot hand, ItemStack stack) {
        if (!hand.isArmor()) {
			stack.set(DataComponents.ITEM_NAME, Component.translatable("owner.kamenridercraft.zi_o", stack.getHoverName()));
			if (stack.isDamageableItem() && ServerConfig.summonedItemDurability != 0) stack.set(DataComponents.MAX_DAMAGE, ServerConfig.summonedItemDurability);
        }
        super.setItemSlot(hand, stack);
    }

    @Override
	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		if (!this.level().isClientSide && this.isOwnedBy(player) && this.getHealth() == this.getMaxHealth() && !this.getMainHandItem().isEmpty() && player.getMainHandItem().isEmpty()) {
            this.spawnAtLocation(this.getMainHandItem());
            this.spawnAtLocation(this.getOffhandItem());
			this.discard();
			return InteractionResult.SUCCESS;
		}
        return super.mobInteract(player, hand);
	}
}