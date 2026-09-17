package com.kelco.kamenridercraft.client.renderer.item;

import com.kelco.kamenridercraft.client.model.item.DrillArmModel;
import com.kelco.kamenridercraft.item.showa.V3.DrillArmItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;


public class DrillArmItemRenderer extends GeoItemRenderer<DrillArmItem> {
    public DrillArmItemRenderer() {
        super(new DrillArmModel());
    }
}