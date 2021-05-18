package com.cdk.vimms.model;

import javax.persistence.*;

@Entity
@Table(name = "image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int imageID;

    @Column(length = 30, nullable = false)
    private String imageName;

    public Image() {}
    public Image(String imageName) {
        this.imageName = imageName;
    }

    public Image(int imageID, String imageName) {
        this.imageID = imageID;
        this.imageName = imageName;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public String toString() {
        return "Image{" +
                "imageID=" + imageID +
                ", imageName='" + imageName + '\'' +
                '}';
    }
}
