import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RegistrationFormComponent } from './registration-form/registration-form.component';
import {MatButtonModule} from '@angular/material/button';
import { HeaderComponent } from './header/header.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatRadioModule} from '@angular/material/radio';
import {MatInputModule} from '@angular/material/input';
import { PizzaOrderComponent } from './pizza-order/pizza-order.component';
import { LoginFormComponent } from './login-form/login-form.component';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatSelectModule} from '@angular/material/select';
import {MatCardModule} from '@angular/material/card';
import { PizzaCatalogueComponent } from './pizza-catalogue/pizza-catalogue.component';

import { HttpClientModule } from '@angular/common/http';
import { PizzaViewComponent } from './pizza-view/pizza-view.component';
import { AddToCartComponent } from './add-to-cart/add-to-cart.component';
import { ShowPizzaComponent } from './show-pizza/show-pizza.component';
import { ShowCartComponent } from './show-cart/show-cart.component';
import { DeletePizzaFromCartComponent } from './delete-pizza-from-cart/delete-pizza-from-cart.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';

@NgModule({
  declarations: [
    AppComponent,
    RegistrationFormComponent,
    HeaderComponent,
    PizzaOrderComponent,
    LoginFormComponent,
    PizzaCatalogueComponent,
    PizzaViewComponent,
    AddToCartComponent,
    ShowPizzaComponent,
    ShowCartComponent,
    DeletePizzaFromCartComponent,
    PageNotFoundComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatToolbarModule,
    MatIconModule,
    ReactiveFormsModule,
    FormsModule,
    MatFormFieldModule,
    MatRadioModule,
    MatInputModule,
    MatSnackBarModule,
    MatSelectModule,
    MatCardModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
