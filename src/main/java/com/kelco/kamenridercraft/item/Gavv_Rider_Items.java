package com.kelco.kamenridercraft.item;

import com.kelco.kamenridercraft.KamenRiderCraftCore;

import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.item.BaseItems.*;
import com.kelco.kamenridercraft.item.gavv.*;
import com.kelco.kamenridercraft.item.tabs.RiderTabs;

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

public class Gavv_Rider_Items {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);

	public static List<Item> GUMMY= new ArrayList<Item>();
	public static List<Item> SNACK= new ArrayList<Item>();
	public static List<Item> MARSHMALLOW= new ArrayList<Item>();
	public static List<Item> CHOCO= new ArrayList<Item>();
	public static List<Item> CANDY= new ArrayList<Item>();
	public static List<Item> CAKE= new ArrayList<Item>();
	public static List<Item> COOKIE= new ArrayList<Item>();
	public static List<Item> PANCAKE= new ArrayList<Item>();
	public static List<Item> MOCHI= new ArrayList<Item>();
	public static List<Item> PUDDING= new ArrayList<Item>();
	public static List<Item> CORN= new ArrayList<Item>();
	public static List<Item> COFFEE= new ArrayList<Item>();
	public static List<Item> ALA_MODE= new ArrayList<Item>();
	public static List<Item> ICE_CREAM= new ArrayList<Item>();

	public static List<Item> NEED_ITEM_KICKIN_PUNCHIN= new ArrayList<Item>();

	public static final DeferredItem<Item> GAVV_LOGO = ITEMS.register("gavv_logo",
			() -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/gavv")), new Item.Properties()).AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> BLANK_GOCHIZO = ITEMS.register("blank_gochizo",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> PROTOTYPE_CUP_GOCHIZO = ITEMS.register("prototype_cup_gochizo",
			() -> new BaseItem(new Item.Properties()).has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> HEATPRESS = ITEMS.register("heatpress",
			() -> new HitpressItem(new Item.Properties()).has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> GRANUTE_TOOTH = ITEMS.register("granute_tooth",
			() -> new BaseItem(new Item.Properties()).has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> POPPINGUMMY_GOCHIZO = ITEMS.register("poppingummy_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","gavv","henshin_belt_gavv_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GUMMI_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 34, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GUMMI_PARTICLES2.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 34, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GUMMI_PARTICLES3.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 34, 0, 0, 0, 1);
				}
			}.IsGlowing().AddToList(GUMMY,3).AddToList(RiderTabs.GAVV_TAB_ITEM));

    public static final DeferredItem<Item> KICKINGUMMY_PUNCHINGUMMY_GOCHIZO_VALEN = ITEMS.register("kickingummy_punchingummy_gochizo_valen",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_kickin_punchin","valen_frappe_custom","vrastumgear_belt_frappe",
                    new MobEffectInstance(Effect_core.PUNCH, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(Effect_core.BLIZZARD, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GUMMI_PARTICLES2.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 34, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GUMMI_PARTICLES3.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 34, 0, 0, 0, 1);
                }
            }.IsGlowing().AddNeedItemList(NEED_ITEM_KICKIN_PUNCHIN).model_has_different_name("poppingummy_gochizo").has_basic_model());

    public static final DeferredItem<Item> KICKINGUMMY_PUNCHINGUMMY_GOCHIZO = ITEMS.register("kickingummy_punchingummy_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_kickin_punchin","gavv","henshin_belt_gavv_belt_kickin",
					new MobEffectInstance(Effect_core.PUNCH, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GUMMI_PARTICLES2.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 34, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GUMMI_PARTICLES3.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 34, 0, 0, 0, 1);
				}
			}.IsGlowing().addAlternative(KICKINGUMMY_PUNCHINGUMMY_GOCHIZO_VALEN.get()).AddNeedItemList(NEED_ITEM_KICKIN_PUNCHIN).model_has_different_name("poppingummy_gochizo").has_basic_model());


    public static final DeferredItem<Item> PUNCHINGUMMY_GOCHIZO_VALEN = ITEMS.register("punchingummy_gochizo_valen",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_punchin","valen_frappe_custom","vrastumgear_belt_frappe",
                    new MobEffectInstance(Effect_core.PUNCH, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(Effect_core.BLIZZARD, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GUMMI_PARTICLES2.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 34, 0, 0, 0, 1);
                }
            }.IsGlowing().model_has_different_name("punchingummy_gochizo").has_basic_model());

    public static final DeferredItem<Item> PUNCHINGUMMY_GOCHIZO = ITEMS.register("punchingummy_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_punchin","gavv","henshin_belt_gavv_belt_punchin",
					new MobEffectInstance(Effect_core.PUNCH, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)) {
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GUMMI_PARTICLES2.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 34, 0, 0, 0, 1);
				}
			}.IsGlowing().addAlternative(PUNCHINGUMMY_GOCHIZO_VALEN.get()).addShiftForm(KICKINGUMMY_PUNCHINGUMMY_GOCHIZO.get())
					.AddToList(NEED_ITEM_KICKIN_PUNCHIN).AddToList(GUMMY,1).AddToList(RiderTabs.GAVV_TAB_ITEM));

    public static final DeferredItem<Item> KICKINGUMMY_GOCHIZO_VALEN = ITEMS.register("kickingummy_gochizo_valen",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_kickin","valen_frappe_custom","vrastumgear_belt_frappe",
                    new MobEffectInstance(Effect_core.PUNCH, 40, 3,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(Effect_core.BLIZZARD, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GUMMI_PARTICLES3.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 34, 0, 0, 0, 1);
                }
            }.IsGlowing().model_has_different_name("kickingummy_gochizo").has_basic_model());

    public static final DeferredItem<Item> KICKINGUMMY_GOCHIZO = ITEMS.register("kickingummy_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_kickin","gavv","henshin_belt_gavv_belt_kickin",
                    new MobEffectInstance(Effect_core.PUNCH, 40, 3,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GUMMI_PARTICLES3.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 34, 0, 0, 0, 1);
                }
            }.IsGlowing().addAlternative(KICKINGUMMY_GOCHIZO_VALEN.get()).addShiftForm(KICKINGUMMY_PUNCHINGUMMY_GOCHIZO.get()).AddToList(NEED_ITEM_KICKIN_PUNCHIN)
                    .AddToList(GUMMY,1).AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> FISHINGGUMMY_GOCHIZO = ITEMS.register("tsurigummy_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_fishingummy","gavv","henshin_belt_gavv_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)
					,new MobEffectInstance(Effect_core.FISH, 40, 0,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GUMMI_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 34, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GUMMI_PARTICLES2.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 34, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ModParticles.GUMMI_PARTICLES3.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 34, 0, 0, 0, 1);
				}
			}.IsGlowing().AddToList(GUMMY,1).has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> ZAKUZAKUCHIPS_GOCHIZO = ITEMS.register("zakuzakuchips_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_zakuzaku_chips","gavv","henshin_belt_gavv_belt_zakuzaku",
					new MobEffectInstance(Effect_core.SLASH, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.SNACK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 40, 0, 0, 0, 1);
				}
			}.IsGlowing().AddToList(SNACK,5).AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> HIRIHIRICHIPS_GOCHIZO = ITEMS.register("hirihirichips_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_zakuzaku_chips","gavv","henshin_belt_gavv_belt_hirihiri",
					new MobEffectInstance(Effect_core.FIRE_SLASH, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.SNACK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 40, 0, 0, 0, 1);
					((ServerLevel) player.level()).sendParticles(ParticleTypes.FLAME,
							player.getX(), player.getY()+1,
							player.getZ(), 30, 0, 0, 0, 0.2);
				}
			}.IsGlowing().AddToList(SNACK,3).AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> FUWAMALLOW_GOCHIZO = ITEMS.register("fuwamallow_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_fuwamallow","gavv","henshin_belt_gavv_belt_fuwamallow",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
                    .IsGlowing().AddToList(MARSHMALLOW,5).AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> MARUMALLOW_GOCHIZO = ITEMS.register("marumallow_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_fuwamallow","gavv","henshin_belt_gavv_belt_marumallow",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(Effect_core.BIG, 40, 0,true,false))
                    .IsGlowing().ChangeModel("gavv_marumallow.geo.json").AddToList(MARSHMALLOW,2).AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> CHOCODAN_GOCHIZO = ITEMS.register("chocodan_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_chocodan","gavv","henshin_belt_gavv_belt_chocodan",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(Effect_core.SHOT_BOOST, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CHOCO_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 40, 0, 0, 0, 1);
                }
            }.IsGlowing().AddToList(CHOCO,9).AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> CHOCODON_GOCHIZO = ITEMS.register("chocodon_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","valen","valenbuckle_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(Effect_core.SHOT_BOOST, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CHOCO_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 40, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREY_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 40, 0, 0, 0, 1);
                }
            }.IsGlowing().AddToList(CHOCO,9).AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> CHOCOLD_GOCHIZO = ITEMS.register("chocold_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_chocold","valen","valenbuckle_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.WITHER, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CHOCO_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 40, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 40, 0, 0, 0, 1);
                }
            }.IsGlowing().has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    public static final DeferredItem<Item> GURUCAN_GOCHIZO_VALEN = ITEMS.register("gurucan_gochizo_valen",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"_gurucan","valen_frappe_custom","vrastumgear_belt_frappe",
                    new MobEffectInstance(Effect_core.GRAVITY, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 1,true,false),
                    new MobEffectInstance(Effect_core.BLIZZARD, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CANDY_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 20, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CANDY_PARTICLES2.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 20, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CANDY_PARTICLES3.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 20, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CANDY_PARTICLES4.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 20, 0, 0, 0, 1);
                }
            }.IsGlowing().model_has_different_name("gurucan_gochizo").has_basic_model());

	public static final DeferredItem<Item> GURUCAN_GOCHIZO = ITEMS.register("gurucan_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_gurucan","gavv","henshin_belt_gavv_belt_gurucan",
					new MobEffectInstance(Effect_core.BIG, 40, 0,true,false)
					,new MobEffectInstance(Effect_core.GRAVITY, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 1,true,false)) {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CANDY_PARTICLES.get(),
                            player.getX(), player.getY() + 2,
                            player.getZ(), 20, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CANDY_PARTICLES2.get(),
                            player.getX(), player.getY() + 2,
                            player.getZ(), 20, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CANDY_PARTICLES3.get(),
                            player.getX(), player.getY() + 2,
                            player.getZ(), 20, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CANDY_PARTICLES4.get(),
                            player.getX(), player.getY() + 2,
                            player.getZ(), 20, 0, 0, 0, 1);
                }
            }.IsGlowing().addAlternative(GURUCAN_GOCHIZO_VALEN.get()).AddToList(CANDY,5).AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> VROCAN_GOCHIZO = ITEMS.register("vrocan_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_gurucan","do_not_work","henshin_belt_gavv_belt")
                    .IsGlowing().AddToList(CANDY,1).AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> BAKUCAN_GOCHIZO = ITEMS.register("bakucan_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_bakucan","gavv","henshin_belt_gavv_belt_bakucan",
					new MobEffectInstance(Effect_core.BIG, 40, 0,true,false)
					,new MobEffectInstance(Effect_core.GRAVITY, 40, 0,true,false)
					,new MobEffectInstance(Effect_core.CANNON, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CANDY_PARTICLES.get(),
                            player.getX(), player.getY() + 2,
                            player.getZ(), 20, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CANDY_PARTICLES2.get(),
                            player.getX(), player.getY() + 2,
                            player.getZ(), 20, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CANDY_PARTICLES3.get(),
                            player.getX(), player.getY() + 2,
                            player.getZ(), 20, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CANDY_PARTICLES4.get(),
                            player.getX(), player.getY() + 2,
                            player.getZ(), 20, 0, 0, 0, 1);
                }
            }.IsGlowing().AddToList(CANDY,1).AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> PARTEA_GOCHIZO = ITEMS.register("partea_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_partea","gavv","henshin_belt_gavv_belt_partea",
					new MobEffectInstance(Effect_core.PUNCH, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false))
                    .IsGlowing().has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> BUSHEL_GOCHIZO = ITEMS.register("bushel_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_bushel","valen","henshin_belt_gavv_belt_bushel",
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)
					,new MobEffectInstance(Effect_core.EXPLOSION_SLASH, 40, 0,true,false)
					,new MobEffectInstance(Effect_core.CHRISTMAS, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsGlowing().AddToList(CAKE,5).AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> KUNGFU_RAMEN_GOCHIZO = ITEMS.register("kungfu_ramen_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_shieldsnack","gavv","henshin_belt_gavv_belt_shieldsnack",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(Effect_core.PUNCH, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.SNACK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 40, 0, 0, 0, 1);
                }
            }.IsGlowing().has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> CHOCO_TREASURE_GOCHIZO = ITEMS.register("choco_treasure_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_shieldsnack","gavv","henshin_belt_gavv_belt_choco_treasure",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(Effect_core.PUNCH, 40, 2,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.SNACK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 40, 0, 0, 0, 1);

                    ((ServerLevel) player.level()).sendParticles(ModParticles.CHOCO_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 40, 0, 0, 0, 1);
                }
            }.IsGlowing().addNeedForm(KUNGFU_RAMEN_GOCHIZO.get()).has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> UMAIBO_GOCHIZO = ITEMS.register("umaibo_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_shot_snack","gavv","henshin_belt_gavv_belt_shot_snack",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(Effect_core.PUNCH, 40, 2,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.SNACK_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 40, 0, 0, 0, 1);
				}
			}.IsGlowing().ChangeAnimation("default_cape.animation.json").has_basic_model().AddToList(CORN,3).AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> CAKING_GOCHIZO = ITEMS.register("caking_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_caking","gavv","henshin_belt_gavv_belt_caking",
					new MobEffectInstance(MobEffects.HUNGER, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 10, 0, 0, 0, 1);
                }
            }.IsGlowing().AddToList(CAKE,1).AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> BLIZZARDSORBEI_GOCHIZO = ITEMS.register("blizzardsorbei_gochizo",
			() -> new BlizzardsorbeiItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_blizzardsorbet","gavv","henshin_belt_gavv_belt_blizzardsorbet",
					new MobEffectInstance(Effect_core.BLIZZARD, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 40, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 40, 0, 0, 0, 1);
                }
            }.IsGlowing().AddToList(ICE_CREAM,1).AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> GOCHIPOD_MASTER = ITEMS.register("gochipod_master",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_master","gavv","henshin_belt_gavv_belt_master",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 6,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GUMMI_PARTICLES.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 300, 0, 0, 0, 1);
				}
			}.IsGlowing());


	public static final DeferredItem<Item> GOCHIPOD = ITEMS.register("gochipod",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"_over","gavv","henshin_belt_gavv_belt_over",
					new MobEffectInstance(Effect_core.PUNCH, 40, 6,true,false),
					new MobEffectInstance(Effect_core.EXPLOSION_PUNCH, 40, 0,true,false),
					new MobEffectInstance(Effect_core.GRAVITY, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ModParticles.GUMMI_PARTICLES3.get(),
							player.getX(), player.getY()+1,
							player.getZ(), 300, 0, 0, 0, 1);
				}
			}.IsGlowing().addSwitchForm(GOCHIPOD_MASTER.get()).AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> GOCHIPOD_EMPTY = ITEMS.register("gochipod_empty",
			() -> new GochipodItem(new Item.Properties())
					.has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));



	public static final DeferredItem<Item> AMAZINGGUMMY = ITEMS.register("amazingummy_gochizo", // TODO: Effects not copy-pasted from Over
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"_amazingummy","gavv","henshin_belt_gavv_belt_amazingummy",
					new MobEffectInstance(Effect_core.PUNCH, 40, 6,true,false),
					new MobEffectInstance(Effect_core.EXPLOSION_PUNCH, 40, 0,true,false),
					new MobEffectInstance(Effect_core.GRAVITY, 40, 0,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
				public void OnTransformation(ItemStack itemstack, LivingEntity player) {
					super.OnTransformation(itemstack, player);
					((ServerLevel) player.level()).sendParticles(ParticleTypes.FLAME,
							player.getX(), player.getY()+1,
							player.getZ(), 300, 0, 0, 0, 0.2);
				}
			}.IsGlowing().has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));


	public static final DeferredItem<Item> DOUMARU_GOCHIZO = ITEMS.register("doumaru_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_doumaru","valen","valenbuckle_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CHOCO_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 40, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 10, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 10, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 10, 0, 0, 0, 1);
                }
            }.IsGlowing().AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> FRAPPEIS_GOCHIZO = ITEMS.register("frappeis_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"","valen_frappe_custom","vrastumgear_belt_frappe",
					new MobEffectInstance(Effect_core.BLIZZARD, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false))
                    .IsGlowing().has_basic_model().AddToList(COFFEE,3).AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> DOPPUDDING_GOCHIZO = ITEMS.register("doppudding_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","vram","vrastumgear_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false))
                    .IsGlowing().has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> PURUJELLY_GOCHIZO = ITEMS.register("purujelly_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_jelly","vram","vrastumgear_belt_jelly",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
					,new MobEffectInstance(Effect_core.STEALTH, 40, 1,true,false))
                    .IsGlowing().has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> PUDDINTE_GOCHIZO = ITEMS.register("puddinte_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),0,"_a_la_mode","vram","vrastumgear_belt_mode",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false))
                    .IsGlowing().has_basic_model().AddToList(ALA_MODE,3).AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> SHOUMA_DOPPUDDING_GOCHIZO = ITEMS.register("shouma_doppudding_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","vrastumgear_belt")
                    .IsGlowing().AddToList(PUDDING,3).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> PRUJELLY_GOCHIZO = ITEMS.register("prujelly_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","vrastumgear_belt")
                    .IsGlowing().AddToList(PUDDING,1).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> SPARKINGUMMY_GOCHIZO = ITEMS.register("sparkingummy_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","bitter_gavv","henshin_belt_bitter_gavv_belt",
					new MobEffectInstance(MobEffects.REGENERATION, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false))
                    .IsGlowing().AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> BREACOOKIE_GOCHIZO = ITEMS.register("breacookie_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_cookie","bitter_gavv","henshin_belt_bitter_gavv_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false))
                    .IsGlowing().AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> BAKIBAKISTICK_GOCHIZO = ITEMS.register("bakibakistick_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"bakibaki","bitter_gavv","henshin_belt_bitter_gavv_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
                    .IsGlowing().AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> MARBLEBREACOOKIE_GOCHIZO = ITEMS.register("marble_breacookie_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_marblebreacookie","bitter_gavv","henshin_belt_bitter_gavv_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false))
                    .IsGlowing().AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());


	public static final DeferredItem<Item> VROCANSPICY_GOCHIZO = ITEMS.register("vrocanspicy_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_bitter_gavv_belt")
                    .IsGlowing().AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> TERROR_GOCHIZO = ITEMS.register("terror_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","caries","henshin_belt_caries_gavv_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false))
                    .IsGlowing().has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));


	public static final DeferredItem<Item> COOKIEKIE_GOCHIZO = ITEMS.register("cookiekie_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_cookiekie","do_not_work","valenbuckle_belt")
					.AddToList(COOKIE,5).AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> BYUNBEI_GOCHIZO = ITEMS.register("byunbei_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_byunbei","do_not_work","valenbuckle_belt")
					.AddToList(COOKIE,4).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> ELEGANMACARON_GOCHIZO = ITEMS.register("eleganmacaron_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_eleganmacaron","do_not_work","valenbuckle_belt")
					.AddToList(COOKIE,4).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> CARAMELMEL_GOCHIZO = ITEMS.register("caramelmel_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_caramelmel","do_not_work","valenbuckle_belt")
					.AddToList(CANDY,2).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> POPBURN_GOCHIZO = ITEMS.register("popburn_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_popburn","do_not_work","valenbuckle_belt")
					.AddToList(CORN,3).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> OSHIRUKO_GOCHIZO = ITEMS.register("oshiruko_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_oshiruko","do_not_work","valenbuckle_belt")
					.AddToList(MARSHMALLOW,1).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> BUBBLERAMUNE_GOCHIZO = ITEMS.register("bubbleramune_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_bubbleramune","do_not_work","valenbuckle_belt")
					.AddToList(CANDY,2).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> BUBBLERAMUNEPEACH_GOCHIZO = ITEMS.register("bubbleramune_gochizo_peach",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_bubbleramune_peach","do_not_work","valenbuckle_belt")
					.AddToList(CANDY,2).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> WAFUSAKU_GOCHIZO = ITEMS.register("wafusaku_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_wafusaku","do_not_work","valenbuckle_belt")
					.AddToList(PANCAKE,2).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> MOFUPACHI_GOCHIZO = ITEMS.register("mofupachi_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_mofupachi","do_not_work","valenbuckle_belt")
					.AddToList(CANDY,2).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> HAGIGORO_GOCHIZO = ITEMS.register("hagigoro_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_hagigoro","do_not_work","valenbuckle_belt")
					.AddToList(MOCHI,2).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> HOTCAKEN_GOCHIZO = ITEMS.register("hotcaken_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_hotcaken","do_not_work","valenbuckle_belt")
					.AddToList(PANCAKE,2).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> CREPUNA_GOCHIZO = ITEMS.register("crepuna_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_crepuna","do_not_work","valenbuckle_belt")
					.AddToList(PANCAKE,2).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> AMONDCOKIKKIE_GOCHIZO = ITEMS.register("amondcokikkie_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_amondcokikkie","do_not_work","valenbuckle_belt")
					.AddToList(COOKIE,2).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> DORANOSUKE_GOCHIZO = ITEMS.register("doranosuke_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_doranosuke","do_not_work","valenbuckle_belt")
					.AddToList(PANCAKE,2).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> MITARAMOTTI_GOCHIZO = ITEMS.register("mitaramotti_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_mitaramotti","do_not_work","valenbuckle_belt")
					.AddToList(MOCHI,2).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> MOGIMARU_GOCHIZO = ITEMS.register("mogimaru_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_mogimaru","do_not_work","valenbuckle_belt")
					.AddToList(MOCHI,2).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> MORIAGARAMUNE_GOCHIZO = ITEMS.register("morinagaramune_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_morinagaramune","do_not_work","valenbuckle_belt")
					.AddToList(CANDY,1).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> ANGELPIE_GOCHIZO = ITEMS.register("angelpie_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_angelpie","do_not_work","valenbuckle_belt")
					.AddToList(MARSHMALLOW,1).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> ARTCANDY_GOCHIZO = ITEMS.register("artcandy_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_artcandy","do_not_work","valenbuckle_belt")
					.AddToList(CANDY,1).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> BONCHIAGE_GOCHIZO = ITEMS.register("bonchiage_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_bonchiage","do_not_work","valenbuckle_belt")
					.AddToList(SNACK,1).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> CHOCOBALL_GOCHIZO = ITEMS.register("chocoball_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_chocoball","do_not_work","valenbuckle_belt")
					.AddToList(CHOCO,1).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> CHOCOPIE_GOCHIZO = ITEMS.register("chocopie_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_chocopie","do_not_work","valenbuckle_belt")
					.AddToList(COOKIE,1).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> CRUNKY_GOCHIZO = ITEMS.register("crunky_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_crunky","do_not_work","valenbuckle_belt")
					.AddToList(CHOCO,1).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> CUSTARDCAKE_GOCHIZO = ITEMS.register("custardcake_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_custardcake","do_not_work","valenbuckle_belt")
					.AddToList(CAKE,1).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> GHANA_GOCHIZO = ITEMS.register("ghana_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_ghana","do_not_work","valenbuckle_belt")
					.AddToList(CHOCO,1).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> HAPPYTURN_GOCHIZO = ITEMS.register("happyturn_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_happyturn","do_not_work","valenbuckle_belt")
					.AddToList(SNACK,1).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> HICHEW_GOCHIZO = ITEMS.register("hichew_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_hichew","do_not_work","valenbuckle_belt")
					.AddToList(GUMMY,1).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> KOALAMARCH_GOCHIZO = ITEMS.register("koalamarch_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_koalamarch","do_not_work","valenbuckle_belt")
					.AddToList(COOKIE,1).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> MEITOALPHABET_GOCHIZO = ITEMS.register("meitoalphabet_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_meitoalphabet","do_not_work","valenbuckle_belt")
					.AddToList(CHOCO,1).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> MOONLIGHTCOOKIE_GOCHIZO = ITEMS.register("moonlightcookie_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_moonlight","do_not_work","valenbuckle_belt")
					.AddToList(COOKIE,1).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> OTTOTTO_GOCHIZO = ITEMS.register("ottotto_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_ottotto","do_not_work","valenbuckle_belt")
					.AddToList(SNACK,1).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> PIENOMI_GOCHIZO = ITEMS.register("pienomi_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_pienomi","do_not_work","valenbuckle_belt")
					.AddToList(COOKIE,1).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> PEANUTAGE_GOCHIZO = ITEMS.register("peanutage_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_peanutage","do_not_work","valenbuckle_belt")
					.AddToList(SNACK,1).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> PUKUPUKUTAI_GOCHIZO = ITEMS.register("pukupukutai_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_pukupukutai","do_not_work","valenbuckle_belt")
					.AddToList(COOKIE,1).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> TARAKOMENTAIKO_GOCHIZO = ITEMS.register("tarakomentaiko_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_tarakomentaiko","do_not_work","valenbuckle_belt")
					.AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> TOPPO_GOCHIZO = ITEMS.register("toppo_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_toppo","do_not_work","valenbuckle_belt")
					.AddToList(COOKIE,1).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> TIROLCHOCOLATE_GOCHIZO = ITEMS.register("tirolchocolate_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_tirolchocolate","do_not_work","valenbuckle_belt")
					.AddToList(CHOCO,1).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> TIROLCHOCOLATE_GOCHIZO_VARIETY = ITEMS.register("tirolchocolate_gochizo_variety",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_tirolchocolate","valen","henshin_belt_gavv_belt_chocodan",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(Effect_core.SHOT_BOOST, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CHOCO_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 40, 0, 0, 0, 1);
                }
            }.IsGlowing().AddToList(CHOCO,2).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> STRAWBERRYJELLYTIROL_GOCHIZO = ITEMS.register("strawberryjellytirol_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_strawberryjellytirol","do_not_work","valenbuckle_belt")
					.AddToList(CHOCO,1).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> NOUGATTIROL_GOCHIZO = ITEMS.register("nougattirol_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_nougattirol","do_not_work","valenbuckle_belt")
					.AddToList(CHOCO,1).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> MILKTIROL_GOCHIZO = ITEMS.register("milktirol_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_milktirol","do_not_work","valenbuckle_belt")
					.AddToList(CHOCO,1).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> BISPINKTIROL_GOCHIZO = ITEMS.register("bispinktirol_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_bispinktirol","do_not_work","valenbuckle_belt")
					.AddToList(CHOCO,1).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> WHITEANDCOOKIESTIROL_GOCHIZO = ITEMS.register("whiteandcookiestirol_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_whiteandcookiestirol","do_not_work","valenbuckle_belt")
					.AddToList(CHOCO,1).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> CRUNCHTIROL_GOCHIZO = ITEMS.register("crunchtirol_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_crunchtirol","do_not_work","valenbuckle_belt")
					.AddToList(CHOCO,1).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> ALMONDTIROL_GOCHIZO = ITEMS.register("almondtirol_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_almondtirol","do_not_work","valenbuckle_belt")
					.AddToList(CHOCO,1).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> BISBLUETIROL_GOCHIZO = ITEMS.register("bisbluetirol_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_bisbluetirol","do_not_work","valenbuckle_belt")
					.AddToList(CHOCO,1).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> TERIYAKI_UMAIBO_GOCHIZO = ITEMS.register("teriyaki_umaibo_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_umaibo","do_not_work","valenbuckle_belt")
					.AddToList(CORN,1).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> SALAD_UMAIBO_GOCHIZO = ITEMS.register("salad_umaibo_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_umaibo","do_not_work","valenbuckle_belt")
					.AddToList(CORN,1).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> TONKATSU_UMAIBO_GOCHIZO = ITEMS.register("tonkatsu_umaibo_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_umaibo","do_not_work","valenbuckle_belt")
					.AddToList(CORN,1).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> POTAGE_UMAIBO_GOCHIZO = ITEMS.register("potage_umaibo_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_umaibo","do_not_work","valenbuckle_belt")
					.AddToList(CORN,1).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> NATTO_UMAIBO_GOCHIZO = ITEMS.register("natto_umaibo_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_umaibo","do_not_work","valenbuckle_belt")
					.AddToList(CORN,1).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> SALAMI_UMAIBO_GOCHIZO = ITEMS.register("salami_umaibo_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_umaibo","do_not_work","valenbuckle_belt")
					.AddToList(CORN,1).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> TAKOYAKI_UMAIBO_GOCHIZO = ITEMS.register("takoyaki_umaibo_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_umaibo","do_not_work","valenbuckle_belt")
					.AddToList(CORN,1).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> MENTAIKO_UMAIBO_GOCHIZO = ITEMS.register("mentaiko_umaibo_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_umaibo","do_not_work","valenbuckle_belt")
					.AddToList(CORN,1).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> CHARAPAKI_GOCHIZO = ITEMS.register("charapaki_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_charapaki","gavv","henshin_belt_gavv_belt_charapaki",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(Effect_core.SHOT_BOOST, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CHOCO_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 40, 0, 0, 0, 1);
                }
            }.IsGlowing().AddToList(CHOCO,3).AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> CHARAPAKI_GOCHIZO_SPECIAL = ITEMS.register("charapaki_gochizo_special",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_charapaki_special","gavv","henshin_belt_gavv_belt_charapaki_special",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(Effect_core.SHOT_BOOST, 40, 0,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.CHOCO_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 40, 0, 0, 0, 1);
                }
            }.IsGlowing().AddToList(CHOCO,3).AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> POPPINGUMMY_GOCHIZO_CHARADECO = ITEMS.register("poppingummy_gochizo_charadeco_ver",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
					.AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> MERRYCHRISTMAS_GOCHIZO = ITEMS.register("merrychristmas_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_merrychristmas","do_not_work","valenbuckle_belt")
					.AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

	public static final DeferredItem<Item> KAMENRIDERGUMMY_GOCHIZO = ITEMS.register("kamenridergummy_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_kamenridergummy","do_not_work","valenbuckle_belt")
					.AddToList(GUMMY,2).AddToList(RiderTabs.GAVV_TAB_ITEM).has_basic_model());

    public static final DeferredItem<Item> ZEZTZ_GOCHIZO = ITEMS.register("zeztz_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    public static final DeferredItem<Item> GAVV_GOCHIZO = ITEMS.register("gavv_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    public static final DeferredItem<Item> VALEN_GOCHIZO = ITEMS.register("valen_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    public static final DeferredItem<Item> VRAM_GOCHIZO = ITEMS.register("vram_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    public static final DeferredItem<Item> GOTCHARD_GOCHIZO = ITEMS.register("gotchard_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    public static final DeferredItem<Item> GEATS_GOCHIZO = ITEMS.register("geats_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    public static final DeferredItem<Item> REVI_GOCHIZO = ITEMS.register("revi_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    public static final DeferredItem<Item> VICE_GOCHIZO = ITEMS.register("vice_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    public static final DeferredItem<Item> SABER_GOCHIZO = ITEMS.register("saber_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    public static final DeferredItem<Item> ZERO_ONE_GOCHIZO = ITEMS.register("zero_one_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    public static final DeferredItem<Item> ZI_O_GOCHIZO = ITEMS.register("zi_o_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    public static final DeferredItem<Item> BUILD_GOCHIZO = ITEMS.register("build_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    public static final DeferredItem<Item> EX_AID_GOCHIZO = ITEMS.register("ex_aid_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    public static final DeferredItem<Item> GHOST_GOCHIZO = ITEMS.register("ghost_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    public static final DeferredItem<Item> DRIVE_GOCHIZO = ITEMS.register("drive_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    public static final DeferredItem<Item> GAIM_GOCHIZO = ITEMS.register("gaim_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    public static final DeferredItem<Item> WIZARD_GOCHIZO = ITEMS.register("wizard_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    public static final DeferredItem<Item> FOURZE_GOCHIZO = ITEMS.register("fourze_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    public static final DeferredItem<Item> OOO_GOCHIZO = ITEMS.register("ooo_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    public static final DeferredItem<Item> W_GOCHIZO = ITEMS.register("w_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    public static final DeferredItem<Item> DECADE_GOCHIZO = ITEMS.register("decade_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    public static final DeferredItem<Item> KIVA_GOCHIZO = ITEMS.register("kiva_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    public static final DeferredItem<Item> DEN_O_GOCHIZO = ITEMS.register("den_o_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    public static final DeferredItem<Item> KABUTO_GOCHIZO = ITEMS.register("kabuto_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    public static final DeferredItem<Item> HIBIKI_GOCHIZO = ITEMS.register("hibiki_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    public static final DeferredItem<Item> BLADE_GOCHIZO = ITEMS.register("blade_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    public static final DeferredItem<Item> FAIZ_GOCHIZO = ITEMS.register("faiz_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    public static final DeferredItem<Item> RYUKI_GOCHIZO = ITEMS.register("ryuki_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    public static final DeferredItem<Item> AGITO_GOCHIZO = ITEMS.register("agito_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    public static final DeferredItem<Item> KUUGA_GOCHIZO = ITEMS.register("kuuga_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    public static final DeferredItem<Item> J_GOCHIZO = ITEMS.register("j_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    public static final DeferredItem<Item> ZO_GOCHIZO = ITEMS.register("zo_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    public static final DeferredItem<Item> SHIN_GOCHIZO = ITEMS.register("shin_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    public static final DeferredItem<Item> BLACK_RX_GOCHIZO = ITEMS.register("black_rx_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    static final DeferredItem<Item> SHADOWMOON_GOCHIZO = ITEMS.register("shadowmoon_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    static final DeferredItem<Item> BLACK_GOCHIZO = ITEMS.register("black_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    static final DeferredItem<Item> ZX_GOCHIZO = ITEMS.register("zx_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    static final DeferredItem<Item> SUPER_1_GOCHIZO = ITEMS.register("super_1_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    static final DeferredItem<Item> SKYRIDER_GOCHIZO = ITEMS.register("skyrider_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    static final DeferredItem<Item> STRONGER_GOCHIZO = ITEMS.register("stronger_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    static final DeferredItem<Item> AMAZON_GOCHIZO = ITEMS.register("amazon_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    static final DeferredItem<Item> X_GOCHIZO = ITEMS.register("x_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    static final DeferredItem<Item> RIDERMAN_GOCHIZO = ITEMS.register("riderman_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    static final DeferredItem<Item> V3_GOCHIZO = ITEMS.register("v3_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    static final DeferredItem<Item> NIGO_GOCHIZO = ITEMS.register("nigo_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    static final DeferredItem<Item> ICHIGO_GOCHIZO = ITEMS.register("ichigo_gochizo",
            () -> new RiderFormChangeItem(new Item.Properties(),0,"","do_not_work","henshin_belt_gavv_belt")
                    .has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

    public static final DeferredItem<Item> BOONBOOMGER_GOCHIZO = ITEMS.register("boonboomger_gochizo",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_boonboomger","gavv","henshin_belt_gavv_belt_boonboomger",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
                    .IsGlowing().AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> JEEB_MIMIC_KEY = ITEMS.register("jeeb_mimic_key",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","jeeb","blank",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)
					,new MobEffectInstance(Effect_core.SLASH, 40, 0,true,false))
					.has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> SHIITA_MIMIC_KEY = ITEMS.register("shiita_mimic_key",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","shiita","blank",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0,true,false)
					,new MobEffectInstance(Effect_core.SHOT_BOOST, 40, 0,true,false))
					.has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> NYELV_MIMIC_KEY = ITEMS.register("nyelv_mimic_key",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","nyelv","blank",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)
					,new MobEffectInstance(Effect_core.RIDER_POISON_HAND, 40, 1,true,false))
					.has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> GLOTTA_MIMIC_KEY = ITEMS.register("glotta_mimic_key",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","glotta","blank",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
					,new MobEffectInstance(Effect_core.SLASH, 40, 1,true,false))
					.has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> LANGO_MIMIC_KEY = ITEMS.register("lango_mimic_key",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","lango","blank",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false)
					,new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false)
					,new MobEffectInstance(Effect_core.EXPLOSION_SLASH, 40, 1,true,false))
					.has_basic_model().AddToList(RiderTabs.GAVV_TAB_ITEM));

	public static final DeferredItem<Item> GAVV_HELMET = ITEMS.register("gavv_head",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.GAVV_TAB_ITEM)
					.ChangeRepairItem(BLANK_GOCHIZO.get()));
	public static final DeferredItem<Item> GAVV_CHESTPLATE = ITEMS.register("gavv_troso",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.GAVV_TAB_ITEM)
					.ChangeRepairItem(BLANK_GOCHIZO.get()));
	public static final DeferredItem<Item> GAVV_LEGGINGS = ITEMS.register("gavv_legs",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.GAVV_TAB_ITEM)
					.ChangeRepairItem(BLANK_GOCHIZO.get()));

	public static final DeferredItem<Item> HENSHIN_BELT_GAVV = ITEMS.register("henshin_belt_gavv",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"gavv",POPPINGUMMY_GOCHIZO ,GAVV_HELMET,GAVV_CHESTPLATE,GAVV_LEGGINGS , new Item.Properties())
			.AddToTabList(RiderTabs.GAVV_TAB_ITEM).ChangeRepairItem(BLANK_GOCHIZO.get()));


	public static final DeferredItem<Item> VALENBUCKLE = ITEMS.register("valenbuckle",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"valen",CHOCODON_GOCHIZO ,GAVV_HELMET,GAVV_CHESTPLATE,GAVV_LEGGINGS , new Item.Properties())
					.Override_belt_text("valenbuckle_belt").AddToTabList(RiderTabs.GAVV_TAB_ITEM).ChangeRepairItem(BLANK_GOCHIZO.get()));

	public static final DeferredItem<Item> VRASTUMGEAR_VALEN = ITEMS.register("vrastumgear_valen",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"valen_frappe_custom",FRAPPEIS_GOCHIZO ,GAVV_HELMET,GAVV_CHESTPLATE,GAVV_LEGGINGS , new Item.Properties().rarity(Rarity.UNCOMMON))
					.has_basic_model().AddToTabList(RiderTabs.GAVV_TAB_ITEM).ChangeRepairItem(BLANK_GOCHIZO.get()));

	public static final DeferredItem<Item> VRASTUMGEAR = ITEMS.register("vrastumgear",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"vram",DOPPUDDING_GOCHIZO ,GAVV_HELMET,GAVV_CHESTPLATE,GAVV_LEGGINGS , new Item.Properties())
					.has_basic_model().AddToTabList(RiderTabs.GAVV_TAB_ITEM).ChangeRepairItem(BLANK_GOCHIZO.get()));

	public static final DeferredItem<Item> HENSHIN_BELT_BITTER_GAVV = ITEMS.register("henshin_belt_bitter_gavv",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"bitter_gavv",SPARKINGUMMY_GOCHIZO ,GAVV_HELMET,GAVV_CHESTPLATE,GAVV_LEGGINGS , new Item.Properties())
					.AddToTabList(RiderTabs.GAVV_TAB_ITEM).ChangeRepairItem(BLANK_GOCHIZO.get()).has_basic_model());

	public static final DeferredItem<Item> BAKEBUCKLE = ITEMS.register("bakebuckle",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"bake",BREACOOKIE_GOCHIZO ,GAVV_HELMET,GAVV_CHESTPLATE,GAVV_LEGGINGS , new Item.Properties())
					.Override_belt_text("bakebuckle_belt").AddToTabList(RiderTabs.GAVV_TAB_ITEM).ChangeRepairItem(BLANK_GOCHIZO.get()));

	public static final DeferredItem<Item> HENSHIN_BELT_CARIES_GAVV = ITEMS.register("henshin_belt_caries_gavv",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"caries",TERROR_GOCHIZO ,GAVV_HELMET,GAVV_CHESTPLATE,GAVV_LEGGINGS , new Item.Properties())
					.Dont_show_belt_form_info().has_basic_model().AddToTabList(RiderTabs.GAVV_TAB_ITEM).ChangeRepairItem(BLANK_GOCHIZO.get()));

	public static final DeferredItem<Item> JEEB_MIMICDEVISER = ITEMS.register("jeeb_mimicdeviser",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"jeeb",JEEB_MIMIC_KEY ,GAVV_HELMET,GAVV_CHESTPLATE,GAVV_LEGGINGS , new Item.Properties())
					.Dont_show_belt_form_info().AddToTabList(RiderTabs.GAVV_TAB_ITEM).ChangeRepairItem(BLANK_GOCHIZO.get()));

	public static final DeferredItem<Item> SHIITA_MIMICDEVISER = ITEMS.register("shiita_mimicdeviser",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"shiita",SHIITA_MIMIC_KEY ,GAVV_HELMET,GAVV_CHESTPLATE,GAVV_LEGGINGS , new Item.Properties())
					.Dont_show_belt_form_info().AddToTabList(RiderTabs.GAVV_TAB_ITEM).ChangeRepairItem(BLANK_GOCHIZO.get()));

	public static final DeferredItem<Item> NYELV_MIMICDEVISER = ITEMS.register("nyelv_mimicdeviser",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"nyelv",NYELV_MIMIC_KEY ,GAVV_HELMET,GAVV_CHESTPLATE,GAVV_LEGGINGS , new Item.Properties())
					.Dont_show_belt_form_info().AddToTabList(RiderTabs.GAVV_TAB_ITEM).ChangeRepairItem(BLANK_GOCHIZO.get()));

	public static final DeferredItem<Item> GLOTTA_MIMICDEVISER = ITEMS.register("glotta_mimicdeviser",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"glotta",GLOTTA_MIMIC_KEY ,GAVV_HELMET,GAVV_CHESTPLATE,GAVV_LEGGINGS , new Item.Properties())
					.Dont_show_belt_form_info().AddToTabList(RiderTabs.GAVV_TAB_ITEM).ChangeRepairItem(BLANK_GOCHIZO.get()));

	public static final DeferredItem<Item> LANGO_MIMICDEVISER = ITEMS.register("lango_mimicdeviser",
			() -> new RiderDriverItem(ArmorMaterials.DIAMOND,"lango",LANGO_MIMIC_KEY ,GAVV_HELMET,GAVV_CHESTPLATE,GAVV_LEGGINGS , new Item.Properties())
					.Dont_show_belt_form_info().AddToTabList(RiderTabs.GAVV_TAB_ITEM).ChangeRepairItem(BLANK_GOCHIZO.get()));

	public static final DeferredItem<Item> GAVVGABLADE = ITEMS.register("gavvgablade",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GAVV_TAB_ITEM)
					.ChangeRepairItem(BLANK_GOCHIZO.get()));

	public static final DeferredItem<Item> ZAKUZAKUCHIPSLASHER = ITEMS.register("zakuzakuchipslasher",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GAVV_TAB_ITEM)
					.ChangeRepairItem(BLANK_GOCHIZO.get()));

	public static final DeferredItem<Item> CHOCODANGUN = ITEMS.register("chocodangun",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GAVV_TAB_ITEM)
					.ChangeRepairItem(BLANK_GOCHIZO.get()));

	public static final DeferredItem<Item> CHOCODONGUN = ITEMS.register("chocodongun",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GAVV_TAB_ITEM)
					.ChangeRepairItem(BLANK_GOCHIZO.get()));

	public static final DeferredItem<Item> XMAX_GAVV = ITEMS.register("xmax_gavv",
			() -> new BaseSwordItem(Tiers.DIAMOND, 7, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GAVV_TAB_ITEM).ChangeRepairItem(BLANK_GOCHIZO.get()));

	public static final DeferredItem<Item> SHIELD_SNACK_SHIELD = ITEMS.register("shield_snack_shield",
			() -> new BaseShieldItem(new Item.Properties()).AddToTabList(RiderTabs.GAVV_TAB_ITEM).ChangeRepairItem(BLANK_GOCHIZO.get()));

	public static final DeferredItem<Item> SHIELD_SNACK_CHOCO_SHIELD = ITEMS.register("shield_snack_shield_choco",
			() -> new BaseShieldItem(new Item.Properties()).AddToTabList(RiderTabs.GAVV_TAB_ITEM).ChangeRepairItem(BLANK_GOCHIZO.get()));

	public static final DeferredItem<Item> GAVVWHIPIR = ITEMS.register("gavvwhipir",
			() -> new GavvwhipirItem(Tiers.DIAMOND, 7, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).AddToTabList(RiderTabs.GAVV_TAB_ITEM)
					.ChangeRepairItem(BLANK_GOCHIZO.get()));

	public static final DeferredItem<Item> VALENBUSTER = ITEMS.register("valenbuster",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).IsHenshinItem(VALENBUCKLE.get()).AddToTabList(RiderTabs.GAVV_TAB_ITEM)
					.ChangeRepairItem(BLANK_GOCHIZO.get()));

	public static final DeferredItem<Item> XMAX_VALEN = ITEMS.register("xmax_valen",
			() -> new BaseSwordItem(Tiers.DIAMOND, 7, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GAVV_TAB_ITEM).ChangeRepairItem(BLANK_GOCHIZO.get()));

	public static final DeferredItem<Item> VRAMBREAKER = ITEMS.register("vrambreaker",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 4, -2F, new Item.Properties()).IsSwordGun().AddToTabList(RiderTabs.GAVV_TAB_ITEM)
					.ChangeRepairItem(BLANK_GOCHIZO.get()));

	public static final DeferredItem<Item> SILVER_DEFENSER = ITEMS.register("silver_defenser",
			() -> new BaseShieldItem(new Item.Properties().rarity(Rarity.UNCOMMON)).AddToTabList(RiderTabs.GAVV_TAB_ITEM).ChangeRepairItem(BLANK_GOCHIZO.get()));

	public static final DeferredItem<Item> BITTER_GAVVGABLADE = ITEMS.register("bitter_gavvgablade",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GAVV_TAB_ITEM)
					.ChangeRepairItem(BLANK_GOCHIZO.get()));

	public static final DeferredItem<Item> BAKEMAGNUM = ITEMS.register("bakemagnum",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).IsHenshinItem(BAKEBUCKLE.get()).AddToTabList(RiderTabs.GAVV_TAB_ITEM)
					.ChangeRepairItem(BLANK_GOCHIZO.get()));

	public static final DeferredItem<Item> JEEB_DAGGER = ITEMS.register("jeeb_dagger",
			() -> new BaseSwordItem(Tiers.DIAMOND, 4, -2F, new Item.Properties()).AddToTabList(RiderTabs.GAVV_TAB_ITEM)
					.ChangeRepairItem(BLANK_GOCHIZO.get()));

	public static final DeferredItem<Item> JEEB_SWORD = ITEMS.register("jeeb_sword",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GAVV_TAB_ITEM)
					.ChangeRepairItem(BLANK_GOCHIZO.get()));

	public static final DeferredItem<Item> SHIITA_GUN = ITEMS.register("shiita_gun",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 4, -2F, new Item.Properties()).AddToTabList(RiderTabs.GAVV_TAB_ITEM)
					.ChangeRepairItem(BLANK_GOCHIZO.get()));

	public static final DeferredItem<Item> NYELV_BOW = ITEMS.register("nyelv_bow",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 4, -2F, new Item.Properties()).IsSwordGun().AddToTabList(RiderTabs.GAVV_TAB_ITEM)
					.ChangeRepairItem(BLANK_GOCHIZO.get()));

	public static final DeferredItem<Item> GLOTTA_SCYTHE = ITEMS.register("glotta_scythe",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GAVV_TAB_ITEM)
					.ChangeRepairItem(BLANK_GOCHIZO.get()));

	public static final DeferredItem<Item> LANGO_SWORD = ITEMS.register("lango_sword",
			() -> new BaseSwordItem(Tiers.DIAMOND, 6, -2F, new Item.Properties()).AddToTabList(RiderTabs.GAVV_TAB_ITEM)
					.ChangeRepairItem(BLANK_GOCHIZO.get()));


	public static final DeferredItem<Item> AGENT_BLASTER = ITEMS.register("agent_blaster",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 2, -1.4F, new Item.Properties()).AddToTabList(RiderTabs.GAVV_TAB_ITEM)
					.ChangeRepairItem(HEATPRESS.get()));

	public static final DeferredItem<Item> WHIPPED_ROD = ITEMS.register("whipped_rod",
			() -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RiderTabs.GAVV_TAB_ITEM)
					.ChangeRepairItem(BLANK_GOCHIZO.get()));

	public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
}
