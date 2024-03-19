package itsaslan.tutorialmod.gui;

import itsaslan.tutorialmod.containers.BombTableContainer;
import itsaslan.tutorialmod.containers.KilnContainer;
import itsaslan.tutorialmod.lib.ModVars;
import net.minecraft.block.Block;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class BombTableGui extends GuiContainer
{

    public static final ResourceLocation TEXTURE = new ResourceLocation(ModVars.MOD_ID + ":textures/gui/container/bombTableGui.png");

    public BombTableGui(InventoryPlayer playerInventory, TileEntity tileEntity, Block block)
    {
        super(new BombTableContainer(playerInventory, tileEntity));
        this.xSize = 176;
        this.ySize = 166;
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
