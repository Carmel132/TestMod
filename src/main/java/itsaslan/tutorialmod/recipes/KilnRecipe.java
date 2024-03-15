package itsaslan.tutorialmod.recipes;

import itsaslan.tutorialmod.interfaces.IRecipeHandler;
import net.minecraft.item.ItemStack;

public class KilnRecipe implements IRecipeHandler
{
    private ItemStack[] inputs;
    private ItemStack output;

    public KilnRecipe(ItemStack output, ItemStack... input)
    {
        this.output = output;
        this.inputs = input;
    }

    public ItemStack getOutput()
    {
        return output;
    }

    public ItemStack[] getInputs()
    {
        return inputs;
    }
}
