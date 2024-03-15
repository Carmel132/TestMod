package itsaslan.tutorialmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import java.util.Random;

public class TallCropTop extends Block
{
    public TallCropTop() {
        super(Material.plants);
        setBlockName("tallCropTop");
        setBlockBounds(0F, 0F, 0F, 0F, 0F, 0F);
        setTickRandomly(false);
    }

    // Prevent dropping anything when the top part is broken directly
    @Override
    public Item getItemDropped(int meta, Random random, int fortune) {
        return null;
    }

    @Override
    public int getRenderType() {
        return 1; // Cross render type
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false; // This makes sure that the block doesn't block rendering of adjacent blocks.
    }

}
