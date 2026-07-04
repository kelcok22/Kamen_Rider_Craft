package com.kelco.kamenridercraft.item.base_items;

import com.kelco.kamenridercraft.entity.projectiles.ShurikenProjectileEntity;
import com.kelco.kamenridercraft.entity.projectiles.WeaponProjectileEntity;
import com.kelco.kamenridercraft.item.ModdedItemCore;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BaseThrowableItem extends SwordItem {

    private Item changedRepairItem = ModdedItemCore.RIDER_CIRCUIT.get();
    private boolean shuriken = false;

    public BaseThrowableItem(Tier toolTier, int Atk, float Spd, Properties prop) {
        super(toolTier, prop.attributes(SwordItem.createAttributes(Tiers.DIAMOND, Atk, Spd)));

    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
		ItemStack itemStack = player.getItemInHand(interactionHand);

		if (!level.isClientSide) {
			level.playSound(null, player.getX(), player.getY(), player.getZ(),
					SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
            if (shuriken) {
                ShurikenProjectileEntity shuriken = new ShurikenProjectileEntity(level, player);
                shuriken.setItem(itemStack);
                shuriken.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
                level.addFreshEntity(shuriken);
            } else {
                WeaponProjectileEntity weapon = new WeaponProjectileEntity(level, player);
                weapon.setItem(itemStack);
                weapon.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
                level.addFreshEntity(weapon);
            }
        }

        player.awardStat(Stats.ITEM_USED.get(this));

        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
    }

    public BaseThrowableItem changeRepairItem(Item item) {
        changedRepairItem = item;
        return this;
    }

    public boolean isValidRepairItem(@NotNull ItemStack itemStackOne, ItemStack repairItem) {
        return repairItem.getItem() == changedRepairItem;
    }

    public BaseThrowableItem addToList(List<Item> TabList, int num) {
        for (int i = 0; i < num; i++) {
            TabList.add(this);
        }
        return this;
    }

    public BaseThrowableItem addToList(List<Item> TabList) {
        TabList.add(this);
        return this;
    }

    public BaseThrowableItem isShuriken() {
        shuriken = true;
        return this;
    }
}
