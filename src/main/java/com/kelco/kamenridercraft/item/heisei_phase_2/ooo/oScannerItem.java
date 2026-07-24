package com.kelco.kamenridercraft.item.heisei_phase_2.ooo;

import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.summons.RiderSummonEntity;
import com.kelco.kamenridercraft.item.base_items.BaseItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.OOORiderItems;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ColorParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.OwnableEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static com.kelco.kamenridercraft.util.MiscUtil.oooComboCheck;

public class oScannerItem extends BaseItem {

    public oScannerItem(Properties prop) {
        super(prop);
    }

    public void inventoryTick(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull Entity entity, int slotId, boolean isSelected) {
        if (entity instanceof Player player) {
            if (player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem belt
                    && belt == OOORiderItems.OOODRIVER.get() && belt.isTransformed(player)) {
                ItemStack Belt = player.getItemBySlot(EquipmentSlot.FEET);
                String medalOne = RiderDriverItem.getFormItem(Belt, 1).toString();
                String medalTwo = RiderDriverItem.getFormItem(Belt, 2).toString();
                String medalThree = RiderDriverItem.getFormItem(Belt, 3).toString();

                switch (oooComboCheck(medalOne, medalTwo, medalThree)) {
                    case "tajadol":
                        player.addEffect(new MobEffectInstance(EffectCore.GLIDE, 40, 0, true, false));
                        break;
                    case "tajadol_eternity", "putotyra":
                        player.addEffect(new MobEffectInstance(EffectCore.FLYING, 400, 0, true, false));
                        break;
                    case "gatakiriba":
                        player.addEffect(new MobEffectInstance(MobEffects.JUMP, 40, 6, true, false));
                        break;
                    case "latorartar":
                        player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 6, true, false));
                        break;
                    case "sagohzo":
                        player.addEffect(new MobEffectInstance(EffectCore.PUNCH, 40, 5, true, false));
                        break;
                    case "shauta":
                        player.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 40, 0, true, false));
                        break;
                }
            }
        }
    }

    public boolean inventoryOrHolderContains(Player player, Item item) {
        NonNullList<ItemStack> inv = NonNullList.create();
        inv.addAll(player.getInventory().items);
        inv.addAll(player.getInventory().armor);
        inv.add(player.getInventory().offhand.getFirst());

        if (player.getInventory().countItem(item) != 0) return true;
        else for (ItemStack itemStack : inv) {
            if (itemStack.has(DataComponents.CONTAINER)) {
                for (ItemStack stack : itemStack.getComponents().get(DataComponents.CONTAINER).nonEmptyItems())
                    if (stack.getItem() == item) return true;
            } else if (itemStack.has(DataComponents.BUNDLE_CONTENTS))
                for (ItemStack stack : itemStack.getComponents().get(DataComponents.BUNDLE_CONTENTS).items())
                    if (stack.getItem() == item) return true;
        }
        return false;
    }

    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemstack = player.getItemInHand(interactionHand);

        if (player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem belt
                && belt == OOORiderItems.OOODRIVER.get() && belt.isTransformed(player) && player.level() instanceof ServerLevel serverLevel) {
            ItemStack Belt = player.getItemBySlot(EquipmentSlot.FEET);

            if (RiderDriverItem.getFormItem(Belt, 1) == OOORiderItems.KUWAGATA_MEDAL.get() &&
                    RiderDriverItem.getFormItem(Belt, 2) == OOORiderItems.KAMAKIRI_MEDAL.get() &&
                    RiderDriverItem.getFormItem(Belt, 3) == OOORiderItems.BATTA_MEDAL.get()) {
                if (!player.isShiftKeyDown()) {
                    RiderSummonEntity summon = MobsCore.RIDER_SUMMON.get().create(level);
                    if (summon != null) {
                        summon.moveTo(player.getX(), player.getY() + 1, player.getZ(), player.getYRot(), player.getXRot());
                        summon.setItemSlot(EquipmentSlot.HEAD, new ItemStack(OOORiderItems.OOOHELMET.get()));
                        summon.setItemSlot(EquipmentSlot.CHEST, new ItemStack(OOORiderItems.OOOCHESTPLATE.get()));
                        summon.setItemSlot(EquipmentSlot.LEGS, new ItemStack(OOORiderItems.OOOLEGGINGS.get()));
                        ItemStack rider = new ItemStack(OOORiderItems.OOODRIVER.get());
                        RiderDriverItem.setUpdateForm(rider);
                        summon.setItemSlot(EquipmentSlot.FEET, rider);
                        RiderDriverItem.setFormItem(summon.getItemBySlot(EquipmentSlot.FEET), OOORiderItems.KUWAGATA_MEDAL.get(), 1);
                        RiderDriverItem.setFormItem(summon.getItemBySlot(EquipmentSlot.FEET), OOORiderItems.KAMAKIRI_MEDAL.get(), 2);

                        level.addFreshEntity(summon);
                        summon.bindToPlayer(player);
                        summon.setRequiredForms(player);
                        summon.mustMatchAllForms(true);
                        if (!player.isCreative()) player.getCooldowns().addCooldown(this, 200);
                        player.awardStat(Stats.ITEM_USED.get(this));
                    }
                } else if (inventoryOrHolderContains(player, OOORiderItems.TAKA_MEDAL.get())
                        && inventoryOrHolderContains(player, OOORiderItems.KUJAKU_MEDAL.get())
                        && inventoryOrHolderContains(player, OOORiderItems.CONDOR_MEDAL.get())
                        && inventoryOrHolderContains(player, OOORiderItems.LION_MEDAL.get())
                        && inventoryOrHolderContains(player, OOORiderItems.TORA_MEDAL.get())
                        && inventoryOrHolderContains(player, OOORiderItems.CHEETAH_MEDAL.get())
                        && inventoryOrHolderContains(player, OOORiderItems.SAI_MEDAL.get())
                        && inventoryOrHolderContains(player, OOORiderItems.GORILLA_MEDAL.get())
                        && inventoryOrHolderContains(player, OOORiderItems.ZOU_MEDAL.get())
                        && inventoryOrHolderContains(player, OOORiderItems.SHACHI_MEDAL.get())
                        && inventoryOrHolderContains(player, OOORiderItems.UNAGI_MEDAL.get())
                        && inventoryOrHolderContains(player, OOORiderItems.TAKO_MEDAL.get())
                        && inventoryOrHolderContains(player, OOORiderItems.PTERA_MEDAL.get())
                        && inventoryOrHolderContains(player, OOORiderItems.TRICERA_MEDAL.get())
                        && inventoryOrHolderContains(player, OOORiderItems.TYRANNO_MEDAL.get())
                        && inventoryOrHolderContains(player, OOORiderItems.COBRA_MEDAL.get())
                        && inventoryOrHolderContains(player, OOORiderItems.KAME_MEDAL.get())
                        && inventoryOrHolderContains(player, OOORiderItems.WANI_MEDAL.get())) {
                    List<RiderSummonEntity> clones = level.getEntitiesOfClass(RiderSummonEntity.class, player.getBoundingBox().inflate(10), entity ->
                            (entity.getOwner() == player && RiderDriverItem.getFormItem(entity.getItemBySlot(EquipmentSlot.FEET), 1) == OOORiderItems.KUWAGATA_MEDAL.get()));
                    if (clones.size() >= 7) {
                        RiderDriverItem.setFormItem(clones.getFirst().getItemBySlot(EquipmentSlot.FEET), OOORiderItems.TAKA_MEDAL.get(), 1);
                        RiderDriverItem.setFormItem(clones.get(0).getItemBySlot(EquipmentSlot.FEET), OOORiderItems.KUJAKU_MEDAL.get(), 2);
                        RiderDriverItem.setFormItem(clones.get(0).getItemBySlot(EquipmentSlot.FEET), OOORiderItems.CONDOR_MEDAL.get(), 3);
                        RiderDriverItem.setFormItem(clones.get(1).getItemBySlot(EquipmentSlot.FEET), OOORiderItems.LION_MEDAL.get(), 1);
                        RiderDriverItem.setFormItem(clones.get(1).getItemBySlot(EquipmentSlot.FEET), OOORiderItems.TORA_MEDAL.get(), 2);
                        RiderDriverItem.setFormItem(clones.get(1).getItemBySlot(EquipmentSlot.FEET), OOORiderItems.CHEETAH_MEDAL.get(), 3);
                        RiderDriverItem.setFormItem(clones.get(2).getItemBySlot(EquipmentSlot.FEET), OOORiderItems.SAI_MEDAL.get(), 1);
                        RiderDriverItem.setFormItem(clones.get(2).getItemBySlot(EquipmentSlot.FEET), OOORiderItems.GORILLA_MEDAL.get(), 2);
                        RiderDriverItem.setFormItem(clones.get(2).getItemBySlot(EquipmentSlot.FEET), OOORiderItems.ZOU_MEDAL.get(), 3);
                        RiderDriverItem.setFormItem(clones.get(3).getItemBySlot(EquipmentSlot.FEET), OOORiderItems.SHACHI_MEDAL.get(), 1);
                        RiderDriverItem.setFormItem(clones.get(3).getItemBySlot(EquipmentSlot.FEET), OOORiderItems.UNAGI_MEDAL.get(), 2);
                        RiderDriverItem.setFormItem(clones.get(3).getItemBySlot(EquipmentSlot.FEET), OOORiderItems.TAKO_MEDAL.get(), 3);
                        RiderDriverItem.setFormItem(clones.get(4).getItemBySlot(EquipmentSlot.FEET), OOORiderItems.PTERA_MEDAL.get(), 1);
                        RiderDriverItem.setFormItem(clones.get(4).getItemBySlot(EquipmentSlot.FEET), OOORiderItems.TRICERA_MEDAL.get(), 2);
                        RiderDriverItem.setFormItem(clones.get(4).getItemBySlot(EquipmentSlot.FEET), OOORiderItems.TYRANNO_MEDAL.get(), 3);
                        RiderDriverItem.setFormItem(clones.get(5).getItemBySlot(EquipmentSlot.FEET), OOORiderItems.COBRA_MEDAL.get(), 1);
                        RiderDriverItem.setFormItem(clones.get(5).getItemBySlot(EquipmentSlot.FEET), OOORiderItems.KAME_MEDAL.get(), 2);
                        RiderDriverItem.setFormItem(clones.get(5).getItemBySlot(EquipmentSlot.FEET), OOORiderItems.WANI_MEDAL.get(), 3);
                        RiderDriverItem.setFormItem(clones.get(6).getItemBySlot(EquipmentSlot.FEET), OOORiderItems.TAKA_MEDAL.get(), 1);
                        RiderDriverItem.setFormItem(clones.get(6).getItemBySlot(EquipmentSlot.FEET), OOORiderItems.TORA_MEDAL.get(), 2);
                        player.playSound(SoundEvents.PLAYER_LEVELUP, 1.0F, 1.35F);
                        if (!player.isCreative()) player.getCooldowns().addCooldown(this, 200);
                        player.awardStat(Stats.ITEM_USED.get(this));
                    }
                }
            } else if (RiderDriverItem.getFormItem(Belt, 1) == OOORiderItems.LION_MEDAL.get() &&
                    RiderDriverItem.getFormItem(Belt, 2) == OOORiderItems.TORA_MEDAL.get() &&
                    RiderDriverItem.getFormItem(Belt, 3) == OOORiderItems.CHEETAH_MEDAL.get()) {
                Vec3 playerPos = player.getEyePosition(1.0f);
                List<LivingEntity> toIgnite = level.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(3), entity ->
                        entity != player && !(entity instanceof OwnableEntity owned && owned.getOwner() == player));
                List<LivingEntity> toBlind = level.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(6), entity ->
                        entity != player && !(entity instanceof OwnableEntity owned && owned.getOwner() == player));
                for (Entity target : toIgnite) {
                    target.hurt(player.damageSources().playerAttack(player), 10.0F);
                    target.setRemainingFireTicks(200);
                }
                for (LivingEntity target : toBlind)
                    target.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100, 0, true, true));

                serverLevel.sendParticles(ParticleTypes.FLAME, playerPos.x, playerPos.y, playerPos.z, 100, 1.5, 1.5, 1.5, 0.01);
                player.playSound(SoundEvents.FIRECHARGE_USE, 1.0F, (level.getRandom().nextFloat() - level.getRandom().nextFloat()) * 0.2F + 1.0F);
                if (!player.isCreative()) player.getCooldowns().addCooldown(this, 200);
                player.awardStat(Stats.ITEM_USED.get(this));
            } else if (RiderDriverItem.getFormItem(Belt, 1) == OOORiderItems.SAI_MEDAL.get() &&
                    RiderDriverItem.getFormItem(Belt, 2) == OOORiderItems.GORILLA_MEDAL.get() &&
                    RiderDriverItem.getFormItem(Belt, 3) == OOORiderItems.ZOU_MEDAL.get()) {
                Vec3 playerPos = player.getEyePosition(1.0f);
                List<LivingEntity> nearbyTargets = level.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(5), entity ->
                        entity != player && !(entity instanceof OwnableEntity owned && owned.getOwner() == player));
                for (LivingEntity target : nearbyTargets) {
                    target.hurt(player.damageSources().playerAttack(player), 10.0F);
                    target.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 40, 0, true, false));
                }
                serverLevel.sendParticles(ParticleTypes.GUST_EMITTER_LARGE, playerPos.x, playerPos.y, playerPos.z, 2, 1.5, 0.5, 1.5, 0.01);
                if (!player.isCreative()) player.getCooldowns().addCooldown(this, 200);
                player.awardStat(Stats.ITEM_USED.get(this));
            } else if (RiderDriverItem.getFormItem(Belt, 1) == OOORiderItems.SHACHI_MEDAL.get() &&
                    RiderDriverItem.getFormItem(Belt, 2) == OOORiderItems.UNAGI_MEDAL.get() &&
                    RiderDriverItem.getFormItem(Belt, 3) == OOORiderItems.TAKO_MEDAL.get()) {
                Vec3 playerPos = player.getEyePosition(1.0f);
                List<LivingEntity> nearbyTargets = level.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(5), entity ->
                        entity != player && !(entity instanceof OwnableEntity owned && owned.getOwner() == player));
                for (LivingEntity target : nearbyTargets) {
                    target.hurt(player.damageSources().playerAttack(player), 10.0F);
                    target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 9, true, true));
                }

                serverLevel.sendParticles(ParticleTypes.ELECTRIC_SPARK, playerPos.x, playerPos.y, playerPos.z, 200, 1.5, 1.5, 1.5, 0.01);
                if (!player.isCreative()) player.getCooldowns().addCooldown(this, 200);
                player.awardStat(Stats.ITEM_USED.get(this));
            } else if (RiderDriverItem.getFormItem(Belt, 1) == OOORiderItems.TAKA_MEDAL.get() &&
                    RiderDriverItem.getFormItem(Belt, 2) == OOORiderItems.KUJAKU_MEDAL.get() &&
                    RiderDriverItem.getFormItem(Belt, 3) == OOORiderItems.CONDOR_MEDAL.get()) {

                LargeFireball largefireball = new LargeFireball(player.level(), player, player.getLookAngle().normalize(), 1);
                largefireball.setPos(largefireball.getX(), player.getY(0.5) + 0.5, largefireball.getZ());
                player.level().addFreshEntity(largefireball);

                if (!player.isCreative()) player.getCooldowns().addCooldown(this, 200);
                player.awardStat(Stats.ITEM_USED.get(this));
            } else if (RiderDriverItem.getFormItem(Belt, 1) == OOORiderItems.PTERA_MEDAL.get() &&
                    RiderDriverItem.getFormItem(Belt, 2) == OOORiderItems.TRICERA_MEDAL.get() &&
                    RiderDriverItem.getFormItem(Belt, 3) == OOORiderItems.TYRANNO_MEDAL.get()) {
                Vec3 playerPos = player.getEyePosition(1.0f);
                List<LivingEntity> nearbyTargets = level.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(5), entity ->
                        entity != player && !(entity instanceof OwnableEntity owned && owned.getOwner() == player));
                for (LivingEntity target : nearbyTargets) {
                    target.hurt(player.damageSources().playerAttack(player), 10.0F);
                    target.setTicksFrozen(340);
                    target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 3, true, false));
                }
                player.addEffect(new MobEffectInstance(EffectCore.BLIZZARD, 10, 0, true, false));
                serverLevel.sendParticles(ParticleTypes.SNOWFLAKE, playerPos.x, playerPos.y, playerPos.z, 50, 1.5, 0.5, 1.5, 0.01);
                if (!player.isCreative()) player.getCooldowns().addCooldown(this, 200);
                player.awardStat(Stats.ITEM_USED.get(this));
            } else if (RiderDriverItem.getFormItem(Belt, 1) == OOORiderItems.COBRA_MEDAL.get() &&
                    RiderDriverItem.getFormItem(Belt, 2) == OOORiderItems.KAME_MEDAL.get() &&
                    RiderDriverItem.getFormItem(Belt, 3) == OOORiderItems.WANI_MEDAL.get()) {
                Vec3 playerPos = player.getEyePosition(1.0f);

                player.removeEffect(MobEffects.POISON);
                player.removeEffect(MobEffects.WITHER);
                serverLevel.sendParticles(ColorParticleOption.create(ParticleTypes.ENTITY_EFFECT, 1.0F, 0.8F, 0.5F), playerPos.x, playerPos.y, playerPos.z, 25, 0.5, 0.5, 0.5, 0.01);
                if (!player.isCreative()) player.getCooldowns().addCooldown(this, 200);
                player.awardStat(Stats.ITEM_USED.get(this));
            } else if (RiderDriverItem.getFormItem(Belt, 1) == OOORiderItems.SUPER_TAKA_MEDAL.get() &&
                    RiderDriverItem.getFormItem(Belt, 2) == OOORiderItems.SUPER_TORA_MEDAL.get() &&
                    RiderDriverItem.getFormItem(Belt, 3) == OOORiderItems.SUPER_BATTA_MEDAL.get()) {
                Vec3 playerPos = player.getEyePosition(1.0f);

                player.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
                player.removeEffect(MobEffects.DIG_SLOWDOWN);
                player.removeEffect(EffectCore.PAUSE);
                serverLevel.sendParticles(ParticleTypes.ELECTRIC_SPARK, playerPos.x, playerPos.y, playerPos.z, 25, 0.5, 0.5, 0.5, 0.01);
                if (!player.isCreative()) player.getCooldowns().addCooldown(this, 200);
                player.awardStat(Stats.ITEM_USED.get(this));
            } else if (RiderDriverItem.getFormItem(Belt, 1) == OOORiderItems.TAKA_ETERNITY_MEDAL.get() &&
                    RiderDriverItem.getFormItem(Belt, 2) == OOORiderItems.KUJAKU_ETERNITY_MEDAL.get() &&
                    RiderDriverItem.getFormItem(Belt, 3) == OOORiderItems.CONDOR_ETERNITY_MEDAL.get()) {

                LargeFireball largefireball = new LargeFireball(player.level(), player, player.getLookAngle().normalize(), 3);
                largefireball.setPos(largefireball.getX(), player.getY(0.5) + 0.5, largefireball.getZ());
                player.level().addFreshEntity(largefireball);

                if (!player.isCreative()) player.getCooldowns().addCooldown(this, 200);
                player.awardStat(Stats.ITEM_USED.get(this));
            }
        }
        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
    }
}