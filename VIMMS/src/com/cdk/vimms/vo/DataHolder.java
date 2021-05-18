package com.cdk.vimms.vo;

import com.cdk.vimms.model.Vehicle;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public interface DataHolder {

    VehicleSearcherResponse search(String key);

    void populate(Vehicle vehicle);

    List<String> getKeys();

    void clear();

}
