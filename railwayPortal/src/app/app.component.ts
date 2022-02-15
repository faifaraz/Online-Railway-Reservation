import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'trains';

  constructor(private http: HttpClient) {

  }

  ngOnInit() {
    this.http.get('http://localhost:8083/admincontrols/Trains').subscribe(data => console.log(data));
  }
}
