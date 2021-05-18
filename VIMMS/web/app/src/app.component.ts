import {Component} from "@angular/core";

@Component({
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
})
export class AppComponent {
}


