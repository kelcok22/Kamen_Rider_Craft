package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

import java.util.Random;

public class ZeinEntity extends BaseHenchmenEntity {
private Boolean cardUsed = false;

    public ZeinEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="zein";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Zero_One_Rider_Items.ZERO_ONE_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Zero_One_Rider_Items.ZERO_ONE_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Zero_One_Rider_Items.ZERO_ONE_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Zero_One_Rider_Items.ZEIN_DRIVER.get()));
    }


    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 135.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3F)
                .add(Attributes.ATTACK_DAMAGE, 10.0D)
                .add(Attributes.ARMOR, 3.0D)
                .add(Attributes.MAX_HEALTH, 200.0D);
    }

    @Override
    public void actuallyHurt(DamageSource source, float amount) {
        super.actuallyHurt(source, amount);
        if (!this.cardUsed && !this.level().isClientSide() && source.getEntity() instanceof Player playerIn && this.getHealth() < 100) {
            HolderLookup.RegistryLookup<Enchantment> B = this.level().registryAccess().lookupOrThrow(Registries.ENCHANTMENT);
            Random rand = new Random();
            switch (rand.nextInt(13)) {
                case 0:
                    playerIn.sendSystemMessage(Component.translatable("attack.kamenridercraft.zein_ryuki"));
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Ryuki_Rider_Items.DRAG_BLADE.get()));
                    this.getItemBySlot(EquipmentSlot.MAINHAND).enchant(B.get(Enchantments.VANISHING_CURSE).get(), 1);
                    break;
                    case 1:
                    playerIn.sendSystemMessage(Component.translatable("attack.kamenridercraft.zein_faiz"));
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Faiz_Rider_Items.FAIZ_BLASTER.get()));
                    this.getItemBySlot(EquipmentSlot.MAINHAND).enchant(B.get(Enchantments.VANISHING_CURSE).get(), 1);
                    break;
                case 2:
                    playerIn.sendSystemMessage(Component.translatable("attack.kamenridercraft.zein_blade"));
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Blade_Rider_Items.KINGROUZER.get()));
                    this.getItemBySlot(EquipmentSlot.MAINHAND).enchant(B.get(Enchantments.VANISHING_CURSE).get(), 1);
                    break;
                case 3:
                    playerIn.sendSystemMessage(Component.translatable("attack.kamenridercraft.zein_kabuto"));
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Kabuto_Rider_Items.PERFECT_ZECTER.get()));
                    this.getItemBySlot(EquipmentSlot.MAINHAND).enchant(B.get(Enchantments.VANISHING_CURSE).get(), 1);
                    break;
                case 4:
                    playerIn.sendSystemMessage(Component.translatable("attack.kamenridercraft.zein_kabuto"));
                    this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(1);
                    this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(10.0D);
                    this.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(128.0D);
                    break;
                case 5:
                    playerIn.sendSystemMessage(Component.translatable("attack.kamenridercraft.zein_kiva"));
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Kiva_Rider_Items.ZANVAT_SWORD.get()));
                    this.getItemBySlot(EquipmentSlot.MAINHAND).enchant(B.get(Enchantments.VANISHING_CURSE).get(), 1);
                    break;
                case 6:
                    playerIn.sendSystemMessage(Component.translatable("attack.kamenridercraft.zein_ooo"));
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(OOO_Rider_Items.MEDAGABURYU.get()));
                    this.getItemBySlot(EquipmentSlot.MAINHAND).enchant(B.get(Enchantments.VANISHING_CURSE).get(), 1);
                    break;
                case 7:
                    playerIn.sendSystemMessage(Component.translatable("attack.kamenridercraft.zein_fourze"));
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Fourze_Rider_Items.BARIZUN_SWORD.get()));
                    this.getItemBySlot(EquipmentSlot.MAINHAND).enchant(B.get(Enchantments.VANISHING_CURSE).get(), 1);
                    break;
                case 8:
                    playerIn.sendSystemMessage(Component.translatable("attack.kamenridercraft.zein_wizard"));
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Wizard_Rider_Items.AXCALIBUR.get()));
                    this.getItemBySlot(EquipmentSlot.MAINHAND).enchant(B.get(Enchantments.VANISHING_CURSE).get(), 1);
                    break;
                case 9:
                    playerIn.sendSystemMessage(Component.translatable("attack.kamenridercraft.zein_zi_o"));
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Zi_O_Rider_Items.SAIKYO_ZIKAN_GIRADE.get()));
                    this.getItemBySlot(EquipmentSlot.MAINHAND).enchant(B.get(Enchantments.VANISHING_CURSE).get(), 1);
                    break;
                case 10:
                    playerIn.sendSystemMessage(Component.translatable("attack.kamenridercraft.zein_saber"));
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Saber_Rider_Items.HAOUKEN_XROSS_SABER.get()));
                    this.getItemBySlot(EquipmentSlot.MAINHAND).enchant(B.get(Enchantments.VANISHING_CURSE).get(), 1);
                    break;
                case 11:
                    playerIn.sendSystemMessage(Component.translatable("attack.kamenridercraft.zein_revi"));
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Revice_Rider_Items.REVICELASHER.get()));
                    this.getItemBySlot(EquipmentSlot.MAINHAND).enchant(B.get(Enchantments.VANISHING_CURSE).get(), 1);
                    break;
                case 12:
                    playerIn.sendSystemMessage(Component.translatable("attack.kamenridercraft.zein_geats"));
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Geats_Rider_Items.GEATS_BUSTER_QB9.get()));
                    this.getItemBySlot(EquipmentSlot.MAINHAND).enchant(B.get(Enchantments.VANISHING_CURSE).get(), 1);
                    break;
            } this.cardUsed = true;
        }
        }


}