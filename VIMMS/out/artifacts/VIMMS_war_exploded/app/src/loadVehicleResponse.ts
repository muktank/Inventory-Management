import {Vehicle} from "./vehicle"

export class LoadVehicleResponse{

    vehicles:Vehicle[];
    makes:string[];


    constructor(vehicles: Vehicle[], makes: string[]) {
        this.vehicles = vehicles;
        this.makes = makes;
    }
}






