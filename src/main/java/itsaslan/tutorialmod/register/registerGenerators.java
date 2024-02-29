package itsaslan.tutorialmod.register;

import cpw.mods.fml.common.registry.GameRegistry;
import itsaslan.tutorialmod.generation.stellarGeneration;

public class registerGenerators {

    public static void oreGen()
    {
        GameRegistry.registerWorldGenerator(new stellarGeneration(), 0);
        System.out.println("Initialized Ore Gen");
    }

}
