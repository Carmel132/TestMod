package itsaslan.tutorialmod.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class KilnBlockTileEntity extends TileEntity implements IInventory
{
    private final ItemStack[] inventoryContents = new ItemStack[27];

    private int activeTimer;

    public void setActiveTimer(int value)
    {
        activeTimer = value;
    }

    public int getActiveTimer()
    {
        return activeTimer;
    }

    @Override
    public void updateEntity()
    {
        super.updateEntity();

        //System.out.println(String.format("Time: %d, Timer: %d, Instance: %s", worldObj.getTotalWorldTime(), activeTimer, this));

        if(!worldObj.isRemote)
        {
            if(activeTimer > 0)
            {
                activeTimer = activeTimer - 1;
                this.markDirty(); // Mark the TileEntity as having changed
                worldObj.markBlockForUpdate(xCoord, yCoord, zCoord); // Request an update on the client side
            }

            if(activeTimer == 0)
            {
                int meta = 0;
                worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, meta, 2);
            }

        }


        if (activeTimer > 0 && activeTimer % 3 == 1) // activeTimer % 3 == 1 is to make particles appear 6 times instead of 20 per second
        {
            double x = xCoord + 0.5 + Math.random() * 0.5 - 0.25;
            double y = yCoord + 0.2;
            double z = zCoord + 1.1;
            worldObj.spawnParticle("flame", x, y, z, 0, 0.01D, 0);
            // Consider adding some randomness to the particle position for a more natural effect
        }
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tag = new NBTTagCompound();
        this.writeToNBT(tag);
        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, tag);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        readFromNBT(pkt.func_148857_g());
    }

    @Override
    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        NBTTagList items = new NBTTagList();
        compound.setInteger("ActiveTimer", activeTimer);

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
        activeTimer = compound.getInteger("ActiveTimer");

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
        return "Kiln";
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
