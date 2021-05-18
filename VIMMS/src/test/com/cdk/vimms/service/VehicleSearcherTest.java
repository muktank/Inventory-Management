package com.cdk.vimms.service;

import com.cdk.vimms.vo.DataHolder;
import com.cdk.vimms.vo.SearchByMakeHolder;
import com.cdk.vimms.vo.VehicleSearcherResponse;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

public class VehicleSearcherTest {

    @InjectMocks
    private VehicleSearcher vehicleSearcher;

    @Mock
    DataHolder searchByMakeHolder;

    @Mock
    private Map<String, DataHolder> searchMap;


    @Test
    public void testSearch() {

        searchMap = new HashMap<>();
        searchMap.put("make", searchByMakeHolder);
        Assert.assertEquals(searchByMakeHolder, searchMap.get("make"));

    }
}
