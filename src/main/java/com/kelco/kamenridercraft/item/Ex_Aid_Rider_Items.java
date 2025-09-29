package com.kelco.kamenridercraft.item;

import com.kelco.kamenridercraft.KamenRiderCraftCore;

import com.kelco.kamenridercraft.block.machineBlocks.GameCreator;
import com.kelco.kamenridercraft.block.machineBlocks.GanbarizingMachine;
import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.item.BaseItems.*;
import com.kelco.kamenridercraft.item.ex_aid.*;
import com.kelco.kamenridercraft.item.tabs.RiderTabs;

import com.kelco.kamenridercraft.particle.ModParticles;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.IntSupplier;

public class Ex_Aid_Rider_Items {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);

	public static final DeferredItem<Item> EX_AID_LOGO = ITEMS.register("ex_aid_logo",
			() -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/ex_aid")), new Item.Properties()).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> BUGSTER_VIRUS_DNA = ITEMS.register("bugster_virus_dna",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	//public static final RegistryObject<Item> GAMEDEUS_BUGSTER_VIRUS_DNA = ITEMS.register("gamedeus_bugster_virus_dna",
	//		() -> new BaseItem(new Item.Properties()).AddToTabList(RiderTabs.EX_AID_TAB_ITEM));


	public static final DeferredItem<Item> BLANK_GASHAT = ITEMS.register("blank_gashat",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.EX_AID_TAB_ITEM));



	public static final DeferredItem<Item> MIGHTY_ACTION_X_GASHAT_LV_1 = ITEMS.register("mighty_action_x_gashat_lv_1",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_lv1","ex_aid","gamer_driver_mighty_action_x_lv_1",
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.ChangeModel("lv_1.geo.json").ChangeBeltModel("geo/lv_1_belt.geo.json")
                    .IsGlowing().alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()));

	public static final DeferredItem<Item> MIGHTY_ACTION_X_GASHAT = ITEMS.register("mighty_action_x_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","ex_aid","gamer_driver_mighty_action_x",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.addSwitchForm(MIGHTY_ACTION_X_GASHAT_LV_1.get()).alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get())
                    .IsGlowing().AddToList(RiderTabs.EX_AID_TAB_ITEM).AddToList(Decade_Rider_Items.NEO_DIEND_SUMMON_FORMS).AddToList(GameCreator.BLANK_GASHAT, 20));

	public static final DeferredItem<Item> TADDLE_QUEST_GASHAT_LV_1 = ITEMS.register("taddle_quest_gashat_lv_1",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_lv1","brave","gamer_driver_taddle_quest_lv_1",
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
					new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.ChangeModel("lv_1.geo.json").ChangeBeltModel("geo/lv_1_belt.geo.json")
                    .IsGlowing().alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()));

	public static final DeferredItem<Item> TADDLE_QUEST_X_GASHAT = ITEMS.register("taddle_quest_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","brave","gamer_driver_taddle_quest",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.addSwitchForm(TADDLE_QUEST_GASHAT_LV_1.get()).alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get())
                    .IsGlowing().AddToList(RiderTabs.EX_AID_TAB_ITEM).AddToList(Decade_Rider_Items.NEO_DIEND_SUMMON_FORMS).AddToList(GameCreator.BLANK_GASHAT, 15));

	public static final DeferredItem<Item> BANG_BANG_SHOOTING_GASHAT_LV_1 = ITEMS.register("bang_bang_shooting_gashat_lv_1",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_lv1","snipe","gamer_driver_bang_bang_shooting_lv_1",
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.DARK_BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.ChangeModel("lv_1.geo.json").ChangeBeltModel("geo/lv_1_belt.geo.json")
                    .IsGlowing().alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()));

	public static final DeferredItem<Item> BANG_BANG_SHOOTING_GASHAT = ITEMS.register("bang_bang_shooting_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","snipe","gamer_driver_bang_bang_shooting",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.DARK_BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.addSwitchForm(BANG_BANG_SHOOTING_GASHAT_LV_1.get()).alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get())
                    .IsGlowing().AddToList(RiderTabs.EX_AID_TAB_ITEM).AddToList(GameCreator.BLANK_GASHAT, 15));

	public static final DeferredItem<Item> BAKUSOU_BIKE_GASHAT_LV_1 = ITEMS.register("bakusou_bike_gashat_lv_1",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_lv1","lazer","gamer_driver_bakusou_bike_lv_1",
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.ChangeModel("lv_1.geo.json").ChangeBeltModel("geo/lv_1_belt.geo.json")
                    .IsGlowing().alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()));

	public static final DeferredItem<Item> BAKUSOU_BIKE_GASHAT_UNDER = ITEMS.register("bakusou_bike_gashat_under",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","lazer","gamer_driver_bakusou_bike",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing());

	public static final DeferredItem<Item> BAKUSOU_BIKE_GASHAT = ITEMS.register("bakusou_bike_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_lv2_bike","lazer","blank",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.addSwitchForm(BAKUSOU_BIKE_GASHAT_LV_1.get())
			.ChangeModel("lazer_lv2.geo.json").ChangeAnimation("lazer_lv2.animation.json").alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get())
                    .IsGlowing().SetPalyerModelInvisible().AddToList(RiderTabs.EX_AID_TAB_ITEM).AddToList(GameCreator.BLANK_GASHAT, 15));

	public static final DeferredItem<Item> BAKUSOU_BIKE_GASHAT_TURBO = ITEMS.register("bakusou_bike_gashat_turbo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_turbo","lazer","gamer_driver_bakusou_bike",
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.addSwitchForm(BAKUSOU_BIKE_GASHAT_LV_1.get())
                    .IsGlowing().alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static String[] BaseGamerDriverUsers = new String[] {"ex_aid","genm","brave","snipe"};

	public static final DeferredItem<Item> GEKITOTSU_ROBOTS_GASHAT = ITEMS.register("gekitotsu_robots_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"robot_gamer","ex_aid","gamer_driver_mighty_action_x",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.SetFormToArmor().ChangeSlot(2).AddToList(RiderTabs.EX_AID_TAB_ITEM).AddToList(GameCreator.BLANK_GASHAT, 10));

	public static final DeferredItem<Item> DOREMIFA_BEAT_GASHAT = ITEMS.register("doremifa_beat_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"beat_gamer","ex_aid","gamer_driver_mighty_action_x",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.SetFormToArmor().ChangeSlot(2)
			.AddToList(RiderTabs.EX_AID_TAB_ITEM).AddToList(GameCreator.BLANK_GASHAT, 10));

	public static final DeferredItem<Item> JET_COMBAT_GASHAT = ITEMS.register("jet_combat_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"combat_gamer","ex_aid","gamer_driver_mighty_action_x",
					new MobEffectInstance(Effect_core.BOOST, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.SetFormToArmor().ChangeSlot(2)
			.AddToList(RiderTabs.EX_AID_TAB_ITEM).AddToList(GameCreator.BLANK_GASHAT, 10));

	public static final DeferredItem<Item> GIRI_GIRI_CHAMBARA_GASHAT = ITEMS.register("giri_giri_chambara_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"chambara_gamer","lazer","gamer_driver_bakusou_bike",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.ChangeSlot(2)
			.alsoChange1stSlot(BAKUSOU_BIKE_GASHAT_UNDER.get()).AddToList(RiderTabs.EX_AID_TAB_ITEM).AddToList(GameCreator.BLANK_GASHAT, 10));

	public static final DeferredItem<Item> GIRI_GIRI_CHAMBARA_GASHAT_X = ITEMS.register("giri_giri_chambara_gashat_x",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"chambara_gamer","lazer","gamer_driver_bakusou_bike",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.ChangeSlot(2)
			.alsoChange1stSlot(BAKUSOU_BIKE_GASHAT_UNDER.get()));

	public static final DeferredItem<Item> SHAKARIKI_SPORTS_GASHAT = ITEMS.register("shakariki_sports_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"sports_gamer","ex_aid","gamer_driver_mighty_action_x",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.SetFormToArmor().ChangeSlot(2).AddToList(RiderTabs.EX_AID_TAB_ITEM).AddToList(GameCreator.BLANK_GASHAT, 10));

	public static final DeferredItem<Item> DRAGO_KNIGHT_HUNTER_Z_GASHAT_CLAW = ITEMS.register("drago_knight_hunter_z_gashat_claw",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"hunter_gamer_claw","lazer","gamer_driver_mighty_action_x",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.alsoChange1stSlot(BAKUSOU_BIKE_GASHAT_UNDER.get()).ChangeSlot(2));

	public static final DeferredItem<Item> DRAGO_KNIGHT_HUNTER_Z_GASHAT_GUN = ITEMS.register("drago_knight_hunter_z_gashat_gun",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"hunter_gamer_gun","snipe","gamer_driver_mighty_action_x",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.SetFormToArmor().addAlternative(DRAGO_KNIGHT_HUNTER_Z_GASHAT_CLAW.get()).ChangeSlot(2));

	public static final DeferredItem<Item> DRAGO_KNIGHT_HUNTER_Z_GASHAT_BLADE = ITEMS.register("drago_knight_hunter_z_gashat_blade",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"hunter_gamer_blade","brave","gamer_driver_mighty_action_x",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(Effect_core.SLASH, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.SetFormToArmor().addAlternative(DRAGO_KNIGHT_HUNTER_Z_GASHAT_GUN.get()).ChangeSlot(2));

	public static final DeferredItem<Item> DRAGO_KNIGHT_HUNTER_Z_GASHAT_FANG = ITEMS.register("drago_knight_hunter_z_gashat_fang",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"hunter_gamer_fang","ex_aid","gamer_driver_mighty_action_x",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.SetFormToArmor().addAlternative(DRAGO_KNIGHT_HUNTER_Z_GASHAT_BLADE.get()).ChangeSlot(2));

	public static final DeferredItem<Item> DRAGO_KNIGHT_HUNTER_Z_GASHAT = ITEMS.register("drago_knight_hunter_z_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"hunter_gamer","ex_aid","gamer_driver_mighty_action_x",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.SetFormToArmor()
					.addShiftForm(DRAGO_KNIGHT_HUNTER_Z_GASHAT_FANG.get()).ChangeSlot(2).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> PROTO_MIGHTY_ACTION_X_GASHAT_LV_1 = ITEMS.register("proto_mighty_action_x_gashat_lv_1",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_lv1","genm","gamer_driver_proto_mighty_action_x_lv_1",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(Effect_core.SLASH, 40, 2,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .IsGlowing().ChangeModel("lv_1.geo.json").ChangeBeltModel("geo/lv_1_belt.geo.json").alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()));

	public static final DeferredItem<Item> PROTO_MIGHTY_ACTION_X_GASHAT = ITEMS.register("proto_mighty_action_x_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","genm","gamer_driver_proto_mighty_action_x",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(Effect_core.BUGSTER, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .IsGlowing().addSwitchForm(PROTO_MIGHTY_ACTION_X_GASHAT_LV_1.get()).alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> PROTO_TADDLE_QUEST_GASHAT_LV_1 = ITEMS.register("proto_taddle_quest_gashat_lv_1",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_proto_brave_lv1","brave","gamer_driver_proto_bang_bang_shooting_lv_1",
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
					new MobEffectInstance(Effect_core.SLASH, 40, 1,true,false),
					new MobEffectInstance(Effect_core.BUGSTER, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .IsGlowing().ChangeModel("lv_1.geo.json").ChangeBeltModel("geo/lv_1_belt.geo.json").alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()));

	public static final DeferredItem<Item> PROTO_TADDLE_QUEST_X_GASHAT = ITEMS.register("proto_taddle_quest_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_proto_brave","brave","gamer_driver_proto_taddle_quest",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(Effect_core.SLASH, 40, 1,true,false),
					new MobEffectInstance(Effect_core.BUGSTER, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .IsGlowing().addSwitchForm(PROTO_TADDLE_QUEST_GASHAT_LV_1.get()).alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> PROTO_BANG_BANG_SHOOTING_GASHAT_LV_1 = ITEMS.register("proto_bang_bang_shooting_gashat_lv_1",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_proto_snipe_lv1","snipe","gamer_driver_proto_bang_bang_shooting_lv_1",
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(Effect_core.BUGSTER, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .IsGlowing().ChangeModel("lv_1.geo.json").ChangeBeltModel("geo/lv_1_belt.geo.json").alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()));

	public static final DeferredItem<Item> PROTO_BANG_BANG_SHOOTING_GASHAT = ITEMS.register("proto_bang_bang_shooting_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_proto_snipe","snipe","gamer_driver_proto_bang_bang_shooting",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(Effect_core.BUGSTER, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .IsGlowing().addSwitchForm(PROTO_BANG_BANG_SHOOTING_GASHAT_LV_1.get()).alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get())
			.AddToList(RiderTabs.EX_AID_TAB_ITEM));


	public static final DeferredItem<Item> PROTO_BAKUSOU_BIKE_GASHAT_LV_1 = ITEMS.register("proto_bakusou_bike_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_proto_lazer_lv1","lazer","gamer_driver_proto_bakusou_bike_lv_1",
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(Effect_core.BUGSTER, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .IsGlowing().ChangeModel("lv_1.geo.json").ChangeBeltModel("geo/lv_1_belt.geo.json")
			.alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()).AddToList(RiderTabs.EX_AID_TAB_ITEM));


	public static final DeferredItem<Item> PROTO_GEKITOTSU_ROBOTS_GASHAT = ITEMS.register("proto_gekitotsu_robots_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"proto_robot_gamer","ex_aid","gamer_driver_mighty_action_x",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(Effect_core.BUGSTER, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.SetFormToArmor()
			.ChangeSlot(2).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> PROTO_DOREMIFA_BEAT_GASHAT = ITEMS.register("proto_doremifa_beat_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"proto_beat_gamer","ex_aid","gamer_driver_mighty_action_x",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(Effect_core.BUGSTER, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.SetFormToArmor()
			.ChangeSlot(2).AddToList(RiderTabs.EX_AID_TAB_ITEM));


	public static final DeferredItem<Item> PROTO_JET_COMBAT_GASHAT_LAZER = ITEMS.register("proto_jet_combat_gashat_lazer",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"proto_combat_gamer","lazer","gamer_driver_mighty_action_x",
					new MobEffectInstance(Effect_core.BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(Effect_core.BUGSTER, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.addNeedForm(BAKUSOU_BIKE_GASHAT_TURBO.get(), 1).ChangeSlot(2));

	public static final DeferredItem<Item> PROTO_JET_COMBAT_GASHAT = ITEMS.register("proto_jet_combat_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"proto_combat_gamer","ex_aid","gamer_driver_mighty_action_x",
					new MobEffectInstance(Effect_core.BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(Effect_core.BUGSTER, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
			.addAlternative(PROTO_JET_COMBAT_GASHAT_LAZER.get()).SetFormToArmor().ChangeSlot(2).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> PROTO_GIRI_GIRI_CHAMBARA_GASHAT = ITEMS.register("proto_giri_giri_chambara_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"proto_chambara_gamer","lazer","gamer_driver_bakusou_bike",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(Effect_core.BUGSTER, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.ChangeSlot(2)
			.alsoChange1stSlot(BAKUSOU_BIKE_GASHAT_UNDER.get()).AddToList(RiderTabs.EX_AID_TAB_ITEM));


	public static final DeferredItem<Item> PROTO_SHAKARIKI_SPORTS_GASHAT_LAZER = ITEMS.register("proto_shakariki_sports_gashat_lazer",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"proto_sports_gamer","lazer","gamer_driver_mighty_action_x",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(Effect_core.BUGSTER, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
			.addNeedForm(BAKUSOU_BIKE_GASHAT_TURBO.get(), 1).ChangeSlot(2));


	public static final DeferredItem<Item> PROTO_SHAKARIKI_SPORTS_GASHAT = ITEMS.register("proto_shakariki_sports_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"proto_sports_gamer","ex_aid","gamer_driver_mighty_action_x",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(Effect_core.BUGSTER, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.SetFormToArmor()
			.addAlternative(PROTO_SHAKARIKI_SPORTS_GASHAT_LAZER.get()).ChangeSlot(2).AddToList(RiderTabs.EX_AID_TAB_ITEM));


	public static final DeferredItem<Item> PROTO_DRAGO_KNIGHT_HUNTER_Z_GASHAT_CLAW = ITEMS.register("proto_drago_knight_hunter_z_gashat_claw",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"proto_hunter_gamer_claw","lazer","gamer_driver_mighty_action_x",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(Effect_core.BUGSTER, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.ChangeSlot(2)
			.alsoChange1stSlot(BAKUSOU_BIKE_GASHAT_UNDER.get()));

	public static final DeferredItem<Item> PROTO_DRAGO_KNIGHT_HUNTER_Z_GASHAT_GUN = ITEMS.register("proto_drago_knight_hunter_z_gashat_gun",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"proto_hunter_gamer_gun","snipe","gamer_driver_mighty_action_x",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(Effect_core.BUGSTER, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.SetFormToArmor()
			.addAlternative(PROTO_DRAGO_KNIGHT_HUNTER_Z_GASHAT_CLAW.get()).ChangeSlot(2));

	public static final DeferredItem<Item> PROTO_DRAGO_KNIGHT_HUNTER_Z_GASHAT_BLADE = ITEMS.register("proto_drago_knight_hunter_z_gashat_blade",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"proto_hunter_gamer_blade","brave","gamer_driver_mighty_action_x",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(Effect_core.BUGSTER, 40, 2,true,false),
					new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.SetFormToArmor()
			.addAlternative(PROTO_DRAGO_KNIGHT_HUNTER_Z_GASHAT_GUN.get()).ChangeSlot(2));

	public static final DeferredItem<Item> PROTO_DRAGO_KNIGHT_HUNTER_Z_GASHAT_FANG = ITEMS.register("proto_drago_knight_hunter_z_gashat_fang",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"proto_hunter_gamer_fang","ex_aid","gamer_driver_mighty_action_x",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
					new MobEffectInstance(Effect_core.BUGSTER, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.SetFormToArmor()
			.addAlternative(PROTO_DRAGO_KNIGHT_HUNTER_Z_GASHAT_BLADE.get()).ChangeSlot(2));

	public static final DeferredItem<Item> PROTO_DRAGO_KNIGHT_HUNTER_Z_GASHAT = ITEMS.register("proto_drago_knight_hunter_z_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"proto_hunter_gamer","ex_aid","gamer_driver_mighty_action_x",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(Effect_core.BUGSTER, 40, 2,true,false),
					new MobEffectInstance(Effect_core.SLASH, 40, 2,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.SetFormToArmor()
			.addShiftForm(PROTO_DRAGO_KNIGHT_HUNTER_Z_GASHAT_FANG.get()).ChangeSlot(2).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> PROTO_MIGHTY_ACTION_X_GASHAT_ORIGIN = ITEMS.register("proto_mighty_action_x_gashat_origin",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_lv0","genm","gamer_driver_proto_mighty_action_x_origin",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(Effect_core.BUGSTER, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
			.addSwitchForm(PROTO_MIGHTY_ACTION_X_GASHAT_LV_1.get()).alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> PROTO_BAKUSOU_BIKE_COMBI_FUKKATSU_GASHAT = ITEMS.register("proto_bakusou_bike_combi_fukkatsu_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_lv0","ex_aid","gamer_driver_proto_bakusou_bike_combi_fukkatsu",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(Effect_core.BUGSTER, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.SetFormToArmor()
			.alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> DANGEROUS_ZOBIE_GASHAT_BD= ITEMS.register("dangerous_zombie_gashat_bd",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_lvx","genm_bugvisor","gamer_driver_dangerous_zombie",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 3,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .IsGlowing().alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()));

	public static final DeferredItem<Item> DANGEROUS_ZOBIE_GASHAT= ITEMS.register("dangerous_zombie_gashat",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_lvx","genm","gamer_driver_dangerous_zombie",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 3,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
			.addAlternative(DANGEROUS_ZOBIE_GASHAT_BD.get()).addNeedForm(PROTO_MIGHTY_ACTION_X_GASHAT_ORIGIN.get(),1)
					.alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get())
                    .IsGlowing().AddToList(GameCreator.BLANK_GASHAT, 2).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> UNFINISHED_KAMEN_RIDER_CHRONICLE_GASHAT = ITEMS.register("unfinished_kamen_rider_chronicle_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","ride_player","ride_player_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BROWN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .IsGlowing().alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()).AddToList(RiderTabs.EX_AID_TAB_ITEM));


	public static final DeferredItem<Item> KAMEN_RIDER_CHRONICLE_GASHAT_GEMEDEUS= ITEMS.register("kamen_rider_chronicle_gashat_gamedeus",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_gamedeus","chronos","gamer_driver_chronicle",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .IsGlowing().alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()).AddToList(RiderTabs.EX_AID_TAB_ITEM));


	public static final DeferredItem<Item> KAMEN_RIDER_CHRONICLE_GASHAT= ITEMS.register("kamen_rider_chronicle_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_cronus","snipe","gamer_driver_chronicle",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .IsGlowing().addAlternative(KAMEN_RIDER_CHRONICLE_GASHAT_GEMEDEUS.get()).alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get())
                    .AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> TOKI_MEKI_CRISIS_GASHAT_RED_EYES= ITEMS.register("toki_meki_crisis_gashat_red_eyes",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_red","poppy","gashacon_bugvisor_ii_poppy",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .IsGlowing());

	public static final DeferredItem<Item> TOKI_MEKI_CRISIS_GASHAT= ITEMS.register("toki_meki_crisis_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","poppy","gashacon_bugvisor_ii_poppy",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .IsGlowing().addSwitchForm(TOKI_MEKI_CRISIS_GASHAT_RED_EYES.get()).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> MIGHTY_CREATOR_VRX_GASHAT = ITEMS.register("mighty_creator_vrx_gashat",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_creator","ex_aid","gamer_driver_mighty_creator_vrx",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .IsGlowing().alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get())
			.AddToList(RiderTabs.EX_AID_TAB_ITEM).AddToList(GameCreator.BLANK_GASHAT, 1));

	public static final DeferredItem<Item> MIGHTY_NOVEL_GASHAT = ITEMS.register("mighty_novel_x_gashat",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_novel","ex_aid","gamer_driver_mighty_novel_x",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .IsGlowing().alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get())
			.AddToList(RiderTabs.EX_AID_TAB_ITEM).AddToList(GameCreator.BLANK_GASHAT, 1));

	public static final DeferredItem<Item> JU_JU_BURGER_GASHAT = ITEMS.register("ju_ju_burger_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"burger_gamer","ex_aid","gamer_driver_mighty_action_x",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.SetFormToArmor()
			.ChangeSlot(2).AddToList(RiderTabs.EX_AID_TAB_ITEM).AddToList(GameCreator.BLANK_GASHAT, 5));

	public static final DeferredItem<Item> NIGHT_OF_SAFARI_GASHAT = ITEMS.register("night_of_safari_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"safari_gamer","ex_aid","gamer_driver_mighty_action_x",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.SetFormToArmor().ChangeSlot(2)
			.AddToList(RiderTabs.EX_AID_TAB_ITEM).AddToList(GameCreator.BLANK_GASHAT, 3));

	public static final DeferredItem<Item> BANG_BANG_TANK_GASHAT = ITEMS.register("bang_bang_tank_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"tank_gamer","ex_aid","gamer_driver_mighty_action_x",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }.SetFormToArmor().ChangeSlot(2)
                    .IsGlowing().AddToList(RiderTabs.EX_AID_TAB_ITEM).AddToList(GameCreator.BLANK_GASHAT, 2));

	
	public static final DeferredItem<Item> TADDLE_LEGACY_GASHAT_TRUE = ITEMS.register("taddle_legacy_gashat_true",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"legacy_gamer","brave","gamer_driver_taddle_legacy",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 5,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .IsGlowing().SetFormToArmor().ChangeSlot(2));

	public static final DeferredItem<Item> TADDLE_LEGACY_GASHAT = ITEMS.register("taddle_legacy_gashat",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"legacy_gamer","brave","gamer_driver_taddle_legacy",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 5,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .SetFormToArmor().ChangeSlot(2).AddToList(RiderTabs.EX_AID_TAB_ITEM).AddToList(GameCreator.BLANK_GASHAT, 2));

	public static final DeferredItem<Item> HURRICANE_NINJA_GASHAT = ITEMS.register("hurricane_ninja_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","fuma","gamer_driver_hurricane_ninja",
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.DARK_BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }
                    .IsGlowing().AddToList(RiderTabs.EX_AID_TAB_ITEM).AddToList(GameCreator.BLANK_GASHAT, 2));

	public static final DeferredItem<Item> PAC_ADVENTURE_GASHAT = ITEMS.register("pac_adventure_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"pac_gamer","ex_aid","gamer_driver_mighty_action_x",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }.SetFormToArmor()
			.ChangeSlot(2).AddToList(GameCreator.BLANK_GASHAT, 1).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> FAMITSA_GASHAT = ITEMS.register("famitsa_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"famista_gamer","ex_aid","gamer_driver_mighty_action_x",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }.SetFormToArmor()
			.ChangeSlot(2).AddToList(GameCreator.BLANK_GASHAT, 1).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> XEVIOUS_GASHAT = ITEMS.register("xevious_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"xevious_gamer","ex_aid","gamer_driver_mighty_action_x",
					new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }.SetFormToArmor()
			.ChangeSlot(2).AddToList(GameCreator.BLANK_GASHAT, 1).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> GALAXIAN_GASHAT = ITEMS.register("galaxian_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"galaxian_gamer","ex_aid","gamer_driver_mighty_action_x",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }.SetFormToArmor()
			.ChangeSlot(2).AddToList(GameCreator.BLANK_GASHAT, 1).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> TAIKO_NO_TATSUJIN_GASHAT = ITEMS.register("taiko_no_tatsujin_gashat",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> GANBERIZING_GASHAT = ITEMS.register("ganbarizing_gashat",
			() -> new BaseItem(new Item.Properties()).AddToList(GameCreator.BLANK_GASHAT, 2).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> PROTO_MIGHTY_ACTION_X_GASHAT_ORIGIN_REMAKE = ITEMS.register("proto_mighty_action_x_gashat_origin_remake",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> TOKI_MEKTI_BRIDAL_GASHAT = ITEMS.register("toki_meki_bridal_gashat",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> POPPY_DOREMIFA_BEAT_GASHAT_GASHAT = ITEMS.register("poppy_doremifa_beat_gashat",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> MIGHTY_BROTHERS_XX_UNFINISHED_GASHAT = ITEMS.register("mighty_brothers_xx_unfinished_gashat",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.EX_AID_TAB_ITEM));


	public static final DeferredItem<Item>  MIGHTY_BROTHERS_XX_GASHAT_L = ITEMS.register("mighty_brothers_xx_gashat_l",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_lvxxl","ex_aid","gamer_driver_mighty_brothers_xx",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
                    .IsGlowing().alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()));

	public static final DeferredItem<Item>  MIGHTY_BROTHERS_XX_GASHAT_R = ITEMS.register("mighty_brothers_xx_gashat_r",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_lvxxr","ex_aid","gamer_driver_mighty_brothers_xx",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
                    .IsGlowing().addSwitchForm(MIGHTY_BROTHERS_XX_GASHAT_L.get()).alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()));

	public static final DeferredItem<Item> MIGHTY_BROTHERS_XX_GASHAT = ITEMS.register("mighty_brothers_xx_gashat",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_lvx","ex_aid","gamer_driver_mighty_brothers_x",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
                    .IsGlowing().ChangeModel("lv_1.geo.json").ChangeBeltModel("geo/lv_1_belt.geo.json").addShiftForm(MIGHTY_BROTHERS_XX_GASHAT_R.get()).alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()).AddToList(RiderTabs.EX_AID_TAB_ITEM).AddToList(GameCreator.BLANK_DOUBLE_GASHAT, 20));

	public static final DeferredItem<Item> DOCTOR_MIGHTY_XX_GASHAT = ITEMS.register("doctor_mighty_xx_gashat",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.EX_AID_TAB_ITEM).AddToList(GameCreator.BLANK_DOUBLE_GASHAT, 5));

	public static final DeferredItem<Item> KNOCK_OUT_FIGHTER_2_GASHAT = ITEMS.register("knock_out_fighter_2_gashat",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_lv39","ex_aid","gamer_driver_knock_out_fighter_2",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
                    .IsGlowing().alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()).AddToList(RiderTabs.EX_AID_TAB_ITEM).AddToList(GameCreator.BLANK_DOUBLE_GASHAT, 5));

	public static final DeferredItem<Item> TADDLE_FANTASY_GASHAT = ITEMS.register("taddle_fantasy_gashat",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"fantasy_gamer","brave","gamer_driver_taddle_fantasy",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
                    .SetFormToArmor().ChangeSlot(2).AddToList(RiderTabs.EX_AID_TAB_ITEM).AddToList(GameCreator.BLANK_DOUBLE_GASHAT, 15));

	public static final DeferredItem<Item> BANG_BANG_SIMULATION_GASHAT = ITEMS.register("bang_bang_simulation_gashat",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"simulation_gamer","snipe","gamer_driver_taddle_fantasy",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
                    .SetFormToArmor().ChangeSlot(2).AddToList(RiderTabs.EX_AID_TAB_ITEM).AddToList(GameCreator.BLANK_DOUBLE_GASHAT, 15));

	public static final DeferredItem<Item> GASHAT_GEAR_DUAL = ITEMS.register("gashat_gear_dual",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","para_dx_lv99","gamer_driver_gashat_gear_dual",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
                    .IsGlowing().alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()));

	public static final DeferredItem<Item> PERFECT_PUZZLE_GASHAT = ITEMS.register("perfect_puzzle_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","para_dx","paradoxbelt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
                    .IsGlowing().addAlternative(GASHAT_GEAR_DUAL.get()).alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()).AddToList(RiderTabs.EX_AID_TAB_ITEM).AddToList(GameCreator.BLANK_DOUBLE_GASHAT, 10));

	public static final DeferredItem<Item> KNOCK_OUT_FIGHTER_GASHAT = ITEMS.register("knock_out_fighter_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_fighter","para_dx","paradoxbelt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
                    .IsGlowing().addAlternative(GASHAT_GEAR_DUAL.get()).alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()).AddToList(RiderTabs.EX_AID_TAB_ITEM).AddToList(GameCreator.BLANK_DOUBLE_GASHAT, 10));

	public static final DeferredItem<Item> GASHAT_GEAR_DUAL_ANOTHER = ITEMS.register("gashat_gear_dual_another",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","another_para_dx","gamer_driver_gashat_gear_dual_another",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
                    .IsGlowing().alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()).AddToList(RiderTabs.EX_AID_TAB_ITEM).AddToList(GameCreator.BLANK_DOUBLE_GASHAT, 5));

	public static final DeferredItem<Item> GENM_MUSOU_GASHAT = ITEMS.register("genm_musou_gashat",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_musou","genm","gamer_driver_genm_musou",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 5,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 6,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.SATURATION, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
					new MobEffectInstance(Effect_core.MUTEKI, 40, 0,true,false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
                    .IsGlowing().alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> UNFINISHED_MAXIMUM_MIGHTY_X_GASHAT = ITEMS.register("unfinished_maximum_mighty_x_gashat",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> MAXIMUM_MIGHTY_X_GASHAT_lv2 = ITEMS.register("maximum_mighty_x_gashat_lv_2",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","ex_aid","gamer_driver_maximum_mighty_x_lv2",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
                    .IsGlowing().alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()));


	public static final DeferredItem<Item> MAXIMUM_MIGHTY_X_GASHAT = ITEMS.register("maximum_mighty_x_gashat",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_lv99","ex_aid","gamer_driver_maximum_mighty_x",
					new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0,0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }.addSwitchForm(MAXIMUM_MIGHTY_X_GASHAT_lv2.get())
                    .IsGlowing().ChangeModel("lv_max.geo.json").ChangeBeltModel("geo/lv_1_belt.geo.json").alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()).AddToList(RiderTabs.EX_AID_TAB_ITEM).AddToList(GameCreator.BLANK_MAXIMUM_GASHAT, 20));


	public static final DeferredItem<Item> GOD_MAXIMUM_MIGHTY_X_GASHAT_lv0 = ITEMS.register("god_maximum_mighty_x_gashat_lv0",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_lv0","genm","gamer_driver_god_maximum_mighty_x_lv0",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 4,true,false),
					new MobEffectInstance(MobEffects.SATURATION, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);


                }
            }
                    .IsGlowing().alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()));


	public static final DeferredItem<Item> GOD_MAXIMUM_MIGHTY_X_GASHAT = ITEMS.register("god_maximum_mighty_x_gashat",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_lv_billion","genm","gamer_driver_god_maximum_mighty_x",
					new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 4,true,false),
					new MobEffectInstance(MobEffects.SATURATION, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0,0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
                    .IsGlowing().addSwitchForm(GOD_MAXIMUM_MIGHTY_X_GASHAT_lv0.get())
			.ChangeModel("lv_max.geo.json").ChangeBeltModel("geo/lv_1_belt.geo.json").alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()).AddToList(RiderTabs.EX_AID_TAB_ITEM).AddToList(GameCreator.BLANK_MAXIMUM_GASHAT, 5));

	public static final DeferredItem<Item> MAXIMUM_ZOMBIE_GASHAT = ITEMS.register("maximum_zombie_gashat",
			() -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).AddToList(RiderTabs.EX_AID_TAB_ITEM));


	public static final DeferredItem<Item> UNFINISHED_HYPER_MUTEKI_GASHAT= ITEMS.register("unfinished_hyper_muteki_gashat",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> HYPER_MUTEKI_GASHAT = ITEMS.register("hyper_muteki_gashat",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"_muteki","ex_aid","gamer_driver_hyper_muteki",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 6,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.SATURATION, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
					new MobEffectInstance(Effect_core.MUTEKI, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
                    .IsGlowing().addNeedForm(MAXIMUM_MIGHTY_X_GASHAT.get(), 1).alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()).AddToList(RiderTabs.EX_AID_TAB_ITEM).AddToList(Decade_Rider_Items.COMPLETE_21_FORMS).AddToList(GameCreator.BLANK_HYPER_GASHAT, 20));

	public static final DeferredItem<Item> GEMEDEUS_HYPER_MUTEKI_GASHAT = ITEMS.register("gamedeus_hyper_muteki_gashat",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"","gamedeus_muteki","gamer_driver_gamedeus_hyper_muteki",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 6,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.SATURATION, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
					new MobEffectInstance(Effect_core.MUTEKI, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
                    .IsGlowing().addNeedForm(MAXIMUM_MIGHTY_X_GASHAT.get(), 1).alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get())
			.AddToList(RiderTabs.EX_AID_TAB_ITEM).AddToList(GameCreator.BLANK_HYPER_GASHAT, 5));


	public static final DeferredItem<Item> HYPER_FUMESTU_GASHAT = ITEMS.register("hyper_fumetsu_gashat",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"_hyper_fumetsu","genm","gamer_driver_hyper_fumetsu",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 6,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.SATURATION, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
					new MobEffectInstance(Effect_core.MUTEKI, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
                    .IsGlowing().addNeedItem(MAXIMUM_ZOMBIE_GASHAT.get()).alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get())
			.AddToList(RiderTabs.EX_AID_TAB_ITEM));


	public static final DeferredItem<Item> THE_UNBEATABLE_GAME= ITEMS.register("the_unbeatable_game",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_totema","genm_bugvisor","gamer_driver_dangerous_zombie",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 3,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
                    .IsGlowing().hasStaticWings().alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get())
			.AddToList(RiderTabs.EX_AID_TAB_ITEM));


	public static final DeferredItem<Item> KAMEN_RIDER_BUILD_GASHAT = ITEMS.register("kamen_rider_build_gashat",
			() -> new BaseItem(new Item.Properties()).AddToList(GanbarizingMachine.BLANK_GASHAT, 1).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> KAIGEN_GHOST_GASHAT_LV_1 = ITEMS.register("kaigan_ghost_gashat_lv_1",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_ghost_lv1","ex_aid","gamer_driver_kaigan_ghost_lv_1",
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
					new MobEffectInstance(Effect_core.GHOST, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }.ChangeModel("lv_1.geo.json").ChangeBeltModel("geo/lv_1_belt.geo.json").alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()));

	public static final DeferredItem<Item> KAIGEN_GHOST_GASHAT = ITEMS.register("kaigan_ghost_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_ghost","ex_aid","gamer_driver_kaigan_ghost",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(Effect_core.GHOST, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }.addSwitchForm(KAIGEN_GHOST_GASHAT_LV_1.get()).alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get())
			.AddToList(GanbarizingMachine.BLANK_GASHAT, 1).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> FULL_THROTTLE_DRIVE_GASHAT = ITEMS.register("full_throttle_drive_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_drive","ex_aid","gamer_driver_full_throttle_drive",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }.alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get())
			.AddToList(GanbarizingMachine.BLANK_GASHAT, 1).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> TOUKENDEN_GAIM_GASHAT = ITEMS.register("toukenden_gaim_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_gaim","ex_aid","gamer_driver_toukenden_gaim",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }.alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get())
			.AddToList(GanbarizingMachine.BLANK_GASHAT, 1).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> MAGIC_THE_WIZARD_GASHAT_LV_1 = ITEMS.register("magic_the_wizard_gashat_lv_1",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_wizard_lv1","genm","gamer_driver_magic_the_wizard_lv_1",
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }.ChangeModel("lv_1.geo.json").ChangeBeltModel("geo/lv_1_belt.geo.json").alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()));

	public static final DeferredItem<Item> MAGIC_THE_WIZARD_GASHAT = ITEMS.register("magic_the_wizard_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_wizard","genm","gamer_driver_magic_the_wizard",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }.addSwitchForm(MAGIC_THE_WIZARD_GASHAT_LV_1.get()).alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get())
			.AddToList(GanbarizingMachine.BLANK_GASHAT, 1).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> SPACE_GALAXY_FOUZE_GASHAT = ITEMS.register("space_galaxy_fourze_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_fourze","genm","gamer_driver_space_galaxy_fourze",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }.alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get())
			.AddToList(GanbarizingMachine.BLANK_GASHAT, 1).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> JUNGLE_OOO_GASHAT = ITEMS.register("jungle_ooo_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_ooo","genm","gamer_driver_jungle_ooo",
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
            }.alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get())
			.AddToList(GanbarizingMachine.BLANK_GASHAT, 1).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> DETECTICE_DOUBLE_GASHAT = ITEMS.register("detective_double_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_w","ex_aid","gamer_driver_detective_double",
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
            }.alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get())
			.AddToList(GanbarizingMachine.BLANK_GASHAT, 1).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> BERCODE_WARRIOR_DECADE_GASHAT = ITEMS.register("barcode_warrior_decade_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_decade","ex_aid","gamer_driver_barcode_warrior_decade",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }
			.alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get()).AddToList(GanbarizingMachine.BLANK_GASHAT, 1).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> DOKIDOKI_MAKAI_CASTLE_KIVA_GASHAT = ITEMS.register("dokidoki_makai_castle_kiva_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_kiva","ex_aid","gamer_driver_dokidoki_makai_castle_kiva",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }.alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get())
			.AddToList(GanbarizingMachine.BLANK_GASHAT, 1).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> TIME_EXPRESS_DEN_O_GASHAT = ITEMS.register("time_express_den_o_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_den_o","genm","gamer_driver_mighty_novel_x",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }.alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get())
			.AddToList(GanbarizingMachine.BLANK_GASHAT, 1).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> INSECT_WARS_KABUTO_GASHAT = ITEMS.register("insect_wars_kabuto_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_kabuto","ex_aid","gamer_driver_full_throttle_drive",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }.alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get())
			.AddToList(GanbarizingMachine.BLANK_GASHAT, 1).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> TAIKO_MASTER_HIBIKI_GASHAT = ITEMS.register("taiko_master_hibiki_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_hibiki","genm","gamer_driver_proto_mighty_action_x",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }.alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get())
			.AddToList(GanbarizingMachine.BLANK_GASHAT, 1).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> KING_OF_POKER_BLADE_GASHAT = ITEMS.register("king_of_poker_blade_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_blade","genm","gamer_driver_king_of_poker_blade",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }.alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get())
			.AddToList(GanbarizingMachine.BLANK_GASHAT, 1).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> MOSHI_MOSHI_FAIZ_GASHAT = ITEMS.register("moshi_moshi_faiz_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_faiz","genm","gamer_driver_moshi_moshi_faiz",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }.alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get())
			.AddToList(GanbarizingMachine.BLANK_GASHAT, 1).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> MIRROR_LABRYINTH_RYUKI_GASHAT = ITEMS.register("mirror_labryinth_ryuki_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_ryuki","ex_aid","gamer_driver_mirror_labyrinth_ryuki",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }.alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get())
			.AddToList(GanbarizingMachine.BLANK_GASHAT, 1).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> AGITO_OF_THE_SUN_GASHAT = ITEMS.register("agito_of_the_sun_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_agito","genm","gamer_driver_agito_of_the_sun",
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }.alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get())
			.AddToList(GanbarizingMachine.BLANK_GASHAT, 1).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> ADVENTURE_GUY_KUUGA_GASHAT = ITEMS.register("adventure_guy_kuuga_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_kuuga","ex_aid","gamer_driver_adventure_guy_kuuga",
					new MobEffectInstance(Effect_core.PUNCH, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }.alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get())
			.AddToList(GanbarizingMachine.BLANK_GASHAT, 1).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> LETS_GO_ICHIGOU_GASHAT = ITEMS.register("lets_go_ichigou_gashat",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_ichigou","ex_aid","gamer_driver_lets_go_ichigou",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }
            }.alsoChange2ndSlot(Modded_item_core.BLANK_FORM.get())
			.AddToList(GanbarizingMachine.BLANK_GASHAT, 1).AddToList(RiderTabs.EX_AID_TAB_ITEM));


	public static final DeferredItem<Item> MIGHTY_ACTION_X_GASHA_TROPHY = ITEMS.register("mighty_action_x_gasha_trophy",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> TADDLE_QUEST_GASHA_TROPHY = ITEMS.register("taddle_quest_gasha_trophy",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> BANG_BANG_SHOOTING_GASHA_TROPHY = ITEMS.register("bang_bang_shooting_gasha_trophy",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> BAKUSOU_BIKE_GASHA_TROPHY = ITEMS.register("bakusou_bike_gasha_trophy",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> GEKITOTSU_ROBOTS_GASHA_TROPHY = ITEMS.register("gekitotsu_robots_gasha_trophy",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> DOREMIFA_BEAT_GASHA_TROPHY = ITEMS.register("doremifa_beat_gasha_trophy",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> JET_COMBAT_GASHA_TROPHY = ITEMS.register("jet_combat_gasha_trophy",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> GIRI_GIRI_CHAMBARA_GASHA_TROPHY = ITEMS.register("giri_giri_chambara_gasha_trophy",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> SHAKARIKI_SPORTS_GASHA_TROPHY = ITEMS.register("shakariki_sports_gasha_trophy",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> DRAGO_KNIGHT_HUNTER_Z_GASHA_TROPHY = ITEMS.register("drago_knight_hunter_z_gasha_trophy",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> PERFECT_PUZZLE_GASHA_TROPHY = ITEMS.register("perfect_puzzle_gasha_trophy",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> KNOCK_OUT_FIGHTER_GASHA_TROPHY = ITEMS.register("knockout_fighter_gasha_trophy",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> TOKI_MEKI_CRISIS_GASHA_TROPHY = ITEMS.register("toki_meki_crisis_gasha_trophy",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> CHRONUS_CLOCK = ITEMS.register("chronus_clock",
			() -> new BaseItem(new Item.Properties().rarity(Rarity.UNCOMMON)).AddToList(RiderTabs.EX_AID_TAB_ITEM));



	public static final DeferredItem<Item>EX_AIDHELMET = ITEMS.register("ex_aidhead",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.EX_AID_TAB_ITEM).ChangeRepairItem(BLANK_GASHAT.get()));
	public static final DeferredItem<Item> EX_AIDCHESTPLATE = ITEMS.register("ex_aidtroso",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.EX_AID_TAB_ITEM).ChangeRepairItem(BLANK_GASHAT.get()));
	public static final DeferredItem<Item> EX_AIDLEGGINGS = ITEMS.register("ex_aidlegs",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.EX_AID_TAB_ITEM).ChangeRepairItem(BLANK_GASHAT.get()));

	public static final DeferredItem<Item> GAMER_DRIVER_EX_AID = ITEMS.register("gamer_driver_ex_aid",
			() -> new GamerDriverItem(ArmorMaterials.DIAMOND,"ex_aid",MIGHTY_ACTION_X_GASHAT_LV_1,MIGHTY_ACTION_X_GASHAT ,EX_AIDHELMET, EX_AIDCHESTPLATE,EX_AIDLEGGINGS , new Item.Properties())
			.AddToTabList(RiderTabs.EX_AID_TAB_ITEM).AddToTabList(Decade_Rider_Items.NEO_DIEND_SUMMON_BELTS).ChangeRepairItem(BLANK_GASHAT.get()));

	public static final DeferredItem<Item> GAMER_DRIVER_BRAVE = ITEMS.register("gamer_driver_brave",
			() -> new GamerDriverItem(ArmorMaterials.DIAMOND,"brave",TADDLE_QUEST_GASHAT_LV_1,TADDLE_QUEST_X_GASHAT ,EX_AIDHELMET, EX_AIDCHESTPLATE,EX_AIDLEGGINGS , new Item.Properties())
			.AddToTabList(RiderTabs.EX_AID_TAB_ITEM).AddToTabList(Decade_Rider_Items.NEO_DIEND_SUMMON_BELTS).ChangeRepairItem(BLANK_GASHAT.get()));

	public static final DeferredItem<Item> GAMER_DRIVER_SNIPE = ITEMS.register("gamer_driver_snipe",
			() -> new GamerDriverItem(ArmorMaterials.DIAMOND,"snipe",BANG_BANG_SHOOTING_GASHAT_LV_1,BANG_BANG_SHOOTING_GASHAT,EX_AIDHELMET, EX_AIDCHESTPLATE,EX_AIDLEGGINGS , new Item.Properties())
			.AddToTabList(RiderTabs.EX_AID_TAB_ITEM).ChangeRepairItem(BLANK_GASHAT.get()));

	public static final DeferredItem<Item> GAMER_DRIVER_LAZER = ITEMS.register("gamer_driver_lazer",
			() -> new GamerDriverItem(ArmorMaterials.DIAMOND,"lazer",BAKUSOU_BIKE_GASHAT_LV_1, BAKUSOU_BIKE_GASHAT,EX_AIDHELMET, EX_AIDCHESTPLATE,EX_AIDLEGGINGS , new Item.Properties())
			.AddToTabList(RiderTabs.EX_AID_TAB_ITEM).ChangeRepairItem(BLANK_GASHAT.get()));

	public static final DeferredItem<Item> GAMER_DRIVER_GENM = ITEMS.register("gamer_driver_genmu",
			() -> new GamerDriverItem(ArmorMaterials.DIAMOND,"genm",PROTO_MIGHTY_ACTION_X_GASHAT_LV_1,PROTO_MIGHTY_ACTION_X_GASHAT ,EX_AIDHELMET, EX_AIDCHESTPLATE,EX_AIDLEGGINGS , new Item.Properties())
			.AddToTabList(RiderTabs.EX_AID_TAB_ITEM).ChangeRepairItem(BLANK_GASHAT.get()));

	public static final DeferredItem<Item> GAMER_DRIVER_PARA_DX = ITEMS.register("gamer_driver_paradx",
			() -> new GamerDriverItem(ArmorMaterials.DIAMOND,"para_dx_lv99",GASHAT_GEAR_DUAL ,EX_AIDHELMET, EX_AIDCHESTPLATE,EX_AIDLEGGINGS , new Item.Properties())
			.AddToTabList(RiderTabs.EX_AID_TAB_ITEM).ChangeRepairItem(BLANK_GASHAT.get()));

	public static final DeferredItem<Item> GAMER_DRIVER_TRUE_BRAVE = ITEMS.register("gamer_driver_truebrave",
			() -> new GamerDriverItem(ArmorMaterials.DIAMOND,"truebrave",TADDLE_LEGACY_GASHAT_TRUE ,EX_AIDHELMET, EX_AIDCHESTPLATE,EX_AIDLEGGINGS , new Item.Properties().rarity(Rarity.UNCOMMON))
					.Dont_show_belt_form_info().AddToTabList(RiderTabs.EX_AID_TAB_ITEM).ChangeRepairItem(BLANK_GASHAT.get()));

	public static final DeferredItem<Item> GAMER_DRIVER_FUMA = ITEMS.register("gamer_driver_fuuma",
			() -> new GamerDriverItem(ArmorMaterials.DIAMOND,"fuma",HURRICANE_NINJA_GASHAT ,EX_AIDHELMET, EX_AIDCHESTPLATE,EX_AIDLEGGINGS , new Item.Properties())
					.Dont_show_belt_form_info().AddToTabList(RiderTabs.EX_AID_TAB_ITEM).ChangeRepairItem(BLANK_GASHAT.get()));

	public static final DeferredItem<Item> GAMER_DRIVER_ANOTHER_PARA_DX = ITEMS.register("gamer_driver_anotherparadox",
			() -> new GamerDriverItem(ArmorMaterials.DIAMOND,"another_para_dx",GASHAT_GEAR_DUAL_ANOTHER ,EX_AIDHELMET, EX_AIDCHESTPLATE,EX_AIDLEGGINGS , new Item.Properties())
					.Dont_show_belt_form_info().AddToTabList(RiderTabs.EX_AID_TAB_ITEM).ChangeRepairItem(BLANK_GASHAT.get()));

	public static final DeferredItem<Item> GAMER_DRIVER_SNIPE_NICO = ITEMS.register("gamer_driver_nico_snipe",
			() -> new GamerDriverItem(ArmorMaterials.DIAMOND,"snipe_nico",BANG_BANG_SHOOTING_GASHAT ,EX_AIDHELMET, EX_AIDCHESTPLATE,EX_AIDLEGGINGS , new Item.Properties())
					.Dont_show_belt_form_info().AddToTabList(RiderTabs.EX_AID_TAB_ITEM).ChangeRepairItem(BLANK_GASHAT.get()));

	public static final DeferredItem<Item> GAMER_DRIVER_GEMEDEUS_MUTEKI = ITEMS.register("gamer_driver_gamedeus_muteki",
			() -> new GamerDriverItem(ArmorMaterials.DIAMOND,"gamedeus_muteki",GEMEDEUS_HYPER_MUTEKI_GASHAT ,EX_AIDHELMET, EX_AIDCHESTPLATE,EX_AIDLEGGINGS , new Item.Properties().rarity(Rarity.RARE))
					.Dont_show_belt_form_info().AddToTabList(RiderTabs.EX_AID_TAB_ITEM).ChangeRepairItem(BLANK_GASHAT.get()));


	public static final DeferredItem<Item> GASHACON_BUGVISOR_GENM = ITEMS.register("gashacon_bugvisor_genmu",
			() -> new GamerDriverItem(ArmorMaterials.DIAMOND,"genm_bugvisor",DANGEROUS_ZOBIE_GASHAT_BD ,EX_AIDHELMET, EX_AIDCHESTPLATE,EX_AIDLEGGINGS , new Item.Properties().rarity(Rarity.UNCOMMON))
			.Override_belt_text("gashacon_bugvisor").AddToTabList(RiderTabs.EX_AID_TAB_ITEM).ChangeRepairItem(BLANK_GASHAT.get()));

	public static final DeferredItem<Item> GASHACON_BUGVISOR_II_CHRONOS = ITEMS.register("gashacon_bugvisor_ii_chronos",
			() -> new GamerDriverItem(ArmorMaterials.DIAMOND,"chronos",KAMEN_RIDER_CHRONICLE_GASHAT ,EX_AIDHELMET, EX_AIDCHESTPLATE,EX_AIDLEGGINGS , new Item.Properties().rarity(Rarity.UNCOMMON))
			.Override_belt_text("gashacon_bugvisor_ii").AddToTabList(RiderTabs.EX_AID_TAB_ITEM).ChangeRepairItem(BLANK_GASHAT.get()));

	public static final DeferredItem<Item> GASHACON_BUGVISOR_II_POPPY = ITEMS.register("gashacon_bugvisor_ii_poppy",
			() -> new GamerDriverItem(ArmorMaterials.DIAMOND,"poppy",TOKI_MEKI_CRISIS_GASHAT ,EX_AIDHELMET, EX_AIDCHESTPLATE,EX_AIDLEGGINGS , new Item.Properties())
					.Dont_show_belt_form_info().AddToTabList(RiderTabs.EX_AID_TAB_ITEM).ChangeRepairItem(BLANK_GASHAT.get()));

	public static final DeferredItem<Item> GASHACON_BUGVISOR_II_LAZER = ITEMS.register("gashacon_bugvisor_ii_lazer",
			() -> new GamerDriverItem(ArmorMaterials.DIAMOND,"lazer_lvx_",GIRI_GIRI_CHAMBARA_GASHAT_X ,EX_AIDHELMET, EX_AIDCHESTPLATE,EX_AIDLEGGINGS , new Item.Properties())
					.Dont_show_belt_form_info().Override_belt_text("gashacon_bugvisor_ii_lazer").AddToTabList(RiderTabs.EX_AID_TAB_ITEM).ChangeRepairItem(BLANK_GASHAT.get()));

	public static final DeferredItem<Item> GASHACON_BUGVISOR_II_CHRONICLE_BUGTER = ITEMS.register("gashacon_bugvisor_ii_chronicle_bugster",
			() -> new GamerDriverItem(ArmorMaterials.DIAMOND,"chronicle_bugster",KAMEN_RIDER_CHRONICLE_GASHAT ,EX_AIDHELMET, EX_AIDCHESTPLATE,EX_AIDLEGGINGS , new Item.Properties())
					.Dont_show_belt_form_info().Override_belt_text("gashacon_bugvisor_ii_chronicle_bugster_belt").AddToTabList(RiderTabs.EX_AID_TAB_ITEM).ChangeRepairItem(BLANK_GASHAT.get()));
	
	public static final DeferredItem<Item> PARA_DX_BELT = ITEMS.register("paradoxbelt",
			() -> new GamerDriverItem(ArmorMaterials.DIAMOND,"para_dx",PERFECT_PUZZLE_GASHAT ,EX_AIDHELMET, EX_AIDCHESTPLATE,EX_AIDLEGGINGS , new Item.Properties())
			.AddToTabList(RiderTabs.EX_AID_TAB_ITEM).ChangeRepairItem(BLANK_GASHAT.get()));

	public static final DeferredItem<Item> RIDE_PLAYER_BELT = ITEMS.register("rideplayerbelt",
			() -> new GamerDriverItem(ArmorMaterials.DIAMOND,"ride_player",UNFINISHED_KAMEN_RIDER_CHRONICLE_GASHAT ,EX_AIDHELMET, EX_AIDCHESTPLATE,EX_AIDLEGGINGS , new Item.Properties())
					.Dont_show_belt_form_info().AddToTabList(RiderTabs.EX_AID_TAB_ITEM).ChangeRepairItem(BLANK_GASHAT.get()));

	public static final DeferredItem<Item> RIDE_PLAYER_BELT_NICO = ITEMS.register("rideplayerbelt_nico",
			() -> new GamerDriverItem(ArmorMaterials.DIAMOND,"ride_player_nico",UNFINISHED_KAMEN_RIDER_CHRONICLE_GASHAT ,EX_AIDHELMET, EX_AIDCHESTPLATE,EX_AIDLEGGINGS , new Item.Properties())
					.Dont_show_belt_form_info().AddToTabList(RiderTabs.EX_AID_TAB_ITEM).ChangeRepairItem(BLANK_GASHAT.get()));

	public static final DeferredItem<Item> NINjA_PLAYER_BELT = ITEMS.register("ninjaplayerbelt",
			() -> new GamerDriverItem(ArmorMaterials.DIAMOND,"ninja_player",UNFINISHED_KAMEN_RIDER_CHRONICLE_GASHAT ,EX_AIDHELMET, EX_AIDCHESTPLATE,EX_AIDLEGGINGS , new Item.Properties())
					.Dont_show_belt_form_info().Override_belt_text("ninja_player_belt").AddToTabList(RiderTabs.EX_AID_TAB_ITEM).ChangeRepairItem(BLANK_GASHAT.get()));


	public static final DeferredItem<Item> GASHACON_BREAKER = ITEMS.register("gashacon_breaker",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).IsChangeSword().AddToTabList(RiderTabs.EX_AID_TAB_ITEM).AddToTabList(Decade_Rider_Items.NEO_DIEND_SUMMON_WEAPONS)
			.ChangeRepairItem(BLANK_GASHAT.get()));

	public static final DeferredItem<Item> GASHACON_KEY_SLASHER = ITEMS.register("gashacon_key_slasher",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 11, -3F, new Item.Properties()).IsSwordGun().AddToTabList(RiderTabs.EX_AID_TAB_ITEM).AddToTabList(Decade_Rider_Items.COMPLETE_21_WEAPONS)
			.ChangeRepairItem(BLANK_GASHAT.get()));

	public static final DeferredItem<Item> GASHACON_SWORD = ITEMS.register("gashacon_sword",
			() -> new BaseSwordItem(Tiers.DIAMOND, 6, -2F, new Item.Properties()).IsChangeSword().AddToTabList(RiderTabs.EX_AID_TAB_ITEM).AddToTabList(Decade_Rider_Items.NEO_DIEND_SUMMON_WEAPONS)
			.ChangeRepairItem(BLANK_GASHAT.get()));

	public static final DeferredItem<Item> GASHACON_MAGNUM = ITEMS.register("gashacon_magnum_gun",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.EX_AID_TAB_ITEM)
			.ChangeRepairItem(BLANK_GASHAT.get()));

	public static final DeferredItem<Item> GASHACON_SPARROW_SICKLE_A = ITEMS.register("gashacon_sparrow_sickle_a",
			() -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.EX_AID_TAB_ITEM)
			.ChangeRepairItem(BLANK_GASHAT.get()));

	public static final DeferredItem<Item> GASHACON_SPARROW_SICKLE_B = ITEMS.register("gashacon_sparrow_sickle_b",
			() -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.EX_AID_TAB_ITEM)
			.ChangeRepairItem(BLANK_GASHAT.get()));

	public static final DeferredItem<Item> GASHACON_SPARROW_ARROW = ITEMS.register("gashacon_sparrow_arrow",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 10, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.EX_AID_TAB_ITEM)
			.ChangeRepairItem(BLANK_GASHAT.get()));

	public static final DeferredItem<Item> GASHACON_BUGVISOR = ITEMS.register("gashacon_bugvisor",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).IsSwordGun().AddToTabList(RiderTabs.EX_AID_TAB_ITEM)
			.ChangeRepairItem(BLANK_GASHAT.get()));

	public static final DeferredItem<Item> GASHACON_BUGVISOR_II = ITEMS.register("gashacon_bugvisor_ii",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 10, -2.4F, new Item.Properties()).IsSwordGun().AddToTabList(RiderTabs.EX_AID_TAB_ITEM)
			.ChangeRepairItem(BLANK_GASHAT.get()));

	public static final DeferredItem<Item> GASHACON_BUGVISOR_G = ITEMS.register("gashacon_bugvisor_g",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).IsSwordGun().AddToTabList(RiderTabs.EX_AID_TAB_ITEM)
			.ChangeRepairItem(BLANK_GASHAT.get()));

	public static final DeferredItem<Item> PARABRAGUN = ITEMS.register("parabragun_axe",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 13, -3F, new Item.Properties()).IsSwordGun().AddToTabList(RiderTabs.EX_AID_TAB_ITEM)
			.ChangeRepairItem(BLANK_GASHAT.get()));

	public static final DeferredItem<Item> RIDE_WEAPON = ITEMS.register("ride_weapon",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).IsSwordGun().AddToTabList(RiderTabs.EX_AID_TAB_ITEM)
			.ChangeRepairItem(BLANK_GASHAT.get()));

	public static final DeferredItem<Item> TRUE_BRAVE_SWORD = ITEMS.register("true_brave_sword",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).AddToTabList(RiderTabs.EX_AID_TAB_ITEM)
			.ChangeRepairItem(BLANK_GASHAT.get()));

	public static final DeferredItem<Item> FUUMA_SWORD = ITEMS.register("fuuma_sword",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2F, new Item.Properties()).AddToTabList(RiderTabs.EX_AID_TAB_ITEM)
			.ChangeRepairItem(BLANK_GASHAT.get()));

	public static final DeferredItem<Item> GENIN_WEAPON = ITEMS.register("genin_weapon",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.EX_AID_TAB_ITEM)
			.ChangeRepairItem(BLANK_GASHAT.get()));

	public static final DeferredItem<Item> BUGSTER_TRIDENT = ITEMS.register("bugster_trident",
			() -> new BaseSwordItem(Tiers.DIAMOND, 2, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.EX_AID_TAB_ITEM)
			.ChangeRepairItem(BLANK_GASHAT.get()));

	public static final DeferredItem<Item> GRAPHITE_FANG = ITEMS.register("graphite_fang",
			() -> new BaseSwordItem(Tiers.DIAMOND, 7, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.EX_AID_TAB_ITEM)
			.ChangeRepairItem(BLANK_GASHAT.get()));


	public static final DeferredItem<Item> DEUS_RUSHER = ITEMS.register("deus_rusher",
			() -> new BaseSwordItem(Tiers.DIAMOND, 10, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.EX_AID_TAB_ITEM)
			.ChangeRepairItem(BLANK_GASHAT.get()));

	public static final DeferredItem<Item> DEUS_RAMPART = ITEMS.register("deus_rampart",
			() -> new BaseShieldItem(new Item.Properties()).AddToTabList(RiderTabs.EX_AID_TAB_ITEM)
			.ChangeRepairItem(BLANK_GASHAT.get()));

	public static final DeferredItem<Item> DEUS_RUSHER_RED = ITEMS.register("deus_rusher_red",
			() -> new BaseSwordItem(Tiers.DIAMOND, 15, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.EX_AID_TAB_ITEM)
			.ChangeRepairItem(BLANK_GASHAT.get()));

	public static final DeferredItem<Item> MACHINA_RAMPART = ITEMS.register("machina_rampart",
			() -> new BaseShieldItem(new Item.Properties()).AddToTabList(RiderTabs.EX_AID_TAB_ITEM)
			.ChangeRepairItem(BLANK_GASHAT.get()));



	public static final DeferredItem<Item> SPEED_ENERGY_ITEM = ITEMS.register("speed_energy_item",
			() -> new ExAidEnergyItem(new Item.Properties(),new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 500, 20,true,false)).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> IRON_ENERGY_ITEM = ITEMS.register("iron_energy_item",
			() -> new ExAidEnergyItem(new Item.Properties(),new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 500, 5,true,false)).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> INSTIGATE_ENERGY_ITEM = ITEMS.register("instigate_energy_item",
			() -> new ExAidEnergyItem(new Item.Properties(),new MobEffectInstance(MobEffects.GLOWING, 500, 0,true,false)).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> JUMP_ENERGY_ITEM = ITEMS.register("jump_energy_item",
			() -> new ExAidEnergyItem(new Item.Properties(),new MobEffectInstance(MobEffects.JUMP, 500, 10,true,false)).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> MUSCLE_ENERGY_ITEM = ITEMS.register("muscle_energy_item",
			() -> new ExAidEnergyItem(new Item.Properties(),new MobEffectInstance(MobEffects.DAMAGE_BOOST, 500, 5,true,false)).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> SHRINK_ENERGY_ITEM = ITEMS.register("shrink_energy_item",
			() -> new ExAidEnergyItem(new Item.Properties(),new MobEffectInstance(Effect_core.SMALL, 500, 2,true,false)).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> CHRISTMAS_ENERGY_ITEM = ITEMS.register("christmas_energy_item",
			() -> new ExAidEnergyItem(new Item.Properties(),new MobEffectInstance(Effect_core.CHRISTMAS, 500, 0,true,false)).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> STRETCH_ENERGY_ITEM = ITEMS.register("stretch_energy_item",
			() -> new ExAidEnergyItem(new Item.Properties(),new MobEffectInstance(Effect_core.STRETCH, 500, 2,true,false)).AddToList(RiderTabs.EX_AID_TAB_ITEM));


	public static final DeferredItem<Item> INVISIBLE_ENERGY_ITEM = ITEMS.register("invisible_energy_item",
			() -> new ExAidEnergyItem(new Item.Properties(),new MobEffectInstance(MobEffects.INVISIBILITY, 500, 0,true,false)).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> CONFUSION_ENERGY_ITEM = ITEMS.register("confusion_energy_item",
			() -> new ExAidEnergyItem(new Item.Properties(),new MobEffectInstance(MobEffects.CONFUSION, 500, 0,true,false)).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> RECOVER_ITEM = ITEMS.register("recover_energy_item",
			() -> new ExAidEnergyItem(new Item.Properties(),new MobEffectInstance(MobEffects.HEAL, 1, 10,true,false)).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	//seperation_energy_item

	public static final DeferredItem<Item> EMISSION_ENERGY_ITEM = ITEMS.register("emission_energy_item",
			() -> new ExAidEnergyItem(new Item.Properties(),new MobEffectInstance(MobEffects.NIGHT_VISION, 500, 0,true,false)).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> REFLECT_ENERGY_ITEM = ITEMS.register("reflect_energy_item",
			() -> new ExAidEnergyItem(new Item.Properties(),new MobEffectInstance(Effect_core.REFLECT, 500, 0,true,false)).AddToList(RiderTabs.EX_AID_TAB_ITEM));


	public static final DeferredItem<Item> SAVE_ENERGY_ITEM = ITEMS.register("save_energy_item",
			() -> new ExAidEnergyItem(new Item.Properties().rarity(Rarity.UNCOMMON),new MobEffectInstance(Effect_core.MUTEKI, 500, 0,true,false)).AddToList(RiderTabs.EX_AID_TAB_ITEM));


	public static final DeferredItem<Item> REVERSE_ITEM = ITEMS.register("reverse_energy_item",
			() -> new ExAidEnergyItem(new Item.Properties(),new MobEffectInstance(MobEffects.HEAL, 1, 10,true,false)).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> GIANT_ENERGY_ITEM = ITEMS.register("giant_energy_item",
			() -> new ExAidEnergyItem(new Item.Properties(),new MobEffectInstance(Effect_core.BIG, 500, 2,true,false)).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	//disguise_energy_item

	public static final DeferredItem<Item> LIQUID_ENERGY_ITEM = ITEMS.register("liquid_energy_item",
			() -> new ExAidEnergyItem(new Item.Properties(),new MobEffectInstance(MobEffects.WATER_BREATHING, 500, 0,true,false)).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> DARK_ENERGY_ITEM = ITEMS.register("dark_energy_item",
			() -> new ExAidEnergyItem(new Item.Properties(),new MobEffectInstance(MobEffects.BLINDNESS, 500, 0,true,false)).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> SLEEP_ENERGY_ITEM = ITEMS.register("sleep_energy_item",
			() -> new ExAidEnergyItem(new Item.Properties(),new MobEffectInstance(Effect_core.SLEEP, 500, 0,true,false)).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> LUCKY_ENERGY_ITEM = ITEMS.register("lucky_energy_item",
			() -> new ExAidEnergyItem(new Item.Properties(),new MobEffectInstance(MobEffects.LUCK, 500, 0,true,false)).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> FLATTEN_ENERGY_ITEM = ITEMS.register("flatten_energy_item",
			() -> new ExAidEnergyItem(new Item.Properties(),new MobEffectInstance(Effect_core.FLAT, 500, 2,true,false)).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> BALLOON_ENERGY_ITEM = ITEMS.register("balloon_energy_item",
			() -> new ExAidEnergyItem(new Item.Properties(),new MobEffectInstance(Effect_core.WIDE, 500, 2,true,false)).AddToList(RiderTabs.EX_AID_TAB_ITEM));


	//gag_energy_item
	//fascination_energy_item
	//partner_energy_item
	//prediction_energy_item
	public static final DeferredItem<Item> HALT_ENERGY_ITEM = ITEMS.register("halt_energy_item",
			() -> new ExAidEnergyItem(new Item.Properties(),new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 500, 100,true,false)).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> END_ENERGY_ITEM = ITEMS.register("end_energy_item",
			() -> new ExAidEnergyItem(new Item.Properties(),new MobEffectInstance(Effect_core.EXPLODE, 500, 1,true,false)).AddToList(RiderTabs.EX_AID_TAB_ITEM));

	//random_energy_item
	public static final DeferredItem<Item> BUG_ENERGY_ITEM = ITEMS.register("bug_energy_item",
			() -> new ExAidEnergyItem(new Item.Properties(),new MobEffectInstance(Effect_core.BUGSTER, 500, 1,true,false)).AddToList(RiderTabs.EX_AID_TAB_ITEM));


	// no plan to add these but adding just in case

	//Senior
	//Memory
	//Desire
	//Friendship
	//Veteran
	//Succession

	//Continue
	//Rampage
	//Afterimage
	//Geniusization
	//Barrier
	//Gravity-Manipulation
	//Weathering
	//Thunder-Strike
	//Cyclone
	//Joker
	//Destroyer
	//Negativeization
	//Calming
	//Passion
	//Deadly-Poison
	//Knight
	//War God
	//Justice
	//Oblivion
	//Lost
	//Ending
	//Mechanization
	//United-Fight
	//Mortality
	//Fusion A
	//Fusion B
	//Sorrow
	//Fury
	//Survive 
	//Breakout
	//Freezing
	//Seal
	//Love & Peace
	//Eye
	//Sliding
	//Enjoyment

	//Aries
	//Taurus
	//Gemini
	//Cancer
	//Leo
	//Virgo
	//Libra
	//Scorpio
	//Sagittarius
	//Capricorn
	//Aquarius
	//Pisces

	//Supernova

	//Sonic Speeding-Up
	//Diamond-Body
	//Abetting
	//Flight
	//Rigidification
	//Full-Recover
	//Minimize
	//Maximize
	//Disappearance
	//Chaos

	//State Change
	//Multiplication
	//Jet Black
	//Flexible
	//Hypnosis
	//Ironclad
	//Resuscitation
	//Heisei
	//Fortune
	//Paper
	//Expansion
	//Very Funny
	//Captivation
	//Unique
	//Wisdom
	//Demise
	//Inheritance
	//Uncontrollable
	//Second Coming
	//Full Stop

	//Tomorrow
	//Wind
	//Forest
	//Fire
	//Shadow
	//Mountain
	//Thunder

	// Ghost x Ex-Aid maybe use for the Ex-Aid Ghost Eyecon

	public static final DeferredItem<Item> RIDER_GASHAT_CASE = ITEMS.register("rider_gashat_case",
			() -> new RiderGashatCaseItem().has_basic_model().AddToList(RiderTabs.EX_AID_TAB_ITEM));

	public static final DeferredItem<Item> ENERGY_ITEM_HOLDER = ITEMS.register("energy_item_holder",
			() -> new EnergyItemHolderItem().AddToList(RiderTabs.EX_AID_TAB_ITEM));


	public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}

}