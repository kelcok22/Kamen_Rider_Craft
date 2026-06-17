package com.kelco.kamenridercraft.item.base_items;

import com.google.common.collect.Lists;
import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.EnemySummonEntity;
import com.kelco.kamenridercraft.entity.mobs.summons.BaseSummonEntity;
import com.kelco.kamenridercraft.network.payload.EndPosePayload;
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
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animation.AnimationState;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;


public class RiderDriverItem extends RiderArmorItem {


    public RiderFormChangeItem Base_Form_Item;
    public RiderFormChangeItem Armor_Form_Item;
    protected ArrayList<RiderFormChangeItem> Extra_Base_Form_Item;
    public String Rider;
    public Item HEAD;
    public Item TORSO;
    public Item LEGS;
    public int Num_Base_Form_Item = 1;
    public String BELT_TEXT;
    private Boolean A1 = false;
    private Boolean SD = false;
    public int Unlimited_Textures = 0;
    public int Unlimited_Belt_Textures = 0;
    public int abilityMultiplier = 1;

    public ResourceLocation abilitySlotOne = null;
    public ResourceLocation abilitySlotTwo = null;

    public String abilityEffectStateOne = "";
    public String abilityEffectStateTwo = "";
    public String abilityEffectStateThree = "";
    public String abilityEffectStateFour = "";
    public boolean kickModelModifier = false;

    public Boolean Has_Inventory = false;

    public Boolean Has_basic_belt_info = true;
    public Boolean Show_belt_form_info = true;


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


        Rider = rider;
        Base_Form_Item = ((RiderFormChangeItem) baseFormItem.get());
        Armor_Form_Item = ((RiderFormChangeItem) baseFormItem.get());
        HEAD = head.get();
        TORSO = torso.get();
        LEGS = legs.get();


        GeoItem.registerSyncedAnimatable(this);
    }

    public RiderDriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> armorFormItem, DeferredItem<Item> head, DeferredItem<Item> torso, DeferredItem<Item> legs, Properties properties) {
        super(material, BasicArmorItem.Type.BOOTS, properties);
        Rider = rider;
        Base_Form_Item = ((RiderFormChangeItem) baseFormItem.get());
        Armor_Form_Item = ((RiderFormChangeItem) armorFormItem.get());
        HEAD = head.get();
        TORSO = torso.get();
        LEGS = legs.get();
        GeoItem.registerSyncedAnimatable(this);
    }

    /**
     * Checks if a {@link net.minecraft.world.entity.LivingEntity} has transformed by equipping this item and its associated armor set.
     *
     * @param player The {@link net.minecraft.world.entity.LivingEntity} using the device
     * @return {@code true} if the entity is transformed, otherwise {@code false}
     *
     * @author Chair
     **/

    public boolean isTransformed(LivingEntity rider) {
        if (!(rider.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem)) return false;
        return rider.getItemBySlot(EquipmentSlot.HEAD).getItem() == HEAD.asItem()
                && rider.getItemBySlot(EquipmentSlot.CHEST).getItem() == TORSO.asItem()
                && rider.getItemBySlot(EquipmentSlot.LEGS).getItem() == LEGS.asItem()
                && rider.getItemBySlot(EquipmentSlot.FEET).getItem() == this;
    }


    public static boolean isTransforming(LivingEntity rider) {
        if (!(rider.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem)) return false;
        return rider.getAttribute(Attributes.IS_TRANSFORMING).getBaseValue() != 0;
    }

    public static boolean isKicking(LivingEntity rider) {
        if (!(rider.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem)) return false;
        else if (rider.getItemBySlot(EquipmentSlot.FEET).has(DataComponents.CUSTOM_DATA)) {
            CompoundTag tag = rider.getItemBySlot(EquipmentSlot.FEET).get(DataComponents.CUSTOM_DATA).getUnsafe();
            return tag.getBoolean("rider_kicking");
        }
        return false;
    }

    public static double getRenderType(ItemStack stack) {
        double form_double = 1;
        RiderFormChangeItem form = getFormItem(stack, 1);
        if (form.getShowFace()) form_double = 2;
        if (form.getShowUnder()) form_double = 3;
        return form_double;
    }


    public void beltTick(ItemStack stack, Level level, LivingEntity rider, int slotId) {
        if (stack.has(DataComponents.CUSTOM_DATA)) {
            CompoundTag tag = stack.get(DataComponents.CUSTOM_DATA).getUnsafe();
            if (tag.getBoolean("Update_form") && slotId == 36) onFormChange(stack, rider, tag);
            if (!isTransformed(rider) || slotId != 36) tag.putBoolean("Update_form", true);
            if (isTransformed(rider)) tag.putDouble("render_type", getRenderType(stack));
            if (!isTransformed(rider)) tag.putDouble("render_type", 0);

        } else {
            setUpdateForm(stack);
        }
    }


    public void giveEffects(LivingEntity rider) {
        if (isTransformed(rider)) {
            for (int n = 0; n < Num_Base_Form_Item; n++) {
                RiderFormChangeItem form = getFormItem(rider.getItemBySlot(EquipmentSlot.FEET), n + 1);
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
        for (int n = 1; n == this.Num_Base_Form_Item; n++) {
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
                        form.putBoolean("Update_form", true);
                    };
                    CustomData.update(DataComponents.CUSTOM_DATA, stack, data);
                }
            }
            if (player.hasEffect(EffectCore.FORM_TIMEOUT)) this.timeoutForms(player, stack);
        }
    }


    public void onFormChange(ItemStack itemstack, LivingEntity rider, CompoundTag tag) {
        if (isTransformed(rider)) {
            OnTransformation(itemstack, rider);
            Consumer<CompoundTag> data = form -> {
                form.putBoolean("Update_form", false);
                form.putDouble("render_type", getRenderType(itemstack));
            };
            CustomData.update(DataComponents.CUSTOM_DATA, itemstack, data);
            rider.getAttribute(Attributes.IS_TRANSFORMING).setBaseValue(30);
            rider.getAttribute(Attributes.CAPE_ROT).setBaseValue(0);
            rider.getAttribute(Attributes.WHEEL_ROT).setBaseValue(0);
            rider.getAttribute(Attributes.BALL_ROT).setBaseValue(0);
        }

    }

    public void OnTransformation(ItemStack itemstack, LivingEntity rider) {
        if (isTransformed(rider) && !rider.level().isClientSide()) {
            this.abilitySlotOne = null;
            this.abilitySlotTwo = null;
            this.kickModelModifier = false;
            for (int n = 0; n < Num_Base_Form_Item; n++) {
                RiderFormChangeItem form = getFormItem(itemstack, n + 1);
                form.OnTransformation(itemstack, rider);
                if (rider instanceof Player player && !player.isCreative()) {
                    PacketDistributor.sendToAllPlayers(new EndPosePayload(player.getStringUUID()));
                }
            }
        }
    }

    public RiderDriverItem addExtraBaseFormItems(DeferredItem<Item> item) {
        Extra_Base_Form_Item = Lists.newArrayList((RiderFormChangeItem) item.get());
        Num_Base_Form_Item = 2;
        return this;
    }

    public RiderDriverItem hideBeltFormInfo() {
        Show_belt_form_info = false;
        return this;
    }

    public RiderDriverItem hasInventoryGui() {
        Has_Inventory = true;
        return this;
    }

    public RiderDriverItem overrideBeltText(String belt) {
        BELT_TEXT = belt;
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
        Extra_Base_Form_Item = Lists.newArrayList((RiderFormChangeItem) item.get(), (RiderFormChangeItem) item2.get());
        Num_Base_Form_Item = 3;
        return this;
    }

    public RiderDriverItem addExtraBaseFormItems(DeferredItem<Item> item, DeferredItem<Item> item2, DeferredItem<Item> item3) {
        Extra_Base_Form_Item = Lists.newArrayList((RiderFormChangeItem) item.get(), (RiderFormChangeItem) item2.get(), (RiderFormChangeItem) item3.get());
        Num_Base_Form_Item = 4;
        return this;
    }

    public RiderDriverItem addExtraBaseFormItems(DeferredItem<Item> item, DeferredItem<Item> item2, DeferredItem<Item> item3, DeferredItem<Item> item4) {
        Extra_Base_Form_Item = Lists.newArrayList((RiderFormChangeItem) item.get(), (RiderFormChangeItem) item2.get(), (RiderFormChangeItem) item3.get(), (RiderFormChangeItem) item4.get());
        Num_Base_Form_Item = 5;
        return this;
    }


    public String getText(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName) {
        boolean fly = rider.getAttribute(Attributes.WINGS_OUT).getBaseValue() == 1;
        boolean sd = rider.getAttribute(Attributes.HEAD_SIZE).getValue() != 1 && getFormItem(itemstack, 1).getSD() & SD;

        if (equipmentSlot == EquipmentSlot.FEET) {
            String belt = ((RiderDriverItem) itemstack.getItem()).BELT_TEXT;
            if (((RiderDriverItem) itemstack.getItem()).BELT_TEXT == null || getFormItem(itemstack, 1).getIgnoreOverrideBeltText()) {
                belt = getFormItem(itemstack, 1).getBeltTex() + (sd ? "_sd" : "");
            }
            return "belts/" + belt;
        } else
            return getFormItem(itemstack, 1).getRiderName(riderName) + getFormItem(itemstack, 1).getFormName(fly) + (sd ? "_sd" : "");
    }

    public String getUnlimitedTextures(ItemStack itemstack, LivingEntity rider, String riderName, int num) {
        return "blank";
    }

    public String getUnlimitedBeltTextures(ItemStack itemstack, LivingEntity rider, String riderName, int num) {
        return "blank";
    }

    public ResourceLocation getBeltModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, getFormItem(itemstack, 1).getBeltModel());
    }

    public ResourceLocation getModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
        if (getFormItem(itemstack, 1).hasWingsIfFlying() && rider.getAttribute(Attributes.WINGS_OUT).getBaseValue() == 1) {
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/" + getFormItem(itemstack, 1).getFlyingModel(this.Rider));
        }
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/" + getFormItem(itemstack, 1).getModel(this.Rider));
    }


    public void setCustomAnimations(RiderArmorItem an, long instanceId, AnimationState<RiderArmorItem> state) {

    }

    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity rider) {
        if (!isTransformed(rider)) {
            return false;
        }
        boolean isGold = false;
        if (Num_Base_Form_Item != 1) {
            for (int n = 0; n < Num_Base_Form_Item - 1; n++) {
                if (getFormItem(stack, n).checkGold()) {
                    isGold = true;
                }
            }
        }
        if (getFormItem(stack, 1).checkGold()) {
            return true;
        }
        return isGold;
    }


    public static void resetFormItem(ItemStack itemstack) {

        if (itemstack.getItem() instanceof RiderDriverItem belt) {

            if (belt.Num_Base_Form_Item != 1) {
                for (int n = 0; n < belt.Num_Base_Form_Item - 1; n++) {
                    setFormItem(itemstack, belt.Extra_Base_Form_Item.get(n), 2 + n);
                }
            }
            setFormItem(itemstack, belt.Base_Form_Item, 1);

        }
    }

    public static void setUpdateForm(ItemStack itemstack) {
        if (!itemstack.has(DataComponents.CUSTOM_DATA)) {
            itemstack.set(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
        }
        if (itemstack.getItem() instanceof RiderDriverItem) {
            Consumer<CompoundTag> data = form -> {
                form.putBoolean("Update_form", true);
                form.putDouble("render_type", getRenderType(itemstack));
            };
            CustomData.update(DataComponents.CUSTOM_DATA, itemstack, data);
        }
    }


    public static void setFormItem(ItemStack itemstack, Item ITEM, int SLOT) {
        if (!itemstack.has(DataComponents.CUSTOM_DATA)) itemstack.set(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
        if (itemstack.getItem() instanceof RiderDriverItem driver) {
            Consumer<CompoundTag> data = form -> {
                if (!form.getString("slot_tex" + SLOT).equals(ITEM.toString())) {
                    form.putString("slot_tex" + SLOT, ITEM.toString());
                    form.putBoolean("Update_form", true);
                    form.putDouble("render_type", getRenderType(itemstack));
                }
            };

            CustomData.update(DataComponents.CUSTOM_DATA, itemstack, data);
            driver.setExtraFormItem(itemstack, ITEM, SLOT, itemstack.get(DataComponents.CUSTOM_DATA).copyTag());
        }
    }


    public void setExtraFormItem(ItemStack itemstack, Item ITEM, int SLOT, CompoundTag tag) {
    }


    public boolean getGlowForSlot(ItemStack itemstack, EquipmentSlot currentSlot, LivingEntity rider) {
        if (currentSlot == EquipmentSlot.FEET) return getFormItem(itemstack, 1).getIsBeltGlowing();
        else if (isTransformed(rider)) return getFormItem(itemstack, 1).getIsGlowing();
        return false;
    }

    public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
    }

    @Override
    public <T extends LivingEntity> int damageItem(ItemStack stack, int amount, @Nullable T rider, Consumer<Item> onBroken) {
        if (stack.has(DataComponents.CONTAINER) && stack.getDamageValue() == stack.getMaxDamage() - 1) {
            for (ItemStack card : stack.get(DataComponents.CONTAINER).nonEmptyItemsCopy()) rider.spawnAtLocation(card);
            if (rider instanceof ServerPlayer player) player.closeContainer();
            stack.set(DataComponents.CONTAINER, ItemContainerContents.EMPTY);
        }
        return amount;
    }

    public boolean getPartsForSlot(ItemStack itemstack, EquipmentSlot currentSlot, String part) {

        switch (currentSlot) {
            case HEAD -> {
                if (Objects.equals(part, "head")) return true;
            }
            case CHEST -> {
                if (Objects.equals(part, "body")) return true;
                if (Objects.equals(part, "rightArm")) return true;
                if (Objects.equals(part, "leftArm")) return true;
            }
            case LEGS -> {

                if (Objects.equals(part, "rightLeg")) return true;
                if (Objects.equals(part, "leftLeg")) return true;
            }
            default -> {
            }
        }
        return false;
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        LocalDate localdate = LocalDate.now();
        boolean isDateA1 = localdate.getMonthValue() == 4 && localdate.getDayOfMonth() == 1;

        if (Has_basic_belt_info) {
            if (A1 & isDateA1) tooltipComponents.add(Component.translatable("kamenridercraft.name." + Rider + ".a1"));
            else tooltipComponents.add(Component.translatable("kamenridercraft.name." + Rider));
            if (Show_belt_form_info) {
                {
                    RiderFormChangeItem formItem = getFormItem(stack, 1);
                    if (formItem.getA1() & isDateA1)
                        tooltipComponents.add(Component.translatable(formItem + ".form.a1"));
                    else tooltipComponents.add(Component.translatable(formItem + ".form"));
                }
            }
        }

        int i = 0;
        int j = 0;
        Iterator<ItemStack> var7 = stack.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY).nonEmptyItems().iterator();
        if (var7.hasNext()) tooltipComponents.add(Component.translatable("container.rider_belt"));

        while (var7.hasNext()) {
            ItemStack itemstack = var7.next();
            ++j;
            if (i <= 2) {
                ++i;
                tooltipComponents.add(Component.translatable("container.shulkerBox.itemCount", itemstack.getHoverName(), itemstack.getCount()));
            }
        }

        if (j - i > 0) {
            tooltipComponents.add(Component.translatable("container.shulkerBox.more", j - i).withStyle(ChatFormatting.ITALIC));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }


    public static RiderFormChangeItem getFormItem(ItemStack itemstack, int SLOT) {

        RiderDriverItem belt = (RiderDriverItem) itemstack.getItem();
        RiderFormChangeItem Base_Form_Item = (SLOT >= 2 ? belt.Extra_Base_Form_Item.get(SLOT - 2) : belt.Base_Form_Item);

        if (itemstack.has(DataComponents.CUSTOM_DATA)) {
            CompoundTag tag = itemstack.get(DataComponents.CUSTOM_DATA).getUnsafe();
            ResourceLocation Used_Form_Item = ResourceLocation.parse(tag.getString("slot_tex" + SLOT));
            if (BuiltInRegistries.ITEM.get(Used_Form_Item) instanceof RiderFormChangeItem formItem) {
                return formItem;
            }
        }
        return Base_Form_Item;
    }

    public boolean hasCape(ItemStack itemstack) {
        for (int n = 0; n < Num_Base_Form_Item; n++) {
            if (getFormItem(itemstack, n + 1).getHasCape()) return true;
        }
        return false;
    }
}