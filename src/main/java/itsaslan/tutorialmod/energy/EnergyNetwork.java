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
        if(tileEntity instanceof IEnergySink)
        {
            sinks.add((IEnergySink) tileEntity);
        }
        else if(tileEntity instanceof IEnergyPath)
        {
            paths.add((IEnergyPath) tileEntity);
        }
        else if(tileEntity instanceof IEnergySource)
        {
            sources.add((IEnergySource) tileEntity);
        }
    }

    public void removeBlock(TileEntity tileEntity)
    {
        if(tileEntity instanceof IEnergySink)
        {
            sinks.remove((IEnergySink) tileEntity);
        }
        else if(tileEntity instanceof IEnergyPath)
        {
            paths.remove((IEnergyPath) tileEntity);
        }
        else if(tileEntity instanceof IEnergySource)
        {
            sources.remove((IEnergySource) tileEntity);
        }
    }

    public boolean isEmpty()
    {
        return paths.isEmpty() && sources.isEmpty() && sinks.isEmpty();
    }

}
