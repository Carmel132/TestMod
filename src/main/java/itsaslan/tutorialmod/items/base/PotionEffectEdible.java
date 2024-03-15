package itsaslan.tutorialmod.items.base;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class PotionEffectEdible extends ItemFood
{

    Potion[] potionEffects;
    int[] potionDurations;
    int[] potionAmplifiers;


    public PotionEffectEdible(int foodPoint, float saturation, boolean wolfMeat, Potion[] effects, int[] durations, int[] amplifiers) {
        super(foodPoint, saturation, wolfMeat);

        this.potionEffects = effects;
        this.potionDurations = durations;
        this.potionAmplifiers = amplifiers;

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
}
