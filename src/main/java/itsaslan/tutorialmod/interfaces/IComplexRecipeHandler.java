package itsaslan.tutorialmod.interfaces;

import net.minecraft.item.ItemStack;


// For recipes without a GUI
public interface IComplexRecipeHandler
{
    ItemStack[] getInputs();
    ItemStack getOutputs();
    int getContainerSize();
}
