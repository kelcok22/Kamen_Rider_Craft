package com.kelco.kamenridercraft.item.extra_riders;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.base_items.BaseDropItem;
import com.kelco.kamenridercraft.item.base_items.BasicArmorItem;
import com.kelco.kamenridercraft.item.base_items.MaskItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ExtraRiderItems {
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);


	public static final DeferredItem<Item> ICHIGO_MASK = ITEMS.register("ichigo_mask",
			() -> new MaskItem(new Item.Properties().stacksTo(1)).AddToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));

	public static final DeferredItem<Item> V3_MASK = ITEMS.register("v3_mask",
			() -> new MaskItem(new Item.Properties().stacksTo(1)).AddToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));

    public static final DeferredItem<Item> RIDERMAN_HELMET = ITEMS.register("riderman_helmet",
            () -> new BasicArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties(),"riderman","riderman").isGlowing().AddToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));

	public static final DeferredItem<Item> GIFT = ITEMS.register("gift",
			() -> new BaseDropItem(new Item.Properties().rarity(Rarity.UNCOMMON), ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "items/gift")).AddToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));

	public static final DeferredItem<Item> GASHAPON_CAPSULE = ITEMS.register("gashapon_capsule",
			() -> new BaseDropItem(new Item.Properties().rarity(Rarity.UNCOMMON), ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "items/gashapon_capsule")).has_basic_model().AddToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));

	public static final DeferredItem<Item> HALLOWEEN_GASHAPON_CAPSULE = ITEMS.register("halloween_gashapon_capsule",
			() -> new BaseDropItem(new Item.Properties().rarity(Rarity.UNCOMMON), ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "items/halloween_gashapon_capsule")).has_basic_model().AddToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));

    public static final DeferredItem<Item> VALENTINE_GASHAPON_CAPSULE = ITEMS.register("valentine_gashapon_capsule",
            () -> new BaseDropItem(new Item.Properties().rarity(Rarity.UNCOMMON), ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "items/valentine_gashapon_capsule")).has_basic_model().AddToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));

    public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}

}