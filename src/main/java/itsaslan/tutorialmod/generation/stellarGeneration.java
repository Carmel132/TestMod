package itsaslan.tutorialmod.generation;

import cpw.mods.fml.common.IWorldGenerator;
import itsaslan.tutorialmod.blocks.TutorialModBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class stellarGeneration implements IWorldGenerator {


    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunckGenerator, IChunkProvider chunkProvider)
    {
        switch (world.provider.dimensionId)
        {
            case -1:
                //Generate Nether
                genNether(world, random, chunkX * 16, chunkZ * 16);
                break;
            case 0:
                //Generate Overworld
                genOverworld(world, random, chunkX * 16, chunkZ * 16);
                break;
            case 1:
                //Generate End
                genEnd(world, random, chunkX * 16, chunkZ * 16);
                break;
        }
        genAll(world, random, chunkX * 16, chunkZ * 16);
    }

    private void genNether(World world, Random random, int x, int z)
    {
        addOreSpawn(TutorialModBlocks.stellarOre, world, random, x, z, 16, 16, 6, 2, 3, 12, 30);
        addOreSpawn(TutorialModBlocks.sulfurOre, world, random, x, z, 16, 16, 5, 3, 6, 12, 50);
    }

    private void genOverworld(World world, Random random, int x, int z)
    {
        addOreSpawn(TutorialModBlocks.stellarOre, world, random, x, z, 16, 16, 6, 2, 3, 12, 30);
        addOreSpawn(TutorialModBlocks.copperOre, world, random, x, z, 16, 16, 6, 4, 5, 12, 60);
        addOreSpawn(TutorialModBlocks.uraniumOre, world, random, x, z, 16, 16, 3, 1, 2, 10, 35);
        addOreSpawn(TutorialModBlocks.sulfurOre, world, random, x, z, 16, 16, 12, 5, 8, 12, 50);
    }

    private void genEnd(World world, Random random, int x, int z)
    {
        addOreSpawn(TutorialModBlocks.stellarOre, world, random, x, z, 16, 16, 6, 2, 3, 12, 30);
    }

    private void genAll(World world, Random random, int x, int z)
    {
        addOreSpawn(TutorialModBlocks.stellarOre, world, random, x, z, 16, 16, 6, 2, 3, 12, 30);
    }

    public void addOreSpawn(Block block, World world, Random random, int blockX, int blockZ, int maxX, int maxZ, int maxVienSize, int minVienSize, int chanceToSpawn, int minY, int maxY)
    {
        for(int i = 0; i < chanceToSpawn; i++)
        {
            int xPos = blockX + random.nextInt(maxX);
            int yPos = minY + random.nextInt(maxY - minY);
            int zPos = blockZ + random.nextInt(maxZ);

            (new WorldGenMinable(block, maxVienSize)).generate(world, random, xPos, yPos, zPos);
        }
    }
}
