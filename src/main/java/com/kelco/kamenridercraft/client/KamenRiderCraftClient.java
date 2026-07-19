package com.kelco.kamenridercraft.client;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.zigythebird.playeranim.animation.PlayerAnimationController;
import com.zigythebird.playeranim.api.PlayerAnimationFactory;
import com.zigythebird.playeranimcore.enums.PlayState;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

import static com.kelco.kamenridercraft.KamenRiderCraftCore.MOD_ID;

@Mod(value = KamenRiderCraftCore.MOD_ID, dist = Dist.CLIENT)
public class KamenRiderCraftClient {
    public static final ResourceLocation POSE_LAYER_ID = ResourceLocation.fromNamespaceAndPath(MOD_ID, "pose_layer");
    public static final ResourceLocation HENSHIN_LAYER_ID = ResourceLocation.fromNamespaceAndPath(MOD_ID, "henshin_layer");
    public static final ResourceLocation ATTACK_LAYER_ID = ResourceLocation.fromNamespaceAndPath(MOD_ID, "attack_layer");
    public static final ResourceLocation RIDER_POSITIONING_ID = ResourceLocation.fromNamespaceAndPath(MOD_ID, "rider_positioning_layer");
    public static final ResourceLocation RIDER_WALK_ID = ResourceLocation.fromNamespaceAndPath(MOD_ID, "rider_walk_layer");

    public KamenRiderCraftClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    public static void registerPlayerAnimations() {
        // Poses
        PlayerAnimationFactory.ANIMATION_DATA_FACTORY.registerFactory(POSE_LAYER_ID, 17500,
                player -> new PlayerAnimationController(player,
                        (controller, state, animSetter) -> PlayState.STOP
                )
        );
        //Rider Henshin Sequence
        PlayerAnimationFactory.ANIMATION_DATA_FACTORY.registerFactory(HENSHIN_LAYER_ID, 18500,
                player -> new PlayerAnimationController(player,
                        (controller, state, animSetter) -> PlayState.STOP
                )
        );
        // Rider Attacks
        PlayerAnimationFactory.ANIMATION_DATA_FACTORY.registerFactory(ATTACK_LAYER_ID, 25000,
                player -> new PlayerAnimationController(player,
                        (controller, state, animSetter) -> PlayState.STOP
                )
        );
        // Bike Riding
        PlayerAnimationFactory.ANIMATION_DATA_FACTORY.registerFactory(RIDER_POSITIONING_ID, 20000,
                player -> new PlayerAnimationController(player,
                        (controller, state, animSetter) -> PlayState.STOP
                )
        );
        // Rider Walk Modifications
        PlayerAnimationFactory.ANIMATION_DATA_FACTORY.registerFactory(RIDER_WALK_ID, 16000,
                player -> new PlayerAnimationController(player,
                        (controller, state, animSetter) -> PlayState.STOP
                )
        );
    }
}


