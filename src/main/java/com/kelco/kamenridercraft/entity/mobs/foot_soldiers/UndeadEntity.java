package com.kelco.kamenridercraft.entity.mobs.foot_soldiers;

import com.kelco.kamenridercraft.entity.effect.SealingEntity;
import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.bosses.AlbinoJokerUndeadEntity;
import com.kelco.kamenridercraft.entity.mobs.bosses.JokerUndeadEntity;
import com.kelco.kamenridercraft.entity.mobs.bosses.KingUndeadEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_1.BladeRiderItems;
import com.kelco.kamenridercraft.level.ModGameRules;
import com.kelco.kamenridercraft.world.attribute.KRCAttributes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.damagesource.DamageContainer;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

import static com.kelco.kamenridercraft.attachments.AttachmentTypes.MOB_STATE;
import static com.kelco.kamenridercraft.attachments.AttachmentTypes.UUID_STORE;
import static com.kelco.kamenridercraft.entity.mobs.MobsCore.SEALING_EFFECT;
import static com.kelco.kamenridercraft.util.MiscUtil.canSpawnBoss;
import static net.minecraft.world.entity.EntityType.ZOMBIE;
import static net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH;

public class UndeadEntity extends BaseHenchmenEntity {
    HolderLookup.RegistryLookup<Enchantment> enchantmentRegistryLookup = level().registryAccess().lookupOrThrow(Registries.ENCHANTMENT);

    public UndeadEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME = "undead_human";
        if (getData(MOB_STATE).isEmpty() && !level().isClientSide() && getClass() == UndeadEntity.class) {
            getAttribute(KRCAttributes.REINFORCEMENT_CHANCE).setBaseValue(12D);
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

            switch (getRandom().nextInt(12)) {
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
                case 9:
                    setData(MOB_STATE, "mole");
                    RiderDriverItem.setFormItem(getItemBySlot(EquipmentSlot.FEET), BladeRiderItems.SCREW_MOLE.get(), 1);
                    setItemInHand(InteractionHand.OFF_HAND, new ItemStack(BladeRiderItems.MOLE_SHIELD.get(), 1));
                    break;
                case 10:
                    setData(MOB_STATE, "jellyfish");
                    RiderDriverItem.setFormItem(getItemBySlot(EquipmentSlot.FEET), BladeRiderItems.GEL_JELLYFISH.get(), 1);
                    break;
                case 11:
                    setData(MOB_STATE, "squid");
                    RiderDriverItem.setFormItem(getItemBySlot(EquipmentSlot.FEET), BladeRiderItems.SMOG_SQUID.get(), 1);
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
                .add(MAX_HEALTH, 45.0D);
    }

    public void sealUndead(ServerPlayer sealer) {
        SealingEntity undeadEffect = new SealingEntity(SEALING_EFFECT.get(), level());
        undeadEffect.moveTo(getX(), getY() + 1, getZ(), 0, 0);
        level().addFreshEntity(undeadEffect);
        if (getData(MOB_STATE).equals("spider_sealable") &&
                sealer.getInventory().countItem(BladeRiderItems.EVOLUTION_TARANTULA.get()) != 0) {
            setData(MOB_STATE, "proper_seal_spider");
        }
        switch (getData(MOB_STATE)) {
            case "beetle_sealable" -> undeadEffect.setData(MOB_STATE, "beetle");
            case "stag_sealable" -> undeadEffect.setData(MOB_STATE, "stag");
            case "mantis_sealable" -> undeadEffect.setData(MOB_STATE, "mantis");
            case "spider_sealable" -> undeadEffect.setData(MOB_STATE, "spider");
            case "proper_seal_spider" -> undeadEffect.setData(MOB_STATE, "proper_seal_spider");
            case "eagle_sealable" -> undeadEffect.setData(MOB_STATE, "eagle");
            case "peacock_sealable" -> undeadEffect.setData(MOB_STATE, "peacock");
            case "wolf_sealable" -> undeadEffect.setData(MOB_STATE, "wolf");
            case "elephant_sealable" -> undeadEffect.setData(MOB_STATE, "elephant");
            case "capricorn_sealable" -> undeadEffect.setData(MOB_STATE, "capricorn");
            case "serpent_sealable" -> undeadEffect.setData(MOB_STATE, "serpent");
            case "orchid_sealable" -> undeadEffect.setData(MOB_STATE, "orchid");
            case "tiger_sealable" -> undeadEffect.setData(MOB_STATE, "tiger");
            case "caucasus_sealable" -> undeadEffect.setData(MOB_STATE, "caucasus");
            case "giraffa_sealable" -> undeadEffect.setData(MOB_STATE, "giraffa");
            case "paradoxa_sealable" -> undeadEffect.setData(MOB_STATE, "paradoxa");
            case "tarantula_sealable" -> undeadEffect.setData(MOB_STATE, "tarantula");
            case "joker_sealable" -> undeadEffect.setData(MOB_STATE, "joker");
            case "albino_joker_sealable" -> undeadEffect.setData(MOB_STATE, "albino_joker");
            case "kerberos_sealable" -> undeadEffect.setData(MOB_STATE, "kerberos");
            default -> undeadEffect.setData(MOB_STATE, "normal_undead");
        }
        undeadEffect.setData(UUID_STORE, sealer.getStringUUID());
        undeadEffect.moveTo(getX(), getY() + 1, getZ(), 0, 0);

        summonUpperClassUndead();
        setLastHurtByPlayer(null);
        setLastHurtByMob(null);
    }

    @Override
    public void die(@NotNull DamageSource damageSource) {
        if (isSealable()) {
            setSealable();
        } else {
            super.die(damageSource);
        }
    }

    @Override
    public void onDamageTaken(DamageContainer damageContainer) {
        setSealable();
        super.onDamageTaken(damageContainer);
    }

    public boolean isSealable() {
        return getHealth() < 15 && !getData(MOB_STATE).contains("sealable") && getLastAttacker() instanceof Player player &&
                player.getInventory().countItem(BladeRiderItems.BLANK_ROUZECARD.get()) > 0;
    }

    public void giveSealableStats() {
        setData(MOB_STATE, getData(MOB_STATE) + "_sealable");
        setHealth(3);
        getAttribute(MAX_HEALTH).setBaseValue(3);

        int duration = 200;
        if (this instanceof JokerUndeadEntity || this instanceof AlbinoJokerUndeadEntity || this instanceof KingUndeadEntity) {
            duration = 600;
        }

        addEffect(new MobEffectInstance(MobEffects.WITHER, duration, 255, true, false));
        addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, duration - 120, 10, true, false));
        addEffect(new MobEffectInstance(MobEffects.REGENERATION, duration - 120, 10, true, false));
        addEffect(new MobEffectInstance(MobEffects.WEAKNESS, duration, 255, true, false));
        addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, duration, 255, true, false));
        addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, duration, 255, true, false));
        addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, duration, 255, true, false));
        addEffect(new MobEffectInstance(MobEffects.GLOWING, duration, duration, true, false));

        removeFreeWill();
        setNoAi(true);

        RiderDriverItem.setUpdateForm(getItemBySlot(EquipmentSlot.FEET));
    }

    public void setSealable() {
        if (isSealable()) {
            giveSealableStats();
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
                case "dragonfly_sealable":
                    RiderDriverItem.setFormItem(getItemBySlot(EquipmentSlot.FEET), BladeRiderItems.SEALABLE_FLOAT_DRAGONFLY.get(), 1);
                    break;
                case "moth_sealable":
                    RiderDriverItem.setFormItem(getItemBySlot(EquipmentSlot.FEET), BladeRiderItems.SEALABLE_REFLECT_MOTH.get(), 1);
                    break;
                case "centipede_sealable":
                    RiderDriverItem.setFormItem(getItemBySlot(EquipmentSlot.FEET), BladeRiderItems.SEALABLE_SHUFFLE_CENTIPEDE.get(), 1);
                    break;
                case "mole_sealable":
                    RiderDriverItem.setFormItem(getItemBySlot(EquipmentSlot.FEET), BladeRiderItems.SEALABLE_SCREW_MOLE.get(), 1);
                    break;
//                case "kerberos_sealable":
//                    RiderDriverItem.setFormItem(getItemBySlot(EquipmentSlot.FEET), BladeRiderItems.SEALABLE_CHANGE_KERBEROS.get(), 1);
//                    break;
            }
        }
    }

    public void summonUpperClassUndead() {
        if (getClass() == UndeadEntity.class) {
            double chance = random.nextDouble();
            Random rand = new Random();
            int gamerule = level().getGameRules().getInt(ModGameRules.RULE_BOSS_SPAWN_PERCENTAGE);

            Mob boss = MobsCore.JACK_UNDEAD.get().create(level());

            if ((chance * 100.0 <= gamerule && (lastHurtByPlayer != null && canSpawnBoss(lastHurtByPlayer))
                    || !(this.getLastAttacker() instanceof Player) && chance * 200.0 <= gamerule)) {

                if (lastHurtByPlayer != null && (getLastAttacker().getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem &&
                        (RiderDriverItem.getFormItem(getLastAttacker().getItemBySlot(EquipmentSlot.FEET), 1).asItem()
                                .toString().toLowerCase().contains("jack") ||
                                RiderDriverItem.getFormItem(getLastAttacker().getItemBySlot(EquipmentSlot.FEET), 1).asItem()
                                        .toString().toLowerCase().contains("wild")) ||
                        lastHurtByPlayer.getInventory().countItem(BladeRiderItems.ROUZE_ABSORBER.get()) != 0)) {
                    boss = MobsCore.QUEEN_UNDEAD.get().create(level());
                }

                if (boss != null) {
                    int tempRandX = (getBlockX()
                            + (rand.nextInt(8, 25))
                            * (rand.nextInt(3) > 1 ? 1 : -1));

                    int tempRandZ = (getBlockZ()
                            + (rand.nextInt(8, 25))
                            * (rand.nextInt(3) > 1 ? 1 : -1));

                    boss.setPos(tempRandX, getY(), tempRandZ);

                    for (int i = 0; i < 400; ++i) {
                        int randX = (getBlockX()
                                + (rand.nextInt(8, 25))
                                * (rand.nextInt(3) > 1 ? 1 : -1));

                        int randY = (getBlockY()
                                + rand.nextInt(-10, 10));

                        int randZ = (getBlockZ()
                                + (rand.nextInt(8, 25))
                                * (rand.nextInt(3) > 1 ? 1 : -1));

                        BlockPos potentialPosition = new BlockPos(randX, randY, randZ);
                        if (SpawnPlacements.isSpawnPositionOk(ZOMBIE, level(), potentialPosition) &&
                                level().noCollision(EntityType.ZOMBIE.getSpawnAABB(randX, randY, randZ))) {
                            boss.setPos(randX, randY, randZ);
                            break;
                        }
                    }
                    level().addFreshEntity(boss);
                }
            }
        }
    }


    @Override
    public void remove(RemovalReason reason) {
        if (isDeadOrDying()) {
            summonUpperClassUndead();
        }
        super.remove(reason);
    }
}