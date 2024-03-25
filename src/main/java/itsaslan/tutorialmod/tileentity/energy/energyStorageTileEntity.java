package itsaslan.tutorialmod.tileentity.energy;

import itsaslan.tutorialmod.energy.EnergyNetwork;
import itsaslan.tutorialmod.energy.EnergyNetworkHandler;
import itsaslan.tutorialmod.enums.EnergyActionType;
import itsaslan.tutorialmod.interfaces.IChatInteraction;
import itsaslan.tutorialmod.interfaces.IEnergyPath;
import itsaslan.tutorialmod.interfaces.IEnergySink;
import itsaslan.tutorialmod.interfaces.INetwork;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class energyStorageTileEntity extends TileEntity implements IEnergySink, INetwork, IChatInteraction
{

    private EnergyNetwork network;
    private int energyLevel = 0;

    public void connectOrCreateNetwork() {

        EnergyNetworkHandler manager = EnergyNetworkHandler.getInstance();
        int[] location = scanForNetwork(worldObj, xCoord, yCoord, zCoord);

        if (location != null && !worldObj.isRemote)
        {

            INetwork block = (INetwork) worldObj.getTileEntity(location[0], location[1], location[2]);
            block.getNetwork().addBlock(worldObj.getTileEntity(xCoord, yCoord, zCoord));
            network = block.getNetwork();

            if (getPlayer(worldObj) != null) {getPlayer(worldObj).addChatMessage(new ChatComponentText("Connected to Network!"));}

        }
        else
        {
            if (!worldObj.isRemote)
            {

                network = manager.createNetwork(worldObj.getTileEntity(xCoord, yCoord, zCoord));
                if (getPlayer(worldObj) != null) {getPlayer(worldObj).addChatMessage(new ChatComponentText("Created Network!"));}

            }
        }
    }

    public void disconnectNetwork()
    {

        if (network != null && !worldObj.isRemote)
        {

            EnergyNetworkHandler manager = EnergyNetworkHandler.getInstance();
            network.removeBlock(worldObj.getTileEntity(xCoord, yCoord, zCoord));

            if (network.isEmpty())
            {
                manager.deleteNetwork(network);
                if (getPlayer(worldObj) != null) {getPlayer(worldObj).addChatMessage(new ChatComponentText("Deleted an Empty Network!"));}
            }

            network = null;
        }


    }

    @Override
    public int[] scanForNetwork(World world, int x, int y, int z) {
        return IEnergySink.super.scanForNetwork(world, x, y, z);
    }

    @Override
    public void setEnergyLevel(int energy) {
        energyLevel = energy;
    }

    @Override
    public int getEnergyLevel() {
        return energyLevel;
    }

    @Override
    public int getMaxEnergy() {
        return 1000;
    }

    @Override
    public EnergyActionType getEnergyStorageAction() {
        return EnergyActionType.INPUT;
    }

    @Override
    public EnergyNetwork getNetwork() {
        return network;
    }
}
