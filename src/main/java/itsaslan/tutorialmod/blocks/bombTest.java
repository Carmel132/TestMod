package itsaslan.tutorialmod.blocks;

import itsaslan.tutorialmod.tileentity.BombTestTileEntity;
import itsaslan.tutorialmod.tileentity.KilnBlockTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockTNT;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class bombTest extends BlockContainer
{

    private float radius;
    private BombTestTileEntity tileEntity;

    public bombTest(Material material, float radius)
    {
        super(material);
        this.radius = radius;
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
                world.createExplosion(null, x, y, z, radius, true); // Ensure radius is a valid field in BombTestTileEntity
            }
        }

    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new BombTestTileEntity();
    }
}
