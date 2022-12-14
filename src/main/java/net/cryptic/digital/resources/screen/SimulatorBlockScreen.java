package net.cryptic.digital.resources.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.cryptic.digital.resources.Main;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class SimulatorBlockScreen extends AbstractContainerScreen<SimulatorBlockMenu> {

    public static final ResourceLocation TEXTURE =
            new ResourceLocation(Main.MOD_ID,"textures/gui/simulator_block_gui.png");

    public SimulatorBlockScreen(SimulatorBlockMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void renderBg(PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        this.blit(pPoseStack, x, y, 0, 0, imageWidth, imageHeight);

        if(menu.isCrafting()) {
            blit(pPoseStack, x + 29, y + 7, 0, 168, 117, 67);
            blit(pPoseStack, x + 29, y + 63, 0, 235, menu.getScaledProgress(), 11);
        } else {
            blit(pPoseStack, x + 29, y + 7, 117, 168, 117, 67);
        }

    }

    @Override
    public void render(PoseStack pPoseStack, int mouseX, int mouseY, float delta) {
        renderBackground(pPoseStack);
        super.render(pPoseStack, mouseX, mouseY, delta);
        renderTooltip(pPoseStack, mouseX, mouseY);
    }
}
