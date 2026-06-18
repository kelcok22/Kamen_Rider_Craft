package com.kelco.kamenridercraft.item.misc_items;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.sounds.ModSounds;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MusicDiscItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);

    public static final DeferredItem<Item> LETS_GO_RIDER_MUSIC_DISC = ITEMS.register("lets_go_rider_kick_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.LETS_GO_RIDER_KICK_KEY).stacksTo(1)));

    public static final DeferredItem<Item> TATAKAE_KAMEN_RIDER_V3_MUSIC_DISC = ITEMS.register("tatakae_kamen_rider_v3_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.TATAKAE_KAMEN_RIDER_V3_KEY).stacksTo(1)));

    public static final DeferredItem<Item> SET_UP_KAMEN_RIDER_X_MUSIC_DISC = ITEMS.register("set_up_kamen_rider_x_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.SET_UP_KAMEN_RIDER_X_KEY).stacksTo(1)));

    public static final DeferredItem<Item> AMAZON_RIDER_KOKO_NI_ARI_MUSIC_DISC = ITEMS.register("amazon_rider_koko_ni_ari_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.AMAZON_RIDER_KOKO_NI_ARI_KEY).stacksTo(1)));

    public static final DeferredItem<Item> KAMEN_RIDER_STRONGER_NO_UTA_MUSIC_DISC = ITEMS.register("kamen_rider_stronger_no_uta_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.KAMEN_RIDER_STRONGER_NO_UTA_KEY).stacksTo(1)));

    public static final DeferredItem<Item> MOERO_KAMEN_RIDER_MUSIC_DISC = ITEMS.register("moero_kamen_rider_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.MOERO_KAMEN_RIDER_KEY).stacksTo(1)));

    public static final DeferredItem<Item> KAMEN_RIDER_SUPER_1_MUSIC_DISC = ITEMS.register("kamen_rider_super_1_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.KAMEN_RIDER_SUPER_1_KEY).stacksTo(1)));

    public static final DeferredItem<Item> DRAGON_ROAD_MUSIC_DISC = ITEMS.register("dragon_road_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.DRAGON_ROAD_KEY).stacksTo(1)));

    public static final DeferredItem<Item> KAMEN_RIDER_BLACK_MUSIC_DISC = ITEMS.register("kamen_rider_black_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.KAMEN_RIDER_BLACK_KEY).stacksTo(1)));

    public static final DeferredItem<Item> KAMEN_RIDER_BLACK_RX_MUSIC_DISC = ITEMS.register("kamen_rider_black_rx_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.KAMEN_RIDER_BLACK_RX_KEY).stacksTo(1)));

    public static final DeferredItem<Item> AI_GA_TOMARANAI_MUSIC_DISC = ITEMS.register("ai_ga_tomaranai_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.AI_GA_TOMARANAI_KEY).stacksTo(1)));

    public static final DeferredItem<Item> KOKORO_TSUNAGU_AI_MUSIC_DISC = ITEMS.register("kokoro_tsunagu_ai_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.KOKORO_TSUNAGU_AI_KEY).stacksTo(1)));

    public static final DeferredItem<Item> KAMEN_RIDER_KUUGA_MUSIC_DISC = ITEMS.register("kamen_rider_kuuga_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.KAMEN_RIDER_KUUGA_KEY).stacksTo(1)));

    public static final DeferredItem<Item> KAMEN_RIDER_AGITO_MUSIC_DISC = ITEMS.register("kamen_rider_agito_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.KAMEN_RIDER_AGITO_KEY).stacksTo(1)));

    public static final DeferredItem<Item> ALIVE_A_LIFE_MUSIC_DISC = ITEMS.register("alive_a_life_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.ALIVE_A_LIFE_KEY).stacksTo(1)));

    public static final DeferredItem<Item> JUSTIFAIZ_MUSIC_DISC = ITEMS.register("justifaiz_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.JUSTIFAIZ_KEY).stacksTo(1)));

    public static final DeferredItem<Item> ROUND_ZERO_BLADE_BRAVE_MUSIC_DISC = ITEMS.register("round_zero_blade_brave_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.ROUND_ZERO_BLADE_BRAVE_KEY).stacksTo(1)));

    public static final DeferredItem<Item> ELEMENTS_MUSIC_DISC = ITEMS.register("elements_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.ELEMENTS_KEY).stacksTo(1)));

    public static final DeferredItem<Item> REBIRTH_MUSIC_DISC = ITEMS.register("rebirth_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.REBIRTH_KEY).stacksTo(1)));

    public static final DeferredItem<Item> KAGAYAKI_MUSIC_DISC = ITEMS.register("kagayaki_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.KAGAYAKI_KEY).stacksTo(1)));

    public static final DeferredItem<Item> HAJIMARI_NO_KIMI_E_MUSIC_DISC = ITEMS.register("hajimari_no_kimi_e_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.HAJIMARI_NO_KIMI_E_KEY).stacksTo(1)));

    public static final DeferredItem<Item> NEXT_LEVEL_MUSIC_DISC = ITEMS.register("next_level_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.NEXT_LEVEL_KEY).stacksTo(1)));

    public static final DeferredItem<Item> CLIMAX_JUMP_MUSIC_DISC = ITEMS.register("climax_jump_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.CLIMAX_JUMP_KEY).stacksTo(1)));

    public static final DeferredItem<Item> BREAK_THE_CHAIN_MUSIC_DISC = ITEMS.register("break_the_chain_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.BREAK_THE_CHAIN_KEY).stacksTo(1)));

    public static final DeferredItem<Item> JOURNEY_THROUGH_THE_DECADE_MUSIC_DISC = ITEMS.register("journey_through_the_decade_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.JOURNEY_THROUGH_THE_DECADE_KEY).stacksTo(1)));

    public static final DeferredItem<Item> WBX_MUSIC_DISC = ITEMS.register("w_b_x_w_boiled_xtreme_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.WBX_KEY).stacksTo(1)));

    public static final DeferredItem<Item> ANYTHING_GOES_MUSIC_DISC = ITEMS.register("anything_goes_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.ANYTHING_GOES_KEY).stacksTo(1)));

    public static final DeferredItem<Item> SWITCH_ON_MUSIC_DISC = ITEMS.register("switch_on_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.SWITCH_ON_KEY).stacksTo(1)));

    public static final DeferredItem<Item> LIFE_IS_SHOWTIME_MUSIC_DISC = ITEMS.register("life_is_showtime_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.LIFE_IS_SHOWTIME_KEY).stacksTo(1)));

    public static final DeferredItem<Item> JUST_LIVE_MORE_MUSIC_DISC = ITEMS.register("just_live_more_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.JUST_LIVE_MORE_KEY).stacksTo(1)));

    public static final DeferredItem<Item> SURPRISE_DRIVE_MUSIC_DISC = ITEMS.register("surprise_drive_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.SURPRISE_DRIVE_KEY).stacksTo(1)));

    public static final DeferredItem<Item> WARERA_OMOU_YUE_NI_WARERA_ARI_MUSIC_DISC = ITEMS.register("warera_omou_yue_ni_warera_ari_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.WARERA_OMOU_YUE_NI_WARERA_ARI_KEY).stacksTo(1)));

    public static final DeferredItem<Item> EXCITE_KEY_MUSIC_DISC = ITEMS.register("excite_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.EXCITE_KEY).stacksTo(1)));

    public static final DeferredItem<Item> BE_THE_ONE_MUSIC_DISC = ITEMS.register("be_the_one_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.BE_THE_ONE_KEY).stacksTo(1)));

    public static final DeferredItem<Item> OVER_QUARTZER_MUSIC_DISC = ITEMS.register("over_quartzer_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.OVER_QUARTZER_KEY).stacksTo(1)));

    public static final DeferredItem<Item> IZANAGI_MUSIC_DISC = ITEMS.register("izanagi_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.IZANAGI_KEY).stacksTo(1)));

    public static final DeferredItem<Item> P_A_R_T_Y_UNIVERSE_FESTIVAL_MUSIC_DISC = ITEMS.register("p_a_r_t_y_universe_festival_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.P_A_R_T_Y_UNIVERSE_FESTIVAL_KEY).stacksTo(1)));

    public static final DeferredItem<Item> REAL_X_EYEZ_MUSIC_DISC = ITEMS.register("realxeyez_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.REAL_X_EYEZ_KEY).stacksTo(1)));

    public static final DeferredItem<Item> ALMIGHTY_MUSIC_DISC = ITEMS.register("almighty_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.ALMIGHTY_KEY).stacksTo(1)));

    public static final DeferredItem<Item> LIVEDEVIL_MUSIC_DISC = ITEMS.register("livedevil_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.LIVEDEVIL_KEY).stacksTo(1)));

    public static final DeferredItem<Item> GEORGE_KARIZAKIS_RIDER_SYSTEM_MUSIC_DISC = ITEMS.register("george_karizakis_rider_system_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.GEORGE_KARIZAKIS_RIDER_SYSTEM_KEY).stacksTo(1)));

    public static final DeferredItem<Item> TRUST_LAST_MUSIC_DISC = ITEMS.register("trust_last_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.TRUST_LAST_KEY).stacksTo(1)));

    public static final DeferredItem<Item> CHEMY_X_STORY_MUSIC_DISC = ITEMS.register("chemy_x_story_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.CHEMY_X_STORY_KEY).stacksTo(1)));

    public static final DeferredItem<Item> CHEMY_X_STORY_FLOW_MUSIC_DISC = ITEMS.register("chemy_x_story_flow_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.CHEMY_X_STORY_FLOW_KEY).stacksTo(1)));

    public static final DeferredItem<Item> GOT_BOOST_MUSIC_DISC = ITEMS.register("got_boost_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.GOT_BOOST_KEY).stacksTo(1)));

    public static final DeferredItem<Item> VISIONS_MUSIC_DISC = ITEMS.register("visions_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.VISIONS_KEY).stacksTo(1)));

    public static final DeferredItem<Item> PLAY_BACK_MUSIC_DISC = ITEMS.register("play_back_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.PLAY_BACK_KEY).stacksTo(1)));

    public static final DeferredItem<Item> MASKED_RIDER_MUSIC_DISC = ITEMS.register("masked_rider_music_disc",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.MASKED_RIDER_KEY).stacksTo(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
