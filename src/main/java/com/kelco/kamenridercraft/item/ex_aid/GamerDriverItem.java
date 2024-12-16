package com.kelco.kamenridercraft.item.ex_aid;

import com.google.common.collect.Lists;
import com.kelco.kamenridercraft.Config;
import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.summons.ParaDXSummonEntity;
import com.kelco.kamenridercraft.item.BaseItems.RiderArmorItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.Ex_Aid_Rider_Items;
import com.kelco.kamenridercraft.item.Modded_item_core;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;

public class GamerDriverItem extends RiderDriverItem {

    public GamerDriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties);

		Extra_Base_Form_Item= Lists.newArrayList((RiderFormChangeItem) Modded_item_core.BLANK_FORM.get(),(RiderFormChangeItem)Modded_item_core.BLANK_FORM.get());
		Num_Base_Form_Item=2;
	}

	public GamerDriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> armorFormItem,DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties)
	{
		super(material, rider, baseFormItem,armorFormItem, head, torso, legs, properties);

		Extra_Base_Form_Item= Lists.newArrayList((RiderFormChangeItem) Modded_item_core.BLANK_FORM.get(),(RiderFormChangeItem)Modded_item_core.BLANK_FORM.get());
		Num_Base_Form_Item=2;
	}


    public static boolean paradxSummoned(Player player) {
		for (ParaDXSummonEntity entity : player.level().getEntitiesOfClass(ParaDXSummonEntity.class,
						player.getBoundingBox().inflate(30), entity -> entity.getOwner() == player)) {
			if (entity != null) return true;
		}
        return false;
    }

	public void OnformChange(ItemStack itemstack, LivingEntity entity, CompoundTag tag) {
		if (Config.mightyBrotherSpawning && entity instanceof Player player && !paradxSummoned(player)
		&& itemstack.getItem() == Ex_Aid_Rider_Items.GAMER_DRIVER_EX_AID.get()
		&& (RiderDriverItem.get_Form_Item(itemstack, 1)==Ex_Aid_Rider_Items.MIGHTY_BROTHERS_XX_GASHAT_R.get()
		|| RiderDriverItem.get_Form_Item(itemstack, 1)==Ex_Aid_Rider_Items.KNOCK_OUT_FIGHTER_2_GASHAT.get())) {
			ParaDXSummonEntity paradx = MobsCore.PARADX_SUMMON.get().create(player.level());
			if (paradx != null) {
				paradx.moveTo(player.getX(), player.getY()+1, player.getZ(), player.getYRot(), player.getXRot());
				if (RiderDriverItem.get_Form_Item(itemstack, 1)==Ex_Aid_Rider_Items.KNOCK_OUT_FIGHTER_2_GASHAT.get()) {
					paradx.setItemSlot(EquipmentSlot.FEET, new ItemStack(Ex_Aid_Rider_Items.GAMER_DRIVER_PARA_DX.get()));
					RiderDriverItem.set_Form_Item(paradx.getItemBySlot(EquipmentSlot.FEET), Ex_Aid_Rider_Items.KNOCK_OUT_FIGHTER_2_GASHAT.get(), 1);
				}
				player.level().addFreshEntity(paradx);
				paradx.bindToPlayer(player);
			}
		}
		super.OnformChange(itemstack, entity, tag);
	}

	@Override
	public String GET_TEXT(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider,String riderName)
	{
		if (equipmentSlot == EquipmentSlot.FEET) {
			String belt = ((RiderDriverItem)itemstack.getItem()).BELT_TEXT;
			if (((RiderDriverItem)itemstack.getItem()).BELT_TEXT==null) {
			 belt = get_Form_Item(itemstack,1).getBeltTex();
			}
		
			if (itemstack.getItem()== Ex_Aid_Rider_Items.GASHACON_BUGVISOR_GENM.get()) {
				if(rider.getMainHandItem().getItem()==Ex_Aid_Rider_Items.GASHACON_BUGVISOR.get()||rider.getOffhandItem().getItem()==Ex_Aid_Rider_Items.GASHACON_BUGVISOR.get() ) belt="bugster_buckle";
				}
			if (itemstack.getItem()==Ex_Aid_Rider_Items.GASHACON_BUGVISOR_II_CHRONOS.get()||itemstack.getItem()==Ex_Aid_Rider_Items.GASHACON_BUGVISOR_II_CHRONICLE_BUGTER.get()
					||itemstack.getItem()==Ex_Aid_Rider_Items.GASHACON_BUGVISOR_II_POPPY.get()||itemstack.getItem()==Ex_Aid_Rider_Items.GASHACON_BUGVISOR_II_LAZER.get()) {
				if(rider.getMainHandItem().getItem()==Ex_Aid_Rider_Items.GASHACON_BUGVISOR_II.get()||rider.getOffhandItem().getItem()==Ex_Aid_Rider_Items.GASHACON_BUGVISOR_II.get() ) belt="bugster_buckle";
				}
			
			if(get_Form_Item(itemstack,1).get_Belt_Model()=="geo/lv_1_belt.geo.json") {
				if (!isTransformed(rider)) belt = get_Form_Item(itemstack,1).getBeltTex()+"_un";
			}
			
			return "belts/"+belt;
		}
		else if (equipmentSlot == EquipmentSlot.CHEST) return get_Form_Item(itemstack,2).getFormName(false);

		else {
			RiderDriverItem belt = ((RiderDriverItem)itemstack.getItem());
			if (belt==Ex_Aid_Rider_Items.GAMER_DRIVER_EX_AID.get()&get_Form_Item(itemstack,1)==Ex_Aid_Rider_Items.MIGHTY_ACTION_X_GASHAT_LV_1.get()
			&rider.hasEffect(Effect_core.CHRISTMAS)) {
				return riderName+"_lv1_christmas";
			}

			if (belt==Ex_Aid_Rider_Items.GAMER_DRIVER_SNIPE.get()) {
				if (get_Form_Item(itemstack,2)==Ex_Aid_Rider_Items.JET_COMBAT_GASHAT.get()||
						get_Form_Item(itemstack,2)==Ex_Aid_Rider_Items.BANG_BANG_TANK_GASHAT.get()||
						get_Form_Item(itemstack,2)==Ex_Aid_Rider_Items.XEVIOUS_GASHAT.get()) {
					return riderName+"_jet";
				}else 	if (get_Form_Item(itemstack,2)==Ex_Aid_Rider_Items.BANG_BANG_SIMULATION_GASHAT.get()) {
					return riderName+"_nocape";
				} 

			}
		}
		return riderName+get_Form_Item(itemstack,1).getFormName(false);


	}

	public ResourceLocation getBeltModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
		
		if(get_Form_Item(itemstack,1).get_Belt_Model()=="geo/lv_1_belt.geo.json" && !isTransformed(rider)) {
			return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"geo/riderbelt.geo.json");
		}
		
		return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, get_Form_Item(itemstack, 1).get_Belt_Model());
	}

	public  boolean getGlowForSlot(ItemStack itemstack,EquipmentSlot currentSlot, LivingEntity livingEntity) {

		if (currentSlot== EquipmentSlot.FEET) {
			return get_Form_Item(itemstack, 1).get_Is_Belt_Glowing();
		}
		if (isTransformed(livingEntity)){
			switch (currentSlot) {
				case HEAD ->{ 
					return get_Form_Item(itemstack, 1).get_Is_Glowing();
				}
				case CHEST -> {
					return get_Form_Item(itemstack, 2).get_Is_Glowing();
				}
				case LEGS -> {
					return get_Form_Item(itemstack, 1).get_Is_Glowing();
				}
				default -> {}
			}
			return false;
		}
		return false;
	}

	public ResourceLocation getModelResource(ItemStack itemstack,RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {

		if (slot == EquipmentSlot.CHEST) {
			if (get_Form_Item(itemstack, 2).HasWingsIfFlying() && rider instanceof Player player && player.getAbilities().flying == true){
				return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/"+get_Form_Item(itemstack, 2).get_FlyingModel());
			} else if (get_Form_Item(itemstack, 2).get_Model()=="default.geo.json") {
				return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/bigger_rider_plusbelt.geo.json");
			}
			return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/"+get_Form_Item(itemstack, 2).get_Model());
		}
		return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/"+get_Form_Item(itemstack, 1).get_Model());

	}

	@Override
	public  boolean getPartsForSlot(ItemStack itemstack,EquipmentSlot currentSlot,String  part) {

		switch (currentSlot) {
		case HEAD ->{ 
			if (part =="head") return true;
			if (part =="body") return true;
			if (part =="rightArm") return true;
			if (part =="leftArm") return true;
			if (part =="leftLeg") return true;
			if (part =="rightLeg") return true;

		}
		case CHEST -> {
			if (get_Form_Item(itemstack, 2)!=Modded_item_core.BLANK_FORM.get()) {
				if (part =="head") return true;
				if (part =="body") return true;
				if (part =="rightArm") return true;
				if (part =="leftArm") return true;
				if (part =="leftLeg") return true;
				if (part =="rightLeg") return true;
			}
		}
		case LEGS -> {}
		default -> {}
		}
		return false;
	}

}