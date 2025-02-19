package com.kelco.kamenridercraft.item;

import java.util.ArrayList;
import java.util.List;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.item.BaseItems.*;
import com.kelco.kamenridercraft.item.geats.MissionBoxItem;
import com.kelco.kamenridercraft.item.gotchard.GotchancollectionPanelItem;
import com.kelco.kamenridercraft.item.gotchard.GotchandrawHolderItem;
import com.kelco.kamenridercraft.item.gotchard.ValvaradItem;
import com.kelco.kamenridercraft.item.misc.GiftItem;
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

public class Gotchard_Rider_Items {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);

	public static List<Item> NEED_ITEM_SteamHopper= new ArrayList<Item>();
	public static List<Item> NEED_ITEM_AppareSkebow= new ArrayList<Item>();
	public static List<Item> NEED_ITEM_VenomMariner= new ArrayList<Item>();
	public static List<Item> NEED_ITEM_AntWrestler= new ArrayList<Item>();
	public static List<Item> NEED_ITEM_BurningGorilla= new ArrayList<Item>();
	public static List<Item> NEED_ITEM_NeedleHawk= new ArrayList<Item>();
	public static List<Item> NEED_ITEM_DokkiriShovel= new ArrayList<Item>();
	public static List<Item> NEED_ITEM_GoldMechanichor= new ArrayList<Item>();
	public static List<Item> NEED_ITEM_HiikesuRose= new ArrayList<Item>();
	public static List<Item> NEED_ITEM_LightningJungle= new ArrayList<Item>();
	public static List<Item> NEED_ITEM_MarsPhoenix= new ArrayList<Item>();
	public static List<Item> NEED_ITEM_MarsPhoenix2= new ArrayList<Item>();

	public static List<Item> NEED_ITEM_Valvarad= new ArrayList<Item>();

	public static List<Item> NEED_ITEM_SteamHopper_daybreak= new ArrayList<Item>();

	public static List<Item> NEED_ITEM_ExceedMighty= new ArrayList<Item>();
	public static List<Item> NEED_ITEM_CycloneTaToBa= new ArrayList<Item>();
	public static List<Item> NEED_ITEM_FullFullRocket= new ArrayList<Item>();

	public static final DeferredItem<Item> GOTCHARD_LOGO = ITEMS.register("gotchard_logo",
    		() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> BLANK_RIDE_CHEMY_CARD = ITEMS.register("blank_ride_chemy_card",
    		() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	   
    public static final DeferredItem<Item> HOPPER1_RIDE_CHEMY_CARD = ITEMS.register("hopper1_ride_chemy_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","gotchard","gotchardriver_belt",
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)).AddNeedItemList(NEED_ITEM_SteamHopper)
            .AddToList(NEED_ITEM_SteamHopper).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));
    /* pikahotaru
     * gengenchoucho
     * bakuonzemi
     */
    
    public static final DeferredItem<Item> ANTROOPER_RIDE_CHEMY_CARD = ITEMS.register("antrooper_ride_chemy_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_ant_wrestler","gotchard","gotchardriver_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
            		new MobEffectInstance(Effect_core.PUNCH, 40, 2,true,false))
            .AddNeedItemList(NEED_ITEM_AntWrestler).AddToList(NEED_ITEM_AntWrestler).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));
    
    /* greatonbo
     * stagvine
     * kaiserbee
     * kamantis
     */

	public static final DeferredItem<Item> BEETLX_RIDE_CHEMY_CARD = ITEMS.register("beetlx_ride_chemy_card",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

     /* odorippa
     */
    
    public static final DeferredItem<Item> DOKKIRIMAJIN_RIDE_CHEMY_CARD = ITEMS.register("dokkirimajin_ride_chemy_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_dokkiri_shovel","gotchard","gotchardriver_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false))
            .AddNeedItemList(NEED_ITEM_DokkiriShovel).AddToList(NEED_ITEM_DokkiriShovel).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));
    
     /* doctorkozo
     * pilets
     */
    
    public static final DeferredItem<Item> WRESTLER_G_RIDE_CHEMY_CARD = ITEMS.register("wrestler_g_ride_chemy_card",
            () -> new CopyFormChangeItem(new Item.Properties(),ANTROOPER_RIDE_CHEMY_CARD.get()).AddToList(NEED_ITEM_AntWrestler)
            .AddToList(RiderTabs.GOTCHARD_TAB_ITEM));
    
     /* sasukemaru
     * bulletbaang
     */
    
    public static final DeferredItem<Item> APPAREBUSHIDO_RIDE_CHEMY_CARD = ITEMS.register("apparebushido_ride_chemy_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_appare_skebow","gotchard","gotchardriver_belt",
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
            		new MobEffectInstance(Effect_core.SLASH, 40, 2,true,false))
            .AddNeedItemList(NEED_ITEM_AppareSkebow).AddToList(NEED_ITEM_AppareSkebow).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));
    
    /* karyudos
     */

	public static final DeferredItem<Item> X_WIZARD_RIDE_CHEMY_CARD = ITEMS.register("x_wizard_ride_chemy_card",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

     /* spicle
     */
    
    public static final DeferredItem<Item> SKEBOWS_RIDE_CHEMY_CARD = ITEMS.register("skebows_ride_chemy_card",
            () -> new CopyFormChangeItem(new Item.Properties(),APPAREBUSHIDO_RIDE_CHEMY_CARD.get()).AddToList(NEED_ITEM_AppareSkebow)
            .AddToList(RiderTabs.GOTCHARD_TAB_ITEM));
    
    public static final DeferredItem<Item> HIIKESCUE_RIDE_CHEMY_CARD = ITEMS.register("hiikescue_ride_chemy_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_hiikesu_rose","gotchard","gotchardriver_belt",
            		new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 1,true,false),
            		new MobEffectInstance(Effect_core.REFLECT, 40, 1,true,false))
            .AddNeedItemList(NEED_ITEM_HiikesuRose).AddToList(NEED_ITEM_HiikesuRose).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));
    
    public static final DeferredItem<Item> GEKIOCOPTER_RIDE_CHEMY_CARD = ITEMS.register("gekiocopter_ride_chemy_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","valvarad","",
            		new MobEffectInstance(Effect_core.FLYING, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false))
            .ChangeSlot(2).addSwitchForm(Modded_item_core.BLANK_FORM.get()).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));
    
    public static final DeferredItem<Item> DEEPMARINER_RIDE_CHEMY_CARD = ITEMS.register("deepmariner_ride_chemy_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_venom_mariner","gotchard","gotchardriver_belt",
            		new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 1,true,false),
            		new MobEffectInstance(Effect_core.ANTIPOISON, 40, 1,true,false))
            .AddNeedItemList(NEED_ITEM_VenomMariner).AddToList(NEED_ITEM_VenomMariner).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));
    
    public static final DeferredItem<Item> MADWHEEL_RIDE_CHEMY_CARD = ITEMS.register("madwheel_ride_chemy_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","valvarad","valvaradraw_buckle_belt",
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> MACHWHEEL_RIDE_CHEMY_CARD = ITEMS.register("machwheel_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","valvarad_rider","valvaradriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.AddNeedItemList(NEED_ITEM_Valvarad).AddToList(NEED_ITEM_Valvarad).AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());
    
    public static final DeferredItem<Item> GOLDDASH_RIDE_CHEMY_CARD = ITEMS.register("golddash_ride_chemy_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_gold_mechanichor","gotchard","gotchardriver_belt_big",
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false))
            .ChangeBeltModel("geo/lv_1_belt.geo.json")
            .AddNeedItemList(NEED_ITEM_GoldMechanichor).AddToList(NEED_ITEM_GoldMechanichor).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));
    
    public static final DeferredItem<Item> GUTSSHOVEL_RIDE_CHEMY_CARD = ITEMS.register("gutsshovel_ride_chemy_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","valvarad","",
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
            		new MobEffectInstance(Effect_core.PUNCH, 40, 3,true,false))
            .ChangeSlot(3).addAlternative(DOKKIRIMAJIN_RIDE_CHEMY_CARD.get()).addSwitchForm(Modded_item_core.BLANK_FORM.get()).AddToList(NEED_ITEM_DokkiriShovel).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

    public static final DeferredItem<Item> STEAMLINER_RIDE_CHEMY_CARD = ITEMS.register("steamliner_ride_chemy_card",
            () -> new CopyFormChangeItem(new Item.Properties(),HOPPER1_RIDE_CHEMY_CARD.get()).AddToList(NEED_ITEM_SteamHopper)
            .AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> EXCEEDFIGHTER_RIDE_CHEMY_CARD = ITEMS.register("exceedfighter_ride_chemy_card",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

     /* yamibat
     * catchula
     */
    
    public static final DeferredItem<Item> MECHANICHANI_RIDE_CHEMY_CARD = ITEMS.register("mechanichani_ride_chemy_card",
            () -> new CopyFormChangeItem(new Item.Properties(),GOLDDASH_RIDE_CHEMY_CARD.get()).AddToList(NEED_ITEM_GoldMechanichor)
            .AddToList(RiderTabs.GOTCHARD_TAB_ITEM));
    
     /* bussasorry
     * bountybunny
     */
	   
    public static final DeferredItem<Item> HAWKSTAR_RIDE_CHEMY_CARD = ITEMS.register("hawkstar_ride_chemy_card",
         () -> new RiderFormChangeItem(new Item.Properties(),0,"_needle_hawk","gotchard","gotchardriver_belt",
         		new MobEffectInstance(Effect_core.FLYING, 40, 1,true,false),
         		new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false))
         .hasFlyingWings(null).AddNeedItemList(NEED_ITEM_NeedleHawk)
         .AddToList(NEED_ITEM_NeedleHawk).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));
 
     /* tsupparihebi
     */
    
    public static final DeferredItem<Item> GORILLASENSEI_RIDE_CHEMY_CARD = ITEMS.register("gorillasensei_ride_chemy_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_burning_gorilla","gotchard","gotchardriver_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
            		new MobEffectInstance(Effect_core.PUNCH, 40, 4,true,false),
            		new MobEffectInstance(Effect_core.FIRE_PUNCH, 40, 4,true,false))
            .AddNeedItemList(NEED_ITEM_BurningGorilla).AddToList(NEED_ITEM_BurningGorilla).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));
    
    /* ganvhale
     */

	public static final DeferredItem<Item> LIXION_RIDE_CHEMY_CARD = ITEMS.register("lixion_ride_chemy_card",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));
    
   	public static final DeferredItem<Item> RAIDENJI_RIDE_CHEMY_CARD = ITEMS.register("raidenji_ride_chemy_card",
           	() -> new RiderFormChangeItem(new Item.Properties(),0,"_lightning_jungle","gotchard","gotchardriver_belt_big",
           			new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false))
			.ChangeBeltModel("geo/lv_1_belt.geo.json")
			.AddNeedItemList(NEED_ITEM_LightningJungle).AddToList(NEED_ITEM_LightningJungle).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));
    
     /* kesuzo
     * mitemirror
     * energyl
     * panpakaparka
     * televi
     * timelord
     * smaphone
     * renkingrobo
     */

	public static final DeferredItem<Item> X_FORTRESS_RIDE_CHEMY_CARD = ITEMS.register("x_fortress_ride_chemy_card",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

     /* happyclover
     */
    
    public static final DeferredItem<Item> BURNINGNERO_RIDE_CHEMY_CARD = ITEMS.register("burningnero_ride_chemy_card",
            () -> new CopyFormChangeItem(new Item.Properties(),GORILLASENSEI_RIDE_CHEMY_CARD.get()).AddToList(NEED_ITEM_BurningGorilla)
            .AddToList(RiderTabs.GOTCHARD_TAB_ITEM));
    
    /* bambamboo
     */
    
    public static final DeferredItem<Item> SABONEEDLE_RIDE_CHEMY_CARD = ITEMS.register("saboneedle_ride_chemy_card",
            () -> new CopyFormChangeItem(new Item.Properties(),HAWKSTAR_RIDE_CHEMY_CARD.get()).AddToList(NEED_ITEM_NeedleHawk)
            .AddToList(RiderTabs.GOTCHARD_TAB_ITEM));
    
    public static final DeferredItem<Item> VENOMDAKE_RIDE_CHEMY_CARD = ITEMS.register("venomdake_ride_chemy_card",
            () -> new CopyFormChangeItem(new Item.Properties(),DEEPMARINER_RIDE_CHEMY_CARD.get()).AddToList(NEED_ITEM_VenomMariner)
            .AddToList(RiderTabs.GOTCHARD_TAB_ITEM));
    
     /* utsubocchama
     */
    
    public static final DeferredItem<Item> FLAYROSE_RIDE_CHEMY_CARD = ITEMS.register("flayrose_ride_chemy_card",
            () -> new CopyFormChangeItem(new Item.Properties(),HIIKESCUE_RIDE_CHEMY_CARD.get()).AddToList(NEED_ITEM_HiikesuRose)
            .AddToList(RiderTabs.GOTCHARD_TAB_ITEM));
    
     /* buglesia
     */
    
    public static final DeferredItem<Item> JUNGLEJAN_RIDE_CHEMY_CARD = ITEMS.register("junglejan_ride_chemy_card",
            () -> new CopyFormChangeItem(new Item.Properties(),RAIDENJI_RIDE_CHEMY_CARD.get()).AddToList(NEED_ITEM_LightningJungle)
            .AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> XEGGDRASIL_RIDE_CHEMY_CARD = ITEMS.register("xeggdrasil_ride_chemy_card",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

     /* carery
     * berosol
     * sayzombie
     * angelead
     * zukyumpire
     */

	public static final DeferredItem<Item> DAIOHNI_RIDE_CHEMY_CARD = ITEMS.register("daiohni_ride_chemy_card",
			() -> new CopyFormChangeItem(new Item.Properties(),MACHWHEEL_RIDE_CHEMY_CARD.get()).AddToList(NEED_ITEM_Valvarad)
					.AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

     /* mackraken
     * jyamatanoorochi
     * ninetail
     */

	public static final DeferredItem<Item> UFO_X_RIDE_CHEMY_CARD = ITEMS.register("ufo_x_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_super_cross_ufo_x","gotchard","gotchardriver_belt_s",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
					new MobEffectInstance(Effect_core.FLYING, 40, 2, true, false),
					new MobEffectInstance(MobEffects.NIGHT_VISION,400,0,true,false)).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

     /* nanmonite
     * akumanocaris
     * pakuraptor
     * ojilacanth
     * sabeliger
     * warptera
     * gigalodon
     * tricera
     * blizzammoth
     */

	public static final DeferredItem<Item> X_REX_RIDE_CHEMY_CARD = ITEMS.register("x_rex_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_super_cross_x_rex","gotchard","gotchardriver_belt_s",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

     /* mercurin
     * kinkiravina
     * gokigenmeteon
     * neminemoon
	 */

	public static final DeferredItem<Item> FIREMARS_RIDE_CHEMY_CARD = ITEMS.register("firemars_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_mars_phoenix","gotchard","gotchardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
					new MobEffectInstance(Effect_core.FIRE_PUNCH, 40, 1,true,false)).AddNeedItemList(NEED_ITEM_MarsPhoenix)
					.AddToList(NEED_ITEM_MarsPhoenix).AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

     /* grandsaturn
     */

	 public static final DeferredItem<Item> THE_SUN_RIDE_CHEMY_CARD = ITEMS.register("the_sun_ride_chemy_card",
			 () -> new RiderFormChangeItem(new Item.Properties(),0,"","majade","alchemisdriver_belt",
					 new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					 new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					 new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false)).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

     /* jupitta
     * kuroana
     * gaiard
     * 
     * gigabaham
     * macentaurus
     */

	public static final DeferredItem<Item> UNICON_RIDE_CHEMY_CARD = ITEMS.register("unicon_ride_chemy_card",
			() -> new CopyFormChangeItem(new Item.Properties(),THE_SUN_RIDE_CHEMY_CARD.get()).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	/* vanfenrir
     */

	public static final DeferredItem<Item> INPHOENIX_RIDE_CHEMY_CARD = ITEMS.register("inphoenix_ride_chemy_card",
			() -> new CopyFormChangeItem(new Item.Properties(),FIREMARS_RIDE_CHEMY_CARD.get()).AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

    /* yoacerberus
     * haodin
     * gingriffon
     * donposeidon
     * dragonalos
     */

	public static final DeferredItem<Item> X_ASSEMBLE_RIDE_CHEMY_CARD = ITEMS.register("x_assemble_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_star","gotchard","gotchardriver_belt_s",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false),
					new MobEffectInstance(Effect_core.FLYING, 40, 0, true, false),
					new MobEffectInstance(Effect_core.THUNDER_PUNCH, 40, 0, true, false),
					new MobEffectInstance(MobEffects.NIGHT_VISION,400,0,true,false)).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> FIREMARS_RIDE_CHEMY_CARD_TELEVIKUN = ITEMS.register("firemars_ride_chemy_card_televikun",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_mars_phoenix","gotchard","gotchardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
					new MobEffectInstance(Effect_core.FIRE_PUNCH, 40, 1,true,false)).AddNeedItemList(NEED_ITEM_MarsPhoenix2)
					.AddToList(NEED_ITEM_MarsPhoenix2).AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> INPHOENIX_RIDE_CHEMY_CARD_TELEVIKUN = ITEMS.register("inphoenix_ride_chemy_card_televikun",
			() -> new CopyFormChangeItem(new Item.Properties(),FIREMARS_RIDE_CHEMY_CARD_TELEVIKUN.get()).AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> HOPPER1_RIDE_CHEMY_CARD_DAYBREAK = ITEMS.register("daybreak_hopper1_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","gotchard_daybreak","gotchardriver_belt_daybreak",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)).AddNeedItemList(NEED_ITEM_SteamHopper_daybreak)
					.AddToList(NEED_ITEM_SteamHopper_daybreak).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> STEAMLINER_RIDE_CHEMY_CARD_DAYBREAK = ITEMS.register("daybreak_steamliner_ride_chemy_card",
			() -> new CopyFormChangeItem(new Item.Properties(),HOPPER1_RIDE_CHEMY_CARD_DAYBREAK.get()).AddToList(NEED_ITEM_SteamHopper_daybreak).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item>  STEAMLINER_REPLI_CHEMY_CARD = ITEMS.register("steamliner_repli_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","dread","dreadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));


	public static final DeferredItem<Item> LEGEND_RIDE_CHEMY_CARD = ITEMS.register("legend_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","legend","legendriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> SANTACLAUS_RIDE_CHEMY_CARD = ITEMS.register("santaclaus_ride_chemy_card",
			() -> new BaseItem(new Item.Properties()).AddToList(GiftItem.GIFTS).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> TONAKAILINER_RIDE_CHEMY_CARD = ITEMS.register("tonakailiner_ride_chemy_card",
			() -> new BaseItem(new Item.Properties()).AddToList(GiftItem.GIFTS).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> KUUGA_RIDE_CHEMY_CARD = ITEMS.register("kuuga_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_exceed_mighty","gotchard","gotchardriver_belt",
					new MobEffectInstance(Effect_core.PUNCH, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)).AddNeedItemList(NEED_ITEM_ExceedMighty)
					.AddToList(NEED_ITEM_ExceedMighty).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	/*agito
	 * ryuki
	 */

	public static final DeferredItem<Item> FAIZ_RIDE_CHEMY_CARD = ITEMS.register("faiz_ride_chemy_card",
			() -> new CopyFormChangeItem(new Item.Properties(),KUUGA_RIDE_CHEMY_CARD.get()).AddToList(NEED_ITEM_ExceedMighty)
					.AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	/*blade
	 * hibiki
	 * kabuto
	 * den-o
	 * kiva
	 * decade
	 */

	public static final DeferredItem<Item> W_RIDE_CHEMY_CARD = ITEMS.register("w_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_cyclone_tatoba","gotchard","gotchardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(Effect_core.PUNCH, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)).AddNeedItemList(NEED_ITEM_CycloneTaToBa)
					.AddToList(NEED_ITEM_CycloneTaToBa).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> OOO_RIDE_CHEMY_CARD = ITEMS.register("ooo_ride_chemy_card",
			() -> new CopyFormChangeItem(new Item.Properties(),W_RIDE_CHEMY_CARD.get()).AddToList(NEED_ITEM_CycloneTaToBa)
					.AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> FOURZE_RIDE_CHEMY_CARD = ITEMS.register("fourze_ride_chemy_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_full_full_rocket","gotchard","gotchardriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)).AddNeedItemList(NEED_ITEM_FullFullRocket)
					.AddToList(NEED_ITEM_FullFullRocket).AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	/*wizard
	 * gaim
	 * drive
	 * ghost
	 * ex-aid
	 */

	public static final DeferredItem<Item> BUILD_RIDE_CHEMY_CARD = ITEMS.register("build_ride_chemy_card",
			() -> new CopyFormChangeItem(new Item.Properties(),FOURZE_RIDE_CHEMY_CARD.get()).AddToList(NEED_ITEM_FullFullRocket)
					.AddToList(RiderTabs.GOTCHARD_TAB_ITEM));

	public static final DeferredItem<Item> GOTCHAR_IGNITER_DB = ITEMS.register("gotchar_igniter_db",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_fire","gotchard_daybreak","gotchardriver_belt_daybreak_fire",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false),
					new MobEffectInstance(Effect_core.BOOST,40,4,true,false),
					new MobEffectInstance(Effect_core.FIRE_PUNCH,40,3,true,false))
					.ChangeModel("default_cape.geo.json").model_has_different_name("gotchar_igniter").has_basic_model());

	public static final DeferredItem<Item> GOTCHAR_IGNITER_EM = ITEMS.register("gotchar_igniter_em",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_exceed_mighty_fire","gotchard","gotchardriver_belt_fire",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false),
					new MobEffectInstance(Effect_core.BOOST,40,4,true,false),
					new MobEffectInstance(Effect_core.FIRE_PUNCH,40,3,true,false))
					.addAlternative(GOTCHAR_IGNITER_DB.get()).addNeedForm(KUUGA_RIDE_CHEMY_CARD.get(),1).ChangeModel("gotchard_fire.geo.json").model_has_different_name("gotchar_igniter").has_basic_model());

	public static final DeferredItem<Item> GOTCHAR_IGNITER_AW = ITEMS.register("gotchar_igniter_aw",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_ant_wrestler_fire","gotchard","gotchardriver_belt_fire",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false),
					new MobEffectInstance(Effect_core.BOOST,40,4,true,false),
					new MobEffectInstance(Effect_core.FIRE_PUNCH,40,3,true,false))
					.addAlternative(GOTCHAR_IGNITER_EM.get()).addNeedForm(ANTROOPER_RIDE_CHEMY_CARD.get(),1).ChangeModel("gotchard_fire.geo.json").model_has_different_name("gotchar_igniter").has_basic_model());

	public static final DeferredItem<Item> GOTCHAR_IGNITER_AS = ITEMS.register("gotchar_igniter_as",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_appare_skebow_fire","gotchard","gotchardriver_belt_fire",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false),
					new MobEffectInstance(Effect_core.BOOST,40,4,true,false),
					new MobEffectInstance(Effect_core.FIRE_PUNCH,40,3,true,false))
					.addAlternative(GOTCHAR_IGNITER_AW.get()).addNeedForm(APPAREBUSHIDO_RIDE_CHEMY_CARD.get(),1).ChangeModel("gotchard_fire.geo.json").model_has_different_name("gotchar_igniter").has_basic_model());

	public static final DeferredItem<Item> GOTCHAR_IGNITER = ITEMS.register("gotchar_igniter",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_fire","gotchard","gotchardriver_belt_fire",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false),
					new MobEffectInstance(Effect_core.BOOST,40,4,true,false),
					new MobEffectInstance(Effect_core.FIRE_PUNCH,40,3,true,false))
					.addAlternative(GOTCHAR_IGNITER_AS.get()).addNeedForm(HOPPER1_RIDE_CHEMY_CARD.get(),1).AddToList(RiderTabs.GOTCHARD_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> GOTCHARD_HELMET = ITEMS.register("gotchard_head",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.GOTCHARD_TAB_ITEM).ChangeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));
    public static final DeferredItem<Item> GOTCHARD_CHESTPLATE = ITEMS.register("gotchard_torso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.GOTCHARD_TAB_ITEM).ChangeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));
    public static final DeferredItem<Item> GOTCHARD_LEGGINGS = ITEMS.register("gotchard_legs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.GOTCHARD_TAB_ITEM).ChangeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));

    
    public static final DeferredItem<Item> GOTCHARDRIVER = ITEMS.register("gotchardriver",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"gotchard", HOPPER1_RIDE_CHEMY_CARD ,GOTCHARD_HELMET, GOTCHARD_CHESTPLATE,GOTCHARD_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.GOTCHARD_TAB_ITEM).ChangeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));

	public static final DeferredItem<Item> GOTCHARDRIVER_DAYBREAK = ITEMS.register("gotchardriver_daybreak",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"gotchard_daybreak", HOPPER1_RIDE_CHEMY_CARD_DAYBREAK ,GOTCHARD_HELMET, GOTCHARD_CHESTPLATE,GOTCHARD_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.GOTCHARD_TAB_ITEM).ChangeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));

	public static final DeferredItem<Item> ALCHEMISDRIVER = ITEMS.register("alchemisdriver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"majade", THE_SUN_RIDE_CHEMY_CARD ,GOTCHARD_HELMET, GOTCHARD_CHESTPLATE,GOTCHARD_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.GOTCHARD_TAB_ITEM).ChangeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));

	public static final DeferredItem<Item> VALVARADRIVER = ITEMS.register("valvaradriver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"valvarad_rider", MACHWHEEL_RIDE_CHEMY_CARD ,GOTCHARD_HELMET, GOTCHARD_CHESTPLATE,GOTCHARD_LEGGINGS , new Item.Properties())
					.AddToTabList(RiderTabs.GOTCHARD_TAB_ITEM).ChangeRepairItem(BLANK_RIDE_CHEMY_CARD.get()).has_basic_model());

	public static final DeferredItem<Item>  DREADRIVER = ITEMS.register("dreadriver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"dread", STEAMLINER_REPLI_CHEMY_CARD ,GOTCHARD_HELMET, GOTCHARD_CHESTPLATE,GOTCHARD_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.GOTCHARD_TAB_ITEM).ChangeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));


	public static final DeferredItem<Item> LEGENDRIVER = ITEMS.register("legendriver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"legend", LEGEND_RIDE_CHEMY_CARD ,GOTCHARD_HELMET, GOTCHARD_CHESTPLATE,GOTCHARD_LEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.GOTCHARD_TAB_ITEM).ChangeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));

	public static final DeferredItem<Item> VALVARADRAW_BUCKLE = ITEMS.register("valvaradraw_buckle",
			() -> new ValvaradItem(ArmorMaterials.DIAMOND,"valvarad", MADWHEEL_RIDE_CHEMY_CARD ,GOTCHARD_HELMET, GOTCHARD_CHESTPLATE,GOTCHARD_LEGGINGS , new Item.Properties())
					.AddToTabList(RiderTabs.GOTCHARD_TAB_ITEM).ChangeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));


	public static final DeferredItem<Item> GOTCHANDRAW_HOLDER = ITEMS.register("gotchandraw_holder",
			() -> new GotchandrawHolderItem().AddToList(RiderTabs.GOTCHARD_TAB_ITEM));
	public static final DeferredItem<Item> GOTCHANCOLLECTION_PANEL = ITEMS.register("gotchancollection_panel",
			() -> new GotchancollectionPanelItem().AddToList(RiderTabs.GOTCHARD_TAB_ITEM));


	public static final DeferredItem<Item> GOTCHARGE_GUN = ITEMS.register("gotcharge_gun",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GOTCHARD_TAB_ITEM).ChangeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));
	
	public static final DeferredItem<Item> GOTCHAR_TORNADO = ITEMS.register("gotchar_tornado",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GOTCHARD_TAB_ITEM).ChangeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));
	
	public static final DeferredItem<Item> VALVARUSHER = ITEMS.register("valvarusher",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).IsSwordGun().IsHenshinItem(VALVARADRAW_BUCKLE.get()).AddToTabList(RiderTabs.GOTCHARD_TAB_ITEM).ChangeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));
	
	public static final DeferredItem<Item> CHEMY_RISER = ITEMS.register("chemy_riser",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GOTCHARD_TAB_ITEM).ChangeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));
	
	public static final DeferredItem<Item> CHEMY_RISER_SUPANA = ITEMS.register("chemy_riser_supana",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GOTCHARD_TAB_ITEM).ChangeRepairItem(BLANK_RIDE_CHEMY_CARD.get()));

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}

}
