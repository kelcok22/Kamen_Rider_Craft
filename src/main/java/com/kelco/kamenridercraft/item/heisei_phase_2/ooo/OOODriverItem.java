package com.kelco.kamenridercraft.item.heisei_phase_2.ooo;

import com.kelco.kamenridercraft.KamenRiderCraftCore;

import com.kelco.kamenridercraft.item.base_items.RiderArmorItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.OOORiderItems;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.List;
import java.util.Objects;

public class OOODriverItem extends RiderDriverItem {


	public OOODriverItem (Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Item.Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties);
		Has_basic_belt_info=false;
        Unlimited_Belt_Textures = 3;
	}

	@Override
	public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {

		tooltipComponents.add(Component.translatable("kamenridercraft.name."+Rider));


		Item formItem = getFormItem(stack, 1);
		Item formItem2 = getFormItem(stack, 2);
		Item formItem3 = getFormItem(stack, 3);

		if (!Objects.equals(getCombo(formItem, formItem2, formItem3), "false"))tooltipComponents.add(Component.translatable("kamenridercraft:"+getCombo(formItem,formItem2,formItem3)+".form"));
		else if (!OOORiderItems.SPECIAL_NAME_MEDALS.contains(formItem) || !OOORiderItems.SPECIAL_NAME_MEDALS.contains(formItem2) || !OOORiderItems.SPECIAL_NAME_MEDALS.contains(formItem3)) {
			tooltipComponents.add(Component.translatable("kamenridercraft:" + getCombo(formItem, formItem2, formItem3) + ".form"));
			tooltipComponents.add(Component.translatable(formItem.toString() + ".form"));
			tooltipComponents.add(Component.translatable(formItem2.toString() + ".form"));
			tooltipComponents.add(Component.translatable(formItem3.toString() + ".form"));
		} else {
			tooltipComponents.add(Component.literal(Component.translatable("kamenridercraft:false.form_special").getString()
					+ Component.translatable(formItem.toString() + ".form_special").getString()
					+ (formItem3 == OOORiderItems.CHEETAH_MEDAL.get() ? Component.translatable(formItem2.toString() + ".form_cheetah").getString() : Component.translatable(formItem2.toString() + ".form_special").getString())
					+ Component.translatable(formItem3.toString() + ".form_special").getString()));
		}
		super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
	}

	public String getCombo (Item formItem,Item formItem2,Item formItem3) {
		if (formItem== OOORiderItems.TAKA_MEDAL.get()&formItem2== OOORiderItems.TORA_MEDAL.get()&formItem3== OOORiderItems.BATTA_MEDAL.get() )return "tatoba";
		if (formItem== OOORiderItems.SUPER_TAKA_MEDAL.get()&formItem2== OOORiderItems.SUPER_TORA_MEDAL.get()&formItem3== OOORiderItems.SUPER_BATTA_MEDAL.get() )return "super_tatoba";
		if (formItem== OOORiderItems.TAKA_ANKH_MEDAL.get()&formItem2== OOORiderItems.TORA_MEDAL.get()&formItem3== OOORiderItems.BATTA_MEDAL.get() )return "tatoba";
		if (formItem== OOORiderItems.TAKA_MEDAL.get()&formItem2== OOORiderItems.KUJAKU_MEDAL.get()&formItem3== OOORiderItems.CONDOR_MEDAL.get() )return "tajadol";
		if (formItem== OOORiderItems.TAKA_ANKH_MEDAL.get()&formItem2== OOORiderItems.KUJAKU_MEDAL.get()&formItem3== OOORiderItems.CONDOR_MEDAL.get() )return "tajadol_fe";
		if (formItem== OOORiderItems.TAKA_ETERNITY_MEDAL.get()&formItem2== OOORiderItems.KUJAKU_ETERNITY_MEDAL.get()&formItem3== OOORiderItems.CONDOR_ETERNITY_MEDAL.get() )return "tajadol_eternity";
		if (formItem== OOORiderItems.LION_MEDAL.get()&formItem2== OOORiderItems.TORA_MEDAL.get()&formItem3== OOORiderItems.CHEETAH_MEDAL.get() )return "latorartar";
		if (formItem== OOORiderItems.KUWAGATA_MEDAL.get()&formItem2== OOORiderItems.KAMAKIRI_MEDAL.get()&formItem3== OOORiderItems.BATTA_MEDAL.get() )return "gatakiriba";
		if (formItem== OOORiderItems.SAI_MEDAL.get()&formItem2== OOORiderItems.GORILLA_MEDAL.get()&formItem3== OOORiderItems.ZOU_MEDAL.get() )return "sagohzo";
		if (formItem== OOORiderItems.SHACHI_MEDAL.get()&formItem2== OOORiderItems.UNAGI_MEDAL.get()&formItem3== OOORiderItems.TAKO_MEDAL.get() )return "shauta";
		if (formItem== OOORiderItems.PTERA_MEDAL.get()&formItem2== OOORiderItems.TRICERA_MEDAL.get()&formItem3== OOORiderItems.TYRANNO_MEDAL.get() )return "putotyra";
		if (formItem== OOORiderItems.COBRA_MEDAL.get()&formItem2== OOORiderItems.KAME_MEDAL.get()&formItem3== OOORiderItems.WANI_MEDAL.get() )return "burakawani";
		if (formItem== OOORiderItems.LOVE_CORE_MEDAL.get()&formItem2== OOORiderItems.LOVE_CORE2_MEDAL.get()&formItem3== OOORiderItems.LOVE_CORE3_MEDAL.get() )return "love";
		if (formItem== OOORiderItems.SAME_MEDAL.get()&formItem2== OOORiderItems.KUJIRA_MEDAL.get()&formItem3== OOORiderItems.OOKAMIUO_MEDAL.get() )return "saramiuo";
		if (formItem== OOORiderItems.EBI_NEW_MEDAL.get()&formItem2== OOORiderItems.KANI_NEW_MEDAL.get()&formItem3== OOORiderItems.SASORI_NEW_MEDAL.get() )return "bikaso";
		if (formItem== OOORiderItems.SHIKA_MEDAL.get()&formItem2== OOORiderItems.GAZELLE_MEDAL.get()&formItem3== OOORiderItems.USHI_MEDAL.get() )return "shigazeshi";
		if (formItem== OOORiderItems.MUKADE_MEDAL.get()&formItem2== OOORiderItems.HACHI_MEDAL.get()&formItem3== OOORiderItems.ARI_MEDAL.get() )return "mukachiri";
		if (formItem== OOORiderItems.SEIUCHI_MEDAL.get()&formItem2== OOORiderItems.SHIROKUMA_MEDAL.get()&formItem3== OOORiderItems.PENGUIN_MEDAL.get() )return "seishirogin";
		if (formItem== OOORiderItems.TAKA_MEDAL.get()&formItem2== OOORiderItems.IMAGIN_MEDAL.get()&formItem3== OOORiderItems.SHOCKER_MEDAL.get() )return "tamashiy";
		if (formItem== OOORiderItems.TAKA_ANKH_MEDAL.get()&formItem2== OOORiderItems.IMAGIN_MEDAL.get()&formItem3== OOORiderItems.SHOCKER_MEDAL.get() )return "tamashiy";
		if (formItem== OOORiderItems.HABATAKI_MEDAL.get()&formItem2== OOORiderItems.TAIGA_MEDAL.get()&formItem3== OOORiderItems.ICHIGO_MEDAL.get() )return "legend_tatoba";
		if (formItem== OOORiderItems.MUKADE_GODA_MEDAL.get()&formItem2== OOORiderItems.HACHI_GODA_MEDAL.get()&formItem3== OOORiderItems.ARI_GODA_MEDAL.get() )return "goda";

		if (formItem== OOORiderItems.ANCIENT_TAKA_MEDAL.get()&formItem2== OOORiderItems.ANCIENT_TORA_MEDAL.get()&formItem3== OOORiderItems.ANCIENT_BATTA_MEDAL.get() )return "ancient_tatoba";
		if (formItem== OOORiderItems.ANCIENT_TAKA_MEDAL.get()&formItem2== OOORiderItems.GREEED_ABSORPTION_CORE.get()&formItem3== OOORiderItems.ANCIENT_BATTA_MEDAL.get() )return "ancient_tatoba_greed";

		return "false";
	}

    @Override
    public String getUnlimitedBeltTextures(ItemStack itemstack, LivingEntity rider, String riderName ,int num) {
        if(riderName!="ooo") return "blank";
        if (num ==1)return getFormItem(itemstack,1).getBeltTex()+ getFormItem(itemstack,1).getFormName(false);
        else  if (num ==2)return getFormItem(itemstack,1).getBeltTex()+ getFormItem(itemstack,2).getFormName(false);
        if (num ==3)return getFormItem(itemstack,1).getBeltTex()+ getFormItem(itemstack,3).getFormName(false);
        return "blank";
    }


    @Override
	public String getText(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName)
	{
        boolean fly = rider.getAttribute(Attributes.WINGS_OUT).getBaseValue()==1;
		if (equipmentSlot == EquipmentSlot.FEET) {


			String belt = ((RiderDriverItem)itemstack.getItem()).BELT_TEXT;
			if (((RiderDriverItem)itemstack.getItem()).BELT_TEXT==null) {
				belt = getFormItem(itemstack,1).getBeltTex();
			}
			return "belts/"+belt;

		}

		else if (equipmentSlot == EquipmentSlot.HEAD& Objects.equals(getFormItem(itemstack, 1).getFormName(false), "_taka") & Objects.equals(getFormItem(itemstack, 2).getFormName(false), "_kujaku") & Objects.equals(getFormItem(itemstack, 3).getFormName(false), "_condor")) return riderName+ "_taka_tajado";
		else if (equipmentSlot == EquipmentSlot.HEAD&rider.getMainHandItem().getItem()== OOORiderItems.MEDAGABURYU.get()&rider.getItemBySlot(EquipmentSlot.FEET).getItem()== OOORiderItems.OOODRIVER.get()& Objects.equals(getFormItem(itemstack, 1).getFormName(false), "_taka") & Objects.equals(getFormItem(itemstack, 2).getFormName(false), "_tora") & Objects.equals(getFormItem(itemstack, 3).getFormName(false), "_batta")) return riderName+ "_taka_purple";

		else if (equipmentSlot == EquipmentSlot.HEAD& getFormItem(itemstack,2)== OOORiderItems.GREEED_ABSORPTION_CORE.get()) return riderName+ getFormItem(itemstack,1).getFormName(fly)+ "_greeed_absorption";
		else if (equipmentSlot == EquipmentSlot.LEGS& getFormItem(itemstack,2)== OOORiderItems.GREEED_ABSORPTION_CORE.get()) return riderName+ getFormItem(itemstack,3).getFormName(fly)+ "_greeed_absorption";

		else if (equipmentSlot == EquipmentSlot.HEAD) return riderName+ getFormItem(itemstack,1).getFormName(fly);
		else if (equipmentSlot == EquipmentSlot.CHEST) return riderName+ getFormItem(itemstack,2).getFormName(fly);
		else return riderName+ getFormItem(itemstack,3).getFormName(fly);

	}

	public ResourceLocation getBeltModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
		return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/ooo_belt.geo.json");
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
					return getFormItem(itemstack, 2).getIsGlowing();
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

        if (slot == EquipmentSlot.HEAD& Objects.equals(getFormItem(itemstack, 1).getFormName(false), "_taka")
                & Objects.equals(getFormItem(itemstack, 2).getFormName(false), "_kujaku")
                & Objects.equals(getFormItem(itemstack, 3).getFormName(false), "_condor")) return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/ooo_taka_tajado.geo.json");

		if (getFormItem(itemstack, num).hasWingsIfFlying() && rider.getAttribute(Attributes.WINGS_OUT).getBaseValue()==1){
			return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/"+ getFormItem(itemstack, num).getFlyingModel(this.Rider));
		}else
			return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/"+ getFormItem(itemstack, num).getModel(this.Rider));

	}

	@Override
	public  boolean getPartsForSlot(ItemStack itemstack,EquipmentSlot currentSlot,String  part) {

		switch (currentSlot) {
			case HEAD ->{
				if (Objects.equals(part, "head")) return true;
				if (Objects.equals(part, "body")) return true;

			}
			case CHEST -> {
				if (Objects.equals(part, "body")) return true;
				if (Objects.equals(part, "rightArm")) return true;
				if (Objects.equals(part, "leftArm")) return true;

			}
			case LEGS -> {
				if (Objects.equals(part, "body")) return true;
				if (Objects.equals(part, "leftLeg")) return true;
				if (Objects.equals(part, "rightLeg")) return true;


			}
			default -> {}
		}
		return false;
	}

}