package itsaslan.tutorialmod.tileentity.energy;

import itsaslan.tutorialmod.energy.EnergyNetwork;
import itsaslan.tutorialmod.energy.EnergyNetworkHandler;
import itsaslan.tutorialmod.interfaces.IChatInteraction;
import itsaslan.tutorialmod.interfaces.IEnergySource;
import itsaslan.tutorialmod.interfaces.INetwork;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class energySourceTileEntity extends TileEntity implements IEnergySource, INetwork, IChatInteraction
{

    private EnergyNetwork network;

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
    public EntityPlayer getPlayer(World world) {
        return IChatInteraction.super.getPlayer(world);
    }

    @Override
    public int[] scanForNetwork(World world, int x, int y, int z) {
        return IEnergySource.super.scanForNetwork(world, x, y, z);
    }

    @Override
    public int getProductionRate() {
        return 10;
    }

    @Override
    public int getMaxBuffer() {
        return 1000;
    }

    @Override
    public EnergyNetwork getNetwork() {
        return network;
    }
}
