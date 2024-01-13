import { Component, Input } from '@angular/core';
import { pizza } from 'src/Model/Pizza';
import { AuthService } from '../services/auth.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-show-pizza',
  templateUrl: './show-pizza.component.html',
  styleUrls: ['./show-pizza.component.css']
})


export class ShowPizzaComponent {
  
constructor(private auth:AuthService,private route:Router,private activatedRoute:ActivatedRoute){}


pizzaId: any;
mytoken:any;

ngOnInit(): void{
  const check=localStorage.getItem("Token");
  if(!check){
    this.route.navigateByUrl("/registration-form")
    alert("Please register !!")
  }
  this.activatedRoute.paramMap.subscribe(data=>{
    let id=data.get('pizzaId')??0;
    this.auth.getCard(id).subscribe(data=>{this.pizzaId=data});
    
  })
}

}
