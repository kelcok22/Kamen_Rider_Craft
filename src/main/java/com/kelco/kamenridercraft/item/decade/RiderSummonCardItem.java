package com.kelco.kamenridercraft.item.decade;

import java.util.ArrayList;
import java.util.List;

import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.summons.RiderSummonEntity;
import com.kelco.kamenridercraft.item.Decade_Rider_Items;
import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderFormChangeItem;

import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


public class RiderSummonCardItem extends BaseItem {
    private RiderDriverItem summonBelt;
    private RiderFormChangeItem summonForm;
    private Integer summonNeoBelt = null;
    private Integer summonNeoForm = null;
    private List<Object> summonWeapons = new ArrayList<>(2);
    private int summonAmount = 1;

    public RiderSummonCardItem( Properties properties, int amount) {
        super(properties);
        summonAmount = amount;
    }

    public RiderSummonCardItem setSummonBelt(RiderDriverItem belt) {
        summonBelt = belt;
        return this;
    }

    public RiderSummonCardItem setSummonBelt(int neoBelt) {
        summonNeoBelt = neoBelt;
        return this;
    }

    public RiderSummonCardItem setSummonForm(RiderFormChangeItem form) {
        summonForm = form;
        return this;
    }

    public RiderSummonCardItem setSummonForm(int neoForm) {
        summonNeoForm = neoForm;
        return this;
    }

    public RiderSummonCardItem addSummonWeapon(Item weapon) {
        summonWeapons.add(weapon);
        return this;
    }

    public RiderSummonCardItem addSummonWeapon(int neoWeapon) {
        summonWeapons.add(neoWeapon);
        return this;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack BELT = player.getItemBySlot(EquipmentSlot.FEET);

        if (!level.isClientSide() && BELT.getItem() == Decade_Rider_Items.DIEND_BELT.get() && ((RiderDriverItem) BELT.getItem()).isTransformed(player)
        && ((this.summonNeoBelt == null && player.getInventory().countItem(Decade_Rider_Items.DIENDRIVER.get()) != 0) || player.getInventory().countItem(Decade_Rider_Items.NEO_DIENDRIVER.get()) != 0)) {
            if (this.summonNeoBelt != null) summonBelt = (RiderDriverItem) Decade_Rider_Items.NEO_DIEND_SUMMON_BELTS.get(summonNeoBelt);
            
            for (int i = 0; i < summonAmount; i++) {
			    RiderSummonEntity summon = MobsCore.RIDER_SUMMON.get().create(level);
			    if (summon != null) {
			    	summon.moveTo(player.getX(), player.getY()+1, player.getZ(), player.getYRot(), player.getXRot());
			    	summon.setItemSlot(EquipmentSlot.HEAD, new ItemStack(summonBelt.HEAD));
			    	summon.setItemSlot(EquipmentSlot.CHEST, new ItemStack(summonBelt.TORSO));
			    	summon.setItemSlot(EquipmentSlot.LEGS, new ItemStack(summonBelt.LEGS));
			    	summon.setItemSlot(EquipmentSlot.FEET, new ItemStack(summonBelt));
                    if (!summonWeapons.isEmpty()) summon.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(summonWeapons.get(0) instanceof Item item ? item : Decade_Rider_Items.NEO_DIEND_SUMMON_WEAPONS.get((int) summonWeapons.get(0))));
                    if (summonWeapons.size() == 2) summon.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(summonWeapons.get(1) instanceof Item item ? item : Decade_Rider_Items.NEO_DIEND_SUMMON_WEAPONS.get((int) summonWeapons.get(1))));
                    if (summonForm != null) RiderDriverItem.set_Form_Item(summon.getItemBySlot(EquipmentSlot.FEET), summonForm, 1);
                    else if (summonNeoForm != null) RiderDriverItem.set_Form_Item(summon.getItemBySlot(EquipmentSlot.FEET), Decade_Rider_Items.NEO_DIEND_SUMMON_FORMS.get(summonNeoForm), 1);
                
			    	level.addFreshEntity(summon);
			    	summon.bindToPlayer(player);
			    	player.displayClientMessage(Component.literal(Component.translatable("attack.kamenridercraft.kamenride").getString() + Component.translatable(this.toString() + ".name").getString()), true);
			    	if (!player.isCreative()) {
                        summon.takeSummonItem(player.getItemInHand(usedHand));
                        player.getCooldowns().addCooldown(this, 750);
                    }
                    player.awardStat(Stats.ITEM_USED.get(this));
			    }
            }
        }
        return InteractionResultHolder.sidedSuccess(player.getItemInHand(usedHand), level.isClientSide());
    }
}