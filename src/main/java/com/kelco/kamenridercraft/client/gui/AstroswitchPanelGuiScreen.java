package com.kelco.kamenridercraft.client.gui;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import com.kelco.kamenridercraft.world.inventory.AstroswitchPanelGuiMenu;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class AstroswitchPanelGuiScreen extends AbstractContainerScreen<AstroswitchPanelGuiMenu> {
	private static final ResourceLocation CONTAINER_TEXTURE = ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/container/astroswitch_panel_gui.png");

	public AstroswitchPanelGuiScreen(AstroswitchPanelGuiMenu menu, Inventory playerInventory, Component title) {
		super(menu, playerInventory, title);
		imageWidth = 250;
		imageHeight = 169;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
		super.render(guiGraphics, mouseX, mouseY, partialTick);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
		int i = (this.width - this.imageWidth) / 2;
		int j = (this.height - this.imageHeight) / 2;
		guiGraphics.blit(CONTAINER_TEXTURE, i, j, 0, 0, this.imageWidth, this.imageHeight);
	}
}
