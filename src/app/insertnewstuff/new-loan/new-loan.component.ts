import { Component } from '@angular/core';
import {ApiService} from "../../core/apiService";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-new-loan',
  templateUrl: './new-loan.component.html',
  styleUrl: './new-loan.component.css'
})
export class NewLoanComponent {
RetailerList :{id:number,retailerName:String}[]=[]
BankList :{id:number,bankName:String}[]=[];
AccountList:{id:number,accountId:String}[]=[];
invoiceDesc:any;
customerName:any;
selectedAccountId:any;
checkId:number=0;
selectedBankId:any;
invoiceAmount:number=0.00;
selectedRetailerId:any;

constructor(private apiService: ApiService, private route:ActivatedRoute){

}
ngOnInit(){
 this.getBankList();
 this.getRetailerList();
 this.getAccountList();
  this.route.params.subscribe(params => {
    console.log(params['id']); // Access the id parameter
    if(params['id']!=undefined){
      this.checkId = params['id'];
      this.apiService.getLoanDetails(this.checkId).subscribe(res=>{

        // "customerId": 2,
        //   "bankId": 1,
        //   "retailerId": 1,
        //   "createdOn": "2024-08-07T00:08:45",
        //   "updatedOn": "2024-08-07T00:08:45",
        //   "activeInd": true,
        //   "invoiceDesc": "New Bike",
        //   "invoiceAmount": 12000.0,
        //   "id": 2
        this.invoiceDesc = res.invoiceDesc;
        this.invoiceAmount = res.invoiceAmount;
        this.selectedBankId = res.bankId;
        this.selectedRetailerId=res.retailerId;
        this.selectedAccountId=res.customerId;
      })
    }
  });
}
getBankList(){
  this.apiService.getBankDetails().subscribe(res=>{
     this.BankList = res;
    },
    error => {
    console.error("Error fetching bank details"+error);
  })


}
getRetailerList(){
  this.apiService.getRetailerDetails().subscribe((res)=>{
    this.RetailerList = res;
  },
    error=>{
    console.error("Error fetching retailer details"+error);
    })
  //console.log("the retailer list is === "+this.RetailerList);
}

getAccountList(){
  this.apiService.getCustomerDetails().subscribe((res)=>{
    this.AccountList=res;
  },
    error=>{
    console.error("Error fetching account details"+error);
    })
}
submit() {

  const data = {
    "bankId": this.selectedBankId,
    "activeInd": true,
    "createdOn": new Date(),
    "updatedOn": new Date(),
    "customerId": this.selectedAccountId,
    "invoiceAmount": this.invoiceAmount,
    "invoiceDesc": this.invoiceDesc,
    "retailerId": this.selectedRetailerId
  }
  if (this.checkId != 0) {
    console.log("I am called here");
    this.apiService.updateLoanDetails(this.checkId, data).subscribe((res) => {

    }, error => {
      console.error("Error updating account details" + error);
    });
  } else {
    this.apiService.saveLoanDetails(data).subscribe((res) => {
        console.log("Hi");
      },
      error => {
        console.error("Error saving account details" + error);
      });
  }
}
}
