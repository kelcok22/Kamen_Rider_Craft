package com.kelco.kamenridercraft.item;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.block.machineBlocks.GSystemChipProgrammer;
import com.kelco.kamenridercraft.item.BaseItems.*;
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

public class Agito_Rider_Items {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);

	public static final DeferredItem<Item> AGITO_LOGO = ITEMS.register("agito_logo",
			() -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/agito")), new Item.Properties()).AddToList(RiderTabs.AGITO_TAB_ITEM));

	public static final DeferredItem<Item> SEED_OF_AGITO = ITEMS.register("agito_of_seed",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.AGITO_TAB_ITEM));

	public static final DeferredItem<Item> AGITO_GROUND = ITEMS.register("agito_ground",
			() -> new RiderFormChangeItem(new Item.Properties(),"","agito","alter_ring_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.IsGlowing().IsBeltGlowing().AddToList(RiderTabs.AGITO_TAB_ITEM));


	public static final DeferredItem<Item> AGITO_STORM = ITEMS.register("agito_storm",
			() -> new RiderFormChangeItem(new Item.Properties(),"_storm","agito","alter_ring_belt_s",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.IsGlowing().IsBeltGlowing().AddToList(RiderTabs.AGITO_TAB_ITEM));

	public static final DeferredItem<Item> AGITO_FLAME = ITEMS.register("agito_flame",
			() -> new RiderFormChangeItem(new Item.Properties(),"_flame","agito","alter_ring_belt_f",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.IsGlowing().IsBeltGlowing().AddToList(RiderTabs.AGITO_TAB_ITEM));

	public static final DeferredItem<Item> AGITO_TRINITY = ITEMS.register("agito_trinity",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"_trinity","agito","alter_ring_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.IsGlowing().IsBeltGlowing().AddToList(RiderTabs.AGITO_TAB_ITEM));

	public static final DeferredItem<Item> AGITO_BURNING = ITEMS.register("agito_burning",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"_burning","agito","alter_ring_belt_b",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 200, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.IsGlowing().IsBeltGlowing().AddToList(RiderTabs.AGITO_TAB_ITEM));

	public static final DeferredItem<Item> AGITO_SHINING = ITEMS.register("agito_shining",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),"_shining","agito","alter_ring_belt_b",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 200, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.IsGlowing().IsBeltGlowing().AddToList(RiderTabs.AGITO_TAB_ITEM));

	public static final DeferredItem<Item> ICONGA_NO_AKAI_AGITO= ITEMS.register("iconga_no_akai_agito",
			() -> new RiderFormChangeItem(new Item.Properties(),"_iconga_no_akai","agito","alter_ring_belt_f",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.IsGlowing().IsBeltGlowing().has_basic_model().model_has_different_name("another_agito").AddToList(RiderTabs.AGITO_TAB_ITEM));


	public static final DeferredItem<Item> GILLS = ITEMS.register("gills",
			() -> new RiderFormChangeItem(new Item.Properties(),"","gills","meta_factor_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.DARK_GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.IsGlowing().AddToList(RiderTabs.AGITO_TAB_ITEM));

	public static final DeferredItem<Item> EXCEED_GILLS = ITEMS.register("exceed_gills",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"_exceed","gills","meta_factor_belt_e",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.DARK_GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);

					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.IsGlowing().AddToList(RiderTabs.AGITO_TAB_ITEM));

	public static final DeferredItem<Item> GOLD_EXCEED_GILLS = ITEMS.register("gold_exceed_gills",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),"_gold_exceed","gills","meta_factor_belt_g",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);

					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.IsGlowing().ChangeModel("gills_exceed.geo.json").AddToList(RiderTabs.AGITO_TAB_ITEM));


	public static final DeferredItem<Item> ANOTHER_AGITO = ITEMS.register("another_agito",
			() -> new RiderFormChangeItem(new Item.Properties(),"","another_agito","ank_point_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.DARK_GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.IsGlowing().AddToList(RiderTabs.AGITO_TAB_ITEM));

	public static final DeferredItem<Item> MIRAGE_AGITO = ITEMS.register("agito_miracle",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.EPIC),"","mirage_agito","alter_ring_mirage_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false)) {
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 300, 0, 0, 0, 1);
				}
			}.IsGlowing().IsGlowing().IsBeltGlowing().AddToList(RiderTabs.AGITO_TAB_ITEM));


	public static final DeferredItem<Item> ANOTHER_AGITO_KOJI = ITEMS.register("another_agito_koji",
			() -> new RiderFormChangeItem(new Item.Properties(),"","another_agito_koji","ank_point_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false)) {
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.IsGlowing().AddToList(RiderTabs.AGITO_TAB_ITEM));

	public static final DeferredItem<Item> ANOTHER_AGITO_BURNING = ITEMS.register("another_agito_burning_form",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"_burning","another_agito_koji","ank_point_belt_b",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 5,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.IsGlowing().AddToList(RiderTabs.AGITO_TAB_ITEM));


	public static final DeferredItem<Item> BLANK_G_SYSTEM_CHIP = ITEMS.register("g3core",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.AGITO_TAB_ITEM));

	public static final DeferredItem<Item> G3_CHIP = ITEMS.register("g3",
			() -> new RiderFormChangeItem(new Item.Properties(),"","g3","g_buckle_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY() + 1,
							player.getZ(), 100, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY() + 1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.IsGlowing().IsBeltGlowing().AddToList(GSystemChipProgrammer.G_CHIP, 10).AddToList(RiderTabs.AGITO_TAB_ITEM));

	public static final DeferredItem<Item> G3_X_CHIP = ITEMS.register("g3x",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"","g3_x","g_buckle_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY() + 1,
							player.getZ(), 100, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY() + 1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.IsGlowing().IsBeltGlowing().AddToList(GSystemChipProgrammer.G_CHIP, 3).AddToList(RiderTabs.AGITO_TAB_ITEM));

	public static final DeferredItem<Item> G3_MILD_CHIP = ITEMS.register("g3mild",
			() -> new RiderFormChangeItem(new Item.Properties(),"","g3_mild","g_buckle_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY() + 1,
							player.getZ(), 100, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY() + 1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.IsGlowing().IsBeltGlowing().AddToList(GSystemChipProgrammer.G_CHIP, 2).AddToList(RiderTabs.AGITO_TAB_ITEM));

	public static final DeferredItem<Item> G4_CHIP = ITEMS.register("g4",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"","g4","g_buckle_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.POISON, 40, 0,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY() + 1,
							player.getZ(), 100, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
							player.getX(), player.getY() + 1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.IsGlowing().IsBeltGlowing().AddToList(GSystemChipProgrammer.G_CHIP, 1).AddToList(RiderTabs.AGITO_TAB_ITEM));

	public static final DeferredItem<Item> G4_X_CHIP = ITEMS.register("g4x",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),"","g4_x","g_buckle_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY() + 1,
							player.getZ(), 100, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY() + 1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.IsGlowing().IsBeltGlowing().AddToList(RiderTabs.AGITO_TAB_ITEM));

    public static final DeferredItem<Item> G6_CHIP = ITEMS.register("g6",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"","g6","g_buckle_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing().IsBeltGlowing().has_basic_model().AddToList(GSystemChipProgrammer.G_CHIP, 1).AddToList(RiderTabs.AGITO_TAB_ITEM));


    public static final DeferredItem<Item> G1_CHIP = ITEMS.register("g1",
			() -> new RiderFormChangeItem(new Item.Properties(),"","g1","g_buckle_belt_1",
					new MobEffectInstance(MobEffects.WEAKNESS, 40, 0,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY() + 1,
							player.getZ(), 100, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY() + 1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.IsGlowing().IsBeltGlowing().AddToList(GSystemChipProgrammer.G_CHIP, 1).AddToList(RiderTabs.AGITO_TAB_ITEM));

	public static final DeferredItem<Item> V1_CHIP = ITEMS.register("v1",
			() -> new RiderFormChangeItem(new Item.Properties(),"","v1","blank",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY() + 1,
							player.getZ(), 100, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
							player.getX(), player.getY() + 1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.AddToList(GSystemChipProgrammer.G_CHIP, 2).AddToList(RiderTabs.AGITO_TAB_ITEM));

	public static final DeferredItem<Item> AGITOHELMET = ITEMS.register("agitohead",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.AGITO_TAB_ITEM).ChangeRepairItem(SEED_OF_AGITO.get()));
	public static final DeferredItem<Item> AGITOCHESTPLATE = ITEMS.register("agitotroso",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.AGITO_TAB_ITEM).ChangeRepairItem(SEED_OF_AGITO.get()));
	public static final DeferredItem<Item> AGITOLEGGINGS = ITEMS.register("agitolegs",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.AGITO_TAB_ITEM).ChangeRepairItem(SEED_OF_AGITO.get()));


	public static final DeferredItem<Item> ALTERING = ITEMS.register("alter_ring",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"agito",AGITO_GROUND ,AGITOHELMET, AGITOCHESTPLATE,AGITOLEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.AGITO_TAB_ITEM).ChangeRepairItem(SEED_OF_AGITO.get()));

	public static final DeferredItem<Item> ALTERING_REIKO = ITEMS.register("alter_ring_reiko",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"female_agito",AGITO_TRINITY ,AGITOHELMET, AGITOCHESTPLATE,AGITOLEGGINGS , new Item.Properties().rarity(Rarity.UNCOMMON)).AddToTabList(RiderTabs.AGITO_TAB_ITEM).ChangeRepairItem(SEED_OF_AGITO.get()));


	public static final DeferredItem<Item> META_FACTOR = ITEMS.register("meta_factor",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"gills",GILLS ,AGITOHELMET, AGITOCHESTPLATE,AGITOLEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.AGITO_TAB_ITEM).ChangeRepairItem(SEED_OF_AGITO.get()));

	public static final DeferredItem<Item> ANK_POINT = ITEMS.register("ank_point",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"another_agito",ANOTHER_AGITO ,AGITOHELMET, AGITOCHESTPLATE,AGITOLEGGINGS , new Item.Properties())
					.Dont_show_belt_form_info().AddToTabList(RiderTabs.AGITO_TAB_ITEM).ChangeRepairItem(SEED_OF_AGITO.get()));

	public static final DeferredItem<Item> G_BUCKLE_G3 = ITEMS.register("g3_belt",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"g3",G3_CHIP ,AGITOHELMET, AGITOCHESTPLATE,AGITOLEGGINGS , new Item.Properties())
					.Dont_show_belt_form_info().AddToTabList(RiderTabs.AGITO_TAB_ITEM).ChangeRepairItem(BLANK_G_SYSTEM_CHIP.get()));

	public static final DeferredItem<Item> G_BUCKLE_G3_X = ITEMS.register("g3_x_belt",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"g3_x",G3_X_CHIP ,AGITOHELMET, AGITOCHESTPLATE,AGITOLEGGINGS , new Item.Properties().rarity(Rarity.UNCOMMON))
					.Dont_show_belt_form_info().AddToTabList(RiderTabs.AGITO_TAB_ITEM).ChangeRepairItem(BLANK_G_SYSTEM_CHIP.get()));

	public static final DeferredItem<Item> G_BUCKLE_G3_MILD = ITEMS.register("g3_mild_belt",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"g3_mild",G3_MILD_CHIP ,AGITOHELMET, AGITOCHESTPLATE,AGITOLEGGINGS , new Item.Properties())
					.Dont_show_belt_form_info().AddToTabList(RiderTabs.AGITO_TAB_ITEM).ChangeRepairItem(BLANK_G_SYSTEM_CHIP.get()));

	public static final DeferredItem<Item> G_BUCKLE_G4 = ITEMS.register("g4_belt",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"g4",G4_CHIP ,AGITOHELMET, AGITOCHESTPLATE,AGITOLEGGINGS , new Item.Properties().rarity(Rarity.UNCOMMON))
					.Dont_show_belt_form_info().AddToTabList(RiderTabs.AGITO_TAB_ITEM).ChangeRepairItem(BLANK_G_SYSTEM_CHIP.get()));

	public static final DeferredItem<Item> G_BUCKLE_G4_X = ITEMS.register("g4_x_belt",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"g4_x",G4_X_CHIP ,AGITOHELMET, AGITOCHESTPLATE,AGITOLEGGINGS , new Item.Properties().rarity(Rarity.RARE))
					.Dont_show_belt_form_info().AddToTabList(RiderTabs.AGITO_TAB_ITEM).ChangeRepairItem(BLANK_G_SYSTEM_CHIP.get()));

    public static final DeferredItem<Item> G_BUCKLE_G6 = ITEMS.register("g6_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"g6",G6_CHIP ,AGITOHELMET, AGITOCHESTPLATE,AGITOLEGGINGS , new Item.Properties().rarity(Rarity.RARE))
                    .Dont_show_belt_form_info().AddToTabList(RiderTabs.AGITO_TAB_ITEM).ChangeRepairItem(BLANK_G_SYSTEM_CHIP.get()));

    public static final DeferredItem<Item> G_BUCKLE_G1 = ITEMS.register("g1_belt",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"g1",G1_CHIP ,AGITOHELMET, AGITOCHESTPLATE,AGITOLEGGINGS , new Item.Properties())
					.Dont_show_belt_form_info().AddToTabList(RiderTabs.AGITO_TAB_ITEM).ChangeRepairItem(BLANK_G_SYSTEM_CHIP.get()));

	public static final DeferredItem<Item> V1_BELT = ITEMS.register("v1_belt",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"v1",V1_CHIP ,AGITOHELMET, AGITOCHESTPLATE,AGITOLEGGINGS , new Item.Properties())
					.Dont_show_belt_form_info().AddToTabList(RiderTabs.AGITO_TAB_ITEM).ChangeRepairItem(BLANK_G_SYSTEM_CHIP.get()));

	public static final DeferredItem<Item> ALTERING_MIRAGE = ITEMS.register("alter_ring_miracle",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"mirage_agito",MIRAGE_AGITO ,AGITOHELMET, AGITOCHESTPLATE,AGITOLEGGINGS , new Item.Properties().rarity(Rarity.EPIC)).AddToTabList(RiderTabs.AGITO_TAB_ITEM).ChangeRepairItem(SEED_OF_AGITO.get()));

	public static final DeferredItem<Item> ANK_POINT_BURNING = ITEMS.register("ank_point_burning",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"another_agito_koji",ANOTHER_AGITO_KOJI ,AGITOHELMET, AGITOCHESTPLATE,AGITOLEGGINGS , new Item.Properties()).AddToTabList(RiderTabs.AGITO_TAB_ITEM).ChangeRepairItem(SEED_OF_AGITO.get()));

	public static final DeferredItem<Item> FLAME_SABER = ITEMS.register("flame_saber",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToList(RiderTabs.AGITO_TAB_ITEM).ChangeRepairItem(SEED_OF_AGITO.get()));
	public static final DeferredItem<Item> STORM_HALBERD = ITEMS.register("storm_halberd",
			() -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToList(RiderTabs.AGITO_TAB_ITEM).ChangeRepairItem(SEED_OF_AGITO.get()));

	public static final DeferredItem<Item> SHINING_CALIBER = ITEMS.register("shining_caliber_summoned",
			() -> new BaseSwordItem(Tiers.DIAMOND, 7, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).AddToList(RiderTabs.AGITO_TAB_ITEM).ChangeRepairItem(SEED_OF_AGITO.get()));
	public static final DeferredItem<Item> SHINING_CALIBER_TWIN = ITEMS.register("shining_caliber",
			() -> new BaseSwordItem(Tiers.DIAMOND, 7, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).AddToList(RiderTabs.AGITO_TAB_ITEM).ChangeRepairItem(SEED_OF_AGITO.get()));


	public static final DeferredItem<Item> GUARD_ACCELLER = ITEMS.register("guard_acceller",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToList(RiderTabs.AGITO_TAB_ITEM).ChangeRepairItem(SEED_OF_AGITO.get()));
	public static final DeferredItem<Item> GM_01_SCORPION = ITEMS.register("gm_01_scorpion",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).setProjectile(BaseBlasterItem.BlasterProjectile.LASER).AddToList(RiderTabs.AGITO_TAB_ITEM).ChangeRepairItem(SEED_OF_AGITO.get()));
	public static final DeferredItem<Item> GG_02_SALAMANDER = ITEMS.register("gg_02_salamander",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).setProjectile(BaseBlasterItem.BlasterProjectile.LARGE_FIREBALL).setCooldown(20).setExplosionPower(1).AddToList(RiderTabs.AGITO_TAB_ITEM).ChangeRepairItem(SEED_OF_AGITO.get()));
	public static final DeferredItem<Item> GS_03_DESTROYER = ITEMS.register("gs_03_destroyer",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToList(RiderTabs.AGITO_TAB_ITEM).ChangeRepairItem(SEED_OF_AGITO.get()));
	public static final DeferredItem<Item> GA_04_ANTARES = ITEMS.register("ga_04_antares",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToList(RiderTabs.AGITO_TAB_ITEM).ChangeRepairItem(SEED_OF_AGITO.get()));
	public static final DeferredItem<Item> GX_05_KERBEROS = ITEMS.register("gx_05_kerberos",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).setProjectile(BaseBlasterItem.BlasterProjectile.LASER).AddToList(RiderTabs.AGITO_TAB_ITEM).ChangeRepairItem(SEED_OF_AGITO.get()));
	public static final DeferredItem<Item> GX_LAUNCHER = ITEMS.register("gx_launcher",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).setProjectile(BaseBlasterItem.BlasterProjectile.ROCKET).setCooldown(80).setExplosionPower(2).AddToList(RiderTabs.AGITO_TAB_ITEM).ChangeRepairItem(SEED_OF_AGITO.get()));
	public static final DeferredItem<Item> GK_06_UNICORN = ITEMS.register("gk_06_unicorn",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties().rarity(Rarity.RARE)).AddToList(RiderTabs.AGITO_TAB_ITEM).ChangeRepairItem(SEED_OF_AGITO.get()));
	public static final DeferredItem<Item> G3_SHIELD = ITEMS.register("g3_shield",
			() -> new BaseShieldItem(new Item.Properties()).AddToTabList(RiderTabs.AGITO_TAB_ITEM).ChangeRepairItem(SEED_OF_AGITO.get()));
	public static final DeferredItem<Item> G3_X_SHIELD = ITEMS.register("g3x_shield",
			() -> new BaseShieldItem(new Item.Properties().rarity(Rarity.UNCOMMON)).AddToTabList(RiderTabs.AGITO_TAB_ITEM).ChangeRepairItem(SEED_OF_AGITO.get()));


	public static final DeferredItem<Item> G4_GIGANT = ITEMS.register("g4_gigant",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 4, 1f, new Item.Properties().rarity(Rarity.RARE)).setProjectile(BaseBlasterItem.BlasterProjectile.ROCKET).setCooldown(60).setExplosionPower(3).AddToList(RiderTabs.AGITO_TAB_ITEM).ChangeRepairItem(SEED_OF_AGITO.get()));


	public static final DeferredItem<Item>V1_SHOT = ITEMS.register("v1_shot",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToList(RiderTabs.AGITO_TAB_ITEM).setProjectile(BaseBlasterItem.BlasterProjectile.LASER).ChangeRepairItem(SEED_OF_AGITO.get()));


	public static final DeferredItem<Item> JUDGEMENT_STAFF = ITEMS.register("judgment_staff",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToList(RiderTabs.AGITO_TAB_ITEM).ChangeRepairItem(SEED_OF_AGITO.get()));
	public static final DeferredItem<Item> RESENTMENT_DU_SANGA = ITEMS.register("el_of_the_water_staff",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToList(RiderTabs.AGITO_TAB_ITEM).ChangeRepairItem(SEED_OF_AGITO.get()));

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}

}