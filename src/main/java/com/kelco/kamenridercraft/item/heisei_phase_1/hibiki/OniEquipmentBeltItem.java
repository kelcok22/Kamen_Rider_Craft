package com.kelco.kamenridercraft.item.heisei_phase_1.hibiki;

import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.base_items.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.heisei_phase_1.HibikiRiderItems;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.List;
import java.util.Objects;

public class OniEquipmentBeltItem extends RiderDriverItem {
    private Item beltItem;
    private final String beltItemTex;

    public OniEquipmentBeltItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item> torso, DeferredItem<Item> legs, Properties properties, DeferredItem<Item> henshinItem, String henshinItemTexture) {
        super(material, rider, baseFormItem, head, torso, legs, properties);
        unlimitedBeltTextures = 1;
        beltItem = henshinItem.get();
        beltItemTex = henshinItemTexture;
    }

    @Override
    public String getUnlimitedBeltTextures(ItemStack itemStack, LivingEntity rider, String riderName, int num) {
        if (!rider.isHolding(beltItem)) return beltItemTex;
        return "blank";
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        hasBasicBeltInfo = false;
        Item form = getFormItem(stack, 1);
        Item mask = getFormItem(stack, 2);

        tooltipComponents.add(Component.translatable("kamenridercraft.name." + riderName));
        if (showBeltFormInfo) {
            if (mask == HibikiRiderItems.MASKLESS_ONI.get()) tooltipComponents.add(Component.literal(Component.translatable(form.toString() + ".form").getString()
                + " " + Component.translatable("kamenridercraft:form.unmasked").getString()));
            else tooltipComponents.add(Component.literal(Component.translatable(form.toString() + ".form").getString()));
        } else super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    @Override
    public double getRenderType(ItemStack stack, double num, LivingEntity rider) {
        RiderFormChangeItem form = getFormItem(stack, 2, num);
        if (form.getShowHead()) return 4;
        return super.getRenderType(stack, num, rider);
    }

    @Override
    public boolean getPartsForSlot(ItemStack itemStack, EquipmentSlot currentSlot, String part) {
        if (Objects.equals(part, "head")) return getFormItem(itemStack, 2) != HibikiRiderItems.MASKLESS_ONI.get();
        return currentSlot != EquipmentSlot.FEET;
    }
}
