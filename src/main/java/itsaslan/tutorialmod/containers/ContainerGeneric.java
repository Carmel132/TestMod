package itsaslan.tutorialmod.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class ContainerGeneric extends Container {

    private IInventory chestInventory;

    private static final int CHEST_INVENTORY_ROWS = 3;
    private static final int CHEST_INVENTORY_COLUMNS = 9;

    public ContainerGeneric(){}

    public ContainerGeneric(InventoryPlayer player, TileEntity tileEntity)
    {

        this.chestInventory = (IInventory) tileEntity;

        for (int i = 0; i < CHEST_INVENTORY_ROWS; ++i) {
            for (int j = 0; j < CHEST_INVENTORY_COLUMNS; ++j) {
                this.addSlotToContainer(new Slot(chestInventory, j + i * CHEST_INVENTORY_COLUMNS, 8 + j * 18, 18 + i * 18));
            }
        }

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(player, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int i = 0; i < 9; ++i) {
            this.addSlotToContainer(new Slot(player, i, 8 + i * 18, 142));
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
            if (index < CHEST_INVENTORY_ROWS * CHEST_INVENTORY_COLUMNS) {
                // try to place in player inventory / action bar
                if (!this.mergeItemStack(itemstack1, CHEST_INVENTORY_ROWS * CHEST_INVENTORY_COLUMNS, this.inventorySlots.size(), true)) {
                    return null;
                }
            }
            // Item is in player inventory, try to move to chest
            else if (!this.mergeItemStack(itemstack1, 0, CHEST_INVENTORY_ROWS * CHEST_INVENTORY_COLUMNS, false)) {
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
