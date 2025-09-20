package com.kelco.kamenridercraft.item.gotchard;

import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.summons.RiderSummonEntity;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.Gotchard_Rider_Items;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.Objects;

public class RideChemyCardItem extends RiderFormChangeItem {
    public RideChemyCardItem(Properties properties, int belt, String formName, String ridername, String beltTex, MobEffectInstance... effects) {
        super(properties, belt, formName, ridername, beltTex, effects);
    }

    public boolean canSummonGotcharbrothers(Player player) {
        if (!needItemList.isEmpty()) {
            for (Item item : needItemList) {
                if (!inventoryOrHolderContains(player, item)) return false;
            }
        }
        return player.isShiftKeyDown() && player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof GotcharDriverItem driver && driver.isTransformed(player)
                && RiderDriverItem.get_Form_Item(player.getItemBySlot(EquipmentSlot.FEET), 1) == Gotchard_Rider_Items.NIJIGON_RIDE_CHEMY_CARD_EXTRA.get();
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        if (canSummonGotcharbrothers(player)) {
            RiderSummonEntity summon = MobsCore.RIDER_SUMMON.get().create(level);
            if (summon != null) {
                summon.moveTo(player.getX(), player.getY() + 1, player.getZ(), player.getYRot(), player.getXRot());
                summon.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Gotchard_Rider_Items.GOTCHARD_HELMET.get()));
                summon.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Gotchard_Rider_Items.GOTCHARD_CHESTPLATE.get()));
                summon.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Gotchard_Rider_Items.GOTCHARD_LEGGINGS.get()));
                summon.setItemSlot(EquipmentSlot.FEET, new ItemStack(Gotchard_Rider_Items.GOTCHARDRIVER_BROTHER.get()));
                RiderDriverItem.set_Form_Item(summon.getItemBySlot(EquipmentSlot.FEET), this, 1);

                level.addFreshEntity(summon);
                summon.bindToPlayer(player);
                summon.addRequiredForm((RiderFormChangeItem)Gotchard_Rider_Items.NIJIGON_RIDE_CHEMY_CARD_EXTRA.get(), 1);
                if (!player.isCreative()) {
                    summon.takeSummonItem(player.getItemInHand(usedHand));
                    player.getCooldowns().addCooldown(this, 750);
                }
                player.awardStat(Stats.ITEM_USED.get(this));
            }
            return InteractionResultHolder.sidedSuccess(player.getItemInHand(usedHand), level.isClientSide());
        }
        return super.use(level, player, usedHand);
    }
}
