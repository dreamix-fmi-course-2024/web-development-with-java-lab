import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RacerNewComponent } from './racer-new.component';

describe('RacerNewComponent', () => {
  let component: RacerNewComponent;
  let fixture: ComponentFixture<RacerNewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RacerNewComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RacerNewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
