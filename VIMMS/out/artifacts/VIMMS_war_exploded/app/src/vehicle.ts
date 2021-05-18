import {Model} from "./model";
import {Make} from "./make";
import {Fuel} from "./fuel";
import {Trim} from "./trim";
import {Image} from "./image";
import {Description} from "./description";


export class Vehicle{


    vin:number;
    model:Model;
    make:Make;
    trim:Trim;
    fuel:Fuel;
    price:number;
    image:Image;
    description:Description;


    constructor(model: Model, make: Make, trim: Trim, fuel: Fuel, price: number, image: Image, description: Description) {
        this.model = model;
        this.make = make;
        this.trim = trim;
        this.fuel = fuel;
        this.price = price;
        this.image = image;
        this.description = description;
    }
}








