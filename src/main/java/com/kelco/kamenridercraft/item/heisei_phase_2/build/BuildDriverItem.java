package com.kelco.kamenridercraft.item.heisei_phase_2.build;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.base_items.RiderArmorItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.BuildRiderItems;
import com.kelco.kamenridercraft.world.attribute.Attributes;
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
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

public class BuildDriverItem extends RiderDriverItem {
    public BuildDriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item> torso, DeferredItem<Item> legs, Properties properties) {
        super(material, rider, baseFormItem, head, torso, legs, properties.component(DataComponents.CONTAINER, ItemContainerContents.EMPTY));
        this.hasInventory = true;
    }

    @Override
    public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
        player.openMenu(new MenuProvider() {
            @Override
            public @NotNull Component getDisplayName() {
                return Component.translatable("fullbottle_holder.text");
            }

            @Override
            public AbstractContainerMenu createMenu(int id, @NotNull Inventory inventory, @NotNull Player player) {
                FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
                packetBuffer.writeBlockPos(player.blockPosition());
                packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
                return new FullBottleHolderGuiMenu(id, inventory, packetBuffer, itemstack);
            }
        }, buf -> buf.writeBlockPos(player.blockPosition()));
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        this.hasBasicBeltInfo = false;
        Item formItem = getFormItem(stack, 1);
        Item formItem2 = getFormItem(stack, 2);
        Item formItem3 = getFormItem(stack, 3);

        tooltipComponents.add(Component.translatable("kamenridercraft.name." + riderName));


        if (formItem3 != BuildRiderItems.HAZARD_TRIGGER.get() && formItem3 != BuildRiderItems.FULL_BOTTLE.get()) {
            tooltipComponents.add(Component.translatable(formItem3.toString() + ".form"));
        } else if (isBestMatch(stack)) {
            tooltipComponents.add(Component.literal(
                    (getFormItem(stack, 2) == BuildRiderItems.MEDAL_FULL_BOTTLE.get() || getFormItem(stack, 2) == BuildRiderItems.PARKA_FULL_BOTTLE.get() ? Component.translatable(formItem.toString() + ".form_legend").getString() : Component.translatable(formItem.toString() + ".form_match").getString())
                            + (getFormItem(stack, 3) == BuildRiderItems.HAZARD_TRIGGER.get() ? " " + Component.translatable("kamenridercraft.name.hazard").getString() : "")));
            tooltipComponents.add(formItem3 == BuildRiderItems.HAZARD_TRIGGER.get() ? Component.translatable("kamenridercraft.name.best_match_hazard") : Component.translatable("kamenridercraft.name.best_match"));
        } else {
            tooltipComponents.add(Component.literal(Component.translatable("kamenridercraft.name.form").getString() + " "
                    + Component.translatable(formItem.toString() + ".form").getString()
                    + Component.translatable(formItem2.toString() + ".form").getString()));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    public boolean getGlowForSlot(ItemStack itemstack, EquipmentSlot currentSlot, LivingEntity livingEntity) {
        if (currentSlot == EquipmentSlot.FEET) {
            return getFormItem(itemstack, 1).getIsBeltGlowing();
        }
        return true;
    }


    @Override
    public String getText(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName) {
        boolean fly = Objects.requireNonNull(rider.getAttribute(Attributes.WINGS_OUT)).getBaseValue() == 1;
        if (equipmentSlot == EquipmentSlot.FEET) {

            return "belts/" + getFormItem(itemstack, 3).getBeltTex();
        } else if (isBestMatch(itemstack) & isLegend(itemstack))
            return riderName + "_" + ((FullBottleItem) getFormItem(itemstack, legendSlot(itemstack))).getIsLegendName();
        else if (equipmentSlot == EquipmentSlot.HEAD)
            return riderName + getFormItem(itemstack, 1).getFormName(fly) + getFormItem(itemstack, 3).getFormName(fly);
        else {
            return riderName + getFormItem(itemstack, 2).getFormName(fly) + getFormItem(itemstack, 3).getFormName(fly);
        }
    }

    public int legendSlot(ItemStack itemstack) {

        if (getFormItem(itemstack, 1) instanceof FullBottleItem form) {
            if (form.getIsLegend()) return 1;
        }
        return 2;
    }

    public boolean isLegend(ItemStack itemstack) {

        if (getFormItem(itemstack, 1) instanceof FullBottleItem form) {
            if (form.getIsLegend()) {
                return true;
            }
        }
        if (getFormItem(itemstack, 2) instanceof FullBottleItem form) {
            return form.getIsLegend();
        }
        return false;
    }

    public static boolean isBestMatch(ItemStack itemstack) {

        if (getFormItem(itemstack, 1) instanceof FullBottleItem form) {
            if (form.getIsLegend()) {
                return form.getBestMatch() == getFormItem(itemstack, 2);
            }

        }
        if (getFormItem(itemstack, 2) instanceof FullBottleItem form) {
            return form.getBestMatch() == getFormItem(itemstack, 1);
        }
        return false;
    }

    public static boolean CanHazard(ItemStack itemstack) {
        if (getFormItem(itemstack, 1) instanceof FullBottleItem form) {
            if (form.getIsLegend()) return false;
        }
        if (isBestMatch(itemstack)) {
            if (getFormItem(itemstack, 2) instanceof FullBottleItem form) {
                if (!form.getIsLegend()) {
                    return form.getCanHazard();
                }
            }
        }
        return false;
    }

    public ResourceLocation getModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {

        int num = 1;
        if (slot == EquipmentSlot.LEGS) num = 2;

        if (isBestMatch(itemstack) & isLegend(itemstack))
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/rider_plusbelt.geo.json");
        else if (Objects.equals(getFormItem(itemstack, num).getModel(this.riderName), "default.geo.json")) {
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/rider_plusbelt.geo.json");
        }
        if (getFormItem(itemstack, num).hasWingsIfFlying() & rider.getAttribute(Attributes.WINGS_OUT).getBaseValue() == 1) {
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/" + getFormItem(itemstack, num).getFlyingModel(this.riderName));
        } else
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/" + getFormItem(itemstack, num).getModel(this.riderName));
    }

    @Override
    public boolean getPartsForSlot(ItemStack itemstack, EquipmentSlot currentSlot, String part) {
        switch (currentSlot) {
            case HEAD -> {
                if (Objects.equals(part, "head")) return true;
                if (Objects.equals(part, "body")) return true;
                if (Objects.equals(part, "rightArm")) return true;
                if (Objects.equals(part, "leftLeg")) return true;
            }
            case LEGS -> {
                if (Objects.equals(part, "head")) return true;
                if (Objects.equals(part, "body")) return true;
                if (Objects.equals(part, "leftArm")) return true;
                if (Objects.equals(part, "rightLeg")) return true;
            }
        }
        return false;
    }
}