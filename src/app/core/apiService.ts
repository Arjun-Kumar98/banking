import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private apiUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }
  registercustomer(data:any):Observable<any>{
    const headers = new HttpHeaders({'Content-Type':'application/json'});
    return this.http.post(`${this.apiUrl}/saveCustomerdetails`,data,{headers});
  }

  registerbanker(data:any):Observable<any>{
    const headers = new HttpHeaders({'Content-Type':'application/json'});
    return this.http.post(`${this.apiUrl}/saveBankerDetails`,data,{headers});
  }

  registerretailer(data:any):Observable<any>{
    const headers = new HttpHeaders({'Content-Type':'application/json'});
    return this.http.post(`${this.apiUrl}/saveRetailerDetails`,data,{headers});
  }
  getBankDetails():Observable<any>{
    const headers:HttpHeaders = new HttpHeaders({'Content-Type':'application/json'});
    return this.http.get(`${this.apiUrl}/getBankDetails`,{headers});
  }
 getRetailerDetails():Observable<any>{
    const headers:HttpHeaders = new HttpHeaders({'Content-Type':'application/json'});
    return this.http.get(`${this.apiUrl}/getRetailerDetails`,{headers});
 }
 getCustomerDetails():Observable<any>{
    const headers:HttpHeaders = new HttpHeaders({'Content-Type':'application/json'});
    return this.http.get(`${this.apiUrl}/getCustomerDetails`,{headers});

 }
 saveLoanDetails(data:any):Observable<any>{
   const headers:HttpHeaders = new HttpHeaders({'Content-Type':'application/json'});
   return this.http.post(`${this.apiUrl}/saveLoanDetails`,data,{headers});
 }
 getLoanDetailsbyBank(data:number):Observable<any>{
    const headers:HttpHeaders = new HttpHeaders({'Content-Type':'application/json'});
    return this.http.get(`${this.apiUrl}/getLoanDetailsbyBank/${data}`,{headers});
 }
  getLoanDetails(data:number):Observable<any>{
    const headers:HttpHeaders = new HttpHeaders({'Content-Type':'application/json'});
    return this.http.get(`${this.apiUrl}/getLoanDetails/${data}`,{headers});
  }
  updateLoanDetails(Id:number,data:any):Observable<any>{
    const headers:HttpHeaders = new HttpHeaders({'Content-Type':'application/json'});
    return this.http.put(`${this.apiUrl}/updateLoanDetails/${Id}`,data,{headers});
  }
}
