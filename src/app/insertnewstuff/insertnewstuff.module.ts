import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule} from "@angular/forms";
import { provideHttpClient } from '@angular/common/http';
import {ApiService} from "../core/apiService";
import {InsertnewComponent} from "./insertnew/insertnew.component";
import {NewLoanComponent} from "./new-loan/new-loan.component";
import {BankLoanComponent} from "./bank-loan/bank-loan.component";
import {InsertnewroutingModule} from "./insertnewrouting.module";

@NgModule({
  declarations: [InsertnewComponent,NewLoanComponent,BankLoanComponent],
  imports: [
    CommonModule,
    FormsModule,
    InsertnewroutingModule
  ],
  providers:[provideHttpClient(),ApiService]
})
export class InsertnewstuffModule { }
