package com.kelco.kamenridercraft.sounds;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.util.DeferredSoundType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, KamenRiderCraftCore.MOD_ID);

    public static final Supplier<SoundEvent> LETS_GO_RIDER_KICK = registerSoundEvent("lets_go_rider_kick");
    public static final ResourceKey<JukeboxSong> LETS_GO_RIDER_KICK_KEY = createSong("lets_go_rider_kick");

    public static final Supplier<SoundEvent> KAMEN_RIDER_BLACK= registerSoundEvent("kamen_rider_black");
    public static final ResourceKey<JukeboxSong> KAMEN_RIDER_BLACK_KEY = createSong("kamen_rider_black");

    public static final Supplier<SoundEvent> ALIVE_A_LIFE= registerSoundEvent("alive_a_life");
    public static final ResourceKey<JukeboxSong> ALIVE_A_LIFE_KEY = createSong("alive_a_life");

    public static final Supplier<SoundEvent> JUSTIFAIZ= registerSoundEvent("justifaiz");
    public static final ResourceKey<JukeboxSong> JUSTIFAIZ_KEY = createSong("justifaiz");

    public static final Supplier<SoundEvent> EXCITE= registerSoundEvent("excite");
    public static final ResourceKey<JukeboxSong> EXCITE_KEY = createSong("excite");

    public static final Supplier<SoundEvent> BE_THE_ONE= registerSoundEvent("be_the_one");
    public static final ResourceKey<JukeboxSong> BE_THE_ONE_KEY = createSong("be_the_one");

    public static final Supplier<SoundEvent> REAL_X_EYEZ= registerSoundEvent("realxeyez");
    public static final ResourceKey<JukeboxSong> REAL_X_EYEZ_KEY = createSong("realxeyez");

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