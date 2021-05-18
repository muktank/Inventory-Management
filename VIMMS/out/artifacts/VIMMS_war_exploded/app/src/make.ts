import {Model} from "./model"

export class Make{
    makeId:number;
    makeName:string = "";
    models:Model[];


    constructor(makeName: string, models: Model[]) {
        this.makeName = makeName;
        this.models = models;
    }
}










