package com.kelco.kamenridercraft.item;

import com.kelco.kamenridercraft.KamenRiderCraftCore;

import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.item.BaseItems.*;
import com.kelco.kamenridercraft.item.tabs.RiderTabs;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Kuuga_Rider_Items {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);

	public static final DeferredItem<Item> KUUGA_LOGO = ITEMS.register("kuuga_logo",
    		() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.KUUGA_TAB_ITEM));

	public static final DeferredItem<Item> KUUGA_GROWING = ITEMS.register("kuuga_growing",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_growing","kuuga","arcle_belt",
            		new MobEffectInstance(MobEffects.WEAKNESS, 40, 2,true,false))
            .AddToList(RiderTabs.KUUGA_TAB_ITEM));
	
    public static final DeferredItem<Item> KUUGA_MIGHTY = ITEMS.register("kuuga_mighty",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","kuuga","arcle_belt",
            		new MobEffectInstance(Effect_core.PUNCH, 40, 2,true,false))
            .AddToList(RiderTabs.KUUGA_TAB_ITEM));

    public static final DeferredItem<Item> KUUGA_DRAGON = ITEMS.register("kuuga_dragon",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_dragon","kuuga","arcle_belt_d",
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
            .AddToList(RiderTabs.KUUGA_TAB_ITEM));

    public static final DeferredItem<Item> KUUGA_PEGASUS = ITEMS.register("kuuga_pegasus",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_pegasus","kuuga","arcle_belt_p",
            		new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
            		new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
            .AddToList(RiderTabs.KUUGA_TAB_ITEM));

    public static final DeferredItem<Item> KUUGA_TITAN = ITEMS.register("kuuga_titan",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_titan","kuuga","arcle_belt_t",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false))
            .AddToList(RiderTabs.KUUGA_TAB_ITEM));

    public static final DeferredItem<Item> KUUGA_RISING_MIGHTY = ITEMS.register("kuuga_rising_mighty",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_rising_mighty","kuuga","arcle_belt_r",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
            		new MobEffectInstance(Effect_core.PUNCH, 40, 3,true,false))
            .AddToList(RiderTabs.KUUGA_TAB_ITEM));

    public static final DeferredItem<Item> KUUGA_RISING_DRAGON = ITEMS.register("kuuga_rising_dragon",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_rising_dragon","kuuga","arcle_belt_r",
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false))
            .AddToList(RiderTabs.KUUGA_TAB_ITEM));

    public static final DeferredItem<Item> KUUGA_RISING_PEGASUS = ITEMS.register("kuuga_rising_pegasus",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_rising_pegasus","kuuga","arcle_belt_r",
            		new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
            		new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false))
            .AddToList(RiderTabs.KUUGA_TAB_ITEM));

    public static final DeferredItem<Item> KUUGA_RISING_TITAN = ITEMS.register("kuuga_rising_titan",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_rising_titan","kuuga","arcle_belt_r",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false))
            .AddToList(RiderTabs.KUUGA_TAB_ITEM));

    public static final DeferredItem<Item> KUUGA_AMAZING_MIGHTY = ITEMS.register("kuuga_amazing_mighty",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_amazing_mighty","kuuga","arcle_belt_r",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
            		new MobEffectInstance(Effect_core.PUNCH, 40, 4,true,false))
            .AddToList(RiderTabs.KUUGA_TAB_ITEM));

    public static final DeferredItem<Item> KUUGA_ULTIMATE = ITEMS.register("kuuga_ultimate",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_ultimate","kuuga","arcle_belt_u",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
            		new MobEffectInstance(Effect_core.PUNCH, 40, 5,true,false))
            .AddToList(RiderTabs.KUUGA_TAB_ITEM));

    public static final DeferredItem<Item> KUUGA_RISING_ULTIMATE = ITEMS.register("kuuga_rising_ultimate",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_rising_ultimate","kuuga","arcle_belt_ru",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
            		new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 5,true,false),
            		new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
            		new MobEffectInstance(Effect_core.PUNCH, 40, 5,true,false))
            .AddToList(RiderTabs.KUUGA_TAB_ITEM));

    public static final DeferredItem<Item> KUUGA_SUPER_RISING_ULTIMATE = ITEMS.register("kuuga_super_rising_ultimate",
    		() -> new RiderFormChangeItem(new Item.Properties(),0,"_super_rising_ultimate","kuuga","arcle_belt_ru",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 5,true,false),
            		new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 7,true,false),
            		new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
            		new MobEffectInstance(Effect_core.PUNCH, 40, 6,true,false))
    		.AddToList(RiderTabs.KUUGA_TAB_ITEM));
    
    public static final DeferredItem<Item> KUUGA_MANGA = ITEMS.register("kuuga_manga",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","kuuga_manga","arcle_belt_manga",
            		new MobEffectInstance(Effect_core.PUNCH, 40, 2,true,false)
            		,new MobEffectInstance(Effect_core.FLAT, 40, 0,true,false)).AddToList(RiderTabs.KUUGA_TAB_ITEM));

    
    public static final DeferredItem<Item> KUUGAHELMET = ITEMS.register("kuugahead",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.KUUGA_TAB_ITEM).ChangeRepairItem(KUUGA_GROWING.get()));
    public static final DeferredItem<Item> KUUGACHESTPLATE = ITEMS.register("kuugatroso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.KUUGA_TAB_ITEM).ChangeRepairItem(KUUGA_GROWING.get()));
    public static final DeferredItem<Item> KUUGALEGGINGS = ITEMS.register("kuugalegs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.KUUGA_TAB_ITEM).ChangeRepairItem(KUUGA_GROWING.get()));
    
    public static final DeferredItem<Item> ARCLE = ITEMS.register("arcle",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"kuuga",KUUGA_MIGHTY ,KUUGAHELMET, KUUGACHESTPLATE,KUUGALEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.KUUGA_TAB_ITEM).ChangeRepairItem(KUUGA_GROWING.get()));

    public static final DeferredItem<Item> MANGA_ARCLE = ITEMS.register("manga_arcle",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"kuuga_manga",KUUGA_MANGA ,KUUGAHELMET, KUUGACHESTPLATE,KUUGALEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.KUUGA_TAB_ITEM).ChangeRepairItem(KUUGA_GROWING.get()));

    
    public static final DeferredItem<Item> DRAGON_ROD = ITEMS.register("dragon_rod",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(KamenRiderCraftCore.KUUGA_CHANGING_ITEM).AddToTabList(RiderTabs.KUUGA_TAB_ITEM).ChangeRepairItem(KUUGA_GROWING.get()));
	public static final DeferredItem<Item> PEGASUS_BOWGUN = ITEMS.register("pegasus_bowgun",
	        () -> new BaseBlasterItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(KamenRiderCraftCore.KUUGA_CHANGING_ITEM).AddToTabList(RiderTabs.KUUGA_TAB_ITEM).ChangeRepairItem(KUUGA_GROWING.get()));
	public static final DeferredItem<Item> TITAN_SWORD = ITEMS.register("titan_sword",
	        () -> new BaseSwordItem(Tiers.DIAMOND, 7, -2.4F, new Item.Properties()).AddToTabList(KamenRiderCraftCore.KUUGA_CHANGING_ITEM).AddToTabList(RiderTabs.KUUGA_TAB_ITEM).ChangeRepairItem(KUUGA_GROWING.get()));

	public static final DeferredItem<Item> KUUGA_PHONE = ITEMS.register("kuuga_phone",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.KUUGA_TAB_ITEM));


	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}

}
