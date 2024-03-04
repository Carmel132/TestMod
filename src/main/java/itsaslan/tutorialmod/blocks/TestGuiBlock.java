package itsaslan.tutorialmod.blocks;

import itsaslan.tutorialmod.tileentity.TestTileEntity;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TestGuiBlock extends BlockContainer
{

    protected TestGuiBlock(Material material) {
        super(material);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {
        if(!world.isRemote)
        {
            if(world.getTileEntity(x, y, z) instanceof TestTileEntity)
            {
                ((TestTileEntity) world.getTileEntity(x, y, z)).openTestGui(player);
            }
            return true;
        }


        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta){
        return new TestTileEntity();
    }

}
