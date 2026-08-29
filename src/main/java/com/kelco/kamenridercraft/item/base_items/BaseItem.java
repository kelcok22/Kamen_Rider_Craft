package com.kelco.kamenridercraft.item.base_items;


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
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BaseItem extends Item {
    public UseAnim useAnim;
    private Item craftingRemainingItem = null;
    private Boolean hasHoverText = false;
    public String modelName = null;

    public BaseItem(Properties prop) {
        super(prop);

    }

    public BaseItem useBasicModel() {
        ModItemModelProvider.BASIC_ITEM_MODEL.add(this);
        return this;
    }

    public BaseItem setModelName(String Name) {
        modelName = Name;
        return this;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack itemStack = player.getItemInHand(usedHand);
        FoodProperties foodProperties = itemStack.getFoodProperties(player);

        ResourceLocation potions = ResourceLocation.fromNamespaceAndPath("c", "potions");
        ResourceLocation drinks = ResourceLocation.fromNamespaceAndPath("c", "drinks");

        boolean isPotion = BuiltInRegistries.ITEM.getOrCreateTag(TagKey.create(Registries.ITEM, potions)).stream().anyMatch(e -> e == itemStack.getItem());
        boolean isDrink = BuiltInRegistries.ITEM.getOrCreateTag(TagKey.create(Registries.ITEM, drinks)).stream().anyMatch(e -> e == itemStack.getItem());

        if (player.hasEffect(EffectCore.GHOST) && (foodProperties != null || isDrink || isPotion)) {
            return InteractionResultHolder.fail(itemStack);
        }
        return super.use(level, player, usedHand);
    }

    public boolean is(TagKey<Item> tag) {
        return this.builtInRegistryHolder().is(tag);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        if (useAnim != null) return useAnim;
        else return stack.has(DataComponents.FOOD) ? UseAnim.EAT : UseAnim.NONE;
    }

    public BaseItem setItemAnimation(UseAnim Anim) {
        useAnim = Anim;
        return this;
    }

    public @NotNull ItemStack getCraftingRemainingItem(ItemStack stack) {
        if (stack.getItem() instanceof BaseItem) {
            if (!hasCraftingRemainingItem(stack)) {
                return ItemStack.EMPTY;
            }
            ItemStack save = new ItemStack(craftingRemainingItem);
            if (!stack.getItem().toString().contains("sample") && !stack.getItem().toString().contains("vial")) {
                save.applyComponents(stack.getComponents());
            }
            return save;
        } else {
            return new ItemStack(this.getCraftingRemainingItem());
        }
    }

    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return ((BaseItem) stack.getItem()).craftingRemainingItem != null;
    }

    public BaseItem keepItem() {
        craftingRemainingItem = this;
        return this;
    }

    public BaseItem changeKeptItem(Item item) {
        craftingRemainingItem = item;
        return this;
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

    public BaseItem useHoverTex() {
        hasHoverText = true;
        return this;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, Item.TooltipContext tooltipContext, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if (hasHoverText) {
            tooltipComponents.add(Component.translatable("tooltip." + itemStack.getItem()));
        }
        super.appendHoverText(itemStack, tooltipContext, tooltipComponents, tooltipFlag);
    }
}