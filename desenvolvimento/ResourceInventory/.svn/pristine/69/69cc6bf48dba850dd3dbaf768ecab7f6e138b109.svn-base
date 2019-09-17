import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { AppHeaderView } from './app-header-view.model';

@Injectable({ providedIn: 'root' })
export class ToolbarService {    

  viewName : BehaviorSubject<AppHeaderView> = new BehaviorSubject(null);

  changeViewName(header: AppHeaderView) {
    if (header) {
      this.viewName.next(header);
    }
  }
}