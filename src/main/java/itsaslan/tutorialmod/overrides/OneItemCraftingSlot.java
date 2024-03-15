package itsaslan.tutorialmod.overrides;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class OneItemCraftingSlot extends Slot
{
    public OneItemCraftingSlot(IInventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public int getSlotStackLimit()
    {
        return 1;
    }
}
