package com.kelco.kamenridercraft.item.decade;

import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.footSoldiers.EnemySummonEntity;
import com.kelco.kamenridercraft.entities.summons.RiderSummonEntity;
import com.kelco.kamenridercraft.item.*;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class GrandZiOCardItem extends FinalKamenRideCardItem implements ZeinCard {
    private List<MobEffectInstance> zeinEffectList = new ArrayList<>();

    public GrandZiOCardItem(Properties properties) {
        super(properties.durability(1));
    }

    public GrandZiOCardItem setZeinEffects(MobEffectInstance... list) {
        zeinEffectList.addAll(List.of(list));
        return this;
    }

    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return repair.is(Decade_Rider_Items.BLANK_CARD.get()) || super.isValidRepairItem(toRepair, repair);
    }

    @Override
    public void activateCard(Level level, LivingEntity living, ItemStack stack) {
        HolderLookup.RegistryLookup<Enchantment> lookup = level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT);

        for (MobEffectInstance effect : zeinEffectList) living.addEffect(effect);
        ItemStack weapon = new ItemStack(Zi_O_Rider_Items.SAIKYO_ZIKAN_GIRADE.get(), 1);
        weapon.set(DataComponents.ITEM_NAME, Component.translatable("owner.kamenridercraft.zein", weapon.getHoverName()));
        weapon.set(DataComponents.REPAIR_COST, Integer.MAX_VALUE);
        if (weapon.isDamageableItem() && level.getGameRules().getInt(ModGameRules.RULE_SUMMONED_ITEM_DURABILITY) > 0) weapon.set(DataComponents.MAX_DAMAGE, level.getGameRules().getInt(ModGameRules.RULE_SUMMONED_ITEM_DURABILITY));
        weapon.enchant(lookup.get(Enchantments.VANISHING_CURSE).get(), 1);

        if (living instanceof Player) {
            ItemEntity entity = new ItemEntity(level, living.getX(), living.getY(), living.getZ(), weapon, 0, 0, 0);
            entity.setPickUpDelay(0);
            level.addFreshEntity(entity);
        } else living.setItemSlot(EquipmentSlot.MAINHAND, weapon);

        LivingEntity zio;
        if (living instanceof Player) zio = MobsCore.RIDER_SUMMON.get().create(level);
        else zio = MobsCore.ENEMY_SUMMON.get().create(level);

        if (zio != null) {
            zio.moveTo(living.getX(), living.getY()+1, living.getZ(), living.getYRot(), living.getXRot());
            zio.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Zi_O_Rider_Items.ZI_O_HELMET.get()));
            zio.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Zi_O_Rider_Items.ZI_O_CHESTPLATE.get()));
            zio.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Zi_O_Rider_Items.ZI_O_LEGGINGS.get()));
            zio.setItemSlot(EquipmentSlot.FEET, new ItemStack(Zi_O_Rider_Items.ZIKU_DRIVER_ZI_O.get()));
            zio.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Zi_O_Rider_Items.ZIKAN_GIRADE.get()));

            level.addFreshEntity(zio);
            if (zio instanceof RiderSummonEntity rider) rider.bindToPlayer((Player) living);
            else ((EnemySummonEntity) zio).setOwnerUUID(living.getUUID());
        }

        Random rand = new Random();
        for (int i = 0; i < 2; i++) {
            Item summonMainWeapon = Items.AIR;
            Item summonOffWeapon = Items.AIR;
            RiderDriverItem summonBelt;
            switch (rand.nextInt(19)) {
                case 0 -> summonBelt = (RiderDriverItem) Kuuga_Rider_Items.ARCLE.get();
                case 1 -> summonBelt = (RiderDriverItem) Agito_Rider_Items.ALTERING.get();
                case 2 -> {
                    summonBelt = (RiderDriverItem) Ryuki_Rider_Items.RYUKIDRIVER.get();
                    summonMainWeapon = Ryuki_Rider_Items.DRAG_CLAW.get();
                }
                case 3 -> {
                    summonBelt = (RiderDriverItem) Faiz_Rider_Items.FAIZ_DRIVER.get();
                    summonMainWeapon = Faiz_Rider_Items.FAIZ_EDGE.get();
                }
                case 4 -> {
                    summonBelt = (RiderDriverItem) Blade_Rider_Items.BLAYBUCKLE.get();
                    summonMainWeapon = Blade_Rider_Items.BLAYROUZER.get();
                }
                case 5 -> {
                    summonBelt = (RiderDriverItem) Hibiki_Rider_Items.HIBIKIDRIVER.get();
                    summonMainWeapon = Hibiki_Rider_Items.ONGEKIBO_REKKA.get();
                    summonOffWeapon = Hibiki_Rider_Items.ONGEKIBO_REKKA.get();
                }
                case 6 -> {
                    summonBelt = (RiderDriverItem) Kabuto_Rider_Items.KABUTO_RIDER_BELT.get();
                    summonMainWeapon = Kabuto_Rider_Items.KABUTO_KUNAI.get();
                }
                case 7 -> {
                    summonBelt = (RiderDriverItem) Den_O_Rider_Items.DEN_O_BELT.get();
                    summonMainWeapon = Den_O_Rider_Items.DEN_GASHER_SWORD.get();
                }
                case 8 -> {
                    summonBelt = (RiderDriverItem) Kiva_Rider_Items.KIVAT_BELT.get();
                }
                case 9 -> {
                    summonBelt = (RiderDriverItem) Decade_Rider_Items.DECADRIVER.get();
                    summonMainWeapon = Decade_Rider_Items.RIDE_BOOKER.get();
                }
                case 10 -> {
                    summonBelt = (RiderDriverItem) W_Rider_Items.WDRIVER.get();
                }
                case 11 -> {
                    summonBelt = (RiderDriverItem) OOO_Rider_Items.OOODRIVER.get();
                    summonMainWeapon = OOO_Rider_Items.MEDAJALIBUR.get();
                }
                case 12 -> {
                    summonBelt = (RiderDriverItem) Fourze_Rider_Items.FOURZE_DRIVER.get();
                }
                case 13 -> {
                    summonBelt = (RiderDriverItem) Wizard_Rider_Items.WIZARDRIVER.get();
                    summonMainWeapon = Wizard_Rider_Items.WIZARSWORDSGUN.get();
                }
                case 14 -> {
                    summonBelt = (RiderDriverItem) Gaim_Rider_Items.SENGOKU_DRIVER_GAIM.get();
                    summonMainWeapon = Gaim_Rider_Items.DAIDAIMARU.get();
                    summonOffWeapon = Gaim_Rider_Items.MUSOU_SABER.get();
                }
                case 15 -> {
                    summonBelt = (RiderDriverItem) Drive_Rider_Items.DRIVE_DRIVER.get();
                }
                case 16 -> {
                    summonBelt = (RiderDriverItem) Ghost_Rider_Items.GHOST_DRIVER.get();
                    summonMainWeapon = Ghost_Rider_Items.GAN_GUN_SABER_BLADE.get();
                }
                case 17 -> {
                    summonBelt = (RiderDriverItem) Ex_Aid_Rider_Items.GAMER_DRIVER_EX_AID.get();
                    summonMainWeapon = Ex_Aid_Rider_Items.GASHACON_BREAKER.get();
                }
                default -> {
                    summonBelt = (RiderDriverItem) Build_Rider_Items.BUILD_DRIVER.get();
                    summonMainWeapon = Build_Rider_Items.DRILL_CRUSHER.get();
                }
            };

            LivingEntity summon;
            if (living instanceof Player) summon = MobsCore.RIDER_SUMMON.get().create(level);
            else summon = MobsCore.ENEMY_SUMMON.get().create(level);

            if (summon != null) {
                summon.moveTo(living.getX(), living.getY()+1, living.getZ(), living.getYRot(), living.getXRot());
                summon.setItemSlot(EquipmentSlot.HEAD, new ItemStack(summonBelt.HEAD));
                summon.setItemSlot(EquipmentSlot.CHEST, new ItemStack(summonBelt.TORSO));
                summon.setItemSlot(EquipmentSlot.LEGS, new ItemStack(summonBelt.LEGS));
                summon.setItemSlot(EquipmentSlot.FEET, new ItemStack(summonBelt));
                summon.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(summonMainWeapon));
                summon.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(summonOffWeapon));
                if (summonBelt == Kabuto_Rider_Items.KABUTO_RIDER_BELT.get()) RiderDriverItem.set_Form_Item(summon.getItemBySlot(EquipmentSlot.FEET), Kabuto_Rider_Items.KABUTO_ZECTER.get(), 1);
                else if (summonBelt == Kabuto_Rider_Items.KABUTO_RIDER_BELT.get()) RiderDriverItem.set_Form_Item(summon.getItemBySlot(EquipmentSlot.FEET), Kabuto_Rider_Items.KABUTO_ZECTER.get(), 1);

                level.addFreshEntity(summon);
                if (summon instanceof RiderSummonEntity rider) rider.bindToPlayer((Player) living);
                else ((EnemySummonEntity) summon).setOwnerUUID(living.getUUID());
            }
        }

        stack.setDamageValue(1);
        ((ServerLevel) level).sendParticles(new ItemParticleOption(ParticleTypes.ITEM, new ItemStack(this)),
            living.getX(), living.getY()+1, living.getZ(), 10, 0, 0, 0, 0.05);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack CARD = player.getItemInHand(usedHand);
        if (!CARD.isDamaged()) {
            ItemStack BELT = player.getItemBySlot(EquipmentSlot.FEET);

            if (!level.isClientSide() && BELT.getItem() == Zero_One_Rider_Items.ZEIN_DRIVER.get() && ((RiderDriverItem) BELT.getItem()).isTransformed(player)) {
                activateCard(level, player, CARD);
                player.displayClientMessage(Component.translatable("attack.kamenridercraft.justice_order"), true);
                if (!player.isCreative()) for (Item item : Decade_Rider_Items.ZEIN_CARDS) player.getCooldowns().addCooldown(item, 2400);
                player.awardStat(Stats.ITEM_USED.get(this));

                return InteractionResultHolder.sidedSuccess(player.getItemInHand(usedHand), level.isClientSide());
            }
            else return super.use(level, player, usedHand);
        }
        return InteractionResultHolder.fail(player.getItemInHand(usedHand));
    }
}