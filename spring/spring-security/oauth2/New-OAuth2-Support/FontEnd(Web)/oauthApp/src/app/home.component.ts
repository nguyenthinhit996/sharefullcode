import {Component} from '@angular/core';
import {AppService} from './app.service'

@Component({
    selector: 'home-header',
    providers: [AppService],
  template: `<div class="container" >
    <button *ngIf="!isLoggedIn" class="btn btn-primary" (click)="login()" type="submit">Login</button>
    <div *ngIf="isLoggedIn" class="content">
        <span>Welcome !!</span>
        <a class="btn btn-default pull-right"(click)="logout()" href="#">Logout</a>
        <br/>
        <foo-details></foo-details>
    </div>
</div>`
})
 
export class HomeComponent {
     public isLoggedIn = false;

    constructor(private _service:AppService){}
 
    ngOnInit(){
        this.isLoggedIn = this._service.checkCredentials();    
        let i = window.location.href.indexOf('code');
        console.log("code: "+window.location.href);
        if(!this.isLoggedIn && i != -1){
            this._service.retrieveToken(window.location.href.substring(i + 5));
        }
    }

    login() {
        window.location.href =
         'http://localhost:8083/auth/realms/baeldung/protocol/openid-connect/auth?response_type=code&&scope=openid%20read%20write&client_id=' + 
          this._service.clientId + '&redirect_uri='+ this._service.redirectUri;

          // login thanh công sẽ đi đến redirect_uri (http://localhost:8089) chính là page này luôn lúc này sẽ nhảy vào ngOnInit để lấy token
          // http://localhost:8089/ là trang home do app.module.ts quy định
        }
 
    logout() {
        this._service.logout();
    }
}