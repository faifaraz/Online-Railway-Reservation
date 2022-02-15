import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router} from '@angular/router';
import { HttpClientService, Trains } from '../service/http-client.service';
import { TraindataService } from '../service/traindata.service';
import { UserServiceService } from '../service/user-service.service';

// function makeid(length: number) {
//   var result           = '';
//   var characters       = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
//   var charactersLength = characters.length;
//   for ( var i = 0; i < length; i++ ) {
//     result += characters.charAt(Math.floor(Math.random() * 
// charactersLength));
//  }
//  return result;
// }


@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})
export class ReservationComponent implements OnInit {
  [x: string]: any;
  bookSeats=new FormGroup(
    {
      _id: new FormControl('',Validators.required),
      train: new FormControl('',Validators.required),
      startStation: new FormControl('',Validators.required),
      endStation:new FormControl('',Validators.required),
      name:new FormControl('',Validators.required),
      age:new FormControl('',Validators.required),
      gender:new FormControl('',Validators.required),
      credit:new FormControl('',Validators.required),
      address:new FormControl('',Validators.required),
      berth:new FormControl('',Validators.required),
      bankname:new FormControl('',Validators.required),
      date: new FormControl('',Validators.required),
      email: new FormControl('',[Validators.required, Validators.email])

    })
    trains: Trains[]=[];
    constructor(private httpClientService: UserServiceService, private router: Router, private httpClientServic: HttpClientService, private httpClientServi: TraindataService) { }
  
    ngOnInit(): void {
      this.httpClientServic.getTrains().subscribe((result)=>{
        console.warn(result)
        this.trains=result
      })
    }
    
    collectTicks()
    {
      //console.warn(this.addResto.value)
      this.httpClientService.saveTrains(this.bookSeats.value).subscribe((result: any)=>{
      console.warn("result",result);
      (<any>this.router).navigate(["/pnr"])
      alert('Booked your ticket!!')
      })
    }
   
search()
{
 // console.warn(this.editResto.value);
  this.httpClientServi.updateResto(this.text).subscribe((result: any)=>{
    console.warn(result)
    this.trains=result
  })
}

search1()
{
 // console.warn(this.editResto.value);
  this.httpClientServi.updateRest(this.text1).subscribe((result: any)=>{
    console.warn(result)
    this.trains=result
  })
}
  }
    
