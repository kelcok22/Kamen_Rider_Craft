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
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Blade_Rider_Items {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);

	public static final DeferredItem<Item> BLADE_LOGO = ITEMS.register("blade_logo",
			() -> new BaseItem(new Item.Properties()).AddToTabList(RiderTabs.BLADE_TAB_ITEM));


	public static final DeferredItem<Item> BLADECARD = ITEMS.register("bladecard",
			() -> new BaseItem(new Item.Properties()).AddToTabList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> ROUZE_ABSORBER = ITEMS.register("rouze_absorber",
			() -> new BaseItem(new Item.Properties()).AddToTabList(RiderTabs.BLADE_TAB_ITEM));


	public static final DeferredItem<Item> CHANGE_BEETLE = ITEMS.register("change_beetle",
			() -> new RiderFormChangeItem(new Item.Properties(), 0, "", "blade", "blay_buckle_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false))
					.AddToTabList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> FUSION_EAGLE = ITEMS.register("fusion_eagle",
			() -> new RiderFormChangeItem(new Item.Properties(), 0, "_jack", "blade", "blay_buckle_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
					new MobEffectInstance(Effect_core.FLYING, 400, 0, true, false))
					.addNeedItem(ROUZE_ABSORBER.get()).ifFlyingModelResource("geo/rider_plusbelt_and_wings.geo.json")
					.AddToTabList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> ABSORB_CAPRICORN = ITEMS.register("absorb_capricorn",
			() -> new BaseItem(new Item.Properties()).AddToTabList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> EVOLUTION_CAUCASUS = ITEMS.register("evolution_caucasus",
			() -> new RiderFormChangeItem(new Item.Properties(), 0, "_king", "blade", "blay_buckle_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3, true, false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false),
					new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4, true, false))
					.addNeedItem(ROUZE_ABSORBER.get()).addNeedItem(ABSORB_CAPRICORN.get()).addNeedItem(FUSION_EAGLE.get())
					.AddToTabList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> SILVER_EVOLUTION_CAUCASUS = ITEMS.register("silver_evolution_caucasus",
			() -> new RiderFormChangeItem(new Item.Properties(), 0, "_silver_king", "blade", "blay_buckle_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3, true, false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false),
					new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4, true, false))
					.addNeedItem(ROUZE_ABSORBER.get()).addNeedItem(ABSORB_CAPRICORN.get()).addNeedItem(FUSION_EAGLE.get())
					.AddToTabList(RiderTabs.BLADE_TAB_ITEM));


	public static final DeferredItem<Item> CHANGE_STAG = ITEMS.register("change_stag",
			() -> new RiderFormChangeItem(new Item.Properties(), 0, "", "garren", "garren_buckle_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0, true, false))
					.AddToTabList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> FUSION_PEACOCK = ITEMS.register("fusion_peacock",
			() -> new RiderFormChangeItem(new Item.Properties(), 0, "_jack", "garren", "garren_buckle_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false),
					new MobEffectInstance(Effect_core.FLYING, 400, 0, true, false))
					.addNeedItem(ROUZE_ABSORBER.get()).ifFlyingModelResource("geo/rider_plusbelt_and_wings.geo.json")
					.AddToTabList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> ABSORB_SERPENT = ITEMS.register("absorb_serpent",
			() -> new BaseItem(new Item.Properties()).AddToTabList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> EVOLUTION_GIRAFFA = ITEMS.register("evolution_giraffa",
			() -> new RiderFormChangeItem(new Item.Properties(), 0, "_king", "garren", "garren_buckle_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3, true, false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false),
					new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4, true, false))
					.addNeedItem(ROUZE_ABSORBER.get()).addNeedItem(ABSORB_SERPENT.get()).addNeedItem(FUSION_PEACOCK.get())
					.AddToTabList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> CHANGE_MANTIS = ITEMS.register("change_mantis",
			() -> new RiderFormChangeItem(new Item.Properties(), 0, "", "chalice", "chalice_rouzer_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false))
					.AddToTabList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> EVOLUTION_PARADOXA = ITEMS.register("evolution_paradoxa",
			() -> new RiderFormChangeItem(new Item.Properties(), 0, "_wild", "chalice", "chalice_rouzer_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3, true, false))
					.AddToTabList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> CHANGE_SPIDER = ITEMS.register("change_spider",
			() -> new RiderFormChangeItem(new Item.Properties(), 0, "", "leangle", "leangle_buckle_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false))
					.AddToTabList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> FUSION_ELEPHANT = ITEMS.register("fusion_elephant",
			() -> new RiderFormChangeItem(new Item.Properties(), 0, "_jack", "leangle", "leangle_buckle_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false))
					.addNeedItem(ROUZE_ABSORBER.get()).AddToTabList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> ABSORB_TIGER = ITEMS.register("absorb_tiger",
			() -> new BaseItem(new Item.Properties()).AddToTabList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> EVOLUTION_TARANTULA = ITEMS.register("evolution_tarantula",
			() -> new RiderFormChangeItem(new Item.Properties(), 0, "_king", "leangle", "leangle_buckle_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3, true, false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2, true, false),
					new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4, true, false))
					.addNeedItem(ROUZE_ABSORBER.get()).addNeedItem(ABSORB_TIGER.get()).addNeedItem(FUSION_ELEPHANT.get())
					.AddToTabList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> CHANGE_KERBEROS_GLAIVE = ITEMS.register("change_kerberos_glaive",
			() -> new RiderFormChangeItem(new Item.Properties(), 0, "", "glaive", "glaive_buckle_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0, true, false))
					.AddToTabList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> CHANGE_KERBEROS_LANCE = ITEMS.register("change_kerberos_lance",
			() -> new RiderFormChangeItem(new Item.Properties(), 0, "", "lance", "lance_buckle_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0, true, false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1, true, false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0, true, false))
					.AddToTabList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> CHANGE_KERBEROS_LARC = ITEMS.register("change_kerberos_larc",
			() -> new RiderFormChangeItem(new Item.Properties(), 0, "", "larc", "larc_buckle_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0, true, false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false))
					.AddToTabList(RiderTabs.BLADE_TAB_ITEM));

	public static final DeferredItem<Item> BLADEHELMET = ITEMS.register("bladehead",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
	public static final DeferredItem<Item> BLADECHESTPLATE = ITEMS.register("bladetroso",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
	public static final DeferredItem<Item> BLADELEGGINGS = ITEMS.register("bladelegs",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));


	public static final DeferredItem<Item> BLAYBUCKLE = ITEMS.register("blay_buckle",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND, "blade", CHANGE_BEETLE, BLADEHELMET, BLADECHESTPLATE, BLADELEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
	public static final DeferredItem<Item> GARRENBUCKLE = ITEMS.register("garren_buckle",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND, "garren", CHANGE_STAG, BLADEHELMET, BLADECHESTPLATE, BLADELEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
	public static final DeferredItem<Item> CHALICEROUZER = ITEMS.register("chalice_rouzer",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND, "chalice", CHANGE_MANTIS, BLADEHELMET, BLADECHESTPLATE, BLADELEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
	public static final DeferredItem<Item> LEANGLEBUCKLE = ITEMS.register("leangle_buckle",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND, "leangle", CHANGE_SPIDER, BLADEHELMET, BLADECHESTPLATE, BLADELEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
	public static final DeferredItem<Item> GLAIVEBUCKLE = ITEMS.register("glaive_buckle",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND, "glaive", CHANGE_KERBEROS_GLAIVE, BLADEHELMET, BLADECHESTPLATE, BLADELEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
	public static final DeferredItem<Item> LANCEBUCKLE = ITEMS.register("lance_buckle",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND, "lance", CHANGE_KERBEROS_LANCE, BLADEHELMET, BLADECHESTPLATE, BLADELEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
	public static final DeferredItem<Item> LARCBUCKLE = ITEMS.register("larc_buckle",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND, "larc", CHANGE_KERBEROS_LARC, BLADEHELMET, BLADECHESTPLATE, BLADELEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));


	public static final DeferredItem<Item> BLAYROUZER = ITEMS.register("blayrouzer",
			() -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
	public static final DeferredItem<Item> KINGROUZER = ITEMS.register("kingrouzer",
			() -> new BaseSwordItem(Tiers.DIAMOND, 7, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
	public static final DeferredItem<Item> GARRENROUZER = ITEMS.register("garrenrouzer",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
	public static final DeferredItem<Item> LEANGLEROUZER = ITEMS.register("leanglerouzer",
			() -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
	public static final DeferredItem<Item> GLAIVEROUZER = ITEMS.register("glaiverouzer",
			() -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
	public static final DeferredItem<Item> LANCEROUZER = ITEMS.register("lancerouzer",
			() -> new BaseSwordItem(Tiers.DIAMOND, 7, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
	public static final DeferredItem<Item> LARCROUZER = ITEMS.register("larcrouzer",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 10, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));

	public static final DeferredItem<Item> CHALICE_ARROW = ITEMS.register("chalice_arrow",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
	public static final DeferredItem<Item> WILD_SLASHER = ITEMS.register("wild_slasher",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));
	public static final DeferredItem<Item> WILD_CHALICE_ARROW = ITEMS.register("wild_chalice_arrow",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).setProjectileFireball().AddToTabList(RiderTabs.BLADE_TAB_ITEM).ChangeRepairItem(BLADECARD.get()));


	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}