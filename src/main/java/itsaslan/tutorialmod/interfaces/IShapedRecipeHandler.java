package itsaslan.tutorialmod.interfaces;

import net.minecraft.item.ItemStack;

public interface IShapedRecipeHandler
{
    ItemStack getOutput();
    ItemStack[] getInputs();
}
