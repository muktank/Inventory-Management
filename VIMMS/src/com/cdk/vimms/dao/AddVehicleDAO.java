package com.cdk.vimms.dao;

import com.cdk.vimms.model.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AddVehicleDAO {
    @PersistenceContext
    EntityManager entityManager;

    public Make getMake(String makeName) {
        Make make = (Make)(entityManager.createQuery("FROM Make M WHERE M.makeName ='" +makeName+"'").getSingleResult());
        return make;
    }

    public int getModel(String modelName, int year, int makeID) {
        int id = (int)entityManager.createQuery("select M.modelID FROM Make B join B.model M WHERE M.modelName ='" + modelName + "' AND B.makeID='" + makeID + "' AND M.year='" + year +"'").getSingleResult();
        return id;

    }

    public int getTrim(String trimName, int modelID) {
        int trim = (int)(entityManager.createQuery("select T.trimID FROM Model M join M.trim T WHERE T.trimName ='" + trimName + "' AND M.modelID='" + modelID +"'").getSingleResult());
        return trim;

    }

    public Fuel getFuel(String fuelType) {
        Fuel fuel = (Fuel)(entityManager.createQuery("FROM Fuel F WHERE F.fuelType ='" +fuelType+"'").getSingleResult());
        return fuel;
    }

    @Transactional
    public Image getImage(Image image) {
        entityManager.persist(image);
       return image;
    }

    @Transactional
    public Description getDescription(Description description) {
        entityManager.persist(description);
       return description;
    }

    @Transactional
    public int addVehicle(Vehicle vehicle) {
        entityManager.merge(vehicle);
        return vehicle.getVin();
    }
}
