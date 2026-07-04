package com.kelco.kamenridercraft.client.gui.overlays;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.extra_riders.ExtraRiderItems;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.LayeredDraw;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;

import static com.kelco.kamenridercraft.KamenRiderCraftCore.MOD_ID;
import static com.kelco.kamenridercraft.abilities.ClientAbilityUtil.clientGetAbility;
import static com.kelco.kamenridercraft.abilities.ClientAbilityUtil.returnAbilityIcon;

@Mod(value = KamenRiderCraftCore.MOD_ID, dist = Dist.CLIENT)
public class AbilityHudOverlay implements LayeredDraw.Layer {
    public static final AbilityHudOverlay instance = new AbilityHudOverlay();
    private static final ResourceLocation UNFILLED_ACTION_BAR = ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/hud/action_meter_background.png");
    private static final ResourceLocation FILLED_ACTION_BAR = ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/hud/action_meter_progress.png");
    private static final ResourceLocation ABILITY_HOLDER = ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/hud/ability_overlay.png");
    private static ResourceLocation ABILITY_ONE = null;
    private static ResourceLocation ABILITY_TWO = null;

    public void render(GuiGraphics guiGraphics, DeltaTracker deltaTracker) {
        Player player = Minecraft.getInstance().player;
        if (Minecraft.getInstance().options.hideGui || player.isSpectator() || !shouldShowIcons(player)) {
            return;
        }

        int screenXCenter = (int) (guiGraphics.guiWidth() * 0.5);
        int screenYCenter = (int) (guiGraphics.guiHeight() * 0.5);

        int maxActionMeter = (int) player.getAttribute(Attributes.MAX_ABILITY_METER).getValue();
        int actionProgress = (int) player.getAttribute(Attributes.ABILITY_METER).getValue();
        int meterDisplay = (int) (51 * Math.min((actionProgress / (double) maxActionMeter), 1));

        RenderSystem.enableBlend();

        if (shouldShowAbilityMeter(player)) {
            guiGraphics.blit(UNFILLED_ACTION_BAR, ((int) (screenXCenter * 0.405)) - 51, (screenYCenter + (int) (screenYCenter * .65)) - 5, 0, 0, 51, 5, 51, 5);
            if (actionProgress > 0) {
                guiGraphics.blit(FILLED_ACTION_BAR, ((int) (screenXCenter * 0.405)) - 51, (screenYCenter + (int) (screenYCenter * .65)) - 5, 0, 0, meterDisplay, 5, 51, 5);
            }
        }

        if (player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem driverItem) {
            ABILITY_ONE = null;
            ABILITY_TWO = null;
            if (driverItem.isTransformed(player)) {
                if (!(driverItem.abilitySlotOne == null)) {
                    ABILITY_ONE = driverItem.abilitySlotOne;
                } else {
                    if (!clientGetAbility(1).isEmpty()) {
                        driverItem.abilitySlotOne = returnAbilityIcon(clientGetAbility(1).getFirst().toLowerCase().substring(1));
                    }
                }
                if (!(driverItem.abilitySlotTwo == null)) {
                    ABILITY_TWO = driverItem.abilitySlotTwo;
                } else {
                    if (!clientGetAbility(2).isEmpty()) {
                        driverItem.abilitySlotTwo = returnAbilityIcon(clientGetAbility(2).getFirst().toLowerCase().substring(1));
                    }
                }
            }
        }

        if (shouldShowIcons(player)) {
            if (ABILITY_ONE != null && ABILITY_TWO != null) {
                guiGraphics.blit(ABILITY_HOLDER, ((int) (screenXCenter * 0.35)) - 9, (screenYCenter + (int) (screenYCenter * .75)) - 9, 0, 0, 18, 18, 18, 18);
                guiGraphics.blit(ABILITY_ONE, ((int) (screenXCenter * 0.35)) - 7, (screenYCenter + (int) (screenYCenter * .75)) - 7, 0, 0, 14, 14, 14, 14);

                guiGraphics.blit(ABILITY_HOLDER, ((int) (screenXCenter * 0.25)) - 9, (screenYCenter + (int) (screenYCenter * .75)) - 9, 0, 0, 18, 18, 18, 18);
                guiGraphics.blit(ABILITY_TWO, ((int) (screenXCenter * 0.25)) - 7, (screenYCenter + (int) (screenYCenter * .75)) - 7, 0, 0, 14, 14, 14, 14);
            } else if (ABILITY_ONE != null || ABILITY_TWO != null) {
                guiGraphics.blit(ABILITY_HOLDER, ((int) (screenXCenter * 0.3)) - 9, (screenYCenter + (int) (screenYCenter * .75)) - 9, 0, 0, 18, 18, 18, 18);
                if (ABILITY_ONE != null) {
                    guiGraphics.blit(ABILITY_ONE, ((int) (screenXCenter * 0.3)) - 7, (screenYCenter + (int) (screenYCenter * .75)) - 7, 0, 0, 14, 14, 14, 14);
                } else if (ABILITY_TWO != null) {
                    guiGraphics.blit(ABILITY_TWO, ((int) (screenXCenter * 0.3)) - 7, (screenYCenter + (int) (screenYCenter * .75)) - 7, 0, 0, 14, 14, 14, 14);
                }
            }
        }
    }

    public static boolean shouldShowAbilityMeter(Player player) {
        Item driverSlot = player.getItemBySlot(EquipmentSlot.FEET).getItem();
        if (player.isCreative()) {
            return false;
        }
        if (driverSlot instanceof RiderDriverItem && ((RiderDriverItem) driverSlot).isTransformed(player)) {
            return !((RiderDriverItem) driverSlot).Rider.toLowerCase().contains("ohma");
        }
        return true;
    }

    public static boolean shouldShowIcons(Player player) {
        Item driverSlot = player.getItemBySlot(EquipmentSlot.FEET).getItem();
        return driverSlot instanceof RiderDriverItem && ((RiderDriverItem) driverSlot).isTransformed(player) || player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ExtraRiderItems.ICHIGO_MASK.get();
    }
}