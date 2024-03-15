package itsaslan.tutorialmod.handlers;

import itsaslan.tutorialmod.interfaces.IRecipeHandler;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecipeHandler
{

    private final static List<IRecipeHandler> recipes = new ArrayList<IRecipeHandler>();

    public static <T extends IRecipeHandler> void addRecipe(T recipe)
    {
        recipes.add(recipe);
    }

    public static ItemStack findMatchingRecipe(InventoryCrafting craftMatrix)
    {
        for (IRecipeHandler recipe : recipes)
        {
            if(doesRecipeMatch(recipe, craftMatrix))
            {
                return recipe.getOutput().copy();
            }
        }
        return null;
    }

    private static boolean doesRecipeMatch(IRecipeHandler recipe, InventoryCrafting craftMatrix)
    {
        List<ItemStack> inputsNeeded = new ArrayList<ItemStack>(Arrays.asList(recipe.getInputs()));

        for(int i = 0; i < craftMatrix.getSizeInventory(); i++)
        {
            ItemStack slotStack = craftMatrix.getStackInSlot(i);
            if(slotStack != null)
            {
                boolean matched = false;

                for(ItemStack input : inputsNeeded)
                {
                    if(slotStack.getItem() == input.getItem())
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
