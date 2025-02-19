package com.kelco.kamenridercraft.item;

import java.util.ArrayList;
import java.util.List;

import com.kelco.kamenridercraft.KamenRiderCraftCore;

import com.kelco.kamenridercraft.block.machineBlocks.ProgrisekeyPrinter;
import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.item.BaseItems.*;
import com.kelco.kamenridercraft.item.misc.GiftItem;
import com.kelco.kamenridercraft.item.tabs.RiderTabs;
import com.kelco.kamenridercraft.item.zero_one.IkazuchiProgriseHolderItem;
import com.kelco.kamenridercraft.item.zero_one.ProgriseHolderItem;
import com.kelco.kamenridercraft.item.zero_one.ShotriserItem;
import com.kelco.kamenridercraft.item.zero_one.ThousandriverItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Zero_One_Rider_Items {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);

	public static final DeferredItem<Item> ZERO_ONE_LOGO = ITEMS.register("zero_one_logo",
    		() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));

	public static List<Item> NEED_ITEM_RAGNAROK = new ArrayList<Item>();

	public static final DeferredItem<Item> HIDEN_METAL = ITEMS.register("hiden_metal",
    		() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));
	public static final DeferredItem<Item> BLANK_PROGRISEKEY = ITEMS.register("blank_progrisekey",
    		() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));
	public static final DeferredItem<Item> HUMAGEAR_PROGRISEKEY = ITEMS.register("humagear_progrisekey",
    		() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));
	
	public static final DeferredItem<Item> RISING_HOPPER_PROGRISEKEY_VULCAN = ITEMS.register("rising_hopper_progrisekey_vulcan",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_hopper","vulcan","aims_shot_riser_belt",
            		new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false)));


	public static final DeferredItem<Item> RISING_HOPPER_PROGRISEKEY = ITEMS.register("rising_hopper_progrisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","zero_one","hiden_zero_one_driver_belt",
            		new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false))
            .addAlternative(RISING_HOPPER_PROGRISEKEY_VULCAN.get()).AddToList(RiderTabs.ZERO_ONE_TAB_ITEM).AddToList(ProgrisekeyPrinter.HIDEN_PROGRISEKEY, 10));
	
	public static final DeferredItem<Item> SHINING_HOPPER_PROGRISEKEY = ITEMS.register("shining_hopper_progrisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_shining","zero_one","hiden_zero_one_driver_belt",
            		new MobEffectInstance(MobEffects.JUMP, 40, 5,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false))
            .AddToList(RiderTabs.ZERO_ONE_TAB_ITEM).AddToList(ProgrisekeyPrinter.HIDEN_PROGRISEKEY, 2));
	
	public static final DeferredItem<Item> SHINING_ASSAULT_HOPPER_PROGRISEKEY = ITEMS.register("shining_assault_hopper_progrisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_assault","zero_one","hiden_zero_one_driver_belt",
            		new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
            		new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false))
            .AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));
	
	public static final DeferredItem<Item> METALCLUSTER_HOPPER_PROGRISEKEY = ITEMS.register("metalcluster_hopper_progrisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_metalcluster","zero_one","hiden_zero_one_driver_belt",
            		new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
            		new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false))
            .AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));
	
	public static final DeferredItem<Item> ZERO_TWO_PROGRISEKEY = ITEMS.register("zero_two_progrisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","zero_two","hiden_zero_two_driver_belt",
            		new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
            		new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
            		new MobEffectInstance(Effect_core.PUNCH, 40, 8,true,false),
            		new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
            .AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));

	public static final DeferredItem<Item> RAGNAROK_PROGRISEKEY = ITEMS.register("ragnarok_progrisekey",
	          () -> new RiderFormChangeItem(new Item.Properties(),0,"","ragnarok","ragnarok_driver_belt",
					new MobEffectInstance(MobEffects.REGENERATION, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false)));
					
	public static final DeferredItem<Item> RAGNAROK_APOCALYPSE_REBOOT = ITEMS.register("ragnarok_apocalypse_reboot",
	          () -> new RiderFormChangeItem(new Item.Properties(),0,"_apocalypse_reboot","ragnarok","ragnarok_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
			.addAlternative(RAGNAROK_PROGRISEKEY.get()).addShiftForm(RAGNAROK_PROGRISEKEY.get()).AddNeedItemList(NEED_ITEM_RAGNAROK));

	
	public static final DeferredItem<Item> RED_RISING_HOPPER_PROGRISEKEY = ITEMS.register("red_rising_hopper_progrisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_red","zero_one","hiden_zero_one_driver_belt_r",
            		new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false))
            .addAlternative(RAGNAROK_APOCALYPSE_REBOOT.get()).AddToList(RiderTabs.ZERO_ONE_TAB_ITEM).AddToList(ProgrisekeyPrinter.HIDEN_PROGRISEKEY));
	
	public static final DeferredItem<Item> REALIZE_RISING_HOPPER_PROGRISEKEY = ITEMS.register("realize_rising_hopper_progrisekey",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.EPIC),0,"_realizing_hopper","zero_one","hiden_zero_one_driver_belt",
            		new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
            		new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false))
            .IsGlowing().AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));
	
	public static final DeferredItem<Item> HELLRISE_PROGRISEKEY = ITEMS.register("hellrise_progrisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_hell","zero_one","hiden_zero_one_driver_belt",
            		new MobEffectInstance(MobEffects.JUMP, 40, 5,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
            		new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.REGENERATION, 40, 2,true,false))
            .AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));
	
	public static final DeferredItem<Item> ZERO_THREE_PROGRISEKEY = ITEMS.register("zero_three_progrisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","zero_three","hiden_zero_three_driver_belt",
            		new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 5,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 6,true,false),
            		new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 4,true,false),
            		new MobEffectInstance(Effect_core.PUNCH, 40, 8,true,false),
            		new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
            .AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));

	public static final DeferredItem<Item> BITING_SHARK_PROGRISEKEY = ITEMS.register("biting_shark_progrisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_shark","zero_one","hiden_zero_one_driver_belt",
            		new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false))
            .AddToList(RiderTabs.ZERO_ONE_TAB_ITEM).AddToList(ProgrisekeyPrinter.HIDEN_PROGRISEKEY, 5));
	
	public static final DeferredItem<Item> RAGNAROK_FLAMING_TIGER_PROGRISEKEY = ITEMS.register("ragnarok_flaming_tiger_progrisekey",
	          () -> new RiderFormChangeItem(new Item.Properties(),0,"_tiger","ragnarok","ragnarok_driver_belt",
			 		new MobEffectInstance(MobEffects.REGENERATION, 40, 0,true,false),
			 		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
			 		new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
			 		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
			 		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)));
	
	public static final DeferredItem<Item> FLAMING_TIGER_PROGRISEKEY = ITEMS.register("flaming_tiger_progrisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_tiger","zero_one","hiden_zero_one_driver_belt",
            		new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false))
            .addAlternative(RAGNAROK_FLAMING_TIGER_PROGRISEKEY.get()).AddToList(RiderTabs.ZERO_ONE_TAB_ITEM).AddToList(ProgrisekeyPrinter.HIDEN_PROGRISEKEY, 5));
	
	public static final DeferredItem<Item> FREEZING_BEAR_PROGRISEKEY = ITEMS.register("freezing_bear_progrisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_bear","zero_one","hiden_zero_one_driver_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false))
            .AddToList(RiderTabs.ZERO_ONE_TAB_ITEM).AddToList(ProgrisekeyPrinter.ZAIA_PROGRISEKEY, 5));
	
	 public static final DeferredItem<Item> BREAKING_MAMMOTH_PROGRISEKEY = ITEMS.register("breaking_mammoth_progrisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_mammoth","zero_one","hiden_zero_one_driver_belt",
             		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
             		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
             		new MobEffectInstance(Effect_core.BIG, 40, 2,true,false))
			.SetPalyerModelInvisible().AddToList(RiderTabs.ZERO_ONE_TAB_ITEM).AddToList(ProgrisekeyPrinter.HIDEN_PROGRISEKEY, 5));
	
	public static final DeferredItem<Item> SPARKING_GIRAFFE_PROGRISEKEY = ITEMS.register("sparking_giraffe_progrisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_giraffe","zero_one","hiden_zero_one_driver_belt",
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false))
            .AddToList(RiderTabs.ZERO_ONE_TAB_ITEM).AddToList(ProgrisekeyPrinter.ZAIA_PROGRISEKEY, 5));
	
	public static final DeferredItem<Item> AMAZING_HERCULES_PROGRISEKEY = ITEMS.register("amazing_hercules_progrisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_hercules","zero_one","hiden_zero_one_driver_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false))
            .AddToList(RiderTabs.ZERO_ONE_TAB_ITEM).AddToList(ProgrisekeyPrinter.ZAIA_PROGRISEKEY, 5));

	public static final DeferredItem<Item> CRUSHING_BUFFALO_PROGRISEKEY_ZERO_ONE = ITEMS.register("crushing_buffalo_progrisekey_zero_one",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_buffalo","zero_one","hiden_zero_one_driver_belt",
            		new MobEffectInstance(Effect_core.BOOST, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)));
	
	public static final DeferredItem<Item> CRUSHING_BUFFALO_PROGRISEKEY = ITEMS.register("crushing_buffalo_progrisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","raider_buffalo","raid_riser_belt_buffalo",
            		new MobEffectInstance(Effect_core.BOOST, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false))
            .addAlternative(CRUSHING_BUFFALO_PROGRISEKEY_ZERO_ONE.get()).ChangeBeltModel("geo/raider_belt.geo.json").AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));
	
	public static final DeferredItem<Item> EXCITING_STAG_PROGRISEKEY = ITEMS.register("exciting_stag_progrisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_stag","zero_one","hiden_zero_one_driver_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false))
            .AddToList(RiderTabs.ZERO_ONE_TAB_ITEM).AddToList(ProgrisekeyPrinter.ZAIA_PROGRISEKEY, 5));
	
	public static final DeferredItem<Item> GATLING_HEDGEHOG_PROGRISEKEY = ITEMS.register("gatling_hedgehog_progrisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_hedgehog","zero_one","hiden_zero_one_driver_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false))
            .AddToList(RiderTabs.ZERO_ONE_TAB_ITEM).AddToList(ProgrisekeyPrinter.ZAIA_PROGRISEKEY, 5));
	
	public static final DeferredItem<Item> TRAPPING_SPIDER_PROGRISEKEY = ITEMS.register("trapping_spider_progrisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_spider","zero_one","hiden_zero_one_driver_belt",
            		new MobEffectInstance(Effect_core.ANTIPOISON, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
            .AddToList(RiderTabs.ZERO_ONE_TAB_ITEM).AddToList(ProgrisekeyPrinter.ZAIA_PROGRISEKEY, 5));
	
	public static final DeferredItem<Item> STORMING_PENGUIN_PROGRISEKEY_ZERO_ONE = ITEMS.register("storming_penguin_progrisekey_zero_one",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_penguin","zero_one","hiden_zero_one_driver_belt",
            		new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)));
	
	public static final DeferredItem<Item> STORMING_PENGUIN_PROGRISEKEY = ITEMS.register("storming_penguin_progrisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","raider_penguin","raid_riser_belt_penguin",
            		new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false))
            .addAlternative(STORMING_PENGUIN_PROGRISEKEY_ZERO_ONE.get()).ChangeBeltModel("geo/raider_belt.geo.json").AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));
	
	public static final DeferredItem<Item> HOPPING_KANGAROO_PROGRISEKEY = ITEMS.register("hopping_kangaroo_progrisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_kangaroo","zero_one","hiden_zero_one_driver_belt",
            		new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
            		new MobEffectInstance(Effect_core.PUNCH, 40, 6,true,false))
            .AddToList(RiderTabs.ZERO_ONE_TAB_ITEM).AddToList(ProgrisekeyPrinter.HIDEN_PROGRISEKEY, 5));
	
	public static final DeferredItem<Item> SPLASHING_WHALE_PROGRISEKEY_ZERO_ONE = ITEMS.register("splashing_whale_progrisekey_zero_one",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_whale","zero_one","hiden_zero_one_driver_belt",
            		new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)));
	
	public static final DeferredItem<Item> SPLASHING_WHALE_PROGRISEKEY = ITEMS.register("splashing_whale_progrisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","raider_whale","raid_riser_belt_whale",
            		new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false))
            .addAlternative(SPLASHING_WHALE_PROGRISEKEY_ZERO_ONE.get()).ChangeBeltModel("geo/raider_belt.geo.json").AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));
	
	public static final DeferredItem<Item> DYNAMAITING_LION_PROGRISEKEY_ZERO_ONE = ITEMS.register("dynamaiting_lion_progrisekey_zero_one",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_lion","zero_one","hiden_zero_one_driver_belt",
            		new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)));
	
	public static final DeferredItem<Item> DYNAMAITING_LION_PROGRISEKEY = ITEMS.register("dynamaiting_lion_progrisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","raider_lion","raid_riser_belt_lion",
            		new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false))
            .addAlternative(DYNAMAITING_LION_PROGRISEKEY_ZERO_ONE.get()).ChangeBeltModel("geo/raider_belt.geo.json").AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));
	
	public static final DeferredItem<Item> SCOUTING_PANDA_PROGRISEKEY_ZERO_ONE = ITEMS.register("scouting_panda_progrisekey_zero_one",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_panda","zero_one","hiden_zero_one_driver_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)));
	
	public static final DeferredItem<Item> SCOUTING_PANDA_PROGRISEKEY = ITEMS.register("scouting_panda_progrisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","raider_panda","raid_riser_belt_panda",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false))
            .addAlternative(SCOUTING_PANDA_PROGRISEKEY_ZERO_ONE.get()).ChangeBeltModel("geo/raider_belt.geo.json").AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));
	
	public static final DeferredItem<Item> INVADING_HORSESHOE_CRAB_PROGRISEKEY_ZERO_ONE = ITEMS.register("invading_horseshoe_crab_progrisekey_zero_one",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_horseshoe_crab","zero_one","hiden_zero_one_driver_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false)));
	
	public static final DeferredItem<Item> INVADING_HORSESHOE_CRAB_PROGRISEKEY = ITEMS.register("invading_horseshoe_crab_progrisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","raider_horseshoe_crab","raid_riser_belt_battle",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false))
            .addAlternative(INVADING_HORSESHOE_CRAB_PROGRISEKEY_ZERO_ONE.get()).ChangeBeltModel("geo/raider_belt.geo.json").AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));

	public static final DeferredItem<Item> SHOOTING_WOLF_PROGRISEKEY_ZERO_ONE = ITEMS.register("shooting_wolf_progrisekey_zero_one",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_wolf","zero_one","hiden_zero_one_driver_belt",
            		new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)));
	
	public static final DeferredItem<Item> SHOOTING_WOLF_PROGRISEKEY = ITEMS.register("shooting_wolf_progrisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","vulcan","aims_shot_riser_belt",
            		new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
			.addAlternative(SHOOTING_WOLF_PROGRISEKEY_ZERO_ONE.get()).AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));
	
	public static final DeferredItem<Item> ASSAULT_WOLF_PROGRISEKEY = ITEMS.register("assault_wolf_progrisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_assault","vulcan","aims_shot_riser_belt",
            		new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
            		new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false))
			.AddToList(RiderTabs.ZERO_ONE_TAB_ITEM).AddToList(ProgrisekeyPrinter.ZAIA_PROGRISEKEY, 2));
	
	public static final DeferredItem<Item> RAMPAGE_GATLING_PROGRISEKEY = ITEMS.register("rampage_gatling_progrisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_rampage","vulcan","aims_shot_riser_belt",
            		new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
            		new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false))
			.AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));
	
	public static final DeferredItem<Item> PUNCHING_KONG_PROGRISEKEY_ZERO_ONE = ITEMS.register("punching_kong_progrisekey_zero_one",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_kong","zero_one","hiden_zero_one_driver_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
            		new MobEffectInstance(Effect_core.PUNCH, 40, 4,true,false)));
	
	public static final DeferredItem<Item> PUNCHING_KONG_PROGRISEKEY = ITEMS.register("punching_kong_progrisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_kong","vulcan","aims_shot_riser_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
            		new MobEffectInstance(Effect_core.PUNCH, 40, 4,true,false))
			.addAlternative(PUNCHING_KONG_PROGRISEKEY_ZERO_ONE.get()).AddToList(RiderTabs.ZERO_ONE_TAB_ITEM).AddToList(ProgrisekeyPrinter.ZAIA_PROGRISEKEY, 5));
	
	public static final DeferredItem<Item> DIRE_WOLF_ZETSUMERISEKEY = ITEMS.register("dire_wolf_zetsumerisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","vulcan_lone","hiden_zero_one_driver_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false))
			.AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));

	public static final DeferredItem<Item> RUSHING_CHEETAH_PROGRISEKEY_ZERO_ONE = ITEMS.register("rushing_cheetah_progrisekey_zero_one",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_cheetah","zero_one","hiden_zero_one_driver_belt",
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)));
	
	public static final DeferredItem<Item> RUSHING_CHEETAH_PROGRISEKEY = ITEMS.register("rushing_cheetah_progrisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","valkyrie","aims_shot_riser_belt",
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false))
			.addAlternative(RUSHING_CHEETAH_PROGRISEKEY_ZERO_ONE.get()).AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));
	
	public static final DeferredItem<Item> LIGHTNING_HORNET_PROGRISEKEY_ZERO_ONE = ITEMS.register("lightning_hornet_progrisekey_zero_one",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_hornet","zero_one","hiden_zero_one_driver_belt",
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
            		new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false)));
	
	public static final DeferredItem<Item> LIGHTNING_HORNET_PROGRISEKEY = ITEMS.register("lightning_hornet_progrisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_hornet","valkyrie","aims_shot_riser_belt",
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
            		new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false))
			.addAlternative(LIGHTNING_HORNET_PROGRISEKEY_ZERO_ONE.get()).AddToList(RiderTabs.ZERO_ONE_TAB_ITEM).AddToList(ProgrisekeyPrinter.ZAIA_PROGRISEKEY, 5));
	
	public static final DeferredItem<Item> FIGHTING_JACKAL_PROGRISEKEY_ZERO_ONE = ITEMS.register("fighting_jackal_progrisekey_zero_one",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_jackal","zero_one","hiden_zero_one_driver_belt",
            		new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)));
	
	public static final DeferredItem<Item> FIGHTING_JACKAL_PROGRISEKEY = ITEMS.register("fighting_jackal_progrisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","raider_jackal","raid_riser_belt_jackal",
            		new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false))
			.addAlternative(FIGHTING_JACKAL_PROGRISEKEY_ZERO_ONE.get()).ChangeBeltModel("geo/raider_belt.geo.json").AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));
	
	public static final DeferredItem<Item> SERVAL_TIGER_ZETSUMERISEKEY = ITEMS.register("serval_tiger_zetsumerisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_serval","valkyrie","aims_shot_riser_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 5,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false))
			.AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));

	public static final DeferredItem<Item> STING_SCORPION_PROGRISEKEY_ZERO_ONE = ITEMS.register("sting_scorpion_progrisekey_zero_one",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_scorpion","zero_one","hiden_zero_one_driver_belt",
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
            		new MobEffectInstance(Effect_core.ANTIPOISON, 40, 0,true,false)));
	
	public static final DeferredItem<Item> STING_SCORPION_PROGRISEKEY = ITEMS.register("sting_scorpion_progrisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","horobi","metsuboujinrai_force_riser_belt_horobi",
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
            		new MobEffectInstance(Effect_core.ANTIPOISON, 40, 0,true,false))
			.addAlternative(STING_SCORPION_PROGRISEKEY_ZERO_ONE.get()).AddToList(RiderTabs.ZERO_ONE_TAB_ITEM).AddToList(ProgrisekeyPrinter.ZAIA_PROGRISEKEY, 10));
	
	public static final DeferredItem<Item> ARK_SCORPION_PROGRISEKEY = ITEMS.register("ark_scorpion_progrisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","horobi_ark_scorpion","zetsumetsu_driver_belt",
            		new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false))
			.AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));

	public static final DeferredItem<Item> FLYING_FALCON_PROGRISEKEY_ZERO_ONE = ITEMS.register("flying_falcon_progrisekey_zero_one",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_falcon","zero_one","hiden_zero_one_driver_belt",
            		new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false)));
	
	public static final DeferredItem<Item> FLYING_FALCON_PROGRISEKEY = ITEMS.register("flying_falcon_progrisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","jin","metsuboujinrai_force_riser_belt_jin",
            		new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false))
			.addAlternative(FLYING_FALCON_PROGRISEKEY_ZERO_ONE.get()).AddToList(RiderTabs.ZERO_ONE_TAB_ITEM).AddToList(ProgrisekeyPrinter.HIDEN_PROGRISEKEY, 5));
	
	public static final DeferredItem<Item> BURNING_FALCON_PROGRISEKEY_ZERO_ONE = ITEMS.register("burning_falcon_progrisekey_zero_one",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_burning","zero_one","hiden_zero_one_driver_belt",
            		new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
            		new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false)));
	
	public static final DeferredItem<Item> BURNING_FALCON_PROGRISEKEY = ITEMS.register("burning_falcon_progrisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","jin_burning","zaia_slash_riser_belt",
            		new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
            		new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false))
			.addAlternative(BURNING_FALCON_PROGRISEKEY_ZERO_ONE.get()).AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));

	public static final DeferredItem<Item> AMAZING_CAUCASUS_PROGRISEKEY_ZERO_ONE = ITEMS.register("amazing_caucasus_progrisekey_zero_one",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_caucasus","zero_one","hiden_zero_one_driver_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)));
	
	public static final DeferredItem<Item> AMAZING_CAUCASUS_PROGRISEKEY = ITEMS.register("amazing_caucasus_progrisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","thouser","zaia_thousandriver_belt",
            		new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false))
			.addAlternative(AMAZING_CAUCASUS_PROGRISEKEY_ZERO_ONE.get()).AddToList(RiderTabs.ZERO_ONE_TAB_ITEM).AddToList(ProgrisekeyPrinter.ZAIA_PROGRISEKEY, 2));
	
	public static final DeferredItem<Item> AWAKING_ARSINO_ZETSUMERISEKEY = ITEMS.register("awaking_arsino_zetsumerisekey",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZERO_ONE_TAB_ITEM).AddToList(ProgrisekeyPrinter.ZAIA_PROGRISEKEY, 2));
	
	public static final DeferredItem<Item> THOUSAND_ARK_PROGRISEKEY = ITEMS.register("thousand_ark_progrisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","thousand_ark","ark_driver_belt_1",
            		new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false))
			.AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));
	
	public static final DeferredItem<Item> ARK_ZERO_PROGRISEKEY = ITEMS.register("ark_zero_progrisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","ark_zero","ark_driver_belt",
            		new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
            		new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)));

	public static final DeferredItem<Item> ARK_ONE_PROGRISEKEY = ITEMS.register("ark_one_progrisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","ark_zero","ark_driver_belt_1",
					new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false)).addSwitchForm(ARK_ZERO_PROGRISEKEY.get()).ChangeRiderName("ark_one").AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));
	
	public static final DeferredItem<Item> ARK_ZERO_ONE_PROGRISEKEY = ITEMS.register("ark_zero_one_progrisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","ark_zero_one","hiden_zero_one_driver_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false))
			.AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));

	public static final DeferredItem<Item> EDEN_ZETSUMERISEKEY = ITEMS.register("eden_zetsumerisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","eden","eden_driver_belt",
            		new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
            		new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.REGENERATION, 40, 2,true,false))
			.AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));
	
	public static final DeferredItem<Item> EDEN_ZETSUMERISEKEY_LUCIFER = ITEMS.register("eden_zetsumerisekey_lucifer",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","lucifer","eden_driver_belt",
            		new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
            		new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)));
	
	public static final DeferredItem<Item> CROWDING_HOPPER_PROGRISEKEY_G = ITEMS.register("crowding_hopper_progrisekey_g",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","abaddon_g","shot_abaddo_riser_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false)));
	
	public static final DeferredItem<Item> CROWDING_HOPPER_PROGRISEKEY_R = ITEMS.register("crowding_hopper_progrisekey_r",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","abaddon_r","slash_abaddo_riser_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false)));
	
	public static final DeferredItem<Item> CROWDING_HOPPER_PROGRISEKEY_SHOT = ITEMS.register("crowding_hopper_progrisekey_shot",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","abaddon_shot","shot_abaddo_riser_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)));
	
	public static final DeferredItem<Item> CROWDING_HOPPER_PROGRISEKEY = ITEMS.register("crowding_hopper_progrisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","abaddon","slash_abaddo_riser_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)).AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));

	public static final DeferredItem<Item> TRICERATOPS_ZETSUMERISEKEY = ITEMS.register("triceratops_zetsumerisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","zaia","zaia_thousandriver_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false))
			.AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));
	
	public static final DeferredItem<Item> CARNOTAURUS_ZETSUMERISEKEY = ITEMS.register("carnotaurus_zetsumerisekey",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));
	
	public static final DeferredItem<Item> MASSBRAIN_ZETSUMERISEKEY = ITEMS.register("massbrain_zetsumerisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","metsuboujinrai","metsuboujinrai_driver_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 5,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(Effect_core.ANTIPOISON, 40, 0,true,false))
			.AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));

    public static final DeferredItem<Item> ZEIN_PROGRISEKEY = ITEMS.register("zein_progrisekey",
              () -> new RiderFormChangeItem(new Item.Properties(),0,"","zein","zein_driver_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
            		new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false))
    		.AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));
	
	public static final DeferredItem<Item> THOUSAND_KEY = ITEMS.register("thousand_key",
	          () -> new RiderFormChangeItem(new Item.Properties(),0,"_supreme","ragnarok","ragnarok_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false))
			.AddToList(NEED_ITEM_RAGNAROK).AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));


	public static final DeferredItem<Item> BEROTHA_ZETSUMERISEKEY = ITEMS.register("berotha_zetsumerisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","berotha_magia","zetsume_riser_belt_berotha",
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false))
			.AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));
	
	public static final DeferredItem<Item> KUEHNE_ZETSUMERISEKEY = ITEMS.register("kuehne_zetsumerisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","kuehne_magia","zetsume_riser_belt_kuehne",
            		new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
			.AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));
	
	public static final DeferredItem<Item> EKAL_ZETSUMERISEKEY = ITEMS.register("ekal_zetsumerisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","ekal_magia","zetsume_riser_belt_ekal",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false))
			.AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));
	
	public static final DeferredItem<Item> NEOHI_ZETSUMERISEKEY = ITEMS.register("neohi_zetsumerisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","neohi_magia","zetsume_riser_belt_neohi",
            		new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 2,true,false))
			.AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));
	
	public static final DeferredItem<Item> ONYCHO_ZETSUMERISEKEY = ITEMS.register("onycho_zetsumerisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","onycho_magia","zetsume_riser_belt_onycho",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false))
			.AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));
	
	public static final DeferredItem<Item> VICARYA_ZETSUMERISEKEY = ITEMS.register("vicarya_zetsumerisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","vicarya_magia","zetsume_riser_belt_vicarya",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false))
			.AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));
	
	public static final DeferredItem<Item> GAERU_ZETSUMERISEKEY = ITEMS.register("gaeru_zetsumerisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","gaeru_magia","zetsume_riser_belt_gaeru",
            		new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 40, 1,true,false))
			.AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));
	
	public static final DeferredItem<Item> MAMMOTH_ZETSUMERISEKEY = ITEMS.register("mammoth_zetsumerisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","mammoth_magia","zetsume_riser_belt_mammoth",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false))
			.AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));
	
	public static final DeferredItem<Item> DODO_ZETSUMERISEKEY_MAGIA = ITEMS.register("dodo_zetsumerisekey_magia",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","dodo_magia","zetsume_riser_belt_dodo",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)	));

	public static final DeferredItem<Item> DODO_CUSTOM_ZETSUMERISEKEY = ITEMS.register("dodo_custom_zetsumerisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","dodo_magia_custom","zetsume_riser_belt_dodo",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false)	));

	public static final DeferredItem<Item> DODO_CUSTOM_TWO_ZETSUMERISEKEY = ITEMS.register("dodo_custom_two_zetsumerisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","dodo_magia_custom_two","zetsume_riser_belt_dodo",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false)	));

	public static final DeferredItem<Item> DODO_ZETSUMERISEKEY = ITEMS.register("dodo_zetsumerisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","ikazuchi","metsuboujinrai_force_riser_belt_ikazuchi",
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false))
			.AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));
	
	public static final DeferredItem<Item> ARSINO_ZETSUMERISEKEY = ITEMS.register("arsino_zetsumerisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","arsino_magia","zetsume_riser_belt_arsino",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false))
			.AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));
	
	public static final DeferredItem<Item> UNKNOWN_ZETSUMERISEKEY = ITEMS.register("unknown_zetsumerisekey",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));

	public static final DeferredItem<Item> JAPANESE_WOLF_ZETSUMERISEKEY_VULCAN = ITEMS.register("japanese_wolf_zetsumerisekey_vulcan",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_orthros","vulcan","aims_shot_riser_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false)));
	
	public static final DeferredItem<Item> JAPANESE_WOLF_ZETSUMERISEKEY = ITEMS.register("japanese_wolf_zetsumerisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","naki","metsuboujinrai_force_riser_belt_naki",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false))
			.addAlternative(JAPANESE_WOLF_ZETSUMERISEKEY_VULCAN.get()).AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));
	
	public static final DeferredItem<Item> ROCKING_HOPPER_ZETSUMERISEKEY = ITEMS.register("rocking_hopper_zetsumerisekey",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","ichigata","cyclone_riser_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false))
			.AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));

	public static final DeferredItem<Item> IS_PROGRISEKEY = ITEMS.register("is_progrisekey",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZERO_ONE_TAB_ITEM).AddToList(ProgrisekeyPrinter.HUMAGEAR_PROGRISEKEY));
	public static final DeferredItem<Item> UCHUYARO_SUBARU_PROGRISEKEY = ITEMS.register("uchuyaro_subaru_progrisekey",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZERO_ONE_TAB_ITEM).AddToList(ProgrisekeyPrinter.HUMAGEAR_PROGRISEKEY, 5));
	public static final DeferredItem<Item> SAIKYO_TAKUMI_OYAKATA_PROGRISEKEY = ITEMS.register("saikyo_takumi_oyakata_progrisekey",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZERO_ONE_TAB_ITEM).AddToList(ProgrisekeyPrinter.HUMAGEAR_PROGRISEKEY, 5));
	public static final DeferredItem<Item> DR_OMIGOTO_PROGRISEKEY = ITEMS.register("dr_omigoto_progrisekey",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZERO_ONE_TAB_ITEM).AddToList(ProgrisekeyPrinter.HUMAGEAR_PROGRISEKEY, 5));
	public static final DeferredItem<Item> SUMIDA_SMILE_PROGRISEKEY = ITEMS.register("sumida_smile_progrisekey",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZERO_ONE_TAB_ITEM).AddToList(ProgrisekeyPrinter.HUMAGEAR_PROGRISEKEY, 5));
	public static final DeferredItem<Item> MAMORU_PROGRISEKEY = ITEMS.register("mamoru_progrisekey",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZERO_ONE_TAB_ITEM).AddToList(ProgrisekeyPrinter.HUMAGEAR_PROGRISEKEY, 5));
	public static final DeferredItem<Item> BENGOSHI_BINGO_PROGRISEKEY = ITEMS.register("bengoshi_bingo_progrisekey",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZERO_ONE_TAB_ITEM).AddToList(ProgrisekeyPrinter.HUMAGEAR_PROGRISEKEY, 5));
	public static final DeferredItem<Item> IKKAN_NIGIRO_PROGRISEKEY = ITEMS.register("ikkan_nigiro_progrisekey",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZERO_ONE_TAB_ITEM).AddToList(ProgrisekeyPrinter.HUMAGEAR_PROGRISEKEY, 5));
	public static final DeferredItem<Item> MATSUDA_ENJI_PROGRISEKEY = ITEMS.register("matsuda_enji_progrisekey",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZERO_ONE_TAB_ITEM).AddToList(ProgrisekeyPrinter.HUMAGEAR_PROGRISEKEY, 5));
	public static final DeferredItem<Item> MORIFUDE_G_PEN_PROGRISEKEY = ITEMS.register("morifude_g_pen_progrisekey",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZERO_ONE_TAB_ITEM).AddToList(ProgrisekeyPrinter.HUMAGEAR_PROGRISEKEY, 5));
	public static final DeferredItem<Item> FUKKINHOUKAI_TARO_PROGRISEKEY = ITEMS.register("fukkinhoukai_taro_progrisekey",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZERO_ONE_TAB_ITEM).AddToList(ProgrisekeyPrinter.HUMAGEAR_PROGRISEKEY, 5));
	public static final DeferredItem<Item> SHESTA_PROGRISEKEY = ITEMS.register("shesta_progrisekey",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZERO_ONE_TAB_ITEM).AddToList(ProgrisekeyPrinter.HUMAGEAR_PROGRISEKEY, 5));
	public static final DeferredItem<Item> LOVE_CHAN_PROGRISEKEY = ITEMS.register("love_chan_progrisekey",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZERO_ONE_TAB_ITEM).AddToList(ProgrisekeyPrinter.HUMAGEAR_PROGRISEKEY, 5));
	public static final DeferredItem<Item> HAKASE_BOT_PROGRISEKEY = ITEMS.register("hakase_bot_progrisekey",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZERO_ONE_TAB_ITEM).AddToList(ProgrisekeyPrinter.HUMAGEAR_PROGRISEKEY, 5));
	public static final DeferredItem<Item> OKURERU_PROGRISEKEY = ITEMS.register("okureru_progrisekey",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZERO_ONE_TAB_ITEM).AddToList(ProgrisekeyPrinter.HUMAGEAR_PROGRISEKEY, 5));
	public static final DeferredItem<Item> DELMO_PROGRISEKEY = ITEMS.register("delmo_progrisekey",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZERO_ONE_TAB_ITEM).AddToList(ProgrisekeyPrinter.HUMAGEAR_PROGRISEKEY, 5));
	public static final DeferredItem<Item> MATSURIDA_Z_PROGRISEKEY = ITEMS.register("matsurida_z_progrisekey",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));

	public static final DeferredItem<Item> HOROBI_PROGRISEKEY = ITEMS.register("horobi_progrisekey",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));
	public static final DeferredItem<Item> NAKI_PROGRISEKEY = ITEMS.register("naki_progrisekey",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));
	public static final DeferredItem<Item> JIN_PROGRISEKEY = ITEMS.register("jin_progrisekey",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));
	public static final DeferredItem<Item> IKAZUCHI_PROGRISEKEY = ITEMS.register("ikazuchi_progrisekey",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));
	public static final DeferredItem<Item> PRESIDENT_DAN_KUROTO_PROGRISEKEY = ITEMS.register("president_dan_kuroto_progrisekey",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));

	public static final DeferredItem<Item> MERRY_HOPPER_PROGRISEKEY = ITEMS.register("merry_hopper_progrisekey",
			() -> new BaseItem(new Item.Properties()).AddToList(GiftItem.GIFTS).AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));

    public static final DeferredItem<Item> ZERO_ONE_HELMET = ITEMS.register("zero_onehead",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
    public static final DeferredItem<Item> ZERO_ONE_CHESTPLATE = ITEMS.register("zero_onetroso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
    public static final DeferredItem<Item> ZERO_ONE_LEGGINGS = ITEMS.register("zero_onelegs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));

	public static final DeferredItem<Item> PROGRISE_HOLDER = ITEMS.register("progrise_holder",
			() -> new ProgriseHolderItem().AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));
	public static final DeferredItem<Item> IKAZUCHI_PROGRISE_HOLDER = ITEMS.register("ikazuchi_progrise_holder",
			() -> new IkazuchiProgriseHolderItem().AddToList(RiderTabs.ZERO_ONE_TAB_ITEM));
    
    public static final DeferredItem<Item> HIDEN_ZERO_ONE_DRIVER = ITEMS.register("hiden_zero_one_driver",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"zero_one",RISING_HOPPER_PROGRISEKEY ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
   
    public static final DeferredItem<Item> HIDEN_ZERO_TWO_DRIVER = ITEMS.register("hiden_zero_two_driver",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"zero_two",ZERO_TWO_PROGRISEKEY ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
 
    public static final DeferredItem<Item> HIDEN_ZERO_THREE_DRIVER = ITEMS.register("hiden_zero_three_driver",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"zero_three",ZERO_THREE_PROGRISEKEY ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
 
    public static final DeferredItem<Item> SHOTRISER_VULCAN = ITEMS.register("shotriser_vulcan",
    		() -> new ShotriserItem(ArmorMaterials.DIAMOND,"vulcan",SHOOTING_WOLF_PROGRISEKEY ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
    public static final DeferredItem<Item> SHOTRISER_VALKYRIE = ITEMS.register("shotriser_valkyrie",
    		() -> new ShotriserItem(ArmorMaterials.DIAMOND,"valkyrie",RUSHING_CHEETAH_PROGRISEKEY ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));

	public static final DeferredItem<Item> ZAIA_THOUSANDRIVER = ITEMS.register("zaia_thousandriver",
    		() -> new ThousandriverItem(ArmorMaterials.DIAMOND,"thouser",AMAZING_CAUCASUS_PROGRISEKEY ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
    public static final DeferredItem<Item> ZAIA_THOUSANDRIVER_ZAIA = ITEMS.register("zaia_thousandriver_zaia",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"zaia",TRICERATOPS_ZETSUMERISEKEY ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));

	public static final DeferredItem<Item> FORCERISER_HOROBI = ITEMS.register("forceriser_horobi",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"horobi",STING_SCORPION_PROGRISEKEY ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
    public static final DeferredItem<Item> FORCERISER_NAKI = ITEMS.register("forceriser_naki",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"naki",JAPANESE_WOLF_ZETSUMERISEKEY ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
    public static final DeferredItem<Item> FORCERISER_JIN = ITEMS.register("forceriser_jin",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"jin",FLYING_FALCON_PROGRISEKEY ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
    public static final DeferredItem<Item> FORCERISER_IKAZUCHI = ITEMS.register("forceriser_ikazuchi",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"ikazuchi",DODO_ZETSUMERISEKEY ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
    public static final DeferredItem<Item> FORCERISER_001 = ITEMS.register("forceriser_001",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"zero_zero_one",RISING_HOPPER_PROGRISEKEY ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).Override_belt_text("force_riser_belt_001").AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));

	public static final DeferredItem<Item> ZAIA_SLASHRISER = ITEMS.register("zaia_slashriser",
    		() -> new ShotriserItem(ArmorMaterials.DIAMOND,"jin_burning",BURNING_FALCON_PROGRISEKEY ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));

	public static final DeferredItem<Item> ZETSUMETSU_DRIVER = ITEMS.register("zetsumetsu_driver",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"horobi_ark_scorpion",ARK_SCORPION_PROGRISEKEY ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
	public static final DeferredItem<Item> METSUBOUJINRAI_DRIVER = ITEMS.register("metsuboujinrai_driver",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"metsuboujinrai",MASSBRAIN_ZETSUMERISEKEY ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));

	public static final DeferredItem<Item> ARK_DRIVER_ZERO = ITEMS.register("ark_driver_zero",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"ark_zero",ARK_ZERO_PROGRISEKEY ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
	public static final DeferredItem<Item> ARK_DRIVER_ZERO_THOUSAND_ARK = ITEMS.register("ark_driver_zero_thousand_ark",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"thousand_ark",THOUSAND_ARK_PROGRISEKEY ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
	public static final DeferredItem<Item> HIDEN_ZERO_ONE_DRIVER_AZU = ITEMS.register("hiden_zero_one_driver_azu",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"ark_zero_one",ARK_ZERO_ONE_PROGRISEKEY ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));

	public static final DeferredItem<Item> CYCLONERISER = ITEMS.register("cycloneriser",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"ichigata",ROCKING_HOPPER_ZETSUMERISEKEY ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));

	public static final DeferredItem<Item> EDEN_DRIVER = ITEMS.register("eden_driver",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"eden",EDEN_ZETSUMERISEKEY ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
	public static final DeferredItem<Item> EDEN_DRIVER_LUCIFER = ITEMS.register("eden_driver_lucifer",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"lucifer",EDEN_ZETSUMERISEKEY_LUCIFER ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));

	public static final DeferredItem<Item> SLASH_ABADDO_RISER = ITEMS.register("slash_abaddo_riser",
    		() -> new ShotriserItem(ArmorMaterials.DIAMOND,"abaddon",CROWDING_HOPPER_PROGRISEKEY ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
	public static final DeferredItem<Item> SHOT_ABADDO_RISER = ITEMS.register("shot_abaddo_riser",
    		() -> new ShotriserItem(ArmorMaterials.DIAMOND,"abaddon_shot",CROWDING_HOPPER_PROGRISEKEY_SHOT ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).Override_belt_text("shot_abaddo_riser_belt").AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
	public static final DeferredItem<Item> SLASH_ABADDO_RISER_R = ITEMS.register("slash_abaddo_riser_r",
    		() -> new ShotriserItem(ArmorMaterials.DIAMOND,"abaddon_r",CROWDING_HOPPER_PROGRISEKEY_R ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
	public static final DeferredItem<Item> SHOT_ABADDO_RISER_G = ITEMS.register("shot_abaddo_riser_g",
    		() -> new ShotriserItem(ArmorMaterials.DIAMOND,"abaddon_g",CROWDING_HOPPER_PROGRISEKEY_G ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).Override_belt_text("shot_abaddo_riser_belt").AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
	public static final DeferredItem<Item> SHOT_ABADDO_RISER_B = ITEMS.register("shot_abaddo_riser_b",
    		() -> new ShotriserItem(ArmorMaterials.DIAMOND,"abaddon_b",CROWDING_HOPPER_PROGRISEKEY_G ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).Override_belt_text("shot_abaddo_riser_belt").AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
	public static final DeferredItem<Item> SLASH_ABADDO_RISER_O = ITEMS.register("slash_abaddo_riser_o",
    		() -> new ShotriserItem(ArmorMaterials.DIAMOND,"abaddon_o",CROWDING_HOPPER_PROGRISEKEY_R ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));

	public static final DeferredItem<Item> HIDEN_ZERO_ONE_DRIVER_VULCAN = ITEMS.register("hiden_zero_one_driver_vulcan",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"vulcan_lone",DIRE_WOLF_ZETSUMERISEKEY ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));

	public static final DeferredItem<Item> ZEIN_DRIVER = ITEMS.register("zein_driver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"zein",ZEIN_PROGRISEKEY ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));


	public static final DeferredItem<Item> RAGNAROK_DRIVER = ITEMS.register("ragnarok_driver",
	  		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"ragnarok",RAGNAROK_PROGRISEKEY ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
	
	public static final DeferredItem<Item> ZETSUMERISER_BEROTHA = ITEMS.register("zetsumeriser_berotha",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"berotha_magia",BEROTHA_ZETSUMERISEKEY ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
	public static final DeferredItem<Item> ZETSUMERISER_KUEHNE = ITEMS.register("zetsumeriser_kuehne",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"kuehne_magia",KUEHNE_ZETSUMERISEKEY ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
	public static final DeferredItem<Item> ZETSUMERISER_EKAL = ITEMS.register("zetsumeriser_ekal",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"ekal_magia",EKAL_ZETSUMERISEKEY ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
	public static final DeferredItem<Item> ZETSUMERISER_NEOHI = ITEMS.register("zetsumeriser_neohi",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"neohi_magia",NEOHI_ZETSUMERISEKEY ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
	public static final DeferredItem<Item> ZETSUMERISER_ONYCHO = ITEMS.register("zetsumeriser_onycho",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"onycho_magia",ONYCHO_ZETSUMERISEKEY ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
	public static final DeferredItem<Item> ZETSUMERISER_VICARYA = ITEMS.register("zetsumeriser_vicarya",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"vicarya_magia",VICARYA_ZETSUMERISEKEY ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
	public static final DeferredItem<Item> ZETSUMERISER_GAERU = ITEMS.register("zetsumeriser_gaeru",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"gaeru_magia",GAERU_ZETSUMERISEKEY ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
	public static final DeferredItem<Item> ZETSUMERISER_MAMMOTH = ITEMS.register("zetsumeriser_mammoth",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND, "mammoth_magia",MAMMOTH_ZETSUMERISEKEY ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
	public static final DeferredItem<Item> ZETSUMERISER_DODO = ITEMS.register("zetsumeriser_dodo",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"dodo_magia",DODO_ZETSUMERISEKEY_MAGIA ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
	public static final DeferredItem<Item> ZETSUMERISER_DODO_CUSTOM = ITEMS.register("zetsumeriser_dodo_custom",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"dodo_magia_custom",DODO_CUSTOM_ZETSUMERISEKEY ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
	public static final DeferredItem<Item> ZETSUMERISER_DODO_CUSTOM_TWO = ITEMS.register("zetsumeriser_dodo_custom_two",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"dodo_magia_custom_two",DODO_CUSTOM_TWO_ZETSUMERISEKEY ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
	public static final DeferredItem<Item> ZETSUMERISER_ARSINO = ITEMS.register("zetsumeriser_arsino",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"arsino_magia",ARSINO_ZETSUMERISEKEY ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
	public static final DeferredItem<Item> RAIDRISER_BATTLE = ITEMS.register("raidriser_battle",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"raider_horseshoe_crab",INVADING_HORSESHOE_CRAB_PROGRISEKEY ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
	public static final DeferredItem<Item> RAIDRISER_BUFFALO = ITEMS.register("raidriser_buffalo",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"raider_buffalo",CRUSHING_BUFFALO_PROGRISEKEY ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
	public static final DeferredItem<Item> RAIDRISER_WHALE = ITEMS.register("raidriser_whale",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"raider_whale",SPLASHING_WHALE_PROGRISEKEY ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
	public static final DeferredItem<Item> RAIDRISER_LION = ITEMS.register("raidriser_lion",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"raider_lion",DYNAMAITING_LION_PROGRISEKEY ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
	public static final DeferredItem<Item> RAIDRISER_PENGUIN = ITEMS.register("raidriser_penguin",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"raider_penguin",STORMING_PENGUIN_PROGRISEKEY ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
	public static final DeferredItem<Item> RAIDRISER_PANDA = ITEMS.register("raidriser_panda",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"raider_panda",SCOUTING_PANDA_PROGRISEKEY ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
	public static final DeferredItem<Item> RAIDRISER_JACKAL = ITEMS.register("raidriser_jackal",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"raider_jackal",FIGHTING_JACKAL_PROGRISEKEY ,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));

	public static final DeferredItem<Item> GIGER_BELT = ITEMS.register("giger_belt",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"giger",BREAKING_MAMMOTH_PROGRISEKEY,ZERO_ONE_HELMET, ZERO_ONE_CHESTPLATE,ZERO_ONE_LEGGINGS , new Item.Properties())
    		.Override_belt_text("giger_belt_belt").AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));

	/*
	public static final DeferredItem<Item> PROGRISE_HOLDER = ITEMS.register("progrise_holder",
			() -> new GimmickCarrierItem(new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM));
	 */
	 
    public static final DeferredItem<Item> ATTACHE_CALIBUR = ITEMS.register("attache_calibur",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
	public static final DeferredItem<Item> ATTACHE_SHOTGUN = ITEMS.register("attache_shotgun",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
	public static final DeferredItem<Item> ATTACHE_ARROW = ITEMS.register("attache_arrow",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
	public static final DeferredItem<Item> AUTHORISE_BUSTER = ITEMS.register("authorise_buster",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 13, -2.4F, new Item.Properties()).IsSwordGun().AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
    public static final DeferredItem<Item> PROGRISE_HOPPER_BLADE = ITEMS.register("progrise_hopper_blade",
            () -> new BaseSwordItem(Tiers.DIAMOND, 11, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
    public static final DeferredItem<Item> PROGRISE_HOPPER_BLADE_NAGINATA = ITEMS.register("progrise_hopper_blade_naginata",
            () -> new BaseSwordItem(Tiers.DIAMOND, 18, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
    public static final DeferredItem<Item> THOUSAND_JACKER = ITEMS.register("thousand_jacker",
            () -> new BaseSwordItem(Tiers.DIAMOND, 8, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));

	public static final DeferredItem<Item> SHOTRISER = ITEMS.register("shot_riser_gun",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
    public static final DeferredItem<Item> SLASHRISER = ITEMS.register("zaia_slashriser_sword",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
	public static final DeferredItem<Item> SHOTABADDORISER_GUN = ITEMS.register("shot_abaddo_gun",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));
    public static final DeferredItem<Item> SLASHABADDORISER_SWORD = ITEMS.register("slash_abaddo_sword",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.ZERO_ONE_TAB_ITEM).ChangeRepairItem(HIDEN_METAL.get()));

	public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}

}