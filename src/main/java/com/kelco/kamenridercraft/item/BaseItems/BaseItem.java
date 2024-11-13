package com.kelco.kamenridercraft.item.BaseItems;


import java.util.List;


import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;

public class BaseItem extends Item {

    public UseAnim Animation;
    private Item craftingRemainingItem = null;

    public BaseItem(Properties prop) {
        super(prop);

    }

    public BaseItem KeepDifItem(Item Dif) {
        craftingRemainingItem=Dif;
        return this;
    }

    public BaseItem KeepItem() {
        craftingRemainingItem=this;
        return this;
    }


    public ItemStack getCraftingRemainingItem(ItemStack stack)
    {
        if (stack.getItem() instanceof BaseItem) {
            if (!hasCraftingRemainingItem(stack))
            {
                return ItemStack.EMPTY;
            }
            return new ItemStack(craftingRemainingItem);
        } else  return new ItemStack(this.getCraftingRemainingItem());
    }

    public BaseItem SetItemAnimation(UseAnim Anim) {
        Animation=Anim;
        return this;
    }


    public boolean hasCraftingRemainingItem(ItemStack stack)
    {
        return ((BaseItem)stack.getItem()).craftingRemainingItem!=null;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        if (Animation != null)  return Animation;
        else return stack.has(DataComponents.FOOD) ? UseAnim.EAT : UseAnim.NONE;
    }

    public BaseItem AddToList(List<Item> TabList, int num) {
        for (int i = 0; i < num; i++)
        {
            TabList.add(this);
        }
        return this;
    }

    public BaseItem AddToList(List<Item> TabList) {
        TabList.add(this);
        return this;
    }



}