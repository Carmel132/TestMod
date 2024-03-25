package itsaslan.tutorialmod.interfaces;

import itsaslan.tutorialmod.energy.EnergyNetwork;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public interface IEnergyPath
{
    int[][] offsets = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
    default int[] scanForNetwork(World world, int x, int y, int z)
    {

        for(int[] offset : offsets)
        {
            int dx = x + offset[0];
            int dy = y + offset[1];
            int dz = z + offset[2];

            TileEntity neighbor = world.getTileEntity(dx, dy, dz);

            if(neighbor instanceof INetwork)
            {
                if(((INetwork) neighbor).getNetwork() != this.getNetwork())
                {
                    return new int[]{dx, dy, dz};
                }
            }

        }

        return null;
    }

    EnergyNetwork getNetwork();
}
