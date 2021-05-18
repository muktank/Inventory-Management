"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
const core_1 = require("@angular/core");
const http_1 = require("@angular/http");
const router_1 = require("@angular/router");
let VehicleAddComponent = class VehicleAddComponent {
    constructor(http, router) {
        this.http = http;
        this.router = router;
        this.imageUrl = "images/";
        this.searchField = "";
        this.searchFieldValue = "";
        this.selectedMake = " ";
        this.selectedModel = " ";
        this.selectedYear = 0;
        this.selectedTrim = " ";
        this.selectedFuel = " ";
        this.selectedOption = " ";
        this.requestHeaders = new http_1.Headers({ 'Accept': 'application/json' });
        this.options = new http_1.RequestOptions({ headers: this.requestHeaders });
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
    addVehicle() {
        var requestHeaders1 = new http_1.Headers({ 'Accept': 'text/plain' });
        var options1 = new http_1.RequestOptions({ headers: requestHeaders1 });
        var searchURL = "";
        searchURL = "/rest/test/" + this.selectedMake + "/" + this.selectedModel + "/" + this.selectedYear + "/" + this.selectedTrim + "/" + this.selectedFuel + "/" + this.image + "/" + this.price + "/" + this.exterior + "/" + this.engine + "/" + this.transmission + "/" + this.cylinder + "/" + this.horsePower + "/" + this.capacity;
        this.http.get(searchURL, options1).subscribe(res => {
            this.response = res.toString();
            if (this.response) {
                alert("Vehicle added successfully!!");
                this.router.navigate(['/search']);
            }
            else {
                alert("Something went wrong!");
            }
            // console.log("hi");
            // console.log(res);
            // this.models = this.vehicleSearchResponse.filtersMap.get("models");
        });
    }
    onChangeMake(make) {
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
    onChangeModel(model) {
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
    onChangeYear(year) {
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
    onChangeTrim(trim) {
        this.fuels = null;
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
    onChangeFuel(fuel) {
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
    onChangeOption(option) {
        if (this.selectedOption == "Make") {
            this.vehicles.sort(function (vehicle1, vehicle2) {
                if (vehicle1.make.makeName < vehicle2.make.makeName) {
                    return -1;
                }
                else if (vehicle1.make.makeName > vehicle2.make.makeName) {
                    return 1;
                }
                else {
                    return 0;
                }
            });
        }
        else if (this.selectedOption == "Model") {
            this.vehicles.sort(function (vehicle1, vehicle2) {
                if (vehicle1.model.modelName < vehicle2.model.modelName) {
                    return -1;
                }
                else if (vehicle1.model.modelName > vehicle2.model.modelName) {
                    return 1;
                }
                else {
                    return 0;
                }
            });
        }
        else if (this.selectedOption == "Year") {
            this.vehicles.sort(function (vehicle1, vehicle2) {
                if (vehicle1.model.year < vehicle2.model.year) {
                    return -1;
                }
                else if (vehicle1.model.year > vehicle2.model.year) {
                    return 1;
                }
                else {
                    return 0;
                }
            });
        }
        else if (this.selectedOption == "Trim") {
            this.vehicles.sort(function (vehicle1, vehicle2) {
                if (vehicle1.trim.trimName < vehicle2.trim.trimName) {
                    return -1;
                }
                else if (vehicle1.trim.trimName > vehicle2.trim.trimName) {
                    return 1;
                }
                else {
                    return 0;
                }
            });
        }
        else if (this.selectedOption == "Fuel") {
            this.vehicles.sort(function (vehicle1, vehicle2) {
                if (vehicle1.fuel.fuelType < vehicle2.fuel.fuelType) {
                    return -1;
                }
                else if (vehicle1.fuel.fuelType > vehicle2.fuel.fuelType) {
                    return 1;
                }
                else {
                    return 0;
                }
            });
        }
        else if (this.selectedOption == "VIN") {
            this.vehicles.sort(function (vehicle1, vehicle2) {
                if (vehicle1.vin < vehicle2.vin) {
                    return -1;
                }
                else if (vehicle1.vin > vehicle2.vin) {
                    return 1;
                }
                else {
                    return 0;
                }
            });
        }
        else if (this.selectedOption == "Price") {
            this.vehicles.sort(function (vehicle1, vehicle2) {
                if (vehicle1.price < vehicle2.price) {
                    return -1;
                }
                else if (vehicle1.price > vehicle2.price) {
                    return 1;
                }
                else {
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
};
VehicleAddComponent = __decorate([
    core_1.Component({
        selector: 'add',
        templateUrl: '../partials/vehicleadd.component.html',
        styleUrls: ['../css/vehicleadd.component.css'],
    }), 
    __metadata('design:paramtypes', [http_1.Http, router_1.Router])
], VehicleAddComponent);
exports.VehicleAddComponent = VehicleAddComponent;
//# sourceMappingURL=vehicleadd.component.js.map