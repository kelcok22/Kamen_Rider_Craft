package com.kelco.kamenridercraft.entities.summons;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entities.allies.BaseAllyEntity;
import com.kelco.kamenridercraft.item.Decade_Rider_Items;
import com.kelco.kamenridercraft.item.Zero_One_Rider_Items;
import com.kelco.kamenridercraft.item.decade.ZeinCard;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.Level;

import java.util.Random;

public class ZeinSummonEntity extends BaseSummonEntity {
	public ZeinSummonEntity(EntityType<? extends ZeinSummonEntity> type, Level level) {
		super(type, level);
		NAME="zein_summon";
		this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Zero_One_Rider_Items.ZERO_ONE_HELMET.get()));
		this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Zero_One_Rider_Items.ZERO_ONE_CHESTPLATE.get()));
		this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Zero_One_Rider_Items.ZERO_ONE_LEGGINGS.get()));
		this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Zero_One_Rider_Items.ZEIN_DRIVER.get()));
		Random rand = new Random();
		this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(switch (rand.nextInt(23)) {
			case 0 -> Decade_Rider_Items.KUUGA_ULTIMATE_CARD.get();
			case 1 -> Decade_Rider_Items.AGITO_SHINING_CARD.get();
			case 2 -> Decade_Rider_Items.RYUKI_SURVIVE_CARD.get();
			case 3 -> Decade_Rider_Items.FAIZ_BLASTER_CARD.get();
			case 4 -> Decade_Rider_Items.BLADE_KING_CARD.get();
			case 5 -> Decade_Rider_Items.ARMED_HIBIKI_CARD.get();
			case 6 -> Decade_Rider_Items.KABUTO_HYPER_CARD.get();
			case 7 -> Decade_Rider_Items.DEN_O_LINER_CARD.get();
			case 8 -> Decade_Rider_Items.KIVA_EMPEROR_CARD.get();
			case 9 -> Decade_Rider_Items.DECADE_COMPLETE_CARD.get();
			case 10 -> Decade_Rider_Items.W_XTREME_CARD.get();
			case 11 -> Decade_Rider_Items.OOO_PUTOTYRA_CARD.get();
			case 12 -> Decade_Rider_Items.FOURZE_COSMIC_CARD.get();
			case 13 -> Decade_Rider_Items.WIZARD_INFINITY_CARD.get();
			case 14 -> Decade_Rider_Items.GAIM_KIWAMI_CARD.get();
			case 15 -> Decade_Rider_Items.DRIVE_TRIDORON_CARD.get();
			case 16 -> Decade_Rider_Items.GHOST_MUGEN_CARD.get();
			case 17 -> Decade_Rider_Items.EX_AID_MUTEKI_CARD.get();
			case 18 -> Decade_Rider_Items.BUILD_GENIUS_CARD.get();
			case 19 -> Decade_Rider_Items.ZERO_TWO_CARD.get();
			case 20 -> Decade_Rider_Items.XROSS_SABER_CARD.get();
			case 21 -> Decade_Rider_Items.ULTIMATE_REVI_CARD.get();
			default -> Decade_Rider_Items.GEATS_IX_CARD.get();
		}));
		this.reassessWeaponGoal();
	}

	public static AttributeSupplier.Builder setAttributes() {
		return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.2F).add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.ARMOR, -10.0D).add(Attributes.ATTACK_DAMAGE, 1.0D);
	}

	@Override
	public void actuallyHurt(DamageSource source, float amount) {
		super.actuallyHurt(source, amount);
		if (!this.level().isClientSide() && source.getEntity() != this.getOwner() && this.getHealth() < this.getMaxHealth()/2
		&& this.getItemBySlot(EquipmentSlot.MAINHAND).getItem() instanceof ZeinCard zein)
			zein.activateCard(this.level(), this, this.getItemBySlot(EquipmentSlot.MAINHAND));
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(4, new FollowOwnerGoal(this, 1.0D, 20.0F, 2.0F));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, BaseAllyEntity.class, BaseSummonEntity.class)).setAlertOthers());
		this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Monster.class, 5, false, false, (p_28879_) -> {
			if (isTame()) {
        		if (p_28879_ instanceof Creeper || p_28879_ instanceof Ghast) {
        		    if (this.getMainHandItem().getItem() instanceof BowItem) {
        		    	return !(this.getMainHandItem().getItem() instanceof SwordItem
        		    	|| this.getMainHandItem().is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "arsenal/all_swordguns")))) || !this.getMeleeOnly();
					}
					return false;
				}
				return p_28879_ instanceof Enemy && !(p_28879_ instanceof NeutralMob neutral && !neutral.isAngry());
			}else return false;
		}));
      	this.targetSelector.addGoal(4, new ResetUniversalAngerTargetGoal<>(this, true));

	}

    @Override
    public void bindToPlayer(Player player) {
      if (player instanceof ServerPlayer serverplayer) CriteriaTriggers.SUMMONED_ENTITY.trigger(serverplayer, this);
      super.bindToPlayer(player);
    }

}