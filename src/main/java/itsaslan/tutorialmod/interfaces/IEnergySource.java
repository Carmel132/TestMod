package itsaslan.tutorialmod.interfaces;

import itsaslan.tutorialmod.energy.EnergyNetwork;
import net.minecraft.block.Block;
import net.minecraft.world.World;

public interface IEnergySource
{
    int[][] offsets = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
    default int[] scanForNetwork(World world, int x, int y, int z)
    {

        for(int[] offset : offsets)
        {
            int dx = x + offset[0];
            int dy = y + offset[1];
            int dz = z + offset[2];

            Block neighbor = world.getBlock(dx, dy, dz);

            if(neighbor instanceof IEnergyPath)
            {
                if(((IEnergyPath) neighbor).getNetwork() != this.getNetwork())
                {
                    return new int[]{dx, dy, dz};
                }
            }
        }

        return null;
    }

    int getProductionRate();
    int getMaxBuffer();

    EnergyNetwork getNetwork();

}
