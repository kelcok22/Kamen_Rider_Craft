package com.kelco.kamenridercraft.item.zi_o;

import com.kelco.kamenridercraft.ServerConfig;
import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.summons.DecadeArmorExAidEntity;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Zi_O_Rider_Items;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;

public class ZikuDriverItem extends RiderDriverItem {

    public ZikuDriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties);
	}

    public void summonDecadeExAid(Player player) {
		DecadeArmorExAidEntity decadeExAid = MobsCore.DECADE_ARMOR_EX_AID.get().create(player.level());
		if (decadeExAid != null) {
			decadeExAid.moveTo(player.getX(), player.getY()+1, player.getZ(), player.getYRot(), player.getXRot());
			player.level().addFreshEntity(decadeExAid);
			decadeExAid.bindToPlayer(player);
		}
    }

    public static boolean decadeExAidSummoned(Player player) {
		for (DecadeArmorExAidEntity entity : player.level().getEntitiesOfClass(DecadeArmorExAidEntity.class,
						player.getBoundingBox().inflate(99), entity -> entity.getOwner() == player)) {
			if (entity != null) return true;
		}
        return false;
    }
	/*
	public void OnTransform(ItemStack itemstack, LivingEntity entity) {
		if (entity instanceof Player player && ServerConfig.decadeExAidSpawning && !decadeExAidSummoned(player)
		&& itemstack.getItem() == Zi_O_Rider_Items.ZIKU_DRIVER_ZI_O.get()
		&& (RiderDriverItem.get_Form_Item(itemstack, 1) == Zi_O_Rider_Items.DECADE_EX_AID_RIDEWATCH_L.get()
		|| RiderDriverItem.get_Form_Item(itemstack, 1) == Zi_O_Rider_Items.DECADE_EX_AID_RIDEWATCH_R.get()))
			summonDecadeExAid(player);
		super.OnTransform(itemstack, entity);
	}
	*/
	public void OnformChange(ItemStack itemstack, LivingEntity entity, CompoundTag tag) {
		if (entity instanceof Player player && !player.level().isClientSide() && isTransformed(player)
		&& ServerConfig.decadeExAidSpawning && !decadeExAidSummoned(player)
		&& itemstack.getItem() == Zi_O_Rider_Items.ZIKU_DRIVER_ZI_O.get()
		&& RiderDriverItem.get_Form_Item(itemstack, 1) == Zi_O_Rider_Items.DECADE_EX_AID_RIDEWATCH_L.get())
			summonDecadeExAid(player);
		super.OnformChange(itemstack, entity, tag);
	}
}