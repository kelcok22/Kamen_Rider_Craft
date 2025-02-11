package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.Saber_Rider_Items;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;

public class DurendalEntity extends BaseHenchmenEntity {

    private boolean kaijiMasshou = false;

    public DurendalEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="durendal";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Saber_Rider_Items.SABER_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Saber_Rider_Items.SABER_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Saber_Rider_Items.SABER_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Saber_Rider_Items.ROYAL_SWORD_OF_LOGOS_BUCKLE_DURENDAL.get()));
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Saber_Rider_Items.JIKOKUKEN_KAIJI.get()));
    }

    void teleportTowards(Entity target) {
        Vec3 vec3 = new Vec3(this.getX() - target.getX(), this.getY() - target.getEyeY(), this.getZ() - target.getZ()).normalize();
        double d1 = this.getX();
        double d2 = this.getY();
        double d3 = this.getZ();
        double d4 = d1 + (this.random.nextDouble() - 0.5) * 4.0 - vec3.x * 4.0;
        double d5 = d2 + (double)(this.random.nextInt(16) - 4) - vec3.y * 4.0;
        double d6 = d3 + (this.random.nextDouble() - 0.5) * 4.0 - vec3.z * 4.0;
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(d4, d5, d6);

        while (pos.getY() > this.level().getMinBuildHeight() && !this.level().getBlockState(pos).blocksMotion()) {
            pos.move(Direction.DOWN);
        }

        if (this.randomTeleport(d4, d5, d6, false)) {
            net.neoforged.neoforge.event.entity.EntityTeleportEvent.EnderEntity event = net.neoforged.neoforge.event.EventHooks.onEnderTeleport(this, d4, d5, d6);
            if (!event.isCanceled()) {
                if (this.level() instanceof ServerLevel level) level.sendParticles(ParticleTypes.SPLASH, d1, d2+1, d3, 100, 0.5, 0.5, 0.5, 1);
                this.level().gameEvent(GameEvent.TELEPORT, this.position(), GameEvent.Context.of(this));
            }
        }
    }

	@Override
    public void actuallyHurt(DamageSource source, float amount) {
        super.actuallyHurt(source, amount);
    	if(!this.level().isClientSide() && this.getHealth()<100 && this.isAlive() && source.getEntity() instanceof Player playerIn) {
            if (!kaijiMasshou) {
                this.teleportTowards(playerIn);
                playerIn.randomTeleport(playerIn.getRandomX(4), playerIn.getY()+1, playerIn.getRandomZ(4), false);
                playerIn.sendSystemMessage(Component.translatable("attack.kamenridercraft.kaiji_masshou"));
                kaijiMasshou = true;
            } else if (this.random.nextInt(2) == 0) {
                this.teleportTowards(playerIn);
                playerIn.randomTeleport(playerIn.getRandomX(4), playerIn.getY()+1, playerIn.getRandomZ(4), false);
            }
    	}
    }    
    

    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 135.0D)
        		.add(Attributes.MOVEMENT_SPEED,(double)0.3F)
        		.add(Attributes.ATTACK_DAMAGE, 9.0D)
        		.add(Attributes.ARMOR, 3.0D)
        		.add(Attributes.MAX_HEALTH, 180.0D);
     }
    

}
