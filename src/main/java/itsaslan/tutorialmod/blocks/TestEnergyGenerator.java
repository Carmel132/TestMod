package itsaslan.tutorialmod.blocks;

import itsaslan.tutorialmod.interfaces.IEnergyGen;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import tv.twitch.chat.ChatMessage;

import java.util.Random;

public class TestEnergyGenerator extends Block implements IEnergyGen
{

    private int energyPerTick;
    private int maxEnergyBuffer;

    private int currentEnergyBuffer = 0;
    private boolean isEnabled = false;


    protected TestEnergyGenerator(Material material, int energyPerTick, int maxEnergyBuffer) {
        super(material);

        this.energyPerTick = energyPerTick;
        this.maxEnergyBuffer = maxEnergyBuffer;
    }

    @Override
    public int getProductionRate() {
        return energyPerTick;
    }

    @Override
    public int getCurrentEnergyBuffer() {
        return currentEnergyBuffer;
    }

    @Override
    public int getMaxEnergyBuffer() {
        return maxEnergyBuffer;
    }

    public EntityPlayer getPlayer(World world)
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

    @Override
    public void onBlockAdded(World world, int x, int y, int z) {
        super.onBlockAdded(world, x, y, z);
        world.scheduleBlockUpdate(x, y, z, this, 1);
    }


    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        super.onNeighborBlockChange(world, x, y, z, block);

        if(!world.isRemote)
        {

            isEnabled = world.isBlockIndirectlyGettingPowered(x, y, z);

        }
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random random) {
        super.updateTick(world, x, y, z, random);

        if(!world.isRemote)
        {
            if(isEnabled && currentEnergyBuffer < getMaxEnergyBuffer())
            {
                currentEnergyBuffer += energyPerTick;
                world.markBlockForUpdate(x, y, z);
            }
            if(getPlayer(world) != null){getPlayer(world).addChatMessage(new ChatComponentText("Buffer is at: " + currentEnergyBuffer));}
        }
        world.scheduleBlockUpdate(x, y, z, this, 20);
    }
}
