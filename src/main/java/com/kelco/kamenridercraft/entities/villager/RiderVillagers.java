package com.kelco.kamenridercraft.entities.villager;



import com.google.common.collect.ImmutableSet;
import com.kelco.kamenridercraft.KamenRiderCraftCore;

import com.kelco.kamenridercraft.block.Rider_Blocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.util.ObfuscationReflectionHelper;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.lang.reflect.InvocationTargetException;

public class RiderVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(Registries.POINT_OF_INTEREST_TYPE, KamenRiderCraftCore.MOD_ID);

    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = DeferredRegister.create(Registries.VILLAGER_PROFESSION, KamenRiderCraftCore.MOD_ID);

    public static final DeferredHolder<PoiType,PoiType> SHOCKER_MONITOR_POI = POI_TYPES.register("shocker_monitor_poi",
            () -> new PoiType(ImmutableSet.copyOf(Rider_Blocks.SHOCKER_MONITOR.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final DeferredHolder<VillagerProfession,VillagerProfession> SHOCKER_VILLAGER = VILLAGER_PROFESSIONS.register("shocker_villager",
            () -> new VillagerProfession("shocker_villager",(X) -> {return X.is(SHOCKER_MONITOR_POI);},
                    (X) -> {return X.is(SHOCKER_MONITOR_POI);}, ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_ARMORER));

    public static final DeferredHolder<PoiType,PoiType> HIDEN_3D_PRINTER_POI = POI_TYPES.register("hiden_3d_printer_poi",
            () -> new PoiType(ImmutableSet.copyOf(Rider_Blocks.HIDEN_3D_PRINTER.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final DeferredHolder<VillagerProfession,VillagerProfession> HUMAGEAR_VILLAGER = VILLAGER_PROFESSIONS.register("humagear_villager",
            () -> new VillagerProfession("humagear_villager", (X) -> {return X.is(HIDEN_3D_PRINTER_POI);},
                    (X) -> {return X.is(HIDEN_3D_PRINTER_POI);}, ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_ARMORER));

    public static final DeferredHolder<PoiType,PoiType> KAMEN_CAFE_COUNTER_POI = POI_TYPES.register("kamen_cafe_counter_poi",
            () -> new PoiType(ImmutableSet.copyOf(Rider_Blocks.KAMEN_CAFE_COUNTER.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final DeferredHolder<VillagerProfession,VillagerProfession> KAMEN_CAFE_BUTLER = VILLAGER_PROFESSIONS.register("kamen_cafe_butler",
            () -> new VillagerProfession("kamen_cafe_butler",(X) -> {return X.is(KAMEN_CAFE_COUNTER_POI);},
                    (X) -> {return X.is(KAMEN_CAFE_COUNTER_POI);}, ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_ARMORER));


    

    public static void registerPOIs() {
        try {
            ObfuscationReflectionHelper.findMethod(PoiType.class,
                    "registerBlockStates", PoiType.class).invoke(null, SHOCKER_MONITOR_POI.get());
            ObfuscationReflectionHelper.findMethod(PoiType.class,
                    "registerBlockStates", PoiType.class).invoke(null, HIDEN_3D_PRINTER_POI.get());
            ObfuscationReflectionHelper.findMethod(PoiType.class,
                    "registerBlockStates", PoiType.class).invoke(null, KAMEN_CAFE_COUNTER_POI.get());
        } catch (InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}