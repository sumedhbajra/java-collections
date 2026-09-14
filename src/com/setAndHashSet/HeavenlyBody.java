package com.setAndHashSet;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class HeavenlyBody {
    private final Key key;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;


    public enum BodyType {STAR, PLANET, DWARF_PLANET, MOON, COMET, ASTEROID}

    public HeavenlyBody(String name, double orbitalPeriod, BodyType bodyType) {
        this.key = new Key(name, bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }


    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addSatellite(HeavenlyBody moon) {
       if(moon.key.getBodyType() == BodyType.MOON) {
           return this.satellites.add(moon);
       } else {
           return false;
       }
    }

    public Key getKey() {
        return key;
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    @Override
    public boolean equals(Object obj) { // DNU: 0
        if(this == obj) { // DNU: 1
            return true;
        }

        if(obj instanceof HeavenlyBody) {
            HeavenlyBody theObject = (HeavenlyBody) obj; // DNU: 2
            return this.key.equals(theObject.getKey());
        }
            return false;
    }

    @Override
    public final int hashCode() { // DNU: 4
        System.out.println("Hash Code is called.");
        return this.key.hashCode(); // WHY?
    }

    public static Key makeKey(String name, BodyType bodyType) {
        return new Key(name, bodyType);
    }

    @Override
    public String toString() {
        return "HeavenlyBody{" +
                "name='" + this.key.name + '\'' +
                ", bodyType=" + this.key.bodyType +
                ", orbitalPeriod=" + orbitalPeriod +
                ", satellites=" + satellites +
                '}';
    }

    public static final class Key {
        private String name;
        private BodyType bodyType;

        private Key(String name, BodyType bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyType getBodyType() {
            return bodyType;
        }

        @Override
        public boolean equals(Object o) {
           Key key = ((Key) o);
           if(this.name.equals(key.getName())) {
               return (this.bodyType == key.getBodyType());
           }
           return false;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + 57 + this.bodyType.hashCode();
        }

        @Override
        public String toString() {
            return "Key{" +
                    "name='" + name + '\'' +
                    ", bodyType=" + bodyType +
                    '}';
        }
    }
}
