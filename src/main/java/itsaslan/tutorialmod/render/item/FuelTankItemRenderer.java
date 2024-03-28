package itsaslan.tutorialmod.render.item;

import itsaslan.tutorialmod.lib.ModVars;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public class FuelTankItemRenderer implements IItemRenderer
{
    private IModelCustom model;
    private ResourceLocation texture;

    public FuelTankItemRenderer()
    {
        model = AdvancedModelLoader.loadModel(new ResourceLocation(ModVars.MOD_ID, "models/block/fuelTank.obj"));
        texture = new ResourceLocation(ModVars.MOD_ID, "textures/models/fuelTankTexture.png");
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

        GL11.glScaled(0.9f, 0.9f, 0.9f);

        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
        model.renderAll();

        GL11.glPopMatrix();
    }
}
