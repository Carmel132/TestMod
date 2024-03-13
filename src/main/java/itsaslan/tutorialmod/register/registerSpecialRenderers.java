package itsaslan.tutorialmod.register;

import cpw.mods.fml.client.registry.ClientRegistry;
import itsaslan.tutorialmod.render.tileentity.BombTestEntityRenderer;
import itsaslan.tutorialmod.tileentity.BombTestTileEntity;

public class registerSpecialRenderers
{
    public static void init()
    {
        ClientRegistry.bindTileEntitySpecialRenderer(BombTestTileEntity.class, new BombTestEntityRenderer());
    }
}
