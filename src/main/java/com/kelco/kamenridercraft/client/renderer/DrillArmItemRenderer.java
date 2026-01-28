package com.kelco.kamenridercraft.client.renderer;

import com.kelco.kamenridercraft.client.item_models.DrillArmModel;
import com.kelco.kamenridercraft.item.ichigo.DrillArmItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class DrillArmItemRenderer extends GeoItemRenderer<DrillArmItem> {
	public DrillArmItemRenderer() {
        super(new DrillArmModel());
    }
}