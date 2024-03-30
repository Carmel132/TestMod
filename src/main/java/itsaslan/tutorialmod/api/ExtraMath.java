package itsaslan.tutorialmod.api;

import itsaslan.tutorialmod.enums.CardinalDirection;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;

public class ExtraMath
{

    public static float[] getPlayerDirection(EntityPlayer player)
    {

        float yawRadians = (float) Math.toRadians(player.rotationYaw);
        float pitchRadians = (float) Math.toRadians(player.rotationPitch);

        float dx = -MathHelper.sin(yawRadians) * MathHelper.cos(pitchRadians);
        float dy = -MathHelper.sin(pitchRadians);
        float dz = MathHelper.cos(yawRadians) * MathHelper.cos(pitchRadians);

        return new float[]{dx, dy, dz};
    }

    public static CardinalDirection getPlayerGeneralDirection(EntityPlayer player) {
        float yaw = (player.rotationYaw % 360 + 360) % 360; // Normalize to 0-360 degrees
        if (yaw >= 45 && yaw < 135) {
            return CardinalDirection.WEST;
        } else if (yaw >= 135 && yaw < 225) {
            return CardinalDirection.NORTH;
        } else if (yaw >= 225 && yaw < 315) {
            return CardinalDirection.EAST;
        } else {
            return CardinalDirection.SOUTH;
        }
    }

}
