package com.kelco.kamenridercraft.item.BaseItems;

import java.util.List;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BannerPatternItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.BannerPattern;

public class BaseBannerPatternItem extends BannerPatternItem {

    public BaseBannerPatternItem(TagKey<BannerPattern> bannerPattern, Item.Properties properties) {
        super(bannerPattern, properties);
    }

    public BaseBannerPatternItem AddToList(List<Item> TabList) {
        TabList.add(this);
        return this;
    }
}
