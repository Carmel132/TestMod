package itsaslan.tutorialmod.tileentity;

import itsaslan.tutorialmod.Main;
import itsaslan.tutorialmod.handlers.GuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;

public class TestTileEntity extends TileEntity
{

    public void openTestGui(EntityPlayer player)
    {
        player.openGui(Main.instance, GuiHandler.TEST_GUI, worldObj, xCoord, yCoord, zCoord);
    }

}
