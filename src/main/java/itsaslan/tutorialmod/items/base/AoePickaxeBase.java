package itsaslan.tutorialmod.items.base;

import itsaslan.tutorialmod.api.ExtraMath;
import itsaslan.tutorialmod.enums.CardinalDirection;
import itsaslan.tutorialmod.lib.ModVars;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

public class AoePickaxeBase extends ItemPickaxeEntitySpawner
{

    private int COLUMNSIZE;
    private int ROWSIZE;

    public AoePickaxeBase(ToolMaterial mat, int ROWSIZE, int COLUMNSIZE, String unlocalizedName, CreativeTabs tab) {
        super(mat);
        this.ROWSIZE = ROWSIZE / 2;
        this.COLUMNSIZE = COLUMNSIZE / 2;
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(tab);

        this.setTextureName(ModVars.MOD_ID + ":" + this.getUnlocalizedName());
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int x, int y, int z, EntityLivingBase player)
    {
        if(!world.isRemote && player instanceof EntityPlayer)
        {
            EntityPlayer playerEntity = (EntityPlayer) player;
            CardinalDirection direction = ExtraMath.getPlayerGeneralDirection(playerEntity);

            for(int i = -COLUMNSIZE; i <= COLUMNSIZE; ++i)
            {
                for(int j = -ROWSIZE; j <= ROWSIZE; ++j)
                {
                    int newX = x;
                    int newY = y + i;
                    int newZ = z;

                    if(direction.equals(CardinalDirection.NORTH) || direction.equals(CardinalDirection.SOUTH)) {
                        newX += j;
                    } else {
                        newZ += j;
                    }

                    if(!(i == 0 && j == 0)) {
                        Block blockToBreak = world.getBlock(newX, newY, newZ);
                        if(blockToBreak != Blocks.air) {
                            blockToBreak.dropBlockAsItem(world, newX, newY, newZ, world.getBlockMetadata(newX, newY, newZ), 0);
                            world.setBlockToAir(newX, newY, newZ);
                        }
                    }
                }
            }
        }

        return super.onBlockDestroyed(stack, world, block, x, y, z, player);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean advanced) {
        super.addInformation(stack, player, list, advanced);

        list.add(EnumChatFormatting.RED + "Owie pickaxe");

    }

}
