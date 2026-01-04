package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.Ryuki_Rider_Items;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.neoforged.neoforge.common.Tags;

import javax.annotation.Nullable;

public class MirrorRiderEntity extends BaseHenchmenEntity {



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

        if (p_34297_.getBiome(this.blockPosition()).is(BiomeTags.IS_SAVANNA)){
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
                    this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Ryuki_Rider_Items.ABYSSDRIVER.get()));
                    break;
                case 1:
                    this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Ryuki_Rider_Items.FATALEDRIVER.get()));
                    break;
                default:
            }

        }else  if (!p_34297_.getLevel().isDay())this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Ryuki_Rider_Items.KNIGHTDRIVER.get()));

        return p_34300_;
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