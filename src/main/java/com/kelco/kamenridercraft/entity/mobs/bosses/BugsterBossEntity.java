package com.kelco.kamenridercraft.entity.mobs.bosses;

import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.ExAidRiderItems;
import com.kelco.kamenridercraft.item.heisei_phase_2.GhostRiderItems;
import com.kelco.kamenridercraft.item.showa.BlackRiderItems;
import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.network.chat.Component;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;

import static com.kelco.kamenridercraft.util.MiscUtil.canSpawnBoss;

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