import {NgModule} from "@angular/core";
import {Routes,RouterModule} from "@angular/router";
import {InsertnewComponent} from "./insertnew/insertnew.component";
import {NewLoanComponent} from "./new-loan/new-loan.component";
import {BankLoanComponent} from "./bank-loan/bank-loan.component";


const routes: Routes=[
  {path:"",component:InsertnewComponent},
  {path:"loan",component:NewLoanComponent},
  {path:"loan/:id",component:NewLoanComponent},
  {path:"viewloan",component:BankLoanComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
 exports: [RouterModule]
  })
export class InsertnewroutingModule{}




