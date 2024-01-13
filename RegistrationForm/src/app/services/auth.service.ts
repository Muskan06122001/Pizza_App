import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subscriber } from 'rxjs';
import { User } from 'src/Model/LoginDetails';
import { pizza } from 'src/Model/Pizza';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http:HttpClient) {  }


    pizzas:pizza={
      "pizzaId":0,
      "varietyOfPizza":"",
      "priceOfPizza":0,
      "sizeOfPizza":""
    }

    pizza=[{
      "pizzaId":0,
      "varietyOfPizza":"",
      "priceOfPizza":0,
      "sizeOfPizza":""
    }]

  getToken(login:User){
  return this.http.post("http://localhost:8083/api/v1/userAuth",login);
  }

  register(user:any){
   return this.http.post("http://localhost:6063/api/v2/saveDetails",user);
  }

  viewCart():Observable<pizza[]>{
    let HttpHeader=new HttpHeaders(
      {
        'Authorization':'Bearer '+localStorage.getItem('Token')
      }
    );
    let requestOptions={headers:HttpHeader}
     return this.http.get<pizza[]>("http://localhost:6063/api/v2/showCart",requestOptions);
  }

  showCatalogue():Observable<pizza[]>{
    return this.http.get<pizza[]>("http://localhost:6063/api/v2/viewCatalogue");
  }

// after

  addToMyCart(pizza:any){
    console.log("serviceeeeee")
    let HttpHeader=new HttpHeaders(
      {
        'Authorization':'Bearer '+localStorage.getItem('Token')
      }
    );
    let requestOptions={headers:HttpHeader}
    return this.http.post("http://localhost:6063/api/v2/addToCart",pizza,requestOptions);
  }


  addPizzaInCatalogue(pizza:pizza){

    let HttpHeader=new HttpHeaders(
      {
        'Authorization':'Bearer '+localStorage.getItem('Token')
      }
    );
    let requestOptions={headers:HttpHeader}
      return this.http.post("/addPizza",pizza,requestOptions)
  }

  getCard(cardId: any): Observable<any> {
    let HttpHeader=new HttpHeaders(
      {
        'Authorization':'Bearer '+localStorage.getItem('Token')
      }
    );
    let requestOptions={headers:HttpHeader}
    const url = `http://localhost:6063/api/v2/showCard/${cardId}`;
    return this.http.get(url,requestOptions);
  }


  deleteFromCart(pizzaName:any):Observable<any>{
    let HttpHeader=new HttpHeaders(
      {
        'Authorization':'Bearer '+localStorage.getItem('Token')
      }
    );
    let requestOptions={headers:HttpHeader}
    const url=`http://localhost:6063/api/v2/cancelOrder/${pizzaName}`
    return this.http.delete(url,requestOptions)
  }
}
