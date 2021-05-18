package com.cdk.vimms.vo;

import com.cdk.vimms.model.Vehicle;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;

@Component
public class LoadVehicleResponse {

    private Set<Vehicle> vehicles;
    private Collection<String> makes;



    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Collection<String> getMakes() {
        return makes;
    }

    public void setMakes(Collection<String> makes) {
        this.makes = makes;
    }
}
