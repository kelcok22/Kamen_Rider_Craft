package com.kelco.kamenridercraft.item.reiwa.gotchard;

import com.google.common.collect.Lists;
import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.ModdedItemCore;
import com.kelco.kamenridercraft.item.base_items.RiderArmorItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.base_items.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.reiwa.GotchardRiderItems;
import com.kelco.kamenridercraft.world.inventory.GotchandrawHolderGuiMenu;
import io.netty.buffer.Unpooled;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.List;
import java.util.Objects;

public class ValvaradItem extends RiderDriverItem {


	public ValvaradItem (Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Item.Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties.stacksTo(1).rarity(Rarity.COMMON).component(DataComponents.CONTAINER, ItemContainerContents.EMPTY));

		extraBaseFormItem = Lists.newArrayList((RiderFormChangeItem) ModdedItemCore.BLANK_FORM.get(),(RiderFormChangeItem) ModdedItemCore.BLANK_FORM.get(),(RiderFormChangeItem) ModdedItemCore.BLANK_FORM.get());
		hasInventory =true;
		numBaseFormItems =3;
	}

	@Override
	public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
		Item formItem = getFormItem(stack, 1);
		Item formItem2 = getFormItem(stack, 2);
		Item formItem3 = getFormItem(stack, 3);

		tooltipComponents.add(Component.translatable("kamenridercraft.name."+ riderName));

		if (formItem2!= GotchardRiderItems.GEKIOCOPTER_RIDE_CHEMY_CARD.get()&&formItem3!= GotchardRiderItems.GUTSSHOVEL_RIDE_CHEMY_CARD.get()) tooltipComponents.add(Component.translatable(formItem.toString() + ".form"));
		else if (formItem2== GotchardRiderItems.GEKIOCOPTER_RIDE_CHEMY_CARD.get()&&formItem3!= GotchardRiderItems.GUTSSHOVEL_RIDE_CHEMY_CARD.get()) tooltipComponents.add(Component.translatable(formItem2 + ".form"));
		else if (formItem2!= GotchardRiderItems.GEKIOCOPTER_RIDE_CHEMY_CARD.get()&&formItem3== GotchardRiderItems.GUTSSHOVEL_RIDE_CHEMY_CARD.get()) tooltipComponents.add(Component.translatable(formItem3 + ".form"));
		else tooltipComponents.add(Component.translatable("kamenridercraft:tri_custom.form"));
	}


@Override
	public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
		player.openMenu(new MenuProvider() {
			@Override
			public Component getDisplayName() {
				return Component.translatable("valvaradraw_buckle.text");
			}

			@Override
			public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
				FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
				packetBuffer.writeBlockPos(player.blockPosition());
				packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
				return new GotchandrawHolderGuiMenu(id, inventory, packetBuffer,itemstack);
			}
		}, buf -> {
			buf.writeBlockPos(player.blockPosition());
			buf.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
		});
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		ItemStack itemstack = entity.getItemInHand(hand);
		if (!world.isClientSide && entity instanceof ServerPlayer serverPlayer) openInventory(serverPlayer, hand, itemstack);
		return InteractionResultHolder.sidedSuccess(itemstack, world.isClientSide());
	}

	@Override
	public String getText(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName)
	{
		if (equipmentSlot == EquipmentSlot.FEET) {

			String belt = ((RiderDriverItem)itemstack.getItem()).beltText;
			if (((RiderDriverItem)itemstack.getItem()).beltText ==null) {
				belt = getFormItem(itemstack,1).getBeltTex();
			}
			return "belts/"+belt;

		}
		else if (equipmentSlot == EquipmentSlot.CHEST) return "valvarad_custom";

		else return riderName+ getFormItem(itemstack,1).getFormName(false);

	}

	public ResourceLocation getModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
        if (Objects.requireNonNull(slot) == EquipmentSlot.CHEST) {
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/valvarad_custom.geo.json");
        }
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/" + getFormItem(itemstack, 1).getModel(this.riderName));
    }

	@Override
	public  boolean getPartsForSlot(ItemStack itemstack,EquipmentSlot currentSlot,String  part) {

		switch (currentSlot) {
		case HEAD ->{ 
			if (Objects.equals(part, "head")) return true;
			if (Objects.equals(part, "body")) return true;
			if (Objects.equals(part, "rightArm")) return true;
			if (Objects.equals(part, "leftArm")) return true;
			if (Objects.equals(part, "leftLeg")) return true;
			if (Objects.equals(part, "rightLeg")) return true;
			
		}
		case CHEST -> {
			if (Objects.equals(part, "rightArm")) return getFormItem(itemstack, 2) == GotchardRiderItems.GEKIOCOPTER_RIDE_CHEMY_CARD.get();
			if (Objects.equals(part, "leftArm")) return getFormItem(itemstack, 3) == GotchardRiderItems.GUTSSHOVEL_RIDE_CHEMY_CARD.get();
		
		}
		case LEGS -> {
			if (Objects.equals(part, "leftLeg")) return true;
			if (Objects.equals(part, "rightLeg")) return true;
		}
		default -> {}
		}
		return false;
	}


}