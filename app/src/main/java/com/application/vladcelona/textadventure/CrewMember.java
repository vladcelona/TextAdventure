package com.application.vladcelona.textadventure;

public class CrewMember {

    private int oxygenLevel;
    private int energyLevel;

    CrewMember() {
        this.oxygenLevel = 100; this.energyLevel = 100;
    }

    public void reduceOxygen() { this.oxygenLevel -= 5; }
    public void reduceEnergy() { this.energyLevel -= 5; }
    public void reduceEnergyWhileShooting() { this.energyLevel -= 10; }

    public boolean checkStats() { return oxygenLevel > 0 && energyLevel > 0; }
}
