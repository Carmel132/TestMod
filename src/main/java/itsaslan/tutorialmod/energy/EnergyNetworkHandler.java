package itsaslan.tutorialmod.energy;

import itsaslan.tutorialmod.interfaces.IEnergyPath;
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

}
