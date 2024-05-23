import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RacerDetailsComponent } from './racer-details.component';

describe('RacerDetailsComponent', () => {
  let component: RacerDetailsComponent;
  let fixture: ComponentFixture<RacerDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RacerDetailsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RacerDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
