import { Component, OnInit } from '@angular/core';
import { AuthService } from "../../services/auth.service";
import { Router } from "@angular/router";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  user= {
    email: '',
    firstname:'',
    lastname:'',
    password:''
  }
  constructor(private authService: AuthService, private router: Router) {

   }

  ngOnInit() {
  }

  signup(){
    this.authService.signUp(this.user).subscribe(resp=>{
      console.log(resp)
      localStorage.setItem('token',resp.token)
      this.router.navigate(['/private/'])
    },err =>{ console.log(err)})
  }
}
