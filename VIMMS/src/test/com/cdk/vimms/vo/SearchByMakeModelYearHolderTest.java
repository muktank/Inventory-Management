package com.cdk.vimms.vo;

import com.cdk.vimms.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SearchByMakeModelYearHolderTest {
    private DataHolder searchByMakeModelYearHolder;

    @Test
    public void testHappyFlow(){
        searchByMakeModelYearHolder = new SearchByMakeModelYearHolder();
        Vehicle expected = prepareTestVehicle();
        searchByMakeModelYearHolder.populate(expected);
        VehicleSearcherResponse response = searchByMakeModelYearHolder.search("BMWA82017");
        List<String> keys = searchByMakeModelYearHolder.getKeys();
        System.out.println(response.getVehicles().toString());
        Assert.assertEquals(response.getVehicles().iterator().next().getModel().getYear(),expected.getModel().getYear());
        Assert.assertEquals(keys.iterator().next(),expected.getMake().getMakeName()+ expected.getModel().getModelName()+ expected.getModel().getYear());
        Assert.assertEquals(response.getFiltersMap().get("trims").iterator().next(),expected.getTrim().getTrimName());

    }

    private Vehicle prepareTestVehicle() {
        Trim trim = new Trim(1, "LXI");
        Set<Trim> trims = new HashSet<>();
        trims.add(trim);
        Model model = new Model(1, "A8", 2017, trims);
        Set<Model> models = new HashSet<>();
        models.add(model);
        Make make = new Make(1, "BMW", models);
        Fuel fuel = new Fuel(1, "petrol");
        Image image = new Image();
        image.setImageID(1);
        image.setImageName("abc.jpg");
        Description description = new Description(1, "black", "engine","auto", 4, "150hp", 4);
        Vehicle vehicle = new Vehicle(1, model, make,trim,fuel,image,description,50000);
        return vehicle;
    }
}
