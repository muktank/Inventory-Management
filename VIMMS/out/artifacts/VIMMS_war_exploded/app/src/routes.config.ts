import {Routes, RouterModule} from '@angular/router';
import {VehicleSearchComponent} from "./vehiclesearch.component";
import {VehicleAddComponent} from "./vehicleadd.component";



let routes: Routes = [

    {path: 'search', component: VehicleSearchComponent},
    {path: 'add', component:VehicleAddComponent},
    {path: '', redirectTo: '/search', pathMatch: 'full'}
];
export const configuredRoutes = RouterModule.forRoot(routes);






