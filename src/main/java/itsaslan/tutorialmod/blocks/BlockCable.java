package itsaslan.tutorialmod.blocks;

import itsaslan.tutorialmod.energy.EnergyNetwork;
import itsaslan.tutorialmod.energy.EnergyNetworkHandler;
import itsaslan.tutorialmod.interfaces.IChatInteraction;
import itsaslan.tutorialmod.interfaces.IEnergyPath;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class BlockCable extends Block implements IEnergyPath, IChatInteraction
{

    private EnergyNetwork network;

    protected BlockCable(Material material) {
        super(material);
    }

    @Override
    public EntityPlayer getPlayer(World world)
    {
        return IChatInteraction.super.getPlayer(world);
    }

    @Override
    public void onBlockAdded(World world, int x, int y, int z) {
        super.onBlockAdded(world, x, y, z);

        EnergyNetworkHandler manager = EnergyNetworkHandler.getInstance();
        int[] location = scanForNetwork(world, x, y, z);
        if(location != null && !world.isRemote)
        {
            IEnergyPath block = (IEnergyPath) world.getBlock(location[0], location[1], location[2]);
            block.getNetwork().addBlock(this);
            network = block.getNetwork();
            if (getPlayer(world) != null){getPlayer(world).addChatMessage(new ChatComponentText("Connected to Network!"));}
        }
        else
        {
            network = manager.createNetwork(this);
            if (getPlayer(world) != null){getPlayer(world).addChatMessage(new ChatComponentText("Created Network!"));}
        }

    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int meta) {

        if(network != null && !world.isRemote)
        {
            EnergyNetworkHandler manager = EnergyNetworkHandler.getInstance();
            network.removeBlock(this);
            if(network.isEmpty())
            {
                manager.deleteNetwork(network);
                if (getPlayer(world) != null){getPlayer(world).addChatMessage(new ChatComponentText("Deleted an Empty Network"));}
            }

            network = null;

            super.breakBlock(world, x, y, z, block, meta);
        }
    }

    @Override
    public int[] scanForNetwork(World world, int x, int y, int z) {
        return IEnergyPath.super.scanForNetwork(world, x, y, z);
    }

    @Override
    public EnergyNetwork getNetwork() {
        return network;
    }



}
