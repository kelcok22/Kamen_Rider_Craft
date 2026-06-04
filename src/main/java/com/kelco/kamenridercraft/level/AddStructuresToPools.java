package com.kelco.kamenridercraft.level;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool.Projection;

import java.lang.reflect.Field;
import java.util.List;

import static com.kelco.kamenridercraft.KamenRiderCraftCore.MOD_ID;

public class AddStructuresToPools {
    @SuppressWarnings("unchecked")
    public static void addModStructures(MinecraftServer server) throws NoSuchFieldException {
        String[] villageHouseList = {"humagear", "shocker", "toy_collector"};

        if (server.registryAccess().registry(Registries.TEMPLATE_POOL).isEmpty()) {
            return;
        }
        Registry<StructureTemplatePool> templatePoolRegistry = server.registryAccess().registry(Registries.TEMPLATE_POOL).get();


        addStructuresToVillages(templatePoolRegistry, villageHouseList);
    }

    public static void addStructureToPool(Registry<StructureTemplatePool> templatePoolRegistry, String structurePath, String structureName) throws NoSuchFieldException {
        Field field = StructureTemplatePool.class.getDeclaredField("templates");
        field.setAccessible(true);
        try {
            StructureTemplatePool pattern = templatePoolRegistry.get(ResourceLocation.parse("minecraft:" + structurePath));
            String houseLocation = MOD_ID + ":" + structurePath + "/" + structureName;

            List<StructurePoolElement> structurePool = (List<StructurePoolElement>) field.get(pattern);
            structurePool.add(StructurePoolElement.legacy(houseLocation).apply(Projection.RIGID));
        } catch (Exception e) {
            System.err.println("Error adding structure!");
        }
    }

    public static void addStructuresToVillages(Registry<StructureTemplatePool> templatePoolRegistry, String[] villageHouseList) throws NoSuchFieldException {

        Field field = StructureTemplatePool.class.getDeclaredField("templates");
        field.setAccessible(true);

        String[] biomes = {"plains"};
        try {
            for (String biome : biomes) {
                for (String house : villageHouseList) {
                    StructureTemplatePool pattern = templatePoolRegistry.get(ResourceLocation.parse("minecraft:village/" + biome + "/houses"));
                    String houseLocation = MOD_ID + ":village/" + biome + "/houses/" + biome + "_" + house;

                    List<StructurePoolElement> structurePool = (List<StructurePoolElement>) field.get(pattern);
                    structurePool.add(StructurePoolElement.legacy(houseLocation).apply(Projection.RIGID));
                }
            }
        } catch (Exception e) {
            System.err.println("Error adding structure!");
        }
    }
}