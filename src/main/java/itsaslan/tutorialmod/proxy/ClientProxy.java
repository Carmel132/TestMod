package itsaslan.tutorialmod.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import itsaslan.tutorialmod.blocks.TutorialBlock;
import itsaslan.tutorialmod.blocks.TutorialModBlocks;
import itsaslan.tutorialmod.register.registerItemRenderers;
import itsaslan.tutorialmod.register.registerSpecialRenderers;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {

    public void preInit(FMLPreInitializationEvent $e)
    {
        super.preInit($e);

    }

    public void init(FMLInitializationEvent $e)
    {
        super.init($e);
        registerSpecialRenderers.init();
        registerItemRenderers.init();
    }

    public void postInit(FMLPostInitializationEvent $e)
    {
        super.postInit($e);

    }

}
