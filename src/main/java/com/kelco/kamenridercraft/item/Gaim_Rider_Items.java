package com.kelco.kamenridercraft.item;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.bikes.RidevendorVendingModeEntity;
import com.kelco.kamenridercraft.item.BaseItems.*;
import com.kelco.kamenridercraft.item.gaim.*;
import com.kelco.kamenridercraft.item.ooo.CandroidItem;
import com.kelco.kamenridercraft.item.tabs.RiderTabs;
import com.kelco.kamenridercraft.particle.ModParticles;
import com.kelco.kamenridercraft.world.inventory.LockseedHolderGuiMenu;
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
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemContainerContents;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Gaim_Rider_Items {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);

	public static final DeferredItem<Item> GAIM_LOGO = ITEMS.register("gaim_logo",
			() -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/gaim")), new Item.Properties()).AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> HIMAWRI_LOCKSEED = ITEMS.register("himawari_lockseed",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.GAIM_TAB_ITEM));


	public static String[] Can_use_Basic_lockseed = new String[] {"gaim","baron","ryugen","zangetsu","gridon","kurokage"
			,"bravo","knuckle","bujin_gaim","fifteen","mars","kamuro","jam","kurokage_troopers","idunn","sengoku_duke","baron_black",
	"saver","maja","proto_gaim","proto_ryugen","proto_baron","proto_gridon","proto_bravo","sylphi","gaim_natsumikan"};


	public static String[] Can_use_Energy_lockseed = new String[] {"zangetsu_shin","baron_shin","ryugen_shin","duke","sigurd","marika","kurokage_shin"
	,"tyrant"};

	public static String[] Can_use_Legend_lockseed = new String[] {"gaim","baron","ryugen","zangetsu","gridon","kurokage"
			,"bravo","knuckle","bujin_gaim","fifteen","mars","kamuro","jam","kurokage_troopers","idunn","sengoku_duke","baron_black",
			"saver","maja","proto_gaim","proto_ryugen","proto_baron","proto_gridon","proto_bravo","sylphi","gaim_natsumikan"
	,"zangetsu_shin","baron_shin","ryugen_shin","duke","sigurd","marika","kurokage_shin","tyrant"};

	public static String[] Can_use_Jimber_Arms = new String[] {"gaim","ryugen","zangetsu","bravo","knuckle"};


	public static final DeferredItem<Item> MATSUBOKKURI_LOCKSEED = ITEMS.register("matsubokkuri_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"matsubokkuri_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BROWN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> KURUMI_LOCKSEED = ITEMS.register("kurumi_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"kurumi_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(Effect_core.PUNCH, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BROWN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> DONGURI_LOCKSEED = ITEMS.register("donguri_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"donguri_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BROWN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> MELON_LOCKSEED = ITEMS.register("melon_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"melon_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> PINE_LOCKSEED = ITEMS.register("pine_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"pine_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> ICHIGO_LOCKSEED = ITEMS.register("ichigo_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"ichigo_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> ORANGE_LOCKSEED = ITEMS.register("orange_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"orange_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> BANANA_LOCKSEED = ITEMS.register("banana_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"banana_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> BUDOU_LOCKSEED = ITEMS.register("budou_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"budou_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> SUIKA_LOCKSEED = ITEMS.register("suika_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"suika_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(Effect_core.BIG, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> MANGO_LOCKSEED = ITEMS.register("mango_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"mango_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> DURIAN_LOCKSEED = ITEMS.register("durian_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"durian_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> KIWI_LOCKSEED = ITEMS.register("kiwi_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"kiwi_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BROWN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> LEMON_LOCKSEED = ITEMS.register("lemon_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"lemon_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> JIMBER_GAIM_CORE = ITEMS.register("jimber_gaim_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_jimber","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Jimber_Arms).ChangeSlot(2).model_has_different_name("gaim_logo").has_basic_model());

	public static final DeferredItem<Item> JIMBER_LEMON_ENERGY_LOCKSEED = ITEMS.register("jimber_lemon_energy",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"jimbar_lemon_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Jimber_Arms).ResetFormToBase().alsoChange2ndSlot(JIMBER_GAIM_CORE.get())
					.model_has_different_name("lemon_energy_lockseed").has_basic_model());

	public static final DeferredItem<Item> LEMON_ENERGY_LOCKSEED = ITEMS.register("lemon_energy_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"energy_lemon_arms","zangetsu_shin","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Energy_lockseed).addAlternative(JIMBER_LEMON_ENERGY_LOCKSEED.get()).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> JIMBER_CHERRY_ENERGY_LOCKSEED = ITEMS.register("jimber_cherry_energy",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"jimbar_cherry_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Jimber_Arms).ResetFormToBase().alsoChange2ndSlot(JIMBER_GAIM_CORE.get())
					.model_has_different_name("cherry_energy_lockseed").has_basic_model());

	public static final DeferredItem<Item> CHERRY_ENERGY_LOCKSEED = ITEMS.register("cherry_energy_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"energy_cherry_arms","zangetsu_shin","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Energy_lockseed).addAlternative(JIMBER_CHERRY_ENERGY_LOCKSEED.get()).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> JIMBER_PEACH_ENERGY_LOCKSEED = ITEMS.register("jimber_peach_energy",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"jimbar_peach_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Jimber_Arms).ResetFormToBase().alsoChange2ndSlot(JIMBER_GAIM_CORE.get())
					.model_has_different_name("peach_energy_lockseed").has_basic_model());

	public static final DeferredItem<Item> PEACH_ENERGY_LOCKSEED = ITEMS.register("peach_energy_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"energy_peach_arms","zangetsu_shin","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Energy_lockseed).ResetFormToBase().addAlternative(JIMBER_PEACH_ENERGY_LOCKSEED.get()).AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> JIMBER_MELON_ENERGY_LOCKSEED = ITEMS.register("jimber_melon_energy",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"jimbar_melon_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Jimber_Arms).ResetFormToBase().alsoChange2ndSlot(JIMBER_GAIM_CORE.get())
					.model_has_different_name("melon_energy_lockseed").has_basic_model());

	public static final DeferredItem<Item> MELON_ENERGY_LOCKSEED = ITEMS.register("melon_energy_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"energy_melon_arms","zangetsu_shin","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Energy_lockseed).ResetFormToBase().addAlternative(JIMBER_MELON_ENERGY_LOCKSEED.get()).AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> MATSUBOKKURI_ENERGY_LOCKSEED = ITEMS.register("matsubokkuri_energy_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"energy_matsubokkuri_arms","zangetsu_shin","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BROWN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Energy_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> JIMBER_DRAGON_FRUITS_ENERGY_LOCKSEED = ITEMS.register("jimber_dragon_fruits_energy",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"jimbar_dragon_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Jimber_Arms).ResetFormToBase().alsoChange2ndSlot(JIMBER_GAIM_CORE.get())
					.model_has_different_name("dragon_fruits_energy_lockseed").has_basic_model());

	public static final DeferredItem<Item> DRAGON_FRUITS_ENERGY_LOCKSEED = ITEMS.register("dragon_fruits_energy_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"energy_dragon_fruits_arms","zangetsu_shin","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Energy_lockseed).ResetFormToBase().addAlternative(JIMBER_DRAGON_FRUITS_ENERGY_LOCKSEED.get()).AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> PROTO_DRAGON_FRUITS_ENERGY_LOCKSEED = ITEMS.register("proto_dragon_fruits_energy_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"energy_prototype_dragon_fruits_arms","zangetsu_shin","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Energy_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> MARRON_ENERGY_LOCKSEED = ITEMS.register("marron_energy_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"jimbar_marron_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(Effect_core.PUNCH, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BROWN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Jimber_Arms).ResetFormToBase().alsoChange2ndSlot(JIMBER_GAIM_CORE.get()).AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> KACHIDOKI_LOCKSEED = ITEMS.register("kachidoki_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"kachidoki_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> ZANGETSU_KACHIDOKI_LOCKSEED = ITEMS.register("zangetsu_kachidoki_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"zangetsu_kachidoki_arms","zangetsu","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> KIWAMI_LOCKSEED = ITEMS.register("kiwami_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"kiwami_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.ResetFormToBase().addNeedForm(KACHIDOKI_LOCKSEED.get(),1).AddToList(RiderTabs.GAIM_TAB_ITEM).AddToList(Decade_Rider_Items.COMPLETE_21_FORMS));

	public static final DeferredItem<Item> YOMOTSU_HEGURI_LOCKSEED = ITEMS.register("yomotsu_heguri_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"yomotsu_heguri_arms","ryugen","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.WITHER, 40, 5,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.DARK_RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.DARK_GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> BLOOD_ORANGE_LOCKSEED = ITEMS.register("blood_orange_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"blood_orange_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.DARK_RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> OCHIMUSHA_LOCKSEED = ITEMS.register("blood_orange_lockseed_ochimusha",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"ochimusha_arms","bujin_gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.DARK_RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> FIFTEEN_LOCKSEED = ITEMS.register("fifteen_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"fifteen_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> GOLDEN_RINGO_LOCKSEED = ITEMS.register("golden_ringo_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"golden_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> SILVER_RINGO_LOCKSEED = ITEMS.register("silver_ringo_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"silver_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> BLACK_RINGO_LOCKSEED = ITEMS.register("black_ringo_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"darkness_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> FORBIBBEN_LOCKSEED_BASE = ITEMS.register("forbidden_ringo_lockseed_base",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"ringo_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);


                }
            }
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase()
					.model_has_different_name("forbidden_ringo_lockseed").has_basic_model());

	public static final DeferredItem<Item> FORBIBBEN_LOCKSEED = ITEMS.register("forbidden_ringo_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"baron_ringo_arms","baron","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);


                }
            }
					.addAlternative(FORBIBBEN_LOCKSEED_BASE.get()).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> WATERMELON_LOCKSEED = ITEMS.register("watermelon_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"watermelon_arms","zangetsu","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);


                }
            }
					.ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> ZAKURO_LOCKSEED = ITEMS.register("zakuro_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"blood_zakuro_arms","saver","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.BLINDNESS, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.DARK_RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);


                }
            }
					.addNeedItem(BLOOD_ORANGE_LOCKSEED.get()).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> MAJA_LOCKSEED = ITEMS.register("maja_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"maja_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);


                }
            }
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> KABI_ORANGE_LOCKSEED = ITEMS.register("kabi_orange_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"kabi_orange_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.WEAKNESS, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> FRESH_ORANGE_LOCKSEED = ITEMS.register("fresh_orange_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"fresh_orange_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 20, 0, 0, 0, 1);


                }
            }
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> FRESH_PINE_LOCKSEED = ITEMS.register("fresh_pine_lockseed",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> LYCHEE_LOCKSEED = ITEMS.register("lychee_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"lychee_arms","gridon","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BROWN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);


                }
            }
					.ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> KING_DURIAN_LOCKSEED = ITEMS.register("king_durian_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"king_durian_arms","bravo","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);


                }
            }
					.ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> HELEIM_LOCKSEED = ITEMS.register("helheim_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"hells_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);


                }
            }
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> NATSUMIKAN_LOCKSEED = ITEMS.register("natsumikan_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"natsumikan_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> PROTO_DONGURI_LOCKSEED = ITEMS.register("proto_donguri_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"proto_donguri_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BROWN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> PROTO_ORANGE_LOCKSEED = ITEMS.register("proto_orange_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"proto_orange_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> PROTO_BANANA_LOCKSEED = ITEMS.register("proto_banana_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"proto_banana_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> PROTO_BUDOU_LOCKSEED = ITEMS.register("proto_budou_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"proto_budou_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> PROTO_DURIAN_LOCKSEED = ITEMS.register("proto_durian_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"proto_durian_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Basic_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));


	public static final DeferredItem<Item> DARK_ORANGE_LOCKSEED = ITEMS.register("dark_orange_lockseed",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> GAIM_YAMI_CORE = ITEMS.register("gaim_yami",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_yami","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }.ChangeSlot(2)
					.model_has_different_name("gaim_logo").has_basic_model());

	public static final DeferredItem<Item> DARK_LEMON_ENERGY_LOCKSEED = ITEMS.register("dark_lemon_energy_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"jimbar_black_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.ResetFormToBase().alsoChange2ndSlot(GAIM_YAMI_CORE.get()).addNeedItem(DARK_ORANGE_LOCKSEED.get()).AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> CHISTMAS_LOCKSEED = ITEMS.register("christmas_lockseed",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> ROULETTE_LOCKSEED = ITEMS.register("roulette_lockseed",
			() -> new RouletteLockseedItem(new Item.Properties()).AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> FAKE_DONGURI_LOCKSEED = ITEMS.register("fake_donguri_lockseed",
			() -> new FakeLockseedItem(new Item.Properties()).AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> SID_LOCKSEED = ITEMS.register("sid_lockseed",
			() -> new SidLockseedItem(new Item.Properties(),500).AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> XIAOLONGBAO_LOCKSEED = ITEMS.register("xiaolongbao_lockseed",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> HSIAO_LUNG_PAO_LOCKSEED = ITEMS.register("hsiao_lung_pao_lockseed",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> TOM_YUM_KUNG_LOCKSEED = ITEMS.register("tom_yum_kung_lockseed",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> YUMMY_LOCKSEED = ITEMS.register("yummy_lockseed",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> HERO_LOCKSEED = ITEMS.register("hero_lockseed",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.GAIM_TAB_ITEM));


	public static final DeferredItem<Item> DRIVE_LOCKSEED = ITEMS.register("drive_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"drive_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 20, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Legend_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> GAIM_LOCKSEED = ITEMS.register("gaim_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"gaim_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Legend_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> WIZARD_LOCKSEED = ITEMS.register("wizard_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"wizard_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 20, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Legend_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> FOURZE_LOCKSEED = ITEMS.register("fourze_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"fourze_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 20, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Legend_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> OOO_LOCKSEED = ITEMS.register("ooo_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"ooo_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Legend_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> W_LOCKSEED = ITEMS.register("w_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"w_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(Effect_core.PUNCH, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Legend_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> DECADE_LOCKSEED = ITEMS.register("decade_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"decade_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 20, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Legend_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> KIVA_LOCKSEED = ITEMS.register("kiva_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"kiva_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 20, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Legend_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> DEN_O_LOCKSEED = ITEMS.register("den_o_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"den_o_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Legend_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> KABUTO_LOCKSEED = ITEMS.register("kabuto_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"kabuto_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
                    	.AddCompatibilityList(Can_use_Legend_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> HIBIKI_LOCKSEED = ITEMS.register("hibiki_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"hibiki_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Legend_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> BLADE_LOCKSEED = ITEMS.register("blade_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"blade_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Legend_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> FAIZ_LOCKSEED = ITEMS.register("faiz_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"faiz_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Legend_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> RYUKI_LOCKSEED = ITEMS.register("ryuki_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"ryuki_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 20, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Legend_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> AGITO_LOCKSEED = ITEMS.register("agito_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"agito_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Legend_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> KUUGA_LOCKSEED = ITEMS.register("kuuga_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"kuuga_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(Effect_core.PUNCH, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Legend_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> RIDER_ICHIGO_LOCKSEED = ITEMS.register("rider_ichigo_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"rider_ichigo_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Legend_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> SHOWA_RIDER_LOCKSEED = ITEMS.register("showa_rider_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"rider_ichigo_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Legend_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> HEISEI_RIDER_LOCKSEED = ITEMS.register("heisei_rider_lockseed",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"gaim_arms","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
					.AddCompatibilityList(Can_use_Legend_lockseed).ResetFormToBase().AddToList(RiderTabs.GAIM_TAB_ITEM));

    public static final DeferredItem<Item> SAKURA_HURRICANE = ITEMS.register("sakura_hurricane",
            () -> new SummonBikeItem(new Item.Properties(),Component.translatable("bike.sakura_hurricane"), MobsCore.SAKURA_HURRICANE)
                    .has_basic_model().AddToList(RiderTabs.GAIM_TAB_ITEM));

    public static final DeferredItem<Item> ROSE_ATTACKER = ITEMS.register("rose_attacker",
            () -> new SummonBikeItem(new Item.Properties(),Component.translatable("bike.rose_attacker"), MobsCore.ROSE_ATTACKER)
                    .has_basic_model().AddToList(RiderTabs.GAIM_TAB_ITEM));

    public static final DeferredItem<Item> DANDELINER = ITEMS.register("dandeliner",
            () -> new BaseItem(new Item.Properties()).has_basic_model().AddToList(RiderTabs.GAIM_TAB_ITEM));

    public static final DeferredItem<Item> TULIP_HOPPER = ITEMS.register("tulip_hopper",
            () -> new BaseItem(new Item.Properties()).has_basic_model().AddToList(RiderTabs.GAIM_TAB_ITEM));

    /**
	dandeliner
	tulip_hopper
**/

    public static final DeferredItem<Item> MEGAHEX_CORE = ITEMS.register("megahex_core",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"","megahex","blank",
                    new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }.has_basic_model());


    public static final DeferredItem<Item> MEGAHEX_KIWAMI = ITEMS.register("megahex_kiwami",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"_kiwami","megahex","blank",
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
                    new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.REGENERATION, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }.addAlternative(MEGAHEX_CORE.get()).addNeedItem(KIWAMI_LOCKSEED.get()).has_basic_model().model_has_different_name("megahex_core").AddToList(RiderTabs.GAIM_TAB_ITEM));


    public static final DeferredItem<Item> GAIM_HELMET = ITEMS.register("gaimhead",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));
	public static final DeferredItem<Item> GAIM_CHESTPLATE = ITEMS.register("gaimtroso",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));
	public static final DeferredItem<Item> GAIM_LEGGINGS = ITEMS.register("gaimlegs",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BASIC_GAIM_CORE = ITEMS.register("basic_gaim_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","gaim","sengoku_driver_belt",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2)
					.model_has_different_name("gaim_logo").has_basic_model());

	public static final DeferredItem<Item> SENGOKU_DRIVER_GAIM = ITEMS.register("sengoku_driver_gaim",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"gaim",ORANGE_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS ,
					new Item.Properties().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)){
				@Override
				public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
					player.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.translatable("lockseed_holder.text");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
							packetBuffer.writeBlockPos(player.blockPosition());
							packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
							return new LockseedHolderGuiMenu(id, inventory, packetBuffer,itemstack);
						}
					}, buf -> {
						buf.writeBlockPos(player.blockPosition());
						buf.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
					});
				}
			}.Has_Inventory_Gui().Add_Extra_Base_Form_Items(BASIC_GAIM_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).AddToTabList(Decade_Rider_Items.NEO_DIEND_SUMMON_BELTS).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BASIC_BARON_CORE = ITEMS.register("basic_baron_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","baron","sengoku_driver_belt_baron",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2)
					.model_has_different_name("gaim_logo").has_basic_model());

	public static final DeferredItem<Item> SENGOKU_DRIVER_BARON = ITEMS.register("sengoku_driver_baron",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"baron",BANANA_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_BARON_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).AddToTabList(Decade_Rider_Items.NEO_DIEND_SUMMON_BELTS).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BASIC_RYUGEN_CORE= ITEMS.register("basic_ryugen_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","ryugen","sengoku_driver_belt_ryugen",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2)
					.model_has_different_name("gaim_logo").has_basic_model());

	public static final DeferredItem<Item> SENGOKU_DRIVER_RYUGEN = ITEMS.register("sengoku_driver_ryugen",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"ryugen",BUDOU_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_RYUGEN_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BASIC_ZENGETSU_CORE= ITEMS.register("basic_zangetsu_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","zangetsu","sengoku_driver_belt_zangetsu",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2)
					.model_has_different_name("gaim_logo").has_basic_model());

	public static final DeferredItem<Item> SENGOKU_DRIVER_ZENGETSU = ITEMS.register("sengoku_driver_zangetsu",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"zangetsu",MELON_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_ZENGETSU_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BASIC_GRIDON_CORE= ITEMS.register("basic_gridon_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","gridon","sengoku_driver_belt_gridon",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2)
					.model_has_different_name("gaim_logo").has_basic_model());

	public static final DeferredItem<Item> SENGOKU_DRIVER_GRIDON = ITEMS.register("sengoku_driver_gridon",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"gridon",DONGURI_LOCKSEED, GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_GRIDON_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BASIC_KUROKAGE_CORE= ITEMS.register("basic_kurokage_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","kurokage","sengoku_driver_belt_kurokage",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2)
					.model_has_different_name("gaim_logo").has_basic_model());

	public static final DeferredItem<Item> SENGOKU_DRIVER_KUROKAGE = ITEMS.register("sengoku_driver_kurokage",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"kurokage",MATSUBOKKURI_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_KUROKAGE_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BASIC_BRAVO_CORE= ITEMS.register("basic_bravo_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","bravo","sengoku_driver_belt_bravo",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2)
					.model_has_different_name("gaim_logo").has_basic_model());

	public static final DeferredItem<Item> SENGOKU_DRIVER_BRAVO = ITEMS.register("sengoku_driver_bravo",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"bravo",DURIAN_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_BRAVO_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BASIC_KNUCKLE_CORE= ITEMS.register("basic_knuckle_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","knuckle","sengoku_driver_belt_knuckle",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2)
					.model_has_different_name("gaim_logo").has_basic_model());

	public static final DeferredItem<Item> SENGOKU_DRIVER_KNUCKLE= ITEMS.register("sengoku_driver_knuckle",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"knuckle",KURUMI_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_KNUCKLE_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BASIC_BUJIN_GAIM_CORE= ITEMS.register("basic_bujin_gaim_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","bujin_gaim","sengoku_driver_belt_bujin_gaim",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2)
					.model_has_different_name("gaim_logo").has_basic_model());

	public static final DeferredItem<Item> SENGOKU_DRIVER_BUJIN_GAIM= ITEMS.register("sengoku_driver_bujin_gaim",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"bujin_gaim",BLOOD_ORANGE_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_BUJIN_GAIM_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BASIC_FIFTEEN_CORE= ITEMS.register("basic_fifteen_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","fifteen","sengoku_driver_belt_fifteen",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2)
					.model_has_different_name("gaim_logo").has_basic_model());

	public static final DeferredItem<Item> SENGOKU_DRIVER_FIFTEEN= ITEMS.register("sengoku_driver_fifteen",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"fifteen",FIFTEEN_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_FIFTEEN_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BASIC_MARS_CORE= ITEMS.register("basic_mars_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","mars","sengoku_driver_belt_mars",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2)
					.model_has_different_name("gaim_logo").has_basic_model());

	public static final DeferredItem<Item> SENGOKU_DRIVER_MARS= ITEMS.register("sengoku_driver_mars",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"mars",GOLDEN_RINGO_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_MARS_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BASIC_KAMURO_CORE= ITEMS.register("basic_kamuro_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","kamuro","sengoku_driver_belt_kamuro",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2)
					.model_has_different_name("gaim_logo").has_basic_model());

	public static final DeferredItem<Item> SENGOKU_DRIVER_KAMURO= ITEMS.register("sengoku_driver_kamuro",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"kamuro",SILVER_RINGO_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_KAMURO_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BASIC_JAM_CORE= ITEMS.register("basic_jam_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","jam","sengoku_driver_belt_jam",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2)
					.model_has_different_name("gaim_logo").has_basic_model());

	public static final DeferredItem<Item> SENGOKU_DRIVER_JAM= ITEMS.register("sengoku_driver_jam",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"jam",BLACK_RINGO_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_JAM_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BASIC_KUROKAGE_TOOPERS_CORE= ITEMS.register("basic_kurokage_troopers_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","kurokage_troopers","sengoku_driver_belt_kurokage_trooper",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2)
					.model_has_different_name("gaim_logo").has_basic_model());

	public static final DeferredItem<Item> SENGOKU_DRIVER_KUROKAGE_TOOPERS= ITEMS.register("sengoku_driver_kurokage_troopers",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"kurokage_troopers",MATSUBOKKURI_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_KUROKAGE_TOOPERS_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BASIC_IDUNN_CORE= ITEMS.register("basic_idunn_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","idunn","sengoku_driver_belt_idunn",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2)
					.model_has_different_name("gaim_logo").has_basic_model());

	public static final DeferredItem<Item> SENGOKU_DRIVER_IDUNN= ITEMS.register("sengoku_driver_idunn",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"idunn",FORBIBBEN_LOCKSEED_BASE , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_IDUNN_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BASIC_DUKE_CORE= ITEMS.register("basic_duke_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","duke_sengoku","sengoku_driver_belt_duke",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2)
					.model_has_different_name("gaim_logo").has_basic_model());

	public static final DeferredItem<Item> SENGOKU_DRIVER_DUKE= ITEMS.register("sengoku_driver_duke",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"duke_sengoku",LEMON_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_DUKE_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BASIC_BLACK_BARON_CORE = ITEMS.register("basic_black_baron_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","black_baron","sengoku_driver_belt_black_baron",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2)
					.model_has_different_name("gaim_logo").has_basic_model());

	public static final DeferredItem<Item> SENGOKU_DRIVER_BLACK_BARON = ITEMS.register("sengoku_driver_black_baron",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"black_baron",BANANA_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_BLACK_BARON_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BASIC_SAVER_CORE= ITEMS.register("basic_saver_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","saver","sengoku_driver_belt_saver",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2)
					.model_has_different_name("gaim_logo").has_basic_model());

	public static final DeferredItem<Item> SENGOKU_DRIVER_SAVER= ITEMS.register("sengoku_driver_saver",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"saver",ZAKURO_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_SAVER_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BASIC_MAJA_CORE= ITEMS.register("basic_maja_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","maja","sengoku_driver_belt_maja",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2)
					.model_has_different_name("gaim_logo").has_basic_model());

	public static final DeferredItem<Item> SENGOKU_DRIVER_MAJA= ITEMS.register("sengoku_driver_maja",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"maja",MAJA_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_MAJA_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BASIC_SYLPHI_CORE= ITEMS.register("basic_sylphi_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","sylphi","sengoku_driver_belt_sylphi",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2)
					.model_has_different_name("gaim_logo").has_basic_model());

	public static final DeferredItem<Item> SENGOKU_DRIVER_SYLPHI= ITEMS.register("sengoku_driver_sylphi",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"sylphi",HELEIM_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_SYLPHI_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> SENGOKU_DRIVER_GAIM_NATSUMIKAN = ITEMS.register("sengoku_driver_gaim_natsumikan",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"gaim_natsumikan",NATSUMIKAN_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_GAIM_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BASIC_PROTO_GAIM_CORE = ITEMS.register("basic_proto_gaim_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","proto_gaim","sengoku_driver_belt_proto_gaim",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2)
					.model_has_different_name("gaim_logo").has_basic_model());

	public static final DeferredItem<Item> SENGOKU_DRIVER_PROTO_GAIM = ITEMS.register("sengoku_driver_proto_gaim",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"proto_gaim",PROTO_ORANGE_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_PROTO_GAIM_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BASIC_PROTO_BARON_CORE = ITEMS.register("basic_proto_baron_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","proto_baron","sengoku_driver_belt_proto_baron",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2)
					.model_has_different_name("gaim_logo").has_basic_model());

	public static final DeferredItem<Item> SENGOKU_DRIVER_PROTO_BARON = ITEMS.register("sengoku_driver_proto_baron",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"proto_baron",PROTO_BANANA_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_PROTO_BARON_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BASIC_PROTO_RYUGEN_CORE= ITEMS.register("basic_proto_ryugen_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","proto_ryugen","sengoku_driver_belt_proto_ryugen",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2)
					.model_has_different_name("gaim_logo").has_basic_model());

	public static final DeferredItem<Item> SENGOKU_DRIVER_PROTO_RYUGEN = ITEMS.register("sengoku_driver_proto_ryugen",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"proto_ryugen",PROTO_BUDOU_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_PROTO_RYUGEN_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BASIC_PROTO_GRIDON_CORE= ITEMS.register("basic_proto_gridon_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","proto_gridon","sengoku_driver_belt_proto_gridon",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2)
					.model_has_different_name("gaim_logo").has_basic_model());

	public static final DeferredItem<Item> SENGOKU_DRIVER_PROTO_GRIDON = ITEMS.register("sengoku_driver_proto_gridon",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"proto_gridon",PROTO_DONGURI_LOCKSEED, GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_PROTO_GRIDON_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BASIC_PROTO_BRAVO_CORE= ITEMS.register("basic_proto_bravo_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","proto_bravo","sengoku_driver_belt_proto_bravo",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2)
					.model_has_different_name("gaim_logo").has_basic_model());


	public static final DeferredItem<Item> SENGOKU_DRIVER_PROTO_KUROKAGE = ITEMS.register("sengoku_driver_proto_bravo",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"proto_bravo",PROTO_DURIAN_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(BASIC_PROTO_BRAVO_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));


	public static final DeferredItem<Item> GENESIS_CORE= ITEMS.register("genesis_core",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","duke","genesis_driver_belt",
					new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)).ChangeSlot(2)
					.model_has_different_name("gaim_logo").has_basic_model());

	public static final DeferredItem<Item> GENESIS_DRIVER_ZANGETSU_SHIN= ITEMS.register("genesis_driver_zangetsu_shin",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"zangetsu_shin",MELON_ENERGY_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties().rarity(Rarity.UNCOMMON))
					.Add_Extra_Base_Form_Items(GENESIS_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> GENESIS_DRIVER_DUKE= ITEMS.register("genesis_driver_duke",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"duke",LEMON_ENERGY_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(GENESIS_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> GENESIS_DRIVER_SIGURD= ITEMS.register("genesis_driver_sigurd",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"sigurd",CHERRY_ENERGY_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(GENESIS_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> GENESIS_DRIVER_MARIKA= ITEMS.register("genesis_driver_marika",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"marika",PEACH_ENERGY_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(GENESIS_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> GENESIS_DRIVER_BARON_SHIN= ITEMS.register("genesis_driver_baron_shin",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"baron_shin",LEMON_ENERGY_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties().rarity(Rarity.UNCOMMON))
					.Add_Extra_Base_Form_Items(GENESIS_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> GENESIS_DRIVER_KUROKAGE_SHIN= ITEMS.register("genesis_driver_kurokage_shin",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"kurokage_shin",MATSUBOKKURI_ENERGY_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties().rarity(Rarity.UNCOMMON))
					.Add_Extra_Base_Form_Items(GENESIS_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> GENESIS_DRIVER_TYRANT= ITEMS.register("genesis_driver_tyrant",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"tyrant",PROTO_DRAGON_FRUITS_ENERGY_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(GENESIS_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> GENESIS_DRIVER_RYUGEN= ITEMS.register("genesis_driver_ryugen_shin",
			() -> new SengokuDriverItem(ArmorMaterials.DIAMOND,"ryugen_shin",MELON_ENERGY_LOCKSEED , GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties().rarity(Rarity.UNCOMMON))
					.Add_Extra_Base_Form_Items(GENESIS_CORE).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

    public static final DeferredItem<Item> MEGAHEX = ITEMS.register("megahex",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"megahex",MEGAHEX_CORE ,GAIM_HELMET,GAIM_CHESTPLATE,GAIM_LEGGINGS , new Item.Properties())
                    .Dont_show_belt_form_info().AddToTabList(RiderTabs.GAIM_TAB_ITEM).has_basic_model().ChangeRepairItem(HIMAWRI_LOCKSEED.get()));


    public static final DeferredItem<Item> MUSOU_SABER = ITEMS.register("musou_saber",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GAIM_TAB_ITEM).AddToTabList(Decade_Rider_Items.NEO_DIEND_SUMMON_WEAPONS).AddToTabList(Decade_Rider_Items.COMPLETE_21_WEAPONS).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> MUSOU_SABER_NAGINATA = ITEMS.register("musou_saber_naginata",
			() -> new BaseSwordItem(Tiers.DIAMOND, 8, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BLOOD_MUSOU_SABER_NAGINATA = ITEMS.register("blood_musou_saber_naginata",
			() -> new BaseSwordItem(Tiers.DIAMOND, 8, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> MUSOU_SABER_KUSARIGAMA = ITEMS.register("musou_saber_kusarigama",
			() -> new BaseSwordItem(Tiers.DIAMOND, 10, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> DJ_GUN = ITEMS.register("dj_gun",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 11, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).AddToTabList(RiderTabs.GAIM_TAB_ITEM).AddToTabList(Decade_Rider_Items.COMPLETE_21_WEAPONS).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> DJ_GUN_TAIKEN_MODE = ITEMS.register("dj_gun_taiken_mode",
			() -> new BaseSwordItem(Tiers.DIAMOND, 18, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> KACHIDOKI_BATA = ITEMS.register("kachidoki_bata",
			() -> new BaseSwordItem(Tiers.DIAMOND, 9, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	// public static final DeferredItem<Item> DJ_GUN_SOJINTO_MODE = ITEMS.register("dj_gun_sojinto_mode",
	// 		() -> new BaseSwordItem(Tiers.DIAMOND, 22, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> ZANGETSU_DJ_GUN = ITEMS.register("zangetsu_dj_gun",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 11, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> ZANGETSU_DJ_GUN_TAIKEN_MODE = ITEMS.register("zangetsu_dj_gun_taiken_mode",
			() -> new BaseSwordItem(Tiers.DIAMOND, 18, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> ZANGETSU_KACHIDOKI_BATA = ITEMS.register("zangetsu_kachidoki_bata",
			() -> new BaseSwordItem(Tiers.DIAMOND, 9, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> JOESHUIMU = ITEMS.register("joeshuimu",
			() -> new BaseSwordItem(Tiers.DIAMOND, 18, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> SHEIMU = ITEMS.register("sheimu",
			() -> new BaseSwordItem(Tiers.DIAMOND, 18, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> DAU = ITEMS.register("dau",
			() -> new BaseSwordItem(Tiers.DIAMOND, 18, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> DIMUBU = ITEMS.register("dimubu",
			() -> new BaseSwordItem(Tiers.DIAMOND, 18, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> GURONBARYAMU = ITEMS.register("guronbaryamu",
			() -> new BaseSwordItem(Tiers.DIAMOND, 18, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> SHINE_DONKACHI = ITEMS.register("shine_donkachi",
			() -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> SHINE_LYCHEE_SWORD = ITEMS.register("shine_lychee_sword",
			() -> new BaseSwordItem(Tiers.DIAMOND, 18, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> HELLS_CANE = ITEMS.register("hells_cane",
			() -> new BaseSwordItem(Tiers.DIAMOND, 18, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> KAGEMATSU = ITEMS.register("kagematsu",
			() -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> DONKACHI = ITEMS.register("donkachi",
			() -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GAIM_TAB_ITEM).AddToTabList(Decade_Rider_Items.COMPLETE_21_WEAPONS).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> MELON_DEFENDER = ITEMS.register("melon_defender",
			() -> new BaseShieldItem(new Item.Properties()).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> PINE_IRON = ITEMS.register("pine_iron",
			() -> new BaseSwordItem(Tiers.DIAMOND, 7, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GAIM_TAB_ITEM).AddToTabList(Decade_Rider_Items.COMPLETE_21_WEAPONS).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<SwordItem> ICHIGO_KUNAI = ITEMS.register("ichigo_kunai",
			() -> new BaseThrowableItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GAIM_TAB_ITEM).AddToTabList(Decade_Rider_Items.COMPLETE_21_WEAPONS).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> DAIDAIMARU = ITEMS.register("daidaimaru",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GAIM_TAB_ITEM).AddToTabList(Decade_Rider_Items.NEO_DIEND_SUMMON_WEAPONS).AddToTabList(Decade_Rider_Items.COMPLETE_21_WEAPONS).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BANA_SPEAR = ITEMS.register("banana_spear",
			() -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GAIM_TAB_ITEM).AddToTabList(Decade_Rider_Items.NEO_DIEND_SUMMON_WEAPONS).AddToTabList(Decade_Rider_Items.COMPLETE_21_WEAPONS).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BUDOU_RYUHOU = ITEMS.register("budou_ryuhou",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GAIM_TAB_ITEM).AddToTabList(Decade_Rider_Items.COMPLETE_21_WEAPONS).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> MANGO_PUNISHER = ITEMS.register("mango_punisher",
			() -> new BaseSwordItem(Tiers.DIAMOND, 9, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GAIM_TAB_ITEM).AddToTabList(Decade_Rider_Items.COMPLETE_21_WEAPONS).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> DURI_NOKO = ITEMS.register("duri_noko",
			() -> new BaseSwordItem(Tiers.DIAMOND, 8, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GAIM_TAB_ITEM).AddToTabList(Decade_Rider_Items.COMPLETE_21_WEAPONS).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> KIWI_GEKIRIN = ITEMS.register("kiwi_gekirin",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GAIM_TAB_ITEM).AddToTabList(Decade_Rider_Items.COMPLETE_21_WEAPONS).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> SONIC_ARROW = ITEMS.register("sonic_arrow",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 9, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> KAGEMATSU_SHIN = ITEMS.register("kagematsu_shin",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> SUIKA_SOJINTO = ITEMS.register("suika_sojinto",
			() -> new BaseSwordItem(Tiers.DIAMOND, 8, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> SUIKA_SOJINTO_BARON_VER = ITEMS.register("suika_sojinto_baron_ver",
			() -> new BaseSwordItem(Tiers.DIAMOND, 8, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> SUIKA_SOJINTO_KNUCKLE_VER = ITEMS.register("suika_sojinto_knuckle_ver",
			() -> new BaseSwordItem(Tiers.DIAMOND, 8, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> GIGA_DURI_NOKO = ITEMS.register("king_duri_noko",
			() -> new BaseSwordItem(Tiers.DIAMOND, 8, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> BLOOD_DAIDAIMARU = ITEMS.register("blood_daidaimaru",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> YOMIMARU = ITEMS.register("yomimaru",
			() -> new BaseSwordItem(Tiers.DIAMOND, 9, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> SWORD_BRINGER = ITEMS.register("sword_bringer",
			() -> new BaseSwordItem(Tiers.DIAMOND, 9, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> APPLE_REFLECTER = ITEMS.register("apple_reflecter",
			() -> new BaseShieldItem(new Item.Properties()).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> LEMON_RAPIER = ITEMS.register("lemon_rapier",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> SOUGINJOU = ITEMS.register("souginjou",
			() -> new BaseSwordItem(Tiers.DIAMOND, 8, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> DARK_DAIDAIMARU = ITEMS.register("dark_daidaimaru",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> WATERMELON_DEFENDER = ITEMS.register("watermelon_defender",
			() -> new BaseShieldItem(new Item.Properties()).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> SAVER_ARROW = ITEMS.register("saver_arrow",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 12, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> KABI_DAIDAIMARU = ITEMS.register("kabi_daidaimaru",
			() -> new BaseSwordItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> MAJAS_SWORD = ITEMS.register("maja_yomimaru",
			() -> new BaseSwordItem(Tiers.DIAMOND, 9, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GAIM_TAB_ITEM).ChangeRepairItem(HIMAWRI_LOCKSEED.get()));

	public static final DeferredItem<Item> LORD_BARON_FRAGMENT = ITEMS.register("lord_baron_fragment",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> LORD_BARON_FRAGMENT_2 = ITEMS.register("lord_baron_fragment_2",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item> LORD_BARON_FRAGMENT_3 = ITEMS.register("lord_baron_fragment_3",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.GAIM_TAB_ITEM));


	public static final DeferredItem<Item> GAIM_HORSE_ARMOR = ITEMS.register("gaim_horse_armor",
			() -> new  BaseAnimalArmorItem(ArmorMaterials.DIAMOND, AnimalArmorItem.BodyType.EQUESTRIAN,
					false, new Item.Properties().stacksTo(1)).AddToList(RiderTabs.GAIM_TAB_ITEM));

	public static final DeferredItem<Item>  HELHEIM_FRUIT = ITEMS.register("helheim_fruit",
			() -> new BaseItem(new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).fast().saturationModifier(0.8f).alwaysEdible().effect(() -> new MobEffectInstance(MobEffects.POISON, 500, 2), 1.0F).build()))
					.HasHoverTex().AddToList(RiderTabs.GAIM_TAB_ITEM));


	public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
}
