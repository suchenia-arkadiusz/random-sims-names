import { Component, OnInit } from '@angular/core';
import { Name } from '../../data/entities/Name';
import { NameService } from '../../services/name.service';

@Component({
  selector: 'app-names-page',
  templateUrl: './names-page.component.html',
  styleUrls: ['./names-page.component.scss']
})
export class NamesPageComponent implements OnInit {
  femaleNames: Name[] = [];
  maleNames: Name[] = [];

  constructor(private nameService: NameService) {
  }

  ngOnInit(): void {
    this.nameService.getNames()
      .subscribe((data: Name[]) =>  {
        this.femaleNames = data.filter(element => element.gender === 'FEMALE');
        this.maleNames = data.filter(element => element.gender === 'MALE');
      });
  }

  deleteFemaleName(index: number) {
    this.nameService.deleteName(this.femaleNames[index]);
  }

  deleteMaleName(index: number) {
    this.nameService.deleteName(this.maleNames[index]);
  }

}
