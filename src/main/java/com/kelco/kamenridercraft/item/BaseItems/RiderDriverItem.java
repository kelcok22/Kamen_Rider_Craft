package com.kelco.kamenridercraft.item.BaseItems;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;


import com.kelco.kamenridercraft.effect.Effect_core;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.component.ItemContainerContents;
import net.neoforged.neoforge.registries.DeferredItem;

import com.google.common.collect.Lists;
import com.kelco.kamenridercraft.KamenRiderCraftCore;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;


public class RiderDriverItem extends RiderArmorItem {

    public RiderFormChangeItem Base_Form_Item;
    public RiderFormChangeItem Armor_Form_Item;
    protected ArrayList<RiderFormChangeItem> Extra_Base_Form_Item;
    public String Rider;
    public Item HEAD;
    public Item TORSO;
    public Item LEGS;
    public int Num_Base_Form_Item = 1;
    public String BELT_TEXT;
    private Boolean A1 = false;

    public int Unlimited_Textures = 0;

    public Boolean Has_Inventory = false;

    public Boolean Has_basic_belt_info = true;
    public Boolean Show_belt_form_info = true;

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

    public boolean isTransformed(LivingEntity player) {
        if (!(player.getItemBySlot(EquipmentSlot.FEET).getItem()instanceof RiderDriverItem))return false;
        return player.getItemBySlot(EquipmentSlot.HEAD).getItem()==HEAD.asItem()
        &&player.getItemBySlot(EquipmentSlot.CHEST).getItem()==TORSO.asItem()
        &&player.getItemBySlot(EquipmentSlot.LEGS).getItem()==LEGS.asItem()
        &&player.getItemBySlot(EquipmentSlot.FEET).getItem()==this;
    }

    public static boolean isTransforming(LivingEntity player) {
        if (!(player.getItemBySlot(EquipmentSlot.FEET).getItem()instanceof RiderDriverItem))return false;
        else if (player.getItemBySlot(EquipmentSlot.FEET).has(DataComponents.CUSTOM_DATA)) {
            CompoundTag tag = player.getItemBySlot(EquipmentSlot.FEET).get(DataComponents.CUSTOM_DATA).getUnsafe();
                return tag.getDouble("is_transforming")!=0;
        }
        return false;
    }

    public static double getRenderType(ItemStack stack) {
        double form_double = 1;
        RiderFormChangeItem form = get_Form_Item(stack, 1);
        if (form.get_Show_Face())form_double=2;
        if (form.get_Show_under())form_double=3;
        return form_double ;
    }

    public void beltTick(ItemStack stack, Level level, LivingEntity player, int slotId) {
        if (stack.has(DataComponents.CUSTOM_DATA)) {
            CompoundTag tag = stack.get(DataComponents.CUSTOM_DATA).getUnsafe();
            if (tag.getBoolean("Update_form")&&slotId==36) OnformChange(stack, player, tag);
            if (!isTransformed(player)||slotId!=36) tag.putBoolean("Update_form", true);
            if (isTransformed(player)) tag.putDouble("render_type", getRenderType(stack));
            if (!isTransformed(player)) tag.putDouble("render_type", 0);
            if (tag.getDouble("is_transforming")!=0) tag.putDouble("is_transforming", tag.getDouble("is_transforming")-1);
            if (tag.getDouble("is_transforming")<0) tag.putDouble("is_transforming", 0);

            if (tag.getDouble("use_ability")!=0) tag.putDouble("use_ability", tag.getDouble("use_ability")-1);
            if (tag.getDouble("use_ability")<0) tag.putDouble("use_ability", 0);

            //if (!level.isClientSide)player.sendSystemMessage(Component.literal("SlotID=" + slotId));

        }else{
            set_Upadete_Form(stack);
        }
    }


    public void giveEffects(LivingEntity player) {

        if (isTransformed(player)) {
                for (int n = 0; n < Num_Base_Form_Item; n++) {
                    RiderFormChangeItem form = get_Form_Item(player.getItemBySlot(EquipmentSlot.FEET), n + 1);
                    List<MobEffectInstance> potionEffectList = form.getPotionEffectList();
                    for (MobEffectInstance effect : potionEffectList) {
                        if (effect.getEffect() != MobEffects.DAMAGE_BOOST&
                                effect.getEffect() != MobEffects.DIG_SPEED&
                                effect.getEffect() != MobEffects.REGENERATION&
                                effect.getEffect() != MobEffects.DAMAGE_RESISTANCE&
                                effect.getEffect() != MobEffects.MOVEMENT_SPEED&
                                effect.getEffect() != Effect_core.NOTE&
                                effect.getEffect() != Effect_core.SLASH&
                                effect.getEffect() != Effect_core.PUNCH&
                                effect.getEffect() != Effect_core.GREEED&
                                effect.getEffect() != Effect_core.BUGSTER
                                ||player instanceof Player) {
                            player.addEffect(new MobEffectInstance(effect.getEffect(), effect.getDuration(), effect.getAmplifier(), true, false));
                        }
                    }
                }
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (entity instanceof LivingEntity player) {
            beltTick(stack,level,player,slotId);
          giveEffects(player);
        }
    }

    public void OnformChange(ItemStack itemstack, LivingEntity player,CompoundTag  tag) {
        if(isTransformed(player)) {
            OnTransformation(itemstack,player);
            Consumer<CompoundTag> data = form -> {
                form.putBoolean("Update_form", false);
                form.putDouble("is_transforming",120);
            };
            CustomData.update(DataComponents.CUSTOM_DATA, itemstack, data);
        }

    }
    /*
    public void OnTransform(ItemStack itemstack, LivingEntity player) {
        if (player.getItemBySlot(EquipmentSlot.FEET)==itemstack) OnTransformation(itemstack, player);
    }
    */
    public void OnTransformation(ItemStack itemstack, LivingEntity player) {
        if(isTransformed(player) && !player.level().isClientSide()) {
            for (int n = 0; n < Num_Base_Form_Item; n++) {
                RiderFormChangeItem form = get_Form_Item(itemstack, n + 1);
                form.OnTransformation(itemstack, player);
            }
        }
    }



    public void OnRiderKickHit(ItemStack itemstack, LivingEntity pLivingEntity, LivingEntity enemy) {
        RiderFormChangeItem formitem = get_Form_Item(itemstack,1);
        formitem.OnRiderKickHit(itemstack,pLivingEntity,enemy);

        DamageSource damageSource = new DamageSource(
                pLivingEntity.registryAccess().lookupOrThrow(Registries.DAMAGE_TYPE).getOrThrow(DamageTypes.PLAYER_ATTACK),pLivingEntity,pLivingEntity,pLivingEntity.position());
        float at = (float) (pLivingEntity.getAttributes().getValue(Attributes.ATTACK_DAMAGE)+pLivingEntity.fallDistance);
        enemy.hurt(damageSource, at);
        //pLivingEntity.sendSystemMessage(Component.literal("power="+at));
        pLivingEntity.fallDistance = 0.0f;
        if(!pLivingEntity.level().isClientSide()) {
            ((ServerLevel) pLivingEntity.level()).sendParticles(ParticleTypes.EXPLOSION,
                    pLivingEntity.getX(), pLivingEntity.getY() + 1.0,
                    pLivingEntity.getZ(), 1, 0, 0, 0, 1);
            ((ServerLevel) pLivingEntity.level()).sendParticles(ParticleTypes.FLAME,
                    pLivingEntity.getX(), pLivingEntity.getY() + 1.0,
                    pLivingEntity.getZ(), 500, 0, 0, 0, 1);
        }
    }



    public RiderDriverItem Add_Extra_Base_Form_Items(DeferredItem<Item> item) {
        Extra_Base_Form_Item= Lists.newArrayList((RiderFormChangeItem)item.get());
        Num_Base_Form_Item=2;
        return this;
    }

    public RiderDriverItem Dont_show_belt_form_info() {
        Show_belt_form_info=false;
        return this;
    }

    public RiderDriverItem Has_Inventory_Gui() {
        Has_Inventory=true;
        return this;
    }

    public RiderDriverItem Override_belt_text(String belt) {
        BELT_TEXT = belt;
        return this;
    }

    public RiderDriverItem IsA1() {
        A1=true;
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
    public RiderDriverItem Add_Extra_Base_Form_Items(DeferredItem<Item> item,DeferredItem<Item> item2,DeferredItem<Item> item3,DeferredItem<Item> item4) {
        Extra_Base_Form_Item= Lists.newArrayList((RiderFormChangeItem)item.get(),(RiderFormChangeItem)item2.get(),(RiderFormChangeItem)item3.get(),(RiderFormChangeItem)item4.get());
        Num_Base_Form_Item=5;
        return this;
    }


    public String GET_TEXT(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName)
    {

        boolean fly = rider instanceof Player player && player.getAbilities().flying;

        if (equipmentSlot == EquipmentSlot.FEET) {
            String belt = ((RiderDriverItem)itemstack.getItem()).BELT_TEXT;
            if (((RiderDriverItem)itemstack.getItem()).BELT_TEXT==null||get_Form_Item(itemstack,1).getIgnoreOverrideBeltText()) {
                belt = get_Form_Item(itemstack,1).getBeltTex();
            }
            return "belts/"+belt;
        }

        else return get_Form_Item(itemstack,1).getRiderName(riderName)+get_Form_Item(itemstack,1).getFormName(fly);

    }

    public String getUnlimitedTextures(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName ,int num)
    {
        return "blank";
    }

    public ResourceLocation getBeltModelResource(ItemStack itemstack,RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, get_Form_Item(itemstack, 1).get_Belt_Model());
    }


    public ResourceLocation getModelResource(ItemStack itemstack,RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
        if (get_Form_Item(itemstack, 1).HasWingsIfFlying() && rider instanceof Player player && player.getAbilities().flying){
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/"+get_Form_Item(itemstack, 1).get_FlyingModel(this.Rider));
        }
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/"+get_Form_Item(itemstack, 1).get_Model(this.Rider));
    }

    public ResourceLocation getAnimationResource(ItemStack itemstack,RiderArmorItem animatable, EquipmentSlot slot) {

        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, get_Form_Item(itemstack, 1).get_Animation(this.Rider));

    }


    public static void reset_Form_Item(ItemStack  itemstack)
    {

        if(itemstack.getItem() instanceof RiderDriverItem belt){

            if (belt.Num_Base_Form_Item!=1) {
                for (int n = 0; n < belt.Num_Base_Form_Item-1; n++)
                {
                   set_Form_Item( itemstack,belt.Extra_Base_Form_Item.get(n),2+n);
                }
            }
           set_Form_Item( itemstack,belt.Base_Form_Item,1);

        }
    }

    public static void set_Upadete_Form(ItemStack itemstack)
    {
        if (!itemstack.has(DataComponents.CUSTOM_DATA)) {
            itemstack.set(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
        }
        if (itemstack.getItem() instanceof RiderDriverItem) {
            Consumer<CompoundTag> data = form -> {
                form.putBoolean("Update_form", true);
                form.putDouble("render_type", getRenderType(itemstack));
            };
            CustomData.update(DataComponents.CUSTOM_DATA, itemstack, data);
        }
    }

    public static void set_Use_Ability(ItemStack itemstack)
    {
        if (!itemstack.has(DataComponents.CUSTOM_DATA)) {
            itemstack.set(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
        }
        if (itemstack.getItem() instanceof RiderDriverItem) {
            Consumer<CompoundTag> data = form -> form.putDouble("use_ability", 5);
            CustomData.update(DataComponents.CUSTOM_DATA, itemstack, data);
        }
    }


    public static void set_Form_Item(ItemStack itemstack, Item ITEM,int SLOT)
    {
        if (!itemstack.has(DataComponents.CUSTOM_DATA)) itemstack.set(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
        if (itemstack.getItem() instanceof RiderDriverItem driver) {
            Consumer<CompoundTag> data = form -> {
                if (!form.getString("slot_tex" + SLOT).equals(ITEM.toString())) {
                    form.putString("slot_tex" + SLOT, ITEM.toString());
                    form.putBoolean("Update_form", true);
                    form.putDouble("render_type", getRenderType(itemstack));
                }
            };

            CustomData.update(DataComponents.CUSTOM_DATA, itemstack, data);
            driver.Extra_set_Form_Item(itemstack, ITEM, SLOT, itemstack.get(DataComponents.CUSTOM_DATA).copyTag());
        }
    }


    public void Extra_set_Form_Item(ItemStack itemstack, Item ITEM,int SLOT,CompoundTag  tag)
    {
    }


    public  boolean getGlowForSlot(ItemStack itemstack,EquipmentSlot currentSlot, LivingEntity livingEntity) {
        if (currentSlot== EquipmentSlot.FEET) return get_Form_Item(itemstack, 1).get_Is_Belt_Glowing();
        else if (isTransformed(livingEntity)) return get_Form_Item(itemstack, 1).get_Is_Glowing();
        return false;
    }
    public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
    }

    public void setUseAbility(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
        set_Use_Ability(itemstack);
    }


    @Override
    public <T extends LivingEntity> int damageItem(ItemStack stack, int amount, @Nullable T entity, Consumer<Item> onBroken) {
        if (stack.has(DataComponents.CONTAINER) && stack.getDamageValue()==stack.getMaxDamage()-1) {
            for (ItemStack card : stack.get(DataComponents.CONTAINER).nonEmptyItemsCopy()) entity.spawnAtLocation(card);
            if (entity instanceof ServerPlayer player) player.closeContainer();
            stack.set(DataComponents.CONTAINER, ItemContainerContents.EMPTY);
        }
        return amount;
    }

    public  boolean getPartsForSlot(ItemStack itemstack,EquipmentSlot currentSlot,String  part) {

        switch (currentSlot) {
            case HEAD ->{
                if (Objects.equals(part, "head")) return true;
            }
            case CHEST -> {
                if (Objects.equals(part, "body")) return true;
                if (Objects.equals(part, "rightArm")) return true;
                if (Objects.equals(part, "leftArm")) return true;
            }
            case LEGS -> {

                if (Objects.equals(part, "rightLeg")) return true;
                if (Objects.equals(part, "leftLeg")) return true;
            }
            default -> {}
        }
        return false;
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        LocalDate localdate = LocalDate.now();
        boolean isDateA1 = localdate.getMonthValue() == 4 && localdate.getDayOfMonth() == 1;

        if (Has_basic_belt_info) {
            if (A1&isDateA1) tooltipComponents.add(Component.translatable("kamenridercraft.name."+Rider+".a1"));
            else tooltipComponents.add(Component.translatable("kamenridercraft.name."+Rider));
            if (Show_belt_form_info) {
                {
                    RiderFormChangeItem formItem = get_Form_Item(stack, 1);
                    if (formItem.get_a1()&isDateA1)tooltipComponents.add(Component.translatable(formItem + ".form.a1"));
                    else tooltipComponents.add(Component.translatable(formItem + ".form"));
                }
            }
        }
            

		int i = 0;
		int j = 0;
		Iterator<ItemStack> var7 = stack.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY).nonEmptyItems().iterator();
        if (var7.hasNext()) tooltipComponents.add(Component.translatable("container.rider_belt"));

		while(var7.hasNext()) {
			ItemStack itemstack = var7.next();
			++j;
			if (i <= 2) {
				++i;
				tooltipComponents.add(Component.translatable("container.shulkerBox.itemCount", itemstack.getHoverName(), itemstack.getCount()));
			}
		}

		if (j - i > 0) {
			tooltipComponents.add(Component.translatable("container.shulkerBox.more", j - i).withStyle(ChatFormatting.ITALIC));
		}
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }


    public static RiderFormChangeItem get_Form_Item(ItemStack itemstack,int SLOT) {

        RiderDriverItem belt = (RiderDriverItem) itemstack.getItem();
        RiderFormChangeItem Base_Form_Item = (SLOT>=2 ? belt.Extra_Base_Form_Item.get(SLOT-2) : belt.Base_Form_Item);

        if (itemstack.has(DataComponents.CUSTOM_DATA)) {
            CompoundTag tag = itemstack.get(DataComponents.CUSTOM_DATA).getUnsafe();
            ResourceLocation Used_Form_Item = ResourceLocation.parse(tag.getString("slot_tex" + SLOT));
            if (BuiltInRegistries.ITEM.get(Used_Form_Item) instanceof RiderFormChangeItem formItem) {
                return formItem;
            }
        }
            return Base_Form_Item;
    }

    }




