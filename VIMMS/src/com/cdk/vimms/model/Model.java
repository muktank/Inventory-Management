package com.cdk.vimms.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "model")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int modelID;

    @Column(length = 20, nullable = false)
    private String modelName;

    private int year;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "modelID")
    private Set<Trim> trim;

    public int getModelID() {
        return modelID;
    }

    public void setModelID(int modelID) {
        this.modelID = modelID;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Set<Trim> getTrim() {
        return trim;
    }

    public void setTrim(Set<Trim> trim) {
        this.trim = trim;
    }

    public Model() {
    }

    public Model(int modelID, String modelName, int year, Set<Trim> trim) {
        this.modelID = modelID;
        this.modelName = modelName;
        this.year = year;
        this.trim = trim;
    }

    public Model(String modelName, int year, Set<Trim> trim) {
        this.modelName = modelName;
        this.year = year;
        this.trim = trim;
    }

    @Override
    public String toString() {
        return "Model{" +
                "modelID=" + modelID +
                ", modelName='" + modelName + '\'' +
                ", year=" + year +
                ", trim=" + trim +
                '}';
    }
}
