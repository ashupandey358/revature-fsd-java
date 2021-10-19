import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  usersUrl : string = "https://reqres.in/api/users/1";


  constructor(private httpClient : HttpClient) { }
}
