package com.kelco.kamenridercraft.item.showa;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.base_items.BaseBannerPatternItem;
import com.kelco.kamenridercraft.item.base_items.RiderArmorItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.base_items.RiderFormChangeItem;
import com.kelco.kamenridercraft.particle.ModParticles;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
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


public class StrongerRiderItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);


    //Stronger
    public static final DeferredItem<Item> STRONGER_LOGO = ITEMS.register("stronger_logo",
            () -> new BaseBannerPatternItem(TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "pattern_item/stronger")), new Item.Properties()).AddToList(KamenRiderCraftCore.CreativeTabRegistry.STRONGER_TAB_ITEM));


    public static final DeferredItem<Item> ELECTRER_CORE = ITEMS.register("electrer_core",
            () -> new RiderFormChangeItem(new Item.Properties(),"","stronger","electrer_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 80, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ParticleTypes.FIREWORK,
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.hasSD().IsGlowing().HasCape().AddToList(KamenRiderCraftCore.CreativeTabRegistry.STRONGER_TAB_ITEM));

    public static final DeferredItem<Item> CHARGE_UP = ITEMS.register("charge_up",
            () -> new RiderFormChangeItem(new Item.Properties().rarity(Rarity.UNCOMMON),"_charge_up","stronger","electrer_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false)
                    ,new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false)
                    ,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    LightningBolt thunder = new LightningBolt(EntityType.LIGHTNING_BOLT,player.level());
                    thunder.setVisualOnly(true);
                    thunder.setPos( player.getX(),  -1 + player.getY(),  player.getZ() );
                    player.level().addFreshEntity(thunder);

                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 80, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ParticleTypes.FIREWORK,
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.hasSD().ChangeModel("stronger.geo.json").HasCape().IsGlowing().AddToList(KamenRiderCraftCore.CreativeTabRegistry.STRONGER_TAB_ITEM));

    public static final DeferredItem<Item> TACKLE_CORE = ITEMS.register("tackle_core",
            () -> new RiderFormChangeItem(new Item.Properties(),"","tackle","tackle_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false),new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 1,true,false)
                    ,new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
                    .hasSD().HasCape().IsGlowing().SetShowUnder().AddToList(KamenRiderCraftCore.CreativeTabRegistry.STRONGER_TAB_ITEM));



    public static final DeferredItem<Item> STRONGERHELMET = ITEMS.register("strongerhead",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.STRONGER_TAB_ITEM));
    public static final DeferredItem<Item> STRONGERCHESTPLATE = ITEMS.register("strongertroso",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.STRONGER_TAB_ITEM));
    public static final DeferredItem<Item> STRONGERLEGGINGS = ITEMS.register("strongerlegs",
            () -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.STRONGER_TAB_ITEM));

    public static final DeferredItem<Item> ELECTRER = ITEMS.register("electrer",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"stronger",ELECTRER_CORE ,STRONGERHELMET,STRONGERCHESTPLATE,STRONGERLEGGINGS , new Item.Properties())
                    .HasAnSDForm().IsA1().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.STRONGER_TAB_ITEM));

    public static final DeferredItem<Item> DARK_ELECTRER = ITEMS.register("dark_electrer",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"dark_stronger",ELECTRER_CORE ,STRONGERHELMET,STRONGERCHESTPLATE,STRONGERLEGGINGS , new Item.Properties()).Dont_show_belt_form_info()
                    .Override_belt_text("dark_electrer_belt").AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.STRONGER_TAB_ITEM));

    public static final DeferredItem<Item> TACKLE_BELT = ITEMS.register("tackle_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"tackle",TACKLE_CORE ,STRONGERHELMET,STRONGERCHESTPLATE,STRONGERLEGGINGS , new Item.Properties())
                    .HasAnSDForm().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.STRONGER_TAB_ITEM));

    public static final DeferredItem<Item> BLACK_TACKLE_BELT = ITEMS.register("black_tackle_belt",
            () -> new RiderDriverItem(ArmorMaterials.DIAMOND,"black_tackle",TACKLE_CORE ,STRONGERHELMET,STRONGERCHESTPLATE,STRONGERLEGGINGS , new Item.Properties())
                    .Override_belt_text("black_tackle_belt").Dont_show_belt_form_info().has_basic_model().AddToTabList(KamenRiderCraftCore.CreativeTabRegistry.STRONGER_TAB_ITEM));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
