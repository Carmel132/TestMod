package itsaslan.tutorialmod.register;

import cpw.mods.fml.common.registry.GameRegistry;
import itsaslan.tutorialmod.render.tileentity.FuelTankEntityRenderer;
import itsaslan.tutorialmod.tileentity.*;

public class registerTileEntities
{
    public static void init()
    {
        GameRegistry.registerTileEntity(TestTileEntity.class, "testTileEntity");
        GameRegistry.registerTileEntity(TestCraftingTileEntity.class, "gemWorkbench");
        GameRegistry.registerTileEntity(KilnBlockTileEntity.class, "kilnTileEntity");
        GameRegistry.registerTileEntity(BombTestTileEntity.class, "bombTileEntity");
        GameRegistry.registerTileEntity(blockPotTileEntity.class, "blockPotTileEntity");
        GameRegistry.registerTileEntity(fuelTankTileEntity.class, "fuelTankTileEntity");
        GameRegistry.registerTileEntity(thrusterTileEntity.class, "thrusterTileEntity");
    }
}

