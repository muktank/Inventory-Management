export class Description{
    descriptionId:number;
    cylinders:number;
    engine:string;
    exterior:string;
    horsepower:string;
    passengerCapacity:number;
    transmission:string;


    constructor(descriptionId: number, cylinders: number, engine: string, exterior: string, horsepower: string, passengerCapacity: number, transmission: string) {
        this.descriptionId = descriptionId;
        this.cylinders = cylinders;
        this.engine = engine;
        this.exterior = exterior;
        this.horsepower = horsepower;
        this.passengerCapacity = passengerCapacity;
        this.transmission = transmission;
    }
}





