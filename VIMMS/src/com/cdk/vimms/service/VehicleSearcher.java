package com.cdk.vimms.service;

import com.cdk.vimms.model.Vehicle;
import com.cdk.vimms.vo.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Component
public class VehicleSearcher {

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


    private Map<String, DataHolder> searchMap = new HashMap<>();

    @PostConstruct
    public void init() {

        searchMap.put("make",searchByMakeHolder);
        searchMap.put("makemodel",searchByMakeModelHolder);
        searchMap.put("makemodelyear",searchByMakeModelYearHolder);
        searchMap.put("makemodelyeartrim",searchByMakeModelYearTrimHolder);
        searchMap.put("makemodelyeartrimfuel",searchByMakeModelYearTrimFuelHolder);
    }

    public VehicleSearcherResponse search (String key, String value){
        DataHolder dataHolder = searchMap.get(key);
        return dataHolder.search(value);

    }
}
