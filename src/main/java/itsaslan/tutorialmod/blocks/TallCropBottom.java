package itsaslan.tutorialmod.blocks;

import itsaslan.tutorialmod.items.TutorialModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.IGrowable;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

public class TallCropBottom extends BlockCrops implements IGrowable
{

    @Override
    public int getRenderType() {
        return 1; // Cross render type
    }

    @Override
    protected Item func_149866_i() {

        return TutorialModItems.specialGrassSeed;
    }


    @Override
    protected Item func_149865_P() {

        return TutorialModItems.blackBrick;

    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int metadata) {
        super.breakBlock(world, x, y, z, block, metadata);
        if (world.getBlock(x, y + 1, z) == TutorialModBlocks.specialGrassTop)
        {
            this.dropBlockAsItem(world, x, y, z, new ItemStack(func_149865_P()));
            world.setBlock(x, y + 1, z, Blocks.air);
        }else {

            this.dropBlockAsItem(world, x, y, z, new ItemStack(func_149866_i()));

        }
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random rand) {
        super.updateTick(world, x, y, z, rand);
        int meta = world.getBlockMetadata(x, y, z);

        if (meta == 6 && world.isAirBlock(x, y + 1, z))
        {
            world.setBlock(x, y + 1, z, TutorialModBlocks.specialGrassTop, 0, 3);
        }
    }

    @Override
    public void func_149853_b(World world, Random rand, int x, int y, int z) {
        int meta = world.getBlockMetadata(x, y, z);

        System.out.println("Before Meta: " + meta);

        if (meta >= 6)
        {
            if (world.isAirBlock(x, y + 1, z))
            {
                world.setBlock(x, y + 1, z, TutorialModBlocks.specialGrassTop, 0, 3);
                world.setBlockMetadataWithNotify(x, y, z, 8, 2);
            }
        }
        else
        {
            int change = meta + MathHelper.getRandomIntegerInRange(world.rand, 1, 2);
            world.setBlockMetadataWithNotify(x, y, z, change, 2);
            meta = change;
            if (meta >= 6)
            {
                if (world.isAirBlock(x, y + 1, z))
                {
                    world.setBlock(x, y + 1, z, TutorialModBlocks.specialGrassTop, 0, 3);
                    world.setBlockMetadataWithNotify(x, y, z, 8, 2);
                }
            }
        }

        System.out.println("After Meta: " + meta);
    }
}
