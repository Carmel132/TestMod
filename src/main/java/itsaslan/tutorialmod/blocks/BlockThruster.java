package itsaslan.tutorialmod.blocks;

import itsaslan.tutorialmod.tileentity.thrusterTileEntity;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockThruster extends BlockContainer
{

    protected BlockThruster(Material material) {
        super(material);
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public int getRenderType()
    {
        return -1; // This tells Minecraft that the block does not have a default render type
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false; // This makes sure that the block doesn't block rendering of adjacent blocks.
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new thrusterTileEntity();
    }
}
