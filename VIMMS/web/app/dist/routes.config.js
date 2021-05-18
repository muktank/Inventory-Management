"use strict";
const router_1 = require('@angular/router');
const vehiclesearch_component_1 = require("./vehiclesearch.component");
const vehicleadd_component_1 = require("./vehicleadd.component");
let routes = [
    { path: 'search', component: vehiclesearch_component_1.VehicleSearchComponent },
    { path: 'add', component: vehicleadd_component_1.VehicleAddComponent },
    { path: '', redirectTo: '/search', pathMatch: 'full' }
];
exports.configuredRoutes = router_1.RouterModule.forRoot(routes);
//# sourceMappingURL=routes.config.js.map