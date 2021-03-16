import { Component, OnInit } from '@angular/core';
import { AspirationService } from '../../services/aspiration.service';
import { Aspiration } from '../../data/entities/Aspiration';

@Component({
  selector: 'app-draw-aspiration',
  templateUrl: './draw-aspiration.component.html',
  styleUrls: ['./draw-aspiration.component.scss']
})
export class DrawAspirationComponent implements OnInit {
  drawnAspiration = new Aspiration();
  checkedAge = 'adult';

  constructor(private aspirationService: AspirationService) { }

  ngOnInit(): void {
  }

  drawAspiration() {
    switch (this.checkedAge) {
      case 'adult':
        this.aspirationService.getAspirationForAdult()
          .subscribe(aspiration => {
            this.drawnAspiration = aspiration;
          });
        break;
      case 'teenager':
        this.aspirationService.getAspirationForTeenager()
          .subscribe(aspiration => {
            this.drawnAspiration = aspiration;
          });
        break;
      case 'child':
        this.aspirationService.getAspirationForChild()
          .subscribe(aspiration => {
            this.drawnAspiration = aspiration;
          });
        break;
    }
  }
}
