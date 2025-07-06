package com.kelco.kamenridercraft.item;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.BaseItems.*;
import com.kelco.kamenridercraft.item.tabs.RiderTabs;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Zeztz_Rider_Items {

        public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);

       // public static final DeferredItem<Item> ZEZTZ_LOGO = ITEMS.register("zeztz_logo",() -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/hibiki")), new Item.Properties()).AddToList(RiderTabs.ZEZTZ_TAB_ITEM));
        
        public static final DeferredItem<Item> ZEZTZ_RIDER_CAPSULE= ITEMS.register("zeztz_rider_capsule",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"","zeztz","drivedriver_belt",
                new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
                new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
                new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
               .ChangeBeltModel("geo/zeztz_riderbelt.geo.json").AddToList(RiderTabs.ZEZTZ_TAB_ITEM));

        public static final DeferredItem<Item> ZEZTZHELMET = ITEMS.register("zeztz_head",
                () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.ZEZTZ_TAB_ITEM));
        public static final DeferredItem<Item> ZEZTZCHESTPLATE = ITEMS.register("zeztz_troso",
                () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.ZEZTZ_TAB_ITEM));
        public static final DeferredItem<Item> ZEZTZLEGGINGS = ITEMS.register("zeztz_legs",
                () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.ZEZTZ_TAB_ITEM));

            
        public static final DeferredItem<Item> ZEZTZDRIVER = ITEMS.register("zeztzdriver",
                () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"zeztz",ZEZTZ_RIDER_CAPSULE ,ZEZTZHELMET,ZEZTZCHESTPLATE,ZEZTZLEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.ZEZTZ_TAB_ITEM));

        public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
	    
	}