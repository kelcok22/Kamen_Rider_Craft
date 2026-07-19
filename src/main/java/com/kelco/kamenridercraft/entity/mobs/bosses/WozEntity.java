package com.kelco.kamenridercraft.entity.mobs.bosses;

import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.ZiORiderItems;
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

public class WozEntity extends BaseHenchmenEntity {

		public WozEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="woz";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ZiORiderItems.ZI_O_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(ZiORiderItems.ZI_O_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(ZiORiderItems.ZI_O_LEGGINGS.get()));
		this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ZiORiderItems.ZIKAN_DESPEAR.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(ZiORiderItems.BEYONDRIVER.get()));
    }

    public void actuallyHurt(DamageSource source, float amount) {
        super.actuallyHurt(source, amount);
        if (!this.level().isClientSide() && this.getHealth()<51 && source.getEntity() instanceof Player playerIn
        && getItemBySlot(EquipmentSlot.FEET).getItem()== ZiORiderItems.BEYONDRIVER.get()){
            ItemStack belt = getItemBySlot(EquipmentSlot.FEET);
            if (RiderDriverItem.getFormItem(belt,1)== ZiORiderItems.WOZ_MIRIDEWATCH.get()) {
                int rand = this.random.nextInt(3);
                switch (rand) {
                    case 1:
                        RiderDriverItem.setFormItem(belt, ZiORiderItems.QUIZ_MIRIDEWATCH.get(), 1);
                        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ZiORiderItems.ZIKAN_DESPEAR_TSUE.get()));
                        if (this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUNCEMENTS)) playerIn.sendSystemMessage(Component.translatable("message.kamenridercraft.woz_quiz"));
                        break;
                    case 2:
                        RiderDriverItem.setFormItem(belt, ZiORiderItems.SHINOBI_MIRIDEWATCH.get(), 1);
                        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ZiORiderItems.ZIKAN_DESPEAR_KAMA.get()));
                        if (this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUNCEMENTS)) playerIn.sendSystemMessage(Component.translatable("message.kamenridercraft.woz_shinobi"));
                        break;
                    default:
                        RiderDriverItem.setFormItem(belt, ZiORiderItems.KIKAI_MIRIDEWATCH.get(), 1);
                        if (this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUNCEMENTS)) playerIn.sendSystemMessage(Component.translatable("message.kamenridercraft.woz_kikai"));
                        break;
                }
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