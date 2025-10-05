package com.kelco.kamenridercraft.item;


import java.util.ArrayList;
import java.util.List;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.item.BaseItems.*;
import com.kelco.kamenridercraft.item.tabs.RiderTabs;
import com.kelco.kamenridercraft.particle.ModParticles;
import com.kelco.kamenridercraft.world.inventory.FueslotGuiMenu;
import io.netty.buffer.Unpooled;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemContainerContents;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Kiva_Rider_Items {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);

	public static final DeferredItem<Item> KIVA_LOGO = ITEMS.register("kiva_logo",
    		() -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/kiva")), new Item.Properties()).AddToList(RiderTabs.KIVA_TAB_ITEM));
 
	public static final DeferredItem<Item> FUESTLE = ITEMS.register("fuestle",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.KIVA_TAB_ITEM));
	
	public static final DeferredItem<Item> FAKE_FUESTLE = ITEMS.register("fuestlefake",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.KIVA_TAB_ITEM));
	
    	  
	   public static List<Item> NEED_ITEM_DOGABAKI= new ArrayList<>();
	   
	
	public static final DeferredItem<Item> DOGABAKI = ITEMS.register("dogabaki",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_dogabaki","kiva","kivat_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.WITHER, 40, 0,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.CHAIN_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 35, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 35, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 35, 0, 0, 0, 1);
				}
			}
                    .IsBeltGlowing().IsGlowing().AddNeedItemList(NEED_ITEM_DOGABAKI));

    public static final DeferredItem<Item> WAKE_UP_FUESTLE = ITEMS.register("wakeupfuestle",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","kiva","kivat_belt",
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GLASS_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 200, 0, 0, 0, 1);
				}
			}.addShiftForm(DOGABAKI.get()).IsBeltGlowing().IsGlowing().AddToList(NEED_ITEM_DOGABAKI).AddToList(RiderTabs.KIVA_TAB_ITEM));
    
    public static final DeferredItem<Item> GARULU_FUESTLE = ITEMS.register("garulufuestle",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_garulu","kiva","kivat_belt_g",
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.CHAIN_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.addShiftForm(DOGABAKI.get()).IsBeltGlowing().IsGlowing().AddToList(NEED_ITEM_DOGABAKI).AddToList(RiderTabs.KIVA_TAB_ITEM));
    
    public static final DeferredItem<Item> BASSHAA_FUESTLE = ITEMS.register("basshaafuestle",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_basshaa","kiva","kivat_belt_b",
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.CHAIN_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.addShiftForm(DOGABAKI.get()).IsBeltGlowing().IsGlowing().AddToList(NEED_ITEM_DOGABAKI).AddToList(RiderTabs.KIVA_TAB_ITEM));
    
    public static final DeferredItem<Item> DOGGA_FUESTLE = ITEMS.register("doggafuestle",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_dogga","kiva","kivat_belt_d",
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.CHAIN_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.addShiftForm(DOGABAKI.get()).IsBeltGlowing().IsGlowing().AddToList(NEED_ITEM_DOGABAKI).AddToList(RiderTabs.KIVA_TAB_ITEM));
    
    public static final DeferredItem<Item> DOGABAKI_EMPEROR = ITEMS.register("dogabaki_emperor",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_dogabaki_emperor","kiva","kivat_belt_e",
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
            		new MobEffectInstance(MobEffects.REGENERATION, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.WITHER, 40, 1,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_BAT_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.CHAIN_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 35, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 35, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 35, 0, 0, 0, 1);
				}
			}.IsBeltGlowing().IsGlowing().addNeedItem(WAKE_UP_FUESTLE.get()).addNeedItem(GARULU_FUESTLE.get()).addNeedItem(BASSHAA_FUESTLE.get()).addNeedItem(DOGGA_FUESTLE.get()));
    
    public static final DeferredItem<Item> TATSULOT = ITEMS.register("tatsulot",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"_emperor","kiva","kivat_belt_e",
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.REGENERATION, 40, 1,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_BAT_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 200, 0, 0, 0, 1);
				}
			}.IsBeltGlowing().IsGlowing().addShiftForm(DOGABAKI_EMPEROR.get()).AddToList(RiderTabs.KIVA_TAB_ITEM));


    public static final DeferredItem<Item> KIVATTE_FUESTLE = ITEMS.register("kiva_says_fuestle",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"_red_emperor","kiva","kivat_belt_e",
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.REGENERATION, 40, 1,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_BAT_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 200, 0, 0, 0, 1);
				}
			}.IsBeltGlowing().IsGlowing().addNeedItem(TATSULOT.get()).AddToList(RiderTabs.KIVA_TAB_ITEM));
    
    
    public static final DeferredItem<Item> KNUCKLE_FUESTLE_BURST = ITEMS.register("knucklefuestle_burst",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_burst","ixa","ixa_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 200, 0, 0, 0, 1);
				}
			}.IsGlowing()
            );
	
    public static final DeferredItem<Item> KNUCKLE_FUESTLE = ITEMS.register("knucklefuestle",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_save","ixa","ixa_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 200, 0, 0, 0, 1);
				}
			}.addSwitchForm(KNUCKLE_FUESTLE_BURST.get()).AddToList(RiderTabs.KIVA_TAB_ITEM));
	
	public static final DeferredItem<Item> CALIBUR_FUESTLE = ITEMS.register("caliburfuestle",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.KIVA_TAB_ITEM));
    
    public static final DeferredItem<Item> RISER_FUESTLE = ITEMS.register("risingfuestle",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_rising","ixa","ixa_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.DARK_BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 200, 0, 0, 0, 1);
				}
			}.IsGlowing().AddToList(RiderTabs.KIVA_TAB_ITEM));
	
    
    public static final DeferredItem<Item> WAKE_UP_FUESTLE_SAGA = ITEMS.register("sagafuestle",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","saga","sagarc_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GLASS_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 200, 0, 0, 0, 1);
				}
			}.IsGlowing().AddToList(RiderTabs.KIVA_TAB_ITEM));
	
    
    public static final DeferredItem<Item> WAKE_UP_FUESTLE_DARK_KIVA = ITEMS.register("darkwakeupfuestle",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","dark_kiva","dark_kivat_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.REGENERATION, 40, 2,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GLASS_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 200, 0, 0, 0, 1);
				}
			}.IsBeltGlowing().IsGlowing().AddToList(RiderTabs.KIVA_TAB_ITEM));
	
    
    public static final DeferredItem<Item> WAKE_UP_FUESTLE_NEW_KIVA = ITEMS.register("newwakeupfuestle",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","new_kiva","new_kivat_belt",
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GLASS_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 200, 0, 0, 0, 1);
				}
			}.IsBeltGlowing().IsGlowing().ChangeRiderName("kiva").AddToList(RiderTabs.KIVA_TAB_ITEM));

    public static final DeferredItem<Item> FLIGHT_STYLE_FUESTLE = ITEMS.register("flight_style_fuestle",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"_flight_style","kiva","kivat_belt_e",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.REGENERATION, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_BAT_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 200, 0, 0, 0, 1);
                }
            }.IsGlowing().IsBeltGlowing().addNeedForm(TATSULOT.get()).has_basic_model().model_has_different_name("keyfuestle"));


    public static final DeferredItem<Item> WAKE_UP_FUESTLE_ARC = ITEMS.register("keyfuestle_arc",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","arc","arc_kivat_belt",
					new MobEffectInstance(Effect_core.BIG, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GLASS_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 200, 0, 0, 0, 1);
				}
			}.addAlternative(FLIGHT_STYLE_FUESTLE.get()).IsBeltGlowing().IsGlowing()
			);
    
    
    public static final DeferredItem<Item> WAKE_UP_FUESTLE_ARC_LEGEND = ITEMS.register("keyfuestle_arc_legend",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_legend","arc","arc_kivat_belt_mecha",
					new MobEffectInstance(Effect_core.BIG, 40, 1,true,false),
					new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false))
                    .IsBeltGlowing().IsGlowing());
    
    public static final DeferredItem<Item> WAKE_UP_FUESTLE_REY = ITEMS.register("keyfuestle",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","rey","rey_kivat_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GLASS_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 200, 0, 0, 0, 1);
				}
			}.IsBeltGlowing().IsGlowing().addAlternative(WAKE_UP_FUESTLE_ARC.get()).AddToList(RiderTabs.KIVA_TAB_ITEM));
    
    
    public static final DeferredItem<Item> WAKE_UP_FUESTLE_KIVALA = ITEMS.register("kivalafuestle",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","kivala","kivala_belt",
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GLASS_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 200, 0, 0, 0, 1);
				}
			}.IsGlowing().AddToList(RiderTabs.KIVA_TAB_ITEM));
    
    
    public static final DeferredItem<Item> KIVAHELMET = ITEMS.register("kivahead",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.KIVA_TAB_ITEM).ChangeRepairItem(FUESTLE.get()));
    public static final DeferredItem<Item> KIVACHESTPLATE = ITEMS.register("kivatroso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.KIVA_TAB_ITEM).ChangeRepairItem(FUESTLE.get()));
    public static final DeferredItem<Item> KIVALEGGINGS = ITEMS.register("kivalegs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.KIVA_TAB_ITEM).ChangeRepairItem(FUESTLE.get()));

    public static final DeferredItem<Item> KIVAT_BELT = ITEMS.register("kivadriver",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"kiva", WAKE_UP_FUESTLE,KIVAHELMET, KIVACHESTPLATE, KIVALEGGINGS, new Item.Properties().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)){
				@Override
				public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
					player.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.translatable("fueslot_gui.text");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
							packetBuffer.writeBlockPos(player.blockPosition());
							packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
							return new FueslotGuiMenu(id, inventory, packetBuffer,itemstack);
						}
					});
				}
			}.Has_Inventory_Gui().AddToTabList(RiderTabs.KIVA_TAB_ITEM).ChangeRepairItem(FUESTLE.get()));

    public static final DeferredItem<Item> IXA_BELT = ITEMS.register("ixa_belt",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"ixa", KNUCKLE_FUESTLE,KIVAHELMET, KIVACHESTPLATE, KIVALEGGINGS, new Item.Properties().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)){
				@Override
				public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
					player.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.translatable("fueslot_gui.text");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
							packetBuffer.writeBlockPos(player.blockPosition());
							packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
							return new FueslotGuiMenu(id, inventory, packetBuffer,itemstack);
						}
					}, buf -> {
						buf.writeBlockPos(player.blockPosition());
						buf.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
					});
				}
			}.Has_Inventory_Gui().AddToTabList(RiderTabs.KIVA_TAB_ITEM).ChangeRepairItem(FUESTLE.get()));

	public static final DeferredItem<Item> PROTO_IXA_BELT = ITEMS.register("proto_ixa_belt",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"proto_ixa", KNUCKLE_FUESTLE,KIVAHELMET, KIVACHESTPLATE, KIVALEGGINGS, new Item.Properties().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)){
				@Override
				public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
					player.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.translatable("fueslot_gui.text");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
							packetBuffer.writeBlockPos(player.blockPosition());
							packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
							return new FueslotGuiMenu(id, inventory, packetBuffer,itemstack);
						}
					}, buf -> {
						buf.writeBlockPos(player.blockPosition());
						buf.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
					});
				}
			}.Has_Inventory_Gui().Dont_show_belt_form_info().AddToTabList(RiderTabs.KIVA_TAB_ITEM).ChangeRepairItem(FUESTLE.get()));

	public static final DeferredItem<Item> PROTO_IXA_BELT_FIRST = ITEMS.register("proto_ixa_belt_first",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"ixa_first", KNUCKLE_FUESTLE,KIVAHELMET, KIVACHESTPLATE, KIVALEGGINGS, new Item.Properties().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY))
		.Has_Inventory_Gui().Override_belt_text("ixa_buckle").Dont_show_belt_form_info().AddToTabList(RiderTabs.KIVA_TAB_ITEM).ChangeRepairItem(FUESTLE.get()));


	public static final DeferredItem<Item> SAGARC_BELT = ITEMS.register("sagarc_belt",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"saga", WAKE_UP_FUESTLE_SAGA, KIVAHELMET, KIVACHESTPLATE, KIVALEGGINGS, new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.KIVA_TAB_ITEM).ChangeRepairItem(FUESTLE.get()));
    
    public static final DeferredItem<Item> DARK_KIVAT_BELT = ITEMS.register("darkkivadriver",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"dark_kiva", WAKE_UP_FUESTLE_DARK_KIVA,KIVAHELMET, KIVACHESTPLATE, KIVALEGGINGS, new Item.Properties().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)){
				@Override
				public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
					player.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.translatable("fueslot_gui.text");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
							packetBuffer.writeBlockPos(player.blockPosition());
							packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
							return new FueslotGuiMenu(id, inventory, packetBuffer,itemstack);
						}
					}, buf -> {
						buf.writeBlockPos(player.blockPosition());
						buf.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
					});
				}
			}.Has_Inventory_Gui().Dont_show_belt_form_info().AddToTabList(RiderTabs.KIVA_TAB_ITEM).ChangeRepairItem(FUESTLE.get()));

    public static final DeferredItem<Item> NEW_KIVAT_BELT = ITEMS.register("newkivadriver",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"new_kiva", WAKE_UP_FUESTLE_NEW_KIVA,KIVAHELMET, KIVACHESTPLATE, KIVALEGGINGS, new Item.Properties().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)){
				@Override
				public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
					player.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.translatable("fueslot_gui.text");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
							packetBuffer.writeBlockPos(player.blockPosition());
							packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
							return new FueslotGuiMenu(id, inventory, packetBuffer,itemstack);
						}
					}, buf -> {
						buf.writeBlockPos(player.blockPosition());
						buf.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
					});
				}
			}.Has_Inventory_Gui().Dont_show_belt_form_info().AddToTabList(RiderTabs.KIVA_TAB_ITEM).ChangeRepairItem(FUESTLE.get()));

    public static final DeferredItem<Item> REY_KIVAT_BELT = ITEMS.register("reydriver",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"rey", WAKE_UP_FUESTLE_REY,KIVAHELMET, KIVACHESTPLATE, KIVALEGGINGS, new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.KIVA_TAB_ITEM).ChangeRepairItem(FUESTLE.get()));

    public static final DeferredItem<Item> ARC_KIVAT_BELT = ITEMS.register("arcdriver",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"arc", WAKE_UP_FUESTLE_ARC,KIVAHELMET, KIVACHESTPLATE, KIVALEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.KIVA_TAB_ITEM).ChangeRepairItem(FUESTLE.get()));

    public static final DeferredItem<Item> KIVALA_BELT = ITEMS.register("kivaladriver",
    		() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"kivala", WAKE_UP_FUESTLE_KIVALA,KIVAHELMET, KIVACHESTPLATE, KIVALEGGINGS, new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RiderTabs.KIVA_TAB_ITEM).ChangeRepairItem(FUESTLE.get()));

    
    public static final DeferredItem<Item> GARULU_SABER = ITEMS.register("garulu_saber",
         	() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.KIVA_TAB_ITEM).ChangeRepairItem(FUESTLE.get()));
    
	public static final DeferredItem<Item> BASSHAA_MAGNUM = ITEMS.register("basshaamagnum",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.KIVA_TAB_ITEM).ChangeRepairItem(FUESTLE.get()));

	public static final DeferredItem<Item> DOGGA_HAMMER = ITEMS.register("dogga_hammer",
         	() -> new BaseSwordItem(Tiers.DIAMOND, 7, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.KIVA_TAB_ITEM).ChangeRepairItem(FUESTLE.get()));
    
	public static final DeferredItem<Item> GARULU_SABER_TATSULOT = ITEMS.register("garulu_saber_tatsulot",
         	() -> new BaseSwordItem(Tiers.DIAMOND, 7, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).AddToTabList(RiderTabs.KIVA_TAB_ITEM).ChangeRepairItem(FUESTLE.get()));
    
	public static final DeferredItem<Item> BASSHAA_MAGNUM_TATSULOT = ITEMS.register("basshaa_magnum_tatsulot",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).AddToTabList(RiderTabs.KIVA_TAB_ITEM).ChangeRepairItem(FUESTLE.get()));

	public static final DeferredItem<Item> DOGGA_HAMMER_TATSULOT = ITEMS.register("dogga_hammer_tatsulot",
         	() -> new BaseSwordItem(Tiers.DIAMOND, 9, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).AddToTabList(RiderTabs.KIVA_TAB_ITEM).ChangeRepairItem(FUESTLE.get()));

	public static final DeferredItem<Item> ZANVAT_SWORD = ITEMS.register("zanbatsword",
         	() -> new BaseSwordItem(Tiers.DIAMOND, 9, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).AddToTabList(RiderTabs.KIVA_TAB_ITEM).ChangeRepairItem(FUESTLE.get()));
    
	public static final DeferredItem<Item> ZANVAT_SWORD_PAST = ITEMS.register("zanbatsword_core",
         	() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.KIVA_TAB_ITEM).ChangeRepairItem(FUESTLE.get()));
	
	public static final DeferredItem<Item>IXA_KNUCKLE = ITEMS.register("ixa_knuckle",
         	() -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.KIVA_TAB_ITEM).ChangeRepairItem(FUESTLE.get()));
    
	public static final DeferredItem<Item> IXA_CALIBER = ITEMS.register("ixa_caliber",
         	() -> new BaseBlasterItem(Tiers.DIAMOND, 9, -2.4F, new Item.Properties()).IsSwordGun().AddToTabList(RiderTabs.KIVA_TAB_ITEM).ChangeRepairItem(FUESTLE.get()));
    
	public static final DeferredItem<Item> IXA_RISER = ITEMS.register("ixariser",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).AddToTabList(RiderTabs.KIVA_TAB_ITEM).ChangeRepairItem(FUESTLE.get()));

	public static final DeferredItem<Item> JACORDER = ITEMS.register("jacorder",
         	() -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.KIVA_TAB_ITEM).ChangeRepairItem(FUESTLE.get()));
    
	public static final DeferredItem<Item> ARC_TRIDENT = ITEMS.register("arc_trident",
         	() -> new BaseSwordItem(Tiers.DIAMOND, 8, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.KIVA_TAB_ITEM).ChangeRepairItem(FUESTLE.get()));

    public static final DeferredItem<Item> KIVALA_SABER = ITEMS.register("kivala_saber",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.KIVA_TAB_ITEM).ChangeRepairItem(FUESTLE.get()));

	public static final DeferredItem<Item> FANGIRE_SLAYER = ITEMS.register("fangire_slayer",
         	() -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.KIVA_TAB_ITEM).ChangeRepairItem(FUESTLE.get()));
    
	public static final DeferredItem<Item> FANGIRE_BUSTER = ITEMS.register("fangire_buster",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 2, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.KIVA_TAB_ITEM).ChangeRepairItem(FUESTLE.get()));

    public static final DeferredItem<Item> BLOODY_ROSE = ITEMS.register("bloody_rose",
            () -> new BaseItem(new Item.Properties()).has_basic_model().AddToList(RiderTabs.KIVA_TAB_ITEM));


    public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
}
