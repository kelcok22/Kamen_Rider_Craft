package com.kelco.kamenridercraft.client.gui.storage_item;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.world.inventory.RiderGashatCaseGuiMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;


public class RiderGashatCaseGuiScreen extends AbstractContainerScreen<RiderGashatCaseGuiMenu> {
    private static final ResourceLocation CONTAINER_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/gui/container/rider_gashat_case_gui.png");

    public RiderGashatCaseGuiScreen(RiderGashatCaseGuiMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        imageHeight++;
    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        int i = (width - imageWidth) / 2;
        int j = (height - imageHeight) / 2;
        guiGraphics.blit(CONTAINER_TEXTURE, i, j, 0, 0, imageWidth, imageHeight);
    }
}
