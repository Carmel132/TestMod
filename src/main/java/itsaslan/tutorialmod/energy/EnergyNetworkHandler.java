package itsaslan.tutorialmod.energy;

import itsaslan.tutorialmod.interfaces.IEnergyPath;
import net.minecraft.block.Block;

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

    public EnergyNetwork createNetwork(Block block)
    {
        EnergyNetwork newNetwork = new EnergyNetwork();
        newNetwork.addBlock(block);
        networks.add(newNetwork);
        return newNetwork;
    }

    public void deleteNetwork(EnergyNetwork network)
    {
        networks.remove(network);
    }

}
