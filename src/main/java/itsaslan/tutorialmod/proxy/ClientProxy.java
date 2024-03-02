package itsaslan.tutorialmod.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import itsaslan.tutorialmod.blocks.TutorialBlock;
import itsaslan.tutorialmod.blocks.TutorialModBlocks;
import itsaslan.tutorialmod.render.item.ItemRenderWaxChest;
import itsaslan.tutorialmod.render.tileentity.WaxChestRenderer;
import itsaslan.tutorialmod.tileentity.TileEntityWaxChest;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {

    public void preInit(FMLPreInitializationEvent $e)
    {
        super.preInit($e);

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWaxChest.class, new WaxChestRenderer());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(TutorialModBlocks.waxChest), new ItemRenderWaxChest());
    }

    public void init(FMLInitializationEvent $e)
    {
        super.init($e);

    }

    public void postInit(FMLPostInitializationEvent $e)
    {
        super.postInit($e);

    }

}
