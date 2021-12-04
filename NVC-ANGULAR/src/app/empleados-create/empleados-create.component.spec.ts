import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpleadoCreateComponent } from './empleados-create.component';

describe('EmpleadosCreateComponent', () => {
  let component: EmpleadosCreateComponent;
  let fixture: ComponentFixture<EmpleadosCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmpleadosCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmpleadosCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
