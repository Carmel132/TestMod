package itsaslan.tutorialmod.blocks;

import itsaslan.tutorialmod.interfaces.IEnergyConductor;
import itsaslan.tutorialmod.interfaces.IEnergyGen;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import java.util.Random;

public class TestEnergyCable extends Block implements IEnergyConductor
{

    private int[][] connections = new int[6][3];
    private int[][] sources = new int[6][3];
    private boolean isConducting = false;
    private int energyTransfer = 0;

    protected TestEnergyCable(Material material) {
        super(material);
    }

    @Override
    public void getConnections() {

    }

    @Override
    public void getSources() {

    }

    @Override
    public boolean isConducting() {
        return isConducting;
    }

    @Override
    public int getEnergyTranser()
    {
        return energyTransfer;
    }

    public EntityPlayer getPlayer(World world)
    {
        for(Object playerObj : world.playerEntities)
        {
            if(playerObj instanceof EntityPlayer)
            {
                return (EntityPlayer) playerObj;
            }
        }
        return null;
    }

    @Override
    public void onBlockAdded(World world, int x, int y, int z) {
        super.onBlockAdded(world, x, y, z);
        world.scheduleBlockUpdate(x, y, z, this, 1);
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        super.onNeighborBlockChange(world, x, y, z, block);

        if(!world.isRemote)
        {
            int[][] offsets = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};

            int i = 0;

            for(int[] offset : offsets)
            {
                int dx = x + offset[0];
                int dy = y + offset[1];
                int dz = z + offset[2];

                Block neighborBlock = world.getBlock(dx, dy, dz);

                if(neighborBlock instanceof IEnergyConductor)
                {
                    connections[i] = new int[]{dx, dy, dz};
                }
                if(neighborBlock instanceof IEnergyGen)
                {
                    sources[i] = new int[]{dx, dy, dz};
                }

                i += 1;
            }

        }
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random random) {
        super.updateTick(world, x, y, z, random);

        if(!world.isRemote)
        {
            if(isConducting())
            {
                if(getPlayer(world) != null){getPlayer(world).addChatMessage(new ChatComponentText(this.getUnlocalizedName() + " is conducting."));}
            }
        }
        world.scheduleBlockUpdate(x, y, z, this, 20);
    }

}
