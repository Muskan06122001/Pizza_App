import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { User } from 'src/Model/LoginDetails';
import { AuthService } from '../services/auth.service';
import { NotExpr } from '@angular/compiler';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent {

  

  panelOpenState = false;
  status:boolean=false;
  details:User={}

  constructor (private _snackBar: MatSnackBar,private route:Router,private auth:AuthService){ }


  durationInSeconds = 5;
  horizontalPosition: MatSnackBarHorizontalPosition = 'start';
  verticalPosition: MatSnackBarVerticalPosition = 'bottom';

  
  openSnackBar() {
    this._snackBar.open('Login Successfully!!', 'Welcome to CrisPizza', {
      horizontalPosition: this.horizontalPosition,
      verticalPosition: this.verticalPosition,
      duration: this.durationInSeconds * 1000
    });
  }

myToken:any;

submit(){
  this.auth.getToken(this.details).subscribe(
    
    { next: data => {
      this.myToken = data;
      localStorage.setItem("Token",this.myToken.token);
      console.log("Token Generated");
      console.log(data)
    }}
  )

   this.route.navigateByUrl('/pizza-Catalogue')
 
}

// showCatalogue(){
//  this.route.navigateByUrl('/pizza-Catalogue')
// }

}
