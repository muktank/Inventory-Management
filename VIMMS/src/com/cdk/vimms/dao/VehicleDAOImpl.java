package com.cdk.vimms.dao;

import com.cdk.vimms.model.Vehicle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Repository
public class VehicleDAOImpl implements VehicleDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicleList = (entityManager.createQuery("from Vehicle")).getResultList();
        return vehicleList;
    }
}
