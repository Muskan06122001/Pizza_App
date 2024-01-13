import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-show-cart',
  templateUrl: './show-cart.component.html',
  styleUrls: ['./show-cart.component.css']
})
export class ShowCartComponent {


  constructor(private auth:AuthService,private route:Router){}

  pizza:any;
  mytoken:any;
  ngOnInit(){
    const check=localStorage.getItem("Token");
     if(!check){
    this.route.navigateByUrl("/registration-form")
    alert("Please register !!")
  }
    console.log(this.pizza);
    this.auth.viewCart().subscribe(data=>this.pizza=data); 
  }

  deletePizzaFromCart(pizzaName:any){
   this.auth.deleteFromCart(pizzaName).subscribe(data=>{this.pizza=data
    this.route.navigateByUrl("/pizza-Catalogue"),alert("Pizza Removed from your cart successfully !!!")
   })
  }

}
