package itsaslan.tutorialmod.interfaces;

import itsaslan.tutorialmod.energy.EnergyNetwork;
import itsaslan.tutorialmod.enums.EnergyActionType;
import net.minecraft.block.Block;
import net.minecraft.world.World;

public interface IEnergySink
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
                return new int[]{dx, dy, dz};
            }
        }

        return null;
    }

    EnergyActionType getEnergyStorageAction();

    EnergyNetwork getNetwork();
}
