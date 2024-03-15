package itsaslan.tutorialmod.proxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import itsaslan.tutorialmod.register.registerItemRenderers;
import itsaslan.tutorialmod.register.registerSpecialRenderers;

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
