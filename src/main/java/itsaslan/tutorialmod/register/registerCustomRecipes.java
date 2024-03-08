package itsaslan.tutorialmod.register;

import itsaslan.tutorialmod.containers.CraftingContainer;
import itsaslan.tutorialmod.handlers.RecipeHandler;
import itsaslan.tutorialmod.items.TutorialModItems;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class registerCustomRecipes
{

    public static void init()
    {
        RecipeHandler.addRecipeBasicRecipe(new ItemStack(TutorialModItems.stellarGem), new ItemStack(TutorialModItems.wax), new ItemStack(TutorialModItems.sandPaper), new ItemStack(TutorialModItems.stellarIngot));
        RecipeHandler.addRecipeKilnRecipe(new ItemStack(TutorialModItems.steelMix, 4), new ItemStack(Items.iron_ingot), new ItemStack(Items.coal));
    }

}
