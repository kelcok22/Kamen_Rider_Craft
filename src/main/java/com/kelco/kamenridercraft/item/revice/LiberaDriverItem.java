package com.kelco.kamenridercraft.item.revice;

import com.kelco.kamenridercraft.ServerConfig;
import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.summons.LovekovEntity;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Revice_Rider_Items;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;

public class LiberaDriverItem extends RiderDriverItem {

    public LiberaDriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties);
	}

    public void summonLovekov(Player player) {
		LovekovEntity lovekov = MobsCore.LOVEKOV.get().create(player.level());
		if (lovekov != null) {
			lovekov.moveTo(player.getX(), player.getY()+1, player.getZ(), player.getYRot(), player.getXRot());
			player.level().addFreshEntity(lovekov);
			lovekov.bindToPlayer(player);
		}
    }

    public static boolean lovekovSummoned(Player player) {
		return !player.level().getEntitiesOfClass(LovekovEntity.class,
				player.getBoundingBox().inflate(99), entity -> entity.getOwner() == player).isEmpty();
    }
	
	public void OnTransformation(ItemStack itemstack, LivingEntity entity) {
		if (entity instanceof Player player && ServerConfig.lovekovSpawning && !lovekovSummoned(player)
		&& itemstack.getItem() == Revice_Rider_Items.LIBERA_DRIVER.get()
		&& RiderDriverItem.get_Form_Item(itemstack, 1) == Revice_Rider_Items.COBRA_VISTAMP.get()
		&& !(player.isHolding(Revice_Rider_Items.LOVEKOV_KUJAKU.get()) || player.isHolding(Revice_Rider_Items.LOVEKOV_TURTLE.get()) || player.isHolding(Revice_Rider_Items.LOVEKOV_HASHIBIROKO.get()) || player.isHolding(Revice_Rider_Items.LOVEKOV_TRICERA.get())))
			summonLovekov(player);
		super.OnTransformation(itemstack, entity);
	}
	
	public void OnformChange(ItemStack itemstack, LivingEntity entity, CompoundTag tag) {
		if (entity instanceof Player player && !player.level().isClientSide() && isTransformed(player)
		&& ServerConfig.lovekovSpawning && !lovekovSummoned(player)
		&& itemstack.getItem() == Revice_Rider_Items.LIBERA_DRIVER.get()
		&& RiderDriverItem.get_Form_Item(itemstack, 1) == Revice_Rider_Items.COBRA_VISTAMP.get()
		&& !(player.isHolding(Revice_Rider_Items.LOVEKOV_KUJAKU.get()) || player.isHolding(Revice_Rider_Items.LOVEKOV_TURTLE.get()) || player.isHolding(Revice_Rider_Items.LOVEKOV_HASHIBIROKO.get()) || player.isHolding(Revice_Rider_Items.LOVEKOV_TRICERA.get())))
			summonLovekov(player);
		super.OnformChange(itemstack, entity, tag);
	}
}