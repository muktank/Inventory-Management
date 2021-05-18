package com.cdk.vimms.service;

import com.cdk.vimms.dao.AddVehicleDAO;
import com.cdk.vimms.dao.VehicleDAO;
import com.cdk.vimms.model.*;
import com.cdk.vimms.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Service
public class VehicleService {

    @Autowired
    VehicleDAO vehicleDAO;

    @Autowired
    AddVehicleDAO addVehicleDAO;


    @Resource
    DataPopulator dataPopulator;


    @Resource
    DataHolder searchByMakeHolder;

    @Resource
    VehicleSearcher vehicleSearcher;


    @Transactional
    public LoadVehicleResponse readAllVehicles() {
        List<Vehicle> vehicleList = vehicleDAO.getAllVehicles();
        Set<Vehicle> vehicles = new HashSet<>();
        Iterator<Vehicle> itr = vehicleList.iterator();
        while (itr.hasNext()) {
            vehicles.add(itr.next());
        }
        dataPopulator.clearCache();
        dataPopulator.prepareCache(vehicles);
        LoadVehicleResponse loadVehicleResponse = new LoadVehicleResponse();
        loadVehicleResponse.setMakes(searchByMakeHolder.getKeys());
        loadVehicleResponse.setVehicles(vehicles);
        return loadVehicleResponse;
    }

    public VehicleSearcherResponse search(String key , String value) {
        return vehicleSearcher.search(key,value);
    }

    @Transactional
    public int addVehicle(String name, String model, int year, String trimName, String fuelType, String image, double price, String exterior, String engine, String transmission, int cylinders, String horsepower, int capacity) {
        Make make = addVehicleDAO.getMake(name);
        int makeID = make.getMakeID();
        int modelID = addVehicleDAO.getModel(model,year, makeID);
        int trimID = addVehicleDAO.getTrim(trimName, modelID);
        Trim trim1 = new Trim(trimID,trimName);
        Set<Trim> trimSet = new HashSet<>();
        trimSet.add(trim1);
        Model model1 = new Model(modelID,model,year,trimSet);
        Set<Model> modelSet = new HashSet<>();
        modelSet.add(model1);
        Make make1 = new Make(make.getMakeID(),make.getMakeName(),modelSet);
        Fuel fuel = addVehicleDAO.getFuel(fuelType);
        Image image1 = new Image(image);
        Image image2 = addVehicleDAO.getImage(image1);
        Description description = new Description(exterior, engine, transmission, cylinders, horsepower, capacity);
        Description description1 = addVehicleDAO.getDescription(description);
        Vehicle vehicle = new Vehicle();
        vehicle.setMake(make1);
        vehicle.setModel(model1);
        vehicle.setTrim(trim1);
        vehicle.setFuel(fuel);
        vehicle.setImage(image2);
        vehicle.setDescription(description1);
        vehicle.setPrice(price);
        int vin = addVehicleDAO.addVehicle(vehicle);
        return vin;
    }
}
