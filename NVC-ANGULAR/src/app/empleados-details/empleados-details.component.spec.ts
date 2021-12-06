import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpleadosDetailsComponent } from './empleados-details.component';

describe('EmpleadosDetailsComponent', () => {
  let component: EmpleadosDetailsComponent;
  let fixture: ComponentFixture<EmpleadosDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmpleadosDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmpleadosDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
