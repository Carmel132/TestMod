package itsaslan.tutorialmod.interfaces;

import net.minecraft.item.ItemStack;


// For recipes with a GUI
public interface IRecipeHandler
{
    ItemStack getOutput();
    ItemStack[] getInputs();
}
