package com.kelco.kamenridercraft.item.gotchard;

import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.summons.RiderSummonEntity;
import com.kelco.kamenridercraft.item.BaseItems.CopyFormChangeItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.Gotchard_Rider_Items;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CopyChemyCardItem extends CopyFormChangeItem {

	private RiderFormChangeItem FORM_ITEM = null;

	public CopyChemyCardItem(Properties properties, Item form_item) {
		super( properties, form_item);
        if ( form_item instanceof RiderFormChangeItem form) FORM_ITEM=form;
	}

    public boolean inventoryOrHolderContains(Player player, Item item) {
        NonNullList<ItemStack> inv = NonNullList.create();
        inv.addAll(player.getInventory().items);
        inv.addAll(player.getInventory().armor);
        inv.add(player.getInventory().offhand.getFirst());

        if (player.getInventory().countItem(item)!=0) return true;
        else for (ItemStack itemStack : inv) {
            if (itemStack.has(DataComponents.CONTAINER)) {
                for (ItemStack stack : itemStack.getComponents().get(DataComponents.CONTAINER).nonEmptyItems())
                    if (stack.getItem() == item) return true;
            } else if (itemStack.has(DataComponents.BUNDLE_CONTENTS))
                for (ItemStack stack : itemStack.getComponents().get(DataComponents.BUNDLE_CONTENTS).items())
                    if (stack.getItem() == item) return true;
        }
        return false;
    }

    public boolean canSummonGotcharbrothers(Player player) {
        if (!FORM_ITEM.needItemList.isEmpty()) {
            for (Item item : FORM_ITEM.needItemList) {
                if (!inventoryOrHolderContains(player, item)) return false;
            }
        }
        return player.isShiftKeyDown() && player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof GotcharDriverItem driver && driver.isTransformed(player)
                && RiderDriverItem.get_Form_Item(player.getItemBySlot(EquipmentSlot.FEET), 1) == Gotchard_Rider_Items.NIJIGON_RIDE_CHEMY_CARD_EXTRA.get();
    }

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {

		ItemStack itemstack = player.getItemInHand(usedHand);

        if (canSummonGotcharbrothers(player) && FORM_ITEM != null) {
            RiderSummonEntity summon = MobsCore.RIDER_SUMMON.get().create(level);
            if (summon != null) {
                summon.moveTo(player.getX(), player.getY() + 1, player.getZ(), player.getYRot(), player.getXRot());
                summon.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Gotchard_Rider_Items.GOTCHARD_HELMET.get()));
                summon.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Gotchard_Rider_Items.GOTCHARD_CHESTPLATE.get()));
                summon.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Gotchard_Rider_Items.GOTCHARD_LEGGINGS.get()));
                summon.setItemSlot(EquipmentSlot.FEET, new ItemStack(Gotchard_Rider_Items.GOTCHARDRIVER_BROTHER.get()));
                RiderDriverItem.set_Form_Item(summon.getItemBySlot(EquipmentSlot.FEET), FORM_ITEM, 1);

                level.addFreshEntity(summon);
                summon.bindToPlayer(player);
                summon.addRequiredForm((RiderFormChangeItem)Gotchard_Rider_Items.NIJIGON_RIDE_CHEMY_CARD_EXTRA.get(), 1);
                if (!player.isCreative()) {
                    summon.takeSummonItem(itemstack);
                    for (Item item : FORM_ITEM.needItemList) player.getCooldowns().addCooldown(item, 750);
                }
                player.awardStat(Stats.ITEM_USED.get(this));
            }
            return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
        }
		if (FORM_ITEM !=null)FORM_ITEM.use(level, player, usedHand);
		
		return InteractionResultHolder.sidedSuccess(itemstack,level.isClientSide());

	}
}
