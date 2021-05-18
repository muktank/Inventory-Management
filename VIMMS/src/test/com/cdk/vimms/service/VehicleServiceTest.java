package com.cdk.vimms.service;

import com.cdk.vimms.dao.AddVehicleDAO;
import com.cdk.vimms.dao.VehicleDAO;
import com.cdk.vimms.dao.VehicleDAOImpl;
import com.cdk.vimms.model.*;
import com.cdk.vimms.vo.DataHolder;
import com.cdk.vimms.vo.LoadVehicleResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.util.*;

public class VehicleServiceTest {

    @InjectMocks
    private VehicleService vehicleService;

    @Mock
    private VehicleDAO vehicleDAOImpl;

    @Mock
    private AddVehicleDAO addVehicleDAO;

    @Mock
    private DataHolder searchByMakeHolder;

    @Mock
    private DataPopulator dataPopulator;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testReadAllVehicles()
    {   List<String> makes = new ArrayList<>();
        makes.add("honda");
        makes.add("bmw");
        Mockito.when(searchByMakeHolder.getKeys()).thenReturn(makes);
        LoadVehicleResponse vehicles = vehicleService.readAllVehicles();
        Assert.assertTrue(vehicles.getMakes().contains("bmw"));
    }

    @Test
    public void testaddVehicle() {
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
        Mockito.when(addVehicleDAO.getMake(Matchers.anyString())).thenReturn(make);
        Mockito.when(addVehicleDAO.getModel(Matchers.anyString(),Matchers.anyInt(), Matchers.anyInt() )).thenReturn(1);
        Mockito.when(addVehicleDAO.getTrim(Matchers.anyString(), Matchers.anyInt())).thenReturn(1);
        Mockito.when(addVehicleDAO.getFuel(Matchers.anyString())).thenReturn(fuel);
        Mockito.when(addVehicleDAO.getImage(Matchers.anyObject())).thenReturn(image);
        Mockito.when(addVehicleDAO.getDescription(Matchers.anyObject())).thenReturn(description);
        Mockito.when(addVehicleDAO.addVehicle(Matchers.anyObject())).thenReturn(1);
        int id = vehicleService.addVehicle("BMW", "A8", 2000, "LXI", "petrol", "img", 500, "black", "fdf", "trans", 4, "hp", 5);
        Assert.assertEquals(1,id);




    }

}
