package itsaslan.tutorialmod.tileentity;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class blockPotTileEntity extends TileEntity
{

    private ItemStack storedItem = null;

    @Override
    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        if (storedItem != null) {
            NBTTagCompound itemTag = new NBTTagCompound();
            storedItem.writeToNBT(itemTag);
            compound.setTag("storedItem", itemTag);
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        if (compound.hasKey("storedItem")) {
            NBTTagCompound itemTag = compound.getCompoundTag("storedItem");
            storedItem = ItemStack.loadItemStackFromNBT(itemTag);
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

    public void setStoredItem(ItemStack storedItem)
    {
        this.storedItem = storedItem;
        markDirty();
        if (!worldObj.isRemote) {
            worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
        }
    }

    public ItemStack getStoredItem()
    {
        return storedItem;
    }
}
