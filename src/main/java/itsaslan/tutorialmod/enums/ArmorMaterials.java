package itsaslan.tutorialmod.enums;

import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class ArmorMaterials
{

    public static final ItemArmor.ArmorMaterial STELLARARMOR = EnumHelper.addArmorMaterial("STELLARARMOR", 99, new int[]{15, 40, 30, 15}, 10);
    public static final ItemArmor.ArmorMaterial INFUSEDARMOR = EnumHelper.addArmorMaterial("INFUSEDARMOR", 180, new int[]{30, 80, 60, 30}, 50);

}
