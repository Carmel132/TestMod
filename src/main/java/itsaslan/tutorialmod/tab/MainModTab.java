package itsaslan.tutorialmod.tab;

import itsaslan.tutorialmod.blocks.TutorialModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MainModTab extends CreativeTabs
{
    public MainModTab(String lable)
    {
        super(lable);
    }

    @Override
    public Item getTabIconItem() {
        return Item.getItemFromBlock(TutorialModBlocks.controlBlock);
    }
}
