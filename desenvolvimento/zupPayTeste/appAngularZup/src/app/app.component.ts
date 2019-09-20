import { Component } from '@angular/core';

@Component({
   
  selector: 'app-root',
  template: `
    <nav class="navbar">

      <!-- logo -->
      <div class="navbar-brand">
        <a class="navbar-item">
          <img src="assets/img/logo_zuppay.png">
        </a>
      </div>
    </nav>
  `,
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'appAngularZup';
}
