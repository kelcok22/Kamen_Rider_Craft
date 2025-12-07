package com.kelco.kamenridercraft.block.machineBlocks;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class MachineBlockTags {
    public static class Items {
        public static final TagKey<Item> REPLICATOR_FROM_BLANK_FAKE = createTag("gear.fuestels.replicator_from_blank_fake");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, name));
        }
    }
}
