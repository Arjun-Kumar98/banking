import { Component } from '@angular/core';
import {ApiService} from "../../core/apiService";
import {Router} from "@angular/router";


@Component({
  selector: 'app-bank-loan',
  templateUrl: './bank-loan.component.html',
  styleUrl: './bank-loan.component.css'
})
export class BankLoanComponent {
  BankList: { id: number, bankName: String }[] = [];
  LoanList: {Id:number,customerId:number,retailerId:number,bankId:number,invoiceAmount:number,invoiceDesc:String,id:number}[]=[];
selectedBankId:number=0;
viewloan:boolean=false;
  constructor(private apiService: ApiService, private router:Router) {
  }

  ngOnInit() {
    this.getBankList();
    this.viewloan=false;
  }
viewloans(){
    this.apiService.getLoanDetailsbyBank(this.selectedBankId).subscribe(res=>{
          this.LoanList = res;
          this.viewloan=true;
    })
}
  getBankList() {
    this.apiService.getBankDetails().subscribe(res => {
        this.BankList = res;
      },
      error => {
        console.error("Error fetching bank details" + error);
      })
  }
  edit(data:any){
    window.localStorage.setItem("editbankid",data);
    this.router.navigate(["/insert/loan",data]);
  }
}
