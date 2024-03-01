package itsaslan.tutorialmod.items.base;

import itsaslan.tutorialmod.lib.ModVars;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ArmorBase extends ItemArmor
{

    String rootName;

    public ArmorBase(ArmorMaterial material, int renderIndex, int armorType, String rootName) {
        super(material, renderIndex, armorType);
        this.rootName = rootName;
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        return this.armorType == 2 ? ModVars.MOD_ID + ":models/armor/" + rootName + "_layer_2.png" : ModVars.MOD_ID + ":models/armor/" + rootName + "_layer_1.png";
    }

}
