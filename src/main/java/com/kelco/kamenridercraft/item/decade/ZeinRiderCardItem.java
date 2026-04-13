package com.kelco.kamenridercraft.item.decade;

import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Decade_Rider_Items;
import com.kelco.kamenridercraft.item.Zero_One_Rider_Items;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;


public class ZeinRiderCardItem extends RiderCardItem implements ZeinCard {
    private List<MobEffectInstance> zeinEffectList = new ArrayList<>();

    public ZeinRiderCardItem(Properties properties, String formName, String ridername, String beltTex, MobEffectInstance... effects) {
        super(properties.durability(1), formName, ridername, beltTex, effects);
        zeinEffectList.addAll(List.of(effects));
    }

    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return repair.is(Decade_Rider_Items.BLANK_CARD.get()) || super.isValidRepairItem(toRepair, repair);
    }

    @Override
    public void activateCard(Level level, LivingEntity living, ItemStack stack) {
        HolderLookup.RegistryLookup<Enchantment> lookup = level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT);

        for (MobEffectInstance effect : zeinEffectList) living.addEffect(effect);
        if (living instanceof ServerPlayer player) CriteriaTriggers.ITEM_DURABILITY_CHANGED.trigger(player, stack, stack.getDamageValue()+1);
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