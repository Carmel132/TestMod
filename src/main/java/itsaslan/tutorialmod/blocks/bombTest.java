package itsaslan.tutorialmod.blocks;

import itsaslan.tutorialmod.tileentity.bombTestTileEntity;
import net.minecraft.block.BlockTNT;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class bombTest extends BlockTNT
{

    public bombTest()
    {
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {

        if(player.inventory.getCurrentItem() != null)
        {
            if(player.inventory.getCurrentItem().getItem() == Items.flint_and_steel)
            {
                bombTestTileEntity bomb = new bombTestTileEntity(world,10);
                world.spawnEntityInWorld(bomb);
                bomb.explode();
                System.out.println("Finished Loop");
            }
        }

        return true;
    }

    @Override
    public void onBlockDestroyedByExplosion(World world, int x, int y, int z, Explosion explosion)
    {

    }

}
