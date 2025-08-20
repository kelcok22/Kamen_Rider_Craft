package com.kelco.kamenridercraft.item.revice;

import com.kelco.kamenridercraft.ServerConfig;
import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.summons.ViceEntity;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Geats_Rider_Items;
import com.kelco.kamenridercraft.item.Revice_Rider_Items;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.List;

public class ReviceDriverItem extends RiderDriverItem {

    public ReviceDriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties);
	}

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        Has_basic_belt_info = false;
        Item formItem = this.get_Form_Item(stack, 1);

        if (formItem == Revice_Rider_Items.ROLLING_VISTAMP.get()) tooltipComponents.add(Component.translatable("kamenridercraft.name.jack_revice"));
        else if (formItem == Revice_Rider_Items.THUNDER_GALE_VISTAMP.get()) tooltipComponents.add(Component.translatable("kamenridercraft.name.revice"));
        else if (formItem == Revice_Rider_Items.FIFTY_GALE_VISTAMP.get()) tooltipComponents.add(Component.translatable("kamenridercraft.name.igarashi"));
        else {
            tooltipComponents.add(Component.translatable("kamenridercraft.name."+Rider));
            tooltipComponents.add(Component.translatable(formItem.toString() + ".form"));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    public void summonVice(Player player) {
		ViceEntity vice = MobsCore.VICE.get().create(player.level());
		if (vice != null) {
			vice.moveTo(player.getX(), player.getY()+1, player.getZ(), player.getYRot(), player.getXRot());
			if (RiderDriverItem.get_Form_Item(player.getItemBySlot(EquipmentSlot.FEET), 1)==Revice_Rider_Items.BARID_REX_VISTAMP.get()) {
				vice.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(Revice_Rider_Items.BARID_SHIELD.get()));
			} else if (RiderDriverItem.get_Form_Item(player.getItemBySlot(EquipmentSlot.FEET), 1)==Revice_Rider_Items.VOLCANO_VISTAMP.get()) {
				RiderDriverItem.set_Form_Item(vice.getItemBySlot(EquipmentSlot.FEET), Revice_Rider_Items.VOLCANO_VISTAMP_VICE.get(), 1);
			}
			player.level().addFreshEntity(vice);
			vice.bindToPlayer(player);
		}
    }

    public static boolean viceSummoned(Player player) {
		return !player.level().getEntitiesOfClass(ViceEntity.class,
				player.getBoundingBox().inflate(99), entity -> entity.getOwner() == player).isEmpty();
    }
	
	public void OnTransformation(ItemStack itemstack, LivingEntity entity) {
		ItemStack form = new ItemStack(RiderDriverItem.get_Form_Item(itemstack, 1));

		if (entity instanceof Player player && ServerConfig.viceSpawning && !viceSummoned(player)
		&& itemstack.getItem() == Revice_Rider_Items.REVICE_DRIVER.get()
		&& form.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "gear/form_items/vice"))))
			summonVice(player);
		super.OnTransformation(itemstack, entity);
	}
	
	public void OnformChange(ItemStack itemstack, LivingEntity entity, CompoundTag tag) {
		ItemStack form = new ItemStack(RiderDriverItem.get_Form_Item(itemstack, 1));
		if (entity instanceof Player player && !player.level().isClientSide() && isTransformed(player)
		&& ServerConfig.viceSpawning && !viceSummoned(player)
		&& itemstack.getItem() == Revice_Rider_Items.REVICE_DRIVER.get()
		&& form.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "gear/form_items/vice"))))
			summonVice(player);
		super.OnformChange(itemstack, entity, tag);
	}
}