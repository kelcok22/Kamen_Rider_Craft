package com.kelco.kamenridercraft.item.gotchard;

import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import com.kelco.kamenridercraft.item.Gotchard_Rider_Items;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChemyRiserItem extends BaseItem {
    private static final Component UNKNOWN_CONTENTS = Component.translatable("container.shulkerBox.unknownContents");

    public static List<Item> ALL_CHEMY= new ArrayList<>();
    public static List<Item> Insect_CHEMY= new ArrayList<>();
    public static List<Item> Job_CHEMY= new ArrayList<>();
    public static List<Item> Vehicle_CHEMY= new ArrayList<>();
    public static List<Item> Animal_CHEMY= new ArrayList<>();
    public static List<Item> Artifact_CHEMY= new ArrayList<>();
    public static List<Item> Plant_CHEMY= new ArrayList<>();
    public static List<Item> Occult_CHEMY= new ArrayList<>();
    public static List<Item> Ancient_CHEMY= new ArrayList<>();
    public static List<Item> Cosmic_CHEMY= new ArrayList<>();
    public static List<Item> Fantastic_CHEMY= new ArrayList<>();
    public static List<Item> Repli_CHEMY= new ArrayList<>();
    public static List<Item> Legend_CHEMY= new ArrayList<>();
    public static List<Item> Daybreak_CHEMY= new ArrayList<>();


    public ChemyRiserItem() {
        super(new Properties().stacksTo(1).rarity(Rarity.COMMON).component(DataComponents.CONTAINER, ItemContainerContents.EMPTY));
    }

    private Item ChemyDrop(Item ring,Level world,Player entity) {
        Random generator = new Random();

        ResourceKey<Level> CITY = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("kamenridercraft:city"));
        if (world.dimension() == CITY){
            int rand = generator.nextInt(Legend_CHEMY.size());
            return Legend_CHEMY.get(rand);
        }else if (world.getBiome(entity.blockPosition()).is(BiomeTags.IS_NETHER)){
            int rand = generator.nextInt(Daybreak_CHEMY.size());
            return Daybreak_CHEMY.get(rand);
        }else if (ring==Gotchard_Rider_Items.ALCHEMIST_RING_BLUE.asItem()&&this ==Gotchard_Rider_Items.CHEMY_RISER.get()){
            int rand = generator.nextInt(Insect_CHEMY.size());
            return Insect_CHEMY.get(rand);
        }else  if (ring==Gotchard_Rider_Items.ALCHEMIST_RING_GREEN.asItem()&&this ==Gotchard_Rider_Items.CHEMY_RISER.get()){
            int rand = generator.nextInt(Plant_CHEMY.size());
            return Plant_CHEMY.get(rand);
        }else  if (ring==Gotchard_Rider_Items.ALCHEMIST_RING_RED.asItem()&&this ==Gotchard_Rider_Items.CHEMY_RISER.get()){
            int rand = generator.nextInt(Animal_CHEMY.size());
            return Animal_CHEMY.get(rand);
        }else  if (ring==Gotchard_Rider_Items.ALCHEMIST_RING_PURPLE.asItem()&&this ==Gotchard_Rider_Items.CHEMY_RISER.get()){
            int rand = generator.nextInt(Artifact_CHEMY.size());
            return Artifact_CHEMY.get(rand);
        }else  if (ring==Gotchard_Rider_Items.ALCHEMIST_RING_ORANGE.asItem()&&this ==Gotchard_Rider_Items.CHEMY_RISER.get()){
            int rand = generator.nextInt(Fantastic_CHEMY.size());
            return Fantastic_CHEMY.get(rand);
        }else  if (ring==Gotchard_Rider_Items.ALCHEMIST_RING_BLUE.asItem()&&this ==Gotchard_Rider_Items.CHEMY_RISER_SUPANA.get()){
            int rand = generator.nextInt(Vehicle_CHEMY.size());
            return Vehicle_CHEMY.get(rand);
        }else  if (ring==Gotchard_Rider_Items.ALCHEMIST_RING_GREEN.asItem()&&this ==Gotchard_Rider_Items.CHEMY_RISER_SUPANA.get()){
            int rand = generator.nextInt(Job_CHEMY.size());
            return Job_CHEMY.get(rand);
        }else  if (ring==Gotchard_Rider_Items.ALCHEMIST_RING_RED.asItem()&&this ==Gotchard_Rider_Items.CHEMY_RISER_SUPANA.get()){
            int rand = generator.nextInt(Ancient_CHEMY.size());
            return Ancient_CHEMY.get(rand);
        }else  if (ring==Gotchard_Rider_Items.ALCHEMIST_RING_PURPLE.asItem()&&this ==Gotchard_Rider_Items.CHEMY_RISER_SUPANA.get()){
            int rand = generator.nextInt(Occult_CHEMY.size());
            return Occult_CHEMY.get(rand);
        }else  if (ring==Gotchard_Rider_Items.ALCHEMIST_RING_ORANGE.asItem()&&this ==Gotchard_Rider_Items.CHEMY_RISER_SUPANA.get()){
            int rand = generator.nextInt(Cosmic_CHEMY.size());
            return Cosmic_CHEMY.get(rand);
        }else {
            int rand = generator.nextInt(ALL_CHEMY.size());
            return ALL_CHEMY.get(rand);
        }
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        ItemStack itemstack = entity.getItemInHand(hand);

        if (!world.isClientSide && entity instanceof ServerPlayer serverPlayer) {
            if ( itemstack.has(DataComponents.CONTAINER) ) {

                if (!entity.isShiftKeyDown()){
                    ItemContainerContents contents = itemstack.get(DataComponents.CONTAINER);
                    ItemStack card = contents.nonEmptyItems().iterator().next();
                    ItemStack ring = contents.getStackInSlot(1);
                        if( card.getItem() == Gotchard_Rider_Items.BLANK_RIDE_CHEMY_CARD.get()) {
                            serverPlayer.drop(new ItemStack(ChemyDrop(ring.getItem(),world,serverPlayer), 1), false);
                            card.shrink(1);
                            if (!serverPlayer.isCreative()) {
                                serverPlayer.getCooldowns().addCooldown(this, 10);
                            }
                        }
                        else if(card.getItem() == Gotchard_Rider_Items.UFO_X_RIDE_CHEMY_CARD.get()) {
                            serverPlayer.drop(new ItemStack(Gotchard_Rider_Items.UNFINISHED_EXGOTCHALIBUR.get(),1), false);
                            card.shrink(1);
                            if (!serverPlayer.isCreative()) {
                                serverPlayer.getCooldowns().addCooldown(this, 10);
                            }
                        }


                } else {
                    serverPlayer.openMenu(new MenuProvider() {
                        @Override
                        public Component getDisplayName() {
                            if (itemstack.getItem()==Gotchard_Rider_Items.CHEMY_RISER_SUPANA.get()) return Component.translatable("chemyriser_supana_gui.text");
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
