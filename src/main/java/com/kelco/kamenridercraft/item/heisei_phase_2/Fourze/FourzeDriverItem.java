package com.kelco.kamenridercraft.item.heisei_phase_2.Fourze;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.item.base_items.RiderArmorItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.FourzeRiderItems;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.List;
import java.util.Objects;

public class FourzeDriverItem extends RiderDriverItem {



	public FourzeDriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties);
		Unlimited_Textures=4;
	}

	@Override
	public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {

		tooltipComponents.add(Component.translatable("kamenridercraft.name."+Rider));
		this.Has_basic_belt_info=false;

		Item formItem = getFormItem(stack, 1);
		Item formItem2 = getFormItem(stack, 2);
		Item formItem3 = getFormItem(stack, 3);
		Item formItem4 = getFormItem(stack, 4);
		Item formItem5 = getFormItem(stack, 5);

		tooltipComponents.add(Component.translatable(formItem5.toString() + ".form"));

		if (formItem5== FourzeRiderItems.FOURZE_FUSION_STATES.asItem()||formItem5== FourzeRiderItems.FOURZE_METEOR_NADESHIKO_FUSION_STATES.asItem()
		) tooltipComponents.add(Component.translatable("kamenridercraft:meteor_switch_fourze.form"));
		else tooltipComponents.add(Component.translatable(formItem.toString() + ".form"));

		if (formItem5== FourzeRiderItems.FOURZE_METEOR_NADESHIKO_FUSION_STATES.asItem()) tooltipComponents.add(Component.translatable( "kamenridercraft:nadeshiko_switch_fourze.form"));
		else tooltipComponents.add(Component.translatable(formItem2.toString() + ".form"));

		tooltipComponents.add(Component.translatable(formItem3.toString() + ".form"));

		if (formItem5== FourzeRiderItems.SHIN_CHAN_ASTROSWITCH.asItem()) tooltipComponents.add(Component.translatable( "kamenridercraft:name_shin_chan.form"));
		else tooltipComponents.add(Component.translatable(formItem4.toString() + ".form"));

		super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
	}

	@Override
	public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {

		super.inventoryTick(stack,level,entity,slotId,isSelected);

		if (entity instanceof LivingEntity player) {
			if (isTransformed(player)) {
				for (int n = 0; n < Num_Base_Form_Item; n++) {
					List<MobEffectInstance> potionEffectList = getFormItem(player.getItemBySlot(EquipmentSlot.FEET), n + 1).getPotionEffectList();
					for (MobEffectInstance effect : potionEffectList) {
						player.addEffect(new MobEffectInstance(effect.getEffect(), effect.getDuration(), effect.getAmplifier() + (player.hasEffect(EffectCore.COSMIC_ENERGY) && !effect.is(EffectCore.COSMIC_ENERGY) ? 1 : 0), true, false));
					}
				}
			}
		}
	}

	@Override
	public String getUnlimitedTextures(ItemStack itemstack, LivingEntity livingEntity, String riderName, int num)
	{
		boolean fly = livingEntity instanceof Player player && (player.getAbilities().flying||player.isFallFlying());
		if (num == 1){
			if (getFormItem(itemstack,1)!= FourzeRiderItems.BLANK_CIRCLE_ASTROSWITCH.get()& getFormItem(itemstack,1)!=null){
				return riderName + getFormItem(itemstack, 1).getFormName(fly);
			}else return"blank";
		}if (num == 2){
		if (getFormItem(itemstack,2)!= FourzeRiderItems.BLANK_CROSS_ASTROSWITCH.get()& getFormItem(itemstack,2)!=null){
			return riderName + getFormItem(itemstack, 2).getFormName(fly);
		}else return"blank";
	}else 	if (num == 3){
		if (getFormItem(itemstack,3)!= FourzeRiderItems.BLANK_TRIANGLE_ASTROSWITCH.get()& getFormItem(itemstack,3)!=null){
			return riderName + getFormItem(itemstack, 3).getFormName(fly);
		}else return"blank";
	} else 	if (num == 4){
		if (getFormItem(itemstack,4)!= FourzeRiderItems.BLANK_SQUARE_ASTROSWITCH.get()& getFormItem(itemstack,4)!=null){
			return riderName + getFormItem(itemstack, 4).getFormName(fly);
		}else return"blank";
	}
		return  "blank";
	}

	@Override
	public void setExtraFormItem(ItemStack belt, Item ITEM, int SLOT, CompoundTag  tag)
	{

		if ((getFormItem(belt, 5) == FourzeRiderItems.FOURZE_ELEK_STATES.get() && getFormItem(belt, 1)!= FourzeRiderItems.ELEK_ASTROSWITCH.get())
				||(getFormItem(belt, 5)== FourzeRiderItems.FOURZE_FIRE_STATES.get() && getFormItem(belt, 1)!= FourzeRiderItems.FIRE_ASTROSWITCH.get())
				||(getFormItem(belt, 5)== FourzeRiderItems.FOURZE_ROCKET_DRILL_STATES.get() && getFormItem(belt, 1)!= FourzeRiderItems.CLEAR_DRILL_ASTROSWITCH.get())
				||(getFormItem(belt, 5)== FourzeRiderItems.FOURZE_MAGNET_STATES.get() && getFormItem(belt, 1)!= FourzeRiderItems.MAGNET_ASTROSWITCH_N.get())
				||(getFormItem(belt, 5)== FourzeRiderItems.FOURZE_MAGNET_STATES.get() && getFormItem(belt, 4)!= FourzeRiderItems.MAGNET_ASTROSWITCH_S.get())
				||(getFormItem(belt, 5)== FourzeRiderItems.FOURZE_ROCKET_STATES.get() && getFormItem(belt, 1)!= FourzeRiderItems.ROCKET_ASTROSWITCH.get())
				||(getFormItem(belt, 5)== FourzeRiderItems.FOURZE_ROCKET_STATES.get() && getFormItem(belt, 4)!= FourzeRiderItems.SUPER_ROCKET_ASTROSWITCH.get()))
		{
			setFormItem(belt, FourzeRiderItems.FOURZE_BASE_STATES.asItem(), 5);
		}

		if (getFormItem(belt, 5) == FourzeRiderItems.FOURZE_METEOR_NADESHIKO_FUSION_STATES.get()
				|| getFormItem(belt, 5) == FourzeRiderItems.FOURZE_FUSION_STATES.get()){
			if (getFormItem(belt, 1) != FourzeRiderItems.BLANK_CIRCLE_ASTROSWITCH.get()
					|| getFormItem(belt, 2) != FourzeRiderItems.BLANK_CROSS_ASTROSWITCH.get()
					|| getFormItem(belt, 3) != FourzeRiderItems.BLANK_TRIANGLE_ASTROSWITCH.get()){
				setFormItem(belt, FourzeRiderItems.FOURZE_BASE_STATES.asItem(), 5);
				setFormItem(belt, FourzeRiderItems.BLANK_SQUARE_ASTROSWITCH.asItem(),4);
			}else if (getFormItem(belt, 4) != FourzeRiderItems.FUSION_ASTROSWITCH.get()
                        & getFormItem(belt, 4) != FourzeRiderItems.FUSION_ASTROSWITCH_OG.get()){
                    setFormItem(belt, FourzeRiderItems.FOURZE_BASE_STATES.asItem(), 5);
            }
        }


		if (getFormItem(belt, 5) == FourzeRiderItems.FOURZE_LAUNCHER_STATES.get()){
			if (getFormItem(belt, 1) != FourzeRiderItems.BLANK_CIRCLE_ASTROSWITCH.get()
					|| getFormItem(belt, 4) != FourzeRiderItems.BLANK_SQUARE_ASTROSWITCH.get()
					|| getFormItem(belt, 3) != FourzeRiderItems.BLANK_TRIANGLE_ASTROSWITCH.get()
					|| getFormItem(belt, 2) != FourzeRiderItems.SUPER_LAUNCHER_ASTROSWITCH.get()){
				setFormItem(belt, FourzeRiderItems.FOURZE_BASE_STATES.asItem(), 5);
				setFormItem(belt, FourzeRiderItems.BLANK_CROSS_ASTROSWITCH.asItem(),2);

			}

		}

		if ((getFormItem(belt, 1)!= FourzeRiderItems.ROCKET_ASTROSWITCH.get() && getFormItem(belt, 4)== FourzeRiderItems.SUPER_ROCKET_ASTROSWITCH.get())){
			setFormItem(belt, FourzeRiderItems.BLANK_SQUARE_ASTROSWITCH.asItem(), 4);
		}

		if ((getFormItem(belt, 1) == FourzeRiderItems.MAGNET_ASTROSWITCH_N.get()
				&& getFormItem(belt, 4)== FourzeRiderItems.MAGNET_ASTROSWITCH_S.get())
				&&(getFormItem(belt, 5) != FourzeRiderItems.FOURZE_MAGNET_STATES.get() ))
		{
			setFormItem(belt, FourzeRiderItems.FOURZE_MAGNET_STATES.asItem(), 5);
		}
		if ((getFormItem(belt, 1) == FourzeRiderItems.CLEAR_DRILL_ASTROSWITCH.get())
				&&(getFormItem(belt, 3) != FourzeRiderItems.BLANK_TRIANGLE_ASTROSWITCH.get() ))
		{
			setFormItem(belt, FourzeRiderItems.BLANK_CIRCLE_ASTROSWITCH.asItem(), 1);
		}
		if ((getFormItem(belt, 5) == FourzeRiderItems.SHIN_CHAN_ASTROSWITCH.get()))
		{
			if (getFormItem(belt, 1) != FourzeRiderItems.BLANK_CIRCLE_ASTROSWITCH.get()
					|| getFormItem(belt, 4) != FourzeRiderItems.BLANK_SQUARE_ASTROSWITCH.get()
					|| getFormItem(belt, 3) != FourzeRiderItems.BLANK_TRIANGLE_ASTROSWITCH.get()
					|| getFormItem(belt, 2) != FourzeRiderItems.BLANK_CROSS_ASTROSWITCH.get()) {
				setFormItem(belt, FourzeRiderItems.FOURZE_BASE_STATES.asItem(), 5);
			}
		}


	}

	@Override
	public String getText(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName)
	{
        boolean fly = rider.getAttribute(Attributes.WINGS_OUT).getBaseValue()==1;
		if (equipmentSlot == EquipmentSlot.FEET) {
			return "belts/"+ getFormItem(itemstack,5).getBeltTex();
		}
		if (equipmentSlot != EquipmentSlot.CHEST) return"blank";

		else return riderName + getFormItem(itemstack,5).getFormName(fly);
	}


	public ResourceLocation getModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {

		if (slot==EquipmentSlot.CHEST){
			if (getFormItem(itemstack, 1).hasWingsIfFlying() && rider.getAttribute(Attributes.WINGS_OUT).getBaseValue()==1){
				return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/"+ getFormItem(itemstack, 5).getFlyingModel(this.Rider));
			}
			return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/"+ getFormItem(itemstack, 5).getModel(this.Rider));
		}
		return super.getModelResource(itemstack, animatable, slot,rider);
	}

	public  boolean getGlowForSlot(ItemStack itemstack,EquipmentSlot currentSlot, LivingEntity livingEntity) {

		if (currentSlot== EquipmentSlot.FEET) {
			return getFormItem(itemstack, 1).getIsBeltGlowing();
		}
		if (isTransformed(livingEntity)){
			switch (currentSlot) {
				case HEAD,CHEST ->{
					return true;
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

	@Override
	public  boolean getPartsForSlot(ItemStack itemstack,EquipmentSlot currentSlot,String  part) {

		switch (currentSlot) {
			case CHEST ->{
				return true;

			}
			case HEAD -> {
				if (Objects.equals(part, "rightLeg")) return true;
				if (Objects.equals(part, "leftLeg")) return true;
				if (Objects.equals(part, "rightArm")) return true;
				if (Objects.equals(part, "leftArm")) return true;
			}

			default -> {}
		}
		return false;
	}
}