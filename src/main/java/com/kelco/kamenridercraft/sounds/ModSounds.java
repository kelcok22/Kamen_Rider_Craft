package com.kelco.kamenridercraft.sounds;

import java.util.function.Supplier;

import com.kelco.kamenridercraft.KamenRiderCraftCore;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, KamenRiderCraftCore.MOD_ID);

    public static final Supplier<SoundEvent> LETS_GO_RIDER_KICK = registerSoundEvent("lets_go_rider_kick");
    public static final ResourceKey<JukeboxSong> LETS_GO_RIDER_KICK_KEY = createSong("lets_go_rider_kick");

    public static final Supplier<SoundEvent> TATAKAE_KAMEN_RIDER_V3= registerSoundEvent("tatakae_kamen_rider_v3");
    public static final ResourceKey<JukeboxSong> TATAKAE_KAMEN_RIDER_V3_KEY = createSong("tatakae_kamen_rider_v3");

    public static final Supplier<SoundEvent> SET_UP_KAMEN_RIDER_X= registerSoundEvent("set_up_kamen_rider_x");
    public static final ResourceKey<JukeboxSong> SET_UP_KAMEN_RIDER_X_KEY = createSong("set_up_kamen_rider_x");

    public static final Supplier<SoundEvent> AMAZON_RIDER_KOKO_NI_ARI= registerSoundEvent("amazon_rider_koko_ni_ari");
    public static final ResourceKey<JukeboxSong> AMAZON_RIDER_KOKO_NI_ARI_KEY = createSong("amazon_rider_koko_ni_ari");

    public static final Supplier<SoundEvent> KAMEN_RIDER_STRONGER_NO_UTA= registerSoundEvent("kamen_rider_stronger_no_uta");
    public static final ResourceKey<JukeboxSong> KAMEN_RIDER_STRONGER_NO_UTA_KEY = createSong("kamen_rider_stronger_no_uta");

    public static final Supplier<SoundEvent> MOERO_KAMEN_RIDER= registerSoundEvent("moero_kamen_rider");
    public static final ResourceKey<JukeboxSong> MOERO_KAMEN_RIDER_KEY = createSong("moero_kamen_rider");

    public static final Supplier<SoundEvent> KAMEN_RIDER_SUPER_1= registerSoundEvent("kamen_rider_super_1");
    public static final ResourceKey<JukeboxSong> KAMEN_RIDER_SUPER_1_KEY = createSong("kamen_rider_super_1");

    public static final Supplier<SoundEvent> DRAGON_ROAD= registerSoundEvent("dragon_road");
    public static final ResourceKey<JukeboxSong> DRAGON_ROAD_KEY = createSong("dragon_road");

    public static final Supplier<SoundEvent> KAMEN_RIDER_BLACK= registerSoundEvent("kamen_rider_black");
    public static final ResourceKey<JukeboxSong> KAMEN_RIDER_BLACK_KEY = createSong("kamen_rider_black");

    public static final Supplier<SoundEvent> KAMEN_RIDER_BLACK_RX= registerSoundEvent("kamen_rider_black_rx");
    public static final ResourceKey<JukeboxSong> KAMEN_RIDER_BLACK_RX_KEY = createSong("kamen_rider_black_rx");

    public static final Supplier<SoundEvent> KAMEN_RIDER_KUUGA= registerSoundEvent("kamen_rider_kuuga");
    public static final ResourceKey<JukeboxSong> KAMEN_RIDER_KUUGA_KEY = createSong("kamen_rider_kuuga");

    public static final Supplier<SoundEvent> KAMEN_RIDER_AGITO= registerSoundEvent("kamen_rider_agito");
    public static final ResourceKey<JukeboxSong> KAMEN_RIDER_AGITO_KEY = createSong("kamen_rider_agito");

    public static final Supplier<SoundEvent> ALIVE_A_LIFE= registerSoundEvent("alive_a_life");
    public static final ResourceKey<JukeboxSong> ALIVE_A_LIFE_KEY = createSong("alive_a_life");

    public static final Supplier<SoundEvent> JUSTIFAIZ= registerSoundEvent("justifaiz");
    public static final ResourceKey<JukeboxSong> JUSTIFAIZ_KEY = createSong("justifaiz");

    public static final Supplier<SoundEvent> ROUND_ZERO_BLADE_BRAVE= registerSoundEvent("round_zero_blade_brave");
    public static final ResourceKey<JukeboxSong> ROUND_ZERO_BLADE_BRAVE_KEY = createSong("round_zero_blade_brave");

    public static final Supplier<SoundEvent> ELEMENTS= registerSoundEvent("elements");
    public static final ResourceKey<JukeboxSong> ELEMENTS_KEY = createSong("elements");

    public static final Supplier<SoundEvent> REBIRTH= registerSoundEvent("rebirth");
    public static final ResourceKey<JukeboxSong> REBIRTH_KEY = createSong("rebirth");

    public static final Supplier<SoundEvent> KAGAYAKI= registerSoundEvent("kagayaki");
    public static final ResourceKey<JukeboxSong> KAGAYAKI_KEY = createSong("kagayaki");

    public static final Supplier<SoundEvent> NEXT_LEVEL= registerSoundEvent("next_level");
    public static final ResourceKey<JukeboxSong> NEXT_LEVEL_KEY = createSong("next_level");

    public static final Supplier<SoundEvent> CLIMAX_JUMP= registerSoundEvent("climax_jump");
    public static final ResourceKey<JukeboxSong> CLIMAX_JUMP_KEY = createSong("climax_jump");

    public static final Supplier<SoundEvent> BREAK_THE_CHAIN= registerSoundEvent("break_the_chain");
    public static final ResourceKey<JukeboxSong> BREAK_THE_CHAIN_KEY = createSong("break_the_chain");

    public static final Supplier<SoundEvent> JOURNEY_THROUGH_THE_DECADE= registerSoundEvent("journey_through_the_decade");
    public static final ResourceKey<JukeboxSong> JOURNEY_THROUGH_THE_DECADE_KEY = createSong("journey_through_the_decade");

    public static final Supplier<SoundEvent> WBX= registerSoundEvent("w_b_x_w_boiled_xtreme");
    public static final ResourceKey<JukeboxSong> WBX_KEY = createSong("w_b_x_w_boiled_xtreme");

    public static final Supplier<SoundEvent> ANYTHING_GOES= registerSoundEvent("anything_goes");
    public static final ResourceKey<JukeboxSong> ANYTHING_GOES_KEY = createSong("anything_goes");

    public static final Supplier<SoundEvent> SWITCH_ON= registerSoundEvent("switch_on");
    public static final ResourceKey<JukeboxSong> SWITCH_ON_KEY = createSong("switch_on");

    public static final Supplier<SoundEvent> LIFE_IS_SHOWTIME= registerSoundEvent("life_is_showtime");
    public static final ResourceKey<JukeboxSong> LIFE_IS_SHOWTIME_KEY = createSong("life_is_showtime");

    public static final Supplier<SoundEvent> JUST_LIVE_MORE= registerSoundEvent("just_live_more");
    public static final ResourceKey<JukeboxSong> JUST_LIVE_MORE_KEY = createSong("just_live_more");

    public static final Supplier<SoundEvent> SURPRISE_DRIVE= registerSoundEvent("surprise_drive");
    public static final ResourceKey<JukeboxSong> SURPRISE_DRIVE_KEY = createSong("surprise_drive");

    public static final Supplier<SoundEvent> WARERA_OMOU_YUE_NI_WARERA_ARI= registerSoundEvent("warera_omou_yue_ni_warera_ari");
    public static final ResourceKey<JukeboxSong> WARERA_OMOU_YUE_NI_WARERA_ARI_KEY = createSong("warera_omou_yue_ni_warera_ari");

    public static final Supplier<SoundEvent> EXCITE= registerSoundEvent("excite");
    public static final ResourceKey<JukeboxSong> EXCITE_KEY = createSong("excite");

    public static final Supplier<SoundEvent> BE_THE_ONE= registerSoundEvent("be_the_one");
    public static final ResourceKey<JukeboxSong> BE_THE_ONE_KEY = createSong("be_the_one");

    public static final Supplier<SoundEvent> OVER_QUARTZER= registerSoundEvent("over_quartzer");
    public static final ResourceKey<JukeboxSong> OVER_QUARTZER_KEY = createSong("over_quartzer");

    public static final Supplier<SoundEvent> P_A_R_T_Y_UNIVERSE_FESTIVAL= registerSoundEvent("p_a_r_t_y_universe_festival");
    public static final ResourceKey<JukeboxSong> P_A_R_T_Y_UNIVERSE_FESTIVAL_KEY = createSong("p_a_r_t_y_universe_festival");

    public static final Supplier<SoundEvent> REAL_X_EYEZ= registerSoundEvent("realxeyez");
    public static final ResourceKey<JukeboxSong> REAL_X_EYEZ_KEY = createSong("realxeyez");

    public static final Supplier<SoundEvent> ALMIGHTY= registerSoundEvent("almighty");
    public static final ResourceKey<JukeboxSong> ALMIGHTY_KEY = createSong("almighty");

    public static final Supplier<SoundEvent> LIVEDEVIL= registerSoundEvent("livedevil");
    public static final ResourceKey<JukeboxSong> LIVEDEVIL_KEY = createSong("livedevil");

    public static final Supplier<SoundEvent> GEORGE_KARIZAKIS_RIDER_SYSTEM= registerSoundEvent("george_karizakis_rider_system");
    public static final ResourceKey<JukeboxSong> GEORGE_KARIZAKIS_RIDER_SYSTEM_KEY = createSong("george_karizakis_rider_system");

    public static final Supplier<SoundEvent> TRUST_LAST= registerSoundEvent("trust_last");
    public static final ResourceKey<JukeboxSong> TRUST_LAST_KEY = createSong("trust_last");

    public static final Supplier<SoundEvent> CHEMY_X_STORY= registerSoundEvent("chemy_x_story");
    public static final ResourceKey<JukeboxSong> CHEMY_X_STORY_KEY = createSong("chemy_x_story");

    public static final Supplier<SoundEvent> CHEMY_X_STORY_FLOW= registerSoundEvent("chemy_x_story_flow");
    public static final ResourceKey<JukeboxSong> CHEMY_X_STORY_FLOW_KEY = createSong("chemy_x_story_flow");

    public static final Supplier<SoundEvent> GOT_BOOST= registerSoundEvent("got_boost");
    public static final ResourceKey<JukeboxSong> GOT_BOOST_KEY = createSong("got_boost");

    public static final Supplier<SoundEvent> VISIONS= registerSoundEvent("visions");
    public static final ResourceKey<JukeboxSong> VISIONS_KEY = createSong("visions");

    public static final Supplier<SoundEvent> MASKED_RIDER= registerSoundEvent("masked_rider");
    public static final ResourceKey<JukeboxSong> MASKED_RIDER_KEY = createSong("masked_rider");

    public static final Supplier<SoundEvent> MIRROR_NOISES= registerSoundEvent("mirror_noises");

    private static ResourceKey<JukeboxSong> createSong(String name) {
        return ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, name));
    }

    private static Supplier<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}