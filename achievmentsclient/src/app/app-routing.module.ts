import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AuthorizationComponent} from "./pages/authorization/authorization.component";
import {MainComponent} from "./pages/main/main.component";
import {RegisterComponent} from "./pages/register/register.component";

const routes: Routes = [
  {path: 'auth', component: AuthorizationComponent},
  {path: 'main', component: MainComponent},
  {path: 'register', component: RegisterComponent},
  {path: '', redirectTo: '/auth', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
