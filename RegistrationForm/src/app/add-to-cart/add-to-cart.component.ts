import { Component, EventEmitter, Input, Output } from '@angular/core';
import { pizza } from 'src/Model/Pizza';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-add-to-cart',
  templateUrl: './add-to-cart.component.html',
  styleUrls: ['./add-to-cart.component.css']
})
export class AddToCartComponent {

  constructor (private auth:AuthService){ }

  // @Input()
  // pizza:any;


  // addToMyCart(){
    
  //   return this.auth.addToMyCart(this.pizza).subscribe((data)=>alert("Note added Successfully"),e=>alert("Network Problem"))
      
  //   }



}

