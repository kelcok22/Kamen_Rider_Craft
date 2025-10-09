package com.kelco.kamenridercraft.item;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.item.BaseItems.*;
import com.kelco.kamenridercraft.item.tabs.RiderTabs;
import com.kelco.kamenridercraft.item.wizard.*;
import com.kelco.kamenridercraft.particle.ModParticles;
import com.kelco.kamenridercraft.world.inventory.RingHolderGuiMenu;
import com.kelco.kamenridercraft.world.inventory.RingHolderGuiMenuBeast;
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

public class Wizard_Rider_Items {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);

	public static final DeferredItem<Item> WIZARD_LOGO = ITEMS.register("wizard_logo",
			() -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/wizard")), new Item.Properties()).AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> WIZARD_GEM= ITEMS.register("wizardgem",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> WIZARD_GEM_RED= ITEMS.register("wizardgem_red",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> WIZARD_GEM_BLUE= ITEMS.register("wizardgem_blue",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> WIZARD_GEM_GREEN= ITEMS.register("wizardgem_green",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> WIZARD_GEM_YELLOW= ITEMS.register("wizardgem_yellow",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> WIZARD_GEM_VIOLET= ITEMS.register("wizardgem_violet",
			() -> new BaseItem(new Item.Properties().rarity(Rarity.UNCOMMON)).AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> WIZARD_GEM_BLACK= ITEMS.register("wizardgem_black",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> WIZARD_GEM_CYAN= ITEMS.register("wizardgem_cyan",
			() -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> PHILOSOPHERS_STONE= ITEMS.register("philosophers_stone",
			() -> new BaseItem(new Item.Properties().rarity(Rarity.EPIC)).AddToList(RiderTabs.WIZARD_TAB_ITEM));


	public static final DeferredItem<Item> FLAME_WIZARD_RING = ITEMS.register("flame_ring",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_WIZARD_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 1, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.allowRiderKick().IsGlowing().AddToList(RiderTabs.WIZARD_TAB_ITEM));


	public static final DeferredItem<Item> WATER_WIZARD_RING = ITEMS.register("water_ring",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_water","wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_WIZARD_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 1, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .allowRiderKick().IsGlowing().AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> HURRICANE_WIZARD_RING = ITEMS.register("hurricane_ring",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_hurricane","wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 5,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_WIZARD_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 1, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .allowRiderKick().IsGlowing().AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> LAND_WIZARD_RING = ITEMS.register("land_ring",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_land","wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_WIZARD_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 1, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.allowRiderKick().IsGlowing().AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> FLAME_DRAGON_WIZARD_RING = ITEMS.register("flame_ring_dragon",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_flame_dragon","wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_WIZARD_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 1, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.allowRiderKick().IsGlowing().AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> WATER_DRAGON_WIZARD_RING = ITEMS.register("water_ring_dragon",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_water_dragon","wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_WIZARD_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 1, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.allowRiderKick().IsGlowing().AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> HURRICANE_DRAGON_WIZARD_RING = ITEMS.register("hurricane_ring_dragon",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_hurricane_dragon","wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_WIZARD_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 1, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.allowRiderKick().IsGlowing().AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> LAND_DRAGON_WIZARD_RING_BEAST = ITEMS.register("land_ring_dragon_beast",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_wizard","beast","beast_driver_belt"
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
					,new MobEffectInstance(Effect_core.PUNCH, 40, 5,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_WIZARD_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 1, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing().ChangeModel("wizard_flame_dragon_all_dragon.geo.json"));

	public static final DeferredItem<Item> LAND_DRAGON_WIZARD_RING = ITEMS.register("land_ring_dragon",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_land_dragon","wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false)
					,new MobEffectInstance(Effect_core.PUNCH, 40, 5,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_WIZARD_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 1, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.allowRiderKick().IsGlowing().addAlternative(LAND_DRAGON_WIZARD_RING_BEAST.get())
			.AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> INFINITY_WIZARD_RING = ITEMS.register("infinity_ring",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"_infinity","wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false)
					,new MobEffectInstance(Effect_core.PUNCH, 40, 5,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_WIZARD_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 1, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 200, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RANDOM_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }.allowRiderKick().IsGlowing().AddToList(RiderTabs.WIZARD_TAB_ITEM).AddToList(Decade_Rider_Items.COMPLETE_21_FORMS));


	public static final DeferredItem<Item> DRAGO_TIMER = ITEMS.register("drago_timer",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_flame_dragon_all_dragon","wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(Effect_core.FIRE_ARMOR, 40, 5,true,false)
					,new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 40, 0,true,false)
					,new MobEffectInstance(Effect_core.PUNCH, 40, 5,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_WIZARD_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 1, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.allowRiderKick().IsGlowing().addNeedForm(FLAME_DRAGON_WIZARD_RING.get(),1).AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> WATER_DRAGON_WIZARD_SPECIAL_RING = ITEMS.register("water_ring_dragon_special_ring",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_water_dragon_special","wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_WIZARD_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 1, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.allowRiderKick().IsGlowing().addNeedForm(WATER_DRAGON_WIZARD_RING.get(),1).ChangeModel("wizard_flame_dragon_all_dragon.geo.json"));

	public static final DeferredItem<Item> HURRICANE_DRAGON_WIZARD_SPECIAL_RING = ITEMS.register("hurricane_ring_dragon_special_ring",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_hurricane_dragon_special","wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_WIZARD_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 1, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.allowRiderKick().IsGlowing().addNeedForm(HURRICANE_DRAGON_WIZARD_RING.get(),1).addAlternative(WATER_DRAGON_WIZARD_SPECIAL_RING.get()).ChangeModel("wizard_flame_dragon_all_dragon.geo.json"));

	public static final DeferredItem<Item> LAND_DRAGON_WIZARD_SPECIAL_RING = ITEMS.register("land_ring_dragon_special_ring",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_land_dragon_special","wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(Effect_core.PUNCH, 40, 5,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_WIZARD_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 1, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.allowRiderKick().IsGlowing().addNeedForm(LAND_DRAGON_WIZARD_RING.get(),1).addAlternative(HURRICANE_DRAGON_WIZARD_SPECIAL_RING.get()).ChangeModel("wizard_flame_dragon_all_dragon.geo.json"));

	public static final DeferredItem<Item> SPECIAL_RING = ITEMS.register("special_ring",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_flame_dragon_special","wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(Effect_core.FIRE_ARMOR, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_WIZARD_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 1, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.allowRiderKick().IsGlowing().ChangeModel("wizard_flame_dragon_all_dragon.geo.json").addAlternative(LAND_DRAGON_WIZARD_SPECIAL_RING.get())
					.addNeedForm(FLAME_DRAGON_WIZARD_RING.get(),1)
					.AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> HOPE_RING = ITEMS.register("hope_ring",
			() -> new BaseItem(new Item.Properties().rarity(Rarity.EPIC)).AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> FINISH_STRIKE_RING_NO_HOPE  = ITEMS.register("finish_strike_ring_no_hope",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_infinity_dragon","wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 5,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false)
					,new MobEffectInstance(Effect_core.FIRE_ARMOR, 40, 0,true,false)
					,new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 40, 0,true,false)
					,new MobEffectInstance(Effect_core.PUNCH, 40, 5,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_WIZARD_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 1, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 200, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RANDOM_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }.allowRiderKick().IsGlowing().addNeedForm(INFINITY_WIZARD_RING.get(),1).ChangeModel("wizard_flame_dragon_all_dragon.geo.json"));

	public static final DeferredItem<Item> FINISH_STRIKE_RING  = ITEMS.register("finish_strike_ring",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.EPIC),0,"_infinity_gold","wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false)
					,new MobEffectInstance(Effect_core.FIRE_ARMOR, 40, 0,true,false)
					,new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 40, 0,true,false)
					,new MobEffectInstance(Effect_core.PUNCH, 40, 5,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 1, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 200, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RANDOM_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }.allowRiderKick().IsGlowing().addNeedForm(INFINITY_WIZARD_RING.get(),1).ChangeModel("wizard_flame_dragon_all_dragon.geo.json")
					.addNeedItem(HOPE_RING.get()).addAlternative(FINISH_STRIKE_RING_NO_HOPE.get()).AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> SPECIAL_RUSH_RING = ITEMS.register("special_rush_ring",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_flame_dragon_special_rush","wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(Effect_core.FIRE_ARMOR, 40, 5,true,false)
					,new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 40, 0,true,false)
					,new MobEffectInstance(Effect_core.PUNCH, 40, 5,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_WIZARD_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 1, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.allowRiderKick().IsGlowing().addNeedForm(FLAME_DRAGON_WIZARD_RING.get(),1).ChangeModel("wizard_flame_dragon_all_dragon.geo.json")
					.AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> BEAST_RING = ITEMS.register("beast_ring",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","beast","beast_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BEAST_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 1, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing().AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> FALCO_RING_WIZARD = ITEMS.register("falco_ring_wizard",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_falco","wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_BEAST_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 1, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.allowRiderKick().IsGlowing().addNeedForm(FLAME_DRAGON_WIZARD_RING.get(),1));

	public static final DeferredItem<Item> FALCO_RING = ITEMS.register("falco_ring",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_falco","beast","beast_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)
					,new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_BEAST_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 1, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing().addAlternative(FALCO_RING_WIZARD.get()).AddToList(RiderTabs.WIZARD_TAB_ITEM)
					);

	public static final DeferredItem<Item> CHAMELEO_RING = ITEMS.register("chameleo_ring",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_chameleo","beast","beast_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)
                    ,new MobEffectInstance(Effect_core.STEALTH, 40, 4,true,false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_BEAST_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 1, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            } .IsGlowing().AddToList(RiderTabs.WIZARD_TAB_ITEM));


	public static final DeferredItem<Item> BUFFA_RING_WIZARD = ITEMS.register("buffa_ring_wizard",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_beast","wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_BEAST_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 1, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.allowRiderKick().IsGlowing().addNeedForm(FALCO_RING_WIZARD.get(),1));

	public static final DeferredItem<Item> BUFFA_RING = ITEMS.register("buffa_ring",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_buffa","beast","beast_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_BEAST_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 1, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing().addAlternative(BUFFA_RING_WIZARD.get()).AddToList(RiderTabs.WIZARD_TAB_ITEM)
					);

	public static final DeferredItem<Item> DOLPHI_RING = ITEMS.register("dolphi_ring",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_dolphi","beast","beast_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 40, 0,true,false)
					,new MobEffectInstance(Effect_core.ANTIPOISON, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_BEAST_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 1, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing().AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> HYPER_RING = ITEMS.register("hyper_ring",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_hyper","beast","beast_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 5,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 5,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BEAST_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 1, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing().AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> WISEMAN_RING = ITEMS.register("wiseman_ring",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","wiseman","wise_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_WIZARD_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 1, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.allowRiderKick().IsGlowing().AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> MAGE_O_RING = ITEMS.register("mage_o_ring",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","mage","wise_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_WIZARD_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 1, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.allowRiderKick().IsGlowing().AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> MAGE_B_RING = ITEMS.register("mage_b_ring",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","mage_blue","wise_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_WIZARD_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 1, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .allowRiderKick().IsGlowing().AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> MAGE_G_RING = ITEMS.register("mage_g_ring",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","mage_green","wise_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_WIZARD_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 1, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.allowRiderKick().IsGlowing().AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> SORCERER_RING = ITEMS.register("sorcerer_ring",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","sorcerer","wise_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_WIZARD_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 1, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 300, 0, 0, 0, 1);
                }
            }.allowRiderKick().AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> BLACK_WIZARD_RING = ITEMS.register("black_ring",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","black_wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_WIZARD_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 1, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.allowRiderKick().IsGlowing().AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> DARK_WIZARD_RING = ITEMS.register("dark_ring",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","dark_wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_WIZARD_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 1, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.allowRiderKick().IsGlowing().AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> LIGHT_WIZARD_RING = ITEMS.register("light_ring",
			() -> new WizardRingItem(new Item.Properties(), new MobEffectInstance(MobEffects.NIGHT_VISION, 800,0,true,true))
                    .AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> EXCITE_WIZARD_RING = ITEMS.register("excite_ring",
			() -> new WizardRingItem(new Item.Properties(), new MobEffectInstance(MobEffects.DAMAGE_BOOST, 500,1,true,true))
					.AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> DEFEND_WIZARD_RING = ITEMS.register("defend_ring",
			() -> new WizardRingItem(new Item.Properties(), new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 800,2,true,true))
					.AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> BLIZZARD_WIZARD_RING = ITEMS.register("blizzard_ring",
			() -> new WizardRingItem(new Item.Properties(), new MobEffectInstance(Effect_core.BLIZZARD, 500,0,true,true))
					.AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> GRAVITY_WIZARD_RING = ITEMS.register("gravity_ring",
			() -> new WizardRingItem(new Item.Properties(), new MobEffectInstance(Effect_core.GRAVITY, 500,2,true,true))
					.AddToList(RiderTabs.WIZARD_TAB_ITEM));

       public static final DeferredItem<Item> THUNDER_WIZARD_RING = ITEMS.register("thunder_ring",
               () -> new WizardRingItem(new Item.Properties(), new MobEffectInstance(Effect_core.THUNDER, 500,0,true,true))
					   .AddToList(RiderTabs.WIZARD_TAB_ITEM));

       public static final DeferredItem<Item> EXPLOSION_WIZARD_RING = ITEMS.register("explosion_ring",
               () -> new WizardRingItem(new Item.Properties().rarity(Rarity.UNCOMMON), new MobEffectInstance(Effect_core.EXPLOSION, 500,1,true,true))
					   .AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> TELEPORT_WIZARD_RING = ITEMS.register("teleport_ring",
			() -> new WizardRingItem(new Item.Properties().rarity(Rarity.UNCOMMON), new MobEffectInstance(Effect_core.RETURN, 500,20,true,true))
					.AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> CONNECT_WIZARD_RING = ITEMS.register("connect_ring",
			() -> new WizardRingItem(new Item.Properties(), new MobEffectInstance(Effect_core.CONNECT, 80,0,true,true))
					.AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> SLEEP_WIZARD_RING = ITEMS.register("sleep_ring",
			() -> new WizardRingItem(new Item.Properties(), new MobEffectInstance(Effect_core.SLEEP, 80,0,true,true))
					.AddToList(RiderTabs.WIZARD_TAB_ITEM));

       public static final DeferredItem<Item> BIND_WIZARD_RING = ITEMS.register("bind_ring",
               () -> new WizardRingItem(new Item.Properties(), new MobEffectInstance(Effect_core.BIND, 80,0,true,true))
					   .AddToList(RiderTabs.WIZARD_TAB_ITEM));

	   public static final DeferredItem<Item> FALL_WIZARD_RING = ITEMS.register("fall_ring",
			   () -> new WizardRingItem(new Item.Properties(), new MobEffectInstance(Effect_core.FALL, 40,0,true,true))
					   .AddToList(RiderTabs.WIZARD_TAB_ITEM));

       public static final DeferredItem<Item> KICK_STRIKE_WIZARD_RING = ITEMS.register("kick_strike_ring",
               () -> new WizardRingItem(new Item.Properties(), "kick_strike")
                       .AddToList(RiderTabs.WIZARD_TAB_ITEM));

       public static final DeferredItem<Item> ECLIPSE_WIZARD_RING = ITEMS.register("eclipse_ring",
               () -> new WizardRingItem(new Item.Properties().rarity(Rarity.UNCOMMON), new MobEffectInstance(Effect_core.NIGHT, 80,0,true,true))
					   .AddToList(RiderTabs.WIZARD_TAB_ITEM));

       public static final DeferredItem<Item> LIGUID_WIZARD_RING = ITEMS.register("liquid_ring",
               () -> new WizardRingItem(new Item.Properties()
                       , new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 1000,9,true,true)
                       , new MobEffectInstance(MobEffects.WATER_BREATHING, 1000,1,true,true))
					   .AddToList(RiderTabs.WIZARD_TAB_ITEM));

       public static final DeferredItem<Item> DRILL_WIZARD_RING = ITEMS.register("drill_ring",
               () -> new WizardRingItem(new Item.Properties()
                       , new MobEffectInstance(MobEffects.DIG_SPEED, 800,3,true,true))
					   .AddToList(RiderTabs.WIZARD_TAB_ITEM));

       public static final DeferredItem<Item> BIG_WIZARD_RING = ITEMS.register("big_ring",
               () -> new WizardRingItem(new Item.Properties(), new MobEffectInstance(Effect_core.BIG, 500,2,true,true))
					   .AddToList(RiderTabs.WIZARD_TAB_ITEM));

       public static final DeferredItem<Item> SMALL_WIZARD_RING = ITEMS.register("small_ring",
               () -> new WizardRingItem(new Item.Properties(), new MobEffectInstance(Effect_core.SMALL, 500,20,true,true))
					   .AddToList(RiderTabs.WIZARD_TAB_ITEM));


       public static final DeferredItem<Item> DRESS_UP_RING = ITEMS.register("dress_up_ring",
               () -> new RiderFormChangeItem(new Item.Properties(),0,"_dressup","wizard","wizardriver_belt",
                       new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
                       ,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)){
                   public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                       super.OnTransformation(itemstack, player);
                       ((ServerLevel) player.level()).sendParticles(ModParticles.RED_WIZARD_PARTICLES.get(),
                               player.getX(), player.getY()+1,
                               player.getZ(), 1, 0, 0, 0, 1);
                       ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                               player.getX(), player.getY()+1,
                               player.getZ(), 100, 0, 0, 0, 1);
                   }
               }.allowRiderKick().addNeedForm(FLAME_WIZARD_RING.get(),1)
                       .IsGlowing().AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> FLOWER_WIZARD_RING = ITEMS.register("flower_ring",
			() -> new WizardRingItem(new Item.Properties(), new MobEffectInstance(Effect_core.FLOWER, 500,0,true,true))
					.AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> EXTAND_WIZARD_RING = ITEMS.register("extend_ring",
			() -> new WizardRingItem(new Item.Properties(), new MobEffectInstance(Effect_core.LONG_ARM, 500,4,true,true))
					.AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> SMELL_WIZARD_RING = ITEMS.register("smell_ring",
			() -> new WizardRingItem(new Item.Properties(), new MobEffectInstance(Effect_core.SMELL, 140,0,true,true))
					.AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> CHRISTMAS_WIZARD_RING = ITEMS.register("merry_christmas_ring",
			() -> new WizardRingItem(new Item.Properties(), new MobEffectInstance(Effect_core.CHRISTMAS, 500,0,true,true))
					.AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> TIME_WIZARD_RING = ITEMS.register("time_ring",
			() -> new WizardRingItem(new Item.Properties(), new MobEffectInstance(Effect_core.TIME, 500,0,true,true))
					.AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> DRAGORISE_WIZARD_RING = ITEMS.register("dragorise_ring",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> ENGAGE_WIZARD_RING = ITEMS.register("engage_ring",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> PLEASE_WIZARD_RING = ITEMS.register("please_ring",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> DRIVER_ON_WIZARD_RING = ITEMS.register("driver_on_ring",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> DRIVER_ON_WHITE_WIZARD_WIZARD_RING = ITEMS.register("driver_on_ring_white_wizard",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> COMMON_WIZARD_RING = ITEMS.register("common_wizard_ring",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> CHICHIN_PUI_PUI_WIZARD_RING = ITEMS.register("chichin_pui_pui_ring",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> CREATE_WIZARD_RING = ITEMS.register("create_ring",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> COPY_WIZARD_RING = ITEMS.register("copy_ring",
			() -> new WizardRingItem(new Item.Properties(), "copy")
					.AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> MIRACLE_WIZARD_RING = ITEMS.register("miracle_ring",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> DANCE_WIZARD_RING = ITEMS.register("dance_ring",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> HOLY_WIZARD_RING = ITEMS.register("holy_ring",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.WIZARD_TAB_ITEM));


	public static final DeferredItem<Item> GARUDA_WIZARD_RING = ITEMS.register("garuda_ring",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> UNICORN_WIZARD_RING = ITEMS.register("unicorn_ring",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> KRAKEN_WIZARD_RING = ITEMS.register("kraken_ring",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> GOLEM_WIZARD_RING = ITEMS.register("golem_ring",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> WHITE_GARUDA_WIZARD_RING = ITEMS.register("white_garuda_ring",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> CERBERUS_WIZARD_RING = ITEMS.register("cerberus_ring",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> GARUDA_WIZARD_RING_COLOR_VER = ITEMS.register("garuda_ring_color_ver",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_garuda","wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)
					,new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_WIZARD_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 1, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .allowRiderKick().IsGlowing().hasStaticWings().addNeedForm(FLAME_WIZARD_RING.get(),1)
					.AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> KRAKEN_WIZARD_RING_COLOR_VER = ITEMS.register("kraken_ring_color_ver",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_kraken","wizard","wizardriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_WIZARD_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 1, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.allowRiderKick().IsGlowing().hasStaticWings().addNeedForm(WATER_WIZARD_RING.get(),1)
					.AddToList(RiderTabs.WIZARD_TAB_ITEM));


	public static final DeferredItem<Item> BEAST_ENGAGE_WIZARD_RING = ITEMS.register("beast_engage_ring",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> CHIMARISE_WIZARD_RING = ITEMS.register("chimarise_ring",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> BEAST_DRIVER_ON_WIZARD_RING = ITEMS.register("beast_driver_on_ring",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> GRIFFIN_WIZARD_RING = ITEMS.register("griffin_ring",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.WIZARD_TAB_ITEM));


    public static final DeferredItem<Item> KUUGA_WIZARD_RING = ITEMS.register("kuuga_ring",
            () -> new LegendWizardRingItem(new Item.Properties(), (RiderDriverItem)Kuuga_Rider_Items.ARCLE.get()).has_basic_model().AddToList(RiderTabs.WIZARD_TAB_ITEM));

    public static final DeferredItem<Item> AGITO_WIZARD_RING = ITEMS.register("agito_ring",
            () -> new LegendWizardRingItem(new Item.Properties(), (RiderDriverItem)Agito_Rider_Items.ALTERING.get()).has_basic_model().AddToList(RiderTabs.WIZARD_TAB_ITEM));

    public static final DeferredItem<Item> RYUKI_WIZARD_RING = ITEMS.register("ryuki_ring",
            () -> new LegendWizardRingItem(new Item.Properties(), (RiderDriverItem)Ryuki_Rider_Items.RYUKIDRIVER.get()).has_basic_model().AddToList(RiderTabs.WIZARD_TAB_ITEM));

    public static final DeferredItem<Item> FAIZ_WIZARD_RING = ITEMS.register("faiz_ring",
            () -> new LegendWizardRingItem(new Item.Properties(), (RiderDriverItem)Faiz_Rider_Items.FAIZ_DRIVER.get()).has_basic_model().AddToList(RiderTabs.WIZARD_TAB_ITEM));

    public static final DeferredItem<Item> BLADE_WIZARD_RING = ITEMS.register("blade_ring",
            () -> new LegendWizardRingItem(new Item.Properties(), (RiderDriverItem)Blade_Rider_Items.BLAYBUCKLE.get()).has_basic_model().AddToList(RiderTabs.WIZARD_TAB_ITEM));

    public static final DeferredItem<Item> HIBIKI_WIZARD_RING = ITEMS.register("hibiki_ring",
            () -> new LegendWizardRingItem(new Item.Properties(), (RiderDriverItem)Hibiki_Rider_Items.HIBIKIDRIVER.get()).has_basic_model().AddToList(RiderTabs.WIZARD_TAB_ITEM));

    public static final DeferredItem<Item> KABUTO_WIZARD_RING = ITEMS.register("kabuto_ring",
            () -> new LegendWizardRingItem(new Item.Properties(), (RiderDriverItem)Kabuto_Rider_Items.KABUTO_RIDER_BELT.get()).has_basic_model().AddToList(RiderTabs.WIZARD_TAB_ITEM));

    public static final DeferredItem<Item> DEN_O_WIZARD_RING = ITEMS.register("den_o_ring",
            () -> new LegendWizardRingItem(new Item.Properties(), (RiderDriverItem)Den_O_Rider_Items.DEN_O_BELT.get()).has_basic_model().AddToList(RiderTabs.WIZARD_TAB_ITEM));

    public static final DeferredItem<Item> KIVA_WIZARD_RING = ITEMS.register("kiva_ring",
            () -> new LegendWizardRingItem(new Item.Properties(), (RiderDriverItem)Kiva_Rider_Items.KIVAT_BELT.get()).has_basic_model().AddToList(RiderTabs.WIZARD_TAB_ITEM));

    public static final DeferredItem<Item> DECADE_WIZARD_RING = ITEMS.register("decade_ring",
            () -> new LegendWizardRingItem(new Item.Properties(), (RiderDriverItem)Decade_Rider_Items.DECADRIVER.get()).has_basic_model().AddToList(RiderTabs.WIZARD_TAB_ITEM));

    public static final DeferredItem<Item> DOUBLE_WIZARD_RING = ITEMS.register("double_ring",
            () -> new LegendWizardRingItem(new Item.Properties(), (RiderDriverItem)W_Rider_Items.WDRIVER.get()).has_basic_model().AddToList(RiderTabs.WIZARD_TAB_ITEM));

    public static final DeferredItem<Item> ACCEL_WIZARD_RING = ITEMS.register("accel_ring",
            () -> new LegendWizardRingItem(new Item.Properties(), (RiderDriverItem)W_Rider_Items.ACCELDRIVER.get()).AddToList(RiderTabs.WIZARD_TAB_ITEM));

    public static final DeferredItem<Item> OOO_WIZARD_RING = ITEMS.register("ooo_ring",
            () -> new LegendWizardRingItem(new Item.Properties(), (RiderDriverItem)OOO_Rider_Items.OOODRIVER.get()).has_basic_model().AddToList(RiderTabs.WIZARD_TAB_ITEM));

    public static final DeferredItem<Item> BIRTH_WIZARD_RING = ITEMS.register("birth_ring",
            () -> new LegendWizardRingItem(new Item.Properties(), (RiderDriverItem)OOO_Rider_Items.BIRTH_DRIVER.get()).AddToList(RiderTabs.WIZARD_TAB_ITEM));

    public static final DeferredItem<Item> FOURZE_WIZARD_RING = ITEMS.register("fourze_ring",
            () -> new LegendWizardRingItem(new Item.Properties(), (RiderDriverItem)Fourze_Rider_Items.FOURZE_DRIVER.get()).has_basic_model().AddToList(RiderTabs.WIZARD_TAB_ITEM));


    public static final DeferredItem<Item> FOURZE_ENGAGE_WIZARD_RING = ITEMS.register("fourze_engage_ring",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> SUPER_SENTAI_WIZARD_RING = ITEMS.register("super_sentai_ring",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.WIZARD_TAB_ITEM));


	public static final DeferredItem<Item> UNKNOWN_AMBER_RING = ITEMS.register("unknown_amber_ring",
			() -> new UnknownWizardRingItem(new Item.Properties(), ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "items/unknown_amber_ring")).AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> UNKNOWN_RED_RING = ITEMS.register("unknown_red_ring",
			() -> new UnknownWizardRingItem(new Item.Properties(), ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "items/unknown_red_ring")).AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> UNKNOWN_BLUE_RING = ITEMS.register("unknown_blue_ring",
			() -> new UnknownWizardRingItem(new Item.Properties(), ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "items/unknown_blue_ring")).AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> UNKNOWN_GREEN_RING = ITEMS.register("unknown_green_ring",
			() -> new UnknownWizardRingItem(new Item.Properties(), ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "items/unknown_green_ring")).AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> UNKNOWN_YELLOW_RING = ITEMS.register("unknown_yellow_ring",
			() -> new UnknownWizardRingItem(new Item.Properties(), ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "items/unknown_yellow_ring")).AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> UNKNOWN_VIOLET_RING = ITEMS.register("unknown_violet_ring",
			() -> new UnknownWizardRingItem(new Item.Properties(), ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "items/unknown_violet_ring")).AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> UNKNOWN_BLACK_RING = ITEMS.register("unknown_black_ring",
			() -> new UnknownWizardRingItem(new Item.Properties(), ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "items/unknown_black_ring")).AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> UNKNOWN_CYAN_RING = ITEMS.register("unknown_cyan_ring",
			() -> new UnknownWizardRingItem(new Item.Properties(), ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "items/unknown_cyan_ring")).AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> UNKNOWN_BEAST_RING = ITEMS.register("unknown_beast_ring",
			() -> new UnknownWizardRingItem(new Item.Properties(), ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "items/unknown_beast_ring")).AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> WIZARD_HEAD = ITEMS.register("wizard_head",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties())
					.ChangeRepairItem(WIZARD_GEM.get()).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> WIZARD_CHESTPLATE = ITEMS.register("wizard_troso",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties())
					.ChangeRepairItem(WIZARD_GEM.get()).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> WIZARD_LEGGINGS = ITEMS.register("wizard_legs",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties())
					.ChangeRepairItem(WIZARD_GEM.get()).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> WIZARDRIVER = ITEMS.register("wizardriver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"wizard",FLAME_WIZARD_RING , WIZARD_HEAD, WIZARD_CHESTPLATE, WIZARD_LEGGINGS,
					new Item.Properties().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)){
				@Override
				public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
					player.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.translatable("ring_holder_gui.text");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
							packetBuffer.writeBlockPos(player.blockPosition());
							packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
							return new RingHolderGuiMenu(id, inventory, packetBuffer,itemstack);
						}
					}, buf -> {
						buf.writeBlockPos(player.blockPosition());
						buf.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
					});
				}

			}.Has_Inventory_Gui().ChangeRepairItem(WIZARD_GEM.get()).AddToTabList(RiderTabs.WIZARD_TAB_ITEM).AddToTabList(Decade_Rider_Items.NEO_DIEND_SUMMON_BELTS));

	public static final DeferredItem<Item> BEAST_DRIVER = ITEMS.register("beastdriver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"beast",BEAST_RING , WIZARD_HEAD, WIZARD_CHESTPLATE, WIZARD_LEGGINGS, new Item.Properties()){
				@Override
				public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
					player.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.translatable("ring_holder_gui.text");
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
						packetBuffer.writeBlockPos(player.blockPosition());
						packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
						return new RingHolderGuiMenuBeast(id, inventory, packetBuffer,itemstack);
					}
				}, buf -> {
					buf.writeBlockPos(player.blockPosition());
					buf.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
				});
			}
			}
					.Has_Inventory_Gui().ChangeRepairItem(WIZARD_GEM.get()).AddToTabList(RiderTabs.WIZARD_TAB_ITEM).AddToTabList(Decade_Rider_Items.NEO_DIEND_SUMMON_BELTS));

	public static final DeferredItem<Item> WHITE_WIZARD_DRIVER = ITEMS.register("whitewizardriver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"wiseman",WISEMAN_RING , WIZARD_HEAD, WIZARD_CHESTPLATE, WIZARD_LEGGINGS, new Item.Properties())
					.Dont_show_belt_form_info().ChangeRepairItem(WIZARD_GEM.get()).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> MAGE_DRIVER = ITEMS.register("magewizardriver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"mage",MAGE_O_RING , WIZARD_HEAD, WIZARD_CHESTPLATE, WIZARD_LEGGINGS, new Item.Properties())
					.Dont_show_belt_form_info().ChangeRepairItem(WIZARD_GEM.get()).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> MAGE_DRIVER_B = ITEMS.register("magewizardriver_b",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"mage_blue",MAGE_B_RING , WIZARD_HEAD, WIZARD_CHESTPLATE, WIZARD_LEGGINGS, new Item.Properties())
					.Dont_show_belt_form_info().ChangeRepairItem(WIZARD_GEM.get()).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> MAGE_DRIVER_G = ITEMS.register("magewizardriver_g",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"mage_green",MAGE_G_RING , WIZARD_HEAD, WIZARD_CHESTPLATE, WIZARD_LEGGINGS, new Item.Properties())
					.Dont_show_belt_form_info().ChangeRepairItem(WIZARD_GEM.get()).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> MAGE_DRIVER_FOOT_SOLDIERS = ITEMS.register("magewizardriver_foot_soldiers",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"mage_foot_soldiers",MAGE_O_RING , WIZARD_HEAD, WIZARD_CHESTPLATE, WIZARD_LEGGINGS, new Item.Properties())
					.Dont_show_belt_form_info().ChangeRepairItem(WIZARD_GEM.get()).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> MAGE_DRIVER_CAPTAIN = ITEMS.register("magewizardriver_captain",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"mage_captain",MAGE_O_RING , WIZARD_HEAD, WIZARD_CHESTPLATE, WIZARD_LEGGINGS, new Item.Properties())
					.Dont_show_belt_form_info().ChangeRepairItem(WIZARD_GEM.get()).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> SORCERER_DRIVER = ITEMS.register("sorcererdriver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"sorcerer",SORCERER_RING , WIZARD_HEAD, WIZARD_CHESTPLATE, WIZARD_LEGGINGS, new Item.Properties())
					.Dont_show_belt_form_info().ChangeRepairItem(WIZARD_GEM.get()).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> WHITE_WIZARD_DRIVER_F = ITEMS.register("whitewizardriver_f",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"wiseman_female",WISEMAN_RING , WIZARD_HEAD, WIZARD_CHESTPLATE, WIZARD_LEGGINGS, new Item.Properties())
					.Dont_show_belt_form_info().ChangeRepairItem(WIZARD_GEM.get()).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> DARK_WIZARDRIVER = ITEMS.register("dark_wizardriver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"dark_wizard",DARK_WIZARD_RING , WIZARD_HEAD, WIZARD_CHESTPLATE, WIZARD_LEGGINGS, new Item.Properties())
					.Dont_show_belt_form_info().ChangeRepairItem(WIZARD_GEM.get()).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> BLACK_WIZARDRIVER = ITEMS.register("black_wizardriver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"black_wizard",BLACK_WIZARD_RING , WIZARD_HEAD, WIZARD_CHESTPLATE, WIZARD_LEGGINGS, new Item.Properties())
					.Dont_show_belt_form_info().ChangeRepairItem(WIZARD_GEM.get()).AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

    public static final DeferredItem<Item> UZAI_BELT = ITEMS.register("uzai_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"uzai", FLAME_WIZARD_RING, WIZARD_HEAD, WIZARD_CHESTPLATE, WIZARD_LEGGINGS, new Item.Properties())
                    .Override_belt_text("uzai_belt_belt").Dont_show_belt_form_info().ChangeRepairItem(WIZARD_GEM.get()).has_basic_model().AddToTabList(RiderTabs.WIZARD_TAB_ITEM));

    public static final DeferredItem<Item> WIZARD_GEM_CRAFTING_CHISEL= ITEMS.register("wizard_gem_crafting_chisel",
			() -> new BaseItem(new Item.Properties()).KeepItem().AddToList(RiderTabs.WIZARD_TAB_ITEM));

	public static final DeferredItem<Item> WIZARSWORDSGUN = ITEMS.register("wizarswordgun",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 2, -2F, new Item.Properties()).IsSwordGun().AddToTabList(RiderTabs.WIZARD_TAB_ITEM).AddToTabList(Decade_Rider_Items.NEO_DIEND_SUMMON_WEAPONS)
					.ChangeRepairItem(WIZARD_GEM.get()));

	public static final DeferredItem<Item> AXCALIBUR = ITEMS.register("axcalibur",
		() -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).IsChangeSword().AddToTabList(RiderTabs.WIZARD_TAB_ITEM).AddToTabList(Decade_Rider_Items.COMPLETE_21_WEAPONS)
				.ChangeRepairItem(WIZARD_GEM.get()));

	public static final DeferredItem<Item> DICE_SABER = ITEMS.register("dice_saber",
			() -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.WIZARD_TAB_ITEM).AddToTabList(Decade_Rider_Items.NEO_DIEND_SUMMON_WEAPONS)
					.ChangeRepairItem(WIZARD_GEM.get()));

	public static final DeferredItem<Item> MIRAGE_MAGNUM = ITEMS.register("mirage_magnum",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).setProjectile(BaseBlasterItem.BlasterProjectile.SMALL_FIREBALL).AddToTabList(RiderTabs.WIZARD_TAB_ITEM)
					.ChangeRepairItem(WIZARD_GEM.get()));

	public static final DeferredItem<Item> WIZARSWORDSGUN_MAGE = ITEMS.register("wizarswordgun_mage",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 2, -2F, new Item.Properties()).IsSwordGun().AddToTabList(RiderTabs.WIZARD_TAB_ITEM)
					.ChangeRepairItem(WIZARD_GEM.get()));

	public static final DeferredItem<Item> HAMMELCANE = ITEMS.register("hammelcane",
			() -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.WIZARD_TAB_ITEM)
					.ChangeRepairItem(WIZARD_GEM.get()));

	public static final DeferredItem<Item> DIS_HALBERD = ITEMS.register("dis_halberd",
			() -> new BaseSwordItem(Tiers.DIAMOND, 9, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.WIZARD_TAB_ITEM)
					.ChangeRepairItem(WIZARD_GEM.get()));



	public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
}
