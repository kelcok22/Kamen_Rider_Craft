package com.kelco.kamenridercraft.client.renderer;

import com.kelco.kamenridercraft.client.item_models.FrontArmedUnitModel;
import com.kelco.kamenridercraft.item.heisei_phase_2.ex_aid.FrontArmedUnitItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class FrontArmedUnitRenderer extends GeoItemRenderer<FrontArmedUnitItem> {
    public FrontArmedUnitRenderer() {
        super(new FrontArmedUnitModel());
    }
}