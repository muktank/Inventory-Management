import {Component, OnInit} from "@angular/core";
import {Http, Headers, RequestOptions} from "@angular/http";
import {Vehicle} from "./vehicle";
import {LoadVehicleResponse} from "./loadVehicleResponse";
import {VehicleSearchResponse} from "./VehicleSearchResponse";
import {Router} from "@angular/router";


@Component({
    selector: 'add',
    templateUrl: '../partials/vehicleadd.component.html',
    styleUrls: ['../css/vehicleadd.component.css'],
})

export class VehicleAddComponent implements OnInit {

    requestHeaders : any;
    options : any;
    imageUrl: string = "images/";
    searchField: string = "";
    searchFieldValue: string = "";
    selectedMake: string = " ";
    selectedModel: string = " ";
    selectedYear: number = 0;
    selectedTrim: string = " ";
    selectedFuel: string = " ";
    selectedOption: string = " ";
    initialResposne: LoadVehicleResponse;
    models: string[];
    makes: string[];
    vehicles: Vehicle[];
    vehicleSearchResponse: VehicleSearchResponse;
    years: number[];
    trims: string[];
    fuels: string[];
    cylinder:number;
    engine:string;
    exterior:string;
    horsePower:string;
    transmission:string;
    capacity:number;
    image:string;
    price:number;
    response:string;

    constructor(private http: Http, private router:Router) {
        this.requestHeaders = new Headers({'Accept': 'application/json'});
        this.options = new RequestOptions({headers: this.requestHeaders});
    }



    ngOnInit() {
        var searchURL = "";
        searchURL = "/rest/loadvehicle";

        this.http.get(searchURL, this.options).subscribe(res => {
            this.initialResposne = res.json();
            console.log(this.initialResposne);
            this.makes = this.initialResposne.makes;

        });
    }


    addVehicle(){
        var requestHeaders1 = new Headers({'Accept': 'text/plain'});
        var options1 = new RequestOptions({headers: requestHeaders1});

        var searchURL = "";
        searchURL = "/rest/test/" + this.selectedMake + "/" + this.selectedModel + "/" + this.selectedYear + "/" + this.selectedTrim + "/" + this.selectedFuel + "/"+ this.image + "/" + this.price + "/" + this.exterior+ "/" + this.engine + "/" + this.transmission + "/" + this.cylinder + "/" + this.horsePower + "/" + this.capacity;

        this.http.get(searchURL, options1).subscribe(res => {
            this.response = res.toString();
            if(this.response){
                alert("Vehicle added successfully!!");
                this.router.navigate(['/search']);
            }

            else{
                alert("Something went wrong!");
            }
            // console.log("hi");
            // console.log(res);
            // this.models = this.vehicleSearchResponse.filtersMap.get("models");
        });
    }


    onChangeMake(make: string) {
        this.models = null;

        this.years = null;
        this.fuels = null;
        this.trims = null;
        this.selectedModel = null;
        this.selectedYear = null;
        this.selectedTrim = null;
        this.selectedFuel = null;
        console.log("MAKE CHANE");
        var searchURL = "";
        searchURL = "/rest/search/" + this.selectedMake;

        this.http.get(searchURL, this.options).subscribe(res => {
            this.vehicleSearchResponse = res.json();
            this.models = this.vehicleSearchResponse.filtersMap.models;
            // this.models = this.vehicleSearchResponse.filtersMap.get("models");
        });
    }

    onChangeModel(model: string) {
        this.years = null;
        this.fuels = null;
        this.trims = null;
        this.selectedYear = null;
        this.selectedTrim = null;
        this.selectedFuel = null;

        var searchURL = "";
        searchURL = "/rest/search/" + this.selectedMake + "/" + this.selectedModel;

        this.http.get(searchURL, this.options).subscribe(res => {
            this.vehicleSearchResponse = res.json();
            this.years = this.vehicleSearchResponse.filtersMap.years;
            // this.models = this.vehicleSearchResponse.filtersMap.get("models");
        });

    }

    onChangeYear(year: string) {

        this.trims = null;
        this.fuels = null;
        this.selectedTrim = null;
        this.selectedFuel = null;

        var searchURL = "";
        searchURL = "/rest/search/" + this.selectedMake + "/" + this.selectedModel + "/" + this.selectedYear;

        this.http.get(searchURL, this.options).subscribe(res => {
            this.vehicleSearchResponse = res.json();
            this.trims = this.vehicleSearchResponse.filtersMap.trims;
            // this.models = this.vehicleSearchResponse.filtersMap.get("models");
        });

    }

    onChangeTrim(trim: string) {

        this.fuels = null
        this.selectedFuel = null;

        var searchURL = "";
        searchURL = "/rest/search/" + this.selectedMake + "/" + this.selectedModel + "/" + this.selectedYear + "/" + this
            .selectedTrim;

        this.http.get(searchURL, this.options).subscribe(res => {
            this.vehicleSearchResponse = res.json();
            this.fuels = this.vehicleSearchResponse.filtersMap.fuelTypes;
            this.vehicles = this.vehicleSearchResponse.vehicles;
            console.log(this.vehicles);

            // this.models = this.vehicleSearchResponse.filtersMap.get("models");
        });

    }

    onChangeFuel(fuel: string) {

        var searchURL = "";
        searchURL = "/rest/search/" + this.selectedMake + "/" + this.selectedModel + "/" + this.selectedYear + "/" + this
            .selectedTrim + "/" + this.selectedFuel;

        this.http.get(searchURL, this.options).subscribe(res => {
            this.vehicleSearchResponse = res.json();
            console.log(this.vehicleSearchResponse);
            this.vehicles = this.vehicleSearchResponse.vehicles;
            console.log(this.vehicles);
            // this.models = this.vehicleSearchResponse.filtersMap.get("models");
        });

    }

    onChangeOption(option: string) {
        if(this.selectedOption == "Make"){
            this.vehicles.sort(function (vehicle1, vehicle2) {
                if (vehicle1.make.makeName < vehicle2.make.makeName) {
                    return -1;
                } else if (vehicle1.make.makeName > vehicle2.make.makeName) {
                    return 1;
                } else {
                    return 0;
                }
            });
        }
        else if(this.selectedOption == "Model"){
            this.vehicles.sort(function (vehicle1, vehicle2) {
                if (vehicle1.model.modelName < vehicle2.model.modelName) {
                    return -1;
                } else if (vehicle1.model.modelName > vehicle2.model.modelName) {
                    return 1;
                } else {
                    return 0;
                }
            });
        }
        else if(this.selectedOption == "Year"){
            this.vehicles.sort(function (vehicle1, vehicle2) {
                if (vehicle1.model.year < vehicle2.model.year) {
                    return -1;
                } else if (vehicle1.model.year > vehicle2.model.year) {
                    return 1;
                } else {
                    return 0;
                }
            });
        }
        else if(this.selectedOption == "Trim"){
            this.vehicles.sort(function (vehicle1, vehicle2) {
                if (vehicle1.trim.trimName < vehicle2.trim.trimName) {
                    return -1;
                } else if (vehicle1.trim.trimName > vehicle2.trim.trimName) {
                    return 1;
                } else {
                    return 0;
                }
            });
        }
        else if(this.selectedOption == "Fuel"){
            this.vehicles.sort(function (vehicle1, vehicle2) {
                if (vehicle1.fuel.fuelType < vehicle2.fuel.fuelType) {
                    return -1;
                } else if (vehicle1.fuel.fuelType > vehicle2.fuel.fuelType) {
                    return 1;
                } else {
                    return 0;
                }
            });
        }

        else if(this.selectedOption == "VIN"){
            this.vehicles.sort(function (vehicle1, vehicle2) {
                if (vehicle1.vin < vehicle2.vin) {
                    return -1;
                } else if (vehicle1.vin > vehicle2.vin) {
                    return 1;
                } else {
                    return 0;
                }
            });
        }

        else if(this.selectedOption == "Price"){
            this.vehicles.sort(function (vehicle1, vehicle2) {
                if (vehicle1.price < vehicle2.price) {
                    return -1;
                } else if (vehicle1.price > vehicle2.price) {
                    return 1;
                } else {
                    return 0;
                }
            });
        }
    }

    clear() {
        this.makes = null;
        this.models = null;
        this.years = null;
        this.fuels = null;
        this.trims = null;
        this.engine = null;
        this.exterior = null;
        this.capacity = null;
        this.cylinder = null;
        this.horsePower = null;
        this.transmission = null;
        this.image = null;

        this.selectedMake = null;
        this.selectedModel = null;
        this.selectedYear = null;
        this.selectedTrim = null;
        this.selectedFuel = null;
        this.selectedOption = null;

        this.ngOnInit();
    }

}


