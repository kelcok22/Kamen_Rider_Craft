package com.kelco.kamenridercraft.data;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.block.Rider_Blocks;
import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import com.kelco.kamenridercraft.item.Modded_item_core;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ModItemModelProvider extends ItemModelProvider {


    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, KamenRiderCraftCore.MOD_ID, existingFileHelper);
    }

    public static List<BaseItem> BASIC_ITEM_MODEL= new ArrayList<>();
    public static List<Item> BASIC_ITEM_MODEL2= new ArrayList<>();

    @Override
    protected void registerModels() {


        for (BaseItem baseItem : BASIC_ITEM_MODEL) {
            ResourceLocation item = Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(baseItem));
            String item2 = baseItem.Model_Name == null ? item.getPath() : baseItem.Model_Name;
            this.getBuilder(item.toString()).parent(new ModelFile.UncheckedModelFile("item/generated")).texture("layer0", ResourceLocation.fromNamespaceAndPath(item.getNamespace(), "item/" + item2));

        }

        for (Item item : BASIC_ITEM_MODEL2) {
            basicItem(item);
        }



        buttonItem(Rider_Blocks.HELHEIM_BUTTON, Rider_Blocks.HELHEIM_PLANKS);
        fenceItem(Rider_Blocks.HELHEIM_FENCE, Rider_Blocks.HELHEIM_PLANKS);
        fenceItem(Rider_Blocks.WHITE_FENCE, Rider_Blocks.PLANKS_WHITE);

        wallItem(Rider_Blocks.YELLOW_WALLPLATE_WALL, Rider_Blocks.YELLOW_WALLPLATE);
        wallItem(Rider_Blocks.WHITE_WALLPLATE_WALL, Rider_Blocks.WHITE_WALLPLATE);
        wallItem(Rider_Blocks.CYAN_WALLPLATE_WALL, Rider_Blocks.CYAN_WALLPLATE);
        wallItem(Rider_Blocks.BLUE_WALLPLATE_WALL, Rider_Blocks.BLUE_WALLPLATE);
        wallItem(Rider_Blocks.LIGHT_BLUE_WALLPLATE_WALL, Rider_Blocks.LIGHT_BLUE_WALLPLATE);

        basicItem(Rider_Blocks.HELHEIM_DOOR.asItem());
        basicItem(Rider_Blocks.WONDERWOOD_DOOR.asItem());
        basicItem(Rider_Blocks.RABBIT_HUTCH_DOOR.asItem());
        basicItem(Rider_Blocks.GLASS_DOOR.asItem());
        basicItem(Rider_Blocks.JAIL_DOOR.asItem());

        basicItem(Rider_Blocks.GRANUTE_GLASS_PANE.asItem());

        basicItem(Modded_item_core.HELHEIM_SIGN_ITEM.asItem());
        basicItem(Modded_item_core.HELHEIM_HANGING_SIGN_ITEM.asItem());


    }


    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }
}

