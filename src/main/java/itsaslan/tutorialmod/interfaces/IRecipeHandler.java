package itsaslan.tutorialmod.interfaces;

import net.minecraft.item.ItemStack;

public interface IRecipeHandler
{
    ItemStack getOutput();
    ItemStack[] getInputs();
}
