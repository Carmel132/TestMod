package itsaslan.tutorialmod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import itsaslan.tutorialmod.generation.stellarGeneration;
import itsaslan.tutorialmod.handlers.GuiHandler;
import itsaslan.tutorialmod.lib.ModVars;
import itsaslan.tutorialmod.proxy.CommonProxy;
import itsaslan.tutorialmod.proxy.ServerProxy;
import itsaslan.tutorialmod.register.registerGenerators;

@Mod(modid = ModVars.MOD_ID, name = ModVars.MOD_Name, version = ModVars.MOD_Version)
public class Main {

    @Mod.Instance
    public static Main instance = new Main();

    @SidedProxy(clientSide = "itsaslan.tutorialmod.proxy.ClientProxy", serverSide = "itsaslan.tutorialmod.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent $e)
    {
        proxy.preInit($e);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent $e)
    {
        proxy.init($e);
        NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent $e)
    {
        proxy.postInit($e);
    }

}
