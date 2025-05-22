import { AfterViewInit, Component, Input, OnInit, ViewChild } from "@angular/core";
import { ColumnConfig } from "../utils/column-config";
import { MatTableDataSource, MatTableModule } from "@angular/material/table";
import { FormControl, ReactiveFormsModule } from "@angular/forms";
import { debounceTime } from "rxjs";
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatPaginator, MatPaginatorModule } from "@angular/material/paginator";
import { CommonModule } from "@angular/common";
import { MatInputModule } from "@angular/material/input";
import { ContainerComponent } from "../container/container.component";

@Component({
  selector: "app-material-dynamic-table",
  templateUrl: "./material-dynamic-table.component.html",
  styleUrl: "./material-dynamic-table.component.scss",
  imports: [
    MatTableModule,
    MatPaginatorModule,
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule,
    CommonModule,
    ContainerComponent
],
})
export class MaterialDynamicTableComponent implements OnInit, AfterViewInit {
  @Input() columns: ColumnConfig[] = [];
  @Input() data: any[] = [];
  @Input() enableSearch: boolean = false;

  dataSource = new MatTableDataSource<any>();
  displayedColumns: string[] = [];
  searchControl = new FormControl();

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  ngOnInit(): void {
    this.displayedColumns = this.columns.map((col) => col.columnDef);
    this.dataSource.data = this.data;

    if (this.enableSearch) {
      this.searchControl.valueChanges
        .pipe(debounceTime(300))
        .subscribe((value) => {
          this.dataSource.filter = value.trim().toLowerCase();
        });

      this.dataSource.filterPredicate = (data, filter) => {
        return this.columns.some((col) =>
          col.cell(data).toLowerCase().includes(filter)
        );
      };
    }
  }

  ngAfterViewInit(): void {
    this.dataSource.paginator = this.paginator;
  }
}