package com.kelco.kamenridercraft.item.ghost;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.block.Rider_Blocks;
import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import com.kelco.kamenridercraft.item.Ghost_Rider_Items;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;


public class BlankGhostEyeconItem extends BaseItem {
    public ResourceLocation LOOT_TABLE_PATH = ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "items/blank_ghost_eyecon");
    public ResourceLocation LOOT_TABLE_PATH2 = ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "items/blank_ghost_eyecon_boost");
    public ResourceLocation LOOT_TABLE_PATH3 = ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "items/blank_ghost_eyecon_mugen");

    public BlankGhostEyeconItem(Properties properties) {
        super(properties);
    }

    public void dropItem(ServerLevel world, Player player) {

        Inventory Inventory = player.getInventory();
        boolean hasEyecons = Inventory.countItem(Ghost_Rider_Items.MUSASHI_GHOST_EYECON.get()) != 0
                & Inventory.countItem(Ghost_Rider_Items.EDISON_GHOST_EYECON.get()) != 0
                & Inventory.countItem(Ghost_Rider_Items.ROBIN_GHOST_EYECON.get()) != 0
                & Inventory.countItem(Ghost_Rider_Items.NEWTON_GHOST_EYECON.get()) != 0
                & Inventory.countItem(Ghost_Rider_Items.BILLY_THE_KID_GHOST_EYECON.get()) != 0
                & Inventory.countItem(Ghost_Rider_Items.BENKEI_GHOST_EYECON.get()) != 0
                & Inventory.countItem(Ghost_Rider_Items.TUTANKHAMUN_GHOST_EYECON.get()) != 0
                & Inventory.countItem(Ghost_Rider_Items.HOUDINI_GHOST_EYECON.get()) != 0
                & Inventory.countItem(Ghost_Rider_Items.RYOMA_GHOST_EYECON.get()) != 0
                & Inventory.countItem(Ghost_Rider_Items.GOEMON_GHOST_EYECON.get()) != 0
                & Inventory.countItem(Ghost_Rider_Items.HIMIKO_GHOST_EYECON.get()) != 0
                & Inventory.countItem(Ghost_Rider_Items.GRIMM_GHOST_EYECON.get()) != 0
                & Inventory.countItem(Ghost_Rider_Items.BEETHOVEN_GHOST_EYECON.get()) != 0
                & Inventory.countItem(Ghost_Rider_Items.SANZO_GHOST_EYECON.get()) != 0
                & Inventory.countItem(Ghost_Rider_Items.NOBUNAGA_GHOST_EYECON.get()) != 0;

        boolean hasAllEyecons = Inventory.countItem(Ghost_Rider_Items.MUSASHI_GHOST_EYECON.get()) != 0
                & Inventory.countItem(Ghost_Rider_Items.EDISON_GHOST_EYECON.get()) != 0
                & Inventory.countItem(Ghost_Rider_Items.ROBIN_GHOST_EYECON.get()) != 0
                & Inventory.countItem(Ghost_Rider_Items.NEWTON_GHOST_EYECON.get()) != 0
                & Inventory.countItem(Ghost_Rider_Items.BILLY_THE_KID_GHOST_EYECON.get()) != 0
                & Inventory.countItem(Ghost_Rider_Items.BENKEI_GHOST_EYECON.get()) != 0
                & Inventory.countItem(Ghost_Rider_Items.TUTANKHAMUN_GHOST_EYECON.get()) != 0
                & Inventory.countItem(Ghost_Rider_Items.HOUDINI_GHOST_EYECON.get()) != 0
                & Inventory.countItem(Ghost_Rider_Items.RYOMA_GHOST_EYECON.get()) != 0
                & Inventory.countItem(Ghost_Rider_Items.GOEMON_GHOST_EYECON.get()) != 0
                & Inventory.countItem(Ghost_Rider_Items.HIMIKO_GHOST_EYECON.get()) != 0
                & Inventory.countItem(Ghost_Rider_Items.GRIMM_GHOST_EYECON.get()) != 0
                & Inventory.countItem(Ghost_Rider_Items.BEETHOVEN_GHOST_EYECON.get()) != 0
                & Inventory.countItem(Ghost_Rider_Items.SANZO_GHOST_EYECON.get()) != 0
                & Inventory.countItem(Ghost_Rider_Items.NOBUNAGA_GHOST_EYECON.get()) != 0
                & Inventory.countItem(Ghost_Rider_Items.BOOST_GHOST_EYECON.get()) != 0
                & Inventory.countItem(Ghost_Rider_Items.EYECON_DRIVER_G.get()) != 0;

        ResourceKey<LootTable> loot = ResourceKey.create(Registries.LOOT_TABLE,hasAllEyecons ? LOOT_TABLE_PATH3 : hasEyecons ? LOOT_TABLE_PATH2 : LOOT_TABLE_PATH);
        LootTable loottable = world.getServer().reloadableRegistries().getLootTable(loot);
        LootParams.Builder lootparams$builder = new LootParams.Builder(world)
                .withParameter(LootContextParams.THIS_ENTITY, player)
                .withParameter(LootContextParams.ORIGIN, player.position());

        LootParams lootparams = lootparams$builder.create(LootContextParamSets.EQUIPMENT);
        loottable.getRandomItems(lootparams, 0L, player::spawnAtLocation);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player playerIn, InteractionHand p_41434_) {
        ItemStack itemstack = playerIn.getItemInHand(p_41434_);
        return InteractionResultHolder.consume(itemstack);
    }


    public InteractionResult useOn(UseOnContext context) {

        Player playerIn = context.getPlayer();
if (context.getLevel().getBlockState(context.getClickedPos())!= Rider_Blocks.MONOLITH.get().defaultBlockState()) {
    ItemStack itemstack = context.getItemInHand();
    if (context.getLevel() instanceof ServerLevel server) this.dropItem(server, playerIn);
    if (!playerIn.hasInfiniteMaterials()) itemstack.shrink(1);

    return InteractionResult.PASS;
}else return InteractionResult.FAIL;
    }
}