package itsaslan.tutorialmod.energy;

import itsaslan.tutorialmod.interfaces.IEnergyPath;
import itsaslan.tutorialmod.interfaces.IEnergySink;
import itsaslan.tutorialmod.interfaces.IEnergySource;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

import java.util.ArrayList;
import java.util.List;

public class EnergyNetworkHandler
{

    private static EnergyNetworkHandler instance;

    List<EnergyNetwork> networks = new ArrayList<>();

    private EnergyNetworkHandler()
    {

    }

    //Singleton :)
    public static EnergyNetworkHandler getInstance()
    {
        if (instance == null)
        {
            instance = new EnergyNetworkHandler();
        }
        return instance;
    }

    public EnergyNetwork createNetwork(TileEntity tileEntity)
    {
        EnergyNetwork newNetwork = new EnergyNetwork();
        newNetwork.addBlock(tileEntity);
        networks.add(newNetwork);
        return newNetwork;
    }

    public void deleteNetwork(EnergyNetwork network)
    {
        networks.remove(network);
    }

    public void distributeEnergy(EnergyNetwork network)
    {

        int tempProductionPerTick = 0;

        for(IEnergySource source : network.sources)
        {
            tempProductionPerTick += source.getProductionRate();
        }

        int averagedProductionPerTick = tempProductionPerTick / network.sinks.size();

        for(IEnergySink sinks : network.sinks)
        {
            if(sinks.getEnergyLevel() > sinks.getMaxEnergy())
            {
                sinks.setEnergyLevel(sinks.getEnergyLevel() + averagedProductionPerTick);
            }
        }

    }

}
