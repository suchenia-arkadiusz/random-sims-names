import { Component, OnInit } from '@angular/core';
import { PopupService } from '../../services/popup.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  pageName: string;

  constructor(private popupService: PopupService,
              private router: Router) { }

  ngOnInit(): void {
    this.pageName = this.router.url;
  }

  showPopup(popupName: string) {
    this.popupService.openPopup(popupName);
  }

}
