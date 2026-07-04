package com.kelco.kamenridercraft.item.base_items;

import com.kelco.kamenridercraft.item.ModdedItemCore;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;

import java.util.List;

public class BaseAxeItem extends AxeItem {

    private Item changedRepairItem = ModdedItemCore.RIDER_CIRCUIT.get();
    private Item formChangeItem;
    private Item henshinBeltItem;
    private Boolean changeAxe = false;
    private Boolean formItem = false;
    private Boolean henshinItem = false;
    private Item craftingRemainingItem = null;


    public BaseAxeItem(Tier toolTier, int Atk, float Spd, Properties prop) {
        super(toolTier, prop.attributes(AxeItem.createAttributes(Tiers.DIAMOND, Atk, Spd)));
    }

    public BaseAxeItem ChangeRepairItem(Item item) {
        changedRepairItem = item;
        return this;
    }

    public boolean isValidRepairItem(ItemStack itemStackOne, ItemStack repairItem) {
        return repairItem.getItem() == changedRepairItem;
    }

	public BaseAxeItem addToList(List<Item> TabList, int num) {
		for (int i = 0; i < num; i++) {
			TabList.add(this);
		}
		return this;
	}

	public BaseAxeItem addToList(List<Item> TabList) {
		TabList.add(this);
		return this;
	}

    public static int Get_Mode(ItemStack itemstack) {
        if (!itemstack.has(DataComponents.CUSTOM_DATA)) return 0;
        else {
            CompoundTag tag = itemstack.get(DataComponents.CUSTOM_DATA).getUnsafe();
            return tag.getInt("item_mode");
        }
    }

    public BaseAxeItem IsFormItem(Item item) {
        formItem = true;
        formChangeItem = item;
        return this;
    }

    public BaseAxeItem IsHenshinItem(Item item) {
        henshinItem = true;
        henshinBeltItem = item;
        return this;
    }

    public static void Set_Mode(ItemStack itemstack) {
        if (!itemstack.has(DataComponents.CUSTOM_DATA)) {
            itemstack.set(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
        }
        CompoundTag tag = itemstack.get(DataComponents.CUSTOM_DATA).getUnsafe();
        tag.putInt("item_mode", Get_Mode(itemstack) == 0 ? 1 : 0);
    }

    public BaseAxeItem KeepDifItem(Item Dif) {
        craftingRemainingItem = Dif;
        return this;
    }

    public BaseAxeItem KeepItem() {
        craftingRemainingItem = this;
        return this;
    }

    public ItemStack getCraftingRemainingItem(ItemStack stack) {
        if (stack.getItem() instanceof BaseAxeItem) {
            if (!hasCraftingRemainingItem(stack)) {
                return ItemStack.EMPTY;
            }
            return new ItemStack(craftingRemainingItem);
        } else return new ItemStack(this.getCraftingRemainingItem());
    }


    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return ((BaseAxeItem) stack.getItem()).craftingRemainingItem != null;
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity interactionTarget, InteractionHand usedHand) {
        if (formItem) formChangeItem.interactLivingEntity(stack, player, interactionTarget, usedHand);
        return InteractionResult.PASS;
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemstack = player.getItemInHand(interactionHand);
        if (henshinItem && player.getItemBySlot(EquipmentSlot.FEET) == ItemStack.EMPTY) {
            player.setItemSlot(EquipmentSlot.FEET, new ItemStack(henshinBeltItem));
            if (player.getOffhandItem().getItem() instanceof RiderFormChangeItem form)
                form.use(level, player, InteractionHand.OFF_HAND);
        }
        if (formItem && player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem) {
            formChangeItem.use(level, player, interactionHand);
        }
        if (changeAxe) {
            if (player.isShiftKeyDown()) {
                Set_Mode(itemstack);
            }

            Get_Mode(itemstack);
        }
        return InteractionResultHolder.pass(player.getItemInHand(interactionHand));
    }


}