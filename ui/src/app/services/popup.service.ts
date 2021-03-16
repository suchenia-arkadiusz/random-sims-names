import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PopupService {
  private isVisible: BehaviorSubject<boolean>;
  private isAddNew: BehaviorSubject<boolean>;
  private isDrawName: BehaviorSubject<boolean>;
  private isAddNewAspiration: BehaviorSubject<boolean>;
  private isDrawAspiration: BehaviorSubject<boolean>;

  constructor() {
    this.isVisible = new BehaviorSubject<boolean>(false);
    this.isAddNew = new BehaviorSubject<boolean>(true);
    this.isDrawName = new BehaviorSubject<boolean>(false);
    this.isAddNewAspiration = new BehaviorSubject<boolean>(false);
    this.isDrawAspiration = new BehaviorSubject<boolean>(false);
  }

  openPopup(popupName) {
    this.isVisible.next(true);
    this.isAddNew.next(popupName === 'add-name');
    this.isDrawName.next(popupName === 'draw-name');
    this.isAddNewAspiration.next(popupName === 'add-aspiration');
    this.isDrawAspiration.next(popupName === 'draw-aspiration');
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

  isDrawNameSelected(): Observable<boolean> {
    return this.isDrawName.asObservable();
  }

  isAddNewAspirationSelected(): Observable<boolean> {
    return this.isAddNewAspiration.asObservable();
  }

  isDrawAspirationSelected(): Observable<boolean> {
    return this.isDrawAspiration.asObservable();
  }
}
