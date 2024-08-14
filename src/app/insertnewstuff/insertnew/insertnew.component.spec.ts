import { ComponentFixture, TestBed } from '@angular/core/testing';
import { InsertnewComponent } from './insertnew.component';
import {ApiService} from "../../core/apiService";
import {CustomerInfo} from "./model";
import {BankInfo} from "./model";
import {RetailerInfo} from "./model";
import {InsertnewstuffModule} from "../insertnewstuff.module";
import {of} from 'rxjs';
describe('InsertnewComponent', () => {
  let component: InsertnewComponent;
  let fixture: ComponentFixture<InsertnewComponent>;
  let apiService: jasmine.SpyObj<ApiService>;
  beforeEach(async () => {
    const apiServiceSpy = jasmine.createSpyObj('ApiService',['registercustomer','registerbanker','registerretailer'])
    await TestBed.configureTestingModule({
      imports: [InsertnewstuffModule],
      providers:[{provide:ApiService,useValue:apiServiceSpy}]
    }).compileComponents();


    fixture = TestBed.createComponent(InsertnewComponent);
    component = fixture.componentInstance;
    apiService = TestBed.inject(ApiService) as jasmine.SpyObj<ApiService>;

    component.customerInfo = new CustomerInfo();
    component.customerInfo.accountId = "CUST123";
    component.customerInfo.customerName = "Jack Dawson";
    component.customerInfo.createdOn = new Date('2024-01-01');
    component.customerInfo.updatedOn = new Date('2024-04-01');
    component.customerInfo.activeInd = true;

    component.bankInfo = new BankInfo();
    component.bankInfo.bankName="SBI";
    component.bankInfo.ifscCode="SB10101";
    component.bankInfo.createdOn= new Date("2024-02-01");
    component.bankInfo.updatedOn = new Date("2024-04-03");
    component.bankInfo.activeInd= true;

    component.retailerInfo = new RetailerInfo();
    component.retailerInfo.retailerName= "Happy Meals";
    component.retailerInfo.accountId="143564";
    component.retailerInfo.createdOn = new Date("2024-01-05");
    component.retailerInfo.updatedOn = new Date("2024-03-03");
    component.retailerInfo.activeInd = true;

    fixture.detectChanges();
  });

  it('should call resgistercustomer when datas is 1',()=>{
    apiService.registercustomer.and.returnValue(of({}));
    component.submitdetails(1);
    expect(apiService.registercustomer).toHaveBeenCalledWith(component.customerInfo)
  });

  it('should call registerbanker when datas is 2',()=>{
    apiService.registerbanker.and.returnValue(of({}));
    component.submitdetails(2);
    expect(apiService.registerbanker).toHaveBeenCalledWith(component.bankInfo);
  });

  it('should call registerretailer when datas is 3',()=>{
    apiService.registerretailer.and.returnValue(of({}));
    component.submitdetails(3);
    expect(apiService.registerretailer).toHaveBeenCalledWith(component.retailerInfo);
  });


});
