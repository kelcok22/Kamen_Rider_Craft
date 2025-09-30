package com.kelco.kamenridercraft.item.zi_o;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kelco.kamenridercraft.item.Zi_O_Rider_Items;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


public class MajestyRidewatchItem extends OhmaRidewatchItem {
    private List<Item> summonMajestyWeapons = new ArrayList<>();
    private Map<Item, Item[]> summonAltMajestyWeapons = new HashMap<>();

    public MajestyRidewatchItem(Properties properties) {
        super(properties);
    }

    public MajestyRidewatchItem addMajestyWeapon(Item weapon) {
        this.summonMajestyWeapons.add(weapon);
        return this;
    }

    public MajestyRidewatchItem addAltMajestyWeapon(Item item, Item... weapons) {
        this.summonAltMajestyWeapons.put(item, weapons);
        return this;
    }

    public void summonWeapon(Level level, Player player) {
        if (this.summonAltMajestyWeapons.containsKey(player.getOffhandItem().getItem())) {
            for (Item item : this.summonAltMajestyWeapons.get(player.getOffhandItem().getItem())) {
                ItemStack stack = new ItemStack(item);
			    stack.set(DataComponents.ITEM_NAME, Component.translatable("owner.kamenridercraft.geiz", stack.getHoverName()));
			    if (stack.isDamageableItem() && level.getGameRules().getInt(ModGameRules.RULE_SUMMONED_ITEM_DURABILITY) > 0) stack.set(DataComponents.MAX_DAMAGE, level.getGameRules().getInt(ModGameRules.RULE_SUMMONED_ITEM_DURABILITY));

				ItemEntity entity = new ItemEntity(level, player.getX(), player.getY(), player.getZ(), stack, 0, 0, 0);
				entity.setPickUpDelay(0);
				level.addFreshEntity(entity);
            }
        } else if (!summonMajestyWeapons.isEmpty()) {
            for (Item item : this.summonMajestyWeapons) {
                ItemStack stack = new ItemStack(item);
			    stack.set(DataComponents.ITEM_NAME, Component.translatable("owner.kamenridercraft.geiz", stack.getHoverName()));
			    if (stack.isDamageableItem() && level.getGameRules().getInt(ModGameRules.RULE_SUMMONED_ITEM_DURABILITY) > 0) stack.set(DataComponents.MAX_DAMAGE, level.getGameRules().getInt(ModGameRules.RULE_SUMMONED_ITEM_DURABILITY));
                
				ItemEntity entity = new ItemEntity(level, player.getX(), player.getY(), player.getZ(), stack, 0, 0, 0);
				entity.setPickUpDelay(0);
				level.addFreshEntity(entity);
            }
        }
        if (!player.isCreative()) player.getCooldowns().addCooldown(this, 200);
        player.awardStat(Stats.ITEM_USED.get(this));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack itemstack = player.getItemInHand(usedHand);
        Item BELT = player.getItemBySlot(EquipmentSlot.FEET).getItem();

        if (player.isShiftKeyDown() && BELT instanceof RiderDriverItem driver && driver.isTransformed(player)
        && (RiderDriverItem.get_Form_Item(player.getItemBySlot(EquipmentSlot.FEET), 1) == Zi_O_Rider_Items.GEIZ_MAJESTY_RIDEWATCH.get())) {
            summonWeapon(level, player);
            return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
        }
        return super.use(level, player, usedHand);

    }
}
