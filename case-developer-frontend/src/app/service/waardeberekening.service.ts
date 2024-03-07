import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Waardeberekening} from "../model/Waardeberekening";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class WaardeberekeningService {

  private readonly endpoint = 'http://localhost:8080/api/waardeberekening';

  constructor(private http: HttpClient) {
  }

  public bereken(pensioenleeftijd: string, deelnemerID: string): Observable<Waardeberekening> {
    const options = {
      params: new HttpParams().set('deelnemerID', deelnemerID).set('pensioenleeftijd', pensioenleeftijd)
    }
    return this.http.get<Waardeberekening>(this.endpoint, options);
  }
}
