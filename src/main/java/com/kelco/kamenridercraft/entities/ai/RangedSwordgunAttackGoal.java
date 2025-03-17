package com.kelco.kamenridercraft.entities.ai;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.entities.summons.BaseSummonEntity;

import net.minecraft.resources.ResourceLocation;

import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.FlyingMob;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.RangedBowAttackGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;

public class RangedSwordgunAttackGoal<T extends Mob & RangedAttackMob> extends RangedBowAttackGoal<T> {
    private T mob;
    private double BOW_DISTANCE;

    public RangedSwordgunAttackGoal(T mob, double speedModifier, int attackIntervalMin, float attackRadius, double bowDistance) {
        this(mob, speedModifier, attackIntervalMin, attackRadius);
        this.mob = mob;
        this.BOW_DISTANCE = bowDistance;
    }

    public RangedSwordgunAttackGoal(T p_25792_, double p_25793_, int p_25794_, float p_25795_) {
        super(p_25792_, p_25793_, p_25794_, p_25795_);
    }

    @Override
    public boolean canUse() {
        if (this.mob.getTarget() != null) {
            boolean swordgunMeleeOnly = ((this.mob instanceof BaseHenchmenEntity entity && entity.getMeleeOnly()) || (this.mob instanceof BaseSummonEntity summon && summon.getMeleeOnly()));
            boolean playerFlying = this.mob.getTarget() instanceof Player player && player.getAbilities().flying && player.distanceToSqr(this.mob) > 5.0D;
            boolean targetClose = ((this.mob.getTarget() instanceof FlyingMob fly && fly.distanceToSqr(this.mob) < 20.0D)
                || this.mob.getTarget().distanceToSqr(this.mob) < this.BOW_DISTANCE);
            return this.isHoldingSwordgun() && (!targetClose || playerFlying) && !swordgunMeleeOnly;
        }
        return false;
    }

    protected boolean isHoldingSwordgun() {
        return this.mob.isHolding(is -> is.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "arsenal/all_swordguns"))));
    }

    @Override
    public boolean canContinueToUse() {
        return (this.canUse() || !this.mob.getNavigation().isDone()) && this.isHoldingSwordgun();
    }
}
