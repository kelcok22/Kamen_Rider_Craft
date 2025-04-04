package com.kelco.kamenridercraft.item.BaseItems;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.item.Modded_item_core;

import com.kelco.kamenridercraft.world.inventory.RingHolderGuiMenu;

import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.cache.GeckoLibCache;

public class RiderFormChangeItem extends BaseItem {

    private String FORM_NAME;
    private int Slot =1;
    private int OffhandSlot=10;
    private Boolean Offhand = false;

    private List<MobEffectInstance> potionEffectList;
    private int BELT;
    private List<Item> NEEDITEM = new ArrayList<Item>();
    protected String RIDER_NAME;
    protected String OVERRIDE_RIDER_NAME;

    private String BELT_TEX;
    private Boolean IS_GLOWING = false;
    private Boolean IS_BELT_GLOWING = false;
    private Boolean HAS_STATIC_WINGS = false;
    private String UPDATED_BELT_MODEL;
    private String UPDATED_MODEL;
    private String FLYING_MODEL;
    private String UPDATED_MODEL_ANIMATION;
    private Boolean SET_PLAYER_MODEL_INVISIBLE = false;

    private Boolean A1 = false;

    private Boolean FLYING_TEXT = false;
    private Item STIFT_ITEM = Items.APPLE;
    private Item SWITCH_ITEM;
    private Boolean RESET_FORM = false;
    private Boolean RESET_FORM_MAIN = false;

    private Boolean SET_TO_ARMOR_FORM = false;

    private List<RiderFormChangeItem> alternative = new ArrayList<RiderFormChangeItem>();
    private RiderFormChangeItem alsoChange1stSlot;
    private RiderFormChangeItem alsoChange2ndSlot;
    private RiderFormChangeItem alsoChange3rdSlot;
    private RiderFormChangeItem alsoChange4thSlot;
    private RiderFormChangeItem alsoChange5thSlot;

    private Boolean hasIncompatibleForms = false;
    private List<RiderFormChangeItem> incompatibleForms= new ArrayList<RiderFormChangeItem>();

    public String[] compatibilityList= new String[] {""};
    public List<Item> needItemList = new ArrayList<Item>();

    private Boolean NEED_BASE_FORM = false;
    private RiderFormChangeItem NEED_FORM_SLOT_1;
    private RiderFormChangeItem NEED_FORM_SLOT_2;
    private RiderFormChangeItem NEED_FORM_SLOT_3;
    private RiderFormChangeItem NEED_FORM_SLOT_4;

    private Boolean IGNORE_BELT_TEXT = false;

    private int Store_num =1;

    public RiderFormChangeItem( Properties properties,int belt,String formName,String ridername,String beltTex, MobEffectInstance... effects) {
        super( properties);

        potionEffectList = Lists.newArrayList(effects);
        FORM_NAME = formName;
        BELT_TEX = beltTex;
        BELT = belt;
        RIDER_NAME = ridername;
    }


    public List<MobEffectInstance> getPotionEffectList() {
        return potionEffectList;
    }

    public int getSlot() {
        return Slot;
    }

    public int getBelt() {
        return BELT;
    }

    public String getFormName(Boolean isFlaying) {
        return (isFlaying&FLYING_TEXT ? FORM_NAME+"_wing" : FORM_NAME);
    }

    public String getRiderName(String name) {
        return (OVERRIDE_RIDER_NAME!=null ? OVERRIDE_RIDER_NAME : name);
    }


    public String getBeltTex() {
        return BELT_TEX;
    }

    public Boolean getIgnoreOverrideBeltText() {
        return IGNORE_BELT_TEXT;
    }

    public String get_Belt_Model() {
        return (UPDATED_BELT_MODEL!=null ? UPDATED_BELT_MODEL : "geo/riderbelt.geo.json");
    }

    public String get_Model() {
        if (UPDATED_MODEL!=null) return UPDATED_MODEL;
        ResourceLocation FORM_MODEL = ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/"+RIDER_NAME+FORM_NAME+".geo.json");
        return (GeckoLibCache.getBakedModels().get(FORM_MODEL)!=null ? RIDER_NAME+FORM_NAME+".geo.json" : (get_Has_Static_Wings() ? "default_wings_armor.geo.json" : "default.geo.json"));
    }

    public String get_Animation() {
        return (UPDATED_MODEL_ANIMATION!=null ? "animations/"+UPDATED_MODEL_ANIMATION : "animations/ichigo.animation.json");
    }

    public Boolean get_PalyerModelInvisible() {
        return SET_PLAYER_MODEL_INVISIBLE;
    }

    public Boolean get_Is_Glowing() {
        return IS_GLOWING;
    }

    public Boolean get_a1() {
        return A1;
    }

    public Boolean get_Is_Belt_Glowing() {
        return IS_BELT_GLOWING;
    }

    public Boolean get_Has_Static_Wings() {
        return HAS_STATIC_WINGS;
    }

    public int get_Stored_num() {
        return Store_num;
    }

    public String get_FlyingModel() {
        if (FLYING_MODEL!=null) return FLYING_MODEL;
        ResourceLocation FORM_MODEL = ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/"+RIDER_NAME+FORM_NAME+"_wing.geo.json");
        return (GeckoLibCache.getBakedModels().get(FORM_MODEL)!=null ? RIDER_NAME+FORM_NAME+"_wing.geo.json" : "rider_plusbelt_and_wings.geo.json");
    }
    public Boolean HasWingsIfFlying() {
        return FLYING_TEXT;
    }

    public RiderFormChangeItem AddIncompatibleForm(Item item) {
        incompatibleForms.add((RiderFormChangeItem) item);
       hasIncompatibleForms=true;
        return this;
    }

    public RiderFormChangeItem alsoChange1stSlot(Item item) {
        alsoChange1stSlot=  (RiderFormChangeItem) item;
        return this;
    }

    public RiderFormChangeItem alsoChange2ndSlot(Item item) {
        alsoChange2ndSlot=  (RiderFormChangeItem) item;
        return this;
    }

    public RiderFormChangeItem alsoChange3rdSlot(Item item) {
        alsoChange3rdSlot=  (RiderFormChangeItem) item;
        return this;
    }

    public RiderFormChangeItem alsoChange4thSlot(Item item) {
        alsoChange4thSlot=  (RiderFormChangeItem) item;
        return this;
    }

    public RiderFormChangeItem alsoChange5thSlot(Item item) {
        alsoChange5thSlot=  (RiderFormChangeItem) item;
        return this;
    }

    public RiderFormChangeItem ChangeModel(String model) {
        UPDATED_MODEL=model;
        return this;
    }

    public RiderFormChangeItem ChangeRiderName(String name) {
        OVERRIDE_RIDER_NAME=name;
        return this;
    }
    public RiderFormChangeItem ChangeModel(String model,String animation) {
        UPDATED_MODEL=model;
        UPDATED_MODEL_ANIMATION=animation;
        return this;
    }
    public RiderFormChangeItem ChangeAnimation(String animation) {
        UPDATED_MODEL_ANIMATION=animation;
        return this;
    }
    public RiderFormChangeItem SetPalyerModelInvisible() {
        SET_PLAYER_MODEL_INVISIBLE = true;
        return this;
    }
    public RiderFormChangeItem ChangeBeltModel(String model) {
        UPDATED_BELT_MODEL=model;
        return this;
    }

    public RiderFormChangeItem ChangeSlot(int slot) {
        Slot=slot;
        return this;
    }

    public RiderFormChangeItem AddNum(int num) {
        Store_num=num;
        return this;
    }
    public RiderFormChangeItem SetOffhandSlot(int slot) {
        OffhandSlot=slot;
        Offhand=true;
        return this;
    }

    public RiderFormChangeItem hasFlyingWings(@Nullable String model) {
        FLYING_TEXT=true;
        if (model!=null) FLYING_MODEL=model;
        return this;
    }

    public RiderFormChangeItem addAlternative( Item item) {
        alternative.add((RiderFormChangeItem) item);
        return this;
    }

    public RiderFormChangeItem ResetFormToBase() {
        RESET_FORM=true;
        return this;
    }
    public RiderFormChangeItem ResetFormToBaseIfMain() {
        RESET_FORM_MAIN=true;
        return this;
    }
    public RiderFormChangeItem SetFormToArmor() {
        SET_TO_ARMOR_FORM=true;
        return this;
    }

    public RiderFormChangeItem IsGlowing() {
        IS_GLOWING=true;
        return this;
    }

    public RiderFormChangeItem IsA1() {
        A1=true;
        return this;
    }

    public RiderFormChangeItem IsBeltGlowing() {
        IS_BELT_GLOWING=true;
        return this;
    }

    public RiderFormChangeItem hasStaticWings() {
        HAS_STATIC_WINGS=true;
        return this;
    }

    public RiderFormChangeItem needBaseForm() {
     NEED_BASE_FORM=true;
        return this;
    }

    public RiderFormChangeItem  ignoreOverrideBeltText() {
        IGNORE_BELT_TEXT =true;
        return this;
    }

    public RiderFormChangeItem addNeedForm(Item  item) {
    NEED_FORM_SLOT_1=((RiderFormChangeItem)item);
        return this;
    }
    public RiderFormChangeItem addNeedForm(Item  item, int slot) {

        if (slot==1)NEED_FORM_SLOT_1=((RiderFormChangeItem)item);
        else if (slot==2)NEED_FORM_SLOT_2=((RiderFormChangeItem)item);
        else if (slot==3)NEED_FORM_SLOT_3=((RiderFormChangeItem)item);
        else if (slot==4)NEED_FORM_SLOT_4=((RiderFormChangeItem)item);
        return this;
    }

    public RiderFormChangeItem addNeedItem( Item item) {
        NEEDITEM.add(item);
        return this;
    }

    public RiderFormChangeItem addShiftForm(Item item) {
        STIFT_ITEM=item;
        return this;
    }

    public RiderFormChangeItem addSwitchForm(Item item) {
        SWITCH_ITEM=item;
        return this;
    }

    public RiderFormChangeItem AddNeedItemList(List<Item> NEED_ITEM) {
        needItemList=NEED_ITEM;
        return this;
    }

    public RiderFormChangeItem AddCompatibilityList(String[] List) {
        compatibilityList=List;
        return this;
    }

    public Boolean iscompatible(String rider) {

        for (int i = 0; i < compatibilityList.length; i++)
        {
            if (compatibilityList[i]==rider){
                return true;
            }
        }

        return false;
    }

	public boolean inventoryOrHolderContains(Player player, Item item) {
		NonNullList<ItemStack> inv = NonNullList.create();
		inv.addAll(player.getInventory().items);
		inv.addAll(player.getInventory().armor);
		inv.add(player.getInventory().offhand.getFirst());

		if (player.getInventory().countItem(item)!=0) return true;
		else for (int i = 0; i < inv.size(); i++) {
			if (inv.get(i).has(DataComponents.CONTAINER)) {
				for (ItemStack stack : inv.get(i).getComponents().get(DataComponents.CONTAINER).nonEmptyItems()) if (stack.getItem() == item) return true;
			} else if (inv.get(i).has(DataComponents.BUNDLE_CONTENTS))
				for (ItemStack stack : inv.get(i).getComponents().get(DataComponents.BUNDLE_CONTENTS).items()) if (stack.getItem() == item) return true;
		}
		return false;
	}

        public Boolean CanChange(Player player,RiderDriverItem belt, ItemStack stack) {

        if (this == Modded_item_core.BLANK_FORM.get()) {
            return true;
        }
        if(hasIncompatibleForms) {
            for (int i = 0; i < incompatibleForms.size(); i++)
            {
                if (incompatibleForms.get(i)==RiderDriverItem.get_Form_Item(stack, 1)){
                    return false;
                }
            }
        }
     if(belt.Rider!=RIDER_NAME&!iscompatible(belt.Rider)) {
            return false;
        }
        if ( !NEEDITEM.isEmpty()) {
            for (Item item : NEEDITEM)
            {
                if (!inventoryOrHolderContains(player, item)) return false;
            }
        }
        if (NEED_BASE_FORM )if (RiderDriverItem.get_Form_Item(stack, 1)!=belt.Base_Form_Item)return false;
        if (NEED_FORM_SLOT_1!=null )if (RiderDriverItem.get_Form_Item(stack, 1)!=NEED_FORM_SLOT_1)return false;
        if (NEED_FORM_SLOT_2!=null )if (RiderDriverItem.get_Form_Item(stack, 2)!=NEED_FORM_SLOT_2)return false;
        if (NEED_FORM_SLOT_3!=null )if (RiderDriverItem.get_Form_Item(stack, 3)!=NEED_FORM_SLOT_3)return false;
        if (NEED_FORM_SLOT_4!=null )if (RiderDriverItem.get_Form_Item(stack, 4)!=NEED_FORM_SLOT_4)return false;

        if  (!needItemList.isEmpty()) {
            for (Item item : needItemList)
            {
                if (!inventoryOrHolderContains(player, item)) return false;
            }
        }
        return true;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {

        ItemStack itemstack = player.getItemInHand(usedHand);

        ItemStack BELT = player.getItemBySlot(EquipmentSlot.FEET);

        if(!player.hasEffect(Effect_core.FORM_LOCK)) {
            if (BELT.getItem() instanceof RiderDriverItem belt) {

                if (STIFT_ITEM instanceof RiderFormChangeItem& player.isShiftKeyDown()) {
                    ((RiderFormChangeItem)STIFT_ITEM).use(level, player, usedHand);
                }
                else if (CanChange(player,belt,BELT)) {
                    if (RESET_FORM)RiderDriverItem.reset_Form_Item(player.getItemBySlot(EquipmentSlot.FEET));
                    if (RESET_FORM_MAIN&RIDER_NAME==belt.Rider)RiderDriverItem.reset_Form_Item(player.getItemBySlot(EquipmentSlot.FEET));
                    if (alsoChange1stSlot !=null)RiderDriverItem.set_Form_Item(player.getItemBySlot(EquipmentSlot.FEET),alsoChange1stSlot, 1);
                    if (alsoChange2ndSlot !=null)RiderDriverItem.set_Form_Item(player.getItemBySlot(EquipmentSlot.FEET),alsoChange2ndSlot, 2);
                    if (alsoChange3rdSlot !=null)RiderDriverItem.set_Form_Item(player.getItemBySlot(EquipmentSlot.FEET),alsoChange3rdSlot, 3);
                    if (alsoChange4thSlot !=null)RiderDriverItem.set_Form_Item(player.getItemBySlot(EquipmentSlot.FEET),alsoChange4thSlot, 4);

                    if (SET_TO_ARMOR_FORM)RiderDriverItem.set_Form_Item(player.getItemBySlot(EquipmentSlot.FEET),belt.Armor_Form_Item, 1);

                    int SLOT = Slot;
                    if (usedHand==InteractionHand.OFF_HAND&Offhand)SLOT = OffhandSlot;

                    if (SWITCH_ITEM!=null&RiderDriverItem.get_Form_Item(player.getItemBySlot(EquipmentSlot.FEET), SLOT)==this) RiderDriverItem.set_Form_Item(player.getItemBySlot(EquipmentSlot.FEET),SWITCH_ITEM, SLOT);
                    else RiderDriverItem.set_Form_Item(player.getItemBySlot(EquipmentSlot.FEET),this, SLOT);
                    if (alsoChange5thSlot !=null)RiderDriverItem.set_Form_Item(player.getItemBySlot(EquipmentSlot.FEET),alsoChange5thSlot, 5);

                }else if(!alternative.isEmpty()){

                    for (int i = 0; i < alternative.size(); i++)
                    {
                        RiderFormChangeItem alternativeItem_form_change = alternative.get(i);
                        alternativeItem_form_change.use(level, player, usedHand);
                    }
                }
            }
        }
        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());

    }


}
