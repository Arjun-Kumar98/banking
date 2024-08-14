export class CustomerInfo{
  accountId: string = "";
  customerName:string="";
  createdOn:Date = new Date();
  updatedOn:Date = new Date();
  activeInd:boolean = true;
}

export class BankInfo{
  bankName:string=" ";
  ifscCode:string=" ";
  createdOn:Date = new Date();
  updatedOn:Date = new Date();
  activeInd=true;
}

export class RetailerInfo{
retailerName:string=" ";
createdOn:Date = new Date();
updatedOn:Date = new Date();
accountId:string=" ";
activeInd:boolean=true;
}
