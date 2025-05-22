import { Component } from "@angular/core";

@Component({
  selector: "app-root",
  template: `
    <app-sidenav>
      <router-outlet />
    </app-sidenav>
  `,
  standalone: false,
  styles: [],
})
export class AppComponent {}
