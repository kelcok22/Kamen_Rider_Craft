package com.kelco.kamenridercraft.entity.mobs.bosses;

import com.kelco.kamenridercraft.entity.ai.FlyingBossControl;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.reiwa.SaberRiderItems;
import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import static com.kelco.kamenridercraft.world.data_attachments.AttachmentTypes.MOB_TRANSFORMED;

public class FalchionEntity extends BaseHenchmenEntity {
    public FalchionEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME = "falchion";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(SaberRiderItems.SABER_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(SaberRiderItems.SABER_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(SaberRiderItems.SABER_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(SaberRiderItems.HAKEN_BLADRIVER_FALCHION.get()));
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(SaberRiderItems.MUMEIKEN_KYOMU.get()));
        this.moveControl = new FlyingBossControl(this, 20);
    }

    @Override
    public void actuallyHurt(DamageSource source, float amount) {
        super.actuallyHurt(source, amount);
        if (!this.level().isClientSide() && source.getEntity() instanceof Player player && player.getInventory().countItem(SaberRiderItems.EMOTIONAL_DRAGON_WONDER_RIDE_BOOK.get()) == 0) {
            this.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 5, 3, true, false));
        }

        if (!this.level().isClientSide() && !this.getData(MOB_TRANSFORMED) && source.getEntity() instanceof Player player) {
            if (player.getInventory().countItem(SaberRiderItems.WONDER_WORLD_STORY_OF_RAIMEIKEN_IKAZUCHI_WONDER_RIDE_BOOK.get()) != 0) {
                this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.4);
                this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(12.0D);
                this.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(128.0D);
                this.setItemSlot(EquipmentSlot.FEET, new ItemStack(SaberRiderItems.HAKEN_BLADRIVER_FALCHION.get()));
                RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), SaberRiderItems.AMAZING_SIREN_WONDER_RIDE_BOOK.get(), 1);
                this.moveControl = new MoveControl(this);
                this.setNoGravity(false);
                if (this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUCEMENTS)) {
                    player.sendSystemMessage(Component.translatable("henshin.kamenridercraft.falchion_siren"));
                }
            }
        }
    }

    public void remove(RemovalReason removalReason) {
        if (this.isDeadOrDying() && this.getLastAttacker() instanceof Player player) {
            if (player.getInventory().countItem(SaberRiderItems.BRAVE_DRAGON_WONDER_RIDE_BOOK.get()) != 0) {
                ItemEntity emotionalDragon = new ItemEntity(player.level(), player.getX(), player.getY(), player.getZ(), new ItemStack(SaberRiderItems.EMOTIONAL_DRAGON_WONDER_RIDE_BOOK.get(), 1), 0, 0, 0);
                emotionalDragon.setPickUpDelay(0);
                player.level().addFreshEntity(emotionalDragon);
                player.sendSystemMessage(Component.translatable("loot.kamenridercraft.emotional_dragon"));
            }

            if (player.getInventory().countItem(SaberRiderItems.LAMP_DO_ALNGINA_WONDER_RIDE_BOOK.get()) != 0
                    && player.getInventory().countItem(SaberRiderItems.WONDER_WORLD_STORY_OF_RAIMEIKEN_IKAZUCHI_WONDER_RIDE_BOOK.get()) != 0) {

                if (player.getOffhandItem().is(SaberRiderItems.LAMP_DO_ALNGINA_WONDER_RIDE_BOOK.get())) {
                    player.getOffhandItem().shrink(1);
                } else {
                    player.getInventory().removeItem(player.getInventory().findSlotMatchingItem(new ItemStack(SaberRiderItems.LAMP_DO_ALNGINA_WONDER_RIDE_BOOK.get())), 1);
                }

                if (player.getOffhandItem().is(SaberRiderItems.WONDER_WORLD_STORY_OF_RAIMEIKEN_IKAZUCHI_WONDER_RIDE_BOOK.get())) {
                    player.getOffhandItem().shrink(1);
                } else {
                    player.getInventory().removeItem(player.getInventory().findSlotMatchingItem(new ItemStack(SaberRiderItems.WONDER_WORLD_STORY_OF_RAIMEIKEN_IKAZUCHI_WONDER_RIDE_BOOK.get())), 1);
                }

                ItemEntity arabianaNight = new ItemEntity(player.level(), player.getX(), player.getY(), player.getZ(), new ItemStack(SaberRiderItems.ARABIANA_NIGHT_WONDER_RIDE_BOOK.get(), 1), 0, 0, 0);
                arabianaNight.setPickUpDelay(0);
                player.level().addFreshEntity(arabianaNight);
                player.sendSystemMessage(Component.translatable("loot.kamenridercraft.arabiana_night"));
            }

            if (player.getInventory().countItem(SaberRiderItems.KAENKEN_REKKA.get()) != 0
                    && player.getInventory().countItem(SaberRiderItems.SUISEIKEN_NAGARE.get()) != 0
                    && player.getInventory().countItem(SaberRiderItems.RAIMEIKEN_IKAZUCHI.get()) != 0
                    && player.getInventory().countItem(SaberRiderItems.DOGOUKEN_GEKIDO.get()) != 0
                    && player.getInventory().countItem(SaberRiderItems.FUUSOUKEN_HAYATE_ITTOURYU.get()) != 0
                    && player.getInventory().countItem(SaberRiderItems.ONJUUKEN_SUZUNE.get()) != 0
                    && player.getInventory().countItem(SaberRiderItems.ANKOKUKEN_KURAYAMI.get()) != 0
                    && player.getInventory().countItem(SaberRiderItems.KOUGOUKEN_SAIKOU.get()) != 0
                    && player.getInventory().countItem(SaberRiderItems.ENEIKEN_NOROSHI.get()) != 0
                    && player.getInventory().countItem(SaberRiderItems.JIKOKUKEN_KAIJI.get()) != 0) {
                ItemEntity xrossSaber = new ItemEntity(player.level(), player.getX(), player.getY(), player.getZ(), new ItemStack(SaberRiderItems.HAOUKEN_XROSS_SABER.get(), 1), 0, 0, 0);
                xrossSaber.setPickUpDelay(0);
                player.level().addFreshEntity(xrossSaber);
                player.sendSystemMessage(Component.translatable("loot.kamenridercraft.xross_saber"));
            }
        }
        super.remove(removalReason);
    }


    public static AttributeSupplier.Builder setAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 135.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.2F)
                .add(Attributes.FLYING_SPEED, 0.2F)
                .add(Attributes.ATTACK_DAMAGE, 2.0D)
                .add(Attributes.ARMOR, 3.0D)
                .add(Attributes.MAX_HEALTH, 70.0D);
    }
}