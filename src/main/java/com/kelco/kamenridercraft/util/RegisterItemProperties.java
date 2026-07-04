package com.kelco.kamenridercraft.util;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.compat.BetterCombatAttackListener;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.TrilobiteMagiaEntity;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.ZuGumunBaEntity;
import com.kelco.kamenridercraft.item.base_items.BaseSwordItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_1.*;
import com.kelco.kamenridercraft.item.reiwa.GeatsRiderItems;
import com.kelco.kamenridercraft.item.reiwa.GotchardRiderItems;
import com.kelco.kamenridercraft.item.reiwa.ZeroOneRiderItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.fml.ModList;

import java.util.List;
import java.util.Objects;

import static com.kelco.kamenridercraft.KamenRiderCraftCore.*;

public class RegisterItemProperties {
    public static void addCustomItemProperties() {
        registerShieldItems();
        registerSwordItems();
        registerKuugaItems();
        registerFaizItems();
        registerBladeItems();
        registerHibikiItems();
        registerKabutoItems();
        registerZeroOneItems();
        registerGeatsItems();
        registerGotchardItems();
        registerOutsidersItems();

        if (ModList.get().isLoaded("bettercombat")) {
            BetterCombatAttackListener.register();
        }
    }

    private static void registerShieldItems() {
        ResourceLocation BLOCKING_PROPERTY_RESLOC = ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "blocking");

        for (Item item : SHIELD_ITEM) {
            ItemProperties.register(item, BLOCKING_PROPERTY_RESLOC, ($itemStack, $level, $entity, $seed) -> $entity != null && $entity.isUsingItem() && $entity.getUseItem() == $itemStack ? 1.0F : 0.0F);
        }

        ItemProperties.register(RyukiRiderItems.DARK_SHIELD.get(), ResourceLocation.parse("pull"), (p_174635_, p_174636_, p_174637_, p_174638_) -> {
            if (p_174637_ == null) {
                return 0.0F;
            } else {
                if (p_174637_.getMainHandItem().getItem() == RyukiRiderItems.DARK_BLADE.get()) {
                    return 1;
                }
                return 0;
            }
        });
    }

    public static void registerSwordItems() {
        for (Item item : SWORD_GUN_ITEM) {
            ItemProperties.register(item, ResourceLocation.parse("pull"), (p_174635_, p_174636_, p_174637_, p_174638_) -> {
                if (p_174637_ == null) {
                    return 0.0F;
                } else {
                    return p_174637_.getUseItem() != p_174635_ ? 0.0F : (float) (p_174635_.getUseDuration(p_174637_) - p_174637_.getUseItemRemainingTicks());
                }
            });
        }

        for (Item item : CHANGE_SWORD_ITEM) {
            ItemProperties.register(item, ResourceLocation.parse("pull"), (p_174635_, p_174636_, p_174637_, p_174638_) -> BaseSwordItem.getMode(p_174635_));
        }
    }

    public static void registerKuugaItems() {
        for (Item item : KUUGA_CHANGING_ITEM) {
            ItemProperties.register(item, ResourceLocation.parse("pull"), (p_174635_, p_174636_, p_174637_, p_174638_) -> {
                        if (p_174637_ == null) {
                            return 0.0F;
                        } else {
                            p_174637_.getItemBySlot(EquipmentSlot.FEET);
                            if (p_174637_.getItemBySlot(EquipmentSlot.FEET).getItem() == KuugaRiderItems.ARCLE.get()) {
                                ItemStack belt = p_174637_.getItemBySlot(EquipmentSlot.FEET);
                                if (Objects.equals(RiderDriverItem.getFormItem(belt, 1).getBeltTex(), "arcle_belt_r"))
                                    return 1;
                                if (Objects.equals(RiderDriverItem.getFormItem(belt, 1).getBeltTex(), "arcle_belt_u"))
                                    return 2;
                                if (Objects.equals(RiderDriverItem.getFormItem(belt, 1).getBeltTex(), "arcle_belt_ru"))
                                    return 2;
                            }
                            return 0;
                        }
                        //return p_174637_.getUseItem() != p_174635_ ? 0.0F : (float)(p_174635_.getUseDuration() - p_174637_.getUseItemRemainingTicks()) / 1.0F;
                    }
            );
        }

        ItemProperties.register(KuugaRiderItems.KUUGA_PHONE.get(), ResourceLocation.parse("pull"), (p_174635_, p_174636_, p_174637_, p_174638_) -> {
                    if (p_174637_ == null) {
                        return 0.0F;
                    } else {
                        if (p_174637_ instanceof Player player) {

                            List<LivingEntity> nearbyEnemies = player.level().getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(15), entity ->
                                    (entity instanceof ZuGumunBaEntity));
                            for (LivingEntity enemy : nearbyEnemies) {
                                if (enemy != null) {
                                    return 1;
                                }
                            }
                        }
                        return 0;
                    }
                    //return p_174637_.getUseItem() != p_174635_ ? 0.0F : (float)(p_174635_.getUseDuration() - p_174637_.getUseItemRemainingTicks()) / 1.0F;
                }
        );

    }

    public static void registerFaizItems() {
        ItemProperties.register(FaizRiderItems.FAIZ_AXEL.get(), ResourceLocation.parse("pull"), (p_174635_, p_174636_, p_174637_, p_174638_) -> {
                    if (p_174637_ == null) {
                        return 0.0F;
                    } else {
                        p_174637_.getItemBySlot(EquipmentSlot.FEET);
                        if (p_174637_.getItemBySlot(EquipmentSlot.FEET).getItem() == FaizRiderItems.FAIZ_DRIVER.get()) {
                            ItemStack belt = p_174637_.getItemBySlot(EquipmentSlot.FEET);
                            if (Objects.equals(RiderDriverItem.getFormItem(belt, 1).getBeltTex(), "faiz_driver_belt_a"))
                                return 1;
                        } else if (p_174637_.getItemBySlot(EquipmentSlot.FEET).getItem() == FaizRiderItems.FAIZ_DRIVER_NEXT.get()) {
                            return 2;
                        } else if (p_174637_.getItemBySlot(EquipmentSlot.FEET).getItem() == FaizRiderItems.NEXT_KAIXA_DRIVER.get()) {
                            return 3;
                        }
                        return 0;
                    }
                    //return p_174637_.getUseItem() != p_174635_ ? 0.0F : (float)(p_174635_.getUseDuration() - p_174637_.getUseItemRemainingTicks()) / 1.0F;
                }
        );

        ItemProperties.register(FaizRiderItems.FAIZ_BLASTER.get(), ResourceLocation.parse("gold"), (p_174635_, p_174636_, p_174637_, p_174638_) -> {
                    if (p_174637_ == null) {
                        return 0.0F;
                    } else {
                        if (p_174637_.getItemBySlot(EquipmentSlot.FEET).getItem() == FaizRiderItems.FAIZ_DRIVER.get()) {
                            ItemStack Belt = p_174637_.getItemBySlot(EquipmentSlot.FEET);
                            if (Objects.equals(RiderDriverItem.getFormItem(Belt, 1).getFormName(false), "_gold_blaster")) {
                                return 1;
                            }
                        }
                        return 0;
                    }
                }
        );
    }

    public static void registerBladeItems() {
        ItemProperties.register(BladeRiderItems.BLAYROUZER.get(), ResourceLocation.parse("pull"), (p_174635_, p_174636_, p_174637_, p_174638_) -> {
                    if (p_174637_ == null) {
                        return 0.0F;
                    } else {
                        if (p_174637_.getItemBySlot(EquipmentSlot.FEET).getItem() == BladeRiderItems.BLAYBUCKLE.get()) {
                            ItemStack Belt = p_174637_.getItemBySlot(EquipmentSlot.FEET);
                            if (Objects.equals(RiderDriverItem.getFormItem(Belt, 1).getFormName(false), "_jack")) {
                                return 1;
                            }
                        }
                        return 0;
                    }
                }
        );

        ItemProperties.register(BladeRiderItems.GARRENROUZER.get(), ResourceLocation.parse("pull"), (p_174635_, p_174636_, p_174637_, p_174638_) -> {
                    if (p_174637_ == null) {
                        return 0.0F;
                    } else {
                        if (p_174637_.getItemBySlot(EquipmentSlot.FEET).getItem() == BladeRiderItems.GARRENBUCKLE.get() || p_174637_.getItemBySlot(EquipmentSlot.FEET).getItem() == BladeRiderItems.GARRENBUCKLE.get()) {
                            ItemStack Belt = p_174637_.getItemBySlot(EquipmentSlot.FEET);
                            if (Objects.equals(RiderDriverItem.getFormItem(Belt, 1).getFormName(false), "_jack")) {
                                return 1;
                            }
                        }
                        return 0;
                    }
                }
        );

        ItemProperties.register(BladeRiderItems.LEANGLEROUZER.get(), ResourceLocation.parse("pull"), (p_174635_, p_174636_, p_174637_, p_174638_) -> {
                    if (p_174637_ == null) {
                        return 0.0F;
                    } else {
                        if (p_174637_.getItemBySlot(EquipmentSlot.FEET).getItem() == BladeRiderItems.LEANGLEBUCKLE.get()) {
                            ItemStack Belt = p_174637_.getItemBySlot(EquipmentSlot.FEET);
                            if (Objects.equals(RiderDriverItem.getFormItem(Belt, 1).getFormName(false), "_jack")) {
                                return 1;
                            }
                        }
                        return 0;
                    }
                }
        );
    }

    public static void registerHibikiItems() {
        ItemProperties.register(HibikiRiderItems.ONGEKIFLUTE_REKKU.get(), ResourceLocation.parse("pull"), (p_174635_, p_174636_, p_174637_, p_174638_) -> {
            if (p_174637_ == null) {
                return 0.0F;
            } else {
                return p_174637_.getUseItem() != p_174635_ ? 0.0F : (float) (p_174635_.getUseDuration(p_174637_) - p_174637_.getUseItemRemainingTicks());
            }
        });
    }

    public static void registerKabutoItems() {
        ItemProperties.register(KabutoRiderItems.CLOCK_UP_PAD.get(), ResourceLocation.parse("pull"), (p_174635_, p_174636_, p_174637_, p_174638_) -> {
                    if (p_174637_ == null) {
                        return 0.0F;
                    } else {
                        if (p_174637_ instanceof Player player) {
                            if (player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem belt && belt.isTransformed(player)) {
                                if (RiderDriverItem.getFormItem(player.getItemBySlot(EquipmentSlot.FEET), 1).is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "gear/hyper_zecters")))) {
                                    return 1;
                                }
                            }
                        }
                        return 0;
                    }
                }
        );
    }

    public static void registerZeroOneItems() {
        ItemProperties.register(ZeroOneRiderItems.AIMS_RISEPHONE.get(), ResourceLocation.parse("pull"), (p_174635_, p_174636_, p_174637_, p_174638_) -> {
                    if (p_174637_ == null) {
                        return 0.0F;
                    } else {
                        if (p_174637_ instanceof Player player) {

                            List<LivingEntity> nearbyEnemies = player.level().getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(15), entity ->
                                    (entity instanceof TrilobiteMagiaEntity));
                            for (LivingEntity enemy : nearbyEnemies) {
                                if (enemy != null) {
                                    return 1;
                                }
                            }
                        }
                        return 0;
                    }
                    //return p_174637_.getUseItem() != p_174635_ ? 0.0F : (float)(p_174635_.getUseDuration() - p_174637_.getUseItemRemainingTicks()) / 1.0F;
                }
        );

    }
    public static void registerGeatsItems() {
        ItemProperties.register(GeatsRiderItems.LASER_RAISE_RISER.get(), ResourceLocation.parse("pull"), (p_174635_, p_174636_, p_174637_, p_174638_) -> {
                    if (p_174637_ == null) {
                        return 0.0F;
                    } else {
                        if (p_174637_.getItemBySlot(EquipmentSlot.FEET).getItem() == GeatsRiderItems.RAISE_RISER_BELT_ZIIN.get() || p_174637_.getItemBySlot(EquipmentSlot.FEET).getItem() == GeatsRiderItems.LASER_RISE_DRIVER_GAZER_ZERO.get()) {
                            return 1;
                        } else if (p_174637_.getItemBySlot(EquipmentSlot.FEET).getItem() == GeatsRiderItems.RAISE_RISER_BELT_KEKERA.get()) {
                            return 2;
                        } else if (p_174637_.getItemBySlot(EquipmentSlot.FEET).getItem() == GeatsRiderItems.RAISE_RISER_BELT_KYUUN.get()) {
                            return 3;
                        } else if (p_174637_.getItemBySlot(EquipmentSlot.FEET).getItem() == GeatsRiderItems.RAISE_RISER_BELT_BEROBA.get()) {
                            return 4;
                        }
                        return 0;
                    }
                }
        );
    }

    public static void registerGotchardItems() {
        ItemProperties.register(GotchardRiderItems.BLANK_RIDE_CHEMY_CARD.get(), ResourceLocation.parse("pull"), (p_174635_, p_174636_, p_174637_, p_174638_) -> {
                    if (p_174637_ == null) {
                        return 0.0F;
                    } else if (p_174637_ instanceof Player player) {
                        ResourceKey<Level> CITY = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("kamenridercraft:city"));
                        if (player.level().dimension() == CITY) {
                            return 1;
                        } else if (player.level().getBiome(player.blockPosition()).is(BiomeTags.IS_NETHER)) {
                            return 2;
                        }
                    }
                    return 0;
                }
        );
    }

    public static void registerOutsidersItems() {
        for (Item item : DecadeRiderItems.ZEIN_CARDS) {
            ItemProperties.register(item, ResourceLocation.parse("shredded"), (p_174635_, p_174636_, p_174637_, p_174638_) -> {
                if (p_174635_.isDamaged()) return 1;
                return 0;
            });
        }
    }
}