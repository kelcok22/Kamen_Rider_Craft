package com.kelco.kamenridercraft.entity.mobs.bosses;

import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.ExAidRiderItems;
import com.kelco.kamenridercraft.level.ModGameRules;
import com.kelco.kamenridercraft.util.GeneralUtil;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ParaDxEntity extends BaseHenchmenEntity {


	public ParaDxEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
		super(type, level);
		NAME = "para-dx";
		this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ExAidRiderItems.EX_AIDHELMET.get()));
		this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(ExAidRiderItems.EX_AIDCHESTPLATE.get()));
		this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(ExAidRiderItems.EX_AIDLEGGINGS.get()));
		this.setItemSlot(EquipmentSlot.FEET, new ItemStack(ExAidRiderItems.PARA_DX_BELT.get()));
	}

	public void actuallyHurt(DamageSource source, float amount) {
		super.actuallyHurt(source, amount);
		int rand2 = random.nextInt(4);

			if (!this.level().isClientSide() && source.getEntity() instanceof Player player) {
				if (this.getHealth() < 40 && player.getInventory().countItem(ExAidRiderItems.MAXIMUM_MIGHTY_X_GASHAT.get().asItem()) != 0 && this.getItemBySlot(EquipmentSlot.FEET).getItem() == ExAidRiderItems.PARA_DX_BELT.get()) {
					if (this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUNCEMENTS))
						player.sendSystemMessage(Component.translatable("henshin.kamenridercraft.para_dx_lv99"));
					this.setHealth(70);
					this.setItemSlot(EquipmentSlot.FEET, new ItemStack(ExAidRiderItems.GAMER_DRIVER_PARA_DX.get()));
					this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ExAidRiderItems.PARABRAGUN.get()));

						int bossChoice = random.nextInt(4);
						switch (bossChoice) {
							case 0:
								addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, -1, 3));
								GeneralUtil.sendMessage(this, "vicinity_actionbar", "henshin.kamenridercraft.para_dx_speed");
								break;
							case 1:
								addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, -1, 0));
								GeneralUtil.sendMessage(this, "vicinity_actionbar", "henshin.kamenridercraft.para_dx_iron");
								break;
							case 2:
								addEffect(new MobEffectInstance(MobEffects.JUMP, -1, 3));
								GeneralUtil.sendMessage(this, "vicinity_actionbar", "henshin.kamenridercraft.para_dx_jump");
								break;
							case 3:
								addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 2));
								GeneralUtil.sendMessage(this, "vicinity_actionbar", "henshin.kamenridercraft.para_dx_muscle");
								break;
						}
				}
				super.tick();
			}

			if (rand2 == 2 & (getItemBySlot(EquipmentSlot.FEET).getItem() == ExAidRiderItems.PARA_DX_BELT.get())) {
				if (getItemBySlot(EquipmentSlot.FEET).getItem() == ExAidRiderItems.PARA_DX_BELT.get()) {
					ItemStack belt = getItemBySlot(EquipmentSlot.FEET);
					int rand = random.nextInt(2);
					switch (rand) {
						case 1:
							RiderDriverItem.setFormItem(belt, ExAidRiderItems.KNOCK_OUT_FIGHTER_GASHAT.get(), 1);
							break;
						default:
							RiderDriverItem.setFormItem(belt, ExAidRiderItems.PERFECT_PUZZLE_GASHAT.get(), 1);
							break;
					}
				}
			}
	}

    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 135.0D)
        		.add(Attributes.MOVEMENT_SPEED, 0.23F)
        		.add(Attributes.ATTACK_DAMAGE, 6.0D)
        		.add(Attributes.ARMOR, 3.0D)
        		.add(Attributes.MAX_HEALTH, 70.0D);
     }
    

}