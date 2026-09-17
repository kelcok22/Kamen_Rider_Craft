package com.kelco.kamenridercraft.client.renderer.item;

import com.kelco.kamenridercraft.client.model.item.RearArmedUnitModel;
import com.kelco.kamenridercraft.item.heisei_phase_2.ex_aid.RearArmedUnitItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;


public class RearArmedUnitRenderer extends GeoItemRenderer<RearArmedUnitItem> {
    public RearArmedUnitRenderer() {
        super(new RearArmedUnitModel());
    }
}