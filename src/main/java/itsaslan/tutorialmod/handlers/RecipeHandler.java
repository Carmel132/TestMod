package itsaslan.tutorialmod.handlers;

import itsaslan.tutorialmod.recipes.BasicRecipe;
import itsaslan.tutorialmod.recipes.KilnRecipe;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecipeHandler
{
    private final static List<BasicRecipe> basicRecipes = new ArrayList<BasicRecipe>();
    private final static List<KilnRecipe> kilnRecipes = new ArrayList<KilnRecipe>();

    public static void addRecipeBasicRecipe(ItemStack output, ItemStack... inputs)
    {
        basicRecipes.add(new BasicRecipe(output, inputs));
    }

    public static void addRecipeKilnRecipe(ItemStack output, ItemStack... inputs)
    {
        kilnRecipes.add(new KilnRecipe(output, inputs));
    }

    public static ItemStack findMatchingRecipeBasic(InventoryCrafting craftMatrix)
    {
        for(BasicRecipe recipe : basicRecipes)
        {
            if(doesBasicRecipeMatch(recipe, craftMatrix))
            {
                return recipe.getOutput().copy();
            }
        }
        return null;
    }

    public static ItemStack findMatchingRecipeKiln(InventoryCrafting craftMatrix)
    {
        for(KilnRecipe recipe : kilnRecipes)
        {
            if(doesKilnRecipeMatch(recipe, craftMatrix))
            {
                return recipe.getOutput().copy();
            }
        }
        return null;
    }

    private static boolean doesBasicRecipeMatch(BasicRecipe recipe, InventoryCrafting craftMatrix)
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

    private static boolean doesKilnRecipeMatch(KilnRecipe recipe, InventoryCrafting craftMatrix)
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
