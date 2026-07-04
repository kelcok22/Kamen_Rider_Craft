package com.kelco.kamenridercraft.item.heisei_phase_2.ex_aid;

import com.google.common.collect.Lists;
import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.ServerConfig;
import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.summons.ParaDXSummonEntity;
import com.kelco.kamenridercraft.item.ModdedItemCore;
import com.kelco.kamenridercraft.item.base_items.RiderArmorItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.base_items.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.ExAidRiderItems;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
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
import java.util.Objects;

public class GamerDriverItem extends RiderDriverItem {
    public GamerDriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item> torso, DeferredItem<Item> legs, Properties properties) {
        super(material, rider, baseFormItem, head, torso, legs, properties);

        extraBaseFormItem = Lists.newArrayList((RiderFormChangeItem) ModdedItemCore.BLANK_FORM.get(), (RiderFormChangeItem) ModdedItemCore.BLANK_FORM.get());
        numBaseFormItems = 2;
    }

    public GamerDriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> armorFormItem, DeferredItem<Item> head, DeferredItem<Item> torso, DeferredItem<Item> legs, Properties properties) {
        super(material, rider, baseFormItem, armorFormItem, head, torso, legs, properties);

        extraBaseFormItem = Lists.newArrayList((RiderFormChangeItem) ModdedItemCore.BLANK_FORM.get(), (RiderFormChangeItem) ModdedItemCore.BLANK_FORM.get());
        numBaseFormItems = 2;
    }

    public void summonParaDX(Player player) {
        ParaDXSummonEntity paradx = MobsCore.PARADX_SUMMON.get().create(player.level());
        if (paradx != null) {
            paradx.moveTo(player.getX(), player.getY() + 1, player.getZ(), player.getYRot(), player.getXRot());
            if (RiderDriverItem.getFormItem(player.getItemBySlot(EquipmentSlot.FEET), 1) == ExAidRiderItems.KNOCK_OUT_FIGHTER_2_GASHAT.get()) {
                paradx.setItemSlot(EquipmentSlot.FEET, new ItemStack(ExAidRiderItems.GAMER_DRIVER_PARA_DX.get()));
                RiderDriverItem.setFormItem(paradx.getItemBySlot(EquipmentSlot.FEET), ExAidRiderItems.KNOCK_OUT_FIGHTER_2_GASHAT.get(), 1);
            } else
                paradx.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ExAidRiderItems.GASHACON_KEY_SLASHER.get()));
            player.level().addFreshEntity(paradx);
            paradx.bindToPlayer(player);
        }
    }

    public static boolean paradxSummoned(Player player) {
        for (ParaDXSummonEntity entity : player.level().getEntitiesOfClass(ParaDXSummonEntity.class,
                player.getBoundingBox().inflate(99), entity -> entity.getOwner() == player)) {
            if (entity != null) {
				return true;
			}
        }
        return false;
    }

    public void onTransformation(ItemStack itemstack, LivingEntity entity) {
        if (entity instanceof Player player && ServerConfig.mightyBrotherSpawning && !paradxSummoned(player)
                && itemstack.getItem() == ExAidRiderItems.GAMER_DRIVER_EX_AID.get()
                && (RiderDriverItem.getFormItem(itemstack, 1) == ExAidRiderItems.MIGHTY_BROTHERS_XX_GASHAT_R.get()
                || RiderDriverItem.getFormItem(itemstack, 1) == ExAidRiderItems.MIGHTY_BROTHERS_XX_GASHAT_L.get()
                || RiderDriverItem.getFormItem(itemstack, 1) == ExAidRiderItems.KNOCK_OUT_FIGHTER_2_GASHAT.get()))
            summonParaDX(player);
        super.onTransformation(itemstack, entity);
    }

    public void onFormChange(ItemStack itemstack, LivingEntity entity, CompoundTag tag) {
        if (entity instanceof Player player && !player.level().isClientSide() && isTransformed(player)
                && ServerConfig.mightyBrotherSpawning && !paradxSummoned(player)
                && itemstack.getItem() == ExAidRiderItems.GAMER_DRIVER_EX_AID.get()
                && (RiderDriverItem.getFormItem(itemstack, 1) == ExAidRiderItems.MIGHTY_BROTHERS_XX_GASHAT_R.get()
                || RiderDriverItem.getFormItem(itemstack, 1) == ExAidRiderItems.MIGHTY_BROTHERS_XX_GASHAT_L.get()
                || RiderDriverItem.getFormItem(itemstack, 1) == ExAidRiderItems.KNOCK_OUT_FIGHTER_2_GASHAT.get()))
            summonParaDX(player);
        super.onFormChange(itemstack, entity, tag);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        this.hasBasicBeltInfo = false;
        Item formItem = getFormItem(stack, 1);
        Item formItem2 = getFormItem(stack, 2);

        if (this == ExAidRiderItems.GAMER_DRIVER_SNIPE.get() && formItem == ExAidRiderItems.KAMEN_RIDER_CHRONICLE_GASHAT.get())
            tooltipComponents.add(Component.translatable("kamenridercraft.name.chronos"));
        else if (formItem == ExAidRiderItems.BAKUSOU_BIKE_GASHAT_TURBO.get())
            tooltipComponents.add(Component.translatable("kamenridercraft.name.lazer_turbo"));
        else tooltipComponents.add(Component.translatable("kamenridercraft.name." + riderName));

        if (this.showBeltFormInfo) {
            if (formItem2 != ModdedItemCore.BLANK_FORM.get())
                tooltipComponents.add(Component.translatable(formItem2.toString() + ".form", Component.translatable(formItem.toString() + ".form_base")));
            else tooltipComponents.add(Component.translatable(formItem.toString() + ".form"));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    @Override
    public String getText(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName) {
        if (equipmentSlot == EquipmentSlot.FEET) {
            String belt = ((RiderDriverItem) itemstack.getItem()).beltText;
            if (((RiderDriverItem) itemstack.getItem()).beltText == null) {
                belt = getFormItem(itemstack, 1).getBeltTex();
            }

            if (itemstack.getItem() == ExAidRiderItems.GASHACON_BUGVISOR_GENM.get() && rider.isHolding(ExAidRiderItems.GASHACON_BUGVISOR.get()))
                belt = "bugster_buckle";
            if ((itemstack.getItem() == ExAidRiderItems.GASHACON_BUGVISOR_II_CHRONOS.get() || itemstack.getItem() == ExAidRiderItems.GASHACON_BUGVISOR_II_CHRONICLE_BUGTER.get()
                    || itemstack.getItem() == ExAidRiderItems.GASHACON_BUGVISOR_II_POPPY.get() || itemstack.getItem() == ExAidRiderItems.GASHACON_BUGVISOR_II_LAZER.get())
                    && rider.isHolding(ExAidRiderItems.GASHACON_BUGVISOR_II.get())) belt = "bugster_buckle";

            if (Objects.equals(getFormItem(itemstack, 1).getBeltModel(), "geo/lv_1_belt.geo.json")) {
                if (!isTransformed(rider)) belt = getFormItem(itemstack, 1).getBeltTex() + "_un";
            }

            return "belts/" + belt;
        } else if (equipmentSlot == EquipmentSlot.CHEST) {
            RiderDriverItem belt = ((RiderDriverItem) itemstack.getItem());
            if (belt == ExAidRiderItems.GAMER_DRIVER_BRAVE.get() & getFormItem(itemstack, 2) == ExAidRiderItems.DOREMIFA_BEAT_GASHAT.get()
                    & rider.hasEffect(EffectCore.CHRISTMAS)) {
                return "beat_gamer_christmas";
            } else return getFormItem(itemstack, 2).getFormName(false);
        } else {
            RiderDriverItem belt = ((RiderDriverItem) itemstack.getItem());
            if (belt == ExAidRiderItems.GAMER_DRIVER_EX_AID.get() & getFormItem(itemstack, 1) == ExAidRiderItems.MIGHTY_ACTION_X_GASHAT_LV_1.get()
                    & rider.hasEffect(EffectCore.CHRISTMAS)) {
                return riderName + "_lv1_christmas";
            }

            if (belt == ExAidRiderItems.GAMER_DRIVER_SNIPE.get()) {
                if (getFormItem(itemstack, 2) == ExAidRiderItems.JET_COMBAT_GASHAT.get() ||
                        getFormItem(itemstack, 2) == ExAidRiderItems.BANG_BANG_TANK_GASHAT.get() ||
                        getFormItem(itemstack, 2) == ExAidRiderItems.XEVIOUS_GASHAT.get()) {
                    return riderName + "_jet";
                } else if (getFormItem(itemstack, 2) == ExAidRiderItems.BANG_BANG_SIMULATION_GASHAT.get()) {
                    return riderName + "_nocape";
                }

            }
        }
        return riderName + getFormItem(itemstack, 1).getFormName(false);

    }

    public ResourceLocation getBeltModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {

        if (Objects.equals(getFormItem(itemstack, 1).getBeltModel(), "geo/lv_1_belt.geo.json") && !isTransformed(rider)) {
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/riderbelt.geo.json");
        }

        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, getFormItem(itemstack, 1).getBeltModel());
    }

    public boolean getGlowForSlot(ItemStack itemstack, EquipmentSlot currentSlot, LivingEntity livingEntity) {

        if (currentSlot == EquipmentSlot.FEET) {
            return getFormItem(itemstack, 1).getIsBeltGlowing();
        } else if (isTransformed(livingEntity)) {
            if (Objects.requireNonNull(currentSlot) == EquipmentSlot.CHEST) {
                return getFormItem(itemstack, 2).getIsGlowing();
            }
            return getFormItem(itemstack, 1).getIsGlowing();
        }
        return false;
    }

    public ResourceLocation getModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {

        if (slot == EquipmentSlot.CHEST) {
            if (getFormItem(itemstack, 2).hasWingsIfFlying() && rider.getAttribute(Attributes.WINGS_OUT).getBaseValue() == 1) {
                return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/" + getFormItem(itemstack, 2).getFlyingModel(this.riderName));
            } else if (Objects.equals(getFormItem(itemstack, 2).getModel(this.riderName), "default.geo.json")) {
                return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/bigger_rider_plusbelt.geo.json");
            }
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/" + getFormItem(itemstack, 2).getModel(this.riderName));
        }
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/" + getFormItem(itemstack, 1).getModel(this.riderName));

    }

    @Override
    public boolean getPartsForSlot(ItemStack itemstack, EquipmentSlot currentSlot, String part) {

        switch (currentSlot) {
            case HEAD -> {
                return true;
            }
            case CHEST -> {
                if (getFormItem(itemstack, 2) != ModdedItemCore.BLANK_FORM.get()) return true;
            }
            default -> {
            }
        }
        return false;
    }

}