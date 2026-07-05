package com.kelco.kamenridercraft.events;

import com.kelco.kamenridercraft.block.Rider_Blocks;
import com.kelco.kamenridercraft.client.KeyBindings;
import com.kelco.kamenridercraft.client.models.DoggaModel;
import com.kelco.kamenridercraft.client.models.ElementaryInvesModel;
import com.kelco.kamenridercraft.client.models.HeartRoidmudeModel;
import com.kelco.kamenridercraft.client.models.MidaredoujiModel;
import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.entity.EntityAttributes;
import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.allies.AnkhEntity;
import com.kelco.kamenridercraft.entity.mobs.bosses.ShadowmoonEntity;
import com.kelco.kamenridercraft.entity.mobs.summons.BaseSummonEntity;
import com.kelco.kamenridercraft.entity.mobs.villager.RiderVillagers;
import com.kelco.kamenridercraft.item.ModdedItemCore;
import com.kelco.kamenridercraft.item.base_items.BaseBlasterItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.base_items.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.extra_riders.CrossSeriesRiderItems;
import com.kelco.kamenridercraft.item.extra_riders.ExtraRiderItems;
import com.kelco.kamenridercraft.item.extra_riders.GRiderItems;
import com.kelco.kamenridercraft.item.extra_riders.RideKamensItems;
import com.kelco.kamenridercraft.item.heisei_phase_1.*;
import com.kelco.kamenridercraft.item.heisei_phase_1.decade.ZeinCardItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.GaimRiderItems;
import com.kelco.kamenridercraft.item.heisei_phase_2.GhostRiderItems;
import com.kelco.kamenridercraft.item.heisei_phase_2.ZiORiderItems;
import com.kelco.kamenridercraft.item.misc_items.MusicDiscItems;
import com.kelco.kamenridercraft.item.reiwa.*;
import com.kelco.kamenridercraft.item.reiwa.gavv.GochipodItem;
import com.kelco.kamenridercraft.item.showa.*;
import com.kelco.kamenridercraft.level.ModGameRules;
import com.kelco.kamenridercraft.network.payload.AbilityKeyPayload;
import com.kelco.kamenridercraft.network.payload.BeltKeyPayload;
import com.kelco.kamenridercraft.network.payload.PoseKeyPayload;
import com.kelco.kamenridercraft.particle.ModParticles;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades.ItemListing;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.AnvilUpdateEvent;
import net.neoforged.neoforge.event.ItemStackedOnOtherEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.living.*;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.level.BlockDropsEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.event.village.WandererTradesEvent;
import net.neoforged.neoforge.network.PacketDistributor;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import static com.kelco.kamenridercraft.KamenRiderCraftCore.MOD_ID;
import static com.kelco.kamenridercraft.world.data_attachments.AttachmentTypes.USED_ABILITY;


public class ModCommonEvents {


    public static class CommonEvents {

        private static ResourceLocation lootTable;
        private static final ResourceLocation LOOT_TABLE_PATH = lootTable;

        @SubscribeEvent
        public void onPlayerDisconnect(PlayerEvent.PlayerLoggedOutEvent event) {
            if (event.getEntity() instanceof ServerPlayer player) {
                player.serverLevel().getAllEntities().forEach(entity -> {
                    if (entity instanceof BaseSummonEntity summon) summon.despawn();
                });
            }
        }

        @SubscribeEvent
        public void DropsEvent(BlockDropsEvent event) {

            if (event.getState().is(BlockTags.create(ResourceLocation.withDefaultNamespace("logs")))) {
                if (event.getBreaker() instanceof Player player) {
                    if (player.getItemBySlot(EquipmentSlot.MAINHAND).isEmpty() & player.getAttribute(Attributes.TOJIMA).getValue() < 100)
                        player.getAttribute(Attributes.TOJIMA).setBaseValue(player.getAttribute(Attributes.TOJIMA).getValue() + 1);
                }
            }

            if (event.getState() == Blocks.GLASS.defaultBlockState()) {
                if (event.getBreaker() instanceof Player player) {
                    Inventory inventory = player.getInventory();
                    boolean hasSURVIVE = inventory.countItem(RyukiRiderItems.BLANK_DECK.get()) != 0;
                    if (hasSURVIVE) {
                        player.addEffect(new MobEffectInstance(EffectCore.MIRROR_NOISES, 300, 0, false, true));
                    }
                }
            }
        }

        @SubscribeEvent
        public void clientTick(ClientTickEvent.Post event) {
            Player player = Minecraft.getInstance().player;
            if (player != null) {
                AttributeInstance heldKeyOne = player.getAttribute(Attributes.HELD_ABILITY_KEY_ONE);
                AttributeInstance heldKeyTwo = player.getAttribute(Attributes.HELD_ABILITY_KEY_TWO);

                if (KeyBindings.INSTANCE.BeltKey.consumeClick())
                    PacketDistributor.sendToServer(new BeltKeyPayload(0));
                if (KeyBindings.INSTANCE.AbilityKeyOne.consumeClick() && !KeyBindings.INSTANCE.AbilityKeyTwo.isDown() && heldKeyOne.getValue() <= 0) {
                    PacketDistributor.sendToServer(new AbilityKeyPayload(1));
                } else if (!KeyBindings.INSTANCE.AbilityKeyOne.isDown() && heldKeyOne.getValue() >= 1) {
                    PacketDistributor.sendToServer(new AbilityKeyPayload(3));
                }
                if (KeyBindings.INSTANCE.AbilityKeyTwo.consumeClick() && !KeyBindings.INSTANCE.AbilityKeyOne.isDown() && heldKeyTwo.getValue() <= 0) {
                    PacketDistributor.sendToServer(new AbilityKeyPayload(2));
                } else if (!KeyBindings.INSTANCE.AbilityKeyTwo.isDown() && heldKeyTwo.getValue() >= 1) {
                    PacketDistributor.sendToServer(new AbilityKeyPayload(4));
                }
                if (KeyBindings.INSTANCE.PoseKey.consumeClick())
                    PacketDistributor.sendToServer(new PoseKeyPayload(0));
            }
        }

        @SubscribeEvent
        public void onPlayerTick(PlayerTickEvent.Post event) {

            if (event.getEntity().getAttribute(Attributes.TOJIMA).getValue() > 99 & event.getEntity().getItemBySlot(EquipmentSlot.HEAD).getItem() == ExtraRiderItems.ICHIGO_MASK.asItem())
                event.getEntity().addEffect(new MobEffectInstance(EffectCore.KNOCKBACK_BOOST, 30, 3, false, false));


            ResourceKey<Level> MOON = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("kamenridercraft:moon"));
            if (event.getEntity().level().dimension() == MOON && event.getEntity().level().getGameRules().getBoolean(ModGameRules.RULE_MOON_GRAVITY)) {
                event.getEntity().addEffect(new MobEffectInstance(EffectCore.LOW_GRAVITY, 30, 7, false, false));
            }

            LocalDate localdate = LocalDate.now();
            int day = localdate.getDayOfMonth();
            if (localdate.getMonthValue() == 12 && day >= 22 && day <= 28) {
                event.getEntity().addEffect(new MobEffectInstance(EffectCore.CHRISTMAS, 30, 0, false, false));
            }

            if (event.getEntity().level().getGameRules().getBoolean(ModGameRules.RULE_HAPPY_MODE)) {
                event.getEntity().addEffect(new MobEffectInstance(EffectCore.HAPPY_MODE, 30, 0, false, false));
            }
        }

        @SubscribeEvent
        public void addLivingDamageEvent(LivingEvent.LivingVisibilityEvent event) {

            if (event.getLookingEntity() instanceof LivingEntity entity) {
                //if (entity.getAttribute(AttributeRegistry.IS_TRANSFORMING).getBaseValue()!=0)entity.getAttribute(AttributeRegistry.IS_TRANSFORMING).setBaseValue(entity.getAttribute(AttributeRegistry.IS_TRANSFORMING).getBaseValue()-0.2);
            }
        }


        @SubscribeEvent
        public void onEntityTick(EntityTickEvent.Post event) {


            if (event.getEntity() instanceof LivingEntity player) {

                if (player.level().isClientSide()) {
                    float X = 0;
                    float Y = 0;
                    float Z = 0;
                    boolean isPlayer = false;
                    if (player instanceof Mob mob) {
                        if (player.getDeltaMovement().x != 0 || player.getDeltaMovement().z != 0) {
                            X = mob.getViewXRot(1);
                            Vec3 look = player.getLookAngle();
                            if (look.x > 0 & player.getDeltaMovement().x > 0) Z = 1;
                            else if (look.z > 0 & player.getDeltaMovement().z > 0) Z = 1;
                            else if (look.x < 0 & player.getDeltaMovement().x < 0) Z = 1;
                            else if (look.z < 0 & player.getDeltaMovement().z < 0) Z = 1;
                            else Z = -1;
                        }
                        player.getAttribute(Attributes.BALL_ROT_OLD).setBaseValue(player.getAttribute(Attributes.BALL_ROT).getBaseValue());
                        player.getAttribute(Attributes.WHEEL_ROT_OLD).setBaseValue(player.getAttribute(Attributes.WHEEL_ROT).getBaseValue());
                        player.getAttribute(Attributes.CAPE_ROT_OLD).setBaseValue(player.getAttribute(Attributes.CAPE_ROT).getBaseValue());

                        if (player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem belt) {

                            if (belt.hasCape(player.getItemBySlot(EquipmentSlot.FEET))) {

                                float cape = (float) player.getAttribute(Attributes.CAPE_ROT).getBaseValue();
                                float ball = 0;
                                if (Z > 0 & cape > -0.7 & !player.isSwimming())
                                    cape = cape - 0.01f - (player.getSpeed() / 10);
                                else if (Z > 0 & cape > -0.7 & !player.isSwimming())
                                    cape = 0;
                                else if (X == 0 & Z < 0 & cape < 0) cape = cape + 0.2f;
                                else if (X == 0 & Z == 0 & cape < 0 & X == 0 || X == 0 & Z == 0 & cape < -0.7 || X == 0 & cape < 0 & player.isSwimming())
                                    cape = cape + 0.02f;
                                if (X > 0) {
                                    ball = 0.2f;
                                    if (isPlayer & Z == 0 & cape > -0.7)
                                        cape = cape - 0.02f - (player.getSpeed() / 10);
                                }
                                if (X < 0) {
                                    ball = -0.2f;
                                    if (isPlayer & Z == 0 & cape > -0.7)
                                        cape = cape - 0.02f - (player.getSpeed() / 10);
                                }
                                //if (player.fallDistance > 0 & !player.isSwimming() & cape > -2) cape = cape - 0.05f;

                                player.getAttribute(Attributes.BALL_ROT).setBaseValue(ball);
                                player.getAttribute(Attributes.CAPE_ROT).setBaseValue(cape);
                            }
                            if (RiderDriverItem.getFormItem(player.getItemBySlot(EquipmentSlot.FEET), 1).getIsBike()) {
                                float wheel = 0;
                                if (Z > 0) wheel = -0.1f;
                                if (Z < 0) wheel = 0.1f;
                                player.getAttribute(Attributes.WHEEL_ROT).setBaseValue(player.getAttribute(Attributes.WHEEL_ROT).getBaseValue() + wheel);
                                float ball = 0;
                                if (X > 0) {
                                    ball = 0.5f;
                                    if (Z == 0) wheel = -0.1f;
                                }
                                if (X < 0) {
                                    ball = -0.5f;
                                    if (Z == 0) wheel = -0.1f;
                                }
                                player.getAttribute(Attributes.BALL_ROT).setBaseValue(ball);
                                player.getAttribute(Attributes.WHEEL_ROT).setBaseValue(player.getAttribute(Attributes.WHEEL_ROT).getBaseValue() + wheel);
                            }
                        }
                    }
                }
                if (player.getAttribute(Attributes.IS_TRANSFORMING).getBaseValue() != 0)
                    player.getAttribute(Attributes.IS_TRANSFORMING).setBaseValue(player.getAttribute(Attributes.IS_TRANSFORMING).getBaseValue() - 1);
                if (player.getAttribute(Attributes.IS_TRANSFORMING).getBaseValue() <= 0)
                    player.getAttribute(Attributes.IS_TRANSFORMING).setBaseValue(0);
            }

            if (!(event.getEntity() instanceof Player) && event.getEntity() instanceof LivingEntity entity && !entity.level().isClientSide && entity.getAttribute(Attributes.CLIMBING).getValue() != 0) {
                if (entity.horizontalCollision) {
                    Vec3 initialVec = entity.getDeltaMovement();
                    Vec3 climbVec = new Vec3(initialVec.x, 0.1D * (entity.getAttribute(Attributes.CLIMBING).getValue()), initialVec.z);
                    entity.setDeltaMovement(climbVec.scale(0.97D));
                }
            }
        }

        private Item getGochizoDrop(ItemStack itemstack, Level level, Player player) {
            Random generator = new Random();

            ResourceKey<Level> SUPER_SENTAI_TOPIA = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("supersentaicraft:super_sentai_topia"));
            ResourceKey<Level> CITY = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("kamenridercraft:city"));
            if ((level.dimension() == CITY)) {
                StructureManager structureManager = ((ServerLevel) player.level()).structureManager();
                TagKey<Structure> shockerBaseKey = TagKey.create(Registries.STRUCTURE, ResourceLocation.fromNamespaceAndPath(MOD_ID, "shocker_base"));
                StructureStart shockerBaseLocation = structureManager.getStructureWithPieceAt(player.blockPosition(), shockerBaseKey);

                if (shockerBaseLocation.isValid()) {
                    return GavvRiderItems.SHOWA_LEGEND.get(generator.nextInt(GavvRiderItems.SHOWA_LEGEND.size()));
                } else {
                    return GavvRiderItems.LEGEND.get(generator.nextInt(GavvRiderItems.LEGEND.size()));
                }
            } else if (level.dimension() == SUPER_SENTAI_TOPIA) {
                return GavvRiderItems.SENTAI.get(generator.nextInt(GavvRiderItems.SENTAI.size()));
            } else if (itemstack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MOD_ID, "food_for/gummy_gochizo")))) {
                int rand = generator.nextInt(GavvRiderItems.GUMMY.size());
                return GavvRiderItems.GUMMY.get(rand);
            } else if (itemstack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MOD_ID, "food_for/marshmallow_gochizo")))) {
                int rand = generator.nextInt(GavvRiderItems.MARSHMALLOW.size());
                return GavvRiderItems.MARSHMALLOW.get(rand);
            } else if (itemstack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MOD_ID, "food_for/snack_gochizo")))) {
                int rand = generator.nextInt(GavvRiderItems.SNACK.size());
                return GavvRiderItems.SNACK.get(rand);
            } else if (itemstack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MOD_ID, "food_for/chocolate_gochizo")))) {
                int rand = generator.nextInt(GavvRiderItems.CHOCO.size());
                return GavvRiderItems.CHOCO.get(rand);
            } else if (itemstack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MOD_ID, "food_for/cookie_gochizo")))) {
                int rand = generator.nextInt(GavvRiderItems.COOKIE.size());
                return GavvRiderItems.COOKIE.get(rand);
            } else if (itemstack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MOD_ID, "food_for/doughnut_gochizo")))) {
                return GavvRiderItems.DOUMARU_GOCHIZO.get();
            } else if (itemstack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MOD_ID, "food_for/tarakomentaiko_gochizo")))) {
                return GavvRiderItems.TARAKOMENTAIKO_GOCHIZO.get();
            } else if (itemstack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MOD_ID, "food_for/candy_gochizo")))) {
                int rand = generator.nextInt(GavvRiderItems.CANDY.size());
                return GavvRiderItems.CANDY.get(rand);
            } else if (itemstack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MOD_ID, "food_for/cake_gochizo")))) {
                int rand = generator.nextInt(GavvRiderItems.CAKE.size());
                return GavvRiderItems.CAKE.get(rand);
            } else if (itemstack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MOD_ID, "food_for/pancake_gochizo")))) {
                int rand = generator.nextInt(GavvRiderItems.PANCAKE.size());
                return GavvRiderItems.PANCAKE.get(rand);
            } else if (itemstack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MOD_ID, "food_for/mochi_gochizo")))) {
                int rand = generator.nextInt(GavvRiderItems.MOCHI.size());
                return GavvRiderItems.MOCHI.get(rand);
            } else if (itemstack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MOD_ID, "food_for/pudding_gochizo")))) {
                int rand = generator.nextInt(GavvRiderItems.PUDDING.size());
                return GavvRiderItems.PUDDING.get(rand);
            } else if (itemstack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MOD_ID, "food_for/corn_gochizo")))) {
                int rand = generator.nextInt(GavvRiderItems.CORN.size());
                return GavvRiderItems.CORN.get(rand);
            }
            return Items.APPLE;
        }

        public ResourceLocation dropItem(ServerLevel world, Player player, Player playerIn, InteractionHand p_41434_) {
            ResourceKey<LootTable> loot = ResourceKey.create(Registries.LOOT_TABLE, LOOT_TABLE_PATH);
            LootTable loottable = world.getServer().reloadableRegistries().getLootTable(loot);
            LootParams.Builder lootparams$builder = new LootParams.Builder(world)
                    .withParameter(LootContextParams.THIS_ENTITY, player)
                    .withParameter(LootContextParams.ORIGIN, player.position());

            LootParams lootparams = lootparams$builder.create(LootContextParamSets.GIFT);
            loottable.getRandomItems(lootparams, 0L, player::spawnAtLocation);
            ItemStack itemstack = playerIn.getItemInHand(p_41434_);
            if (itemstack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MOD_ID, "food_for/halloween_gochizo")))) {
                return ResourceLocation.fromNamespaceAndPath(MOD_ID, "items/gift");
            }
            return null;
        }

        private Item getCupGochizoDrop(ItemStack itemstack) {
            Random generator = new Random();
            if (itemstack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MOD_ID, "food_for/frappeis_gochizo")))) {
                int rand = generator.nextInt(GavvRiderItems.COFFEE.size());
                return GavvRiderItems.COFFEE.get(rand);
            } else if (itemstack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MOD_ID, "food_for/ala_mode_gochizo")))) {
                int rand = generator.nextInt(GavvRiderItems.ALA_MODE.size());
                return GavvRiderItems.ALA_MODE.get(rand);
            } else if (itemstack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MOD_ID, "food_for/sorbei_gochizo")))) {
                int rand = generator.nextInt(GavvRiderItems.ICE_CREAM.size());
                return GavvRiderItems.ICE_CREAM.get(rand);
            } else if (itemstack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MOD_ID, "food_for/cake_gochizo")))) {
                return GavvRiderItems.UEHOUSE_GOCHIZO.asItem();
            }
            return Items.APPLE;
        }

        @SubscribeEvent
        public void Give_Gochizo(LivingEntityUseItemEvent.Finish event) {
            if (event.getEntity() instanceof Player player && !player.level().isClientSide()) {

                Item GOCHIZO = getGochizoDrop(event.getItem(), event.getEntity().level(), player);
                Item CUP_GOCHIZO = getCupGochizoDrop(event.getItem());


                if (event.getItem().getItem() == GaimRiderItems.HELHEIM_FRUIT.asItem() & player.getInventory().countItem(GaimRiderItems.GURONBARYAMU.get()) > 0 & player.getItemBySlot(EquipmentSlot.FEET).getItem() == GaimRiderItems.SENGOKU_DRIVER_BARON.asItem()) {
                    RiderFormChangeItem alternativeItem_form_change = (RiderFormChangeItem) GaimRiderItems.LORD_BARON.get();
                    alternativeItem_form_change.use(event.getEntity().level(), player, InteractionHand.MAIN_HAND);
                }

                if (GOCHIZO != Items.APPLE & player.getInventory().countItem(GavvRiderItems.BLANK_GOCHIZO.get()) > 0) {

                    if (player.getInventory().getItem(40).getItem() == GavvRiderItems.BLANK_GOCHIZO.get()) {
                        player.getInventory().removeItem(40, 1);
                    } else
                        player.getInventory().removeItem(player.getInventory().findSlotMatchingItem(new ItemStack(GavvRiderItems.BLANK_GOCHIZO.get())), 1);

                    player.drop(new ItemStack(GOCHIZO), false);

                }
                if (CUP_GOCHIZO != Items.APPLE & player.getInventory().countItem(GavvRiderItems.PROTOTYPE_CUP_GOCHIZO.get()) > 0) {

                    if (player.getInventory().getItem(40).getItem() == GavvRiderItems.PROTOTYPE_CUP_GOCHIZO.get()) {
                        player.getInventory().removeItem(40, 1);
                    } else
                        player.getInventory().removeItem(player.getInventory().findSlotMatchingItem(new ItemStack(GavvRiderItems.PROTOTYPE_CUP_GOCHIZO.get())), 1);

                    player.drop(new ItemStack(CUP_GOCHIZO), false);
                }
            }
        }


        @SubscribeEvent
        public void Farmers_Delight_Cake_Gochizo(PlayerInteractEvent.RightClickBlock event) {
            if (ModList.get().isLoaded("farmersdelight") && !event.getLevel().isClientSide) {
                BlockState state = event.getLevel().getBlockState(event.getPos());
                Player player = event.getEntity();

                if (state.is(BlockTags.create(ResourceLocation.parse("kamenridercraft:fd_cakes_for_gochizo"))) && !event.getItemStack().is(ItemTags.create(ResourceLocation.fromNamespaceAndPath("farmersdelight", "tools/knives")))
                        && player.canEat(false) && player.getInventory().countItem(GavvRiderItems.BLANK_GOCHIZO.get()) > 0) {
                    if (player.getInventory().getItem(40).getItem() == GavvRiderItems.BLANK_GOCHIZO.get())
                        player.getInventory().removeItem(40, 1);
                    else
                        player.getInventory().removeItem(player.getInventory().findSlotMatchingItem(new ItemStack(GavvRiderItems.BLANK_GOCHIZO.get())), 1);

                    player.drop(new ItemStack(GavvRiderItems.CAKE.get(new Random().nextInt(GavvRiderItems.CAKE.size()))), false);
                }
            }
        }

        @SubscribeEvent
        public void anvilUpdateEvent(AnvilUpdateEvent event) {
            if (event.getLeft().isDamaged() && event.getLeft().getItem() instanceof ZeinCardItem zein && zein.isValidRepairItem(event.getLeft(), event.getRight())) {
                ItemStack result = event.getLeft().copy();
                result.setDamageValue(0);
                event.setOutput(result);
                event.setCost(5);
            }
        }

        @SubscribeEvent
        public void addLivingDamageEvent(ItemStackedOnOtherEvent event) {
            if (event.getCarriedItem().is(GavvRiderItems.GOCHIPOD_EMPTY)) {

                ItemStack stack = event.getCarriedItem();
                ItemStack other = event.getStackedOnItem();
                if (other.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MOD_ID, "gear/gochizo/gochizo_for_gochipod")))) {
                    int stored = GochipodItem.getStoreItem(stack);
                    int need = 100 - stored;
                    int have = other.getCount();
                    if (need != 0) {
                        if (have > need) {
                            GochipodItem.setStoreItem(stack, need);
                            other.shrink(need);
                        } else {
                            GochipodItem.setStoreItem(stack, have);
                            other.shrink(have);
                        }
                    }
                }
            }
        }


        @SubscribeEvent
        public void addLivingDamageEvent(LivingDeathEvent event) {
            if (event.getSource().getEntity() instanceof Player player) {
                if (player.hasEffect(EffectCore.HAPPY_MODE)) {
                    player.sendSystemMessage(Component.literal(Component.translatable("happy_mode.kamenridercraft.sleep").getString()));
                    if (event.getEntity() instanceof ShadowmoonEntity)
                        player.sendSystemMessage(Component.literal(Component.translatable("happy_mode.kamenridercraft.cheese_man").getString()));
                }
            }
        }


        @SubscribeEvent
        public void addLivingDamageEvent(LivingDamageEvent.Post event) {
            Entity sourceEntity = event.getSource().getEntity();
            if (sourceEntity instanceof LivingEntity livingEntity) {
                AttributeInstance abilityMeter = livingEntity.getAttribute(Attributes.ABILITY_METER);
                AttributeInstance maxAbilityMeter = livingEntity.getAttribute(Attributes.MAX_ABILITY_METER);
                if (livingEntity.getData(USED_ABILITY).isEmpty() && !(event.getSource().is(DamageTypes.ARROW) || event.getSource().is(DamageTypes.MOB_PROJECTILE) || event.getSource().is(DamageTypes.FIREBALL)) && abilityMeter.getValue() < maxAbilityMeter.getValue()) {
                    if (livingEntity.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem driverItem && driverItem.isTransformed(livingEntity)) {
                        abilityMeter.setBaseValue(abilityMeter.getValue() + 1 * driverItem.abilityMultiplier);
                    } else {
                        abilityMeter.setBaseValue(abilityMeter.getValue() + 1);
                    }
                    if (abilityMeter.getValue() > maxAbilityMeter.getValue()) {
                        abilityMeter.setBaseValue(maxAbilityMeter.getValue());
                    }
                }
            }

            if (event.getEntity() instanceof Player player && player.getInventory().countItem(ZeztzRiderItems.VOID_CAPSEM.get()) != 0 && !event.getEntity().level().isClientSide() && event.getSource().is(DamageTypes.LIGHTNING_BOLT)) {
                if (player.getOffhandItem().is(ZeztzRiderItems.VOID_CAPSEM.get())) {
                    player.getOffhandItem().shrink(1);
                } else {
                    player.getInventory().removeItem(player.getInventory().findSlotMatchingItem(new ItemStack(ZeztzRiderItems.VOID_CAPSEM.get())), 1);
                }
                player.getInventory().add(new ItemStack(ZeztzRiderItems.PLASMA_CAPSEM.get()));
            }

            if (event.getSource().getEntity() instanceof LivingEntity _livEnt) {


                if (event.getSource().is(DamageTypes.PLAYER_ATTACK) || event.getSource().is(DamageTypes.MOB_ATTACK) || event.getSource().is(DamageTypes.MOB_ATTACK_NO_AGGRO)) {

                    if (_livEnt.getItemBySlot(EquipmentSlot.FEET).is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MOD_ID, "belts/ex-aid_armor")))) {
                        ((ServerLevel) event.getEntity().level()).sendParticles(ModParticles.HIT_PARTICLES.get(),
                                event.getEntity().getX() + 0.5, event.getEntity().getY() + 1.5,
                                event.getEntity().getZ() + 0.5, 1, 0, 0, 0, 3);
                    }

                    if (event.getEntity().hasEffect(EffectCore.MUTEKI)) {
                        ((ServerLevel) event.getEntity().level()).sendParticles(ModParticles.MISS_PARTICLES.get(),
                                event.getEntity().getX() + 0.5, event.getEntity().getY() + 1.5,
                                event.getEntity().getZ() + 0.5, 1, 0, 0, 0, 3);
                        ((ServerLevel) event.getEntity().level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                                event.getEntity().getX(), event.getEntity().getY() + 1,
                                event.getEntity().getZ(), 10, 0, 0, 0, 1);
                    }

                    if (_livEnt.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem && RiderDriverItem.getFormItem(_livEnt.getItemBySlot(EquipmentSlot.FEET), 1).is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MOD_ID, "gear/gochizo/puchingummy")))) {
                        ((ServerLevel) event.getEntity().level()).sendParticles(ModParticles.GUMMI_PARTICLES2.get(),
                                event.getEntity().getX() + 0.5, event.getEntity().getY() + 1.5,
                                event.getEntity().getZ() + 0.5, 10, 0, 0, 0, 3);
                    }

                    if (_livEnt.hasEffect(EffectCore.HAPPY_MODE)) {
                        ((ServerLevel) event.getEntity().level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                                event.getEntity().getX() + 0.5, event.getEntity().getY() + 1.5,
                                event.getEntity().getZ() + 0.5, 10, 0, 0, 0, 3);
                        ((ServerLevel) event.getEntity().level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
                                event.getEntity().getX() + 0.5, event.getEntity().getY() + 1.5,
                                event.getEntity().getZ() + 0.5, 10, 0, 0, 0, 3);
                        ((ServerLevel) event.getEntity().level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                                event.getEntity().getX() + 0.5, event.getEntity().getY() + 1.5,
                                event.getEntity().getZ() + 0.5, 10, 0, 0, 0, 3);
                        ((ServerLevel) event.getEntity().level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                                event.getEntity().getX() + 0.5, event.getEntity().getY() + 1.5,
                                event.getEntity().getZ() + 0.5, 10, 0, 0, 0, 3);
                        ((ServerLevel) event.getEntity().level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                                event.getEntity().getX() + 0.5, event.getEntity().getY() + 1.5,
                                event.getEntity().getZ() + 0.5, 10, 0, 0, 0, 3);
                    }

                    if (_livEnt.hasEffect(EffectCore.KNOCKBACK_BOOST) && _livEnt.getMainHandItem().isEmpty()) {
                        ((ServerLevel) event.getEntity().level()).sendParticles(ParticleTypes.GUST_EMITTER_SMALL, event.getEntity().getX(), event.getEntity().getEyeY(), event.getEntity().getZ(), 1, 0, 0, 0, 0.05);
                    }

                    if (_livEnt.hasEffect(EffectCore.THUNDER_PUNCH)) {
                        if (_livEnt.getMainHandItem().isEmpty()) {
                            LightningBolt thunder = new LightningBolt(EntityType.LIGHTNING_BOLT, _livEnt.level());
                            thunder.setPos(event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ());
                            event.getEntity().level().addFreshEntity(thunder);
                        }
                    }

                    if (_livEnt.hasEffect(EffectCore.THUNDER_SLASH)) {
                        if (_livEnt.getMainHandItem().getItem() instanceof SwordItem || _livEnt.getMainHandItem().getItem() instanceof BaseBlasterItem) {
                            LightningBolt thunder = new LightningBolt(EntityType.LIGHTNING_BOLT, _livEnt.level());
                            thunder.setPos(event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ());
                            event.getEntity().level().addFreshEntity(thunder);
                        }
                    }


                    if (_livEnt.hasEffect(EffectCore.ELECTRIC_PUNCH) && _livEnt.getMainHandItem().isEmpty()) {
                        event.getEntity().addEffect(new MobEffectInstance(EffectCore.ELECTRIC_SHOCK, 500, _livEnt.getEffect(EffectCore.ELECTRIC_PUNCH).getAmplifier(), false, false));
                    }

                    if (_livEnt.hasEffect(EffectCore.ELECTRIC_SLASH) && (_livEnt.getMainHandItem().getItem() instanceof SwordItem || _livEnt.getMainHandItem().getItem() instanceof BaseBlasterItem)) {
                        event.getEntity().addEffect(new MobEffectInstance(EffectCore.ELECTRIC_SHOCK, 500, _livEnt.getEffect(EffectCore.ELECTRIC_SLASH).getAmplifier(), false, false));
                    }


                    if (_livEnt.hasEffect(EffectCore.RIDER_POISON_HAND) || _livEnt.hasEffect(EffectCore.POISON_PUNCH)) {
                        if (_livEnt.getMainHandItem().isEmpty()) {
                            event.getEntity().addEffect(new MobEffectInstance(MobEffects.POISON, 500, 1, true, true));
                        }
                    }

                    if (_livEnt.hasEffect(EffectCore.POISON_SLASH) && (_livEnt.getMainHandItem().getItem() instanceof SwordItem || _livEnt.getMainHandItem().getItem() instanceof BaseBlasterItem)) {
                        event.getEntity().addEffect(new MobEffectInstance(MobEffects.POISON, 500, 1, true, true));
                    }


                    if (_livEnt.hasEffect(EffectCore.WITHER_PUNCH)) {
                        if (_livEnt.getMainHandItem().isEmpty()) {
                            event.getEntity().addEffect(new MobEffectInstance(MobEffects.WITHER, 500, _livEnt.getEffect(EffectCore.WITHER_PUNCH).getAmplifier(), false, true));
                        }
                    }

                    if (_livEnt.hasEffect(EffectCore.WITHER_SLASH) && (_livEnt.getMainHandItem().getItem() instanceof SwordItem || _livEnt.getMainHandItem().getItem() instanceof BaseBlasterItem)) {
                        event.getEntity().addEffect(new MobEffectInstance(MobEffects.WITHER, 500, _livEnt.getEffect(EffectCore.WITHER_SHOT).getAmplifier(), false, true));
                    }


                    if (_livEnt.hasEffect(EffectCore.FIRE_PUNCH)) {
                        if (_livEnt.getMainHandItem().isEmpty()) {
                            event.getEntity().igniteForSeconds(_livEnt.getEffect(EffectCore.FIRE_PUNCH).getAmplifier() + 1);
                        }
                    }

                    if (_livEnt.hasEffect(EffectCore.FIRE_SLASH)) {
                        if (_livEnt.getMainHandItem().getItem() instanceof SwordItem || _livEnt.getMainHandItem().getItem() instanceof BaseBlasterItem) {
                            event.getEntity().igniteForSeconds(_livEnt.getEffect(EffectCore.FIRE_SLASH).getAmplifier() + 1);
                        }
                    }

                    if (event.getEntity().hasEffect(EffectCore.FIRE_ARMOR)) {
                        _livEnt.igniteForSeconds(event.getEntity().getEffect(EffectCore.FIRE_ARMOR).getAmplifier() + 1);
                    }


                    if (_livEnt.hasEffect(EffectCore.EXPLOSION_PUNCH)) {
                        if (_livEnt.getMainHandItem().isEmpty()) {
                            boolean flag = event.getEntity().level().getLevelData().getGameRules().getRule(GameRules.RULE_MOBGRIEFING).get();
                            event.getEntity().level().explode(null, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), _livEnt.getEffect(EffectCore.EXPLOSION_PUNCH).getAmplifier(), flag, Level.ExplosionInteraction.MOB);
                        }
                    }

                    if (_livEnt.hasEffect(EffectCore.EXPLOSION_SLASH)) {
                        if (_livEnt.getMainHandItem().getItem() instanceof SwordItem || _livEnt.getMainHandItem().getItem() instanceof BaseBlasterItem) {
                            boolean flag = event.getEntity().level().getLevelData().getGameRules().getRule(GameRules.RULE_MOBGRIEFING).get();
                            event.getEntity().level().explode(null, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), _livEnt.getEffect(EffectCore.EXPLOSION_SLASH).getAmplifier(), flag, Level.ExplosionInteraction.MOB);
                        }
                    }


                    if (event.getEntity().hasEffect(EffectCore.REFLECT)) {
                        event.getSource().getEntity().hurt(event.getSource(), (event.getOriginalDamage()) * (1 + event.getEntity().getEffect(EffectCore.REFLECT).getAmplifier() + 1));
                    }

                } else if (event.getSource().is(DamageTypes.ARROW) || event.getSource().is(DamageTypes.MOB_PROJECTILE)) {
                    if (_livEnt.hasEffect(EffectCore.THUNDER_SHOT)) {
                        LightningBolt thunder = new LightningBolt(EntityType.LIGHTNING_BOLT, _livEnt.level());
                        thunder.setPos(event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ());
                        event.getEntity().level().addFreshEntity(thunder);
                    }

                    if (_livEnt.hasEffect(EffectCore.ELECTRIC_SHOT)) {
                        event.getEntity().addEffect(new MobEffectInstance(EffectCore.ELECTRIC_SHOCK, 500, _livEnt.getEffect(EffectCore.ELECTRIC_SHOCK).getAmplifier(), false, false));
                    }

                    if (_livEnt.hasEffect(EffectCore.POISON_SHOT)) {
                        event.getEntity().addEffect(new MobEffectInstance(MobEffects.POISON, 500, 1, false, true));
                    }

                    if (_livEnt.hasEffect(EffectCore.WITHER_SHOT)) {
                        event.getEntity().addEffect(new MobEffectInstance(MobEffects.WITHER, 500, _livEnt.getEffect(EffectCore.WITHER_SHOT).getAmplifier(), false, true));
                    }

                    if (_livEnt.hasEffect(EffectCore.FIRE_SHOT)) {
                        event.getEntity().setRemainingFireTicks(25 * (Objects.requireNonNull(_livEnt.getEffect(EffectCore.FIRE_SHOT)).getAmplifier() + 1));
                    }

                    if (_livEnt.hasEffect(EffectCore.EXPLOSION_SHOT)) {
                        boolean flag = event.getEntity().level().getLevelData().getGameRules().getRule(GameRules.RULE_MOBGRIEFING).get();
                        event.getEntity().level().explode(null, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), _livEnt.getEffect(EffectCore.EXPLOSION_SHOT).getAmplifier(), flag, Level.ExplosionInteraction.MOB);
                    }
                }
            }
        }

        @SubscribeEvent
        public void formTimeout(MobEffectEvent.Expired event) {
            LivingEntity entity = event.getEntity();
            ItemStack belt = entity.getItemBySlot(EquipmentSlot.FEET);

            if (event.getEffectInstance() != null && event.getEffectInstance().getEffect() == EffectCore.FORM_TIMEOUT
                    && belt.getItem() instanceof RiderDriverItem driver && driver.isTransformed(entity)) {
                driver.timeoutForms(entity, belt);
            }
        }

        @SubscribeEvent
        public void riderVisibility(LivingEvent.LivingVisibilityEvent event) {
            if (event.getEntity().getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem belt
                    && belt.isTransformed(event.getEntity()) && event.getEntity().hasEffect(MobEffects.INVISIBILITY)) {
                event.modifyVisibility(event.getVisibilityModifier() * 0.1);
            }
        }

        @SubscribeEvent
        public void addCustomWandererTrades(WandererTradesEvent event) {
            List<ItemListing> trades = event.getGenericTrades();
            trades.add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 2),
                    new ItemStack(Rider_Blocks.GINGA_METEOR.get(), 1), 10, 8, 0.02F));
            trades.add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 2),
                    new ItemStack(Rider_Blocks.HELHEIM_SAPLING.get(), 1), 10, 8, 0.02F));
            trades.add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 5),
                    new ItemStack(Rider_Blocks.GASHAPON_MACHINE.get(), 1), 10, 8, 0.02F));
            trades.add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 2),
                    new ItemStack(CrossSeriesRiderItems.KUUGA_AMAZING_MIGHTY_ARTIST.get(), 1), 10, 8, 0.02F));
            trades.add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 3),
                    new ItemStack(ZiORiderItems.TOY_ROBOT.get(), 1), 10, 8, 0.02F));
            trades.add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 3),
                    new ItemStack(ZiORiderItems.QUESTIOABLE_WATCH.get(), 1), 10, 8, 0.02F));
            trades.add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 5),
                    new ItemStack(Rider_Blocks.YAMININ_BOSS_BLOCK.get(), 1), 10, 8, 0.02F));
            trades.add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 3),
                    new ItemStack(RyukiRiderItems.BLANK_DECK.get(), 1), 10, 8, 0.02F));
        }


        @SubscribeEvent
        public void addCustomTrades(VillagerTradesEvent event) {
            Int2ObjectMap<List<ItemListing>> trades = event.getTrades();
            if (event.getType() == VillagerProfession.LIBRARIAN) {
                trades.get(1).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 2),
                        new ItemStack(IchigoRiderItems.RIDER3_VS_THE_DEMON_OF_GENERAL_BLACK.get(), 1), 10, 8, 0.02F));
                trades.get(1).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 2),
                        new ItemStack(KuugaRiderItems.KUUGA_MANGA.get(), 1), 10, 8, 0.02F));
                trades.get(2).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 2),
                        new ItemStack(ModdedItemCore.CARD_WARRIOR_KAMEN_RIDER_MANGA.get(), 1), 10, 8, 0.02F));
            } else if (event.getType() == VillagerProfession.CLERIC) {
                trades.get(1).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 5),
                        new ItemStack(GotchardRiderItems.ALCHEMIST_RING_NO_GEM.get(), 1), 10, 8, 0.02F));
            } else if (event.getType() == RiderVillagers.SHOCKER_VILLAGER.get()) {
                trades.get(1).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(XRiderItems.RIDOL_CORE.get(), 1),
                        new ItemStack(XRiderItems.PERFECTER.get(), 1), 10, 8, 0.02F));
                trades.get(1).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 2),
                        new ItemStack(ModdedItemCore.SHOCKER_EMBLEM.get(), 1), 10, 8, 0.02F));
                trades.get(1).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 2),
                        new ItemStack(ModdedItemCore.TAKOYAKI.get(), 4), 10, 8, 0.02F));
                trades.get(1).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(ModdedItemCore.RIDER_CIRCUIT.get(), 5),
                        new ItemStack(Items.EMERALD, 1), 10, 8, 0.02F));
                trades.get(2).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 2),
                        new ItemStack(ShinRiderItems.SHIN_STONE.get(), 1), 10, 8, 0.02F));
                trades.get(2).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 2),
                        new ItemStack(ZORiderItems.ZO_STONE.get(), 1), 10, 8, 0.02F));
                trades.get(2).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 2),
                        new ItemStack(JRiderItems.J_STONE.get(), 1), 10, 8, 0.02F));
                trades.get(3).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 2),
                        new ItemStack(GRiderItems.GORO_WINE_BOTTLE.get(), 1), 10, 8, 0.02F));
                trades.get(3).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 4),
                        new ItemStack(ModdedItemCore.SINISTER_PACHINKO_BALL.get(), 1), 10, 8, 0.02F));
                trades.get(4).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 2),
                        new ItemStack(Rider_Blocks.ICHIGO_CHAIR.get(), 1), 10, 8, 0.02F));
                trades.get(4).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 2),
                        new ItemStack(IchigoRiderItems.NOPHOON_CORE.get(), 1), 10, 8, 0.02F));
            } else if (event.getType() == RiderVillagers.HUMAGEAR_VILLAGER.get()) {
                trades.get(1).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 1),
                        new ItemStack(ZeroOneRiderItems.BLANK_PROGRISEKEY.get(), 3), 10, 8, 0.02F));
                trades.get(1).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(ZeroOneRiderItems.HIDEN_METAL.get(), 3),
                        new ItemStack(Items.EMERALD, 1), 10, 8, 0.02F));
                trades.get(2).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 2),
                        new ItemStack(ZeroOneRiderItems.HUMAGEAR_PROGRISEKEY.get(), 3), 10, 8, 0.02F));
                trades.get(3).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 12),
                        new ItemStack(ZeroOneRiderItems.THOUSAND_KEY.get(), 1), 10, 8, 0.02F));
                trades.get(3).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 30),
                        new ItemStack(ZeroOneRiderItems.ZAIA_SPEC.get(), 1), 10, 8, 0.02F));
                trades.get(3).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 4),
                        new ItemStack(ZeroOneRiderItems.AIMS_RISEPHONE.get(), 1), 10, 8, 0.02F));
                trades.get(5).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 4),
                        new ItemStack(MusicDiscItems.REAL_X_EYEZ_MUSIC_DISC.get(), 1), 10, 8, 0.02F));
            } else if (event.getType() == RiderVillagers.KAMEN_CAFE_BUTLER.get()) {
                trades.get(1).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 1),
                        new ItemStack(RideKamensItems.CANDY.get(), 3), 10, 8, 0.02F));
                trades.get(1).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 2),
                        new ItemStack(RideKamensItems.CONTRACT_CHAOSTONE.get(), 1), 10, 8, 0.02F));
                trades.get(2).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 6),
                        new ItemStack(RideKamensItems.GASHA_TICKET.get(), 1), 10, 8, 0.02F));
                trades.get(2).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 2),
                        new ItemStack(RideKamensItems.ENERGY_DRINK.get(), 1), 10, 8, 0.02F));
            } else if (event.getType() == RiderVillagers.AGENT_VILLAGER.get()) {
                trades.get(1).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(GavvRiderItems.HEATPRESS, 1),
                        new ItemStack(GavvRiderItems.DOPPUDDING_GOCHIZO.get(), 1), 10, 8, 0.02F));
                trades.get(1).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(GavvRiderItems.HEATPRESS, 2),
                        new ItemStack(GavvRiderItems.PURUJELLY_GOCHIZO.get(), 1), 10, 8, 0.02F));
                trades.get(2).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(GavvRiderItems.HEATPRESS, 3),
                        new ItemStack(Rider_Blocks.DARK_TREAT_GLASS.get(), 1), 10, 8, 0.02F));
                trades.get(2).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 3),
                        new ItemStack(Rider_Blocks.GOCHIZO_JAR.get(), 1), 10, 8, 0.02F));
                trades.get(3).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(GavvRiderItems.HEATPRESS, 5),
                        new ItemStack(GavvRiderItems.PURUJELLY_NOIR_GOCHIZO.get(), 1), 10, 8, 0.02F));
            } else if (event.getType() == RiderVillagers.CANDYSHOP_VILLAGER.get()) {
                trades.get(1).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 1),
                        new ItemStack(ModdedItemCore.DANGO.get(), 2), 10, 8, 0.02F));
                trades.get(3).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 1),
                        new ItemStack(ModdedItemCore.PUDDING.get(), 1), 10, 8, 0.02F));
                trades.get(1).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 1),
                        new ItemStack(ModdedItemCore.GUMMI_CANDY.get(), 1), 10, 8, 0.02F));
                trades.get(1).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 1),
                        new ItemStack(ModdedItemCore.POTATO_SNACKS.get(), 1), 10, 8, 0.02F));
                trades.get(2).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 1),
                        new ItemStack(ModdedItemCore.CHOCOLATE_BAR.get(), 1), 10, 8, 0.02F));
                trades.get(2).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 1),
                        new ItemStack(ModdedItemCore.LOLLIPOP.get(), 1), 10, 8, 0.02F));
                trades.get(2).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 1),
                        new ItemStack(RideKamensItems.CANDY.get(), 1), 10, 8, 0.02F));
                trades.get(1).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 1),
                        new ItemStack(ModdedItemCore.MARSHMALLOW.get(), 1), 10, 8, 0.02F));
                trades.get(1).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 1),
                        new ItemStack(Items.COOKIE, 1), 10, 8, 0.02F));
                trades.get(2).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 1),
                        new ItemStack(ModdedItemCore.CORN_SNACK.get(), 1), 10, 8, 0.02F));
                trades.get(3).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 1),
                        new ItemStack(ModdedItemCore.MAYO.get(), 1), 10, 8, 0.02F));
            } else if (event.getType() == RiderVillagers.COLLECTOR_VILLAGER.get()) {
                trades.get(1).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 1),
                        new ItemStack(ExtraRiderItems.GASHAPON_CAPSULE.get(), 1), 10, 8, 0.02F));
                trades.get(2).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 1),
                        new ItemStack(Rider_Blocks.RED_ICHIGO_CHAIR.get(), 1), 10, 8, 0.02F));
                trades.get(1).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 1),
                        new ItemStack(ExtraRiderItems.RIDERMAN_HELMET.get(), 1), 10, 8, 0.02F));
                trades.get(1).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 2),
                        new ItemStack(ExtraRiderItems.GIFT.get(), 1), 10, 8, 0.02F));
                trades.get(2).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 1),
                        new ItemStack(ReviceRiderItems.TOYSAURUS_VISTAMP.get(), 1), 10, 8, 0.02F));
                trades.get(2).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 3),
                        new ItemStack(CrossSeriesRiderItems.KUUGA_AMAZING_MIGHTY_ARTIST.get(), 1), 10, 8, 0.02F));
                trades.get(2).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 2),
                        new ItemStack(MobsCore.BICYCLE_SPAWN_EGG.get(), 1), 10, 8, 0.02F));
                trades.get(2).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 1),
                        new ItemStack(GhostRiderItems.ORE_SPECTER_GHOST_EYECON.get(), 1), 10, 8, 0.02F));
                trades.get(3).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 3),
                        new ItemStack(ExtraRiderItems.HALLOWEEN_GASHAPON_CAPSULE.get(), 1), 10, 8, 0.02F));
                trades.get(3).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 3),
                        new ItemStack(ExtraRiderItems.VALENTINE_GASHAPON_CAPSULE.get(), 1), 10, 8, 0.02F));
                trades.get(4).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(BladeRiderItems.EVOLUTION_CAUCASUS, 1),
                        new ItemStack(BladeRiderItems.SILVER_EVOLUTION_CAUCASUS.get(), 1), 10, 8, 0.02F));
                trades.get(4).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(KivaRiderItems.TATSULOT, 1),
                        new ItemStack(KivaRiderItems.KIVATTE_FUESTLE.get(), 1), 10, 8, 0.02F));
                trades.get(4).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(FaizRiderItems.FAIZ_BLASTER_MISSION_MEMORY, 1),
                        new ItemStack(FaizRiderItems.FAIZ_GOLD_BLASTER_MISSION_MEMORY.get(), 1), 10, 8, 0.02F));
                trades.get(4).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(AgitoRiderItems.EXCEED_GILLS, 1),
                        new ItemStack(AgitoRiderItems.GOLD_EXCEED_GILLS.get(), 1), 10, 8, 0.02F));
                trades.get(4).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(RyukiRiderItems.SURVIVE_REKKA, 1),
                        new ItemStack(RyukiRiderItems.SURVIVE_BLACK.get(), 1), 10, 8, 0.02F));
            }
        }
    }


    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(MidaredoujiModel.LAYER_LOCATION, MidaredoujiModel::createBodyLayer);
        event.registerLayerDefinition(ElementaryInvesModel.LAYER_LOCATION, ElementaryInvesModel::createBodyLayer);
        event.registerLayerDefinition(HeartRoidmudeModel.LAYER_LOCATION, HeartRoidmudeModel::createBodyLayer);
        event.registerLayerDefinition(DoggaModel.LAYER_LOCATION, DoggaModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        EntityAttributes.addEntityAttributes(event);
    }

    @SubscribeEvent
    public static void entitySpawnRestriction(RegisterSpawnPlacementsEvent event) {
        event.register(MobsCore.SHOCKER_COMBATMAN.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);


        event.register(MobsCore.DESTRON_COMBATMAN.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.GOD_WARFARE_AGENT.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(MobsCore.RED_FOLLWER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(MobsCore.BLACK_SATAN_SOLDIER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(MobsCore.ARI_COMMANDO.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(MobsCore.DOGMA_FIGHTER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(MobsCore.COMBAT_ROID.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(MobsCore.CHAP.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(MobsCore.CHAP_GREY.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.ZU_GUMUN_BA.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.PANTHERAS_LUTEUS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(MobsCore.ANGUIS_MASCULUS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.RIOTROOPER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.BAKENEKO.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(MobsCore.MAKAMOU_NINJA_GROUP.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.ZECTROOPER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkAnyLightMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(MobsCore.SHADOW_TROOPER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkAnyLightMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(MobsCore.NEOTROOPER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkAnyLightMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.NEW_MOLE_IMAGIN_SAND.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.MOOSE_FANGIRE.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.DECADE_VIOLENT.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.MASQUERADE.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(MobsCore.FOUNDATION_X_MASQUERADE.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.YUMMY.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(MobsCore.GHOULS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.MAGE_FOOTSOLDIER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(MobsCore.MAGE_CAPTAIN.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.ELEMENTARY_INVES_RED.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.ROIDMUDE.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(MobsCore.REAPER_LEGION.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.GAMMA_COMMANDO.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(MobsCore.DARK_GHOST.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(MobsCore.DARK_NECROM.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);


        event.register(MobsCore.BUGSTERVIRUS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(MobsCore.NEBULA_BUGSTERVIRUS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(MobsCore.RIDEPLAYER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.TOUTOGUARDIAN.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(MobsCore.SEITOGUARDIAN.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(MobsCore.HOKUTOGUARDIAN.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(MobsCore.DOWNFALL_GUARDIAN.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(MobsCore.HARD_GUARDIAN.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.KASSHINE.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.TRILOBITE_MAGIA.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(MobsCore.DODO_MAGIA_CHICK.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(MobsCore.BATTLE_RAIDER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(MobsCore.ABADDON.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.SHIMI.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(MobsCore.CHARYBDIS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.GIFF_JUNIOR.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.PAWN_JYAMATO.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(MobsCore.JYAMATO_RIDER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkAnyLightMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(MobsCore.GM_RIDER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkAnyLightMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(MobsCore.END_RIDER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkAnyLightMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(MobsCore.KUROKAGE_TROOPER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.MALGAM.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(MobsCore.GOLEM.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(MobsCore.DREATROOPER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.AGENT.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.BATTA_AUGMENT.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);


        event.register(MobsCore.ANKH.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AnkhEntity::checkAnkhSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);


    }
}
