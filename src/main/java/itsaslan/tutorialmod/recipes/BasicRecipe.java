package itsaslan.tutorialmod.recipes;

import net.minecraft.item.ItemStack;

public class BasicRecipe
{
    private ItemStack[] inputs;
    private ItemStack output;

    public BasicRecipe(ItemStack output, ItemStack... input)
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
