package com.kelco.kamenridercraft.block.custom;

import com.google.common.collect.Lists;
import com.kelco.kamenridercraft.block.base_blocks.BaseBlock;
import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.fml.loading.FMLEnvironment;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

public class BossBlockHokutoTrio extends BaseBlock {
    private final List<Component> text = Lists.newArrayList();

    public BossBlockHokutoTrio(Properties prop) {
        super(prop);
    }

    public BossBlockHokutoTrio addLine(Component text) {
        this.text.add(text);
        return this;
    }

    @Override
    public void playerDestroy(@NotNull Level level, @NotNull Player player, @NotNull BlockPos blockPos, @NotNull BlockState blockState, @Nullable BlockEntity blockEntity, @NotNull ItemStack itemStack) {
        if (!level.isClientSide()) {
            HolderLookup.RegistryLookup<Enchantment> enchantmentRegistryLookup = level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT);
            if ((level.getDifficulty() != Difficulty.PEACEFUL) && (!level.getGameRules().getBoolean(ModGameRules.RULE_BOSS_REQUIRE_TRANSFORMATION) ||
                    level.getDifficulty() == Difficulty.HARD || (player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem driver && driver.isTransformed(player)) ||
                    player.getItemBySlot(EquipmentSlot.FEET).getItem().toString().contains("sentai") ||
                    player.getItemBySlot(EquipmentSlot.FEET).getItem().toString().contains("power") ||
                    player.getItemBySlot(EquipmentSlot.FEET).getItem().toString().contains("ultra"))) {
                BaseHenchmenEntity boss = MobsCore.OWL_LOST_SMASH.get().create(level);
                BaseHenchmenEntity boss2 = MobsCore.STAG_LOST_SMASH.get().create(level);
                BaseHenchmenEntity boss3 = MobsCore.CASTLE_LOST_SMASH.get().create(level);
                if (boss != null & boss2 != null & boss3 != null) {
                    boss.moveTo(blockPos.getX(), blockPos.getY(), blockPos.getZ() + 1, 0, 0.0F);
                    boss2.moveTo(blockPos.getX(), blockPos.getY(), blockPos.getZ(), 0, 0.0F);
                    boss3.moveTo(blockPos.getX(), blockPos.getY(), blockPos.getZ() - 1, 0, 0.0F);
                    level.addFreshEntity(boss);
                    level.addFreshEntity(boss2);
                    level.addFreshEntity(boss3);
                    if (!text.isEmpty()) for (Component text : text) player.sendSystemMessage(text);
                }
            } else if (!itemStack.getTagEnchantments().keySet().contains(enchantmentRegistryLookup.get(Enchantments.SILK_TOUCH).get())) {
                ItemStack fakeItem = new ItemStack(itemStack.getItem());
                fakeItem.enchant(enchantmentRegistryLookup.get(Enchantments.SILK_TOUCH).get(), 10);
                super.playerDestroy(level, player, blockPos, blockState, blockEntity, fakeItem);
            }
        }
        super.playerDestroy(level, player, blockPos, blockState, blockEntity, itemStack);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, Item.@NotNull TooltipContext tooltipContext, @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
        if (FMLEnvironment.dist.isClient() && (Minecraft.getInstance().level.getDifficulty() != Difficulty.HARD)) {
            tooltipComponents.add(Component.translatable("tooltip.kamenridercraft:boss_block"));
        }
        super.appendHoverText(itemStack, tooltipContext, tooltipComponents, tooltipFlag);
    }
}