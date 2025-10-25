package com.kelco.kamenridercraft.entities.ai;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;

public class FlyingBossControl extends MoveControl {
    private final int maxTurn;

    public FlyingBossControl(Mob mob, int maxTurn) {
        super(mob);
        this.maxTurn = maxTurn;
    }

    public void tick() {
        float f1 = (float)(this.speedModifier * this.mob.getAttributeValue(Attributes.FLYING_SPEED));
        if (this.operation == Operation.MOVE_TO && this.mob.getTarget() != null && (this.mob.getTarget().getY() > this.mob.getY()+1.9)) {
            this.operation = Operation.WAIT;
            this.mob.setNoGravity(true);
            this.setWantedPosition(this.mob.getTarget().getX(), this.mob.getTarget().getY(), this.mob.getTarget().getZ(), 2.0);
            double d0 = this.wantedX - this.mob.getX();
            double d1 = this.wantedY - this.mob.getY();
            double d2 = this.wantedZ - this.mob.getZ();
            double d3 = d0 * d0 + d1 * d1 + d2 * d2;
            if (d3 < (double)2.5000003E-7F) {
                this.mob.setYya(0.0F);
                this.mob.setZza(0.0F);
                return;
            }

            float f = (float)(Mth.atan2(d2, d0) * (double)180.0F / (double)(float)Math.PI) - 90.0F;
            this.mob.setYRot(this.rotlerp(this.mob.getYRot(), f, 90.0F));

            this.mob.setSpeed(f1);
            double d4 = Math.sqrt(d0 * d0 + d2 * d2);
            if (Math.abs(d1) > (double)1.0E-5F || Math.abs(d4) > (double)1.0E-5F) {
                float f2 = (float)(-(Mth.atan2(d1, d4) * (double)180.0F / (double)(float)Math.PI));
                this.mob.setXRot(this.rotlerp(this.mob.getXRot(), f2, (float)this.maxTurn));
                this.mob.setYya(d1 > (double)0.0F ? f1 : -f1);
            }
        } else if (this.mob.isNoGravity()) {
            if (this.mob.getTarget() != null) this.setWantedPosition(this.mob.getTarget().getX(), this.mob.getTarget().getY(), this.mob.getTarget().getZ(), 2.0);
            double d0 = this.wantedX - this.mob.getX();
            double d1 = this.wantedY - this.mob.getY();
            double d2 = this.wantedZ - this.mob.getZ();

            float f = (float)(Mth.atan2(d2, d0) * (double)180.0F / (double)(float)Math.PI) - 90.0F;
            this.mob.setYRot(this.rotlerp(this.mob.getYRot(), f, 90.0F));

            this.mob.setYya(this.mob.getTarget() != null && d1 > (double)0.001F ? f1 : -f1);
            this.mob.setZza(0.0F);
            this.mob.fallDistance = 0.0F;
            if (this.mob.onGround()) {
                this.mob.setYya(0.0F);
                this.mob.setNoGravity(false);
            }
        }
        super.tick();
    }
}
