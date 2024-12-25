package com.kelco.kamenridercraft.item.BaseItems;


import java.util.List;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.Modded_item_core;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Unit;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;

import javax.annotation.Nullable;

public class BaseBlasterItem extends BowItem {


	private Item RepairItem = Modded_item_core.RIDER_CIRCUIT.get();
	private Item FormChangeItem;
	private Item HenshinBeltItem;
	private Boolean Form_item = false;
	private Boolean Henshin_item = false;

	private Boolean LFB = false;
	private int LFBB = 1;
	private Boolean SFB = false;
	private Boolean EP = false;
	private Boolean WS = false;
	private Boolean CK = false;
	private Boolean DFB = false;
	
	public BaseBlasterItem(Tier toolTier, int Atk, float Spd, Properties prop) {
		super(prop.durability(toolTier.getUses()).attributes(SwordItem.createAttributes(Tiers.DIAMOND, Atk, Spd)));
		ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
	}
	public BaseBlasterItem AddToTabList(List<Item> TabList) {
		TabList.add(this);
		return this;
	}

	public void releaseUsing(ItemStack stack, Level level, LivingEntity entityLiving, int timeLeft) {
		if (entityLiving instanceof Player player) {
			ItemStack itemstack = new ItemStack(Items.ARROW, 1);
			itemstack.set(DataComponents.INTANGIBLE_PROJECTILE, Unit.INSTANCE);

			List<ItemStack> list = draw(stack, itemstack, player);
			if (level instanceof ServerLevel) {
				if (Henshin_item && player.getItemBySlot(EquipmentSlot.FEET)==ItemStack.EMPTY) {
					player.setItemSlot(EquipmentSlot.FEET, new ItemStack(HenshinBeltItem));
					if (player.getItemBySlot(EquipmentSlot.OFFHAND).getItem() instanceof RiderFormChangeItem) player.getItemBySlot(EquipmentSlot.OFFHAND).getItem().use(level, player, InteractionHand.OFF_HAND);
				}
				if (Form_item && player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem) {
					FormChangeItem.use(level, player, InteractionHand.MAIN_HAND);
				}	
				ServerLevel serverlevel = (ServerLevel)level;
				if (!list.isEmpty()) {

					Vec3 vec3 = player.getLookAngle();
					if (SFB){
						SmallFireball smallfireball = new SmallFireball(player.level(), player, vec3.normalize());
						smallfireball.setPos(smallfireball.getX(), player.getY(0.5) + 0.5, smallfireball.getZ());
						player.level().addFreshEntity(smallfireball);
						stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
					}else if (LFB){
						LargeFireball largefireball = new LargeFireball(player.level(), player, vec3.normalize(),LFBB);
						largefireball.setPos(largefireball.getX(), player.getY(0.5) + 0.5, largefireball.getZ());
						player.level().addFreshEntity(largefireball);
						stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
					}else if (DFB) {
						DragonFireball dragonfireball = new DragonFireball(player.level(), player, vec3.normalize());
						dragonfireball.setPos(dragonfireball.getX(), player.getY(0.5D) + 0.5D, dragonfireball.getZ());
						player.level().addFreshEntity(dragonfireball);
						stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
					}else if (CK) {
						ThrownEgg fireball = new ThrownEgg(player.level(),player);
						fireball.setPos(fireball.getX(), player.getY(0.5D) + 0.5D, fireball.getZ());
						fireball.setDeltaMovement( fireball.getDeltaMovement().add(vec3.x*3, vec3.y*3, vec3.z*3));
						player.level().addFreshEntity(fireball);
						stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
					}else if (WS) {
						WitherSkull fireball = new WitherSkull(player.level(), player,vec3.normalize());
						fireball.setPos(fireball.getX(), player.getY(0.5D) + 0.5D, fireball.getZ());
						player.level().addFreshEntity(fireball);
						stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
					}
					else if (EP) {
						ThrownEnderpearl fireball = new ThrownEnderpearl(player.level(),player);
						fireball.setPos(fireball.getX(), player.getY(0.5D) + 0.5D, fireball.getZ());
						fireball.setDeltaMovement( fireball.getDeltaMovement().add(vec3.x*3, vec3.y*3, vec3.z*3));
						player.level().addFreshEntity(fireball);
						stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
					}

					else this.shoot(serverlevel, player, player.getUsedItemHand(), stack, list, 3, 1.0F, true, (LivingEntity)null);
				}
				level.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.BLAZE_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (level.getRandom().nextFloat() * 0.4F + 1.2F) + 1 * 0.5F);
				player.awardStat(Stats.ITEM_USED.get(this));
			}
		}

	}

	@Override
	protected void shootProjectile(LivingEntity shooter, Projectile projectile, int index, float velocity, float inaccuracy, float angle, @Nullable LivingEntity target) {
		projectile.shootFromRotation(shooter, shooter.getXRot(), shooter.getYRot() + angle, 0.0F, velocity, inaccuracy);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		boolean flag = !player.getProjectile(itemstack).isEmpty();
		InteractionResultHolder<ItemStack> ret = EventHooks.onArrowNock(itemstack, level, player, hand, flag);

		if (ret != null) return ret;
		else {
			player.startUsingItem(hand);
			return InteractionResultHolder.consume(itemstack);
		}
	}


	public int getDefaultProjectileRange() {
		return 30;
	}



	public BaseBlasterItem ChangeRepairItem(Item item) {
		RepairItem = item;
		return this;
	}

	public boolean isValidRepairItem(ItemStack p_40392_, ItemStack p_40393_) {
		return p_40393_.getItem()== RepairItem;
	}

	public BaseBlasterItem IsFormItem(Item item) {
		Form_item=true;
		FormChangeItem=item;
		return this;
	}

	public BaseBlasterItem IsHenshinItem(Item item) {
		Henshin_item=true;
		HenshinBeltItem=item;
		return this;
	}

	public BaseBlasterItem IsSwordGun() {
		KamenRiderCraftCore.SWORD_GUN_ITEM.add(this);
		return this;
	}

	public BaseBlasterItem setProjectileLargeFireball(int blast) {
		LFB=true;
		LFBB=blast;
		return this;
	}
	public BaseBlasterItem setProjectileDragonFireball() {
		DFB=true;
		return this;
	}
	public BaseBlasterItem setProjectileFireball() {
		SFB=true;
		return this;
	}

	public BaseBlasterItem setProjectileWitherSkull() {
		WS=true;
		return this;
	}
	public BaseBlasterItem setProjectileEnderpearl() {
		EP=true;
		return this;
	}
	public BaseBlasterItem setProjectileEgg() {
		CK=true;
		return this;
	}

	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		return true;
	}

    @Override
    public void postHurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.hurtAndBreak(1, attacker, EquipmentSlot.MAINHAND);
    }

	public static ItemAttributeModifiers createAttributes(Tier tier, int attackDamage, float attackSpeed) {
		return createAttributes(tier, (float)attackDamage, attackSpeed);
	}
	public static ItemAttributeModifiers createAttributes(Tier p_330371_, float p_331976_, float p_332104_) {
		return ItemAttributeModifiers.builder().add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, (double)(p_331976_ + p_330371_.getAttackDamageBonus()), AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, (double)p_332104_, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).build();
	}
}