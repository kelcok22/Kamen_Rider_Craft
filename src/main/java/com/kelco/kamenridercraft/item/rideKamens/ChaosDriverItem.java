package com.kelco.kamenridercraft.item.rideKamens;

import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.summons.ApolloEntity;
import com.kelco.kamenridercraft.entities.summons.LibraEntity;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.Miscellaneous_Rider_Items;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;

public class ChaosDriverItem extends RiderDriverItem {

    public ChaosDriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties);
	}

    public void summonRobots(Player player) {
		ApolloEntity apollo = MobsCore.APOLLO.get().create(player.level());
		if (apollo != null) {
			apollo.moveTo(player.getX()-1, player.getY()+1, player.getZ(), player.getYRot(), player.getXRot());
			player.level().addFreshEntity(apollo);
			apollo.bindToPlayer(player);
            apollo.addRequiredForm((RiderFormChangeItem)Miscellaneous_Rider_Items.CHAOS_RING_LOQ.get(), 1);
		}
        LibraEntity libra = MobsCore.LIBRA.get().create(player.level());
        if (libra != null) {
            libra.moveTo(player.getX()+1, player.getY()+1, player.getZ(), player.getYRot(), player.getXRot());
            player.level().addFreshEntity(libra);
            libra.bindToPlayer(player);
            libra.addRequiredForm((RiderFormChangeItem)Miscellaneous_Rider_Items.CHAOS_RING_LOQ.get(), 1);
        }
    }

    public static boolean robotsSummoned(Player player) {
		return !player.level().getEntitiesOfClass(ApolloEntity.class,
				player.getBoundingBox().inflate(99), entity -> entity.getOwner() == player).isEmpty()
                &&!player.level().getEntitiesOfClass(LibraEntity.class,
                player.getBoundingBox().inflate(99), entity -> entity.getOwner() == player).isEmpty() ;
    }
	
	public void OnTransformation(ItemStack itemstack, LivingEntity entity) {
		if (entity instanceof Player player && !robotsSummoned(player) && itemstack.getItem() == Miscellaneous_Rider_Items.CHAOS_DRIVER_LOQ.get()
                && RiderDriverItem.get_Form_Item(itemstack, 1) == Miscellaneous_Rider_Items.CHAOS_RING_LOQ.get())
			summonRobots(player);
		super.OnTransformation(itemstack, entity);
	}
	
	public void OnformChange(ItemStack itemstack, LivingEntity entity, CompoundTag tag) {
		if (entity instanceof Player player && !player.level().isClientSide() && isTransformed(player) && !robotsSummoned(player)
		&& itemstack.getItem() == Miscellaneous_Rider_Items.CHAOS_DRIVER_LOQ.get()
		&& RiderDriverItem.get_Form_Item(itemstack, 1) == Miscellaneous_Rider_Items.CHAOS_RING_LOQ.get())
			summonRobots(player);
		super.OnformChange(itemstack, entity, tag);
	}
}