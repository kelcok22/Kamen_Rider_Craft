package com.kelco.kamenridercraft.item.reiwa.gavv;


import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.variants.WhippedSoldierVariant;
import com.kelco.kamenridercraft.entity.mobs.summons.WhippedSoldierEntity;
import com.kelco.kamenridercraft.item.base_items.BaseSwordItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.reiwa.Gavv_Rider_Items;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

import java.util.List;

public class GavvwhipirItem extends BaseSwordItem {


	public GavvwhipirItem(Tier toolTier, int Atk, float Spd, Properties prop) {
		super(toolTier, Atk, Spd, prop);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        ItemStack belt = entity.getItemBySlot(EquipmentSlot.FEET);
		if (!world.isClientSide() && belt.getItem() == Gavv_Rider_Items.HENSHIN_BELT_GAVV.get() && ((RiderDriverItem)belt.getItem()).isTransformed(entity)
        && (RiderDriverItem.get_Form_Item(belt, 1) == Gavv_Rider_Items.CAKING_GOCHIZO.get() || RiderDriverItem.get_Form_Item(belt, 1) == Gavv_Rider_Items.BLIZZARDSORBEI_GOCHIZO.get())) {
			List<WhippedSoldierEntity> soldiers = world.getEntitiesOfClass(WhippedSoldierEntity.class, entity.getBoundingBox().inflate(50), whip -> (whip.getOwner() == entity));
			if (soldiers.size() < 2) {
                WhippedSoldierEntity whip = MobsCore.WHIPPED_SOLDIER.get().create(world);
                if (whip != null) {
                    whip.moveTo(entity.getX(), entity.getY()+1, entity.getZ(), entity.getYRot(), entity.getXRot());				
                    world.addFreshEntity(whip);
                    whip.bindToPlayer(entity);
					if (RiderDriverItem.get_Form_Item(belt, 1) == Gavv_Rider_Items.BLIZZARDSORBEI_GOCHIZO.get()) whip.setVariant(WhippedSoldierVariant.ICE);
                }
                entity.displayClientMessage(Component.translatable("attack.kamenridercraft.whip_party"), true);
				if (!entity.isCreative()) entity.getCooldowns().addCooldown(this, 80);
			}
		}
		return super.use(world, entity, hand);
	}
}