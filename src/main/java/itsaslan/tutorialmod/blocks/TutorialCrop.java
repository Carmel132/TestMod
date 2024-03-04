package itsaslan.tutorialmod.blocks;

import itsaslan.tutorialmod.items.TutorialModItems;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;

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