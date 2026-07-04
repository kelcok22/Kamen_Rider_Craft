package com.kelco.kamenridercraft.item.heisei_phase_2.Fourze;

import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.summons.RiderSummonEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.base_items.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.FourzeRiderItems;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


public class ShowaSwitchItem extends RiderFormChangeItem {
    private RiderDriverItem summonBelt;
    private RiderFormChangeItem summonForm = null;

    public ShowaSwitchItem( Properties properties,String formName,String ridername,String beltTex, MobEffectInstance... effects) {
        super(properties, formName, ridername, beltTex, effects);
    }

    public ShowaSwitchItem setSummonBelt(RiderDriverItem belt) {
        summonBelt = belt;
        return this;
    }

    public ShowaSwitchItem setSummonForm(RiderFormChangeItem form) {
        summonForm = form;
        return this;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack BELT = player.getItemBySlot(EquipmentSlot.FEET);

        if (player.isShiftKeyDown() && BELT.getItem() == FourzeRiderItems.FOURZE_DRIVER.get() && ((RiderDriverItem) BELT.getItem()).isTransformed(player)) {
            
		    RiderSummonEntity summon = MobsCore.RIDER_SUMMON.get().create(level);
		    if (summon != null) {
		    	summon.moveTo(player.getX(), player.getY()+1, player.getZ(), player.getYRot(), player.getXRot());
		    	summon.setItemSlot(EquipmentSlot.HEAD, new ItemStack(summonBelt.helmet));
		    	summon.setItemSlot(EquipmentSlot.CHEST, new ItemStack(summonBelt.chestplate));
		    	summon.setItemSlot(EquipmentSlot.LEGS, new ItemStack(summonBelt.leggings));
		    	summon.setItemSlot(EquipmentSlot.FEET, new ItemStack(summonBelt));
                if (summonForm != null) RiderDriverItem.setFormItem(summon.getItemBySlot(EquipmentSlot.FEET), summonForm, 1);

		    	level.addFreshEntity(summon);
		    	summon.bindToPlayer(player);
                if (!player.isCreative()) {
                    summon.takeSummonItem(player.getItemInHand(usedHand));
                    player.getCooldowns().addCooldown(this, 750);
                }
                player.awardStat(Stats.ITEM_USED.get(this));
		    }
            return InteractionResultHolder.sidedSuccess(player.getItemInHand(usedHand), level.isClientSide());
        } else return super.use(level, player, usedHand);
    }
}