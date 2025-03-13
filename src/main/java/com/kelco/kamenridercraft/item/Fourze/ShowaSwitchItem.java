package com.kelco.kamenridercraft.item.Fourze;

import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.summons.RiderSummonEntity;
import com.kelco.kamenridercraft.item.Fourze_Rider_Items;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderFormChangeItem;

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

    public ShowaSwitchItem( Properties properties,int belt,String formName,String ridername,String beltTex, MobEffectInstance... effects) {
        super(properties, belt, formName, ridername, beltTex, effects);
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

        if (player.isShiftKeyDown() && BELT.getItem() == Fourze_Rider_Items.FOURZE_DRIVER.get() && ((RiderDriverItem) BELT.getItem()).isTransformed(player)) {
            
		    RiderSummonEntity summon = MobsCore.RIDER_SUMMON.get().create(level);
		    if (summon != null) {
		    	summon.moveTo(player.getX(), player.getY()+1, player.getZ(), player.getYRot(), player.getXRot());
		    	summon.setItemSlot(EquipmentSlot.HEAD, new ItemStack(summonBelt.HEAD));
		    	summon.setItemSlot(EquipmentSlot.CHEST, new ItemStack(summonBelt.TORSO));
		    	summon.setItemSlot(EquipmentSlot.LEGS, new ItemStack(summonBelt.LEGS));
		    	summon.setItemSlot(EquipmentSlot.FEET, new ItemStack(summonBelt));
                if (summonForm != null) RiderDriverItem.set_Form_Item(summon.getItemBySlot(EquipmentSlot.FEET), summonForm, 1);

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