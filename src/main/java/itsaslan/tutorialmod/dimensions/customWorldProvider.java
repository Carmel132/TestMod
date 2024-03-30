package itsaslan.tutorialmod.dimensions;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class customWorldProvider extends WorldProvider
{

    public void registerWorldChunkManager()
    {
        this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.desertHills, 1.2f);
        this.dimensionId = dimensionRegistery.dimensionId;
    }

    public IChunkProvider createChunkGeneration()
    {
        return null;
    }

    @Override
    public String getDimensionName() {
        return "Moon";
    }
}
