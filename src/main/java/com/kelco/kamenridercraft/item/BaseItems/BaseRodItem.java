package com.kelco.kamenridercraft.item.BaseItems;


import com.google.common.collect.ImmutableMultimap;
import com.kelco.kamenridercraft.item.Modded_item_core;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class BaseRodItem extends FishingRodItem {
	private Item RepairItem = Modded_item_core.RIDER_CIRCUIT.get();
	private Item craftingRemainingItem = null;

	public BaseRodItem(Tier toolTier, int Atk, float Spd, Properties prop) {
		super(prop.durability(toolTier.getUses()).attributes(SwordItem.createAttributes(Tiers.DIAMOND, Atk, Spd)));
		ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
	}
	public BaseRodItem AddToTabList(List<Item> TabList) {
		TabList.add(this);
		return this;
	}

	public BaseRodItem KeepDifItem(Item Dif) {
		craftingRemainingItem=Dif;
		return this;
	}

	public BaseRodItem KeepItem() {
		craftingRemainingItem=this;
		return this;
	}

	public ItemStack getCraftingRemainingItem(ItemStack stack)
	{
		if (stack.getItem() instanceof BaseRodItem) {
			if (!hasCraftingRemainingItem(stack))
			{
				return ItemStack.EMPTY;
			}
			return new ItemStack(craftingRemainingItem);
		} else  return new ItemStack(this.getCraftingRemainingItem());
	}


	public boolean hasCraftingRemainingItem(ItemStack stack)
	{
		return ((BaseRodItem)stack.getItem()).craftingRemainingItem!=null;
	}


	@Override
    public boolean canAttackBlock(BlockState state, Level level, BlockPos pos, Player player) {
        return !player.isCreative();
    }

	public int getDefaultProjectileRange() {
		return 30;
	}

	public BaseRodItem ChangeRepairItem(Item item) {
		RepairItem = item;
		return this;
	}

	public boolean isValidRepairItem(ItemStack p_40392_, ItemStack p_40393_) {
		return p_40393_.getItem()== RepairItem;
	}

	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		return true;
	}

    @Override
    public void postHurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.hurtAndBreak(1, attacker, EquipmentSlot.MAINHAND);
    }

	public static ItemAttributeModifiers createAttributes(Tier tier, int attackDamage, float attackSpeed) {
		return createAttributes(tier, (float)attackDamage, attackSpeed);
	}
	public static ItemAttributeModifiers createAttributes(Tier p_330371_, float p_331976_, float p_332104_) {
		return ItemAttributeModifiers.builder().add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, p_331976_ + p_330371_.getAttackDamageBonus(), AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, p_332104_, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).build();
	}
}