package com.kelco.kamenridercraft.item.heisei_phase_2.zi_o;

import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.summons.GrandSummonEntity;
import com.kelco.kamenridercraft.item.base_items.BaseItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.base_items.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.FourzeRiderItems;
import com.kelco.kamenridercraft.item.heisei_phase_2.GhostRiderItems;
import com.kelco.kamenridercraft.item.heisei_phase_2.OOORiderItems;
import com.kelco.kamenridercraft.item.heisei_phase_2.ZiORiderItems;
import com.kelco.kamenridercraft.item.reiwa.GotchardRiderItems;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FinalFormRidewatchItem extends BaseItem {
    private RiderDriverItem summonBelt;
    private RiderFormChangeItem summonForm = null;
    private Map<Item, RiderFormChangeItem[]> summonAltForms = new HashMap<>();
    private Map<Item, RiderDriverItem> summonAltBelts = new HashMap<>();
    private Map<Item, Item[]> summonAltWeapons = new HashMap<>();
    private List<Item> summonWeapons = new ArrayList<>(2);

    public FinalFormRidewatchItem(Properties properties) {
        super(properties);
    }

    public FinalFormRidewatchItem setSummonBelt(RiderDriverItem belt) {
        this.summonBelt = belt;
        return this;
    }

    public FinalFormRidewatchItem setSummonForm(RiderFormChangeItem form) {
        this.summonForm = form;
        return this;
    }

    public FinalFormRidewatchItem addAltForm(Item item, RiderFormChangeItem... forms) {
        this.summonAltForms.put(item, forms);
        return this;
    }

    public FinalFormRidewatchItem addAltBelt(Item item, RiderDriverItem belt) {
        this.summonAltBelts.put(item, belt);
        return this;
    }

    public FinalFormRidewatchItem addAltWeapon(Item item, Item... weapons) {
        this.summonAltWeapons.put(item, weapons);
        return this;
    }

    public FinalFormRidewatchItem addSummonWeapon(Item weapon) {
        this.summonWeapons.add(weapon);
        return this;
    }

    public void summon(Level level, Player player) {
        GrandSummonEntity summon = MobsCore.GRAND_SUMMON.get().create(level);
        if (summon != null) {
            summon.allowFormChanges(true);
            summon.moveTo(player.getX(), player.getY() + 1, player.getZ(), player.getYRot(), player.getXRot());
            summon.setItemSlot(EquipmentSlot.HEAD, new ItemStack(this.summonBelt.helmet));
            summon.setItemSlot(EquipmentSlot.CHEST, new ItemStack(this.summonBelt.chestplate));
            summon.setItemSlot(EquipmentSlot.LEGS, new ItemStack(this.summonBelt.leggings));
            Item key = player.getOffhandItem().getItem();

            if (this.summonAltBelts.containsKey(key)) {
                summon.setItemSlot(EquipmentSlot.FEET, new ItemStack(this.summonAltBelts.get(key)));
            } else summon.setItemSlot(EquipmentSlot.FEET, new ItemStack(this.summonBelt));

            if (this.summonAltWeapons.containsKey(key)) {
                summon.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(this.summonAltWeapons.get(key)[0]));
                if (this.summonAltWeapons.get(key).length > 1)
                    summon.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(this.summonAltWeapons.get(key)[1]));
            } else if (!summonWeapons.isEmpty()) {
                summon.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(this.summonWeapons.get(0)));
                if (this.summonWeapons.size() == 2)
                    summon.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(summonWeapons.get(1)));
            }

            for (ItemStack weapon : summon.getHandSlots()) {
                if (player.getItemBySlot(EquipmentSlot.FEET).is(GotchardRiderItems.LEGENDRIVER.get()))
                    weapon.set(DataComponents.ITEM_NAME, Component.translatable("owner.kamenridercraft.legend", weapon.getHoverName()));
                else
                    weapon.set(DataComponents.ITEM_NAME, Component.translatable("owner.kamenridercraft.zi_o", weapon.getHoverName()));
            }

            if (this.summonForm != null) {
                RiderDriverItem.setFormItem(summon.getItemBySlot(EquipmentSlot.FEET), this.summonForm, this.summonForm.getSlot());
                if (this.summonForm == OOORiderItems.PTERA_MEDAL.get()) {
                    RiderDriverItem.setFormItem(summon.getItemBySlot(EquipmentSlot.FEET), OOORiderItems.TRICERA_MEDAL.get(), 2);
                    RiderDriverItem.setFormItem(summon.getItemBySlot(EquipmentSlot.FEET), OOORiderItems.TYRANNO_MEDAL.get(), 3);
                } else if (this.summonForm == FourzeRiderItems.COSMIC_ASTROSWITCH.get()) {
                    RiderDriverItem.setFormItem(summon.getItemBySlot(EquipmentSlot.FEET), FourzeRiderItems.FOURZE_COSMIC_STATES.get(), 5);
                }else if (this.summonForm == GhostRiderItems.MUGEN_DAMASHII.get()) {
                    RiderDriverItem.setFormItem(summon.getItemBySlot(EquipmentSlot.FEET), GhostRiderItems.MUGEN_GHOST_EYECON.get(), 1);
                }
            }

            if (this.summonAltForms.containsKey(key)) {
                for (RiderFormChangeItem item : this.summonAltForms.get(key)) {
                    RiderDriverItem.setFormItem(summon.getItemBySlot(EquipmentSlot.FEET), item, item.getSlot());
                }
            }

            level.addFreshEntity(summon);
            summon.bindToPlayer(player);
            summon.allowFormChanges(false);
            if (!player.isCreative()) player.getCooldowns().addCooldown(this, 400);
            player.awardStat(Stats.ITEM_USED.get(this));
        }
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemstack = player.getItemInHand(interactionHand);
        ItemStack BELT = player.getItemBySlot(EquipmentSlot.FEET);

        if (!level.isClientSide() && player.isShiftKeyDown() && BELT.getItem() instanceof RiderDriverItem driver && driver.isTransformed(player)
                && (RiderDriverItem.getFormItem(BELT, 1) == ZiORiderItems.GRAND_ZI_O_RIDEWATCH.get() && (this != ZiORiderItems.BIO_RIDER_RIDEWATCH.get() && this != ZiORiderItems.GENM_RIDEWATCH.get())
                || RiderDriverItem.getFormItem(BELT, 1) == ZiORiderItems.UNFINISHED_OHMA_ZI_O_DRIVER_L.get()
                || RiderDriverItem.getFormItem(BELT, 1) == ZiORiderItems.OHMA_ZI_O_RIDEWATCH.get()
                || RiderDriverItem.getFormItem(BELT, 1) == GotchardRiderItems.GRAND_ZI_O_RIDE_CHEMY_CARD.get())) {
            summon(level, player);
            return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
        }
        return super.use(level, player, interactionHand);

    }
}
