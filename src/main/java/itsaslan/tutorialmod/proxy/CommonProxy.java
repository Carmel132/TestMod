package itsaslan.tutorialmod.proxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import itsaslan.tutorialmod.blocks.TutorialModBlocks;
import itsaslan.tutorialmod.crafting.TutorialCrafting;
import itsaslan.tutorialmod.items.TutorialModItems;
import itsaslan.tutorialmod.register.*;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent $e)
    {
        TutorialModItems.init();
        TutorialModBlocks.init();
        registerGenerators.oreGen();
    }

    public void init(FMLInitializationEvent $e)
    {
        registerTileEntities.init();
        TutorialCrafting.init();
        registerCustomRecipes.init();
        registerCustomComplexRecipes.init();
        registerEntities.init();
    }

    public void postInit(FMLPostInitializationEvent $e)
    {
    }

}
