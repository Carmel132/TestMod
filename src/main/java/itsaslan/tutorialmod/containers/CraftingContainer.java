package itsaslan.tutorialmod.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class CraftingContainer extends Container
{

    private InventoryCrafting craftingMatrix;
    private IInventory craftResult = new InventoryCraftResult();

    private IInventory inventory;

    private static final int CRAFTING_INPUT_COLUMNS = 3;
    private static final int CRAFTING_INPUT_ROWS = 3;

    public CraftingContainer(InventoryPlayer playerInventory, TileEntity tileEntity)
    {
        this.inventory = (IInventory) tileEntity;
        this.craftingMatrix = new InventoryCrafting(this, CRAFTING_INPUT_COLUMNS, CRAFTING_INPUT_ROWS);

        for (int i = 0; i < CRAFTING_INPUT_COLUMNS; ++i)
        {
            for(int j = 0; j < CRAFTING_INPUT_ROWS; ++j)
            {
                this.addSlotToContainer(new Slot(inventory, j + i * CRAFTING_INPUT_COLUMNS, 30 + j * 18, 17 + i * 18));
            }
        }

        this.addSlotToContainer(new SlotCrafting(playerInventory.player, craftingMatrix, craftResult, 11, 124, 35));

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int i = 0; i < 9; ++i) {
            this.addSlotToContainer(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int index) {
        ItemStack itemstack = null;
        Slot slot = (Slot) this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            // If the index is in the chest inventory
            if (index < CRAFTING_INPUT_ROWS * CRAFTING_INPUT_COLUMNS) {
                // try to place in player inventory / action bar
                if (!this.mergeItemStack(itemstack1, CRAFTING_INPUT_ROWS * CRAFTING_INPUT_COLUMNS, this.inventorySlots.size(), true)) {
                    return null;
                }
            }
            // Item is in player inventory, try to move to chest
            else if (!this.mergeItemStack(itemstack1, 0, CRAFTING_INPUT_ROWS * CRAFTING_INPUT_COLUMNS, false)) {
                return null;
            }

            if (itemstack1.stackSize == 0) {
                slot.putStack((ItemStack) null);
            } else {
                slot.onSlotChanged();
            }
        }

        return itemstack;
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }
}
