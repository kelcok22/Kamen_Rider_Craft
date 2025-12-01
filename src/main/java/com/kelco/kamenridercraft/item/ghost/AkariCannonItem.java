package com.kelco.kamenridercraft.item.ghost;


import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.bosses.IgorEntity;
import com.kelco.kamenridercraft.entities.bosses.NecromEntity;
import com.kelco.kamenridercraft.entities.footSoldiers.GammaCommandoEntity;
import com.kelco.kamenridercraft.entities.summons.RiderSummonEntity;
import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.OOO_Rider_Items;
import com.kelco.kamenridercraft.item.Wizard_Rider_Items;
import com.kelco.kamenridercraft.particle.ModParticles;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import org.apache.commons.lang3.ArrayUtils;

import java.util.List;


public class AkariCannonItem extends BaseItem {


	public AkariCannonItem(Properties properties)
	{
		super(properties);
	}

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);

            if (level instanceof ServerLevel Slevel) {
                Slevel.sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                        player.getX() + 0, player.getY() + 1,
                        player.getZ() + 0, 200, 0, 0, 0, 4);

                    List<LivingEntity> nearbyEnemies = Slevel.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(50), entity ->
                            (entity instanceof GammaCommandoEntity));
                    for (LivingEntity enemy : nearbyEnemies) {
                        enemy.addEffect(new MobEffectInstance(MobEffects.GLOWING, 200, 0,true,true));
                    }
        if (!player.isCreative()) {
            player.getCooldowns().addCooldown(this, 500);
        }
        player.awardStat(Stats.ITEM_USED.get(this));
    }
		return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
}
}