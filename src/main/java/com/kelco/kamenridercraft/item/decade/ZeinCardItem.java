package com.kelco.kamenridercraft.item.decade;

import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Decade_Rider_Items;
import com.kelco.kamenridercraft.item.Zero_One_Rider_Items;
import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
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
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;


public class ZeinCardItem extends FinalKamenRideCardItem implements ZeinCard {
    private List<MobEffectInstance> zeinEffectList = new ArrayList<>();
    private List<String> zeinItemList = new ArrayList<>(2);

    public ZeinCardItem(Properties properties) {
        super(properties.durability(1));
    }

    public ZeinCardItem setZeinEffects(MobEffectInstance... list) {
        zeinEffectList.addAll(List.of(list));
        return this;
    }

    public ZeinCardItem setZeinItems(String... list) {
        zeinItemList.addAll(List.of(list));
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
        for (String string : zeinItemList) {
            ItemStack weapon = new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse(string)), 1);
            weapon.set(DataComponents.ITEM_NAME, Component.translatable("owner.kamenridercraft.zein", weapon.getHoverName()));
            if (weapon.isDamageableItem() && level.getGameRules().getInt(ModGameRules.RULE_SUMMONED_ITEM_DURABILITY) > 0) weapon.set(DataComponents.MAX_DAMAGE, level.getGameRules().getInt(ModGameRules.RULE_SUMMONED_ITEM_DURABILITY));
            weapon.enchant(lookup.get(Enchantments.VANISHING_CURSE).get(), 1);

            if (living instanceof Player) {
                ItemEntity entity = new ItemEntity(level, living.getX(), living.getY(), living.getZ(), weapon, 0, 0, 0);
                entity.setPickUpDelay(0);
                level.addFreshEntity(entity);
            } else if (zeinItemList.size() == 2 && zeinItemList.get(1).equals(string)) living.setItemSlot(EquipmentSlot.OFFHAND, weapon);
            else living.setItemSlot(EquipmentSlot.MAINHAND, weapon);
        }
        stack.setDamageValue(1);
        ((ServerLevel) level).sendParticles(new ItemParticleOption(ParticleTypes.ITEM, new ItemStack(this)),
            living.getX(), living.getY()+1, living.getZ(), 10, 0, 0, 0, 0.2);
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