package com.kelco.kamenridercraft.item.base_items;


import com.google.common.collect.Lists;
import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.entity.mobs.summons.RiderSummonEntity;
import com.kelco.kamenridercraft.item.ModdedItemCore;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.cache.GeckoLibCache;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RiderFormChangeItem extends BaseItem {

    private String FORM_NAME;
    private int Slot = 1;
    private int OffhandSlot = 10;
    private Boolean Offhand = false;

    private List<MobEffectInstance> potionEffectList;
    private List<Item> NEEDITEM = new ArrayList<>();
    protected String RIDER_NAME;
    protected String OVERRIDE_RIDER_NAME;

    private String BELT_TEX;
    private Boolean IS_GLOWING = false;
    private Boolean IS_BELT_GLOWING = false;
    private Boolean HAS_STATIC_WINGS = false;
    private String UPDATED_BELT_MODEL;
    private String UPDATED_MODEL;
    private String FLYING_MODEL;
    private Boolean SET_SHOW_FACE = false;
    private Boolean SET_SHOW_UNDER = false;

    private Boolean USE_WALK = false;
    private Boolean USE_BIKE = false;
    private Boolean HAS_CAPE = false;


    private Boolean A1 = false;
    private Boolean SD = false;

    private Boolean FLYING_TEXT = false;
    private Item STIFT_ITEM;
    private Item SWITCH_ITEM;
    private Boolean RESET_FORM = false;
    private Boolean RESET_FORM_MAIN = false;

    private Boolean isGold = false;

    private Boolean SET_TO_ARMOR_FORM = false;

    private List<RiderFormChangeItem> alternative = new ArrayList<>();
    private RiderFormChangeItem alsoChange1stSlot;
    private RiderFormChangeItem alsoChange2ndSlot;
    private RiderFormChangeItem alsoChange3rdSlot;
    private RiderFormChangeItem alsoChange4thSlot;
    private RiderFormChangeItem alsoChange5thSlot;

    private Boolean hasIncompatibleForms = false;
    private List<RiderFormChangeItem> incompatibleForms = new ArrayList<>();

    public String[] compatibilityList = new String[]{""};
    public List<Item> needItemList = new ArrayList<>();

    private Boolean NEED_BASE_FORM = false;
    private RiderFormChangeItem NEED_FORM_SLOT_1;
    private RiderFormChangeItem NEED_FORM_SLOT_2;
    private RiderFormChangeItem NEED_FORM_SLOT_3;
    private RiderFormChangeItem NEED_FORM_SLOT_4;

    private int timeoutDuration = 0;
    private int lockDuration = 0;
    private RiderFormChangeItem REVERT_FORM;

    private Boolean IGNORE_BELT_TEXT = false;

    private boolean allowsRiderKick = false;

    private int Store_num = 1;

    private String slotOneAbility = "";
    private int slotOneAbilityPriority = 0;
    private String slotTwoAbility = "";
    private int slotTwoAbilityPriority = 0;

    public RiderFormChangeItem(Properties properties, String formName, String ridername, String beltTex, MobEffectInstance... effects) {
        super(properties);

        potionEffectList = Lists.newArrayList(effects);
        FORM_NAME = formName;
        BELT_TEX = beltTex;
        RIDER_NAME = ridername;
    }


    public List<MobEffectInstance> getPotionEffectList() {
        return potionEffectList;
    }

    public int getSlot() {
        return Slot;
    }

    public String getFormName(Boolean isFlying) {
        return (isFlying & FLYING_TEXT ? FORM_NAME + "_wing" : FORM_NAME);
    }

    public String getRiderName(String name) {
        return (OVERRIDE_RIDER_NAME != null ? OVERRIDE_RIDER_NAME : name);
    }


    public String getBeltTex() {
        return BELT_TEX;
    }

    public List<RiderFormChangeItem> getAlternative() {
        return alternative;
    }


    public Boolean getIgnoreOverrideBeltText() {
        return IGNORE_BELT_TEXT;
    }

    public String getBeltModel() {
        return (UPDATED_BELT_MODEL != null ? UPDATED_BELT_MODEL : "geo/riderbelt.geo.json");
    }

    public String getModel(String riderName) {
        if (UPDATED_MODEL != null) return UPDATED_MODEL;
        ResourceLocation FORM_MODEL = ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/" + getRiderName(riderName) + FORM_NAME + ".geo.json");
        return (GeckoLibCache.getBakedModels().get(FORM_MODEL) != null ? getRiderName(riderName) + FORM_NAME + ".geo.json" : (get_Has_SgetHasStaticWings() ? "default_wings_armor.geo.json" : "default.geo.json"));
    }

    public Boolean getShowFace() {
        return SET_SHOW_FACE;
    }

    public Boolean getShowUnder() {
        return SET_SHOW_UNDER;
    }

    public Boolean getIsGlowing() {
        return IS_GLOWING;
    }

    public Boolean getA1() {
        return A1;
    }

    public Boolean getSD() {
        return SD;
    }

    public String getSlotOneAbility() {
        return slotOneAbility.toLowerCase();
    }

    public int getSlotOneAbilityPriotiy() {
        return slotOneAbilityPriority;
    }

    public String getSlotTwoAbility() {
        return slotTwoAbility.toLowerCase();
    }

    public int getSlotTwoAbilityPriority() {
        return slotTwoAbilityPriority;
    }

    public Boolean getHasCape() {
        return HAS_CAPE;
    }

    public Boolean getIsBike() {
        return USE_BIKE;
    }

    public Boolean getIsBeltGlowing() {
        return IS_BELT_GLOWING;
    }

    public Boolean get_Has_SgetHasStaticWings() {
        return HAS_STATIC_WINGS;
    }

    public Boolean getIsResetForm() {
        return RESET_FORM;
    }

    public Boolean getIsResetFormMain() {
        return RESET_FORM_MAIN;
    }

    public Item getStiftItem() {
        return STIFT_ITEM;
    }


    public int getStoredNum() {
        return Store_num;
    }

    public String getFlyingModel(String riderName) {
        if (FLYING_MODEL != null) return FLYING_MODEL;
        ResourceLocation FORM_MODEL = ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/" + getRiderName(riderName) + FORM_NAME + "_wing.geo.json");
        return (GeckoLibCache.getBakedModels().get(FORM_MODEL) != null ? getRiderName(riderName) + FORM_NAME + "_wing.geo.json" : "rider_plusbelt_and_wings.geo.json");
    }

    public Boolean hasWingsIfFlying() {
        return FLYING_TEXT;
    }

    public RiderFormChangeItem addIncompatibleForm(Item item) {
        incompatibleForms.add((RiderFormChangeItem) item);
        hasIncompatibleForms = true;
        return this;
    }

    public RiderFormChangeItem alsoChange1stSlot(Item item) {
        alsoChange1stSlot = (RiderFormChangeItem) item;
        return this;
    }

    public RiderFormChangeItem alsoChange2ndSlot(Item item) {
        alsoChange2ndSlot = (RiderFormChangeItem) item;
        return this;
    }

    public RiderFormChangeItem alsoChange3rdSlot(Item item) {
        alsoChange3rdSlot = (RiderFormChangeItem) item;
        return this;
    }

    public RiderFormChangeItem alsoChange4thSlot(Item item) {
        alsoChange4thSlot = (RiderFormChangeItem) item;
        return this;
    }

    public RiderFormChangeItem alsoChange5thSlot(Item item) {
        alsoChange5thSlot = (RiderFormChangeItem) item;
        return this;
    }

    public RiderFormChangeItem changeRiderName(String name) {
        OVERRIDE_RIDER_NAME = name;
        return this;
    }

    public RiderFormChangeItem changeModel(String model) {
        UPDATED_MODEL = model;
        return this;
    }

    public RiderFormChangeItem setShowFace() {
        SET_SHOW_FACE = true;
        return this;
    }

    public RiderFormChangeItem setShowUnder() {
        SET_SHOW_UNDER = true;
        return this;
    }

    public RiderFormChangeItem isGold() {
        isGold = true;
        return this;
    }

    public RiderFormChangeItem setSlotOneAbility(String abilityChange, int abilityPriority) {
        slotOneAbility = abilityChange.toLowerCase();
        slotOneAbilityPriority = abilityPriority;
        return this;
    }

    public RiderFormChangeItem setSlotTwoAbility(String abilityChange, int abilityPriority) {
        slotTwoAbility = abilityChange.toLowerCase();
        slotTwoAbilityPriority = abilityPriority;
        return this;
    }

    public RiderFormChangeItem changeBeltModel(String model) {
        UPDATED_BELT_MODEL = model;
        return this;
    }

    public RiderFormChangeItem changeSlot(int slot) {
        Slot = slot;
        return this;
    }

    public int getTimeoutDuration() {
        return this.timeoutDuration;
    }

    public int getLockDuration() {
        return this.lockDuration;
    }

    public RiderFormChangeItem getRevertForm() {
        return this.REVERT_FORM;
    }

    public RiderFormChangeItem hasTimeout(int timeout, int lock, RiderFormChangeItem revertsTo) {
        timeoutDuration = timeout;
        lockDuration = lock;
        REVERT_FORM = revertsTo;
        return this;
    }

    public RiderFormChangeItem addNum(int num) {
        Store_num = num;
        return this;
    }

    public RiderFormChangeItem setOffhandSlot(int slot) {
        OffhandSlot = slot;
        Offhand = true;
        return this;
    }


    public RiderFormChangeItem hasFlyingWings(@Nullable String model) {
        FLYING_TEXT = true;
        if (model != null) FLYING_MODEL = model;
        return this;
    }

    public RiderFormChangeItem addAlternative(Item item) {
        alternative.add((RiderFormChangeItem) item);
        return this;
    }

    public RiderFormChangeItem resetFormToBase() {
        RESET_FORM = true;
        return this;
    }

    public RiderFormChangeItem resetFormToBaseIfMain() {
        RESET_FORM_MAIN = true;
        return this;
    }

    public RiderFormChangeItem setFormToArmor() {
        SET_TO_ARMOR_FORM = true;
        return this;
    }

    public RiderFormChangeItem isGlowing() {
        IS_GLOWING = true;
        return this;
    }

    public RiderFormChangeItem hasCape() {
        HAS_CAPE = true;
        return this;
    }

    public RiderFormChangeItem isBike() {
        USE_BIKE = true;
        return this;
    }


    public RiderFormChangeItem isA1() {
        A1 = true;
        return this;
    }

    public RiderFormChangeItem hasSD() {
        SD = true;
        return this;
    }

    public RiderFormChangeItem IsBeltGlowing() {
        IS_BELT_GLOWING = true;
        return this;
    }

    public RiderFormChangeItem hasStaticWings() {
        HAS_STATIC_WINGS = true;
        return this;
    }

    public RiderFormChangeItem needBaseForm() {
        NEED_BASE_FORM = true;
        return this;
    }

    public RiderFormChangeItem ignoreOverrideBeltText() {
        IGNORE_BELT_TEXT = true;
        return this;
    }

    public RiderFormChangeItem allowRiderKick() {
        this.allowsRiderKick = true;
        return this;
    }

    public RiderFormChangeItem addNeedForm(Item item) {
        NEED_FORM_SLOT_1 = ((RiderFormChangeItem) item);
        return this;
    }

    public RiderFormChangeItem addNeedForm(Item item, int slot) {

        if (slot == 1) NEED_FORM_SLOT_1 = ((RiderFormChangeItem) item);
        else if (slot == 2) NEED_FORM_SLOT_2 = ((RiderFormChangeItem) item);
        else if (slot == 3) NEED_FORM_SLOT_3 = ((RiderFormChangeItem) item);
        else if (slot == 4) NEED_FORM_SLOT_4 = ((RiderFormChangeItem) item);
        return this;
    }

    public RiderFormChangeItem addNeedItem(Item item) {
        NEEDITEM.add(item);
        return this;
    }

    public RiderFormChangeItem addShiftForm(Item item) {
        STIFT_ITEM = item;
        return this;
    }

    public RiderFormChangeItem addSwitchForm(Item item) {
        SWITCH_ITEM = item;
        return this;
    }

    public RiderFormChangeItem addNeedItemList(List<Item> NEED_ITEM) {
        needItemList = NEED_ITEM;
        return this;
    }

    public RiderFormChangeItem addCompatibilityList(String[] List) {
        compatibilityList = List;
        return this;
    }


    public Boolean isCompatible(RiderDriverItem belt) {
        if (Objects.equals(belt.Rider, RIDER_NAME)) return true;
        for (String str : compatibilityList) {
            if (Objects.equals(str, belt.Rider)) return true;
        }
        ItemStack itemstack = new ItemStack(belt);
        return itemstack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "form_change_item/works_with/" + RIDER_NAME + FORM_NAME)));
    }

    public Boolean checkGold() {
        return this.isGold;
    }

    public boolean inventoryOrHolderContains(Player player, Item item) {
        NonNullList<ItemStack> inv = NonNullList.create();
        inv.addAll(player.getInventory().items);
        inv.addAll(player.getInventory().armor);
        inv.add(player.getInventory().offhand.getFirst());

        if (player.getInventory().countItem(item) != 0) return true;
        else for (ItemStack itemStack : inv) {
            if (itemStack.has(DataComponents.CONTAINER)) {
                for (ItemStack stack : itemStack.getComponents().get(DataComponents.CONTAINER).nonEmptyItems())
                    if (stack.getItem() == item) return true;
            } else if (itemStack.has(DataComponents.BUNDLE_CONTENTS))
                for (ItemStack stack : itemStack.getComponents().get(DataComponents.BUNDLE_CONTENTS).items())
                    if (stack.getItem() == item) return true;
        }
        return false;
    }

    public Boolean canChange(Player player, RiderDriverItem belt, ItemStack stack) {

        if (this == ModdedItemCore.BLANK_FORM.get()) {
            //return true;
        }
        if (hasIncompatibleForms) {
            for (RiderFormChangeItem incompatibleForm : incompatibleForms) {
                int num_forms = belt.Num_Base_Form_Item;
                for (int n = 0; n < num_forms; n++) {
                    if (incompatibleForm == RiderDriverItem.getFormItem(stack, n + 1)) {
                        return false;
                    }
                }
            }
        }
        if (!isCompatible(belt)) {
            return false;
        }
        if (!NEEDITEM.isEmpty()) {
            for (Item item : NEEDITEM) {
                if (!inventoryOrHolderContains(player, item)) return false;
            }
        }
        if (NEED_BASE_FORM) if (RiderDriverItem.getFormItem(stack, 1) != belt.Base_Form_Item) return false;
        if (NEED_FORM_SLOT_1 != null) if (RiderDriverItem.getFormItem(stack, 1) != NEED_FORM_SLOT_1) return false;
        if (NEED_FORM_SLOT_2 != null) if (RiderDriverItem.getFormItem(stack, 2) != NEED_FORM_SLOT_2) return false;
        if (NEED_FORM_SLOT_3 != null) if (RiderDriverItem.getFormItem(stack, 3) != NEED_FORM_SLOT_3) return false;
        if (NEED_FORM_SLOT_4 != null) if (RiderDriverItem.getFormItem(stack, 4) != NEED_FORM_SLOT_4) return false;

        if (!needItemList.isEmpty()) {
            for (Item item : needItemList) {
                if (!inventoryOrHolderContains(player, item)) return false;
            }
        }
        return true;
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity interactionTarget, InteractionHand usedHand) {
        if (interactionTarget instanceof RiderSummonEntity summon && summon.canChangeForms() && !summon.hasEffect(EffectCore.FORM_LOCK)) {
            ItemStack BELT = interactionTarget.getItemBySlot(EquipmentSlot.FEET);

            if (BELT.getItem() instanceof RiderDriverItem belt) {
                if (STIFT_ITEM instanceof RiderFormChangeItem form && player.isShiftKeyDown() && form.canChange(player, belt, BELT))
                    STIFT_ITEM.interactLivingEntity(new ItemStack(form), player, summon, usedHand);
                else if (canChange(player, belt, BELT)) {
                    if (RESET_FORM) RiderDriverItem.resetFormItem(summon.getItemBySlot(EquipmentSlot.FEET));
                    if (RESET_FORM_MAIN & Objects.equals(belt.Rider, RIDER_NAME))
                        RiderDriverItem.resetFormItem(summon.getItemBySlot(EquipmentSlot.FEET));
                    if (alsoChange1stSlot != null)
                        RiderDriverItem.setFormItem(summon.getItemBySlot(EquipmentSlot.FEET), alsoChange1stSlot, 1);
                    if (alsoChange2ndSlot != null)
                        RiderDriverItem.setFormItem(summon.getItemBySlot(EquipmentSlot.FEET), alsoChange2ndSlot, 2);
                    if (alsoChange3rdSlot != null)
                        RiderDriverItem.setFormItem(summon.getItemBySlot(EquipmentSlot.FEET), alsoChange3rdSlot, 3);
                    if (alsoChange4thSlot != null)
                        RiderDriverItem.setFormItem(summon.getItemBySlot(EquipmentSlot.FEET), alsoChange4thSlot, 4);

                    if (SET_TO_ARMOR_FORM)
                        RiderDriverItem.setFormItem(summon.getItemBySlot(EquipmentSlot.FEET), belt.Armor_Form_Item, 1);

                    int SLOT = Slot;
                    if (usedHand == InteractionHand.OFF_HAND & Offhand) SLOT = OffhandSlot;

                    if (SWITCH_ITEM != null & RiderDriverItem.getFormItem(summon.getItemBySlot(EquipmentSlot.FEET), SLOT) == this)
                        RiderDriverItem.setFormItem(summon.getItemBySlot(EquipmentSlot.FEET), SWITCH_ITEM, SLOT);
                    else RiderDriverItem.setFormItem(summon.getItemBySlot(EquipmentSlot.FEET), this, SLOT);
                    if (alsoChange5thSlot != null)
                        RiderDriverItem.setFormItem(summon.getItemBySlot(EquipmentSlot.FEET), alsoChange5thSlot, 5);

                } else if (!alternative.isEmpty()) {

                    for (RiderFormChangeItem alternativeItem_form_change : alternative) {
                        alternativeItem_form_change.interactLivingEntity(stack, player, summon, usedHand);
                    }
                }
            }
        }
        return InteractionResult.PASS;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {

        ItemStack itemstack = player.getItemInHand(usedHand);

        ItemStack BELT = player.getItemBySlot(EquipmentSlot.FEET);

        if (!player.hasEffect(EffectCore.FORM_LOCK)) {
            if (BELT.getItem() instanceof RiderDriverItem belt) {
                if (STIFT_ITEM instanceof RiderFormChangeItem form && player.isShiftKeyDown())
                    STIFT_ITEM.use(level, player, usedHand);
                else if (canChange(player, belt, BELT)) {
                    if (!player.isCreative()) {
                        player.getCooldowns().addCooldown(this, 60);
                        player.addEffect(new MobEffectInstance(EffectCore.FORM_LOCK, 20, 0, true, false));
                    }
                    if (RESET_FORM) RiderDriverItem.resetFormItem(player.getItemBySlot(EquipmentSlot.FEET));
                    if (RESET_FORM_MAIN & Objects.equals(belt.Rider, RIDER_NAME))
                        RiderDriverItem.resetFormItem(player.getItemBySlot(EquipmentSlot.FEET));
                    if (alsoChange1stSlot != null)
                        RiderDriverItem.setFormItem(player.getItemBySlot(EquipmentSlot.FEET), alsoChange1stSlot, 1);
                    if (alsoChange2ndSlot != null)
                        RiderDriverItem.setFormItem(player.getItemBySlot(EquipmentSlot.FEET), alsoChange2ndSlot, 2);
                    if (alsoChange3rdSlot != null)
                        RiderDriverItem.setFormItem(player.getItemBySlot(EquipmentSlot.FEET), alsoChange3rdSlot, 3);
                    if (alsoChange4thSlot != null)
                        RiderDriverItem.setFormItem(player.getItemBySlot(EquipmentSlot.FEET), alsoChange4thSlot, 4);

                    if (SET_TO_ARMOR_FORM)
                        RiderDriverItem.setFormItem(player.getItemBySlot(EquipmentSlot.FEET), belt.Armor_Form_Item, 1);

                    int SLOT = Slot;
                    if (usedHand == InteractionHand.OFF_HAND & Offhand) SLOT = OffhandSlot;

                    if (SWITCH_ITEM != null & RiderDriverItem.getFormItem(player.getItemBySlot(EquipmentSlot.FEET), SLOT) == this)
                        RiderDriverItem.setFormItem(player.getItemBySlot(EquipmentSlot.FEET), SWITCH_ITEM, SLOT);
                    else RiderDriverItem.setFormItem(player.getItemBySlot(EquipmentSlot.FEET), this, SLOT);
                    if (alsoChange5thSlot != null)
                        RiderDriverItem.setFormItem(player.getItemBySlot(EquipmentSlot.FEET), alsoChange5thSlot, 5);

                } else if (!alternative.isEmpty()) {

                    for (RiderFormChangeItem alternativeItem_form_change : alternative) {
                        alternativeItem_form_change.use(level, player, usedHand);
                    }
                }
            }
        }
        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());

    }

    public void OnTransformation(ItemStack itemstack, LivingEntity entity) {
        if (timeoutDuration != 0) {
            if (!(entity instanceof ArmorStand))
                entity.addEffect(new MobEffectInstance(EffectCore.FORM_TIMEOUT, this.timeoutDuration, 0, true, false));
            if (entity instanceof Player player && !player.isCreative())
                player.getCooldowns().addCooldown(this, this.lockDuration);
        }
    }
    public void transformationEffect(ItemStack itemstack, LivingEntity entity) {
        if (entity.level() instanceof ServerLevel sl) {
            sl.sendParticles(ParticleTypes.GUST,
                    entity.getX(), entity.getY() + 1.0,
                    entity.getZ(), 1, 0, 0, 0, 1);
        }
    }

    public void transformationEffect(ItemStack itemstack, LivingEntity entity, Double tick) {
     if (tick==30)transformationEffect(itemstack, entity);
    }
}