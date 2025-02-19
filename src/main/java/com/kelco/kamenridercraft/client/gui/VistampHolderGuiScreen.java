package com.kelco.kamenridercraft.client.gui;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.world.inventory.VistampHolderGuiMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class VistampHolderGuiScreen extends AbstractContainerScreen<VistampHolderGuiMenu> {
	private static final ResourceLocation CONTAINER_TEXTURE = ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/gui/container/basic_3_item_gui.png");

	public VistampHolderGuiScreen(VistampHolderGuiMenu menu, Inventory playerInventory, Component title) {
		super(menu, playerInventory, title);
		this.imageHeight++;
	}

	/**
	 * Renders the graphical user interface (GUI) element.
	 *
	 * @param guiGraphics the GuiGraphics object used for rendering.
	 * @param mouseX      the x-coordinate of the mouse cursor.
	 * @param mouseY      the y-coordinate of the mouse cursor.
	 * @param partialTick the partial tick time.
	 */
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
