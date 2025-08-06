package com.kelco.kamenridercraft.item.gotchard;
import com.kelco.kamenridercraft.item.BaseItems.BaseBlasterItem;
import com.kelco.kamenridercraft.item.Gotchard_Rider_Items;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class ValvarusherItem extends BaseBlasterItem {

	public ValvarusherItem(Tier toolTier, int Atk, float Spd, Properties prop) {
		super(toolTier, Atk, Spd, prop);
	}

	public void releaseUsing(ItemStack stack, Level level, LivingEntity entityLiving, int timeLeft) {
        super.releaseUsing(stack, level, entityLiving, timeLeft);
		if (entityLiving instanceof Player player && player.getItemBySlot(EquipmentSlot.FEET) == ItemStack.EMPTY) {
			if (player.getOffhandItem().getItem() == Gotchard_Rider_Items.MADWHEEL_REPLI_CHEMY_CARD.get())
                player.setItemSlot(EquipmentSlot.FEET, new ItemStack(Gotchard_Rider_Items.VALVARADRAW_BUCKLE_LACHESIS.get(), 1));
            else player.setItemSlot(EquipmentSlot.FEET, new ItemStack(Gotchard_Rider_Items.VALVARADRAW_BUCKLE.get(), 1));
		}
	}
}