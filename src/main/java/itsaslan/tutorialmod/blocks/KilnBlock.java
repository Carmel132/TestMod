package itsaslan.tutorialmod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import itsaslan.tutorialmod.Main;
import itsaslan.tutorialmod.handlers.GuiHandler;
import itsaslan.tutorialmod.items.TutorialModItems;
import itsaslan.tutorialmod.lib.ModVars;
import itsaslan.tutorialmod.tileentity.KilnBlockTileEntity;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class KilnBlock extends BlockContainer
{

    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    private IIcon isOnFireIcon;
    private IIcon frontIcon;

    protected KilnBlock(Material material) {
        super(material);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {

        TileEntity hitTileEntity = world.getTileEntity(x, y, z);

        if(!world.isRemote)
        {
            if(world.getTileEntity(x, y, z) instanceof KilnBlockTileEntity)
            {
                if(player.inventory.getCurrentItem() != null)
                {
                    Item currentItem = player.inventory.getCurrentItem().getItem();

                    if(currentItem == Items.flint_and_steel)
                    {
                        this.setLightLevel(1.0f);
                        ((KilnBlockTileEntity) hitTileEntity).setActiveTimer(100);
                        int newMeta = 1;
                        world.setBlockMetadataWithNotify(x, y, z, newMeta, 2);
                    }
                    else if(currentItem == Items.lava_bucket)
                    {
                        this.setLightLevel(0.0f);
                        ((KilnBlockTileEntity) hitTileEntity).setActiveTimer(1000);
                        int newMeta = 1;
                        world.setBlockMetadataWithNotify(x, y, z, newMeta, 2);
                    }
                    else if(currentItem == TutorialModItems.cloth)
                    {
                        ((KilnBlockTileEntity) hitTileEntity).setActiveTimer(0);
                        int newMeta = 2;
                        world.setBlockMetadataWithNotify(x, y, z, newMeta, 2);
                    }
                    else
                    {
                        player.openGui(Main.instance, GuiHandler.KILN_GUI, world, x, y, z);
                    }
                }
                else
                {
                    player.openGui(Main.instance, GuiHandler.KILN_GUI, world, x, y, z);
                }
            }
        }

        return true;

    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister reg) {
        icons = new IIcon[6]; // One for each side

        this.isOnFireIcon = reg.registerIcon(ModVars.MOD_ID + ":tile.kilnSideFrontOnFire");
        this.frontIcon = reg.registerIcon(ModVars.MOD_ID + ":tile.kilnSideFront");

        // Assuming you have different textures named side0.png, side1.png, ..., side5.png in assets/yourmodid/textures/blocks/
        icons[0] = reg.registerIcon(ModVars.MOD_ID + ":tile.kilnBottom"); // Bottom
        icons[1] = reg.registerIcon(ModVars.MOD_ID + ":tile.kilnTop"); // Top
        icons[2] = reg.registerIcon(ModVars.MOD_ID + ":tile.kilnSideUniversal"); // North
        icons[4] = reg.registerIcon(ModVars.MOD_ID + ":tile.kilnSideUniversal"); // West
        icons[5] = reg.registerIcon(ModVars.MOD_ID + ":tile.kilnSideUniversal"); // East
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        if(meta == 1 && side == 3)
        {
            return this.isOnFireIcon; // Icon when kiln is on
        }
        else if (meta == 2 && side == 3)
        {
            return this.frontIcon; // Default top icon
        }
        else if (side == 3)
        {
            return this.frontIcon; // Default top icon
        }
        return icons[side]; // Other sides
    }


    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new KilnBlockTileEntity();
    }

}