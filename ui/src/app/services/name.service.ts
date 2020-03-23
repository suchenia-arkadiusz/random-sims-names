import { Injectable } from '@angular/core';
import { Name } from "../data/entities/Name";

@Injectable({
  providedIn: 'root'
})
export class NameService {
  private names: Name[] = [];

  constructor() { }

  addNewName(name: Name) {
    this.names.push(name);
  }

  getNames(): Name[] {
    return this.names;
  }

  deleteName(index: number) {
    if (index > -1) {
      this.names.splice(index, 1);
    }
  }
}
