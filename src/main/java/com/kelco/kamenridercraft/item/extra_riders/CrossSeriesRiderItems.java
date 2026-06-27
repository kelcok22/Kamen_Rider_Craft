package com.kelco.kamenridercraft.item.extra_riders;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.item.base_items.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.heisei_phase_1.KuugaRiderItems;
import com.kelco.kamenridercraft.particle.ModParticles;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CrossSeriesRiderItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);


    public static final DeferredItem<Item>  GREEN_KING_STONE_ARTIST = ITEMS.register("green_king_stone_artist",
            () -> new RiderFormChangeItem(new Item.Properties(),"_artist","shadow_moon","shadow_charger_belt_artist",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.DIG_SPEED,40, 0,true,false)
                    ,new MobEffectInstance(EffectCore.DARK_AURA,40, 0,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.DARK_RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 50, 0, 0, 0, 1);
                }
            }.hasSD().isGlowing().hasCape().has_basic_model().model_has_different_name("green_king_stone"));


    public static final DeferredItem<Item> TYPHOON_CORE_ARTIST = ITEMS.register("typhoon_core_artist",
            () -> new RiderFormChangeItem(new Item.Properties(),"_artist","ichigo","typhoon_belt_artist",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)).addAlternative(GREEN_KING_STONE_ARTIST.get()).allowRiderKick().isGlowing());

    public static final DeferredItem<Item> DOUBLE_TYPHOON_CORE_ARTIST = ITEMS.register("double_typhoon_core_artist",
            () -> new RiderFormChangeItem(new Item.Properties(),"_artist","v3","double_typhoon_belt_artist",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)
                    ,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false))
                    .isGlowing().addAlternative(TYPHOON_CORE_ARTIST.get()));

    public static final DeferredItem<Item> RIDERMAN_BELT_CORE_ARTIST = ITEMS.register("riderman_belt_core_artist",
            () -> new RiderFormChangeItem(new Item.Properties(),"_artist","riderman","riderman_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.REGENERATION,200, 0,true,false)
                    ,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false))
                    .isGlowing().setShowFace().addAlternative(DOUBLE_TYPHOON_CORE_ARTIST.get()));

    public static final DeferredItem<Item> CONDORER_WHEEL_PRE_AMAZON = ITEMS.register("condorer_wheel_pre_amazon",
            () -> new RiderFormChangeItem(new Item.Properties(),"_pre","amazon","condorer_belt",
                    new MobEffectInstance(MobEffects.WEAKNESS, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false))
                    .changeModel("amazon.geo.json").isGlowing().addAlternative(RIDERMAN_BELT_CORE_ARTIST.get()));

    public static final DeferredItem<Item> ELECTRER_CORE_ARTIST = ITEMS.register("electrer_core_artist",
            () -> new RiderFormChangeItem(new Item.Properties(),"_artist","stronger","electrer_belt_artist",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
                    .changeModel("stronger.geo.json").hasCape().isGlowing().addAlternative(CONDORER_WHEEL_PRE_AMAZON.get()));

    public static final DeferredItem<Item> TACKLE_CORE_ARTIST = ITEMS.register("tackle_core_artist",
            () -> new RiderFormChangeItem(new Item.Properties(),"_artist","tackle","tackle_belt_artist",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
                    .changeModel("tackle.geo.json").hasCape().isGlowing().setShowUnder().addAlternative(ELECTRER_CORE_ARTIST.get()));

    public static final DeferredItem<Item> KUUGA_AMAZING_MIGHTY_ARTIST = ITEMS.register("kuuga_amazing_mighty_artist",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"_artist","kuuga","arcle_belt_r",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 4,true,false)){
                public void transformationEffect(ItemStack itemstack, LivingEntity player) {
                    super.transformationEffect(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.allowRiderKick().IsBeltGlowing().isGlowing().addNeedForm(KuugaRiderItems.KUUGA_AMAZING_MIGHTY.get(),1).addAlternative(TACKLE_CORE_ARTIST.get())
                    .addToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
