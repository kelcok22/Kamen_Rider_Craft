package com.kelco.kamenridercraft.item.build;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.BaseItems.RiderArmorItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Build_Rider_Items;
import com.kelco.kamenridercraft.world.inventory.FullBottleHolderGuiMenu;
import io.netty.buffer.Unpooled;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemContainerContents;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.List;
import java.util.Objects;

public class BuildDriverItem extends RiderDriverItem {


	public BuildDriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties.component(DataComponents.CONTAINER, ItemContainerContents.EMPTY));
		this.Has_Inventory=true;
	}

	@Override
	public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
		player.openMenu(new MenuProvider() {
			@Override
			public Component getDisplayName() {
				return Component.translatable("fullbottle_holder.text");
			}
			@Override
			public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
				FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
				packetBuffer.writeBlockPos(player.blockPosition());
				packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
				return new FullBottleHolderGuiMenu(id, inventory, packetBuffer,itemstack);
			}
		}, buf -> buf.writeBlockPos(player.blockPosition()));
	}

	@Override
	public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
		this.Has_basic_belt_info = false;
		Item formItem = get_Form_Item(stack, 1);
		Item formItem2 = get_Form_Item(stack, 2);
		Item formItem3 = get_Form_Item(stack, 3);

		tooltipComponents.add(Component.translatable("kamenridercraft.name." + Rider));


		if(formItem3!= Build_Rider_Items.HAZARD_TRIGGER.get()&&formItem3!= Build_Rider_Items.FULL_BOTTLE.get()){
			tooltipComponents.add(Component.translatable(formItem3.toString() + ".form"));
		}else if (isBestMatch(stack)) {
			tooltipComponents.add(Component.literal(
			(get_Form_Item(stack, 2) == Build_Rider_Items.MEDAL_FULL_BOTTLE.get() || get_Form_Item(stack, 2) == Build_Rider_Items.PARKA_FULL_BOTTLE.get() ? Component.translatable(formItem.toString() + ".form_legend").getString() : Component.translatable(formItem.toString() + ".form_match").getString())

			+ (get_Form_Item(stack, 3) == Build_Rider_Items.HAZARD_TRIGGER.get() ? " " + Component.translatable("kamenridercraft.name.hazard").getString() : "")));
			tooltipComponents.add(formItem3== Build_Rider_Items.HAZARD_TRIGGER.get() ? Component.translatable("kamenridercraft.name.best_match_hazard") : Component.translatable("kamenridercraft.name.best_match"));
		} else {
			tooltipComponents.add(Component.literal(Component.translatable("kamenridercraft.name.form").getString() + " "
			+ Component.translatable(formItem.toString() + ".form").getString()
			+ Component.translatable(formItem2.toString() + ".form").getString()));
		}
		super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
	}

    public  boolean getGlowForSlot(ItemStack itemstack,EquipmentSlot currentSlot, LivingEntity livingEntity) {

        if (currentSlot== EquipmentSlot.FEET) {
            return get_Form_Item(itemstack, 1).get_Is_Belt_Glowing();
        }
        if (isTransformed(livingEntity)){
            switch (currentSlot) {
                case HEAD, CHEST, LEGS ->{
                    return true;
                }
                default -> {}
            }
            return false;
        }
        return false;
    }



	@Override
	public String GET_TEXT(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider,String riderName)
	{
		boolean fly = rider instanceof Player player && player.getAbilities().flying;
		if (equipmentSlot == EquipmentSlot.FEET) {
			
			return "belts/"+get_Form_Item(itemstack,3).getBeltTex();
		}
		else if (isBestMatch(itemstack)&isLegend(itemstack)) return riderName+"_"+((FullBottleItem)get_Form_Item(itemstack,Legend_Slot(itemstack))).get_Is_Legend_Name();
		else if (equipmentSlot == EquipmentSlot.HEAD) return riderName+get_Form_Item(itemstack,1).getFormName(fly)+get_Form_Item(itemstack,3).getFormName(fly);
		else { return riderName+get_Form_Item(itemstack,2).getFormName(fly)+get_Form_Item(itemstack,3).getFormName(fly);
		}
	}

	public int Legend_Slot(ItemStack itemstack) {

		if (get_Form_Item(itemstack, 1) instanceof FullBottleItem form) {
			if (form.get_Is_Legend()) return 1;
		}
		return 2;
	}

	public boolean isLegend(ItemStack itemstack) {

		if (get_Form_Item(itemstack,1) instanceof FullBottleItem form){
			if (form.get_Is_Legend()){return true;}
		}if (get_Form_Item(itemstack,2) instanceof FullBottleItem form){
            return form.get_Is_Legend();
		}
		return false;
	}
	public static boolean isBestMatch(ItemStack itemstack) {

		if (get_Form_Item(itemstack,1) instanceof FullBottleItem form){
			if (form.get_Is_Legend()){
				return form.get_Best_Match()==get_Form_Item(itemstack,2);
			}

		}if (get_Form_Item(itemstack,2) instanceof FullBottleItem form){
			return form.get_Best_Match()==get_Form_Item(itemstack,1);
		}
		return false;
	}

	public static boolean CanHazard(ItemStack itemstack) {
		if (get_Form_Item(itemstack,1) instanceof FullBottleItem form) {
			if (form.get_Is_Legend())return false;
		}
				if (isBestMatch(itemstack)){
			if (get_Form_Item(itemstack,2) instanceof FullBottleItem form){
				if (!form.get_Is_Legend()){
					return form.Get_Can_Hazard();
				}
			}
		}
		return false;
	}
	public ResourceLocation getModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {

		int num = 1;
		if (slot == EquipmentSlot.LEGS)num=2;

	 if (isBestMatch(itemstack)&isLegend(itemstack)) return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/rider_plusbelt.geo.json");
		else if (Objects.equals(get_Form_Item(itemstack, num).get_Model(this.Rider), "default.geo.json")) {
			return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/rider_plusbelt.geo.json");
		}
		if (get_Form_Item(itemstack, num).HasWingsIfFlying() && rider instanceof Player player && player.getAbilities().flying){
			return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/"+get_Form_Item(itemstack, num).get_FlyingModel(this.Rider));
		}else return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/"+get_Form_Item(itemstack, num).get_Model(this.Rider));
	}
	
	@Override
	public  boolean getPartsForSlot(ItemStack itemstack,EquipmentSlot currentSlot,String  part) {

		switch (currentSlot) {
		case HEAD ->{ 
			if (Objects.equals(part, "head")) return true;
			if (Objects.equals(part, "body")) return true;
			if (Objects.equals(part, "rightArm")) return true;
			if (Objects.equals(part, "leftLeg")) return true;
		}
		case CHEST -> {
		}
		case LEGS -> {
			if (Objects.equals(part, "head")) return true;
			if (Objects.equals(part, "body")) return true;
			if (Objects.equals(part, "leftArm")) return true;
			if (Objects.equals(part, "rightLeg")) return true;
		}
		default -> {}
		}
		return false;
	}



}