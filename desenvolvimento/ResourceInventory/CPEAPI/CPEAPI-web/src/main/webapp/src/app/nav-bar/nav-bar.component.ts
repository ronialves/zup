import { Component, Input } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { AppComponent } from '../app.component';
import { NavBarState } from './nav-bar-state.model';


@Component({
  selector: 'nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.scss']
})

export class NavBarComponent {
  @Input()
  retracted: boolean;
  
  states: Array<NavBarState> = [
    new NavBarState("Consultar Equipamentos", "/catalogo", "fas fa-stream", false),
    new NavBarState("Inserir Equipamento", "/catalogo/novo", "fas fa-hdd", false)
  ];
  
  constructor(public router: Router, public appComponent: AppComponent) {

    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        let url = event.urlAfterRedirects;
        this.states.forEach(state => {
          state.active = state.name === url;
        });
      }
    });
  }
}