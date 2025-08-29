package com.kelco.kamenridercraft.item.wizard;

import com.google.common.collect.Lists;
import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.summons.RiderSummonEntity;
import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Kabuto_Rider_Items;
import com.kelco.kamenridercraft.item.Wizard_Rider_Items;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.apache.commons.lang3.ArrayUtils;

import java.util.List;


public class LegendWizardRingItem extends BaseItem {

    private RiderDriverItem summonBelt;
	public String[] FORMS = new String[] {"wizard","wiseman","mage","mage_blue","mage_green","mage_foot_soldiers","mage_captain","sorcerer","wiseman_female","dark_wizard","black_wizard"};

	public LegendWizardRingItem(Properties properties, RiderDriverItem belt)
	{
		super(properties);
        summonBelt = belt;
	} // TODO: forms

	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		
		ItemStack itemstack = player.getItemInHand(hand);
		
		if (!level.isClientSide()
		&&player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem belt
		&&belt.isTransformed(player)){
			if (ArrayUtils.contains(FORMS, belt.Rider)) {
				RiderSummonEntity copy = MobsCore.RIDER_SUMMON.get().create(level);
				if (copy != null) {
                    copy.moveTo(player.getX(), player.getY() + 1, player.getZ(), player.getYRot(), player.getXRot());
                    copy.setItemSlot(EquipmentSlot.HEAD, new ItemStack(summonBelt.HEAD));
                    copy.setItemSlot(EquipmentSlot.CHEST, new ItemStack(summonBelt.TORSO));
                    copy.setItemSlot(EquipmentSlot.LEGS, new ItemStack(summonBelt.LEGS));
                    copy.setItemSlot(EquipmentSlot.FEET, new ItemStack(summonBelt));
                    if (summonBelt == Kabuto_Rider_Items.KABUTO_RIDER_BELT.get()) RiderDriverItem.set_Form_Item(copy.getItemBySlot(EquipmentSlot.FEET), Kabuto_Rider_Items.KABUTO_ZECTER.get(), 1);

                    level.addFreshEntity(copy);
                    copy.bindToPlayer(player);
                }
				if (!player.isCreative()) {
					player.getCooldowns().addCooldown(this, 500);
				}
				player.awardStat(Stats.ITEM_USED.get(this));
			}
		}
		
		return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
	}
}