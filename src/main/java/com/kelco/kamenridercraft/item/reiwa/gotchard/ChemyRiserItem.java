package com.kelco.kamenridercraft.item.reiwa.gotchard;

import com.kelco.kamenridercraft.item.base_items.BaseItem;
import com.kelco.kamenridercraft.item.reiwa.GotchardRiderItems;
import com.kelco.kamenridercraft.world.inventory.ChemyRiserGuiMenu;
import io.netty.buffer.Unpooled;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChemyRiserItem extends BaseItem {
    private static final Component UNKNOWN_CONTENTS = Component.translatable("container.shulkerBox.unknownContents");

    public static List<Item> allChemy = new ArrayList<>();
    public static List<Item> insectChemy = new ArrayList<>();
    public static List<Item> jobChemy = new ArrayList<>();
    public static List<Item> vehicleChemy = new ArrayList<>();
    public static List<Item> animalChemy = new ArrayList<>();
    public static List<Item> artifactChemy = new ArrayList<>();
    public static List<Item> plantChemy = new ArrayList<>();
    public static List<Item> occultChemy = new ArrayList<>();
    public static List<Item> ancientChemy = new ArrayList<>();
    public static List<Item> cosmicCHEMY = new ArrayList<>();
    public static List<Item> fantasticChemy = new ArrayList<>();
    public static List<Item> repliChemy = new ArrayList<>();
    public static List<Item> legendChemy = new ArrayList<>();
    public static List<Item> daybreakChemy = new ArrayList<>();


    public ChemyRiserItem() {
        super(new Properties().stacksTo(1).rarity(Rarity.COMMON).component(DataComponents.CONTAINER, ItemContainerContents.EMPTY));
    }

    private Item ChemyDrop(Item ring, Level world, Player entity) {
        Random generator = new Random();

        ResourceKey<Level> CITY = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("kamenridercraft:city"));
        if (world.dimension() == CITY) {
            int rand = generator.nextInt(legendChemy.size());
            return legendChemy.get(rand);
        } else if (world.getBiome(entity.blockPosition()).is(BiomeTags.IS_NETHER)) {
            int rand = generator.nextInt(daybreakChemy.size());
            return daybreakChemy.get(rand);
        } else if (ring == GotchardRiderItems.ALCHEMIST_RING_BLUE.asItem() && this == GotchardRiderItems.CHEMY_RISER.get()) {
            int rand = generator.nextInt(insectChemy.size());
            return insectChemy.get(rand);
        } else if (ring == GotchardRiderItems.ALCHEMIST_RING_GREEN.asItem() && this == GotchardRiderItems.CHEMY_RISER.get()) {
            int rand = generator.nextInt(plantChemy.size());
            return plantChemy.get(rand);
        } else if (ring == GotchardRiderItems.ALCHEMIST_RING_RED.asItem() && this == GotchardRiderItems.CHEMY_RISER.get()) {
            int rand = generator.nextInt(animalChemy.size());
            return animalChemy.get(rand);
        } else if (ring == GotchardRiderItems.ALCHEMIST_RING_PURPLE.asItem() && this == GotchardRiderItems.CHEMY_RISER.get()) {
            int rand = generator.nextInt(artifactChemy.size());
            return artifactChemy.get(rand);
        } else if (ring == GotchardRiderItems.ALCHEMIST_RING_ORANGE.asItem() && this == GotchardRiderItems.CHEMY_RISER.get()) {
            int rand = generator.nextInt(fantasticChemy.size());
            return fantasticChemy.get(rand);
        } else if (ring == GotchardRiderItems.ALCHEMIST_RING_BLUE.asItem() && this == GotchardRiderItems.CHEMY_RISER_SUPANA.get()) {
            int rand = generator.nextInt(vehicleChemy.size());
            return vehicleChemy.get(rand);
        } else if (ring == GotchardRiderItems.ALCHEMIST_RING_GREEN.asItem() && this == GotchardRiderItems.CHEMY_RISER_SUPANA.get()) {
            int rand = generator.nextInt(jobChemy.size());
            return jobChemy.get(rand);
        } else if (ring == GotchardRiderItems.ALCHEMIST_RING_RED.asItem() && this == GotchardRiderItems.CHEMY_RISER_SUPANA.get()) {
            int rand = generator.nextInt(ancientChemy.size());
            return ancientChemy.get(rand);
        } else if (ring == GotchardRiderItems.ALCHEMIST_RING_PURPLE.asItem() && this == GotchardRiderItems.CHEMY_RISER_SUPANA.get()) {
            int rand = generator.nextInt(occultChemy.size());
            return occultChemy.get(rand);
        } else if (ring == GotchardRiderItems.ALCHEMIST_RING_ORANGE.asItem() && this == GotchardRiderItems.CHEMY_RISER_SUPANA.get()) {
            int rand = generator.nextInt(cosmicCHEMY.size());
            return cosmicCHEMY.get(rand);
        } else {
            int rand = generator.nextInt(allChemy.size());
            return allChemy.get(rand);
        }
    }


    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        ItemStack itemstack = entity.getItemInHand(hand);

        if (!world.isClientSide && entity instanceof ServerPlayer serverPlayer) {
            if (itemstack.has(DataComponents.CONTAINER)) {

                if (!entity.isShiftKeyDown()) {
                    ItemContainerContents contents = itemstack.get(DataComponents.CONTAINER);
                    assert contents != null;
                    ItemStack card = contents.nonEmptyItems().iterator().next();
                    ItemStack ring = contents.getStackInSlot(1);
                    if (card.getItem() == GotchardRiderItems.BLANK_RIDE_CHEMY_CARD.get()) {
                        serverPlayer.drop(new ItemStack(ChemyDrop(ring.getItem(), world, serverPlayer), 1), false);
                        card.shrink(1);
                        if (!serverPlayer.isCreative()) {
                            serverPlayer.getCooldowns().addCooldown(this, 10);
                        }
                    } else if (card.getItem() == GotchardRiderItems.UFO_X_RIDE_CHEMY_CARD.get()) {
                        serverPlayer.drop(new ItemStack(GotchardRiderItems.UNFINISHED_EXGOTCHALIBUR.get(), 1), false);
                        card.shrink(1);
                        if (!serverPlayer.isCreative()) {
                            serverPlayer.getCooldowns().addCooldown(this, 10);
                        }
                    } else if (card.getItem() == GotchardRiderItems.TAMAGON_RIDE_CHEMY_CARD.get()) {
                        serverPlayer.drop(new ItemStack(GotchardRiderItems.NIJIGON_RIDE_CHEMY_CARD_EXTRA.get(), 1), false);
                        serverPlayer.drop(new ItemStack(GotchardRiderItems.NIJIGON_RIDE_CHEMY_CARD_SPECIAL.get(), 1), false);
                        card.shrink(1);
                        if (!serverPlayer.isCreative()) {
                            serverPlayer.getCooldowns().addCooldown(this, 10);
                        }
                    }


                } else {
                    serverPlayer.openMenu(new MenuProvider() {
                        @Override
                        public @NotNull Component getDisplayName() {
                            if (itemstack.getItem() == GotchardRiderItems.CHEMY_RISER_SUPANA.get())
                                return Component.translatable("chemyriser_supana_gui.text");
                            else return Component.translatable("chemyriser_gui.text");
                        }

                        @Override
                        public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                            FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
                            packetBuffer.writeBlockPos(entity.blockPosition());
                            packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
                            return new ChemyRiserGuiMenu(id, inventory, packetBuffer, itemstack);
                        }
                    }, buf -> {
                        buf.writeBlockPos(entity.blockPosition());
                        buf.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
                    });
                }
            }
        }
        entity.awardStat(Stats.ITEM_USED.get(this));
        return InteractionResultHolder.sidedSuccess(itemstack, world.isClientSide());
    }


    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        if (stack.has(DataComponents.CONTAINER_LOOT)) {
            tooltipComponents.add(UNKNOWN_CONTENTS);
        }

        int i = 0;
        int j = 0;

        for (ItemStack itemstack : stack.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY).nonEmptyItems()) {
            ++j;
            if (i <= 4) {
                ++i;
                tooltipComponents.add(Component.translatable("container.shulkerBox.itemCount", itemstack.getHoverName(), itemstack.getCount()));
            }
        }

        if (j - i > 0) {
            tooltipComponents.add(Component.translatable("container.shulkerBox.more", j - i).withStyle(ChatFormatting.ITALIC));
        }
    }
}
