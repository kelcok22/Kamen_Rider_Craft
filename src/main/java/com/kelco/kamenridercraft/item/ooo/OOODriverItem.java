package com.kelco.kamenridercraft.item.ooo;

import com.kelco.kamenridercraft.KamenRiderCraftCore;

import com.kelco.kamenridercraft.item.BaseItems.RiderArmorItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.OOO_Rider_Items;
import com.kelco.kamenridercraft.item.W_Rider_Items;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.List;

public class OOODriverItem extends RiderDriverItem {


	public OOODriverItem (Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Item.Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties);
		Has_basic_belt_info=false;
	}

	@Override
	public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {

		tooltipComponents.add(Component.translatable("kamenridercraft.name."+Rider));


		Item formItem = this.get_Form_Item(stack, 1);
		Item formItem2 = this.get_Form_Item(stack, 2);
		Item formItem3 = this.get_Form_Item(stack, 3);

	if (getCombo(formItem,formItem2,formItem3)!="false")tooltipComponents.add(Component.translatable("kamenridercraft:"+getCombo(formItem,formItem2,formItem3)+".form"));
		else if (!OOO_Rider_Items.SPECIAL_NAME_MEDALS.contains(formItem) || !OOO_Rider_Items.SPECIAL_NAME_MEDALS.contains(formItem2) || !OOO_Rider_Items.SPECIAL_NAME_MEDALS.contains(formItem3)) {
			tooltipComponents.add(Component.translatable("kamenridercraft:" + getCombo(formItem, formItem2, formItem3) + ".form"));
			tooltipComponents.add(Component.translatable(formItem.toString() + ".form"));
			tooltipComponents.add(Component.translatable(formItem2.toString() + ".form"));
			tooltipComponents.add(Component.translatable(formItem3.toString() + ".form"));
		} else {
			tooltipComponents.add(Component.literal(Component.translatable("kamenridercraft:false.form_special").getString()
			+ Component.translatable(formItem.toString() + ".form_special").getString()
			+ (formItem3 == OOO_Rider_Items.CHEETAH_MEDAL.get() ? Component.translatable(formItem2.toString() + ".form_cheetah").getString() : Component.translatable(formItem2.toString() + ".form_special").getString())
			+ Component.translatable(formItem3.toString() + ".form_special").getString()));
		}
		super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
	}

	public String getCombo (Item formItem,Item formItem2,Item formItem3) {
		if (formItem==OOO_Rider_Items.TAKA_MEDAL.get()&formItem2==OOO_Rider_Items.TORA_MEDAL.get()&formItem3==OOO_Rider_Items.BATTA_MEDAL.get() )return "tatoba";
		if (formItem==OOO_Rider_Items.SUPER_TAKA_MEDAL.get()&formItem2==OOO_Rider_Items.SUPER_TORA_MEDAL.get()&formItem3==OOO_Rider_Items.SUPER_BATTA_MEDAL.get() )return "super_tatoba";
		if (formItem==OOO_Rider_Items.TAKA_ANKH_MEDAL.get()&formItem2==OOO_Rider_Items.TORA_MEDAL.get()&formItem3==OOO_Rider_Items.BATTA_MEDAL.get() )return "tatoba";
		if (formItem==OOO_Rider_Items.TAKA_MEDAL.get()&formItem2==OOO_Rider_Items.KUJAKU_MEDAL.get()&formItem3==OOO_Rider_Items.CONDOR_MEDAL.get() )return "tajadol";
		if (formItem==OOO_Rider_Items.TAKA_ANKH_MEDAL.get()&formItem2==OOO_Rider_Items.KUJAKU_MEDAL.get()&formItem3==OOO_Rider_Items.CONDOR_MEDAL.get() )return "tajadol_fe";
		if (formItem==OOO_Rider_Items.TAKA_ETERNITY_MEDAL.get()&formItem2==OOO_Rider_Items.KUJAKU_ETERNITY_MEDAL.get()&formItem3==OOO_Rider_Items.CONDOR_ETERNITY_MEDAL.get() )return "tajadol_eternity";
		if (formItem==OOO_Rider_Items.LION_MEDAL.get()&formItem2==OOO_Rider_Items.TORA_MEDAL.get()&formItem3==OOO_Rider_Items.CHEETAH_MEDAL.get() )return "latorartar";
		if (formItem==OOO_Rider_Items.KUWAGATA_MEDAL.get()&formItem2==OOO_Rider_Items.KAMAKIRI_MEDAL.get()&formItem3==OOO_Rider_Items.BATTA_MEDAL.get() )return "gatakiriba";
		if (formItem==OOO_Rider_Items.SAI_MEDAL.get()&formItem2==OOO_Rider_Items.GORILLA_MEDAL.get()&formItem3==OOO_Rider_Items.ZOU_MEDAL.get() )return "sagohzo";
		if (formItem==OOO_Rider_Items.SHACHI_MEDAL.get()&formItem2==OOO_Rider_Items.UNAGI_MEDAL.get()&formItem3==OOO_Rider_Items.TAKO_MEDAL.get() )return "shauta";
		if (formItem==OOO_Rider_Items.PTERA_MEDAL.get()&formItem2==OOO_Rider_Items.TRICERA_MEDAL.get()&formItem3==OOO_Rider_Items.TYRANNO_MEDAL.get() )return "putotyra";
		if (formItem==OOO_Rider_Items.COBRA_MEDAL.get()&formItem2==OOO_Rider_Items.KAME_MEDAL.get()&formItem3==OOO_Rider_Items.WANI_MEDAL.get() )return "burakawani";
		if (formItem==OOO_Rider_Items.LOVE_CORE_MEDAL.get()&formItem2==OOO_Rider_Items.LOVE_CORE2_MEDAL.get()&formItem3==OOO_Rider_Items.LOVE_CORE3_MEDAL.get() )return "love";
		if (formItem==OOO_Rider_Items.SAME_MEDAL.get()&formItem2==OOO_Rider_Items.KUJIRA_MEDAL.get()&formItem3==OOO_Rider_Items.OOKAMIUO_MEDAL.get() )return "saramiuo";
		if (formItem==OOO_Rider_Items.EBI_NEW_MEDAL.get()&formItem2==OOO_Rider_Items.KANI_NEW_MEDAL.get()&formItem3==OOO_Rider_Items.SASORI_NEW_MEDAL.get() )return "bikaso";
		if (formItem==OOO_Rider_Items.SHIKA_MEDAL.get()&formItem2==OOO_Rider_Items.GAZELLE_MEDAL.get()&formItem3==OOO_Rider_Items.USHI_MEDAL.get() )return "shigazeshi";
		if (formItem==OOO_Rider_Items.MUKADE_MEDAL.get()&formItem2==OOO_Rider_Items.HACHI_MEDAL.get()&formItem3==OOO_Rider_Items.ARI_MEDAL.get() )return "mukachiri";
		if (formItem==OOO_Rider_Items.SEIUCHI_MEDAL.get()&formItem2==OOO_Rider_Items.SHIROKUMA_MEDAL.get()&formItem3==OOO_Rider_Items.PENGUIN_MEDAL.get() )return "seishirogin";
		if (formItem==OOO_Rider_Items.TAKA_MEDAL.get()&formItem2==OOO_Rider_Items.IMAGIN_MEDAL.get()&formItem3==OOO_Rider_Items.SHOCKER_MEDAL.get() )return "tamashiy";
		if (formItem==OOO_Rider_Items.TAKA_ANKH_MEDAL.get()&formItem2==OOO_Rider_Items.IMAGIN_MEDAL.get()&formItem3==OOO_Rider_Items.SHOCKER_MEDAL.get() )return "tamashiy";
		if (formItem==OOO_Rider_Items.HABATAKI_MEDAL.get()&formItem2==OOO_Rider_Items.TAIGA_MEDAL.get()&formItem3==OOO_Rider_Items.ICHIGO_MEDAL.get() )return "legend_tatoba";
		if (formItem==OOO_Rider_Items.MUKADE_GODA_MEDAL.get()&formItem2==OOO_Rider_Items.HACHI_GODA_MEDAL.get()&formItem3==OOO_Rider_Items.ARI_GODA_MEDAL.get() )return "goda";

		if (formItem==OOO_Rider_Items.ANCIENT_TAKA_MEDAL.get()&formItem2==OOO_Rider_Items.ANCIENT_TORA_MEDAL.get()&formItem3==OOO_Rider_Items.ANCIENT_BATTA_MEDAL.get() )return "ancient_tatoba";
		if (formItem==OOO_Rider_Items.ANCIENT_TAKA_MEDAL.get()&formItem2==OOO_Rider_Items.GREEED_ABSORPTION_CORE.get()&formItem3==OOO_Rider_Items.ANCIENT_BATTA_MEDAL.get() )return "ancient_tatoba_greed";

		return "false";
	}

	@Override
	public String GET_TEXT(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider,String riderName)
	{
		boolean fly = rider instanceof Player player && player.getAbilities().flying;
		if (equipmentSlot == EquipmentSlot.FEET) {
			
			
				String belt = ((RiderDriverItem)itemstack.getItem()).BELT_TEXT;
				if (((RiderDriverItem)itemstack.getItem()).BELT_TEXT==null) {
					belt = get_Form_Item(itemstack,1).getBeltTex();
				}
				return "belts/"+belt;
			
		}
	
		else if (equipmentSlot == EquipmentSlot.HEAD&get_Form_Item(itemstack,1).getFormName(false)=="_taka"&get_Form_Item(itemstack,2).getFormName(false)=="_kujaku"&get_Form_Item(itemstack,3).getFormName(false)=="_condor") return riderName+ "_taka_tajado";
		else if (equipmentSlot == EquipmentSlot.HEAD&rider.getMainHandItem().getItem()== OOO_Rider_Items.MEDAGABURYU.get()&rider.getItemBySlot(EquipmentSlot.FEET).getItem()==OOO_Rider_Items.OOODRIVER.get()&get_Form_Item(itemstack,1).getFormName(false)=="_taka"&get_Form_Item(itemstack,2).getFormName(false)=="_tora"&get_Form_Item(itemstack,3).getFormName(false)=="_batta") return riderName+ "_taka_purple";
		
		else if (equipmentSlot == EquipmentSlot.HEAD&get_Form_Item(itemstack,2)==OOO_Rider_Items.GREEED_ABSORPTION_CORE.get()) return riderName+ get_Form_Item(itemstack,1).getFormName(fly)+ "_greeed_absorption";
		else if (equipmentSlot == EquipmentSlot.LEGS&get_Form_Item(itemstack,2)==OOO_Rider_Items.GREEED_ABSORPTION_CORE.get()) return riderName+ get_Form_Item(itemstack,3).getFormName(fly)+ "_greeed_absorption";
		
		else if (equipmentSlot == EquipmentSlot.HEAD) return riderName+ get_Form_Item(itemstack,1).getFormName(fly);
		else if (equipmentSlot == EquipmentSlot.CHEST) return riderName+ get_Form_Item(itemstack,2).getFormName(fly);
		else return riderName+ get_Form_Item(itemstack,3).getFormName(fly);

	}

	public ResourceLocation getBeltModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
		return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/ooo_belt.geo.json");
	}

	public  boolean getGlowForSlot(ItemStack itemstack,EquipmentSlot currentSlot, LivingEntity livingEntity) {

		if (currentSlot== EquipmentSlot.FEET) {
			return get_Form_Item(itemstack, 1).get_Is_Belt_Glowing();
		}
		if (isTransformed(livingEntity)){
			switch (currentSlot) {
				case HEAD ->{ 
					return false;
				}
				case CHEST -> {
					return get_Form_Item(itemstack, 2).get_Is_Glowing();
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

	public ResourceLocation getModelResource(ItemStack itemstack,RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
		int num = 1;
		if (slot == EquipmentSlot.CHEST)num=2; 
		if (slot == EquipmentSlot.LEGS)num=3;
		
		if (get_Form_Item(itemstack, num).HasWingsIfFlying() && rider instanceof Player player && player.getAbilities().flying == true){
			return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/"+get_Form_Item(itemstack, num).get_FlyingModel(this.Rider));
	 }else if (get_Form_Item(itemstack, num).get_Model(this.Rider)=="default.geo.json") {
			return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/ooo.geo.json");
		 }else   
			 return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/"+get_Form_Item(itemstack, num).get_Model(this.Rider));

	}
	
	@Override
	public  boolean getPartsForSlot(ItemStack itemstack,EquipmentSlot currentSlot,String  part) {

		switch (currentSlot) {
		case HEAD ->{ 
			if (part =="head") return true;
			if (part =="body") return true;
			
		}
		case CHEST -> {
			if (part =="body") return true;
			if (part =="rightArm") return true;
			if (part =="leftArm") return true;
			
		}
		case LEGS -> {
			if (part =="body") return true;
			if (part =="leftLeg") return true;
			if (part =="rightLeg") return true;
			
		
		}
		default -> {}
		}
		return false;
	}

}