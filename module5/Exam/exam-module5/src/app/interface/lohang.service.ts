import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Lohang} from './lohang';
import {Sanpham} from './sanpham';

@Injectable({
  providedIn: 'root'
})
export class LohangService {

  constructor(private httpClient:HttpClient) { }
  URL_lo="http://localhost:3000/lohangs";
  URL_sp="http://localhost:3000/sanphams";
  getAllLo():Observable<Lohang[]>{
    return this.httpClient.get<Lohang[]>(this.URL_lo)
  }
  findById(id):Observable<Lohang>{
    return this.httpClient.get<Lohang>(this.URL_lo+'/'+id);
  }
  create(lohang){
    return this.httpClient.post(this.URL_lo,lohang);
  }
  deteleById(id){
    return this.httpClient.delete(this.URL_lo+'/'+id);
  }

  getAllsp():Observable<Sanpham[]>{
    return this.httpClient.get<Sanpham[]>(this.URL_sp);
  }
  timkiemtensp(name):Observable<Lohang[]>{
    return this.httpClient.get<Lohang[]>(this.URL_lo+'?sanpham.ten_like='+name);
  }
  timkiemNgayHetHan(date):Observable<Lohang[]>{
    return this.httpClient.get<Lohang[]>(this.URL_lo+'?ngayhethan='+date);
  }
  timkiemtenvangay(name,date){
    return this.httpClient.get<Lohang[]>(this.URL_lo+'?sanpham.ten_like='+name+'&ngayhethan='+date);
  }

  timkiemdatetodate(date1,date2){
    return this.httpClient.get<Lohang[]>(this.URL_lo+'?ngaynhap_gte='+date1+'&ngaynhap_lte='+date2);
  }
  timkiem(name,date,date1,date2){
    return this.httpClient.get<Lohang[]>(this.URL_lo+'?ngaynhap_gte='+date1+'&ngaynhap_lte='+date2+'&sanpham.ten_like='+name+'&ngayhethan='+date);
  }
}
