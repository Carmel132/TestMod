package itsaslan.tutorialmod.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import itsaslan.tutorialmod.lib.ModVars;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class TutorialModBlocks {

    public static InteractableBlocks blockOfStellarOre;
    public static TutorialBlock stellarOre;
    public static Block waxCrop;
    public static Block interactableTest;

    public static Block waxChest;

    public static void init()
    {
        blockOfStellarOre = new InteractableBlocks(Material.rock, "blockOfStellarOre", 3.0f, 1.0f, 2, 500.0f, Block.soundTypeAnvil);
        GameRegistry.registerBlock(blockOfStellarOre, blockOfStellarOre.getUnlocalizedName());

        stellarOre = new TutorialBlock(Material.rock, "stellarOre", 3.0f, 0.5f, 2, 500.0f, Block.soundTypeStone);
        GameRegistry.registerBlock(stellarOre, stellarOre.getUnlocalizedName());

        waxCrop = new TutorialCrop().setBlockName("waxCrop").setBlockTextureName(ModVars.MOD_ID + ":waxCrop");
        GameRegistry.registerBlock(waxCrop, waxCrop.getUnlocalizedName());

        interactableTest = new InteractableBlocks(Material.rock, "interactableTest", 3.0f, 1.0f, 2, 500.0f, Block.soundTypeAnvil).setBlockName("interactableTest");
        GameRegistry.registerBlock(interactableTest, interactableTest.getUnlocalizedName());

    }

}
