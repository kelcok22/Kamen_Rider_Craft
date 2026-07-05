package com.kelco.kamenridercraft.item.base_items;

import com.google.common.collect.Lists;
import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.EnemySummonEntity;
import com.kelco.kamenridercraft.entity.mobs.summons.BaseSummonEntity;
import com.kelco.kamenridercraft.item.ModdedItemCore;
import com.kelco.kamenridercraft.network.payload.EndAnimationPayload;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animation.AnimationState;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import static com.kelco.kamenridercraft.abilities.AbilityUtil.cancelAbility;
import static com.kelco.kamenridercraft.world.data_attachments.AttachmentTypes.USED_ABILITY;


public class RiderDriverItem extends RiderArmorItem {
    public RiderFormChangeItem baseFormItem;
    public RiderFormChangeItem armorFormItem;
    protected ArrayList<RiderFormChangeItem> extraBaseFormItem;

    public String riderName;
    public Item helmet;
    public Item chestplate;
    public Item leggings;
    public int numBaseFormItems = 1;
    public String beltText;
    private Boolean A1 = false;
    private Boolean SD = false;
    public int unlimitedTextures = 0;
    public int unlimitedBeltTextures = 0;
    public float abilityMultiplier = 2.5F;

    public ResourceLocation abilitySlotOne = null;
    public ResourceLocation abilitySlotTwo = null;


    public Boolean hasInventory = false;

    public Boolean hasBasicBeltInfo = true;
    public Boolean showBeltFormInfo = true;

    /**
     * Constructor for the main armor piece used by a Kamen Rider, kaijin, or other transforming character. This item uses the foot armor slot in all cases.
     *
     * @param material     The {@link ArmorMaterial} for the device (typically diamond)
     * @param rider        The name of the Rider that uses this device. A {@link RiderFormChangeItem} compares its {@code ridername} with this value to determine if the Rider can use the form attached to the item
     * @param baseFormItem The {@link RiderFormChangeItem} containing the Rider's base form
     * @param head         A helmet required to henshin, typically from a corresponding series
     * @param torso        A chestplate required to henshin, typically from a corresponding series
     * @param legs         A pair of leggings required to henshin, typically from a corresponding series
     * @param properties   The default {@link Properties} of the item
     * @author Kelco
     **/

    public RiderDriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item> torso, DeferredItem<Item> legs, Properties properties) {
        super(material, Type.BOOTS, properties);

        this.riderName = rider;
        this.baseFormItem = ((RiderFormChangeItem) baseFormItem.get());
        armorFormItem = ((RiderFormChangeItem) baseFormItem.get());
        helmet = head.get();
        chestplate = torso.get();
        leggings = legs.get();

        GeoItem.registerSyncedAnimatable(this);
    }

    public RiderDriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> armorFormItem, DeferredItem<Item> head, DeferredItem<Item> torso, DeferredItem<Item> legs, Properties properties) {
        super(material, Type.BOOTS, properties);
        this.riderName = rider;
        this.baseFormItem = ((RiderFormChangeItem) baseFormItem.get());
        this.armorFormItem = ((RiderFormChangeItem) armorFormItem.get());
        helmet = head.get();
        chestplate = torso.get();
        leggings = legs.get();
        GeoItem.registerSyncedAnimatable(this);
    }

    /**
     * Checks if a {@link LivingEntity} has transformed by equipping this item and its associated armor set.
     *
     * @param rider The {@link LivingEntity} using the device
     * @return {@code true} if the entity is transformed, otherwise {@code false}
     *
     * @author Chair
     **/

    public boolean isTransformed(LivingEntity rider) {
        if (!(rider.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem)) return false;
        return rider.getItemBySlot(EquipmentSlot.HEAD).getItem() == helmet.asItem()
                && rider.getItemBySlot(EquipmentSlot.CHEST).getItem() == chestplate.asItem()
                && rider.getItemBySlot(EquipmentSlot.LEGS).getItem() == leggings.asItem()
                && rider.getItemBySlot(EquipmentSlot.FEET).getItem() == this;
    }


    public static boolean isTransforming(LivingEntity rider) {
        if (!(rider.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem)) return false;
        return rider.getAttribute(Attributes.IS_TRANSFORMING).getBaseValue() != 0;
    }


    public static double getRenderType(ItemStack stack, double num) {
        double form_double = 1;
        RiderFormChangeItem form = getFormItem(stack, 1,num);
        if (form.getShowFace()) form_double = 2;
        if (form.getShowUnder()) form_double = 3;
        if (form.getShowPlayer()) form_double = 0;
        return form_double;
    }


    public void beltTick(ItemStack stack, Level level, LivingEntity rider, int slotId) {
        if (stack.has(DataComponents.CUSTOM_DATA)) {
            CompoundTag tag = stack.get(DataComponents.CUSTOM_DATA).getUnsafe();
            if (tag.getBoolean("Update_form") && slotId == 36) onFormChange(stack, rider, tag);
            if (!isTransformed(rider) || slotId != 36) tag.putBoolean("Update_form", true);
            if (isTransformed(rider)) tag.putDouble("render_type", getRenderType(stack,rider.getAttribute(Attributes.IS_TRANSFORMING).getBaseValue()));
            if (!isTransformed(rider)) tag.putDouble("render_type", 0);

            if (!rider.level().isClientSide()) {
                for (int n = 0; n < numBaseFormItems; n++) {
                    RiderFormChangeItem form = getFormItem(stack, n + 1);
                    form.transformationEffect(stack, rider, Objects.requireNonNull(rider.getAttribute(Attributes.IS_TRANSFORMING)).getBaseValue());
                }
            }
        } else {
            setUpdateForm(stack);
        }
    }


    public void giveEffects(LivingEntity rider) {
        if (isTransformed(rider)) {
            for (int n = 0; n < numBaseFormItems; n++) {
                RiderFormChangeItem form = getFormItem(rider.getItemBySlot(EquipmentSlot.FEET), n + 1, rider.getAttribute(Attributes.IS_TRANSFORMING).getBaseValue());
                List<MobEffectInstance> potionEffectList = form.getPotionEffectList();
                for (MobEffectInstance effect : potionEffectList) {
                    if ((effect.getEffect() != MobEffects.DAMAGE_BOOST &&
                            effect.getEffect() != MobEffects.DIG_SPEED &&
                            effect.getEffect() != MobEffects.REGENERATION &&
                            effect.getEffect() != MobEffects.DAMAGE_RESISTANCE &&
                            effect.getEffect() != MobEffects.MOVEMENT_SPEED &&
                            effect.getEffect() != EffectCore.NOTE &&
                            effect.getEffect() != EffectCore.SLASH &&
                            effect.getEffect() != EffectCore.PUNCH &&
                            effect.getEffect() != EffectCore.GREEED &&
                            effect.getEffect() != EffectCore.BUGSTER)
                            || ((rider instanceof BaseSummonEntity || rider instanceof EnemySummonEntity)
                            && (effect.getEffect() != MobEffects.DAMAGE_RESISTANCE || effect.getAmplifier() < 3)
                            && effect.getEffect() != EffectCore.GREEED &&
                            effect.getEffect() != EffectCore.BUGSTER)
                            || rider instanceof Player) {
                        rider.addEffect(new MobEffectInstance(effect.getEffect(), effect.getDuration(), effect.getAmplifier(), true, false));
                    }
                }
            }
        }
    }

    public void timeoutForms(LivingEntity rider, ItemStack stack) {
        for (int n = 1; n == this.numBaseFormItems; n++) {
            RiderFormChangeItem form = RiderDriverItem.getFormItem(stack, n);
            if (form.getTimeoutDuration() != 0) {
                RiderDriverItem.setFormItem(stack, form.getRevertForm(), n);
                rider.addEffect(new MobEffectInstance(EffectCore.FORM_LOCK, form.getLockDuration(), 0, false, false));
            }
        }
        rider.removeEffect(EffectCore.FORM_TIMEOUT);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (entity instanceof LivingEntity rider && stack == rider.getItemBySlot(EquipmentSlot.FEET)) {
            this.beltTick(stack, level, rider, slotId);
            this.giveEffects(rider);
            if (rider.hasEffect(EffectCore.FORM_TIMEOUT) && !isTransformed(rider))
                this.timeoutForms(rider, stack);
        } else if (entity instanceof LivingEntity player) {
            if (stack.has(DataComponents.CUSTOM_DATA)) {
                if (!isTransformed(player) || slotId != 36) {
                    Consumer<CompoundTag> data = form -> {
                        form.putBoolean("rider_kicking", false);
                        form.putDouble("rider_kick_cooldown", 200);
                        form.putDouble("rider_kick_tick", 0);
                        form.putDouble("render_type", 0);
                        form.putBoolean("Update_form", true);
                        form.putString("slot_tex_old" + 1,ModdedItemCore.BLANK_FORM.asItem().toString());
                    };
                    CustomData.update(DataComponents.CUSTOM_DATA, stack, data);
                }
            }else{
                setUpdateForm(stack);
            }
            if (player.hasEffect(EffectCore.FORM_TIMEOUT)) this.timeoutForms(player, stack);
        }
    }


    public void onFormChange(ItemStack itemStack, LivingEntity rider, CompoundTag tag) {
        if (isTransformed(rider)) {
            onTransformation(itemStack, rider);
            Consumer<CompoundTag> data = form -> {
                form.putBoolean("Update_form", false);
            };
            CustomData.update(DataComponents.CUSTOM_DATA, itemStack, data);
            rider.getAttribute(Attributes.IS_TRANSFORMING).setBaseValue(30);
            rider.getAttribute(Attributes.CAPE_ROT).setBaseValue(0);
            rider.getAttribute(Attributes.WHEEL_ROT).setBaseValue(0);
            rider.getAttribute(Attributes.BALL_ROT).setBaseValue(0);
        }

    }

    public void onTransformation(ItemStack itemStack, LivingEntity rider) {
        if (isTransformed(rider) && !rider.level().isClientSide()) {
            this.abilitySlotOne = null;
            this.abilitySlotTwo = null;
            cancelAbility(rider, "", 0);
            if (!rider.getData(USED_ABILITY).isEmpty()) {
                cancelAbility(rider, "", 0);
            }
            for (int n = 0; n < numBaseFormItems; n++) {
                RiderFormChangeItem form = getFormItem(itemStack, n + 1);
                form.OnTransformation(itemStack, rider);
                if (rider instanceof Player player && !player.isCreative()) {
                    PacketDistributor.sendToAllPlayers(new EndAnimationPayload(player.getStringUUID(), "pose"));
                }
            }
        }
    }

    public RiderDriverItem addExtraBaseFormItems(DeferredItem<Item> item) {
        extraBaseFormItem = Lists.newArrayList((RiderFormChangeItem) item.get());
        numBaseFormItems = 2;
        return this;
    }

    public RiderDriverItem hideBeltFormInfo() {
        showBeltFormInfo = false;
        return this;
    }

    public RiderDriverItem hasInventoryGui() {
        hasInventory = true;
        return this;
    }

    public RiderDriverItem overrideBeltText(String belt) {
        beltText = belt;
        return this;
    }

    public RiderDriverItem hasSDForm() {
        SD = true;
        return this;
    }

    public RiderDriverItem isA1() {
        A1 = true;
        return this;
    }

    public RiderDriverItem addExtraBaseFormItems(DeferredItem<Item> item, DeferredItem<Item> item2) {
        extraBaseFormItem = Lists.newArrayList((RiderFormChangeItem) item.get(), (RiderFormChangeItem) item2.get());
        numBaseFormItems = 3;
        return this;
    }

    public RiderDriverItem addExtraBaseFormItems(DeferredItem<Item> item, DeferredItem<Item> item2, DeferredItem<Item> item3) {
        extraBaseFormItem = Lists.newArrayList((RiderFormChangeItem) item.get(), (RiderFormChangeItem) item2.get(), (RiderFormChangeItem) item3.get());
        numBaseFormItems = 4;
        return this;
    }

    public RiderDriverItem addExtraBaseFormItems(DeferredItem<Item> item, DeferredItem<Item> item2, DeferredItem<Item> item3, DeferredItem<Item> item4) {
        extraBaseFormItem = Lists.newArrayList((RiderFormChangeItem) item.get(), (RiderFormChangeItem) item2.get(), (RiderFormChangeItem) item3.get(), (RiderFormChangeItem) item4.get());
        numBaseFormItems = 5;
        return this;
    }


    public String getText(ItemStack itemStack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName) {
        boolean fly = rider.getAttribute(Attributes.WINGS_OUT).getBaseValue() == 1;
        boolean sd = rider.getAttribute(Attributes.HEAD_SIZE).getValue() != 1 && getFormItem(itemStack, 1, rider.getAttribute(Attributes.IS_TRANSFORMING).getBaseValue()).getSD() & SD;

        if (equipmentSlot == EquipmentSlot.FEET) {
            String belt = ((RiderDriverItem) itemStack.getItem()).beltText;
            if (((RiderDriverItem) itemStack.getItem()).beltText == null || getFormItem(itemStack, 1).getIgnoreOverrideBeltText()) {
                belt = getFormItem(itemStack, 1).getBeltTex() + (sd ? "_sd" : "");
            }
            return "belts/" + belt;
        } else
            return getFormItem(itemStack, 1, rider.getAttribute(Attributes.IS_TRANSFORMING).getBaseValue()).getRiderName(riderName) + getFormItem(itemStack, 1, rider.getAttribute(Attributes.IS_TRANSFORMING).getBaseValue()).getFormName(fly) + (sd ? "_sd" : "");
    }

    public String getUnlimitedTextures(ItemStack itemStack, LivingEntity rider, String riderName, int num) {
        return "blank";
    }

    public String getUnlimitedBeltTextures(ItemStack itemStack, LivingEntity rider, String riderName, int num) {
        return "blank";
    }

    public ResourceLocation getBeltModelResource(ItemStack itemStack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, getFormItem(itemStack, 1, rider.getAttribute(Attributes.IS_TRANSFORMING).getBaseValue()).getBeltModel());
    }

    public ResourceLocation getModelResource(ItemStack itemStack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
        if (getFormItem(itemStack, 1, rider.getAttribute(Attributes.IS_TRANSFORMING).getBaseValue()).hasWingsIfFlying() && rider.getAttribute(Attributes.WINGS_OUT).getBaseValue() == 1) {
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/" + getFormItem(itemStack, 1, rider.getAttribute(Attributes.IS_TRANSFORMING).getBaseValue()).getFlyingModel(this.riderName));
        }
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/" + getFormItem(itemStack, 1, rider.getAttribute(Attributes.IS_TRANSFORMING).getBaseValue()).getModel(this.riderName));
    }


    public void setCustomAnimations(RiderArmorItem an, long instanceId, AnimationState<RiderArmorItem> state) {

    }

    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity rider) {
        if (!isTransformed(rider)) {
            return false;
        }
        boolean isGold = false;
        if (getFormItem(stack, 1, rider.getAttribute(Attributes.IS_TRANSFORMING).getBaseValue()).checkGold()) {
            return true;
        }
        if (numBaseFormItems != 1) {
            for (int n = 2; n < numBaseFormItems; n++) {
                if (getFormItem(stack, n, rider.getAttribute(Attributes.IS_TRANSFORMING).getBaseValue()).checkGold()) {
                    isGold = true;
                }
            }
        }
        return isGold;
    }


    public static void resetFormItem(ItemStack itemStack) {
        if (itemStack.getItem() instanceof RiderDriverItem belt) {
            if (belt.numBaseFormItems != 1) {
                for (int n = 0; n < belt.numBaseFormItems - 1; n++) {
                    setFormItem(itemStack, belt.extraBaseFormItem.get(n), 2 + n);
                }
            }
            setFormItem(itemStack, belt.baseFormItem, 1);
        }
    }

    public static void setUpdateForm(ItemStack itemStack) {
        if (!itemStack.has(DataComponents.CUSTOM_DATA)) {
            itemStack.set(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
        }
        if (itemStack.getItem() instanceof RiderDriverItem belt) {
            Consumer<CompoundTag> data = form -> {
                form.putBoolean("rider_kicking", false);
                form.putDouble("rider_kick_cooldown", 200);
                form.putDouble("rider_kick_tick", 0);
                form.putBoolean("Update_form", true);
                form.putDouble("render_type", 0);
                form.putString("slot_tex_old" + 1,ModdedItemCore.BLANK_FORM.asItem().toString());
                    for (int n = 1; n <= belt.numBaseFormItems; n++) {
                        form.putString("slot_tex" + n, getFormItem(itemStack,n).toString());
                    }
            };
            CustomData.update(DataComponents.CUSTOM_DATA, itemStack, data);
        }
    }


    public static void setFormItem(ItemStack itemStack, Item item, int slot) {
        if (!itemStack.has(DataComponents.CUSTOM_DATA)) itemStack.set(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
        if (itemStack.getItem() instanceof RiderDriverItem driver) {
            Consumer<CompoundTag> data = form -> {
                if (!form.getString("slot_tex" + slot).equals(item.toString())) {
                    form.putString("slot_tex" + slot, item.toString());
                    form.putBoolean("Update_form", true);
                }
            };

            CustomData.update(DataComponents.CUSTOM_DATA, itemStack, data);
            driver.setExtraFormItem(itemStack, item, slot, itemStack.get(DataComponents.CUSTOM_DATA).copyTag());
        }
    }


    public static void UpdateOldFormItem(ItemStack itemStack) {
        if (!itemStack.has(DataComponents.CUSTOM_DATA)) {
            itemStack.set(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
        }
        if (itemStack.getItem() instanceof RiderDriverItem driver) {
            Consumer<CompoundTag> data = form -> {
                for (int n = 1; n <= driver.numBaseFormItems; n++) {
                    form.putString("slot_tex_old" + n, form.getString("slot_tex" + n));
                }
            };
            CustomData.update(DataComponents.CUSTOM_DATA, itemStack, data);
        }
    }


    public void setExtraFormItem(ItemStack itemStack, Item ITEM, int SLOT, CompoundTag tag) {
    }


    public boolean getGlowForSlot(ItemStack itemStack, EquipmentSlot currentSlot, LivingEntity rider) {
        var transformingTick = Objects.requireNonNull(rider.getAttribute(Attributes.IS_TRANSFORMING)).getBaseValue();
        if (currentSlot == EquipmentSlot.FEET)
            return getFormItem(itemStack, 1, transformingTick).getIsBeltGlowing();
        else if (isTransformed(rider))
            return getFormItem(itemStack, 1, transformingTick).getIsGlowing();
        return false;
    }

    public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemStack) {
    }

    @Override
    public <T extends LivingEntity> int damageItem(ItemStack itemStack, int amount, @Nullable T rider, @NotNull Consumer<Item> onBroken) {
        if (itemStack.has(DataComponents.CONTAINER) && itemStack.getDamageValue() == itemStack.getMaxDamage() - 1) {
            for (ItemStack card : Objects.requireNonNull(itemStack.get(DataComponents.CONTAINER)).nonEmptyItemsCopy()) {
                assert rider != null;
                rider.spawnAtLocation(card);
            }
            if (rider instanceof ServerPlayer player) {
                player.closeContainer();
            }
            itemStack.set(DataComponents.CONTAINER, ItemContainerContents.EMPTY);
        }
        return amount;
    }

    public boolean getPartsForSlot(ItemStack itemStack, EquipmentSlot currentSlot, String part) {
        return currentSlot.equals(EquipmentSlot.HEAD);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        LocalDate localdate = LocalDate.now();
        boolean isDateA1 = localdate.getMonthValue() == 4 && localdate.getDayOfMonth() == 1;

        if (hasBasicBeltInfo) {
            if (A1 & isDateA1) {
                tooltipComponents.add(Component.translatable("kamenridercraft.name." + riderName + ".a1"));
            } else {
                tooltipComponents.add(Component.translatable("kamenridercraft.name." + riderName));
            }
            if (showBeltFormInfo) {
                RiderFormChangeItem formItem = getFormItem(itemStack, 1);
                if (formItem.getA1() & isDateA1) {
                    tooltipComponents.add(Component.translatable(formItem + ".form.a1"));

                } else {
                    tooltipComponents.add(Component.translatable(formItem + ".form"));
                }
            }
        }

        int i = 0;
        int j = 0;
        Iterator<ItemStack> var7 = itemStack.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY).nonEmptyItems().iterator();
        if (var7.hasNext()) {
            tooltipComponents.add(Component.translatable("container.rider_belt"));
        }

        while (var7.hasNext()) {
            ItemStack inventoryStack = var7.next();
            ++j;
            if (i <= 2) {
                ++i;
                tooltipComponents.add(Component.translatable("container.shulkerBox.itemCount", inventoryStack.getHoverName(), inventoryStack.getCount()));
            }
        }

        if (j - i > 0) {
            tooltipComponents.add(Component.translatable("container.shulkerBox.more", j - i).withStyle(ChatFormatting.ITALIC));
        }
        super.appendHoverText(itemStack, tooltipContext, tooltipComponents, tooltipFlag);
    }

    public static RiderFormChangeItem getFormItem(ItemStack itemStack, int slot, double num) {
        RiderDriverItem belt = (RiderDriverItem) itemStack.getItem();
        RiderFormChangeItem baseFormItem = (slot >= 2 ? belt.extraBaseFormItem.get(slot - 2) : belt.baseFormItem);

        if (itemStack.has(DataComponents.CUSTOM_DATA)) {
            CompoundTag tag = Objects.requireNonNull(itemStack.get(DataComponents.CUSTOM_DATA)).getUnsafe();
            ResourceLocation UsedFormItem = ResourceLocation.parse(tag.getString("slot_tex" + slot));
            ResourceLocation UsedFormItemOld = ResourceLocation.parse(tag.getString("slot_tex_old" + slot));
            if (BuiltInRegistries.ITEM.get(UsedFormItem) instanceof RiderFormChangeItem formItem) {
                if (BuiltInRegistries.ITEM.get(UsedFormItemOld) instanceof RiderFormChangeItem formItem2 && num > formItem.getFormDelay())
                    return formItem2;
                else if (num > formItem.getFormDelay()) return (RiderFormChangeItem) ModdedItemCore.BLANK_FORM.asItem();
                return formItem;
            }
        }
        return baseFormItem;
    }

    public static RiderFormChangeItem getFormItem(ItemStack itemStack, int slot) {
        return getFormItem(itemStack, slot, 0d);
    }

    public boolean hasCape(ItemStack itemStack) {
        for (int n = 0; n < numBaseFormItems; n++) {
            if (getFormItem(itemStack, n + 1).getHasCape()) {
                return true;
            }
        }
        return false;
    }

}