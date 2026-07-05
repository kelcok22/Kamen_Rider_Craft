package com.kelco.kamenridercraft.item;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.block.Rider_Blocks;
import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.ShockerCombatmanEntity;
import com.kelco.kamenridercraft.item.base_items.BaseItem;
import com.kelco.kamenridercraft.item.base_items.BaseSwordItem;
import com.kelco.kamenridercraft.item.base_items.RiderCaseItem;
import com.kelco.kamenridercraft.item.base_items.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.misc_items.MusicDiscItems;
import com.kelco.kamenridercraft.particle.ModParticles;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModdedItemCore {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);

    public static final DeferredItem<Item> BLANK_FORM = ITEMS.register("blank_form",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "", "").setShowPlayer().changeRiderName("blank").changeModel("default.geo.json"));


    public static final DeferredItem<Item> RIDER_CIRCUIT = ITEMS.register("rider_circuit",
            () -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));

    public static final DeferredItem<Item> TAKOYAKI = ITEMS.register("takoyaki",
            () -> new BaseItem(new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).fast().saturationModifier(0.8f).alwaysEdible().build()))
                    .has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));

    public static final DeferredItem<Item> COFFEE = ITEMS.register("coffee",
            () -> new BaseItem(new Item.Properties().food((new FoodProperties.Builder()).nutrition(1).saturationModifier(0.8f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 250, 1), 1.0F).build()))
                    .SetItemAnimation(UseAnim.DRINK).has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));

    public static final DeferredItem<Item> VIENNA_COFFEE = ITEMS.register("vienna_coffee",
            () -> new BaseItem(new Item.Properties().food((new FoodProperties.Builder()).nutrition(1).saturationModifier(0.8f).alwaysEdible().build()))
                    .SetItemAnimation(UseAnim.DRINK).addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));

    public static final DeferredItem<Item> PUDDING = ITEMS.register("pudding",
            () -> new BaseItem(new Item.Properties().food(Foods.COOKIE)).addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));

    public static final DeferredItem<Item> ICE_POP = ITEMS.register("icepop1",
            () -> new BaseItem(new Item.Properties().food(Foods.BEEF)).addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));

    public static final DeferredItem<Item> ICE_POP2 = ITEMS.register("icepop2",
            () -> new BaseItem(new Item.Properties().food(Foods.BEEF)).addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));

    public static final DeferredItem<Item> ICE_POP3 = ITEMS.register("icepop3",
            () -> new BaseItem(new Item.Properties().food(Foods.BEEF)).addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));

    public static final DeferredItem<Item> TRANSFORM_ONE_SHOT = ITEMS.register("transform_one_shot",
            () -> new BaseItem(new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).fast().saturationModifier(0.8f).alwaysEdible().effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 500, 3), 1.0F).build()))
                    .SetItemAnimation(UseAnim.DRINK).addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));

    public static final DeferredItem<Item> MILK_BOTTLE = ITEMS.register("milk_bottle",
            () -> new BaseItem(new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).fast().saturationModifier(0.8f).alwaysEdible().effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 500, 4), 1.0F).build()))
                    .SetItemAnimation(UseAnim.DRINK).addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));

    public static final DeferredItem<Item> PUZZLE_PIECE = ITEMS.register("puzzle_piece",
            () -> new BaseItem(new Item.Properties().food((new FoodProperties.Builder()).nutrition(0).fast().saturationModifier(0f).alwaysEdible().effect(() -> new MobEffectInstance(MobEffects.POISON, 40, 2), 1.0F).build()))
                    .HasHoverTex().has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));

    public static final DeferredItem<Item> TAIYAKI = ITEMS.register("taiyaki",
            () -> new BaseItem(new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).fast().saturationModifier(1.2f).alwaysEdible().build()))
                    .has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));


    public static final DeferredItem<Item> DONUT = ITEMS.register("donut",
            () -> new BaseItem(new Item.Properties().food(Foods.BREAD)).addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));

    public static final DeferredItem<Item> MAYO = ITEMS.register("mayo",
            () -> new BaseItem(new Item.Properties().food((new FoodProperties.Builder()).nutrition(1).fast().saturationModifier(0.8f).alwaysEdible().effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 500, 2), 1.0F).build()))
                    .SetItemAnimation(UseAnim.DRINK).addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));

    public static final DeferredItem<Item> MAYO_DONUT = ITEMS.register("mayo_donut",
            () -> new BaseItem(new Item.Properties().food((new FoodProperties.Builder()).nutrition(3).fast().saturationModifier(0.8f).alwaysEdible().effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 500, 2), 1.0F).build()))
                    .has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));

    public static final DeferredItem<Item> MY_TH_HEAD = ITEMS.register("my_th_head",
            () -> new BaseItem(new Item.Properties().food((new FoodProperties.Builder()).nutrition(3).fast().saturationModifier(0.8f).alwaysEdible().effect(() -> new MobEffectInstance(EffectCore.CLIMBING, 500, 2555), 1.0F).build()))
                    .has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.MY_TH_TAB_ITEM));


    public static final DeferredItem<Item> CANDY_WRAPPER = ITEMS.register("candy_wrapper",
            () -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));

    public static final DeferredItem<Item> GUMMI_CANDY = ITEMS.register("gummi_candy",
            () -> new BaseItem(new Item.Properties().food(Foods.SWEET_BERRIES)).addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));

    public static final DeferredItem<Item> POTATO_SNACKS = ITEMS.register("potato_snacks",
            () -> new BaseItem(new Item.Properties().food(Foods.POTATO)).addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));

    public static final DeferredItem<Item> LOLLIPOP = ITEMS.register("lollipop",
            () -> new BaseItem(new Item.Properties().food(Foods.MELON_SLICE)).addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));

    public static final DeferredItem<Item> CHOCOLATE_BAR = ITEMS.register("chocolate_bar",
            () -> new BaseItem(new Item.Properties().food(Foods.COOKIE)).addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));

    public static final DeferredItem<Item> MARSHMALLOW = ITEMS.register("marshmallow",
            () -> new BaseItem(new Item.Properties().food(Foods.MELON_SLICE)).addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));

    public static final DeferredItem<Item> PANCAKE = ITEMS.register("pancake",
            () -> new BaseItem(new Item.Properties().food(Foods.BREAD)).addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));

    public static final DeferredItem<Item> DANGO = ITEMS.register("dango",
            () -> new BaseItem(new Item.Properties().food(Foods.COOKIE)).has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));

    public static final DeferredItem<Item> CORN_SNACK = ITEMS.register("corn_snack",
            () -> new BaseItem(new Item.Properties().food(Foods.COOKIE)).has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));


    public static final DeferredItem<Item> BASE_SWORD = ITEMS.register("base_sword",
            () -> new BaseSwordItem(Tiers.IRON, 3, -2.2F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));

    public static final DeferredItem<Item> BASE_BIKE = ITEMS.register("base_bike",
            () -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));

    public static final DeferredItem<Item> GENERIC_RIDER_CASE = ITEMS.register("rider_case",
            () -> new RiderCaseItem().has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));

    public static final DeferredItem<Item> SHOCKER_EMBLEM = ITEMS.register("shocker_emblem",
            () -> new RiderFormChangeItem(new Item.Properties(), "", "shocker_combatman", "shocker_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false))
                    .hasSD().setShowFace().has_basic_model().addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));

    public static final DeferredItem<Item> SINISTER_PACHINKO_BALL = ITEMS.register("sinister_pachinko_ball",
            () -> new BaseItem(new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));


    public static final DeferredItem<Item> CARD_WARRIOR_KAMEN_RIDER_MANGA = ITEMS.register("card_warrior_kamen_rider_manga",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.UNCOMMON)).addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM).KeepItem());


    public static final DeferredItem<Item> DRAGREDER = ITEMS.register("dragreder",
            () -> new RiderFormChangeItem(new Item.Properties(), "_dragreder", "ryuki", "v_buckle_belt_ryuki",
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 0, true, false),
                    new MobEffectInstance(EffectCore.FLYING, 40, 1, true, false))
                    .isGlowing().hasStaticWings().addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));

    public static final DeferredItem<Item> STAGTORNADOR = ITEMS.register("stagtornador",
            () -> new RiderFormChangeItem(new Item.Properties(), "_stagtornador", "agito", "alter_ring_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0, true, false),
                    new MobEffectInstance(EffectCore.FLYING, 40, 1, true, false))
                    .isGlowing().IsBeltGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));

    public static final DeferredItem<Item> HERCULESPADER = ITEMS.register("herculespader",
            () -> new RiderFormChangeItem(new Item.Properties(), "_herculespader", "blade", "blay_buckle_belt",
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false))
                    .isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));


    public static final DeferredItem<Item> DARKWING = ITEMS.register("darkwing",
            () -> new RiderFormChangeItem(new Item.Properties(), "_darkwing", "knight", "v_buckle_belt_knight",
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0, true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0, true, false),
                    new MobEffectInstance(EffectCore.FLYING, 40, 1, true, false))
                    .addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));


    public static final DeferredItem<Item> GREYWOLCH = ITEMS.register("greywolch",
            () -> new RiderFormChangeItem(new Item.Properties(), "_greywolch", "faiz", "faiz_driver_belt_greywolch",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0, true, false))
                    .isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));

    public static final DeferredItem<Item> GRANDGOURAM = ITEMS.register("grandgouram",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON), "_grand_gouram", "kuuga", "arcle_belt_r",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 8, true, false)) {
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.IsBeltGlowing().isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));

    public static final DeferredItem<Item> EXBEETER = ITEMS.register("exbeeter",
            () -> new RiderFormChangeItem(new Item.Properties(), "_exbeeter", "kabuto", "kabuto_rider_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3, true, false))
                    .isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));

    public static final DeferredItem<Item> CHAOSDILE = ITEMS.register("chaosdile",
            () -> new RiderFormChangeItem(new Item.Properties(), "_chaosdile", "kaixa", "kaixa_driver_belt_chaosdile",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0, true, false)
            ).isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));


    public static final DeferredItem<Item> LEATHERAIDER = ITEMS.register("leatheraider",
            () -> new RiderFormChangeItem(new Item.Properties(), "_leatheraider", "gills", "meta_factor_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 0, true, false))
                    .isGlowing().hasStaticWings().addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));


    public static final DeferredItem<Item> FLARESALAMANDER = ITEMS.register("flaresalamander",
            () -> new RiderFormChangeItem(new Item.Properties(), "_flaresalamander", "v3", "double_typhoon_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 4, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3, true, false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 4, true, false),
                    new MobEffectInstance(EffectCore.FLYING, 40, 1, true, false)
            ).isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));

    public static final DeferredItem<Item> DRAGRANZER = ITEMS.register("dragranzer",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.RARE), "_dragranzer", "ryuki", "v_buckle_belt_ryuki_s",
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2, true, false),
                    new MobEffectInstance(EffectCore.FLYING, 40, 1, true, false))
                    .isGlowing().hasStaticWings().addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));


    public static final DeferredItem<Item> SCISSORBEETER = ITEMS.register("scissorbeeter",
            () -> new RiderFormChangeItem(new Item.Properties(), "_scissorbeeter", "gatack", "gatack_rider_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false),
                    new MobEffectInstance(EffectCore.FLYING, 40, 1, true, false))
                    .isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));


    public static final DeferredItem<Item> AKANETAKA = ITEMS.register("akanetaka",
            () -> new RiderFormChangeItem(new Item.Properties(), "_akanetaka", "hibiki", "hibikidriver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(EffectCore.FLYING, 40, 1, true, false))
                    .changeBeltModel("geo/hibiki_belt.geo.json").isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));


    public static final DeferredItem<Item> SHADOWMANTIS = ITEMS.register("shadowmantis",
            () -> new RiderFormChangeItem(new Item.Properties(), "_shadowmantis", "chalice", "chalice_rouzer_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(EffectCore.FLYING, 40, 1, true, false))
                    .isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));


    public static final DeferredItem<Item> CYCLONEHOPPER = ITEMS.register("cyclonehopper",
            () -> new RiderFormChangeItem(new Item.Properties(), "_cyclonehopper", "ichigo", "typhoon_belt_original",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 4, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3, true, false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 4, true, false),
                    new MobEffectInstance(EffectCore.FLYING, 40, 1, true, false)) {
                public void OnRiderKickHit(ItemStack itemstack, LivingEntity pLivingEntity, LivingEntity enemy) {
                    if (enemy.isDeadOrDying() && enemy instanceof ShockerCombatmanEntity && !pLivingEntity.level().isClientSide())
                        enemy.spawnAtLocation(new ItemStack(MusicDiscItems.LETS_GO_RIDER_MUSIC_DISC.get()));
                }
            }.isGlowing().addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));

    //Bakuen no senshi


    public static final DeferredItem<Item> BAKUEN_NO_SENSHI_HIBIKI = ITEMS.register("bakuen_no_senshi_hibiki",
            () -> new RiderFormChangeItem(new Item.Properties(), "_bakuen_no_senshi", "hibiki", "hibikidriver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4, true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0, true, false),
                    new MobEffectInstance(EffectCore.FLYING, 40, 1, true, false)
            ).changeBeltModel("geo/hibiki_belt.geo.json"));

    public static final DeferredItem<Item> BAKUEN_NO_SENSHI_RYUGA = ITEMS.register("bakuen_no_senshi_ryuga",
            () -> new RiderFormChangeItem(new Item.Properties(), "_bakuen_no_senshi", "ryuga", "v_buckle_belt_ryuga",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4, true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0, true, false),
                    new MobEffectInstance(EffectCore.FLYING, 40, 1, true, false)
            ).hasStaticWings().addAlternative(BAKUEN_NO_SENSHI_HIBIKI.get()));

    public static final DeferredItem<Item> BAKUEN_NO_SENSHI = ITEMS.register("bakuen_no_senshi",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON), "_bakuen_no_senshi", "faiz", "faiz_driver_belt_bakuen_no_senshi",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4, true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0, true, false),
                    new MobEffectInstance(EffectCore.FLYING, 40, 1, true, false)
            ).isGlowing().addAlternative(BAKUEN_NO_SENSHI_RYUGA.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));


    public static final DeferredItem<Item> JINRAI_NO_SENSHI_DARK_KABUTO = ITEMS.register("jinrai_no_senshi_dark_kabuto",
            () -> new RiderFormChangeItem(new Item.Properties(), "_jinrai_no_senshi", "dark_kabuto", "dark_kabuto_rider_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3, true, false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 6, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4, true, false),
                    new MobEffectInstance(EffectCore.FLYING, 40, 0, true, false)
            ) {

                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    LightningBolt thunder = new LightningBolt(EntityType.LIGHTNING_BOLT, player.level());
                    thunder.setVisualOnly(true);
                    thunder.setPos(player.getX(), -1 + player.getY(), player.getZ());
                    player.level().addFreshEntity(thunder);

                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }

                public void OnRiderKickHit(ItemStack itemstack, LivingEntity pLivingEntity, LivingEntity enemy) {
                    if (!pLivingEntity.level().isClientSide()) {
                        if (pLivingEntity.level() instanceof ServerLevel) {
                            LightningBolt thunder = new LightningBolt(EntityType.LIGHTNING_BOLT, pLivingEntity.level());
                            thunder.setPos(enemy.getX(), -1 + enemy.getY(), enemy.getZ());
                            pLivingEntity.level().addFreshEntity(thunder);
                        }
                    }
                }
            }.isGlowing());


    public static final DeferredItem<Item> JINRAI_NO_SENSHI_BLADE = ITEMS.register("jinrai_no_senshi_blade",
            () -> new RiderFormChangeItem(new Item.Properties(), "_jinrai_no_senshi", "blade", "blay_buckle_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3, true, false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(EffectCore.FLYING, 40, 0, true, false)) {

                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    LightningBolt thunder = new LightningBolt(EntityType.LIGHTNING_BOLT, player.level());
                    thunder.setVisualOnly(true);
                    thunder.setPos(player.getX(), -1 + player.getY(), player.getZ());
                    player.level().addFreshEntity(thunder);

                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }

                public void OnRiderKickHit(ItemStack itemstack, LivingEntity pLivingEntity, LivingEntity enemy) {
                    if (!pLivingEntity.level().isClientSide()) {
                        if (pLivingEntity.level() instanceof ServerLevel) {
                            LightningBolt thunder = new LightningBolt(EntityType.LIGHTNING_BOLT, pLivingEntity.level());
                            thunder.setPos(enemy.getX(), -1 + enemy.getY(), enemy.getZ());
                            pLivingEntity.level().addFreshEntity(thunder);
                        }
                    }
                }
            }.isGlowing().addAlternative(JINRAI_NO_SENSHI_DARK_KABUTO.get()));


    public static final DeferredItem<Item> JINRAI_NO_SENSHI = ITEMS.register("jinrai_no_senshi",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON), "_jinrai_no_senshi", "kuuga", "arcle_belt_r",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0, true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3, true, false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2, true, false),
                    new MobEffectInstance(EffectCore.FLYING, 40, 0, true, false)
            ) {

                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    LightningBolt thunder = new LightningBolt(EntityType.LIGHTNING_BOLT, player.level());
                    thunder.setVisualOnly(true);
                    thunder.setPos(player.getX(), -1 + player.getY(), player.getZ());
                    player.level().addFreshEntity(thunder);

                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY() + 1,
                            player.getZ(), 100, 0, 0, 0, 1);

                }

                public void OnRiderKickHit(ItemStack itemstack, LivingEntity pLivingEntity, LivingEntity enemy) {
                    if (!pLivingEntity.level().isClientSide()) {
                        if (pLivingEntity.level() instanceof ServerLevel) {
                            LightningBolt thunder = new LightningBolt(EntityType.LIGHTNING_BOLT, pLivingEntity.level());
                            thunder.setPos(enemy.getX(), -1 + enemy.getY(), enemy.getZ());
                            pLivingEntity.level().addFreshEntity(thunder);
                        }
                    }
                }
            }.IsBeltGlowing().isGlowing().addAlternative(JINRAI_NO_SENSHI_BLADE.get()).addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));


    public static final DeferredItem<Item> GRANDGOURAM_ROD = ITEMS.register("grandgouram_rod",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties().rarity(Rarity.UNCOMMON)).addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM)
                    .changeRepairItem(RIDER_CIRCUIT.get()));

    public static final DeferredItem<Item> HERCULESPADER_SWORD = ITEMS.register("herculespader_sword",
            () -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM)
                    .changeRepairItem(RIDER_CIRCUIT.get()));

    public static final DeferredItem<Item> DARKWING_SWORD = ITEMS.register("darkwing_sword",
            () -> new BaseSwordItem(Tiers.DIAMOND, 9, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM)
                    .changeRepairItem(RIDER_CIRCUIT.get()));

    public static final DeferredItem<Item> FLARESALAMANDER_SWORD = ITEMS.register("flaresalamander_sword",
            () -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM)
                    .changeRepairItem(RIDER_CIRCUIT.get()));

    public static final DeferredItem<SignItem> HELHEIM_SIGN_ITEM = ITEMS.register("helheim_sign_item",
            () -> new SignItem(new Item.Properties().stacksTo(16), Rider_Blocks.HELHEIM_SIGN.get(), Rider_Blocks.HELHEIM_WALL_SIGN.get()));
    public static final DeferredItem<SignItem> HELHEIM_HANGING_SIGN_ITEM = ITEMS.register("helheim_hanging_sign_item",
            () -> new SignItem(new Item.Properties().stacksTo(16), Rider_Blocks.HELHEIM_HANGING_SIGN.get(), Rider_Blocks.HELHEIM_WALL_HANGING_SIGN.get()));

    // public static final DeferredItem<Item> WARRIOR_POTTERY_SHERD = ITEMS.register("warrior_pottery_sherd",
    //      () -> new Item(new Item.Properties().stacksTo(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}