package com.cdk.vimms.model;


import javax.persistence.*;

@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vin;

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "modelID")
    private Model model;

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "makeID")
    private Make make;

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "trimID")
    private Trim trim;

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "fuelID")
    private Fuel fuel;

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "imageID")
    private Image image;

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "descriptionID")
    private Description description;

    @Column(nullable = false)
    private double price;

    public Vehicle() {}

    public Vehicle(Model model, Make make, Trim trim, Fuel fuel, Image image, Description description, double price) {
        this.model = model;
        this.make = make;
        this.trim = trim;
        this.fuel = fuel;
        this.image = image;
        this.description = description;
        this.price = price;
    }

    public Vehicle(int vin, Model model, Make make, Trim trim, Fuel fuel, Image image, Description description, double price) {
        this.vin = vin;
        this.model = model;
        this.make = make;
        this.trim = trim;
        this.fuel = fuel;
        this.image = image;
        this.description = description;
        this.price = price;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Make getMake() {
        return make;
    }

    public void setMake(Make make) {
        this.make = make;
    }

    public Trim getTrim() {
        return trim;
    }

    public void setTrim(Trim trim) {
        this.trim = trim;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vin=" + vin +
                ", model=" + model +
                ", make=" + make +
                ", trim=" + trim +
                ", fuel=" + fuel +
                ", image=" + image +
                ", description=" + description +
                ", price=" + price +
                '}';
    }
}
