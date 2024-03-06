package itsaslan.tutorialmod.handlers;

import itsaslan.tutorialmod.recipes.BasicRecipe;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecipeHandler
{
    private final static List<BasicRecipe> recipes = new ArrayList<BasicRecipe>();

    public static void addRecipe(ItemStack output, ItemStack... inputs)
    {
        recipes.add(new BasicRecipe(output, inputs));
    }

    public static ItemStack findMatchingRecipe(InventoryCrafting craftMatrix)
    {
        for(BasicRecipe recipe : recipes)
        {
            if(doesRecipeMatch(recipe, craftMatrix))
            {
                return recipe.getOutput().copy();
            }
        }
        return null;
    }

    private static boolean doesRecipeMatch(BasicRecipe recipe, InventoryCrafting craftMatrix)
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
