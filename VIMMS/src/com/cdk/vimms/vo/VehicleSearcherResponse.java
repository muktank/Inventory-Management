package com.cdk.vimms.vo;

import com.cdk.vimms.model.Vehicle;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class VehicleSearcherResponse {

    private Set<Vehicle> vehicles ;
    private Map<String,Set<String>> filtersMap;

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Map<String, Set<String>> getFiltersMap() {
        return filtersMap;
    }

    public void setFiltersMap(Map<String, Set<String>> filtersMap) {
        this.filtersMap = filtersMap;
    }
}
