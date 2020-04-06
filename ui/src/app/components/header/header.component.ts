import { Component, OnInit } from '@angular/core';
import { PopupService } from "../../services/popup.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  constructor(private popupService: PopupService) { }

  ngOnInit(): void {
  }

  showPopup(popupName: string) {
    this.popupService.openPopup(popupName);
  }

}
