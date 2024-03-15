package itsaslan.tutorialmod.blocks;

import itsaslan.tutorialmod.tileentity.BombTestTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class bombTest extends BlockContainer
{

    private int radius;
    private BombTestTileEntity tileEntity;

    public bombTest(Material material, int radius)
    {
        super(material);
        this.radius = radius;
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
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {

        if(world.getTileEntity(x, y, z) instanceof BombTestTileEntity && !world.isRemote)
        {
            tileEntity = (BombTestTileEntity) world.getTileEntity(x, y, z);
            ((BombTestTileEntity) world.getTileEntity(x, y, z)).openBombGui(player);
        }

        return true;
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block blockID)
    {
        super.onNeighborBlockChange(world, x, y, z, blockID);

        if(world.getTileEntity(x, y, z) instanceof BombTestTileEntity) { // Assuming BombTestTileEntity is your custom TileEntity class
            BombTestTileEntity bombTileEntity = (BombTestTileEntity) world.getTileEntity(x, y, z);

            boolean isPowered = world.isBlockIndirectlyGettingPowered(x, y, z);

            if(isPowered && bombTileEntity.isReadyToBlow) {
                System.out.println("Blew up");
                world.setBlock(x, y, z, Blocks.air);

                calculateExplosion(world, x, y, z, radius, radius, radius);
                //world.createExplosion(null, x, y, z, radius, true); // Ensure radius is a valid field in BombTestTileEntity
            }
        }

    }

    private void calculateExplosion(World world, int x, int y, int z, int xPlane, int yPlane, int zHeight) // xPlane and yPlane are the dimensions of the 2d square which is then layered upon by the zHeight
    {
        for(int height = 0; height < zHeight; ++height)
        {
            for(int length = 0; length < yPlane; ++length)
            {
                for(int width = 0; width < xPlane; ++width)
                {
                    world.setBlock(x + width, y + (height - (height * 2)), z + length, Blocks.air);
                    world.setBlock(x - width, y + (height - (height * 2)), z + length, Blocks.air);
                    world.setBlock(x + width, y + (height - (height * 2)), z - length, Blocks.air);
                    world.setBlock(x - width, y + (height - (height * 2)), z - length, Blocks.air);
                    System.out.println("Set Block to air");
                }
            }
        }
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new BombTestTileEntity();
    }
}