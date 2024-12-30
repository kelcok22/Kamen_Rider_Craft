package com.kelco.kamenridercraft.entities.footSoldiers;

import com.kelco.kamenridercraft.ServerConfig;
import com.kelco.kamenridercraft.entities.MobsCore;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class ElementaryInvesRedEntity extends BaseHenchmenEntity {

	private BaseHenchmenEntity boss;

    public ElementaryInvesRedEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="elementary_inves_red";
    }
}