package com.kelco.kamenridercraft.item.BaseItems;


import java.util.List;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.Modded_item_core;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.DragonFireball;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.entity.projectile.ThrownEgg;
import net.minecraft.world.entity.projectile.ThrownEnderpearl;
import net.minecraft.world.entity.projectile.WitherSkull;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;

public class BaseBlasterItem extends BowItem {

	private final float attackDamage;
	private final Multimap<Attribute, AttributeModifier> defaultModifiers;

	private Item RepairItem = Modded_item_core.RIDER_CIRCUIT.get();
	private Item HenshinBeltItem;
	private Boolean Henshin_item = false;

	private Boolean LFB = false;
	private int LFBB = 1;
	private Boolean SFB = false;
	private Boolean EP = false;
	private Boolean WS = false;
	private Boolean CK = false;
	private Boolean DFB = false;
	
	public BaseBlasterItem(Tier toolTier, int Atk, float Spd, Properties prop) {
		super(prop.durability(toolTier.getUses()));
		this.attackDamage = (float)Atk;
		ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
		//builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", (double)this.attackDamage, AttributeModifier.Operation.ADDITION));
		//builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", (double)Spd, AttributeModifier.Operation.ADDITION));
		this.defaultModifiers = builder.build();

	}
	public BaseBlasterItem AddToTabList(List<Item> TabList) {
		TabList.add(this);
		return this;
	}
/**
	public float getDamage() {
		return this.attackDamage;
	}

	public void releaseUsing(ItemStack p_40667_, Level p_40668_, LivingEntity p_40669_, int p_40670_) {
		if (p_40669_ instanceof Player player) {
			boolean flag = player.getAbilities().instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY. p_40667_) > 0;
			ItemStack arrow = new ItemStack(Items.ARROW,1)

			int i = this.getUseDuration(p_40667_) - p_40670_;
			i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(p_40667_, p_40668_, player, i, !arrow.isEmpty() || flag);
			if (i < 0) return;


			float f = 2f;
			if (!((double)f < 0.1D)) {

				if (!p_40668_.isClientSide) {
					if (Henshin_item && p_40669_.getItemBySlot(EquipmentSlot.FEET)==ItemStack.EMPTY) {
						p_40669_.setItemSlot(EquipmentSlot.FEET, new ItemStack(HenshinBeltItem));
						if (p_40669_.getItemBySlot(EquipmentSlot.OFFHAND).getItem() instanceof RiderFormChangeItem) p_40669_.getItemBySlot(EquipmentSlot.OFFHAND).getItem().use(p_40668_, (Player) p_40669_, InteractionHand.OFF_HAND);
					}
					Vec3 look = player.getLookAngle();
					if (LFB) {
						
						LargeFireball fireball = new LargeFireball(p_40668_, player, look.x*3, look.y*3, look.z*3, LFBB);
						fireball.setPos(fireball.getX(), player.getY(0.5D) + 0.5D, fireball.getZ());


						p_40668_.addFreshEntity(fireball);
					}else if (DFB) {
						DragonFireball fireball = new DragonFireball(p_40668_, player, look.x*3, look.y*3, look.z*3);
						fireball.setPos(fireball.getX(), player.getY(0.5D) + 0.5D, fireball.getZ());


						p_40668_.addFreshEntity(fireball);
					}else if (CK) {
						ThrownEgg fireball = new ThrownEgg(p_40668_,player);
						fireball.setPos(fireball.getX(), player.getY(0.5D) + 0.5D, fireball.getZ());
						fireball.setDeltaMovement( fireball.getDeltaMovement().add(look.x*3, look.y*3, look.z*3));

						p_40668_.addFreshEntity(fireball);
					}else if (WS) {
						WitherSkull fireball = new WitherSkull(p_40668_, player, look.x*3, look.y*3, look.z*3);
						fireball.setPos(fireball.getX(), player.getY(0.5D) + 0.5D, fireball.getZ());
						p_40668_.addFreshEntity(fireball);
					}
					else if (EP) {
						ThrownEnderpearl fireball = new ThrownEnderpearl(p_40668_,player);
						fireball.setPos(fireball.getX(), player.getY(0.5D) + 0.5D, fireball.getZ());

						fireball.setDeltaMovement( fireball.getDeltaMovement().add(look.x*3, look.y*3, look.z*3));

						p_40668_.addFreshEntity(fireball);
					}
					else if (SFB) {

						SmallFireball fireball = new SmallFireball(p_40668_, player, look.x*3, look.y*3, look.z*3);
						fireball.setPos(fireball.getX(), player.getY(0.5D) + 0.5D, fireball.getZ());


						p_40668_.addFreshEntity(fireball);
					}
					else{
						ArrowItem arrowitem = (ArrowItem)(Items.ARROW);
						AbstractArrow abstractarrow = arrowitem.createArrow(p_40668_, arrow, player);
						abstractarrow = customArrow(abstractarrow);
						abstractarrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, f * 3.0F, 1.0F);

						abstractarrow.setCritArrow(true);

						int j = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, p_40667_);
						if (j > 0) {
							abstractarrow.setBaseDamage(abstractarrow.getBaseDamage() + (double)j * 0.5D + 0.5D);
						}

						int k = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PUNCH_ARROWS, p_40667_);
						if (k > 0) {
							abstractarrow.setKnockback(k);
						}

						if (player.hasEffect(Effect_core.SHOT_BOOST.get())) {
							abstractarrow.setKnockback(3);
						}

						if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, p_40667_) > 0) {
							abstractarrow.setSecondsOnFire(100);
						}
						abstractarrow.pickup = AbstractArrow.Pickup.DISALLOWED;


						p_40668_.addFreshEntity(abstractarrow);
					}

					p_40667_.hurtAndBreak(1, player, (p_276007_) -> {
						p_276007_.broadcastBreakEvent(player.getUsedItemHand());
					});

				}

				p_40668_.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.BLAZE_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (p_40668_.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);


				player.awardStat(Stats.ITEM_USED.get(this));
			}

		}
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		boolean flag = !player.getProjectile(itemstack).isEmpty();
		InteractionResultHolder<ItemStack> ret = EventHooks.onArrowNock(itemstack, level, player, hand, flag);

		if (ret != null) return ret;
		else return InteractionResultHolder.consume(itemstack);

	}


	public static float getPowerForTime(int p_40662_) {

		return 1;
	}

	public int getDefaultProjectileRange() {
		return 30;
	}
**/
	public BaseBlasterItem ChangeRepairItem(Item item) {
		RepairItem = item;
		return this;
	}
/**
	public boolean isValidRepairItem(ItemStack p_40392_, ItemStack p_40393_) {
		return p_40393_.getItem()== RepairItem;
	}

	public BaseBlasterItem IsHenshinItem(Item item) {
		Henshin_item=true;
		HenshinBeltItem=item;
		return this;
	}
**/
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