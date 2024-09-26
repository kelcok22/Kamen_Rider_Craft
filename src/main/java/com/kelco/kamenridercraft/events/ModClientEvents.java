package com.kelco.kamenridercraft.events;

import com.kelco.kamenridercraft.client.renderer.BasicEntityRenderer;
import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RenderLivingEvent;

public class ModClientEvents {




    public static class ClientEvents {



        @SubscribeEvent
        public void addRenderLivingEvent(RenderLivingEvent.Pre event) {

            if (event.getEntity().getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem belt) {
                if (RiderDriverItem.get_Form_Item(event.getEntity().getItemBySlot(EquipmentSlot.FEET), 1).get_PalyerModelInvisible())
                    event.getEntity().setInvisible(belt.isTransformed(event.getEntity()));
            }

            float size = 1;
            boolean Tall = event.getEntity().hasEffect(Effect_core.STRETCH);

            if (event.getEntity().hasEffect(Effect_core.STRETCH)) {
                size = size + ((event.getEntity().getEffect(Effect_core.STRETCH).getAmplifier()) + 1);
            }

            float size2 = event.getEntity().hasEffect(Effect_core.STRETCH) ? 1 : size;

            if (event.getEntity().hasEffect(Effect_core.FLAT)) {
              size2 = 0.1f;
            }
            float size3 = event.getEntity().hasEffect(Effect_core.STRETCH) ? 1 : size;
            if (event.getEntity().hasEffect(Effect_core.WIDE)) {
                size2 = (float) (size2 * 3);
                size3 = (float) (size3 * 3);
            }
            event.getPoseStack().scale(size3, size, size2);
        }
    }
}
