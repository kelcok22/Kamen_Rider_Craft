package com.kelco.kamenridercraft.item;

import com.kelco.kamenridercraft.KamenRiderCraftCore;

import com.kelco.kamenridercraft.block.machineBlocks.CellMedalProgramer;
import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.bikes.RidevendorVendingModeEntity;
import com.kelco.kamenridercraft.item.BaseItems.*;
import com.kelco.kamenridercraft.item.ooo.*;
import com.kelco.kamenridercraft.item.tabs.RiderTabs;
import com.kelco.kamenridercraft.particle.ModParticles;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;

public class OOO_Rider_Items {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);
	public static List<Item> SPECIAL_NAME_MEDALS = new ArrayList<>();

	public static final DeferredItem<Item> OOO_LOGO = ITEMS.register("ooo_logo",
			() -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/ooo")), new Item.Properties()).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item>CELL_MEDAL = ITEMS.register("cellmedal",
			() -> new CellMedalItem(new Item.Properties()).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> CELL_ALLOY_INGOT = ITEMS.register("cell_alloy_ingot",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.OOO_TAB_ITEM));


	public static final DeferredItem<Item> TAKA_MEDAL = ITEMS.register("taka_medal",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_taka","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}.AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));

	public static final DeferredItem<Item> KUJAKU_MEDAL = ITEMS.register("kujaku_medal",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_kujaku","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}.ChangeSlot(2).hasFlyingWings( "ooo_rider_plusbelt_and_wings.geo.json").AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));

	public static final DeferredItem<Item> CONDOR_MEDAL = ITEMS.register("condor_medal",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_condor","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}.ChangeSlot(3).AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));

	public static final DeferredItem<Item> TAKA_ANKH_MEDAL = ITEMS.register("taka_ankh_medal",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_taka","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.REGENERATION, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
					new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}.ChangeSlot(1).AddToList(RiderTabs.OOO_TAB_ITEM));


	public static final DeferredItem<Item> LION_MEDAL = ITEMS.register("lion_medal",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_lion","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}.AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));

	public static final DeferredItem<Item> TORA_MEDAL = ITEMS.register("tora_medal",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_tora","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}.ChangeSlot(2).AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));

	public static final DeferredItem<Item> CHEETAH_MEDAL = ITEMS.register("cheetah_medal",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_cheetah","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}.ChangeSlot(3).AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));


	public static final DeferredItem<Item> KUWAGATA_MEDAL = ITEMS.register("kuwagata_medal",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_kuwagata","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}.AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));

	public static final DeferredItem<Item> KAMAKIRI_MEDAL = ITEMS.register("kamakiri_medal",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_kamakiri","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}.ChangeSlot(2).AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));

	public static final DeferredItem<Item> BATTA_MEDAL = ITEMS.register("batta_medal",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_batta","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}.ChangeSlot(3).AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));


	public static final DeferredItem<Item> SAI_MEDAL = ITEMS.register("sai_medal",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_sai","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 1,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}.ChangeSlot(1).AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));

	public static final DeferredItem<Item> GORILLA_MEDAL = ITEMS.register("gorilla_medal",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_gorilla","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 1,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}.ChangeSlot(2).AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));

	public static final DeferredItem<Item> ZOU_MEDAL = ITEMS.register("zou_medal",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_zou","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 1,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}.ChangeSlot(3).AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));


	public static final DeferredItem<Item> SHACHI_MEDAL = ITEMS.register("shachi_medal",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_shachi","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}.ChangeSlot(1).AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));

	public static final DeferredItem<Item> UNAGI_MEDAL = ITEMS.register("unagi_medal",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_unagi","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}.ChangeSlot(2).AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));

	public static final DeferredItem<Item> TAKO_MEDAL = ITEMS.register("tako_medal",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_tako","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}.ChangeSlot(3).AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));


	public static final DeferredItem<Item> PTERA_MEDAL = ITEMS.register("ptera_medal",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"_ptera","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}.ChangeSlot(1).AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(Decade_Rider_Items.COMPLETE_21_FORMS).AddToList(SPECIAL_NAME_MEDALS));

	public static final DeferredItem<Item> TRICERA_MEDAL = ITEMS.register("tricera_medal",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"_tricera","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40	, 3,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}.ChangeSlot(2).AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));

	public static final DeferredItem<Item> TYRANNO_MEDAL = ITEMS.register("tyranno_medal",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"_tyranno","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}.ChangeSlot(3).AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));


	public static final DeferredItem<Item> COBRA_MEDAL = ITEMS.register("cobra_medal",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_cobra","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.REGENERATION, 40, 0,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}.ChangeSlot(1).AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));

	public static final DeferredItem<Item> KAME_MEDAL = ITEMS.register("kame_medal",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_kame","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false)){
						public void OnTransformation(ItemStack itemstack, LivingEntity player) {
							super.OnTransformation(itemstack, player);
							((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
									player.getX(), player.getY()+1,
									player.getZ(), 30, 0, 0, 0, 0.1);
						}
					}
			.ChangeSlot(2).AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));

	public static final DeferredItem<Item> WANI_MEDAL = ITEMS.register("wani_medal",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_wani","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}.ChangeSlot(3).AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));


	public static final DeferredItem<Item> SASORI_MEDAL = ITEMS.register("sasori_medal",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","core","core_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ParticleTypes.FLAME,
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}.ChangeSlot(3).AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));

	public static final DeferredItem<Item> KANI_MEDAL = ITEMS.register("kani_medal",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","core","core_driver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 2,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ParticleTypes.FLAME,
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}.ChangeSlot(2).AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));

	public static final DeferredItem<Item> EBI_MEDAL = ITEMS.register("ebi_medal",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","core","core_driver_belt",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ParticleTypes.FLAME,
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}.IsGlowing().ChangeSlot(1).SetPalyerModelInvisible().AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));


	public static final DeferredItem<Item> MUKADE_MEDAL = ITEMS.register("mukade_medal",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_mukade","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}
			.ChangeSlot(1).AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));

	public static final DeferredItem<Item> HACHI_MEDAL = ITEMS.register("hachi_medal",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_hachi","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}
			.ChangeSlot(2).AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));

	public static final DeferredItem<Item> ARI_MEDAL = ITEMS.register("ari_medal",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_ari","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}
			.ChangeSlot(3).AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));


	public static final DeferredItem<Item> EBI_NEW_MEDAL = ITEMS.register("ebi_new_medal",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_ebi","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}.IsGlowing().ChangeSlot(1).AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));

	public static final DeferredItem<Item> KANI_NEW_MEDAL = ITEMS.register("kani_new_medal",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_kani","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}.ChangeSlot(2).AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));

	public static final DeferredItem<Item> SASORI_NEW_MEDAL = ITEMS.register("sasori_new_medal",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_sasori","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}
			.ChangeSlot(3).AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));


	public static final DeferredItem<Item> SAME_MEDAL = ITEMS.register("same_medal",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_same","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}.IsGlowing().ChangeSlot(1).AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));

	public static final DeferredItem<Item> KUJIRA_MEDAL = ITEMS.register("kujira_medal",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_kujira","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)) {
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}.ChangeSlot(2).AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));

	public static final DeferredItem<Item> OOKAMIUO_MEDAL = ITEMS.register("ookamiuo_medal",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_ookamiuo","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}.ChangeSlot(3).AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));


	public static final DeferredItem<Item> SHIKA_MEDAL = ITEMS.register("shika_medal",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_shika","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}.ChangeSlot(1).AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));

	public static final DeferredItem<Item> GAZELLE_MEDAL = ITEMS.register("gazelle_medal",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_gazelle","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.DARK_RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}.ChangeSlot(2).AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));

	public static final DeferredItem<Item> USHI_MEDAL = ITEMS.register("ushi_medal",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_ushi","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}.ChangeSlot(3).AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));


	public static final DeferredItem<Item> SEIUCHI_MEDAL = ITEMS.register("seiuchi_medal",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_seiuchi","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.SATURATION, 40, 1,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}.ChangeSlot(1).AddToList(CellMedalProgramer.SEISHIROGIN).AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));

	public static final DeferredItem<Item> SHIROKUMA_MEDAL = ITEMS.register("shirokuma_medal",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_shirokuma","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}.ChangeSlot(2).AddToList(CellMedalProgramer.SEISHIROGIN).AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));

	public static final DeferredItem<Item> PENGUIN_MEDAL = ITEMS.register("penguin_medal",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_penguin","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}.ChangeSlot(3).AddToList(CellMedalProgramer.SEISHIROGIN).AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));


	public static final DeferredItem<Item> PANDA_MEDAL = ITEMS.register("panda_medal",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_panda","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}
			.ChangeSlot(2).AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));


	public static final DeferredItem<Item> KANGAROO_MEDAL_LEG = ITEMS.register("kangaroo_medal_leg",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_kangaroo_leg","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}.ChangeSlot(3).AddToList(SPECIAL_NAME_MEDALS));


	public static final DeferredItem<Item> KANGAROO_MEDAL = ITEMS.register("kangaroo_medal",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_kangaroo","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}.ChangeSlot(2).addShiftForm(KANGAROO_MEDAL_LEG.get()).AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));


	public static final DeferredItem<Item> YADOKARI_MEDAL = ITEMS.register("yadokari_medal",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_yadokari","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}.ChangeSlot(2).AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));


	public static final DeferredItem<Item> SUPER_TAKA_MEDAL = ITEMS.register("super_taka_medal",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.EPIC),0,"_super_taka","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(Effect_core.BOOST, 40, 0,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 0.1);
				}
			}.ChangeSlot(1).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> SUPER_TORA_MEDAL = ITEMS.register("super_tora_medal",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.EPIC),0,"_super_tora","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 5,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 0.1);
				}
			}.ChangeSlot(2).hasFlyingWings( "ooo_rider_plusbelt_and_wings.geo.json").AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> SUPER_BATTA_MEDAL = ITEMS.register("super_batta_medal",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.EPIC),0,"_super_batta","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 0.1);
				}
			}.ChangeSlot(3).AddToList(RiderTabs.OOO_TAB_ITEM));


	public static final DeferredItem<Item> TAKA_ETERNITY_MEDAL = ITEMS.register("taka_eternity_medal",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"_taka_eternity","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.SATURATION, 40, 1,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 60, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 10, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 10, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 10, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 10, 0, 0, 0, 0.1);
				}
			}.ChangeSlot(1).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> KUJAKU_ETERNITY_MEDAL = ITEMS.register("kujaku_eternity_medal",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"_kujaku_eternity","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 60, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 10, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 10, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 10, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 10, 0, 0, 0, 0.1);
				}
			}.ChangeSlot(2).hasFlyingWings( "ooo_rider_plusbelt_and_wings.geo.json").AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> CONDOR_ETERNITY_MEDAL = ITEMS.register("condor_eternity_medal",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"_condor_eternity","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 60, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 10, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 10, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 10, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 10, 0, 0, 0, 0.1);
				}
			}.ChangeSlot(3).AddToList(RiderTabs.OOO_TAB_ITEM));


	public static final DeferredItem<Item> ANCIENT_TAKA_MEDAL = ITEMS.register("ancient_taka_medal",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"_taka","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 6,true,false),
					new MobEffectInstance(Effect_core.FLYING, 40, 6,true,false)) {
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 0.1);
				}
			}
			.ChangeSlot(1).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> ANCIENT_TORA_MEDAL = ITEMS.register("ancient_tora_medal",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"_tora","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 0.1);
				}
			}.ChangeSlot(2).AddCompatibilityList(new String[] {"ooo_ancient"}).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> ANCIENT_BATTA_MEDAL = ITEMS.register("ancient_batta_medal",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_batta","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}.ChangeSlot(3).AddToList(RiderTabs.OOO_TAB_ITEM));


	public static final DeferredItem<Item> MUKADE_GODA_MEDAL = ITEMS.register("mukade_goda_medal",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"_mukade","goda","ooodriver_belt",
					new MobEffectInstance(MobEffects.REGENERATION, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(Effect_core.ANTIPOISON, 40, 0,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 0.1);
				}
			}
			.ChangeSlot(1).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> HACHI_GODA_MEDAL = ITEMS.register("hachi_goda_medal",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"_hachi","goda","ooodriver_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 5,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 0.1);
				}
			}.ChangeSlot(2).ChangeModel("ooo_imagin.geo.json").AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> ARI_GODA_MEDAL = ITEMS.register("ari_goda_medal",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"_ari","goda","ooodriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 0.1);
				}
			}
			.ChangeSlot(3).AddToList(RiderTabs.OOO_TAB_ITEM));


	public static final DeferredItem<Item> LOVE_CORE_MEDAL = ITEMS.register("love_core_medal",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.EPIC),0,"_love_1","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.REGENERATION, 40, 1,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}.ChangeSlot(1).AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));

	public static final DeferredItem<Item> LOVE_CORE2_MEDAL = ITEMS.register("love_core2_medal",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.EPIC),0,"_love_2","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}.ChangeSlot(2).AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));

	public static final DeferredItem<Item> LOVE_CORE3_MEDAL = ITEMS.register("love_core3_medal",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.EPIC),0,"_love_3","ooo","ooodriver_belt",
					new MobEffectInstance(MobEffects.SATURATION, 40, 1,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}.ChangeSlot(3).AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));


	public static final DeferredItem<Item> FOUNDATION_X_TAKA_MEDAL = ITEMS.register("foundation_x_taka_medal",
			() -> new CopyFormChangeItem(new Item.Properties(),TAKA_MEDAL.get()).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> FOUNDATION_X_KUJAKU_MEDAL = ITEMS.register("foundation_x_kujaku_medal",
			() -> new CopyFormChangeItem(new Item.Properties(),KUJAKU_MEDAL.get()).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> FOUNDATION_X_CONDOR_MEDAL = ITEMS.register("foundation_x_condor_medal",
			() -> new CopyFormChangeItem(new Item.Properties(),CONDOR_MEDAL.get()).AddToList(RiderTabs.OOO_TAB_ITEM));


	public static final DeferredItem<Item> FOUNDATION_X_LION_MEDAL = ITEMS.register("foundation_x_lion_medal",
			() -> new CopyFormChangeItem(new Item.Properties(),LION_MEDAL.get()).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> FOUNDATION_X_TORA_MEDAL = ITEMS.register("foundation_x_tora_medal",
			() -> new CopyFormChangeItem(new Item.Properties(),TORA_MEDAL.get()).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> FOUNDATION_X_CHEETAH_MEDAL = ITEMS.register("foundation_x_cheetah_medal",
			() -> new CopyFormChangeItem(new Item.Properties(),CHEETAH_MEDAL.get()).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> FOUNDATION_X_KUWAGATA_MEDAL = ITEMS.register("foundation_x_kuwagata_medal",
			() -> new CopyFormChangeItem(new Item.Properties(),KUWAGATA_MEDAL.get()).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> FOUNDATION_X_KAMAKIRI_MEDAL = ITEMS.register("foundation_x_kamakiri_medal",
			() -> new CopyFormChangeItem(new Item.Properties(),KAMAKIRI_MEDAL.get()).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> FOUNDATION_X_BATTA_MEDAL = ITEMS.register("foundation_x_batta_medal",
			() -> new CopyFormChangeItem(new Item.Properties(),BATTA_MEDAL.get()).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> FOUNDATION_X_SAI_MEDAL = ITEMS.register("foundation_x_sai_medal",
			() -> new CopyFormChangeItem(new Item.Properties(),SAI_MEDAL.get()).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> FOUNDATION_X_GORILLA_MEDAL = ITEMS.register("foundation_x_gorilla_medal",
			() -> new CopyFormChangeItem(new Item.Properties(),GORILLA_MEDAL.get()).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> FOUNDATION_X_ZOU_MEDAL = ITEMS.register("foundation_x_zou_medal",
			() -> new CopyFormChangeItem(new Item.Properties(),ZOU_MEDAL.get()).AddToList(RiderTabs.OOO_TAB_ITEM));


	public static final DeferredItem<Item> FOUNDATION_X_SHACHI_MEDAL = ITEMS.register("foundation_x_shachi_medal",
			() -> new CopyFormChangeItem(new Item.Properties(),SHACHI_MEDAL.get()).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> FOUNDATION_X_UNAGI_MEDAL = ITEMS.register("foundation_x_unagi_medal",
			() -> new CopyFormChangeItem(new Item.Properties(),UNAGI_MEDAL.get()).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> FOUNDATION_X_TAKO_MEDAL = ITEMS.register("foundation_x_tako_medal",
			() -> new CopyFormChangeItem(new Item.Properties(),TAKO_MEDAL.get()).AddToList(RiderTabs.OOO_TAB_ITEM));



	public static final DeferredItem<Item> ZEUS_TAKA_MEDAL = ITEMS.register("zeus_taka_medal",
			() -> new CopyFormChangeItem(new Item.Properties(),TAKA_MEDAL.get()).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> ZEUS_KUJAKU_MEDAL = ITEMS.register("zeus_kujaku_medal",
			() -> new CopyFormChangeItem(new Item.Properties(),KUJAKU_MEDAL.get()).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> ZEUS_CONDOR_MEDAL = ITEMS.register("zeus_condor_medal",
			() -> new CopyFormChangeItem(new Item.Properties(),CONDOR_MEDAL.get()).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> ZEUS_LION_MEDAL = ITEMS.register("zeus_lion_medal",
			() -> new CopyFormChangeItem(new Item.Properties(),LION_MEDAL.get()).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> ZEUS_TORA_MEDAL = ITEMS.register("zeus_tora_medal",
			() -> new CopyFormChangeItem(new Item.Properties(),TORA_MEDAL.get()).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> ZEUS_CHEETAH_MEDAL = ITEMS.register("zeus_cheetah_medal",
			() -> new CopyFormChangeItem(new Item.Properties(),CHEETAH_MEDAL.get()).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> ZEUS_KUWAGATA_MEDAL = ITEMS.register("zeus_kuwagata_medal",
			() -> new CopyFormChangeItem(new Item.Properties(),KUWAGATA_MEDAL.get()).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> ZEUS_KAMAKIRI_MEDAL = ITEMS.register("zeus_kamakiri_medal",
			() -> new CopyFormChangeItem(new Item.Properties(),KAMAKIRI_MEDAL.get()).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> ZEUS_BATTA_MEDAL = ITEMS.register("zeus_batta_medal",
			() -> new CopyFormChangeItem(new Item.Properties(),BATTA_MEDAL.get()).AddToList(RiderTabs.OOO_TAB_ITEM));


	public static final DeferredItem<Item> ZEUS_SAI_MEDAL = ITEMS.register("zeus_sai_medal",
			() -> new CopyFormChangeItem(new Item.Properties(),SAI_MEDAL.get()).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> ZEUS_GORILLA_MEDAL = ITEMS.register("zeus_gorilla_medal",
			() -> new CopyFormChangeItem(new Item.Properties(),GORILLA_MEDAL.get()).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> ZEUS_ZOU_MEDAL = ITEMS.register("zeus_zou_medal",
			() -> new CopyFormChangeItem(new Item.Properties(),ZOU_MEDAL.get()).AddToList(RiderTabs.OOO_TAB_ITEM));


	public static final DeferredItem<Item> ZEUS_SHACHI_MEDAL = ITEMS.register("zeus_shachi_medal",
			() -> new CopyFormChangeItem(new Item.Properties(),SHACHI_MEDAL.get()).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> ZEUS_UNAGI_MEDAL = ITEMS.register("zeus_unagi_medal",
			() -> new CopyFormChangeItem(new Item.Properties(),UNAGI_MEDAL.get()).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> ZEUS_TAKO_MEDAL = ITEMS.register("zeus_tako_medal",
			() -> new CopyFormChangeItem(new Item.Properties(),TAKO_MEDAL.get()).AddToList(RiderTabs.OOO_TAB_ITEM));


	public static final DeferredItem<Item> ZEUS_PTERA_MEDAL = ITEMS.register("zeus_ptera_medal",
			() -> new CopyFormChangeItem(new Item.Properties().rarity(Rarity.RARE),PTERA_MEDAL.get()).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> ZEUS_TRICERA_MEDAL = ITEMS.register("zeus_tricera_medal",
			() -> new CopyFormChangeItem(new Item.Properties().rarity(Rarity.RARE),TRICERA_MEDAL.get()).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> ZEUS_TYRANNO_MEDAL = ITEMS.register("zeus_tyranno_medal",
			() -> new CopyFormChangeItem(new Item.Properties().rarity(Rarity.RARE),TYRANNO_MEDAL.get()).AddToList(RiderTabs.OOO_TAB_ITEM));


	public static final DeferredItem<Item> ZEUS_MUKADE_MEDAL = ITEMS.register("zeus_mukade_medal",
			() -> new CopyFormChangeItem(new Item.Properties(),MUKADE_MEDAL.get()).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> ZEUS_HACHI_MEDAL = ITEMS.register("zeus_hachi_medal",
			() -> new CopyFormChangeItem(new Item.Properties(),HACHI_MEDAL.get()).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> ZEUS_ARI_MEDAL = ITEMS.register("zeus_ari_medal",
			() -> new CopyFormChangeItem(new Item.Properties(),ARI_MEDAL.get()).AddToList(RiderTabs.OOO_TAB_ITEM));


    public static final DeferredItem<Item> X_MEDAL = ITEMS.register("x_medal",
					() -> new ShowaMedalItem(new Item.Properties(), (RiderDriverItem)Ichigo_Rider_Items.RIDOL.get(), Ichigo_Rider_Items.RIDOL_STICK.get()).AddToList(RiderTabs.OOO_TAB_ITEM));

			public static final DeferredItem<Item> AMAZON_MEDAL = ITEMS.register("amazon_medal",
					() -> new ShowaMedalItem(new Item.Properties(), (RiderDriverItem)Ichigo_Rider_Items.CONDORER.get(), null).AddToList(RiderTabs.OOO_TAB_ITEM));

			public static final DeferredItem<Item> STRONGER_MEDAL = ITEMS.register("stronger_medal",
					() -> new ShowaMedalItem(new Item.Properties(), (RiderDriverItem)Ichigo_Rider_Items.ELECTRER.get(), null).AddToList(RiderTabs.OOO_TAB_ITEM));


			public static final DeferredItem<Item> HABATAKI_MEDAL = ITEMS.register("habataki_medal",
					() -> new RiderFormChangeItem(new Item.Properties(),0,"_habataki","ooo","ooodriver_belt",
							new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)){
						public void OnTransformation(ItemStack itemstack, LivingEntity player) {
							super.OnTransformation(itemstack, player);
							((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
									player.getX(), player.getY()+1,
									player.getZ(), 30, 0, 0, 0, 0.1);
						}
					}.ChangeSlot(1).AddToList(RiderTabs.OOO_TAB_ITEM));

			public static final DeferredItem<Item> TAIGA_MEDAL = ITEMS.register("taiga_medal",
					() -> new RiderFormChangeItem(new Item.Properties(),0,"_tiger","ooo","ooodriver_belt",
							new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false)){
						public void OnTransformation(ItemStack itemstack, LivingEntity player) {
							super.OnTransformation(itemstack, player);
							((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
									player.getX(), player.getY()+1,
									player.getZ(), 30, 0, 0, 0, 0.1);
						}
					}.ChangeSlot(2).AddToList(RiderTabs.OOO_TAB_ITEM));

			public static final DeferredItem<Item> ICHIGO_MEDAL = ITEMS.register("ichigo_medal",
					() -> new RiderFormChangeItem(new Item.Properties(),0,"_ichigo","ooo","ooodriver_belt",
							new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
						public void OnTransformation(ItemStack itemstack, LivingEntity player) {
							super.OnTransformation(itemstack, player);
							((ServerLevel) player.level()).sendParticles(ModParticles.DARK_GREEN_SPARK_PARTICLES.get(),
									player.getX(), player.getY()+1,
									player.getZ(), 30, 0, 0, 0, 0.1);
						}
					}.ChangeSlot(3).AddToList(RiderTabs.OOO_TAB_ITEM));


			public static final DeferredItem<Item> IMAGIN_MEDAL = ITEMS.register("imagin_medal",
					() -> new RiderFormChangeItem(new Item.Properties(),0,"_imagin","ooo","ooodriver_belt",
							new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
							new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)){
						public void OnTransformation(ItemStack itemstack, LivingEntity player) {
							super.OnTransformation(itemstack, player);
							((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
									player.getX(), player.getY()+1,
									player.getZ(), 30, 0, 0, 0, 0.1);
						}
					}.ChangeSlot(2).AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));

			public static final DeferredItem<Item> SHOCKER_MEDAL = ITEMS.register("shocker_medal",
					() -> new RiderFormChangeItem(new Item.Properties(),0,"_shocker","ooo","ooodriver_belt",
							new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)) {
						public void OnTransformation(ItemStack itemstack, LivingEntity player) {
							super.OnTransformation(itemstack, player);
							((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
									player.getX(), player.getY()+1,
									player.getZ(), 30, 0, 0, 0, 0.1);
						}
					}.ChangeSlot(3).AddToList(RiderTabs.OOO_TAB_ITEM).AddToList(SPECIAL_NAME_MEDALS));

			public static final DeferredItem<Item> GEL_SHOCKER_MEDAL = ITEMS.register("gel_shocker_medal",
					() -> new RiderFormChangeItem(new Item.Properties(),0,"_gel_shocker","shocker_ooo","ooodriver_belt",
							new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)){
						public void OnTransformation(ItemStack itemstack, LivingEntity player) {
							super.OnTransformation(itemstack, player);
							((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
									player.getX(), player.getY()+1,
									player.getZ(), 60, 0, 0, 0, 0.1);
						}
					}
					.ChangeSlot(2).AddToList(RiderTabs.OOO_TAB_ITEM));

			public static final DeferredItem<Item> DESTRON_MEDAL = ITEMS.register("destron_medal",
					() -> new RiderFormChangeItem(new Item.Properties(),0,"_destron","shocker_ooo","ooodriver_belt",
							new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false))
					.ChangeSlot(3).AddToList(RiderTabs.OOO_TAB_ITEM));

			public static final DeferredItem<Item> GOD_MEDAL = ITEMS.register("god_medal",
					() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.OOO_TAB_ITEM));

			public static final DeferredItem<Item> GARANDA_MEDAL = ITEMS.register("garanda_medal",
					() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.OOO_TAB_ITEM));

			public static final DeferredItem<Item> DELZA_MEDAL = ITEMS.register("delza_medal",
					() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.OOO_TAB_ITEM));

			public static final DeferredItem<Item> NEO_SHOCKER_MEDAL = ITEMS.register("neo_shocker_medal",
					() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.OOO_TAB_ITEM));

			public static final DeferredItem<Item> JIN_DOGMA_MEDAL = ITEMS.register("jin_dogma_medal",
					() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.OOO_TAB_ITEM));

			public static final DeferredItem<Item> BADAN_MEDAL = ITEMS.register("badan_medal",
					() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> HEXA_OOOOOO = ITEMS.register("hexa_oooooo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","oooooo","oooooodriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)) {
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 300, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE,
							player.getX(), player.getY()+1,
							player.getZ(), 300, 0, 0, 0, 0.1);
					LightningBolt thunder = new LightningBolt(EntityType.LIGHTNING_BOLT,player.level());
					thunder.setVisualOnly(true);
					thunder.setPos( player.getX(),  -1 + player.getY(),  player.getZ() );
					player.level().addFreshEntity(thunder);

				}
			}.IsGlowing().ChangeBeltModel("geo/ooo_belt.geo.json").has_basic_model().model_has_different_name("shocker_medal"));

	public static final DeferredItem<Item> BIRTH_CORE = ITEMS.register("birth_core",
					() -> new RiderFormChangeItem(new Item.Properties(),0,"","birth","birth_driver_belt",
							new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
							new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)){
						public void OnTransformation(ItemStack itemstack, LivingEntity player) {
							super.OnTransformation(itemstack, player);
							((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
									player.getX(), player.getY()+1,
									player.getZ(), 100, 0, 0, 0, 0.1);
						}
					}.AddToList(RiderTabs.OOO_TAB_ITEM));

			public static final DeferredItem<Item> PROTO_BIRTH_CORE = ITEMS.register("proto_birth_core",
					() -> new RiderFormChangeItem(new Item.Properties(),0,"","birth_prototype","birth_driver_belt",
							new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
							new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)){
						public void OnTransformation(ItemStack itemstack, LivingEntity player) {
							super.OnTransformation(itemstack, player);
							((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
									player.getX(), player.getY()+1,
									player.getZ(), 30, 0, 0, 0, 0.1);
						}
					}.AddToList(RiderTabs.OOO_TAB_ITEM));

			public static final DeferredItem<Item> BIRTH_CORE_EYES = ITEMS.register("birth_core_eyes",
					() -> new RiderFormChangeItem(new Item.Properties(),0,"_eyes","birth","birth_driver_belt",
							new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
							new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
							new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)){
						public void OnTransformation(ItemStack itemstack, LivingEntity player) {
							super.OnTransformation(itemstack, player);
							((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
									player.getX(), player.getY()+1,
									player.getZ(), 100, 0, 0, 0, 0.1);
						}
					}
					.addSwitchForm(OOO_Rider_Items.BIRTH_CORE.get())
					.IsGlowing().AddToList(CellMedalProgramer.CELL_MEDAL).AddToList(RiderTabs.OOO_TAB_ITEM));

			public static final DeferredItem<Item> BIRTH_CORE_BREAST_CANNON = ITEMS.register("birth_core_breast_cannon",
					() -> new RiderFormChangeItem(new Item.Properties(),0,"","birth","",
							new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 1,true,false))
					.ChangeSlot(2).addSwitchForm(Modded_item_core.BLANK_FORM.get())
					.AddCompatibilityList(new String[] {"birth_prototype"}).AddToList(CellMedalProgramer.CELL_MEDAL).AddToList(RiderTabs.OOO_TAB_ITEM));

			public static final DeferredItem<Item> BIRTH_CORE_CRANE_ARM = ITEMS.register("birth_core_crane_arm",
					() -> new RiderFormChangeItem(new Item.Properties(),0,"","birth","",
							new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false))
					.ChangeSlot(3).addSwitchForm(Modded_item_core.BLANK_FORM.get())
					.AddCompatibilityList(new String[] {"birth_prototype"}).AddToList(CellMedalProgramer.CELL_MEDAL).AddToList(RiderTabs.OOO_TAB_ITEM));

			public static final DeferredItem<Item> BIRTH_CORE_SHOVEL_ARM = ITEMS.register("birth_core_shovel_arm",
					() -> new RiderFormChangeItem(new Item.Properties(),0,"","birth","",
							new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false))
					.ChangeSlot(4).addSwitchForm(Modded_item_core.BLANK_FORM.get())
					.AddToList(CellMedalProgramer.CELL_MEDAL).AddToList(RiderTabs.OOO_TAB_ITEM));

			public static final DeferredItem<Item> BIRTH_CORE_CATERPILLAR_LEG = ITEMS.register("birth_core_catepillar_leg",
					() -> new RiderFormChangeItem(new Item.Properties(),0,"","birth","",
							new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false))
					.ChangeSlot(5).addSwitchForm(Modded_item_core.BLANK_FORM.get())
					.AddToList(CellMedalProgramer.CELL_MEDAL).AddToList(RiderTabs.OOO_TAB_ITEM));

			public static final DeferredItem<Item> BIRTH_CORE_DRILL_ARM = ITEMS.register("birth_core_drill_arm",
					() -> new RiderFormChangeItem(new Item.Properties(),0,"","birth","",
							new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
							new MobEffectInstance(Effect_core.DRILL, 40, 0,true,false))
					.ChangeSlot(6).addSwitchForm(Modded_item_core.BLANK_FORM.get())
					.AddToList(CellMedalProgramer.CELL_MEDAL).AddToList(RiderTabs.OOO_TAB_ITEM));


			public static final DeferredItem<Item> BIRTH_CORE_CUTTER_WING = ITEMS.register("birth_core_cutter_wing",
					() -> new RiderFormChangeItem(new Item.Properties(),0,"","birth","",
							new MobEffectInstance(Effect_core.FLYING, 40, 0,true,false))
					.ChangeSlot(7).addSwitchForm(Modded_item_core.BLANK_FORM.get())
					.AddCompatibilityList(new String[] {"birth_prototype"}).AddToList(CellMedalProgramer.CELL_MEDAL).AddToList(RiderTabs.OOO_TAB_ITEM));

			public static final DeferredItem<Item> GREEED_ABSORPTION_CORE = ITEMS.register("greeed_absorption_core",
					() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_tora_greeed_absorption","ooo_ancient","ooodriver_belt",
							new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false))
					.ChangeSlot(2).ChangeModel("ooo_imagin.geo.json").AddToList(RiderTabs.OOO_TAB_ITEM));


			public static final DeferredItem<Item> AQUA_CORE = ITEMS.register("aqua_core",
					() -> new RiderFormChangeItem(new Item.Properties(),0,"","aqua","aqua_driver_belt",
							new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
							,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 2,true,false))
                            .IsGlowing().AddToList(RiderTabs.OOO_TAB_ITEM));


			public static final DeferredItem<Item> PURPLE_MEDALS_SEALED = ITEMS.register("purple_medals_sealed",
					() -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).AddToList(RiderTabs.OOO_TAB_ITEM));
			public static final DeferredItem<Item> PURPLE_MEDALS_OPENED = ITEMS.register("purple_medals_opened",
					() -> new Item_Purple_Medals(new Item.Properties().rarity(Rarity.RARE)).AddToList(RiderTabs.OOO_TAB_ITEM));
			public static final DeferredItem<Item> PURPLE_MEDALS_EMPTY = ITEMS.register("purple_medals_empty",
					() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.OOO_TAB_ITEM));

			public static final DeferredItem<Item> OOOHELMET = ITEMS.register("ooohead",
					() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.OOO_TAB_ITEM).ChangeRepairItem(CELL_MEDAL.get()));
			public static final DeferredItem<Item> OOOCHESTPLATE = ITEMS.register("oootroso",
					() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.OOO_TAB_ITEM).ChangeRepairItem(CELL_MEDAL.get()));
			public static final DeferredItem<Item> OOOLEGGINGS = ITEMS.register("ooolegs",
					() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.OOO_TAB_ITEM).ChangeRepairItem(CELL_MEDAL.get()));


			public static final DeferredItem<Item> OOODRIVER = ITEMS.register("ooodriver",
					() -> new OOODriverItem(ArmorMaterials.DIAMOND,"ooo",TAKA_MEDAL ,OOOHELMET,OOOCHESTPLATE,OOOLEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(TORA_MEDAL,BATTA_MEDAL).ChangeRepairItem(CELL_MEDAL.get()).AddToTabList(RiderTabs.OOO_TAB_ITEM).AddToTabList(Decade_Rider_Items.NEO_DIEND_SUMMON_BELTS));


			public static final DeferredItem<Item> BIRTH_DRIVER = ITEMS.register("birth_driver",
					() -> new BirthDriverItem(ArmorMaterials.DIAMOND,"birth",BIRTH_CORE ,OOOHELMET,OOOCHESTPLATE,OOOLEGGINGS , new Item.Properties())
					.ChangeRepairItem(CELL_MEDAL.get()).AddToTabList(RiderTabs.OOO_TAB_ITEM).AddToTabList(Decade_Rider_Items.NEO_DIEND_SUMMON_BELTS));

			public static final DeferredItem<Item> PROTO_BIRTH_DRIVER = ITEMS.register("proto_birth_driver",
					() -> new BirthDriverItem(ArmorMaterials.DIAMOND,"birth_prototype",BIRTH_CORE ,OOOHELMET,OOOCHESTPLATE,OOOLEGGINGS , new Item.Properties())
					.ChangeRepairItem(CELL_MEDAL.get()).AddToTabList(RiderTabs.OOO_TAB_ITEM));

			public static final DeferredItem<Item> BIRTH_DRIVER_X = ITEMS.register("birth_driver_x",
					() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"birth_x",EBI_NEW_MEDAL ,OOOHELMET,OOOCHESTPLATE,OOOLEGGINGS , new Item.Properties().rarity(Rarity.UNCOMMON))
					{
						@Override
						public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
							Has_basic_belt_info=false;
							tooltipComponents.add(Component.translatable("kamenridercraft.name."+Rider));
							tooltipComponents.add(Component.translatable( "kamenridercraft:sokabi.form"));

							super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
						}

					}.Add_Extra_Base_Form_Items(KANI_NEW_MEDAL, SASORI_NEW_MEDAL).Override_belt_text("birth_driver_x_belt").ChangeRepairItem(CELL_MEDAL.get()).AddToTabList(RiderTabs.OOO_TAB_ITEM));

			public static final DeferredItem<Item> REBIRTH_DRIVER_X = ITEMS.register("rebirth_driver",
					() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"re_birth",Modded_item_core.BLANK_FORM ,OOOHELMET,OOOCHESTPLATE,OOOLEGGINGS , new Item.Properties().rarity(Rarity.UNCOMMON))
							.Dont_show_belt_form_info().Override_belt_text("rebirth_driver_belt").ChangeRepairItem(CELL_MEDAL.get()).AddToTabList(RiderTabs.OOO_TAB_ITEM));

			public static final DeferredItem<Item> AQUA_DRIVER = ITEMS.register("aqua_driver",
					() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"aqua",AQUA_CORE ,OOOHELMET,OOOCHESTPLATE,OOOLEGGINGS , new Item.Properties())
							.Dont_show_belt_form_info().ChangeRepairItem(CELL_MEDAL.get()).AddToTabList(RiderTabs.OOO_TAB_ITEM));

			public static final DeferredItem<Item> POSEIDONDRIVER = ITEMS.register("poseidon_driver",
					() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"poseidon",SAME_MEDAL ,OOOHELMET,OOOCHESTPLATE,OOOLEGGINGS , new Item.Properties())
							.Dont_show_belt_form_info().Add_Extra_Base_Form_Items(KUJIRA_MEDAL,OOKAMIUO_MEDAL).Override_belt_text("poseidon_driver_belt")
							.ChangeRepairItem(CELL_MEDAL.get()).AddToTabList(RiderTabs.OOO_TAB_ITEM));

			public static final DeferredItem<Item> ANCIENT_OOODRIVER = ITEMS.register("ancient_ooodriver",
					() -> new OOODriverItem(ArmorMaterials.DIAMOND,"ooo_ancient",ANCIENT_TAKA_MEDAL ,OOOHELMET,OOOCHESTPLATE,OOOLEGGINGS , new Item.Properties().rarity(Rarity.UNCOMMON))
					.Add_Extra_Base_Form_Items(ANCIENT_TORA_MEDAL,ANCIENT_BATTA_MEDAL).ChangeRepairItem(CELL_MEDAL.get()).AddToTabList(RiderTabs.OOO_TAB_ITEM));

			public static final DeferredItem<Item> GODA_OOODRIVER = ITEMS.register("goda_ooodriver",
					() -> new OOODriverItem(ArmorMaterials.DIAMOND,"goda",MUKADE_GODA_MEDAL ,OOOHELMET,OOOCHESTPLATE,OOOLEGGINGS , new Item.Properties().rarity(Rarity.UNCOMMON))
					.Add_Extra_Base_Form_Items(HACHI_GODA_MEDAL,ARI_GODA_MEDAL).ChangeRepairItem(CELL_MEDAL.get()).AddToTabList(RiderTabs.OOO_TAB_ITEM));

			public static final DeferredItem<Item> SHOCKER_OOODRIVER = ITEMS.register("shocker_ooodriver",
					() -> new OOODriverItem(ArmorMaterials.DIAMOND,"shocker_ooo",SHOCKER_MEDAL ,OOOHELMET,OOOCHESTPLATE,OOOLEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(GEL_SHOCKER_MEDAL,DESTRON_MEDAL).ChangeRepairItem(CELL_MEDAL.get()).AddToTabList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> OOOOOODRIVER = ITEMS.register("oooooodriver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"oooooo",HEXA_OOOOOO ,OOOHELMET,OOOCHESTPLATE,OOOLEGGINGS , new Item.Properties())
					.Dont_show_belt_form_info().ChangeRepairItem(CELL_MEDAL.get()).has_basic_model().AddToTabList(RiderTabs.OOO_TAB_ITEM));


	public static final DeferredItem<Item> CORE_DRIVER = ITEMS.register("core_driver",
					() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"core",EBI_MEDAL ,OOOHELMET,OOOCHESTPLATE,OOOLEGGINGS , new Item.Properties())
					.Dont_show_belt_form_info().Add_Extra_Base_Form_Items(KANI_MEDAL,SASORI_MEDAL,Modded_item_core.BLANK_FORM).Override_belt_text("gaia_core_typhoon_belt").ChangeRepairItem(CELL_MEDAL.get()).AddToTabList(RiderTabs.OOO_TAB_ITEM));

			public static final DeferredItem<Item> POWERED_UP_CORE_DRIVER = ITEMS.register("powered_up_core_driver",
					() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"powered_up_core",EBI_MEDAL ,OOOHELMET,OOOCHESTPLATE,OOOLEGGINGS , new Item.Properties().rarity(Rarity.UNCOMMON))
					.Dont_show_belt_form_info().Add_Extra_Base_Form_Items(KANI_MEDAL,SASORI_MEDAL,Modded_item_core.BLANK_FORM).Override_belt_text("powered_up_gaia_core_typhoon_belt").ChangeRepairItem(CELL_MEDAL.get()).AddToTabList(RiderTabs.OOO_TAB_ITEM));


			public static final DeferredItem<Item> GREEED_BLET_ANKH_LOST = ITEMS.register("greeed_blet_ankh_lost",
					() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"ankh_lost",TAKA_MEDAL ,OOOHELMET,OOOCHESTPLATE,OOOLEGGINGS , new Item.Properties().rarity(Rarity.RARE))
					.Dont_show_belt_form_info().Add_Extra_Base_Form_Items(KUJAKU_MEDAL,CONDOR_MEDAL).Override_belt_text("ankh_lost_belt").ChangeRepairItem(CELL_MEDAL.get()).AddToTabList(RiderTabs.OOO_TAB_ITEM));

			public static final DeferredItem<Item> GREEED_BLET_ANKH = ITEMS.register("greeed_blet_ankh",
					() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"ankh_complete",TAKA_ANKH_MEDAL ,OOOHELMET,OOOCHESTPLATE,OOOLEGGINGS , new Item.Properties())
					.Dont_show_belt_form_info().Add_Extra_Base_Form_Items(KUJAKU_MEDAL,CONDOR_MEDAL).Override_belt_text("ankh_belt").ChangeRepairItem(CELL_MEDAL.get()).AddToTabList(RiderTabs.OOO_TAB_ITEM));

			public static final DeferredItem<Item> GREEED_BLET_UVA = ITEMS.register("greeed_blet_uva",
					() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"uva_complete",KUWAGATA_MEDAL ,OOOHELMET,OOOCHESTPLATE,OOOLEGGINGS , new Item.Properties())
					.Dont_show_belt_form_info().Add_Extra_Base_Form_Items(KAMAKIRI_MEDAL,BATTA_MEDAL).Override_belt_text("ankh_belt").ChangeRepairItem(CELL_MEDAL.get()).AddToTabList(RiderTabs.OOO_TAB_ITEM));

			public static final DeferredItem<Item> GREEED_BLET_KAZARI = ITEMS.register("greeed_blet_kazari",
					() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"kazari_complete",LION_MEDAL ,OOOHELMET,OOOCHESTPLATE,OOOLEGGINGS , new Item.Properties())
					.Dont_show_belt_form_info().Add_Extra_Base_Form_Items(TORA_MEDAL,CHEETAH_MEDAL).Override_belt_text("ankh_belt").ChangeRepairItem(CELL_MEDAL.get()).AddToTabList(RiderTabs.OOO_TAB_ITEM));

			public static final DeferredItem<Item> GREEED_BLET_MEZOOL = ITEMS.register("greeed_blet_mezool",
					() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"mezool_complete",SHACHI_MEDAL ,OOOHELMET,OOOCHESTPLATE,OOOLEGGINGS , new Item.Properties())
					.Dont_show_belt_form_info().Add_Extra_Base_Form_Items(UNAGI_MEDAL,TAKO_MEDAL).Override_belt_text("ankh_belt").ChangeRepairItem(CELL_MEDAL.get()).AddToTabList(RiderTabs.OOO_TAB_ITEM));

			public static final DeferredItem<Item> GREEED_BLET_GAMEL = ITEMS.register("greeed_blet_gamel",
					() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"gamel_complete",SAI_MEDAL ,OOOHELMET,OOOCHESTPLATE,OOOLEGGINGS , new Item.Properties())
					.Dont_show_belt_form_info().Add_Extra_Base_Form_Items(GORILLA_MEDAL,ZOU_MEDAL).Override_belt_text("ankh_belt").ChangeRepairItem(CELL_MEDAL.get()).AddToTabList(RiderTabs.OOO_TAB_ITEM));

			public static final DeferredItem<Item> GREEED_BLET_MUCHIRI = ITEMS.register("greeed_blet_muchiri",
					() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"muchiri_complete",MUKADE_MEDAL ,OOOHELMET,OOOCHESTPLATE,OOOLEGGINGS , new Item.Properties())
					.Dont_show_belt_form_info().Add_Extra_Base_Form_Items(HACHI_MEDAL,ARI_MEDAL).Override_belt_text("ankh_belt").ChangeRepairItem(CELL_MEDAL.get()).AddToTabList(RiderTabs.OOO_TAB_ITEM));

    public static final DeferredItem<Item> GREEED_BLET_KYORYU = ITEMS.register("greeed_blet_kyoryu",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"kyoryu_complete",PTERA_MEDAL ,OOOHELMET,OOOCHESTPLATE,OOOLEGGINGS , new Item.Properties())
                    .Dont_show_belt_form_info().Add_Extra_Base_Form_Items(TRICERA_MEDAL,TYRANNO_MEDAL).Override_belt_text("kyoryu_belt").ChangeRepairItem(CELL_MEDAL.get()).has_basic_model().AddToTabList(RiderTabs.OOO_TAB_ITEM));

			public static final DeferredItem<Item> MEDAJALIBUR = ITEMS.register("medajalibur",
					() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.OOO_TAB_ITEM).AddToTabList(Decade_Rider_Items.NEO_DIEND_SUMMON_WEAPONS).ChangeRepairItem(CELL_MEDAL.get()));

			public static final DeferredItem<Item> TAJASPINNER = ITEMS.register("tajaspinner",
					() -> new BaseBlasterItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).IsSwordGun().setProjectile(BaseBlasterItem.BlasterProjectile.SMALL_FIREBALL).AddToTabList(RiderTabs.OOO_TAB_ITEM).ChangeRepairItem(CELL_MEDAL.get()));

			public static final DeferredItem<Item> MEDAGABURYU = ITEMS.register("medagaburyu",
					() -> new BaseBlasterItem(Tiers.DIAMOND, 12, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).IsSwordGun().setProjectile(BaseBlasterItem.BlasterProjectile.WITHER_SKULL).AddToTabList(RiderTabs.OOO_TAB_ITEM).AddToTabList(Decade_Rider_Items.COMPLETE_21_WEAPONS).ChangeRepairItem(CELL_MEDAL.get()));

			public static final DeferredItem<Item> TAJASPINNER_ETERNITY = ITEMS.register("tajaspinner_eternity",
					() -> new BaseBlasterItem(Tiers.DIAMOND, 9, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).IsSwordGun().setProjectile(BaseBlasterItem.BlasterProjectile.LARGE_FIREBALL).setExplosionPower(1).AddToTabList(RiderTabs.OOO_TAB_ITEM).ChangeRepairItem(CELL_MEDAL.get()));


			public static final DeferredItem<Item> DEEPEST_HARPOON = ITEMS.register("deepest_harpoon",
					() -> new BaseSwordItem(Tiers.DIAMOND, 9, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.OOO_TAB_ITEM).ChangeRepairItem(CELL_MEDAL.get()));

			public static final DeferredItem<Item> ANICENT_OOO_GREEED_SWORD = ITEMS.register("ancient_ooo_greeed_sword",
					() -> new BaseSwordItem(Tiers.DIAMOND, 11, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).AddToTabList(RiderTabs.OOO_TAB_ITEM).ChangeRepairItem(CELL_MEDAL.get()));

			public static final DeferredItem<Item> BIRTH_BUSTER = ITEMS.register("birth_buster",
					() -> new BaseBlasterItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.OOO_TAB_ITEM).AddToTabList(Decade_Rider_Items.NEO_DIEND_SUMMON_WEAPONS).ChangeRepairItem(CELL_MEDAL.get()));


	public static final DeferredItem<Item> O_SCANNER = ITEMS.register("o_scanner",
			() -> new oScannerItem(new Item.Properties().rarity(Rarity.UNCOMMON)).AddToList(RiderTabs.OOO_TAB_ITEM));


	public static final DeferredItem<Item> O_MEDAL_HOLDER = ITEMS.register("o_medal_holder",
			() -> new OMedalHolderItem().AddToList(RiderTabs.OOO_TAB_ITEM));

	/*
    public static final DeferredItem<Item> O_MEDAL_NEST = ITEMS.register("o_medal_nest",
            () -> new GimmickCarrierItem(new Item.Properties()).AddToList(RiderTabs.OOO_TAB_ITEM));
     */

	public static final DeferredItem<Item> TAKA_CANDROID = ITEMS.register("taka_candroid",
			() -> new CandroidItem(new Item.Properties(),Component.translatable("candroid.kamenridercraft.taka"), MobsCore.TAKA_CAN)
					.AddToList(RidevendorVendingModeEntity.CANDROID,5).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> TAKO_CANDROID = ITEMS.register("tako_candroid",
			() -> new CandroidItem(new Item.Properties(),Component.translatable("candroid.kamenridercraft.tako"), MobsCore.TAKO_CAN)
					.AddToList(RidevendorVendingModeEntity.CANDROID,4).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> BATTA_CANDROID = ITEMS.register("batta_candroid",
			() -> new CandroidItem(new Item.Properties(),Component.translatable("candroid.kamenridercraft.batta"), MobsCore.BATTA_CAN)
					.AddToList(RidevendorVendingModeEntity.CANDROID,4).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> TORA_CANDROID = ITEMS.register("tora_candroid",
			() -> new CandroidItem(new Item.Properties(),Component.translatable("candroid.kamenridercraft.tora"), MobsCore.TORA_CAN)
					.AddToList(RidevendorVendingModeEntity.CANDROID,3).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> DENKIUNAGI_CANDROID = ITEMS.register("denkiunagi_candroid",
			() -> new CandroidItem(new Item.Properties(),Component.translatable("candroid.kamenridercraft.denkiunagi"), MobsCore.DENKIUNAGI_CAN)
					.AddToList(RidevendorVendingModeEntity.CANDROID,3).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> GORILLA_CANDROID = ITEMS.register("gorilla_candroid",
			() -> new CandroidItem(new Item.Properties(),Component.translatable("candroid.kamenridercraft.gorilla"), MobsCore.GORILLA_CAN)
					.AddToList(RidevendorVendingModeEntity.CANDROID,3).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> KUJAKU_CANDROID = ITEMS.register("kujaku_candroid",
			() -> new CandroidItem(new Item.Properties(),Component.translatable("candroid.kamenridercraft.kujaku"), MobsCore.KUJAKU_CAN)
					.AddToList(RidevendorVendingModeEntity.CANDROID,3).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> PTERA_CANDROID = ITEMS.register("ptera_candroid",
			() -> new CandroidItem(new Item.Properties(),Component.translatable("candroid.kamenridercraft.ptera"), MobsCore.PTERA_CAN)
					.AddToList(RidevendorVendingModeEntity.CANDROID,2).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> TORIKERA_CANDROID = ITEMS.register("torikera_candroid",
			() -> new CandroidItem(new Item.Properties(),Component.translatable("candroid.kamenridercraft.torikera"), MobsCore.TORIKERA_CAN)
					.AddToList(RidevendorVendingModeEntity.CANDROID,2).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static final DeferredItem<Item> FURIFURI_CANDROID = ITEMS.register("furifuri_candroid",
			() -> new BaseItem(new Item.Properties()).AddToList(RidevendorVendingModeEntity.CANDROID,1).AddToList(RiderTabs.OOO_TAB_ITEM));

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}
