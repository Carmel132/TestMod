package itsaslan.tutorialmod.tileentity;

import itsaslan.tutorialmod.Main;
import itsaslan.tutorialmod.handlers.GuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TestTileEntity extends TileEntity implements IInventory
{

    private final ItemStack[] inventoryContents = new ItemStack[27];

    public void openTestGui(EntityPlayer player)
    {
        player.openGui(Main.instance, GuiHandler.TEST_GUI, worldObj, xCoord, yCoord, zCoord);
    }

    @Override
    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        NBTTagList items = new NBTTagList();

        for (int i = 0; i < this.inventoryContents.length; ++i) {
            if (this.inventoryContents[i] != null) {
                NBTTagCompound item = new NBTTagCompound();
                item.setByte("Slot", (byte)i);
                this.inventoryContents[i].writeToNBT(item);
                items.appendTag(item);
            }
        }

        compound.setTag("Items", items);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        NBTTagList items = compound.getTagList("Items", 10); // 10 is the tag type for NBTTagCompound

        for (int i = 0; i < items.tagCount(); ++i) {
            NBTTagCompound item = items.getCompoundTagAt(i);
            int slot = item.getByte("Slot") & 255;

            if (slot >= 0 && slot < this.inventoryContents.length) {
                this.inventoryContents[slot] = ItemStack.loadItemStackFromNBT(item);
            }
        }
    }

    @Override
    public int getSizeInventory() {
        return inventoryContents.length;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return inventoryContents[index];
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        if(inventoryContents[index] != null)
        {
            ItemStack itemStack;

            if(inventoryContents[index].stackSize <= count)
            {
                itemStack = inventoryContents[index];
                inventoryContents[index] = null;
                this.markDirty();
                return itemStack;
            }
            else
            {
                itemStack = inventoryContents[index].splitStack(count);

                if(inventoryContents[index].stackSize == 0)
                {
                    inventoryContents[index] = null;
                }

                this.markDirty();
                return itemStack;
            }
        }
        else
        {
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int index) {
        if(inventoryContents[index] != null)
        {
            ItemStack itemStack = inventoryContents[index];
            inventoryContents[index] = null;
            return itemStack;
        }
        else
        {
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        inventoryContents[index] = stack;

        if(stack != null && stack.stackSize > this.getInventoryStackLimit())
        {
            stack.stackSize = this.getInventoryStackLimit();
        }

        this.markDirty();
    }

    @Override
    public String getInventoryName() {
        return "Custom Chest";
    }

    @Override
    public boolean hasCustomInventoryName() {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this || player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return true;
    }
}
