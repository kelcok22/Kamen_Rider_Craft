package com.kelco.kamenridercraft.entity.mobs.foot_soldiers;

import com.kelco.kamenridercraft.item.heisei_phase_1.DecadeRiderItems;
import com.kelco.kamenridercraft.item.heisei_phase_1.decade.ZeinCard;
import com.kelco.kamenridercraft.item.reiwa.ZeroOneRiderItems;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Random;

public class ZeinEnemySummonEntity extends EnemySummonEntity {
    public ZeinEnemySummonEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="zein_summon";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ZeroOneRiderItems.ZERO_ONE_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(ZeroOneRiderItems.ZERO_ONE_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(ZeroOneRiderItems.ZERO_ONE_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(ZeroOneRiderItems.ZEIN_DRIVER.get()));
        Random rand = new Random();
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(switch (rand.nextInt(23)) {
            case 0 -> DecadeRiderItems.KUUGA_ULTIMATE_CARD.get();
            case 1 -> DecadeRiderItems.AGITO_SHINING_CARD.get();
            case 2 -> DecadeRiderItems.RYUKI_SURVIVE_CARD.get();
            case 3 -> DecadeRiderItems.FAIZ_BLASTER_CARD.get();
            case 4 -> DecadeRiderItems.BLADE_KING_CARD.get();
            case 5 -> DecadeRiderItems.ARMED_HIBIKI_CARD.get();
            case 6 -> DecadeRiderItems.KABUTO_HYPER_CARD.get();
            case 7 -> DecadeRiderItems.DEN_O_LINER_CARD.get();
            case 8 -> DecadeRiderItems.KIVA_EMPEROR_CARD.get();
            case 9 -> DecadeRiderItems.DECADE_COMPLETE_CARD.get();
            case 10 -> DecadeRiderItems.W_XTREME_CARD.get();
            case 11 -> DecadeRiderItems.OOO_PUTOTYRA_CARD.get();
            case 12 -> DecadeRiderItems.FOURZE_COSMIC_CARD.get();
            case 13 -> DecadeRiderItems.WIZARD_INFINITY_CARD.get();
            case 14 -> DecadeRiderItems.GAIM_KIWAMI_CARD.get();
            case 15 -> DecadeRiderItems.DRIVE_TRIDORON_CARD.get();
            case 16 -> DecadeRiderItems.GHOST_MUGEN_CARD.get();
            case 17 -> DecadeRiderItems.EX_AID_MUTEKI_CARD.get();
            case 18 -> DecadeRiderItems.BUILD_GENIUS_CARD.get();
            case 19 -> DecadeRiderItems.ZERO_TWO_CARD.get();
            case 20 -> DecadeRiderItems.XROSS_SABER_CARD.get();
            case 21 -> DecadeRiderItems.ULTIMATE_REVI_CARD.get();
            default -> DecadeRiderItems.GEATS_IX_CARD.get();
        }));
        this.reassessWeaponGoal();
    }

    public static AttributeSupplier.Builder setAttributes() {
        return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.2F).add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.ARMOR, -10.0D).add(Attributes.ATTACK_DAMAGE, 1.0D);
    }

    @Override
    public void actuallyHurt(DamageSource source, float amount) {
        super.actuallyHurt(source, amount);
        if (!this.level().isClientSide() && source.getEntity() != this.getOwner() && this.getHealth() < this.getMaxHealth()/2
                && this.getItemBySlot(EquipmentSlot.MAINHAND).getItem() instanceof ZeinCard zein)
            zein.activateCard(this.level(), this, this.getItemBySlot(EquipmentSlot.MAINHAND));
    }
}
