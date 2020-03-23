import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class PopupService {
  private isVisible: BehaviorSubject<boolean>;
  private isAddNew: BehaviorSubject<boolean>;

  constructor() {
    this.isVisible = new BehaviorSubject<boolean>(false);
    this.isAddNew = new BehaviorSubject<boolean>(true);
  }

  openPopup(popupName) {
    this.isVisible.next(true);
    this.isAddNew.next(popupName === 'add-name');
  }

  closePopup() {
    this.isVisible.next(false);
  }

  isPopupVisible(): Observable<boolean> {
    return this.isVisible.asObservable();
  }

  isAddNewSelected(): Observable<boolean> {
    return this.isAddNew.asObservable();
  }
}
