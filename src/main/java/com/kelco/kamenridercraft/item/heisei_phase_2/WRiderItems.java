package com.kelco.kamenridercraft.item.heisei_phase_2;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.block.machine.GaiaMemoryRefinerBlock;
import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.item.ModdedItemCore;
import com.kelco.kamenridercraft.item.base_items.*;
import com.kelco.kamenridercraft.item.heisei_phase_1.DecadeRiderItems;
import com.kelco.kamenridercraft.item.heisei_phase_2.w.MetalShaftItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.w.T2MemoryCaseItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.w.WDriverItem;
import com.kelco.kamenridercraft.particle.ModParticles;
import com.kelco.kamenridercraft.util.AnimationUtil;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class WRiderItems {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);

	public static final DeferredItem<Item> W_LOGO = ITEMS.register("w_logo",
			() -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/w")), new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM));


	public static final DeferredItem<Item> GAIA_MEMORY = ITEMS.register("gaiamemory",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM));

	public static final DeferredItem<Item>UNREFINED_MEMORY_G = ITEMS.register("unrefined_memory_g",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM));

	public static final DeferredItem<Item> UNREFINED_MEMORY_S = ITEMS.register("unrefined_memory_s",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM));

	public static final DeferredItem<Item> UNREFINED_MEMORY_T2 = ITEMS.register("unrefined_memory_t2",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM));


	public static final DeferredItem<Item> CYCLONE_MEMORY = ITEMS.register("cyclone_memory",
			() -> new RiderFormChangeItem(new Item.Properties(),"_cyclone","w","wdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)) {
				public void transformationEffect(ItemStack itemstack, LivingEntity player, Double tick)  {
                    super.transformationEffect(itemstack, player,tick);
                    if (tick==12d) AnimationUtil.playPose(player,"w.henshin_pose");
					if (tick==6d) {
						player.level().playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.BREEZE_IDLE_GROUND, SoundSource.PLAYERS, 1.0F, 1F);
					}
					if (tick==1d) {
						player.getAttribute(Attributes.WIND).setBaseValue(30);
						player.level().playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.IRON_TRAPDOOR_OPEN, SoundSource.PLAYERS, 1.0F, 1F);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 0.1);
				}}
			}.setFormDelay(1d).hasCape().isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM).addToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_S, 20));

	public static final DeferredItem<Item> HEAT_MEMORY = ITEMS.register("heat_memory",
			() -> new RiderFormChangeItem(new Item.Properties(),"_heat","w","wdriver_belt_hj",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(EffectCore.FIRE_ARMOR, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player, Double tick)  {
                    super.transformationEffect(itemstack, player,tick);
                    if (tick==12d) AnimationUtil.playPose(player,"w.henshin_pose");
                    if (tick==1d) {
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 0.1);
				}}
			}.setFormDelay(1d).isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM).addToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_S, 10));

	public static final DeferredItem<Item> LUNA_MEMORY = ITEMS.register("luna_memory",
			() -> new RiderFormChangeItem(new Item.Properties(),"_luna","w","wdriver_belt_lj",
					new MobEffectInstance(EffectCore.LONG_ARM, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player, Double tick)  {
                    super.transformationEffect(itemstack, player,tick);
                    if (tick==12d) AnimationUtil.playPose(player,"w.henshin_pose");
                    if (tick==1d) {
					((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 0.1);
				}}
			}.setFormDelay(1d).isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM).addToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_S, 10));

	public static final DeferredItem<Item> FANG_MEMORY = ITEMS.register("fang_memory",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"_fang","w","wdriver_belt_fj",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.CONFUSION, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player, Double tick)  {
                    super.transformationEffect(itemstack, player,tick);
                    if (tick==12d) AnimationUtil.playPose(player,"w.henshin_pose");
                    if (tick==1d) {
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 150, 0, 0, 0, 0.1);
				}}
			}.setFormDelay(1d).isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM));

	public static final DeferredItem<Item> JOKER_JOKER_MEMORY = ITEMS.register("joker_joker_memory",
			() -> new RiderFormChangeItem(new Item.Properties(),"_joker_joker","w","wdriver_belt_jj",
					new MobEffectInstance(EffectCore.KNOCKBACK_BOOST, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player, Double tick)  {
                    super.transformationEffect(itemstack, player,tick);
                    if (tick==12d) AnimationUtil.playPose(player,"w.henshin_pose");
                    if (tick==1d) {
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 0.1);
				}}
			}.setFormDelay(1d).isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM));


	public static final DeferredItem<Item> JOKER_MEMORY = ITEMS.register("joker_memory",
			() -> new RiderFormChangeItem(new Item.Properties(),"_joker","w","wdriver_belt",
					new MobEffectInstance(EffectCore.PUNCH, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player, Double tick)  {
                    super.transformationEffect(itemstack, player,tick);
                    if (tick==1d) {
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 0.1);
				}}
			}.setFormDelay(1d).isGlowing().changeSlot(2).setSlotTwoAbility("joker_memory_kick", 1).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM).addToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_G, 20));

	public static final DeferredItem<Item> METAL_MEMORY = ITEMS.register("metal_memory",
			() -> new RiderFormChangeItem(new Item.Properties(),"_metal","w","wdriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player, Double tick)  {
                    super.transformationEffect(itemstack, player,tick);
                    if (tick==1d) {
					((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 0.1);
				}}
			}.setFormDelay(1d).isGlowing().changeSlot(2).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM).addToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_G, 10));

	public static final DeferredItem<Item> TRIGGER_MEMORY = ITEMS.register("trigger_memory",
			() -> new RiderFormChangeItem(new Item.Properties(),"_trigger","w","wdriver_belt",
					new MobEffectInstance(EffectCore.SHOT_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player, Double tick)  {
                    super.transformationEffect(itemstack, player,tick);
                    if (tick==1d) {
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 0.1);
				}}
			}.setFormDelay(1d).isGlowing().changeSlot(2).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM).addToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_G, 10));

	public static final DeferredItem<Item> CYCLONE_CYCLONE_MEMORY = ITEMS.register("cyclone_cyclone_memory",
			() -> new RiderFormChangeItem(new Item.Properties(),"_cyclone_cyclone","w","wdriver_belt",
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)) {
				public void transformationEffect(ItemStack itemstack, LivingEntity player, Double tick)  {
                    super.transformationEffect(itemstack, player,tick);
                    if (tick==1d) {
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 0.1);
				}}
			}.setFormDelay(1d).hasCape().isGlowing().changeSlot(2).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM));


	public static final DeferredItem<Item> XTREME_MEMORY = ITEMS.register("xtreme_memory",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),"_cyclone_xtreme","w","wdriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(EffectCore.PUNCH, 40, 3,true,false),
					new MobEffectInstance(EffectCore.SLASH, 40, 2,true,false),
					new MobEffectInstance(EffectCore.REFLECT, 40, 0,true,false)){
		
				public void transformationEffect(ItemStack itemstack, LivingEntity player, Double tick)  {
                    super.transformationEffect(itemstack, player,tick);
                    if (tick==12d) AnimationUtil.playPose(player,"w.xtreme_henshin_pose");

                    if (tick==28d)((ServerLevel) player.level()).sendParticles(ParticleTypes.ENCHANT,
                            player.getX(), player.getY()+1.6,
                            player.getZ(), 1000, 0, 0, 0, 2);

                    if (tick==1d) {
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 200, 0, 0, 0, 0.1);

					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 0.1);
				}}
			}.setFormDelay(1d).isGlowing().alsoChange2ndSlot(JOKER_MEMORY.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM).addToList(DecadeRiderItems.COMPLETE_21_FORMS));

	public static final DeferredItem<Item> XTREME_GOLD_MEMORY = ITEMS.register("xtreme_gold_memory",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.EPIC),"_cyclone_xtreme_gold","w","wdriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(EffectCore.PUNCH, 40, 3,true,false),
					new MobEffectInstance(EffectCore.SLASH, 40, 2,true,false),
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player, Double tick)  {
                    super.transformationEffect(itemstack, player,tick);
                    if (tick==12d) AnimationUtil.playPose(player,"w.henshin_pose");
                    if (tick==1d) {
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 240, 0, 0, 0, 0.1);

					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 0.1);
				}}
			}.hasCape().setFormDelay(1d).isGlowing().alsoChange2ndSlot(JOKER_MEMORY.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM));

	public static final DeferredItem<Item> XTREME_ACCEL_MEMORY = ITEMS.register("xtreme_accel_memory",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),"_cyclone_xtreme_accel","w","wdriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(EffectCore.PUNCH, 40, 3,true,false),
					new MobEffectInstance(EffectCore.SLASH, 40, 4,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player, Double tick)  {
                    super.transformationEffect(itemstack, player,tick);
                    if (tick==12d) AnimationUtil.playPose(player,"w.henshin_pose");
                    if (tick==1d) {
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 240, 0, 0, 0, 0.1);

					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}}
			}.setFormDelay(1d).isGlowing().alsoChange2ndSlot(JOKER_MEMORY.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM));


	public static final DeferredItem<Item> ACCEL_MEMORY_BIKE = ITEMS.register("accel_memory_bike",
			() -> new RiderFormChangeItem(new Item.Properties(),"_bike_form","accel","blank",
					new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 40, 4,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
					new MobEffectInstance(EffectCore.STEP, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 0.1);
				}
			}.changeModel("accel_bike.geo.json").isBike().isGlowing().has_basic_model().model_has_different_name("accel_memory"));

	public static final DeferredItem<Item> ACCEL_MEMORY = ITEMS.register("accel_memory",
			() -> new RiderFormChangeItem(new Item.Properties(),"","accel","acceldriver_belt",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 0.1);
				}
			}.addSwitchForm(ACCEL_MEMORY_BIKE.get()).isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM).addToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_G, 5));

	public static final DeferredItem<Item> TRIAL_MEMORY = ITEMS.register("trial_memory",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"_trial","accel","acceldriver_belt_t",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(EffectCore.PUNCH, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player, Double tick)  {
                    super.transformationEffect(itemstack, player,tick);

                    if (tick==29d){
                        RiderDriverItem.SetOldFormItem(itemstack,ACCEL_MEMORY.get(),1);
                        player.level().playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.NOTE_BLOCK_CHIME, SoundSource.PLAYERS, 1.0F, 0.595f);
                        ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                                player.getX(), player.getY()+1,
                                player.getZ(), 100, 0, 0, 0, 0.1);
                    }
                    if (tick==15d){
                        player.level().playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.NOTE_BLOCK_CHIME, SoundSource.PLAYERS, 1.0F, 0.595f);
                        ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                                player.getX(), player.getY()+1,
                                player.getZ(), 100, 0, 0, 0, 0.1);
                    }
                    if (tick==1d) {
                        player.level().playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.NOTE_BLOCK_CHIME, SoundSource.PLAYERS, 1.0F, 1.189f);
                        player.level().playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.BREEZE_DEATH, SoundSource.PLAYERS, 1.0F, 1f);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 200, 0, 0, 0, 0.1);
				}}
			}.getAlsoUpdateOld(ACCEL_MEMORY.get()).setFormDelay(1).needBaseForm().isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM));

	public static final DeferredItem<Item> ACCEL_BOOSTER_MEMORY = ITEMS.register("accel_booster_memory",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"_booster","accel","acceldriver_belt_b",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(EffectCore.PUNCH, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ParticleTypes.FLAME,
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 0.1);
				}
			}.changeModel("accel.geo.json").addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM));


	public static final DeferredItem<Item> CYCLONE_SKULL_MEMORY = ITEMS.register("skull_cyclone_memory",
			() -> new RiderFormChangeItem(new Item.Properties(),"_skull","w","wdriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player, Double tick)  {
                    super.transformationEffect(itemstack, player,tick);
                    if (tick==1d) {
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 0.1);
				}}
			}.setFormDelay(1d).isGlowing().addNeedForm(CYCLONE_MEMORY.get(),1).changeSlot(2)
					.model_has_different_name("skull_memory").has_basic_model());

	public static final DeferredItem<Item> SKULL_MEMORY_CRYSTAL = ITEMS.register("skull_memory_crystal",
			() -> new RiderFormChangeItem(new Item.Properties(),"_crystal","skulll_crystal","lostdriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player,Double tick)  {
					super.transformationEffect(itemstack, player);
					if (tick==12d) AnimationUtil.playPose(player,"skull.henshin_pose");
					if (tick==1d) {
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 0.1);
				}}
			}.hasCape().isGlowing().addAlternative(CYCLONE_SKULL_MEMORY.get()).has_basic_model().model_has_different_name("skull_memory"));


	public static final DeferredItem<Item> SKULL_MEMORY = ITEMS.register("skull_memory",
			() -> new RiderFormChangeItem(new Item.Properties(),"","skull","lostdriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player,Double tick)  {
                    super.transformationEffect(itemstack, player,tick);
                    if (tick==12d) AnimationUtil.playPose(player,"skull.henshin_pose");
                    if (tick==1d) {
                        ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                                player.getX(), player.getY()+1,
                                player.getZ(), 100, 0, 0, 0, 0.1);
                    }}
            }.setFormDelay(1d).changeBeltModel("geo/belts/lostdriver_riderbelt.geo.json").hasCape().addSwitchForm(SKULL_MEMORY_CRYSTAL.get()).addAlternative(CYCLONE_SKULL_MEMORY.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM).addToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_S, 5));


	public static final DeferredItem<Item> ETERNAL_MEMORY = ITEMS.register("eternal_memory",
			() -> new RiderFormChangeItem(new Item.Properties(),"_red","eternal","lostdriver_belt_e",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.WEAKNESS, 40, 0,true,false)) {
				public void transformationEffect(ItemStack itemstack, LivingEntity player,Double tick)  {
                    super.transformationEffect(itemstack, player,tick);
						if (tick==12d) AnimationUtil.playPose(player,"eternal.henshin_pose");
                    if (tick==1d) {
                        ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                                player.getX(), player.getY()+1,
                                player.getZ(), 100, 0, 0, 0, 0.1);
                    }}
            }.setFormDelay(1d).changeBeltModel("geo/belts/lostdriver_riderbelt.geo.json").isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM).addToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_S, 1));


	public static final DeferredItem<Item> PRISM_MEMORY = ITEMS.register("prism_memory",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM)
					.addToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_S, 5));

	public static final DeferredItem<Item> ENGINE_MEMORY = ITEMS.register("engine_memory",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM)
					.addToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_S, 5));

	public static final DeferredItem<Item> BOMB_MEMORY = ITEMS.register("bomb_memory",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM)
					.addToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_S, 1));

	public static final DeferredItem<Item> TRIAL_MEMORY_UN = ITEMS.register("trial_memory_un",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM)
					.addToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_G, 2));

	public static final DeferredItem<Item> FANG_MEMORY_UN = ITEMS.register("fang_memory_un",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM)
					.addToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_S, 5));

	public static final DeferredItem<Item> XTREME_MEMORY_G = ITEMS.register("xtreme_memory_g",
			() -> new BaseItem(new Item.Properties().rarity(Rarity.UNCOMMON)).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM)
					.addToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_G, 1));

	public static final DeferredItem<Item> XTREME_MEMORY_S = ITEMS.register("xtreme_memory_s",
			() -> new BaseItem(new Item.Properties().rarity(Rarity.UNCOMMON)).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM)
					.addToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_S, 1));


	public static final DeferredItem<Item> SHIPPU_MEMORY = ITEMS.register("shippu_memory",
			() -> new CopyFormChangeItem(new Item.Properties(),CYCLONE_MEMORY.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM));

	public static final DeferredItem<Item> KIRIFUDA_MEMORY = ITEMS.register("kirifuda_memory",
			() -> new CopyFormChangeItem(new Item.Properties(),JOKER_MEMORY.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM));


	public static final DeferredItem<Item> ACCEL_T2_MEMORY = ITEMS.register("accel_t2_memory",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM)
					.addToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));

	public static final DeferredItem<Item> BIRD_T2_MEMORY = ITEMS.register("bird_t2_memory",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM)
					.addToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));

	public static final DeferredItem<Item> CYCLONE_T2_MEMORY = ITEMS.register("cyclone_t2_memory",
			() -> new RiderFormChangeItem(new Item.Properties(),"","cyclone","lostdriver_belt_c",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player,Double tick)  {
                    super.transformationEffect(itemstack, player,tick);
                    if (tick==12d) AnimationUtil.playPose(player,"cyclone.henshin_pose");
                    if (tick==1d) {
                        ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                                player.getX(), player.getY()+1,
                                player.getZ(), 100, 0, 0, 0, 0.1);
                    }}
            }.setFormDelay(1d).changeBeltModel("geo/belts/lostdriver_riderbelt.geo.json").isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM).addToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));

	public static final DeferredItem<Item> DUMMY_T2_MEMORY = ITEMS.register("dummy_t2_memory",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM)
					.addToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));

	public static final DeferredItem<Item> ETERNAL_T2_MEMORY = ITEMS.register("eternal_t2_memory",
			() -> new RiderFormChangeItem(new Item.Properties(),"","eternal","lostdriver_belt_e",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(EffectCore.PUNCH, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player,Double tick)  {
                    super.transformationEffect(itemstack, player,tick);
                    if (tick==12d) AnimationUtil.playPose(player,"eternal.henshin_pose");
                    if (tick==1d) {
					((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 0.1);
				}}
			}.setFormDelay(1d).changeBeltModel("geo/belts/lostdriver_riderbelt.geo.json").hasCape().isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM).addToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 5));


	public static final DeferredItem<Item> FANG_T2_MEMORY = ITEMS.register("fang_t2_memory",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM)
					.addToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));

	public static final DeferredItem<Item> GENE_T2_MEMORY = ITEMS.register("gene_t2_memory",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM)
					.addToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));

	public static final DeferredItem<Item> HEAT_T2_MEMORY = ITEMS.register("heat_t2_memory",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM)
					.addToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));

	public static final DeferredItem<Item> ICEAGE_T2_MEMORY = ITEMS.register("iceage_t2_memory",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM)
					.addToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));

	public static final DeferredItem<Item> JOKER_T2_MEMORY = ITEMS.register("joker_t2_memory",
			() -> new RiderFormChangeItem(new Item.Properties(),"","joker","lostdriver_belt",
					new MobEffectInstance(EffectCore.PUNCH, 40, 1,true,false),
					new MobEffectInstance(EffectCore.KNOCKBACK_BOOST, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player,Double tick)  {
                    super.transformationEffect(itemstack, player,tick);
                    if (tick==12d) AnimationUtil.playPose(player,"joker.henshin_pose");
                    if (tick==1d) {
                        ((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
                                player.getX(), player.getY()+1,
                                player.getZ(), 100, 0, 0, 0, 0.1);
                    }}
            }.setFormDelay(1d).changeBeltModel("geo/belts/lostdriver_riderbelt.geo.json").isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM).addToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 5));

	public static final DeferredItem<Item> KEY_T2_MEMORY = ITEMS.register("key_t2_memory",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM)
					.addToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));

	public static final DeferredItem<Item> luna_T2_MEMORY = ITEMS.register("luna_t2_memory",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM)
					.addToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));

	public static final DeferredItem<Item> METAL_T2_MEMORY = ITEMS.register("metal_t2_memory",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM)
					.addToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));

	public static final DeferredItem<Item> NASCA_T2_MEMORY = ITEMS.register("nasca_t2_memory",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM)
					.addToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));

	public static final DeferredItem<Item> OCEAN_T2_MEMORY = ITEMS.register("ocean_t2_memory",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM)
					.addToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));

	public static final DeferredItem<Item> PUPPETEER_T2_MEMORY = ITEMS.register("puppeteer_t2_memory",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM)
					.addToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));

	public static final DeferredItem<Item> QUEEN_T2_MEMORY = ITEMS.register("queen_t2_memory",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM)
					.addToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));

	public static final DeferredItem<Item> ROCKET_T2_MEMORY = ITEMS.register("rocket_t2_memory",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM)
					.addToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));

	public static final DeferredItem<Item> SKULL_T2_MEMORY = ITEMS.register("skull_t2_memory",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM)
					.addToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));

	public static final DeferredItem<Item> TRIGGER_T2_MEMORY = ITEMS.register("trigger_t2_memory",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM)
					.addToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));

	public static final DeferredItem<Item> UNICORN_T2_MEMORY = ITEMS.register("unicorn_t2_memory",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM)
					.addToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));

	public static final DeferredItem<Item> VIOLENCE_T2_MEMORY = ITEMS.register("violence_t2_memory",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM)
					.addToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));

	public static final DeferredItem<Item> WEATHER_T2_MEMORY = ITEMS.register("weather_t2_memory",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM)
					.addToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));

	public static final DeferredItem<Item> XTREME_T2_MEMORY = ITEMS.register("xtreme_t2_memory",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM)
					.addToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));

	public static final DeferredItem<Item> YESTERDAY_T2_MEMORY = ITEMS.register("yesterday_t2_memory",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM)
					.addToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1));


	public static final DeferredItem<Item> T2_ZONE_MEMORY = ITEMS.register("zone_t2_memory",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"_strengthening_armament","eternal","lostdriver_belt_e_z",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(EffectCore.PUNCH, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 5,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player,Double tick)  {
                    super.transformationEffect(itemstack, player,tick);
                    if (tick==30d) RiderDriverItem.SetOldFormItem(itemstack,ETERNAL_T2_MEMORY.get(),1);
                    if (tick==12d) AnimationUtil.playPose(player,"w.maximum_drive_start");
                    if (tick==1d) {
					((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.DARK_BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 10, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 10, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.DARK_RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 10, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 10, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.DARK_GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 10, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 10, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 10, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 10, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 10, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 10, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 10, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 10, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 10, 0, 0, 0, 0.1);

				}}
			}.getAlsoUpdateOld(ETERNAL_T2_MEMORY.get()).needBaseForm().hasCape().setFormDelay(1d).changeBeltModel("geo/belts/lostdriver_riderbelt.geo.json").isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM).addToList(GaiaMemoryRefinerBlock.GAIA_MEMORY_T2, 1) );


	public static final DeferredItem<Item> TERROR_MEMORY = ITEMS.register("terror_memory",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"","terror_dopant","gaia_driver_belt_terror",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(EffectCore.CANNON, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 0.1);
				}
			}.addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM));

	public static final DeferredItem<Item> TABOO_MEMORY = ITEMS.register("taboo_memory",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"","terror_dopant","gaia_driver_belt_taboo",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(EffectCore.CANNON, 40, 0,true,false),
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 0.1);
				}
			}.addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM));

	public static final DeferredItem<Item> CLAYDOLL_MEMORY = ITEMS.register("claydoll_memory",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"","claydoll_dopant","gaia_driver_belt_taboo",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.REGENERATION,200, 2,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 0.1);
				}
			}.changeBeltModel("geo/belts/claydoll_riderbelt.geo.json").addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM));

	public static final DeferredItem<Item> NASCA_MEMORY = ITEMS.register("nasca_memory",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"","nazca_dopant","gaia_driver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(EffectCore.SLASH, 40, 1,true,false),
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 0.1);
				}
			}.addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM));

	public static final DeferredItem<Item> SMILODON_MEMORY = ITEMS.register("smilodon_memory",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"","smilodon_dopant","gaia_driver_belt_smilodon",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(EffectCore.PUNCH,40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 0.1);
				}
			}.addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM));

	public static final DeferredItem<Item> WEATHER_MEMORY = ITEMS.register("weather_memory",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM));

	public static final DeferredItem<Item> QUETZALCOATUS_MEMORY = ITEMS.register("quetzalcoatlus_memory",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM));

	public static final DeferredItem<Item> QUETZALCOATUS_MEMORY_PROTOTYPE = ITEMS.register("quetzalcoatlus_memory_prototype",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM));

	public static final DeferredItem<Item> UTOPIA_MEMORY = ITEMS.register("utopia_memory",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM));

    public static final DeferredItem<Item> SHINIGAMI_HAKASE_MEMORY  = ITEMS.register("shinigami_hakase_dopant_memory",
            () -> new BaseItem(new Item.Properties()).has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM));

    public static final DeferredItem<Item> UNICON_MEMORY = ITEMS.register("unicorn_memory",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM));

	public static final DeferredItem<Item> UNICON_MEMORY_ENHANCING_ADAPTER = ITEMS.register("unicorn_memory_enhancing_adapter",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM));

	public static final DeferredItem<Item> MAGMA_MEMORY = ITEMS.register("magma_memory",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM));

	public static final DeferredItem<Item> COMMANDER_MEMORY = ITEMS.register("commander_memory",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM));

	public static final DeferredItem<Item> COMMANDER_MEMORY_ENHANCING_ADAPTER = ITEMS.register("commander_memory_enhancing_adapter",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM).KeepDifItem(COMMANDER_MEMORY.get()));


	public static final DeferredItem<Item> MEMORY_MEMORY = ITEMS.register("memory_memory",
			() -> new RiderFormChangeItem(new Item.Properties(),"","core","core_driver_belt",
					new MobEffectInstance(EffectCore.BIG, 40, 2,true,false),
					new MobEffectInstance(EffectCore.FIRE_PUNCH, 40, 2,true,false),
					new MobEffectInstance(EffectCore.FIRE_ARMOR, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 2,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ParticleTypes.FLAME,
							player.getX(), player.getY()+3,
							player.getZ(), 1000, 0, 0, 0, 0.1);
				}
			}.changeSlot(4).addSwitchForm(ModdedItemCore.BLANK_FORM.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM));

	public static final DeferredItem<Item> JOKER_DOPANT_MEMORY_BROKEN = ITEMS.register("joker_dopant_memory_broken",
			() -> new BaseItem(new Item.Properties()).has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM));

	public static final DeferredItem<Item> JOKER_DOPANT_MEMORY = ITEMS.register("joker_dopant_memory",
			() -> new BaseItem(new Item.Properties()).has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM));

	//public static final DeferredItem<Item> ROAD_MEMORY = ITEMS.register("road_memory",
	//		() -> new BaseCityItem(new Item.Properties(),10).addToList(RiderTabs.W_TAB_ITEM));

	public static final DeferredItem<Item> EGG_CHICKEN_MEMORY = ITEMS.register("egg_chicken_memory",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM));

	public static final DeferredItem<Item> MASQUERADE_MEMORY = ITEMS.register("masquerade_memory",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM));

	public static final DeferredItem<Item> STAG_MEMORY = ITEMS.register("stag_memory",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM));

	public static final DeferredItem<Item> SPIDER_MEMORY = ITEMS.register("spider_memory",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM));

	public static final DeferredItem<Item> BAT_MEMORY = ITEMS.register("bat_memory",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM));

	public static final DeferredItem<Item> BEETEL_MEMORY = ITEMS.register("beetle_memory",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM));

	public static final DeferredItem<Item> FROG_MEMORY = ITEMS.register("frog_memory",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM));

	public static final DeferredItem<Item> DENDEN_MEMORY = ITEMS.register("denden_memory",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM));


	public static final DeferredItem<Item> AKIKO_NO_SLIPPER = ITEMS.register("akiko_no_slipper",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM));


	public static final DeferredItem<Item> WHELMET = ITEMS.register("whead",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM).changeRepairItem( GAIA_MEMORY.get()));
	public static final DeferredItem<Item> WCHESTPLATE = ITEMS.register("wtroso",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM).changeRepairItem( GAIA_MEMORY.get()));
	public static final DeferredItem<Item> WLEGGINGS = ITEMS.register("wlegs",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM).changeRepairItem( GAIA_MEMORY.get()));


	public static final DeferredItem<Item> WDRIVER = ITEMS.register("wdriver",
			() -> new WDriverItem(ArmorMaterials.DIAMOND,"w",CYCLONE_MEMORY ,WHELMET,WCHESTPLATE,WLEGGINGS , new Item.Properties())
					.addExtraBaseFormItems(JOKER_MEMORY).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM).changeRepairItem(GAIA_MEMORY.get()).addToList(DecadeRiderItems.NEO_DIEND_SUMMON_BELTS));

	public static final DeferredItem<Item> ACCELDRIVER = ITEMS.register("acceldriver",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"accel",ACCEL_MEMORY ,WHELMET,WCHESTPLATE,WLEGGINGS , new Item.Properties()) {
                public String getText(ItemStack itemStack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName) {
                   // getFormItem(itemstack,2,rider.getAttribute(Attributes.IS_TRANSFORMING).getBaseValue())
                    if (equipmentSlot != EquipmentSlot.FEET&&getFormItem(itemStack,1)==TRIAL_MEMORY.asItem()&&rider.getAttribute(Attributes.IS_TRANSFORMING).getBaseValue()!=0){
                        if(rider.getAttribute(Attributes.IS_TRANSFORMING).getBaseValue()<15)return "accel_yellow";
                    }
                    return super.getText(itemStack,equipmentSlot,rider,riderName);
                }

            }.addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM).addToList(DecadeRiderItems.NEO_DIEND_SUMMON_BELTS).changeRepairItem(GAIA_MEMORY.get()).changeRepairItem( GAIA_MEMORY.get()));


	public static final DeferredItem<Item> LOSTDRIVER_JOKER = ITEMS.register("lostdriver_joker",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"joker",JOKER_T2_MEMORY ,WHELMET,WCHESTPLATE,WLEGGINGS , new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM)
					.changeRepairItem(GAIA_MEMORY.get()).changeRepairItem( GAIA_MEMORY.get()));

	public static final DeferredItem<Item> LOSTDRIVER_CYCLONE = ITEMS.register("lostdriver_cyclone",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"cyclone",CYCLONE_T2_MEMORY ,WHELMET,WCHESTPLATE,WLEGGINGS , new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM)
					.changeRepairItem(GAIA_MEMORY.get()).changeRepairItem( GAIA_MEMORY.get()));

	public static final DeferredItem<Item> LOSTDRIVER_SKULL = ITEMS.register("lostdriver_skull",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"skull",SKULL_MEMORY ,WHELMET,WCHESTPLATE,WLEGGINGS , new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM).addToList(DecadeRiderItems.NEO_DIEND_SUMMON_BELTS)
					.changeRepairItem(GAIA_MEMORY.get()).changeRepairItem( GAIA_MEMORY.get()));

	public static final DeferredItem<Item> LOSTDRIVER_ETERNAL = ITEMS.register("lostdriver_eternal",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"eternal",ETERNAL_T2_MEMORY ,WHELMET,WCHESTPLATE,WLEGGINGS , new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM)
					.changeRepairItem(GAIA_MEMORY.get()).changeRepairItem( GAIA_MEMORY.get()));

	public static final DeferredItem<Item> GAIA_DRIVER_TERROR = ITEMS.register("gaia_driver_terror",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"terror_dopant",TERROR_MEMORY ,WHELMET,WCHESTPLATE,WLEGGINGS , new Item.Properties()).hideBeltFormInfo().addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM)
					.changeRepairItem(GAIA_MEMORY.get()).changeRepairItem( GAIA_MEMORY.get()));

	public static final DeferredItem<Item> GAIA_DRIVER_TABOO = ITEMS.register("gaia_driver_taboo",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"taboo_dopant",TABOO_MEMORY ,WHELMET,WCHESTPLATE,WLEGGINGS , new Item.Properties()).hideBeltFormInfo().addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM)
					.changeRepairItem(GAIA_MEMORY.get()).changeRepairItem( GAIA_MEMORY.get()));

	public static final DeferredItem<Item> GAIA_DRIVER_CLAYDOLL = ITEMS.register("gaia_driver_claydoll",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"claydoll_dopant",CLAYDOLL_MEMORY ,WHELMET,WCHESTPLATE,WLEGGINGS , new Item.Properties()).hideBeltFormInfo().addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM)
					.changeRepairItem(GAIA_MEMORY.get()).changeRepairItem( GAIA_MEMORY.get()));

	public static final DeferredItem<Item> GAIA_DRIVER_SMILODON = ITEMS.register("gaia_driver_smilodon",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"smilodon_dopant",SMILODON_MEMORY ,WHELMET,WCHESTPLATE,WLEGGINGS , new Item.Properties()).hideBeltFormInfo().addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM)
					.changeRepairItem(GAIA_MEMORY.get()).changeRepairItem( GAIA_MEMORY.get()));

	public static final DeferredItem<Item> GAIA_DRIVER_NASCA = ITEMS.register("gaia_driver_nasca",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"nazca_dopant",NASCA_MEMORY ,WHELMET,WCHESTPLATE,WLEGGINGS , new Item.Properties()).hideBeltFormInfo().addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM)
					.changeRepairItem(GAIA_MEMORY.get()).changeRepairItem( GAIA_MEMORY.get()));


	public static final DeferredItem<Item> TRIGGER_MAGNUM = ITEMS.register("trigger_magnum",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM));

	public static final DeferredItem<Item>METAL_SHAFT = ITEMS.register("metal_shaft",
			() -> new MetalShaftItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM).changeRepairItem( GAIA_MEMORY.get()));


	public static final DeferredItem<Item> PRISM_BICKER = ITEMS.register("prism_bicker",
			() -> new BaseSwordItem(Tiers.DIAMOND, 9, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM).addToList(DecadeRiderItems.COMPLETE_21_WEAPONS).changeRepairItem( GAIA_MEMORY.get()));


	public static final DeferredItem<Item> SHIELD_PRISM_BICKER = ITEMS.register("shield_prism_bicker",
			() -> new BaseShieldItem(new Item.Properties().rarity(Rarity.UNCOMMON)).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM).addToList(DecadeRiderItems.COMPLETE_21_WEAPONS).changeRepairItem( GAIA_MEMORY.get()));


	public static final DeferredItem<Item> ETERNAL_EDGE = ITEMS.register("eternal_edge",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM).changeRepairItem( GAIA_MEMORY.get()));

	public static final DeferredItem<Item> SKILL_MAGNUM = ITEMS.register("skull_magnum",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM).addToList(DecadeRiderItems.NEO_DIEND_SUMMON_WEAPONS).changeRepairItem( GAIA_MEMORY.get()));

	public static final DeferredItem<Item> ENGINE_BLADE = ITEMS.register("engine_blade",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM).addToList(DecadeRiderItems.NEO_DIEND_SUMMON_WEAPONS).changeRepairItem( GAIA_MEMORY.get()));

	public static final DeferredItem<Item> BOMB_MAGNUM = ITEMS.register("bomb_magnum",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM).changeRepairItem( GAIA_MEMORY.get()));

	public static final DeferredItem<Item> NASCA_BLADE = ITEMS.register("nasca_blade",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM).changeRepairItem( GAIA_MEMORY.get()));

	public static final DeferredItem<Item> T2_MEMORY_CASE = ITEMS.register("t2_memory_case",
			() -> new T2MemoryCaseItem().has_basic_model().model_has_different_name("rider_case").addToList(KamenRiderCraftCore.CreativeTabRegistry.W_TAB_ITEM));

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}