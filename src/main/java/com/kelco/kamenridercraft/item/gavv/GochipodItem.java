package com.kelco.kamenridercraft.item.gavv;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.Gavv_Rider_Items;
import com.kelco.kamenridercraft.item.Geats_Rider_Items;
import com.kelco.kamenridercraft.item.Modded_item_core;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.BundleContents;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import org.jline.reader.History;

import java.util.List;
import java.util.function.Consumer;

public class GochipodItem extends BaseItem {
	public GochipodItem(Properties prop) {
		super(prop.stacksTo(1));
	}

	@Override
	public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
		tooltipComponents.add(Component.literal(Component.translatable("kamenridercraft.name.gochipod.stored").getString()+":"+get_store_Item(stack)+"/100"));
		super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
	}

	public void inventoryTick(ItemStack itemStack, Level level, Entity entity, int slotId, boolean isSelected) {
		if (entity instanceof Player player)
		if (get_store_Item(itemStack)==100){
			player.getInventory().setItem(slotId, new ItemStack(Gavv_Rider_Items.GOCHIPOD.asItem()));
		}
	}

/**
	@Override
	public boolean overrideOtherStackedOnMe(
			ItemStack stack, ItemStack other, Slot slot, ClickAction action, Player player, SlotAccess access
	) {
if (other.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "gear/gochizo/puchingummy")))){
	int stored = get_store_Item(stack);
	int need = 100-stored;
	int have = other.getCount();
	if (need!=0){
		if (have>need){
			set_store_Item(stack,need);
			other.shrink(need);
		}else {
			set_store_Item(stack,have);
			other.shrink(have);
		}
		return true;
	}
		}
		return false;
	}
**/

	public static int get_store_Item(ItemStack itemstack)
	{
		if (itemstack.has(DataComponents.CUSTOM_DATA)) {
			CompoundTag tag = itemstack.get(DataComponents.CUSTOM_DATA).getUnsafe();
				return tag.getInt("store");
		}
		return 0;
	}

	public static void set_store_Item(ItemStack itemstack, int num)
	{
		if (!itemstack.has(DataComponents.CUSTOM_DATA)) itemstack.set(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
			Consumer<CompoundTag> data = form -> {
				form.putInt("store",num+get_store_Item(itemstack));
			};
			CustomData.update(DataComponents.CUSTOM_DATA, itemstack, data);
	}
}