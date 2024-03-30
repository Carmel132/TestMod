package itsaslan.tutorialmod.dimensions;

import net.minecraftforge.common.DimensionManager;

public class dimensionRegistery
{

    public static final int dimensionId = 8;

    public static void init()
    {
        DimensionManager.registerProviderType(dimensionId, customWorldProvider.class, false);
        DimensionManager.registerDimension(dimensionId, dimensionId);
    }
}
