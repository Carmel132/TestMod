package itsaslan.tutorialmod.register;

import itsaslan.tutorialmod.blocks.TutorialModBlocks;
import itsaslan.tutorialmod.render.item.BombItemRenderer;
import itsaslan.tutorialmod.render.item.PotItemRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class registerItemRenderers
{
    public static void init()
    {
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(TutorialModBlocks.bombTest), new BombItemRenderer());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(TutorialModBlocks.blockPot), new PotItemRenderer());
    }
}
