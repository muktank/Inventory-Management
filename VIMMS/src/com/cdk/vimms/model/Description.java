package com.cdk.vimms.model;

import javax.persistence.*;

@Entity
@Table(name = "description")
public class Description {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int descriptionID;

    @Column(length = 30, nullable = false)
    private String exterior;

    @Column(length = 30, nullable = false)
    private String engine;

    @Column(length = 30, nullable = false)
    private String transmission;

    @Column(nullable = false)
    private int cylinders;

    @Column(length = 30, nullable = false)
    private String horsepower;

    @Column(nullable = false)
    private int passengerCapacity;

    public  Description() {}

    public Description(String exterior, String engine, String transmission, int cylinders, String horsepower, int passengerCapacity) {
        this.exterior = exterior;
        this.engine = engine;
        this.transmission = transmission;
        this.cylinders = cylinders;
        this.horsepower = horsepower;
        this.passengerCapacity = passengerCapacity;
    }
    public Description(int descriptionID, String exterior, String engine, String transmission, int cylinders, String horsepower, int passengerCapacity) {
        this.descriptionID = descriptionID;
        this.exterior = exterior;
        this.engine = engine;
        this.transmission = transmission;
        this.cylinders = cylinders;
        this.horsepower = horsepower;
        this.passengerCapacity = passengerCapacity;
    }

    public int getDescriptionID() {
        return descriptionID;
    }

    public void setDescriptionID(int descriptionID) {
        this.descriptionID = descriptionID;
    }

    public String getExterior() {
        return exterior;
    }

    public void setExterior(String exterior) {
        this.exterior = exterior;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public int getCylinders() {
        return cylinders;
    }

    public void setCylinders(int cylinders) {
        this.cylinders = cylinders;
    }

    public String getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(String horsepower) {
        this.horsepower = horsepower;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public String toString() {
        return "Description{" +
                "descriptionID=" + descriptionID +
                ", exterior='" + exterior + '\'' +
                ", engine='" + engine + '\'' +
                ", transmission='" + transmission + '\'' +
                ", cylinders=" + cylinders +
                ", horsepower='" + horsepower + '\'' +
                ", passengerCapacity=" + passengerCapacity +
                '}';
    }
}
