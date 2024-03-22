package itsaslan.tutorialmod.interfaces;

import itsaslan.tutorialmod.enums.EnergyMoveStatus;

public interface IEnergyStorage
{
    float getMaxEnergyStorage();
    void setStatus();
    EnergyMoveStatus getStatus();
}
