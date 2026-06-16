package com.kelco.kamenridercraft.item.reiwa.geats;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.ModdedItemCore;
import com.kelco.kamenridercraft.item.base_items.RiderArmorItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.reiwa.GeatsRiderItems;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import com.kelco.kamenridercraft.world.inventory.RaiseBuckleHolderGuiMenu;
import io.netty.buffer.Unpooled;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
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
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.List;
import java.util.Objects;

public class DesireDriverItem  extends RiderDriverItem {


	public DesireDriverItem (Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Item.Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties.component(DataComponents.CONTAINER, ItemContainerContents.EMPTY));
		this.Has_Inventory=true;
	}

	@Override
	public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
		player.openMenu(new MenuProvider() {
			@Override
			public Component getDisplayName() {
				return Component.translatable("raise_buckle_holder.text");
			}


			@Override
			public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
				FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
				packetBuffer.writeBlockPos(player.blockPosition());
				packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
				return new RaiseBuckleHolderGuiMenu(id, inventory, packetBuffer,itemstack);
			}
		}, buf -> buf.writeBlockPos(player.blockPosition()));
	}

	@Override
	public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
		Has_basic_belt_info=false;
		Item formItem = getFormItem(stack, 1);
		Item formItem2 = getFormItem(stack, 2);
		Item formItem3 = getFormItem(stack, 3);

		if(formItem2== GeatsRiderItems.ONENESS_RAISE_BUCKLE.get()) tooltipComponents.add(Component.translatable("kamenridercraft.name.geats_oneness"));
		else if(formItem== GeatsRiderItems.GEATS_CORE_ID_OSAKA.get()) tooltipComponents.add(Component.translatable("kamenridercraft.name.osaka_"+Rider));
		else if(formItem== GeatsRiderItems.GEATS_CORE_ID_FUKUOKA.get()) tooltipComponents.add(Component.translatable("kamenridercraft.name.fukuoka_"+Rider));
		else if(formItem== GeatsRiderItems.GEATS_CORE_ID_NAGOYA.get()) tooltipComponents.add(Component.translatable("kamenridercraft.name.nagoya_"+Rider));
		else if(formItem== GeatsRiderItems.GEATS_CORE_ID_TOKYO.get()) tooltipComponents.add(Component.translatable("kamenridercraft.name.tokyo_"+Rider));
		else tooltipComponents.add(Component.translatable("kamenridercraft.name."+Rider));

		// To the person who tries to decipher this code: good luck :P
		if (Show_belt_form_info && formItem2!= GeatsRiderItems.ONENESS_RAISE_BUCKLE.get()) {
			if((formItem2== ModdedItemCore.BLANK_FORM.get()||formItem2== GeatsRiderItems.GIGANT_CONTAINER_BUCKLE.get())&&(formItem3== ModdedItemCore.BLANK_FORM.get()||formItem3== GeatsRiderItems.GIGANT_CONTAINER_BUCKLE.get())) {
				tooltipComponents.add(Component.literal(Component.translatable(formItem.toString() + ".form").getString()
						+ (formItem== GeatsRiderItems.JYAMASHIN_WISH_CARD.get() ? " " + Component.translatable("kamenridercraft:form.jyamashin").getString() : "")));
			} else if (isFever(stack, Rider)||isGoldenFever(stack, Rider)) {
				tooltipComponents.add(Component.literal(Component.translatable("kamenridercraft.name.form").getString() + " "
						+ (Component.translatable("kamenridercraft:feverslot_raise_buckle.form").getString() + " ")
						+ (isArmedBuckle(formItem3)? Component.translatable("kamenridercraft:form.armed").getString() + " ": "")
						+ (formItem3!= ModdedItemCore.BLANK_FORM.get() ? Component.translatable(formItem3.toString() + ".form").getString() + " " : " ")
						+ Component.translatable("kamenridercraft:form.form").getString()
						+ (formItem== GeatsRiderItems.JYAMASHIN_WISH_CARD.get() ? " " + Component.translatable("kamenridercraft:form.jyamashin").getString() : "")));
			} else if (isRaising(stack, Rider)) {
				if (formItem3== GeatsRiderItems.COMMAND_TWIN_BUCKLE_CANNON_l.get())
					tooltipComponents.add(Component.literal(Component.translatable("kamenridercraft.name.form").getString() + " "
							+ Component.translatable("kamenridercraft:command_twin_buckle_cannon.form_jet_mode").getString()));
				else if (formItem2== GeatsRiderItems.COMMAND_TWIN_BUCKLE_CANNON.get())
					tooltipComponents.add(Component.literal(Component.translatable("kamenridercraft.name.form").getString() + " "
							+ Component.translatable("kamenridercraft:command_twin_buckle_cannon.form_cannon_mode").getString()));
				else tooltipComponents.add(Component.literal(Component.translatable("kamenridercraft.name.form").getString() + " "
							+ Component.translatable("kamenridercraft:command_twin_buckle_jet.form").getString() + (isArmedBuckle(formItem2)||isArmedBuckle(formItem3)? " " + Component.translatable("kamenridercraft:form.armed").getString() + " ": "")
							+ (formItem2== ModdedItemCore.BLANK_FORM.get()||formItem3== ModdedItemCore.BLANK_FORM.get() ? " "
							: (formItem2== GeatsRiderItems.COMMAND_TWIN_BUCKLE_JET.get() ? Component.translatable(formItem3.toString() + ".form").getString() + " "
							: Component.translatable(formItem2.toString() + ".form").getString() + " "))
							+ Component.translatable("kamenridercraft:form.form").getString()));
			} else if (formItem2== GeatsRiderItems.BOOST_MKII_RAISE_BUCKLE.get()) tooltipComponents.add(Component.literal(Component.translatable("kamenridercraft.name.form").getString()+" "+Component.translatable("kamenridercraft:boost_mkii_raise_buckle.form").getString()));
			else if (formItem2== GeatsRiderItems.UNITE_GRIP.get()) tooltipComponents.add(Component.literal(Component.translatable("kamenridercraft.name.form").getString()+" "+Component.translatable("kamenridercraft:unite_grip.form").getString()));
			else if (formItem2== GeatsRiderItems.BOOST_MKIII_RAISE_BUCKLE.get()&&formItem3== GeatsRiderItems.BOOST_MKIII_RAISE_BUCKLE.get()) tooltipComponents.add(Component.literal(Component.translatable("kamenridercraft.name.form").getString()+" "+Component.translatable("kamenridercraft:boost_mkiii_raise_buckle.form_ix").getString()));
			else if (formItem3== GeatsRiderItems.BUJIN_SWORD_RAISE_BUCKLE.get()){
				tooltipComponents.add(Component.literal(Component.translatable("kamenridercraft.name.form").getString() + " "
						+ (formItem2!= ModdedItemCore.BLANK_FORM.get() ? (Component.translatable("kamenridercraft:bujin_sword_raise_buckle.form_r").getString()+" "+Component.translatable(formItem2.toString() + ".form").getString())
						: Component.translatable(formItem3 + ".form").getString())
						+ " " + Component.translatable("kamenridercraft:form.form").getString()));
			} else {
				tooltipComponents.add(Component.literal(Component.translatable("kamenridercraft.name.form").getString() + " "
						+ (isArmedBuckle(formItem2)? Component.translatable("kamenridercraft:form.armed").getString() + " " : "")
						+ (formItem2!= ModdedItemCore.BLANK_FORM.get()&&formItem2!= GeatsRiderItems.GIGANT_CONTAINER_BUCKLE.get() ? (Component.translatable(formItem2.toString() + ".form").getString() + (formItem3== ModdedItemCore.BLANK_FORM.get()||formItem3== GeatsRiderItems.GIGANT_CONTAINER_BUCKLE.get()||isArmedBuckle(formItem3)||isArmedBuckle(formItem2)? " " : "")) : "")
						+ (isArmedBuckle(formItem3)&&!isArmedBuckle(formItem2) ? Component.translatable("kamenridercraft:form.armed").getString() + " ":"")
						+ (formItem3!= ModdedItemCore.BLANK_FORM.get()&&formItem3!= GeatsRiderItems.GIGANT_CONTAINER_BUCKLE.get() ? Component.translatable(formItem3.toString() + ".form").getString() + " " : "")
						+ Component.translatable("kamenridercraft:form.form").getString()
						+ (formItem2== GeatsRiderItems.BOOST_MKIII_RAISE_BUCKLE.get()||formItem3== GeatsRiderItems.BOOST_MKIII_RAISE_BUCKLE.get() ? " " + Component.translatable("kamenridercraft:form.mkiii").getString() : "")
						+ (formItem== GeatsRiderItems.JYAMASHIN_WISH_CARD.get() ? " " + Component.translatable("kamenridercraft:form.jyamashin").getString() : "")));
			}
		}
		super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
	}

	@Override
	public String getText(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName)
	{
        boolean fly = rider.getAttribute(Attributes.WINGS_OUT).getBaseValue()==1;

		boolean isBujin= getFormItem(itemstack, 2) == GeatsRiderItems.MONSTER_RAISE_BUCKLE.get() || getFormItem(itemstack, 2) == GeatsRiderItems.BOOST_RAISE_BUCKLE.get() || getFormItem(itemstack, 2) == ModdedItemCore.BLANK_FORM.get();

		if (equipmentSlot == EquipmentSlot.FEET) {


			String belt = ((RiderDriverItem)itemstack.getItem()).BELT_TEXT;
			if (getFormItem(itemstack,2)== GeatsRiderItems.REVICE_DRIVER_RAISE_BUCKLE.get()) {
				belt = "revice_driver_belt";
			} else if (getFormItem(itemstack,2)== GeatsRiderItems.REVICE_DRIVER_RAISE_BUCKLE_VICE.get()) {
				belt = "buddy_buckle_belt";
			} else if (((RiderDriverItem)itemstack.getItem()).BELT_TEXT==null) {
				belt = getFormItem(itemstack,1).getBeltTex();
			}
			return "belts/"+belt;

		}

		else if (equipmentSlot == EquipmentSlot.HEAD& getFormItem(itemstack,3)== GeatsRiderItems.PLOSION_RAGE_RAISE_BUCKLE.get()) return riderName+"_base_over_plosion_rage";

		else if (equipmentSlot == EquipmentSlot.HEAD&isRaising(itemstack,riderName)) return riderName+"_base_over_raising"+ getFormItem(itemstack,1).getFormName(fly);
		else if (equipmentSlot == EquipmentSlot.HEAD&isFever(itemstack,riderName)) return riderName+"_base_over_fever"+ getFormItem(itemstack,1).getFormName(fly);

		else if (equipmentSlot == EquipmentSlot.HEAD& getFormItem(itemstack,2)== GeatsRiderItems.ONENESS_RAISE_BUCKLE.get()) return riderName+"_base_over_oneness";

		else if (equipmentSlot == EquipmentSlot.HEAD& getFormItem(itemstack,3)== GeatsRiderItems.BUJIN_SWORD_RAISE_BUCKLE.get()) return riderName+"_base_over_bujin";

		else if (equipmentSlot == EquipmentSlot.HEAD& getFormItem(itemstack,2)== GeatsRiderItems.BOOST_MKII_RAISE_BUCKLE.get()) return riderName+"_base_over_boost_mkii";
		else if (equipmentSlot == EquipmentSlot.HEAD& getFormItem(itemstack,2)== GeatsRiderItems.UNITE_GRIP.get()) return "geats_base_over_laser_boost";
		else if (equipmentSlot == EquipmentSlot.CHEST& getFormItem(itemstack,2)== ModdedItemCore.BLANK_FORM.get()&& Objects.equals(getFormItem(itemstack, 3).getFormName(fly), "_jyamato")) return "geats_rider_jyamato_no_belt";

		else if (equipmentSlot == EquipmentSlot.CHEST& getFormItem(itemstack,2)== GeatsRiderItems.MAGNUM_RAISE_BUCKLE.get()&& getFormItem(itemstack,1)== GeatsRiderItems.GEATS_CORE_ID_OSAKA.get()) return "geats_rider_magnum_osaka";
		else if (equipmentSlot == EquipmentSlot.CHEST& getFormItem(itemstack,2)== GeatsRiderItems.MAGNUM_RAISE_BUCKLE.get()&& getFormItem(itemstack,1)== GeatsRiderItems.GEATS_CORE_ID_FUKUOKA.get()) return "geats_rider_magnum_fukuoka";
		else if (equipmentSlot == EquipmentSlot.CHEST& getFormItem(itemstack,2)== GeatsRiderItems.MAGNUM_RAISE_BUCKLE.get()&& getFormItem(itemstack,1)== GeatsRiderItems.GEATS_CORE_ID_NAGOYA.get()) return "geats_rider_magnum_nagoya";
		else if (equipmentSlot == EquipmentSlot.CHEST& getFormItem(itemstack,2)== GeatsRiderItems.MAGNUM_RAISE_BUCKLE.get()&& getFormItem(itemstack,1)== GeatsRiderItems.GEATS_CORE_ID_TOKYO.get()) return "geats_rider_magnum_tokyo";


		else if (equipmentSlot == EquipmentSlot.HEAD& getFormItem(itemstack,3)== GeatsRiderItems.BOOST_MKIII_RAISE_BUCKLE.get()&& getFormItem(itemstack,2)== GeatsRiderItems.BOOST_MKIII_RAISE_BUCKLE.get()) return riderName+"_ix_base_over";
		else if (equipmentSlot == EquipmentSlot.CHEST& getFormItem(itemstack,2)== GeatsRiderItems.BOOST_MKIII_RAISE_BUCKLE.get()&& getFormItem(itemstack,3)== GeatsRiderItems.BOOST_MKIII_RAISE_BUCKLE.get()) return "geats_rider_geats_ix";
		else if (equipmentSlot == EquipmentSlot.LEGS& getFormItem(itemstack,3)== GeatsRiderItems.BOOST_MKIII_RAISE_BUCKLE.get()&& getFormItem(itemstack,2)== GeatsRiderItems.BOOST_MKIII_RAISE_BUCKLE.get()) return "geats_rider_geats_ix_2";

		else if (equipmentSlot == EquipmentSlot.LEGS& getFormItem(itemstack,3)== GeatsRiderItems.BOOST_MKII_RAISE_BUCKLE.get()&& getFormItem(itemstack,2)== GeatsRiderItems.UNITE_GRIP.get()) return "geats_rider_laser_boost_2";

		else if (equipmentSlot == EquipmentSlot.CHEST& getFormItem(itemstack,2)== ModdedItemCore.BLANK_FORM.get()&& getFormItem(itemstack,3)== GeatsRiderItems.PLOSION_RAGE_RAISE_BUCKLE.get())  return "geats_rider_plosion_rage";
		else if (equipmentSlot == EquipmentSlot.CHEST& getFormItem(itemstack,2)== ModdedItemCore.BLANK_FORM.get()&& getFormItem(itemstack,3)== GeatsRiderItems.PLOSION_RAGE_RAISE_BUCKLE.get())  return "geats_rider_plosion_rage";

		else if (equipmentSlot == EquipmentSlot.CHEST& getFormItem(itemstack,2)== ModdedItemCore.BLANK_FORM.get()&& getFormItem(itemstack,3)== GeatsRiderItems.BUJIN_SWORD_RAISE_BUCKLE.get())  return "geats_rider_bujin_sword_top";
		else if (equipmentSlot == EquipmentSlot.CHEST& getFormItem(itemstack,3)== GeatsRiderItems.BUJIN_SWORD_RAISE_BUCKLE.get()&isBujin)  return "geats_rider"+ getFormItem(itemstack,2).getFormName(fly)+"_bujin_sword";
		else if (equipmentSlot == EquipmentSlot.LEGS& getFormItem(itemstack,2)!= ModdedItemCore.BLANK_FORM.get()&& getFormItem(itemstack,3)== GeatsRiderItems.BUJIN_SWORD_RAISE_BUCKLE.get())  return "geats_rider_bujin_sword_combo";

		else if (equipmentSlot == EquipmentSlot.LEGS& getFormItem(itemstack,3)== GeatsRiderItems.XGEATS_RAISE_BUCKLE.get()&& getFormItem(itemstack,2)== GeatsRiderItems.XGEATS_RAISE_BUCKLE.get()) return "geats_rider_x_geats_2";
		else if (equipmentSlot == EquipmentSlot.LEGS& getFormItem(itemstack,3)== GeatsRiderItems.DOOMS_GEATS_RAISE_BUCKLE.get()&& getFormItem(itemstack,2)== GeatsRiderItems.DOOMS_GEATS_RAISE_BUCKLE.get()) return "geats_rider_dooms_geats_2";

		else if (equipmentSlot == EquipmentSlot.CHEST& getFormItem(itemstack,2)== GeatsRiderItems.COMMAND_TWIN_BUCKLE_JET.get()&& getFormItem(itemstack,3)== GeatsRiderItems.COMMAND_TWIN_BUCKLE_CANNON_l.get()) return "geats_rider_jet";
		else if (equipmentSlot == EquipmentSlot.LEGS& getFormItem(itemstack,3)== GeatsRiderItems.COMMAND_TWIN_BUCKLE_JET.get()&& getFormItem(itemstack,2)== GeatsRiderItems.COMMAND_TWIN_BUCKLE_CANNON.get()) return "geats_rider_jet";
		else if (equipmentSlot == EquipmentSlot.LEGS& getFormItem(itemstack,2)== GeatsRiderItems.BOOST_MKII_RAISE_BUCKLE.get()) return "geats_rider_boost_mkii_nobelt";

		else if (getFormItem(itemstack,2)== GeatsRiderItems.REVICE_DRIVER_RAISE_BUCKLE.get()) {
			if (equipmentSlot == EquipmentSlot.HEAD) return "revi";
			return "geats_rider_revi";
		} else if (getFormItem(itemstack,2)== GeatsRiderItems.REVICE_DRIVER_RAISE_BUCKLE_VICE.get()) {
			if (equipmentSlot == EquipmentSlot.HEAD) return "vice";
			return "geats_rider_vice";
		}

		else if (equipmentSlot == EquipmentSlot.HEAD) return riderName+"_base_over"+ getFormItem(itemstack,1).getFormName(fly);
		else if (equipmentSlot == EquipmentSlot.CHEST) return "geats_rider"+ getFormItem(itemstack,2).getFormName(fly);
		else return "geats_rider"+ getFormItem(itemstack,3).getFormName(fly);

	}

	public  boolean isArmedBuckle(Item item) {
		return (item== GeatsRiderItems.HAMMER_RAISE_BUCKLE.get() || item== GeatsRiderItems.WATER_RAISE_BUCKLE.get()
				|| item== GeatsRiderItems.ARROW_RAISE_BUCKLE.get() || item== GeatsRiderItems.SHIELD_RAISE_BUCKLE.get()
				|| item== GeatsRiderItems.PROPELLER_RAISE_BUCKLE.get() || item== GeatsRiderItems.DRILL_RAISE_BUCKLE.get()
				|| item== GeatsRiderItems.CHAIN_ARRAY_RAISE_BUCKLE.get() || item== GeatsRiderItems.CLAW_RAISE_BUCKLE.get()
				|| item== GeatsRiderItems.HAMMER_RAISE_BUCKLE_FEVER.get() || item== GeatsRiderItems.WATER_RAISE_BUCKLE_FEVER.get()
				|| item== GeatsRiderItems.ARROW_RAISE_BUCKLE_FEVER.get() || item== GeatsRiderItems.SHIELD_RAISE_BUCKLE_FEVER.get()
				|| item== GeatsRiderItems.PROPELLER_RAISE_BUCKLE_FEVER.get() || item== GeatsRiderItems.DRILL_RAISE_BUCKLE_FEVER.get()
				|| item== GeatsRiderItems.CHAIN_ARRAY_RAISE_BUCKLE_FEVER.get() || item== GeatsRiderItems.CLAW_RAISE_BUCKLE_FEVER.get());
	}

	public  boolean isGoldenFever(ItemStack itemstack,String riderName) {

		if (CanFever(riderName)) {
			if (getFormItem(itemstack,2)== GeatsRiderItems.HAMMER_RAISE_BUCKLE_FEVER.get()& getFormItem(itemstack,3)== GeatsRiderItems.HAMMER_RAISE_BUCKLE.get()) return true;
			if (getFormItem(itemstack,2)== GeatsRiderItems.WATER_RAISE_BUCKLE_FEVER.get()& getFormItem(itemstack,3)== GeatsRiderItems.WATER_RAISE_BUCKLE.get()) return true;
			if (getFormItem(itemstack,2)== GeatsRiderItems.ARROW_RAISE_BUCKLE_FEVER.get()& getFormItem(itemstack,3)== GeatsRiderItems.ARROW_RAISE_BUCKLE.get()) return true;
			if (getFormItem(itemstack,2)== GeatsRiderItems.SHIELD_RAISE_BUCKLE_FEVER.get()& getFormItem(itemstack,3)== GeatsRiderItems.SHIELD_RAISE_BUCKLE.get()) return true;
			if (getFormItem(itemstack,2)== GeatsRiderItems.CHAIN_ARRAY_RAISE_BUCKLE_FEVER.get()& getFormItem(itemstack,3)== GeatsRiderItems.CHAIN_ARRAY_RAISE_BUCKLE.get()) return true;
			if (getFormItem(itemstack,2)== GeatsRiderItems.CLAW_RAISE_BUCKLE_FEVER.get()& getFormItem(itemstack,3)== GeatsRiderItems.CLAW_RAISE_BUCKLE.get()) return true;
			if (getFormItem(itemstack,2)== GeatsRiderItems.DRILL_RAISE_BUCKLE_FEVER.get()& getFormItem(itemstack,3)== GeatsRiderItems.DRILL_RAISE_BUCKLE.get()) return true;
			if (getFormItem(itemstack,2)== GeatsRiderItems.PROPELLER_RAISE_BUCKLE_FEVER.get()& getFormItem(itemstack,3)== GeatsRiderItems.PROPELLER_RAISE_BUCKLE.get()) return true;

			if (getFormItem(itemstack,2)== GeatsRiderItems.HAMMER_RAISE_BUCKLE.get()& getFormItem(itemstack,3)== GeatsRiderItems.HAMMER_RAISE_BUCKLE_FEVER.get()) return true;
			if (getFormItem(itemstack,2)== GeatsRiderItems.WATER_RAISE_BUCKLE.get()& getFormItem(itemstack,3)== GeatsRiderItems.WATER_RAISE_BUCKLE_FEVER.get()) return true;
			if (getFormItem(itemstack,2)== GeatsRiderItems.ARROW_RAISE_BUCKLE.get()& getFormItem(itemstack,3)== GeatsRiderItems.ARROW_RAISE_BUCKLE_FEVER.get()) return true;
			if (getFormItem(itemstack,2)== GeatsRiderItems.SHIELD_RAISE_BUCKLE.get()& getFormItem(itemstack,3)== GeatsRiderItems.SHIELD_RAISE_BUCKLE_FEVER.get()) return true;
			if (getFormItem(itemstack,2)== GeatsRiderItems.CHAIN_ARRAY_RAISE_BUCKLE.get()& getFormItem(itemstack,3)== GeatsRiderItems.CHAIN_ARRAY_RAISE_BUCKLE_FEVER.get()) return true;
			if (getFormItem(itemstack,2)== GeatsRiderItems.CLAW_RAISE_BUCKLE.get()& getFormItem(itemstack,3)== GeatsRiderItems.CLAW_RAISE_BUCKLE_FEVER.get()) return true;
			if (getFormItem(itemstack,2)== GeatsRiderItems.DRILL_RAISE_BUCKLE.get()& getFormItem(itemstack,3)== GeatsRiderItems.DRILL_RAISE_BUCKLE_FEVER.get()) return true;
			return getFormItem(itemstack, 2) == GeatsRiderItems.PROPELLER_RAISE_BUCKLE.get() & getFormItem(itemstack, 3) == GeatsRiderItems.PROPELLER_RAISE_BUCKLE_FEVER.get();

		}
		return false;
	}

	public  boolean isFever(ItemStack itemstack,String riderName) {

		if (CanFever(riderName)) {
			if (getFormItem(itemstack,2)== GeatsRiderItems.BOOST_RAISE_BUCKLE_FEVER.get()& getFormItem(itemstack,3)== GeatsRiderItems.BOOST_RAISE_BUCKLE.get()) return true;
			if (getFormItem(itemstack,2)== GeatsRiderItems.MAGNUM_RAISE_BUCKLE_FEVER.get()& getFormItem(itemstack,3)== GeatsRiderItems.MAGNUM_RAISE_BUCKLE.get()) return true;
			if (getFormItem(itemstack,2)== GeatsRiderItems.ZOMBIE_RAISE_BUCKLE_FEVER.get()& getFormItem(itemstack,3)== GeatsRiderItems.ZOMBIE_RAISE_BUCKLE.get()) return true;
			if (getFormItem(itemstack,2)== GeatsRiderItems.NINJA_RAISE_BUCKLE_FEVER.get()& getFormItem(itemstack,3)== GeatsRiderItems.NINJA_RAISE_BUCKLE.get()) return true;
			if (getFormItem(itemstack,2)== GeatsRiderItems.BEAT_RAISE_BUCKLE_FEVER.get()& getFormItem(itemstack,3)== GeatsRiderItems.BEAT_RAISE_BUCKLE.get()) return true;
			if (getFormItem(itemstack,2)== GeatsRiderItems.MONSTER_RAISE_BUCKLE_FEVER.get()& getFormItem(itemstack,3)== GeatsRiderItems.MONSTER_RAISE_BUCKLE.get()) return true;

			if (getFormItem(itemstack,2)== GeatsRiderItems.BOOST_RAISE_BUCKLE.get()& getFormItem(itemstack,3)== GeatsRiderItems.BOOST_RAISE_BUCKLE_FEVER.get()) return true;
			if (getFormItem(itemstack,2)== GeatsRiderItems.MAGNUM_RAISE_BUCKLE.get()& getFormItem(itemstack,3)== GeatsRiderItems.MAGNUM_RAISE_BUCKLE_FEVER.get()) return true;
			if (getFormItem(itemstack,2)== GeatsRiderItems.ZOMBIE_RAISE_BUCKLE.get()& getFormItem(itemstack,3)== GeatsRiderItems.ZOMBIE_RAISE_BUCKLE_FEVER.get()) return true;
			if (getFormItem(itemstack,2)== GeatsRiderItems.NINJA_RAISE_BUCKLE.get()& getFormItem(itemstack,3)== GeatsRiderItems.NINJA_RAISE_BUCKLE_FEVER.get()) return true;
			if (getFormItem(itemstack,2)== GeatsRiderItems.BEAT_RAISE_BUCKLE.get()& getFormItem(itemstack,3)== GeatsRiderItems.BEAT_RAISE_BUCKLE_FEVER.get()) return true;
			return getFormItem(itemstack, 2) == GeatsRiderItems.MONSTER_RAISE_BUCKLE.get() & getFormItem(itemstack, 3) == GeatsRiderItems.MONSTER_RAISE_BUCKLE_FEVER.get();
		}
		return false;
	}

	public  boolean isRaising(ItemStack itemstack,String riderName) {
		return getFormItem(itemstack, 2) == GeatsRiderItems.COMMAND_TWIN_BUCKLE_JET.get() || getFormItem(itemstack, 3) == GeatsRiderItems.COMMAND_TWIN_BUCKLE_JET.get();
	}


	public Boolean CanFever(String rider) {
		String[] feverRiderList = GeatsRiderItems.FeverUsers;
		for (String s : feverRiderList) {
			if (Objects.equals(s, rider)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public void onFormChange(ItemStack belt, LivingEntity player, CompoundTag tag) {

		if (getFormItem(belt,2)== GeatsRiderItems.COMMAND_TWIN_BUCKLE_CANNON.get()& getFormItem(belt,3)!= GeatsRiderItems.COMMAND_TWIN_BUCKLE_JET.get())
            setFormItem(belt, ModdedItemCore.BLANK_FORM.get(), 2);
		if (getFormItem(belt,3)== GeatsRiderItems.COMMAND_TWIN_BUCKLE_CANNON_l.get()& getFormItem(belt,2)!= GeatsRiderItems.COMMAND_TWIN_BUCKLE_JET.get())
            setFormItem(belt, ModdedItemCore.BLANK_FORM.get(), 3);

		if (getFormItem(belt,1)== GeatsRiderItems.JYAMASHIN_WISH_CARD.get()& getFormItem(belt,2)== GeatsRiderItems.COMMAND_TWIN_BUCKLE_JET.get())
            setFormItem(belt, GeatsRiderItems.BUFFA_CORE_ID.get(), 1);
		if (getFormItem(belt,1)== GeatsRiderItems.JYAMASHIN_WISH_CARD.get()& getFormItem(belt,3)== GeatsRiderItems.COMMAND_TWIN_BUCKLE_JET.get())
            setFormItem(belt, GeatsRiderItems.BUFFA_CORE_ID.get(), 1);

		if (getFormItem(belt,2)== GeatsRiderItems.BOOST_MKII_RAISE_BUCKLE.get()& getFormItem(belt,3)!= ModdedItemCore.BLANK_FORM.get())
            setFormItem(belt, ModdedItemCore.BLANK_FORM.get(), 2);

		if (getFormItem(belt,3)== GeatsRiderItems.BOOST_MKII_RAISE_BUCKLE.get()& getFormItem(belt,2)!= GeatsRiderItems.UNITE_GRIP.get())
            setFormItem(belt, ModdedItemCore.BLANK_FORM.get(), 3);
		if (getFormItem(belt,2)== GeatsRiderItems.UNITE_GRIP.get()& getFormItem(belt,3)!= GeatsRiderItems.BOOST_MKII_RAISE_BUCKLE.get())
            setFormItem(belt, ModdedItemCore.BLANK_FORM.get(), 2);

		if (getFormItem(belt,2)== GeatsRiderItems.ONENESS_RAISE_BUCKLE.get()& getFormItem(belt,3)!= GeatsRiderItems.BOOST_MKIII_RAISE_BUCKLE.get())
            setFormItem(belt, ModdedItemCore.BLANK_FORM.get(), 2);

		if (getFormItem(belt,1)== GeatsRiderItems.GEATS_CORE_ID_OSAKA.get()& getFormItem(belt,2)!= GeatsRiderItems.MAGNUM_RAISE_BUCKLE.get())
            setFormItem(belt, GeatsRiderItems.GEATS_CORE_ID.get(), 1);
		if (getFormItem(belt,1)== GeatsRiderItems.GEATS_CORE_ID_FUKUOKA.get()& getFormItem(belt,2)!= GeatsRiderItems.MAGNUM_RAISE_BUCKLE.get())
            setFormItem(belt, GeatsRiderItems.GEATS_CORE_ID.get(), 1);
		if (getFormItem(belt,1)== GeatsRiderItems.GEATS_CORE_ID_NAGOYA.get()& getFormItem(belt,2)!= GeatsRiderItems.MAGNUM_RAISE_BUCKLE.get())
            setFormItem(belt, GeatsRiderItems.GEATS_CORE_ID.get(), 1);
		if (getFormItem(belt,1)== GeatsRiderItems.GEATS_CORE_ID_TOKYO.get()& getFormItem(belt,2)!= GeatsRiderItems.MAGNUM_RAISE_BUCKLE.get())
            setFormItem(belt, GeatsRiderItems.GEATS_CORE_ID.get(), 1);

		if (getFormItem(belt,1)== GeatsRiderItems.GEATS_CORE_ID_OSAKA.get()& getFormItem(belt,3)!= GeatsRiderItems.BOOST_RAISE_BUCKLE.get())
            setFormItem(belt, GeatsRiderItems.GEATS_CORE_ID.get(), 1);
		if (getFormItem(belt,1)== GeatsRiderItems.GEATS_CORE_ID_FUKUOKA.get()& getFormItem(belt,3)!= GeatsRiderItems.BOOST_RAISE_BUCKLE.get())
            setFormItem(belt, GeatsRiderItems.GEATS_CORE_ID.get(), 1);
		if (getFormItem(belt,1)== GeatsRiderItems.GEATS_CORE_ID_NAGOYA.get()& getFormItem(belt,3)!= GeatsRiderItems.BOOST_RAISE_BUCKLE.get())
            setFormItem(belt, GeatsRiderItems.GEATS_CORE_ID.get(), 1);
		if (getFormItem(belt,1)== GeatsRiderItems.GEATS_CORE_ID_TOKYO.get()& getFormItem(belt,3)!= GeatsRiderItems.BOOST_RAISE_BUCKLE.get())
            setFormItem(belt, GeatsRiderItems.GEATS_CORE_ID.get(), 1);

		boolean isBujin= true;
		if (getFormItem(belt,2)== GeatsRiderItems.BOOST_RAISE_BUCKLE.get()) isBujin = false;
		else if (getFormItem(belt,2)== GeatsRiderItems.MONSTER_RAISE_BUCKLE.get())  isBujin = false;
		else if (getFormItem(belt,2)== ModdedItemCore.BLANK_FORM.get())  isBujin = false;

		if (getFormItem(belt,3)== GeatsRiderItems.BUJIN_SWORD_RAISE_BUCKLE.get()&isBujin) setFormItem(belt, ModdedItemCore.BLANK_FORM.get(), 3);

		if (getFormItem(belt,3)== GeatsRiderItems.PLOSION_RAGE_RAISE_BUCKLE.get()& getFormItem(belt,2)!= ModdedItemCore.BLANK_FORM.get())
            setFormItem(belt, ModdedItemCore.BLANK_FORM.get(), 3);

		if (getFormItem(belt,2)== GeatsRiderItems.REVICE_DRIVER_RAISE_BUCKLE.get()& getFormItem(belt,3)!= ModdedItemCore.BLANK_FORM.get())
            setFormItem(belt, ModdedItemCore.BLANK_FORM.get(), 2);
		if (getFormItem(belt,2)== GeatsRiderItems.REVICE_DRIVER_RAISE_BUCKLE_VICE.get()& getFormItem(belt,3)!= ModdedItemCore.BLANK_FORM.get())
            setFormItem(belt, ModdedItemCore.BLANK_FORM.get(), 2);
		super.onFormChange(belt, player, tag);
	}


	@Override
	public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
		super.inventoryTick(stack,level,entity,slotId,isSelected);

		if (entity instanceof LivingEntity player) {
			if (isTransformed(player)) {
				if (getFormItem(stack, 2) == GeatsRiderItems.BOOST_MKII_RAISE_BUCKLE.get()) player.addEffect(new MobEffectInstance(MobEffects.HUNGER, 40, 2,true,false));
				boolean Fever=  isFever(stack,this.Rider);
				if (getFormItem(stack,2)== GeatsRiderItems.BOOST_MKIII_RAISE_BUCKLE.get()& getFormItem(stack,3)== GeatsRiderItems.BOOST_MKIII_RAISE_BUCKLE.get())  Fever= true;

				for (int n = 0; n < Num_Base_Form_Item; n++) {
					List<MobEffectInstance> potionEffectList = getFormItem(player.getItemBySlot(EquipmentSlot.FEET), n + 1).getPotionEffectList();
					for (MobEffectInstance effect : potionEffectList) {
						player.addEffect(new MobEffectInstance(effect.getEffect(),effect.getDuration(), effect.getAmplifier() + (Fever ? 2 : 0),true,false));	}

				}
			}
		}
	}


	public  boolean getGlowForSlot(ItemStack itemstack,EquipmentSlot currentSlot, LivingEntity livingEntity) {

		if (currentSlot== EquipmentSlot.FEET) {
			return getFormItem(itemstack, 1).getIsBeltGlowing();
		}
		if (isTransformed(livingEntity)){
			switch (currentSlot) {
				case HEAD ->{

					return true;
				}
				case CHEST -> {
					return (getFormItem(itemstack, 2)!= GeatsRiderItems.OUJA_V_BUCKLE_RAISE_BUCKLE.asItem());
				}
				case LEGS -> {
					return false;
				}
				default -> {}
			}
			return false;
		}
		return false;
	}

	public ResourceLocation getModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
		int num = 1;
		if (slot == EquipmentSlot.CHEST)num=2;
		if (slot == EquipmentSlot.LEGS)num=3;

		if (slot == EquipmentSlot.CHEST) {
			if (Objects.equals(getFormItem(itemstack, num).getModel(this.Rider), "default.geo.json"))return  ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/geats_rider_plusbelt.geo.json");
			else return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/"+ getFormItem(itemstack, num).getModel("geats_rider"));

		}else if (slot == EquipmentSlot.LEGS) {
			if (Objects.equals(getFormItem(itemstack, num).getModel(this.Rider), "default.geo.json"))return  ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/revo_geats_rider_plusbelt.geo.json");
			else return  ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/revo_"+ getFormItem(itemstack, num).getModel("geats_rider"));

		}else
		if (itemstack.getItem()== GeatsRiderItems.DESIRE_DRIVER_PUNKJACK.asItem()||itemstack.getItem()== GeatsRiderItems.DESIRE_DRIVER_SHIROWE.asItem()||itemstack.getItem()== GeatsRiderItems.DESIRE_DRIVER_DA_PAAN.asItem()) return  ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/punkjack_base_over.geo.json");
		if (itemstack.getItem()== GeatsRiderItems.DESIRE_DRIVER_BUFFA.asItem()) return  ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/buffa.geo.json");
		if (getFormItem(itemstack,3)== GeatsRiderItems.BOOST_MKIII_RAISE_BUCKLE.get()&& getFormItem(itemstack,2)== GeatsRiderItems.BOOST_MKIII_RAISE_BUCKLE.get()) return  ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/default_wings_armor.geo.json");
		if (getFormItem(itemstack,3)== GeatsRiderItems.BUJIN_SWORD_RAISE_BUCKLE.get()) return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/default_cape.geo.json");

		if (Objects.equals(getFormItem(itemstack, num).getModel(this.Rider), "default.geo.json"))return  ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/geats.geo.json");
		else return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/"+ getFormItem(itemstack, num).getModel(this.Rider));
	}


	@Override
	public  boolean getPartsForSlot(ItemStack itemstack,EquipmentSlot currentSlot,String  part) {

		switch (currentSlot) {
			case HEAD, LEGS ->{
				if (Objects.equals(part, "head")) return true;
				if (Objects.equals(part, "body")) return true;
				if (Objects.equals(part, "rightArm")) return true;
				if (Objects.equals(part, "leftArm")) return true;
				if (Objects.equals(part, "leftLeg")) return true;
				if (Objects.equals(part, "rightLeg")) return true;

			}
			case CHEST -> {
				if (Objects.equals(part, "head")) return true;
				if (Objects.equals(part, "body")) return true;
				if (Objects.equals(part, "rightArm")) return true;
				if (Objects.equals(part, "leftArm")) return true;

			}
			default -> {}
		}
		return false;
	}

}