package com.kelco.kamenridercraft.entity.mobs.foot_soldiers;

import com.kelco.kamenridercraft.entity.effect.SealingEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_1.BladeRiderItems;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.damagesource.DamageContainer;

import static com.kelco.kamenridercraft.attachments.AttachmentTypes.UUID_STORE;
import static com.kelco.kamenridercraft.attachments.AttachmentTypes.MOB_STATE;
import static com.kelco.kamenridercraft.entity.mobs.MobsCore.SEALING_EFFECT;

public class UndeadEntity extends BaseHenchmenEntity {
    HolderLookup.RegistryLookup<Enchantment> enchantmentRegistryLookup = level().registryAccess().lookupOrThrow(Registries.ENCHANTMENT);

    public UndeadEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME = "undead_human";
        getAttribute(Attributes.REINFORCEMENT_CHANCE).setBaseValue(12D);
        if (getData(MOB_STATE).isEmpty() && !level().isClientSide()) {
            setItemSlot(EquipmentSlot.HEAD, new ItemStack(BladeRiderItems.BLADEHELMET.get()));
            getItemBySlot(EquipmentSlot.HEAD).enchant(enchantmentRegistryLookup.get(Enchantments.UNBREAKING).get(), 255);
            setItemSlot(EquipmentSlot.CHEST, new ItemStack(BladeRiderItems.BLADECHESTPLATE.get()));
            getItemBySlot(EquipmentSlot.CHEST).enchant(enchantmentRegistryLookup.get(Enchantments.UNBREAKING).get(), 255);
            setItemSlot(EquipmentSlot.LEGS, new ItemStack(BladeRiderItems.BLADELEGGINGS.get()));
            getItemBySlot(EquipmentSlot.LEGS).enchant(enchantmentRegistryLookup.get(Enchantments.UNBREAKING).get(), 255);
            setItemSlot(EquipmentSlot.FEET, new ItemStack(BladeRiderItems.UNDEAD_BUCKLE.get()));
            getItemBySlot(EquipmentSlot.FEET).enchant(enchantmentRegistryLookup.get(Enchantments.UNBREAKING).get(), 255);

            setDropChance(EquipmentSlot.HEAD, 0.0f);
            setDropChance(EquipmentSlot.CHEST, 0.0f);
            setDropChance(EquipmentSlot.LEGS, 0.0f);
            setDropChance(EquipmentSlot.FEET, 0.0f);

            RiderDriverItem.setUpdateForm(getItemBySlot(EquipmentSlot.FEET));

            switch (getRandom().nextInt(9)) {
                case 0:
                    setData(MOB_STATE, "locust");
                    RiderDriverItem.setFormItem(getItemBySlot(EquipmentSlot.FEET), BladeRiderItems.KICK_LOCUST.get(), 1);
                    break;
                case 1:
                    setData(MOB_STATE, "deer");
                    RiderDriverItem.setFormItem(getItemBySlot(EquipmentSlot.FEET), BladeRiderItems.THUNDER_DEER.get(), 1);
                    break;
                case 2:
                    setData(MOB_STATE, "jaguar");
                    RiderDriverItem.setFormItem(getItemBySlot(EquipmentSlot.FEET), BladeRiderItems.MACH_JAGUAR.get(), 1);
                    setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(BladeRiderItems.JAGUAR_CLAWS.get(), 1));
                    break;
                case 3:
                    setData(MOB_STATE, "pecker");
                    RiderDriverItem.setFormItem(getItemBySlot(EquipmentSlot.FEET), BladeRiderItems.RAPID_PECKER.get(), 1);
                    break;
                case 4:
                    setData(MOB_STATE, "tortoise");
                    RiderDriverItem.setFormItem(getItemBySlot(EquipmentSlot.FEET), BladeRiderItems.ROCK_TORTOISE.get(), 1);
                    break;
                case 5:
                    setData(MOB_STATE, "bat");
                    RiderDriverItem.setFormItem(getItemBySlot(EquipmentSlot.FEET), BladeRiderItems.SCOPE_BAT.get(), 1);
                    break;
                case 6:
                    setData(MOB_STATE, "moth");
                    RiderDriverItem.setFormItem(getItemBySlot(EquipmentSlot.FEET), BladeRiderItems.REFLECT_MOTH.get(), 1);
                    break;
                case 7:
                    setData(MOB_STATE, "centipede");
                    RiderDriverItem.setFormItem(getItemBySlot(EquipmentSlot.FEET), BladeRiderItems.SHUFFLE_CENTIPEDE.get(), 1);
                    break;
                case 8:
                    setData(MOB_STATE, "dragonfly");
                    RiderDriverItem.setFormItem(getItemBySlot(EquipmentSlot.FEET), BladeRiderItems.FLOAT_DRAGONFLY.get(), 1);
                    setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(BladeRiderItems.DRAGONFLY_SOMERSAULT.get(), 1));
                    break;
            }
        }
    }

    public static AttributeSupplier.Builder setAttributes() {
        return Monster.createMonsterAttributes()
                .add(net.minecraft.world.entity.ai.attributes.Attributes.FOLLOW_RANGE, 35.0D)
                .add(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED, 0.23F)
                .add(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE, 4.0D)
                .add(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR, -17.0D)
                .add(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH, 45.0D);
    }

    public void sealUndead(ServerPlayer sealer) {
        SealingEntity undeadEffect = new SealingEntity(SEALING_EFFECT.get(), level());
        undeadEffect.moveTo(getX(), getY() + 1, getZ(), 0, 0);
        level().addFreshEntity(undeadEffect);
        undeadEffect.setData(MOB_STATE, "normal_undead");
        undeadEffect.setData(UUID_STORE, sealer.getStringUUID());
        undeadEffect.moveTo(getX(), getY() + 1, getZ(), 0, 0);
        setLastHurtByPlayer(null);
        setLastHurtByMob(null);
    }

    @Override
    public void onDamageTaken(DamageContainer damageContainer) {
        if (getHealth() < 15 && !getData(MOB_STATE).contains("sealable") && getLastAttacker() instanceof Player player &&
                player.getInventory().countItem(BladeRiderItems.BLANK_ROUZECARD.get()) > 0) {
            setData(MOB_STATE, getData(MOB_STATE) + "_sealable");
            setHealth(3);
            getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(3);

            addEffect(new MobEffectInstance(MobEffects.WITHER, 200, 255, true, false));
            addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 80, 10, true, false));
            addEffect(new MobEffectInstance(MobEffects.REGENERATION, 80, 10, true, false));
            addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, 255, true, false));
            addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 255, true, false));
            addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 200, 255, true, false));
            addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 255, true, false));
            addEffect(new MobEffectInstance(MobEffects.GLOWING, 200, 255, true, false));

            removeFreeWill();
            setNoAi(true);

            RiderDriverItem.setUpdateForm(getItemBySlot(EquipmentSlot.FEET));
            switch (getData(MOB_STATE)) {
                case "locust_sealable":
                    RiderDriverItem.setFormItem(getItemBySlot(EquipmentSlot.FEET), BladeRiderItems.SEALABLE_KICK_LOCUST.get(), 1);
                    break;
                case "deer_sealable":
                    RiderDriverItem.setFormItem(getItemBySlot(EquipmentSlot.FEET), BladeRiderItems.SEALABLE_THUNDER_DEER.get(), 1);
                    break;
                case "jaguar_sealable":
                    RiderDriverItem.setFormItem(getItemBySlot(EquipmentSlot.FEET), BladeRiderItems.SEALABLE_MACH_JAGUAR.get(), 1);
                    break;
                case "pecker_sealable":
                    RiderDriverItem.setFormItem(getItemBySlot(EquipmentSlot.FEET), BladeRiderItems.SEALABLE_RAPID_PECKER.get(), 1);
                    break;
                case "tortoise_sealable":
                    RiderDriverItem.setFormItem(getItemBySlot(EquipmentSlot.FEET), BladeRiderItems.SEALABLE_ROCK_TORTOISE.get(), 1);
                    break;
                case "bat_sealable":
                    RiderDriverItem.setFormItem(getItemBySlot(EquipmentSlot.FEET), BladeRiderItems.SEALABLE_SCOPE_BAT.get(), 1);
                    break;
                case "moth_sealable":
                    RiderDriverItem.setFormItem(getItemBySlot(EquipmentSlot.FEET), BladeRiderItems.SEALABLE_REFLECT_MOTH.get(), 1);
                    break;
                case "centipede_sealable":
                    RiderDriverItem.setFormItem(getItemBySlot(EquipmentSlot.FEET), BladeRiderItems.SEALABLE_SHUFFLE_CENTIPEDE.get(), 1);
                    break;
                case "dragonfly_sealable":
                    RiderDriverItem.setFormItem(getItemBySlot(EquipmentSlot.FEET), BladeRiderItems.SEALABLE_FLOAT_DRAGONFLY.get(), 1);
                    break;
            }
        }
        super.onDamageTaken(damageContainer);
    }
}