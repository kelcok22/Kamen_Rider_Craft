package com.kelco.kamenridercraft.item;

import com.kelco.kamenridercraft.KamenRiderCraftCore;

import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.item.BaseItems.*;
import com.kelco.kamenridercraft.item.decade.AttackRideCardItem;
import com.kelco.kamenridercraft.item.decade.BlankCardItem;
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

	public static final DeferredItem<Item> DECADE_LOGO = ITEMS.register("decade_logo",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DECADE_CAMERA = ITEMS.register("decade_camera",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.DECADE_TAB_ITEM).KeepItem());

	public static final DeferredItem<Item> BLANK_CRAD = ITEMS.register("blank_card",
			() -> new BlankCardItem(new Item.Properties()).AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> DECADE_CYAN_CRAD = ITEMS.register("decade_cyan_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_cyan","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)));

    public static final DeferredItem<Item> DIEND_GREEN_CRAD = ITEMS.register("diend_green_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_green","diend","diend_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)));

    public static final DeferredItem<Item> DECADE_CRAD = ITEMS.register("decade_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)).addAlternative(DIEND_GREEN_CRAD.get()).AddToList(RiderTabs.DECADE_TAB_ITEM).AddToList(BlankCardItem.RIDER_CARD, 10));

    public static final DeferredItem<Item> K_TOUCH = ITEMS.register("k_touch",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_complete","decade","decadriver_belt_k_touch",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)).AddToList(RiderTabs.DECADE_TAB_ITEM));
					
    public static final DeferredItem<Item> DECADE_VIOLENT_EMOTION_CARD = ITEMS.register("decade_violent_emotion_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_violent_emotion","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
					new MobEffectInstance(MobEffects.HUNGER, 40, 0,true,false)).AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> DIEND_CRAD = ITEMS.register("diend_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","diend","diend_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)).addAlternative(DECADE_CYAN_CRAD.get()).AddToList(RiderTabs.DECADE_TAB_ITEM).AddToList(BlankCardItem.RIDER_CARD, 5));

    public static final DeferredItem<Item> DIEND_CRAD_POWER_UP = ITEMS.register("diend_power_up_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","diend","diend_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)).AddToList(RiderTabs.DECADE_TAB_ITEM).AddToList(BlankCardItem.RIDER_CARD, 5));

    
    public static final DeferredItem<Item> K_TOUCH_DIEND = ITEMS.register("k_touch_diend",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_complete","diend","diend_belt_k_touch",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)).AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> DARK_DECADE_CRAD = ITEMS.register("dark_decade_card",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","dark_decade","dark_decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)).AddToList(RiderTabs.DECADE_TAB_ITEM).AddToList(BlankCardItem.RIDER_CARD));

	public static String[] BaseDecadeUsers = new String[] {"decade","dark_decade"};

    public static final DeferredItem<Item> KUUGA_MIGHTY_CRAD = ITEMS.register("kuuga_mighty_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","decade","decadriver_belt",
            		new MobEffectInstance(Effect_core.PUNCH, 40, 2,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("kuuga").AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> AGITO_GROUND_CRAD = ITEMS.register("agito_ground_card",
	        () -> new RiderFormChangeItem(new Item.Properties(),0,"","decade","decadriver_belt",
	        		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
	        		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false))
	        .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("agito").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> RYUKI_CRAD = ITEMS.register("ryuki_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("ryuki").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> FAIZ_CRAD = ITEMS.register("faiz_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false))
            .IsGlowing().AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("faiz").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> BLADE_ACE_CRAD = ITEMS.register("blade_ace_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("blade").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> HIBIKI_CRAD = ITEMS.register("hibiki_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("hibiki").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> KABUTO_RIDER_CRAD = ITEMS.register("kabuto_rider_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("kabuto").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> DEN_O_SWORD_CRAD = ITEMS.register("den_o_sword_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("den_o").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> KIVA_CRAD = ITEMS.register("kiva_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","decade","decadriver_belt",
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("kiva").AddToList(RiderTabs.DECADE_TAB_ITEM));
	

	public static final DeferredItem<Item> KUUGA_GROWING_CRAD = ITEMS.register("kuuga_growing_card",
	        () -> new RiderFormChangeItem(new Item.Properties(),0,"_growing","decade","decadriver_belt",
	        		new MobEffectInstance(MobEffects.WEAKNESS, 40, 2,true,false))
	        .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("kuuga").AddToList(RiderTabs.DECADE_TAB_ITEM));
		
    public static final DeferredItem<Item> KUUGA_DRAGON_CRAD = ITEMS.register("kuuga_dragon_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_dragon","decade","decadriver_belt",
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("kuuga").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> KUUGA_PEGASUS_CRAD = ITEMS.register("kuuga_pegasus_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_pegasus","decade","decadriver_belt",
            		new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
            		new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("kuuga").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> KUUGA_TITAN_CRAD = ITEMS.register("kuuga_titan_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_titan","decade","decadriver_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("kuuga").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> KUUGA_RISING_MIGHTY_CRAD = ITEMS.register("kuuga_rising_mighty_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_rising_mighty","decade","decadriver_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
            		new MobEffectInstance(Effect_core.PUNCH, 40, 3,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("kuuga").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> KUUGA_RISING_DRAGON_CRAD = ITEMS.register("kuuga_rising_dragon_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_rising_dragon","decade","decadriver_belt",
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("kuuga").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> KUUGA_RISING_PEGASUS_CRAD = ITEMS.register("kuuga_rising_pegasus_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_rising_pegasus","decade","decadriver_belt",
            		new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
            		new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("kuuga").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> KUUGA_RISING_TITAN_CRAD = ITEMS.register("kuuga_rising_titan_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_rising_titan","decade","decadriver_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("kuuga").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> KUUGA_AMAZING_MIGHTY_CRAD = ITEMS.register("kuuga_amazing_mighty_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_amazing_mighty","decade","decadriver_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
            		new MobEffectInstance(Effect_core.PUNCH, 40, 4,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("kuuga").AddToList(RiderTabs.DECADE_TAB_ITEM));

  
    public static final DeferredItem<Item> AGITO_STORM_CRAD = ITEMS.register("agito_storm_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_storm","decade","decadriver_belt",
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("agito").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> AGITO_FLAME_CRAD = ITEMS.register("agito_flame_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_flame","decade","decadriver_belt",
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("agito").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> AGITO_TRINITY_CRAD = ITEMS.register("agito_trinity_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_trinity","decade","decadriver_belt",
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("agito").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> AGITO_BURNING_CRAD = ITEMS.register("agito_burning_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_burning","decade","decadriver_belt",
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("agito").AddToList(RiderTabs.DECADE_TAB_ITEM));


    public static final DeferredItem<Item> RYUKI_BLANK_CRAD = ITEMS.register("ryuki_blank_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_blank","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.WEAKNESS, 40, 0,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("ryuki").AddToList(RiderTabs.DECADE_TAB_ITEM));


    public static final DeferredItem<Item> FAIZ_AXEL_CRAD = ITEMS.register("faiz_axel_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_axel","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 5,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false))
					.IsGlowing().AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("faiz").AddToList(RiderTabs.DECADE_TAB_ITEM));


    public static final DeferredItem<Item> BLADE_JACK_CRAD = ITEMS.register("blade_jack_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_jack","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("blade").hasFlyingWings( "geo/rider_plusbelt_and_wings.geo.json").AddToList(RiderTabs.DECADE_TAB_ITEM));


    public static final DeferredItem<Item> HIBIKI_KURENAI_CRAD = ITEMS.register("hibiki_kurenai_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_kurenai","decade","decadriver_belt",
                	new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
                	new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
                	new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
                	new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("hibiki").AddToList(RiderTabs.DECADE_TAB_ITEM));


    public static final DeferredItem<Item> KABUTO_MASKED_CRAD = ITEMS.register("kabuto_masked_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_masked","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("kabuto").AddToList(RiderTabs.DECADE_TAB_ITEM));


    public static final DeferredItem<Item> DEN_O_PLAT_CRAD = ITEMS.register("den_o_plat_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_plat","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.WEAKNESS, 40, 0,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("den_o").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> DEN_O_ROD_CRAD = ITEMS.register("den_o_rod_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_rod","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("den_o").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> DEN_O_AX_CRAD = ITEMS.register("den_o_ax_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_axe","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("den_o").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> DEN_O_GUN_CRAD = ITEMS.register("den_o_gun_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_gun","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("den_o").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> DEN_O_WING_CRAD = ITEMS.register("den_o_wing_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_wing","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.WEAKNESS, 40, 0,true,false),
					new MobEffectInstance(Effect_core.FLYING, 40, 1,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("den_o").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> DEN_O_CLIMAX_CRAD = ITEMS.register("den_o_climax_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_climax","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("den_o").AddToList(RiderTabs.DECADE_TAB_ITEM));


    public static final DeferredItem<Item> KIVA_GARULU_CRAD = ITEMS.register("kiva_garulu_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_garulu","decade","decadriver_belt",
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("kiva").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> KIVA_BASSHAA_CRAD = ITEMS.register("kiva_basshaa_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_basshaa","decade","decadriver_belt",
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("kiva").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> KIVA_DOGGA_CRAD = ITEMS.register("kiva_dogga_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_dogga","decade","decadriver_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("kiva").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> KIVA_DOGABAKI_CRAD = ITEMS.register("kiva_dogabaki_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_dogabaki","decade","decadriver_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.WITHER, 40, 0,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("kiva").AddToList(RiderTabs.DECADE_TAB_ITEM));


    public static final DeferredItem<Item> ICHIGO_CRAD = ITEMS.register("ichigo_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","decade","decadriver_belt",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
						new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
						new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("ichigo").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> NIGO_CRAD = ITEMS.register("nigo_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","decade","decadriver_belt",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
						new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
						new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("nigo").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> V3_CRAD = ITEMS.register("v3_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","decade","decadriver_belt",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
						new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
	            		new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
						new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("v3").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> RIDERMAN_CRAD = ITEMS.register("riderman_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","decade","decadriver_belt",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
						new MobEffectInstance(MobEffects.REGENERATION,200, 0,true,false),
	            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("riderman").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> X_CRAD = ITEMS.register("x_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","decade","decadriver_belt",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
						new MobEffectInstance(MobEffects.REGENERATION,200, 0,true,false),
	            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
						new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("x").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> AMAZON_CRAD = ITEMS.register("amazon_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","decade","decadriver_belt",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
						new MobEffectInstance(MobEffects.REGENERATION,200, 1,true,false),
	            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
						new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("amazon").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> STRONGER_CRAD = ITEMS.register("stronger_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","decade","decadriver_belt",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
						new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 1,true,false),
	            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
						new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("stronger").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> SKYRIDER_CRAD = ITEMS.register("skyrider_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","decade","decadriver_belt",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
						new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
	            		new MobEffectInstance(MobEffects.JUMP, 40, 5,true,false),
						new MobEffectInstance(Effect_core.FLYING, 40, 4,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("skyrider").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> SUPER_1_CRAD = ITEMS.register("super_1_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","decade","decadriver_belt",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
						new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 1,true,false),
	            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
						new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("super_1").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> ZX_CRAD = ITEMS.register("zx_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","decade","decadriver_belt",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
						new MobEffectInstance(MobEffects.REGENERATION,200, 0,true,false),
	            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
						new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("zx").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> BLACK_CRAD = ITEMS.register("black_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","decade","decadriver_belt",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
						new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false),
	            		new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
						new MobEffectInstance(Effect_core.PUNCH, 40, 1,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("black").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> BLACK_RX_CRAD = ITEMS.register("black_rx_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","decade","decadriver_belt",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
						new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false),
	            		new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
						new MobEffectInstance(Effect_core.PUNCH, 40, 1,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("black_rx").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> SHIN_CRAD = ITEMS.register("shin_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","decade","decadriver_belt",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
						new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false),
	            		new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
						new MobEffectInstance(Effect_core.PUNCH, 40, 1,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("shin").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> ZO_CRAD = ITEMS.register("zo_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","decade","decadriver_belt",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
						new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false),
	            		new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
						new MobEffectInstance(Effect_core.PUNCH, 40, 1,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("zo").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> J_CRAD = ITEMS.register("j_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","decade","decadriver_belt",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
						new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false),
	            		new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
						new MobEffectInstance(Effect_core.PUNCH, 40, 1,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("j").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> BLACK_RX_ROBORIDER_CRAD = ITEMS.register("black_rx_roborider_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_robo","decade","decadriver_belt",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
						new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false),
	            		new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
						new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("black_rx").AddToList(RiderTabs.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> BLACK_RX_BIORIDER_CRAD = ITEMS.register("black_rx_biorider_card",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_bio","decade","decadriver_belt",
	            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
						new MobEffectInstance(MobEffects.WATER_BREATHING,40, 0,true,false),
	            		new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 40, 1,true,false),
						new MobEffectInstance(Effect_core.PUNCH, 40, 1,true,false))
            .AddCompatibilityList(BaseDecadeUsers).ChangeRiderName("black_rx").AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> KUUGA_ULTIMATE_CARD = ITEMS.register("kuuga_ultimate_card",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> AGITO_SHINING_CARD = ITEMS.register("agito_shining_card",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> RYUKI_SURVIVE_CARD = ITEMS.register("ryuki_survive_card",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> FAIZ_BLASTER_CARD = ITEMS.register("faiz_blaster_card",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> BLADE_KING_CARD = ITEMS.register("blade_king_card",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> ARMED_HIBIKI_CARD = ITEMS.register("armed_hibiki_card",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> KABUTO_HYPER_CARD = ITEMS.register("kabuto_hyper_card",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> DEN_O_LINER_CARD = ITEMS.register("den_o_liner_card",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> KIVA_EMPEROR_CARD = ITEMS.register("kiva_emperor_card",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> G4_CARD = ITEMS.register("g4_card",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> RYUGA_CARD = ITEMS.register("ryuga_card",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> ORGA_CARD = ITEMS.register("orga_card",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> GLAIVE_CARD = ITEMS.register("glaive_card",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> KABUKI_CARD = ITEMS.register("kabuki_card",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> CAUCASUS_CARD = ITEMS.register("caucasus_card",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> ARC_CARD = ITEMS.register("arc_card",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> SKULL_CARD = ITEMS.register("skull_card",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.DECADE_TAB_ITEM));



	public static final DeferredItem<Item> DECADEHELMET = ITEMS.register("decadehead",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.DECADE_TAB_ITEM).ChangeRepairItem(BLANK_CRAD.get()));
	public static final DeferredItem<Item> DECADECHESTPLATE = ITEMS.register("decadetroso",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.DECADE_TAB_ITEM).ChangeRepairItem(BLANK_CRAD.get()));
	public static final DeferredItem<Item> DECADELEGGINGS = ITEMS.register("decadelegs",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.DECADE_TAB_ITEM).ChangeRepairItem(BLANK_CRAD.get()));

	public static final DeferredItem<Item> DECADRIVER = ITEMS.register("decadriver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"decade",DECADE_CRAD ,DECADEHELMET, DECADECHESTPLATE,DECADELEGGINGS , new Item.Properties())
			.AddToTabList(RiderTabs.DECADE_TAB_ITEM).ChangeRepairItem(BLANK_CRAD.get()));
	public static final DeferredItem<Item> DIEND_BELT= ITEMS.register("diend_belt",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"diend",DIEND_CRAD ,DECADEHELMET, DECADECHESTPLATE,DECADELEGGINGS , new Item.Properties())
			.AddToTabList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> DARK_DECADRIVER = ITEMS.register("dark_decadriver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"dark_decade",DARK_DECADE_CRAD ,DECADEHELMET, DECADECHESTPLATE,DECADELEGGINGS , new Item.Properties())
			.Override_belt_text("dark_decadriver_belt").AddToTabList(RiderTabs.DECADE_TAB_ITEM).ChangeRepairItem(BLANK_CRAD.get()));

	public static final DeferredItem<Item> RIDE_BOOKER = ITEMS.register("ride_booker",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).IsSwordGun().AddToTabList(RiderTabs.DECADE_TAB_ITEM)
			.ChangeRepairItem(BLANK_CRAD.get()));
    public static final DeferredItem<Item> DIENDRIVER = ITEMS.register("diendriver",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).IsHenshinItem(DIEND_BELT.get()).AddToTabList(RiderTabs.DECADE_TAB_ITEM).ChangeRepairItem(BLANK_CRAD.get()));
    public static final DeferredItem<Item> ONGEKIBO_REKKA_DECADE = ITEMS.register("ongekibo_rekka_decade",
            () -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.DECADE_TAB_ITEM).ChangeRepairItem(BLANK_CRAD.get()));
    public static final DeferredItem<Item> ONGEKIBO_REKKA_DIEND = ITEMS.register("ongekibo_rekka_diend",
            () -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.DECADE_TAB_ITEM).ChangeRepairItem(BLANK_CRAD.get()));
    public static final DeferredItem<Item> ONGEKIKANABO_OUJA = ITEMS.register("ongekikanabo_ouja",
            () -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.DECADE_TAB_ITEM).ChangeRepairItem(Ryuki_Rider_Items.ADVENT_CARD.get()));
    public static final DeferredItem<Item> DECADE_BAZOOKA = ITEMS.register("decade_bazooka",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.DECADE_TAB_ITEM).ChangeRepairItem(BLANK_CRAD.get()));

    public static final DeferredItem<Item> DECADE_BLAST_CARD = ITEMS.register("decade_blast_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"decade","decade_complete","decade_violent_emotion","decade_cyan","dark_decade"}, new MobEffectInstance(Effect_core.SHOT_BOOST, 300,2,true,false)).AddToList(RiderTabs.DECADE_TAB_ITEM));
    public static final DeferredItem<Item>DECADE_SLASH_CARD = ITEMS.register("decade_slash_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"decade","decade_complete","decade_violent_emotion","decade_cyan","dark_decade"}, new MobEffectInstance(Effect_core.SLASH, 300,2,true,false)).AddToList(RiderTabs.DECADE_TAB_ITEM));
    public static final DeferredItem<Item> DECADE_ILLUSION_CARD = ITEMS.register("decade_illusion_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"decade","decade_complete","decade_violent_emotion","decade_cyan","dark_decade"}, "illusion").AddToList(RiderTabs.DECADE_TAB_ITEM));
    public static final DeferredItem<Item> DECADE_INVISIBLE_CARD = ITEMS.register("decade_invisible_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"decade","decade_complete","decade_violent_emotion","decade_cyan","dark_decade"}, new MobEffectInstance(MobEffects.INVISIBILITY, 300,0,true,false)).AddToList(RiderTabs.DECADE_TAB_ITEM));
    public static final DeferredItem<Item> DIEND_BLAST_CARD = ITEMS.register("diend_blast_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"diend","diend_green"}, new MobEffectInstance(Effect_core.SHOT_BOOST, 300,2,true,false)).AddToList(RiderTabs.DECADE_TAB_ITEM));
    public static final DeferredItem<Item> DIEND_INVISIBLE_CARD = ITEMS.register("diend_invisible_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"diend","diend_green"}, new MobEffectInstance(MobEffects.INVISIBILITY, 300,0,true,false)).AddToList(RiderTabs.DECADE_TAB_ITEM));
    public static final DeferredItem<Item> DIEND_CROSSATTACK_CARD = ITEMS.register("diend_crossattack_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"diend","diend_green"}, "crossattack").AddToList(RiderTabs.DECADE_TAB_ITEM));
    public static final DeferredItem<Item> DIEND_BARRIER_CARD = ITEMS.register("diend_barrier_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"diend","diend_green"}, "barrier").AddToList(RiderTabs.DECADE_TAB_ITEM));
    public static final DeferredItem<Item> DIEND_ILLUSION_CARD = ITEMS.register("diend_illusion_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"diend","diend_green"}, "diend_illusion").AddToList(RiderTabs.DECADE_TAB_ITEM));
    //public static final DeferredItem<Item> REKKA_DAIZANTOU_CARD = ITEMS.register("rekka_daizantou_card",
	//		() -> new AttackRideCardItem(new Item.Properties(), new String[]{"decade","decade_complete","decade_violent_emotion","decade_cyan"}, ForgeRegistries.ITEMS.getValue(new ResourceLocation("supersentaicraft:rekka_daizantou")), 30).AddToTabList(RiderTabs.DECADE_TAB_ITEM));
    public static final DeferredItem<Item> G4_GIGANT_CARD = ITEMS.register("g4_gigant_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"decade_violent_emotion"}, Agito_Rider_Items.G4_GIGANT.get()).AddToList(RiderTabs.DECADE_TAB_ITEM));
    public static final DeferredItem<Item> RYUKI_STRIKE_VENT_CARD = ITEMS.register("ryuki_strike_vent_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"ryuki","decade_violent_emotion"}, Ryuki_Rider_Items.DRAG_CLAW.get()).AddToList(RiderTabs.DECADE_TAB_ITEM));
    public static final DeferredItem<Item> BLADE_METAL_CARD = ITEMS.register("blade_metal_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"blade","decade_violent_emotion"}, new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 300,1,true,false)).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> BLADE_MACH_CARD = ITEMS.register("blade_mach_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"blade","decade_violent_emotion"},
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300,3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 300,3,true,false)).AddToList(RiderTabs.DECADE_TAB_ITEM));
    public static final DeferredItem<Item> HIBIKI_ONGEKIBOU_REKKA_CARD = ITEMS.register("hibiki_ongekibou_rekka_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"hibiki","decade_violent_emotion"}, Hibiki_Rider_Items.ONGEKIBO_REKKA.get()).AddToList(RiderTabs.DECADE_TAB_ITEM));
    public static final DeferredItem<Item> HIBIKI_ONIBI_CARD = ITEMS.register("hibiki_onibi_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"hibiki","decade_violent_emotion"}, "onibi").AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> KABUTO_CLOCK_UP_CARD = ITEMS.register("kabuto_clock_up_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"kabuto","decade_violent_emotion"}, new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 250,20,true,false)).AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> DEN_O_ORE_SANJOU_CARD = ITEMS.register("den_o_ore_sanjou_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"den_o","den_o_rod","den_o_axe","den_o_gun","den_o_wing","den_o_climax","decade_violent_emotion"}, "ore_sanjou").AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> DEN_O_BOKU_NI_TSURARETE_MIRU_CARD = ITEMS.register("den_o_bokuni_tsurarete_miru_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"den_o","den_o_rod","den_o_axe","den_o_gun","den_o_wing","den_o_climax","decade_violent_emotion"}, "bokuni_tsurarete_miru").AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> DEN_O_NAKERUDE_CARD = ITEMS.register("den_o_nakerude_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"den_o","den_o_rod","den_o_axe","den_o_gun","den_o_wing","den_o_climax","decade_violent_emotion"}, "nakerude").AddToList(RiderTabs.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> DEN_O_KOTAE_WA_KIITENAI_CARD = ITEMS.register("den_o_kotaewa_kiite_nai_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"den_o","den_o_rod","den_o_axe","den_o_gun","den_o_wing","den_o_climax","decade_violent_emotion"}, "kotaewa_kiite_nai").AddToList(RiderTabs.DECADE_TAB_ITEM));
    public static final DeferredItem<Item> DEN_O_TSUPPARI_CARD = ITEMS.register("den_o_tsuppari_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"den_o_axe","decade_violent_emotion"}, new MobEffectInstance(Effect_core.PUNCH, 300,1,true,false)).AddToList(RiderTabs.DECADE_TAB_ITEM));
    public static final DeferredItem<Item> DEN_O_UTCHARI_CARD = ITEMS.register("den_o_utchari_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"den_o_axe","decade_violent_emotion"},
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300,2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 300,3,true,false)).AddToList(RiderTabs.DECADE_TAB_ITEM));
    public static final DeferredItem<Item> AMAZON_GAGA_NO_UDEWA_CARD = ITEMS.register("amazon_gaga_no_udewa_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"amazon","decade_complete","decade_violent_emotion"}, Ichigo_Rider_Items.GAGA_ARMLET.get()).AddToList(RiderTabs.DECADE_TAB_ITEM));

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}

}