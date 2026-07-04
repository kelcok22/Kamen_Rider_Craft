package com.kelco.kamenridercraft.item.heisei_phase_2.build;


import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.base_items.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.BuildRiderItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class FullBottleItem extends RiderFormChangeItem {
    private Boolean hazard = false;
    private Boolean legend = false;
    private String legendName;
    private Item bestMatch = BuildRiderItems.FULL_BOTTLE.get();

    public FullBottleItem(Properties properties, String formName, String ridername, String beltTex, MobEffectInstance... effects) {
        super(properties, formName, ridername, beltTex, effects);
    }

    public RiderFormChangeItem getBestMatch() {
        return (RiderFormChangeItem) bestMatch;
    }

    public Boolean getCanHazard() {
        return hazard;
    }

    public Boolean getIsLegend() {
        return legend;
    }

    public String getIsLegendName() {
        return legendName;
    }

    public FullBottleItem bestMatch(Item item) {
        bestMatch = item;
        return this;
    }

    public FullBottleItem isLegend(String formName) {
        legendName = formName;
        legend = true;
        return this;
    }

    public FullBottleItem canUseHazard() {
        hazard = true;
        return this;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack itemstack = player.getItemInHand(usedHand);
        ItemStack BELT = player.getItemBySlot(EquipmentSlot.FEET);

        if (level.isClientSide() && !player.hasEffect(EffectCore.FORM_LOCK) && BELT.getItem() instanceof RiderDriverItem belt) {
            if (canChange(player, belt, BELT)) {
                RiderDriverItem.setFormItem(player.getItemBySlot(EquipmentSlot.FEET), BuildRiderItems.FULL_BOTTLE.get(), 3);
                super.use(level, player, usedHand);
            } else if (!getAlternative().isEmpty()) {
                super.use(level, player, usedHand);
            }
        }
        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
    }
}