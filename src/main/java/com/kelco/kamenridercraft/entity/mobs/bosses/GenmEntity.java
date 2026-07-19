package com.kelco.kamenridercraft.entity.mobs.bosses;

import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.ExAidRiderItems;
import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.server.ServerLifecycleHooks;

public class GenmEntity extends BaseHenchmenEntity {


    public GenmEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME = "genm";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ExAidRiderItems.EX_AIDHELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(ExAidRiderItems.EX_AIDCHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(ExAidRiderItems.EX_AIDLEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(ExAidRiderItems.GAMER_DRIVER_GENM.get()));

        ItemStack belt = new ItemStack(ExAidRiderItems.GAMER_DRIVER_GENM.get());
        RiderDriverItem.setFormItem(belt, ExAidRiderItems.PROTO_MIGHTY_ACTION_X_GASHAT.get(), 1);

        this.setItemSlot(EquipmentSlot.FEET, belt);
    }

    @Override
    public void actuallyHurt(DamageSource source, float amount) {
        super.actuallyHurt(source, amount);
        if (!this.level().isClientSide() && source.getEntity() instanceof Player player) {
            if (this.getHealth() < 30 && player.getInventory().countItem(ExAidRiderItems.BAKUSOU_BIKE_GASHAT.get().asItem()) != 0 && this.getItemBySlot(EquipmentSlot.FEET).getItem() != ExAidRiderItems.GASHACON_BUGVISOR_GENM.get()) {
                if (this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUNCEMENTS))
                    player.sendSystemMessage(Component.translatable("henshin.kamenridercraft.genm_dangerous_zombie"));
                this.setHealth(45);
                this.setItemSlot(EquipmentSlot.FEET, new ItemStack(ExAidRiderItems.GASHACON_BUGVISOR_GENM.get()));

                ResourceKey<Level> CITY = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("kamenridercraft:city"));
                if (this.level().dimension() == Level.OVERWORLD || this.level().dimension() == CITY) {
                    if (player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem driverItem && driverItem.isTransformed(player) && driverItem.riderName.toLowerCase().contains("lazer"))
                    ServerLifecycleHooks.getCurrentServer().getLevel(this.level().dimension()).setWeatherParameters(10, 5000, true, false);
                }
            }
        }
    }

    public void remove(RemovalReason p_149847_) {
        if (this.isDeadOrDying()) {
            if (!this.level().isClientSide() && this.getItemBySlot(EquipmentSlot.FEET).getItem() == ExAidRiderItems.GASHACON_BUGVISOR_GENM.get()) {
                ItemEntity gashat = new ItemEntity(level(), getX(), getY(), getZ(), new ItemStack(ExAidRiderItems.DANGEROUS_ZOBIE_GASHAT.get(), 1), 0, 0, 0);
                gashat.setPickUpDelay(0);
                level().addFreshEntity(gashat);
            }
        }
        super.remove(p_149847_);
    }


    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 135.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.23F)
                .add(Attributes.ATTACK_DAMAGE, 6.0D)
                .add(Attributes.ARMOR, 0.0D)
                .add(Attributes.MAX_HEALTH, 45.0D);
    }


}