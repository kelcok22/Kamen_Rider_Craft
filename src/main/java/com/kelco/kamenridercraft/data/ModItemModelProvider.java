package com.kelco.kamenridercraft.data;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.block.Rider_Blocks;
import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import com.kelco.kamenridercraft.item.tabs.RiderTabs;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
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

    public static List<BaseItem> BASIC_ITEM_MODEL= new ArrayList<BaseItem>();
    public static List<Item> BASIC_ITEM_MODEL2= new ArrayList<Item>();

    @Override
    protected void registerModels() {


            for (int i = 0; i < BASIC_ITEM_MODEL.size(); i++)
            {
                ResourceLocation item = (ResourceLocation)Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(BASIC_ITEM_MODEL.get(i)));
                String item2 = BASIC_ITEM_MODEL.get(i).Model_Name==null? item.getPath():BASIC_ITEM_MODEL.get(i).Model_Name;
                ((ItemModelBuilder) ((ItemModelBuilder) this.getBuilder(item.toString())).parent(new ModelFile.UncheckedModelFile("item/generated"))).texture("layer0", ResourceLocation.fromNamespaceAndPath(item.getNamespace(), "item/" + item2));

            }

        for (int i = 0; i < BASIC_ITEM_MODEL2.size(); i++)
        {
                 basicItem(BASIC_ITEM_MODEL2.get(i));
        }



        buttonItem(Rider_Blocks.HELHEIM_BUTTON, Rider_Blocks.HELHEIM_PLANKS);
        fenceItem(Rider_Blocks.HELHEIM_FENCE, Rider_Blocks.HELHEIM_PLANKS);

        basicItem(Rider_Blocks.HELHEIM_DOOR.asItem());
        basicItem(Rider_Blocks.RABBIT_HUTCH_DOOR.asItem());
        basicItem(Rider_Blocks.GLASS_DOOR.asItem());
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
}

