package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.ai.FlyingBossControl;
import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.Hibiki_Rider_Items;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class MidaredoujiEntity extends BaseHenchmenEntity {
	public MidaredoujiEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="midaredouji";
        this.setDropChance(EquipmentSlot.MAINHAND, 0.0F);
        this.setDropChance(EquipmentSlot.OFFHAND, 0.0F);
        this.moveControl = new FlyingBossControl(this, 20);
    }

    @Override
    public void actuallyHurt(DamageSource source, float amount) {
        super.actuallyHurt(source, amount);
        if(!this.level().isClientSide() && source.getEntity() instanceof Player playerIn) {
            if (this.getHealth()<40 && playerIn.getInventory().countItem(Hibiki_Rider_Items.HENSHIN_ONSA_KURENAI.get().asItem())!=0 && this.getItemBySlot(EquipmentSlot.MAINHAND).isEmpty()) {
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Hibiki_Rider_Items.MIDAREDOUJI_BLADE.get()));
                this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(Hibiki_Rider_Items.MIDAREDOUJI_BLADE.get()));
            }
        }
    }

	public static AttributeSupplier.Builder setAttributes() {
		return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 128.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.30F)
                .add(Attributes.FLYING_SPEED, 0.30F)
        		.add(Attributes.ATTACK_DAMAGE, 5.0D)
        		.add(Attributes.MAX_HEALTH, 60.0D);
     }
}