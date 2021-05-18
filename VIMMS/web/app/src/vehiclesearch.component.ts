import {Component, OnInit} from "@angular/core";
import {Http, Headers, RequestOptions} from "@angular/http";
import {Vehicle} from "./vehicle";
import {LoadVehicleResponse} from "./loadVehicleResponse";
import {VehicleSearchResponse} from "./VehicleSearchResponse";
import {Router} from "@angular/router";


@Component({
    selector: 'search',
    templateUrl: '../partials/vehiclesearch.component.html',
    styleUrls: ['../css/vehiclesearch.component.css'],
})

export class VehicleSearchComponent implements OnInit {

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
            this.vehicles = this.initialResposne.vehicles;

            this.vehicles.sort(function (vehicle1, vehicle2) {
                if (vehicle1.vin < vehicle2.vin) {
                    return -1;
                } else if (vehicle1.vin > vehicle2.vin) {
                    return 1;
                } else {
                    return 0;
                }
            });

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

        var searchURL = "";
        searchURL = "/rest/search/" + this.selectedMake;

        this.http.get(searchURL, this.options).subscribe(res => {
            this.vehicleSearchResponse = res.json();
            this.models = this.vehicleSearchResponse.filtersMap.models;
            this.vehicles = this.vehicleSearchResponse.vehicles;
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
            this.vehicles = this.vehicleSearchResponse.vehicles;
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
            this.vehicles = this.vehicleSearchResponse.vehicles;
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

        this.selectedMake = null;
        this.selectedModel = null;
        this.selectedYear = null;
        this.selectedTrim = null;
        this.selectedFuel = null;
        this.selectedOption = null;

        this.ngOnInit();
    }

    addVehicle(){
        this.router.navigate(['/add']);
    }

}



