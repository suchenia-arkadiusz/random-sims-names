import { Component, OnInit } from '@angular/core';
import { Aspiration } from '../../data/entities/Aspiration';
import { AspirationService } from '../../services/aspiration.service';
import { PopupService } from '../../services/popup.service';

@Component({
  selector: 'app-add-new-aspiration',
  templateUrl: './add-new-aspiration.component.html',
  styleUrls: ['./add-new-aspiration.component.scss']
})
export class AddNewAspirationComponent implements OnInit {
  aspirations: Aspiration[] = [new Aspiration('', '', 'CREATIVITY', '', '', false, false)];

  constructor(private aspirationService: AspirationService,
              private popupService: PopupService) { }

  ngOnInit(): void {
  }

  addAspirations() {
    this.aspirationService.addNewAspiration(this.aspirations);
    this.popupService.closePopup();
  }

  addRow() {
    this.aspirations.push(new Aspiration('', '', 'CREATIVITY', '', '', false, false));
  }
}
