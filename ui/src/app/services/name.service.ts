import { Injectable } from '@angular/core';
import { Name } from "../data/entities/Name";
import { HttpClient } from "@angular/common/http";
import { BehaviorSubject, Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class NameService {
  private readonly MAIN_URL = 'http://localhost:8080/api/v1';
  // private readonly MAIN_URL = '/api/v1';                            // use this address for production
  private names: BehaviorSubject<Name[]>;

  constructor(private http: HttpClient) {
    this.names = new BehaviorSubject([]);
    this.http.get<Name[]>(`${this.MAIN_URL}/names`)
      .subscribe((data: Name[]) => {
        this.names.next(data);
      });
  }

  addNewName(names: Name[]) {
    this.http.post<Name[]>(`${this.MAIN_URL}/names`, names)
      .subscribe(
        (response) => {
          this.names.next(response);
        },
        (error) => console.log(error)
      );
  }

  getNames(): Observable<Name[]> {
    return this.names.asObservable();
  }

  deleteName(name: Name) {
    let entries = this.names.getValue();
    let index = entries.indexOf(name);
    if (index > -1) {
      this.http.delete<Name[]>(`${this.MAIN_URL}/names?name=${name.name}`)
        .subscribe(
          (response) => {
            this.names.next(response);
          },
        (error) => console.log(error)
        );
    }
  }

  setNameAsTaken(name: Name) {
    name.isUsed = true;
    this.http.put<Name[]>(`${this.MAIN_URL}/names`, name)
      .subscribe(
        (response) => {
          this.names.next(response);
        },
        (error) => console.log(error)
      );
  }

  getRandomName(gender: string): Observable<Name> {
    return this.http.get<Name>(`${this.MAIN_URL}/names?gender=${gender}`);
  }
}
