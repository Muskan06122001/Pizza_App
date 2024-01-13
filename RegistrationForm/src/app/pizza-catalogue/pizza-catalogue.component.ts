import { Component, Input } from '@angular/core';
// import { PIZZA } from 'src/Model/PizzaDetails';
import { AuthService } from '../services/auth.service';
import { pizza } from 'src/Model/Pizza';
import { HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
// import { PIZZA } from 'src/Model/PizzaDetails';

@Component({
  selector: 'app-pizza-catalogue',
  templateUrl: './pizza-catalogue.component.html',
  styleUrls: ['./pizza-catalogue.component.css']
})

export class PizzaCatalogueComponent   {

constructor(private auth:AuthService,private route:Router){}

  p:any; 
  searchPizzaName:string="";
  cart:pizza[]=[];
  pizza:any;

 ngOnInit(){
    
     this.auth.showCatalogue().subscribe(data=>this.p=data);
     console.log(this.p);

  }

  newMyCart(){
    this.route.navigateByUrl("/show-cart");
  }
  
 
}
