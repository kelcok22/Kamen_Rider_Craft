package com.kelco.kamenridercraft.data;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.block.RiderBlocks;
import com.kelco.kamenridercraft.item.ModdedItemCore;
import com.kelco.kamenridercraft.item.base_items.BaseItem;
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



        buttonItem(RiderBlocks.HELHEIM_BUTTON, RiderBlocks.HELHEIM_PLANKS);
        fenceItem(RiderBlocks.HELHEIM_FENCE, RiderBlocks.HELHEIM_PLANKS);
        fenceItem(RiderBlocks.WHITE_FENCE, RiderBlocks.PLANKS_WHITE);

        wallItem(RiderBlocks.YELLOW_WALLPLATE_WALL, RiderBlocks.YELLOW_WALLPLATE);
        wallItem(RiderBlocks.WHITE_WALLPLATE_WALL, RiderBlocks.WHITE_WALLPLATE);
        wallItem(RiderBlocks.CYAN_WALLPLATE_WALL, RiderBlocks.CYAN_WALLPLATE);
        wallItem(RiderBlocks.BLUE_WALLPLATE_WALL, RiderBlocks.BLUE_WALLPLATE);
        wallItem(RiderBlocks.LIGHT_BLUE_WALLPLATE_WALL, RiderBlocks.LIGHT_BLUE_WALLPLATE);

        basicItem(RiderBlocks.HELHEIM_DOOR.asItem());
        basicItem(RiderBlocks.WONDERWOOD_DOOR.asItem());
        basicItem(RiderBlocks.RABBIT_HUTCH_DOOR.asItem());
        basicItem(RiderBlocks.GLASS_DOOR.asItem());
        basicItem(RiderBlocks.JAIL_DOOR.asItem());
        basicItem(RiderBlocks.GOLD_DOOR.asItem());

        basicItem(RiderBlocks.GRANUTE_GLASS_PANE.asItem());

        basicItem(ModdedItemCore.HELHEIM_SIGN_ITEM.asItem());
        basicItem(ModdedItemCore.HELHEIM_HANGING_SIGN_ITEM.asItem());


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

