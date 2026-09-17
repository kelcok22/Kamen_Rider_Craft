package com.kelco.kamenridercraft.client.model.entity.mob;

import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import net.minecraft.client.model.AbstractZombieModel;
import net.minecraft.client.model.geom.ModelPart;


public class FootSoldierModel<T extends BaseHenchmenEntity> extends AbstractZombieModel<T> {
    public FootSoldierModel(ModelPart root) {
        super(root);
    }

    public boolean isAggressive(T entity) {
        return entity.isAggressive();
    }
}
