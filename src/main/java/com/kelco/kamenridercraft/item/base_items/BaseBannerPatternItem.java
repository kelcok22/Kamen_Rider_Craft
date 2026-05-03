package com.kelco.kamenridercraft.item.base_items;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BannerPatternItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.BannerPattern;

import java.util.List;

public class BaseBannerPatternItem extends BannerPatternItem {

    public BaseBannerPatternItem(TagKey<BannerPattern> bannerPattern, Item.Properties properties) {
        super(bannerPattern, properties);
    }

    public BaseBannerPatternItem AddToList(List<Item> TabList) {
        TabList.add(this);
        return this;
    }
}
