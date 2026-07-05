package com.kelco.kamenridercraft.item.heisei_phase_2.ooo;


import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.item.base_items.BaseItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.OOORiderItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;


public class CellMedalItem extends BaseItem {
    public CellMedalItem(Properties properties) {
        super(properties);
    }

    @Override
    public void inventoryTick(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull Entity entity, int num, boolean flag) {
        if (entity instanceof Player player) {
            int num1 = player.getInventory().countItem(OOORiderItems.CELL_MEDAL.get());
            int num2 = (num1 / 64) - 1;
            if (num1 > 63 & player.getInventory().countItem(OOORiderItems.TOMORROWS_UNDERWEAR_ON_A_STICK.get()) == 0)
				player.addEffect(new MobEffectInstance(EffectCore.GREEED, 300, num2));
        }
    }
}