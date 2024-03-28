package itsaslan.tutorialmod.blocks;

import itsaslan.tutorialmod.tileentity.fuelTankTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockFuelTank extends BlockContainer
{

    protected BlockFuelTank(Material p_i45394_1_) {
        super(p_i45394_1_);
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public int getRenderType()
    {
        return -1;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new fuelTankTileEntity();
    }
}
