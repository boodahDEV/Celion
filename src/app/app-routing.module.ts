import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuard } from "./auth.guard";

import { SigninComponent } from './components/signin/signin.component'
import { SignupComponent } from './components/signup/signup.component'
import { SettingComponent } from "./components/setting/setting.component";
import { DashboardComponent } from "./components/dashboard/dashboard.component";
import { ChestComponent } from "./components/chest/chest.component";
import { PrivateChestsComponent } from "./components/private-chests/private-chests.component";

const routes: Routes = [
  {
    path:'',
    redirectTo:'/dashboard',
    pathMatch: 'full'
  },
  {
    path:'settings',
    component:SettingComponent
  },
  {
    path:'dashboard',
    component:DashboardComponent
  },
  {
    path:'chest',
    component:ChestComponent
  },
  {
    path:'private-chest',
    component:PrivateChestsComponent,
    canActivate:[AuthGuard]
  },
  {
    path:'signup',
    component:SignupComponent
  },
  {
    path:'signin',
    component:SigninComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
