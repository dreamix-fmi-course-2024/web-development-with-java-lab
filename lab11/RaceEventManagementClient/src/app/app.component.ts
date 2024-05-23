import {ChangeDetectorRef, Component} from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {MatCard, MatCardActions, MatCardContent, MatCardHeader} from "@angular/material/card";
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import {CommonModule} from "@angular/common";
import {HttpClient} from "@angular/common/http";
import {MaterialModule} from "./material/material.module";
import {RacerNewComponent} from "./racer-new/racer-new.component";
import {RacerDetailsComponent} from "./racer-details/racer-details.component";
import {RacerService} from "./racer.service";
import {Racer} from "./racer";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, MaterialModule, CommonModule, RacerNewComponent, RacerDetailsComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'RaceEventManagementClient';
  racers: Racer[] = []
  show: any = false;
  constructor(private http: HttpClient, private racerService: RacerService, private cd: ChangeDetectorRef) {
  }

  findAllRacers() {
    this.racerService.findAll().subscribe((result: Racer[]) => {

      this.racers = result;
      this.cd.detectChanges();
    })
  }
}
