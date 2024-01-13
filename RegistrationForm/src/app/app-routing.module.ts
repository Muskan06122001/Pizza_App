import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PizzaOrderComponent } from './pizza-order/pizza-order.component';
import { RegistrationFormComponent } from './registration-form/registration-form.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { PizzaCatalogueComponent } from './pizza-catalogue/pizza-catalogue.component';
 import { ShowPizzaComponent } from './show-pizza/show-pizza.component';
import { ShowCartComponent } from './show-cart/show-cart.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
// import { unsavedGuard } from './unsaved.guard';

const routes: Routes = [
  {path:'pizza-Order',component:PizzaOrderComponent},
  {path:"",redirectTo:"/pizza-Order",pathMatch:"full"},
  {path:'registration-form',component:RegistrationFormComponent},
  {path:'login-form',component:LoginFormComponent},
  {path:'pizza-Catalogue',component:PizzaCatalogueComponent},
  {path:'show-pizza/:pizzaId',component:ShowPizzaComponent},
  {path:'show-cart',component:ShowCartComponent},
  {path:"**",component:PageNotFoundComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

// {path:'show-pizza/:pizzaId',component:ShowPizzaComponent}
