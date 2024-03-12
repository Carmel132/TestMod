package itsaslan.tutorialmod.tileentity;

import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class bombTestTileEntity extends EntityTNTPrimed
{

    private final float radius;

    public bombTestTileEntity(World world) {
        super(world);
        this.radius = 4.0f; // Default radius value or consider another way to set this
    }

    public bombTestTileEntity(World world, float radius) {
        super(world);
        this.radius = radius;
    }

    public void explodeBlock()
    {
        if(!this.worldObj.isRemote)
        {

        }
    }

}
