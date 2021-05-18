package com.cdk.vimms.vo;

import com.cdk.vimms.model.Vehicle;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SearchByMakeHolder extends AbstractSearchHolder {


    @Override
    public void populate(Vehicle vehicle) {

        if (getVehiclesMap().containsKey(vehicle.getMake().getMakeName())) {
            Set<Vehicle> vehicles = getVehiclesMap().get(vehicle.getMake().getMakeName());
            vehicles.add(vehicle);
            getVehiclesMap().put(vehicle.getMake().getMakeName(), vehicles);
        }
        else
        {
            Set<Vehicle> makes = new HashSet<>();
            makes.add(vehicle);
            getVehiclesMap().put(vehicle.getMake().getMakeName(), makes);
        }

        populateFiltersMap(vehicle.getMake().getMakeName(),vehicle);

    }

}

