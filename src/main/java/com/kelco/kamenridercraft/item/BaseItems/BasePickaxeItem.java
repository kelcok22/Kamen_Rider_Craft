package com.kelco.kamenridercraft.item.BaseItems;

import com.kelco.kamenridercraft.item.Modded_item_core;
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

public class BasePickaxeItem extends PickaxeItem {

	private Item RepairItem = Modded_item_core.RIDER_CIRCUIT.get();
	private Item FormChangeItem;
	private Item HenshinBeltItem;
	private Boolean Change_pick = false;
	private Boolean Form_item = false;
	private Boolean Henshin_item = false;
    private Item craftingRemainingItem = null;


	public BasePickaxeItem(Tier toolTier, int Atk, float Spd, Properties prop) {
		super(toolTier, prop.attributes(PickaxeItem.createAttributes(Tiers.DIAMOND, Atk, Spd)));
	}

	public BasePickaxeItem ChangeRepairItem(Item item) {
		RepairItem = item;
		return this;
	}

	public boolean isValidRepairItem(ItemStack p_40392_, ItemStack p_40393_) {
		return p_40393_.getItem()== RepairItem;
	}

	public BasePickaxeItem AddToTabList(List<Item> TabList) {
		TabList.add(this);
		return this;
	}

	public static int Get_Mode (ItemStack itemstack)
	{
		if (!itemstack.has(DataComponents.CUSTOM_DATA)) return  0;
		else{
			CompoundTag tag = itemstack.get(DataComponents.CUSTOM_DATA).getUnsafe();
			return tag.getInt("item_mode");
		}
	}

	public BasePickaxeItem IsFormItem(Item item) {
		Form_item=true;
		FormChangeItem=item;
		return this;
	}

	public BasePickaxeItem IsHenshinItem(Item item) {
		Henshin_item=true;
		HenshinBeltItem=item;
		return this;
	}

	public static void Set_Mode(ItemStack itemstack)
	{
		if (!itemstack.has(DataComponents.CUSTOM_DATA)) {
			itemstack.set(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
		}
		CompoundTag  tag = itemstack.get(DataComponents.CUSTOM_DATA).getUnsafe();
		tag.putInt("item_mode", Get_Mode(itemstack)==0? 1:0);
	}

    public BasePickaxeItem KeepDifItem(Item Dif) {
        craftingRemainingItem=Dif;
        return this;
    }

    public BasePickaxeItem KeepItem() {
        craftingRemainingItem=this;
        return this;
    }

    public ItemStack getCraftingRemainingItem(ItemStack stack)
    {
        if (stack.getItem() instanceof BasePickaxeItem) {
            if (!hasCraftingRemainingItem(stack))
            {
                return ItemStack.EMPTY;
            }
            return new ItemStack(craftingRemainingItem);
        } else  return new ItemStack(this.getCraftingRemainingItem());
    }


    public boolean hasCraftingRemainingItem(ItemStack stack)
    {
        return ((BasePickaxeItem)stack.getItem()).craftingRemainingItem!=null;
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity interactionTarget, InteractionHand usedHand) {
        if (Form_item) FormChangeItem.interactLivingEntity(stack, player, interactionTarget, usedHand);
        return InteractionResult.PASS;
    }

	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand p_41130_) {
		ItemStack itemstack = player.getItemInHand(p_41130_);
		if (Henshin_item && player.getItemBySlot(EquipmentSlot.FEET)==ItemStack.EMPTY) {
			player.setItemSlot(EquipmentSlot.FEET, new ItemStack(HenshinBeltItem));
			if (player.getOffhandItem().getItem() instanceof RiderFormChangeItem form) form.use(level, player, InteractionHand.OFF_HAND);
		}	
		if (Form_item && player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem) {
			FormChangeItem.use(level, player, p_41130_);
		}
		if (Change_pick) {
			if (player.isShiftKeyDown()) {
				Set_Mode(itemstack);
			}

            Get_Mode(itemstack);
        }
		   return InteractionResultHolder.pass(player.getItemInHand( p_41130_));
	}


}