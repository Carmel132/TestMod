package itsaslan.tutorialmod.blocks;

import itsaslan.tutorialmod.items.TutorialModItems;
import itsaslan.tutorialmod.lib.ModVars;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class InteractableBlocks extends Block {

    boolean isHoldingNugget;

    protected InteractableBlocks(Material material, String name, float Hardness, float LightLevel, int HarvestLevel, float Resistance, SoundType Sound)
    {
        super(material);
        this.setBlockName(name);
        this.setBlockTextureName(ModVars.MOD_ID + ":" + this.getUnlocalizedName());
        this.setCreativeTab(CreativeTabs.tabBlock);

        this.setHardness(Hardness); // Stone: 1.5f && Obsidian: 50.0f
        this.setLightLevel(LightLevel); // Glowstone: 1.0f && Stone: 0.0f
        this.setHarvestLevel("pickaxe", HarvestLevel); // 0 = wood, 1 = stone, 2 = iron, 3 = diamond
        this.setResistance(Resistance); // Stone: 10.0f && Obsidian: 2000.0f
        this.setStepSound(Sound);
    }

    @Override
    public void onBlockClicked(World world, int posX, int posY, int posZ, EntityPlayer player)
    {
        if(player.getCurrentEquippedItem() != null)
        {
            if(player.getCurrentEquippedItem().getItem().getUnlocalizedName().equals(TutorialModItems.stellarNugget.getUnlocalizedName()))
            {
                ItemStack replacedItem = new ItemStack(TutorialModItems.wax, player.getCurrentEquippedItem().stackSize);
                System.out.println("Nugget In Hand");
                player.setCurrentItemOrArmor(0, replacedItem);
            }
            else if(!player.getCurrentEquippedItem().getItem().getUnlocalizedName().equals(TutorialModItems.stellarNugget.getUnlocalizedName()))
            {
                System.out.println("Nugget Not in Hand");
            }
        }
    }

}
