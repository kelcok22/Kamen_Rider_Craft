package com.kelco.kamenridercraft.entity.mobs.bosses;

import com.kelco.kamenridercraft.attachments.AttachmentTypes;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.ExAidRiderItems;
import com.kelco.kamenridercraft.particle.ModParticles;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.UUID;

public class BugsterBossEntity extends BaseHenchmenEntity {

    public BugsterBossEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME = "rider_summon";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ExAidRiderItems.EX_AIDHELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(ExAidRiderItems.EX_AIDCHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(ExAidRiderItems.EX_AIDLEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(ExAidRiderItems.GASHACON_BUGVISOR_BUGSTER.get()));
        RiderDriverItem.setFormItem(getItemBySlot(EquipmentSlot.FEET), ExAidRiderItems.MIGHTY_ACTION_X_GASHAT_BUGSTER.get(), 1);
        RiderDriverItem.setUpdateForm(this.getItemBySlot(EquipmentSlot.FEET));
    }

    public void remove(@NotNull RemovalReason removalReason) {
        if (isDeadOrDying()) {
            try {
                if (level() instanceof ServerLevel serverLevel && hasData(AttachmentTypes.UUID_STORE.get())
                        && serverLevel.getEntity(UUID.fromString(getData(AttachmentTypes.UUID_STORE.get()))) != null) {
                    Entity infected = serverLevel.getEntity(UUID.fromString(getData(AttachmentTypes.UUID_STORE.get())));
                    if (infected instanceof LivingEntity livingEntity) {
                        livingEntity.removeAllEffects();
                    }
                    serverLevel.sendParticles(ModParticles.HIT_PARTICLES.get(),
                            infected.getX() + 0.5, infected.getY() + 1.5,
                            infected.getZ() + 0.5, 1, 0, 0, 0, 3);
                    serverLevel.playSound(null, infected.getX(), infected.getY(), infected.getZ(), SoundEvents.ZOMBIE_VILLAGER_CURE,
                            SoundSource.VOICE, 3.0F, 1.0F / (level().getRandom().nextFloat() * 0.4F + 1.2F) + 1 * 0.5F);

                    infected.setData(AttachmentTypes.MOB_STATE, "normal");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        super.remove(removalReason);
    }


    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 35.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.23F)
                .add(Attributes.ATTACK_DAMAGE, 8.0D)
                .add(Attributes.ARMOR, 3.0D)
                .add(Attributes.MAX_HEALTH, 60.0D);
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_34297_, DifficultyInstance p_34298_, MobSpawnType p_34299_, @Nullable SpawnGroupData p_34300_) {
        p_34300_ = super.finalizeSpawn(p_34297_, p_34298_, p_34299_, p_34300_);

        if (p_34297_.getRandom().nextInt(3) == 1) {
            RiderDriverItem.setFormItem(getItemBySlot(EquipmentSlot.FEET), ExAidRiderItems.TADDLE_QUEST_GASHAT_BUGSTER.get(), 1);
            setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(ExAidRiderItems.ALHAMBRA_STAFF.get(), 1));
        } else if (p_34297_.getRandom().nextInt(3) == 2) {
            RiderDriverItem.setFormItem(getItemBySlot(EquipmentSlot.FEET), ExAidRiderItems.BAKUSOU_BIKE_GASHAT_BUGSTER.get(), 1);
        }
        return p_34300_;
    }
}