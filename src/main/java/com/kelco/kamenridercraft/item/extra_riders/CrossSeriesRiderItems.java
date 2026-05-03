package com.kelco.kamenridercraft.item.extra_riders;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.effects.effect_core.EffectCore;
import com.kelco.kamenridercraft.item.base_items.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.heisei_phase_1.Kuuga_Rider_Items;
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

    public static final DeferredItem<Item> TYPHOON_CORE_ARTIST = ITEMS.register("typhoon_core_artist",
            () -> new RiderFormChangeItem(new Item.Properties(),"_artist","ichigo","typhoon_belt_artist",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)).allowRiderKick().IsGlowing());

    public static final DeferredItem<Item> DOUBLE_TYPHOON_CORE_ARTIST = ITEMS.register("double_typhoon_core_artist",
            () -> new RiderFormChangeItem(new Item.Properties(),"_artist","v3","double_typhoon_belt_artist",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false)
                    ,new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false))
                    .IsGlowing().addAlternative(TYPHOON_CORE_ARTIST.get()));

    public static final DeferredItem<Item> RIDERMAN_BELT_CORE_ARTIST = ITEMS.register("riderman_belt_core_artist",
            () -> new RiderFormChangeItem(new Item.Properties(),"_artist","riderman","riderman_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.REGENERATION,200, 0,true,false)
                    ,new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false))
                    .IsGlowing().SetShowFace().addAlternative(DOUBLE_TYPHOON_CORE_ARTIST.get()));

    public static final DeferredItem<Item> CONDORER_WHEEL_PRE_AMAZON = ITEMS.register("condorer_wheel_pre_amazon",
            () -> new RiderFormChangeItem(new Item.Properties(),"_pre","amazon","condorer_belt",
                    new MobEffectInstance(MobEffects.WEAKNESS, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false))
                    .ChangeModel("amazon.geo.json").IsGlowing().addAlternative(RIDERMAN_BELT_CORE_ARTIST.get()));

    public static final DeferredItem<Item> ELECTRER_CORE_ARTIST = ITEMS.register("electrer_core_artist",
            () -> new RiderFormChangeItem(new Item.Properties(),"_artist","stronger","electrer_belt_artist",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
                    .ChangeModel("stronger.geo.json").HasCape().IsGlowing().addAlternative(CONDORER_WHEEL_PRE_AMAZON.get()));

    public static final DeferredItem<Item> TACKLE_CORE_ARTIST = ITEMS.register("tackle_core_artist",
            () -> new RiderFormChangeItem(new Item.Properties(),"_artist","tackle","tackle_belt_artist",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
                    .ChangeModel("tackle.geo.json").HasCape().IsGlowing().SetShowUnder().addAlternative(ELECTRER_CORE_ARTIST.get()));

    public static final DeferredItem<Item> KUUGA_AMAZING_MIGHTY_ARTIST = ITEMS.register("kuuga_amazing_mighty_artist",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"_artist","kuuga","arcle_belt_r",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 4,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.allowRiderKick().IsBeltGlowing().IsGlowing().addNeedForm(Kuuga_Rider_Items.KUUGA_AMAZING_MIGHTY.get(),1).addAlternative(TACKLE_CORE_ARTIST.get())
                    .AddToList(KamenRiderCraftCore.CreativeTabRegistry.Misc_TAB_ITEM));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
