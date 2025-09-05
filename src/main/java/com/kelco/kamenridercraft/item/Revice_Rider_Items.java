package com.kelco.kamenridercraft.item;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.block.machineBlocks.VistampBar;
import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.item.BaseItems.*;
import com.kelco.kamenridercraft.item.revice.*;
import com.kelco.kamenridercraft.item.tabs.RiderTabs;
import com.kelco.kamenridercraft.world.inventory.VistampHolderGuiMenu;
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
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemContainerContents;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Revice_Rider_Items {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);


	public static final DeferredItem<Item> REVICE_LOGO = ITEMS.register("revice_logo",
			() -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/revice")), new Item.Properties()).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> PROTO_VISTAMP = ITEMS.register("proto_vistamp",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> REX_VISTAMP_VICE = ITEMS.register("rex_vistamp_vice",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","vice","buddy_buckle_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)));

	public static final DeferredItem<Item> REX_VISTAMP = ITEMS.register("rex_vistamp",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","revi","revice_driver_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)).addAlternative(REX_VISTAMP_VICE.get()).AddToList(VistampBar.PROTO_VISTAMP, 12).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> UNFINISHED_BARID_REX_VISTAMP = ITEMS.register("barid_rex_vistamp_closed",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> BARID_REX_VISTAMP_VICE = ITEMS.register("barid_rex_vistamp_vice",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"","vice","buddy_buckle_belt",
                new MobEffectInstance(MobEffects.JUMP, 40, 5,true,false),
                new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
                new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
                new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)));

	public static final DeferredItem<Item> BARID_REX_VISTAMP = ITEMS.register("barid_rex_vistamp",
        () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_barid_rex","revi","revice_driver_belt_b",
                new MobEffectInstance(MobEffects.JUMP, 40, 5,true,false),
                new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
                new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
                new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)).addAlternative(BARID_REX_VISTAMP_VICE.get()).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> VOLCANO_VISTAMP_VICE = ITEMS.register("volcano_vistamp_vice",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"_barid_rex","vice","buddy_buckle_belt",
                new MobEffectInstance(MobEffects.JUMP, 40, 5,true,false),
                new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
                new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
                new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
                new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
                new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)));

	public static final DeferredItem<Item> VOLCANO_VISTAMP = ITEMS.register("volcano_vistamp",
        () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_volcano_rex","revi","revice_driver_belt_v",
                new MobEffectInstance(MobEffects.JUMP, 40, 5,true,false),
                new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
                new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
                new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
                new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
                new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false))
				.ChangeBeltModel("geo/volcano_riderbelt.geo.json").addAlternative(VOLCANO_VISTAMP_VICE.get()).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> ROLLING_VISTAMP = ITEMS.register("rolling_vistamp",
        () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_jack_revice","revi","revice_driver_belt_r",
				new MobEffectInstance(MobEffects.JUMP, 40, 5,true,false),
				new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
				new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
				new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false))
				.ChangeBeltModel("geo/volcano_riderbelt.geo.json").AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> THUNDER_GALE_VISTAMP = ITEMS.register("thunder_gale_vistamp",
        () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_revice","revi","revice_driver_belt_t",
				new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false),
				new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
				new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
				new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 5,true,false),
				new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
				new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> GIFFARD_REX_VISTAMP_VICE = ITEMS.register("giffard_rex_vistamp_vice",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"_ultimate","vice","revice_driver_belt_g_vice",
				new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false),
				new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
				new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
				new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 5,true,false),
				new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
				new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
				new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
				new MobEffectInstance(Effect_core.PUNCH, 40, 8,true,false)));

	public static final DeferredItem<Item> GIFFARD_REX_VISTAMP = ITEMS.register("giffard_rex_vistamp",
        () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"_ultimate","revi","revice_driver_belt_g",
				new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false),
				new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
				new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
				new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 5,true,false),
				new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
				new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
				new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
				new MobEffectInstance(Effect_core.PUNCH, 40, 8,true,false)).addAlternative(GIFFARD_REX_VISTAMP_VICE.get()).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> FIFTY_GALE_VISTAMP = ITEMS.register("fifty_gale_vistamp",
        () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"_igarashi","revi","revice_driver_belt_f",
				new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false),
				new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
				new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
				new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 5,true,false),
				new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
				new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
				new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false),
				new MobEffectInstance(Effect_core.ANTIPOISON, 40, 0,true,false),
				new MobEffectInstance(Effect_core.PUNCH, 40, 5,true,false)).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> GOLD_SPINO_VISTAMP_VICE = ITEMS.register("gold_spino_vice",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_gold_spino","vice","blank",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 6,true,false)).SetPalyerModelInvisible());


	public static final DeferredItem<Item> GOLD_SPINO_VISTAMP = ITEMS.register("gold_spino_vistamp",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"_gold_spino","revi","revice_driver_belt_go",
				new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
				new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
				new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
				.addAlternative(GOLD_SPINO_VISTAMP_VICE.get()).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> TRUE_REX_VISTAMP = ITEMS.register("true_rex_vistamp",
        () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_shin","revi","revice_driver_belt_tr",
				new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false),
				new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
				new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
				new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 5,true,false),
				new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> EAGLE_VISTAMP_VICE = ITEMS.register("eagle_vistamp_vice",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"_eagle","vice","buddy_buckle_belt",
                new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false),
                new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)));

	public static final DeferredItem<Item> EAGLE_VISTAMP = ITEMS.register("eagle_vistamp",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"_eagle","revi","revice_driver_belt_e",
                new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false),
                new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)).addAlternative(EAGLE_VISTAMP_VICE.get()).AddToList(VistampBar.PROTO_VISTAMP, 9).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> MAMMOTH_VISTAMP_VICE = ITEMS.register("mammoth_vistamp_vice",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"_mammoth","vice","buddy_buckle_belt",
                new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
                new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)));

	public static final DeferredItem<Item> MAMMOTH_VISTAMP = ITEMS.register("mammoth_vistamp",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"_mammoth","revi","revice_driver_belt_m",
                new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
                new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)).addAlternative(MAMMOTH_VISTAMP_VICE.get()).AddToList(VistampBar.PROTO_VISTAMP, 9).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> MEGALODON_VISTAMP_VICE = ITEMS.register("megalodon_vistamp_vice",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"_megalodon","vice","buddy_buckle_belt",
                new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 40, 1,true,false),
                new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false)));

	public static final DeferredItem<Item> MEGALODON_VISTAMP = ITEMS.register("megalodon_vistamp",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"_megalodon","revi","revice_driver_belt_me",
                new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 40, 1,true,false),
                new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false)).addAlternative(MEGALODON_VISTAMP_VICE.get()).AddToList(VistampBar.PROTO_VISTAMP, 9).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> PTERA_VISTAMP = ITEMS.register("ptera_vistamp",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"_ptera","revi","revice_driver_belt_p",
                new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false),
                new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)).AddToList(VistampBar.PROTO_VISTAMP, 5).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> LION_VISTAMP_VICE = ITEMS.register("lion_vistamp_vice",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"_lion","vice","buddy_buckle_belt",
                new MobEffectInstance(Effect_core.PUNCH, 40, 6,true,false),
                new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)));

	public static final DeferredItem<Item> LION_VISTAMP = ITEMS.register("lion_vistamp",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"_lion","revi","revice_driver_belt_l",
                new MobEffectInstance(Effect_core.PUNCH, 40, 6,true,false),
                new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)).addAlternative(LION_VISTAMP_VICE.get()).AddToList(VistampBar.PROTO_VISTAMP, 8).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> JACKAL_VISTAMP_EVIL = ITEMS.register("jackal_vistamp_evil",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"_jackal","evil","two_sidriver_belt",
                new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
                new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)));

	public static final DeferredItem<Item> JACKAL_VISTAMP_LIVE = ITEMS.register("jackal_vistamp_live",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"_jackal","live","two_sidriver_belt",
                new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
                new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)).addAlternative(JACKAL_VISTAMP_EVIL.get()));

	public static final DeferredItem<Item> JACKAL_VISTAMP_VICE = ITEMS.register("jackal_vistamp_vice",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"_jackal","vice","blank",
                new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
                new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)).addAlternative(JACKAL_VISTAMP_LIVE.get()).SetPalyerModelInvisible());

	public static final DeferredItem<Item> JACKAL_VISTAMP = ITEMS.register("jackal_vistamp",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"_jackal","revi","revice_driver_belt_j",
                new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
                new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)).addAlternative(JACKAL_VISTAMP_VICE.get()).AddToList(VistampBar.PROTO_VISTAMP, 8).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> KONG_VISTAMP_DESTREAM = ITEMS.register("kong_vistamp_destream",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"_kong","destream","destream_driver_belt",
                new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false),
                new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
                new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
                new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 5,true,false),
                new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
                new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
                new MobEffectInstance(Effect_core.PUNCH, 40, 5,true,false))
	);

	public static final DeferredItem<Item> KONG_VISTAMP_VICE = ITEMS.register("kong_vistamp_vice",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"_kong","vice","buddy_buckle_belt_big",
				new MobEffectInstance(Effect_core.PUNCH, 40, 5,true,false),
				new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false))
				.ChangeModel("lv_1.geo.json").ChangeBeltModel("geo/lv_1_belt.geo.json").addAlternative(KONG_VISTAMP_DESTREAM.get()));

	public static final DeferredItem<Item> KONG_VISTAMP = ITEMS.register("kong_vistamp",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"_kong","revi","revice_driver_belt_k",
                new MobEffectInstance(Effect_core.PUNCH, 40, 5,true,false),
                new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)).addAlternative(KONG_VISTAMP_VICE.get()).AddToList(VistampBar.PROTO_VISTAMP, 8).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> KAMAKIRI_VISTAMP_VICE = ITEMS.register("kamakiri_vistamp_vice",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"_kamakiri","vice","buddy_buckle_belt",
				new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
				new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)));

	public static final DeferredItem<Item> KAMAKIRI_VISTAMP = ITEMS.register("kamakiri_vistamp",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"_kamakiri","revi","revice_driver_belt_ka",
                new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
                new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)).addAlternative(KAMAKIRI_VISTAMP_VICE.get()).AddToList(VistampBar.PROTO_VISTAMP, 8).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> BRACHIO_VISTAMP_VICE = ITEMS.register("brachio_vistamp_vice",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"_brachio","vice","buddy_buckle_belt_big",
				new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
				new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false))
				.ChangeModel("lv_1.geo.json").ChangeBeltModel("geo/lv_1_belt.geo.json"));

	public static final DeferredItem<Item> BRACHIO_VISTAMP = ITEMS.register("brachio_vistamp",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"_brachio","revi","revice_driver_belt_br",
                new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
                new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)).addAlternative(BRACHIO_VISTAMP_VICE.get()).AddToList(VistampBar.PROTO_VISTAMP, 8).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> NEO_BATTA_VISTAMP_VICE = ITEMS.register("neo_batta_vistamp_vice",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"_neo_batta","vice","buddy_buckle_belt",
				new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false)));

	public static final DeferredItem<Item> NEO_BATTA_VISTAMP = ITEMS.register("neo_batta_vistamp",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"_neo_batta","revi","revice_driver_belt_n",
                new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false)).addAlternative(NEO_BATTA_VISTAMP_VICE.get()).AddToList(VistampBar.PROTO_VISTAMP, 5).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> KANGAROO_VISTAMP_VICE = ITEMS.register("kangaroo_vistamp_vice",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_kangaroo","vice","buddy_buckle_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false),
					new MobEffectInstance(Effect_core.SMALL, 40, 6,true,false)));

	public static final DeferredItem<Item> KANGAROO_VISTAMP = ITEMS.register("kangaroo_vistamp",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"_kangaroo","revi","revice_driver_belt_kan",
                new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
                new MobEffectInstance(Effect_core.PUNCH, 40, 6,true,false)).addAlternative(KANGAROO_VISTAMP_VICE.get())
				.AddToList(VistampBar.PROTO_VISTAMP, 4).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> KIRIN_VISTAMP_VICE = ITEMS.register("kirin_vistamp_vice",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_kirin","vice","buddy_buckle_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false))
					.model_has_different_name("kirin_vistamp").has_basic_model());

	public static final DeferredItem<Item> KIRIN_VISTAMP = ITEMS.register("kirin_vistamp",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"_kirin","revi","revice_driver_belt_ki",
                new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
                new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false))
				.addAlternative(KIRIN_VISTAMP_VICE.get()).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> NIWATORI_VISTAMP_VICE = ITEMS.register("niwatori_vistamp_vice",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_niwatori","vice","buddy_buckle_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false))
					.SetPalyerModelInvisible().model_has_different_name("niwatori_vistamp").has_basic_model());

	public static final DeferredItem<Item> NIWATORI_VISTAMP = ITEMS.register("niwatori_vistamp",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"_niwatori","revi","revice_driver_belt_ni",
                new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
                new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false))
				.addAlternative(NIWATORI_VISTAMP_VICE.get()).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> FUNKOROGASHI_VISTAMP_VICE = ITEMS.register("funkorogashi_vistamp_vice",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_funkorogashi","vice","buddy_buckle_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false))
					.SetPalyerModelInvisible().model_has_different_name("niwatori_vistamp").has_basic_model());

	public static final DeferredItem<Item> FUNKOROGASHI_VISTAMP = ITEMS.register("funkorogashi_vistamp",
        () -> new RiderFormChangeItem(new Item.Properties(),0,"_funkorogashi","revi","revice_driver_belt_fu",
                new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
                new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false))
				.addAlternative(FUNKOROGASHI_VISTAMP_VICE.get()).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> BAT_VISTAMP_EVIL = ITEMS.register("bat_vistamp_evil",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","evil","two_sidriver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)));

	public static final DeferredItem<Item> BAT_VISTAMP = ITEMS.register("bat_vistamp",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","live","two_sidriver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)).addAlternative(BAT_VISTAMP_EVIL.get()).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> CROW_VISTAMP = ITEMS.register("crow_vistamp",
			() -> new BaseItem(new Item.Properties()).AddToList(VistampBar.PROTO_VISTAMP).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> HOLY_WING_VISTAMP = ITEMS.register("holy_wing_vistamp",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_holy","live","two_sidriver_belt",
                    new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 5,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> PERFECT_WING_VISTAMP = ITEMS.register("perfect_wing_vistamp",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_evility","live","two_sidriver_belt",
                    new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 5,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 5,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> MEGA_BAT_VISTAMP = ITEMS.register("mega_bat_vistamp",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"","live_marvelous","revice_driver_belt_live",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 6,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 6,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> SPIDER_VISTAMP = ITEMS.register("spider_vistamp",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","demons","demons_driver_belt",
					new MobEffectInstance(MobEffects.POISON, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)).AddToList(VistampBar.PROTO_VISTAMP, 6).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> GIANT_SPIDER_VISTAMP = ITEMS.register("giant_spider_vistamp",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_imperial","demons","demons_driver_belt",
					new MobEffectInstance(MobEffects.POISON, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> KUWAGATA_VISTAMP = ITEMS.register("kuwagata_vistamp",
    		() -> new RiderFormChangeItem(new Item.Properties(),0,"","over_demons","demons_driver_belt",
    		        new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false),
    		        new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
    		        new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
    		        new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
    		        new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> GIRAFFA_VISTAMP = ITEMS.register("giraffa_vistamp",
    		() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"","over_demons_get","demons_driver_belt",
    		        new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false),
    		        new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
    		        new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
    		        new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
    		        new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> BATTA_VISTAMP = ITEMS.register("batta_vistamp",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_batta","demons","demons_driver_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.ChangeSlot(5).addSwitchForm(Modded_item_core.BLANK_FORM.get()).needBaseForm()
					.AddToList(VistampBar.PROTO_VISTAMP, 4).AddToList(RiderTabs.REVICE_TAB_ITEM));


	public static final DeferredItem<Item> MOGURA_VISTAMP = ITEMS.register("mogura_vistamp",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_mogura","demons","demons_driver_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false))
					.ChangeSlot(2).addSwitchForm(Modded_item_core.BLANK_FORM.get()).needBaseForm()
					.AddToList(VistampBar.PROTO_VISTAMP, 4).AddToList(RiderTabs.REVICE_TAB_ITEM));


	public static final DeferredItem<Item> SCORPION_VISTAMP = ITEMS.register("scorpion_vistamp",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_scorpion","demons","demons_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false))
				.ChangeSlot(4).addSwitchForm(Modded_item_core.BLANK_FORM.get())
					.needBaseForm().AddToList(VistampBar.PROTO_VISTAMP, 4).AddToList(RiderTabs.REVICE_TAB_ITEM));


	public static final DeferredItem<Item> ANOMALOCARIS_VISTAMP = ITEMS.register("anomalocaris_vistamp",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_anomalocaris","demons","demons_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false))
					.ChangeSlot(2).addSwitchForm(Modded_item_core.BLANK_FORM.get()).needBaseForm()
					.AddToList(VistampBar.PROTO_VISTAMP, 3).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> COBRA_VISTAMP = ITEMS.register("cobra_vistamp",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","jeanne","libera_driver_belt",
                    new MobEffectInstance(Effect_core.PUNCH, 40, 5,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
                    new MobEffectInstance(Effect_core.ANTIPOISON, 40, 0,true,false))
					.AddToList(VistampBar.PROTO_VISTAMP, 5).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> TURTLE_VISTAMP = ITEMS.register("turtle_vistamp",
            () -> new BaseItem(new Item.Properties()).AddToList(VistampBar.PROTO_VISTAMP, 3).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> KUJAKU_VISTAMP = ITEMS.register("kujaku_vistamp",
            () -> new BaseItem(new Item.Properties()).AddToList(VistampBar.PROTO_VISTAMP, 3).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> HASHIBIROKO_VISTAMP = ITEMS.register("hashibiroko_vistamp",
            () -> new BaseItem(new Item.Properties()).AddToList(VistampBar.PROTO_VISTAMP, 3).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> TRICERA_VISTAMP = ITEMS.register("tricera_vistamp",
            () -> new BaseItem(new Item.Properties()).AddToList(VistampBar.PROTO_VISTAMP, 3).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> KING_COBRA_VISTAMP = ITEMS.register("king_cobra_vistamp",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_invincible","jeanne","libera_driver_belt_k",
                    new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
                    new MobEffectInstance(Effect_core.ANTIPOISON, 40, 0,true,false),
                    new MobEffectInstance(Effect_core.PUNCH, 40, 7,true,false)).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> KABUTO_VISTAMP = ITEMS.register("kabuto_vistamp",
    		() -> new RiderFormChangeItem(new Item.Properties(),0,"","vail","vail_driver_belt",
    		        new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
    		        new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
    		        new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
    		        new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> CRIMSON_VAIL_VISTAMP = ITEMS.register("crimson_vail_vistamp",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"","crimson_vail","crimson_vail_belt",
                    new MobEffectInstance(MobEffects.JUMP, 40, 5,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false)).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> HERCULES_VISTAMP = ITEMS.register("hercules_vistamp",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","destream","destream_driver_belt",
                    new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 5,true,false),
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> CROCODILE_VISTAMP_DEMONS = ITEMS.register("crocodile_vistamp_demons",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_crocodile","demons","demons_driver_belt",
					new MobEffectInstance(Effect_core.PUNCH, 400, 5,true,false))
					.ChangeSlot(3).addSwitchForm(Modded_item_core.BLANK_FORM.get()).addNeedForm(GIANT_SPIDER_VISTAMP.get(),1));

	public static final DeferredItem<Item> CROCODILE_VISTAMP = ITEMS.register("crocodile_vistamp",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_crocodile","destream","destream_driver_belt",
                    new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 5,true,false),
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(Effect_core.PUNCH, 40, 5,true,false))
					.addAlternative(CROCODILE_VISTAMP_DEMONS.get()).AddToList(VistampBar.PROTO_VISTAMP).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> KOMODO_DRAGON_VISTAMP_DEMONS = ITEMS.register("komodo_vistamp_demons",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_komodo_dragon","demons","demons_driver_belt",
					new MobEffectInstance(Effect_core.FIRE_PUNCH, 400, 2,true,false))
					.ChangeSlot(2).addSwitchForm(Modded_item_core.BLANK_FORM.get()).addNeedForm(GIANT_SPIDER_VISTAMP.get(),1));

	public static final DeferredItem<Item> KOMODO_DRAGON_VISTAMP = ITEMS.register("komodo_dragon_vistamp",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_komodo_dragon","destream","destream_driver_belt",
                    new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 5,true,false),
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(Effect_core.FIRE_PUNCH, 40, 2,true,false))
					.addAlternative(KOMODO_DRAGON_VISTAMP_DEMONS.get()).AddToList(VistampBar.PROTO_VISTAMP).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> BLOOD_VADE_VISTAMP = ITEMS.register("blood_vade_vistamp",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"","blood_vade","vade_belt_belt",
                    new MobEffectInstance(MobEffects.JUMP, 40, 5,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false)).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> TROOPER_SPIDER_VISTAMP = ITEMS.register("spider_trooper_vistamp",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","demons_trooper_alpha","demons_driver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> TROOPER_KUWAGATA_VISTAMP = ITEMS.register("kuwagata_trooper_vistamp",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","demons_trooper_beta","demons_driver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> QUEEN_BEE_VISTAMP = ITEMS.register("queen_bee_vistamp",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","aguilera","week_endriver_belt",
                    new MobEffectInstance(Effect_core.PUNCH, 40, 5,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
                    new MobEffectInstance(Effect_core.ANTIPOISON, 40, 0,true,false),
                    new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false)).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> BUFFALO_VISTAMP = ITEMS.register("buffalo_vistamp",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> TWIN_CHIMERA_VISTAMP = ITEMS.register("twin_chimera_vistamp",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"","chimera","chimera_driver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 5,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> TRI_CHIMERA_VISTAMP = ITEMS.register("tri_chimera_vistamp",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"","daimon","chimera_driver_daimon_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 5,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> JUUGA_VISTAMP = ITEMS.register("juuga_vistamp",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"","juuga","juuga_driver_belt",
                	new MobEffectInstance(Effect_core.PUNCH, 40, 6,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
                	new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> KRAKEN_VISTAMP = ITEMS.register("kraken_vistamp",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","orteca","demons_driver_belt",
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> CONDOR_VISTAMP_DEMONS = ITEMS.register("batta_vistamp_demons",
			() -> new RiderFormChangeItem(new Item.Properties(), 0, "_condor", "demons", "demons_driver_belt",
					new MobEffectInstance(Effect_core.FLYING, 40, 0, true, false))
					.ChangeSlot(3).addSwitchForm(Modded_item_core.BLANK_FORM.get()).needBaseForm());

	public static final DeferredItem<Item> CONDOR_VISTAMP_VICE = ITEMS.register("condor_vistamp_vice",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_condor","vice","buddy_buckle_belt",
					new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false))
					.addAlternative(CONDOR_VISTAMP_DEMONS.get()));

	public static final DeferredItem<Item> CONDOR_VISTAMP = ITEMS.register("condor_vistamp",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_condor","revi","revice_driver_belt_c",
					new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false))
					.addAlternative(CONDOR_VISTAMP_VICE.get()).AddToList(VistampBar.PROTO_VISTAMP, 3).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> WHITE_LEO_VISTAMP_VICE = ITEMS.register("white_leo_vistamp_vice",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_white_leo","vice","buddy_buckle_belt",
					new MobEffectInstance(Effect_core.PUNCH, 40, 7,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false)));

	public static final DeferredItem<Item> WHITE_LEO_VISTAMP = ITEMS.register("white_leo_vistamp",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_white_leo","revi","revice_driver_belt_w",
					new MobEffectInstance(Effect_core.PUNCH, 40, 7,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false))
					.addAlternative(WHITE_LEO_VISTAMP_VICE.get()).AddToList(VistampBar.PROTO_VISTAMP, 1).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> QUETZALCOATLUS_VISTAMP = ITEMS.register("quetzalcoatlus_vistamp",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_quetzalcoatlus","revi","revice_driver_belt_q",
					new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false))
					.AddToList(VistampBar.PROTO_VISTAMP, 1).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> KAJIKI_VISTAMP = ITEMS.register("kajiki_vistamp",
            () -> new BaseItem(new Item.Properties()).AddToList(VistampBar.PROTO_VISTAMP).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> HEDGEHOG_VISTAMP = ITEMS.register("hedgehog_vistamp",
            () -> new BaseItem(new Item.Properties()).AddToList(VistampBar.PROTO_VISTAMP).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> KING_CRAB_VISTAMP = ITEMS.register("king_crab_vistamp",
            () -> new BaseItem(new Item.Properties()).AddToList(VistampBar.PROTO_VISTAMP).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> KUROSAI_VISTAMP = ITEMS.register("kurosai_vistamp",
            () -> new BaseItem(new Item.Properties()).AddToList(VistampBar.PROTO_VISTAMP).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> OCTOPUS_VISTAMP = ITEMS.register("octopus_vistamp",
            () -> new BaseItem(new Item.Properties()).AddToList(VistampBar.PROTO_VISTAMP).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> OOMUKADE_VISTAMP = ITEMS.register("oomukade_vistamp",
            () -> new BaseItem(new Item.Properties()).AddToList(VistampBar.PROTO_VISTAMP).AddToList(RiderTabs.REVICE_TAB_ITEM));
	
	public static final DeferredItem<Item> DAIOUIKA_VISTAMP = ITEMS.register("daiouika_vistamp",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> WOLF_VISTAMP = ITEMS.register("wolf_vistamp",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> PLANARIAN_VISTAMP = ITEMS.register("planarian_vistamp",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> CHAMELEON_VISTAMP = ITEMS.register("chameleon_vistamp",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> PROTO_PLANARIAN_VISTAMP = ITEMS.register("proto_planarian_vistamp",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> PROTO_CHAMELEON_VISTAMP = ITEMS.register("proto_chameleon_vistamp",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> SABERTIGER_VISTAMP = ITEMS.register("sabertiger_vistamp",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> PROTO_QUEEN_BEE_VISTAMP = ITEMS.register("proto_queen_bee_vistamp",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.REVICE_TAB_ITEM));
	
	public static final DeferredItem<Item> CHEETAH_VISTAMP = ITEMS.register("cheetah_vistamp",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> ELEPHANT_VISTAMP = ITEMS.register("elephant_vistamp",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> SHARK_VISTAMP = ITEMS.register("shark_vistamp",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> KOALA_VISTAMP = ITEMS.register("koala_vistamp",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.REVICE_TAB_ITEM));
	
	public static final DeferredItem<Item> RAFFLESIA_VISTAMP = ITEMS.register("raflessia_vistamp",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> PROTO_JACKAL_VISTAMP_VICE = ITEMS.register("proto_jackal_vistamp",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_jackal_concept","vice","buddy_buckle_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false))
					.SetPalyerModelInvisible().has_basic_model().model_has_different_name("jackal_vistamp").AddToList(RiderTabs.REVICE_TAB_ITEM));


	public static final DeferredItem<Item> OBLIVION_STAMP = ITEMS.register("oblivion_stamp",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> DEADMAN_STAMP = ITEMS.register("deadman_stamp",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> DOPANT_STAMP = ITEMS.register("dopant_stamp",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> INVES_STAMP = ITEMS.register("inves_stamp",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> ROIDMUDE_STAMP = ITEMS.register("roidmude_stamp",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> SMASH_STAMP = ITEMS.register("smash_stamp",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> WORM_STAMP = ITEMS.register("worm_stamp",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> GURONGI_STAMP = ITEMS.register("gurongi_stamp",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> FANGIRE_STAMP = ITEMS.register("fangire_stamp",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> ZODIARTS_STAMP = ITEMS.register("zodiarts_stamp",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> ORPHNOCH_STAMP = ITEMS.register("orphnoch_stamp",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.REVICE_TAB_ITEM));
	
	public static final DeferredItem<Item> REX_VISTAMP_METAL = ITEMS.register("rex_vistamp_metal",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> REX_VISTAMP_CHRISTMAS = ITEMS.register("rex_vistamp_christmas",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> REX_VISTAMP_THEME = ITEMS.register("rex_vistamp_theme",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> TOYSAURUS_VISTAMP = ITEMS.register("toysaurus_vistamp",
            () -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> TELEMAG_REX_VISTAMP = ITEMS.register("telemag_rex_vistamp",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> MAMMOTH_VISTAMP_CHINA = ITEMS.register("mammoth_vistamp_china",
			() -> new BaseItem(new Item.Properties()).AddToList(VistampBar.PROTO_VISTAMP, 1).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> GIFF_JUNIOR_VISTAMP = ITEMS.register("giff_junior_vistamp",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> GIFF_STAMP = ITEMS.register("giff_stamp",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> DIABLO_STAMP = ITEMS.register("diablo_stamp",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.REVICE_TAB_ITEM));

	public static final DeferredItem<Item> CYCLOTRON_DRIVER_CORE_BREAK = ITEMS.register("cyclotron_driver_core_break",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_break","century","cyclotron_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)));

	public static final DeferredItem<Item> CYCLOTRON_DRIVER_CORE = ITEMS.register("cyclotron_driver_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","century","cyclotron_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
					.addSwitchForm(CYCLOTRON_DRIVER_CORE_BREAK.get()).AddToList(RiderTabs.REVICE_TAB_ITEM));


	public static final DeferredItem<Item> GIFF_EYE = ITEMS.register("giff_eye",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.REVICE_TAB_ITEM));


	public static final DeferredItem<Item> REVICE_HELMET = ITEMS.register("revice_head",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.REVICE_TAB_ITEM).ChangeRepairItem(PROTO_VISTAMP.get()));
	public static final DeferredItem<Item> REVICE_CHESTPLATE = ITEMS.register("revice_troso",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.REVICE_TAB_ITEM).ChangeRepairItem(PROTO_VISTAMP.get()));
	public static final DeferredItem<Item> REVICE_LEGGINGS = ITEMS.register("revice_legs",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.REVICE_TAB_ITEM).ChangeRepairItem(PROTO_VISTAMP.get()));

	public static final DeferredItem<Item> REVICE_DRIVER = ITEMS.register("revice_driver",
			() -> new ReviceDriverItem(ArmorMaterials.DIAMOND,"revi",REX_VISTAMP ,REVICE_HELMET, REVICE_CHESTPLATE,REVICE_LEGGINGS , new Item.Properties().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)){
				@Override
				public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
					player.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.translatable("vistamp_holder.text");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
							packetBuffer.writeBlockPos(player.blockPosition());
							packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
							return new VistampHolderGuiMenu(id, inventory, packetBuffer,itemstack);
						}
					});
				}
			}.Has_Inventory_Gui().AddToTabList(RiderTabs.REVICE_TAB_ITEM).ChangeRepairItem(PROTO_VISTAMP.get()));

	public static final DeferredItem<Item> BUDDY_BUCKLE = ITEMS.register("vice_belt",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"vice",REX_VISTAMP_VICE ,REVICE_HELMET, REVICE_CHESTPLATE,REVICE_LEGGINGS ,
					new Item.Properties().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)){
				@Override
				public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
					player.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.translatable("vistamp_holder.text");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
							packetBuffer.writeBlockPos(player.blockPosition());
							packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
							return new VistampHolderGuiMenu(id, inventory, packetBuffer,itemstack);
						}
					});
				}
			}.Has_Inventory_Gui().AddToTabList(RiderTabs.REVICE_TAB_ITEM).ChangeRepairItem(PROTO_VISTAMP.get()));

	public static final DeferredItem<Item> TWO_SIDRIVER_LIVE = ITEMS.register("two_sidriver_live",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"live",BAT_VISTAMP ,REVICE_HELMET, REVICE_CHESTPLATE,REVICE_LEGGINGS ,
					new Item.Properties().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)){
				@Override
				public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
					player.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.translatable("vistamp_holder.text");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
							packetBuffer.writeBlockPos(player.blockPosition());
							packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
							return new VistampHolderGuiMenu(id, inventory, packetBuffer,itemstack);
						}
					});
				}
			}.Has_Inventory_Gui().AddToTabList(RiderTabs.REVICE_TAB_ITEM).ChangeRepairItem(PROTO_VISTAMP.get()));

	public static final DeferredItem<Item> TWO_SIDRIVER_EVIL = ITEMS.register("two_sidriver_evil",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"evil",BAT_VISTAMP_EVIL ,REVICE_HELMET, REVICE_CHESTPLATE,REVICE_LEGGINGS ,  new Item.Properties().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)){
				@Override
				public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
					player.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.translatable("vistamp_holder.text");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
							packetBuffer.writeBlockPos(player.blockPosition());
							packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
							return new VistampHolderGuiMenu(id, inventory, packetBuffer,itemstack);
						}
					});
				}
			}.Has_Inventory_Gui().AddToTabList(RiderTabs.REVICE_TAB_ITEM).ChangeRepairItem(PROTO_VISTAMP.get()));

	public static final DeferredItem<Item> LIBERA_DRIVER = ITEMS.register("libera_driver",
			() -> new LiberaDriverItem(ArmorMaterials.DIAMOND,"jeanne",COBRA_VISTAMP ,REVICE_HELMET, REVICE_CHESTPLATE,REVICE_LEGGINGS ,  new Item.Properties().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)){
				@Override
				public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
					player.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.translatable("vistamp_holder.text");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
							packetBuffer.writeBlockPos(player.blockPosition());
							packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
							return new VistampHolderGuiMenu(id, inventory, packetBuffer,itemstack);
						}
					});
				}
			}.Has_Inventory_Gui().AddToTabList(RiderTabs.REVICE_TAB_ITEM).ChangeRepairItem(PROTO_VISTAMP.get()));

	public static final DeferredItem<Item> LOVEKOV_BELT = ITEMS.register("lovekov_belt",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"lovekov",COBRA_VISTAMP ,REVICE_HELMET, REVICE_CHESTPLATE,REVICE_LEGGINGS , new Item.Properties())
					.Dont_show_belt_form_info().Override_belt_text("lovekov_belt_belt").AddToTabList(RiderTabs.REVICE_TAB_ITEM).has_basic_model().ChangeRepairItem(PROTO_VISTAMP.get()));


	public static final DeferredItem<Item> DEMONS_DRIVER = ITEMS.register("demons_driver",
			() -> new DemonsDriverItem(ArmorMaterials.DIAMOND,"demons",SPIDER_VISTAMP ,REVICE_HELMET, REVICE_CHESTPLATE,REVICE_LEGGINGS ,  new Item.Properties().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)){
				@Override
				public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
					player.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.translatable("vistamp_holder.text");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
							packetBuffer.writeBlockPos(player.blockPosition());
							packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
							return new VistampHolderGuiMenu(id, inventory, packetBuffer,itemstack);
						}
					});
				}
			}.Has_Inventory_Gui().AddToTabList(RiderTabs.REVICE_TAB_ITEM).ChangeRepairItem(PROTO_VISTAMP.get()));

	public static final DeferredItem<Item> OVER_DEMONS_DRIVER = ITEMS.register("over_demons_driver",
			() -> new DemonsDriverItem(ArmorMaterials.DIAMOND,"over_demons",KUWAGATA_VISTAMP ,REVICE_HELMET, REVICE_CHESTPLATE,REVICE_LEGGINGS ,  new Item.Properties().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)){
				@Override
				public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
					player.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.translatable("vistamp_holder.text");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
							packetBuffer.writeBlockPos(player.blockPosition());
							packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
							return new VistampHolderGuiMenu(id, inventory, packetBuffer,itemstack);
						}
					});
				}
			}.Has_Inventory_Gui().AddToTabList(RiderTabs.REVICE_TAB_ITEM).ChangeRepairItem(PROTO_VISTAMP.get()));

	public static final DeferredItem<Item> GET_OVER_DEMONS_DRIVER = ITEMS.register("get_over_demons_driver",
			() -> new DemonsDriverItem(ArmorMaterials.DIAMOND,"over_demons_get",GIRAFFA_VISTAMP ,REVICE_HELMET, REVICE_CHESTPLATE,REVICE_LEGGINGS ,
					new Item.Properties().rarity(Rarity.UNCOMMON).component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)){
				@Override
				public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
					player.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.translatable("vistamp_holder.text");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
							packetBuffer.writeBlockPos(player.blockPosition());
							packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
							return new VistampHolderGuiMenu(id, inventory, packetBuffer,itemstack);
						}
					});
				}
			}.Has_Inventory_Gui().AddToTabList(RiderTabs.REVICE_TAB_ITEM).ChangeRepairItem(PROTO_VISTAMP.get()));


	public static final DeferredItem<Item> DEMONS_DRIVER_DEMONS_TROOPER_A = ITEMS.register("demons_driver_demons_trooper_a",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"demons_trooper_alpha",TROOPER_SPIDER_VISTAMP ,REVICE_HELMET, REVICE_CHESTPLATE,REVICE_LEGGINGS , new Item.Properties())
					.Dont_show_belt_form_info().AddToTabList(RiderTabs.REVICE_TAB_ITEM).ChangeRepairItem(PROTO_VISTAMP.get()));

	public static final DeferredItem<Item> DEMONS_DRIVER_DEMONS_TROOPER_B = ITEMS.register("demons_driver_demons_trooper_b",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"demons_trooper_beta",TROOPER_KUWAGATA_VISTAMP ,REVICE_HELMET, REVICE_CHESTPLATE,REVICE_LEGGINGS , new Item.Properties())
					.Dont_show_belt_form_info().AddToTabList(RiderTabs.REVICE_TAB_ITEM).ChangeRepairItem(PROTO_VISTAMP.get()));

	public static final DeferredItem<Item> VAIL_DRIVER = ITEMS.register("vail_driver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"vail",KABUTO_VISTAMP ,REVICE_HELMET, REVICE_CHESTPLATE,REVICE_LEGGINGS ,
					new Item.Properties().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)){
				@Override
				public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
					player.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.translatable("vistamp_holder.text");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
							packetBuffer.writeBlockPos(player.blockPosition());
							packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
							return new VistampHolderGuiMenu(id, inventory, packetBuffer,itemstack);
						}
					});
				}
			}.Has_Inventory_Gui().AddToTabList(RiderTabs.REVICE_TAB_ITEM).ChangeRepairItem(PROTO_VISTAMP.get()));

	public static final DeferredItem<Item> DESTREAM_DRIVER = ITEMS.register("destream_driver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"destream",HERCULES_VISTAMP ,REVICE_HELMET, REVICE_CHESTPLATE,REVICE_LEGGINGS ,
					new Item.Properties().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)){
				@Override
				public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
					player.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.translatable("vistamp_holder.text");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
							packetBuffer.writeBlockPos(player.blockPosition());
							packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
							return new VistampHolderGuiMenu(id, inventory, packetBuffer,itemstack);
						}
					});
				}
			}.Has_Inventory_Gui().AddToTabList(RiderTabs.REVICE_TAB_ITEM).ChangeRepairItem(PROTO_VISTAMP.get()));

	public static final DeferredItem<Item> VAIL_BELT = ITEMS.register("vail_belt",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"crimson_vail",CRIMSON_VAIL_VISTAMP ,REVICE_HELMET, REVICE_CHESTPLATE,REVICE_LEGGINGS , new Item.Properties().rarity(Rarity.UNCOMMON))
					.Dont_show_belt_form_info().AddToTabList(RiderTabs.REVICE_TAB_ITEM).ChangeRepairItem(PROTO_VISTAMP.get()));

	public static final DeferredItem<Item> VADE_BELT = ITEMS.register("vade_belt",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"blood_vade",BLOOD_VADE_VISTAMP ,REVICE_HELMET, REVICE_CHESTPLATE,REVICE_LEGGINGS , new Item.Properties().rarity(Rarity.UNCOMMON))
					.Dont_show_belt_form_info().AddToTabList(RiderTabs.REVICE_TAB_ITEM).ChangeRepairItem(PROTO_VISTAMP.get()));

	
	public static final DeferredItem<Item> WEEK_ENDRIVER = ITEMS.register("week_endriver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"aguilera",QUEEN_BEE_VISTAMP ,REVICE_HELMET, REVICE_CHESTPLATE,REVICE_LEGGINGS ,
					new Item.Properties().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)){
				@Override
				public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
					player.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.translatable("vistamp_holder.text");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
							packetBuffer.writeBlockPos(player.blockPosition());
							packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
							return new VistampHolderGuiMenu(id, inventory, packetBuffer,itemstack);
						}
					});
				}
			}.Has_Inventory_Gui().Dont_show_belt_form_info().AddToTabList(RiderTabs.REVICE_TAB_ITEM).ChangeRepairItem(PROTO_VISTAMP.get()));

	public static final DeferredItem<Item> DARK_WEEK_ENDRIVER = ITEMS.register("dark_week_endriver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"dark_aguilera",QUEEN_BEE_VISTAMP ,REVICE_HELMET, REVICE_CHESTPLATE,REVICE_LEGGINGS ,
					new Item.Properties().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)){
				@Override
				public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
					player.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.translatable("vistamp_holder.text");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
							packetBuffer.writeBlockPos(player.blockPosition());
							packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
							return new VistampHolderGuiMenu(id, inventory, packetBuffer,itemstack);
						}
					});
				}
			}.Has_Inventory_Gui().Dont_show_belt_form_info().AddToTabList(RiderTabs.REVICE_TAB_ITEM).ChangeRepairItem(PROTO_VISTAMP.get()));

	public static final DeferredItem<Item> CHIMERA_DRIVER = ITEMS.register("chimera_driver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"chimera",TWIN_CHIMERA_VISTAMP ,REVICE_HELMET, REVICE_CHESTPLATE,REVICE_LEGGINGS ,
					new Item.Properties().rarity(Rarity.UNCOMMON).component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)){
				@Override
				public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
					player.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.translatable("vistamp_holder.text");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
							packetBuffer.writeBlockPos(player.blockPosition());
							packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
							return new VistampHolderGuiMenu(id, inventory, packetBuffer,itemstack);
						}
					});
				}
			}.Has_Inventory_Gui().Dont_show_belt_form_info().AddToTabList(RiderTabs.REVICE_TAB_ITEM).ChangeRepairItem(PROTO_VISTAMP.get()));

	public static final DeferredItem<Item> CHIMERA_DRIVER_DAIMON = ITEMS.register("chimera_driver_daimon",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"daimon",TRI_CHIMERA_VISTAMP ,REVICE_HELMET, REVICE_CHESTPLATE,REVICE_LEGGINGS ,
					new Item.Properties().rarity(Rarity.UNCOMMON).component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)){
				@Override
				public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
					player.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.translatable("vistamp_holder.text");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
							packetBuffer.writeBlockPos(player.blockPosition());
							packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
							return new VistampHolderGuiMenu(id, inventory, packetBuffer,itemstack);
						}
					});
				}
			}.Has_Inventory_Gui().Dont_show_belt_form_info().AddToTabList(RiderTabs.REVICE_TAB_ITEM).ChangeRepairItem(PROTO_VISTAMP.get()));

	public static final DeferredItem<Item> JUUGA_DRIVER = ITEMS.register("juuga_driver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"juuga",JUUGA_VISTAMP ,REVICE_HELMET, REVICE_CHESTPLATE,REVICE_LEGGINGS ,
					new Item.Properties().rarity(Rarity.RARE).component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)){
				@Override
				public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
					player.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.translatable("vistamp_holder.text");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
							packetBuffer.writeBlockPos(player.blockPosition());
							packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
							return new VistampHolderGuiMenu(id, inventory, packetBuffer,itemstack);
						}
					});
				}
			}.Has_Inventory_Gui().Dont_show_belt_form_info().AddToTabList(RiderTabs.REVICE_TAB_ITEM).ChangeRepairItem(PROTO_VISTAMP.get()));

	public static final DeferredItem<Item> CYCLOTRON_DRIVER = ITEMS.register("cyclotron_driver",
			() -> new CyclotronDriverItem(ArmorMaterials.DIAMOND,"century",CYCLOTRON_DRIVER_CORE ,REVICE_HELMET, REVICE_CHESTPLATE,REVICE_LEGGINGS , new Item.Properties())
			.AddToTabList(RiderTabs.REVICE_TAB_ITEM).ChangeRepairItem(PROTO_VISTAMP.get()));

	public static final DeferredItem<Item> REVICE_DRIVER_LIVE = ITEMS.register("revice_driver_live",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"live_marvelous",MEGA_BAT_VISTAMP ,REVICE_HELMET, REVICE_CHESTPLATE,REVICE_LEGGINGS ,
					new Item.Properties().rarity(Rarity.UNCOMMON).component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)){
				@Override
				public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
					player.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.translatable("vistamp_holder.text");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
							packetBuffer.writeBlockPos(player.blockPosition());
							packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
							return new VistampHolderGuiMenu(id, inventory, packetBuffer,itemstack);
						}
					});
				}
			}.Has_Inventory_Gui().Dont_show_belt_form_info().AddToTabList(RiderTabs.REVICE_TAB_ITEM).ChangeRepairItem(PROTO_VISTAMP.get()));

	public static final DeferredItem<Item> REVICE_DRIVER_EVIL = ITEMS.register("revice_driver_evil",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"evil_marvelous",MEGA_BAT_VISTAMP ,REVICE_HELMET, REVICE_CHESTPLATE,REVICE_LEGGINGS ,
					new Item.Properties().rarity(Rarity.UNCOMMON).component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)){
				@Override
				public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
					player.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.translatable("vistamp_holder.text");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
							packetBuffer.writeBlockPos(player.blockPosition());
							packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
							return new VistampHolderGuiMenu(id, inventory, packetBuffer,itemstack);
						}
					});
				}
			}.Has_Inventory_Gui().Dont_show_belt_form_info().AddToTabList(RiderTabs.REVICE_TAB_ITEM).ChangeRepairItem(PROTO_VISTAMP.get()));

	public static final DeferredItem<Item> DEMONS_DRIVER_ORTECA = ITEMS.register("demons_driver_orteca",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"orteca",KRAKEN_VISTAMP ,REVICE_HELMET, REVICE_CHESTPLATE,REVICE_LEGGINGS , new Item.Properties())
					.Dont_show_belt_form_info().AddToTabList(RiderTabs.REVICE_TAB_ITEM).ChangeRepairItem(PROTO_VISTAMP.get()));

    public static final DeferredItem<Item> OHINBUSTER_50 = ITEMS.register("ohin_buster_50",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).IsSwordGun().AddToTabList(RiderTabs.REVICE_TAB_ITEM).ChangeRepairItem(PROTO_VISTAMP.get()));

	public static final DeferredItem<Item> GUNDEPHONE_50 = ITEMS.register("gun_de_phone_50",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.REVICE_TAB_ITEM).ChangeRepairItem(PROTO_VISTAMP.get()));

	public static final DeferredItem<Item> OSUTODERUHAMMER_50 = ITEMS.register("osutoderu_hammer_50",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.REVICE_TAB_ITEM).ChangeRepairItem(PROTO_VISTAMP.get()));

	public static final DeferredItem<Item> REVICELASHER = ITEMS.register("revice_lasher",
            () -> new BaseSwordItem(Tiers.DIAMOND, 8, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.REVICE_TAB_ITEM).ChangeRepairItem(PROTO_VISTAMP.get()));
	
	public static final DeferredItem<Item> BARID_SHIELD = ITEMS.register("egg_shield",
            () -> new BaseShieldItem(new Item.Properties().rarity(Rarity.UNCOMMON)).AddToTabList(RiderTabs.REVICE_TAB_ITEM).ChangeRepairItem(PROTO_VISTAMP.get()));

    public static final DeferredItem<Item> MAMMOTH_GASHER  = ITEMS.register("mammoth_gasher",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.REVICE_TAB_ITEM).ChangeRepairItem(PROTO_VISTAMP.get()));

	public static final DeferredItem<Item> KAMAKIRIC_ARROW = ITEMS.register("kamakiric_arrow",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.REVICE_TAB_ITEM).ChangeRepairItem(PROTO_VISTAMP.get()));

	public static final DeferredItem<Item> EVILBLADE = ITEMS.register("evil_blade",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.REVICE_TAB_ITEM).ChangeRepairItem(PROTO_VISTAMP.get()));

	public static final DeferredItem<Item> LIVEGUN = ITEMS.register("live_gun",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.REVICE_TAB_ITEM).ChangeRepairItem(PROTO_VISTAMP.get()));

    public static final DeferredItem<Item> LOVEKOV_KUJAKU = ITEMS.register("lovekov_kujaku",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.REVICE_TAB_ITEM).ChangeRepairItem(PROTO_VISTAMP.get()));

	public static final DeferredItem<Item> LOVEKOV_TURTLE = ITEMS.register("lovekov_turtle",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.REVICE_TAB_ITEM).ChangeRepairItem(PROTO_VISTAMP.get()));

	public static final DeferredItem<Item> LOVEKOV_HASHIBIROKO = ITEMS.register("lovekov_hashibiroko",
            () -> new BaseSwordItem(Tiers.DIAMOND, 13, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.REVICE_TAB_ITEM).ChangeRepairItem(PROTO_VISTAMP.get()));

	public static final DeferredItem<Item> LOVEKOV_TRICERA = ITEMS.register("lovekov_tricera",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.REVICE_TAB_ITEM).ChangeRepairItem(PROTO_VISTAMP.get()));

    public static final DeferredItem<Item> NEEDLE_KUNAI = ITEMS.register("needle_kunai",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.REVICE_TAB_ITEM).ChangeRepairItem(PROTO_VISTAMP.get()));

    public static final DeferredItem<Item> GIFF_JUNIOR_SWORD = ITEMS.register("giff_junior_sword",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.REVICE_TAB_ITEM).ChangeRepairItem(PROTO_VISTAMP.get()));

	public static final DeferredItem<Item> PARANEGRO = ITEMS.register("paranegro",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.REVICE_TAB_ITEM).ChangeRepairItem(PROTO_VISTAMP.get()));

    public static final DeferredItem<Item> BUFFALO_GEKIRIN = ITEMS.register("buffalo_disks",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.REVICE_TAB_ITEM).ChangeRepairItem(PROTO_VISTAMP.get()));

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}

}
