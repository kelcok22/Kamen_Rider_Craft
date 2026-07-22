package com.kelco.kamenridercraft;

import com.kelco.kamenridercraft.client.KeyBindings;
import com.kelco.kamenridercraft.network.payload.AbilityKeyPayload;
import com.kelco.kamenridercraft.network.payload.BeltKeyPayload;
import com.kelco.kamenridercraft.network.payload.PoseKeyPayload;
import com.kelco.kamenridercraft.world.attribute.Attributes;
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

import java.util.Objects;

import static com.kelco.kamenridercraft.KamenRiderCraftCore.MOD_ID;

@Mod(value = KamenRiderCraftCore.MOD_ID, dist = Dist.CLIENT)
public class KamenRiderCraftCoreClient {
    public static final ResourceLocation POSE_LAYER_ID = ResourceLocation.fromNamespaceAndPath(MOD_ID, "pose_layer");
    public static final ResourceLocation HENSHIN_LAYER_ID = ResourceLocation.fromNamespaceAndPath(MOD_ID, "henshin_layer");
    public static final ResourceLocation ATTACK_LAYER_ID = ResourceLocation.fromNamespaceAndPath(MOD_ID, "attack_layer");
    public static final ResourceLocation RIDER_POSITIONING_ID = ResourceLocation.fromNamespaceAndPath(MOD_ID, "rider_positioning_layer");
    public static final ResourceLocation RIDER_WALK_ID = ResourceLocation.fromNamespaceAndPath(MOD_ID, "rider_walk_layer");

    public KamenRiderCraftCoreClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    public static void clientInit(IEventBus bus) {
        eventSetup(bus);
    }

    public static void eventSetup(IEventBus eventBus) {
        NeoForge.EVENT_BUS.addListener(KamenRiderCraftCoreClient::clientTick);
    }

    @SubscribeEvent
    public static void clientTick(ClientTickEvent.Post event) {
        Player player = Minecraft.getInstance().player;
        if (player != null) {
            AttributeInstance heldKeyOne = player.getAttribute(Attributes.HELD_ABILITY_KEY_ONE);
            AttributeInstance heldKeyTwo = player.getAttribute(Attributes.HELD_ABILITY_KEY_TWO);

            if (KeyBindings.INSTANCE.BeltKey.consumeClick())
                PacketDistributor.sendToServer(new BeltKeyPayload(0));
            if (KeyBindings.INSTANCE.AbilityKeyOne.consumeClick() && !KeyBindings.INSTANCE.AbilityKeyTwo.isDown() && Objects.requireNonNull(heldKeyOne).getValue() <= 0) {
                PacketDistributor.sendToServer(new AbilityKeyPayload(1));
            } else {
                if (!KeyBindings.INSTANCE.AbilityKeyOne.isDown()) {
                    assert heldKeyOne != null;
                    if (heldKeyOne.getValue() >= 1) {
                        PacketDistributor.sendToServer(new AbilityKeyPayload(3));
                    }
                }
            }
            if (KeyBindings.INSTANCE.AbilityKeyTwo.consumeClick() && !KeyBindings.INSTANCE.AbilityKeyOne.isDown() && Objects.requireNonNull(heldKeyTwo).getValue() <= 0) {
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

        PlayerAnimationFactory.ANIMATION_DATA_FACTORY.registerFactory(POSE_LAYER_ID, 17500,
                player -> new PlayerAnimationController(player,
                        (controller, state, animSetter) -> PlayState.STOP
                )
        );

        PlayerAnimationFactory.ANIMATION_DATA_FACTORY.registerFactory(HENSHIN_LAYER_ID, 18500,
                player -> new PlayerAnimationController(player,
                        (controller, state, animSetter) -> PlayState.STOP
                )
        );

        PlayerAnimationFactory.ANIMATION_DATA_FACTORY.registerFactory(ATTACK_LAYER_ID, 25000,
                player -> new PlayerAnimationController(player,
                        (controller, state, animSetter) -> PlayState.STOP
                )
        );

        PlayerAnimationFactory.ANIMATION_DATA_FACTORY.registerFactory(RIDER_POSITIONING_ID, 20000,
                player -> new PlayerAnimationController(player,
                        (controller, state, animSetter) -> PlayState.STOP
                )
        );

        PlayerAnimationFactory.ANIMATION_DATA_FACTORY.registerFactory(RIDER_WALK_ID, 16000,
                player -> new PlayerAnimationController(player,
                        (controller, state, animSetter) -> PlayState.STOP
                )
        );
    }
}