package itsaslan.tutorialmod.tileentity;

import itsaslan.tutorialmod.interfaces.IWaterBoiler;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.WorldServer;

public class blockPotTileEntity extends TileEntity implements IWaterBoiler
{

    private ItemStack[] storedItems = new ItemStack[3];
    private boolean waterFilled = false;

    private int elapsedTime = 0;
    private boolean startBoil = false;

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

    @Override
    public void updateEntity() {
        super.updateEntity();

        System.out.println("debug");
        double x = xCoord + 0.5;
        double y = yCoord + 1;
        double z = zCoord + 0.5;
        worldObj.spawnParticle("bubble", x, y, z, 0, 0.01D, 0);

        if(isBoiling() && getFilledWaterBool())
        {
            if(getElapsedBoilTimeTick() >= getTickTimeToBoil())
            {

            }
            else
            {
                setElapsedBoilTimeTick(getElapsedBoilTimeTick() + 1);
            }
        }
    }

    @Override
    public void onHeatupStart() {}

    @Override
    public void onBoil() {

    }

    @Override
    public void setElapsedBoilTimeTick(int time) {
        this.elapsedTime = time;
        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    }

    @Override
    public void setTickTimeToBoil(int time) {

    }

    @Override
    public void startBoil(boolean start) {
        this.startBoil = start;
        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    }

    @Override
    public boolean isBoiling() {
        return startBoil;
    }

    @Override
    public int getElapsedBoilTimeTick() {
        return elapsedTime;
    }

    @Override
    public int getTickTimeToBoil() {
        return 100;
    }
}
