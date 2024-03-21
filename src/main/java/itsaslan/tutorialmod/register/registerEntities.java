package itsaslan.tutorialmod.register;

import cpw.mods.fml.common.registry.EntityRegistry;
import itsaslan.tutorialmod.Main;
import itsaslan.tutorialmod.entity.GrenadeEntity;

public class registerEntities
{
    public static void init()
    {
        int uniqueEntityId = EntityRegistry.findGlobalUniqueEntityId();
        EntityRegistry.registerGlobalEntityID(GrenadeEntity.class, "CustomThrowable", uniqueEntityId);
        EntityRegistry.registerModEntity(GrenadeEntity.class, "CustomThrowable", uniqueEntityId, Main.instance, 64, 10, true);
    }
}
