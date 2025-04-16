package com.kelco.kamenridercraft.item;

import java.util.ArrayList;
import java.util.List;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.block.Rider_Blocks;
import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.item.BaseItems.*;
import com.kelco.kamenridercraft.item.decade.AttackRideCardItem;
import com.kelco.kamenridercraft.item.decade.BlankCardItem;
import com.kelco.kamenridercraft.item.decade.FinalKamenRideCardItem;
import com.kelco.kamenridercraft.item.decade.RiderSummonCardItem;
import com.kelco.kamenridercraft.item.decade.RideBookerItem;
import com.kelco.kamenridercraft.item.decade.RiderCardItem;
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

public class Decade_Rider_Items {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);
	public static List<Item> NEO_DIEND_SUMMON_BELTS = new ArrayList<Item>();
	public static List<Item> NEO_DIEND_SUMMON_FORMS = new ArrayList<Item>();
	public static List<Item> NEO_DIEND_SUMMON_WEAPONS = new ArrayList<Item>();
	public static List<Item> COMPLETE_21_FORMS = new ArrayList<Item>();
	public static List<Item> COMPLETE_21_WEAPONS = new ArrayList<Item>();

	public static final DeferredItem<Item> DECADE_LOGO = ITEMS.register("decade_logo",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DECADE_CAMERA = ITEMS.register("decade_camera",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.DECADE_TAB_ITEM).KeepItem());

	public static final DeferredItem<Item> BLANK_CARD = ITEMS.register("blank_card",
			() -> new BlankCardItem(new Item.Properties()).AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> DECADE_CYAN_CARD = ITEMS.register("decade_cyan_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_cyan","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)));

    public static final DeferredItem<Item> DIEND_GREEN_CARD = ITEMS.register("diend_green_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_green","diend","diend_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)));

    public static final DeferredItem<Item> DECADE_CARD = ITEMS.register("decade_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false))
					.AddCompatibilityList(new String[] {"neo_decade"}).ChangeRiderName("decade").addAlternative(DIEND_GREEN_CARD.get())
					.AddToList(RiderTabs.DECADE_TAB_ITEM).AddToList(BlankCardItem.RIDER_CARD, 10));

    public static final DeferredItem<Item> K_TOUCH = ITEMS.register("k_touch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_complete","decade","decadriver_belt_k_touch",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)).AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> K_TOUCH_21 = ITEMS.register("k_touch_21",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_complete_21","neo_decade","decadriver_belt_k_touch_21",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 5,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.ignoreOverrideBeltText().AddToList(RiderTabs.DECADE_TAB_ITEM));
					
    public static final DeferredItem<Item> DECADE_VIOLENT_EMOTION_CARD = ITEMS.register("decade_violent_emotion_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_violent_emotion","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
					new MobEffectInstance(MobEffects.HUNGER, 40, 0,true,false)).AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> DIEND_CARD = ITEMS.register("diend_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","diend","diend_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)).addAlternative(DECADE_CYAN_CARD.get()).AddToList(RiderTabs.DECADE_TAB_ITEM).AddToList(BlankCardItem.RIDER_CARD, 5));

    public static final DeferredItem<Item> DIEND_CARD_POWER_UP = ITEMS.register("diend_power_up_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","diend","diend_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)).AddToList(RiderTabs.DECADE_TAB_ITEM));
    
    public static final DeferredItem<Item> K_TOUCH_DIEND = ITEMS.register("k_touch_diend",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_complete","diend","diend_belt_k_touch",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)).AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> DARK_DECADE_CARD = ITEMS.register("dark_decade_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","dark_decade","dark_decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)).AddToList(RiderTabs.DECADE_TAB_ITEM).AddToList(BlankCardItem.RIDER_CARD));

	public static String[] BaseDecadeUsers = new String[] {"decade","dark_decade","neo_decade"};

    public static final DeferredItem<Item> KUUGA_MIGHTY_CARD = ITEMS.register("kuuga_mighty_card",
            () -> new RiderCardItem(new Item.Properties(),0,"","decade","decadriver_belt",
            		new MobEffectInstance(Effect_core.PUNCH, 40, 2,true,false))
			.setSummonBelt((RiderDriverItem)Kuuga_Rider_Items.ARCLE.get()).AddCompatibilityList(BaseDecadeUsers)
					.IsGlowing().ChangeModel("kuuga.geo.json").ChangeRiderName("kuuga").AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> AGITO_GROUND_CARD = ITEMS.register("agito_ground_card",
	        () -> new RiderCardItem(new Item.Properties(),0,"","decade","decadriver_belt",
	        		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
	        		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false))
	        .setSummonBelt((RiderDriverItem)Agito_Rider_Items.ALTERING.get()).AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("agito").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> RYUKI_CARD = ITEMS.register("ryuki_card",
            () -> new RiderCardItem(new Item.Properties(),0,"","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false))
            .setSummonBelt((RiderDriverItem)Ryuki_Rider_Items.RYUKIDRIVER.get()).addSummonWeapon(Ryuki_Rider_Items.DRAG_CLAW.get()).AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("ryuki").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> FAIZ_CARD = ITEMS.register("faiz_card",
            () -> new RiderCardItem(new Item.Properties(),0,"","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false))
            .setSummonBelt((RiderDriverItem)Faiz_Rider_Items.FAIZ_DRIVER.get()).addSummonWeapon(Faiz_Rider_Items.FAIZ_EDGE.get()).IsGlowing().AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("faiz").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> BLADE_ACE_CARD = ITEMS.register("blade_ace_card",
            () -> new RiderCardItem(new Item.Properties(),0,"","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false))
            .setSummonBelt((RiderDriverItem)Blade_Rider_Items.BLAYBUCKLE.get()).addSummonWeapon(Blade_Rider_Items.BLAYROUZER.get()).AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("blade").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> HIBIKI_CARD = ITEMS.register("hibiki_card",
            () -> new RiderCardItem(new Item.Properties(),0,"","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
			.setSummonBelt((RiderDriverItem)Hibiki_Rider_Items.HIBIKIDRIVER.get()).addSummonWeapon(Hibiki_Rider_Items.ONGEKIBO_REKKA.get()).addSummonWeapon(Hibiki_Rider_Items.ONGEKIBO_REKKA.get()).AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("hibiki").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> KABUTO_RIDER_CARD = ITEMS.register("kabuto_rider_card",
            () -> new RiderCardItem(new Item.Properties(),0,"","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false))
            .setSummonBelt((RiderDriverItem)Kabuto_Rider_Items.KABUTO_RIDER_BELT.get()).setSummonForm((RiderFormChangeItem)Kabuto_Rider_Items.KABUTO_ZECTER.get()).addSummonWeapon(Kabuto_Rider_Items.KABUTO_KUNAI.get()).AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("kabuto").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> DEN_O_SWORD_CARD = ITEMS.register("den_o_sword_card",
            () -> new RiderCardItem(new Item.Properties(),0,"","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false))
            .setSummonBelt((RiderDriverItem)Den_O_Rider_Items.DEN_O_BELT.get()).addSummonWeapon(Den_O_Rider_Items.DEN_GASHER_SWORD.get()).AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("den_o").AddToList(RiderTabs.DECADE_TAB_ITEM));


    public static final DeferredItem<Item> KIVA_CARD = ITEMS.register("kiva_card",
            () -> new RiderCardItem(new Item.Properties(),0,"","decade","decadriver_belt",
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false))
			.setSummonBelt((RiderDriverItem)Kiva_Rider_Items.KIVAT_BELT.get()).AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("kiva").AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> W_CARD = ITEMS.register("w_card",
			() -> new RiderCardItem(new Item.Properties(),0,"_w","neo_decade","neo_decadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false))
			.setSummonBelt(0).ChangeRiderName("decade").AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> OOO_CARD = ITEMS.register("ooo_card",
			() -> new RiderCardItem(new Item.Properties(),0,"_ooo","neo_decade","neo_decadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false))
			.setSummonBelt(3).addSummonWeapon(2).ChangeRiderName("decade").AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> FOURZE_CARD = ITEMS.register("fourze_card",
			() -> new RiderCardItem(new Item.Properties(),0,"","neo_decade","neo_decadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false))
			.setSummonBelt(5).ChangeRiderName("fourze").AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> WIZARD_CARD = ITEMS.register("wizard_card",
			() -> new RiderCardItem(new Item.Properties(),0,"","neo_decade","neo_decadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false))
			.setSummonBelt(7).addSummonWeapon(4).ChangeRiderName("wizard").AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> GAIM_CARD = ITEMS.register("gaim_card",
			() -> new RiderCardItem(new Item.Properties(),0,"_gaim","neo_decade","neo_decadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false))
			.setSummonBelt(9).addSummonWeapon(7).addSummonWeapon(6).ChangeRiderName("decade").AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DRIVE_CARD = ITEMS.register("drive_card",
			() -> new RiderCardItem(new Item.Properties(),0,"_drive","neo_decade","neo_decadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false))
			.setSummonBelt(11).addSummonWeapon(9).ChangeRiderName("decade").AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> GHOST_CARD = ITEMS.register("ghost_card",
			() -> new RiderCardItem(new Item.Properties(),0,"_ghost","neo_decade","neo_decadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false))
			.setSummonBelt(13).addSummonWeapon(11).ChangeRiderName("decade").AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> EX_AID_CARD = ITEMS.register("ex_aid_card",
			() -> new RiderCardItem(new Item.Properties(),0,"","neo_decade","neo_decadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false))
			.setSummonBelt(15).setSummonForm(0).addSummonWeapon(13).ChangeRiderName("ex_aid").AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> BUILD_CARD = ITEMS.register("build_card",
			() -> new RiderCardItem(new Item.Properties(),0,"_build","neo_decade","neo_decadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false))
			.setSummonBelt(17).addSummonWeapon(15).ChangeRiderName("decade").AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> ZI_O_CARD = ITEMS.register("zi_o_card",
			() -> new RiderCardItem(new Item.Properties(),0,"","neo_decade","neo_decadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false))
			.setSummonBelt(19).addSummonWeapon(17).ChangeRiderName("zi_o").AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> ZERO_ONE_CARD = ITEMS.register("zero_one_card",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.DECADE_TAB_ITEM));
/*
	public static final DeferredItem<Item> SABER_CARD = ITEMS.register("saber_card",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> REVI_CARD = ITEMS.register("revi_card",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> VICE_CARD = ITEMS.register("vice_card",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> GEATS_CARD = ITEMS.register("geats_card",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> GOTCHARD_CARD = ITEMS.register("gotchard_card",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> GAVV_CARD = ITEMS.register("gavv_card",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.DECADE_TAB_ITEM));
*/
	public static final DeferredItem<Item> G3_CARD = ITEMS.register("g3_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem)Agito_Rider_Items.G_BUCKLE_G3.get()).addSummonWeapon(Agito_Rider_Items.GM_01_SCORPION.get()).AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> KNIGHT_CARD = ITEMS.register("knight_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem)Ryuki_Rider_Items.KNIGHTDRIVER.get()).addSummonWeapon(Ryuki_Rider_Items.WING_LANCER.get()).AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> KAIXA_CARD = ITEMS.register("kaixa_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem)Faiz_Rider_Items.KAIXA_DRIVER.get()).addSummonWeapon(Faiz_Rider_Items.KAIXA_BLAYGUN.get()).AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> GARREN_CARD = ITEMS.register("garren_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem)Blade_Rider_Items.GARRENBUCKLE.get()).addSummonWeapon(Blade_Rider_Items.GARRENROUZER.get()).AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> IBUKI_CARD = ITEMS.register("ibuki_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem)Hibiki_Rider_Items.IBUKIDRIVER.get()).addSummonWeapon(Hibiki_Rider_Items.ONGEKIKAN_REPPUU.get()).AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> GATACK_CARD = ITEMS.register("gatack_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem)Kabuto_Rider_Items.GATACK_RIDER_BELT.get()).setSummonForm((RiderFormChangeItem)Kabuto_Rider_Items.GATACK_ZECTER.get()).addSummonWeapon(Kabuto_Rider_Items.GATACK_DOUBLE_CALIBUR.get()).addSummonWeapon(Kabuto_Rider_Items.GATACK_DOUBLE_CALIBUR_MINUS.get()).AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> ZERONOS_CARD = ITEMS.register("zeronos_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem)Den_O_Rider_Items.ZERONOS_BELT.get()).addSummonWeapon(Den_O_Rider_Items.ZEROGASHER.get()).AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> IXA_CARD = ITEMS.register("ixa_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem)Kiva_Rider_Items.IXA_BELT.get()).addSummonWeapon(Kiva_Rider_Items.IXA_CALIBER.get()).AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> ACCEL_CARD = ITEMS.register("accel_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt(1).addSummonWeapon(1).AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> BIRTH_CARD = ITEMS.register("birth_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt(4).addSummonWeapon(3).AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> METEOR_CARD = ITEMS.register("meteor_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt(6).AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> BEAST_CARD = ITEMS.register("beast_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt(8).addSummonWeapon(5).AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> BARON_CARD = ITEMS.register("baron_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt(10).addSummonWeapon(8).AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> MACH_CARD = ITEMS.register("mach_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt(12).addSummonWeapon(10).AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> SPECTER_CARD = ITEMS.register("specter_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt(14).addSummonWeapon(12).AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> BRAVE_CARD = ITEMS.register("brave_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt(16).setSummonForm(1).addSummonWeapon(14).AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> CROSS_Z_CARD = ITEMS.register("cross_z_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt(18).addSummonWeapon(16).AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> GEIZ_CARD = ITEMS.register("geiz_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt(20).addSummonWeapon(18).AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> KUUGA_GROWING_CARD = ITEMS.register("kuuga_growing_card",
	        () -> new RiderFormChangeItem(new Item.Properties(),0,"_growing","decade","decadriver_belt",
	        		new MobEffectInstance(MobEffects.WEAKNESS, 40, 2,true,false))
					.IsGlowing().ChangeModel("kuuga_growing.geo.json").AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("kuuga").AddToList(RiderTabs.DECADE_TAB_ITEM));
		
    public static final DeferredItem<Item> KUUGA_DRAGON_CARD = ITEMS.register("kuuga_dragon_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_dragon","decade","decadriver_belt",
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.IsGlowing().ChangeModel("kuuga_dragon.geo.json").AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("kuuga").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> KUUGA_PEGASUS_CARD = ITEMS.register("kuuga_pegasus_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_pegasus","decade","decadriver_belt",
            		new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
            		new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
					.IsGlowing().ChangeModel("kuuga_pegasus.geo.json").AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("kuuga").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> KUUGA_TITAN_CARD = ITEMS.register("kuuga_titan_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_titan","decade","decadriver_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false))
					.IsGlowing().ChangeModel("kuuga_titan.geo.json").AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("kuuga").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> KUUGA_RISING_MIGHTY_CARD = ITEMS.register("kuuga_rising_mighty_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_rising_mighty","decade","decadriver_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
            		new MobEffectInstance(Effect_core.PUNCH, 40, 3,true,false))
					.IsGlowing().ChangeModel("kuuga_rising_mighty.geo.json").AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("kuuga").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> KUUGA_RISING_DRAGON_CARD = ITEMS.register("kuuga_rising_dragon_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_rising_dragon","decade","decadriver_belt",
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false))
					.IsGlowing().ChangeModel("kuuga_rising_dragon.geo.json").AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("kuuga").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> KUUGA_RISING_PEGASUS_CARD = ITEMS.register("kuuga_rising_pegasus_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_rising_pegasus","decade","decadriver_belt",
            		new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
            		new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false))
					.IsGlowing().ChangeModel("kuuga_rising_pegasus.geo.json").AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("kuuga").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> KUUGA_RISING_TITAN_CARD = ITEMS.register("kuuga_rising_titan_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_rising_titan","decade","decadriver_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false))
					.IsGlowing().ChangeModel("kuuga_rising_titan.geo.json").AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("kuuga").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> KUUGA_AMAZING_MIGHTY_CARD = ITEMS.register("kuuga_amazing_mighty_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_amazing_mighty","decade","decadriver_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
            		new MobEffectInstance(Effect_core.PUNCH, 40, 4,true,false))
					.IsGlowing().ChangeModel("kuuga_amazing_mighty.geo.json").AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("kuuga").AddToList(RiderTabs.DECADE_TAB_ITEM));

  
    public static final DeferredItem<Item> AGITO_STORM_CARD = ITEMS.register("agito_storm_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_storm","decade","decadriver_belt",
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("agito").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> AGITO_FLAME_CARD = ITEMS.register("agito_flame_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_flame","decade","decadriver_belt",
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("agito").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> AGITO_TRINITY_CARD = ITEMS.register("agito_trinity_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_trinity","decade","decadriver_belt",
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("agito").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> AGITO_BURNING_CARD = ITEMS.register("agito_burning_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_burning","decade","decadriver_belt",
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("agito").AddToList(RiderTabs.DECADE_TAB_ITEM));


    public static final DeferredItem<Item> RYUKI_BLANK_CARD = ITEMS.register("ryuki_blank_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_blank","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.WEAKNESS, 40, 0,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("ryuki").AddToList(RiderTabs.DECADE_TAB_ITEM));


    public static final DeferredItem<Item> FAIZ_AXEL_CARD = ITEMS.register("faiz_axel_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_axel","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 5,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false))
					.IsGlowing().AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("faiz").AddToList(RiderTabs.DECADE_TAB_ITEM));


    public static final DeferredItem<Item> BLADE_JACK_CARD = ITEMS.register("blade_jack_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_jack","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("blade").hasFlyingWings("rider_plusbelt_and_wings.geo.json").AddToList(RiderTabs.DECADE_TAB_ITEM));


    public static final DeferredItem<Item> HIBIKI_KURENAI_CARD = ITEMS.register("hibiki_kurenai_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_kurenai","decade","decadriver_belt",
                	new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
                	new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
                	new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
                	new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("hibiki").AddToList(RiderTabs.DECADE_TAB_ITEM));


    public static final DeferredItem<Item> KABUTO_MASKED_CARD = ITEMS.register("kabuto_masked_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_masked","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("kabuto").AddToList(RiderTabs.DECADE_TAB_ITEM));


    public static final DeferredItem<Item> DEN_O_PLAT_CARD = ITEMS.register("den_o_plat_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_plat","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.WEAKNESS, 40, 0,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("den_o").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> DEN_O_ROD_CARD = ITEMS.register("den_o_rod_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_rod","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("den_o").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> DEN_O_AX_CARD = ITEMS.register("den_o_ax_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_axe","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("den_o").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> DEN_O_GUN_CARD = ITEMS.register("den_o_gun_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_gun","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("den_o").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> DEN_O_WING_CARD = ITEMS.register("den_o_wing_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_wing","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.WEAKNESS, 40, 0,true,false),
					new MobEffectInstance(Effect_core.FLYING, 40, 1,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("den_o").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> DEN_O_CLIMAX_CARD = ITEMS.register("den_o_climax_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_climax","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("den_o").AddToList(RiderTabs.DECADE_TAB_ITEM));


    public static final DeferredItem<Item> KIVA_GARULU_CARD = ITEMS.register("kiva_garulu_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_garulu","decade","decadriver_belt",
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("kiva").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> KIVA_BASSHAA_CARD = ITEMS.register("kiva_basshaa_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_basshaa","decade","decadriver_belt",
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("kiva").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> KIVA_DOGGA_CARD = ITEMS.register("kiva_dogga_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_dogga","decade","decadriver_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("kiva").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> KIVA_DOGABAKI_CARD = ITEMS.register("kiva_dogabaki_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_dogabaki","decade","decadriver_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.WITHER, 40, 0,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("kiva").AddToList(RiderTabs.DECADE_TAB_ITEM));


    public static final DeferredItem<Item> ICHIGO_CARD = ITEMS.register("ichigo_card",
            () -> new RiderCardItem(new Item.Properties(),0,"","decade","decadriver_belt",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
						new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
						new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
            .setSummonBelt((RiderDriverItem)Ichigo_Rider_Items.TYPHOON_ICHIGO.get()).AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("ichigo").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> NIGO_CARD = ITEMS.register("nigo_card",
            () -> new RiderCardItem(new Item.Properties(),0,"","decade","decadriver_belt",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
						new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
						new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
            .setSummonBelt((RiderDriverItem)Ichigo_Rider_Items.TYPHOON_NIGO.get()).AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("nigo").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> V3_CARD = ITEMS.register("v3_card",
            () -> new RiderCardItem(new Item.Properties(),0,"","decade","decadriver_belt",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
						new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
	            		new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
						new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false))
    		.setSummonBelt((RiderDriverItem)Ichigo_Rider_Items.DOUBLE_TYPHOON.get()).AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("v3").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> RIDERMAN_CARD = ITEMS.register("riderman_card",
            () -> new RiderCardItem(new Item.Properties(),0,"","decade","decadriver_belt",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
						new MobEffectInstance(MobEffects.REGENERATION,200, 0,true,false),
	            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false))
            .setSummonBelt((RiderDriverItem)Ichigo_Rider_Items.RIDERMAN_BELT.get()).AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("riderman").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> X_CARD = ITEMS.register("x_card",
            () -> new RiderCardItem(new Item.Properties(),0,"","decade","decadriver_belt",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
						new MobEffectInstance(MobEffects.REGENERATION,200, 0,true,false),
	            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
						new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
            .setSummonBelt((RiderDriverItem)Ichigo_Rider_Items.RIDOL.get()).addSummonWeapon(Ichigo_Rider_Items.RIDOL_STICK.get()).AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("x").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> AMAZON_CARD = ITEMS.register("amazon_card",
            () -> new RiderCardItem(new Item.Properties(),0,"","decade","decadriver_belt",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
						new MobEffectInstance(MobEffects.REGENERATION,200, 1,true,false),
	            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
						new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
            .setSummonBelt((RiderDriverItem)Ichigo_Rider_Items.CONDORER.get()).AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("amazon").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> STRONGER_CARD = ITEMS.register("stronger_card",
            () -> new RiderCardItem(new Item.Properties(),0,"","decade","decadriver_belt",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
						new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 1,true,false),
	            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
						new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
            .setSummonBelt((RiderDriverItem)Ichigo_Rider_Items.ELECTRER.get()).AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("stronger").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> SKYRIDER_CARD = ITEMS.register("skyrider_card",
            () -> new RiderCardItem(new Item.Properties(),0,"","decade","decadriver_belt",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
						new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
	            		new MobEffectInstance(MobEffects.JUMP, 40, 5,true,false),
						new MobEffectInstance(Effect_core.FLYING, 40, 4,true,false))
            .setSummonBelt((RiderDriverItem)Ichigo_Rider_Items.TORNADO.get()).AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("skyrider").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> SUPER_1_CARD = ITEMS.register("super_1_card",
            () -> new RiderCardItem(new Item.Properties(),0,"","decade","decadriver_belt",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
						new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 1,true,false),
	            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
						new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
            .setSummonBelt((RiderDriverItem)Ichigo_Rider_Items.CYCLODE.get()).AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("super_1").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> ZX_CARD = ITEMS.register("zx_card",
            () -> new RiderCardItem(new Item.Properties(),0,"","decade","decadriver_belt",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
						new MobEffectInstance(MobEffects.REGENERATION,200, 0,true,false),
	            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
						new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
            .setSummonBelt((RiderDriverItem)Ichigo_Rider_Items.ZX_BELT.get()).AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("zx").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> BLACK_CARD = ITEMS.register("black_card",
            () -> new RiderCardItem(new Item.Properties(),0,"","decade","decadriver_belt",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
						new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false),
	            		new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
						new MobEffectInstance(Effect_core.PUNCH, 40, 1,true,false))
            .setSummonBelt((RiderDriverItem)Ichigo_Rider_Items.VITAL_CHARGER.get()).AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("black").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> BLACK_RX_CARD = ITEMS.register("black_rx_card",
            () -> new RiderCardItem(new Item.Properties(),0,"","decade","decadriver_belt",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
						new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false),
	            		new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
						new MobEffectInstance(Effect_core.PUNCH, 40, 1,true,false))
            .setSummonBelt((RiderDriverItem)Ichigo_Rider_Items.SUN_RISER.get()).AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("black_rx").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> SHIN_CARD = ITEMS.register("shin_card",
            () -> new RiderCardItem(new Item.Properties(),0,"","decade","decadriver_belt",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
						new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false),
	            		new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
						new MobEffectInstance(Effect_core.PUNCH, 40, 1,true,false))
            .setSummonBelt((RiderDriverItem)Ichigo_Rider_Items.GRASSHOPPER_DNA.get()).AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("shin").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> ZO_CARD = ITEMS.register("zo_card",
            () -> new RiderCardItem(new Item.Properties(),0,"","decade","decadriver_belt",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
						new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false),
	            		new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
						new MobEffectInstance(Effect_core.PUNCH, 40, 1,true,false))
            .setSummonBelt((RiderDriverItem)Ichigo_Rider_Items.ZO_CORE.get()).AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("zo").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> J_CARD = ITEMS.register("j_card",
            () -> new RiderCardItem(new Item.Properties(),0,"","decade","decadriver_belt",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
						new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false),
	            		new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
						new MobEffectInstance(Effect_core.PUNCH, 40, 1,true,false))
            .setSummonBelt((RiderDriverItem)Ichigo_Rider_Items.J_SPIRIT.get()).setSummonForm((RiderFormChangeItem)Ichigo_Rider_Items.J_STONE_JUMBO_FORMATION.get()).AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("j").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> BLACK_RX_ROBORIDER_CARD = ITEMS.register("black_rx_roborider_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_robo","decade","decadriver_belt",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
						new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false),
	            		new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
						new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("black_rx").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> BLACK_RX_BIORIDER_CARD = ITEMS.register("black_rx_biorider_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_bio","decade","decadriver_belt",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
						new MobEffectInstance(MobEffects.WATER_BREATHING,40, 0,true,false),
	            		new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 40, 1,true,false),
						new MobEffectInstance(Effect_core.PUNCH, 40, 1,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("black_rx").AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> KUUGA_ULTIMATE_CARD = ITEMS.register("kuuga_ultimate_card",
			() -> new FinalKamenRideCardItem(new Item.Properties()).setSummonBelt((RiderDriverItem)Kuuga_Rider_Items.ARCLE.get()).setSummonForm((RiderFormChangeItem)Kuuga_Rider_Items.KUUGA_ULTIMATE.get()).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> AGITO_SHINING_CARD = ITEMS.register("agito_shining_card",
			() -> new FinalKamenRideCardItem(new Item.Properties()).setSummonBelt((RiderDriverItem)Agito_Rider_Items.ALTERING.get()).setSummonForm((RiderFormChangeItem)Agito_Rider_Items.AGITO_SHINING.get()).addSummonWeapon(Agito_Rider_Items.SHINING_CALIBER_TWIN.get()).addSummonWeapon(Agito_Rider_Items.SHINING_CALIBER_TWIN.get()).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> RYUKI_SURVIVE_CARD = ITEMS.register("ryuki_survive_card",
			() -> new FinalKamenRideCardItem(new Item.Properties()).setSummonBelt((RiderDriverItem)Ryuki_Rider_Items.RYUKIDRIVER.get()).setSummonForm((RiderFormChangeItem)Ryuki_Rider_Items.SURVIVE_REKKA.get()).addSummonWeapon(Ryuki_Rider_Items.DRAG_BLADE.get()).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> FAIZ_BLASTER_CARD = ITEMS.register("faiz_blaster_card",
			() -> new FinalKamenRideCardItem(new Item.Properties()).setSummonBelt((RiderDriverItem)Faiz_Rider_Items.FAIZ_DRIVER.get()).setSummonForm((RiderFormChangeItem)Faiz_Rider_Items.FAIZ_BLASTER_MISSION_MEMORY.get()).addSummonWeapon(Faiz_Rider_Items.FAIZ_BLASTER.get()).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> BLADE_KING_CARD = ITEMS.register("blade_king_card",
			() -> new FinalKamenRideCardItem(new Item.Properties()).setSummonBelt((RiderDriverItem)Blade_Rider_Items.BLAYBUCKLE.get()).setSummonForm((RiderFormChangeItem)Blade_Rider_Items.EVOLUTION_CAUCASUS.get()).addSummonWeapon(Blade_Rider_Items.KINGROUZER.get()).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> ARMED_HIBIKI_CARD = ITEMS.register("armed_hibiki_card",
			() -> new FinalKamenRideCardItem(new Item.Properties()).setSummonBelt((RiderDriverItem)Hibiki_Rider_Items.HIBIKIDRIVER.get()).setSummonForm((RiderFormChangeItem)Hibiki_Rider_Items.HENSHIN_ONSA_ARMED.get()).addSummonWeapon(Hibiki_Rider_Items.ARMED_SABER.get()).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> KABUTO_HYPER_CARD = ITEMS.register("kabuto_hyper_card",
			() -> new FinalKamenRideCardItem(new Item.Properties()).setSummonBelt((RiderDriverItem)Kabuto_Rider_Items.KABUTO_RIDER_BELT.get()).setSummonForm((RiderFormChangeItem)Kabuto_Rider_Items.HYPER_ZECTER.get()).addSummonWeapon(Kabuto_Rider_Items.PERFECT_ZECTER.get()).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> DEN_O_LINER_CARD = ITEMS.register("den_o_liner_card",
			() -> new FinalKamenRideCardItem(new Item.Properties()).setSummonBelt((RiderDriverItem)Den_O_Rider_Items.DEN_O_BELT.get()).setSummonForm((RiderFormChangeItem)Den_O_Rider_Items.DEN_O_LINER_FORM.get()).addSummonWeapon(Den_O_Rider_Items.DENKAMEN_SWORD.get()).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> KIVA_EMPEROR_CARD = ITEMS.register("kiva_emperor_card",
			() -> new FinalKamenRideCardItem(new Item.Properties()).setSummonBelt((RiderDriverItem)Kiva_Rider_Items.KIVAT_BELT.get()).setSummonForm((RiderFormChangeItem)Kiva_Rider_Items.TATSULOT.get()).addSummonWeapon(Kiva_Rider_Items.ZANVAT_SWORD.get()).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> W_XTREME_CARD = ITEMS.register("w_xtreme_card",
			() -> new FinalKamenRideCardItem(new Item.Properties()).setSummonBelt(0).setSummonForm(0, 1).addSummonWeapon(0).addSummonWeapon(1).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> OOO_PUTOTYRA_CARD = ITEMS.register("ooo_putotyra_card",
			() -> new FinalKamenRideCardItem(new Item.Properties()).setSummonBelt(3).setSummonForm(1, 1).addSummonWeapon(2).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> FOURZE_COSMIC_CARD = ITEMS.register("fourze_cosmic_card",
			() -> new FinalKamenRideCardItem(new Item.Properties()).setSummonBelt(5).setSummonForm(2, 1).addSummonWeapon(3).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> WIZARD_INFINITY_CARD = ITEMS.register("wizard_infinity_card",
			() -> new FinalKamenRideCardItem(new Item.Properties()).setSummonBelt(7).setSummonForm(3, 1).addSummonWeapon(4).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> GAIM_KIWAMI_CARD = ITEMS.register("gaim_kiwami_card",
			() -> new FinalKamenRideCardItem(new Item.Properties()).setSummonBelt(9).setSummonForm(4, 1).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> DRIVE_TRIDORON_CARD = ITEMS.register("drive_tridoron_card",
			() -> new FinalKamenRideCardItem(new Item.Properties()).setSummonBelt(11).setSummonForm(5, 1).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> GHOST_MUGEN_CARD = ITEMS.register("ghost_mugen_card",
			() -> new FinalKamenRideCardItem(new Item.Properties()).setSummonBelt(13).setSummonForm(6, 2).addSummonWeapon(16).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> EX_AID_MUTEKI_CARD = ITEMS.register("ex_aid_muteki_card",
			() -> new FinalKamenRideCardItem(new Item.Properties()).setSummonBelt(15).setSummonForm(7, 1).addSummonWeapon(17).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> BUILD_GENIUS_CARD = ITEMS.register("build_genius_card",
			() -> new FinalKamenRideCardItem(new Item.Properties()).setSummonBelt(17).setSummonForm(8, 3).addSummonWeapon(18).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> GRAND_ZI_O_CARD = ITEMS.register("grand_zi_o_card",
			() -> new FinalKamenRideCardItem(new Item.Properties()).setSummonBelt(19).setSummonForm(9, 1).addSummonWeapon(19).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> ZERO_TWO_CARD = ITEMS.register("zero_two_card",
			() -> new FinalKamenRideCardItem(new Item.Properties()).setSummonBelt(21).addSummonWeapon(20).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> XROSS_SABER_CARD = ITEMS.register("xross_saber_card",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> ULTIMATE_REVI_CARD = ITEMS.register("ultimate_revi_card",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> ULTIMATE_VICE_CARD = ITEMS.register("ultimate_vice_card",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> GEATS_IX_CARD = ITEMS.register("geats_ix_card",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.DECADE_TAB_ITEM));
	/*
	public static final DeferredItem<Item> RAINBOW_GOTCHARD_CARD = ITEMS.register("rainbow_gotchard_card",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.DECADE_TAB_ITEM));
	*/
	public static final DeferredItem<Item> G4_CARD = ITEMS.register("g4_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem)Agito_Rider_Items.G_BUCKLE_G4.get()).addSummonWeapon(Agito_Rider_Items.G4_GIGANT.get()).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> RYUGA_CARD = ITEMS.register("ryuga_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem)Ryuki_Rider_Items.RYUGADRIVER.get()).addSummonWeapon(Ryuki_Rider_Items.DRAG_CLAW_RYUGA.get()).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> ORGA_CARD = ITEMS.register("orga_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem)Faiz_Rider_Items.ORGA_DRIVER.get()).addSummonWeapon(Faiz_Rider_Items.ORGA_STLANZER.get()).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> GLAIVE_CARD = ITEMS.register("glaive_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem)Blade_Rider_Items.GLAIVEBUCKLE.get()).addSummonWeapon(Blade_Rider_Items.GLAIVEROUZER.get()).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> KABUKI_CARD = ITEMS.register("kabuki_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem)Hibiki_Rider_Items.KABUKIDRIVER.get()).addSummonWeapon(Hibiki_Rider_Items.ECHO_SWORD_ONSAKEN.get()).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> CAUCASUS_CARD = ITEMS.register("caucasus_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem)Kabuto_Rider_Items.CAUCASUS_RIDER_BELT.get()).addSummonWeapon(Rider_Blocks.BLUE_ROSE.asItem()).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> ARC_CARD = ITEMS.register("arc_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem)Kiva_Rider_Items.ARC_KIVAT_BELT.get()).addSummonWeapon(Kiva_Rider_Items.ARC_TRIDENT.get()).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> SKULL_CARD = ITEMS.register("skull_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt(2).addSummonWeapon(0).AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> COMPLETE_CARD_DECADE_21 = ITEMS.register("complete_card_decade_21",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.DECADE_TAB_ITEM));
	/*
	public static final DeferredItem<Item> RIDE_PLAYER_CARD = ITEMS.register("rideplayer_card",
			() -> new ZeinCardItem(new Item.Properties()).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> DIMENSION_CARD = ITEMS.register("dimension_card",
			() -> new ZeinCardItem(new Item.Properties()).AddToList(RiderTabs.DECADE_TAB_ITEM));
	*/
	public static final DeferredItem<Item> KUUGA_BALL = ITEMS.register("kuuga_ball",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_ball","kuuga","blank",
					new MobEffectInstance(Effect_core.PUNCH, 40, 2,true,false))
					.IsGlowing().ChangeModel("kuuga_ball.geo.json","kuuga_ball.animation.json").SetPalyerModelInvisible().has_basic_model().AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DECADEHELMET = ITEMS.register("decadehead",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.DECADE_TAB_ITEM).ChangeRepairItem(BLANK_CARD.get()));
	public static final DeferredItem<Item> DECADECHESTPLATE = ITEMS.register("decadetroso",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.DECADE_TAB_ITEM).ChangeRepairItem(BLANK_CARD.get()));
	public static final DeferredItem<Item> DECADELEGGINGS = ITEMS.register("decadelegs",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.DECADE_TAB_ITEM).ChangeRepairItem(BLANK_CARD.get()));

	public static final DeferredItem<Item> DECADRIVER = ITEMS.register("decadriver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"decade",DECADE_CARD ,DECADEHELMET, DECADECHESTPLATE,DECADELEGGINGS , new Item.Properties())
			.AddToTabList(RiderTabs.DECADE_TAB_ITEM).ChangeRepairItem(BLANK_CARD.get()));

	public static final DeferredItem<Item> NEO_DECADRIVER = ITEMS.register("neo_decadriver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"neo_decade",DECADE_CARD ,DECADEHELMET, DECADECHESTPLATE,DECADELEGGINGS , new Item.Properties())
					.Override_belt_text("neo_decadriver_belt").AddToTabList(RiderTabs.DECADE_TAB_ITEM).ChangeRepairItem(BLANK_CARD.get()));

	public static final DeferredItem<Item> DIEND_BELT= ITEMS.register("diend_belt",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"diend",DIEND_CARD ,DECADEHELMET, DECADECHESTPLATE,DECADELEGGINGS , new Item.Properties())
			.AddToTabList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DARK_DECADRIVER = ITEMS.register("dark_decadriver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"dark_decade",DARK_DECADE_CARD ,DECADEHELMET, DECADECHESTPLATE,DECADELEGGINGS , new Item.Properties())
			.Override_belt_text("dark_decadriver_belt").AddToTabList(RiderTabs.DECADE_TAB_ITEM).ChangeRepairItem(BLANK_CARD.get()));

	public static final DeferredItem<Item> RIDE_BOOKER = ITEMS.register("ride_booker",
			() -> new RideBookerItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).IsSwordGun().AddToTabList(RiderTabs.DECADE_TAB_ITEM)
			.ChangeRepairItem(BLANK_CARD.get()));

	public static final DeferredItem<Item> DIENDRIVER = ITEMS.register("diendriver",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).IsHenshinItem(DIEND_BELT.get()).AddToTabList(RiderTabs.DECADE_TAB_ITEM).ChangeRepairItem(BLANK_CARD.get()));

	public static final DeferredItem<Item> NEO_DIENDRIVER = ITEMS.register("neo_diendriver",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).IsHenshinItem(DIEND_BELT.get()).AddToTabList(RiderTabs.DECADE_TAB_ITEM).ChangeRepairItem(BLANK_CARD.get()));

	public static final DeferredItem<Item> ONGEKIBO_REKKA_DECADE = ITEMS.register("ongekibo_rekka_decade",
            () -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.DECADE_TAB_ITEM).ChangeRepairItem(BLANK_CARD.get()));

	public static final DeferredItem<Item> ONGEKIBO_REKKA_DIEND = ITEMS.register("ongekibo_rekka_diend",
            () -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.DECADE_TAB_ITEM).ChangeRepairItem(BLANK_CARD.get()));

    public static final DeferredItem<Item> ONGEKIKANABO_OUJA = ITEMS.register("ongekikanabo_ouja",
            () -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.DECADE_TAB_ITEM).ChangeRepairItem(Ryuki_Rider_Items.ADVENT_CARD.get()));

	public static final DeferredItem<Item> DECADE_BAZOOKA = ITEMS.register("decade_bazooka",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.DECADE_TAB_ITEM).ChangeRepairItem(BLANK_CARD.get()));

    public static final DeferredItem<Item> DECADE_BLAST_CARD = ITEMS.register("decade_blast_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"decade","decade_complete","decade_violent_emotion","decade_cyan","dark_decade","neo_decade_complete_21"})
			.addEffects(new MobEffectInstance(Effect_core.SHOT_BOOST, 300,2,true,false)).AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item>DECADE_SLASH_CARD = ITEMS.register("decade_slash_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"decade","decade_complete","decade_violent_emotion","decade_cyan","dark_decade","neo_decade_complete_21"})
			.addEffects(new MobEffectInstance(Effect_core.SLASH, 300,2,true,false)).AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DECADE_ILLUSION_CARD = ITEMS.register("decade_illusion_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"decade","decade_complete","decade_violent_emotion","decade_cyan","dark_decade","neo_decade_complete_21"})
			.addSpecial("illusion").AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DECADE_INVISIBLE_CARD = ITEMS.register("decade_invisible_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"decade","decade_complete","decade_violent_emotion","decade_cyan","dark_decade","neo_decade_complete_21"})
			.addEffects(new MobEffectInstance(MobEffects.INVISIBILITY, 200,0,true,false)).AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DIEND_BLAST_CARD = ITEMS.register("diend_blast_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"diend","diend_green"})
			.addEffects(new MobEffectInstance(Effect_core.SHOT_BOOST, 300,2,true,false)).AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DIEND_INVISIBLE_CARD = ITEMS.register("diend_invisible_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"diend","diend_green"})
			.addEffects(new MobEffectInstance(MobEffects.INVISIBILITY, 200,0,true,false)).AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DIEND_CROSSATTACK_CARD = ITEMS.register("diend_crossattack_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"diend","diend_green"})
			.addSpecial("crossattack").AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DIEND_BARRIER_CARD = ITEMS.register("diend_barrier_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"diend","diend_green"})
			.addSpecial("barrier").AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DIEND_ILLUSION_CARD = ITEMS.register("diend_illusion_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"diend","diend_green"})
			.addSpecial("diend_illusion").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> REKKA_DAIZANTOU_CARD = ITEMS.register("rekka_daizantou_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"decade","decade_complete","decade_violent_emotion","decade_cyan","neo_decade_complete_21"})
			.addSpecial("rekka_daizantou").AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> G4_GIGANT_CARD = ITEMS.register("g4_gigant_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"decade_violent_emotion"})
			.addItem(Agito_Rider_Items.G4_GIGANT.get()).AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> RYUKI_STRIKE_VENT_CARD = ITEMS.register("ryuki_strike_vent_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"ryuki","decade_violent_emotion"})
			.addItem(Ryuki_Rider_Items.DRAG_CLAW.get()).AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> BLADE_METAL_CARD = ITEMS.register("blade_metal_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"blade","decade_violent_emotion"})
			.addEffects(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 300,1,true,false)).AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> BLADE_MACH_CARD = ITEMS.register("blade_mach_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"blade","decade_violent_emotion"})
			.addEffects(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300,3,true,false),
						new MobEffectInstance(MobEffects.DIG_SPEED, 300,3,true,false)).AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> HIBIKI_ONGEKIBOU_REKKA_CARD = ITEMS.register("hibiki_ongekibou_rekka_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"hibiki","decade_violent_emotion"})
			.addItem(Hibiki_Rider_Items.ONGEKIBO_REKKA.get()).AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> HIBIKI_ONIBI_CARD = ITEMS.register("hibiki_onibi_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"hibiki","decade_violent_emotion"})
			.addSpecial("onibi").AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> KABUTO_CLOCK_UP_CARD = ITEMS.register("kabuto_clock_up_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"kabuto","decade_violent_emotion"})
			.addEffects(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 250,20,true,false)).AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DEN_O_ORE_SANJOU_CARD = ITEMS.register("den_o_ore_sanjou_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"den_o","den_o_rod","den_o_axe","den_o_gun","den_o_wing","den_o_climax","decade_violent_emotion"})
			.addSpecial("ore_sanjou").AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DEN_O_BOKU_NI_TSURARETE_MIRU_CARD = ITEMS.register("den_o_bokuni_tsurarete_miru_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"den_o","den_o_rod","den_o_axe","den_o_gun","den_o_wing","den_o_climax","decade_violent_emotion"})
			.addSpecial("bokuni_tsurarete_miru").AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DEN_O_NAKERUDE_CARD = ITEMS.register("den_o_nakerude_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"den_o","den_o_rod","den_o_axe","den_o_gun","den_o_wing","den_o_climax","decade_violent_emotion"})
			.addSpecial("nakerude").AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DEN_O_KOTAE_WA_KIITENAI_CARD = ITEMS.register("den_o_kotaewa_kiite_nai_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"den_o","den_o_rod","den_o_axe","den_o_gun","den_o_wing","den_o_climax","decade_violent_emotion"})
			.addSpecial("kotaewa_kiite_nai").AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DEN_O_TSUPPARI_CARD = ITEMS.register("den_o_tsuppari_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"den_o_axe","decade_violent_emotion"})
			.addEffects(new MobEffectInstance(Effect_core.PUNCH, 300,1,true,false)).AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DEN_O_UTCHARI_CARD = ITEMS.register("den_o_utchari_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"den_o_axe","decade_violent_emotion"})
			.addEffects(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300,2,true,false),
						new MobEffectInstance(MobEffects.JUMP, 300,3,true,false)).AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> AMAZON_GAGA_NO_UDEWA_CARD = ITEMS.register("amazon_gaga_no_udewa_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"amazon","decade_complete","decade_violent_emotion","neo_decade_complete_21"})
			.addItem(Ichigo_Rider_Items.GAGA_ARMLET.get()).AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}

}
