package com.cdk.vimms.controller;

import com.cdk.vimms.service.VehicleSearcher;
import com.cdk.vimms.service.VehicleService;
import com.cdk.vimms.vo.LoadVehicleResponse;
import com.cdk.vimms.vo.VehicleSearcherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @Resource
    VehicleSearcher vehicleSearcher;

    @RequestMapping(value = "/loadvehicle",produces = "application/json" ,method = RequestMethod.GET)
    public LoadVehicleResponse loadAllVehicles(){
        LoadVehicleResponse loadVehicleResponse = vehicleService.readAllVehicles();
        return loadVehicleResponse;
    }

    @RequestMapping(value = "/search/{make}",produces = "application/json" ,method = RequestMethod.GET)
    public VehicleSearcherResponse searchVehiclesByMake(@PathVariable String make){
        VehicleSearcherResponse result = vehicleService.search("make", make);
        return result;
    }

    @RequestMapping(value = "/search/{make}/{model}",produces = "application/json" ,method = RequestMethod.GET)
    public VehicleSearcherResponse searchVehiclesByMakeModel(@PathVariable String make, @PathVariable String model ){
        return vehicleService.search("makemodel",make+model);
    }

    @RequestMapping(value = "/search/{make}/{model}/{year}",produces = "application/json" ,method = RequestMethod.GET)
    public VehicleSearcherResponse searchVehiclesByMakeModelYear(@PathVariable String make, @PathVariable String model, @PathVariable int year ){
        return vehicleService.search("makemodelyear",make+model+year);
    }

    @RequestMapping(value = "/search/{make}/{model}/{year}/{trim}",produces = "application/json" ,method = RequestMethod.GET)
    public VehicleSearcherResponse searchVehiclesByMakeModelYearTrim(@PathVariable String make, @PathVariable String model, @PathVariable int year, @PathVariable String trim ){
        VehicleSearcherResponse response = vehicleService.search("makemodelyeartrim",make+model+year+trim);
        return response;
    }

    @RequestMapping(value = "/search/{make}/{model}/{year}/{trim}/{fuel}",produces = "application/json" ,method = RequestMethod.GET)
    public VehicleSearcherResponse searchVehiclesByMakeModelYearTrimFuel(@PathVariable String make, @PathVariable String model, @PathVariable int year, @PathVariable String trim, @PathVariable String fuel ){
        return vehicleService.search("makemodelyeartrimfuel",make+model+year+trim+fuel);
    }

    @RequestMapping(value = "/test/{name}/{model}/{year}/{trim}/{fuel}/{image}/{price}/{exterior}/{engine}/{transmission}/{cylinders}/{horsepower}/{capacity}" ,produces = "text/plain" ,method = RequestMethod.GET)
    public String addVehicle(@PathVariable String name,@PathVariable String model, @PathVariable int year, @PathVariable String trim, @PathVariable String fuel, @PathVariable String image, @PathVariable double price, @PathVariable String exterior, @PathVariable String engine, @PathVariable String transmission, @PathVariable int cylinders, @PathVariable String horsepower, @PathVariable int capacity){
        int i = vehicleService.addVehicle(name,model,year,trim,fuel,image,price,exterior,engine,transmission,cylinders,horsepower,capacity);
        return "Car with vin '"+i+" ' added successfully!";
    }




}
