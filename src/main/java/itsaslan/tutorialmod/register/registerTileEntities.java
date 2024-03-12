package itsaslan.tutorialmod.register;

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import itsaslan.tutorialmod.Main;
import itsaslan.tutorialmod.lib.ModVars;
import itsaslan.tutorialmod.tileentity.BombTestTileEntity;
import itsaslan.tutorialmod.tileentity.KilnBlockTileEntity;
import itsaslan.tutorialmod.tileentity.TestCraftingTileEntity;
import itsaslan.tutorialmod.tileentity.TestTileEntity;

public class registerTileEntities
{
    public static void init()
    {
        GameRegistry.registerTileEntity(TestTileEntity.class, "testTileEntity");
        GameRegistry.registerTileEntity(TestCraftingTileEntity.class, "gemWorkbench");
        GameRegistry.registerTileEntity(KilnBlockTileEntity.class, "kilnTileEntity");
        GameRegistry.registerTileEntity(BombTestTileEntity.class, "bombTileEntity");
    }
}

