package com.kelco.kamenridercraft.world.inventory;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.init.ModMenus;
import com.kelco.kamenridercraft.item.BaseItems.component.BasicContainer;
import com.kelco.kamenridercraft.item.BaseItems.component.slot.CaseArmorSlot;
import com.kelco.kamenridercraft.item.BaseItems.component.slot.SlotByTag;
import com.kelco.kamenridercraft.item.Fourze_Rider_Items;
import com.kelco.kamenridercraft.item.Modded_item_core;
import com.kelco.kamenridercraft.item.W_Rider_Items;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.Container;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;
import java.util.Map;

public class RiderCaseGuiMenu extends AbstractContainerMenu {
    private static final int CONTAINER_SIZE = 10;
    private final Container container;
    public static final ResourceLocation EMPTY_ARMOR_SLOT_HELMET = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_helmet");
    public static final ResourceLocation EMPTY_ARMOR_SLOT_CHESTPLATE = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_chestplate");
    public static final ResourceLocation EMPTY_ARMOR_SLOT_LEGGINGS = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_leggings");
    public static final ResourceLocation EMPTY_ARMOR_SLOT_BOOTS = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_boots");
    public static final ResourceLocation EMPTY_ARMOR_SLOT_SHIELD = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_shield");

    private static final Map<EquipmentSlot, ResourceLocation> TEXTURE_EMPTY_SLOTS = Map.of(
            EquipmentSlot.FEET,
            EMPTY_ARMOR_SLOT_BOOTS,
            EquipmentSlot.LEGS,
            EMPTY_ARMOR_SLOT_LEGGINGS,
            EquipmentSlot.CHEST,
            EMPTY_ARMOR_SLOT_CHESTPLATE,
            EquipmentSlot.HEAD,
            EMPTY_ARMOR_SLOT_HELMET
    );
    public RiderCaseGuiMenu(int containerId, Inventory playerInventory, FriendlyByteBuf registryFriendlyByteBuf) {
        this(containerId, playerInventory,new ItemStack(Modded_item_core.GENERIC_RIDER_CASE.get()));
    }

    public RiderCaseGuiMenu(int containerId, Inventory playerInventory, FriendlyByteBuf registryFriendlyByteBuf, ItemStack itemstack) {

        this(containerId, playerInventory,itemstack);
    }

    public RiderCaseGuiMenu(int containerId, Inventory playerInventory, ItemStack itemstack) {
        super(ModMenus.RIDER_CASE_GUI.get(), containerId);
        this.container = new BasicContainer(itemstack,10);
        container.startOpen(playerInventory.player);

        int i = 3;
        int j = 9;


        this.addSlot(new Slot(container, 0,90,16) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return stack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "rider_head_armor")));
            }
        });


        this.addSlot(new Slot(container, 1,90,34) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return stack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "rider_chest_armor")));
            }
        });

        this.addSlot(new Slot(container, 2,90,52) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return stack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "rider_leg_armor")));
            }
        });
        this.addSlot(new Slot(container, 3,108,34) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return stack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "rider_foot_armor")));
            }
        });

        this.addSlot(new SlotByTag(container,4,126,16,"gear/all_items"));
        this.addSlot(new SlotByTag(container,5,144,16,"gear/all_items"));
        this.addSlot(new SlotByTag(container,6,126,34,"gear/all_items"));
        this.addSlot(new SlotByTag(container,7,144,34,"gear/all_items"));
        this.addSlot(new SlotByTag(container,8,126,52,"gear/all_items"));
        this.addSlot(new SlotByTag(container,9,144,52,"gear/all_items"));


        this.addSlot(new CaseArmorSlot(playerInventory, playerInventory.player, EquipmentSlot.HEAD, 39,26,16, TEXTURE_EMPTY_SLOTS.get(EquipmentSlot.HEAD)));
        this.addSlot(new CaseArmorSlot(playerInventory, playerInventory.player, EquipmentSlot.CHEST, 38,26,34, TEXTURE_EMPTY_SLOTS.get(EquipmentSlot.CHEST)));
        this.addSlot(new CaseArmorSlot(playerInventory, playerInventory.player, EquipmentSlot.LEGS, 37,26,52, TEXTURE_EMPTY_SLOTS.get(EquipmentSlot.LEGS)));
        this.addSlot(new CaseArmorSlot(playerInventory, playerInventory.player, EquipmentSlot.FEET, 36,44,34, TEXTURE_EMPTY_SLOTS.get(EquipmentSlot.FEET)));

        for(int i1 = 0; i1 < 3; ++i1) {
            for(int k1 = 0; k1 < 9; ++k1) {
                this.addSlot(new Slot(playerInventory, k1 + i1 * 9 + 9, 8 + k1 * 18, 84 + i1 * 18){
                    @Override
                    public boolean mayPickup(Player player) {
                        if (this.getItem().getItem()==Modded_item_core.GENERIC_RIDER_CASE.get())return false;
                        return true;
                    }
                });
            }
        }

        for(int j1 = 0; j1 < 9; ++j1) {
            this.addSlot(new Slot(playerInventory, j1, 8 + j1 * 18, 142){
                @Override
                public boolean mayPickup(Player player) {
                    if (this.getItem().getItem()==Modded_item_core.GENERIC_RIDER_CASE.get())return false;
                    return true;
                }
            });
        }
    }

    @Override
    public boolean stillValid(Player player) {
        return this.container.stillValid(player);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (index < this.container.getContainerSize()) {
                if (!this.moveItemStackTo(itemstack1, this.container.getContainerSize(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, 0, this.container.getContainerSize(), false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return itemstack;
    }

    /**
     * Called when the container is closed.
     */
    @Override
    public void removed(Player player) {
        super.removed(player);
        this.container.stopOpen(player);
    }
}
