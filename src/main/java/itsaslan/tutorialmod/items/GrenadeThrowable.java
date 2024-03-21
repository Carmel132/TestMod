package itsaslan.tutorialmod.items;

import itsaslan.tutorialmod.entity.GrenadeEntity;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class GrenadeThrowable extends Item
{

    private int radius;

    public GrenadeThrowable(int radius)
    {
        super();

        this.maxStackSize = 16;
        this.setCreativeTab(CreativeTabs.tabMisc);
        this.radius = radius;

    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        if(!player.capabilities.isCreativeMode)
        {
            --itemStack.stackSize;
        }

        if(!world.isRemote)
        {
            world.spawnEntityInWorld(new GrenadeEntity(world, player, radius));
        }

        return itemStack;
    }
}
