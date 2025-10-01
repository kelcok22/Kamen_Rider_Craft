package com.kelco.kamenridercraft.entities;

import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import net.minecraft.client.model.AbstractZombieModel;
import net.minecraft.client.model.geom.ModelPart;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FootSoldierModel<T extends BaseHenchmenEntity> extends AbstractZombieModel<T> {
    public FootSoldierModel(ModelPart root) {
        super(root);
    }

    public boolean isAggressive(T entity) {
        return entity.isAggressive();
    }
}
