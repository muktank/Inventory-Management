package com.cdk.vimms.model;

import javax.persistence.*;

@Entity
@Table(name = "trim")
public class Trim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trimID;

    @Column(length = 20, nullable = false)
    private String trimName;

    public int getTrimID() {
        return trimID;
    }

    public void setTrimID(int trimID) {
        this.trimID = trimID;
    }

    public String getTrimName() {
        return trimName;
    }

    public void setTrimName(String trimName) {
        this.trimName = trimName;
    }

    public Trim() {
    }

    public Trim(String trimName) {
        this.trimName = trimName;
    }

    public Trim(int trimID, String trimName) {
        this.trimID = trimID;
        this.trimName = trimName;
    }

    @Override
    public String toString() {
        return "Trim{" +
                "trimID=" + trimID +
                ", trimName='" + trimName + '\'' +
                '}';
    }
}
