package itsaslan.tutorialmod.interfaces;

public interface IWaterBoiler
{
    void onHeatupStart();
    void onBoil();
    void setElapsedBoilTimeTick(int time);
    void setTickTimeToBoil(int time);
    void startBoil(boolean start);
    boolean isBoiling();
    int getElapsedBoilTimeTick();
    int getTickTimeToBoil();
}
