package com.kelco.kamenridercraft.item.gavv;


import java.util.List;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.summons.RiderSummonEntity;
import com.kelco.kamenridercraft.entities.summons.WhippedSoldierEntity;
import com.kelco.kamenridercraft.entities.variants.WhippedSoldierVariant;
import com.kelco.kamenridercraft.item.Decade_Rider_Items;
import com.kelco.kamenridercraft.item.Gavv_Rider_Items;
import com.kelco.kamenridercraft.item.Modded_item_core;
import com.kelco.kamenridercraft.item.OOO_Rider_Items;
import com.kelco.kamenridercraft.item.BaseItems.BaseSwordItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;

import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
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