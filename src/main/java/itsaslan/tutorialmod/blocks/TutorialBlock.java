package itsaslan.tutorialmod.blocks;
import itsaslan.tutorialmod.Main;
import itsaslan.tutorialmod.lib.ModVars;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class TutorialBlock extends Block
{

    protected TutorialBlock(Material material, String name, float Hardness, float LightLevel, int HarvestLevel, float Resistance, SoundType Sound)
    {
        super(material);
        this.setBlockName(name);
        this.setBlockTextureName(ModVars.MOD_ID + ":" + this.getUnlocalizedName());
        this.setCreativeTab(Main.mainModTab);

        this.setHardness(Hardness); // Stone: 1.5f && Obsidian: 50.0f
        this.setLightLevel(LightLevel); // Glowstone: 1.0f && Stone: 0.0f
        this.setHarvestLevel("pickaxe", HarvestLevel); // 0 = wood, 1 = stone, 2 = iron, 3 = diamond
        this.setResistance(Resistance); // Stone: 10.0f && Obsidian: 2000.0f
        this.setStepSound(Sound);
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

}
