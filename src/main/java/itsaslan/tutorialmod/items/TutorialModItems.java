package itsaslan.tutorialmod.items;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.registry.GameRegistry;
import itsaslan.tutorialmod.blocks.TutorialCrop;
import itsaslan.tutorialmod.blocks.TutorialModBlocks;
import itsaslan.tutorialmod.enums.ArmorMaterials;
import itsaslan.tutorialmod.enums.ToolMaterials;
import itsaslan.tutorialmod.items.base.*;
import itsaslan.tutorialmod.lib.ModVars;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class TutorialModItems {

    public static Item stellarIngot;
    public static Item stellarGem;
    public static Item stellarNugget;

    public static ItemSword stellarSword;
    public static ItemPickaxe stellarPickaxe;
    public static ItemAxe stellarAxe;
    public static ItemHoe stellarHoe;
    public static ItemSpade stellarShovel;

    public static ItemArmor stellarHelmet;
    public static ItemArmor stellarChestplate;
    public static ItemArmor stellarLeggings;
    public static ItemArmor stellarBoots;

    public static Item waxSeed;
    public static Item wax;

    public static Item sandPaper;

    public static void init()
    {

        //Armor

        stellarHelmet = new ArmorBase(ArmorMaterials.STELLARARMOR, 0, 0, "stellar");
        stellarHelmet.setUnlocalizedName("stellarHelmet").setCreativeTab(CreativeTabs.tabCombat).setTextureName("tutorialmod:stellarHelmet");;
        GameRegistry.registerItem(stellarHelmet, "stellarHelmet");

        stellarChestplate = new ArmorBase(ArmorMaterials.STELLARARMOR, 0, 1, "stellar");
        stellarChestplate.setUnlocalizedName("stellarChestplate").setCreativeTab(CreativeTabs.tabCombat).setTextureName("tutorialmod:stellarChestplate");
        GameRegistry.registerItem(stellarChestplate, "stellarChestplate");

        stellarLeggings = new ArmorBase(ArmorMaterials.STELLARARMOR, 0, 2, "stellar");
        stellarLeggings.setUnlocalizedName("stellarLeggings").setCreativeTab(CreativeTabs.tabCombat).setTextureName("tutorialmod:stellarLeggings");;
        GameRegistry.registerItem(stellarLeggings, "stellarLeggings");

        stellarBoots = new ArmorBase(ArmorMaterials.STELLARARMOR, 0, 3, "stellar");
        stellarBoots.setUnlocalizedName("stellarBoots").setCreativeTab(CreativeTabs.tabCombat).setTextureName("tutorialmod:stellarBoots");;
        GameRegistry.registerItem(stellarBoots, "stellarBoots");

        // Items

        stellarIngot = new Item().setUnlocalizedName("stellarIngot").setCreativeTab(CreativeTabs.tabMaterials);
        stellarIngot.setTextureName(ModVars.MOD_ID + ":" + stellarIngot.getUnlocalizedName());
        GameRegistry.registerItem(stellarIngot, stellarIngot.getUnlocalizedName());

        stellarGem = new Item().setUnlocalizedName("stellarGem").setCreativeTab(CreativeTabs.tabMaterials);
        stellarGem.setTextureName((ModVars.MOD_ID + ":" + stellarGem.getUnlocalizedName()));
        GameRegistry.registerItem(stellarGem, stellarGem.getUnlocalizedName());

        sandPaper = new Item().setUnlocalizedName("sandpaper").setCreativeTab(CreativeTabs.tabMisc);
        sandPaper.setTextureName(ModVars.MOD_ID + ":" + sandPaper.getUnlocalizedName());
        GameRegistry.registerItem(sandPaper, sandPaper.getUnlocalizedName());

        stellarNugget = new Item().setUnlocalizedName("stellarNugget").setCreativeTab(CreativeTabs.tabMaterials);
        stellarNugget.setTextureName(ModVars.MOD_ID + ":" + stellarNugget.getUnlocalizedName());
        GameRegistry.registerItem(stellarNugget, stellarNugget.getUnlocalizedName());

        // Tools

        stellarSword = (ItemSword) new ItemSword(ToolMaterials.FUNNYMAT).setUnlocalizedName("stellarSword").setCreativeTab(CreativeTabs.tabCombat);
        stellarSword.setTextureName(ModVars.MOD_ID + ":" + stellarSword.getUnlocalizedName());
        GameRegistry.registerItem(stellarSword, "stellarSword");

        stellarPickaxe = (ItemPickaxe) new PickaxeBase(ToolMaterials.STELLARMATERIAL).setUnlocalizedName("stellarPickaxe").setCreativeTab(CreativeTabs.tabTools);
        stellarPickaxe.setTextureName(ModVars.MOD_ID + ":" + stellarPickaxe.getUnlocalizedName());
        GameRegistry.registerItem(stellarPickaxe, "stellarPickaxe");

        stellarAxe = (ItemAxe) new AxeBase(ToolMaterials.STELLARMATERIAL).setUnlocalizedName("stellarAxe").setCreativeTab(CreativeTabs.tabTools);
        stellarAxe.setTextureName(ModVars.MOD_ID + ":" + stellarAxe.getUnlocalizedName());
        GameRegistry.registerItem(stellarAxe, "stellarAxe");

        stellarHoe = (ItemHoe) new HoeBase(ToolMaterials.STELLARMATERIAL).setUnlocalizedName("stellarHoe").setCreativeTab(CreativeTabs.tabTools);
        stellarHoe.setTextureName(ModVars.MOD_ID + ":" + stellarHoe.getUnlocalizedName());
        GameRegistry.registerItem(stellarHoe, "stellarHoe");

        stellarShovel = (ItemSpade) new ShovelBase(ToolMaterials.STELLARMATERIAL).setUnlocalizedName("stellarShovel").setCreativeTab(CreativeTabs.tabTools);
        stellarShovel.setTextureName(ModVars.MOD_ID + ":" + stellarShovel.getUnlocalizedName());
        GameRegistry.registerItem(stellarShovel, "stellarShovel");

        // Crops

        waxSeed = new ItemSeeds(TutorialModBlocks.waxCrop, Blocks.farmland).setCreativeTab(CreativeTabs.tabMisc).setUnlocalizedName("waxSeed");
        waxSeed.setTextureName(ModVars.MOD_ID + ":" + waxSeed.getUnlocalizedName());
        GameRegistry.registerItem(waxSeed, "waxSeed");

        wax = new ItemFood(6, 0.5f, false).setCreativeTab(CreativeTabs.tabMisc).setUnlocalizedName("wax");
        wax.setTextureName(ModVars.MOD_ID + ":" + wax.getUnlocalizedName());
        GameRegistry.registerItem(wax, "wax");

    }

}