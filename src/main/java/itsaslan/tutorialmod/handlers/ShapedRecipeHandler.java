package itsaslan.tutorialmod.handlers;

import itsaslan.tutorialmod.interfaces.IShapedRecipeHandler;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShapedRecipeHandler
{
    private static List<IShapedRecipeHandler> shapedRecipes = new ArrayList<IShapedRecipeHandler>();

    public static void addShapedRecipe(IShapedRecipeHandler recipe) {
        shapedRecipes.add(recipe);
    }

    public static ItemStack findMatchingRecipe(InventoryCrafting storedItems) {
        for(IShapedRecipeHandler recipe : shapedRecipes) {
            if(doesRecipeMatch(recipe, storedItems))
            {
                return recipe.getOutput().copy();
            }
        }
        return null;
    }

    public static boolean doesRecipeMatch(IShapedRecipeHandler recipe, InventoryCrafting storedItems)
    {
        List<ItemStack> inputsNeeded = new ArrayList<ItemStack>(Arrays.asList(recipe.getInputs()));

        int matchedInt = 0;

        for(int i = 0; i < storedItems.getSizeInventory(); ++i)
        {
            ItemStack slotStack = storedItems.getStackInSlot(i);
            boolean matched = false;
            if(slotStack != null)
            {
                System.out.println(slotStack.getItem().getUnlocalizedName());
                if(inputsNeeded.get(i).getItem() == slotStack.getItem())
                {
                    matched = true;
                    matchedInt += 1;
                }
            }
            if(!matched)
            {
                break;
            }
        }
        return matchedInt == 16;
    }
}
