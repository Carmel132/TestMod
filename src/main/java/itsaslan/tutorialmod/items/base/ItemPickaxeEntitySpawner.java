package itsaslan.tutorialmod.items.base;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class ItemPickaxeEntitySpawner extends ItemPickaxe
{
    protected ItemPickaxeEntitySpawner(ToolMaterial mat) {
        super(mat);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {

        if(!world.isRemote)
        {
            Vec3 playerLookVector = player.getLookVec();

            double spawnX = player.posX + playerLookVector.xCoord * 2;
            double spawnY = player.posY + player.getEyeHeight() + playerLookVector.yCoord * 2;
            double spawnZ = player.posZ + playerLookVector.zCoord * 2;

            EntityLargeFireball fireball = new EntityLargeFireball(world);
            fireball.setPosition(spawnX, spawnY, spawnZ);
            fireball.accelerationX = playerLookVector.xCoord * 0.4f;
            fireball.accelerationY = playerLookVector.yCoord * 0.4f;
            fireball.accelerationZ = playerLookVector.zCoord * 0.4f;

            fireball.field_92057_e = 1;
            fireball.shootingEntity = player;

            world.spawnEntityInWorld(fireball);
            stack.damageItem(1, player);

        }

        return stack;
    }
}
