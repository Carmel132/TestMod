package itsaslan.tutorialmod.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class GrenadeEntity extends EntityThrowable
{

    private int radius;


    public int getRadius()
    {
        return radius;
    }

    public GrenadeEntity(World world)
    {
        super(world);
    }

    public GrenadeEntity(World world, int radius)
    {
        super(world);
        this.radius = radius;
    }

    public GrenadeEntity(World world, EntityLivingBase entityLiving, int radius) {
        super(world, entityLiving);
        this.radius = radius;
    }

    public GrenadeEntity(World world, int radius, double x, double y, double z) {
        super(world, x, y, z);
        this.radius = radius;
    }

    @Override
    protected void onImpact(MovingObjectPosition position)
    {
        if(!worldObj.isRemote)
        {
            worldObj.createExplosion(this, this.posX, this.posY, this.posZ, radius, false);
            this.setDead();
        }
    }
}
