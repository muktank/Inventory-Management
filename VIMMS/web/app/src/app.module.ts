import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import { HttpModule } from '@angular/http';

import {VehicleSearchComponent} from "./vehiclesearch.component"
import {VehicleAddComponent} from "./vehicleadd.component";
import {AppComponent} from "./app.component";
import {configuredRoutes} from "./routes.config";




@NgModule({
	imports:[BrowserModule,FormsModule,HttpModule, configuredRoutes],
	declarations:[VehicleSearchComponent, VehicleAddComponent, AppComponent],
	bootstrap:[AppComponent]
})
export class AppModule{
}







