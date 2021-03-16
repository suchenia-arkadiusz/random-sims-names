import { Component, OnInit } from '@angular/core';
import { AspirationService } from '../../services/aspiration.service';
import { Aspiration } from '../../data/entities/Aspiration';

@Component({
  selector: 'app-aspirations-page',
  templateUrl: './aspirations-page.component.html',
  styleUrls: ['./aspirations-page.component.scss']
})
export class AspirationsPageComponent implements OnInit {
  aspirations: Aspiration[] = [];

  constructor(private aspirationService: AspirationService) { }

  ngOnInit(): void {
    this.aspirationService.getAspirations()
      .subscribe((data: Aspiration[]) => {
        this.aspirations = data;
      });
  }

  deleteAspiration(index: number) {
    this.aspirationService.deleteAspiration(this.aspirations[index]);
  }
}
