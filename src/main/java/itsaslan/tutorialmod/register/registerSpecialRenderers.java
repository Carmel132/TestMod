package itsaslan.tutorialmod.register;

import cpw.mods.fml.client.registry.ClientRegistry;
import itsaslan.tutorialmod.render.tileentity.BombTableEntityRenderer;
import itsaslan.tutorialmod.render.tileentity.BombTestEntityRenderer;
import itsaslan.tutorialmod.render.tileentity.FuelTankEntityRenderer;
import itsaslan.tutorialmod.render.tileentity.PotEntityRenderer;
import itsaslan.tutorialmod.tileentity.BombTestTileEntity;
import itsaslan.tutorialmod.tileentity.blockPotTileEntity;
import itsaslan.tutorialmod.tileentity.bombTableTileEntity;
import itsaslan.tutorialmod.tileentity.fuelTankTileEntity;

public class registerSpecialRenderers
{
    public static void init()
    {
        ClientRegistry.bindTileEntitySpecialRenderer(BombTestTileEntity.class, new BombTestEntityRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(blockPotTileEntity.class, new PotEntityRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(bombTableTileEntity.class, new BombTableEntityRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(fuelTankTileEntity.class, new FuelTankEntityRenderer());
    }
}
