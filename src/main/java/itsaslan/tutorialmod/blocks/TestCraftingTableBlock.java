package itsaslan.tutorialmod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import itsaslan.tutorialmod.Main;
import itsaslan.tutorialmod.handlers.GuiHandler;
import itsaslan.tutorialmod.lib.ModVars;
import itsaslan.tutorialmod.tileentity.TestCraftingTileEntity;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class TestCraftingTableBlock extends BlockContainer
{

    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

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
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister reg) {
        icons = new IIcon[6]; // One for each side

        // Assuming you have different textures named side0.png, side1.png, ..., side5.png in assets/yourmodid/textures/blocks/
        icons[0] = reg.registerIcon(ModVars.MOD_ID + ":tile.GemWorkbenchBottom"); // Bottom
        icons[1] = reg.registerIcon(ModVars.MOD_ID + ":tile.GemWorkbenchTop"); // Top
        icons[2] = reg.registerIcon(ModVars.MOD_ID + ":tile.GemWorkbenchSideUniversal"); // North
        icons[3] = reg.registerIcon(ModVars.MOD_ID + ":tile.GemWorkbenchSideUniversal"); // South
        icons[4] = reg.registerIcon(ModVars.MOD_ID + ":tile.GemWorkbenchSideUniversal"); // West
        icons[5] = reg.registerIcon(ModVars.MOD_ID + ":tile.GemWorkbenchSideUniversal"); // East
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return icons[side];
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta){
        return new TestCraftingTileEntity();
    }
}
