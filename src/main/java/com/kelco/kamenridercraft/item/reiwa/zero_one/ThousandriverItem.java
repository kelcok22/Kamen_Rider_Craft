package com.kelco.kamenridercraft.item.reiwa.zero_one;

import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.reiwa.ZeroOneRiderItems;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.registries.DeferredItem;

public class ThousandriverItem extends RiderDriverItem {
    public ThousandriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item> torso, DeferredItem<Item> legs, Item.Properties properties) {
        super(material, rider, baseFormItem, head, torso, legs, properties);

    }

    public void inventoryTick(ItemStack itemStack, Level level, Entity entity, int slotId, boolean isSelected) {
        super.inventoryTick(itemStack, level, entity, slotId, isSelected);

        if (entity instanceof Player player && !level.isClientSide) {
            if (isTransformed(player) && player.hasEffect(EffectCore.BUGSTER)
                    && player.getInventory().countItem(ZeroOneRiderItems.ARK_ONE_PROGRISEKEY.get()) > 0
                    && player.getInventory().countItem(ZeroOneRiderItems.HUMAGEAR_PROGRISEKEY.get()) > 0) {
                if (player.getInventory().getItem(40).getItem() == ZeroOneRiderItems.HUMAGEAR_PROGRISEKEY.get())
                    player.getInventory().removeItem(40, 1);
                else
                    player.getInventory().removeItem(player.getInventory().findSlotMatchingItem(new ItemStack(ZeroOneRiderItems.HUMAGEAR_PROGRISEKEY.get())), 1);
                ItemEntity key = new ItemEntity(level, player.getX(), player.getY(), player.getZ(), new ItemStack(ZeroOneRiderItems.PRESIDENT_DAN_KUROTO_PROGRISEKEY.get(), 1), 0, 0, 0);
                key.setPickUpDelay(0);
                level.addFreshEntity(key);
                player.sendSystemMessage(Component.translatable("loot.kamenridercraft.dan_kuroto_progrisekey"));
                player.removeEffect(EffectCore.BUGSTER);
            }
        }
    }

    @Override
    public String getText(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName) {
        boolean fly = rider.getAttribute(Attributes.WINGS_OUT).getBaseValue() == 1;
        boolean bug = rider.getAttribute(Attributes.HAS_BUG).getValue() != 0;
        if (equipmentSlot == EquipmentSlot.FEET) {
            String belt = ((RiderDriverItem) itemstack.getItem()).beltText;
            if (((RiderDriverItem) itemstack.getItem()).beltText == null) {
                belt = getFormItem(itemstack, 1).getBeltTex();
            }
            return "belts/" + belt;
        } else if (bug) return "zaia";
        else return riderName + getFormItem(itemstack, 1).getFormName(fly);
    }
}