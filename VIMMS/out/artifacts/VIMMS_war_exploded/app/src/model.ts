import {Trim} from "./trim"

export class Model{
    modelId:number;
    modelName:string = "";
    year:number;
    trims:Trim[];


    constructor(modelName: string, year: number, trims: Trim[]) {
        this.modelName = modelName;
        this.year = year;
        this.trims = trims;
    }
}








