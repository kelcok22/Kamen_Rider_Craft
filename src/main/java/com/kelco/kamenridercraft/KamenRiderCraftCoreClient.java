package com.kelco.kamenridercraft;

import com.zigythebird.playeranim.animation.PlayerAnimationController;
import com.zigythebird.playeranim.api.PlayerAnimationFactory;
import com.zigythebird.playeranimcore.enums.PlayState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

import static com.zigythebird.playeranim.PlayerAnimLibMod.ANIMATION_LAYER_ID;

@Mod(value = KamenRiderCraftCore.MOD_ID, dist = Dist.CLIENT)
public class KamenRiderCraftCoreClient {
    public KamenRiderCraftCoreClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    public static void registerPlayerAnimations( FMLClientSetupEvent event) {
        // Rider Attacks
        PlayerAnimationFactory.ANIMATION_DATA_FACTORY.registerFactory(ANIMATION_LAYER_ID, 17500,
                player -> new PlayerAnimationController(player,
                        (controller, state, animSetter) -> PlayState.STOP
                )
        );
        /*
        // Poses
        PlayerAnimationFactory.ANIMATION_DATA_FACTORY.registerFactory(ANIMATION_LAYER_ID, 20000,
                player -> new PlayerAnimationController(player,
                        (controller, state, animSetter) -> PlayState.STOP
                )
        );
        // Bike Riding
        PlayerAnimationFactory.ANIMATION_DATA_FACTORY.registerFactory(ANIMATION_LAYER_ID, 20000,
                player -> new PlayerAnimationController(player,
                        (controller, state, animSetter) -> PlayState.STOP
                )
        );
        // Flying
        PlayerAnimationFactory.ANIMATION_DATA_FACTORY.registerFactory(ANIMATION_LAYER_ID, 20000,
                player -> new PlayerAnimationController(player,
                        (controller, state, animSetter) -> PlayState.STOP
                )
        );
        */
    }
}


