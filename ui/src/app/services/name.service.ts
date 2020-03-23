import { Injectable } from '@angular/core';
import { Name } from "../data/entities/Name";

@Injectable({
  providedIn: 'root'
})
export class NameService {
  private names: Name[] = [];

  constructor() { }

  addNewName(name: Name) {
    console.log(name);
    this.names.push(name);
  }

  getNames(): Name[] {
    return this.names;
  }
}
