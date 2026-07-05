package com.kelco.kamenridercraft.item.reiwa.revice;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.ServerConfig;
import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.summons.ViceEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.reiwa.ReviceRiderItems;
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
    public ReviceDriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item> torso, DeferredItem<Item> legs, Properties properties) {
        super(material, rider, baseFormItem, head, torso, legs, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        hasBasicBeltInfo = false;
        Item formItem = getFormItem(stack, 1);

        if (formItem == ReviceRiderItems.ROLLING_VISTAMP.get())
            tooltipComponents.add(Component.translatable("kamenridercraft.name.jack_revice"));
        else if (formItem == ReviceRiderItems.THUNDER_GALE_VISTAMP.get())
            tooltipComponents.add(Component.translatable("kamenridercraft.name.revice"));
        else if (formItem == ReviceRiderItems.FIFTY_GALE_VISTAMP.get())
            tooltipComponents.add(Component.translatable("kamenridercraft.name.igarashi"));
        else {
            tooltipComponents.add(Component.translatable("kamenridercraft.name." + riderName));
            tooltipComponents.add(Component.translatable(formItem.toString() + ".form"));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    public void summonVice(Player player) {
        ViceEntity vice = MobsCore.VICE.get().create(player.level());
        if (vice != null) {
            vice.moveTo(player.getX(), player.getY() + 1, player.getZ(), player.getYRot(), player.getXRot());
            if (RiderDriverItem.getFormItem(player.getItemBySlot(EquipmentSlot.FEET), 1) == ReviceRiderItems.BARID_REX_VISTAMP.get()) {
                vice.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(ReviceRiderItems.BARID_SHIELD.get()));
            } else if (RiderDriverItem.getFormItem(player.getItemBySlot(EquipmentSlot.FEET), 1) == ReviceRiderItems.VOLCANO_VISTAMP.get()) {
                RiderDriverItem.setFormItem(vice.getItemBySlot(EquipmentSlot.FEET), ReviceRiderItems.VOLCANO_VISTAMP_VICE.get(), 1);
            }
            player.level().addFreshEntity(vice);
            vice.bindToPlayer(player);
        }
    }

    public static boolean viceSummoned(Player player) {
        return !player.level().getEntitiesOfClass(ViceEntity.class,
                player.getBoundingBox().inflate(99), entity -> entity.getOwner() == player).isEmpty();
    }

    public void onTransformation(ItemStack itemstack, LivingEntity entity) {
        ItemStack form = new ItemStack(RiderDriverItem.getFormItem(itemstack, 1));

        if (entity instanceof Player player && ServerConfig.viceSpawning && !viceSummoned(player)
                && itemstack.getItem() == ReviceRiderItems.REVICE_DRIVER.get()
                && form.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "gear/form_items/vice"))))
            summonVice(player);
        super.onTransformation(itemstack, entity);
    }

    public void onFormChange(ItemStack itemstack, LivingEntity entity, CompoundTag tag) {
        ItemStack form = new ItemStack(RiderDriverItem.getFormItem(itemstack, 1));
        if (entity instanceof Player player && !player.level().isClientSide() && isTransformed(player)
                && ServerConfig.viceSpawning && !viceSummoned(player)
                && itemstack.getItem() == ReviceRiderItems.REVICE_DRIVER.get()
                && form.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "gear/form_items/vice"))))
            summonVice(player);
        super.onFormChange(itemstack, entity, tag);
    }
}