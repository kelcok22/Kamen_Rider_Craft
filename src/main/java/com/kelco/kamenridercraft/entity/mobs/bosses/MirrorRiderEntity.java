package com.kelco.kamenridercraft.entity.mobs.bosses;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.entity.mobs.summons.BaseSummonEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_1.RyukiRiderItems;
import com.kelco.kamenridercraft.item.heisei_phase_2.ZiORiderItems;
import com.kelco.kamenridercraft.item.misc_items.MusicDiscItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MoveThroughVillageGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.neoforged.neoforge.common.Tags;

import javax.annotation.Nullable;

public class MirrorRiderEntity extends BaseHenchmenEntity {
    private static final EntityDataAccessor<String> RIDER_NAME =
            SynchedEntityData.defineId(MirrorRiderEntity.class, EntityDataSerializers.STRING);
    private static final EntityDataAccessor<Boolean> IS_SURVIVE =
            SynchedEntityData.defineId(MirrorRiderEntity.class, EntityDataSerializers.BOOLEAN);

    public MirrorRiderEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME = "rider_summon";
        setItemSlot(EquipmentSlot.HEAD, new ItemStack(RyukiRiderItems.RYUKIHELMET.get()));
        setItemSlot(EquipmentSlot.CHEST, new ItemStack(RyukiRiderItems.RYUKICHESTPLATE.get()));
        setItemSlot(EquipmentSlot.LEGS, new ItemStack(RyukiRiderItems.RYUKILEGGINGS.get()));
    }

    protected void addBehaviourGoals() {
        goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        goalSelector.addGoal(6, new MoveThroughVillageGoal(this, 1.0D, true, 4, this::canBreakDoors));
        goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        targetSelector.addGoal(1, (new HurtByTargetGoal(this, getClass())).setAlertOthers(getClass()));
        targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, MirrorRiderEntity.class, false));
        targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, OdinEntity.class, false));
        targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, BaseSummonEntity.class, true));
    }

    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(RIDER_NAME, "ryuki");
        builder.define(IS_SURVIVE, false);
    }

    private String getTypeVariant() {
        return entityData.get(RIDER_NAME);
    }

    private void setTypeVariant(String Name) {
        entityData.set(RIDER_NAME, Name);
    }

    private Boolean getIsSurvive() {
        return entityData.get(IS_SURVIVE);
    }

    private void setIsSurvive() {
        entityData.set(IS_SURVIVE, true);
    }


    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putString("rider_name", getTypeVariant());
        compound.putBoolean("is_survive", getIsSurvive());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        entityData.set(RIDER_NAME, compound.getString("rider_name"));
        entityData.set(IS_SURVIVE, compound.getBoolean("is_survive"));
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor serverLevelAccessor, DifficultyInstance difficultyInstance, MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawnGroupData) {
        ResourceKey<Level> SANDS_OF_TIME = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("kamenridercraft:sands_of_time"));
        ResourceKey<Level> CITY = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("kamenridercraft:city"));
        
        if (serverLevelAccessor.getLevel().dimension() == SANDS_OF_TIME) {
            setItemSlot(EquipmentSlot.FEET, new ItemStack(RyukiRiderItems.BLADEDRIVER.get()));
            setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(RyukiRiderItems.GULD_VISOR.get()));
        } else if (serverLevelAccessor.getLevel().dimension() == CITY) {
            int bossChoice = random.nextInt(2);
            switch (bossChoice) {
                case 0:
                    setItemSlot(EquipmentSlot.FEET, new ItemStack(RyukiRiderItems.ABYSSDRIVER.get()));
                    setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(RyukiRiderItems.ABYSS_VISOR.get()));
                    break;
                case 1:
                    setItemSlot(EquipmentSlot.HEAD, new ItemStack(ZiORiderItems.ZI_O_HELMET.get()));
                    setItemSlot(EquipmentSlot.CHEST, new ItemStack(ZiORiderItems.ZI_O_CHESTPLATE.get()));
                    setItemSlot(EquipmentSlot.LEGS, new ItemStack(ZiORiderItems.ZI_O_LEGGINGS.get()));
                    setItemSlot(EquipmentSlot.FEET, new ItemStack(ZiORiderItems.ZIKU_DRIVER_ZI_O_MIRROR.get()));
                    setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(ZiORiderItems.ZIKAN_GIRADE.get()));
                    break;
            }
        } else if (serverLevelAccessor.getBiome(blockPosition()).is(BiomeTags.IS_SAVANNA)) {
            setItemSlot(EquipmentSlot.FEET, new ItemStack(RyukiRiderItems.IMPERERDRIVER.get()));
        } else if (serverLevelAccessor.getBiome(blockPosition()).is(BiomeTags.IS_FOREST)) {
            setItemSlot(EquipmentSlot.FEET, new ItemStack(RyukiRiderItems.ZOLDADRIVER.get()));
            setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(RyukiRiderItems.MAGNA_VISOR.get()));
        } else if (serverLevelAccessor.getBiome(blockPosition()).is(Tags.Biomes.IS_SWAMP)) {
            setItemSlot(EquipmentSlot.FEET, new ItemStack(RyukiRiderItems.OUJADRIVER.get()));
            setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(RyukiRiderItems.VENO_VISOR.get()));
        } else if (serverLevelAccessor.getBiome(blockPosition()).is(Tags.Biomes.IS_OCEAN) ||
                serverLevelAccessor.getBiome(blockPosition()).is(Tags.Biomes.IS_DEEP_OCEAN)) {
            setItemSlot(EquipmentSlot.FEET, new ItemStack(RyukiRiderItems.RAIADRIVER.get()));
            setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(RyukiRiderItems.EVIL_VISOR.get()));
        } else if (serverLevelAccessor.getBiome(blockPosition()).is(Tags.Biomes.IS_BEACH) ||
                serverLevelAccessor.getBiome(blockPosition()).is(BiomeTags.IS_MOUNTAIN)) {
            setItemSlot(EquipmentSlot.FEET, new ItemStack(RyukiRiderItems.SCISSORSDRIVER.get()));
            setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(RyukiRiderItems.SCISSORS_VISOR.get()));
        } else if (serverLevelAccessor.getBiome(blockPosition()).is(Tags.Biomes.IS_TAIGA)) {
            setItemSlot(EquipmentSlot.FEET, new ItemStack(RyukiRiderItems.TIGERDRIVER.get()));
            setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(RyukiRiderItems.DEST_VISOR.get()));
        } else if (serverLevelAccessor.getBiome(blockPosition()).is(BiomeTags.IS_BADLANDS) ||
                serverLevelAccessor.getBiome(blockPosition()).is(Tags.Biomes.IS_DESERT)) {
            setItemSlot(EquipmentSlot.FEET, new ItemStack(RyukiRiderItems.GAIDRIVER.get()));
        } else if (serverLevelAccessor.getBiome(blockPosition()).is(BiomeTags.IS_NETHER)) {
            int bossChoice = random.nextInt(3);
            switch (bossChoice) {
                case 0:
                    setItemSlot(EquipmentSlot.FEET, new ItemStack(RyukiRiderItems.FEMMEDRIVER.get()));
                    setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(RyukiRiderItems.BLANC_VISOR.get()));
                    break;
                case 1:
                    setItemSlot(EquipmentSlot.FEET, new ItemStack(RyukiRiderItems.VERDEDRIVER.get()));
                    break;
                case 2:
                    setItemSlot(EquipmentSlot.FEET, new ItemStack(RyukiRiderItems.RYUGADRIVER.get()));
                    setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(RyukiRiderItems.BLACK_DRAG_VISOR.get()));
                    break;
            }
        } else if (serverLevelAccessor.getBiome(blockPosition()).is(BiomeTags.IS_END)) {
            int bossChoice = random.nextInt(2);
            switch (bossChoice) {
                case 0:
                    setItemSlot(EquipmentSlot.FEET, new ItemStack(RyukiRiderItems.ALTERNATIVEDRIVER.get()));
                    setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(RyukiRiderItems.SLASH_VISOR.get()));
                    break;
                case 1:
                    setItemSlot(EquipmentSlot.FEET, new ItemStack(RyukiRiderItems.ALTERNATIVEZERODRIVER.get()));
                    setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(RyukiRiderItems.SLASH_VISOR.get()));
                    break;
            }

        } else if (!serverLevelAccessor.getLevel().isDay()) {
            setItemSlot(EquipmentSlot.FEET, new ItemStack(RyukiRiderItems.KNIGHTDRIVER.get()));
            setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(RyukiRiderItems.DARK_VISOR.get()));
        } else {
            setItemSlot(EquipmentSlot.FEET, new ItemStack(RyukiRiderItems.RYUKIDRIVER.get()));
            setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(RyukiRiderItems.DRAG_VISOR.get()));
        }
        if (getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem belt) {
            setTypeVariant(belt.riderName);
        }

        return super.finalizeSpawn(serverLevelAccessor, difficultyInstance, mobSpawnType, spawnGroupData);
    }

    public void remove(RemovalReason removalReason) {
        if (isDeadOrDying()) {
            if (level() instanceof ServerLevel serverLevel) {
                if (getIsSurvive()) {
                    ResourceKey<LootTable> loot = ResourceKey.create(Registries.LOOT_TABLE,
                            ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,
                                    "entities/mirror_riders/" + getTypeVariant() + "_survive"));
                    LootTable loottable = level().getServer().reloadableRegistries().getLootTable(loot);
                    LootParams.Builder lootparams$builder = new LootParams.Builder(serverLevel)
                            .withParameter(LootContextParams.THIS_ENTITY, this)
                            .withParameter(LootContextParams.ORIGIN, position());
                    LootParams lootparams = lootparams$builder.create(LootContextParamSets.EQUIPMENT);
                    loottable.getRandomItems(lootparams, 0L, this::spawnAtLocation);
                }

                ResourceKey<LootTable> loot = ResourceKey.create(Registries.LOOT_TABLE,
                        ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "entities/mirror_riders/" + getTypeVariant()));
                LootTable loottable = level().getServer().reloadableRegistries().getLootTable(loot);
                LootParams.Builder lootparams$builder = new LootParams.Builder(serverLevel)
                        .withParameter(LootContextParams.THIS_ENTITY, this)
                        .withParameter(LootContextParams.ORIGIN, position());
                LootParams lootparams = lootparams$builder.create(LootContextParamSets.EQUIPMENT);
                loottable.getRandomItems(lootparams, 0L, this::spawnAtLocation);
            }
            if (!level().isClientSide() && getLastAttacker() instanceof Player
                    && getLastAttacker().getItemBySlot(EquipmentSlot.FEET).toString().contains(entityData.get(RIDER_NAME))) {
                ItemEntity musicDisc = new ItemEntity(level(), getX(), getY(), getZ(),
                        new ItemStack(MusicDiscItems.ALIVE_A_LIFE_MUSIC_DISC.get(), 1), 0, 0, 0);
                musicDisc.setPickUpDelay(0);
                level().addFreshEntity(musicDisc);
            }
        }
        super.remove(removalReason);
    }

    public void actuallyHurt(DamageSource damageSource, float amount) {
        super.actuallyHurt(damageSource, amount);
        int rand2 = random.nextInt(10);

        boolean hasSurvive = false;
        if (damageSource.getEntity() instanceof Player player) {
            Inventory inventory = player.getInventory();
            hasSurvive = inventory.countItem(RyukiRiderItems.SURVIVE_REKKA.get()) != 0 || inventory.countItem(RyukiRiderItems.SURVIVE_MUGEN.get()) != 0 || inventory.countItem(RyukiRiderItems.SURVIVE_SHIPPU.get()) != 0;
        }

        if (hasSurvive) {
            ItemStack belt = getItemBySlot(EquipmentSlot.FEET);
            if (getItemBySlot(EquipmentSlot.FEET).getItem() == RyukiRiderItems.RYUKIDRIVER.get() & RiderDriverItem.getFormItem(belt, 1) != RyukiRiderItems.SURVIVE_REKKA.asItem()) {
                RiderDriverItem.setFormItem(belt, RyukiRiderItems.SURVIVE_REKKA.get(), 1);
                setIsSurvive();
                setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(RyukiRiderItems.DRAG_VISOR_ZWEI.get()));
                getItemBySlot(EquipmentSlot.MAINHAND).consume(1, this);
            }
            if (getItemBySlot(EquipmentSlot.FEET).getItem() == RyukiRiderItems.RAIADRIVER.get() & RiderDriverItem.getFormItem(belt, 1) != RyukiRiderItems.SURVIVE_SHIPPU_RAIA.asItem()) {
                RiderDriverItem.setFormItem(belt, RyukiRiderItems.SURVIVE_SHIPPU_RAIA.get(), 1);
                setIsSurvive();
                setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(RyukiRiderItems.EVIL_VISOR_ZWEI.get()));
            }
            if (getItemBySlot(EquipmentSlot.FEET).getItem() == RyukiRiderItems.KNIGHTDRIVER.get() & RiderDriverItem.getFormItem(belt, 1) != RyukiRiderItems.SURVIVE_SHIPPU.asItem()) {
                RiderDriverItem.setFormItem(belt, RyukiRiderItems.SURVIVE_SHIPPU.get(), 1);
                setIsSurvive();
                setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(RyukiRiderItems.DARK_SHIELD.get()));
                setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(RyukiRiderItems.DARK_BLADE.get()));
            }
            if (getItemBySlot(EquipmentSlot.FEET).getItem() == RyukiRiderItems.RYUGADRIVER.get() & RiderDriverItem.getFormItem(belt, 1) != RyukiRiderItems.SURVIVE_REKKA_RYUGA.asItem()) {
                RiderDriverItem.setFormItem(belt, RyukiRiderItems.SURVIVE_REKKA_RYUGA.get(), 1);
                setIsSurvive();
                setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(RyukiRiderItems.BLACK_DRAG_VISOR_ZWEI.get()));
                getItemBySlot(EquipmentSlot.MAINHAND).consume(1, this);
            }
            if (getItemBySlot(EquipmentSlot.FEET).getItem() == RyukiRiderItems.OUJADRIVER.get() & RiderDriverItem.getFormItem(belt, 1) != RyukiRiderItems.SURVIVE_MUGEN.asItem()) {
                RiderDriverItem.setFormItem(belt, RyukiRiderItems.SURVIVE_MUGEN.get(), 1);
                setIsSurvive();
                setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(RyukiRiderItems.VENO_VISOR_ZWEI.get()));
                getItemBySlot(EquipmentSlot.MAINHAND).consume(1, this);
            }
        }

        if (rand2 == 2) {
            if (getItemBySlot(EquipmentSlot.FEET).getItem() == RyukiRiderItems.RYUKIDRIVER.get()) {
                ItemStack belt = getItemBySlot(EquipmentSlot.FEET);
                if (RiderDriverItem.getFormItem(belt, 1) != RyukiRiderItems.SURVIVE_REKKA.asItem()) {
                    int rand = random.nextInt(3);
                    switch (rand) {
                        case 1:
                            setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(RyukiRiderItems.DRAG_SABER.get()));
                            break;
                        case 2:
                            setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(RyukiRiderItems.DRAG_CLAW.get()));
                            break;
                        default:
                            setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(RyukiRiderItems.DRAG_SHIELD.get()));
                            break;
                    }
                } else if (RiderDriverItem.getFormItem(belt, 1) == RyukiRiderItems.SURVIVE_REKKA.asItem()) {
                    int rand = random.nextInt(2);
                    if (rand == 1) {
                        setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(RyukiRiderItems.DRAG_VISOR_ZWEI.get()));
                    } else {
                        setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(RyukiRiderItems.DRAG_BLADE.get()));
                    }
                }
            } else if (getItemBySlot(EquipmentSlot.FEET).getItem() == RyukiRiderItems.KNIGHTDRIVER.get()) {
                ItemStack belt = getItemBySlot(EquipmentSlot.FEET);
                if (RiderDriverItem.getFormItem(belt, 1) != RyukiRiderItems.SURVIVE_SHIPPU.asItem()) {
                    int rand = random.nextInt(3);
                    switch (rand) {
                        case 1:
                            setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(RyukiRiderItems.WING_LANCER.get()));
                            break;
                        case 2:
                            setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(RyukiRiderItems.DARK_VISOR.get()));
                            break;
                        default:
                            RiderDriverItem.setFormItem(belt, RyukiRiderItems.WING_WALL_VENT.get(), 1);
                            break;
                    }
                }
            } else if (getItemBySlot(EquipmentSlot.FEET).getItem() == RyukiRiderItems.ZOLDADRIVER.get()) {
                ItemStack belt = getItemBySlot(EquipmentSlot.FEET);
                int rand = random.nextInt(5);
                switch (rand) {
                    case 1:
                        setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(RyukiRiderItems.GIGA_LAUNCHER.get()));
                        break;
                    case 2:
                        setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(RyukiRiderItems.GIGA_ARMOR.get()));
                        break;
                    case 3:
                        setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(RyukiRiderItems.GIGA_HORN.get()));
                        break;
                    default:
                        RiderDriverItem.setFormItem(belt, RyukiRiderItems.GIGA_CANNON_VENT.get(), 1);
                        break;
                }
            } else if (getItemBySlot(EquipmentSlot.FEET).getItem() == RyukiRiderItems.SCISSORSDRIVER.get()) {
                int rand = random.nextInt(2);
                if (rand == 1) {
                    setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(RyukiRiderItems.SHELL_DEFENSE.get()));
                } else {
                    setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(RyukiRiderItems.SCISSORS_PINCH.get()));
                }


            } else if (getItemBySlot(EquipmentSlot.FEET).getItem() == RyukiRiderItems.TIGERDRIVER.get()) {
                int rand = random.nextInt(3);
                if (rand == 1) {
                    setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(RyukiRiderItems.DEST_CLAW.get()));
                    setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(RyukiRiderItems.DEST_CLAW1.get()));
                } else {
                    setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(RyukiRiderItems.DEST_VISOR.get()));
                    getItemBySlot(EquipmentSlot.OFFHAND).consume(1, this);
                }
            } else if (getItemBySlot(EquipmentSlot.FEET).getItem() == RyukiRiderItems.OUJADRIVER.get()) {
                ItemStack belt = getItemBySlot(EquipmentSlot.FEET);
                if (RiderDriverItem.getFormItem(belt, 1) != RyukiRiderItems.SURVIVE_MUGEN.asItem()) {
                    int rand = random.nextInt(5);
                    switch (rand) {
                        case 1:
                            setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(RyukiRiderItems.EVIL_WHIP.get()));
                            break;
                        case 2:
                            setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(RyukiRiderItems.METAL_HORN.get()));
                            break;
                        default:
                            setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(RyukiRiderItems.VENO_SABER.get()));
                            break;
                    }
                }
            } else if (getItemBySlot(EquipmentSlot.FEET).getItem() == RyukiRiderItems.IMPERERDRIVER.get()) {
                setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(RyukiRiderItems.GAZELLE_STAB.get()));
            } else if (getItemBySlot(EquipmentSlot.FEET).getItem() == RyukiRiderItems.GAIDRIVER.get()) {
                setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(RyukiRiderItems.METAL_HORN.get()));
            } else if (getItemBySlot(EquipmentSlot.FEET).getItem() == RyukiRiderItems.RAIADRIVER.get()) {
                setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(RyukiRiderItems.EVIL_WHIP.get()));
            } else if (getItemBySlot(EquipmentSlot.FEET).getItem() == RyukiRiderItems.VERDEDRIVER.get()) {
                int rand = random.nextInt(3);
                if (rand == 1) {
                    setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(RyukiRiderItems.BIO_WINDER.get()));
                } else {
                    addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 20, 0, true, true));
                }
            } else if (getItemBySlot(EquipmentSlot.FEET).getItem() == RyukiRiderItems.RYUGADRIVER.get()) {
                ItemStack belt = getItemBySlot(EquipmentSlot.FEET);
                if (RiderDriverItem.getFormItem(belt, 1) != RyukiRiderItems.SURVIVE_REKKA_RYUGA.asItem()) {
                    int rand = random.nextInt(3);
                    switch (rand) {
                        case 1:
                            setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(RyukiRiderItems.DRAG_SABER_RYUGA.get()));
                            break;
                        case 2:
                            setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(RyukiRiderItems.DRAG_CLAW_RYUGA.get()));
                            break;
                        default:
                            setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(RyukiRiderItems.DRAG_SHIELD_RYUGA.get()));
                            break;
                    }
                }
            } else if (getItemBySlot(EquipmentSlot.FEET).getItem() == RyukiRiderItems.FEMMEDRIVER.get()) {
                int rand = random.nextInt(3);
                switch (rand) {
                    case 1:
                        setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(RyukiRiderItems.WING_SHIELD.get()));
                        break;
                    case 2:
                        setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(RyukiRiderItems.WING_SLASHER.get()));
                        break;
                    default:
                        setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(RyukiRiderItems.BLANC_VISOR.get()));
                        break;
                }
            } else if (getItemBySlot(EquipmentSlot.FEET).getItem() == RyukiRiderItems.ABYSSDRIVER.get()) {
                int rand = random.nextInt(3);
                switch (rand) {
                    case 1:
                        setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(RyukiRiderItems.ABYSS_SABER.get()));
                        setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(RyukiRiderItems.ABYSS_SABER.get()));
                        break;
                    case 2:
                        setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(RyukiRiderItems.ABYSS_VISOR.get()));
                        setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(RyukiRiderItems.ABYSS_CLAW.get()));
                        break;
                    default:
                        setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(RyukiRiderItems.ABYSS_VISOR.get()));
                        break;
                }
            } else if (getItemBySlot(EquipmentSlot.FEET).getItem() == RyukiRiderItems.ALTERNATIVEDRIVER.get() ||
                    getItemBySlot(EquipmentSlot.FEET).getItem() == RyukiRiderItems.ALTERNATIVEZERODRIVER.get()) {
                setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(RyukiRiderItems.SLASH_DAGGER.get()));
            }
        }
    }

    public static AttributeSupplier.Builder setAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 135.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3F)
                .add(Attributes.ATTACK_DAMAGE, 10.0D)
                .add(Attributes.ARMOR, 3.0D)
                .add(Attributes.MAX_HEALTH, 40.0D);
    }
}