package com.kelco.kamenridercraft.item;

import com.kelco.kamenridercraft.KamenRiderCraftCore;

import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.item.BaseItems.*;
import com.kelco.kamenridercraft.item.den_o.DenKamenSwordItem;
import com.kelco.kamenridercraft.item.den_o.RiderPassItem;
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

public class Den_O_Rider_Items {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);

	public static final DeferredItem<Item> DEN_O_LOGO = ITEMS.register("den_o_logo",
			() -> new BaseItem(new Item.Properties()).AddToTabList(RiderTabs.DEN_O_TAB_ITEM));

	public static final DeferredItem<Item> IMAGIN_SAND = ITEMS.register("imagin_sand",
			() -> new BaseItem(new Item.Properties()).AddToTabList(RiderTabs.DEN_O_TAB_ITEM));

	public static final DeferredItem<Item> RIDER_TICKET_NEW_DEN_O = ITEMS.register("rider_ticket_new_den_o",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_plat","new_den_o","new_den_o_belt_p",
					new MobEffectInstance(MobEffects.WEAKNESS, 40, 0,true,false)));

	public static final DeferredItem<Item> RIDER_TICKET = ITEMS.register("rider_ticket",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_plat","den_o","den_o_belt_p",
					new MobEffectInstance(MobEffects.WEAKNESS, 40, 0,true,false)).addAlternative(RIDER_TICKET_NEW_DEN_O.get()).AddToTabList(RiderTabs.DEN_O_TAB_ITEM));

	public static final DeferredItem<Item> RIDER_TICKET_SWORD = ITEMS.register("rider_ticket_sword",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","den_o","den_o_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)).AddToTabList(RiderTabs.DEN_O_TAB_ITEM));

	public static final DeferredItem<Item> RIDER_TICKET_ROD = ITEMS.register("rider_ticket_rod",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_rod","den_o","den_o_belt_r",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)).AddToTabList(RiderTabs.DEN_O_TAB_ITEM));

	public static final DeferredItem<Item> RIDER_TICKET_AX = ITEMS.register("rider_ticket_ax",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_axe","den_o","den_o_belt_a",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)).AddToTabList(RiderTabs.DEN_O_TAB_ITEM));

	public static final DeferredItem<Item> RIDER_TICKET_GUN = ITEMS.register("rider_ticket_gun",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_gun","den_o","den_o_belt_g",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)).AddToTabList(RiderTabs.DEN_O_TAB_ITEM));

	public static final DeferredItem<Item> KTAROS = ITEMS.register("ktaros",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_climax","den_o","den_o_belt_c",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)).AddToTabList(RiderTabs.DEN_O_TAB_ITEM));

    public static final DeferredItem<Item> SUPER_KTAROS = ITEMS.register("super_ktaros",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_super_climax","den_o","den_o_belt_c",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.WEAKNESS, 40, 0,true,false)).addNeedItem(KTAROS.get()).ChangeModel("geo/cyclonehopper_wingsarmor.geo.json"));

	public static final DeferredItem<Item> RIDER_TICKET_WING = ITEMS.register("rider_ticket_wing",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_wing","den_o","den_o_belt_w",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.WEAKNESS, 40, 0,true,false),
					new MobEffectInstance(Effect_core.FLYING, 40, 1,true,false)).addShiftForm(SUPER_KTAROS.get()).AddToTabList(RiderTabs.DEN_O_TAB_ITEM));

    public static final DeferredItem<Item> DEN_O_LINER_FORM = ITEMS.register("den_o_liner_form",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_liner","den_o","den_o_belt_c",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.WEAKNESS, 40, 0,true,false)).addNeedItem(KTAROS.get()));

    public static final DeferredItem<Item> ZERONOS_PLAT_CARD = ITEMS.register("zeronos_plat_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_plat","zeronos","zeronos_belt_p",
					new MobEffectInstance(MobEffects.WEAKNESS, 40, 0,true,false)).AddToTabList(RiderTabs.DEN_O_TAB_ITEM));

	public static final DeferredItem<Item> ZERONOS_ALTAIR_CARD = ITEMS.register("zeronos_altair_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","zeronos","zeronos_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)).AddToTabList(RiderTabs.DEN_O_TAB_ITEM));

	public static final DeferredItem<Item> NEW_DEN_O_VEGA_CARD = ITEMS.register("new_den_o_vega_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_vega","new_den_o","new_den_o_belt_v",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)));

	public static final DeferredItem<Item> ZERONOS_VEGA_CARD = ITEMS.register("zeronos_vega_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_vega","zeronos","zeronos_belt_v",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)).addAlternative(NEW_DEN_O_VEGA_CARD.get()).AddToTabList(RiderTabs.DEN_O_TAB_ITEM));

	public static final DeferredItem<Item> ZERONOS_ZERO_CARD = ITEMS.register("zeronos_zero_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_zero","zeronos","zeronos_belt_z",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 1,true,false)).AddToTabList(RiderTabs.DEN_O_TAB_ITEM));

    public static final DeferredItem<Item> RIDER_TICKET_NEGA = ITEMS.register("rider_ticket_nega",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","nega_den_o","den_o_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)).AddToTabList(RiderTabs.DEN_O_TAB_ITEM));

    public static final DeferredItem<Item> RIDER_TICKET_YUUKI_HIJACK = ITEMS.register("rider_ticket_yuuki_hijack",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_hijack","yuuki","yuuki_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 2,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)));

	public static final DeferredItem<Item> RIDER_TICKET_YUUKI = ITEMS.register("rider_ticket_yuuki",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_skull","yuuki","yuuki_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 2,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)).addSwitchForm(RIDER_TICKET_YUUKI_HIJACK.get()).AddToTabList(RiderTabs.DEN_O_TAB_ITEM));

    public static final DeferredItem<Item> RIDER_TICKET_G = ITEMS.register("rider_ticket_g",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","g_den_o","g_den_o_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)).AddToTabList(RiderTabs.DEN_O_TAB_ITEM));

    public static final DeferredItem<Item> RIDER_TICKET_GAOH = ITEMS.register("rider_ticket_gaoh",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","gaoh","gaoh_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)).AddToTabList(RiderTabs.DEN_O_TAB_ITEM));

    public static final DeferredItem<Item> RIDER_TICKET_STRIKE = ITEMS.register("rider_ticket_strike",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","new_den_o","new_den_o_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)).AddToTabList(RiderTabs.DEN_O_TAB_ITEM));

	public static final DeferredItem<Item> RIDER_TICKET_PRETTY_DEN_O = ITEMS.register("rider_ticket_pretty_den_o",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","pretty_den_o","den_o_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)));

    public static final DeferredItem<Item> RIDER_TICKET_PUDDING = ITEMS.register("rider_ticket_pudding",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_pudding","den_o","den_o_belt_pu",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 400, 2,true,false)).AddToTabList(RiderTabs.DEN_O_TAB_ITEM));

	public static final DeferredItem<Item> DEN_OHELMET = ITEMS.register("den_ohead",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.DEN_O_TAB_ITEM).ChangeRepairItem(IMAGIN_SAND.get()));
	public static final DeferredItem<Item> DEN_OCHESTPLATE = ITEMS.register("den_otroso",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.DEN_O_TAB_ITEM).ChangeRepairItem(IMAGIN_SAND.get()));
	public static final DeferredItem<Item> DEN_OLEGGINGS = ITEMS.register("den_olegs",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.DEN_O_TAB_ITEM).ChangeRepairItem(IMAGIN_SAND.get()));

	public static final DeferredItem<Item> DEN_O_BELT = ITEMS.register("den_o_belt",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"den_o",RIDER_TICKET_SWORD ,DEN_OHELMET, DEN_OCHESTPLATE,DEN_OLEGGINGS , new Item.Properties())
			.AddToTabList(RiderTabs.DEN_O_TAB_ITEM).ChangeRepairItem(IMAGIN_SAND.get()));

	public static final DeferredItem<Item> ZERONOS_BELT = ITEMS.register("zeronos_belt",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"zeronos",ZERONOS_ALTAIR_CARD ,DEN_OHELMET, DEN_OCHESTPLATE,DEN_OLEGGINGS , new Item.Properties())
			.AddToTabList(RiderTabs.DEN_O_TAB_ITEM).ChangeRepairItem(IMAGIN_SAND.get()));

	public static final DeferredItem<Item> NEGA_DEN_O_BELT = ITEMS.register("nega_den_o_belt",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"nega_den_o",RIDER_TICKET_NEGA ,DEN_OHELMET, DEN_OCHESTPLATE,DEN_OLEGGINGS , new Item.Properties())
			.AddToTabList(RiderTabs.DEN_O_TAB_ITEM).ChangeRepairItem(IMAGIN_SAND.get()));

	public static final DeferredItem<Item> NEW_DEN_O_BELT = ITEMS.register("new_den_o_belt",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"new_den_o",RIDER_TICKET_STRIKE ,DEN_OHELMET, DEN_OCHESTPLATE,DEN_OLEGGINGS , new Item.Properties())
			.AddToTabList(RiderTabs.DEN_O_TAB_ITEM).ChangeRepairItem(IMAGIN_SAND.get()));

	public static final DeferredItem<Item> GAOH_BELT = ITEMS.register("gaoh_belt",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"gaoh",RIDER_TICKET_GAOH ,DEN_OHELMET, DEN_OCHESTPLATE,DEN_OLEGGINGS , new Item.Properties())
			.AddToTabList(RiderTabs.DEN_O_TAB_ITEM).ChangeRepairItem(IMAGIN_SAND.get()));

	public static final DeferredItem<Item> YUUKI_BELT = ITEMS.register("yuuki_belt",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"yuuki",RIDER_TICKET_YUUKI ,DEN_OHELMET, DEN_OCHESTPLATE,DEN_OLEGGINGS , new Item.Properties())
			.AddToTabList(RiderTabs.DEN_O_TAB_ITEM).ChangeRepairItem(IMAGIN_SAND.get()));

	public static final DeferredItem<Item> G_DEN_O_BELT = ITEMS.register("g_den_o_belt",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"g_den_o",RIDER_TICKET_G ,DEN_OHELMET, DEN_OCHESTPLATE,DEN_OLEGGINGS , new Item.Properties())
			.AddToTabList(RiderTabs.DEN_O_TAB_ITEM).ChangeRepairItem(IMAGIN_SAND.get()));

	public static final DeferredItem<Item> PRETTY_DEN_O_BELT = ITEMS.register("pretty_den_o_belt",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"pretty_den_o",RIDER_TICKET_PRETTY_DEN_O ,DEN_OHELMET, DEN_OCHESTPLATE,DEN_OLEGGINGS , new Item.Properties())
			.AddToTabList(RiderTabs.DEN_O_TAB_ITEM).ChangeRepairItem(IMAGIN_SAND.get()));

    public static final DeferredItem<Item> RIDER_PASS = ITEMS.register("rider_pass",
            () -> new RiderPassItem(new Item.Properties().durability(20)).AddToTabList(RiderTabs.DEN_O_TAB_ITEM));

    public static final DeferredItem<Item> MASTER_PASS = ITEMS.register("master_pass",
            () -> new RiderPassItem(new Item.Properties()).AddToTabList(RiderTabs.DEN_O_TAB_ITEM));

	public static final DeferredItem<Item> G_DEN_O_RIDER_PASS = ITEMS.register("g_den_o_rider_pass",
            () -> new RiderPassItem(new Item.Properties()).AddToTabList(RiderTabs.DEN_O_TAB_ITEM));

    public static final DeferredItem<Item>DEN_GASHER_SWORD = ITEMS.register("den_gasher_sword",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.DEN_O_TAB_ITEM).ChangeRepairItem(IMAGIN_SAND.get()));
    public static final DeferredItem<Item> DEN_GASHER_ROD = ITEMS.register("den_gasher_rod",
            () -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.DEN_O_TAB_ITEM).ChangeRepairItem(IMAGIN_SAND.get()));
    public static final DeferredItem<Item> DEN_GASHER_AX = ITEMS.register("den_gasher_ax",
            () -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.DEN_O_TAB_ITEM).ChangeRepairItem(IMAGIN_SAND.get()));
    public static final DeferredItem<Item> DEN_GASHER_GUN = ITEMS.register("den_gasher_gun",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.DEN_O_TAB_ITEM).ChangeRepairItem(IMAGIN_SAND.get()));
    public static final DeferredItem<Item>DENKAMEN_SWORD = ITEMS.register("denkamen_sword",
            () -> new DenKamenSwordItem(Tiers.DIAMOND, 9, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.DEN_O_TAB_ITEM).ChangeRepairItem(IMAGIN_SAND.get()));
    public static final DeferredItem<Item> DEN_GASHER_HANDAX = ITEMS.register("den_gasher_handax",
            () -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.DEN_O_TAB_ITEM).ChangeRepairItem(IMAGIN_SAND.get()));
    public static final DeferredItem<Item> DEN_GASHER_BOOMERANG = ITEMS.register("den_gasher_boomerang",
            () -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.DEN_O_TAB_ITEM).ChangeRepairItem(IMAGIN_SAND.get()));
    public static final DeferredItem<Item> SAVAGE_GASHER = ITEMS.register("savage_gasher",
            () -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.DEN_O_TAB_ITEM).ChangeRepairItem(IMAGIN_SAND.get()));
    public static final DeferredItem<Item> MOMOTAKEN = ITEMS.register("momotaken",
            () -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.DEN_O_TAB_ITEM).ChangeRepairItem(IMAGIN_SAND.get()));
    public static final DeferredItem<Item> URATAZAO = ITEMS.register("uratazao",
            () -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.DEN_O_TAB_ITEM).ChangeRepairItem(IMAGIN_SAND.get()));
    public static final DeferredItem<Item> KINTAONO = ITEMS.register("kintaono",
            () -> new BaseSwordItem(Tiers.DIAMOND, 7, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.DEN_O_TAB_ITEM).ChangeRepairItem(IMAGIN_SAND.get()));
    public static final DeferredItem<Item>G_DEN_GASHER_JITTE = ITEMS.register("g_den_gasher_jitte",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.DEN_O_TAB_ITEM).ChangeRepairItem(IMAGIN_SAND.get()));
    public static final DeferredItem<Item> MACHETEDDY = ITEMS.register("macheteddy",
            () -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.DEN_O_TAB_ITEM).ChangeRepairItem(IMAGIN_SAND.get()));
    public static final DeferredItem<Item> G_DEN_GASHER_GUN = ITEMS.register("g_den_gasher_gun",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.DEN_O_TAB_ITEM).ChangeRepairItem(IMAGIN_SAND.get()));

    public static final DeferredItem<Item> NEGA_DEN_GASHER = ITEMS.register("nega_den_gasher",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.DEN_O_TAB_ITEM).ChangeRepairItem(IMAGIN_SAND.get()));
    public static final DeferredItem<Item> GAOH_GASHER = ITEMS.register("gaoh_gasher",
            () -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.DEN_O_TAB_ITEM).ChangeRepairItem(IMAGIN_SAND.get()));
    public static final DeferredItem<Item> DEN_GASHER_VEGA = ITEMS.register("den_gasher_vega",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.DEN_O_TAB_ITEM).ChangeRepairItem(IMAGIN_SAND.get()));
    public static final DeferredItem<Item> DEN_GASHER_PUDDING = ITEMS.register("den_gasher_pudding",
            () -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.DEN_O_TAB_ITEM).ChangeRepairItem(IMAGIN_SAND.get()));

    public static final DeferredItem<Item> MOMOTAROSWORD = ITEMS.register("momotarosword",
            () -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.DEN_O_TAB_ITEM).ChangeRepairItem(IMAGIN_SAND.get()));
    public static final DeferredItem<Item> URATAROD = ITEMS.register("uratarod",
            () -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.DEN_O_TAB_ITEM).ChangeRepairItem(IMAGIN_SAND.get()));
    public static final DeferredItem<Item> KINTAROS_AX = ITEMS.register("kintaros_ax",
            () -> new BaseSwordItem(Tiers.DIAMOND, 7, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.DEN_O_TAB_ITEM).ChangeRepairItem(IMAGIN_SAND.get()));
    public static final DeferredItem<Item> RYUVOLVER = ITEMS.register("ryuvolver",
    		() -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.DEN_O_TAB_ITEM).ChangeRepairItem(IMAGIN_SAND.get()));
    public static final DeferredItem<Item> NEGA_MOMOTAROSWORD = ITEMS.register("nega_momotarosword",
            () -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.DEN_O_TAB_ITEM).ChangeRepairItem(IMAGIN_SAND.get()));
    public static final DeferredItem<Item> NEGA_URATAROD = ITEMS.register("nega_uratarod",
            () -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.DEN_O_TAB_ITEM).ChangeRepairItem(IMAGIN_SAND.get()));
    public static final DeferredItem<Item> NEGA_KINTAROS_AX = ITEMS.register("nega_kintaros_ax",
            () -> new BaseSwordItem(Tiers.DIAMOND, 7, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.DEN_O_TAB_ITEM).ChangeRepairItem(IMAGIN_SAND.get()));
    public static final DeferredItem<Item> NEGA_RYUVOLVER = ITEMS.register("nega_ryuvolver",
    		() -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.DEN_O_TAB_ITEM).ChangeRepairItem(IMAGIN_SAND.get()));
	
    public static final DeferredItem<Item> ZEROGASHER = ITEMS.register("zerogasher",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.DEN_O_TAB_ITEM).ChangeRepairItem(IMAGIN_SAND.get()));

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}

}