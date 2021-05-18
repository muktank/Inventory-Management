package com.cdk.vimms.vo;

import com.cdk.vimms.model.Vehicle;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SearchByMakeModelYearHolder extends AbstractSearchHolder{
    @Override
    public void populate(Vehicle vehicle) {
        String key = vehicle.getMake().getMakeName() + vehicle.getModel().getModelName() + vehicle.getModel().getYear();
        if (getVehiclesMap().containsKey(key)) {
            Set<Vehicle> vehicles = getVehiclesMap().get(key);
            vehicles.add(vehicle);
            getVehiclesMap().put(key, vehicles);
        }

        else
        {
            Set<Vehicle> makes = new HashSet<>();
            makes.add(vehicle);
            getVehiclesMap().put(key, makes);
        }

        populateFiltersMap(key,vehicle);
    }


}
