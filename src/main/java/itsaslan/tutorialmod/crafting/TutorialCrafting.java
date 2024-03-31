package itsaslan.tutorialmod.crafting;

import cpw.mods.fml.common.registry.GameRegistry;
import itsaslan.tutorialmod.blocks.TutorialModBlocks;
import itsaslan.tutorialmod.items.TutorialModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class TutorialCrafting {

    public static void init()
    {

        GameRegistry.addSmelting(TutorialModBlocks.stellarOre, new ItemStack(TutorialModItems.stellarIngot), 10.0f);
        //GameRegistry.addSmelting(Items.iron_ingot, new ItemStack(TutorialModItems.stellarIngot), 10.0f);
        GameRegistry.addSmelting(TutorialModItems.steelMix, new ItemStack(TutorialModItems.steelIngot, 2), 10.0f);
        GameRegistry.addSmelting(TutorialModItems.copperMix, new ItemStack(TutorialModItems.copperIngot, 2), 0.0f);
        GameRegistry.addSmelting(TutorialModBlocks.uraniumOre, new ItemStack(TutorialModItems.uraniumIngot), 10.0f);

        GameRegistry.addRecipe(new ItemStack(TutorialModBlocks.blockOfStellarOre), new Object[]{"III", "III", "III", 'I', TutorialModItems.stellarIngot});

        //GameRegistry.addRecipe(new ItemStack(TutorialModItems.stellarGem), new Object[]{"III", "IKI", "III", 'I', TutorialModItems.stellarIngot, 'K', Items.nether_star});
        //GameRegistry.addShapelessRecipe(new ItemStack(TutorialModItems.stellarGem), new Object[]{TutorialModItems.wax, TutorialModItems.sandPaper, TutorialModItems.stellarIngot});

        GameRegistry.addRecipe(new ItemStack(TutorialModItems.stellarHelmet), new Object[]{"III", "I I", 'I', TutorialModItems.stellarGem});
        GameRegistry.addRecipe(new ItemStack(TutorialModItems.stellarChestplate), new Object[]{"I I", "III", "III", 'I', TutorialModItems.stellarGem});
        GameRegistry.addRecipe(new ItemStack(TutorialModItems.stellarLeggings), new Object[]{"III", "I I", "I I", 'I', TutorialModItems.stellarGem});
        GameRegistry.addRecipe(new ItemStack(TutorialModItems.stellarBoots), new Object[]{"I I", "I I", 'I', TutorialModItems.stellarGem});

        GameRegistry.addRecipe(new ItemStack(TutorialModItems.stellarSword), new Object[]{"I", "I", "K", 'I', TutorialModItems.stellarIngot, 'K', Items.stick});
        GameRegistry.addRecipe(new ItemStack(TutorialModItems.stellarAxe), new Object[]{"II", "IK", " K", 'I', TutorialModItems.stellarIngot, 'K', Items.stick});
        GameRegistry.addRecipe(new ItemStack(TutorialModItems.stellarPickaxe), new Object[]{"III", " K ", " K ", 'I', TutorialModItems.stellarIngot, 'K', Items.stick});
        GameRegistry.addRecipe(new ItemStack(TutorialModItems.stellarShovel), new Object[]{"I", "K", "K", 'I', TutorialModItems.stellarIngot, 'K', Items.stick});
        GameRegistry.addRecipe(new ItemStack(TutorialModItems.stellarHoe), new Object[]{"II", " K", " K", 'I', TutorialModItems.stellarIngot, 'K', Items.stick});

        GameRegistry.addShapelessRecipe(new ItemStack(TutorialModItems.sandPaper, 16), new Object[]{Blocks.sand, Blocks.sand, Items.paper});
        GameRegistry.addShapelessRecipe(new ItemStack(TutorialModItems.waxSeed, 4), new Object[]{Items.sugar, Items.coal, Items.paper});

        GameRegistry.addRecipe(new ItemStack(TutorialModItems.stellarIngot), new Object[]{"III", "III", "III", 'I', TutorialModItems.stellarNugget});
        GameRegistry.addShapelessRecipe(new ItemStack(TutorialModItems.stellarNugget, 9), new Object[]{TutorialModItems.stellarIngot});
        GameRegistry.addShapelessRecipe(new ItemStack(TutorialModItems.steelMix, 4), new Object[]{Items.coal, Items.iron_ingot});

        GameRegistry.addRecipe(new ItemStack(TutorialModBlocks.waxChest), new Object[]{"IKI", "I I", "III", 'I', TutorialModItems.wax, 'K', Blocks.glass_pane});

        GameRegistry.addRecipe(new ItemStack(TutorialModBlocks.testCraftingTableBlock), new Object[]{"III", "OKO", "III", 'I', TutorialModItems.steelIngot, 'O', TutorialModItems.wax, 'K', Blocks.crafting_table});
        GameRegistry.addRecipe(new ItemStack(TutorialModBlocks.kilnBlock), new Object[]{"III", "IKI", "III", 'I', Items.brick, 'K', Blocks.furnace});

        GameRegistry.addRecipe(new ItemStack(TutorialModItems.cloth, 8), new Object[]{"IK", "KI", 'I', Items.string, 'K', Blocks.wool});
        GameRegistry.addRecipe(new ItemStack(TutorialModItems.infusingRod), new Object[]{"I", "K", "I", 'I', TutorialModItems.copperIngot, 'K', Items.redstone});

        GameRegistry.addRecipe(new ItemStack(TutorialModBlocks.armorInfuser), new Object[]{"III", "JKJ", "LLL", 'I', TutorialModItems.blackBrick, 'J', TutorialModItems.infusingRod, 'K', TutorialModItems.wax, 'L', TutorialModItems.steelIngot});

        GameRegistry.addRecipe(new ItemStack(TutorialModItems.cubeOfSpecialGrass), new Object[]{"III", "IJI", "III", 'I', TutorialModItems.specialGrassItem, 'J', TutorialModItems.wax});
        GameRegistry.addShapelessRecipe(new ItemStack(TutorialModItems.specialGrassItem, 8), new Object[]{TutorialModItems.cubeOfSpecialGrass});

        GameRegistry.addRecipe(new ItemStack(TutorialModItems.igniter), new Object[]{"I I", "LOL", "LLL", 'I', Items.redstone, 'L', TutorialModItems.steelIngot, 'O', TutorialModItems.lithiumCube});
        GameRegistry.addRecipe(new ItemStack(TutorialModItems.bombCore), new Object[]{"III", "IOI", "III", 'I', TutorialModItems.steelIngot, 'O', TutorialModItems.uraniumIngot});
        GameRegistry.addRecipe(new ItemStack(TutorialModItems.fuselage), new Object[]{"IOI", "IOI", "IOI", 'I', TutorialModItems.steelIngot, 'O', TutorialModItems.stellarGem});

        GameRegistry.addRecipe(new ItemStack(TutorialModItems.grenade), new Object[]{"IJ", "OO", 'I', TutorialModItems.steelIngot, 'O', TutorialModItems.dynamite, 'J', Items.string});
        GameRegistry.addShapelessRecipe(new ItemStack(TutorialModItems.dynamite, 4), new Object[]{Items.clay_ball, Items.clay_ball, TutorialModItems.sulfurCube, TutorialModItems.sulfurCube});

        GameRegistry.addRecipe(new ItemStack(TutorialModItems.sulfurCube), new Object[]{"III", "IOI", "III", 'I', TutorialModItems.sulfur, 'O', TutorialModItems.wax});

    }

}
