package com.kelco.kamenridercraft.item.BaseItems;

import java.util.function.Consumer;
import java.util.ArrayList;
import java.util.List;

import com.kelco.kamenridercraft.item.BaseItems.RiderArmorItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderFormChangeItem;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.component.PatchedDataComponentMap;
import net.minecraft.world.item.component.CustomData;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.NotNull;

import com.google.common.collect.Lists;
import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.client.RiderArmorRenderer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biomes;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;

import javax.annotation.Nullable;



public class RiderDriverItem extends RiderArmorItem {


    public String armorNamePrefix;
    public RiderFormChangeItem Base_Form_Item;
    public RiderFormChangeItem Armor_Form_Item;
    protected ArrayList<RiderFormChangeItem> Extra_Base_Form_Item;
    public String Rider;
    public Item HEAD;
    public Item TORSO;
    public Item LEGS;
    public int Num_Base_Form_Item = 1;
    public String BELT_TEXT;



    public RiderDriverItem (Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties)
    {
        super(material, ArmorItem.Type.BOOTS, properties);
        Rider=rider;
        Base_Form_Item=((RiderFormChangeItem)baseFormItem.get());
        Armor_Form_Item=((RiderFormChangeItem)baseFormItem.get());
        HEAD=head.get();
        TORSO=torso.get();
        LEGS=legs.get();

    }

    public RiderDriverItem (Holder<ArmorMaterial> material, String rider,DeferredItem<Item> baseFormItem,DeferredItem<Item> armorFormItem,DeferredItem<Item> head,DeferredItem<Item>torso,DeferredItem<Item> legs, Properties properties)
    {
        super(material, ArmorItem.Type.BOOTS, properties);

        Rider=rider;
        Base_Form_Item=((RiderFormChangeItem)baseFormItem.get());
        Armor_Form_Item=((RiderFormChangeItem)armorFormItem.get());
        HEAD=head.get();
        TORSO=torso.get();
        LEGS=legs.get();

    }
/**
    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player)
    {

       if (stack.getTag().getBoolean("Update_form"))OnformChange(stack,player);

        if (player.getItemBySlot(EquipmentSlot.LEGS).getItem() == LEGS){
            if (player.getItemBySlot(EquipmentSlot.CHEST).getItem() == TORSO){
                if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == HEAD){
                    if (player.getItemBySlot(EquipmentSlot.FEET).getItem() == this){
                        for (int n = 0; n < Num_Base_Form_Item; n++)
                        {
                            List<MobEffectInstance> potionEffectList = get_Form_Item(player.getItemBySlot(EquipmentSlot.FEET),n+1).getPotionEffectList();
                            for (int i = 0; i < potionEffectList.size(); i++)
                            {
                                player.addEffect(new MobEffectInstance(potionEffectList.get(i).getEffect(),potionEffectList.get(i).getDuration(),potionEffectList.get(i).getAmplifier(),true,false));
                            }
                        }
                    }
                }
            }
        }

    }

    public void OnformChange(ItemStack itemstack, Player player) {
        player.setInvisible(false);
        itemstack.getTag().putBoolean("Update_form", false);
    }

**/
    public RiderDriverItem Add_Extra_Base_Form_Items(DeferredItem<Item> item) {
        Extra_Base_Form_Item= Lists.newArrayList((RiderFormChangeItem)item.get());
        Num_Base_Form_Item=2;
        return this;
    }

    public RiderDriverItem Override_belt_text(String belt) {
        BELT_TEXT = belt;
        return this;
    }

    public RiderDriverItem Add_Extra_Base_Form_Items(DeferredItem<Item> item,DeferredItem<Item> item2) {
        Extra_Base_Form_Item= Lists.newArrayList((RiderFormChangeItem)item.get(),(RiderFormChangeItem)item2.get());
        Num_Base_Form_Item=3;
        return this;
    }

    public RiderDriverItem Add_Extra_Base_Form_Items(DeferredItem<Item> item,DeferredItem<Item> item2,DeferredItem<Item> item3) {
        Extra_Base_Form_Item= Lists.newArrayList((RiderFormChangeItem)item.get(),(RiderFormChangeItem)item2.get(),(RiderFormChangeItem)item3.get());
        Num_Base_Form_Item=4;
        return this;
    }


    @Override
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider() {
            private RiderArmorRenderer renderer;

            @Override
            public <T extends LivingEntity> HumanoidModel<?> getGeoArmorRenderer(@Nullable T livingEntity, ItemStack itemStack, @Nullable EquipmentSlot equipmentSlot, @Nullable HumanoidModel<T> original) {
                if(this.renderer == null) this.renderer = new RiderArmorRenderer(livingEntity, equipmentSlot);

                this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return this.renderer;
            }
        });
    }

    public String GET_TEXT(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName)
    {

        boolean fly = rider instanceof Player player && player.getAbilities().flying;

        if (equipmentSlot == EquipmentSlot.FEET) {
            String belt = ((RiderDriverItem)itemstack.getItem()).BELT_TEXT;
            if (((RiderDriverItem)itemstack.getItem()).BELT_TEXT==null) {
                belt = get_Form_Item(itemstack,1).getBeltTex();
            }
            return "belts/"+belt;
        }

        else return get_Form_Item(itemstack,1).getRiderName(riderName)+get_Form_Item(itemstack,1).getFormName(fly);

    }


    public ResourceLocation getBeltModelResource(ItemStack itemstack,RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, get_Form_Item(itemstack, 1).get_Belt_Model());
    }


    public ResourceLocation getModelResource(ItemStack itemstack,RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
        if (get_Form_Item(itemstack, 1).HasWingsIfFlying() && rider instanceof Player player && player.getAbilities().flying == true){
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, get_Form_Item(itemstack, 1).get_FlyingModel());
        }else return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, get_Form_Item(itemstack, 1).get_Model());
    }

    public ResourceLocation getAnimationResource(ItemStack itemstack,RiderArmorItem animatable, EquipmentSlot slot) {

        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, get_Form_Item(itemstack, 1).get_Animation());

    }


    public static void reset_Form_Item(ItemStack  itemstack)
    {

        if(itemstack.getItem() instanceof RiderDriverItem belt){

            if (belt.Num_Base_Form_Item!=1) {
                for (int n = 0; n < belt.Num_Base_Form_Item-1; n++)
                {
                  //  set_Form_Item( itemstack,belt.Extra_Base_Form_Item.get(n),2+n);
                }
            }
           // set_Form_Item( itemstack,belt.Base_Form_Item,1);

        }
    }


/**
    public static void set_Form_Item(ItemStack itemstack, Item ITEM,int SLOT)
    {
        if (!itemstack.getComponents().isEmpty())
        {
            //(DataComponents.CUSTOM_DATA,new CompoundTag())
            itemstack.get(DataComponents.POTION_CONTENTS);
            //itemstack.setTag(new CompoundTag());
        }
        if (itemstack.getItem() instanceof RiderDriverItem) {
            ((RiderDriverItem)itemstack.getItem()).Extra_set_Form_Item(itemstack, ITEM, SLOT);
            itemstack.getTag().putString("slot_tex"+SLOT, ITEM.toString());
            itemstack.getTag().putInt("slot"+SLOT, Item.getId(ITEM));
            itemstack.getTag().putBoolean("Update_form", true);
        }
    }
**/



    public void Extra_set_Form_Item(ItemStack itemstack, Item ITEM,int SLOT)
    {
    }


    public  boolean getGlowForSlot(ItemStack itemstack,EquipmentSlot currentSlot, LivingEntity livingEntity) {

        if (currentSlot== EquipmentSlot.FEET) {
            return get_Form_Item(itemstack, 1).get_Is_Belt_Glowing();
        }
        if (livingEntity.getItemBySlot(EquipmentSlot.LEGS).getItem() == LEGS){
            if (livingEntity.getItemBySlot(EquipmentSlot.CHEST).getItem() == TORSO){
                if (livingEntity.getItemBySlot(EquipmentSlot.HEAD).getItem() == HEAD){
                    switch (currentSlot) {
                        case HEAD ->{
                            return get_Form_Item(itemstack, 1).get_Is_Glowing();
                        }
                        case CHEST -> {
                            return get_Form_Item(itemstack, 1).get_Is_Glowing();
                        }
                        case LEGS -> {
                            return get_Form_Item(itemstack, 1).get_Is_Glowing();
                        }
                        default -> {}
                    }
                    return false;
                }
            }

        }
        return false;
    }

    public  boolean getPartsForSlot(ItemStack itemstack,EquipmentSlot currentSlot,String  part) {

        switch (currentSlot) {
            case HEAD ->{
                if (part =="head") return true;
            }
            case CHEST -> {
                if (part =="body") return true;
                if (part =="rightArm") return true;
                if (part =="leftArm") return true;
            }
            case LEGS -> {

                if (part =="rightLeg") return true;
                if (part =="leftLeg") return true;
            }
            default -> {}
        }
        return false;
    }




    public static RiderFormChangeItem get_Form_Item(ItemStack itemstack,int SLOT)
    {
        //ResourceLocation Used_Form_Item = new ResourceLocation(KamenRiderCraftCore.MOD_ID, itemstack.getTag().getString("slot_tex"+SLOT));
        RiderDriverItem belt = (RiderDriverItem)itemstack.getItem();
        RiderFormChangeItem Base_Form_Item = belt.Base_Form_Item;

        if (SLOT == 2) {
            Base_Form_Item =belt.Extra_Base_Form_Item.get(0);
        }else if (SLOT == 3) {
            Base_Form_Item =belt.Extra_Base_Form_Item.get(1);
        }else if (SLOT == 4) {
            Base_Form_Item =belt.Extra_Base_Form_Item.get(2);
        }
/**
        if (!itemstack.hasTag())
        {
            return  Base_Form_Item;
        }else if (ForgeRegistries.ITEMS.getValue(Used_Form_Item) instanceof RiderFormChangeItem){
            return (RiderFormChangeItem) ForgeRegistries.ITEMS.getValue(Used_Form_Item);
        }else{
            **/
            return Base_Form_Item;
        }
    }




