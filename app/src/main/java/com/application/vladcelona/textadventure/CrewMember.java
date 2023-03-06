package com.application.vladcelona.textadventure;

public class CrewMember {

    private int oxygenLevel;
    private int energyLevel;

    CrewMember() {
        oxygenLevel = 100; energyLevel = 100;
    }

    public void reduceOxygen() { oxygenLevel -= 5; }
    public void reduceEnergy() { energyLevel -= 5; }
    public void reduceEnergyShooting() { energyLevel -= 10; }

    public boolean checkStats() { return oxygenLevel > 0 && energyLevel > 0; }
    public int getEnergyLevel() { return energyLevel; }
    public int getOxygenLevel() {return oxygenLevel; }
}
