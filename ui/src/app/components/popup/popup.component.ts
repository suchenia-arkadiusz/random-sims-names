import { Component, Input, OnInit } from '@angular/core';
import { PopupService } from "../../services/popup.service";

@Component({
  selector: 'app-popup',
  templateUrl: './popup.component.html',
  styleUrls: ['./popup.component.scss']
})
export class PopupComponent implements OnInit {
  @Input() isPopupVisible: boolean;

  constructor(private popupService: PopupService) { }

  ngOnInit(): void {
  }

  showPopup() {
    this.isPopupVisible = true;
  }

  closePopup() {
    this.isPopupVisible = false;
  }
}
