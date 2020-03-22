import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class PopupService {
  private isVisible: BehaviorSubject<boolean>;

  constructor() {
    this.isVisible = new BehaviorSubject<boolean>(false);
  }

  openPopup() {
    this.isVisible.next(true);
  }

  closePopup() {
    this.isVisible.next(false);
  }

  isPopupVisible(): Observable<boolean> {
    return this.isVisible.asObservable();
  }
}
