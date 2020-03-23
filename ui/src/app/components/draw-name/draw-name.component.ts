import { Component, OnInit } from '@angular/core';
import { NameService } from "../../services/name.service";
import { PopupService } from "../../services/popup.service";
import { Name } from "../../data/entities/Name";

@Component({
  selector: 'app-draw-name',
  templateUrl: './draw-name.component.html',
  styleUrls: ['./draw-name.component.scss']
})
export class DrawNameComponent implements OnInit {
  private name = "";
  private gender = "";
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
    this.nameService.getNames()
      .subscribe((data: Name[]) => {
        let index = Math.floor(Math.random() * data.length);
        this.drawnName = data[index];
        this.name = this.drawnName.name;
        this.gender = this.drawnName.gender === 'MALE' ? 'Mężczyzna' : 'Kobieta';
      });
  }
}
