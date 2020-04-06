import { Injectable } from '@angular/core';
import { Name } from "../data/entities/Name";
import { HttpClient } from "@angular/common/http";
import { BehaviorSubject, Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class NameService {
  private readonly MAIN_URL = 'http://localhost:8081/api/v1';
  // private readonly MAIN_URL = '/api/v1';
  private names: BehaviorSubject<Name[]>;

  constructor(private http: HttpClient) {
    this.names = new BehaviorSubject([]);
    this.http.get<Name[]>(`${this.MAIN_URL}/names`)
      .subscribe((data: Name[]) => {
        this.names.next(data);
      });
  }

  addNewName(name: Name) {
    this.http.post(`${this.MAIN_URL}/name`, name, {responseType: 'text'})
      .subscribe(
        (response) => {
          let entries = this.names.getValue();
          entries.push(name);
          this.names.next(entries);
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
      this.http.delete(`${this.MAIN_URL}/name?name=${name.name}`, {responseType: 'text'})
        .subscribe(
          (response) => {
            entries.splice(index, 1);
            this.names.next(entries);
          },
        (error) => console.log(error)
        );
    }
  }

  setNameAsTaken(name: Name) {
    name.isUsed = true;
    this.http.put(`${this.MAIN_URL}/name`, name, {responseType: 'text'})
      .subscribe(
        (response) => {
          let entries = this.names.getValue();
          let index = entries.indexOf(name);
          entries[index] = name;
          this.names.next(entries);
        },
        (error) => console.log(error)
      );
  }

  getRandomName(gender: string): Observable<Name> {
    return this.http.get<Name>(`${this.MAIN_URL}/name?gender=${gender}`);
  }
}
