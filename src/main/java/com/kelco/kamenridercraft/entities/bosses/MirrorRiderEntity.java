package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Geats_Rider_Items;
import com.kelco.kamenridercraft.item.Ghost_Rider_Items;
import com.kelco.kamenridercraft.item.Ryuki_Rider_Items;
import com.kelco.kamenridercraft.item.Zero_One_Rider_Items;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.neoforged.neoforge.common.Tags;

import javax.annotation.Nullable;
import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.List;

public class MirrorRiderEntity extends BaseHenchmenEntity {


    public String RIDER_NAME = "ryuki";

    public MirrorRiderEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="rider_summon";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Ryuki_Rider_Items.RYUKIHELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Ryuki_Rider_Items.RYUKICHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Ryuki_Rider_Items.RYUKILEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Ryuki_Rider_Items.RYUKIDRIVER.get()));

    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_34297_, DifficultyInstance p_34298_, MobSpawnType p_34299_, @Nullable SpawnGroupData p_34300_) {
        p_34300_ = super.finalizeSpawn(p_34297_, p_34298_, p_34299_, p_34300_);


        ResourceKey<Level> CITY = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("kamenridercraft:city"));
        if (p_34297_.getLevel().dimension() == CITY){
            int bossChoice = this.random.nextInt(2);
            switch (bossChoice) {
                case 0:
                    this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Ryuki_Rider_Items.ABYSSDRIVER.get()));
                    break;
                case 1:
                    this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Ryuki_Rider_Items.FATALEDRIVER.get()));
                    break;
                default:
            }
        }else if (p_34297_.getBiome(this.blockPosition()).is(BiomeTags.IS_SAVANNA)){
            this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Ryuki_Rider_Items.IMPERERDRIVER.get()));
        }
        else if (p_34297_.getBiome(this.blockPosition()).is(BiomeTags.IS_FOREST)){
            this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Ryuki_Rider_Items.ZOLDADRIVER.get()));
        }
        else if (p_34297_.getBiome(this.blockPosition()).is(Tags.Biomes.IS_SWAMP)){
            this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Ryuki_Rider_Items.OUJADRIVER.get()));
        }
        else if (p_34297_.getBiome(this.blockPosition()).is(Tags.Biomes.IS_OCEAN)||
        p_34297_.getBiome(this.blockPosition()).is(Tags.Biomes.IS_DEEP_OCEAN)){
            this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Ryuki_Rider_Items.RAIADRIVER.get()));
        }
        else if (p_34297_.getBiome(this.blockPosition()).is(Tags.Biomes.IS_BEACH)||
                p_34297_.getBiome(this.blockPosition()).is(BiomeTags.IS_MOUNTAIN)){
            this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Ryuki_Rider_Items.SCISSORSDRIVER.get()));
        }
        else if (p_34297_.getBiome(this.blockPosition()).is(Tags.Biomes.IS_TAIGA)){
            this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Ryuki_Rider_Items.TIGERDRIVER.get()));
        }
        else if (p_34297_.getBiome(this.blockPosition()).is(BiomeTags.IS_BADLANDS)||
                p_34297_.getBiome(this.blockPosition()).is(Tags.Biomes.IS_DESERT)){
            this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Ryuki_Rider_Items.GAIDRIVER.get()));
        }
        else if (p_34297_.getBiome(this.blockPosition()).is(BiomeTags.IS_NETHER)){
            int bossChoice = this.random.nextInt(3);
            switch (bossChoice) {
                case 0:
                    this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Ryuki_Rider_Items.FEMMEDRIVER.get()));
                    break;
                case 1:
                    this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Ryuki_Rider_Items.VERDEDRIVER.get()));
                    break;
                case 2:
                    this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Ryuki_Rider_Items.RYUGADRIVER.get()));
                    break;
                default:
            }
        }
        else if (p_34297_.getBiome(this.blockPosition()).is(BiomeTags.IS_END)){
                int bossChoice = this.random.nextInt(2);
                switch (bossChoice) {
                    case 0:
                        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Ryuki_Rider_Items.ALTERNATIVEDRIVER.get()));
                        break;
                    case 1:
                        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Ryuki_Rider_Items.ALTERNATIVEZERODRIVER.get()));
                        break;
                    default:
                }

        }else  if (!p_34297_.getLevel().isDay())this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Ryuki_Rider_Items.KNIGHTDRIVER.get()));
if(this.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem belt){
    RIDER_NAME = belt.Rider;
}

        return p_34300_;
    }

    public void remove(RemovalReason p_149847_) {

        if ( this.isDeadOrDying()) {
                if (level() instanceof ServerLevel Slevel) {
                    ResourceKey<LootTable> loot = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "entities/mirror_riders/"+RIDER_NAME));
                    LootTable loottable = level().getServer().reloadableRegistries().getLootTable(loot);
                    LootParams.Builder lootparams$builder = new LootParams.Builder(Slevel)
                            .withParameter(LootContextParams.THIS_ENTITY, this)
                            .withParameter(LootContextParams.ORIGIN, this.position());
                    LootParams lootparams = lootparams$builder.create(LootContextParamSets.EQUIPMENT);
                    loottable.getRandomItems(lootparams, 0L, this::spawnAtLocation);
                }
        }

        super.remove(p_149847_);
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