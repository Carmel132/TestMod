package itsaslan.tutorialmod.register;

import itsaslan.tutorialmod.handlers.ComplexRecipeHandler;
import itsaslan.tutorialmod.items.TutorialModItems;
import itsaslan.tutorialmod.recipes.complexRecipes.PotRecipe;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class registerCustomComplexRecipes
{

    public static void init()
    {
        ComplexRecipeHandler.addRecipe(new PotRecipe(new ItemStack(TutorialModItems.steelIngot), new ItemStack[]{new ItemStack(Items.iron_ingot), new ItemStack(Items.coal)}));
    }

}
