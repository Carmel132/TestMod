package itsaslan.tutorialmod.blocks;

import itsaslan.tutorialmod.lib.ModVars;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import java.util.Random;

public class OreBlockBase extends Block
{

    private int minDropAmount = 1;
    private int maxDropAmount = 1;

    private Item itemToDrop;

    public OreBlockBase(Material mat, String name, CreativeTabs tab, Item itemToDrop) {
        super(mat);

        this.setHardness(3f);
        this.setStepSound(soundTypeStone);

        this.setBlockName(name);
        this.setCreativeTab(tab);
        this.setBlockTextureName(ModVars.MOD_ID + ":" + this.getUnlocalizedName());

        this.itemToDrop = itemToDrop;
    }

    public OreBlockBase(Material mat, String name, CreativeTabs tab, Item itemToDrop, int minDropAmount, int maxDropAmount) {
        super(mat);

        this.setHardness(3f);
        this.setStepSound(soundTypeStone);

        this.setBlockName(name);
        this.setCreativeTab(tab);
        this.setBlockTextureName(ModVars.MOD_ID + ":" + this.getUnlocalizedName());

        this.itemToDrop = itemToDrop;
        this.minDropAmount = minDropAmount;
        this.maxDropAmount = maxDropAmount;
    }


    @Override
    public Item getItemDropped(int meta, Random random, int fortune) {
        return itemToDrop;
    }

    @Override
    public int quantityDropped(Random random) {
        return random.nextInt(maxDropAmount - minDropAmount + 1) + minDropAmount;
    }

}
