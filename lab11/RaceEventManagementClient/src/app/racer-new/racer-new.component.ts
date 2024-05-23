import { Component } from '@angular/core';
import {MaterialModule} from "../material/material.module";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {FormBuilder, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {RacerService} from "../racer.service";

@Component({
  selector: 'app-racer-new',
  standalone: true,
  imports: [MaterialModule, ReactiveFormsModule],
  templateUrl: './racer-new.component.html',
  styleUrl: './racer-new.component.css'
})
export class RacerNewComponent {
  racerForm: FormGroup =  this.fb.group({
    name: ['Racer'],
    lastName: ['Racer1 '],
    age: [0]
  })

  constructor(private  fb : FormBuilder,
              private racerService: RacerService) {
  }

  createRacer() {
    // alert(JSON.stringify(this.racerForm.value))
    this.racerService.createRacer(this.racerForm.value).subscribe();
  }
}
