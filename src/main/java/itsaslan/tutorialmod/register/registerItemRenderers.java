package itsaslan.tutorialmod.register;

import cpw.mods.fml.client.registry.RenderingRegistry;
import itsaslan.tutorialmod.blocks.TutorialModBlocks;
import itsaslan.tutorialmod.entity.GrenadeEntity;
import itsaslan.tutorialmod.items.TutorialModItems;
import itsaslan.tutorialmod.render.item.BombItemRenderer;
import itsaslan.tutorialmod.render.item.BombTableRenderer;
import itsaslan.tutorialmod.render.item.GrenadeRenderer;
import itsaslan.tutorialmod.render.item.PotItemRenderer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class registerItemRenderers
{
    public static void init()
    {
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(TutorialModBlocks.bombTest), new BombItemRenderer());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(TutorialModBlocks.blockPot), new PotItemRenderer());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(TutorialModBlocks.bombTable), new BombTableRenderer());

        RenderingRegistry.registerEntityRenderingHandler(GrenadeEntity.class, new GrenadeRenderer(TutorialModItems.grenade, 1));

    }
}
