package com.kelco.kamenridercraft.item.wizard;

import com.google.common.collect.Lists;
import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.summons.RiderSummonEntity;
import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
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


public class WizardRingItem extends BaseItem {

	private List<MobEffectInstance> EFFECTS;
	public String SPECIAL;
	public String[] FORMS = new String[] {"wizard","wiseman","mage","mage_blue","mage_green","mage_foot_soldiers","mage_captain","sorcerer","wiseman_female","dark_wizard","black_wizard"};

	public WizardRingItem (Properties properties, MobEffectInstance... effects)
	{
		super(properties);
		EFFECTS = Lists.newArrayList(effects);
	}

	public WizardRingItem (Properties properties, String special)
	{
		super(properties);
		SPECIAL = special;
	}


	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		
		ItemStack itemstack = player.getItemInHand(hand);
		
		if (!level.isClientSide()
		&&player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem belt
		&&belt.isTransformed(player)){
			if (ArrayUtils.contains(FORMS, belt.Rider)) {
				if (EFFECTS != null) {
					for (int i = 0; i < EFFECTS.size(); i++)
					{
						player.addEffect(new MobEffectInstance(EFFECTS.get(i).getEffect(),EFFECTS.get(i).getDuration(),EFFECTS.get(i).getAmplifier(),true,true));
					}
				} else {
					switch (SPECIAL) {
						case "copy":
							RiderSummonEntity copy = MobsCore.RIDER_SUMMON.get().create(level);
							if (copy != null) {
								copy.moveTo(player.getX(), player.getY()+1, player.getZ(), player.getYRot(), player.getXRot());
								copy.NAME = "wizard_copy";
								copy.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Wizard_Rider_Items.WIZARD_HEAD.get()));
								copy.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Wizard_Rider_Items.WIZARD_CHESTPLATE.get()));
								copy.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Wizard_Rider_Items.WIZARD_LEGGINGS.get()));
								copy.setItemSlot(EquipmentSlot.FEET, player.getItemBySlot(EquipmentSlot.FEET));
								RiderDriverItem.set_Form_Item(copy.getItemBySlot(EquipmentSlot.FEET), RiderDriverItem.get_Form_Item(player.getItemBySlot(EquipmentSlot.FEET),1), 1);
								
								level.addFreshEntity(copy);
								copy.bindToPlayer(player);
							}
							break;
					}
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