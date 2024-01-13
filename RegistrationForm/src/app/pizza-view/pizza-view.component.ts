import { Component, EventEmitter, Input, Output } from '@angular/core';
import { pizza } from 'src/Model/Pizza';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';
import { User } from 'src/Model/LoginDetails';

@Component({
  selector: 'app-pizza-view',
  templateUrl: './pizza-view.component.html',
  styleUrls: ['./pizza-view.component.css']
})
export class PizzaViewComponent {

constructor(private auth:AuthService,private route:Router){}


@Input()
pizzaobj:pizza={
  "pizzaId":0,
  "varietyOfPizza":"",
  "priceOfPizza":0,
  "sizeOfPizza":""
}

mytoken:any;
details:User={}

 

addPizzaToCart(){
  const check=localStorage.getItem("Token");
  if(!check){
    this.route.navigateByUrl("/registration-form")
    alert("Please register !!")
  }
console.log(this.pizzaobj);
 this.auth.addToMyCart(this.pizzaobj).subscribe(()=>alert('Pizza Added to cart successfully'));

}


showCard(){
  this.route.navigateByUrl("/show-pizza")
}

}


// logout(){
//   localStorage.setItem("Token","");
//   this.route.navigateByUrl("/pizza-Order")
// }
// this.auth.getToken(this.details).subscribe(
//   { next: data => {
//     this.myToken = data;
//     localStorage.setItem("Token",this.myToken.token);
//     console.log("Token Generated");
//   }}
// )