package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.Build_Rider_Items;
import com.kelco.kamenridercraft.item.Gavv_Rider_Items;
import com.kelco.kamenridercraft.item.OOO_Rider_Items;
import com.kelco.kamenridercraft.item.Zi_O_Rider_Items;
import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WozEntity extends BaseHenchmenEntity {

		public WozEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="woz";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Zi_O_Rider_Items.ZI_O_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Zi_O_Rider_Items.ZI_O_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Zi_O_Rider_Items.ZI_O_LEGGINGS.get()));
		this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Zi_O_Rider_Items.ZIKAN_DESPEAR.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Zi_O_Rider_Items.BEYONDRIVER.get()));
    }

    public void actuallyHurt(DamageSource source, float amount) {
        super.actuallyHurt(source, amount);
        if (!this.level().isClientSide() && this.getHealth()<51 && source.getEntity() instanceof Player playerIn
        && getItemBySlot(EquipmentSlot.FEET).getItem()==Zi_O_Rider_Items.BEYONDRIVER.get()){
            ItemStack belt = getItemBySlot(EquipmentSlot.FEET);
            if (RiderDriverItem.get_Form_Item(belt,1)==Zi_O_Rider_Items.WOZ_MIRIDEWATCH.get()) {
                int rand = this.random.nextInt(3);
                switch (rand) {
                    case 1:
                        RiderDriverItem.set_Form_Item(belt, (RiderFormChangeItem) Zi_O_Rider_Items.QUIZ_MIRIDEWATCH.get(), 1);
                        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Zi_O_Rider_Items.ZIKAN_DESPEAR_TSUE.get()));
                        if (this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUCEMENTS)) playerIn.sendSystemMessage(Component.translatable("message.kamenridercraft.woz_quiz"));
                        break;
                    case 2:
                        RiderDriverItem.set_Form_Item(belt, (RiderFormChangeItem) Zi_O_Rider_Items.SHINOBI_MIRIDEWATCH.get(), 1);
                        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Zi_O_Rider_Items.ZIKAN_DESPEAR_KAMA.get()));
                        if (this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUCEMENTS)) playerIn.sendSystemMessage(Component.translatable("message.kamenridercraft.woz_shinobi"));
                        break;
                    default:
                        RiderDriverItem.set_Form_Item(belt, (RiderFormChangeItem) Zi_O_Rider_Items.KIKAI_MIRIDEWATCH.get(), 1);
                        if (this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUCEMENTS)) playerIn.sendSystemMessage(Component.translatable("message.kamenridercraft.woz_kikai"));
                        break;
                }
            }
        }
    }


    public static AttributeSupplier.Builder setAttributes() {
		return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 128.0D)
        		.add(Attributes.MOVEMENT_SPEED,(double)0.30F)
        		.add(Attributes.ATTACK_DAMAGE, 5.0D)
        		.add(Attributes.MAX_HEALTH, 100.0D);
     }
    

}