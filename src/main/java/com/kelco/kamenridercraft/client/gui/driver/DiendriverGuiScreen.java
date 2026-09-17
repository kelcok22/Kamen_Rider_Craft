package com.kelco.kamenridercraft.client.gui.driver;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.world.inventory.DiendriverGuiMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;


public class DiendriverGuiScreen extends AbstractContainerScreen<DiendriverGuiMenu> {
    private static final ResourceLocation CONTAINER_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/gui/container/diendriver_gui.png");

    public DiendriverGuiScreen(DiendriverGuiMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        ++imageHeight;
        titleLabelX = imageWidth - 73;
        inventoryLabelX = imageWidth - 73;
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