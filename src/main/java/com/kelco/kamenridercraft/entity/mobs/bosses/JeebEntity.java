package com.kelco.kamenridercraft.entity.mobs.bosses;


import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.reiwa.GavvRiderItems;
import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class JeebEntity extends BaseHenchmenEntity {



    public JeebEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="jeeb_stomach";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(GavvRiderItems.GAVV_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(GavvRiderItems.GAVV_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(GavvRiderItems.GAVV_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(GavvRiderItems.JEEB_MIMICDEVISER.get()));
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(GavvRiderItems.JEEB_SWORD.get()));
        this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(GavvRiderItems.JEEB_DAGGER.get()));
    }

    @Override
    public void actuallyHurt(DamageSource source, float amount) {
        super.actuallyHurt(source, amount);
        if(!this.level().isClientSide() && source.getEntity() instanceof Player playerIn  && this.getHealth()<30
                && this.getItemBySlot(EquipmentSlot.FEET).getItem()!= GavvRiderItems.HENSHIN_BELT_BITTER_GAVV.get()
        && playerIn.getInventory().countItem(GavvRiderItems.SHIITA_MIMIC_KEY.asItem())!=0) {
            if (this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUCEMENTS)) playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.bitter_jeeb"));
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.5);
            this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(10.0D);
            this.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(128.0D);

            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(GavvRiderItems.BITTER_GAVVGABLADE.get()));
            this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(GavvRiderItems.BAKEMAGNUM.get()));
            this.setItemSlot(EquipmentSlot.FEET, new ItemStack(GavvRiderItems.HENSHIN_BELT_BITTER_GAVV.get()));
            RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), GavvRiderItems.BAKIBAKISTICK_GOCHIZO.get(), 1);
        }
    }

    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 135.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3F)
                .add(Attributes.ATTACK_DAMAGE, 10.0D)
                .add(Attributes.ARMOR, 3.0D)
                .add(Attributes.MAX_HEALTH, 60.0D);
    }


}