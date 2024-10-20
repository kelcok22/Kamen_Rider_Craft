package com.kelco.kamenridercraft.item.gavv;


import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import com.kelco.kamenridercraft.item.Gavv_Rider_Items;
import com.kelco.kamenridercraft.item.Modded_item_core;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GiveGochizoFoodItem extends BaseItem {

    public static List<Item> GUMMY= new ArrayList<Item>();

    public GiveGochizoFoodItem(Properties prop) {
        super(prop);

    }

    private Item getGochizoDrop() {
        Random generator = new Random();
        if (this==Modded_item_core.GUMMI_CANDY.get()){
            int rand = generator.nextInt(GUMMY.size());
            return GUMMY.get(rand);
        }
        return Gavv_Rider_Items.POPPINGGUMMY_GOCHIZO.get();
    }

    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {

        if (livingEntity instanceof Player player){
            if (player.getInventory().countItem(Gavv_Rider_Items.BLANK_GOCHIZO.get())>0){
                player.getInventory().removeItem(new ItemStack(Gavv_Rider_Items.BLANK_GOCHIZO.get()));
                ItemStack GOCHIZO = new ItemStack(getGochizoDrop());
                player.getInventory().removeItem( player.getInventory().findSlotMatchingItem(new ItemStack(Gavv_Rider_Items.BLANK_GOCHIZO.get())),1);

                 player.drop(GOCHIZO, true);
            }
        }
        FoodProperties foodproperties = stack.getFoodProperties(livingEntity);
        return foodproperties != null ? livingEntity.eat(level, stack, foodproperties) : stack;
    }


}