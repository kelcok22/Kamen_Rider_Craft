package com.kelco.kamenridercraft.item;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.block.machineBlocks.SwordOfLogosBookAnalyzer;
import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.item.BaseItems.*;
import com.kelco.kamenridercraft.item.saber.*;
import com.kelco.kamenridercraft.item.tabs.RiderTabs;
import com.kelco.kamenridercraft.world.inventory.HissatsuHolderGuiMenu;
import io.netty.buffer.Unpooled;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemContainerContents;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Saber_Rider_Items {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);



	public static final DeferredItem<Item> SABER_LOGO = ITEMS.register("saber_logo",
			() -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/saber")), new Item.Properties()).AddToList(RiderTabs.SABER_TAB_ITEM));

	public static final DeferredItem<Item> BLANK_WONDER_RIDE_BOOK = ITEMS.register("blank_wonder_ride_book",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.SABER_TAB_ITEM));

	public static final DeferredItem<Item> BLANK_WONDER_WORLD_STORY_WONDER_RIDE_BOOK = ITEMS.register("blank_wonder_world_story_wonder_ride_book",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.SABER_TAB_ITEM));



	public static final DeferredItem<Item> SABER_BLANK_1 = ITEMS.register("saber_blank_1",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"blank","saber","seiken_swordriver_belt")
					.model_has_different_name("blank_wonder_ride_book").has_basic_model());

	public static final DeferredItem<Item> SABER_BLANK_2 = ITEMS.register("saber_blank_2",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"blank","saber","seiken_swordriver_belt")
					.model_has_different_name("blank_wonder_ride_book").has_basic_model());

	public static final DeferredItem<Item> SABER_BLANK_3 = ITEMS.register("saber_blank_3",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"blank","saber","seiken_swordriver_belt")
					.model_has_different_name("blank_wonder_ride_book").has_basic_model());


	public static final DeferredItem<Item> BRAVE_DRAGON_WONDER_RIDE_BOOK_XROSS = ITEMS.register("brave_dragon_wonder_ride_book_xross",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"xross_brave_dragon","saber","seiken_swordriver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 5,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false))
					.AddNum(3).ResetFormToBase());

	public static final DeferredItem<Item> BRAVE_DRAGON_WONDER_RIDE_BOOK = ITEMS.register("brave_dragon_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"brave_dragon","saber","seiken_swordriver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false))
					.ResetFormToBaseIfMain().AddCompatibilityList(new String[] {"blades","espada"}).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.BLANK_BOOK, 30));

	public static final DeferredItem<Item> STORM_EAGLE_WONDER_RIDE_BOOK_XROSS = ITEMS.register("storm_eagle_wonder_ride_book_xross",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"xross_storm_eagle","saber","seiken_swordriver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)
					,new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false)).ChangeSlot(2));

	public static final DeferredItem<Item> STORM_EAGLE_WONDER_RIDE_BOOK = ITEMS.register("storm_eagle_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"storm_eagle","saber","seiken_swordriver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)
					,new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false))
					.AddIncompatibleForm(BRAVE_DRAGON_WONDER_RIDE_BOOK_XROSS.asItem()).addAlternative(STORM_EAGLE_WONDER_RIDE_BOOK_XROSS.get())
					.AddCompatibilityList(new String[] {"espada"}).ChangeSlot(2).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.BLANK_BOOK, 15));

	public static final DeferredItem<Item> SAIYUU_JOURNEY_WONDER_RIDE_BOOK_XROSS = ITEMS.register("saiyuu_journey_wonder_ride_book_xross",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"xross_saiyuu_journey","saber","seiken_swordriver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 6,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false)).ChangeSlot(3));

	public static final DeferredItem<Item> SAIYUU_JOURNEY_WONDER_RIDE_BOOK = ITEMS.register("saiyuu_journey_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"saiyuu_journey","saber","seiken_swordriver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
					.AddIncompatibleForm(BRAVE_DRAGON_WONDER_RIDE_BOOK_XROSS.asItem()).addAlternative(SAIYUU_JOURNEY_WONDER_RIDE_BOOK_XROSS.get())
					.AddCompatibilityList(new String[] {"blades"}).ChangeSlot(3).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.BLANK_BOOK, 5));

	public static final DeferredItem<Item> TENKUU_NO_PEGASUS_WONDER_RIDE_BOOK = ITEMS.register("tenkuu_no_pegasus_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"tenkuu_no_pegasus","blades","seiken_swordriver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false))
					.AddCompatibilityList(new String[] {"blades","espada"}).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.BLANK_BOOK, 5));

	public static final DeferredItem<Item> LION_SENKI_WONDER_RIDE_BOOK_XROSS = ITEMS.register("lion_senki_wonder_ride_book_xross",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"xross_lion_senki","saber","seiken_swordriver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 4,true,false)).ChangeSlot(2));

	public static final DeferredItem<Item> LION_SENKI_WONDER_RIDE_BOOK = ITEMS.register("lion_senki_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"lion_senki","blades","seiken_swordriver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false))
					.AddIncompatibleForm(BRAVE_DRAGON_WONDER_RIDE_BOOK_XROSS.asItem()).addAlternative(LION_SENKI_WONDER_RIDE_BOOK_XROSS.get())
					.ResetFormToBaseIfMain().AddCompatibilityList(new String[] {"saber","espada"}).ChangeSlot(2).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.BLANK_BOOK, 25));

	public static final DeferredItem<Item> PETER_FANTASISTA_WONDER_RIDE_BOOK = ITEMS.register("peter_fantasista_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"peter_fantasista","saber","seiken_swordriver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false))
					.AddCompatibilityList(new String[] {"blades"}).ChangeSlot(3).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.BLANK_BOOK, 15));

	public static final DeferredItem<Item> TRI_CERBERUS_WONDER_RIDE_BOOK = ITEMS.register("tri_cerberus_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"tri_cerberus","blades","seiken_swordriver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false))
					.AddCompatibilityList(new String[] {"espada"}).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.BLANK_BOOK, 5));

	public static final DeferredItem<Item> NEEDLE_HEDGEHOG_WONDER_RIDE_BOOK = ITEMS.register("needle_hedgehog_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"needle_hedgehog","saber","seiken_swordriver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false))
					.AddCompatibilityList(new String[] {"espada"}).ChangeSlot(2).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.BLANK_BOOK, 15));

	public static final DeferredItem<Item> LAMP_DO_ALNGINA_WONDER_RIDE_BOOK_XROSS = ITEMS.register("lamp_do_alngina_wonder_ride_book_xross",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"xross_lamp_do_alngina","saber","seiken_swordriver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 4,true,false)).ChangeSlot(3));

	public static final DeferredItem<Item> LAMP_DO_ALNGINA_WONDER_RIDE_BOOK = ITEMS.register("lamp_do_alngina_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"lamp_do_alngina","espada","seiken_swordriver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false))
					.AddIncompatibleForm(BRAVE_DRAGON_WONDER_RIDE_BOOK_XROSS.asItem()).addAlternative(LAMP_DO_ALNGINA_WONDER_RIDE_BOOK_XROSS.get())
					.ResetFormToBaseIfMain().AddCompatibilityList(new String[] {"blades","saber"}).ChangeSlot(3).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.BLANK_BOOK, 25));

	public static final DeferredItem<Item> GENBU_SHINWA_WONDER_RIDE_BOOK_BUSTER = ITEMS.register("genbu_shinwa_wonder_ride_book_buster",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","buster","sword_of_logos_buckle_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false))
					.model_has_different_name("genbu_shinwa_wonder_ride_book").has_basic_model());

	public static final DeferredItem<Item> GENBU_SHINWA_WONDER_RIDE_BOOK = ITEMS.register("genbu_shinwa_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"genbu_shinwa","blades","seiken_swordriver_belt"
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false))
					.addAlternative(GENBU_SHINWA_WONDER_RIDE_BOOK_BUSTER.get()).AddCompatibilityList(new String[] {"espada"}).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.BLANK_BOOK, 10));

	public static final DeferredItem<Item> JACKUN_TO_DOMAMENOKI_WONDER_RIDE_BOOK_KENZAN = ITEMS.register("jackun_to_domamenoki_wonder_ride_book_kenzan",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_jackun","kenzan","sword_of_logos_buckle_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false))
					.model_has_different_name("jackun_to_domamenoki_wonder_ride_book").has_basic_model());

	public static final DeferredItem<Item> JACKUN_TO_DOMAMENOKI_WONDER_RIDE_BOOK_BUSTER = ITEMS.register("jackun_to_domamenoki_wonder_ride_book_buster",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_jackun","buster","sword_of_logos_buckle_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false))
					.addAlternative(JACKUN_TO_DOMAMENOKI_WONDER_RIDE_BOOK_KENZAN.get())
					.model_has_different_name("jackun_to_domamenoki_wonder_ride_book").has_basic_model());

	public static final DeferredItem<Item> JACKUN_TO_DOMAMENOKI_WONDER_RIDE_BOOK = ITEMS.register("jackun_to_domamenoki_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"jackun_to_domamenoki","saber","seiken_swordriver_belt"
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false))
					.addAlternative(JACKUN_TO_DOMAMENOKI_WONDER_RIDE_BOOK_BUSTER.get()).AddCompatibilityList(new String[] {"blades"}).ChangeSlot(3).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.BLANK_BOOK, 15));

	public static final DeferredItem<Item> SARUTOBI_NINJADEN_WONDER_RIDE_BOOK_KENZAN = ITEMS.register("sarutobi_ninjaden_wonder_ride_book_kenzan",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","kenzan","sword_of_logos_buckle_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false))
					.model_has_different_name("sarutobi_ninjaden_wonder_ride_book").has_basic_model());

	public static final DeferredItem<Item> SARUTOBI_NINJADEN_WONDER_RIDE_BOOK = ITEMS.register("sarutobi_ninjaden_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"sarutobi_ninjaden","saber","seiken_swordriver_belt"
					,new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false))
					.addAlternative(SARUTOBI_NINJADEN_WONDER_RIDE_BOOK_KENZAN.get()).AddCompatibilityList(new String[] {"blades"}).ChangeSlot(3).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.BLANK_BOOK, 10));

	public static final DeferredItem<Item> KOBUTA_3KYOUDAI_WONDER_RIDE_BOOK_SLASH = ITEMS.register("kobuta_3_kyoudai_wonder_ride_book_slash",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_kobuta_3_kyoudai","slash","sword_of_logos_buckle_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false))
					.model_has_different_name("kobuta_3_kyoudai_wonder_ride_book").has_basic_model());

	public static final DeferredItem<Item> KOBUTA_3KYOUDAI_WONDER_RIDE_BOOK_KENZAN = ITEMS.register("kobuta_3_kyoudai_wonder_ride_book_kenzan",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_kobuta_3_kyoudai","kenzan","sword_of_logos_buckle_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false))
					.addAlternative(KOBUTA_3KYOUDAI_WONDER_RIDE_BOOK_SLASH.get())
					.model_has_different_name("kobuta_3_kyoudai_wonder_ride_book").has_basic_model());

	public static final DeferredItem<Item> KOBUTA_3KYOUDAI_WONDER_RIDE_BOOK = ITEMS.register("kobuta_3_kyoudai_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"kobuta_3_kyoudai","saber","seiken_swordriver_belt"
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false))
					.addAlternative(KOBUTA_3KYOUDAI_WONDER_RIDE_BOOK_KENZAN.get()).AddCompatibilityList(new String[] {"blades"}).ChangeSlot(3).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.BLANK_BOOK, 15));

	public static final DeferredItem<Item> HANSELNUTS_TO_GRETEL_WONDER_RIDE_BOOK_SLASH = ITEMS.register("hanselnuts_to_gretel_wonder_ride_book_slash",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","slash","sword_of_logos_buckle_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false))
					.model_has_different_name("hanselnuts_to_gretel_wonder_ride_book").has_basic_model());

	public static final DeferredItem<Item> HANSELNUTS_TO_GRETEL_WONDER_RIDE_BOOK = ITEMS.register("hanselnuts_to_gretel_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"hanselnuts_to_gretel","saber","seiken_swordriver_belt"
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false))
					.addAlternative(HANSELNUTS_TO_GRETEL_WONDER_RIDE_BOOK_SLASH.get()).AddCompatibilityList(new String[] {"blades"})
					.ChangeSlot(3).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.BLANK_BOOK, 10));

	public static final DeferredItem<Item> BREMEN_NO_ROCK_BAND_WONDER_RIDE_BOOK_BUSTER = ITEMS.register("bremen_no_rock_band_wonder_ride_book_buster",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_bremen_no_rock_band","buster","sword_of_logos_buckle_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 4,true,false))
					.model_has_different_name("bremen_no_rock_band_wonder_ride_book").has_basic_model());

	public static final DeferredItem<Item> BREMEN_NO_ROCK_BAND_WONDER_RIDE_BOOK_SLASH = ITEMS.register("bremen_no_rock_band_wonder_ride_book_slash",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_bremen_no_rock_band","slash","sword_of_logos_buckle_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 4,true,false)
					,new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false))
					.addAlternative(BREMEN_NO_ROCK_BAND_WONDER_RIDE_BOOK_BUSTER.get())
					.model_has_different_name("bremen_no_rock_band_wonder_ride_book").has_basic_model());

	public static final DeferredItem<Item> BREMEN_NO_ROCK_BAND_WONDER_RIDE_BOOK = ITEMS.register("bremen_no_rock_band_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"bremen_no_rock_band","saber","seiken_swordriver_belt"
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 4,true,false))
					.addAlternative(BREMEN_NO_ROCK_BAND_WONDER_RIDE_BOOK_SLASH.get()).AddCompatibilityList(new String[] {"blades"}).ChangeSlot(3).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.BLANK_BOOK, 15));

	public static final DeferredItem<Item> JAAKU_DRAGON_WONDER_RIDE_BOOK_CALIBUR = ITEMS.register("jaaku_dragon_wonder_ride_book_calibur",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","calibur","jaken_caliburdriver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false))
					.model_has_different_name("jaaku_dragon_wonder_ride_book").has_basic_model());

	public static final DeferredItem<Item> JAAKU_DRAGON_WONDER_RIDE_BOOK = ITEMS.register("jaaku_dragon_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"jaaku_dragon","blades","seiken_swordriver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false))
					.addAlternative(JAAKU_DRAGON_WONDER_RIDE_BOOK_CALIBUR.get()).AddCompatibilityList(new String[] {"espada"}).AddToList(RiderTabs.SABER_TAB_ITEM));

	public static final DeferredItem<Item> JAOU_DRAGON_WONDER_RIDE_BOOK = ITEMS.register("jaou_dragon_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_jaou_dragon","calibur","jaken_caliburdriver_belt_j"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false)).AddToList(RiderTabs.SABER_TAB_ITEM));

	public static final DeferredItem<Item> KIN_NO_BUKI_GIN_NO_BUKI_WONDER_RIDE_BOOK_SHADOW = ITEMS.register("kin_no_buki_gin_no_buki_wonder_ride_book_shadow",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","saikou","seiken_saikou_driver_belt_saikou"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.REGENERATION, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false))
					.model_has_different_name("kin_no_buki_gin_no_buki_wonder_ride_book").has_basic_model());

	public static final DeferredItem<Item> KIN_NO_BUKI_GIN_NO_BUKI_WONDER_RIDE_BOOK = ITEMS.register("kin_no_buki_gin_no_buki_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"","saikou","seiken_saikou_driver_belt_saikou"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.REGENERATION, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.INVISIBILITY, 2, 0,true,false))
					.addSwitchForm(KIN_NO_BUKI_GIN_NO_BUKI_WONDER_RIDE_BOOK_SHADOW.get()).AddToList(RiderTabs.SABER_TAB_ITEM)
					.AddToList(SwordOfLogosBookAnalyzer.BLANK_BOOK, 3));

	public static final DeferredItem<Item> X_SWORDMAN_WONDER_RIDE_BOOK_COLORFUL = ITEMS.register("x_swordman_wonder_ride_book_colorful",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_x_swordman","saikou","seiken_saikou_driver_belt_x"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.REGENERATION, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false))
					.model_has_different_name("x_swordman_wonder_ride_book").has_basic_model());

	public static final DeferredItem<Item> X_SWORDMAN_WONDER_RIDE_BOOK_POWERFUL = ITEMS.register("x_swordman_wonder_ride_book_powerful",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_x_swordman_powerful","saikou","seiken_saikou_driver_belt_p"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.REGENERATION, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false))
					.addNeedForm(X_SWORDMAN_WONDER_RIDE_BOOK_COLORFUL.get(), 1).addAlternative(X_SWORDMAN_WONDER_RIDE_BOOK_COLORFUL.get())
					.model_has_different_name("x_swordman_wonder_ride_book").has_basic_model());

	public static final DeferredItem<Item> X_SWORDMAN_WONDER_RIDE_BOOK = ITEMS.register("x_swordman_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_x_swordman_wonderful","saikou","seiken_saikou_driver_belt_w"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.REGENERATION, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false))
					.addNeedForm(X_SWORDMAN_WONDER_RIDE_BOOK_POWERFUL.get(), 1).addAlternative(X_SWORDMAN_WONDER_RIDE_BOOK_POWERFUL.get()).AddToList(RiderTabs.SABER_TAB_ITEM));

	public static final DeferredItem<Item> KONCHUU_DAIHYAKKA_WONDER_RIDE_BOOK = ITEMS.register("konchuu_daihyakka_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","sabela","royal_sword_of_logos_buckle_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)).AddToList(RiderTabs.SABER_TAB_ITEM));

	public static final DeferredItem<Item> OCEAN_HISTORY_WONDER_RIDE_BOOK = ITEMS.register("ocean_history_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","durendal","royal_sword_of_logos_buckle_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)).AddToList(RiderTabs.SABER_TAB_ITEM));

	public static final DeferredItem<Item> OMNI_FORCE_WONDER_RIDE_BOOK = ITEMS.register("omni_force_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"","solomon","dooms_driver_buckle_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 5,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 5,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 5,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)).AddToList(RiderTabs.SABER_TAB_ITEM));

	public static final DeferredItem<Item> GRIMOIRE_WONDER_RIDE_BOOK = ITEMS.register("grimoire_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"","storious","dooms_driver_buckle_belt_storious"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 7,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 6,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 6,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false)).AddToList(RiderTabs.SABER_TAB_ITEM));

	public static final DeferredItem<Item> TASSEL_DARK_WONDER_RIDE_BOOK = ITEMS.register("tassel_dark_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","tassel","haken_bladriver_belt_tassel"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 7,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 6,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 6,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false)).AddToList(RiderTabs.SABER_TAB_ITEM));

	public static final DeferredItem<Item> ETERNAL_PHOENIX_WONDER_RIDE_BOOK_FALCHION = ITEMS.register("eternal_phoenix_wonder_ride_book_falchion",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","falchion","haken_bladriver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.REGENERATION, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)
					,new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false))
					.model_has_different_name("eternal_phoenix_wonder_ride_book").has_basic_model());

	public static final DeferredItem<Item> ETERNAL_PHOENIX_WONDER_RIDE_BOOK = ITEMS.register("eternal_phoenix_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"eternal_phoenix","blades","seiken_swordriver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.REGENERATION, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)
					,new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false))
					.addAlternative(ETERNAL_PHOENIX_WONDER_RIDE_BOOK_FALCHION.get()).AddCompatibilityList(new String[] {"espada"}).AddToList(RiderTabs.SABER_TAB_ITEM));

	public static final DeferredItem<Item> AMAZING_SIREN_WONDER_RIDE_BOOK = ITEMS.register("amazing_siren_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_amazing_siren","falchion","haken_bladriver_belt_s"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 6,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.REGENERATION, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)
					,new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false)).AddToList(RiderTabs.SABER_TAB_ITEM));

	public static final DeferredItem<Item> KIRIN_NO_ONGAESHI_WONDER_RIDE_BOOK = ITEMS.register("kirin_no_ongaeshi_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"kirin_no_ongaeshi","saber","seiken_swordriver_belt"
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false))
					.AddCompatibilityList(new String[] {"blades"}).ChangeSlot(3).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.BLANK_BOOK, 5));

	public static final DeferredItem<Item> SARUKANI_WARS_WONDER_RIDE_BOOK = ITEMS.register("sarukani_wars_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"sarukani_wars","saber","seiken_swordriver_belt"
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false))
					.AddCompatibilityList(new String[] {"blades"}).ChangeSlot(3).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.BLANK_BOOK, 5));

	public static final DeferredItem<Item> BAKUSOU_USAGI_TO_KAME_WONDER_RIDE_BOOK = ITEMS.register("bakusou_usagi_to_kame_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"bakusou_usagi_to_kame","saber","seiken_swordriver_belt"
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 5,true,false))
					.AddCompatibilityList(new String[] {"blades"}).ChangeSlot(3).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.BLANK_BOOK, 5));

	public static final DeferredItem<Item> HOUSHIN_KAMEN_ENGI_WONDER_RIDE_BOOK = ITEMS.register("houshin_kamen_engi_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"houshin_kamen_engi","saber","seiken_swordriver_belt"
					,new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false))
					.AddCompatibilityList(new String[] {"blades"}).ChangeSlot(3).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.BLANK_BOOK, 5));

	public static final DeferredItem<Item> TSUKI_NO_HIME_KAGUYAN_WONDER_RIDE_BOOK = ITEMS.register("tsuki_no_hime_kaguyan_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"tsuki_no_hime_kaguyan","saber","seiken_swordriver_belt"
					,new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false))
					.AddCompatibilityList(new String[] {"blades"}).ChangeSlot(3).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.BLANK_BOOK, 5));

	public static final DeferredItem<Item> OSHA_JIZOU_SAN_WONDER_RIDE_BOOK = ITEMS.register("osha_jizou_san_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"osha_jizou_san","saber","seiken_swordriver_belt"
					,new MobEffectInstance(MobEffects.SATURATION, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.LUCK, 40, 2,true,false))
					.AddCompatibilityList(new String[] {"blades"}).ChangeSlot(3).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.BLANK_BOOK, 5));

	public static final DeferredItem<Item> ISSUN_BUSHI_WONDER_RIDE_BOOK = ITEMS.register("issun_bushi_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"issun_bushi","saber","seiken_swordriver_belt"
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 4,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false))
					.AddCompatibilityList(new String[] {"blades"}).ChangeSlot(3).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.BLANK_BOOK, 5));

	public static final DeferredItem<Item> DAISHOUGUN_MOMOICHIROU_WONDER_RIDE_BOOK = ITEMS.register("daishougun_momoichirou_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"daishougun_momoichirou","saber","seiken_swordriver_belt"
					,new MobEffectInstance(MobEffects.SATURATION, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false))
					.AddCompatibilityList(new String[] {"blades"}).ChangeSlot(3).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.BLANK_BOOK, 5));

	public static final DeferredItem<Item> DAIKENGOU_URASHIMAJIROU_WONDER_RIDE_BOOK = ITEMS.register("daikengou_urashimajirou_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"daikengou_urashimajirou","saber","seiken_swordriver_belt"
					,new MobEffectInstance(MobEffects.SATURATION, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false))
					.AddCompatibilityList(new String[] {"blades"}).ChangeSlot(3).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.BLANK_BOOK, 5));

	public static final DeferredItem<Item> DAIYOKOZUNA_KINZABUROU_WONDER_RIDE_BOOK = ITEMS.register("daiyokozuna_kinzaburou_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"daiyokozuna_kinzaburou","saber","seiken_swordriver_belt"
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false))
					.AddCompatibilityList(new String[] {"blades"}).ChangeSlot(3).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.BLANK_BOOK, 5));

	public static final DeferredItem<Item> KING_OF_ARTHUR_WONDER_RIDE_BOOK = ITEMS.register("king_of_arthur_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"king_of_arthur","saber","seiken_swordriver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false))
					.AddCompatibilityList(new String[] {"blades"}).ChangeSlot(3).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.BLANK_BOOK, 3));

	public static final DeferredItem<Item> DRAGONIC_KNIGHT_WONDER_RIDE_BOOK = ITEMS.register("dragonic_knight_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"saber_dragonic_knight","saber","seiken_swordriver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false))
					.AddNum(2).ResetFormToBase().AddToList(RiderTabs.SABER_TAB_ITEM));

	public static final DeferredItem<Item> EMOTIONAL_DRAGON_WONDER_RIDE_BOOK = ITEMS.register("emotional_dragon_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"saber_emotional_dragon","saber","seiken_swordriver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 5,true,false)
					,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false))
					.AddNum(2).ResetFormToBase().AddToList(RiderTabs.SABER_TAB_ITEM));

	public static final DeferredItem<Item> PRIMITIVE_DRAGON_WONDER_RIDE_BOOK = ITEMS.register("primitive_dragon_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"saber_primitive_dragon","saber","seiken_swordriver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false)
					,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false))
					.AddNum(2).ResetFormToBase().AddToList(RiderTabs.SABER_TAB_ITEM));

	public static final DeferredItem<Item> ELEMENTAL_DRAGON_WONDER_RIDE_BOOK = ITEMS.register("elemental_dragon_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"saber_elemental_primitive_dragon","saber","seiken_swordriver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false))
					.addNeedForm(PRIMITIVE_DRAGON_WONDER_RIDE_BOOK.get(), 1).AddNum(2).ResetFormToBase().AddToList(RiderTabs.SABER_TAB_ITEM));

	public static final DeferredItem<Item> WONDER_ALMIGHTY_WONDER_RIDE_BOOK = ITEMS.register("wonder_almighty_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.EPIC),0,"saber_wonder_almighty","saber","seiken_swordriver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 6,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 6,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 5,true,false)
					,new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false))
					.AddNum(2).ResetFormToBase().AddToList(RiderTabs.SABER_TAB_ITEM));

	public static final DeferredItem<Item> SUPER_HERO_SENKI_WONDER_RIDE_BOOK = ITEMS.register("super_hero_senki_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"saber_super_hero_senki","saber","seiken_swordriver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 6,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 5,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false))
					.AddNum(2).ResetFormToBase().AddToList(RiderTabs.SABER_TAB_ITEM));

	public static final DeferredItem<Item> KING_LION_DAISENKI_WONDER_RIDE_BOOK = ITEMS.register("king_lion_daisenki_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"blades_king_lion_daisenki","blades","seiken_swordriver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false))
					.AddNum(2).ResetFormToBase().AddToList(RiderTabs.SABER_TAB_ITEM));

	public static final DeferredItem<Item> TATEGAMI_HYOUJUU_SENKI_WONDER_RIDE_BOOK = ITEMS.register("tategami_hyoujuu_senki_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"blades_tategami_hyoujuu_senki","blades","seiken_swordriver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false)
					,new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false))
					.AddNum(2).ResetFormToBase().AddToList(RiderTabs.SABER_TAB_ITEM));

	public static final DeferredItem<Item> ARABIANA_NIGHT_WONDER_RIDE_BOOK = ITEMS.register("arabiana_night_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"espada_arabiana_night","espada","seiken_swordriver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 6,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 6,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 5,true,false))
					.AddNum(2).ResetFormToBase().AddToList(RiderTabs.SABER_TAB_ITEM));

	public static final DeferredItem<Item> GAIKOTSU_NINJADEN_WONDER_RIDE_BOOK = ITEMS.register("gaikotsu_ninjaden_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"","desast","seiken_swordriver_belt_desast"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false)).AddToList(RiderTabs.SABER_TAB_ITEM));

	public static final DeferredItem<Item> TELEVI_KUN_WONDER_RIDE_BOOK = ITEMS.register("televi_kun_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"televi_kun","saber","seiken_swordriver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false))
					.AddCompatibilityList(new String[] {"blades"}).ChangeSlot(3).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.BLANK_BOOK));

	public static final DeferredItem<Item> ULTIMATE_BAHAMUT_WONDER_RIDE_BOOK = ITEMS.register("ultimate_bahamut_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"saber_ultimate_bahamut","saber","seiken_swordriver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 5,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 5,true,false))
					.AddNum(2).ResetFormToBase().AddToList(RiderTabs.SABER_TAB_ITEM));

	public static final DeferredItem<Item> WONDER_WORLD_STORY_OF_KAENKEN_REKKA_WONDER_RIDE_BOOK = ITEMS.register("wonder_world_story_of_kaenken_rekka_wonder_ride_book",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.WONDER_WORLD_BOOK));

	public static final DeferredItem<Item> WONDER_WORLD_STORY_OF_SUISEIKEN_NAGARE_WONDER_RIDE_BOOK = ITEMS.register("wonder_world_story_of_suiseiken_nagare_wonder_ride_book",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.WONDER_WORLD_BOOK));

	public static final DeferredItem<Item> WONDER_WORLD_STORY_OF_RAIMEIKEN_IKAZUCHI_WONDER_RIDE_BOOK = ITEMS.register("wonder_world_story_of_raimeiken_ikazuchi_wonder_ride_book",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.WONDER_WORLD_BOOK));

	public static final DeferredItem<Item> WONDER_WORLD_STORY_OF_ANKOKUKEN_KURAYAMI_WONDER_RIDE_BOOK = ITEMS.register("wonder_world_story_of_ankokuken_kurayami_wonder_ride_book",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.WONDER_WORLD_BOOK));

	public static final DeferredItem<Item> WONDER_WORLD_STORY_OF_DOGOUKEN_GEKIDO_WONDER_RIDE_BOOK = ITEMS.register("wonder_world_story_of_dogouken_gekido_wonder_ride_book",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.WONDER_WORLD_BOOK));

	public static final DeferredItem<Item> WONDER_WORLD_STORY_OF_FUUSOUKEN_HAYATE_WONDER_RIDE_BOOK = ITEMS.register("wonder_world_story_of_fuusouken_hayate_wonder_ride_book",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.WONDER_WORLD_BOOK));

	public static final DeferredItem<Item> WONDER_WORLD_STORY_OF_ONJUUKEN_SUZUNE_WONDER_RIDE_BOOK = ITEMS.register("wonder_world_story_of_onjuuken_suzune_wonder_ride_book",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.WONDER_WORLD_BOOK));

	public static final DeferredItem<Item> WONDER_WORLD_STORY_OF_KOUGOUKEN_SAIKOU_WONDER_RIDE_BOOK = ITEMS.register("wonder_world_story_of_kougouken_saikou_wonder_ride_book",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.WONDER_WORLD_BOOK));

	public static final DeferredItem<Item> WONDER_WORLD_STORY_OF_MUMEIKEN_KYOMU_WONDER_RIDE_BOOK = ITEMS.register("wonder_world_story_of_mumeiken_kyomu_wonder_ride_book",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.WONDER_WORLD_BOOK));

	public static final DeferredItem<Item> WONDER_WORLD_STORY_OF_ENEIKEN_NOROSHI_WONDER_RIDE_BOOK = ITEMS.register("wonder_world_story_of_eneiken_noroshi_wonder_ride_book",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.WONDER_WORLD_BOOK));

	public static final DeferredItem<Item> WONDER_WORLD_STORY_OF_JIKOKUKEN_KAIJI_WONDER_RIDE_BOOK = ITEMS.register("wonder_world_story_of_jikokuken_kaiji_wonder_ride_book",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.SABER_TAB_ITEM).AddToList(SwordOfLogosBookAnalyzer.WONDER_WORLD_BOOK));

	public static final DeferredItem<Item> HAPPY_BRAVE_DRAGON_WONDER_RIDE_BOOK = ITEMS.register("happy_brave_dragon_wonder_ride_book",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.SABER_TAB_ITEM));

	public static final DeferredItem<Item> DESAST_ALTER_RIDE_BOOK = ITEMS.register("desast_alter_ride_book",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.SABER_TAB_ITEM));

	public static final DeferredItem<Item> CHARYBDIS_ALTER_RIDE_BOOK = ITEMS.register("charybdis_alter_ride_book",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.SABER_TAB_ITEM));

	public static final DeferredItem<Item> LEGEIEL_ALTER_RIDE_BOOK = ITEMS.register("legeiel_alter_ride_book",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.SABER_TAB_ITEM));

	public static final DeferredItem<Item> ZOOOUS_ALTER_RIDE_BOOK = ITEMS.register("zooous_alter_ride_book",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.SABER_TAB_ITEM));

	public static final DeferredItem<Item> STORIOUS_ALTER_RIDE_BOOK = ITEMS.register("storious_alter_ride_book",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.SABER_TAB_ITEM));

	public static final DeferredItem<Item> OMNI_FORCE_WONDER_RIDE_BOOK_PART = ITEMS.register("omni_force_wonder_ride_book_part",
			() -> new BaseItem(new Item.Properties().rarity(Rarity.UNCOMMON)).AddToList(RiderTabs.SABER_TAB_ITEM));

	public static final DeferredItem<Item> OMNI_FORCE_WONDER_RIDE_BOOK_PART_2 = ITEMS.register("omni_force_wonder_ride_book_part_2",
			() -> new BaseItem(new Item.Properties().rarity(Rarity.UNCOMMON)).AddToList(RiderTabs.SABER_TAB_ITEM));

	public static final DeferredItem<Item> BOOK_OF_RUIN = ITEMS.register("book_of_ruin",
			() -> new BookOfRuinItem(new Item.Properties()).AddToList(RiderTabs.SABER_TAB_ITEM));

	public static final DeferredItem<Item> FORBIDDEN_TOME = ITEMS.register("forbidden_tome",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.SABER_TAB_ITEM));

	public static final DeferredItem<Item> GREAT_BOOK_FRAGMENT = ITEMS.register("great_book_fragment",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.SABER_TAB_ITEM));

	public static final DeferredItem<Item> GHOST_IJINROKU_WONDER_RIDE_BOOK = ITEMS.register("ghost_ijinroku_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"saber_ghost_ijinroku","saber","seiken_swordriver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)
					,new MobEffectInstance(Effect_core.GHOST, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddNum(2).ResetFormToBase().AddToList(RiderTabs.SABER_TAB_ITEM));

	public static final DeferredItem<Item> SPECTER_GEKIKOU_SENKI_WONDER_RIDE_BOOK = ITEMS.register("specter_gekikou_senki_wonder_ride_book",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"blades_specter_gekikou_senki","blades","seiken_swordriver_belt"
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false))
					.AddNum(2).ChangeSlot(2).ResetFormToBase().AddToList(RiderTabs.SABER_TAB_ITEM));

	public static final DeferredItem<Item> BOOK_GATE_WONDER_RIDE_BOOK = ITEMS.register("book_gate_wonder_ride_book",
			() -> new BookGateItem(new Item.Properties(),10).AddToList(RiderTabs.SABER_TAB_ITEM));


	public static final DeferredItem<Item> SABER_HELMET = ITEMS.register("saberhead",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.SABER_TAB_ITEM)
					.ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));
	public static final DeferredItem<Item> SABER_CHESTPLATE = ITEMS.register("sabertroso",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.SABER_TAB_ITEM)
					.ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));
	public static final DeferredItem<Item> SABER_LEGGINGS = ITEMS.register("saberlegs",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.SABER_TAB_ITEM)
					.ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> SEIKEN_SWORDRIVER_DRIVER_SABER = ITEMS.register("seiken_swordriver_saber",
			() -> new SeikenSwordriverItem(ArmorMaterials.DIAMOND,"saber",BRAVE_DRAGON_WONDER_RIDE_BOOK ,SABER_HELMET,SABER_CHESTPLATE,SABER_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(SABER_BLANK_2,SABER_BLANK_3).AddToTabList(RiderTabs.SABER_TAB_ITEM).ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> SEIKEN_SWORDRIVER_DRIVER_BLADES = ITEMS.register("seiken_swordriver_blades",
			() -> new SeikenSwordriverItem(ArmorMaterials.DIAMOND,"blades",SABER_BLANK_1 ,SABER_HELMET,SABER_CHESTPLATE,SABER_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(LION_SENKI_WONDER_RIDE_BOOK,SABER_BLANK_3).AddToTabList(RiderTabs.SABER_TAB_ITEM).ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> SEIKEN_SWORDRIVER_DRIVER_ESPADA = ITEMS.register("seiken_swordriver_espada",
			() -> new SeikenSwordriverItem(ArmorMaterials.DIAMOND,"espada",SABER_BLANK_1 ,SABER_HELMET,SABER_CHESTPLATE,SABER_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(SABER_BLANK_2,LAMP_DO_ALNGINA_WONDER_RIDE_BOOK).AddToTabList(RiderTabs.SABER_TAB_ITEM).ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> SWORD_OF_LOGOS_BUCKLE_BUSTER = ITEMS.register("sword_of_logos_buckle_buster",
			() -> new SwordOfLogosBuckleItem(ArmorMaterials.DIAMOND,"buster",GENBU_SHINWA_WONDER_RIDE_BOOK_BUSTER ,SABER_HELMET,SABER_CHESTPLATE,SABER_LEGGINGS ,
					new Item.Properties().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)){
				@Override
				public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
					player.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.translatable("sword_of_logos_holder.text");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
							packetBuffer.writeBlockPos(player.blockPosition());
							packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
							return new HissatsuHolderGuiMenu(id, inventory, packetBuffer,itemstack);
						}
					});
				}
			}.Has_Inventory_Gui().AddToTabList(RiderTabs.SABER_TAB_ITEM).ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> SWORD_OF_LOGOS_BUCKLE_KENZAN = ITEMS.register("sword_of_logos_buckle_kenzan",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"kenzan",SARUTOBI_NINJADEN_WONDER_RIDE_BOOK_KENZAN ,SABER_HELMET,SABER_CHESTPLATE,SABER_LEGGINGS ,
					new Item.Properties().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)){
				@Override
				public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
					player.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.translatable("sword_of_logos_holder.text");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
							packetBuffer.writeBlockPos(player.blockPosition());
							packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
							return new HissatsuHolderGuiMenu(id, inventory, packetBuffer,itemstack);
						}
					});
				}
			}.Has_Inventory_Gui().AddToTabList(RiderTabs.SABER_TAB_ITEM).ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> SWORD_OF_LOGOS_BUCKLE_SLASH = ITEMS.register("sword_of_logos_buckle_slash",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"slash",HANSELNUTS_TO_GRETEL_WONDER_RIDE_BOOK_SLASH ,SABER_HELMET,SABER_CHESTPLATE,SABER_LEGGINGS ,
					new Item.Properties().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)){
				@Override
				public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
					player.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.translatable("sword_of_logos_holder.text");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
							packetBuffer.writeBlockPos(player.blockPosition());
							packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
							return new HissatsuHolderGuiMenu(id, inventory, packetBuffer,itemstack);
						}
					});
				}
			}.Has_Inventory_Gui().AddToTabList(RiderTabs.SABER_TAB_ITEM).ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> JAKEN_CALIBURDRIVER = ITEMS.register("jaken_caliburdriver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"calibur",JAAKU_DRAGON_WONDER_RIDE_BOOK_CALIBUR ,SABER_HELMET,SABER_CHESTPLATE,SABER_LEGGINGS ,
					new Item.Properties().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)){
				@Override
				public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
					player.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.translatable("hissatsuholder.text");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
							packetBuffer.writeBlockPos(player.blockPosition());
							packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
							return new HissatsuHolderGuiMenu(id, inventory, packetBuffer,itemstack);
						}
					});
				}
			}.Has_Inventory_Gui().AddToTabList(RiderTabs.SABER_TAB_ITEM).ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> SEIKEN_SAIKOU_DRIVER = ITEMS.register("seiken_saikou_driver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"saikou",KIN_NO_BUKI_GIN_NO_BUKI_WONDER_RIDE_BOOK ,SABER_HELMET,SABER_CHESTPLATE,SABER_LEGGINGS , new Item.Properties().rarity(Rarity.UNCOMMON))
					.AddToTabList(RiderTabs.SABER_TAB_ITEM).ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> DOOMS_DRIVER_BUCKLE_SOLOMON = ITEMS.register("dooms_driver_buckle_solomon",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"solomon",OMNI_FORCE_WONDER_RIDE_BOOK ,SABER_HELMET,SABER_CHESTPLATE,SABER_LEGGINGS , new Item.Properties().rarity(Rarity.UNCOMMON))
					.Dont_show_belt_form_info().AddToTabList(RiderTabs.SABER_TAB_ITEM).ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> DOOMS_DRIVER_BUCKLE_STORIOUS = ITEMS.register("dooms_driver_buckle_storious",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"storious",GRIMOIRE_WONDER_RIDE_BOOK ,SABER_HELMET,SABER_CHESTPLATE,SABER_LEGGINGS , new Item.Properties().rarity(Rarity.UNCOMMON))
					.Dont_show_belt_form_info().AddToTabList(RiderTabs.SABER_TAB_ITEM).ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> HAKEN_BLADRIVER_FALCHION = ITEMS.register("haken_bladriver_falchion",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"falchion",ETERNAL_PHOENIX_WONDER_RIDE_BOOK_FALCHION ,SABER_HELMET,SABER_CHESTPLATE,SABER_LEGGINGS ,
					new Item.Properties().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)){
				@Override
				public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
					player.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.translatable("hissatsuholder.text");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
							packetBuffer.writeBlockPos(player.blockPosition());
							packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
							return new HissatsuHolderGuiMenu(id, inventory, packetBuffer,itemstack);
						}
					});
				}
			}.Has_Inventory_Gui().AddToTabList(RiderTabs.SABER_TAB_ITEM).ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> ROYAL_SWORD_OF_LOGOS_BUCKLE_SABELA = ITEMS.register("royal_sword_of_logos_buckle_sabela",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"sabela",KONCHUU_DAIHYAKKA_WONDER_RIDE_BOOK ,SABER_HELMET,SABER_CHESTPLATE,SABER_LEGGINGS , new Item.Properties())
					.Dont_show_belt_form_info().AddToTabList(RiderTabs.SABER_TAB_ITEM).ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> ROYAL_SWORD_OF_LOGOS_BUCKLE_DURENDAL = ITEMS.register("royal_sword_of_logos_buckle_durendal",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"durendal",OCEAN_HISTORY_WONDER_RIDE_BOOK ,SABER_HELMET,SABER_CHESTPLATE,SABER_LEGGINGS , new Item.Properties())
					.Dont_show_belt_form_info().AddToTabList(RiderTabs.SABER_TAB_ITEM).ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> HAKEN_BLADRIVER_TASSEL = ITEMS.register("haken_bladriver_tassel",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"tassel",TASSEL_DARK_WONDER_RIDE_BOOK ,SABER_HELMET,SABER_CHESTPLATE,SABER_LEGGINGS , new Item.Properties())
					.Dont_show_belt_form_info().AddToTabList(RiderTabs.SABER_TAB_ITEM).ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> SEIKEN_SWORDRIVER_DRIVER_DESAST = ITEMS.register("seiken_swordriver_desast",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"desast",GAIKOTSU_NINJADEN_WONDER_RIDE_BOOK,SABER_HELMET,SABER_CHESTPLATE,SABER_LEGGINGS ,
					new Item.Properties().rarity(Rarity.UNCOMMON).component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)){
				@Override
				public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
					player.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.translatable("hissatsuholder.text");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
							packetBuffer.writeBlockPos(player.blockPosition());
							packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
							return new HissatsuHolderGuiMenu(id, inventory, packetBuffer,itemstack);
						}
					});
				}
			}.Has_Inventory_Gui().Dont_show_belt_form_info().AddToTabList(RiderTabs.SABER_TAB_ITEM).ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));



	public static final DeferredItem<Item> KAENKEN_REKKA = ITEMS.register("kaenken_rekka",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.SABER_TAB_ITEM)
					.ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> KINGEXCALIBUR = ITEMS.register("kingexcalibur",
			() -> new BaseSwordItem(Tiers.DIAMOND, 8, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).AddToTabList(RiderTabs.SABER_TAB_ITEM)
					.ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> SUISEIKEN_NAGARE = ITEMS.register("suiseiken_nagare",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.SABER_TAB_ITEM)
					.ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> RAIMEIKEN_IKAZUCHI = ITEMS.register("raimeiken_ikazuchi",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.SABER_TAB_ITEM)
					.ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> DOGOUKEN_GEKIDO = ITEMS.register("dogouken_gekido",
			() -> new BaseSwordItem(Tiers.DIAMOND, 7, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.SABER_TAB_ITEM)
					.ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> FUUSOUKEN_HAYATE_NITOURYU = ITEMS.register("fuusouken_hayate_nitouryu",
			() -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.SABER_TAB_ITEM)
					.ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> FUUSOUKEN_HAYATE_NITOURYU_2 = ITEMS.register("fuusouken_hayate_nitouryu2",
			() -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.SABER_TAB_ITEM)
					.ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> FUUSOUKEN_HAYATE_SHURIKEN = ITEMS.register("fuusouken_hayate_shuriken",
			() -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.SABER_TAB_ITEM)
					.ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()).KeepDifItem(FUUSOUKEN_HAYATE_NITOURYU_2.get()));

	public static final DeferredItem<Item> FUUSOUKEN_HAYATE_ITTOURYU = ITEMS.register("fuusouken_hayate_ittouryu",
			() -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.SABER_TAB_ITEM)
					.ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()).KeepDifItem(FUUSOUKEN_HAYATE_NITOURYU_2.get()));

    public static final DeferredItem<Item> ONJUUKEN_SUZUNE = ITEMS.register("onjuuken_suzune",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties())
			.IsSwordGun().AddToTabList(RiderTabs.SABER_TAB_ITEM).ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> ANKOKUKEN_KURAYAMI = ITEMS.register("ankokuken_kurayami",
			() -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.SABER_TAB_ITEM)
					.ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> KOUGOUKEN_SAIKOU = ITEMS.register("kougouken_saikou",
			() -> new BaseSwordItem(Tiers.DIAMOND, 8, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).AddToTabList(RiderTabs.SABER_TAB_ITEM)
					.ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> MUMEIKEN_KYOMU = ITEMS.register("mumeiken_kyomu",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.SABER_TAB_ITEM)
					.ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> ENEIKEN_NOROSHI = ITEMS.register("eneiken_noroshi",
			() -> new BaseSwordItem(Tiers.DIAMOND, 8, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.SABER_TAB_ITEM)
					.ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> JIKOKUKEN_KAIJI = ITEMS.register("jikokuken_kaiji",
			() -> new BaseSwordItem(Tiers.DIAMOND, 9, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.SABER_TAB_ITEM)
					.ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> CALADBOLG = ITEMS.register("caladbolg",
			() -> new BaseSwordItem(Tiers.DIAMOND, 14, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).AddToTabList(RiderTabs.SABER_TAB_ITEM)
					.ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> BILGAMED = ITEMS.register("bilgamed",
			() -> new BaseSwordItem(Tiers.DIAMOND, 14, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).AddToTabList(RiderTabs.SABER_TAB_ITEM)
					.ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> HAOUKEN_XROSS_SABER = ITEMS.register("haouken_xross_saber",
			() -> new BaseSwordItem(Tiers.DIAMOND, 14, -2.4F, new Item.Properties().rarity(Rarity.RARE)).AddToTabList(RiderTabs.SABER_TAB_ITEM)
					.ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()).IsFormItem(BRAVE_DRAGON_WONDER_RIDE_BOOK_XROSS.get()));

	public static final DeferredItem<Item> DESTRUCTION_SHIELD = ITEMS.register("destruction_shield",
			() -> new BaseShieldItem(new Item.Properties().rarity(Rarity.UNCOMMON)).AddToTabList(RiderTabs.SABER_TAB_ITEM).ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> GEKKOU_RAIMEIKEN_IKAZUCHI = ITEMS.register("gekkou_raimeiken_ikazuchi",
			() -> new BaseSwordItem(Tiers.DIAMOND, 14, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).AddToTabList(RiderTabs.SABER_TAB_ITEM)
					.ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> KOKURANKEN_SHIKKOKU = ITEMS.register("kokuranken_shikkoku",
			() -> new BaseSwordItem(Tiers.DIAMOND, 8, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).AddToTabList(RiderTabs.SABER_TAB_ITEM)
					.ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	public static final DeferredItem<Item> SHIMI_LOT = ITEMS.register("shimi_lot",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.SABER_TAB_ITEM)
					.ChangeRepairItem(BLANK_WONDER_RIDE_BOOK.get()));

	// kokuranken_shikkoku


	public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
}
