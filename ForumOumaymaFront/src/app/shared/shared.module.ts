import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {ComponentsModule} from '../components/components.module';
import {ToastrModule} from 'ngx-toastr';



@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    ComponentsModule,
    FormsModule,
    ToastrModule.forRoot()
  ],
  exports: [
    ReactiveFormsModule,
    ComponentsModule,
    FormsModule
  ]
})
export class SharedModule { }
