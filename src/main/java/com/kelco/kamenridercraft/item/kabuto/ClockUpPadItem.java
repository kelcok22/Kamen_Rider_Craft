package com.kelco.kamenridercraft.item.kabuto;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Kabuto_Rider_Items;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import org.apache.commons.lang3.ArrayUtils;

import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Objects;


public class ClockUpPadItem extends BaseItem {

	public ClockUpPadItem (Properties properties)
	{
		super(properties);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {

		ItemStack itemstack = player.getItemInHand(usedHand);

		String[] ClockUpUsers = new String[] {"kabuto","thebee","drake","sasword","gatack","dark_kabuto","kickhopper","punchhopper","ketaros","hercus","caucasus","lady"};


		if (player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem belt && belt.isTransformed(player)){
            if(RiderDriverItem.get_Form_Item(player.getItemBySlot(EquipmentSlot.FEET), 1).is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "gear/hyper_zecters")))){
                Kabuto_Rider_Items.HYPER_ZECTER_CLOCK_UP.asItem().use(level,player,usedHand);
				if (!player.isCreative()) {
					player.getCooldowns().addCooldown(this, 500);
				}
				player.awardStat(Stats.ITEM_USED.get(this));
            } else if (!Objects.equals(RiderDriverItem.get_Form_Item(player.getItemBySlot(EquipmentSlot.FEET), 1).getFormName(false), "_masked")){
                if (ArrayUtils.contains(ClockUpUsers, belt.Rider) && !level.isClientSide()) {
                	player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 250, 20,true,false));
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