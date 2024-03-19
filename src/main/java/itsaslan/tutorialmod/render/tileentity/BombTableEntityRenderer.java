package itsaslan.tutorialmod.render.tileentity;

import itsaslan.tutorialmod.lib.ModVars;
import itsaslan.tutorialmod.tileentity.bombTableTileEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public class BombTableEntityRenderer extends TileEntitySpecialRenderer
{

    IModelCustom model = AdvancedModelLoader.loadModel(new ResourceLocation(ModVars.MOD_ID, "models/block/bombTable.obj"));
    ResourceLocation texture = new ResourceLocation(ModVars.MOD_ID, "textures/models/bombTableTexture.png");

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float partialTicks)
    {
        GL11.glPushMatrix();
        GL11.glTranslated(x + 0.5, y + 0.5, z + 0.5);

        int orientation = ((bombTableTileEntity) tileEntity).getOrientation();

        // Rotate based on metadata
        switch (orientation) {
            case 0:
                GL11.glRotatef(0, 0, 1, 0); // Facing south, no rotation needed.
                break;
            case 1:
                GL11.glRotatef(270, 0, 1, 0); // Facing west, rotate 270 degrees.
                break;
            case 2:
                GL11.glRotatef(180, 0, 1, 0); // Facing north, rotate 180 degrees.
                break;
            case 3:
                GL11.glRotatef(90, 0, 1, 0); // Facing east, rotate 90 degrees.
                break;
        }

        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
        model.renderAll();
        GL11.glPopMatrix();

    }
}
