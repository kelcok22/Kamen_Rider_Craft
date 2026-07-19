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

public class BitterGavvEntity extends BaseHenchmenEntity {

		public BitterGavvEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="bitter_gavv";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(GavvRiderItems.GAVV_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(GavvRiderItems.GAVV_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(GavvRiderItems.GAVV_LEGGINGS.get()));
		this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(GavvRiderItems.BITTER_GAVVGABLADE.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(GavvRiderItems.HENSHIN_BELT_BITTER_GAVV.get()));
            RiderDriverItem.setUpdateForm(this.getItemBySlot(EquipmentSlot.FEET));
    }
    @Override
    public void actuallyHurt(DamageSource source, float amount) {
        super.actuallyHurt(source, amount);
        if(!this.level().isClientSide() && source.getEntity() instanceof Player playerIn) {
            if (this.getHealth()<75 && playerIn.getInventory().countItem(GavvRiderItems.NYELV_MIMIC_KEY.get().asItem())!=0 && RiderDriverItem.getFormItem(this.getItemBySlot(EquipmentSlot.FEET),1)!= GavvRiderItems.MARBLEBREACOOKIE_GOCHIZO.get()) {
                if (this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUNCEMENTS)) playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.marble_breacookie"));
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(GavvRiderItems.BAKEMAGNUM.get()));
                RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), GavvRiderItems.MARBLEBREACOOKIE_GOCHIZO.get(), 1);
            }
        }
    }

	public static AttributeSupplier.Builder setAttributes() {
		return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 128.0D)
        		.add(Attributes.MOVEMENT_SPEED, 0.30F)
        		.add(Attributes.ATTACK_DAMAGE, 5.0D)
        		.add(Attributes.MAX_HEALTH, 100.0D);
     }
    

}