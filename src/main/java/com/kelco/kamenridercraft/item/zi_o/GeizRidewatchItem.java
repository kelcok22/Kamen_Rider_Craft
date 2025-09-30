package com.kelco.kamenridercraft.item.zi_o;

import com.kelco.kamenridercraft.item.Zi_O_Rider_Items;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderFormChangeItem;

import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


public class GeizRidewatchItem extends RiderFormChangeItem {
    public GeizRidewatchItem( Properties properties,int belt,String formName,String ridername,String beltTex, MobEffectInstance... effects) {
        super(properties, belt, formName, ridername, beltTex, effects);
    }

    public void summonWeapon(Level level, Player player) {
        ItemStack stack = new ItemStack(Zi_O_Rider_Items.ZIKAN_ZAX.get());
        if (player.getOffhandItem().getItem() == Zi_O_Rider_Items.GEIZ_REVIVE_RIDEWATCH.get()) stack = new ItemStack(Zi_O_Rider_Items.ZIKAN_JACLAW.get());
        
		stack.set(DataComponents.ITEM_NAME, Component.translatable("owner.kamenridercraft.geiz", stack.getHoverName()));
		if (stack.isDamageableItem() && level.getGameRules().getInt(ModGameRules.RULE_SUMMONED_ITEM_DURABILITY) > 0) stack.set(DataComponents.MAX_DAMAGE, level.getGameRules().getInt(ModGameRules.RULE_SUMMONED_ITEM_DURABILITY));

		ItemEntity entity = new ItemEntity(level, player.getX(), player.getY(), player.getZ(), stack, 0, 0, 0);
		entity.setPickUpDelay(0);
		level.addFreshEntity(entity);

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
