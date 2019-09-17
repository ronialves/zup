import { Component } from '@angular/core';
import { ToolbarService } from './toolbar/toolbar.service';
import { Observable } from 'rxjs';
import { AppHeaderView } from './toolbar/app-header-view.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  navOpen = true;
  header: AppHeaderView;

  constructor(private toolbarService: ToolbarService) {
    this.toolbarService.viewName.subscribe(header => { this.header = header; });
  }

  doLogout() {
  }
}