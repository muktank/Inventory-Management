package com.cdk.vimms.service;

import com.cdk.vimms.vo.DataHolder;
import com.cdk.vimms.model.Vehicle;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.*;

@Component
public class DataPopulator {

    @Resource
    DataHolder searchByMakeHolder;

    @Resource
    DataHolder searchByMakeModelHolder;

    @Resource
    DataHolder searchByMakeModelYearHolder;

    @Resource
    DataHolder searchByMakeModelYearTrimHolder;

    @Resource
    DataHolder searchByMakeModelYearTrimFuelHolder;


    private List<DataHolder> dataHolders;


    @PostConstruct
    public  void initialize(){

        dataHolders = new ArrayList<>();
        dataHolders.add(searchByMakeHolder);
        dataHolders.add(searchByMakeModelHolder);
        dataHolders.add(searchByMakeModelYearHolder);
        dataHolders.add(searchByMakeModelYearTrimHolder);
        dataHolders.add(searchByMakeModelYearTrimFuelHolder);
    }


    public void prepareCache(Set<Vehicle> vehicles){

        for(Vehicle vehicle : vehicles){

            for(DataHolder dataHolder : dataHolders){
                dataHolder.populate(vehicle);
            }
        }

    }

    public void clearCache() {

            for(DataHolder dataHolder : dataHolders){
                dataHolder.clear();
            }


    }
}
