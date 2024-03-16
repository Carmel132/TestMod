package itsaslan.tutorialmod.blocks;

import itsaslan.tutorialmod.handlers.ComplexRecipeHandler;
import itsaslan.tutorialmod.tileentity.blockPotTileEntity;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import static org.apache.commons.lang3.ArrayUtils.contains;

public class blockPot extends BlockContainer
{

    Item[] allowedItems = new Item[]{Items.iron_ingot, Items.gold_ingot, Items.coal};

    protected blockPot(Material material) {
        super(material);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {

        if(!world.isRemote && world.getTileEntity(x, y, z) instanceof blockPotTileEntity)
        {

            blockPotTileEntity tileEntity = (blockPotTileEntity) world.getTileEntity(x, y, z);

            if(player.getHeldItem() != null && contains(allowedItems, player.getHeldItem().getItem()))
            {

                for(int i = 0; i < tileEntity.getLength(); ++i)
                {

                    if(tileEntity.getStoredItemAtIndex(i) == null)
                    {
                        tileEntity.setStoredItem(player.getHeldItem().copy(), i);
                        tileEntity.getStoredItemAtIndex(i).stackSize = 1;
                        if(!player.capabilities.isCreativeMode)
                        {
                            player.getHeldItem().stackSize--;
                        }

                        matchedOuput(tileEntity.getStoredItems());

                        break;

                    }
                }

            }
            else if (player.getHeldItem() != null && player.getHeldItem().getItem() == Items.water_bucket)
            {
                if(!tileEntity.getFilledWaterBool())
                {
                    tileEntity.setFilledWaterBool(true);
                }
            }
            else if (player.getHeldItem() != null && player.getHeldItem().getItem() == Items.bucket)
            {
                if(tileEntity.getFilledWaterBool())
                {
                    tileEntity.setFilledWaterBool(false);
                }
            }
        }
        return true;
    }

    public static void matchedOuput(ItemStack[] currentItems)
    {
        ItemStack result = ComplexRecipeHandler.findMatchingRecipe(currentItems);
        if(result != null)
        {
            System.out.println("correct Recipe");
        }
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new blockPotTileEntity();
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
