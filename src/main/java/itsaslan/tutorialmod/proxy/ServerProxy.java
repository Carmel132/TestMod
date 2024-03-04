package itsaslan.tutorialmod.proxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import itsaslan.tutorialmod.Main;
import itsaslan.tutorialmod.handlers.GuiHandler;
import itsaslan.tutorialmod.lib.ModVars;

public class ServerProxy extends CommonProxy{

    public void preInit(FMLPreInitializationEvent $e)
    {
        super.preInit($e);
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
