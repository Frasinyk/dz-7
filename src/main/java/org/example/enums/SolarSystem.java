package org.example.enums;

public enum SolarSystem {
    MERCURY(0, 200),
    VENUS(100, 300),
    EARTH(200, 600),
    MARS(250, 400),
    JUPITER(250, 1200),
    SATURN(500, 1000),
    URANUS(250, 350),
    NEPTUNE(700, 120);


    private int prevDistance;
    private int radius;
    private int distanceToSun = 1230;
    private int disToSun;
    private int order;


    SolarSystem(int prevDistance, int radius) {
        this.prevDistance = prevDistance;
        this.radius = radius;
        this.order = ordinal() + 1;

    }

    public int getDistanceToSun() {
        this.disToSun = prevDistance + (getPrevious() != null ? getPrevious().disToSun : distanceToSun);
        return this.disToSun;
    }

    public SolarSystem getNext() {
        if (ordinal() == values().length - 1) {
            return null;
        }
        return values()[(ordinal() + 1) % values().length];
    }

    public SolarSystem getPrevious() {
        if (ordinal() == 0) {
            return null;
        }
        return values()[(ordinal() - 1) % values().length];
    }

    @Override
    public String toString() {
        String prevName = (getPrevious() != null) ? getPrevious().name() : "None";
        String nextName = (getNext() != null) ? getNext().name() : "None";
        return String.format("Planet #%d %s: Distance from previous planet = %d, Distance from Sun = %d, Radius = %d, Previous planet = %s, Next planet = %s",
                order, name(), prevDistance, getDistanceToSun(), radius, prevName, nextName);
    }
}
