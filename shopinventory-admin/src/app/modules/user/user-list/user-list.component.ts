import { Component } from '@angular/core';
import { UsersMock } from '../../../data/mocks/users.data';
import { ColumnConfig } from '../../../shared/utils/column-config';

@Component({
  selector: 'app-user-list',
  standalone: false,
  templateUrl: './user-list.component.html',
  styleUrl: './user-list.component.scss'
})
export class UserListComponent {
  users: any[] = [];

  columns: ColumnConfig[] = [
    { columnDef: 'id', header: 'ID', cell: (row: any) => `${row.id}` },
    { columnDef: 'firstName', header: 'First Name', cell: (row: any) => `${row.firstName}` },
    { columnDef: 'middleName', header: 'Middle Name', cell: (row: any) => `${row.middleName}` },
    { columnDef: 'lastName', header: 'Last Name', cell: (row: any) => `${row.lastName}` },
    { columnDef: 'username', header: 'Username', cell: (row: any) => `${row.username}` },
    { columnDef: 'email', header: 'Email', cell: (row: any) => `${row.email}` },
    { columnDef: 'mobile', header: 'Phone', cell: (row: any) => `${row.mobile}` },
  ];
  
  ngOnInit(): void {
    this.users = UsersMock.content;
  }
}
