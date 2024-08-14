import { Component } from '@angular/core';
import{FormsModule} from "@angular/forms";
import {CustomerInfo} from "./model";
import {BankInfo} from "./model";
import {RetailerInfo} from "./model";
import {ApiService} from "../../core/apiService";

@Component({
  selector: 'app-insertnew',
  templateUrl: './insertnew.component.html',
  styleUrl: './insertnew.component.css'
})
export class InsertnewComponent {
constructor(private apiService: ApiService){}
   customerInfo: CustomerInfo = new CustomerInfo();
   bankInfo: BankInfo = new BankInfo();
   initially:boolean=true;
   banking:boolean = false;
   retailing:boolean=false;
   customerscreen:boolean=false;
   retailerInfo: RetailerInfo = new RetailerInfo();

   ngOnInit(){
     this.initially=true;
   }
      showcustomer(){
     this.initially=false;
     this.customerscreen = true;
      }
goback(){
     this.initially=true;
     this.customerscreen=false;
     this.retailing=false;
     this.banking=false;
}
      submitdetails(datas:any){
      if(datas==1){
        this.apiService.registercustomer(this.customerInfo).subscribe(res=>{

        });
      }else if(datas==2){
        this.apiService.registerbanker(this.bankInfo).subscribe(res=>{});
      }else{
        this.apiService.registerretailer(this.retailerInfo).subscribe(res=>{});
      }
      }

      showbank(){
     this.initially=false;
     this.banking=true;
      }

      showretailer(){
     this.initially=false;
     this.retailing=true;
      }
}
