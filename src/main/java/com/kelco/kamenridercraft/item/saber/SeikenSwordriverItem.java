package com.kelco.kamenridercraft.item.saber;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.BaseItems.RiderArmorItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Fourze_Rider_Items;
import com.kelco.kamenridercraft.item.Saber_Rider_Items;
import com.kelco.kamenridercraft.item.W_Rider_Items;
import com.kelco.kamenridercraft.world.inventory.HissatsuHolderGuiMenu;
import com.kelco.kamenridercraft.world.inventory.VistampHolderGuiMenu;
import io.netty.buffer.Unpooled;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Entity;
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
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.List;

public class SeikenSwordriverItem extends RiderDriverItem {



    public SeikenSwordriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties)
    {
        super(material, rider, baseFormItem, head, torso, legs, properties.component(DataComponents.CONTAINER, ItemContainerContents.EMPTY));
        Unlimited_Textures=4;
        Has_Inventory=true;
    }

        @Override
        public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
            player.openMenu(new MenuProvider() {
                @Override
                public Component getDisplayName() {
                    return Component.translatable("hissatsuholder.text");
                }

                @Override
                public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                    FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
                    packetBuffer.writeBlockPos(player.blockPosition());
                    packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
                    return new HissatsuHolderGuiMenu(id, inventory, packetBuffer,itemstack);
                }
            });
        }


    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {

        Has_basic_belt_info=false;


        Item formItem = this.get_Form_Item(stack, 1);
        Item formItem2 = this.get_Form_Item(stack, 2);
        Item formItem3 = this.get_Form_Item(stack, 3);

        if(formItem==Saber_Rider_Items.BRAVE_DRAGON_WONDER_RIDE_BOOK_XROSS.get()) {
            tooltipComponents.add(Component.translatable("kamenridercraft.name."+Rider+"_xross"));

            if (formItem2==Saber_Rider_Items.SABER_BLANK_2.get()&&formItem3==Saber_Rider_Items.SABER_BLANK_3.get()) tooltipComponents.add(Component.translatable(formItem.toString() + ".form"));
            else if (formItem2==Saber_Rider_Items.LION_SENKI_WONDER_RIDE_BOOK_XROSS.get()&&formItem3==Saber_Rider_Items.LAMP_DO_ALNGINA_WONDER_RIDE_BOOK_XROSS.get()) tooltipComponents.add(Component.translatable(formItem.toString() + ".form_featuring"));
            else if (formItem2==Saber_Rider_Items.STORM_EAGLE_WONDER_RIDE_BOOK_XROSS.get()&&formItem3==Saber_Rider_Items.SAIYUU_JOURNEY_WONDER_RIDE_BOOK_XROSS.get()) tooltipComponents.add(Component.translatable(formItem.toString() + ".form_crimson"));
            else {
                tooltipComponents.add(Component.translatable(formItem.toString() + ".form_hybrid"));
                if (formItem2!=Saber_Rider_Items.SABER_BLANK_2.get()) tooltipComponents.add(Component.translatable(formItem2.toString() + ".form"));
                if (formItem3!=Saber_Rider_Items.SABER_BLANK_3.get()) tooltipComponents.add(Component.translatable(formItem3.toString() + ".form"));
            }
        } else {
            tooltipComponents.add(Component.translatable("kamenridercraft.name."+Rider));
            if (stack.getItem()==Saber_Rider_Items.SEIKEN_SWORDRIVER_DRIVER_SABER.get()) {
                if (formItem==Saber_Rider_Items.BRAVE_DRAGON_WONDER_RIDE_BOOK.get()) {
                    if (formItem2==Saber_Rider_Items.SABER_BLANK_2.get()&&formItem3==Saber_Rider_Items.SABER_BLANK_3.get()) tooltipComponents.add(Component.translatable(formItem.toString() + ".form_basic"));
                    else if (formItem2==Saber_Rider_Items.SABER_BLANK_2.get()&&formItem3==Saber_Rider_Items.SAIYUU_JOURNEY_WONDER_RIDE_BOOK.get()) tooltipComponents.add(Component.translatable(formItem.toString() + ".form_saiyuu"));
                    else if (formItem2==Saber_Rider_Items.STORM_EAGLE_WONDER_RIDE_BOOK.get()&&formItem3==Saber_Rider_Items.SAIYUU_JOURNEY_WONDER_RIDE_BOOK.get()) tooltipComponents.add(Component.translatable(formItem.toString() + ".form_combo"));
                    else tooltipComponents.add(Component.literal(Component.translatable("kamenridercraft.name.form").getString() + " "
                    + Component.translatable(formItem.toString() + ".form").getString()
                    + (formItem2!=Saber_Rider_Items.SABER_BLANK_2.get() ? " " + Component.translatable(formItem2.toString() + ".form").getString() : "")
                    + (formItem3!=Saber_Rider_Items.SABER_BLANK_3.get() ? " " + Component.translatable(formItem3.toString() + ".form").getString() : "")));
                } else tooltipComponents.add(Component.translatable(formItem.toString() + ".form"));
            } else if (stack.getItem()==Saber_Rider_Items.SEIKEN_SWORDRIVER_DRIVER_BLADES.get()) {
                if (formItem2==Saber_Rider_Items.LION_SENKI_WONDER_RIDE_BOOK.get()) {
                    if (formItem==Saber_Rider_Items.SABER_BLANK_1.get()&&formItem3==Saber_Rider_Items.SABER_BLANK_3.get()) tooltipComponents.add(Component.translatable(formItem2.toString() + ".form_basic"));
                    else if (formItem==Saber_Rider_Items.SABER_BLANK_1.get()&&formItem3==Saber_Rider_Items.PETER_FANTASISTA_WONDER_RIDE_BOOK.get()) tooltipComponents.add(Component.translatable(formItem2.toString() + ".form_peter"));
                    else if (formItem==Saber_Rider_Items.TENKUU_NO_PEGASUS_WONDER_RIDE_BOOK.get()&&formItem3==Saber_Rider_Items.SABER_BLANK_3.get()) tooltipComponents.add(Component.translatable(formItem2.toString() + ".form_pegasus"));
                    else if (formItem==Saber_Rider_Items.TENKUU_NO_PEGASUS_WONDER_RIDE_BOOK.get()&&formItem3==Saber_Rider_Items.PETER_FANTASISTA_WONDER_RIDE_BOOK.get()) tooltipComponents.add(Component.translatable(formItem2.toString() + ".form_combo"));
                    else tooltipComponents.add(Component.literal(Component.translatable("kamenridercraft.name.form").getString() + " "
                    + (formItem!=Saber_Rider_Items.SABER_BLANK_1.get() ? Component.translatable(formItem.toString() + ".form").getString() + " " : "")
                    + Component.translatable(formItem2.toString() + ".form").getString()
                    + (formItem3!=Saber_Rider_Items.SABER_BLANK_3.get() ? " " + Component.translatable(formItem3.toString() + ".form").getString() : "")));
                } else tooltipComponents.add(Component.translatable(formItem2.toString() + ".form"));
            } else if (stack.getItem()==Saber_Rider_Items.SEIKEN_SWORDRIVER_DRIVER_ESPADA.get()) {
                if (formItem3==Saber_Rider_Items.LAMP_DO_ALNGINA_WONDER_RIDE_BOOK.get()) {
                    if (formItem==Saber_Rider_Items.SABER_BLANK_1.get()&&formItem2==Saber_Rider_Items.SABER_BLANK_2.get()) tooltipComponents.add(Component.translatable(formItem3.toString() + ".form_basic"));
                    else if (formItem==Saber_Rider_Items.SABER_BLANK_1.get()&&formItem2==Saber_Rider_Items.NEEDLE_HEDGEHOG_WONDER_RIDE_BOOK.get()) tooltipComponents.add(Component.translatable(formItem3.toString() + ".form_hedgehog"));
                    else if (formItem==Saber_Rider_Items.TRI_CERBERUS_WONDER_RIDE_BOOK.get()&&formItem2==Saber_Rider_Items.SABER_BLANK_2.get()) tooltipComponents.add(Component.translatable(formItem3.toString() + ".form_cerberus"));
                    else if (formItem==Saber_Rider_Items.TRI_CERBERUS_WONDER_RIDE_BOOK.get()&&formItem2==Saber_Rider_Items.NEEDLE_HEDGEHOG_WONDER_RIDE_BOOK.get()) tooltipComponents.add(Component.translatable(formItem3.toString() + ".form_combo"));
                    else tooltipComponents.add(Component.literal(Component.translatable("kamenridercraft.name.form").getString() + " "
                    + (formItem!=Saber_Rider_Items.SABER_BLANK_1.get() ? Component.translatable(formItem.toString() + ".form").getString() + " " : "")
                    + (formItem2!=Saber_Rider_Items.SABER_BLANK_2.get() ? Component.translatable(formItem2.toString() + ".form").getString() + " " : "")
                    + Component.translatable(formItem3.toString() + ".form").getString()));
                } else tooltipComponents.add(Component.translatable(formItem3.toString() + ".form"));
            }
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    @Override
    public String getUnlimitedTextures(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName, int num)
    {
        boolean fly = rider instanceof Player player && player.getAbilities().flying;
        //return riderName + get_Form_Item(itemstack, 4).getFormName(fly);v8

        if (get_Form_Item(itemstack,1).get_Stored_num()==2) return"blank";
        if(num==2) return get_Form_Item(itemstack,1).getFormName(fly);
        else if(num==3) return get_Form_Item(itemstack,2).getFormName(fly);
        else if(num==4) return get_Form_Item(itemstack,3).getFormName(fly);
        else return riderName + "_base";
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        super.inventoryTick(stack,level,entity,slotId,isSelected);

    }
    @Override
    public void Extra_set_Form_Item(ItemStack belt, Item ITEM, int SLOT, CompoundTag tag)
    {
        if (belt.getItem()==Saber_Rider_Items.SEIKEN_SWORDRIVER_DRIVER_SABER.get()){
            if (get_Form_Item(belt, 1).get_Stored_num()==2 && (get_Form_Item(belt, 2)!= Saber_Rider_Items.SABER_BLANK_2.get() || get_Form_Item(belt, 3)!= Saber_Rider_Items.SABER_BLANK_3.get())) {
                set_Form_Item(belt, Saber_Rider_Items.BRAVE_DRAGON_WONDER_RIDE_BOOK.asItem(), 1);
            } else if (get_Form_Item(belt, 1).get_Stored_num()==3 && ((get_Form_Item(belt, 2)!= Saber_Rider_Items.SABER_BLANK_2.get() && get_Form_Item(belt, 2)!= Saber_Rider_Items.LION_SENKI_WONDER_RIDE_BOOK_XROSS.get() && get_Form_Item(belt, 2)!= Saber_Rider_Items.STORM_EAGLE_WONDER_RIDE_BOOK_XROSS.get())
            || (get_Form_Item(belt, 3)!= Saber_Rider_Items.SABER_BLANK_3.get() && get_Form_Item(belt, 3)!= Saber_Rider_Items.LAMP_DO_ALNGINA_WONDER_RIDE_BOOK_XROSS.get() && get_Form_Item(belt, 3)!= Saber_Rider_Items.SAIYUU_JOURNEY_WONDER_RIDE_BOOK_XROSS.get()))) {
                set_Form_Item(belt, Saber_Rider_Items.BRAVE_DRAGON_WONDER_RIDE_BOOK.asItem(), 1);
            }
        } else if (belt.getItem()==Saber_Rider_Items.SEIKEN_SWORDRIVER_DRIVER_BLADES.get()){
            if (get_Form_Item(belt, 2).get_Stored_num()==2 && (get_Form_Item(belt, 1)!= Saber_Rider_Items.SABER_BLANK_1.get() ||get_Form_Item(belt, 3)!= Saber_Rider_Items.SABER_BLANK_3.get())) {
                set_Form_Item(belt, Saber_Rider_Items.LION_SENKI_WONDER_RIDE_BOOK.asItem(), 2);
            }
        } else if (belt.getItem()==Saber_Rider_Items.SEIKEN_SWORDRIVER_DRIVER_ESPADA.get()){
            if (get_Form_Item(belt, 3).get_Stored_num()==2 && (get_Form_Item(belt, 1)!= Saber_Rider_Items.SABER_BLANK_1.get() || get_Form_Item(belt, 2)!= Saber_Rider_Items.SABER_BLANK_2.get())) {
                set_Form_Item(belt, Saber_Rider_Items.LAMP_DO_ALNGINA_WONDER_RIDE_BOOK.asItem(), 3);
            }
        }

    }


    public ResourceLocation getModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
        if (itemstack.getItem()==Saber_Rider_Items.SEIKEN_SWORDRIVER_DRIVER_SABER.get() && get_Form_Item(itemstack, 1) == Saber_Rider_Items.WONDER_ALMIGHTY_WONDER_RIDE_BOOK.get()) return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/saber_wonder_almighty.geo.json");
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/rider_plusbelt.geo.json");
    }


    @Override
    public String GET_TEXT(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider,String riderName)
    {
        boolean fly = rider instanceof Player player && player.getAbilities().flying;
        if (equipmentSlot == EquipmentSlot.FEET) {
            return "belts/"+get_Form_Item(itemstack,1).getBeltTex();
        }
        if (equipmentSlot == EquipmentSlot.HEAD) return get_Form_Item(itemstack,1).getFormName(fly);
        else if (equipmentSlot == EquipmentSlot.CHEST) return get_Form_Item(itemstack,2).getFormName(fly);
        else if (equipmentSlot == EquipmentSlot.LEGS) return get_Form_Item(itemstack,3).getFormName(fly);
        else return get_Form_Item(itemstack,3).getFormName(fly);
    }


    @Override
    public  boolean getPartsForSlot(ItemStack itemstack,EquipmentSlot currentSlot,String  part) {

        switch (currentSlot) {
            case HEAD,LEGS,CHEST ->{
                return true;

            }

            default -> {}
        }
        return false;
    }
}