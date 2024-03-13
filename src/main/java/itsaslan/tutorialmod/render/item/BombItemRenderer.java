package itsaslan.tutorialmod.render.item;

import itsaslan.tutorialmod.lib.ModVars;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public class BombItemRenderer implements IItemRenderer
{

    private IModelCustom model;
    private ResourceLocation texture;

    public BombItemRenderer()
    {
        model = AdvancedModelLoader.loadModel(new ResourceLocation(ModVars.MOD_ID, "models/block/bombModel.obj"));
        texture = new ResourceLocation(ModVars.MOD_ID, "textures/models/bombTexture.png");
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        GL11.glPushMatrix();

        GL11.glTranslated(0.0f, -0.16f, 0.0f);
        GL11.glScaled(0.8f, 0.8f, 0.8f);

        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
        model.renderAll();

        GL11.glPopMatrix();
    }
}
