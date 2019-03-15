import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-password-correct',
  templateUrl: './password-correct.component.html',
  styleUrls: ['./password-correct.component.css']
})
export class PasswordCorrectComponent implements OnInit {
  pwdj:string;
  spwd:string;
  kpwd:string;
  mpwd:string;
  npwd:string;
  nipwd:string;
  epwd :number;
  empN :string;

  constructor( private router : Router) { }
 
  Change(pwdn){
    this.epwd = parseInt(localStorage.getItem("empId"));
  
       localStorage.setItem("pwdn",pwdn);
this.pwdj = localStorage.getItem("pwdn");
if(this.epwd == 1000){
   this.spwd = this.pwdj;
   localStorage.setItem("spwd",this.spwd);
  
}else if(this.epwd == 2000){
  this.kpwd = this.pwdj;
  localStorage.setItem("kpwd",this.kpwd);

}else if(this.epwd == 3000){
  this.mpwd = this.pwdj;
  localStorage.setItem("mpwd",this.mpwd);
}else if(this.epwd == 4000){
  this.npwd = this.pwdj;
  localStorage.setItem("npwd",this.npwd);
}else{
  this.nipwd = this.pwdj;
  localStorage.setItem("nipwd",this.nipwd);
}

    this.router.navigate(["/login"]);

}  


  ngOnInit() {
  }

}
