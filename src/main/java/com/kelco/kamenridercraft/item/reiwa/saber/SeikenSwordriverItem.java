package com.kelco.kamenridercraft.item.reiwa.saber;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.base_items.RiderArmorItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.reiwa.SaberRiderItems;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import com.kelco.kamenridercraft.world.inventory.HissatsuHolderGuiMenu;
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

public class SeikenSwordriverItem extends RiderDriverItem {
    public SeikenSwordriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item> torso, DeferredItem<Item> legs, Properties properties) {
        super(material, rider, baseFormItem, head, torso, legs, properties.component(DataComponents.CONTAINER, ItemContainerContents.EMPTY));
        unlimitedTextures = 4;
        hasInventory = true;
    }

    @Override
    public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
        player.openMenu(new MenuProvider() {
            @Override
            public @NotNull Component getDisplayName() {
                return Component.translatable("hissatsuholder.text");
            }

            @Override
            public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
                packetBuffer.writeBlockPos(player.blockPosition());
                packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
                return new HissatsuHolderGuiMenu(id, inventory, packetBuffer, itemstack);
            }
        });
    }


    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        hasBasicBeltInfo = false;


        Item formItem = getFormItem(stack, 1);
        Item formItem2 = getFormItem(stack, 2);
        Item formItem3 = getFormItem(stack, 3);

        if (formItem == SaberRiderItems.BRAVE_DRAGON_WONDER_RIDE_BOOK_XROSS.get()) {
            tooltipComponents.add(Component.translatable("kamenridercraft.name." + riderName + "_xross"));

            if (formItem2 == SaberRiderItems.SABER_BLANK_2.get() && formItem3 == SaberRiderItems.SABER_BLANK_3.get())
                tooltipComponents.add(Component.translatable(formItem + ".form"));
            else if (formItem2 == SaberRiderItems.LION_SENKI_WONDER_RIDE_BOOK_XROSS.get() && formItem3 == SaberRiderItems.LAMP_DO_ALNGINA_WONDER_RIDE_BOOK_XROSS.get())
                tooltipComponents.add(Component.translatable(formItem + ".form_featuring"));
            else if (formItem2 == SaberRiderItems.STORM_EAGLE_WONDER_RIDE_BOOK_XROSS.get() && formItem3 == SaberRiderItems.SAIYUU_JOURNEY_WONDER_RIDE_BOOK_XROSS.get())
                tooltipComponents.add(Component.translatable(formItem + ".form_crimson"));
            else {
                tooltipComponents.add(Component.translatable(formItem + ".form_hybrid"));
                if (formItem2 != SaberRiderItems.SABER_BLANK_2.get())
                    tooltipComponents.add(Component.translatable(formItem2.toString() + ".form"));
                if (formItem3 != SaberRiderItems.SABER_BLANK_3.get())
                    tooltipComponents.add(Component.translatable(formItem3.toString() + ".form"));
            }
        } else {
            tooltipComponents.add(Component.translatable("kamenridercraft.name." + riderName));
            if (stack.getItem() == SaberRiderItems.SEIKEN_SWORDRIVER_DRIVER_SABER.get()) {
                if (formItem == SaberRiderItems.BRAVE_DRAGON_WONDER_RIDE_BOOK.get()) {
                    if (formItem2 == SaberRiderItems.SABER_BLANK_2.get() && formItem3 == SaberRiderItems.SABER_BLANK_3.get())
                        tooltipComponents.add(Component.translatable(formItem + ".form_basic"));
                    else if (formItem2 == SaberRiderItems.SABER_BLANK_2.get() && formItem3 == SaberRiderItems.SAIYUU_JOURNEY_WONDER_RIDE_BOOK.get())
                        tooltipComponents.add(Component.translatable(formItem + ".form_saiyuu"));
                    else if (formItem2 == SaberRiderItems.STORM_EAGLE_WONDER_RIDE_BOOK.get() && formItem3 == SaberRiderItems.SAIYUU_JOURNEY_WONDER_RIDE_BOOK.get())
                        tooltipComponents.add(Component.translatable(formItem + ".form_combo"));
                    else
                        tooltipComponents.add(Component.literal(Component.translatable("kamenridercraft.name.form").getString() + " "
                                + Component.translatable(formItem + ".form").getString()
                                + (formItem2 != SaberRiderItems.SABER_BLANK_2.get() ? " " + Component.translatable(formItem2.toString() + ".form").getString() : "")
                                + (formItem3 != SaberRiderItems.SABER_BLANK_3.get() ? " " + Component.translatable(formItem3.toString() + ".form").getString() : "")));
                } else tooltipComponents.add(Component.translatable(formItem.toString() + ".form"));
            } else if (stack.getItem() == SaberRiderItems.SEIKEN_SWORDRIVER_DRIVER_BLADES.get()) {
                if (formItem2 == SaberRiderItems.LION_SENKI_WONDER_RIDE_BOOK.get()) {
                    if (formItem == SaberRiderItems.SABER_BLANK_1.get() && formItem3 == SaberRiderItems.SABER_BLANK_3.get())
                        tooltipComponents.add(Component.translatable(formItem2 + ".form_basic"));
                    else if (formItem == SaberRiderItems.SABER_BLANK_1.get() && formItem3 == SaberRiderItems.PETER_FANTASISTA_WONDER_RIDE_BOOK.get())
                        tooltipComponents.add(Component.translatable(formItem2 + ".form_peter"));
                    else if (formItem == SaberRiderItems.TENKUU_NO_PEGASUS_WONDER_RIDE_BOOK.get() && formItem3 == SaberRiderItems.SABER_BLANK_3.get())
                        tooltipComponents.add(Component.translatable(formItem2 + ".form_pegasus"));
                    else if (formItem == SaberRiderItems.TENKUU_NO_PEGASUS_WONDER_RIDE_BOOK.get() && formItem3 == SaberRiderItems.PETER_FANTASISTA_WONDER_RIDE_BOOK.get())
                        tooltipComponents.add(Component.translatable(formItem2 + ".form_combo"));
                    else if (formItem == SaberRiderItems.KING_LION_DAISENKI_WONDER_RIDE_BOOK.get() || formItem == SaberRiderItems.TATEGAMI_HYOUJUU_SENKI_WONDER_RIDE_BOOK.get())
                        tooltipComponents.add(Component.translatable(formItem + ".form"));
                    else
                        tooltipComponents.add(Component.literal(Component.translatable("kamenridercraft.name.form").getString() + " "
                                + (formItem != SaberRiderItems.SABER_BLANK_1.get() ? Component.translatable(formItem.toString() + ".form").getString() + " " : "")
                                + Component.translatable(formItem2 + ".form").getString()
                                + (formItem3 != SaberRiderItems.SABER_BLANK_3.get() ? " " + Component.translatable(formItem3.toString() + ".form").getString() : "")));
                } else tooltipComponents.add(Component.translatable(formItem2.toString() + ".form"));
            } else if (stack.getItem() == SaberRiderItems.SEIKEN_SWORDRIVER_DRIVER_ESPADA.get()) {
                if (formItem3 == SaberRiderItems.LAMP_DO_ALNGINA_WONDER_RIDE_BOOK.get()) {
                    if (formItem == SaberRiderItems.SABER_BLANK_1.get() && formItem2 == SaberRiderItems.SABER_BLANK_2.get())
                        tooltipComponents.add(Component.translatable(formItem3 + ".form_basic"));
                    else if (formItem == SaberRiderItems.SABER_BLANK_1.get() && formItem2 == SaberRiderItems.NEEDLE_HEDGEHOG_WONDER_RIDE_BOOK.get())
                        tooltipComponents.add(Component.translatable(formItem3 + ".form_hedgehog"));
                    else if (formItem == SaberRiderItems.TRI_CERBERUS_WONDER_RIDE_BOOK.get() && formItem2 == SaberRiderItems.SABER_BLANK_2.get())
                        tooltipComponents.add(Component.translatable(formItem3 + ".form_cerberus"));
                    else if (formItem == SaberRiderItems.TRI_CERBERUS_WONDER_RIDE_BOOK.get() && formItem2 == SaberRiderItems.NEEDLE_HEDGEHOG_WONDER_RIDE_BOOK.get())
                        tooltipComponents.add(Component.translatable(formItem3 + ".form_combo"));
                    else if (formItem == SaberRiderItems.ARABIANA_NIGHT_WONDER_RIDE_BOOK.get())
                        tooltipComponents.add(Component.translatable(formItem + ".form"));
                    else
                        tooltipComponents.add(Component.literal(Component.translatable("kamenridercraft.name.form").getString() + " "
                                + (formItem != SaberRiderItems.SABER_BLANK_1.get() ? Component.translatable(formItem.toString() + ".form").getString() + " " : "")
                                + (formItem2 != SaberRiderItems.SABER_BLANK_2.get() ? Component.translatable(formItem2.toString() + ".form").getString() + " " : "")
                                + Component.translatable(formItem3 + ".form").getString()));
                } else tooltipComponents.add(Component.translatable(formItem3.toString() + ".form"));
            }
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    @Override
    public String getUnlimitedTextures(ItemStack itemstack, LivingEntity livingEntity, String riderName, int num) {
        boolean fly = livingEntity instanceof Player player && (player.getAbilities().flying || player.isFallFlying());

        if (getFormItem(itemstack, 1).getStoredNum() == 2) return "blank";

        if (num == 2) return getFormItem(itemstack, 1).getFormName(fly);
        else if (num == 3 && Objects.equals(riderName, "saber") & getFormItem(itemstack, 3) == SaberRiderItems.LAMP_DO_ALNGINA_WONDER_RIDE_BOOK.get())
            return getFormItem(itemstack, 3).getFormName(fly) + "_saber";
        else if (num == 3) return getFormItem(itemstack, 3).getFormName(fly);
        else if (num == 4) return getFormItem(itemstack, 2).getFormName(fly);
        else if (getFormItem(itemstack, 1).getStoredNum() == 3) return "xross_" + riderName + "_base";

        else return riderName + "_base";
    }

    @Override
    public void setExtraFormItem(ItemStack belt, Item ITEM, int SLOT, CompoundTag tag) {
        if (belt.getItem() == SaberRiderItems.SEIKEN_SWORDRIVER_DRIVER_SABER.get()) {
            if (getFormItem(belt, 1).getStoredNum() == 2 && (getFormItem(belt, 2) != SaberRiderItems.SABER_BLANK_2.get() || getFormItem(belt, 3) != SaberRiderItems.SABER_BLANK_3.get())) {
                setFormItem(belt, SaberRiderItems.BRAVE_DRAGON_WONDER_RIDE_BOOK.asItem(), 1);
            } else if (getFormItem(belt, 1).getStoredNum() == 3 && ((getFormItem(belt, 2) != SaberRiderItems.SABER_BLANK_2.get() && getFormItem(belt, 2) != SaberRiderItems.LION_SENKI_WONDER_RIDE_BOOK_XROSS.get() && getFormItem(belt, 2) != SaberRiderItems.STORM_EAGLE_WONDER_RIDE_BOOK_XROSS.get())
                    || (getFormItem(belt, 3) != SaberRiderItems.SABER_BLANK_3.get() && getFormItem(belt, 3) != SaberRiderItems.LAMP_DO_ALNGINA_WONDER_RIDE_BOOK_XROSS.get() && getFormItem(belt, 3) != SaberRiderItems.SAIYUU_JOURNEY_WONDER_RIDE_BOOK_XROSS.get()))) {
                setFormItem(belt, SaberRiderItems.BRAVE_DRAGON_WONDER_RIDE_BOOK.asItem(), 1);
            }
        } else if (belt.getItem() == SaberRiderItems.SEIKEN_SWORDRIVER_DRIVER_BLADES.get()) {
            if (getFormItem(belt, 2).getStoredNum() == 2 && (getFormItem(belt, 1) != SaberRiderItems.SABER_BLANK_1.get() || getFormItem(belt, 3) != SaberRiderItems.SABER_BLANK_3.get())) {
                setFormItem(belt, SaberRiderItems.LION_SENKI_WONDER_RIDE_BOOK.asItem(), 2);
            }
        } else if (belt.getItem() == SaberRiderItems.SEIKEN_SWORDRIVER_DRIVER_ESPADA.get()) {
            if (getFormItem(belt, 3).getStoredNum() == 2 && (getFormItem(belt, 1) != SaberRiderItems.SABER_BLANK_1.get() || getFormItem(belt, 2) != SaberRiderItems.SABER_BLANK_2.get())) {
                setFormItem(belt, SaberRiderItems.LAMP_DO_ALNGINA_WONDER_RIDE_BOOK.asItem(), 3);
            }
        }

    }


    public ResourceLocation getModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
        if (itemstack.getItem() == SaberRiderItems.SEIKEN_SWORDRIVER_DRIVER_SABER.get() && getFormItem(itemstack, 1) == SaberRiderItems.WONDER_ALMIGHTY_WONDER_RIDE_BOOK.get())
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/armor/saber_wonder_almighty.geo.json");
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/armor/rider_plusbelt.geo.json");
    }


    @Override
    public String getText(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName) {
        boolean fly = rider.getAttribute(Attributes.WINGS_OUT).getBaseValue() == 1;
        if (equipmentSlot == EquipmentSlot.FEET) {
            return "belts/" + getFormItem(itemstack, 1).getBeltTex();
        }
        if (equipmentSlot == EquipmentSlot.HEAD & getFormItem(itemstack, 1).getStoredNum() == 2)
            return getFormItem(itemstack, 1).getFormName(fly);
        else if (equipmentSlot == EquipmentSlot.HEAD & getFormItem(itemstack, 1).getStoredNum() == 3)
            return riderName + "_face_xross";
        else if (equipmentSlot == EquipmentSlot.HEAD) return riderName + "_face";
        else return "blank";
    }

    public boolean getGlowForSlot(ItemStack itemstack, EquipmentSlot currentSlot, LivingEntity livingEntity) {

        if (currentSlot == EquipmentSlot.FEET) {
            return getFormItem(itemstack, 1).getIsBeltGlowing();
        }
        if (isTransformed(livingEntity)) {
            switch (currentSlot) {
                case LEGS -> {
                    return false;
                }
                case CHEST, HEAD -> {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean getPartsForSlot(ItemStack itemstack, EquipmentSlot currentSlot, String part) {

        switch (currentSlot) {
            case HEAD, LEGS, CHEST -> {
                return true;
            }
        }
        return false;
    }
}