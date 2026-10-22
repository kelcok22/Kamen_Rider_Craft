package com.kelco.kamenridercraft.entity.mobs.bosses;

import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.reiwa.GotchardRiderItems;
import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class DreadEntity extends BaseHenchmenEntity {
    public DreadEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME = "dread";
        setItemSlot(EquipmentSlot.HEAD, new ItemStack(GotchardRiderItems.GOTCHARD_HELMET.get()));
        setItemSlot(EquipmentSlot.CHEST, new ItemStack(GotchardRiderItems.GOTCHARD_CHESTPLATE.get()));
        setItemSlot(EquipmentSlot.LEGS, new ItemStack(GotchardRiderItems.GOTCHARD_LEGGINGS.get()));
        setItemSlot(EquipmentSlot.FEET, new ItemStack(GotchardRiderItems.DREADRIVER.get()));
        setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(GotchardRiderItems.BLOODY_AB.get()));
        RiderDriverItem.setUpdateForm(getItemBySlot(EquipmentSlot.FEET));
    }

    @Override
    public void actuallyHurt(@NotNull DamageSource source, float amount) {
        super.actuallyHurt(source, amount);
        if (!level().isClientSide() && source.getEntity() instanceof ServerPlayer player) {
            if (getHealth() < 75 && player.getInventory().countItem(GotchardRiderItems.TENLINER_RIDE_CHEMY_CARD.get().asItem()) != 0
                    && RiderDriverItem.getFormItem(getItemBySlot(EquipmentSlot.FEET), 1) != GotchardRiderItems.DREAD_TYPE_THREE_CARDS.get()) {
                if (level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUNCEMENTS)) {
                    player.sendSystemMessage(Component.translatable("henshin.kamenridercraft.dread_type_three"));
                }
                RiderDriverItem.setFormItem(getItemBySlot(EquipmentSlot.FEET), GotchardRiderItems.DREAD_TYPE_THREE_CARDS.get(), 1);
                setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(GotchardRiderItems.BLOODY_UC.get()));
                setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(GotchardRiderItems.BLOODY_DO.get()));
                RiderDriverItem.setUpdateForm(getItemBySlot(EquipmentSlot.FEET));
            }
        }
    }

    public void remove(@NotNull RemovalReason removalReason) {
        if (isDeadOrDying()) {
            if (getLastAttacker() instanceof ServerPlayer player
                    && player.getInventory().countItem(GotchardRiderItems.TENLINER_RIDE_CHEMY_CARD.get()) != 0) {
                ItemEntity key = new ItemEntity(player.level(), player.getX(), player.getY(), player.getZ(),
                        new ItemStack(GotchardRiderItems.CROSSHOPPER_RIDE_CHEMY_CARD.get(), 1), 0, 0, 0);
                key.setPickUpDelay(0);
                player.level().addFreshEntity(key);
                player.sendSystemMessage(Component.translatable("loot.kamenridercraft.crosshopper"));
            }
        }
        super.remove(removalReason);
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor accessor, DifficultyInstance difficulty, MobSpawnType mobSpawnType,
                                        @Nullable SpawnGroupData spawnGroupData) {
        spawnGroupData = super.finalizeSpawn(accessor, difficulty, mobSpawnType, spawnGroupData);

        if (accessor.getRandom().nextInt(2) == 1) {
            setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(GotchardRiderItems.BLOODY_BB.get()));
        }
        return spawnGroupData;
    }

    public static AttributeSupplier.Builder setAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 128.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.30F)
                .add(Attributes.ATTACK_DAMAGE, 5.0D)
                .add(Attributes.MAX_HEALTH, 100.0D);
    }
}