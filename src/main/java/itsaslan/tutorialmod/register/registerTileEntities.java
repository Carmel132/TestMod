package itsaslan.tutorialmod.register;

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import itsaslan.tutorialmod.Main;
import itsaslan.tutorialmod.lib.ModVars;
import itsaslan.tutorialmod.tileentity.KilnBlockTileEntity;
import itsaslan.tutorialmod.tileentity.TestCraftingTileEntity;
import itsaslan.tutorialmod.tileentity.TestTileEntity;
import itsaslan.tutorialmod.tileentity.bombTestTileEntity;

public class registerTileEntities
{
    public static void init() {
        GameRegistry.registerTileEntity(TestTileEntity.class, "testTileEntity");
        GameRegistry.registerTileEntity(TestCraftingTileEntity.class, "gemWorkbench");
        GameRegistry.registerTileEntity(KilnBlockTileEntity.class, "kilnTileEntity");

        EntityRegistry.registerModEntity(bombTestTileEntity.class, "CustomTNTPrimed", 1, Main.instance, 64, 10, true);
    }
}

