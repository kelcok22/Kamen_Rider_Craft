package com.kelco.kamenridercraft.entity.mobs.bosses;

import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.UndeadEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_1.BladeRiderItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

import static com.kelco.kamenridercraft.attachments.AttachmentTypes.MOB_STATE;

public class JackUndeadEntity extends UndeadEntity {
    HolderLookup.RegistryLookup<Enchantment> enchantmentRegistryLookup = level().registryAccess().lookupOrThrow(Registries.ENCHANTMENT);

    public JackUndeadEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME = "undead_human";
        if (getData(MOB_STATE).isEmpty()&& !level().isClientSide() ) {
            setItemSlot(EquipmentSlot.HEAD, new ItemStack(BladeRiderItems.BLADEHELMET.get()));
            getItemBySlot(EquipmentSlot.HEAD).enchant(enchantmentRegistryLookup.get(Enchantments.UNBREAKING).get(), 255);
            setItemSlot(EquipmentSlot.CHEST, new ItemStack(BladeRiderItems.BLADECHESTPLATE.get()));
            getItemBySlot(EquipmentSlot.CHEST).enchant(enchantmentRegistryLookup.get(Enchantments.UNBREAKING).get(), 255);
            setItemSlot(EquipmentSlot.LEGS, new ItemStack(BladeRiderItems.BLADELEGGINGS.get()));
            getItemBySlot(EquipmentSlot.LEGS).enchant(enchantmentRegistryLookup.get(Enchantments.UNBREAKING).get(), 255);
            setItemSlot(EquipmentSlot.FEET, new ItemStack(BladeRiderItems.UNDEAD_BUCKLE.get()));
            getItemBySlot(EquipmentSlot.FEET).enchant(enchantmentRegistryLookup.get(Enchantments.UNBREAKING).get(), 255);

            setDropChance(EquipmentSlot.HEAD, 0.0f);
            setDropChance(EquipmentSlot.CHEST, 0.0f);
            setDropChance(EquipmentSlot.LEGS, 0.0f);
            setDropChance(EquipmentSlot.FEET, 0.0f);

            RiderDriverItem.setUpdateForm(getItemBySlot(EquipmentSlot.FEET));

            switch (getRandom().nextInt(3)) {
                case 0:
                    setData(MOB_STATE, "eagle");
                    setItemSlot(EquipmentSlot.FEET, new ItemStack(BladeRiderItems.UNDEAD_BUCKLE.get()));
                    RiderDriverItem.setFormItem(getItemBySlot(EquipmentSlot.FEET), BladeRiderItems.FUSION_EAGLE_UNDEAD.get(), 1);
                    break;
                case 1:
                    setData(MOB_STATE, "peacock");
                    setItemSlot(EquipmentSlot.FEET, new ItemStack(BladeRiderItems.UNDEAD_BUCKLE.get()));
                    RiderDriverItem.setFormItem(getItemBySlot(EquipmentSlot.FEET), BladeRiderItems.FUSION_PEACOCK_UNDEAD.get(), 1);
                    setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(BladeRiderItems.PEACOCK_SWORTHER.get(), 1));
                    break;
                case 2:
                    setData(MOB_STATE, "wolf");
                    setItemSlot(EquipmentSlot.FEET, new ItemStack(BladeRiderItems.UNDEAD_BUCKLE.get()));
                    RiderDriverItem.setFormItem(getItemBySlot(EquipmentSlot.FEET), BladeRiderItems.FUSION_WOLF_UNDEAD.get(), 1);
                    break;
            }
        }
    }

    @Override
    public void setSealable() {
        if (isSealable()) {
            giveSealableStats();
            switch (getData(MOB_STATE)) {
                case "eagle_sealable":
                    RiderDriverItem.setFormItem(getItemBySlot(EquipmentSlot.FEET), BladeRiderItems.SEALABLE_FUSION_EAGLE.get(), 1);
                    break;
                case "peacock_sealable":
                    RiderDriverItem.setFormItem(getItemBySlot(EquipmentSlot.FEET), BladeRiderItems.SEALABLE_FUSION_PEACOCK.get(), 1);
                    break;
                case "wolf_sealable":
                    RiderDriverItem.setFormItem(getItemBySlot(EquipmentSlot.FEET), BladeRiderItems.SEALABLE_FUSION_WOLF.get(), 1);
                    break;
//                case "elephant_sealable":
//                    RiderDriverItem.setFormItem(getItemBySlot(EquipmentSlot.FEET), BladeRiderItems.SEALABLE_FUSION_ELEPHANT.get(), 1);
//                    break;
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