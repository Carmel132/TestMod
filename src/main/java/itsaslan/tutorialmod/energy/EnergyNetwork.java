package itsaslan.tutorialmod.energy;

import itsaslan.tutorialmod.interfaces.IEnergyPath;
import itsaslan.tutorialmod.interfaces.IEnergySink;
import itsaslan.tutorialmod.interfaces.IEnergySource;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class EnergyNetwork
{

    List<IEnergySource> sources = new ArrayList<>();
    List<IEnergyPath> paths = new ArrayList<>();
    List<IEnergySink> sinks = new ArrayList<>();


    public void addBlock(Block block)
    {
        paths.add((IEnergyPath) block);
    }

    public void removeBlock(Block block)
    {
        paths.remove((IEnergyPath) block);
    }

    public boolean isEmpty()
    {
        return paths.isEmpty();
    }

}
