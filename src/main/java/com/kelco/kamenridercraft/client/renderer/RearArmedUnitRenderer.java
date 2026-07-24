package com.kelco.kamenridercraft.client.renderer;

import com.kelco.kamenridercraft.client.item_models.RearArmedUnitModel;
import com.kelco.kamenridercraft.item.base_items.GeoBlasterItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class RearArmedUnitRenderer extends GeoItemRenderer<GeoBlasterItem> {
    public RearArmedUnitRenderer() {
        super(new RearArmedUnitModel());
    }
}