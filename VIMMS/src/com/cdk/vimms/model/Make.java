package com.cdk.vimms.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "make")
public class Make {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int makeID;

    @Column(length = 20, nullable = false)
    private String makeName;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "makeID")
    private Set<Model> model;

    public int getMakeID() {
        return makeID;
    }

    public void setMakeID(int makeID) {
        this.makeID = makeID;
    }

    public String getMakeName() {
        return makeName;
    }

    public void setMakeName(String makeName) {
        this.makeName = makeName;
    }

    public Set<Model> getModel() {
        return model;
    }

    public void setModel(Set<Model> model) {
        this.model = model;
    }

    public Make() {
            }

    public Make(String makeName, Set<Model> model) {
        this.makeName = makeName;
        this.model = model;
    }

    public Make(int makeID, String makeName, Set<Model> model) {
        this.makeID = makeID;
        this.makeName = makeName;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Make{" +
                "makeID=" + makeID +
                ", makeName='" + makeName + '\'' +
                ", model=" + model +
                '}';
    }
}
