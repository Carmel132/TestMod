package itsaslan.tutorialmod.tileentity;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class blockPotTileEntity extends TileEntity
{

    private ItemStack[] storedItems = new ItemStack[3];
    private boolean waterFilled = false;

    @Override
    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);

        compound.setBoolean("waterFilled", waterFilled);

        for(int item = 0; item < storedItems.length; ++item)
        {
            if(storedItems[item] != null)
            {
                NBTTagCompound itemTag = new NBTTagCompound();
                storedItems[item].writeToNBT(itemTag);
                compound.setTag("storedItem_" + item, itemTag);
            }
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);

        waterFilled = compound.getBoolean("waterFilled");

        for(int item = 0; item < storedItems.length; ++item)
        {
            if(compound.hasKey("storedItem_" + item))
            {
                NBTTagCompound itemTag = compound.getCompoundTag("storedItem_" + item);
                storedItems[item] = ItemStack.loadItemStackFromNBT(itemTag);
            }
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

    public void setStoredItem(ItemStack storedItem, int index)
    {
        this.storedItems[index] = storedItem;
        markDirty();
        if (!worldObj.isRemote) {
            worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
        }
    }

    public ItemStack[] getStoredItems()
    {
        return storedItems;
    }

    public ItemStack getStoredItemAtIndex(int index)
    {
        return storedItems[index];
    }

    public int getLength()
    {
        return storedItems.length;
    }

    public boolean getFilledWaterBool()
    {
        return waterFilled;
    }

    public void setFilledWaterBool(boolean bool)
    {
        this.waterFilled = bool;
        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    }
}
