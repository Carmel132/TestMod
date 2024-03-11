package itsaslan.tutorialmod.tileentity;

import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class bombTestTileEntity extends EntityTNTPrimed
{

    private final float radius;

    public bombTestTileEntity(World world, float radius) {
        super(world);
        this.radius = radius;
    }

    public void explode()
    {
        System.out.println("Exploded");
        worldObj.createExplosion(this, this.posX, this.posY, this.posZ, radius, true);
    }

}
