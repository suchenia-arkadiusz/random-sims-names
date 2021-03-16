import { Component, OnInit } from '@angular/core';
import { NameService } from '../../services/name.service';
import { PopupService } from '../../services/popup.service';
import { Name } from '../../data/entities/Name';

@Component({
  selector: 'app-draw-name',
  templateUrl: './draw-name.component.html',
  styleUrls: ['./draw-name.component.scss']
})
export class DrawNameComponent implements OnInit {
  name = '';
  selectedGender = 'MALE';
  private drawnName: Name;

  constructor(private nameService: NameService,
              private popupService: PopupService) { }

  ngOnInit(): void {
  }

  selectName() {
    this.nameService.setNameAsTaken(this.drawnName);
    this.popupService.closePopup();
  }

  drawName() {
    this.nameService.getRandomName(this.selectedGender)
      .subscribe(data =>  {
        this.drawnName = data;
        this.name = this.drawnName.name;
      });
  }
}
