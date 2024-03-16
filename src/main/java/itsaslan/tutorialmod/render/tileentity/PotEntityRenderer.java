package itsaslan.tutorialmod.render.tileentity;

import cpw.mods.fml.common.Mod;
import itsaslan.tutorialmod.lib.ModVars;
import itsaslan.tutorialmod.tileentity.blockPotTileEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
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


        if (tileEntity instanceof blockPotTileEntity)
        {
            blockPotTileEntity potTileEntity = (blockPotTileEntity) tileEntity;

            for(int item = 0; item < potTileEntity.getStoredItems().length; ++item)
            {
                if(potTileEntity.getStoredItemAtIndex(item) != null)
                {
                    GL11.glPushMatrix();
                    GL11.glTranslated(x + 0.3 + (0.2 * item), y, z + 0.5); // Adjust the position to where you want to render the item
                    GL11.glRotatef(45.0f, 1.0f, 0.0f, 0.0f);
                    GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
                    EntityItem entityItem = new EntityItem(tileEntity.getWorldObj(), 0, 0, 0, potTileEntity.getStoredItemAtIndex(item));
                    entityItem.hoverStart = 0;
                    RenderItem.renderInFrame = true;
                    RenderManager.instance.renderEntityWithPosYaw(entityItem, 0D, 0D, 0D, 0F, 0F);
                    RenderItem.renderInFrame = false;
                    GL11.glPopMatrix();
                }
            }

            if (potTileEntity.getFilledWaterBool()) {
                GL11.glPushMatrix();
                GL11.glTranslated(x + 0.5, y - 0.5, z + 0.5);

                Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(ModVars.MOD_ID, "textures/blocks/potWater.png"));
                GL11.glEnable(GL11.GL_BLEND);
                GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
                Tessellator tessellator = Tessellator.instance;


                float waterHeight = 0.8f;
                float size = 0.3f;

                tessellator.startDrawingQuads();

                tessellator.addVertexWithUV(-size, waterHeight, -size, 0, 0);
                tessellator.addVertexWithUV(-size, waterHeight, size, 0, 1);
                tessellator.addVertexWithUV(size, waterHeight, size, 1, 1);
                tessellator.addVertexWithUV(size, waterHeight, -size, 1, 0);
                tessellator.draw();

                GL11.glDisable(GL11.GL_BLEND);
                GL11.glPopMatrix();
            }
        }

    }
}
