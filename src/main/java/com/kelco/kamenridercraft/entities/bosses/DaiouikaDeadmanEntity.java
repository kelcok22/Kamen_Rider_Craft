package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.Revice_Rider_Items;

import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class DaiouikaDeadmanEntity extends BaseHenchmenEntity {




    public DaiouikaDeadmanEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="daiouika_deadman";
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Revice_Rider_Items.PARANEGRO.get()));
    }
    public void remove(RemovalReason reason) {
        if (reason == RemovalReason.KILLED) {
            BaseHenchmenEntity boss = MobsCore.ANOMALOCARIS_DEADMAN.get().create(this.level());
            if (this.getLastAttacker()instanceof Player playerIn){
                if (playerIn.getInventory().countItem(Revice_Rider_Items.ROLLING_VISTAMP.asItem())!=0) {

                    boss.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                    this.level().addFreshEntity(boss);

                    if (this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUCEMENTS)) playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.anomalocaris_deadman"));
                }
            }

        }
        super.remove(reason);
    }


    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 135.0D)
        		.add(Attributes.MOVEMENT_SPEED,(double)0.4F)
        		.add(Attributes.ATTACK_DAMAGE, 12.0D)
        		.add(Attributes.ARMOR, 4.0D)
        		.add(Attributes.MAX_HEALTH, 120.0D);
     }


}