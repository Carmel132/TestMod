package itsaslan.tutorialmod.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import itsaslan.tutorialmod.Main;
import itsaslan.tutorialmod.items.TutorialModItems;
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
    public static Block specialGrassTop;
    public static Block specialGrassBottom;
    public static Block blockPot;
    public static Block uraniumOre;
    public static Block bombTable;
    public static Block energyStorage;
    public static Block cable;
    public static Block energyGenerator;
    public static Block fuelTank;
    public static Block thruster;
    public static Block controlBlock;
    public static Block sulfurOre;

    public static void init()
    {

        stellarOre = new TutorialBlock(Material.rock, "stellarOre", 3.0f, 0.5f, 2, 500.0f, Block.soundTypeStone);
        GameRegistry.registerBlock(stellarOre, stellarOre.getUnlocalizedName());

        copperOre = new TutorialBlock(Material.rock, "copperOre", 3.0f, 0.0f, 2, 200.0f, Block.soundTypeStone);
        GameRegistry.registerBlock(copperOre, copperOre.getUnlocalizedName());

        waxCrop = new TutorialCrop().setBlockName("waxCrop").setBlockTextureName(ModVars.MOD_ID + ":waxCrop");
        GameRegistry.registerBlock(waxCrop, waxCrop.getUnlocalizedName());

        testGuiBlock = new TestGuiBlock(Material.rock).setBlockName("testGuiBlock").setCreativeTab(Main.mainModTab);
        GameRegistry.registerBlock(testGuiBlock, testGuiBlock.getUnlocalizedName());

        testCraftingTableBlock = new TestCraftingTableBlock(Material.rock).setBlockName("testCraftingTableBlock").setCreativeTab(Main.mainModTab);
        GameRegistry.registerBlock(testCraftingTableBlock, testCraftingTableBlock.getUnlocalizedName());

        kilnBlock = new KilnBlock(Material.rock).setBlockName("Kiln").setCreativeTab(Main.mainModTab);
        GameRegistry.registerBlock(kilnBlock, kilnBlock.getUnlocalizedName());

        armorInfuser = new TutorialBlock(Material.rock, "armorInfuser", 3.0f, 0.5f, 2, 500.0f, Block.soundTypeStone);
        GameRegistry.registerBlock(armorInfuser, armorInfuser.getUnlocalizedName());

        blackRock = new TutorialBlock(Material.rock, "blackRock", 2.0f, 0.0f, 2, 20.0f, Block.soundTypeStone);
        GameRegistry.registerBlock(blackRock, blackRock.getUnlocalizedName());

        bombTest = new bombTest(Material.tnt, 50).setBlockName("bombTest").setCreativeTab(Main.mainModTab);
        GameRegistry.registerBlock(bombTest, bombTest.getUnlocalizedName());

        specialGrassBottom = new TallCropBottom().setBlockName("specialGrassBottom").setBlockTextureName(ModVars.MOD_ID + ":specialGrass");;
        GameRegistry.registerBlock(specialGrassBottom, specialGrassBottom.getUnlocalizedName());

        specialGrassTop = new TallCropTop().setCreativeTab(CreativeTabs.tabAllSearch).setBlockTextureName(ModVars.MOD_ID + ":specialGrassTop");
        GameRegistry.registerBlock(specialGrassTop, specialGrassTop.getUnlocalizedName());

        blockPot = new blockPot(Material.anvil).setCreativeTab(Main.mainModTab).setBlockName("blockPot");
        GameRegistry.registerBlock(blockPot, blockPot.getUnlocalizedName());

        uraniumOre = new TutorialBlock(Material.rock, "uraniumOre", 3.0f, 0.0f, 2, 500.0f, Block.soundTypeStone).setCreativeTab(Main.mainModTab).setBlockName("uraniumOre");
        GameRegistry.registerBlock(uraniumOre, uraniumOre.getUnlocalizedName());

        bombTable = new bombTable(Material.rock).setBlockName("bombTable").setCreativeTab(Main.mainModTab);
        GameRegistry.registerBlock(bombTable, bombTable.getUnlocalizedName());

        energyStorage = new BlockEnergyStorage(Material.anvil).setBlockName("storage").setCreativeTab(Main.mainModTab);
        energyStorage.setBlockTextureName(ModVars.MOD_ID + ":" + energyStorage.getUnlocalizedName());
        GameRegistry.registerBlock(energyStorage, energyStorage.getUnlocalizedName());

        cable = new BlockCable(Material.anvil).setBlockName("cable").setCreativeTab(Main.mainModTab);
        cable.setBlockTextureName(ModVars.MOD_ID + ":" + cable.getUnlocalizedName());
        GameRegistry.registerBlock(cable, cable.getUnlocalizedName());

        energyGenerator = new BlockEnergySource(Material.anvil).setBlockName("energyGenerator").setCreativeTab(Main.mainModTab);
        energyGenerator.setBlockTextureName(ModVars.MOD_ID + ":" + energyGenerator.getUnlocalizedName());
        GameRegistry.registerBlock(energyGenerator, energyGenerator.getUnlocalizedName());

        fuelTank = new BlockFuelTank(Material.anvil).setCreativeTab(Main.mainModTab).setBlockName("fuelTank");
        GameRegistry.registerBlock(fuelTank, fuelTank.getUnlocalizedName());

        thruster = new BlockThruster(Material.anvil).setCreativeTab(Main.mainModTab).setBlockName("thruster");
        GameRegistry.registerBlock(thruster, thruster.getUnlocalizedName());

        controlBlock = new TutorialBlock(Material.rock, "controlBlock", 3.0f, 0.5f, 2, 500.0f, Block.soundTypeAnvil);
        GameRegistry.registerBlock(controlBlock, controlBlock.getUnlocalizedName());

        sulfurOre = new OreBlockBase(Material.rock, "sulfurOre", Main.mainModTab, TutorialModItems.sulfur, 5, 10);
        GameRegistry.registerBlock(sulfurOre, sulfurOre.getUnlocalizedName());
    }

}
