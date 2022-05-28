import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InvigilateComponent } from './invigilate.component';

describe('InvigilateComponent', () => {
  let component: InvigilateComponent;
  let fixture: ComponentFixture<InvigilateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InvigilateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InvigilateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
