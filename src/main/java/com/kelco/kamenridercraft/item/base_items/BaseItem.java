package com.kelco.kamenridercraft.item.base_items;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.data.ModItemModelProvider;
import com.kelco.kamenridercraft.effects.EffectCore;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

import java.util.List;

public class BaseItem extends Item {

    public UseAnim Animation;
    private Item craftingRemainingItem = null;
    private Boolean hasHoverText = false;
    public String Model_Name = null;

    public BaseItem(Properties prop) {
        super(prop);

    }

    public BaseItem KeepDifItem(Item Dif) {
        craftingRemainingItem = Dif;
        return this;
    }

    public BaseItem KeepItem() {
        craftingRemainingItem = this;
        return this;
    }

    public BaseItem HasHoverTex() {
        hasHoverText = true;
        return this;
    }

    public BaseItem has_basic_model() {
        ModItemModelProvider.BASIC_ITEM_MODEL.add(this);
        return this;
    }

    public BaseItem model_has_different_name(String Name) {
        Model_Name = Name;
        return this;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack itemstack = player.getItemInHand(usedHand);
        FoodProperties foodproperties = itemstack.getFoodProperties(player);

        ResourceLocation potions = ResourceLocation.fromNamespaceAndPath("c", "potions");
        ResourceLocation drinks = ResourceLocation.fromNamespaceAndPath("c", "drinks");

        boolean isPotion = BuiltInRegistries.ITEM.getOrCreateTag(TagKey.create(Registries.ITEM, potions)).stream().anyMatch(e -> e == itemstack.getItem());
        boolean isDrink = BuiltInRegistries.ITEM.getOrCreateTag(TagKey.create(Registries.ITEM, drinks)).stream().anyMatch(e -> e == itemstack.getItem());

        if ((foodproperties != null || isDrink || isPotion) && player.hasEffect(EffectCore.GHOST)) {
            return InteractionResultHolder.fail(itemstack);
        }
        return super.use(level, player, usedHand);
    }

    public boolean is(TagKey<Item> tag) {
        return this.builtInRegistryHolder().is(tag);
    }


    public ItemStack getCraftingRemainingItem(ItemStack stack) {
        if (stack.getItem() instanceof BaseItem) {
            if (!hasCraftingRemainingItem(stack)) {
                return ItemStack.EMPTY;
            }
            ItemStack save = new ItemStack(craftingRemainingItem);
            if (!stack.getItem().toString().contains("sample") || !stack.getItem().toString().contains("vial")) {
                save.applyComponents(stack.getComponents());
            }
            return save;

        } else {
            return new ItemStack(this.getCraftingRemainingItem());
        }
    }

    public BaseItem SetItemAnimation(UseAnim Anim) {
        Animation = Anim;
        return this;
    }


    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return ((BaseItem) stack.getItem()).craftingRemainingItem != null;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        if (Animation != null) return Animation;
        else return stack.has(DataComponents.FOOD) ? UseAnim.EAT : UseAnim.NONE;
    }

    public BaseItem addToList(List<Item> TabList, int num) {
        for (int i = 0; i < num; i++) {
            TabList.add(this);
        }
        return this;
    }

    public BaseItem addToList(List<Item> TabList) {
        TabList.add(this);
        return this;
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if (hasHoverText) {
            tooltipComponents.add(Component.translatable("tooltip." + stack.getItem()));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

}