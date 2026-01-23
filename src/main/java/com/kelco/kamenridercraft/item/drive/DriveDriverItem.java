package com.kelco.kamenridercraft.item.drive;

import com.kelco.kamenridercraft.item.BaseItems.RiderArmorItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Drive_Rider_Items;
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
		if (belt!=Drive_Rider_Items.BANNO_DRIVER_BRONZE_DRIVE.get()&
				belt!=Drive_Rider_Items.BANNO_DRIVER_GORD_DRIVE.get()&
				belt!=Drive_Rider_Items.METRO_PD_DRIVER_HONOH.get()&
				belt!=Drive_Rider_Items.BRAIN_DRIVER.get()) {

			this.Has_basic_belt_info = false;
			Item formItem = get_Form_Item(stack, 1);
			Item formItem2 = get_Form_Item(stack, 2);

			if (formItem == Drive_Rider_Items.SHIFT_PROTO_SPEED.get() & Objects.equals(Rider, "drive"))
				tooltipComponents.add(Component.translatable("kamenridercraft.name.zero_drive"));
			else tooltipComponents.add(Component.translatable("kamenridercraft.name." + Rider));

			if (formItem == Drive_Rider_Items.SHIFT_PROTO_SPEED.get() & Objects.equals(Rider, "drive"))
				tooltipComponents.add(Component.translatable(formItem + ".zero_drive.form"));
			else tooltipComponents.add(Component.translatable(formItem.toString() + ".form"));

			if (formItem2 == Drive_Rider_Items.BASIC_TIRE.get())
				tooltipComponents.add(Component.translatable(formItem + ".tire.form"));
			else tooltipComponents.add(Component.translatable(formItem2.toString() + ".form"));
		}
		super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
	}
	@Override
	public String getUnlimitedTextures(ItemStack itemstack, LivingEntity rider, String riderName, int num)
	{
		boolean fly = rider instanceof Player player && player.getAbilities().flying;

		if (Objects.equals(riderName, "mach") &get_Form_Item(itemstack,2)== Drive_Rider_Items.BASIC_TIRE.get()&&get_Form_Item(itemstack,1)== Drive_Rider_Items.SHIFT_DEAD_HEAT_MACH.get()
		|| Objects.equals(riderName, "drive") &get_Form_Item(itemstack,2)== Drive_Rider_Items.BASIC_TIRE.get()&&get_Form_Item(itemstack,1)== Drive_Rider_Items.SHIFT_DEAD_HEAT.get()){
			if(rider.getHealth()<7) {
				return "tire/dead_heat_burst_tire";
			}
		}else if (Objects.equals(riderName, "mach") &get_Form_Item(itemstack,2)== Drive_Rider_Items.SHIFT_MAX_FLARE.get()&&get_Form_Item(itemstack,1)!= Drive_Rider_Items.SHIFT_DEAD_HEAT_MACH.get()){
			return "tire/kourin_moerl_tire";
		}else if (Objects.equals(riderName, "mach") &get_Form_Item(itemstack,2)== Drive_Rider_Items.SHIFT_RUMBLE_DUMP.get()&&get_Form_Item(itemstack,1)!= Drive_Rider_Items.SHIFT_DEAD_HEAT_MACH.get()){
			return "tire/kourin_arabull_tire";
		}else if (Objects.equals(riderName, "mach") &get_Form_Item(itemstack,2)== Drive_Rider_Items.SHIFT_SPIN_MIXER.get()&&get_Form_Item(itemstack,1)!= Drive_Rider_Items.SHIFT_DEAD_HEAT_MACH.get()){
			return "tire/kourin_mazerl_tire";
		}
		return "tire/"+get_Form_Item(itemstack,2).getFormName(fly);
	}

	@Override
	public  boolean getPartsForSlot(ItemStack itemstack,EquipmentSlot currentSlot,String  part) {
        return Objects.requireNonNull(currentSlot) == EquipmentSlot.HEAD;
    }
	public  boolean getGlowForSlot(ItemStack itemstack,EquipmentSlot currentSlot, LivingEntity livingEntity) {

		if (currentSlot== EquipmentSlot.FEET) {
			return get_Form_Item(itemstack, 1).get_Is_Belt_Glowing();
		}
		if (isTransformed(livingEntity)){
			switch (currentSlot) {
				case HEAD, CHEST ->{
					return get_Form_Item(itemstack, 1).get_Is_Glowing();
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