package itsaslan.tutorialmod.blocks;

import itsaslan.tutorialmod.Main;
import itsaslan.tutorialmod.handlers.GuiHandler;
import itsaslan.tutorialmod.tileentity.blockPotTileEntity;
import itsaslan.tutorialmod.tileentity.bombTableTileEntity;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class bombTable extends BlockContainer
{

    protected bombTable(Material material) {
        super(material);
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
        int orientation = MathHelper.floor_double((entity.rotationYaw * 4.0F) / 360.0F + 0.5D) & 3;
        TileEntity tile = world.getTileEntity(x, y, z);
        if (tile instanceof bombTableTileEntity) {
            ((bombTableTileEntity) tile).setOrientation(orientation);
        }
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {
        TileEntity hitTileEntity = world.getTileEntity(x, y, z);

        if(!world.isRemote)
        {
            if(world.getTileEntity(x, y, z) instanceof bombTableTileEntity)
            {
                player.openGui(Main.instance, GuiHandler.BOMBTABLEGUI, world, x, y, z);
            }
        }

        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new bombTableTileEntity();
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public int getRenderType()
    {
        return -1; // This tells Minecraft that the block does not have a default render type
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false; // This makes sure that the block doesn't block rendering of adjacent blocks.
    }

}
