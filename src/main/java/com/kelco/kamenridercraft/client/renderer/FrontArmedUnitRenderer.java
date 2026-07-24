package com.kelco.kamenridercraft.client.renderer;

import com.kelco.kamenridercraft.client.item_models.FrontArmedUnitModel;
import com.kelco.kamenridercraft.item.base_items.GeoBlasterItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class FrontArmedUnitRenderer extends GeoItemRenderer<GeoBlasterItem> {
    public FrontArmedUnitRenderer() {
        super(new FrontArmedUnitModel());
    }
}