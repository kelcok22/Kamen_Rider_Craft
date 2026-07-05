package com.kelco.kamenridercraft.item.heisei_phase_1.decade;

import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_1.DecadeRiderItems;
import com.kelco.kamenridercraft.item.reiwa.ZeroOneRiderItems;
import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
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
import org.jetbrains.annotations.NotNull;

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
    public boolean isValidRepairItem(@NotNull ItemStack toRepair, ItemStack repair) {
        return repair.is(DecadeRiderItems.BLANK_CARD.get()) || super.isValidRepairItem(toRepair, repair);
    }

    @Override
    public void activateCard(Level level, LivingEntity livingEntity, ItemStack itemStack) {
        HolderLookup.RegistryLookup<Enchantment> lookup = level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT);

        for (MobEffectInstance effect : zeinEffectList) livingEntity.addEffect(effect);
        if (zeinItemList.isEmpty() && !(livingEntity instanceof Player))
            livingEntity.setItemSlot(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
        else for (String string : zeinItemList) {
            ItemStack weapon = new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse(string)), 1);
            weapon.set(DataComponents.ITEM_NAME, Component.translatable("owner.kamenridercraft.zein", weapon.getHoverName()));
            weapon.set(DataComponents.REPAIR_COST, Integer.MAX_VALUE);
            if (weapon.isDamageableItem() && level.getGameRules().getInt(ModGameRules.RULE_SUMMONED_ITEM_DURABILITY) > 0)
                weapon.set(DataComponents.MAX_DAMAGE, level.getGameRules().getInt(ModGameRules.RULE_SUMMONED_ITEM_DURABILITY));
            weapon.enchant(lookup.get(Enchantments.VANISHING_CURSE).get(), 1);

            if (livingEntity instanceof Player) {
                ItemEntity entity = new ItemEntity(level, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), weapon, 0, 0, 0);
                entity.setPickUpDelay(0);
                level.addFreshEntity(entity);
            } else if (livingEntity.getItemBySlot(EquipmentSlot.MAINHAND).getItem() == BuiltInRegistries.ITEM.get(ResourceLocation.parse(zeinItemList.getFirst())))
                livingEntity.setItemSlot(EquipmentSlot.OFFHAND, weapon);
            else livingEntity.setItemSlot(EquipmentSlot.MAINHAND, weapon);
        }
        if (livingEntity instanceof ServerPlayer player)
            CriteriaTriggers.ITEM_DURABILITY_CHANGED.trigger(player, itemStack, itemStack.getDamageValue() + 1);
        itemStack.setDamageValue(1);
        ((ServerLevel) level).sendParticles(new ItemParticleOption(ParticleTypes.ITEM, new ItemStack(this)),
                livingEntity.getX(), livingEntity.getY() + 1, livingEntity.getZ(), 10, 0, 0, 0, 0.05);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack card = player.getItemInHand(interactionHand);
        if (!card.isDamaged()) {
            ItemStack belt = player.getItemBySlot(EquipmentSlot.FEET);

            if (!level.isClientSide() && belt.getItem() == ZeroOneRiderItems.ZEIN_DRIVER.get() && ((RiderDriverItem) belt.getItem()).isTransformed(player)) {
                activateCard(level, player, card);
                player.displayClientMessage(Component.translatable("attack.kamenridercraft.justice_order"), true);
                if (!player.isCreative())
                    for (Item item : DecadeRiderItems.ZEIN_CARDS) player.getCooldowns().addCooldown(item, 2400);
                player.awardStat(Stats.ITEM_USED.get(this));

                return InteractionResultHolder.sidedSuccess(player.getItemInHand(interactionHand), level.isClientSide());
            } else return super.use(level, player, interactionHand);
        }
        return InteractionResultHolder.fail(player.getItemInHand(interactionHand));
    }
}