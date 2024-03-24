package itsaslan.tutorialmod.energy;

import itsaslan.tutorialmod.interfaces.IEnergyPath;
import itsaslan.tutorialmod.interfaces.IEnergySink;
import itsaslan.tutorialmod.interfaces.IEnergySource;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

import java.util.ArrayList;
import java.util.List;

public class EnergyNetwork
{

    List<IEnergySource> sources = new ArrayList<>();
    List<IEnergyPath> paths = new ArrayList<>();
    List<IEnergySink> sinks = new ArrayList<>();


    public void addBlock(TileEntity tileEntity)
    {
        paths.add((IEnergyPath) tileEntity);
    }

    public void removeBlock(TileEntity tileEntity)
    {
        paths.remove((IEnergyPath) tileEntity);
    }

    public boolean isEmpty()
    {
        return paths.isEmpty();
    }

}
