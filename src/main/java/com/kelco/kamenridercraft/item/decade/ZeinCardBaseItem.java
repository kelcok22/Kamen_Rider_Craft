package com.kelco.kamenridercraft.item.decade;

import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Decade_Rider_Items;
import com.kelco.kamenridercraft.item.Zero_One_Rider_Items;
import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;


public class ZeinCardBaseItem extends BaseItem {
    private List<MobEffectInstance> zeinEffectList = new ArrayList<>();
    private List<String> zeinItemList = new ArrayList<>();

    public ZeinCardBaseItem(Properties properties) {
        super(properties.durability(1));
    }

    public ZeinCardBaseItem setZeinEffects(MobEffectInstance... list) {
        zeinEffectList.addAll(List.of(list));
        return this;
    }

    public ZeinCardBaseItem setZeinItems(String... list) {
        zeinItemList.addAll(List.of(list));
        return this;
    }

    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return repair.is(Zero_One_Rider_Items.ZEIN_PROGRISEKEY.get()) || super.isValidRepairItem(toRepair, repair);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack CARD = player.getItemInHand(usedHand);
        if (!CARD.isDamaged()) {
            ItemStack BELT = player.getItemBySlot(EquipmentSlot.FEET);

            if (!level.isClientSide() && BELT.getItem() == Zero_One_Rider_Items.ZEIN_DRIVER.get() && ((RiderDriverItem) BELT.getItem()).isTransformed(player)) {
                for (MobEffectInstance effect : zeinEffectList) player.addEffect(effect);
                for (String string : zeinItemList) {
                    ItemStack stack = new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse(string)), 1);
                    stack.set(DataComponents.ITEM_NAME, Component.translatable("owner.kamenridercraft.zein", stack.getHoverName()));
                    if (stack.isDamageableItem() && level.getGameRules().getInt(ModGameRules.RULE_SUMMONED_ITEM_DURABILITY) > 0) stack.set(DataComponents.MAX_DAMAGE, level.getGameRules().getInt(ModGameRules.RULE_SUMMONED_ITEM_DURABILITY));

                    ItemEntity entity = new ItemEntity(level, player.getX(), player.getY(), player.getZ(), stack, 0, 0, 0);
                    entity.setPickUpDelay(0);
                    level.addFreshEntity(entity);
                }
                CARD.setDamageValue(1);
                player.displayClientMessage(Component.translatable("attack.kamenridercraft.justice_order"), true);
                if (!player.isCreative()) for (Item item : Decade_Rider_Items.ZEIN_CARDS) player.getCooldowns().addCooldown(item, 2400);

                return InteractionResultHolder.sidedSuccess(player.getItemInHand(usedHand), level.isClientSide());
            }
        }
        return InteractionResultHolder.fail(player.getItemInHand(usedHand));
    }
}