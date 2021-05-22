import {Injectable} from '@angular/core';
import { Cookie } from 'ng2-cookies';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { throwError } from 'rxjs';
 
export class Student {
  constructor(
    public age: number,
    public name: string) { }
} 

@Injectable()
export class AppService {
   public clientId = 'newClient';
   public redirectUri = 'http://localhost:8089/';

  constructor(
    private _http: HttpClient){}

  retrieveToken(code:any){
    let params = new URLSearchParams();   
    params.append('grant_type','authorization_code');
    params.append('client_id', this.clientId);
    params.append('client_secret', 'newClientSecret');
    params.append('redirect_uri', this.redirectUri);
    params.append('code',code);

    let headers = new HttpHeaders({'Content-type': 'application/x-www-form-urlencoded; charset=utf-8'});
     this._http.post('http://localhost:8083/auth/realms/baeldung/protocol/openid-connect/token', params.toString(), { headers: headers })
    .subscribe(
      data => { this.saveToken(data); console.log(data)},
      err => alert('Invalid Credentials')
    ); 
  }

  saveToken(token:any){
    var expireDate = new Date().getTime() + (1000 * token.expires_in);
    Cookie.set("access_token", token.access_token, expireDate);
    Cookie.set("id_token", token.id_token, expireDate);
    console.log('Obtained Access token');
    window.location.href = 'http://localhost:8089';
  }

  getResource(resourceUrl:any) : Observable<any>{
    var headers = new HttpHeaders({'Content-type': 'application/x-www-form-urlencoded; charset=utf-8', 'Authorization': 'Bearer '+Cookie.get('access_token')});
    return this._http.get(resourceUrl, { headers: headers }).pipe(
        catchError((err) => {
          console.log('error caught in service')
          console.error(err);
 
          //Handle the error here
 
          return throwError(err);    //Rethrow it back to component
        })
      )
  }

  addStudent(resourceUrl:any, body:any) : Observable<any>{
    var headers = new HttpHeaders({'Content-type': 'application/json; charset=utf-8', 'Authorization': 'Bearer '+Cookie.get('access_token')});
    return this._http.post(resourceUrl,  JSON.stringify(body) ,{ headers: headers }).pipe(
        catchError((err) => {
          console.log('error caught in service')
          console.error(err);
          //Handle the error here
          return throwError(err);    //Rethrow it back to component
        }))
  }

  editStudent(resourceUrl:any, body:any) : Observable<any>{
    var headers = new HttpHeaders({'Content-type': 'application/json; charset=utf-8', 'Authorization': 'Bearer '+Cookie.get('access_token')});
    return this._http.put(resourceUrl,  JSON.stringify(body) , { headers: headers }).pipe(
      map((resdd) => {
          return resdd;
        }),
        catchError((err) => {
          console.log('error caught in service')
          console.error(err);
          //Handle the error here
          return throwError(err);    //Rethrow it back to component
        }))
  }

  checkCredentials(){
    return Cookie.check('access_token');
  }

  logout() {
    let token = Cookie.get('id_token');
    Cookie.delete('access_token');
    Cookie.delete('id_token');
    let logoutURL = "http://localhost:8083/auth/realms/baeldung/protocol/openid-connect/logout?id_token_hint="
      + token
      + "&post_logout_redirect_uri=" + this.redirectUri;

    window.location.href = logoutURL;
  } 
}