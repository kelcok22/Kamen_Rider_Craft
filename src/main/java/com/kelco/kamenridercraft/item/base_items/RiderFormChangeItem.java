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

    private String formName;
    private int slot = 1;
    private int offhandSlot = 10;
    private Boolean offhand = false;

    private List<MobEffectInstance> potionEffectList;
    private List<Item> needItem = new ArrayList<>();
    protected String riderName;
    protected String overrideRiderName;

    private String beltTex;
    private Boolean isGlowing = false;
    private Boolean isBeltGlowing = false;
    private Boolean hasStaticWings = false;
    private String updatedBeltModel;
    private String updatedModel;
    private String flyingModel;
    private Boolean setShowFace = false;
    private Boolean setShowUnder = false;
    private Boolean setShowPlayer = false;

    private Boolean useWalk = false;
    private Boolean useBike = false;
    private Boolean hasCape = false;


    private Boolean A1 = false;
    private Boolean SD = false;

    private Boolean flyingText = false;
    private Item shiftItem;
    private Item switchItem;
    private Boolean resetForm = false;
    private Boolean resetToMainForm = false;

    private Boolean isGold = false;

    private Boolean setToArmorForm = false;

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

    private Boolean needBaseForm = false;
    private RiderFormChangeItem needFormSlot1;
    private RiderFormChangeItem needFormSlot2;
    private RiderFormChangeItem needFormSlot3;
    private RiderFormChangeItem needFormSlot4;

    private int timeoutDuration = 0;
    private int lockDuration = 0;
    private RiderFormChangeItem revertForm;

    private Boolean ignoreBeltText = false;

    private int storeNum = 1;

    private String slotOneAbility = "";
    private int slotOneAbilityPriority = 0;
    private String slotTwoAbility = "";
    private int slotTwoAbilityPriority = 0;

    private Double formDelay = 30d;


    public RiderFormChangeItem(Properties properties, String formName, String riderName, String beltTex, MobEffectInstance... effects) {
        super(properties);

        potionEffectList = Lists.newArrayList(effects);
        this.formName = formName;
        this.beltTex = beltTex;
        this.riderName = riderName;
    }


    public List<MobEffectInstance> getPotionEffectList() {
        return potionEffectList;
    }

    public int getSlot() {
        return slot;
    }

    public String getFormName(Boolean isFlying) {
        return (isFlying & flyingText ? formName + "_wing" : formName);
    }

    public String getRiderName(String name) {
        return (overrideRiderName != null ? overrideRiderName : name);
    }


    public String getBeltTex() {
        return beltTex;
    }

    public Double getFormDelay() {
        return formDelay;
    }


    public List<RiderFormChangeItem> getAlternative() {
        return alternative;
    }


    public Boolean getIgnoreOverrideBeltText() {
        return ignoreBeltText;
    }

    public String getBeltModel() {
        return (updatedBeltModel != null ? updatedBeltModel : "geo/riderbelt.geo.json");
    }

    public String getModel(String riderName) {
        if (updatedModel != null) return updatedModel;
        ResourceLocation FORM_MODEL = ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/" + getRiderName(riderName) + formName + ".geo.json");
        return (GeckoLibCache.getBakedModels().get(FORM_MODEL) != null ? getRiderName(riderName) + formName + ".geo.json" : (getHasStaticWings() ? "default_wings_armor.geo.json" : "default.geo.json"));
    }

    public Boolean getShowFace() {
        return setShowFace;
    }

    public Boolean getShowUnder() {
        return setShowUnder;
    }

    public Boolean getShowPlayer() {
        return setShowPlayer;
    }

    public Boolean getIsGlowing() {
        return isGlowing;
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
        return hasCape;
    }

    public Boolean getIsBike() {
        return useBike;
    }

    public Boolean getIsBeltGlowing() {
        return isBeltGlowing;
    }

    public Boolean getHasStaticWings() {
        return hasStaticWings;
    }

    public Boolean getIsResetForm() {
        return resetForm;
    }

    public Boolean getIsResetFormMain() {
        return resetToMainForm;
    }

    public Item getStiftItem() {
        return shiftItem;
    }


    public int getStoredNum() {
        return storeNum;
    }

    public String getFlyingModel(String riderName) {
        if (flyingModel != null) return flyingModel;
        ResourceLocation FORM_MODEL = ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/" + getRiderName(riderName) + formName + "_wing.geo.json");
        return (GeckoLibCache.getBakedModels().get(FORM_MODEL) != null ? getRiderName(riderName) + formName + "_wing.geo.json" : "rider_plusbelt_and_wings.geo.json");
    }

    public Boolean hasWingsIfFlying() {
        return flyingText;
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
        overrideRiderName = name;
        return this;
    }

    public RiderFormChangeItem changeModel(String model) {
        updatedModel = model;
        return this;
    }

    public RiderFormChangeItem setShowFace() {
        setShowFace = true;
        return this;
    }

    public RiderFormChangeItem setShowUnder() {
        setShowUnder = true;
        return this;
    }

    public RiderFormChangeItem setShowPlayer() {
        setShowPlayer = true;
        return this;
    }
    public RiderFormChangeItem setFormDelay(double num) {
        formDelay = num;
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
        updatedBeltModel = model;
        return this;
    }

    public RiderFormChangeItem changeSlot(int slot) {
        this.slot = slot;
        return this;
    }

    public int getTimeoutDuration() {
        return this.timeoutDuration;
    }

    public int getLockDuration() {
        return this.lockDuration;
    }

    public RiderFormChangeItem getRevertForm() {
        return this.revertForm;
    }

    public RiderFormChangeItem hasTimeout(int timeout, int lock, RiderFormChangeItem revertsTo) {
        timeoutDuration = timeout;
        lockDuration = lock;
        revertForm = revertsTo;
        return this;
    }

    public RiderFormChangeItem addNum(int num) {
        storeNum = num;
        return this;
    }

    public RiderFormChangeItem setOffhandSlot(int slot) {
        offhandSlot = slot;
        offhand = true;
        return this;
    }


    public RiderFormChangeItem hasFlyingWings(@Nullable String model) {
        flyingText = true;
        if (model != null) flyingModel = model;
        return this;
    }

    public RiderFormChangeItem addAlternative(Item item) {
        alternative.add((RiderFormChangeItem) item);
        return this;
    }

    public RiderFormChangeItem resetFormToBase() {
        resetForm = true;
        return this;
    }

    public RiderFormChangeItem resetFormToBaseIfMain() {
        resetToMainForm = true;
        return this;
    }

    public RiderFormChangeItem setFormToArmor() {
        setToArmorForm = true;
        return this;
    }

    public RiderFormChangeItem isGlowing() {
        isGlowing = true;
        return this;
    }

    public RiderFormChangeItem hasCape() {
        hasCape = true;
        return this;
    }

    public RiderFormChangeItem isBike() {
        useBike = true;
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
        isBeltGlowing = true;
        return this;
    }

    public RiderFormChangeItem hasStaticWings() {
        hasStaticWings = true;
        return this;
    }

    public RiderFormChangeItem needBaseForm() {
        needBaseForm = true;
        return this;
    }

    public RiderFormChangeItem ignoreOverrideBeltText() {
        ignoreBeltText = true;
        return this;
    }

    public RiderFormChangeItem addNeedForm(Item item) {
        needFormSlot1 = ((RiderFormChangeItem) item);
        return this;
    }

    public RiderFormChangeItem addNeedForm(Item item, int slot) {

        if (slot == 1) needFormSlot1 = ((RiderFormChangeItem) item);
        else if (slot == 2) needFormSlot2 = ((RiderFormChangeItem) item);
        else if (slot == 3) needFormSlot3 = ((RiderFormChangeItem) item);
        else if (slot == 4) needFormSlot4 = ((RiderFormChangeItem) item);
        return this;
    }

    public RiderFormChangeItem addNeedItem(Item item) {
        needItem.add(item);
        return this;
    }

    public RiderFormChangeItem addShiftForm(Item item) {
        shiftItem = item;
        return this;
    }

    public RiderFormChangeItem addSwitchForm(Item item) {
        switchItem = item;
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
        if (Objects.equals(belt.riderName, riderName)) return true;
        for (String str : compatibilityList) {
            if (Objects.equals(str, belt.riderName)) return true;
        }
        ItemStack itemStack = new ItemStack(belt);
        return itemStack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "form_change_item/works_with/" + riderName + formName)));
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
            return true;
        }
        if (hasIncompatibleForms) {
            for (RiderFormChangeItem incompatibleForm : incompatibleForms) {
                int num_forms = belt.numBaseFormItems;
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
        if (!needItem.isEmpty()) {
            for (Item item : needItem) {
                if (!inventoryOrHolderContains(player, item)) return false;
            }
        }
        if (needBaseForm) if (RiderDriverItem.getFormItem(stack, 1) != belt.baseFormItem) return false;
        if (needFormSlot1 != null) if (RiderDriverItem.getFormItem(stack, 1) != needFormSlot1) return false;
        if (needFormSlot2 != null) if (RiderDriverItem.getFormItem(stack, 2) != needFormSlot2) return false;
        if (needFormSlot3 != null) if (RiderDriverItem.getFormItem(stack, 3) != needFormSlot3) return false;
        if (needFormSlot4 != null) if (RiderDriverItem.getFormItem(stack, 4) != needFormSlot4) return false;

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
                if (shiftItem instanceof RiderFormChangeItem form && player.isShiftKeyDown() && form.canChange(player, belt, BELT))
                    shiftItem.interactLivingEntity(new ItemStack(form), player, summon, usedHand);
                else if (canChange(player, belt, BELT)) {
                    if (resetForm) RiderDriverItem.resetFormItem(summon.getItemBySlot(EquipmentSlot.FEET));
                    if (resetToMainForm & Objects.equals(belt.riderName, riderName))
                        RiderDriverItem.resetFormItem(summon.getItemBySlot(EquipmentSlot.FEET));
                    if (alsoChange1stSlot != null)
                        RiderDriverItem.setFormItem(summon.getItemBySlot(EquipmentSlot.FEET), alsoChange1stSlot, 1);
                    if (alsoChange2ndSlot != null)
                        RiderDriverItem.setFormItem(summon.getItemBySlot(EquipmentSlot.FEET), alsoChange2ndSlot, 2);
                    if (alsoChange3rdSlot != null)
                        RiderDriverItem.setFormItem(summon.getItemBySlot(EquipmentSlot.FEET), alsoChange3rdSlot, 3);
                    if (alsoChange4thSlot != null)
                        RiderDriverItem.setFormItem(summon.getItemBySlot(EquipmentSlot.FEET), alsoChange4thSlot, 4);

                    if (setToArmorForm)
                        RiderDriverItem.setFormItem(summon.getItemBySlot(EquipmentSlot.FEET), belt.armorFormItem, 1);

                    int SLOT = slot;
                    if (usedHand == InteractionHand.OFF_HAND & offhand) SLOT = offhandSlot;

                    if (switchItem != null & RiderDriverItem.getFormItem(summon.getItemBySlot(EquipmentSlot.FEET), SLOT) == this)
                        RiderDriverItem.setFormItem(summon.getItemBySlot(EquipmentSlot.FEET), switchItem, SLOT);
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

        ItemStack itemStack = player.getItemInHand(usedHand);

        ItemStack BELT = player.getItemBySlot(EquipmentSlot.FEET);

        if (!player.hasEffect(EffectCore.FORM_LOCK)) {
            if (BELT.getItem() instanceof RiderDriverItem belt) {
                if (shiftItem instanceof RiderFormChangeItem form && player.isShiftKeyDown())
                    shiftItem.use(level, player, usedHand);
                else if (canChange(player, belt, BELT)) {
                    if (!player.isCreative()) {
                        player.getCooldowns().addCooldown(this, 60);
                        player.addEffect(new MobEffectInstance(EffectCore.FORM_LOCK, 20, 0, true, false));
                    }
                    if (resetForm) RiderDriverItem.resetFormItem(player.getItemBySlot(EquipmentSlot.FEET));
                    if (resetToMainForm & Objects.equals(belt.riderName, riderName))
                        RiderDriverItem.resetFormItem(player.getItemBySlot(EquipmentSlot.FEET));
                    if (alsoChange1stSlot != null)
                        RiderDriverItem.setFormItem(player.getItemBySlot(EquipmentSlot.FEET), alsoChange1stSlot, 1);
                    if (alsoChange2ndSlot != null)
                        RiderDriverItem.setFormItem(player.getItemBySlot(EquipmentSlot.FEET), alsoChange2ndSlot, 2);
                    if (alsoChange3rdSlot != null)
                        RiderDriverItem.setFormItem(player.getItemBySlot(EquipmentSlot.FEET), alsoChange3rdSlot, 3);
                    if (alsoChange4thSlot != null)
                        RiderDriverItem.setFormItem(player.getItemBySlot(EquipmentSlot.FEET), alsoChange4thSlot, 4);

                    if (setToArmorForm)
                        RiderDriverItem.setFormItem(player.getItemBySlot(EquipmentSlot.FEET), belt.armorFormItem, 1);

                    int SLOT = slot;
                    if (usedHand == InteractionHand.OFF_HAND & offhand) SLOT = offhandSlot;

                    if (switchItem != null & RiderDriverItem.getFormItem(player.getItemBySlot(EquipmentSlot.FEET), SLOT) == this)
                        RiderDriverItem.setFormItem(player.getItemBySlot(EquipmentSlot.FEET), switchItem, SLOT);
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
        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());

    }

    public void OnTransformation(ItemStack itemStack, LivingEntity entity) {
        if (timeoutDuration != 0) {
            if (!(entity instanceof ArmorStand))
                entity.addEffect(new MobEffectInstance(EffectCore.FORM_TIMEOUT, this.timeoutDuration, 0, true, false));
            if (entity instanceof Player player && !player.isCreative())
                player.getCooldowns().addCooldown(this, this.lockDuration);
        }
    }

    public void transformationEffect(ItemStack itemStack, LivingEntity entity) {
        if (entity.level() instanceof ServerLevel sl) {
            sl.sendParticles(ParticleTypes.GUST,
                    entity.getX(), entity.getY() + 1.0,
                    entity.getZ(), 1, 0, 0, 0, 1);
        }
    }

    public void transformationEffect(ItemStack itemStack, LivingEntity entity, Double tick) {
        if (tick == 30) transformationEffect(itemStack, entity);
        if (tick == 1) RiderDriverItem.UpdateOldFormItem(itemStack);

    }
}