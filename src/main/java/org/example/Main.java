package org.example;

import org.example.enums.SolarSystem;

public class Main {
    public static void main(String[] args) {
        for (SolarSystem planet : SolarSystem.values()) {

            System.out.println(planet);
        }
    }
}