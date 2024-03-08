package itsaslan.tutorialmod.blocks;

import itsaslan.tutorialmod.Main;
import itsaslan.tutorialmod.handlers.GuiHandler;
import itsaslan.tutorialmod.tileentity.KilnBlockTileEntity;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class KilnBlock extends BlockContainer
{

    protected KilnBlock(Material material) {
        super(material);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {
        if(!world.isRemote)
        {
            if(world.getTileEntity(x, y, z) instanceof KilnBlockTileEntity)
            {
                player.openGui(Main.instance, GuiHandler.KILN_GUI, world, x, y, z);
            }
        }

        return true;

    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new KilnBlockTileEntity();
    }

}
