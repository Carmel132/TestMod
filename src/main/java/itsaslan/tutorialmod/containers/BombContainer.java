package itsaslan.tutorialmod.containers;

import itsaslan.tutorialmod.items.TutorialModItems;
import itsaslan.tutorialmod.overrides.OneItemCraftingSlot;
import itsaslan.tutorialmod.tileentity.BombTestTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class BombContainer extends Container
{

    private InventoryCrafting craftingMatrix;
    private BombTestTileEntity bombTestTileEntity;

    private static final int CRAFTING_INPUT_COLUMNS = 4;
    private static final int CRAFTING_INPUT_ROWS = 1;

    private Item[] requiredItems = new Item[]{TutorialModItems.igniter, TutorialModItems.fuselage, TutorialModItems.bombCore, Items.egg};

    public BombContainer(InventoryPlayer playerInventory, TileEntity tileEntity)
    {

        this.craftingMatrix = new InventoryCrafting(this, CRAFTING_INPUT_COLUMNS, CRAFTING_INPUT_ROWS);
        this.bombTestTileEntity = (BombTestTileEntity) tileEntity;


        for (int i = 0; i < 4; ++i)
        {
            this.addSlotToContainer(new OneItemCraftingSlot(craftingMatrix, i, 45 + i * 23, 34));
        }

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int i = 0; i < 9; ++i) {
            this.addSlotToContainer(new Slot(playerInventory, i, 8 + i * 18, 142));
        }

        this.bombTestTileEntity.loadCraftingInventory(this.craftingMatrix);
    }

    @Override
    public void onContainerClosed(EntityPlayer player) {
        super.onContainerClosed(player);
        if (!player.worldObj.isRemote) {
            // Save craftingMatrix contents to BombTestTileEntity
            this.bombTestTileEntity.saveCraftingInventory(this.craftingMatrix);
        }
    }

    @Override
    public void onCraftMatrixChanged(IInventory inventory) {
        super.onCraftMatrixChanged(inventory);

        bombTestTileEntity.isReadyToBlow = checkCorrectRecipe();
        if (bombTestTileEntity.isReadyToBlow) {System.out.println("Correct Orientation: " + requiredItems[0] + ", " + requiredItems[1] + ", " + requiredItems[2] + ", " + requiredItems[3]);}
    }

    public boolean checkCorrectRecipe()
    {
        for(int i = 0; i < CRAFTING_INPUT_COLUMNS; ++i)
        {
            if(craftingMatrix.getStackInSlot(i) != null)
            {
                if(craftingMatrix.getStackInSlot(i).getItem() != requiredItems[i])
                {
                    return false;
                }
            }
            else
            {
                return false;
            }

        }
        return true;
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
