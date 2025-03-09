package com.kelco.kamenridercraft.item;

import com.kelco.kamenridercraft.KamenRiderCraftCore;

import com.kelco.kamenridercraft.block.machineBlocks.GaiaMemoryRefinerBlock;
import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.item.BaseItems.*;
import com.kelco.kamenridercraft.item.tabs.RiderTabs;
import com.kelco.kamenridercraft.item.w.MetalShaftItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderCaseItem;
import com.kelco.kamenridercraft.item.w.T2MemoryCaseItem;
import com.kelco.kamenridercraft.item.w.WDriverItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class W_Rider_Items {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);

	public static final DeferredItem<Item> W_LOGO = ITEMS.register("w_logo",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM));


	public static final DeferredItem<Item> GAIA_MEMORY = ITEMS.register("gaiamemory",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM));

	public static final DeferredItem<Item>UNREFINED_MEMORY_G = ITEMS.register("unrefined_memory_g",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM));

	public static final DeferredItem<Item> UNREFINED_MEMORY_S = ITEMS.register("unrefined_memory_s",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM));

	public static final DeferredItem<Item> UNREFINED_MEMORY_T2 = ITEMS.register("unrefined_memory_t2",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM));


	public static final DeferredItem<Item> CYCLONE_MEMORY = ITEMS.register("cyclone_memory",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_cyclone","w","wdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false))
			.AddToList(RiderTabs.W_TAB_ITEM).AddToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_S, 20));

	public static final DeferredItem<Item> HEAT_MEMORY = ITEMS.register("heat_memory",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_heat","w","wdriver_belt_hj",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false))
			.AddToList(RiderTabs.W_TAB_ITEM).AddToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_S, 10));

	public static final DeferredItem<Item> LUNA_MEMORY = ITEMS.register("luna_memory",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_luna","w","wdriver_belt_lj",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 0,true,false))
			.AddToList(RiderTabs.W_TAB_ITEM).AddToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_S, 10));

	public static final DeferredItem<Item> FANG_MEMORY = ITEMS.register("fang_memory",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_fang","w","wdriver_belt_fj",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.CONFUSION, 40, 0,true,false))
			.AddToList(RiderTabs.W_TAB_ITEM));

	public static final DeferredItem<Item> JOKER_JOKER_MEMORY = ITEMS.register("joker_joker_memory",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_joker_joker","w","wdriver_belt_jj",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(Effect_core.PUNCH, 40, 0,true,false))
			.AddToList(RiderTabs.W_TAB_ITEM));


	public static final DeferredItem<Item> JOKER_MEMORY = ITEMS.register("joker_memory",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_joker","w","wdriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(Effect_core.PUNCH, 40, 0,true,false))
			.ChangeSlot(2).AddToList(RiderTabs.W_TAB_ITEM).AddToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_G, 20));

	public static final DeferredItem<Item> METAL_MEMORY = ITEMS.register("metal_memory",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_metal","w","wdriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false))
			.ChangeSlot(2).AddToList(RiderTabs.W_TAB_ITEM).AddToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_G, 10));

	public static final DeferredItem<Item> TRIGGER_MEMORY = ITEMS.register("trigger_memory",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_trigger","w","wdriver_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false))
			.ChangeSlot(2).AddToList(RiderTabs.W_TAB_ITEM).AddToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_G, 10));

	public static final DeferredItem<Item> CYCLONE_CYCLONE_MEMORY = ITEMS.register("cyclone_cyclone_memory",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_cyclone_cyclone","w","wdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false))
			.ChangeSlot(2).AddToList(RiderTabs.W_TAB_ITEM));


	public static final DeferredItem<Item> XTREME_MEMORY = ITEMS.register("xtreme_memory",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_cyclone_xtreme","w","wdriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(Effect_core.PUNCH, 40, 3,true,false))
			.alsoChange2ndSlot(JOKER_MEMORY.get()).AddToList(RiderTabs.W_TAB_ITEM));

	public static final DeferredItem<Item> XTREME_GOLD_MEMORY = ITEMS.register("xtreme_gold_memory",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_cyclone_xtreme_gold","w","wdriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(Effect_core.PUNCH, 40, 4,true,false),
					new MobEffectInstance(Effect_core.FLYING, 40, 4,true,false))
			.alsoChange2ndSlot(JOKER_MEMORY.get()).hasStaticWings().AddToList(RiderTabs.W_TAB_ITEM));

	public static final DeferredItem<Item> XTREME_ACCEL_MEMORY = ITEMS.register("xtreme_accel_memory",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_cyclone_xtreme_accel","w","wdriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(Effect_core.PUNCH, 40, 3,true,false))
			.alsoChange2ndSlot(JOKER_MEMORY.get()).AddToList(RiderTabs.W_TAB_ITEM));


	public static final DeferredItem<Item> ACCEL_MEMORY = ITEMS.register("accel_memory",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","accel","acceldriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(Effect_core.PUNCH, 40, 0,true,false))
			.AddToList(RiderTabs.W_TAB_ITEM).AddToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_G, 5));

	public static final DeferredItem<Item> TRIAL_MEMORY = ITEMS.register("trial_memory",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_trial","accel","acceldriver_belt_t",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(Effect_core.PUNCH, 40, 0,true,false))
			.AddToList(RiderTabs.W_TAB_ITEM));

	public static final DeferredItem<Item> ACCEL_BOOSTER_MEMORY = ITEMS.register("accel_booster_memory",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_booster","accel","acceldriver_belt_b",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(Effect_core.PUNCH, 40, 0,true,false),
					new MobEffectInstance(Effect_core.BOOST, 40, 0,true,false))
			.AddToList(RiderTabs.W_TAB_ITEM));


	public static final DeferredItem<Item> CYCLONE_SKULL_MEMORY = ITEMS.register("skull_cyclone_memory",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_skull","w","wdriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(Effect_core.PUNCH, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
					.addNeedForm(CYCLONE_MEMORY.get(),1).ChangeSlot(2)
					.model_has_different_name("skull_memory").has_basic_model());
	

	public static final DeferredItem<Item> SKULL_MEMORY = ITEMS.register("skull_memory",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","skull","lostdriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(Effect_core.PUNCH, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
					.addAlternative(CYCLONE_SKULL_MEMORY.get()).AddToList(RiderTabs.W_TAB_ITEM).AddToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_S, 5));

	public static final DeferredItem<Item> ETERNAL_MEMORY = ITEMS.register("eternal_memory",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_red","eternal","lostdriver_belt_e",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.WEAKNESS, 40, 1,true,false))
			.AddToList(RiderTabs.W_TAB_ITEM).AddToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_S, 1));


	public static final DeferredItem<Item> PRISM_MEMORY = ITEMS.register("prism_memory",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM)
			.AddToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_S, 5));

	public static final DeferredItem<Item> ENGINE_MEMORY = ITEMS.register("engine_memory",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM)
			.AddToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_S, 5));

	public static final DeferredItem<Item> BOMB_MEMORY = ITEMS.register("bomb_memory",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM)
			.AddToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_S, 1));

	public static final DeferredItem<Item> TRIAL_MEMORY_UN = ITEMS.register("trial_memory_un",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM)
			.AddToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_G, 2));

	public static final DeferredItem<Item> FANG_MEMORY_UN = ITEMS.register("fang_memory_un",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM)
			.AddToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_S, 5));

	public static final DeferredItem<Item> XTREME_MEMORY_G = ITEMS.register("xtreme_memory_g",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM)
			.AddToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_G, 1));

	public static final DeferredItem<Item> XTREME_MEMORY_S = ITEMS.register("xtreme_memory_s",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM)
			.AddToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_S, 1));


	public static final DeferredItem<Item> SHIPPU_MEMORY = ITEMS.register("shippu_memory",
			() -> new CopyFormChangeItem(new Item.Properties(),CYCLONE_MEMORY.get()).AddToList(RiderTabs.W_TAB_ITEM));

	public static final DeferredItem<Item> KIRIFUDA_MEMORY = ITEMS.register("kirifuda_memory",
			() -> new CopyFormChangeItem(new Item.Properties(),JOKER_MEMORY.get()).AddToList(RiderTabs.W_TAB_ITEM));


	public static final DeferredItem<Item> ACCEL_T2_MEMORY = ITEMS.register("accel_t2_memory",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM)
			.AddToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));

	public static final DeferredItem<Item> BIRD_T2_MEMORY = ITEMS.register("bird_t2_memory",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM)
			.AddToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));

	public static final DeferredItem<Item> CYCLONE_T2_MEMORY = ITEMS.register("cyclone_t2_memory",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","cyclone","lostdriver_belt_c",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false),
					new MobEffectInstance(Effect_core.PUNCH, 40, 0,true,false))
			.AddToList(RiderTabs.W_TAB_ITEM).AddToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));

	public static final DeferredItem<Item> DUMMY_T2_MEMORY = ITEMS.register("dummy_t2_memory",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM)
			.AddToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));

	public static final DeferredItem<Item> ETERNAL_T2_MEMORY = ITEMS.register("eternal_t2_memory",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","eternal","lostdriver_belt_e",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(Effect_core.PUNCH, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
			.AddToList(RiderTabs.W_TAB_ITEM).AddToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 5));


	public static final DeferredItem<Item> FANG_T2_MEMORY = ITEMS.register("fang_t2_memory",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM)
			.AddToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));

	public static final DeferredItem<Item> GENE_T2_MEMORY = ITEMS.register("gene_t2_memory",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM)
			.AddToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));

	public static final DeferredItem<Item> HEAT_T2_MEMORY = ITEMS.register("heat_t2_memory",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM)
			.AddToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));

	public static final DeferredItem<Item> ICEAGE_T2_MEMORY = ITEMS.register("iceage_t2_memory",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM)
			.AddToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));

	public static final DeferredItem<Item> JOKER_T2_MEMORY = ITEMS.register("joker_t2_memory",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","joker","lostdriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(Effect_core.PUNCH, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
			.AddToList(RiderTabs.W_TAB_ITEM).AddToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 5));

	public static final DeferredItem<Item> KEY_T2_MEMORY = ITEMS.register("key_t2_memory",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM)
			.AddToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));

	public static final DeferredItem<Item> luna_T2_MEMORY = ITEMS.register("luna_t2_memory",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM)
			.AddToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));

	public static final DeferredItem<Item> METAL_T2_MEMORY = ITEMS.register("metal_t2_memory",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM)
			.AddToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));

	public static final DeferredItem<Item> NASCA_T2_MEMORY = ITEMS.register("nasca_t2_memory",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM)
			.AddToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));

	public static final DeferredItem<Item> OCEAN_T2_MEMORY = ITEMS.register("ocean_t2_memory",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM)
			.AddToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));

	public static final DeferredItem<Item> PUPPETEER_T2_MEMORY = ITEMS.register("puppeteer_t2_memory",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM)
			.AddToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));

	public static final DeferredItem<Item> QUEEN_T2_MEMORY = ITEMS.register("queen_t2_memory",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM)
			.AddToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));

	public static final DeferredItem<Item> ROCKET_T2_MEMORY = ITEMS.register("rocket_t2_memory",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM)
			.AddToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));

	public static final DeferredItem<Item> SKULL_T2_MEMORY = ITEMS.register("skull_t2_memory",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM)
			.AddToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));

	public static final DeferredItem<Item> TRIGGER_T2_MEMORY = ITEMS.register("trigger_t2_memory",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM)
			.AddToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));

	public static final DeferredItem<Item> UNICORN_T2_MEMORY = ITEMS.register("unicorn_t2_memory",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM)
			.AddToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));

	public static final DeferredItem<Item> VIOLENCE_T2_MEMORY = ITEMS.register("violence_t2_memory",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM)
			.AddToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));

	public static final DeferredItem<Item> WEATHER_T2_MEMORY = ITEMS.register("weather_t2_memory",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM)
			.AddToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));

	public static final DeferredItem<Item> XTREME_T2_MEMORY = ITEMS.register("xtreme_t2_memory",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM)
			.AddToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));

	public static final DeferredItem<Item> YESTERDAY_T2_MEMORY = ITEMS.register("yesterday_t2_memory",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM)
			.AddToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));


	public static final DeferredItem<Item> T2_ZONE_MEMORY = ITEMS.register("zone_t2_memory",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_strengthening_armament","eternal","lostdriver_belt_e",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(Effect_core.PUNCH, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 5,true,false))
			.AddToList(RiderTabs.W_TAB_ITEM).AddToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1) );


	public static final DeferredItem<Item> TERROR_MEMORY = ITEMS.register("terror_memory",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM));

	public static final DeferredItem<Item> TABOO_MEMORY = ITEMS.register("taboo_memory",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM));

	public static final DeferredItem<Item> CLAYDOLL_MEMORY = ITEMS.register("claydoll_memory",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM));

	public static final DeferredItem<Item> NASCA_MEMORY = ITEMS.register("nasca_memory",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM));

	public static final DeferredItem<Item> SMILODON_MEMORY = ITEMS.register("smilodon_memory",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM));

	public static final DeferredItem<Item> WEATHER_MEMORY = ITEMS.register("weather_memory",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM));

	public static final DeferredItem<Item> QUETZALCOATUS_MEMORY = ITEMS.register("quetzalcoatlus_memory",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM));

	public static final DeferredItem<Item> QUETZALCOATUS_MEMORY_PROTOTYPE = ITEMS.register("quetzalcoatlus_memory_prototype",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM));

	public static final DeferredItem<Item> UTOPIA_MEMORY = ITEMS.register("utopia_memory",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM));

	public static final DeferredItem<Item> UNICON_MEMORY = ITEMS.register("unicorn_memory",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM));

	public static final DeferredItem<Item> UNICON_MEMORY_ENHANCING_ADAPTER = ITEMS.register("unicorn_memory_enhancing_adapter",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM));

	public static final DeferredItem<Item> MAGMA_MEMORY = ITEMS.register("magma_memory",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM));

	public static final DeferredItem<Item> COMMANDER_MEMORY = ITEMS.register("commander_memory",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM));

	public static final DeferredItem<Item> COMMANDER_MEMORY_ENHANCING_ADAPTER = ITEMS.register("commander_memory_enhancing_adapter",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM).KeepDifItem(COMMANDER_MEMORY.get()));

	public static final DeferredItem<Item> MEMORY_MEMORY = ITEMS.register("memory_memory",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","core","core_driver_belt",
					new MobEffectInstance(Effect_core.BIG, 40, 2,true,false))
			.ChangeSlot(4).addSwitchForm(Modded_item_core.BLANK_FORM.get()).AddToList(RiderTabs.W_TAB_ITEM));



	public static final DeferredItem<Item> EGG_CHICKEN_MEMORY = ITEMS.register("egg_chicken_memory",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM));

	public static final DeferredItem<Item> MASQUERADE_MEMORY = ITEMS.register("masquerade_memory",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM));

	public static final DeferredItem<Item> STAG_MEMORY = ITEMS.register("stag_memory",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM));

	public static final DeferredItem<Item> SPIDER_MEMORY = ITEMS.register("spider_memory",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM));

	public static final DeferredItem<Item> BAT_MEMORY = ITEMS.register("bat_memory",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM));

	public static final DeferredItem<Item> BEETEL_MEMORY = ITEMS.register("beetle_memory",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM));

	public static final DeferredItem<Item> FROG_MEMORY = ITEMS.register("frog_memory",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM));

	public static final DeferredItem<Item> DENDEN_MEMORY = ITEMS.register("denden_memory",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM));


	public static final DeferredItem<Item> AKIKO_NO_SLIPPER = ITEMS.register("akiko_no_slipper",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.W_TAB_ITEM));


	public static final DeferredItem<Item> WHELMET = ITEMS.register("whead",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.W_TAB_ITEM).ChangeRepairItem( GAIA_MEMORY.get()));
	public static final DeferredItem<Item> WCHESTPLATE = ITEMS.register("wtroso",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.W_TAB_ITEM).ChangeRepairItem( GAIA_MEMORY.get()));
	public static final DeferredItem<Item> WLEGGINGS = ITEMS.register("wlegs",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.W_TAB_ITEM).ChangeRepairItem( GAIA_MEMORY.get()));


	public static final DeferredItem<Item> WDRIVER = ITEMS.register("wdriver",
			() -> new WDriverItem(ArmorMaterials.DIAMOND,"w",CYCLONE_MEMORY ,WHELMET,WCHESTPLATE,WLEGGINGS , new Item.Properties())
			.Add_Extra_Base_Form_Items(JOKER_MEMORY).AddToTabList(RiderTabs.W_TAB_ITEM).AddToTabList(Decade_Rider_Items.NEO_DIEND_SUMMON_BELTS));

	public static final DeferredItem<Item> ACCELDRIVER = ITEMS.register("acceldriver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"accel",ACCEL_MEMORY ,WHELMET,WCHESTPLATE,WLEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.W_TAB_ITEM).AddToTabList(Decade_Rider_Items.NEO_DIEND_SUMMON_BELTS).ChangeRepairItem( GAIA_MEMORY.get()));


	public static final DeferredItem<Item> LOSTDRIVER_JOKER = ITEMS.register("lostdriver_joker",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"joker",JOKER_T2_MEMORY ,WHELMET,WCHESTPLATE,WLEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.W_TAB_ITEM).ChangeRepairItem( GAIA_MEMORY.get()));

	public static final DeferredItem<Item> LOSTDRIVER_CYCLONE = ITEMS.register("lostdriver_cyclone",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"cyclone",CYCLONE_T2_MEMORY ,WHELMET,WCHESTPLATE,WLEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.W_TAB_ITEM).ChangeRepairItem( GAIA_MEMORY.get()));

	public static final DeferredItem<Item> LOSTDRIVER_SKULL = ITEMS.register("lostdriver_skull",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"skull",SKULL_MEMORY ,WHELMET,WCHESTPLATE,WLEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.W_TAB_ITEM).AddToTabList(Decade_Rider_Items.NEO_DIEND_SUMMON_BELTS).ChangeRepairItem( GAIA_MEMORY.get()));

	public static final DeferredItem<Item> LOSTDRIVER_ETERNAL = ITEMS.register("lostdriver_eternal",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"eternal",ETERNAL_T2_MEMORY ,WHELMET,WCHESTPLATE,WLEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.W_TAB_ITEM).ChangeRepairItem( GAIA_MEMORY.get()));


	public static final DeferredItem<Item> TRIGGER_MAGNUM = ITEMS.register("trigger_magnum",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.W_TAB_ITEM));

	public static final DeferredItem<Item>METAL_SHAFT = ITEMS.register("metal_shaft",
			() -> new MetalShaftItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.W_TAB_ITEM).ChangeRepairItem( GAIA_MEMORY.get()));


	public static final DeferredItem<Item> PRISM_BICKER = ITEMS.register("prism_bicker",
			() -> new BaseSwordItem(Tiers.DIAMOND, 9, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.W_TAB_ITEM).ChangeRepairItem( GAIA_MEMORY.get()));


	public static final DeferredItem<Item> SHIELD_PRISM_BICKER = ITEMS.register("shield_prism_bicker",
			() -> new BaseShieldItem(new Item.Properties()).AddToTabList(RiderTabs.W_TAB_ITEM).ChangeRepairItem( GAIA_MEMORY.get()));


	public static final DeferredItem<Item> ETERNAL_EDGE = ITEMS.register("eternal_edge",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.W_TAB_ITEM).ChangeRepairItem( GAIA_MEMORY.get()));

	public static final DeferredItem<Item> SKILL_MAGNUM = ITEMS.register("skull_magnum",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.W_TAB_ITEM).AddToTabList(Decade_Rider_Items.NEO_DIEND_SUMMON_WEAPONS).ChangeRepairItem( GAIA_MEMORY.get()));

	public static final DeferredItem<Item> ENGINE_BLADE = ITEMS.register("engine_blade",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.W_TAB_ITEM).AddToTabList(Decade_Rider_Items.NEO_DIEND_SUMMON_WEAPONS).ChangeRepairItem( GAIA_MEMORY.get()));

	public static final DeferredItem<Item> BOMB_MAGNUM = ITEMS.register("bomb_magnum",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.W_TAB_ITEM).ChangeRepairItem( GAIA_MEMORY.get()));

	public static final DeferredItem<Item> NASCA_BLADE = ITEMS.register("nasca_blade",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.W_TAB_ITEM).ChangeRepairItem( GAIA_MEMORY.get()));

	public static final DeferredItem<Item> T2_MEMORY_CASE = ITEMS.register("t2_memory_case",
			() -> new T2MemoryCaseItem().has_basic_model().model_has_different_name("rider_case").AddToList(RiderTabs.W_TAB_ITEM));

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}