import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

export class Trains {
  constructor(
    public  train_id: number,
    public  train_name: String,
    public  from: String,
    public  to: String,
    public  fare: number,
    public  berths:number,
  ) {
  }
}

@Injectable({
  providedIn: 'root'
})

export class HttpClientService{
  [x: string]: any;
  constructor(
    private httpClient: HttpClient
  ) { }

  getTrains(){
      console.log('Test Call');
      return this.httpClient.get<Trains[]>('http://localhost:8083/admincontrols/Trains');
  }
  saveTrain(data: any)
  {
     return this.httpClient.post<Trains[]>('http://localhost:8083/admincontrols/Trains',data)
  }
  deleteTrains(id: any)
  {
    return this.httpClient.delete<Trains[]>(`${'http://localhost:8083/admincontrols/Trains'}/${id}`)
  }
  getCurrentResto(id: any)
  {
    return this.httpClient.get<Trains[]>(`${'http://localhost:8083/admincontrols/Trains'}/${id}`)
  }
  updateResto(id: any,data: any)
  {
    return this.httpClient.put<Trains[]>(`${'http://localhost:8083/admincontrols/Trains'}/${id}`,data)
  }
}