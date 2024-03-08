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

    public static Block testGuiBlock;
    public static Block testCraftingTableBlock;
    public static Block kilnBlock;

    public static void init()
    {

        stellarOre = new TutorialBlock(Material.rock, "stellarOre", 3.0f, 0.5f, 2, 500.0f, Block.soundTypeStone);
        GameRegistry.registerBlock(stellarOre, stellarOre.getUnlocalizedName());

        waxCrop = new TutorialCrop().setBlockName("waxCrop").setBlockTextureName(ModVars.MOD_ID + ":waxCrop");
        GameRegistry.registerBlock(waxCrop, waxCrop.getUnlocalizedName());

        testGuiBlock = new TestGuiBlock(Material.rock).setBlockName("testGuiBlock").setCreativeTab(CreativeTabs.tabAllSearch);
        GameRegistry.registerBlock(testGuiBlock, testGuiBlock.getUnlocalizedName());

        testCraftingTableBlock = new TestCraftingTableBlock(Material.rock).setBlockName("testCraftingTableBlock").setCreativeTab(CreativeTabs.tabAllSearch);
        GameRegistry.registerBlock(testCraftingTableBlock, testCraftingTableBlock.getUnlocalizedName());

        kilnBlock = new KilnBlock(Material.rock).setBlockName("Kiln").setCreativeTab(CreativeTabs.tabDecorations);
        GameRegistry.registerBlock(kilnBlock, kilnBlock.getUnlocalizedName());

    }

}
