package com.kelco.kamenridercraft.item.base_items;


import com.kelco.kamenridercraft.item.KRCItemLists;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;

import java.util.List;
import java.util.function.Supplier;

public class BaseSpawnEggItem extends DeferredSpawnEggItem {
    public BaseSpawnEggItem(Supplier<? extends EntityType<? extends Mob>> type, int backgroundColor, int highlightColor, Properties props) {
        super(type, backgroundColor, highlightColor, props);
    }

    public BaseSpawnEggItem addToList(List<Item> TabList, int num) {
        for (int i = 0; i < num; i++) {
            TabList.add(this);
        }
        return this;
    }

    public BaseSpawnEggItem addToList(List<Item> TabList) {
        TabList.add(this);
        KRCItemLists.SPAWN_EGGS.add(this);
        return this;
    }
}