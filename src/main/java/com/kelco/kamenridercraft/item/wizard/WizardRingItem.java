package com.kelco.kamenridercraft.item.wizard;

import com.google.common.collect.Lists;
import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.summons.RiderSummonEntity;
import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Decade_Rider_Items;
import com.kelco.kamenridercraft.item.Wizard_Rider_Items;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.OwnableEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.server.ServerLifecycleHooks;
import org.apache.commons.lang3.ArrayUtils;

import java.util.List;


public class WizardRingItem extends BaseItem {

	private List<MobEffectInstance> EFFECTS;
	public String[] FORMS = new String[] {"wizard","wiseman","mage","mage_blue","mage_green","mage_foot_soldiers","mage_captain","sorcerer","wiseman_female","dark_wizard","black_wizard"};

	public WizardRingItem(Properties properties, MobEffectInstance... effects)
	{
		super(properties);
		EFFECTS = Lists.newArrayList(effects);
	}


	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		
		ItemStack itemstack = player.getItemInHand(hand);
		
		if (!level.isClientSide()
		&&player.getItemBySlot(EquipmentSlot.LEGS).getItem() == Wizard_Rider_Items.WIZARD_LEGGINGS.get()
		&&player.getItemBySlot(EquipmentSlot.CHEST).getItem() == Wizard_Rider_Items.WIZARD_CHESTPLATE.get()
		&&player.getItemBySlot(EquipmentSlot.HEAD).getItem() == Wizard_Rider_Items.WIZARD_HEAD.get()){
			if (player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem belt){
				if (ArrayUtils.contains(FORMS, ((RiderDriverItem) belt).GET_TEXT(player.getItemBySlot(EquipmentSlot.FEET), null, player, ((RiderDriverItem) belt).Rider))) {
					if (EFFECTS != null) {
						for (int i = 0; i < EFFECTS.size(); i++)
						{
							player.addEffect(new MobEffectInstance(EFFECTS.get(i).getEffect(),EFFECTS.get(i).getDuration(),EFFECTS.get(i).getAmplifier(),true,true));
						}
					}
					if (!player.isCreative()) {
						player.getCooldowns().addCooldown(this, 500);
					}
					player.awardStat(Stats.ITEM_USED.get(this));
				}
			}
		}
		
		return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
	}
}