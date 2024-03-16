package itsaslan.tutorialmod.recipes.complexRecipes;

import itsaslan.tutorialmod.interfaces.IComplexRecipeHandler;
import net.minecraft.item.ItemStack;

public class PotRecipe implements IComplexRecipeHandler
{

    private ItemStack[] inputs;
    private ItemStack output;

    public PotRecipe(ItemStack output, ItemStack[] inputs)
    {
        this.output = output;
        this.inputs = inputs;
    }

    @Override
    public ItemStack[] getInputs() {
        return inputs;
    }

    @Override
    public ItemStack getOutputs() {
        return output;
    }

    @Override
    public int getContainerSize() {
        return 3;
    }
}
