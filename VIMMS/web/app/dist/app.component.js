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
let AppComponent = class AppComponent {
};
AppComponent = __decorate([
    core_1.Component({
        selector: 'vimms-app',
        template: `
        <div>
            <!--<a routerLink="politician">Show Politicians</a>-->
            <!--<a routerLink="customer">Add Customer</a>-->
            <!--<a routerLink="news">News Page</a>-->
            <!--<a routerLink="cricket">Cricket Page</a>-->
            <!--<a routerLink="weather">Weather Page</a>-->
            <!--<a routerLink="">Calculator Page</a>-->
            <!--<a routerLink="movie/100">Movies 1</a>-->
            <!--<a routerLink="movie/101">Movies 2</a>-->
            <!--<a routerLink="login">login</a>-->
            <router-outlet></router-outlet>
        </div>`
    }), 
    __metadata('design:paramtypes', [])
], AppComponent);
exports.AppComponent = AppComponent;
//# sourceMappingURL=app.component.js.map