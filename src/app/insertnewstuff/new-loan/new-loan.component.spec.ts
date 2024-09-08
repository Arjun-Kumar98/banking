import { ComponentFixture, TestBed } from '@angular/core/testing';
import {ApiService} from "../../core/apiService";
import { NewLoanComponent } from './new-loan.component';
import{InsertnewstuffModule} from "../insertnewstuff.module";
import{ActivatedRoute} from "@angular/router";
import {of} from "rxjs";

describe('NewLoanComponent', () => {
  let component: NewLoanComponent;
  let fixture: ComponentFixture<NewLoanComponent>;
  let apiService: jasmine.SpyObj<ApiService>;

  const routeService = {
    snapshot:{
      paramMap:{
        get:(key:string)=>{
          return 'mockValue';
        }
      }
    },
    queryParams:of({}),
  };
  beforeEach(async () => {
    const apiServiceSpy = jasmine.createSpyObj('ApiService',['saveLoanDetails']);

    await TestBed.configureTestingModule({
      imports: [InsertnewstuffModule],
      providers:[{provide:ApiService,useValue:apiServiceSpy},{provide: ActivatedRoute,useValue: routeService}]
    }).compileComponents();

    fixture = TestBed.createComponent(NewLoanComponent);
    component = fixture.componentInstance;
    apiService = TestBed.inject(ApiService) as jasmine.SpyObj<ApiService>;
      component.selectedBankId=1,
      component.selectedAccountId=1;
      component.invoiceAmount=11202;
      component.invoiceDesc ="new Briefcase";
      component.selectedRetailerId =1;
    fixture.detectChanges();
  });

  it('shoud call the api when the submit function is called',()=>{
    apiService.saveLoanDetails.and.returnValue(of({}));
    component.submit();
    expect(apiService.saveLoanDetails).toHaveBeenCalledWith({
      "bankId": component.selectedBankId,
      "activeInd": true,
      "createdOn":new Date(),
      "updatedOn":new Date(),
      "customerId":component.selectedAccountId,
      "invoiceAmount":component.invoiceAmount,
      "invoiceDesc":component.invoiceDesc,
      "retailerId":component.selectedRetailerId
    }

  )
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
