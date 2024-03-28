package itsaslan.tutorialmod.register;

import cpw.mods.fml.client.registry.ClientRegistry;
import itsaslan.tutorialmod.render.tileentity.*;
import itsaslan.tutorialmod.tileentity.*;

public class registerSpecialRenderers
{
    public static void init()
    {
        ClientRegistry.bindTileEntitySpecialRenderer(BombTestTileEntity.class, new BombTestEntityRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(blockPotTileEntity.class, new PotEntityRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(bombTableTileEntity.class, new BombTableEntityRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(fuelTankTileEntity.class, new FuelTankEntityRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(thrusterTileEntity.class, new ThrusterEntityRenderer());
    }
}
