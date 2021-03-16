import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Aspiration } from '../data/entities/Aspiration';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AspirationService {
  private readonly MAIN_URL = 'http://localhost:8080/api/v1/aspirations';
  // private readonly MAIN_URL = '/api/v1';                             // use this address for production
  private aspirations: BehaviorSubject<Aspiration[]>;

  constructor(private http: HttpClient) {
    this.aspirations = new BehaviorSubject([]);
    this.http.get<Aspiration[]>(this.MAIN_URL)
      .subscribe((data: Aspiration[]) => {
        this.aspirations.next(data);
      });
  }

  addNewAspiration(aspirations: Aspiration[]) {
    this.http.post<Aspiration[]>(this.MAIN_URL, aspirations)
      .subscribe((response) => {
        this.aspirations.next(response);
      }, error => console.error(error));
  }

  getAspirations(): Observable<Aspiration[]> {
    return this.aspirations.asObservable();
  }

  deleteAspiration(aspiration: Aspiration) {
    const entries = this.aspirations.getValue();
    const index = entries.indexOf(aspiration);
    if (index > -1) {
      this.http.delete<Aspiration[]>(`${this.MAIN_URL}/${aspiration.name}`)
        .subscribe((response) => {
          this.aspirations.next(response);
        }, error => console.error(error));
    }
  }

  getAspirationForChild(): Observable<Aspiration> {
    return this.http.get<Aspiration>(`${this.MAIN_URL}/random?isChild=true`);
  }

  getAspirationForTeenager(): Observable<Aspiration> {
    return this.http.get<Aspiration>(`${this.MAIN_URL}/random?isTeenager=true`);
  }

  getAspirationForAdult(): Observable<Aspiration> {
    return this.http.get<Aspiration>(`${this.MAIN_URL}/random`);
  }
}
