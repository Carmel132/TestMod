package itsaslan.tutorialmod.recipes;

import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;

public class KilnRecipe
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
