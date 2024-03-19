package itsaslan.tutorialmod.handlers;

import itsaslan.tutorialmod.interfaces.IComplexRecipeHandler;
import itsaslan.tutorialmod.interfaces.IShapedRecipeHandler;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ComplexRecipeHandler
{

    private final static List<IComplexRecipeHandler> recipes = new ArrayList<IComplexRecipeHandler>();

    public static <T extends IComplexRecipeHandler> void addRecipe(T recipe)
    {
        recipes.add(recipe);
    }

    public static ItemStack findMatchingRecipe(ItemStack[] storedItems)
    {
        for(IComplexRecipeHandler recipe : recipes)
        {
            if(doesRecipeMatch(recipe, storedItems))
            {
                return recipe.getOutputs().copy();
            }
        }
        return null;
    }

    public static boolean doesRecipeMatch(IComplexRecipeHandler recipe, ItemStack[] storedItems)
    {
        List<ItemStack> inputsNeeded = new ArrayList<ItemStack>(Arrays.asList(recipe.getInputs()));

        for(int i = 0; i < recipe.getContainerSize(); ++i)
        {
            ItemStack item = storedItems[i];

            if(item != null)
            {
                boolean matched = false;

                for(ItemStack input : inputsNeeded)
                {
                    if(item.getItem() == input.getItem())
                    {
                        matched = true;
                        inputsNeeded.remove(input);
                        break;
                    }
                }

                if(!matched)
                {
                    return false;
                }
            }
        }
        return inputsNeeded.isEmpty();
    }


}
