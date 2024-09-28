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

public class Gavv_Rider_Items {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);

	public static final DeferredItem<Item> GAVV_LOGO = ITEMS.register("gavv_logo",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> POPPINGGUMMY_GOCHIZO = ITEMS.register("poppingummy_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","gavv","henshin_belt_gavv_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)).AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> PUNCHINGUMMY_GOCHIZO = ITEMS.register("punchingummy_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_punchin","gavv","henshin_belt_gavv_belt",
					new MobEffectInstance(Effect_core.PUNCH, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)).AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> KICKINGUMMY_GOCHIZO = ITEMS.register("kickingummy_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_kickin","gavv","henshin_belt_gavv_belt",
					new MobEffectInstance(Effect_core.PUNCH, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)).AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> GAVV_HELMET = ITEMS.register("gavv_head",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.GAVV_TAB_ITEM));
	public static final DeferredItem<Item> GAVV_CHESTPLATE = ITEMS.register("gavv_troso",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.GAVV_TAB_ITEM));
	public static final DeferredItem<Item> GAVV_LEGGINGS = ITEMS.register("gavv_legs",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> HENSHIN_BELT_GAVV = ITEMS.register("henshin_belt_gavv",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"gavv",POPPINGGUMMY_GOCHIZO ,GAVV_HELMET,GAVV_CHESTPLATE,GAVV_LEGGINGS , new Item.Properties())
			.AddToTabList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> GAVVGABLADE = ITEMS.register("gavvgablade",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GAVV_TAB_ITEM));


	public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
}
