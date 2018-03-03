import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class ColorService {

  constructor(private httpClient: HttpClient) { }

  getColors(): Observable<any> {
    return this.httpClient.get<any>('http://localhost:8080/V1/items');
  }
}
