package com.kelco.kamenridercraft.item;

import com.kelco.kamenridercraft.KamenRiderCraftCore;

import com.kelco.kamenridercraft.block.Rider_Blocks;
import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import com.kelco.kamenridercraft.item.BaseItems.BaseSwordItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.tabs.RiderTabs;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Modded_item_core {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);

    public static final DeferredItem<Item> BLANK_FORM = ITEMS.register("blank_form",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","",""));


    public static final DeferredItem<Item>  RIDER_CIRCUIT = ITEMS.register("rider_circuit",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.Misc_TAB_ITEM));

    public static final DeferredItem<Item>  VIENNA_COFFEE= ITEMS.register("vienna_coffee",
            () -> new BaseItem(new Item.Properties().food((new FoodProperties.Builder()).nutrition(1).saturationModifier(0.8f).alwaysEdible().build()))
                    .SetItemAnimation(UseAnim.DRINK).AddToList(RiderTabs.Misc_TAB_ITEM));

    public static final DeferredItem<Item>  PUDDING = ITEMS.register("pudding",
            () -> new BaseItem(new Item.Properties().food(Foods.COOKIE)).AddToList(RiderTabs.Misc_TAB_ITEM));

    public static final DeferredItem<Item>  ICE_POP = ITEMS.register("icepop1",
            () -> new BaseItem(new Item.Properties().food(Foods.BEEF)).AddToList(RiderTabs.Misc_TAB_ITEM));

    public static final DeferredItem<Item>  ICE_POP2 = ITEMS.register("icepop2",
            () -> new BaseItem(new Item.Properties().food(Foods.BEEF)).AddToList(RiderTabs.Misc_TAB_ITEM));

    public static final DeferredItem<Item> ICE_POP3 = ITEMS.register("icepop3",
            () -> new BaseItem(new Item.Properties().food(Foods.BEEF)).AddToList(RiderTabs.Misc_TAB_ITEM));


    public static final DeferredItem<Item>  DONUT = ITEMS.register("donut",
            () -> new BaseItem(new Item.Properties().food(Foods.BREAD)).AddToList(RiderTabs.Misc_TAB_ITEM));

    public static final DeferredItem<Item> MAYO= ITEMS.register("mayo",
            () -> new BaseItem(new Item.Properties().food((new FoodProperties.Builder()).nutrition(1).fast().saturationModifier(0.8f).alwaysEdible().effect(() -> new MobEffectInstance(Effect_core.LOW_GRAVITY, 500, 2), 1.0F).build()))
                    .SetItemAnimation(UseAnim.DRINK).AddToList(RiderTabs.Misc_TAB_ITEM));


    public static final DeferredItem<Item>  CANDY_WRAPPER = ITEMS.register("candy_wrapper",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.Misc_TAB_ITEM));

    public static final DeferredItem<Item>  GUMMI_CANDY = ITEMS.register("gummi_candy",
            () -> new BaseItem(new Item.Properties().food(Foods.SWEET_BERRIES)).AddToList(RiderTabs.Misc_TAB_ITEM));

    public static final DeferredItem<Item>  POTATO_SNACKS = ITEMS.register("potato_snacks",
            () -> new BaseItem(new Item.Properties().food(Foods.POTATO)).AddToList(RiderTabs.Misc_TAB_ITEM));

    public static final DeferredItem<Item>  LOLLIPOP = ITEMS.register("lollipop",
            () -> new BaseItem(new Item.Properties().food(Foods.MELON_SLICE)).AddToList(RiderTabs.Misc_TAB_ITEM));

    public static final DeferredItem<Item>  CHOCOLATE_BAR = ITEMS.register("chocolate_bar",
            () -> new BaseItem(new Item.Properties().food(Foods.COOKIE)).AddToList(RiderTabs.Misc_TAB_ITEM));

    public static final DeferredItem<Item>  MARSHMALLOW = ITEMS.register("marshmallow",
            () -> new BaseItem(new Item.Properties().food(Foods.MELON_SLICE)).AddToList(RiderTabs.Misc_TAB_ITEM));


    public static final DeferredItem<Item> BASE_SWORD = ITEMS.register("base_sword",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.Misc_TAB_ITEM));

    public static final DeferredItem<Item>  BASE_BIKE = ITEMS.register("base_bike",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.Misc_TAB_ITEM));

    public static final DeferredItem<Item>  SHOCKER_EMBLEM = ITEMS.register("shocker_emblem",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.Misc_TAB_ITEM));

    public static final DeferredItem<Item>  SINISTER_PACHINKO_BALL = ITEMS.register("sinister_pachinko_ball",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.Misc_TAB_ITEM));



    public static final DeferredItem<Item>  CARD_WARRIOR_KAMEN_RIDER_MANGA = ITEMS.register("card_warrior_kamen_rider_manga",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.Misc_TAB_ITEM).KeepItem());


    public static final DeferredItem<Item> DRAGREDER = ITEMS.register("dragreder",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_dragreder","ryuki","v_buckle_belt_ryuki",
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
                    new MobEffectInstance(Effect_core.FLYING, 40, 1,true,false))
                    .hasStaticWings().AddToList(RiderTabs.Misc_TAB_ITEM));

    public static final DeferredItem<Item> STAGTORNADOR = ITEMS.register("stagtornador",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_stagtornador","agito","alter_ring_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
                    new MobEffectInstance(Effect_core.FLYING, 40, 1,true,false))
                    .hasStaticWings().AddToList(RiderTabs.Misc_TAB_ITEM));

    public static final DeferredItem<Item> HERCULESPADER = ITEMS.register("herculespader",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_herculespader","blade","blay_buckle_belt",
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false))
                    .hasStaticWings().AddToList(RiderTabs.Misc_TAB_ITEM));


    public static final DeferredItem<Item> DARKWING = ITEMS.register("darkwing",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_darkwing","knight","v_buckle_belt_knight",
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
                    new MobEffectInstance(Effect_core.FLYING, 40, 1,true,false))
                    .hasStaticWings().AddToList(RiderTabs.Misc_TAB_ITEM));



    public static final DeferredItem<Item> GREYWOLCH = ITEMS.register("greywolch",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_greywolch","faiz","faiz_driver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false))
                    .hasStaticWings().AddToList(RiderTabs.Misc_TAB_ITEM));

    public static final DeferredItem<Item> GRANDGOURAM = ITEMS.register("grandgouram",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_grand_gouram","kuuga","arcle_belt_r",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
                    new MobEffectInstance(Effect_core.PUNCH, 40, 8,true,false))
                    .hasStaticWings().AddToList(RiderTabs.Misc_TAB_ITEM));

    public static final DeferredItem<Item> EXBEETER = ITEMS.register("exbeeter",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_exbeeter","kabuto","kabuto_rider_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false))
                    .hasStaticWings().AddToList(RiderTabs.Misc_TAB_ITEM));

    public static final DeferredItem<Item> CHAOSDILE = ITEMS.register("chaosdile",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_chaosdile","kaixa","kaixa_driver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)
            ).hasStaticWings().AddToList(RiderTabs.Misc_TAB_ITEM));


    public static final DeferredItem<Item> LEATHERAIDER = ITEMS.register("leatheraider",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_leatheraider","gills","meta_factor_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false))
                    .hasStaticWings().AddToList(RiderTabs.Misc_TAB_ITEM));


    public static final DeferredItem<Item>FLARESALAMANDER = ITEMS.register("flaresalamander",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_flaresalamander","v3","double_typhoon_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(Effect_core.PUNCH, 40, 4,true,false),
                    new MobEffectInstance(Effect_core.FLYING, 40, 1,true,false)
            ).AddToList(RiderTabs.Misc_TAB_ITEM));

    public static final DeferredItem<Item> DRAGRANZER = ITEMS.register("dragranzer",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_dragranzer","ryuki","v_buckle_belt_ryuki_s",
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(Effect_core.FLYING, 40, 1,true,false))
                    .hasStaticWings().AddToList(RiderTabs.Misc_TAB_ITEM));


    public static final DeferredItem<Item> SCISSORBEETER = ITEMS.register("scissorbeeter",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_scissorbeeter","gatack","gatack_rider_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
                    new MobEffectInstance(Effect_core.FLYING, 40, 1,true,false))
                    .hasStaticWings().AddToList(RiderTabs.Misc_TAB_ITEM));


    public static final DeferredItem<Item> AKANETAKA = ITEMS.register("akanetaka",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_akanetaka","hibiki","hibikidriver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
                    new MobEffectInstance(Effect_core.FLYING, 40, 1,true,false))
                    .hasStaticWings().AddToList(RiderTabs.Misc_TAB_ITEM));


    public static final DeferredItem<Item>SHADOWMANTIS = ITEMS.register("shadowmantis",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_shadowmantis","chalice","chalice_rouzer_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
                    new MobEffectInstance(Effect_core.FLYING, 40, 1,true,false))
                    .hasStaticWings().AddToList(RiderTabs.Misc_TAB_ITEM));



    public static final DeferredItem<Item> CYCLONEHOPPER = ITEMS.register("cyclonehopper",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_cyclonehopper","ichigo","typhoon_belt_original",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(Effect_core.PUNCH, 40, 4,true,false),
                    new MobEffectInstance(Effect_core.FLYING, 40, 1,true,false)
            ).hasStaticWings().AddToList(RiderTabs.Misc_TAB_ITEM));

    //Bakuen no senshi



    public static final DeferredItem<Item> BAKUEN_NO_SENSHI_HIBIKI = ITEMS.register("bakuen_no_senshi_hibiki",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_bakuen_no_senshi","hibiki","hibikidriver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
                    new MobEffectInstance(Effect_core.FLYING, 40, 1,true,false)
            ).hasStaticWings());

    public static final DeferredItem<Item> BAKUEN_NO_SENSHI_RYUGA = ITEMS.register("bakuen_no_senshi_ryuga",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_bakuen_no_senshi","ryuga","v_buckle_belt_ryuga",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
                    new MobEffectInstance(Effect_core.FLYING, 40, 1,true,false)
            ).hasStaticWings().addAlternative(BAKUEN_NO_SENSHI_HIBIKI.get()));

    public static final DeferredItem<Item> BAKUEN_NO_SENSHI = ITEMS.register("bakuen_no_senshi",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_bakuen_no_senshi","faiz","faiz_driver_belt_b",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
                    new MobEffectInstance(Effect_core.FLYING, 40, 1,true,false)
            ).hasStaticWings().addAlternative(BAKUEN_NO_SENSHI_RYUGA.get()).AddToList(RiderTabs.Misc_TAB_ITEM));


    public static final DeferredItem<Item> JINRAI_NO_SENSHI_DARK_KABUTO = ITEMS.register("jinrai_no_senshi_dark_kabuto",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_jinrai_no_senshi","dark_kabuto","dark_kabuto_rider_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
                    new MobEffectInstance(Effect_core.PUNCH, 40, 6,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
                    new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false)
            ).hasStaticWings());


    public static final DeferredItem<Item> JINRAI_NO_SENSHI_BLADE = ITEMS.register("jinrai_no_senshi_blade",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_jinrai_no_senshi","blade","blay_buckle_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
                    new MobEffectInstance(Effect_core.PUNCH, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
                    new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false)
            ).hasStaticWings().addAlternative(JINRAI_NO_SENSHI_DARK_KABUTO.get()));


    public static final DeferredItem<Item> JINRAI_NO_SENSHI = ITEMS.register("jinrai_no_senshi",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_jinrai_no_senshi","kuuga","arcle_belt_r",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
                    new MobEffectInstance(Effect_core.PUNCH, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
                    new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false)
            ).hasStaticWings().addAlternative(JINRAI_NO_SENSHI_BLADE.get()).AddToList(RiderTabs.Misc_TAB_ITEM));


    public static final DeferredItem<Item> GRANDGOURAM_ROD = ITEMS.register("grandgouram_rod",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.Misc_TAB_ITEM)
                    .ChangeRepairItem(RIDER_CIRCUIT.get()));

    public static final DeferredItem<Item> HERCULESPADER_SWORD = ITEMS.register("herculespader_sword",
            () -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.Misc_TAB_ITEM)
                    .ChangeRepairItem(RIDER_CIRCUIT.get()));

    public static final DeferredItem<Item> DARKWING_SWORD = ITEMS.register("darkwing_sword",
            () -> new BaseSwordItem(Tiers.DIAMOND, 9, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.Misc_TAB_ITEM)
                    .ChangeRepairItem(RIDER_CIRCUIT.get()));

    public static final DeferredItem<Item> FLARESALAMANDER_SWORD = ITEMS.register("flaresalamander_sword",
            () -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.Misc_TAB_ITEM)
                    .ChangeRepairItem(RIDER_CIRCUIT.get()));

    public static final DeferredItem<SignItem> HELHEIM_SIGN_ITEM = ITEMS.register("helheim_sign_item",
            () -> new SignItem(new Item.Properties().stacksTo(16), Rider_Blocks.HELHEIM_SIGN.get(), Rider_Blocks.HELHEIM_WALL_SIGN.get()));
    public static final DeferredItem<SignItem> HELHEIM_HANGING_SIGN_ITEM = ITEMS.register("helheim_hanging_sign_item",
            () -> new SignItem(new Item.Properties().stacksTo(16), Rider_Blocks.HELHEIM_HANGING_SIGN.get(), Rider_Blocks.HELHEIM_WALL_HANGING_SIGN.get()));

public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);
}


}