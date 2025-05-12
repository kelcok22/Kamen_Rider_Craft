package com.kelco.kamenridercraft.item.gavv;


import com.kelco.kamenridercraft.item.Gavv_Rider_Items;
import com.kelco.kamenridercraft.item.BaseItems.BaseSwordItem;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
public class GavvgabladeItem extends BaseSwordItem {


	public GavvgabladeItem(Tier toolTier, int Atk, float Spd, Properties prop) {
		super(toolTier, Atk, Spd, prop);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        ItemStack press = entity.getItemBySlot(EquipmentSlot.OFFHAND);
		if (!world.isClientSide() && entity.getItemBySlot(EquipmentSlot.MAINHAND).getItem() == this && press.getItem() == Gavv_Rider_Items.HEATPRESS.get()) {
            EntityType.VILLAGER.spawn((ServerLevel)world, entity.blockPosition(), MobSpawnType.SPAWN_EGG);
            entity.getItemBySlot(EquipmentSlot.OFFHAND).shrink(1);
			entity.getItemBySlot(EquipmentSlot.MAINHAND).hurtAndBreak(1, entity, EquipmentSlot.MAINHAND);
		}
		return super.use(world, entity, hand);
	}
}