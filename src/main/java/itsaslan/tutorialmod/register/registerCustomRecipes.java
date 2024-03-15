package itsaslan.tutorialmod.register;

import itsaslan.tutorialmod.blocks.TutorialModBlocks;
import itsaslan.tutorialmod.handlers.RecipeHandler;
import itsaslan.tutorialmod.items.TutorialModItems;
import itsaslan.tutorialmod.recipes.BasicRecipe;
import itsaslan.tutorialmod.recipes.KilnRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class registerCustomRecipes
{


    public static void init()
    {

        RecipeHandler.addRecipe(new BasicRecipe(new ItemStack(TutorialModItems.stellarGem), new ItemStack(TutorialModItems.wax), new ItemStack(TutorialModItems.sandPaper), new ItemStack(TutorialModItems.stellarIngot)));

        RecipeHandler.addRecipe(new KilnRecipe(new ItemStack(TutorialModItems.steelMix, 4), new ItemStack(Items.iron_ingot), new ItemStack(Items.coal)));
        RecipeHandler.addRecipe(new KilnRecipe(new ItemStack(Items.brick, 4), new ItemStack(Items.clay_ball), new ItemStack(Items.coal)));
        RecipeHandler.addRecipe(new KilnRecipe(new ItemStack(Blocks.glass, 8), new ItemStack(Blocks.sand), new ItemStack(Items.coal)));
        RecipeHandler.addRecipe(new KilnRecipe(new ItemStack(TutorialModItems.emeraldMix), new ItemStack(Items.emerald), new ItemStack(Items.blaze_powder)));
        RecipeHandler.addRecipe(new KilnRecipe(new ItemStack(TutorialModItems.copperMix, 4), new ItemStack(TutorialModBlocks.copperOre), new ItemStack(Items.coal)));
        RecipeHandler.addRecipe(new KilnRecipe(new ItemStack(TutorialModItems.blackBrick, 4), new ItemStack(TutorialModBlocks.blackRock), new ItemStack(Items.blaze_powder)));
        RecipeHandler.addRecipe(new KilnRecipe(new ItemStack(TutorialModItems.pickle), new ItemStack(Blocks.leaves), new ItemStack(Items.diamond)));

    }

}
