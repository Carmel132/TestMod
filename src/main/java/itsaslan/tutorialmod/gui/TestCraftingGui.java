package itsaslan.tutorialmod.gui;

import itsaslan.tutorialmod.containers.ContainerGeneric;
import itsaslan.tutorialmod.containers.CraftingContainer;
import itsaslan.tutorialmod.lib.ModVars;
import net.minecraft.block.Block;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class TestCraftingGui extends GuiContainer
{

    public static final ResourceLocation TEXTURE = new ResourceLocation(ModVars.MOD_ID + ":textures/gui/container/testCraftingGui.png");

    public TestCraftingGui(InventoryPlayer playerInventory, TileEntity tileEntity, Block block)
    {
        super(new CraftingContainer(playerInventory, tileEntity));
        this.xSize = 176;
        this.ySize = 166;
    }

    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        // Draw the container's name at the top-center
        String name = "Test Crafting";
        int nameWidth = fontRendererObj.getStringWidth(name);
        fontRendererObj.drawString(name, 8, 6, 0x404040);

        // Draw the player's inventory label
        fontRendererObj.drawString("Inventory", 8, ySize - 96 + 2, 0x404040);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        mc.getTextureManager().bindTexture(TEXTURE);
        int startX = (width - xSize) / 2;
        int startY = (height - ySize) / 2;
        drawTexturedModalRect(startX, startY, 0, 0, xSize, ySize);
    }
}
