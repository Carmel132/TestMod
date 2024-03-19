package itsaslan.tutorialmod.items.base;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

public class PotionEffectEdible extends ItemFood
{

    Potion[] potionEffects;
    int[] potionDurations;
    int[] potionAmplifiers;

    EnumChatFormatting color = EnumChatFormatting.WHITE;
    String[] descriptions = new String[0];

    public PotionEffectEdible(int foodPoint, float saturation, boolean wolfMeat, Potion[] effects, int[] durations, int[] amplifiers) {
        super(foodPoint, saturation, wolfMeat);

        this.potionEffects = effects;
        this.potionDurations = durations;
        this.potionAmplifiers = amplifiers;

    }

    public PotionEffectEdible(int foodPoint, float saturation, boolean wolfMeat, Potion[] effects, int[] durations, int[] amplifiers, EnumChatFormatting color, String[] descriptions) {
        super(foodPoint, saturation, wolfMeat);

        this.potionEffects = effects;
        this.potionDurations = durations;
        this.potionAmplifiers = amplifiers;

        this.color = color;
        this.descriptions = descriptions;

    }

    @Override
    protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
        super.onFoodEaten(stack, world, player);
        if (!world.isRemote)
        {
            for(int effect = 0; effect < potionEffects.length; ++effect)
            {
                player.addPotionEffect(new PotionEffect(potionEffects[effect].id, potionDurations[effect], potionAmplifiers[effect]));
            }
        }
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean advanced) {
        super.addInformation(stack, player, list, advanced);
        // Your item's description

        for (String description : descriptions) {
            list.add(color + description);
        }

    }
}
