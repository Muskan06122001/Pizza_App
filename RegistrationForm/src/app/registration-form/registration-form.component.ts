import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition } from '@angular/material/snack-bar';
import { confirmPassValidator } from 'src/Validators/ConfirmPasswordValidator';
import { PhoneNoValidator } from 'src/Validators/PhoneNumberValidator';
import { PizzaOrderComponent } from '../pizza-order/pizza-order.component';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration-form',
  templateUrl: './registration-form.component.html',
  styleUrls: ['./registration-form.component.css']
})
export class RegistrationFormComponent implements OnInit {
  
FirstName:string=""
Password:string=""
PhoneNumber:string=""


  constructor(private fb:FormBuilder,private _snackBar: MatSnackBar,private auth:AuthService,private route:Router){}

  durationInSeconds = 5;
  horizontalPosition: MatSnackBarHorizontalPosition = 'start';
  verticalPosition: MatSnackBarVerticalPosition = 'bottom';

  

  openSnackBar() {

    this.auth.register(this.regform.value).subscribe((data)=>console.log(data),e=>alert("Network Problem"));


    this._snackBar.open('Registered Successfully!!', 'Welcome', {
      horizontalPosition: this.horizontalPosition,
      verticalPosition: this.verticalPosition,
      duration: this.durationInSeconds * 1000
    });
       this.route.navigateByUrl("/login-form")
  }

 
  // customerEmailId;
  //   private String customerName;
  //   private String password;
  //   private String mobileNo;
  //   private String address;


  regform=this.fb.group({
       customerName:['',[Validators.required]],
       password:['',[Validators.pattern(/^(?=\D*\d)(?=[^a-z]*[a-z])(?=.*[$@$!%*?&])(?=[^A-Z]*[A-Z]).{8,30}$/),Validators.minLength(8),Validators.required]],
      customerEmailId:['',[Validators.pattern("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9  !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~€£¥₩])(?=.*?[A-Z 0-9]).{8,}$"),Validators.required]],
       mobileNo:['',[PhoneNoValidator,Validators.required]],
        address:['',[Validators.required]]
       
         
  })

  // we will get validators(small v) from the AbstractControl class 
  // we will get Validators(capital V) is a class and required is validation


  get customerNameValidate(){
    return this.regform.get('customerName')
  }
  

  get customerEmailValidator(){
    return  this.regform.get('customerEmailId')
  }

  get PasswordValidator(){
    return this.regform.get('password');
  }

  get MobileNumberValidator(){
    return this.regform.get('mobileNo');
  }

  get addressValidator(){
    return this.regform.get('address');
  }

  
  ngOnInit(){

    this.regform.valueChanges.subscribe(value=>{
      console.log(value);
    })
}

}

