package itsaslan.tutorialmod.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import itsaslan.tutorialmod.lib.ModVars;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class TutorialModBlocks {

    public static TutorialBlock blockOfStellarOre;
    public static TutorialBlock stellarOre;
    public static Block waxCrop;

    public static Block waxChest;

    public static void init()
    {

        stellarOre = new TutorialBlock(Material.rock, "stellarOre", 3.0f, 0.5f, 2, 500.0f, Block.soundTypeStone);
        GameRegistry.registerBlock(stellarOre, stellarOre.getUnlocalizedName());

        waxCrop = new TutorialCrop().setBlockName("waxCrop").setBlockTextureName(ModVars.MOD_ID + ":waxCrop");
        GameRegistry.registerBlock(waxCrop, waxCrop.getUnlocalizedName());

        waxChest = new WaxChest(0).setBlockName("waxChest").setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName(ModVars.MOD_ID + ":waxChest");
        GameRegistry.registerBlock(waxChest, waxChest.getUnlocalizedName());
    }

}
