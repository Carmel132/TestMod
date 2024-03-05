package itsaslan.tutorialmod.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import itsaslan.tutorialmod.blocks.TestGuiBlock;
import itsaslan.tutorialmod.containers.ContainerGeneric;
import itsaslan.tutorialmod.lib.ModVars;
import itsaslan.tutorialmod.tileentity.TestTileEntity;
import net.minecraft.block.Block;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;


@SideOnly(Side.CLIENT)
public class TestGui extends GuiContainer {

    private static final ResourceLocation TEXTURE = new ResourceLocation(ModVars.MOD_ID + ":textures/gui/container/testGUI.png");

    public TestGui(InventoryPlayer inventoryPlayer, TileEntity tileEntity, Block block) {
        super(new ContainerGeneric(inventoryPlayer, tileEntity));
        this.xSize = 176;
        this.ySize = 166;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        // Draw the container's name at the top-center
        String name = "Red Chest";
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
