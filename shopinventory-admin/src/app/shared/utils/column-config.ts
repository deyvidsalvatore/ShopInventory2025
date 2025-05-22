export interface ColumnConfig {
  columnDef: string;
  header: string;
  cell: (element: any) => string;
  sortable?: boolean;
  width?: string;
}