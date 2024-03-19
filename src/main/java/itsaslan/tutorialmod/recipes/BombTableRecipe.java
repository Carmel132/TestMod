package itsaslan.tutorialmod.recipes;

import itsaslan.tutorialmod.interfaces.IShapedRecipeHandler;
import net.minecraft.item.ItemStack;

public class BombTableRecipe implements IShapedRecipeHandler
{

    private ItemStack output;
    private ItemStack[] inputs;

    public BombTableRecipe(ItemStack output, ItemStack[] inputs)
    {
        this.output = output;
        this.inputs = inputs;
    }

    @Override
    public ItemStack getOutput() {
        return output;
    }

    @Override
    public ItemStack[] getInputs() {
        return inputs;
    }

}
