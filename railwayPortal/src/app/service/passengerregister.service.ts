import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

export class userlogin {
  constructor(
    public  username: String,
    public  password: String,
  ) {
  }
}

@Injectable({
  providedIn: 'root'
})
export class PassengerregisterService {

  constructor(private httpClient: HttpClient) {
  }
  saveResto(data: any)
   {
      return this.httpClient.post<userlogin[]>('http://localhost:8888/Secure/subs',data)
   }

}









