import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserRoutingModule } from './user-routing.module';
import { UserListComponent } from './user-list/user-list.component';
import { MaterialDynamicTableComponent } from '../../shared/material-dynamic-table/material-dynamic-table.component';


@NgModule({
  declarations: [
    UserListComponent
  ],
  imports: [
    CommonModule,
    UserRoutingModule,
    MaterialDynamicTableComponent
  ]
})
export class UserModule { }
