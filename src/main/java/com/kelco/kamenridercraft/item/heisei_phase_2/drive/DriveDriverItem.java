package com.kelco.kamenridercraft.item.heisei_phase_2.drive;

import com.kelco.kamenridercraft.item.base_items.RiderArmorItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.DriveRiderItems;
import com.kelco.kamenridercraft.world.inventory.ShiftCarHolderGuiMenu;
import io.netty.buffer.Unpooled;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemContainerContents;
import net.neoforged.neoforge.registries.DeferredItem;
import software.bernie.geckolib.animation.AnimationState;

import java.util.List;
import java.util.Objects;

public class DriveDriverItem extends RiderDriverItem {


	public DriveDriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties.component(DataComponents.CONTAINER, ItemContainerContents.EMPTY));
		Unlimited_Textures=1;
	}

	@Override
	public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
		player.openMenu(new MenuProvider() {
			@Override
			public Component getDisplayName() {
				return Component.translatable("shift_car_holder.text");
			}

			@Override
			public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
				FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
				packetBuffer.writeBlockPos(player.blockPosition());
				packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
				return new ShiftCarHolderGuiMenu(id, inventory, packetBuffer, itemstack);
			}
		}, buf -> {
			buf.writeBlockPos(player.blockPosition());
			buf.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
		});
	}

	@Override
	public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
		Item belt= stack.getItem();
		if (belt!= DriveRiderItems.BANNO_DRIVER_BRONZE_DRIVE.get()&
				belt!= DriveRiderItems.BANNO_DRIVER_GORD_DRIVE.get()&
				belt!= DriveRiderItems.METRO_PD_DRIVER_HONOH.get()&
				belt!= DriveRiderItems.BRAIN_DRIVER.get()) {

			this.Has_basic_belt_info = false;
			Item formItem = getFormItem(stack, 1);
			Item formItem2 = getFormItem(stack, 2);

			if (formItem == DriveRiderItems.SHIFT_PROTO_SPEED.get() & Objects.equals(Rider, "drive"))
				tooltipComponents.add(Component.translatable("kamenridercraft.name.zero_drive"));
			else tooltipComponents.add(Component.translatable("kamenridercraft.name." + Rider));

			if (formItem == DriveRiderItems.SHIFT_PROTO_SPEED.get() & Objects.equals(Rider, "drive"))
				tooltipComponents.add(Component.translatable(formItem + ".zero_drive.form"));
			else tooltipComponents.add(Component.translatable(formItem.toString() + ".form"));

			if (formItem2 == DriveRiderItems.BASIC_TIRE.get())
				tooltipComponents.add(Component.translatable(formItem + ".tire.form"));
			else tooltipComponents.add(Component.translatable(formItem2.toString() + ".form"));
		}
		super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
	}
	@Override
	public String getUnlimitedTextures(ItemStack itemstack, LivingEntity livingEntity, String riderName, int num)
	{
		boolean fly = livingEntity instanceof Player player && (player.getAbilities().flying||player.isFallFlying());

		if (Objects.equals(riderName, "mach") & getFormItem(itemstack,2)== DriveRiderItems.BASIC_TIRE.get()&& getFormItem(itemstack,1)== DriveRiderItems.SHIFT_DEAD_HEAT_MACH.get()
		|| Objects.equals(riderName, "drive") & getFormItem(itemstack,2)== DriveRiderItems.BASIC_TIRE.get()&& getFormItem(itemstack,1)== DriveRiderItems.SHIFT_DEAD_HEAT.get()){
			if(livingEntity.getHealth()<7) {
				return "tire/dead_heat_burst_tire";
			}
		}else if (Objects.equals(riderName, "mach") & getFormItem(itemstack,2)== DriveRiderItems.SHIFT_MAX_FLARE.get()&& getFormItem(itemstack,1)!= DriveRiderItems.SHIFT_DEAD_HEAT_MACH.get()){
			return "tire/kourin_moerl_tire";
		}else if (Objects.equals(riderName, "mach") & getFormItem(itemstack,2)== DriveRiderItems.SHIFT_RUMBLE_DUMP.get()&& getFormItem(itemstack,1)!= DriveRiderItems.SHIFT_DEAD_HEAT_MACH.get()){
			return "tire/kourin_arabull_tire";
		}else if (Objects.equals(riderName, "mach") & getFormItem(itemstack,2)== DriveRiderItems.SHIFT_SPIN_MIXER.get()&& getFormItem(itemstack,1)!= DriveRiderItems.SHIFT_DEAD_HEAT_MACH.get()){
			return "tire/kourin_mazerl_tire";
		}
		return "tire/"+ getFormItem(itemstack,2).getFormName(fly);
	}

	@Override
	public  boolean getPartsForSlot(ItemStack itemstack,EquipmentSlot currentSlot,String  part) {
        return Objects.requireNonNull(currentSlot) == EquipmentSlot.HEAD;
    }
	public  boolean getGlowForSlot(ItemStack itemstack,EquipmentSlot currentSlot, LivingEntity livingEntity) {

		if (currentSlot== EquipmentSlot.FEET) {
			return getFormItem(itemstack, 1).getIsBeltGlowing();
		}
		if (isTransformed(livingEntity)){
			switch (currentSlot) {
				case HEAD, CHEST ->{
					return getFormItem(itemstack, 1).getIsGlowing();
				}
				case LEGS -> {
					return false;
				}
				default -> {}
			}
			return false;
		}
		return false;
	}

    @Override
    public void setCustomAnimations(RiderArmorItem an, long instanceId, AnimationState<RiderArmorItem> state) {

    }
}