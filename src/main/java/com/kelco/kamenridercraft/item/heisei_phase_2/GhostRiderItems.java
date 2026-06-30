package com.kelco.kamenridercraft.item.heisei_phase_2;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.block.machineBlocks.Monolith;
import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.item.base_items.*;
import com.kelco.kamenridercraft.item.heisei_phase_1.DecadeRiderItems;
import com.kelco.kamenridercraft.item.heisei_phase_2.ghost.AkariCannonItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.ghost.BlankGhostEyeconItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.ghost.GhostDriverItem;
import com.kelco.kamenridercraft.particle.ModParticles;
import net.minecraft.core.particles.ParticleTypes;
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

public class GhostRiderItems {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);

	public static final DeferredItem<Item> GHOST_LOGO = ITEMS.register("ghost_logo",
			() -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/ghost")), new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> BLANK_GHOST_EYECON = ITEMS.register("blank_ghost_eyecon",
			() -> new BlankGhostEyeconItem(new Item.Properties().rarity(Rarity.UNCOMMON)).has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> ORE_DAMASHII = ITEMS.register("ore_damashii",
			() -> new RiderFormChangeItem(new Item.Properties(),"ore_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 1);
				}
			}.changeModel("damashii.geo.json").changeSlot(2));

	public static final DeferredItem<Item> ORE_GHOST_EYECON = ITEMS.register("ore_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"","ghost","ghostdriver_belt",
					new MobEffectInstance(EffectCore.GHOST, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.IsBeltGlowing().addAlternative(ORE_DAMASHII.get()).alsoChange2ndSlot(ORE_DAMASHII.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> BOOST_DAMASHII = ITEMS.register("boost_damashii",
			() -> new RiderFormChangeItem(new Item.Properties(),"boost_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 1);
				}
			}.addNum(3).changeModel("damashii.geo.json").changeSlot(2));

	public static final DeferredItem<Item> BOOST_GHOST_EYECON = ITEMS.register("boost_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"_boost","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(EffectCore.GHOST, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.addAlternative(BOOST_DAMASHII.get()).changeModel("ghost.geo.json").alsoChange2ndSlot(BOOST_DAMASHII.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> MUGEN_DAMASHII = ITEMS.register("mugen_damashii",
			() -> new RiderFormChangeItem(new Item.Properties(),"mugen_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 1);
				}
			}.addNum(3).changeModel("mugen_damashii.geo.json").changeSlot(2).hasCape().addToList(DecadeRiderItems.COMPLETE_21_FORMS));

	public static final DeferredItem<Item> MUGEN_GHOST_EYECON = ITEMS.register("mugen_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),"_mugen","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 5,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(EffectCore.GHOST, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RANDOM_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.alsoChange2ndSlot(MUGEN_DAMASHII.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> SPECTER_DAMASHII = ITEMS.register("specter_damashii",
			() -> new RiderFormChangeItem(new Item.Properties(),"specter_damashii","specter","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 1);
				}
			}.addNum(2).changeModel("damashii.geo.json").changeSlot(2));

	public static final DeferredItem<Item> SPECTER_GHOST_EYECON = ITEMS.register("specter_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"","specter","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.addAlternative(SPECTER_DAMASHII.get()).alsoChange2ndSlot(SPECTER_DAMASHII.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> DEEP_SPECTER_DAMASHII = ITEMS.register("deep_specter_damashii",
			() -> new RiderFormChangeItem(new Item.Properties(),"deep_damashii","specter","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 1);
				}
			}.addNum(0).changeModel("deep_damashii.geo.json").changeSlot(2));

	public static final DeferredItem<Item> DEEP_SPECTER_GHOST_EYECON = ITEMS.register("deep_specter_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"_deep","specter","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.alsoChange2ndSlot(DEEP_SPECTER_DAMASHII.get()).changeModel("deep_specter.geo.json").addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> SIN_SPECTER_DAMASHII = ITEMS.register("sin_specter_damashii",
			() -> new RiderFormChangeItem(new Item.Properties(),"sin_damashii","specter","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 1);
				}
			}
					.addNum(0).changeModel("mugen_damashii.geo.json").hasCape().changeSlot(2));

	public static final DeferredItem<Item> SIN_SPECTER_GHOST_EYECON = ITEMS.register("sin_specter_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),"_sin","specter","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 5,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.alsoChange2ndSlot(SIN_SPECTER_DAMASHII.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));


	public static final DeferredItem<Item> NECROM_DAMASHII = ITEMS.register("necrom_damashii",
			() -> new RiderFormChangeItem(new Item.Properties(),"necrom_damashii","necrom","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 1);
				}
			}.addNum(0).changeModel("necrom_damashii.geo.json").changeSlot(2));

	public static final DeferredItem<Item> NECROM_GHOST_EYECON = ITEMS.register("necrom_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"","necrom","necrom_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.changeBeltModel("geo/belt_with_brace.geo.json").changeModel("necrom.geo.json").addAlternative(NECROM_DAMASHII.get()).alsoChange2ndSlot(NECROM_DAMASHII.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> YUJOU_BURST_DAMASHII = ITEMS.register("yujou_burst_damashii",
			() -> new RiderFormChangeItem(new Item.Properties(),"yujou_burst_necrom_damashii","necrom","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 1);
				}
			}.changeModel("yujou_burst_necrom_damashii.geo.json").changeSlot(2));

	public static final DeferredItem<Item> YUJOU_BURST_GHOST_EYECON = ITEMS.register("yujou_burst_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"_yujou_burst","necrom","necrom_belt_yujou",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.alsoChange2ndSlot(YUJOU_BURST_DAMASHII.get()).changeModel("necrom.geo.json").changeBeltModel("geo/belt_with_brace.geo.json").addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> DARK_DAMASHII = ITEMS.register("dark_damashii",
			() -> new RiderFormChangeItem(new Item.Properties(),"dark_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 1);
				}
			}.changeModel("damashii.geo.json").changeSlot(2));

	public static final DeferredItem<Item> DARK_GHOST_EYECON = ITEMS.register("dark_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"","dark_ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.addAlternative(DARK_DAMASHII.get()).alsoChange2ndSlot(DARK_DAMASHII.get()).changeModel("ghost.geo.json").addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> ZERO_SPECTER_DAMASHII = ITEMS.register("zero_specter_damashii",
			() -> new RiderFormChangeItem(new Item.Properties(),"zero_specter_damashii","specter","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 1);
				}
			}.addNum(2).changeModel("damashii.geo.json").changeSlot(2));

	public static final DeferredItem<Item> ZERO_SPECTER_GHOST_EYECON = ITEMS.register("zero_specter_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"","zero_specter","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.addAlternative(ZERO_SPECTER_DAMASHII.get()).alsoChange2ndSlot(ZERO_SPECTER_DAMASHII.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> PROTO_ORE_DAMASHII = ITEMS.register("proto_ore_damashii",
			() -> new RiderFormChangeItem(new Item.Properties(),"proto_ore_damashii","zero_ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 1);
				}
			}.changeModel("damashii.geo.json").changeSlot(2));

	public static final DeferredItem<Item> PROTO_ORE_GHOST_EYECON = ITEMS.register("proto_ore_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"","zero_ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.addAlternative(PROTO_ORE_DAMASHII.get()).alsoChange2ndSlot(PROTO_ORE_DAMASHII.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));


	public static final DeferredItem<Item> KANON_SPECTER_DAMASHII = ITEMS.register("kanon_specter_damashii",
			() -> new RiderFormChangeItem(new Item.Properties(),"kanon_specter_damashii","specter","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 1);
				}
			}.addNum(2).changeModel("damashii.geo.json").changeSlot(2));

	public static final DeferredItem<Item> KANON_SPECTER_GHOST_EYECON = ITEMS.register("kanon_specter_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"","kanon_specter","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.addAlternative(KANON_SPECTER_DAMASHII.get()).alsoChange2ndSlot(KANON_SPECTER_DAMASHII.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));


    public static final DeferredItem<Item> DARK_NECROM_GHOST_EYECON = ITEMS.register("dark_necrom_ghost_eyecon",
            () -> new RiderFormChangeItem(new Item.Properties(),"","dark_necrom","dark_necrom_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 70, 0, 0, 0, 1);
                }
            }.changeBeltModel("geo/belt_with_brace.geo.json").changeModel("necrom.geo.json"));

	public static final DeferredItem<Item> DARK_NECROM_RED_GHOST_EYECON = ITEMS.register("dark_necrom_red_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"dark_necrom_red_damashii","dark_necrom","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.addNum(0).changeModel("dark_necrom_damashii.geo.json").changeSlot(2).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> DARK_NECROM_BLUE_GHOST_EYECON = ITEMS.register("dark_necrom_blue_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"dark_necrom_blue_damashii","dark_necrom","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.addNum(0).changeModel("dark_necrom_damashii.geo.json").changeSlot(2).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> DARK_NECROM_YELLOW_GHOST_EYECON = ITEMS.register("dark_necrom_yellow_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"dark_necrom_yellow_damashii","dark_necrom","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.addNum(0).changeModel("dark_necrom_damashii.geo.json").changeSlot(2).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> DARK_NECROM_PINK_GHOST_EYECON = ITEMS.register("dark_necrom_pink_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"dark_necrom_pink_damashii","dark_necrom","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.addNum(0).changeModel("dark_necrom_damashii.geo.json").changeSlot(2).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> NEW_ORE_GHOST_EYECON = ITEMS.register("new_ore_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"new_ore_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.changeModel("damashii.geo.json").changeSlot(2).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> MUSASHI_GHOST_EYECON = ITEMS.register("musashi_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"musashi_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(EffectCore.SLASH, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.changeModel("musashi_damashii.geo.json").hasCape().changeSlot(2).addToList(Monolith.GHOST_EYECONS,5).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> EDISON_GHOST_EYECON = ITEMS.register("edison_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"edison_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.changeModel("edison_damashii.geo.json").changeSlot(2).addToList(Monolith.GHOST_EYECONS,5).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> ROBIN_GHOST_EYECON = ITEMS.register("robin_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"robin_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.changeModel("robin_damashii.geo.json").hasCape().changeSlot(2).addToList(Monolith.GHOST_EYECONS,4).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> NEWTON_GHOST_EYECON = ITEMS.register("newton_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"newton_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(EffectCore.LOW_GRAVITY, 40, 7,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.changeModel("newton_damashii.geo.json").changeSlot(2).addToList(Monolith.GHOST_EYECONS,4).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> BILLY_THE_KID_GHOST_EYECON = ITEMS.register("billy_the_kid_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"billy_the_kid_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BROWN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.changeModel("billy_the_kid_damashii.geo.json").changeSlot(2).addToList(Monolith.GHOST_EYECONS,3).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> BEETHOVEN_GHOST_EYECON = ITEMS.register("beethoven_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"beethoven_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.changeModel("beethoven_damashii.geo.json").hasCape().changeSlot(2).addToList(Monolith.GHOST_EYECONS,3).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> BENKEI_GHOST_EYECON = ITEMS.register("benkei_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"benkei_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.changeModel("benkei_damashii.geo.json").changeSlot(2).addToList(Monolith.GHOST_EYECONS,3).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));


	public static final DeferredItem<Item> GOEMON_GHOST_EYECON = ITEMS.register("goemon_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"goemon_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.addNum(3).changeModel("goemon_damashii.geo.json").changeSlot(2).hasCape().addToList(Monolith.GHOST_EYECONS,2).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> RYOMA_GHOST_EYECON = ITEMS.register("ryoma_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"ryoma_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.addNum(3).changeModel("ryoma_damashii.geo.json").changeSlot(2).hasCape().addToList(Monolith.GHOST_EYECONS,2).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> HIMIKO_GHOST_EYECON = ITEMS.register("himiko_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"himiko_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.addNum(3).changeModel("himiko_damashii.geo.json").hasCape().changeSlot(2).addToList(Monolith.GHOST_EYECONS,2).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> TUTANKHAMUN_GHOST_EYECON = ITEMS.register("tutankhamun_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"tutankhamun_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.addNum(2).changeModel("tutankhamun_damashii.geo.json").changeSlot(2).addToList(Monolith.GHOST_EYECONS,3).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> NOBUNAGA_GHOST_EYECON = ITEMS.register("nobunaga_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"nobunaga_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.addNum(2).changeModel("nobunaga_damashii.geo.json").hasCape().changeSlot(2).addToList(Monolith.GHOST_EYECONS,3).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> HOUDINI_GHOST_EYECON = ITEMS.register("houdini_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"houdini_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 5,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.addNum(2).changeModel("houdini_damashii.geo.json").changeSlot(2).addToList(Monolith.GHOST_EYECONS,2).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> GRIMM_GHOST_EYECON = ITEMS.register("grimm_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"grimm_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.DARK_GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.addNum(0).changeModel("grimm_damashii.geo.json").changeSlot(2).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> SANZO_GHOST_EYECON = ITEMS.register("sanzo_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"sanzo_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 5,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.addNum(0).changeModel("sanzo_damashii.geo.json").changeSlot(2).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> NAPOLEON_GHOST_EYECON = ITEMS.register("napoleon_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"napoleon_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.DARK_BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.changeModel("napoleon_damashii.geo.json").hasCape().changeSlot(2).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> DARWIN_GHOST_EYECON = ITEMS.register("darwin_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"darwin_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.REGENERATION, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.changeModel("darwin_damashii.geo.json").changeSlot(2).hasCape().addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> IKKYU_GHOST_EYECON = ITEMS.register("ikkyu_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"ikkyu_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.changeModel("damashii.geo.json").changeSlot(2).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> PYTHAGORAS_GHOST_EYECON = ITEMS.register("pythagoras_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"pythagoras_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.changeModel("pythagoras_damashii.geo.json").changeSlot(2).hasCape().addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> SANTA_GHOST_EYECON = ITEMS.register("santa_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"santa_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.REGENERATION, 40, 1,true,false),
					new MobEffectInstance(MobEffects.SATURATION, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 35, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 35, 0, 0, 0, 1);
				}
			}.changeModel("santa_damashii.geo.json").changeSlot(2).hasCape().addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> NIGHTINGALE_GHOST_EYECON = ITEMS.register("nightingale_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"nightingale_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.REGENERATION, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.changeModel("damashii.geo.json").changeSlot(2).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> SPECIAL_ORE_GHOST_EYECON = ITEMS.register("special_ore_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"special_ore_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.changeModel("damashii.geo.json").changeSlot(2).addToList(Monolith.GHOST_EYECONS).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> ORE_SPECTER_GHOST_EYECON = ITEMS.register("ore_specter_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"ore_specter_damashii","chair_is_no_fun","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false))
					.changeModel("damashii.geo.json").changeSlot(2).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> ISHINOMORI_GHOST_EYECON = ITEMS.register("ishinomori_ghost_eyecon",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> COLUMBUS_GHOST_EYECON = ITEMS.register("columbus_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"columbus_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.changeModel("damashii.geo.json").changeSlot(2).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> SHAKEPEARE_GHOST_EYECON = ITEMS.register("shakespeare_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"shakespeare_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.CONFUSION, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.changeModel("damashii.geo.json").changeSlot(2).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> KAMEHAMEHA_GHOST_EYECON = ITEMS.register("kamehameha_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"kamehameha_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.changeModel("kamehameha_damashii.geo.json").changeSlot(2).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> GALILEO_GHOST_EYECON = ITEMS.register("galileo_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"galileo_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.changeModel("galileo_damashii.geo.json").changeSlot(2).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> DA_VINCI_GHOST_EYECON = ITEMS.register("da_vinci_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"da_vinci_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.changeModel("damashii.geo.json").changeSlot(2).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> TENKATOITSU_GHOST_EYECON = ITEMS.register("tenkatoitsu_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),"tenkatoitsu_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.REGENERATION, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.changeModel("damashii.geo.json").changeSlot(2).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> SHINSENGUMI_GHOST_EYECON = ITEMS.register("shinsengumi_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"shinsengumi_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.changeModel("damashii.geo.json").changeSlot(2).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> SHOWA_GHOST_EYECON = ITEMS.register("showa_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"showa_rider_45_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.changeModel("damashii.geo.json").changeSlot(2).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> KUUGA_GHOST_EYECON = ITEMS.register("kuuga_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"kuuga_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(EffectCore.PUNCH, 40, 2,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.changeModel("damashii.geo.json").changeSlot(2).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> AGITO_GHOST_EYECON = ITEMS.register("agito_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"agito_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.changeModel("damashii.geo.json").changeSlot(2).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> RYUKI_GHOST_EYECON = ITEMS.register("ryuki_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"ryuki_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}	.changeModel("damashii.geo.json").changeSlot(2).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> FAIZ_GHOST_EYECON = ITEMS.register("faiz_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"faiz_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.changeModel("damashii.geo.json").changeSlot(2).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> BLADE_GHOST_EYECON = ITEMS.register("blade_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"blade_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.changeModel("damashii.geo.json").changeSlot(2).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> HIBIKI_GHOST_EYECON = ITEMS.register("hibiki_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"hibiki_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.DARK_BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.changeModel("damashii.geo.json").changeSlot(2).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> KABUTO_GHOST_EYECON = ITEMS.register("kabuto_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"kabuto_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.changeModel("damashii.geo.json").changeSlot(2).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> DEN_O_GHOST_EYECON = ITEMS.register("den_o_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"den_o_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.changeModel("damashii.geo.json").changeSlot(2).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> KIVA_GHOST_EYECON = ITEMS.register("kiva_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"kiva_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.changeModel("damashii.geo.json").changeSlot(2).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> DECADE_GHOST_EYECON = ITEMS.register("decade_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"decade_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.changeModel("damashii.geo.json").changeSlot(2).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> DOUBLE_GHOST_EYECON = ITEMS.register("double_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"double_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(EffectCore.PUNCH, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.changeModel("damashii.geo.json").changeSlot(2).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> OOO_GHOST_EYECON = ITEMS.register("ooo_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"ooo_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.changeModel("damashii.geo.json").changeSlot(2).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> FOURZE_GHOST_EYECON = ITEMS.register("fourze_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"fourze_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.changeModel("damashii.geo.json").changeSlot(2).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> WIZARD_GHOST_EYECON = ITEMS.register("wizard_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"wizard_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.changeModel("damashii.geo.json").changeSlot(2).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> GAIM_GHOST_EYECON = ITEMS.register("gaim_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"gaim_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.DARK_BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.changeModel("damashii.geo.json").changeSlot(2).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> DRIVE_GHOST_EYECON = ITEMS.register("drive_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"drive_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.changeModel("damashii.geo.json").changeSlot(2).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> GHOST_GHOST_EYECON = ITEMS.register("ghost_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"ore_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
					new MobEffectInstance(EffectCore.GHOST, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.changeModel("damashii.geo.json").changeSlot(2).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> EX_AID_GHOST_EYECON = ITEMS.register("ex_aid_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"ex_aid_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.changeModel("damashii.geo.json").changeSlot(2).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> UNFINISHED_FOURTYFIVE_HEISEI_GHOST_EYECON  = ITEMS.register("unfinished_fourtyfive_heisei_ghost_eyecon",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> FOURTYFIVE_HEISEI_DAMASHII = ITEMS.register("fourtyfive_heisei_damashii",
			() -> new RiderFormChangeItem(new Item.Properties(),"fourtyfive_heisei_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 1);
				}
			}.changeModel("damashii.geo.json").changeSlot(2));

	public static final DeferredItem<Item> FOURTYFIVE_HEISEI_GHOST_EYECON = ITEMS.register("fourtyfive_heisei_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"_heisei","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 1);
				}
			}.alsoChange2ndSlot(FOURTYFIVE_HEISEI_DAMASHII.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> FOURTYFIVE_SHOWA_GHOST_EYECON = ITEMS.register("fourtyfive_showa_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"ichigou_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ParticleTypes.GUST,
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 1);
				}
			}.changeModel("ichigo_damashii.geo.json").changeSlot(2).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> TOUSAN_GHOST_EYECON = ITEMS.register("tousan_ghost_eyecon",
			() -> new CopyFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),BOOST_GHOST_EYECON.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));


	public static final DeferredItem<Item> ROYALTY_GAMMA_EYECON = ITEMS.register("royalty_gamma_eyecon",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> GAMMA_SUPERIOR_DAMASHII = ITEMS.register("gamma_superior_damashii",
			() -> new RiderFormChangeItem(new Item.Properties(),"gamma_superior_damashii","gamma_superior","gamma_superior_belt_gamma_superior_damashii",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 1);
				}
			}.changeModel("damashii.geo.json").changeSlot(2).has_basic_model().model_has_different_name("transform_gamma_eyecon"));

	public static final DeferredItem<Item> TRANSFORM_GAMMA_EYECON = ITEMS.register("transform_gamma_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"","gamma_superior","gamma_superior_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.addAlternative(GAMMA_SUPERIOR_DAMASHII.get()).changeModel("gamma_superior.geo.json").changeBeltModel("geo/belt_with_brace.geo.json").alsoChange2ndSlot(GAMMA_SUPERIOR_DAMASHII.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> TRANSFORM_GAMMA_EYECON_CAMILLE = ITEMS.register("transform_gamma_eyecon_camille",
			() -> new RiderFormChangeItem(new Item.Properties(),"gamma_superior_damashii_gold","gamma_superior","gamma_superior_belt_gammma_superior_damashii",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 1);
				}
			}.changeModel("damashii.geo.json").changeSlot(2).has_basic_model().model_has_different_name("transform_gamma_eyecon").addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> KNIFE_GAMMA_EYECON = ITEMS.register("knife_gamma_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),"gamma_knife_damashii","gamma_superior","gamma_superior_belt_knife_damashii",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.changeModel("gamma_knife_damashii.geo.json").changeSlot(2).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> YURUSEN_GAMMA_EYECON = ITEMS.register("yurusen_gamma_eyecon",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> SISTER_GAMMA_EYECON = ITEMS.register("sister_gamma_eyecon",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> GHOST_HELMET = ITEMS.register("ghost_head",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM).ChangeRepairItem(BLANK_GHOST_EYECON.get()));
	public static final DeferredItem<Item> GHOST_CHESTPLATE = ITEMS.register("ghost_troso",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM).ChangeRepairItem(BLANK_GHOST_EYECON.get()));
	public static final DeferredItem<Item> GHOST_LEGGINGS = ITEMS.register("ghost_legs",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM).ChangeRepairItem(BLANK_GHOST_EYECON.get()));

	public static final DeferredItem<Item> GHOST_DRIVER = ITEMS.register("ghost_driver",
			() -> new GhostDriverItem(ArmorMaterials.DIAMOND,"ghost",ORE_GHOST_EYECON ,1, GHOST_HELMET,GHOST_CHESTPLATE,GHOST_LEGGINGS , new Item.Properties())
                    .addOnTransformationTiming(1d).addExtraBaseFormItems(ORE_DAMASHII).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM).AddToTabList(DecadeRiderItems.NEO_DIEND_SUMMON_BELTS).ChangeRepairItem(BLANK_GHOST_EYECON.get()));

	public static final DeferredItem<Item> UNFINISHED_EYECON_DRIVER_G = ITEMS.register("unfinished_eyecon_driver_g",
			() -> new RiderFormChangeItem(new Item.Properties(),"","ghost_grateful","eyecon_driver_g_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.REGENERATION, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
					new MobEffectInstance(EffectCore.GHOST, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.RANDOM_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 1);
				}
			}.isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> EYECON_DRIVER_G = ITEMS.register("eyecon_driver_g",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"ghost_grateful",UNFINISHED_EYECON_DRIVER_G , GHOST_HELMET,GHOST_CHESTPLATE,GHOST_LEGGINGS , new Item.Properties().rarity(Rarity.UNCOMMON))
					.AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM).ChangeRepairItem(BLANK_GHOST_EYECON.get()));


	public static final DeferredItem<Item> SPECTER_DRIVER = ITEMS.register("specter_driver",
			() -> new GhostDriverItem(ArmorMaterials.DIAMOND,"specter",SPECTER_GHOST_EYECON ,2, GHOST_HELMET,GHOST_CHESTPLATE,GHOST_LEGGINGS , new Item.Properties())
					.addExtraBaseFormItems(SPECTER_DAMASHII).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM).AddToTabList(DecadeRiderItems.NEO_DIEND_SUMMON_BELTS).ChangeRepairItem(BLANK_GHOST_EYECON.get()));

	public static final DeferredItem<Item> MEGA_ULORDER = ITEMS.register("mega_ulorder",
			() -> new GhostDriverItem(ArmorMaterials.DIAMOND,"necrom",NECROM_GHOST_EYECON ,0, GHOST_HELMET,GHOST_CHESTPLATE,GHOST_LEGGINGS , new Item.Properties())
					.addExtraBaseFormItems(NECROM_DAMASHII).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM).ChangeRepairItem(BLANK_GHOST_EYECON.get()));

	public static final DeferredItem<Item> DARK_GHOST_DRIVER = ITEMS.register("dark_ghost_driver",
			() -> new GhostDriverItem(ArmorMaterials.DIAMOND,"dark_ghost",DARK_GHOST_EYECON ,1, GHOST_HELMET,GHOST_CHESTPLATE,GHOST_LEGGINGS , new Item.Properties())
					.addExtraBaseFormItems(DARK_DAMASHII).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM).ChangeRepairItem(BLANK_GHOST_EYECON.get()));

	public static final DeferredItem<Item> UNFINISHED_EXTREMER_DRIVER = ITEMS.register("unfinished_extremer_driver",
			() -> new RiderFormChangeItem(new Item.Properties(),"","extremer","extremer_driver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 1,true,false),
					new MobEffectInstance(EffectCore.GHOST, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 1);
				}
			}.isGlowing());

	public static final DeferredItem<Item> EXTREMER_DRIVER = ITEMS.register("extremer_driver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"extremer",UNFINISHED_EXTREMER_DRIVER , GHOST_HELMET,GHOST_CHESTPLATE,GHOST_LEGGINGS , new Item.Properties().rarity(Rarity.UNCOMMON))
					.hideBeltFormInfo().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM).ChangeRepairItem(BLANK_GHOST_EYECON.get()));

	public static final DeferredItem<Item> ZERO_SPECTER_DRIVER = ITEMS.register("zero_specter_driver",
			() -> new GhostDriverItem(ArmorMaterials.DIAMOND,"zero_specter",ZERO_SPECTER_GHOST_EYECON ,2, GHOST_HELMET,GHOST_CHESTPLATE,GHOST_LEGGINGS , new Item.Properties())
					.addExtraBaseFormItems(ZERO_SPECTER_DAMASHII).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM).ChangeRepairItem(BLANK_GHOST_EYECON.get()));

	public static final DeferredItem<Item> KANON_SPECTER_DRIVER = ITEMS.register("kanon_specter_driver",
			() -> new GhostDriverItem(ArmorMaterials.DIAMOND,"kanon_specter",KANON_SPECTER_GHOST_EYECON ,2, GHOST_HELMET,GHOST_CHESTPLATE,GHOST_LEGGINGS , new Item.Properties())
					.addExtraBaseFormItems(KANON_SPECTER_DAMASHII).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM).ChangeRepairItem(BLANK_GHOST_EYECON.get()));

	public static final DeferredItem<Item> PROTO_MEGA_ULORDER_RED = ITEMS.register("proto_mega_ulorder_red",
			() -> new GhostDriverItem(ArmorMaterials.DIAMOND,"dark_necrom",DARK_NECROM_GHOST_EYECON ,0, GHOST_HELMET,GHOST_CHESTPLATE,GHOST_LEGGINGS , new Item.Properties())
					.addExtraBaseFormItems(DARK_NECROM_RED_GHOST_EYECON).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM).ChangeRepairItem(BLANK_GHOST_EYECON.get()));

	public static final DeferredItem<Item> PROTO_MEGA_ULORDER_BLUE = ITEMS.register("proto_mega_ulorder_blue",
			() -> new GhostDriverItem(ArmorMaterials.DIAMOND,"dark_necrom",DARK_NECROM_GHOST_EYECON ,0, GHOST_HELMET,GHOST_CHESTPLATE,GHOST_LEGGINGS , new Item.Properties())
					.addExtraBaseFormItems(DARK_NECROM_BLUE_GHOST_EYECON).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM).ChangeRepairItem(BLANK_GHOST_EYECON.get()));

	public static final DeferredItem<Item> PROTO_MEGA_ULORDER_YELLOW = ITEMS.register("proto_mega_ulorder_yellow",
			() -> new GhostDriverItem(ArmorMaterials.DIAMOND,"dark_necrom",DARK_NECROM_GHOST_EYECON ,0, GHOST_HELMET,GHOST_CHESTPLATE,GHOST_LEGGINGS , new Item.Properties())
					.addExtraBaseFormItems(DARK_NECROM_YELLOW_GHOST_EYECON).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM).ChangeRepairItem(BLANK_GHOST_EYECON.get()));

	public static final DeferredItem<Item> PROTO_MEGA_ULORDER_PINK = ITEMS.register("proto_mega_ulorder_pink",
			() -> new GhostDriverItem(ArmorMaterials.DIAMOND,"dark_necrom",DARK_NECROM_GHOST_EYECON ,0, GHOST_HELMET,GHOST_CHESTPLATE,GHOST_LEGGINGS , new Item.Properties())
					.addExtraBaseFormItems(DARK_NECROM_PINK_GHOST_EYECON).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM).ChangeRepairItem(BLANK_GHOST_EYECON.get()));

	public static final DeferredItem<Item> NEW_GHOST_DRIVER = ITEMS.register("new_ghost_driver",
			() -> new GhostDriverItem(ArmorMaterials.DIAMOND,"dark_ghost",DARK_GHOST_EYECON ,1, GHOST_HELMET,GHOST_CHESTPLATE,GHOST_LEGGINGS , new Item.Properties())
					.addExtraBaseFormItems(NEW_ORE_GHOST_EYECON).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM).ChangeRepairItem(BLANK_GHOST_EYECON.get()));

	public static final DeferredItem<Item> ZERO_GHOST_DRIVER = ITEMS.register("zero_ghost_driver",
			() -> new GhostDriverItem(ArmorMaterials.DIAMOND,"zero_ghost",PROTO_ORE_GHOST_EYECON ,1, GHOST_HELMET,GHOST_CHESTPLATE,GHOST_LEGGINGS , new Item.Properties())
					.addExtraBaseFormItems(PROTO_ORE_DAMASHII).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM).ChangeRepairItem(BLANK_GHOST_EYECON.get()));

	public static final DeferredItem<Item> PROTO_MEGA_ULORDER_IGOR = ITEMS.register("proto_mega_ulorder_gamma_superior",
			() -> new GhostDriverItem(ArmorMaterials.DIAMOND,"gamma_superior",TRANSFORM_GAMMA_EYECON ,0, GHOST_HELMET,GHOST_CHESTPLATE,GHOST_LEGGINGS , new Item.Properties())
					.addExtraBaseFormItems(GAMMA_SUPERIOR_DAMASHII).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM).ChangeRepairItem(BLANK_GHOST_EYECON.get()));


	public static final DeferredItem<Item> GAN_GUN_SABER_BLADE = ITEMS.register("gan_gun_saber_blade",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM).addToList(DecadeRiderItems.NEO_DIEND_SUMMON_WEAPONS).addToList(DecadeRiderItems.COMPLETE_21_WEAPONS).ChangeRepairItem(BLANK_GHOST_EYECON.get()));

	public static final DeferredItem<Item> GAN_GUN_SABER_NITOURYU = ITEMS.register("gan_gun_saber_nitouryu",
			() -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM).ChangeRepairItem(BLANK_GHOST_EYECON.get()));

	public static final DeferredItem<Item> GAN_GUN_SABER_NITOURYU_2 = ITEMS.register("gan_gun_saber_nitouryu_2",
			() -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM).ChangeRepairItem(BLANK_GHOST_EYECON.get()));

	public static final DeferredItem<Item> GAN_GUN_SABER_GUN = ITEMS.register("gan_gun_saber_gun",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 2, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM).ChangeRepairItem(BLANK_GHOST_EYECON.get()));

	public static final DeferredItem<Item> GAN_GUN_SABER_NAGINATA = ITEMS.register("gan_gun_saber_naginata",
			() -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM).ChangeRepairItem(BLANK_GHOST_EYECON.get()));

	public static final DeferredItem<Item> GAN_GUN_SABER_CONDOR_DENWOR = ITEMS.register("gan_gun_saber_condor_denwor",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM).ChangeRepairItem(BLANK_GHOST_EYECON.get()));

	public static final DeferredItem<Item> GAN_GUN_SABER_RIFLE = ITEMS.register("gan_gun_saber_rifle",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM).ChangeRepairItem(BLANK_GHOST_EYECON.get()));

	public static final DeferredItem<Item> GAN_GUN_SABER_HAMMER = ITEMS.register("gan_gun_saber_hammer",
			() -> new BaseSwordItem(Tiers.DIAMOND, 7, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM).ChangeRepairItem(BLANK_GHOST_EYECON.get()));

	public static final DeferredItem<Item> SUNGLASSESLASHER = ITEMS.register("sunglasseslasher_sword",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 12, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).IsSwordGun().addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM).ChangeRepairItem(BLANK_GHOST_EYECON.get()));

	public static final DeferredItem<Item> GAN_GUN_HAND_ROD = ITEMS.register("gan_gun_hand_rod",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).IsSwordGun().addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM).addToList(DecadeRiderItems.NEO_DIEND_SUMMON_WEAPONS).ChangeRepairItem(BLANK_GHOST_EYECON.get()));

	public static final DeferredItem<Item> GAN_GUN_HAND_KAMA = ITEMS.register("gan_gun_hand_kama",
			() -> new BaseSwordItem(Tiers.DIAMOND, 9, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM).ChangeRepairItem(BLANK_GHOST_EYECON.get()));

	public static final DeferredItem<Item> DEEP_SLASHER_SWORD = ITEMS.register("deep_slasher_sword",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 13, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).IsSwordGun().addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM).ChangeRepairItem(BLANK_GHOST_EYECON.get()));

	public static final DeferredItem<Item> GAN_GUN_CATCHER_ROD = ITEMS.register("gan_gun_catcher_rod",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 10, -2.4F, new Item.Properties()).IsSwordGun().addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM).ChangeRepairItem(BLANK_GHOST_EYECON.get()));

	public static final DeferredItem<Item> AKARI_CANNON = ITEMS.register("akari_cannon",
			() -> new AkariCannonItem(new Item.Properties().rarity(Rarity.UNCOMMON)).addToList(KamenRiderCraftCore.CreativeTabRegistry.GHOST_TAB_ITEM));

	public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
}