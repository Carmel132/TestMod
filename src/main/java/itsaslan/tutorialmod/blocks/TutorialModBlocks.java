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

    public static Block copperOre;
    public static Block armorInfuser;

    public static Block blackRock;

    public static Block bombTest;

    public static void init()
    {

        stellarOre = new TutorialBlock(Material.rock, "stellarOre", 3.0f, 0.5f, 2, 500.0f, Block.soundTypeStone);
        GameRegistry.registerBlock(stellarOre, stellarOre.getUnlocalizedName());

        copperOre = new TutorialBlock(Material.rock, "copperOre", 3.0f, 0.0f, 2, 200.0f, Block.soundTypeStone);
        GameRegistry.registerBlock(copperOre, copperOre.getUnlocalizedName());

        waxCrop = new TutorialCrop().setBlockName("waxCrop").setBlockTextureName(ModVars.MOD_ID + ":waxCrop");
        GameRegistry.registerBlock(waxCrop, waxCrop.getUnlocalizedName());

        testGuiBlock = new TestGuiBlock(Material.rock).setBlockName("testGuiBlock").setCreativeTab(CreativeTabs.tabAllSearch);
        GameRegistry.registerBlock(testGuiBlock, testGuiBlock.getUnlocalizedName());

        testCraftingTableBlock = new TestCraftingTableBlock(Material.rock).setBlockName("testCraftingTableBlock").setCreativeTab(CreativeTabs.tabAllSearch);
        GameRegistry.registerBlock(testCraftingTableBlock, testCraftingTableBlock.getUnlocalizedName());

        kilnBlock = new KilnBlock(Material.rock).setBlockName("Kiln").setCreativeTab(CreativeTabs.tabDecorations);
        GameRegistry.registerBlock(kilnBlock, kilnBlock.getUnlocalizedName());

        armorInfuser = new TutorialBlock(Material.rock, "armorInfuser", 3.0f, 0.5f, 2, 500.0f, Block.soundTypeStone);
        GameRegistry.registerBlock(armorInfuser, armorInfuser.getUnlocalizedName());

        blackRock = new TutorialBlock(Material.rock, "blackRock", 2.0f, 0.0f, 2, 20.0f, Block.soundTypeStone);
        GameRegistry.registerBlock(blackRock, blackRock.getUnlocalizedName());

        bombTest = new bombTest(Material.tnt, 20.0f).setBlockName("bombTest").setCreativeTab(CreativeTabs.tabBlock);
        GameRegistry.registerBlock(bombTest, bombTest.getUnlocalizedName());

    }

}
