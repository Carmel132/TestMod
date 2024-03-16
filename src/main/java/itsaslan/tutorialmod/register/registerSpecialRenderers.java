package itsaslan.tutorialmod.register;

import cpw.mods.fml.client.registry.ClientRegistry;
import itsaslan.tutorialmod.render.tileentity.BombTestEntityRenderer;
import itsaslan.tutorialmod.render.tileentity.PotEntityRenderer;
import itsaslan.tutorialmod.tileentity.BombTestTileEntity;
import itsaslan.tutorialmod.tileentity.blockPotTileEntity;

public class registerSpecialRenderers
{
    public static void init()
    {
        ClientRegistry.bindTileEntitySpecialRenderer(BombTestTileEntity.class, new BombTestEntityRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(blockPotTileEntity.class, new PotEntityRenderer());
    }
}
