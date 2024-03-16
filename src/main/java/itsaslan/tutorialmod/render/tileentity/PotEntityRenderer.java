package itsaslan.tutorialmod.render.tileentity;

import itsaslan.tutorialmod.lib.ModVars;
import itsaslan.tutorialmod.tileentity.blockPotTileEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public class PotEntityRenderer extends TileEntitySpecialRenderer
{

    IModelCustom model = AdvancedModelLoader.loadModel(new ResourceLocation(ModVars.MOD_ID, "models/block/potModel.obj"));
    ResourceLocation texture = new ResourceLocation(ModVars.MOD_ID, "textures/models/potTexture.png");

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float partialTicks)
    {
        GL11.glPushMatrix();
        GL11.glTranslated(x + 0.5f, y + 0.5f, z + 0.5f);
        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
        model.renderAll();
        GL11.glPopMatrix();

        if (tileEntity instanceof blockPotTileEntity) {
            blockPotTileEntity potTe = (blockPotTileEntity) tileEntity;

            if (potTe.getStoredItem() != null) {
                GL11.glPushMatrix();
                GL11.glTranslated(x + 0.5, y + 1, z + 0.5); // Adjust the position to where you want to render the item
                EntityItem entityItem = new EntityItem(tileEntity.getWorldObj(), 0, 0, 0, potTe.getStoredItem());
                entityItem.hoverStart = 0;
                RenderItem.renderInFrame = true;
                RenderManager.instance.renderEntityWithPosYaw(entityItem, 0D, 0D, 0D, 0F, 0F);
                RenderItem.renderInFrame = false;
                GL11.glPopMatrix();
            }
        }
    }
}
