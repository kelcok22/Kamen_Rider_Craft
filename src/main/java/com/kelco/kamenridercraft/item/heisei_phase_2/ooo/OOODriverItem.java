package com.kelco.kamenridercraft.item.heisei_phase_2.ooo;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.ModdedItemCore;
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


    public OOODriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item> torso, DeferredItem<Item> legs, Item.Properties properties) {
        super(material, rider, baseFormItem, head, torso, legs, properties);
        hasBasicBeltInfo = false;
        unlimitedBeltTextures = 3;
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("kamenridercraft.name." + riderName));

        Item formItem = getFormItem(stack, 1);
        Item formItem2 = getFormItem(stack, 2);
        Item formItem3 = getFormItem(stack, 3);

        String combo = getCombo(formItem, formItem2, formItem3);

        if (!combo.equals("false"))
            tooltipComponents.add(Component.translatable("kamenridercraft:" + combo + ".form"));
        else if (!OOORiderItems.SPECIAL_NAME_MEDALS.contains(formItem) || !OOORiderItems.SPECIAL_NAME_MEDALS.contains(formItem2) || !OOORiderItems.SPECIAL_NAME_MEDALS.contains(formItem3)) {
            tooltipComponents.add(Component.translatable("kamenridercraft:" + combo + ".form"));
            tooltipComponents.add(Component.translatable(formItem + ".form"));
            tooltipComponents.add(Component.translatable(formItem2 + ".form"));
            tooltipComponents.add(Component.translatable(formItem3 + ".form"));
        } else {
            tooltipComponents.add(Component.literal(Component.translatable("kamenridercraft:false.form_special").getString()
                    + Component.translatable(formItem + ".form_special").getString()
                    + (formItem3 == OOORiderItems.CHEETAH_MEDAL.get() ? Component.translatable(formItem2 + ".form_cheetah").getString() : Component.translatable(formItem2 + ".form_special").getString())
                    + Component.translatable(formItem3 + ".form_special").getString()));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    public String getCombo(Item medalOne, Item medalTwo, Item medalThree) {
        String comboText = medalOne.toString().replace("kamenridercraft:", "") + " " + medalTwo.toString().replace("kamenridercraft:", "") + " " + medalThree.toString().replace("kamenridercraft:", "");
        return switch (comboText) {
            case "taka_medal tora_medal batta_medal" -> "tatoba";
            case "super_taka_medal super_tora_medal super_batta_medal" -> "super_tatoba";
            case "habataki_medal taiga_medal ichigo_medal" -> "legend_tatoba";
            case "ancient_taka_medal ancient_tora_medal ancient_batta_medal" -> "ancient_tatoba";
            case "ancient_taka_medal greeed_absorption_core ancient_batta_medal" -> "ancient_tatoba_greed";
            case "kuwagata_medal kamakiri_medal batta_medal" -> "gatakiriba";
            case "lion_medal tora_medal cheetah_medal" -> "latorartar";
            case "taka_medal kujaku_medal condor_medal", "blokees_taka_medal blokees_kujaku_medal blokees_condor_medal" -> "tajadol";
            case "taka_ankh_medal kujaku_medal condor_medal" -> "tajadol_fe";
            case "taka_eternity_medal kujaku_eternity_medal condor_eternity_medal" -> "tajadol_eternity";
            case "shachi_medal unagi_medal tako_medal" -> "shauta";
            case "sai_medal gorilla_medal zou_medal" -> "sagohzo";
            case "ptera_medal tricera_medal tyranno_medal" -> "putotyra";
            case "cobra_medal kame_medal wani_medal" -> "burakawani";
            case "seiuchi_medal shirokuma_medal penguin_medal" -> "seishirogin";
            case "mukade_medal hachi_medal ari_medal" -> "mukachiri";
            case "shika_medal gazelle_medal ushi_medal" -> "shigazeshi";
            case "ebi_new_medal kani_new_medal sasori_new_medal" -> "bikaso";
            case "same_medal kujira_medal ookamiuo_medal" -> "saramiuo";
            case "love_core_medal love_core2_medal love_core3_medal" -> "love";
            case "taka_medal imagin_medal shocker_medal", "taka_ankh_medal imagin_medal shocker_medal" -> "tamashiy";
            default -> "false";
        };
    }

    @Override
    public String getUnlimitedBeltTextures(ItemStack itemstack, LivingEntity rider, String riderName, int num) {
        if (riderName.equals("ooo")) {
            switch (num) {
                case 1:
                    return getFormItem(itemstack, 1).getBeltTex() + getFormItem(itemstack, 1).getFormName(false);
                case 2:
                    return getFormItem(itemstack, 1).getBeltTex() + getFormItem(itemstack, 2).getFormName(false);
                case 3:
                    return getFormItem(itemstack, 1).getBeltTex() + getFormItem(itemstack, 3).getFormName(false);
            }
        }
        return "blank";
    }


    @Override
    public String getText(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName) {
        boolean fly = Objects.requireNonNull(rider.getAttribute(Attributes.WINGS_OUT)).getBaseValue() == 1;
        double henshinTick = Objects.requireNonNull(rider.getAttribute(Attributes.IS_TRANSFORMING)).getBaseValue();
        String combo = getCombo(getFormItem(itemstack, 1, henshinTick), getFormItem(itemstack, 2, henshinTick), getFormItem(itemstack, 3, henshinTick));
        if (equipmentSlot!=EquipmentSlot.FEET&getFormItem(itemstack, 1, Objects.requireNonNull(rider.getAttribute(Attributes.IS_TRANSFORMING)).getBaseValue())== ModdedItemCore.BLANK_FORM.asItem())return "blank";
        switch (equipmentSlot) {
            case EquipmentSlot.FEET:
                if (((RiderDriverItem) itemstack.getItem()).beltText == null || !((RiderDriverItem) itemstack.getItem()).beltText.isEmpty()) {
                    return "belts/" + getFormItem(itemstack, 1).getBeltTex();
                }
                break;
            case EquipmentSlot.HEAD:
                if (combo.contains("tajadol")) {
                    return riderName + "_taka_tajado";
                } else if (rider.getMainHandItem().getItem() == OOORiderItems.MEDAGABURYU.get() & combo.equals("tatoba")) {
                    return riderName + "_taka_purple";
                } else if (combo.equals("ancient_tatoba_greed")) {
                    return riderName + getFormItem(itemstack, 1, henshinTick).getFormName(fly) + "_greeed_absorption";
                }
                return riderName + getFormItem(itemstack, 1, henshinTick).getFormName(fly);
            case EquipmentSlot.CHEST:
                return riderName + getFormItem(itemstack, 2, henshinTick).getFormName(fly);
            case EquipmentSlot.LEGS:
                if (combo.equals("ancient_tatoba_greed")) {
                    return riderName + getFormItem(itemstack, 3, henshinTick).getFormName(fly) + "_greeed_absorption";
                }
        }
        return riderName + getFormItem(itemstack, 3, henshinTick).getFormName(fly);
    }

    public ResourceLocation getBeltModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/belts/ooo_belt.geo.json");
    }

    public boolean getGlowForSlot(ItemStack itemstack, EquipmentSlot currentSlot, LivingEntity livingEntity) {
        double henshinTick = Objects.requireNonNull(livingEntity.getAttribute(Attributes.IS_TRANSFORMING)).getBaseValue();
        if (currentSlot == EquipmentSlot.FEET) {
            return getFormItem(itemstack, 1, henshinTick).getIsBeltGlowing();
        }
        if (isTransformed(livingEntity)) {
            switch (currentSlot) {
                case HEAD -> {
                    return true;
                }
                case CHEST -> {
                    return getFormItem(itemstack, 2, henshinTick).getIsGlowing();
                }
            }
        }
        return false;
    }

    public ResourceLocation getModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
        int num = 1;
        double henshinTick = Objects.requireNonNull(rider.getAttribute(Attributes.IS_TRANSFORMING)).getBaseValue();

        if (slot == EquipmentSlot.CHEST) {
            num = 2;
        } else if (slot == EquipmentSlot.LEGS) {
            num = 3;
        }

        if (slot == EquipmentSlot.HEAD & getFormItem(itemstack, 1, henshinTick).getFormName(false).equals("_taka")
                & getFormItem(itemstack, 2, henshinTick).getFormName(false).equals("_kujaku")
                & getFormItem(itemstack, 3, henshinTick).getFormName(false).equals("_condor"))
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/armor/ooo_taka_tajado.geo.json");

        if (getFormItem(itemstack, num, henshinTick).hasWingsIfFlying() && Objects.requireNonNull(rider.getAttribute(Attributes.WINGS_OUT)).getBaseValue() == 1) {
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/armor/" + getFormItem(itemstack, num, henshinTick).getFlyingModel(this.riderName));
        } else
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/armor/" + getFormItem(itemstack, num, henshinTick).getModel(this.riderName));
    }

    @Override
    public boolean getPartsForSlot(ItemStack itemstack, EquipmentSlot currentSlot, String part) {
        switch (currentSlot) {
            case HEAD -> {
                if (part.equals("head") || part.equals("body")) {
                    return true;
                }
            }
            case CHEST -> {
                if (part.equals("body") || part.equals("rightArm") || part.equals("leftArm")) {
                    return true;
                }
            }
            case LEGS -> {
                if (part.equals("body") || part.equals("rightLeg") || part.equals("leftLeg")) {
                    return true;
                }
            }
        }
        return false;
    }
}