import { MatButtonModule, MatCheckboxModule, MatTableModule } from '@angular/material';
import { NgModule } from '@angular/core';

@NgModule({
  imports: [
    MatButtonModule,
    MatCheckboxModule,
    MatTableModule
  ],
  exports: [
    MatButtonModule,
    MatCheckboxModule,
    MatTableModule
  ],
})
export class MaterialModule { }
