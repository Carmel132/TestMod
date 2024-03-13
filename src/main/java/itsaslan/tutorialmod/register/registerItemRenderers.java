package itsaslan.tutorialmod.register;

import itsaslan.tutorialmod.blocks.TutorialModBlocks;
import itsaslan.tutorialmod.render.item.BombItemRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class registerItemRenderers
{
    public static void init()
    {
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(TutorialModBlocks.bombTest), new BombItemRenderer());
    }
}
