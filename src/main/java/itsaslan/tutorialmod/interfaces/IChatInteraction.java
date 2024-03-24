package itsaslan.tutorialmod.interfaces;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public interface IChatInteraction
{
    default EntityPlayer getPlayer(World world)
    {
        for(Object playerObj : world.playerEntities)
        {
            if(playerObj instanceof EntityPlayer)
            {
                return (EntityPlayer) playerObj;
            }
        }
        return null;
    }
}
