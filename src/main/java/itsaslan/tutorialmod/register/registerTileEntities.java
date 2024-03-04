package itsaslan.tutorialmod.register;

import cpw.mods.fml.common.registry.GameRegistry;
import itsaslan.tutorialmod.tileentity.TestTileEntity;

public class registerTileEntities
{
    public static void init()
    {
        GameRegistry.registerTileEntity(TestTileEntity.class, "testTileEntity");
    }
}
