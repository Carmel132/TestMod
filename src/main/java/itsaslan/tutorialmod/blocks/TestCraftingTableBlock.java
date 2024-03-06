package itsaslan.tutorialmod.blocks;

import itsaslan.tutorialmod.Main;
import itsaslan.tutorialmod.handlers.GuiHandler;
import itsaslan.tutorialmod.tileentity.TestCraftingTileEntity;
import itsaslan.tutorialmod.tileentity.TestTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TestCraftingTableBlock extends BlockContainer
{

    protected TestCraftingTableBlock(Material material) {
        super(material);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {

        if(!world.isRemote)
        {
            if(world.getTileEntity(x, y, z) instanceof TestCraftingTileEntity)
            {
                player.openGui(Main.instance, GuiHandler.TEST_CRAFTING_GUI, world, x, y, z);
            }
        }

        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta){
        return new TestCraftingTileEntity();
    }
}
