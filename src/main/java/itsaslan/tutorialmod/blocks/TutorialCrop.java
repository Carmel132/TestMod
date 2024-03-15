package itsaslan.tutorialmod.blocks;

import itsaslan.tutorialmod.items.TutorialModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import java.util.Random;

public class TutorialCrop extends BlockCrops {

    @Override
    protected Item func_149866_i()
    {
        return TutorialModItems.waxSeed;
    }

    @Override
    protected Item func_149865_P()
    {
        return TutorialModItems.wax;
    }

}