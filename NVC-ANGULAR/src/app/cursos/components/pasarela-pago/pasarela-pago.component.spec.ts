import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PasarelaPagoComponent } from './pasarela-pago.component';

describe('PasarelaPagoComponent', () => {
  let component: PasarelaPagoComponent;
  let fixture: ComponentFixture<PasarelaPagoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PasarelaPagoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PasarelaPagoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
