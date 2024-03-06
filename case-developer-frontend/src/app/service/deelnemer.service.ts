import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Deelnemer} from "../model/Deelnemer";
import {DeelnemerDetails} from "../model/DeelnemerDetails";

@Injectable({
  providedIn: 'root'
})
export class DeelnemerService {

  private readonly endpoint =  'http://localhost:8080/api/deelnemers';

  constructor(private http: HttpClient) {
  }

  public findAll(): Observable<Deelnemer[]> {
    return this.http.get<Deelnemer[]>(this.endpoint);
  }

  public find(deelnemerID: string) {
    return this.http.get<DeelnemerDetails>(this.endpoint + "/" + deelnemerID);
  }
}
