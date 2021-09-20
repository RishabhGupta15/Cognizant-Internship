import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private router:Router){}

  canActivate(
    route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean>  {
    if(this.isloggedIn()){
      console.log("Login true");
      return of(true);
    }
    else{
      alert("you don't have permission to access the page , please login...");
      this.router.navigate(['login']);
      return of(false);
    }
      
  }
  
  isloggedIn(){
    var data=sessionStorage.getItem("loginstatus");
    if(data==="success"){
      return true;
    }else{
      return false;
    }
  }
}
  

