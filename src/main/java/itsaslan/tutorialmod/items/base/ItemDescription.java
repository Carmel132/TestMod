package itsaslan.tutorialmod.items.base;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

public class ItemDescription extends Item
{

    EnumChatFormatting color = EnumChatFormatting.WHITE;
    String[] descriptions = new String[0];

    public ItemDescription(EnumChatFormatting color, String[] descriptions) {;

        this.color = color;
        this.descriptions = descriptions;

    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean advanced) {
        super.addInformation(stack, player, list, advanced);

        for (String description : descriptions) {
            list.add(color + description);
        }

    }
}
