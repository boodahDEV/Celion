import { Component } from '@angular/core';
import { AuthService } from "./services/auth.service";
import { NbMenuService } from '@nebular/theme';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  auth:any
  items = [
    { title: 'Configurar', icon: 'settings-2-outline' },
    { title: 'Salir',  icon: 'log-out-outline', },
  ];
  userMenu = [ { title: 'Log out' } ];

  constructor(private authService: AuthService , private menuService: NbMenuService){
    this.auth = authService
  }
}
