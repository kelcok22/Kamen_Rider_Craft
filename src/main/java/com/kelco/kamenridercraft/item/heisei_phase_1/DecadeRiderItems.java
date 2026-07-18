package com.kelco.kamenridercraft.item.heisei_phase_1;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.block.RiderBlocks;
import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.item.base_items.*;
import com.kelco.kamenridercraft.item.heisei_phase_1.decade.*;
import com.kelco.kamenridercraft.item.showa.*;
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

import java.util.ArrayList;
import java.util.List;

public class DecadeRiderItems {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);
	public static List<Item> NEO_DIEND_SUMMON_BELTS = new ArrayList<>();
	public static List<Item> NEO_DIEND_SUMMON_FORMS = new ArrayList<>();
	public static List<Item> NEO_DIEND_SUMMON_WEAPONS = new ArrayList<>();
	public static List<Item> COMPLETE_21_FORMS = new ArrayList<>();
	public static List<Item> COMPLETE_21_WEAPONS = new ArrayList<>();
	public static List<Item> ZEIN_CARDS = new ArrayList<>();

	public static final DeferredItem<Item> DECADE_LOGO = ITEMS.register("decade_logo",
			() -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/decade")), new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DECADE_CAMERA = ITEMS.register("decade_camera",
			() -> new BaseItem(new Item.Properties().rarity(Rarity.UNCOMMON)).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM).KeepItem());

	public static final DeferredItem<Item> BLANK_CARD = ITEMS.register("blank_card",
			() -> new BaseDropItem(new Item.Properties(), ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "items/blank_card")).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DECADE_CYAN_CARD = ITEMS.register("decade_cyan_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"_cyan","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().IsBeltGlowing());

	public static final DeferredItem<Item> DIEND_GREEN_CARD = ITEMS.register("diend_green_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"_green","diend","diend_belt_green",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing());

	public static final DeferredItem<Item> DECADE_CARD = ITEMS.register("decade_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(), //WeHn MaGnTaE
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addCompatibilityList(new String[] {"neo_decade"}).changeRiderName("decade").addAlternative(DIEND_GREEN_CARD.get())
					.IsBeltGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

    public static List<Item> NEED_ITEM_STRONGEST_COMPLETE= new ArrayList<>();

    public static final DeferredItem<Item> K_TOUCH_STRONGEST = ITEMS.register("k_touch_strongest",
            () -> new RiderFormChangeItem(new Item.Properties(),"_strongest_complete","decade","decadriver_belt_k_touch",
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
                    ,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 8,true,false)
                    ,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false)
                    ,new MobEffectInstance(MobEffects.REGENERATION, 40, 4,true,false)
                    ,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.SATURATION, 40, 4,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }.addNeedItemList(NEED_ITEM_STRONGEST_COMPLETE).IsBeltGlowing().isGlowing());

    public static final DeferredItem<Item> K_TOUCH = ITEMS.register("k_touch",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),"_complete","decade","decadriver_belt_k_touch",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }.IsBeltGlowing().isGlowing().addSwitchForm(K_TOUCH_STRONGEST.get()).addIncompatibleForm(K_TOUCH_STRONGEST.asItem()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> K_TOUCH_21 = ITEMS.register("k_touch_21",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.EPIC),"_complete_21","neo_decade","decadriver_belt_k_touch_21",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 5,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 75, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 25, 0, 0, 0, 1);
				}
			}.IsBeltGlowing().isGlowing().hasCape().ignoreOverrideBeltText().addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DECADE_VIOLENT_EMOTION_CARD = ITEMS.register("decade_violent_emotion_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"_violent_emotion","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
					new MobEffectInstance(MobEffects.HUNGER, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.IsBeltGlowing().isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DIEND_CARD = ITEMS.register("diend_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","diend","diend_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().IsBeltGlowing().addAlternative(DECADE_CYAN_CARD.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DIEND_CHINOMANAKO_CARD = ITEMS.register("diend_chinomanako_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"_chinomanako","diend","diend_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.IsBeltGlowing().has_basic_model().model_has_different_name("diend_card").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DIEND_CARD_POWER_UP = ITEMS.register("diend_power_up_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"","diend","diend_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().IsBeltGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> K_TOUCH_DIEND = ITEMS.register("k_touch_diend",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"_complete","diend","diend_belt_k_touch",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
				}
			}.IsBeltGlowing().isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DARK_DECADE_CARD = ITEMS.register("dark_decade_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"","dark_decade","dark_decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.IsBeltGlowing().isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static String[] BaseDecadeUsers = new String[] {"decade","dark_decade","neo_decade"};

	public static final DeferredItem<Item> KUUGA_MIGHTY_CARD = ITEMS.register("kuuga_mighty_card",
			() -> new RiderCardItem(new Item.Properties(),"","decade","decadriver_belt",
					new MobEffectInstance(EffectCore.PUNCH, 40, 2,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.setSummonBelt((RiderDriverItem) KuugaRiderItems.ARCLE.get()).addCompatibilityList(BaseDecadeUsers)
					.IsBeltGlowing().isGlowing().changeRiderName("kuuga").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> AGITO_GROUND_CARD = ITEMS.register("agito_ground_card",
			() -> new RiderCardItem(new Item.Properties(),"","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.setSummonBelt((RiderDriverItem) AgitoRiderItems.ALTERING.get()).addCompatibilityList(BaseDecadeUsers)
					.IsBeltGlowing().isGlowing().changeRiderName("agito").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> RYUKI_CARD = ITEMS.register("ryuki_card",
			() -> new RiderCardItem(new Item.Properties(),"","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.setSummonBelt((RiderDriverItem) RyukiRiderItems.RYUKIDRIVER.get()).addSummonWeapon(RyukiRiderItems.DRAG_CLAW.get())
					.IsBeltGlowing().isGlowing().addCompatibilityList(BaseDecadeUsers).changeRiderName("ryuki").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> FAIZ_CARD = ITEMS.register("faiz_card",
			() -> new RiderCardItem(new Item.Properties(),"","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.setSummonBelt((RiderDriverItem) FaizRiderItems.FAIZ_DRIVER.get()).addSummonWeapon(FaizRiderItems.FAIZ_EDGE.get())
					.IsBeltGlowing().isGlowing().addCompatibilityList(BaseDecadeUsers).changeRiderName("faiz").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> BLADE_ACE_CARD = ITEMS.register("blade_ace_card",
			() -> new RiderCardItem(new Item.Properties(),"","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.DARK_BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.setSummonBelt((RiderDriverItem) BladeRiderItems.BLAYBUCKLE.get()).addSummonWeapon(BladeRiderItems.BLAYROUZER.get())
					.IsBeltGlowing().isGlowing().addCompatibilityList(BaseDecadeUsers).changeRiderName("blade").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> HIBIKI_CARD = ITEMS.register("hibiki_card",
			() -> new RiderCardItem(new Item.Properties(),"","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.setSummonBelt((RiderDriverItem) HibikiRiderItems.HIBIKIDRIVER.get()).addSummonWeapon(HibikiRiderItems.ONGEKIBO_REKKA.get()).addSummonWeapon(HibikiRiderItems.ONGEKIBO_REKKA.get())
					.IsBeltGlowing().isGlowing().addCompatibilityList(BaseDecadeUsers).changeRiderName("hibiki").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> KABUTO_RIDER_CARD = ITEMS.register("kabuto_rider_card",
			() -> new RiderCardItem(new Item.Properties(),"","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 80, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 20, 0, 0, 0, 1);
				}
			}.setSummonBelt((RiderDriverItem) KabutoRiderItems.KABUTO_RIDER_BELT.get()).setSummonForm((RiderFormChangeItem) KabutoRiderItems.KABUTO_ZECTER.get())
					.addSummonWeapon(KabutoRiderItems.KABUTO_KUNAI.get()).isGlowing().addCompatibilityList(BaseDecadeUsers)
					.changeRiderName("kabuto").IsBeltGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DEN_O_SWORD_CARD = ITEMS.register("den_o_sword_card",
			() -> new RiderCardItem(new Item.Properties(),"","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.setSummonBelt((RiderDriverItem) DenORiderItems.DEN_O_BELT.get()).addSummonWeapon(DenORiderItems.DEN_GASHER_SWORD.get()).isGlowing()
					.IsBeltGlowing().addCompatibilityList(BaseDecadeUsers).changeRiderName("den_o").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));


	public static final DeferredItem<Item> KIVA_CARD = ITEMS.register("kiva_card",
			() -> new RiderCardItem(new Item.Properties(),"","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GLASS_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 200, 0, 0, 0, 1);
				}
			}.setSummonBelt((RiderDriverItem) KivaRiderItems.KIVAT_BELT.get()).isGlowing().IsBeltGlowing()
					.addCompatibilityList(BaseDecadeUsers).changeRiderName("kiva").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> W_CARD = ITEMS.register("w_card",
			() -> new RiderCardItem(new Item.Properties(),"_w","neo_decade","neo_decadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
				}
			}.setSummonBelt(0).changeModel("w_cyclone.geo.json").hasCape().changeRiderName("decade").isGlowing().IsBeltGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> OOO_CARD = ITEMS.register("ooo_card",
			() -> new RiderCardItem(new Item.Properties(),"_ooo","neo_decade","neo_decadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}.setSummonBelt(3).addSummonWeapon(2).changeModel("ooo_tora.geo.json").isGlowing().IsBeltGlowing().changeRiderName("decade").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> FOURZE_CARD = ITEMS.register("fourze_card",
			() -> new RiderCardItem(new Item.Properties(),"","neo_decade","neo_decadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE,
							player.getX(), player.getY()+0.5,
							player.getZ(), 100, 0, 0, 0, 0.05);
					((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 7, 0, 0, 0, 0.05);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 7, 0, 0, 0, 0.05);
					((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 7, 0, 0, 0, 0.05);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 7, 0, 0, 0, 0.05);
				}
			}.setSummonBelt(5).changeRiderName("fourze").isGlowing().IsBeltGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> WIZARD_CARD = ITEMS.register("wizard_card",
			() -> new RiderCardItem(new Item.Properties(),"","neo_decade","neo_decadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false))
					.setSummonBelt(7).addSummonWeapon(4).isGlowing().IsBeltGlowing().changeRiderName("wizard").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> GAIM_CARD = ITEMS.register("gaim_card",
			() -> new RiderCardItem(new Item.Properties(),"_gaim","neo_decade","neo_decadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
							player.getX(), player.getY() + 1,
							player.getZ(), 100, 0, 0, 0, 1);

				}
			}.setSummonBelt(9).addSummonWeapon(7).addSummonWeapon(6).changeRiderName("decade")
					.isGlowing().IsBeltGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DRIVE_CARD = ITEMS.register("drive_card",
			() -> new RiderCardItem(new Item.Properties(),"","neo_decade","neo_decadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 20, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.setSummonBelt(11).addSummonWeapon(9).changeModel("drive.geo.json").isGlowing().IsBeltGlowing().changeRiderName("drive").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> GHOST_CARD = ITEMS.register("ghost_card",
			() -> new RiderCardItem(new Item.Properties(),"_ghost","neo_decade","neo_decadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 70, 0, 0, 0, 1);
				}
			}.setSummonBelt(13).addSummonWeapon(11).isGlowing().IsBeltGlowing().changeRiderName("decade").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> EX_AID_CARD = ITEMS.register("ex_aid_card",
			() -> new RiderCardItem(new Item.Properties(),"","neo_decade","neo_decadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.setSummonBelt(15).setSummonForm(0).addSummonWeapon(13).isGlowing().IsBeltGlowing().changeRiderName("ex_aid").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> BUILD_CARD = ITEMS.register("build_card",
			() -> new RiderCardItem(new Item.Properties(),"_build","neo_decade","neo_decadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)){
    public void transformationEffect(ItemStack itemstack, LivingEntity player) {
        super.transformationEffect(itemstack, player);
        ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                player.getX(), player.getY()+1,
                player.getZ(), 100, 0, 0, 0, 1);
        ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                player.getX(), player.getY()+1,
                player.getZ(), 100, 0, 0, 0, 1);
    }
}.setSummonBelt(17).addSummonWeapon(15).isGlowing().IsBeltGlowing().changeRiderName("decade").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> ZI_O_CARD = ITEMS.register("zi_o_card",
			() -> new RiderCardItem(new Item.Properties(),"","neo_decade","neo_decadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.setSummonBelt(19).addSummonWeapon(17).isGlowing().IsBeltGlowing().changeRiderName("zi_o").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> ZERO_ONE_CARD = ITEMS.register("zero_one_card",
			() -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));
	/*
        public static final DeferredItem<Item> SABER_CARD = ITEMS.register("saber_card",
                () -> new BaseItem(new Item.Properties()).addToList(RiderTabs.DECADE_TAB_ITEM));

        public static final DeferredItem<Item> REVI_CARD = ITEMS.register("revi_card",
                () -> new BaseItem(new Item.Properties()).addToList(RiderTabs.DECADE_TAB_ITEM));

        public static final DeferredItem<Item> VICE_CARD = ITEMS.register("vice_card",
                () -> new BaseItem(new Item.Properties()).addToList(RiderTabs.DECADE_TAB_ITEM));

        public static final DeferredItem<Item> GEATS_CARD = ITEMS.register("geats_card",
                () -> new BaseItem(new Item.Properties()).addToList(RiderTabs.DECADE_TAB_ITEM));

        public static final DeferredItem<Item> GOTCHARD_CARD = ITEMS.register("gotchard_card",
                () -> new BaseItem(new Item.Properties()).addToList(RiderTabs.DECADE_TAB_ITEM));

        public static final DeferredItem<Item> GAVV_CARD = ITEMS.register("gavv_card",
                () -> new BaseItem(new Item.Properties()).addToList(RiderTabs.DECADE_TAB_ITEM));
    */
	public static final DeferredItem<Item> G3_CARD = ITEMS.register("g3_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem) AgitoRiderItems.G_BUCKLE_G3.get()).addSummonWeapon(AgitoRiderItems.GM_01_SCORPION.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> KNIGHT_CARD = ITEMS.register("knight_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem) RyukiRiderItems.KNIGHTDRIVER.get()).addSummonWeapon(RyukiRiderItems.WING_LANCER.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> SCISSORS_CARD = ITEMS.register("scissors_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem) RyukiRiderItems.SCISSORSDRIVER.get()).addSummonWeapon(RyukiRiderItems.SCISSORS_PINCH.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> RAIA_CARD = ITEMS.register("raia_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem) RyukiRiderItems.RAIADRIVER.get()).addSummonWeapon(RyukiRiderItems.EVIL_WHIP.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> GAI_CARD = ITEMS.register("gai_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem) RyukiRiderItems.GAIDRIVER.get()).addSummonWeapon(RyukiRiderItems.METAL_HORN.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> OUJA_CARD = ITEMS.register("ouja_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem) RyukiRiderItems.OUJADRIVER.get()).addSummonWeapon(RyukiRiderItems.VENO_SABER.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> FEMME_CARD = ITEMS.register("femme_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem) RyukiRiderItems.FEMMEDRIVER.get()).addSummonWeapon(RyukiRiderItems.WING_SLASHER.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> KAIXA_CARD = ITEMS.register("kaixa_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem) FaizRiderItems.KAIXA_DRIVER.get()).addSummonWeapon(FaizRiderItems.KAIXA_BLAYGUN.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DELTA_CARD = ITEMS.register("delta_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem) FaizRiderItems.DELTA_DRIVER.get()).addSummonWeapon(FaizRiderItems.DELTA_BLASTER.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> PSYGA_CARD = ITEMS.register("psyga_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem) FaizRiderItems.PSYGA_DRIVER.get()).addSummonWeapon(FaizRiderItems.PSYGA_TONFA_EDGE.get()).addSummonWeapon(FaizRiderItems.PSYGA_TONFA_EDGE.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> RIOTROOPER_CARD = ITEMS.register("riotrooper_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 3).setSummonBelt((RiderDriverItem) FaizRiderItems.SMARTBUCKLE.get()).addSummonWeapon(FaizRiderItems.AXEL_RAY_GUN.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> GARREN_CARD = ITEMS.register("garren_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem) BladeRiderItems.GARRENBUCKLE.get()).addSummonWeapon(BladeRiderItems.GARRENROUZER.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> IBUKI_CARD = ITEMS.register("ibuki_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem) HibikiRiderItems.IBUKIDRIVER.get()).addSummonWeapon(HibikiRiderItems.ONGEKIKAN_REPPUU.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> TODOROKI_CARD = ITEMS.register("todoroki_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem) HibikiRiderItems.TODOROKIDRIVER.get()).addSummonWeapon(HibikiRiderItems.ONGEKIGEN_RETSURAI.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> ZANKI_CARD = ITEMS.register("zanki_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem) HibikiRiderItems.ZANKIDRIVER.get()).addSummonWeapon(HibikiRiderItems.ONGEKI_SHINGEN_RETSUZAN.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> GATACK_CARD = ITEMS.register("gatack_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem) KabutoRiderItems.GATACK_RIDER_BELT.get()).setSummonForm((RiderFormChangeItem) KabutoRiderItems.GATACK_ZECTER.get()).addSummonWeapon(KabutoRiderItems.GATACK_DOUBLE_CALIBUR.get()).addSummonWeapon(KabutoRiderItems.GATACK_DOUBLE_CALIBUR_MINUS.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DRAKE_CARD = ITEMS.register("drake_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem) KabutoRiderItems.DRAKE_RIDER_BELT.get()).setSummonForm((RiderFormChangeItem) KabutoRiderItems.DRAKE_ZECTER.get()).addSummonWeapon(KabutoRiderItems.DRAKE_GLIP.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> SASWORD_CARD = ITEMS.register("sasword_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem) KabutoRiderItems.SASWORD_RIDER_BELT.get()).setSummonForm((RiderFormChangeItem) KabutoRiderItems.SASWORD_ZECTER.get()).addSummonWeapon(KabutoRiderItems.SASWORD_YAIVER.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> PUNCH_HOPPER_CARD = ITEMS.register("punchhopper_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem) KabutoRiderItems.PUNCHHOPPER_RIDER_BELT.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> HERCUS_CARD = ITEMS.register("hercus_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem) KabutoRiderItems.HERCUS_RIDER_BELT.get()).addSummonWeapon(KabutoRiderItems.ZECT_KUNAI.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> KETAROS_CARD = ITEMS.register("ketaros_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem) KabutoRiderItems.KETAROS_RIDER_BELT.get()).addSummonWeapon(KabutoRiderItems.ZECT_KUNAI_KUNAI.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> ZERONOS_CARD = ITEMS.register("zeronos_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem) DenORiderItems.ZERONOS_BELT.get()).addSummonWeapon(DenORiderItems.ZEROGASHER.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> IXA_CARD = ITEMS.register("ixa_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem) KivaRiderItems.IXA_BELT.get()).addSummonWeapon(KivaRiderItems.IXA_CALIBER.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> SAGA_CARD = ITEMS.register("saga_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem) KivaRiderItems.SAGARC_BELT.get()).addSummonWeapon(KivaRiderItems.JACORDER.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> REY_CARD = ITEMS.register("rey_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem) KivaRiderItems.REY_KIVAT_BELT.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> ACCEL_CARD = ITEMS.register("accel_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt(1).addSummonWeapon(1).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> BIRTH_CARD = ITEMS.register("birth_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt(4).addSummonWeapon(3).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> METEOR_CARD = ITEMS.register("meteor_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt(6).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> BEAST_CARD = ITEMS.register("beast_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt(8).addSummonWeapon(5).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> BARON_CARD = ITEMS.register("baron_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt(10).addSummonWeapon(8).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> MACH_CARD = ITEMS.register("mach_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt(12).addSummonWeapon(10).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> SPECTER_CARD = ITEMS.register("specter_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt(14).addSummonWeapon(12).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> BRAVE_CARD = ITEMS.register("brave_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt(16).setSummonForm(1).addSummonWeapon(14).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> CROSS_Z_CARD = ITEMS.register("cross_z_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt(18).addSummonWeapon(16).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> GEIZ_CARD = ITEMS.register("geiz_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt(20).addSummonWeapon(18).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> KUUGA_GROWING_AR = ITEMS.register("kuuga_growing_ar",
			() -> new RiderFormChangeItem(new Item.Properties(),"_growing_ar","kuuga","arcle_belt",
					new MobEffectInstance(MobEffects.WEAKNESS, 40, 2,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.IsBeltGlowing().isGlowing().has_basic_model().model_has_different_name("kuuga_growing_card"));

	public static final DeferredItem<Item> KUUGA_GROWING_CARD = ITEMS.register("kuuga_growing_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"_growing","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.WEAKNESS, 40, 2,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.addAlternative(KUUGA_GROWING_AR.get()).isGlowing().IsBeltGlowing().addCompatibilityList(BaseDecadeUsers).changeRiderName("kuuga").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> KUUGA_DRAGON_CARD = ITEMS.register("kuuga_dragon_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"_dragon","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().IsBeltGlowing().addCompatibilityList(BaseDecadeUsers).changeRiderName("kuuga").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> KUUGA_PEGASUS_CARD = ITEMS.register("kuuga_pegasus_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"_pegasus","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(EffectCore.RADAR, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().IsBeltGlowing().addCompatibilityList(BaseDecadeUsers).changeRiderName("kuuga").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> KUUGA_TITAN_CARD = ITEMS.register("kuuga_titan_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"_titan","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().IsBeltGlowing().addCompatibilityList(BaseDecadeUsers).changeRiderName("kuuga").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> KUUGA_RISING_MIGHTY_CARD = ITEMS.register("kuuga_rising_mighty_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"_rising_mighty","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(EffectCore.PUNCH, 40, 3,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().IsBeltGlowing().addCompatibilityList(BaseDecadeUsers).changeRiderName("kuuga").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> KUUGA_RISING_DRAGON_CARD = ITEMS.register("kuuga_rising_dragon_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"_rising_dragon","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().IsBeltGlowing().addCompatibilityList(BaseDecadeUsers).changeRiderName("kuuga").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> KUUGA_RISING_PEGASUS_CARD = ITEMS.register("kuuga_rising_pegasus_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"_rising_pegasus","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(EffectCore.RADAR, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().IsBeltGlowing().addCompatibilityList(BaseDecadeUsers).changeRiderName("kuuga").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> KUUGA_RISING_TITAN_CARD = ITEMS.register("kuuga_rising_titan_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"_rising_titan","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().IsBeltGlowing().addCompatibilityList(BaseDecadeUsers).changeRiderName("kuuga").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> KUUGA_AMAZING_MIGHTY_CARD = ITEMS.register("kuuga_amazing_mighty_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"_amazing_mighty","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(EffectCore.PUNCH, 40, 4,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
				}
			}.isGlowing().IsBeltGlowing().addCompatibilityList(BaseDecadeUsers).changeRiderName("kuuga").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));


	public static final DeferredItem<Item> AGITO_STORM_CARD = ITEMS.register("agito_storm_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"_storm","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().IsBeltGlowing().addCompatibilityList(BaseDecadeUsers).changeRiderName("agito").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> AGITO_FLAME_CARD = ITEMS.register("agito_flame_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"_flame","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().IsBeltGlowing().addCompatibilityList(BaseDecadeUsers).changeRiderName("agito").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> AGITO_TRINITY_CARD = ITEMS.register("agito_trinity_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"_trinity","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
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
			}.isGlowing().IsBeltGlowing().addCompatibilityList(BaseDecadeUsers).changeRiderName("agito").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> AGITO_BURNING_CARD = ITEMS.register("agito_burning_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"_burning","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 200, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().IsBeltGlowing().addCompatibilityList(BaseDecadeUsers).changeRiderName("agito").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));


	public static final DeferredItem<Item> RYUKI_BLANK_CARD = ITEMS.register("ryuki_blank_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"_blank","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.WEAKNESS, 40, 0,true,false))
					.isGlowing().IsBeltGlowing().addCompatibilityList(BaseDecadeUsers).changeRiderName("ryuki").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));


	public static final DeferredItem<Item> FAIZ_AXEL_CARD = ITEMS.register("faiz_axel_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"_axel","decade","decadriver_belt_faiz_axel",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 5,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().IsBeltGlowing().changeBeltModel("geo/belts/decadriver_belt_faiz_axel.geo.json").hasTimeout(400, 1200, (RiderFormChangeItem)DECADE_CARD.get()).addCompatibilityList(BaseDecadeUsers).changeRiderName("faiz").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));


	public static final DeferredItem<Item> BLADE_JACK_CARD = ITEMS.register("blade_jack_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"_jack","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.hasCape().isGlowing().IsBeltGlowing().addCompatibilityList(BaseDecadeUsers).changeRiderName("blade").hasFlyingWings("blade_jack_wing.geo.json").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));


	public static final DeferredItem<Item> HIBIKI_KURENAI_CARD = ITEMS.register("hibiki_kurenai_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"_kurenai","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.addCompatibilityList(BaseDecadeUsers).IsBeltGlowing().changeRiderName("hibiki").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));


	public static final DeferredItem<Item> KABUTO_MASKED_CARD = ITEMS.register("kabuto_masked_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"_masked","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 20, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 80, 0, 0, 0, 1);
				}
			}.isGlowing().IsBeltGlowing().addCompatibilityList(BaseDecadeUsers).changeRiderName("kabuto").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));


	public static final DeferredItem<Item> DEN_O_PLAT_CARD = ITEMS.register("den_o_plat_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"_plat","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.WEAKNESS, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
				}
			}.addCompatibilityList(BaseDecadeUsers).IsBeltGlowing().changeRiderName("den_o").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DEN_O_ROD_CARD = ITEMS.register("den_o_rod_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"_rod","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addCompatibilityList(BaseDecadeUsers).IsBeltGlowing().changeRiderName("den_o").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DEN_O_AX_CARD = ITEMS.register("den_o_ax_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"_axe","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.addCompatibilityList(BaseDecadeUsers).IsBeltGlowing().changeRiderName("den_o").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DEN_O_GUN_CARD = ITEMS.register("den_o_gun_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"_gun","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addCompatibilityList(BaseDecadeUsers).IsBeltGlowing().changeRiderName("den_o").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DEN_O_WING_CARD = ITEMS.register("den_o_wing_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"_wing","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.WEAKNESS, 40, 0,true,false),
					new MobEffectInstance(EffectCore.FLYING, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addCompatibilityList(BaseDecadeUsers).IsBeltGlowing().changeRiderName("den_o").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DEN_O_CLIMAX_CARD = ITEMS.register("den_o_climax_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"_climax","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 25, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 25, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 25, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 25, 0, 0, 0, 1);
				}
			}.isGlowing().addCompatibilityList(BaseDecadeUsers).IsBeltGlowing().changeRiderName("den_o").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));


	public static final DeferredItem<Item> KIVA_GARULU_CARD = ITEMS.register("kiva_garulu_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"_garulu","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.CHAIN_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addCompatibilityList(BaseDecadeUsers).IsBeltGlowing().changeRiderName("kiva").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> KIVA_BASSHAA_CARD = ITEMS.register("kiva_basshaa_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"_basshaa","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.CHAIN_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addCompatibilityList(BaseDecadeUsers).IsBeltGlowing().changeRiderName("kiva").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> KIVA_DOGGA_CARD = ITEMS.register("kiva_dogga_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"_dogga","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.CHAIN_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.PURPLE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.isGlowing().addCompatibilityList(BaseDecadeUsers).IsBeltGlowing().changeRiderName("kiva").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> KIVA_DOGABAKI_CARD = ITEMS.register("kiva_dogabaki_card",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"_dogabaki","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.HUNGER, 40, 0,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
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
			}.isGlowing().addCompatibilityList(BaseDecadeUsers).IsBeltGlowing().changeRiderName("kiva").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));


	public static final DeferredItem<Item> ICHIGO_CARD = ITEMS.register("ichigo_card",
			() -> new RiderCardItem(new Item.Properties(),"","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.setSummonBelt((RiderDriverItem) IchigoRiderItems.TYPHOON_ICHIGO.get()).IsBeltGlowing().addCompatibilityList(BaseDecadeUsers).isGlowing().changeRiderName("ichigo").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> NIGO_CARD = ITEMS.register("nigo_card",
			() -> new RiderCardItem(new Item.Properties(),"","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.setSummonBelt((RiderDriverItem) IchigoRiderItems.TYPHOON_NIGO.get()).IsBeltGlowing().addCompatibilityList(BaseDecadeUsers).isGlowing().changeRiderName("nigo").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> V3_CARD = ITEMS.register("v3_card",
			() -> new RiderCardItem(new Item.Properties(),"","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.setSummonBelt((RiderDriverItem)V3RiderItems.DOUBLE_TYPHOON.get()).IsBeltGlowing().addCompatibilityList(BaseDecadeUsers).isGlowing().changeRiderName("v3").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> RIDERMAN_CARD = ITEMS.register("riderman_card",
			() -> new RiderCardItem(new Item.Properties(),"","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.REGENERATION,200, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
				}
			}.setSummonBelt((RiderDriverItem) V3RiderItems.RIDERMAN_BELT.get()).IsBeltGlowing().addCompatibilityList(BaseDecadeUsers).isGlowing().setShowFace().changeRiderName("riderman").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> X_CARD = ITEMS.register("x_card",
			() -> new RiderCardItem(new Item.Properties(),"","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.REGENERATION,200, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 80, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 20, 0, 0, 0, 1);
				}
			}.setSummonBelt((RiderDriverItem)XRiderItems.RIDOL.get()).addSummonWeapon(XRiderItems.RIDOL_STICK.get())
					.IsBeltGlowing().isGlowing().addCompatibilityList(BaseDecadeUsers).changeRiderName("x").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> AMAZON_CARD = ITEMS.register("amazon_card",
			() -> new RiderCardItem(new Item.Properties(),"","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.REGENERATION,200, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY() + 1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.setSummonBelt((RiderDriverItem)AmazonRiderItems.CONDORER.get()).addCompatibilityList(BaseDecadeUsers)
					.IsBeltGlowing().isGlowing().changeRiderName("amazon").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> STRONGER_CARD = ITEMS.register("stronger_card",
			() -> new RiderCardItem(new Item.Properties(),"","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 80, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ParticleTypes.FIREWORK,
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.setSummonBelt((RiderDriverItem) StrongerRiderItems.ELECTRER.get()).addCompatibilityList(BaseDecadeUsers)
					.IsBeltGlowing().hasCape().isGlowing().changeRiderName("stronger").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> SKYRIDER_CARD = ITEMS.register("skyrider_card",
			() -> new RiderCardItem(new Item.Properties(),"","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 5,true,false),
					new MobEffectInstance(EffectCore.FLYING, 40, 4,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 34, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 34, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 34, 0, 0, 0, 1);
				}
			}.setSummonBelt((RiderDriverItem) SkyriderItems.TORNADO.get()).addCompatibilityList(BaseDecadeUsers)
					.IsBeltGlowing().hasCape().isGlowing().changeRiderName("skyrider").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> SUPER_1_CARD = ITEMS.register("super_1_card",
			() -> new ZeinRiderCardItem(new Item.Properties(),"","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 20, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 20, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.ORANGE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 20, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 20, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 20, 0, 0, 0, 1);
				}
			}.setSummonBelt((RiderDriverItem)Super1RiderItems.CYCLODE.get()).addCompatibilityList(BaseDecadeUsers)
					.IsBeltGlowing().hasCape().isGlowing().changeRiderName("super_1").addToList(ZEIN_CARDS).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> ZX_CARD = ITEMS.register("zx_card",
			() -> new RiderCardItem(new Item.Properties(),"","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.REGENERATION,200, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.setSummonBelt((RiderDriverItem)ZXRiderItems.ZX_BELT.get()).addCompatibilityList(BaseDecadeUsers)
					.IsBeltGlowing().isGlowing().changeRiderName("zx").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> BLACK_CARD = ITEMS.register("black_card",
			() -> new RiderCardItem(new Item.Properties(),"","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(EffectCore.PUNCH, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
				}
			}.setSummonBelt((RiderDriverItem)BlackRiderItems.VITAL_CHARGER.get()).addCompatibilityList(BaseDecadeUsers)
					.IsBeltGlowing().isGlowing().changeRiderName("black").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> BLACK_RX_CARD = ITEMS.register("black_rx_card",
			() -> new RiderCardItem(new Item.Properties(),"","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(EffectCore.PUNCH, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
				}
			}.setSummonBelt((RiderDriverItem)BlackRXRiderItems.SUN_RISER.get()).addCompatibilityList(BaseDecadeUsers)
					.IsBeltGlowing().isGlowing().changeRiderName("black_rx").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> SHIN_CARD = ITEMS.register("shin_card",
			() -> new RiderCardItem(new Item.Properties(),"","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(EffectCore.PUNCH, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.setSummonBelt((RiderDriverItem)ShinRiderItems.GRASSHOPPER_DNA.get()).changeModel("ichigo.geo.json").addCompatibilityList(BaseDecadeUsers)
					.IsBeltGlowing().isGlowing().changeRiderName("shin").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> ZO_CARD = ITEMS.register("zo_card",
			() -> new RiderCardItem(new Item.Properties(),"","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(EffectCore.PUNCH, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.setSummonBelt((RiderDriverItem)ZORiderItems.ZO_CORE.get()).addCompatibilityList(BaseDecadeUsers)
					.IsBeltGlowing().isGlowing().changeRiderName("zo").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> J_CARD = ITEMS.register("j_card",
			() -> new RiderCardItem(new Item.Properties(),"","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(EffectCore.PUNCH, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 100, 0, 0, 0, 1);
				}
			}.setSummonBelt((RiderDriverItem)JRiderItems.J_SPIRIT.get()).setSummonForm((RiderFormChangeItem)JRiderItems.J_STONE_JUMBO_FORMATION.get())
					.IsBeltGlowing().isGlowing().addCompatibilityList(BaseDecadeUsers).changeRiderName("j").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> BLACK_RX_ROBORIDER_CARD = ITEMS.register("black_rx_roborider_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"_robo","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
				}
			}.addCompatibilityList(BaseDecadeUsers).IsBeltGlowing().isGlowing().changeRiderName("black_rx").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> BLACK_RX_BIORIDER_CARD = ITEMS.register("black_rx_biorider_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"_bio","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.WATER_BREATHING,40, 0,true,false),
					new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 40, 1,true,false),
					new MobEffectInstance(EffectCore.PUNCH, 40, 1,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 50, 0, 0, 0, 1);
				}
			}.addCompatibilityList(BaseDecadeUsers).IsBeltGlowing().isGlowing().changeRiderName("black_rx").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> KUUGA_ULTIMATE_CARD = ITEMS.register("kuuga_ultimate_card",
			() -> ((ZeinCardItem) new ZeinCardItem(new Item.Properties().rarity(Rarity.RARE)).setSummonBelt((RiderDriverItem) KuugaRiderItems.ARCLE.get()).setSummonForm((RiderFormChangeItem) KuugaRiderItems.KUUGA_ULTIMATE.get()))
					.setZeinEffects(
							new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 9600, 3,true,true),
							new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 9600, 3,true,true),
							new MobEffectInstance(MobEffects.JUMP, 9600, 3,true,true),
							new MobEffectInstance(MobEffects.DAMAGE_BOOST, 9600, 4,true,true),
							new MobEffectInstance(EffectCore.PUNCH, 9600, 5,true,true),
							new MobEffectInstance(EffectCore.FIRE_ARMOR, 9600, 5,true,true)
					).addToList(ZEIN_CARDS).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> AGITO_SHINING_CARD = ITEMS.register("agito_shining_card",
			() -> ((ZeinCardItem) new ZeinCardItem(new Item.Properties().rarity(Rarity.RARE)).setSummonBelt((RiderDriverItem) AgitoRiderItems.ALTERING.get()).setSummonForm((RiderFormChangeItem) AgitoRiderItems.AGITO_SHINING.get()).addSummonWeapon(AgitoRiderItems.SHINING_CALIBER_TWIN.get()).addSummonWeapon(AgitoRiderItems.SHINING_CALIBER_TWIN.get()))
					.setZeinEffects(
						new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 9600, 3,true,true),
						new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 9600, 0,true,true),
						new MobEffectInstance(MobEffects.DAMAGE_BOOST, 9600, 4,true,true),
						new MobEffectInstance(MobEffects.JUMP, 9600, 3,true,true),
						new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 9600, 3,true,true)
					).setZeinItems("kamenridercraft:shining_caliber", "kamenridercraft:shining_caliber").addToList(ZEIN_CARDS).addToList(NEED_ITEM_STRONGEST_COMPLETE).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> RYUKI_SURVIVE_CARD = ITEMS.register("ryuki_survive_card",
			() -> ((ZeinCardItem) new ZeinCardItem(new Item.Properties().rarity(Rarity.RARE)).setSummonBelt((RiderDriverItem) RyukiRiderItems.RYUKIDRIVER.get()).setSummonForm((RiderFormChangeItem) RyukiRiderItems.SURVIVE_REKKA.get()).addSummonWeapon(RyukiRiderItems.DRAG_BLADE.get()))
					.setZeinEffects(
							new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 9600, 0,true,true),
							new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 9600, 1,true,true),
							new MobEffectInstance(MobEffects.DIG_SPEED, 9600, 1,true,true),
							new MobEffectInstance(MobEffects.DAMAGE_BOOST, 9600, 4,true,true),
							new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 9600, 2,true,true)
					).setZeinItems("kamenridercraft:drag_blade").addToList(ZEIN_CARDS).addToList(NEED_ITEM_STRONGEST_COMPLETE).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> FAIZ_BLASTER_CARD = ITEMS.register("faiz_blaster_card",
			() -> ((ZeinCardItem) new ZeinCardItem(new Item.Properties().rarity(Rarity.RARE)).setSummonBelt((RiderDriverItem) FaizRiderItems.FAIZ_DRIVER.get()).setSummonForm((RiderFormChangeItem) FaizRiderItems.FAIZ_BLASTER_MISSION_MEMORY.get()).addSummonWeapon(FaizRiderItems.FAIZ_BLASTER.get()))
					.setZeinEffects(
							new MobEffectInstance(MobEffects.DAMAGE_BOOST, 9600, 4,true,true),
							new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 9600, 3,true,true),
							new MobEffectInstance(MobEffects.DIG_SPEED, 9600, 3,true,true),
							new MobEffectInstance(MobEffects.JUMP, 9600, 3,true,true),
							new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 9600, 2,true,true),
							new MobEffectInstance(MobEffects.NIGHT_VISION, 9600, 0,true,true)
					).setZeinItems("kamenridercraft:faiz_blaster").addToList(ZEIN_CARDS).addToList(NEED_ITEM_STRONGEST_COMPLETE).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> BLADE_KING_CARD = ITEMS.register("blade_king_card",
			() -> ((ZeinCardItem) new ZeinCardItem(new Item.Properties().rarity(Rarity.RARE)).setSummonBelt((RiderDriverItem) BladeRiderItems.BLAYBUCKLE.get()).setSummonForm((RiderFormChangeItem) BladeRiderItems.EVOLUTION_CAUCASUS.get()).addSummonWeapon(BladeRiderItems.KINGROUZER.get()))
					.setZeinEffects(
							new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 9600, 3, true, true),
							new MobEffectInstance(MobEffects.JUMP, 9600, 2, true, true),
							new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 9600, 0, true, true),
							new MobEffectInstance(MobEffects.DAMAGE_BOOST, 9600, 4, true, true)
					).setZeinItems("kamenridercraft:kingrouzer").addToList(ZEIN_CARDS).addToList(NEED_ITEM_STRONGEST_COMPLETE).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> ARMED_HIBIKI_CARD = ITEMS.register("armed_hibiki_card",
			() -> ((ZeinCardItem) new ZeinCardItem(new Item.Properties().rarity(Rarity.RARE)).setSummonBelt((RiderDriverItem) HibikiRiderItems.HIBIKIDRIVER.get()).setSummonForm((RiderFormChangeItem) HibikiRiderItems.HENSHIN_ONSA_ARMED.get()).addSummonWeapon(HibikiRiderItems.ARMED_SABER.get()))
					.setZeinEffects(
							new MobEffectInstance(MobEffects.DAMAGE_BOOST, 9600, 2,true,true),
							new MobEffectInstance(MobEffects.DIG_SPEED, 9600, 3,true,true),
							new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 9600, 2,true,true),
							new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 9600, 1,true,true),
							new MobEffectInstance(MobEffects.REGENERATION, 9600, 0,true,true)
					).setZeinItems("kamenridercraft:armed_saber").addToList(ZEIN_CARDS).addToList(NEED_ITEM_STRONGEST_COMPLETE).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> KABUTO_HYPER_CARD = ITEMS.register("kabuto_hyper_card",
			() -> ((ZeinCardItem) new ZeinCardItem(new Item.Properties().rarity(Rarity.RARE)).setSummonBelt((RiderDriverItem) KabutoRiderItems.KABUTO_RIDER_BELT.get()).setSummonForm((RiderFormChangeItem) KabutoRiderItems.HYPER_ZECTER.get()).addSummonWeapon(KabutoRiderItems.PERFECT_ZECTER.get()))
					.setZeinEffects(
							new MobEffectInstance(MobEffects.DIG_SPEED, 9600, 3,true,true),
							new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 800, 30,true,true),
							new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 9600, 7,true,true),
							new MobEffectInstance(MobEffects.DAMAGE_BOOST, 9600, 4,true,true),
							new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 9600, 3,true,true),
							new MobEffectInstance(MobEffects.JUMP, 9600, 4,true,true),
							new MobEffectInstance(MobEffects.NIGHT_VISION, 9600, 0,true,true)
					).setZeinItems("kamenridercraft:perfect_zecter").addToList(ZEIN_CARDS).addToList(NEED_ITEM_STRONGEST_COMPLETE).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> DEN_O_LINER_CARD = ITEMS.register("den_o_liner_card",
			() -> ((ZeinCardItem) new ZeinCardItem(new Item.Properties().rarity(Rarity.RARE)).setSummonBelt((RiderDriverItem) DenORiderItems.DEN_O_BELT.get()).setSummonForm((RiderFormChangeItem) DenORiderItems.DEN_O_LINER_FORM.get()).addSummonWeapon(DenORiderItems.DENKAMEN_SWORD.get()))
					.setZeinEffects(
							new MobEffectInstance(MobEffects.DIG_SPEED, 9600, 2,true,true),
							new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 9600, 1,true,true),
							new MobEffectInstance(MobEffects.DAMAGE_BOOST, 9600, 3,true,true),
							new MobEffectInstance(MobEffects.JUMP, 9600, 1,true,true),
							new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 96040, 1,true,true),
							new MobEffectInstance(MobEffects.WEAKNESS, 9600, 0,true,true)
					).setZeinItems("kamenridercraft:denkamen_sword").addToList(ZEIN_CARDS).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> KIVA_EMPEROR_CARD = ITEMS.register("kiva_emperor_card",
			() -> ((ZeinCardItem) new ZeinCardItem(new Item.Properties().rarity(Rarity.RARE)).setSummonBelt((RiderDriverItem) KivaRiderItems.KIVAT_BELT.get()).setSummonForm((RiderFormChangeItem) KivaRiderItems.TATSULOT.get()).addSummonWeapon(KivaRiderItems.ZANVAT_SWORD.get()))
					.setZeinEffects(
							new MobEffectInstance(MobEffects.DAMAGE_BOOST, 9600, 2,true,true),
							new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 9600, 2,true,true),
							new MobEffectInstance(MobEffects.DIG_SPEED, 9600, 1,true,true),
							new MobEffectInstance(MobEffects.JUMP, 9600, 1,true,true),
							new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 9600, 2,true,true),
							new MobEffectInstance(MobEffects.REGENERATION, 9600, 1,true,true)
					).setZeinItems("kamenridercraft:zanbatsword").addToList(ZEIN_CARDS).addToList(NEED_ITEM_STRONGEST_COMPLETE).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> DECADE_COMPLETE_CARD = ITEMS.register("decade_complete_card",
			() -> new ZeinCardBaseItem(new Item.Properties().rarity(Rarity.RARE)).setZeinEffects(
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 9600, 4,true,true),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 9600, 2,true,true),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 9600, 2,true,true),
					new MobEffectInstance(MobEffects.DIG_SPEED, 9600, 2,true,true),
					new MobEffectInstance(MobEffects.JUMP, 9600, 2,true,true),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 49600, 0,true,true),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 9600, 0,true,true)
					).setZeinItems("kamenridercraft:ride_booker").addToList(ZEIN_CARDS).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> W_XTREME_CARD = ITEMS.register("w_xtreme_card",
			() -> ((ZeinCardItem) new ZeinCardItem(new Item.Properties().rarity(Rarity.RARE)).setSummonBelt(0).setSummonForm(0, 1).addSummonWeapon(0).addSummonWeapon(1))
					.setZeinEffects(
							new MobEffectInstance(MobEffects.DAMAGE_BOOST, 9600, 3,true,true),
							new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 9600, 2,true,true),
							new MobEffectInstance(MobEffects.DIG_SPEED, 9600, 1,true,true),
							new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 9600, 3,true,true),
							new MobEffectInstance(MobEffects.NIGHT_VISION, 9600, 0,true,true),
							new MobEffectInstance(EffectCore.PUNCH, 9600, 3,true,true)
					).setZeinItems("kamenridercraft:prism_bicker", "kamenridercraft:shield_prism_bicker").addToList(ZEIN_CARDS).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> OOO_PUTOTYRA_CARD = ITEMS.register("ooo_putotyra_card",
			() -> ((ZeinCardItem) new ZeinCardItem(new Item.Properties().rarity(Rarity.RARE)).setSummonBelt(3).setSummonForm(1, 1).addSummonWeapon(2))
					.setZeinEffects(
							new MobEffectInstance(MobEffects.JUMP, 9600, 2,true,true),
							new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 9600, 3,true,true),
							new MobEffectInstance(MobEffects.DAMAGE_BOOST, 9600, 2,true,true),
							new MobEffectInstance(EffectCore.FLYING, 9600, 0,true,true)
					).setZeinItems("kamenridercraft:medagaburyu").addToList(ZEIN_CARDS).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> FOURZE_COSMIC_CARD = ITEMS.register("fourze_cosmic_card",
			() -> ((ZeinCardItem) new ZeinCardItem(new Item.Properties().rarity(Rarity.RARE)).setSummonBelt(5).setSummonForm(2, 1).addSummonWeapon(3))
					.setZeinEffects(
							new MobEffectInstance(EffectCore.SLASH, 9600, 2,true,true),
							new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 9600, 2,true,true),
							new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 9600, 1,true,true),
							new MobEffectInstance(MobEffects.DAMAGE_BOOST, 9600, 3,true,true)
					).setZeinItems("kamenridercraft:barizun_sword").addToList(ZEIN_CARDS).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> WIZARD_INFINITY_CARD = ITEMS.register("wizard_infinity_card",
			() -> ((ZeinCardItem) new ZeinCardItem(new Item.Properties().rarity(Rarity.RARE)).setSummonBelt(7).setSummonForm(3, 1).addSummonWeapon(4))
					.setZeinEffects(
							new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 9600, 3,true,true)
							,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 9600, 0,true,true)
							,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 9600, 4,true,true)
							,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 9600, 3,true,true)
							,new MobEffectInstance(EffectCore.PUNCH, 9600, 5,true,true),
							new MobEffectInstance(MobEffects.NIGHT_VISION, 9600, 0,true,true)
					).setZeinItems("kamenridercraft:axcalibur").addToList(ZEIN_CARDS).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> GAIM_KIWAMI_CARD = ITEMS.register("gaim_kiwami_card",
			() -> ((ZeinCardItem) new ZeinCardItem(new Item.Properties().rarity(Rarity.RARE)).setSummonBelt(9).setSummonForm(4, 1))
					.setZeinEffects(
							new MobEffectInstance(MobEffects.NIGHT_VISION, 9600, 0,true,true),
							new MobEffectInstance(MobEffects.WATER_BREATHING, 9600, 0,true,true),
							new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 9600, 3,true,true),
							new MobEffectInstance(MobEffects.DAMAGE_BOOST, 9600, 2,true,true),
							new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 9600, 3,true,true),
							new MobEffectInstance(MobEffects.REGENERATION, 9600, 2,true,true),
							new MobEffectInstance(MobEffects.DIG_SPEED, 9600, 3,true,true),
							new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 9600, 0,true,true)
					).setZeinItems("kamenridercraft:dj_gun").addToList(ZEIN_CARDS).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> DRIVE_TRIDORON_CARD = ITEMS.register("drive_tridoron_card",
			() -> ((ZeinCardItem) new ZeinCardItem(new Item.Properties().rarity(Rarity.RARE)).setSummonBelt(11).setSummonForm(5, 1))
					.setZeinEffects(
							new MobEffectInstance(MobEffects.NIGHT_VISION, 9600, 0,true,true)
							,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 9600, 2,true,true)
							,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 9600, 4,true,true)
							,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 9600, 3,true,true)
							,new MobEffectInstance(MobEffects.JUMP, 9600, 3,true,true)
					).setZeinItems("kamenridercraft:trailer_hou").addToList(ZEIN_CARDS).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> GHOST_MUGEN_CARD = ITEMS.register("ghost_mugen_card",
			() -> ((ZeinCardItem) new ZeinCardItem(new Item.Properties().rarity(Rarity.RARE)).setSummonBelt(13).setSummonForm(6, 2).addSummonWeapon(16))
					.setZeinEffects(
						new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,true)
						,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 5,true,true)
						,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,true),
						new MobEffectInstance(EffectCore.GHOST, 40, 0,true,true)
					).setZeinItems("kamenridercraft:sunglasseslasher_sword").addToList(ZEIN_CARDS).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> EX_AID_MUTEKI_CARD = ITEMS.register("ex_aid_muteki_card",
			() -> ((ZeinCardItem) new ZeinCardItem(new Item.Properties().rarity(Rarity.RARE)).setSummonBelt(15).setSummonForm(7, 1).addSummonWeapon(17))
					.setZeinEffects(
							new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 9600, 3,true,true),
							new MobEffectInstance(MobEffects.DIG_SPEED, 9600, 4,true,true),
							new MobEffectInstance(MobEffects.DAMAGE_BOOST, 9600, 4,true,true),
							new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 9600, 6,true,true),
							new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 9600, 0,true,true),
							new MobEffectInstance(MobEffects.NIGHT_VISION, 9600, 0,true,true),
							new MobEffectInstance(MobEffects.SATURATION, 9600, 2,true,true),
							new MobEffectInstance(MobEffects.JUMP, 9600, 3,true,true),
							new MobEffectInstance(EffectCore.MUTEKI, 9600, 0,true,true)
					).addToList(ZEIN_CARDS).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> BUILD_GENIUS_CARD = ITEMS.register("build_genius_card",
			() -> ((ZeinCardItem) new ZeinCardItem(new Item.Properties().rarity(Rarity.RARE)).setSummonBelt(17).setSummonForm(8, 3).addSummonWeapon(18))
					.setZeinEffects(
							new MobEffectInstance(MobEffects.DAMAGE_BOOST, 9600, 3,true,true),
							new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 9600, 3,true,true),
							new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 9600, 3,true,true),
							new MobEffectInstance(MobEffects.REGENERATION, 9600, 1,true,true),
							new MobEffectInstance(MobEffects.DIG_SPEED, 9600, 3,true,true),
							new MobEffectInstance(MobEffects.JUMP, 9600, 4,true,true),
							new MobEffectInstance(MobEffects.NIGHT_VISION, 9600, 0,true,true),
							new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 9600, 0,true,true),
							new MobEffectInstance(MobEffects.WATER_BREATHING, 9600, 0,true,true),
							new MobEffectInstance(MobEffects.SATURATION, 9600, 0,true,true),
							new MobEffectInstance(EffectCore.FLYING, 9600, 0, true, true)
					).addToList(ZEIN_CARDS).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> GRAND_ZI_O_CARD = ITEMS.register("grand_zi_o_card",
			() -> ((GrandZiOCardItem) new GrandZiOCardItem(new Item.Properties().rarity(Rarity.RARE)).setSummonBelt(19).setSummonForm(9, 1).addSummonWeapon(19))
				.setZeinEffects(
					new MobEffectInstance(MobEffects.NIGHT_VISION, 9600, 0, true, true),
					new MobEffectInstance(MobEffects.WATER_BREATHING, 9600, 0, true, true),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 9600, 3, true, true),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 9600, 3, true, true),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 9600, 3, true, true),
					new MobEffectInstance(MobEffects.DIG_SPEED, 9600, 3, true, true),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 9600, 0, true, true),
					new MobEffectInstance(MobEffects.SATURATION, 9600, 0, true, true)
				).addToList(ZEIN_CARDS).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> ZERO_TWO_CARD = ITEMS.register("zero_two_card",
			() -> ((ZeinCardItem) new ZeinCardItem(new Item.Properties().rarity(Rarity.RARE)).setSummonBelt(21).addSummonWeapon(20))
					.setZeinEffects(
							new MobEffectInstance(MobEffects.JUMP, 9600, 6,true,true),
							new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 9600, 3,true,true),
							new MobEffectInstance(MobEffects.DAMAGE_BOOST, 9600, 4,true,true),
							new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 9600, 4,true,true),
							new MobEffectInstance(MobEffects.NIGHT_VISION, 9600, 0,true,true),
							new MobEffectInstance(MobEffects.DIG_SPEED, 9600, 3,true,true),
							new MobEffectInstance(EffectCore.PUNCH, 9600, 8,true,true),
							new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 9600, 0,true,true)
					).addToList(ZEIN_CARDS).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> XROSS_SABER_CARD = ITEMS.register("xross_saber_card",
			() -> new ZeinCardBaseItem(new Item.Properties().rarity(Rarity.RARE)).setZeinEffects(
						new MobEffectInstance(EffectCore.SLASH, 9600, 0,true,true)
						,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 9600, 4,true,true)
						,new MobEffectInstance(MobEffects.JUMP, 9600, 4,true,true)
						,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 9600, 5,true,true)
						,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 9600, 3,true,true)
						,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 9600, 0,true,true)
						,new MobEffectInstance(MobEffects.WATER_BREATHING, 9600, 0,true,true)
						,new MobEffectInstance(MobEffects.DIG_SPEED, 9600, 3,true,true)
					).setZeinItems("kamenridercraft:haouken_xross_saber").addToList(ZEIN_CARDS).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> ULTIMATE_REVI_CARD = ITEMS.register("ultimate_revi_card",
			() -> new ZeinCardBaseItem(new Item.Properties().rarity(Rarity.RARE)).setZeinEffects(
						new MobEffectInstance(MobEffects.JUMP, 40, 6,true,true),
						new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,true),
						new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,true),
						new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 5,true,true),
						new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,true),
						new MobEffectInstance(MobEffects.NIGHT_VISION, 40, 0,true,true),
						new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,true),
						new MobEffectInstance(EffectCore.PUNCH, 40, 8,true,true)
					).setZeinItems("kamenridercraft:revice_lasher").addToList(ZEIN_CARDS).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> ULTIMATE_VICE_CARD = ITEMS.register("ultimate_vice_card",
			() -> new UltimateViceCardItem(new Item.Properties().rarity(Rarity.RARE)).addToList(ZEIN_CARDS).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> GEATS_IX_CARD = ITEMS.register("geats_ix_card",
			() -> new ZeinCardBaseItem(new Item.Properties().rarity(Rarity.RARE)).setZeinEffects(
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 9600, 6,true,true),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 9600, 6,true,true),
					new MobEffectInstance(MobEffects.DIG_SPEED, 9600, 5,true,true),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 9600, 4,true,true),
					new MobEffectInstance(MobEffects.JUMP, 9600, 7,true,true),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 9600, 2,true,true),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 9600, 0,true,true),
					new MobEffectInstance(EffectCore.FIRE_PUNCH, 9600, 6,true,true),
					new MobEffectInstance(EffectCore.BOOST, 9600, 6,true,true)
					).setZeinItems("kamenridercraft:geats_buster_qb9").addToList(ZEIN_CARDS).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> KUUGA_RISING_ULTIMATE_CARD = ITEMS.register("kuuga_rising_ultimate_card",
			() -> new FinalKamenRideCardItem(new Item.Properties().rarity(Rarity.RARE)).setSummonBelt((RiderDriverItem) KuugaRiderItems.ARCLE.get()).setSummonForm((RiderFormChangeItem) KuugaRiderItems.KUUGA_RISING_ULTIMATE.get()).addToList(NEED_ITEM_STRONGEST_COMPLETE).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> DEN_O_CHOU_CLIMAX_CARD = ITEMS.register("den_o_chou_climax_card",
			() -> new FinalKamenRideCardItem(new Item.Properties().rarity(Rarity.RARE)).setSummonBelt((RiderDriverItem) DenORiderItems.DEN_O_BELT.get()).setSummonForm((RiderFormChangeItem) DenORiderItems.SUPER_KTAROS.get()).addSummonWeapon(DenORiderItems.DEN_GASHER_SWORD.get()).addToList(NEED_ITEM_STRONGEST_COMPLETE).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));
	/*
    public static final DeferredItem<Item> RAINBOW_GOTCHARD_CARD = ITEMS.register("rainbow_gotchard_card",
            () -> new BaseItem(new Item.Properties()).addToList(RiderTabs.DECADE_TAB_ITEM));
    */
	public static final DeferredItem<Item> G4_CARD = ITEMS.register("g4_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem) AgitoRiderItems.G_BUCKLE_G4.get()).addSummonWeapon(AgitoRiderItems.G4_GIGANT.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> RYUGA_CARD = ITEMS.register("ryuga_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem) RyukiRiderItems.RYUGADRIVER.get()).addSummonWeapon(RyukiRiderItems.DRAG_CLAW_RYUGA.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> ORGA_CARD = ITEMS.register("orga_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem) FaizRiderItems.ORGA_DRIVER.get()).addSummonWeapon(FaizRiderItems.ORGA_STLANZER.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> GLAIVE_CARD = ITEMS.register("glaive_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem) BladeRiderItems.GLAIVEBUCKLE.get()).addSummonWeapon(BladeRiderItems.GLAIVEROUZER.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> KABUKI_CARD = ITEMS.register("kabuki_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem) HibikiRiderItems.KABUKIDRIVER.get()).addSummonWeapon(HibikiRiderItems.ECHO_SWORD_ONSAKEN.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> CAUCASUS_CARD = ITEMS.register("caucasus_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem) KabutoRiderItems.CAUCASUS_RIDER_BELT.get()).addSummonWeapon(RiderBlocks.BLUE_ROSE.asItem()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> ARC_CARD = ITEMS.register("arc_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem) KivaRiderItems.ARC_KIVAT_BELT.get()).addSummonWeapon(KivaRiderItems.ARC_TRIDENT.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> SKULL_CARD = ITEMS.register("skull_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt(2).addSummonWeapon(0).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> EAGLE_UNDEAD_CARD = ITEMS.register("eagle_undead_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem) BladeRiderItems.UNDEAD_ROUZER.get()).setSummonForm((RiderFormChangeItem) BladeRiderItems.FUSION_EAGLE_UNDEAD.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> MOOSE_FANGIRE_CARD = ITEMS.register("moose_fangire_card",
			() -> new RiderSummonCardItem(new Item.Properties(), 1).setSummonBelt((RiderDriverItem) KivaRiderItems.MOOSE_FANGIRE_BELT.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));


	public static final DeferredItem<Item> COMPLETE_CARD_DECADE_21 = ITEMS.register("complete_card_decade_21",
			() -> new BaseItem(new Item.Properties().rarity(Rarity.UNCOMMON)).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> RIDE_PLAYER_CARD = ITEMS.register("rideplayer_card",
			() -> new RidePlayerCardItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));
	public static final DeferredItem<Item> DIMENSION_CARD = ITEMS.register("dimension_card",
			() -> new DimensionCardItem(new Item.Properties()).addToList(ZEIN_CARDS).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));


	public static final DeferredItem<Item> DECADE_OOO_CARD = ITEMS.register("decade_ooo_armor_card",
			() -> new RiderFormChangeItem(new Item.Properties(),"_ooo_armor","decade","decadriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
					new MobEffectInstance(EffectCore.FLYING, 40, 2,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.1);
				}
			}.hasStaticWings().isGlowing().addCompatibilityList(new String[] {"neo_decade"}).changeRiderName("decade")
					.IsBeltGlowing().has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));


	public static final DeferredItem<Item> KUUGA_BALL = ITEMS.register("kuuga_ball",
			() -> new RiderFormChangeItem(new Item.Properties(),"_ball","kuuga","blank",
					new MobEffectInstance(EffectCore.PUNCH, 40, 2,true,false)){
				public void transformationEffect(ItemStack itemstack, LivingEntity player) {
					super.transformationEffect(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
							player.getX(), player.getY(),
							player.getZ(), 200, 0, 0, 0, 1);
				}
			}.isBike().isGlowing().has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

    public static final DeferredItem<Item> CHALICE_FINAL_FORM_RIDE = ITEMS.register("final_form_ride_chalice_choco",
            () -> new RiderFormChangeItem(new Item.Properties(),"_final_form_ride","chalice","blank",
                    new MobEffectInstance(MobEffects.SATURATION, 40, 0,true,false)
            ,new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 2,true,false)
                    ,new MobEffectInstance(EffectCore.SMALL, 40, 5,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CHOCO_PARTICLES.get(),
                            player.getX(), player.getY(),
                            player.getZ(), 200, 0, 0, 0, 1);
                }
            }.hasCape().has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));


    public static final DeferredItem<Item> DECADEHELMET = ITEMS.register("decadehead",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM).changeRepairItem(BLANK_CARD.get()));
	public static final DeferredItem<Item> DECADECHESTPLATE = ITEMS.register("decadetroso",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM).changeRepairItem(BLANK_CARD.get()));
	public static final DeferredItem<Item> DECADELEGGINGS = ITEMS.register("decadelegs",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM).changeRepairItem(BLANK_CARD.get()));

	public static final DeferredItem<Item> DECADRIVER = ITEMS.register("decadriver",
			() -> new DecadriverItem(ArmorMaterials.DIAMOND,"decade",DECADE_CARD ,DECADEHELMET, DECADECHESTPLATE,DECADELEGGINGS , new Item.Properties())
					.addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM).changeRepairItem(BLANK_CARD.get()));

	public static final DeferredItem<Item> NEO_DECADRIVER = ITEMS.register("neo_decadriver",
			() -> new NeoDecadriverItem(ArmorMaterials.DIAMOND,"neo_decade",DECADE_CARD ,DECADEHELMET, DECADECHESTPLATE,DECADELEGGINGS , new Item.Properties().rarity(Rarity.UNCOMMON))
					.overrideBeltText("neo_decadriver_belt").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM).changeRepairItem(BLANK_CARD.get()));

	public static final DeferredItem<Item> DIEND_BELT= ITEMS.register("diend_belt",
			() -> new DiendBeltItem(ArmorMaterials.DIAMOND,"diend",DIEND_CARD ,DECADEHELMET, DECADECHESTPLATE,DECADELEGGINGS , new Item.Properties())
					.addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DARK_DECADRIVER = ITEMS.register("dark_decadriver",
			() -> new DecadriverItem(ArmorMaterials.DIAMOND,"dark_decade",DARK_DECADE_CARD ,DECADEHELMET, DECADECHESTPLATE,DECADELEGGINGS , new Item.Properties())
					.overrideBeltText("dark_decadriver_belt").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM).changeRepairItem(BLANK_CARD.get()));

	public static final DeferredItem<Item> RIDE_BOOKER = ITEMS.register("ride_booker",
			() -> new RideBookerItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).IsSwordGun().addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM)
					.changeRepairItem(BLANK_CARD.get()));

	public static final DeferredItem<Item> DIENDRIVER = ITEMS.register("diendriver",
			() -> new DiendriverItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).isHenshinItem(DIEND_BELT.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM).changeRepairItem(BLANK_CARD.get()));

	public static final DeferredItem<Item> NEO_DIENDRIVER = ITEMS.register("neo_diendriver",
			() -> new NeoDiendriverItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).isHenshinItem(DIEND_BELT.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM).changeRepairItem(BLANK_CARD.get()));

	public static final DeferredItem<Item> ONGEKIBO_REKKA_DECADE = ITEMS.register("ongekibo_rekka_decade",
			() -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM).changeRepairItem(BLANK_CARD.get()));

	public static final DeferredItem<Item> ONGEKIBO_REKKA_DIEND = ITEMS.register("ongekibo_rekka_diend",
			() -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM).changeRepairItem(BLANK_CARD.get()));

	public static final DeferredItem<Item> ONGEKIKANABO_OUJA = ITEMS.register("ongekikanabo_ouja",
			() -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM).changeRepairItem(RyukiRiderItems.ADVENT_CARD.get()));

	public static final DeferredItem<Item> DECADE_BAZOOKA = ITEMS.register("decade_bazooka",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM).changeRepairItem(BLANK_CARD.get()));

	public static final DeferredItem<Item> DECADE_BLAST_CARD = ITEMS.register("decade_blast_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"decade","decade_complete","decade_violent_emotion","decade_cyan","dark_decade","neo_decade_complete_21"})
					.addEffects(new MobEffectInstance(EffectCore.SHOT_BOOST, 300,2,true,false)).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item>DECADE_SLASH_CARD = ITEMS.register("decade_slash_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"decade","decade_complete","decade_violent_emotion","decade_cyan","dark_decade","neo_decade_complete_21"})
					.addEffects(new MobEffectInstance(EffectCore.SLASH, 300,2,true,false)).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DECADE_ILLUSION_CARD = ITEMS.register("decade_illusion_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"decade","decade_complete","decade_violent_emotion","decade_cyan","dark_decade","neo_decade_complete_21"})
					.addSpecial("illusion").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DECADE_INVISIBLE_CARD = ITEMS.register("decade_invisible_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"decade","decade_complete","decade_violent_emotion","decade_cyan","dark_decade","neo_decade_complete_21"})
					.addEffects(new MobEffectInstance(MobEffects.INVISIBILITY, 200,0,true,false)).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DIEND_BLAST_CARD = ITEMS.register("diend_blast_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"diend"})
					.addEffects(new MobEffectInstance(EffectCore.SHOT_BOOST, 300,2,true,false)).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DIEND_INVISIBLE_CARD = ITEMS.register("diend_invisible_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"diend"})
					.addEffects(new MobEffectInstance(MobEffects.INVISIBILITY, 200,0,true,false)).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DIEND_CROSSATTACK_CARD = ITEMS.register("diend_crossattack_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"diend"})
					.addSpecial("crossattack").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DIEND_BARRIER_CARD = ITEMS.register("diend_barrier_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"diend"})
					.addSpecial("barrier").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DIEND_ILLUSION_CARD = ITEMS.register("diend_illusion_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"diend"})
					.addSpecial("illusion").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DIEND_NEO_BLAST_CARD = ITEMS.register("diend_neo_blast_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"diend"})
					.addEffects(new MobEffectInstance(EffectCore.SHOT_BOOST, 300,2,true,false)).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DIEND_NEO_INVISIBLE_CARD = ITEMS.register("diend_neo_invisible_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"diend"})
					.addEffects(new MobEffectInstance(MobEffects.INVISIBILITY, 200,0,true,false)).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DIEND_NEO_CROSSATTACK_CARD = ITEMS.register("diend_neo_crossattack_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"diend"})
					.addSpecial("crossattack").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DIEND_NEO_BARRIER_CARD = ITEMS.register("diend_neo_barrier_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"diend"})
					.addSpecial("barrier").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DIEND_NEO_ILLUSION_CARD = ITEMS.register("diend_neo_illusion_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"diend"})
					.addSpecial("illusion").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> REKKA_DAIZANTOU_CARD = ITEMS.register("rekka_daizantou_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"decade","decade_complete","decade_violent_emotion","decade_cyan","neo_decade_complete_21"})
					.addSpecial("rekka_daizantou").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> G4_GIGANT_CARD = ITEMS.register("g4_gigant_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"decade_violent_emotion"})
					.addItem(AgitoRiderItems.G4_GIGANT.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> RYUKI_STRIKE_VENT_CARD = ITEMS.register("ryuki_strike_vent_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"ryuki","decade_violent_emotion"})
					.addItem(RyukiRiderItems.DRAG_CLAW.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> BLADE_METAL_CARD = ITEMS.register("blade_metal_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"blade","decade_violent_emotion"})
					.addEffects(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 300,1,true,false)).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> BLADE_MACH_CARD = ITEMS.register("blade_mach_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"blade","decade_violent_emotion"})
					.addEffects(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300,3,true,false),
							new MobEffectInstance(MobEffects.DIG_SPEED, 300,3,true,false)).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> HIBIKI_ONGEKIBOU_REKKA_CARD = ITEMS.register("hibiki_ongekibou_rekka_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"hibiki","decade_violent_emotion"})
					.addItem(HibikiRiderItems.ONGEKIBO_REKKA.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> HIBIKI_ONIBI_CARD = ITEMS.register("hibiki_onibi_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"hibiki","decade_violent_emotion"})
					.addSpecial("onibi").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> KABUTO_CLOCK_UP_CARD = ITEMS.register("kabuto_clock_up_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"kabuto","decade_violent_emotion"})
					.addEffects(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 250,20,true,false)).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DEN_O_ORE_SANJOU_CARD = ITEMS.register("den_o_ore_sanjou_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"den_o","den_o_rod","den_o_axe","den_o_gun","den_o_wing","den_o_climax","decade_violent_emotion"})
					.addSpecial("ore_sanjou").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DEN_O_BOKU_NI_TSURARETE_MIRU_CARD = ITEMS.register("den_o_bokuni_tsurarete_miru_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"den_o","den_o_rod","den_o_axe","den_o_gun","den_o_wing","den_o_climax","decade_violent_emotion"})
					.addSpecial("bokuni_tsurarete_miru").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DEN_O_NAKERUDE_CARD = ITEMS.register("den_o_nakerude_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"den_o","den_o_rod","den_o_axe","den_o_gun","den_o_wing","den_o_climax","decade_violent_emotion"})
					.addSpecial("nakerude").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DEN_O_KOTAE_WA_KIITENAI_CARD = ITEMS.register("den_o_kotaewa_kiite_nai_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"den_o","den_o_rod","den_o_axe","den_o_gun","den_o_wing","den_o_climax","decade_violent_emotion"})
					.addSpecial("kotaewa_kiite_nai").addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DEN_O_TSUPPARI_CARD = ITEMS.register("den_o_tsuppari_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"den_o_axe","decade_violent_emotion"})
					.addEffects(new MobEffectInstance(EffectCore.PUNCH, 300,1,true,false)).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> DEN_O_UTCHARI_CARD = ITEMS.register("den_o_utchari_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"den_o_axe","decade_violent_emotion"})
					.addEffects(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300,2,true,false),
							new MobEffectInstance(MobEffects.JUMP, 300,3,true,false)).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> AMAZON_GAGA_NO_UDEWA_CARD = ITEMS.register("amazon_gaga_no_udewa_card",
			() -> new AttackRideCardItem(new Item.Properties(), new String[]{"amazon","decade_complete","decade_violent_emotion","neo_decade_complete_21"})
					.addItem(AmazonRiderItems.GAGA_ARMLET.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static final DeferredItem<Item> GACKT_CARD = ITEMS.register("gackt_card",
			() -> new BaseItem(new Item.Properties()).KeepItem().has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.DECADE_TAB_ITEM));

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}

}