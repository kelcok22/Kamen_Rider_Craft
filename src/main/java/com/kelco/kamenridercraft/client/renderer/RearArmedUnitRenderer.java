package com.kelco.kamenridercraft.client.renderer;

import com.kelco.kamenridercraft.client.item_models.RearArmedUnitModel;
import com.kelco.kamenridercraft.item.heisei_phase_2.ex_aid.RearArmedUnitItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class RearArmedUnitRenderer extends GeoItemRenderer<RearArmedUnitItem> {
    public RearArmedUnitRenderer() {
        super(new RearArmedUnitModel());
    }
}