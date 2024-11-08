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

import java.util.ArrayList;
import java.util.List;

public class Gavv_Rider_Items {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);

	public static List<Item> GUMMY= new ArrayList<Item>();
	public static List<Item> SNACK= new ArrayList<Item>();
	public static List<Item> MARSHMALLOW= new ArrayList<Item>();
	public static List<Item> CHOCO= new ArrayList<Item>();


	public static final DeferredItem<Item> GAVV_LOGO = ITEMS.register("gavv_logo",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> BLANK_GOCHIZO = ITEMS.register("blank_gochizo",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> POPPINGGUMMY_GOCHIZO = ITEMS.register("poppingummy_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","gavv","henshin_belt_gavv_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.AddToList(GUMMY,3).AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> PUNCHINGUMMY_GOCHIZO = ITEMS.register("punchingummy_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_punchin","gavv","henshin_belt_gavv_belt_punchin",
					new MobEffectInstance(Effect_core.PUNCH, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.AddToList(GUMMY,1).AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> KICKINGUMMY_GOCHIZO = ITEMS.register("kickingummy_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_kickin","gavv","henshin_belt_gavv_belt_kickin",
					new MobEffectInstance(Effect_core.PUNCH, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.AddToList(GUMMY,1).AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> ZAKUZAKUCHIPS_GOCHIZO = ITEMS.register("zakuzakuchips_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_zakuzaku_chips","gavv","henshin_belt_gavv_belt_zakuzaku",
					new MobEffectInstance(Effect_core.SLASH, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.AddToList(SNACK,5).AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> HIRIHIRICHIPS_GOCHIZO = ITEMS.register("hirihirichips_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_zakuzaku_chips","gavv","henshin_belt_gavv_belt_hirihiri",
					new MobEffectInstance(Effect_core.FIRE_ARMOR, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.AddToList(SNACK,2).AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> FUWAMALLOW_GOCHIZO = ITEMS.register("fuwamallow_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_fuwamallow","gavv","henshin_belt_gavv_belt_fuwamallow",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.AddToList(MARSHMALLOW,5).AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> MARUMALLOW_GOCHIZO = ITEMS.register("marumallow_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_fuwamallow","gavv","henshin_belt_gavv_belt_marumallow",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(Effect_core.BIG, 40, 0,true,false))
					.ChangeModel("gavv_marumallow.geo.json").AddToList(MARSHMALLOW,2).AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> CHOCODAN_GOCHIZO = ITEMS.register("chocodan_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_chocodan","gavv","henshin_belt_gavv_belt_chocodan",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(Effect_core.SHOT_BOOST, 40, 0,true,false))
					.AddToList(CHOCO,5).AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> CHOCODON_GOCHIZO = ITEMS.register("chocodon_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","valen","valenbuckle_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(Effect_core.SHOT_BOOST, 40, 0,true,false))
					.AddToList(CHOCO,5).AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> DOUMARU_GOCHIZO = ITEMS.register("doumaru_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_doumaru","valen","valenbuckle_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> COOKIEKIE_GOCHIZO = ITEMS.register("cookiekie_gochizo",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> GAVV_HELMET = ITEMS.register("gavv_head",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.GAVV_TAB_ITEM));
	public static final DeferredItem<Item> GAVV_CHESTPLATE = ITEMS.register("gavv_troso",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.GAVV_TAB_ITEM));
	public static final DeferredItem<Item> GAVV_LEGGINGS = ITEMS.register("gavv_legs",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> HENSHIN_BELT_GAVV = ITEMS.register("henshin_belt_gavv",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"gavv",POPPINGGUMMY_GOCHIZO ,GAVV_HELMET,GAVV_CHESTPLATE,GAVV_LEGGINGS , new Item.Properties())
			.AddToTabList(RiderTabs.GAVV_TAB_ITEM));

	//.Override_belt_text("valenbuckle_belt")
	public static final DeferredItem<Item> VALENBUCKLE = ITEMS.register("valenbuckle",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"valen",CHOCODON_GOCHIZO ,GAVV_HELMET,GAVV_CHESTPLATE,GAVV_LEGGINGS , new Item.Properties())
					.AddToTabList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> GAVVGABLADE = ITEMS.register("gavvgablade",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> ZAKUZAKUCHIPSLASHER = ITEMS.register("zakuzakuchipslasher",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GAVV_TAB_ITEM));


	public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
}
