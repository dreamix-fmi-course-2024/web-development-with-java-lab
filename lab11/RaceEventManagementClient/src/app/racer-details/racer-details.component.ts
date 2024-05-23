import {Component, Input} from '@angular/core';
import {MaterialModule} from "../material/material.module";
import {Racer} from "../racer";

@Component({
  selector: 'app-racer-details',
  standalone: true,
  imports: [MaterialModule],
  templateUrl: './racer-details.component.html',
  styleUrl: './racer-details.component.css'
})
export class RacerDetailsComponent {
  @Input()
  racer: Racer = {} as Racer;

  constructor() {
  }
}
