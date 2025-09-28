package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.Zero_One_Rider_Items;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;

import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.joml.Vector3f;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;

public class ArkZeroEntity extends BaseHenchmenEntity {
    private final ServerBossEvent bossEvent = new ServerBossEvent(getDisplayName(), BossEvent.BossBarColor.RED, BossEvent.BossBarOverlay.PROGRESS);
    private static final EntityDataAccessor<Integer> DATA_ID_INV;
    public static List<Item> THINGS_AND_STUFF= new ArrayList<>();


    public ArkZeroEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="ark_zero";
        this.makeInvulnerable();
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new DoNothingGoal());
        super.registerGoals();
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (this.getInvulnerableTicks() > 0 && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) return false;
        else return super.hurt(source, amount);
    }

	@Override
    public void actuallyHurt(DamageSource source, float amount) {
        super.actuallyHurt(source, amount);
    	if(!this.level().isClientSide() && source.getEntity() instanceof Player playerIn && this.getHealth()<100
		&& this.getItemBySlot(EquipmentSlot.FEET).getItem()==Zero_One_Rider_Items.ARK_DRIVER_ZERO.get() && RiderDriverItem.get_Form_Item(this.getItemBySlot(EquipmentSlot.FEET),1)!=Zero_One_Rider_Items.ARK_ONE_PROGRISEKEY.get()) {
			playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.ark_one"));
    				
    		this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.5);
    		this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(10.0D);
    		this.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(128.0D);
    	    RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Zero_One_Rider_Items.ARK_ONE_PROGRISEKEY.get(), 1);
        }
    }

    @Override
    protected void updateInvisibilityStatus() {
        super.updateInvisibilityStatus();
        if (this.getInvulnerableTicks() > 0) this.setInvisible(true);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (this.getInvulnerableTicks() > 0) {
            for (int i1 = 0; i1 < 5; ++i1) {
                this.level().addParticle(new DustParticleOptions(new Vector3f(0.0f, 0.0f, 0.0f), 4f), this.getX() + this.random.nextGaussian() / 2, (this.getEyeY()-0.25 + this.random.nextGaussian() / 2) * this.getScale(), this.getZ() + this.random.nextGaussian() / 2, 0.0F, 0.0F, 0.0F);
                //this.level().addParticle(ColorParticleOption.create(ParticleTypes.ENTITY_EFFECT, 0.7F, 0.7F, 0.9F), this.getX() + this.random.nextGaussian(), this.getY() + (double)(this.random.nextFloat() * f3), this.getZ() + this.random.nextGaussian(), 0.0F, 0.0F, 0.0F);
            }
            if (this.getInvulnerableTicks() <= 200 && this.getInvulnerableTicks() % 3 == 0)
                this.level().addParticle(new DustParticleOptions(new Vector3f(1.0f, 0.0f, 0.0f), 4f), this.getX() + this.random.nextGaussian() / 2, (this.getEyeY()-0.25 + this.random.nextGaussian() / 2) * this.getScale(), this.getZ() + this.random.nextGaussian() / 2, 0.0F, 0.0F, 0.0F);

            if (this.getInvulnerableTicks() == 200) {
                for (Player player : this.level().getNearbyPlayers(TargetingConditions.forNonCombat().range(16.0), this, this.getBoundingBox().inflate(16)))
                    player.displayClientMessage(Component.translatable("henshin.kamenridercraft.ark_zero"), true);
            } else if (this.getInvulnerableTicks() == 1) {
                for (Player player : this.level().getNearbyPlayers(TargetingConditions.forNonCombat().range(16.0), this, this.getBoundingBox().inflate(16)))
                    player.displayClientMessage(Component.translatable("henshin.kamenridercraft.ark_zero_2"), true);
            }
        }
    }

    protected void customServerAiStep() {
        this.bossEvent.setName(Component.translatable("entity.kamenridercraft.ark_zero").withStyle(ChatFormatting.RED));

        if (this.getInvulnerableTicks() > 0) {
            int j = this.getInvulnerableTicks() - 1;
            this.bossEvent.setProgress(1.0F - (float) j / 220.0F);

            this.setInvulnerableTicks(j);
            if (this.tickCount % 10 == 0) this.heal(10.0F);
            if (this.getInvulnerableTicks() == 0) {
                this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Zero_One_Rider_Items.ZERO_ONE_HELMET.get()));
                this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Zero_One_Rider_Items.ZERO_ONE_CHESTPLATE.get()));
                this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Zero_One_Rider_Items.ZERO_ONE_LEGGINGS.get()));
                this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Zero_One_Rider_Items.ARK_DRIVER_ZERO.get()));
            }

        } else {
            super.customServerAiStep();
            this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
        }
    }

    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_ID_INV, 0);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Invul", this.getInvulnerableTicks());
    }

    public void readAdditionalSaveData(CompoundTag p_31474_) {
        super.readAdditionalSaveData(p_31474_);
        this.setInvulnerableTicks(p_31474_.getInt("Invul"));
        if (this.hasCustomName()) {
            this.bossEvent.setName(this.getDisplayName());
        }
    }

    public void makeInvulnerable() {
        this.setInvulnerableTicks(220);
        this.bossEvent.setProgress(0.0F);
        this.setHealth(this.getMaxHealth() / 3.0F);
        for (Player player : this.level().getNearbyPlayers(TargetingConditions.forCombat().range(32.0), this, this.getBoundingBox().inflate(16)))
            player.sendSystemMessage(Component.translatable("henshin.kamenridercraft.ark_zero_msg"));
    }

    public int getInvulnerableTicks() {
        return this.entityData.get(DATA_ID_INV);
    }

    public void setInvulnerableTicks(int invulnerableTicks) {
        this.entityData.set(DATA_ID_INV, invulnerableTicks);
    }

    public void setCustomName(@Nullable Component p_31476_) {
        super.setCustomName(p_31476_);
        this.bossEvent.setName(this.getDisplayName());
    }

    public void startSeenByPlayer(ServerPlayer p_31483_) {
        super.startSeenByPlayer(p_31483_);
        this.bossEvent.addPlayer(p_31483_);
    }

    public void stopSeenByPlayer(ServerPlayer p_31488_) {
        super.stopSeenByPlayer(p_31488_);
        this.bossEvent.removePlayer(p_31488_);
    }



    public void tick() {
        if (this.getHealth()<150 && this.getInvulnerableTicks() == 0) {
            if(getItemBySlot(EquipmentSlot.FEET).getItem()==Zero_One_Rider_Items.ARK_DRIVER_ZERO.get()){
                Random generator = new Random();
                int rand = generator.nextInt(THINGS_AND_STUFF.size());
                int rand2 = generator.nextInt(200);
                    if (rand2==1)this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(THINGS_AND_STUFF.get(rand)));
                }

        }
        super.tick();
    }


    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 135.0D)
        		.add(Attributes.MOVEMENT_SPEED, 0.3F)
        		.add(Attributes.ATTACK_DAMAGE, 10.0D)
        		.add(Attributes.ARMOR, 3.0D)
        		.add(Attributes.MAX_HEALTH, 200.0D);
     }

    static {
        DATA_ID_INV = SynchedEntityData.defineId(ArkZeroEntity.class, EntityDataSerializers.INT);
    }

    class DoNothingGoal extends Goal {
        public DoNothingGoal() {
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
        }

        @Override
        public boolean canUse() {
            return ArkZeroEntity.this.getInvulnerableTicks() > 0;
        }
    }
    

}
