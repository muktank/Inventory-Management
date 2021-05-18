package com.cdk.vimms.vo;

import com.cdk.vimms.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SearchByMakeHolderTest {


  private DataHolder searchByMakeHolder;

  @Test
  public void testHappyFlow(){
    searchByMakeHolder = new SearchByMakeHolder();
    Vehicle expected = prepareTestVehicle();
    searchByMakeHolder.populate(expected);
    VehicleSearcherResponse response = searchByMakeHolder.search("honda");
    List<String> keys = searchByMakeHolder.getKeys();
    System.out.println(response.getVehicles().toString());
    Assert.assertEquals(response.getVehicles().iterator().next().getMake().getMakeName(),expected.getMake().getMakeName());
    Assert.assertEquals(keys.iterator().next(),expected.getMake().getMakeName());
    Assert.assertEquals(response.getFiltersMap().get("models").iterator().next(),expected.getModel().getModelName());

  }


  private Vehicle prepareTestVehicle(){
      Vehicle vehicle = new Vehicle();
    Make make = new Make();
    make.setMakeID(1);
    make.setMakeName("honda");

    vehicle.setMake(make);

    Model model = new Model();
    model.setModelID(1);
    model.setModelName("crv");
    vehicle.setModel(model);
    Trim trim = new Trim();
    trim.setTrimID(1);
    trim.setTrimName("vxi");
    vehicle.setTrim(trim);
    Fuel fuel = new Fuel();
    fuel.setFuelID(1);
    fuel.setFuelType("petrol");
    vehicle.setFuel(fuel);
      vehicle.setPrice(123);
      Image image = new Image();
      image.setImageID(1);
      image.setImageName("abc.jpg");
      vehicle.setImage(image);
      Description description = new Description(1, "black", "engine","auto", 4, "150hp", 4);
      vehicle.setDescription(description);
      return vehicle;
  }

}
