package itsaslan.tutorialmod.render.tileentity;

import itsaslan.tutorialmod.lib.ModVars;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public class ThrusterEntityRenderer extends TileEntitySpecialRenderer
{

    IModelCustom model = AdvancedModelLoader.loadModel(new ResourceLocation(ModVars.MOD_ID, "models/block/thruster.obj"));
    ResourceLocation texture = new ResourceLocation(ModVars.MOD_ID, "textures/models/thrusterTexture.png");

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float partialTicks)
    {
        GL11.glPushMatrix();
        GL11.glTranslated(x + 0.5, y + 0.5, z + 0.5);
        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
        model.renderAll();
        GL11.glPopMatrix();

    }

}
