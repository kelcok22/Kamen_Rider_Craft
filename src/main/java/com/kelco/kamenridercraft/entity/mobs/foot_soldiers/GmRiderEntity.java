package com.kelco.kamenridercraft.entity.mobs.foot_soldiers;

import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.reiwa.GeatsRiderItems;
import com.kelco.kamenridercraft.item.showa.BlackRiderItems;
import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.network.chat.Component;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;

import static com.kelco.kamenridercraft.util.MiscUtil.canSpawnBoss;

public class GmRiderEntity extends BaseHenchmenEntity {

    private BaseHenchmenEntity boss;

    public GmRiderEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(GeatsRiderItems.GEATS_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(GeatsRiderItems.GEATS_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(GeatsRiderItems.GEATS_LEGGINGS.get()));
        if (this.random.nextInt(2) == 0) {
            NAME = "gm_rider";
            this.setItemSlot(EquipmentSlot.FEET, new ItemStack(GeatsRiderItems.DESIRE_DRIVER_GM.get()));
        } else {
            NAME = "gm_rider_chirami";
            RiderDriverItem.setUpdateForm(this.getItemBySlot(EquipmentSlot.FEET));
            this.setItemSlot(EquipmentSlot.FEET, new ItemStack(GeatsRiderItems.DESIRE_DRIVER_GM_CHIRAMI.get()));
        }
    }


    public void remove(Entity.RemovalReason p_149847_) {

        if (this.isDeadOrDying()) {
            double chance = this.random.nextDouble();
            int gamerule = this.level().getGameRules().getInt(ModGameRules.RULE_BOSS_SPAWN_PERCENTAGE);

            if (chance * 100.0 <= gamerule && (this.lastHurtByPlayer != null && canSpawnBoss(this.lastHurtByPlayer) || !(this.getLastAttacker() instanceof Player) && chance * 200.0 <= gamerule)) {
                int bossChoice = this.random.nextInt(3);
                switch (bossChoice) {
                    case 0:
                        boss = MobsCore.GLARE.get().create(this.level());
                        if (boss != null && this.getLastAttacker() instanceof Player playerIn && this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUNCEMENTS)) {
                            playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.glare"));
                        }
                        break;
                    case 1:
                        boss = MobsCore.GLARE2.get().create(this.level());
                        if (boss != null && this.getLastAttacker() instanceof Player playerIn && this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUNCEMENTS)) {
                            playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.glare2"));
                        }
                        break;
                    case 2:
                        boss = MobsCore.GAZER.get().create(this.level());
                        if (boss != null && this.getLastAttacker() instanceof Player playerIn && this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUNCEMENTS)) {
                            playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.gazer"));
                        }
                        break;
                    default:
                }
                if (boss != null) {
                    boss.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                    this.level().addFreshEntity(boss);
                }
            }
        }
        super.remove(p_149847_);
    }

    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 35.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.23F)
                .add(Attributes.ATTACK_DAMAGE, 4.0D)
                .add(Attributes.ARMOR, 3.0D)
                .add(Attributes.MAX_HEALTH, 30.0D)
                .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_34297_, DifficultyInstance p_34298_, MobSpawnType p_34299_, @Nullable SpawnGroupData p_34300_) {
        p_34300_ = super.finalizeSpawn(p_34297_, p_34298_, p_34299_, p_34300_);
        RiderDriverItem.setUpdateForm(this.getItemBySlot(EquipmentSlot.FEET));

        switch (p_34297_.getRandom().nextInt(16)) {
            case 0:
                RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), GeatsRiderItems.MAGNUM_RAISE_BUCKLE.get(), 2);
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(GeatsRiderItems.MAGNUM_SHOOTER_40X.get()));
                break;
            case 1:
                RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), GeatsRiderItems.BOOST_RAISE_BUCKLE.get(), 2);
                break;
            case 2:
                RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), GeatsRiderItems.ZOMBIE_RAISE_BUCKLE.get(), 2);
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(GeatsRiderItems.ZOMBIE_BREAKER.get()));
                break;
            case 3:
                RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), GeatsRiderItems.NINJA_RAISE_BUCKLE.get(), 2);
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(GeatsRiderItems.NINJA_DUELER_TWIN_BLADE_MODE.get()));
                this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(GeatsRiderItems.NINJA_DUELER_TWIN_BLADE_MODE2.get()));
                break;
            case 4:
                RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), GeatsRiderItems.MONSTER_RAISE_BUCKLE.get(), 2);
                break;
            case 5:
                RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), GeatsRiderItems.BEAT_RAISE_BUCKLE.get(), 2);
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(GeatsRiderItems.BEAT_AXE.get()));
                break;
            case 6:
                RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), GeatsRiderItems.ARROW_RAISE_BUCKLE.get(), 2);
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(GeatsRiderItems.RAISE_ARROW.get()));
                break;
            case 7:
                RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), GeatsRiderItems.WATER_RAISE_BUCKLE.get(), 2);
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(GeatsRiderItems.RAISE_WATER.get()));
                break;
            case 8:
                RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), GeatsRiderItems.HAMMER_RAISE_BUCKLE.get(), 2);
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(GeatsRiderItems.RAISE_HAMMER.get()));
                break;
            case 9:
                RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), GeatsRiderItems.SHIELD_RAISE_BUCKLE.get(), 2);
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(GeatsRiderItems.RAISE_SHIELD.get()));
                break;
            case 10:
                RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), GeatsRiderItems.CHAIN_ARRAY_RAISE_BUCKLE.get(), 2);
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(GeatsRiderItems.RAISE_CHAIN_ARRAY.get()));
                break;
            case 11:
                RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), GeatsRiderItems.CLAW_RAISE_BUCKLE.get(), 2);
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(GeatsRiderItems.RAISE_CLAW.get()));
                break;
            case 12:
                RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), GeatsRiderItems.DRILL_RAISE_BUCKLE.get(), 2);
                break;
            case 13:
                RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), GeatsRiderItems.PROPELLER_RAISE_BUCKLE.get(), 2);
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(GeatsRiderItems.RAISE_PROPELLER.get()));
                break;
        }
        return p_34300_;
    }

}