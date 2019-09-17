import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToolbarService } from '../toolbar/toolbar.service';
import { AppHeaderView } from '../toolbar/app-header-view.model';

@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor(public router: Router, private toolbarService: ToolbarService) { 
  }

  ngOnInit() {    
    let headerView = new AppHeaderView();
    headerView.title = "CPE Inventory";
    headerView.icon = "fa fa-home";
    this.toolbarService.changeViewName(headerView);
  }

}