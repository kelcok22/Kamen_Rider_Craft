package com.kelco.kamenridercraft;

import com.kelco.kamenridercraft.client.KeyBindings;
import com.kelco.kamenridercraft.network.payload.AbilityKeyPayload;
import com.kelco.kamenridercraft.network.payload.BeltKeyPayload;
import com.kelco.kamenridercraft.network.payload.PoseKeyPayload;
import com.kelco.kamenridercraft.world.attribute.KRCAttributes;
import com.zigythebird.playeranim.animation.PlayerAnimationController;
import com.zigythebird.playeranim.api.PlayerAnimationFactory;
import com.zigythebird.playeranimcore.enums.PlayState;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.network.PacketDistributor;

import static com.kelco.kamenridercraft.KamenRiderCraftCore.MOD_ID;

@Mod(value = KamenRiderCraftCore.MOD_ID, dist = Dist.CLIENT)
public class KamenRiderCraftClientCore {
    public static final ResourceLocation POSE_LAYER_ID =
            ResourceLocation.fromNamespaceAndPath(MOD_ID, "pose_layer");
    public static final ResourceLocation HENSHIN_LAYER_ID =
            ResourceLocation.fromNamespaceAndPath(MOD_ID, "henshin_layer");
    public static final ResourceLocation ATTACK_LAYER_ID =
            ResourceLocation.fromNamespaceAndPath(MOD_ID, "attack_layer");

    public static final ResourceLocation SD_LAYER_ID =
            ResourceLocation.fromNamespaceAndPath(MOD_ID, "rider_positioning_layer");
    public static final ResourceLocation FULL_BODY_POSITIONING_ID =
            ResourceLocation.fromNamespaceAndPath(MOD_ID, "full_body_positioning_layer");
    public static final ResourceLocation GLIDING_POSITIONING_ID =
            ResourceLocation.fromNamespaceAndPath(MOD_ID, "gliding_positioning_layer");
    public static final ResourceLocation FLYING_POSITIONING_ID =
            ResourceLocation.fromNamespaceAndPath(MOD_ID, "flying_positioning_layer");

    public static final ResourceLocation RIDER_POSITIONING_ID_1 =
            ResourceLocation.fromNamespaceAndPath(MOD_ID, "rider_positioning_layer_1");
    public static final ResourceLocation RIDER_POSITIONING_ID_2 =
            ResourceLocation.fromNamespaceAndPath(MOD_ID, "rider_positioning_layer_2");
    public static final ResourceLocation RIDER_POSITIONING_ID_3 =
            ResourceLocation.fromNamespaceAndPath(MOD_ID, "rider_positioning_layer_3");
    public static final ResourceLocation RIDER_POSITIONING_ID_4 =
            ResourceLocation.fromNamespaceAndPath(MOD_ID, "rider_positioning_layer_4");
    public static final ResourceLocation RIDER_POSITIONING_ID_5 =
            ResourceLocation.fromNamespaceAndPath(MOD_ID, "rider_positioning_layer_5");

    public int ability_one_key_held_ticks = 0;
    public int ability_two_key_held_ticks = 0;

    public KamenRiderCraftClientCore(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    public static void clientInit(IEventBus bus) {
        eventSetup(bus);
    }

    public static void eventSetup(IEventBus eventBus) {
        NeoForge.EVENT_BUS.addListener(KamenRiderCraftClientCore::clientTick);
    }

    @SubscribeEvent
    public static void clientTick(ClientTickEvent.Post event) {
        Player player = Minecraft.getInstance().player;
        if (player != null) {
            AttributeInstance heldKeyOne = player.getAttribute(KRCAttributes.HELD_ABILITY_KEY_ONE);
            AttributeInstance heldKeyTwo = player.getAttribute(KRCAttributes.HELD_ABILITY_KEY_TWO);

            if (KeyBindings.INSTANCE.BeltKey.consumeClick())
                PacketDistributor.sendToServer(new BeltKeyPayload(0));
            if (KeyBindings.INSTANCE.AbilityKeyOne.consumeClick() && !KeyBindings.INSTANCE.AbilityKeyTwo.isDown()
                    && heldKeyOne.getValue() <= 0) {
                PacketDistributor.sendToServer(new AbilityKeyPayload(1));
            } else {
                if (!KeyBindings.INSTANCE.AbilityKeyOne.isDown()) {
                    assert heldKeyOne != null;
                    if (heldKeyOne.getValue() >= 1) {
                        PacketDistributor.sendToServer(new AbilityKeyPayload(3));
                    }
                }
            }
            if (KeyBindings.INSTANCE.AbilityKeyTwo.consumeClick() && !KeyBindings.INSTANCE.AbilityKeyOne.isDown()
                    && heldKeyTwo.getValue() <= 0) {
                PacketDistributor.sendToServer(new AbilityKeyPayload(2));
            } else {
                if (!KeyBindings.INSTANCE.AbilityKeyTwo.isDown()) {
                    assert heldKeyTwo != null;
                    if (heldKeyTwo.getValue() >= 1) {
                        PacketDistributor.sendToServer(new AbilityKeyPayload(4));
                    }
                }
            }
            if (KeyBindings.INSTANCE.PoseKey.consumeClick())
                PacketDistributor.sendToServer(new PoseKeyPayload(0));
        }
    }

    @SubscribeEvent
    public static void registerPlayerAnimations() {

        PlayerAnimationFactory.ANIMATION_DATA_FACTORY.registerFactory(POSE_LAYER_ID, 21000,
                player -> new PlayerAnimationController(player,
                        (controller, state, animSetter) -> PlayState.STOP
                )
        );

        PlayerAnimationFactory.ANIMATION_DATA_FACTORY.registerFactory(HENSHIN_LAYER_ID, 22000,
                player -> new PlayerAnimationController(player,
                        (controller, state, animSetter) -> PlayState.STOP
                )
        );

        PlayerAnimationFactory.ANIMATION_DATA_FACTORY.registerFactory(ATTACK_LAYER_ID, 25000,
                player -> new PlayerAnimationController(player,
                        (controller, state, animSetter) -> PlayState.STOP
                )
        );


        PlayerAnimationFactory.ANIMATION_DATA_FACTORY.registerFactory(FULL_BODY_POSITIONING_ID, 24000,
                player -> new PlayerAnimationController(player,
                        (controller, state, animSetter) -> PlayState.STOP
                )
        );
        PlayerAnimationFactory.ANIMATION_DATA_FACTORY.registerFactory(FLYING_POSITIONING_ID, 24200,
                player -> new PlayerAnimationController(player,
                        (controller, state, animSetter) -> PlayState.STOP
                )
        );
        PlayerAnimationFactory.ANIMATION_DATA_FACTORY.registerFactory(GLIDING_POSITIONING_ID, 24100,
                player -> new PlayerAnimationController(player,
                        (controller, state, animSetter) -> PlayState.STOP
                )
        );
        PlayerAnimationFactory.ANIMATION_DATA_FACTORY.registerFactory(SD_LAYER_ID, 30000,
                player -> new PlayerAnimationController(player,
                        (controller, state, animSetter) -> PlayState.STOP
                )
        );


        PlayerAnimationFactory.ANIMATION_DATA_FACTORY.registerFactory(RIDER_POSITIONING_ID_1, 20400,
                player -> new PlayerAnimationController(player,
                        (controller, state, animSetter) -> PlayState.STOP
                )
        );
        PlayerAnimationFactory.ANIMATION_DATA_FACTORY.registerFactory(RIDER_POSITIONING_ID_2, 20300,
                player -> new PlayerAnimationController(player,
                        (controller, state, animSetter) -> PlayState.STOP
                )
        );
        PlayerAnimationFactory.ANIMATION_DATA_FACTORY.registerFactory(RIDER_POSITIONING_ID_3, 20200,
                player -> new PlayerAnimationController(player,
                        (controller, state, animSetter) -> PlayState.STOP
                )
        );
        PlayerAnimationFactory.ANIMATION_DATA_FACTORY.registerFactory(RIDER_POSITIONING_ID_4, 20100,
                player -> new PlayerAnimationController(player,
                        (controller, state, animSetter) -> PlayState.STOP
                )
        );
        PlayerAnimationFactory.ANIMATION_DATA_FACTORY.registerFactory(RIDER_POSITIONING_ID_5, 20000,
                player -> new PlayerAnimationController(player,
                        (controller, state, animSetter) -> PlayState.STOP
                )
        );
    }
}