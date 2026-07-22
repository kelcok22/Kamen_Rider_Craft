package com.kelco.kamenridercraft.block.base_blocks;

import com.google.common.collect.Lists;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class BossBlock extends BaseBlock {

    private List<Component> TEXT = Lists.newArrayList();
    private Supplier<? extends EntityType<? extends BaseHenchmenEntity>> BOSS;
    private List<Block> BLOCK;
    private int NUM;

    public BossBlock(Properties prop, Supplier<? extends EntityType<? extends BaseHenchmenEntity>> boss) {
        super(prop);
        BOSS = boss;
    }

    public BossBlock(Properties prop, Supplier<? extends EntityType<? extends BaseHenchmenEntity>> boss, Block... block) {
        super(prop);
        BOSS = boss;
        BLOCK = Lists.newArrayList(block);
    }

    public BossBlock addLine(Component text) {
        TEXT.add(text);
        return this;
    }

    @Override
    public void playerDestroy(@NotNull Level level, Player player, @NotNull BlockPos blockPos, @NotNull BlockState blockState, @Nullable BlockEntity blockEntity, @NotNull ItemStack itemStack) {
        if (player.level() instanceof ServerLevel serverLevel) {
            HolderLookup.RegistryLookup<Enchantment> enchantmentRegistryLookup = level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT);

            if (!(serverLevel.getDifficulty() == Difficulty.PEACEFUL) && (serverLevel.getDifficulty() == Difficulty.HARD) || (player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem driver && driver.isTransformed(player))) {
                if (BLOCK != null) {
                    if (NUM == 1) {
                        for (int n = 0; n < 40; n++) {
                            Random generator = new Random();
                            int posX = (blockPos.getX() - 10) + generator.nextInt(20);
                            int posY = blockPos.getY() + generator.nextInt(6);
                            int posZ = (blockPos.getZ() - 10) + generator.nextInt(20);
                            BlockPos pos1 = new BlockPos(posX, posY, posZ);
                            if (level.isEmptyBlock(pos1)) {
                                level.setBlockAndUpdate(pos1, BLOCK.get(generator.nextInt(BLOCK.size())).defaultBlockState());
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
                                level.setBlockAndUpdate(pos1, BLOCK.get(generator.nextInt(BLOCK.size())).defaultBlockState());
                            }
                        }
                    }
                }
                BaseHenchmenEntity boss = BOSS.get().create(level);
                if (boss != null) {
                    boss.moveTo(blockPos.getX() + 0.5, blockPos.getY(), blockPos.getZ() + 0.5, 0, 0.0F);
                    level.addFreshEntity(boss);
                    if (!TEXT.isEmpty() && level.getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUNCEMENTS)) {
                        for (Component text : TEXT) {
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
        super.playerDestroy(level, player, blockPos, blockState, blockEntity, itemStack);
    }
}