package com.cdk.vimms.model;

import javax.persistence.*;

@Entity
@Table(name = "fuel")
public class Fuel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fuelID;

    @Column(length = 20, nullable = false)
    private String fuelType;

    public int getFuelID() {
        return fuelID;
    }

    public void setFuelID(int fuelID) {
        this.fuelID = fuelID;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Fuel() {
    }

    public Fuel(String fuelType) {
        this.fuelType = fuelType;
    }

    public Fuel(int fuelID, String fuelType) {
        this.fuelID = fuelID;
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "Fuel{" +
                "fuelID=" + fuelID +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }
}
