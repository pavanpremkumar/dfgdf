import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
user:number;
pwd:string;
emp:number;
  constructor(private router : Router) {
    this.user=parseInt(localStorage.getItem("empId"));
  }
login() {
  if(this.user == parseInt(localStorage.getItem("empId")) && this.pwd == "114"){
    this.router.navigate(["/DashBoard"]);
  } else if(this.user == 1000 && this.pwd == localStorage.getItem("spwd")) {
    this.router.navigate(["/DashBoard"]);
  }else if(this.user == 2000 && this.pwd == localStorage.getItem("kpwd")) {
    this.router.navigate(["/DashBoard"]);
  }else if(this.user == 3000 && this.pwd == localStorage.getItem("mpwd")) {
    this.router.navigate(["/DashBoard"]);
  }else if(this.user == 4000 && this.pwd == localStorage.getItem("npwd")) {
    this.router.navigate(["/DashBoard"]);
  }else if(this.user == 5000 && this.pwd == localStorage.getItem("nipwd")) {
    this.router.navigate(["/DashBoard"]);
  } else {
    alert("Invalid Credentials...");
  }
}
pswd(){
  this.router.navigate(["/pswdC"]);
  this.pwd = localStorage.getItem("pwsd");
}
  ngOnInit() {
  }

}