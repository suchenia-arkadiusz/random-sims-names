import { Component, OnInit } from '@angular/core';
import { PopupService } from "../../services/popup.service";

@Component({
  selector: 'app-popup',
  templateUrl: './popup.component.html',
  styleUrls: ['./popup.component.scss']
})
export class PopupComponent implements OnInit {
  isPopupVisible: boolean;
  isAddNameSelected: boolean;

  constructor(private popupService: PopupService) { }

  ngOnInit(): void {
    this.popupService.isPopupVisible()
      .subscribe(value => this.isPopupVisible = value);
    this.popupService.isAddNewSelected()
      .subscribe(value => this.isAddNameSelected = value);
  }

  closePopup() {
    this.popupService.closePopup();
  }
}
