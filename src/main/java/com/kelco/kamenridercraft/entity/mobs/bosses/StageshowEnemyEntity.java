package com.kelco.kamenridercraft.entity.mobs.bosses;

import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_1.DecadeRiderItems;
import com.kelco.kamenridercraft.item.heisei_phase_1.FaizRiderItems;
import com.kelco.kamenridercraft.item.heisei_phase_1.HibikiRiderItems;
import com.kelco.kamenridercraft.item.heisei_phase_1.KabutoRiderItems;
import com.kelco.kamenridercraft.item.heisei_phase_2.ExAidRiderItems;
import com.kelco.kamenridercraft.item.heisei_phase_2.FourzeRiderItems;
import com.kelco.kamenridercraft.item.heisei_phase_2.GaimRiderItems;
import com.kelco.kamenridercraft.item.heisei_phase_2.WizardRiderItems;
import com.kelco.kamenridercraft.item.showa.BlackRiderItems;
import com.kelco.kamenridercraft.item.showa.IchigoRiderItems;
import com.kelco.kamenridercraft.item.showa.V3RiderItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import static com.kelco.kamenridercraft.attachments.AttachmentTypes.MOB_STATE;

public class StageshowEnemyEntity extends BaseHenchmenEntity {
    public StageshowEnemyEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME = "rider_summon";
        if (!level().isClientSide() && getData(MOB_STATE).isEmpty()) {
            switch (getRandom().nextInt(15)) {
                case 0:
                    setData(MOB_STATE, "red_cheeseman");
                    setItemSlot(EquipmentSlot.HEAD, new ItemStack(BlackRiderItems.BLACK_HELMET.get()));
                    setItemSlot(EquipmentSlot.CHEST, new ItemStack(BlackRiderItems.BLACK_CHESTPLATE.get()));
                    setItemSlot(EquipmentSlot.LEGS, new ItemStack(BlackRiderItems.BLACK_LEGGINGS.get()));
                    setItemSlot(EquipmentSlot.FEET, new ItemStack(BlackRiderItems.SHADOW_CHARGER.get()));
                    RiderDriverItem.setFormItem(getItemBySlot(EquipmentSlot.FEET), BlackRiderItems.CREATION_KING_STONE.get(), 1);
                    setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(BlackRiderItems.SATANSABER.get(), 1));
                    break;
                case 1:
                    setData(MOB_STATE, "boot");
                    setItemSlot(EquipmentSlot.HEAD, new ItemStack(FourzeRiderItems.FOURZE_HELMET.get()));
                    setItemSlot(EquipmentSlot.CHEST, new ItemStack(FourzeRiderItems.FOURZE_CHESTPLATE.get()));
                    setItemSlot(EquipmentSlot.LEGS, new ItemStack(FourzeRiderItems.FOURZE_LEGGINGS.get()));
                    setItemSlot(EquipmentSlot.FEET, new ItemStack(FourzeRiderItems.BOOT_DRIVER.get()));
                    break;
                case 2:
                    setData(MOB_STATE, "alpha");
                    setItemSlot(EquipmentSlot.HEAD, new ItemStack(FaizRiderItems.FAIZ_HELMET.get()));
                    setItemSlot(EquipmentSlot.CHEST, new ItemStack(FaizRiderItems.FAIZ_CHESTPLATE.get()));
                    setItemSlot(EquipmentSlot.LEGS, new ItemStack(FaizRiderItems.FAIZ_LEGGINGS.get()));
                    setItemSlot(EquipmentSlot.FEET, new ItemStack(FaizRiderItems.ALPHA_DRIVER.get()));
                    break;
                case 3:
                    setData(MOB_STATE, "beta");
                    setItemSlot(EquipmentSlot.HEAD, new ItemStack(FaizRiderItems.FAIZ_HELMET.get()));
                    setItemSlot(EquipmentSlot.CHEST, new ItemStack(FaizRiderItems.FAIZ_CHESTPLATE.get()));
                    setItemSlot(EquipmentSlot.LEGS, new ItemStack(FaizRiderItems.FAIZ_LEGGINGS.get()));
                    setItemSlot(EquipmentSlot.FEET, new ItemStack(FaizRiderItems.BETA_DRIVER.get()));
                    break;
                case 4:
                    setData(MOB_STATE, "zuccocade");
                    setItemSlot(EquipmentSlot.HEAD, new ItemStack(DecadeRiderItems.DECADEHELMET.get()));
                    setItemSlot(EquipmentSlot.CHEST, new ItemStack(DecadeRiderItems.DECADECHESTPLATE.get()));
                    setItemSlot(EquipmentSlot.LEGS, new ItemStack(DecadeRiderItems.DECADELEGGINGS.get()));
                    setItemSlot(EquipmentSlot.FEET, new ItemStack(DecadeRiderItems.ZUCCOCADE_BELT.get()));
                    break;
                case 5:
                    setData(MOB_STATE, "fake_v3");
                    setItemSlot(EquipmentSlot.HEAD, new ItemStack(V3RiderItems.V3HELMET.get()));
                    setItemSlot(EquipmentSlot.CHEST, new ItemStack(V3RiderItems.V3CHESTPLATE.get()));
                    setItemSlot(EquipmentSlot.LEGS, new ItemStack(V3RiderItems.V3LEGGINGS.get()));
                    setItemSlot(EquipmentSlot.FEET, new ItemStack(V3RiderItems.FAKE_DOUBLE_TYPHOON.get()));
                    break;
                case 6:
                    setData(MOB_STATE, "uzai");
                    setItemSlot(EquipmentSlot.HEAD, new ItemStack(WizardRiderItems.WIZARD_HELMET.get()));
                    setItemSlot(EquipmentSlot.CHEST, new ItemStack(WizardRiderItems.WIZARD_CHESTPLATE.get()));
                    setItemSlot(EquipmentSlot.LEGS, new ItemStack(WizardRiderItems.WIZARD_LEGGINGS.get()));
                    setItemSlot(EquipmentSlot.FEET, new ItemStack(WizardRiderItems.UZAI_BELT.get()));
                    break;
                case 7:
                    setData(MOB_STATE, "dark_wizard");
                    setItemSlot(EquipmentSlot.HEAD, new ItemStack(WizardRiderItems.WIZARD_HELMET.get()));
                    setItemSlot(EquipmentSlot.CHEST, new ItemStack(WizardRiderItems.WIZARD_CHESTPLATE.get()));
                    setItemSlot(EquipmentSlot.LEGS, new ItemStack(WizardRiderItems.WIZARD_LEGGINGS.get()));
                    setItemSlot(EquipmentSlot.FEET, new ItemStack(WizardRiderItems.DARK_WIZARDRIVER.get()));
                    break;
                case 8:
                    setData(MOB_STATE, "fake_ichigo");
                    setItemSlot(EquipmentSlot.HEAD, new ItemStack(IchigoRiderItems.ICHIGO_HELMET.get()));
                    setItemSlot(EquipmentSlot.CHEST, new ItemStack(IchigoRiderItems.ICHIGO_CHESTPLATE.get()));
                    setItemSlot(EquipmentSlot.LEGS, new ItemStack(IchigoRiderItems.ICHIGO_LEGGINGS.get()));
                    setItemSlot(EquipmentSlot.FEET, new ItemStack(IchigoRiderItems.TYPHOON_FAKE_ICHIGO.get()));
                    break;
                case 9:
                    setData(MOB_STATE, "chophopper");
                    setItemSlot(EquipmentSlot.HEAD, new ItemStack(KabutoRiderItems.KABUTO_HELMET.get()));
                    setItemSlot(EquipmentSlot.CHEST, new ItemStack(KabutoRiderItems.KABUTO_CHESTPLATE.get()));
                    setItemSlot(EquipmentSlot.LEGS, new ItemStack(KabutoRiderItems.KABUTO_LEGGINGS.get()));
                    setItemSlot(EquipmentSlot.FEET, new ItemStack(KabutoRiderItems.CHOPHOPPER_RIDER_BELT.get()));
                    break;
                case 10:
                    setData(MOB_STATE, "lady");
                    setItemSlot(EquipmentSlot.HEAD, new ItemStack(KabutoRiderItems.KABUTO_HELMET.get()));
                    setItemSlot(EquipmentSlot.CHEST, new ItemStack(KabutoRiderItems.KABUTO_CHESTPLATE.get()));
                    setItemSlot(EquipmentSlot.LEGS, new ItemStack(KabutoRiderItems.KABUTO_LEGGINGS.get()));
                    setItemSlot(EquipmentSlot.FEET, new ItemStack(KabutoRiderItems.LADY_RIDER_BELT.get()));
                    break;
                case 11:
                    setData(MOB_STATE, "maja");
                    setItemSlot(EquipmentSlot.HEAD, new ItemStack(GaimRiderItems.GAIM_HELMET.get()));
                    setItemSlot(EquipmentSlot.CHEST, new ItemStack(GaimRiderItems.GAIM_CHESTPLATE.get()));
                    setItemSlot(EquipmentSlot.LEGS, new ItemStack(GaimRiderItems.GAIM_LEGGINGS.get()));
                    setItemSlot(EquipmentSlot.FEET, new ItemStack(GaimRiderItems.SENGOKU_DRIVER_MAJA.get()));
                    setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(GaimRiderItems.MAJAS_SWORD.get(), 1));
                    break;
                case 12:
                    setData(MOB_STATE, "chronicle_bugster");
                    setItemSlot(EquipmentSlot.HEAD, new ItemStack(ExAidRiderItems.EX_AIDHELMET.get()));
                    setItemSlot(EquipmentSlot.CHEST, new ItemStack(ExAidRiderItems.EX_AIDCHESTPLATE.get()));
                    setItemSlot(EquipmentSlot.LEGS, new ItemStack(ExAidRiderItems.EX_AIDLEGGINGS.get()));
                    setItemSlot(EquipmentSlot.FEET, new ItemStack(ExAidRiderItems.GASHACON_BUGVISOR_II_CHRONICLE_BUGTER.get()));
                    break;
                case 13:
                    setData(MOB_STATE, "jaki");
                    setItemSlot(EquipmentSlot.HEAD, new ItemStack(HibikiRiderItems.HIBIKIHELMET.get()));
                    setItemSlot(EquipmentSlot.CHEST, new ItemStack(HibikiRiderItems.HIBIKICHESTPLATE.get()));
                    setItemSlot(EquipmentSlot.LEGS, new ItemStack(HibikiRiderItems.HIBIKILEGGINGS.get()));
                    setItemSlot(EquipmentSlot.FEET, new ItemStack(HibikiRiderItems.JAKIDRIVER.get()));
                    break;
                case 14:
                    setData(MOB_STATE, "mujaki");
                    setItemSlot(EquipmentSlot.HEAD, new ItemStack(HibikiRiderItems.HIBIKIHELMET.get()));
                    setItemSlot(EquipmentSlot.CHEST, new ItemStack(HibikiRiderItems.HIBIKICHESTPLATE.get()));
                    setItemSlot(EquipmentSlot.LEGS, new ItemStack(HibikiRiderItems.HIBIKILEGGINGS.get()));
                    setItemSlot(EquipmentSlot.FEET, new ItemStack(HibikiRiderItems.MUJAKIDRIVER.get()));
                    break;
            }
            RiderDriverItem.setUpdateForm(getItemBySlot(EquipmentSlot.FEET));
        }
    }

    public static AttributeSupplier.Builder setAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 128.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.30F)
                .add(Attributes.ATTACK_DAMAGE, 5.0D)
                .add(Attributes.MAX_HEALTH, 75.0D);
    }
}