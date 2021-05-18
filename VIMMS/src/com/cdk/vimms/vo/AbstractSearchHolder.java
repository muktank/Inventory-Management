package com.cdk.vimms.vo;

import com.cdk.vimms.model.Vehicle;
import org.springframework.stereotype.Component;

import java.util.*;


public abstract class AbstractSearchHolder implements DataHolder {



    private Map<String,Set<Vehicle>> vehiclesMap = new HashMap<>();
    private Map<String,Map<String,Set<String>>> filtersMap = new HashMap<>();


    public Map<String, Set<Vehicle>> getVehiclesMap() {
        return vehiclesMap;
    }

    public void setVehiclesMap(Map<String, Set<Vehicle>> vehiclesMap) {
        this.vehiclesMap = vehiclesMap;
    }

    public Map<String, Map<String, Set<String>>> getFiltersMap() {
        return filtersMap;
    }

    public void setFiltersMap(Map<String, Map<String, Set<String>>> filtersMap) {
        this.filtersMap = filtersMap;
    }

    @Override
    public VehicleSearcherResponse search(String key) {
        VehicleSearcherResponse searcherResponse = new VehicleSearcherResponse();
        searcherResponse.setVehicles(vehiclesMap.get(key));
        searcherResponse.setFiltersMap(filtersMap.get(key));
        return searcherResponse;
    }


    protected void populateFiltersMap(String key, Vehicle vehicle) {
        Map<String, Set<String>> filters = filtersMap.get(key);
        if(filters == null){
            filters = new HashMap<>();
        }
        if(!filters.containsKey("models")){
            filters.put("models",new LinkedHashSet<>());
        }
        if(!filters.containsKey("years")){
            filters.put("years",new LinkedHashSet<>());
        }
        if(!filters.containsKey("trims")){
            filters.put("trims",new LinkedHashSet<>());
        }
        if(!filters.containsKey("fuelTypes")){
            filters.put("fuelTypes",new LinkedHashSet<>());
        }
        filters.get("models").add(vehicle.getModel().getModelName());
        filters.get("years").add(String.valueOf(vehicle.getModel().getYear()));
        filters.get("trims").add(vehicle.getTrim().getTrimName());
        filters.get("fuelTypes").add(vehicle.getFuel().getFuelType());
        filtersMap.put(key,filters);
    }

    @Override
    public List<String> getKeys() {
        return new ArrayList(vehiclesMap.keySet());
    }

    @Override
    public void clear() {
        vehiclesMap.clear();
        filtersMap.clear();
    }
}

