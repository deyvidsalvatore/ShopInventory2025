import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DashboardRoutingModule } from './dashboard-routing.module';
import { DashboardPageComponent } from './dashboard-page/dashboard-page.component';
import { ContainerComponent } from "../../shared/container/container.component";
import { MatButtonModule } from '@angular/material/button';


@NgModule({
  declarations: [
    DashboardPageComponent
  ],
  imports: [
    CommonModule,
    DashboardRoutingModule,
    ContainerComponent,
    MatButtonModule
]
})
export class DashboardModule { }
