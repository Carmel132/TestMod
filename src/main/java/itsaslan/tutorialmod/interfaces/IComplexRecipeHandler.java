package itsaslan.tutorialmod.interfaces;

import net.minecraft.item.ItemStack;

public interface IComplexRecipeHandler
{
    ItemStack[] getInputs();
    ItemStack getOutputs();
    int getContainerSize();
}
