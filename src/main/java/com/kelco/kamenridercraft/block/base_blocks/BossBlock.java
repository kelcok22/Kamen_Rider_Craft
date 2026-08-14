package com.kelco.kamenridercraft.block.base_blocks;

import com.google.common.collect.Lists;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.fml.loading.FMLEnvironment;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class BossBlock extends BaseBlock {
    private List<Component> bossText = Lists.newArrayList();
    private Supplier<? extends EntityType<? extends BaseHenchmenEntity>> boss;
    private List<Block> bossBlock;
    private int num;

    public BossBlock(Properties prop, Supplier<? extends EntityType<? extends BaseHenchmenEntity>> boss) {
        super(prop);
        this.boss = boss;
    }

    public BossBlock(Properties prop, Supplier<? extends EntityType<? extends BaseHenchmenEntity>> boss, Block... block) {
        super(prop);
        this.boss = boss;
        bossBlock = Lists.newArrayList(block);
    }

    public BossBlock addLine(Component text) {
        bossText.add(text);
        return this;
    }

    @Override
    public void playerDestroy(@NotNull Level level, @NotNull Player player, @NotNull BlockPos blockPos, @NotNull BlockState blockState, @Nullable BlockEntity blockEntity, @NotNull ItemStack itemStack) {
        if (!level.isClientSide()) {
            HolderLookup.RegistryLookup<Enchantment> enchantmentRegistryLookup = level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT);
            if (!(level.getDifficulty() == Difficulty.PEACEFUL) && (level.getDifficulty() == Difficulty.HARD ||
                    !level.getGameRules().getBoolean(ModGameRules.RULE_BOSS_REQUIRE_TRANSFORMATION) ||
                    (player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem driver && driver.isTransformed(player)) ||
                    player.getItemBySlot(EquipmentSlot.FEET).getItem().toString().contains("sentai") ||
                    player.getItemBySlot(EquipmentSlot.FEET).getItem().toString().contains("power"))) {
                if (bossBlock != null) {
                    if (num == 1) {
                        for (int n = 0; n < 40; n++) {
                            Random generator = new Random();
                            int posX = (blockPos.getX() - 10) + generator.nextInt(20);
                            int posY = blockPos.getY() + generator.nextInt(6);
                            int posZ = (blockPos.getZ() - 10) + generator.nextInt(20);
                            BlockPos pos1 = new BlockPos(posX, posY, posZ);
                            if (level.isEmptyBlock(pos1)) {
                                level.setBlockAndUpdate(pos1, bossBlock.get(generator.nextInt(bossBlock.size())).defaultBlockState());
                            }
                        }
                    } else {
                        for (int n = 0; n < 40; n++) {
                            Random generator = new Random();
                            int posX = (blockPos.getX() - 10) + generator.nextInt(20);
                            int posY = blockPos.getY();
                            int posZ = (blockPos.getZ() - 10) + generator.nextInt(20);
                            BlockPos pos1 = new BlockPos(posX, posY, posZ);
                            BlockState blockBelow = level.getBlockState(new BlockPos(posX, posY - 1, posZ));
                            if (level.isEmptyBlock(pos1) && !(blockBelow.is(TagKey.create(Registries.BLOCK, ResourceLocation.withDefaultNamespace("flowers"))) || blockBelow.is(TagKey.create(Registries.BLOCK, ResourceLocation.withDefaultNamespace("replacable_by_trees"))))) {
                                level.setBlockAndUpdate(pos1, bossBlock.get(generator.nextInt(bossBlock.size())).defaultBlockState());
                            }
                        }
                    }
                    BaseHenchmenEntity boss = this.boss.get().create(level);
                    if (boss != null) {
                        boss.moveTo(blockPos.getX() + 0.5, blockPos.getY(), blockPos.getZ() + 0.5, 0, 0.0F);
                        level.addFreshEntity(boss);
                        if (!bossText.isEmpty() && level.getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUNCEMENTS)) {
                            for (Component text : bossText) {
                                player.sendSystemMessage(text);
                            }
                        }
                    }
                } else if (!itemStack.getTagEnchantments().keySet().contains(enchantmentRegistryLookup.get(Enchantments.SILK_TOUCH).get())) {
                    ItemStack fakeItem = new ItemStack(itemStack.getItem());
                    fakeItem.enchant(enchantmentRegistryLookup.get(Enchantments.SILK_TOUCH).get(), 10);
                    super.playerDestroy(level, player, blockPos, blockState, blockEntity, fakeItem);
                }
            }
        }
        super.playerDestroy(level, player, blockPos, blockState, blockEntity, itemStack);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, Item.@NotNull TooltipContext tooltipContext, @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
        if (FMLEnvironment.dist.isClient() && (Minecraft.getInstance().level.getDifficulty() != Difficulty.HARD
                && Minecraft.getInstance().level.getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUNCEMENTS))) {
            tooltipComponents.add(Component.translatable("tooltip.kamenridercraft:boss_block"));
        }
        super.appendHoverText(itemStack, tooltipContext, tooltipComponents, tooltipFlag);
    }
}