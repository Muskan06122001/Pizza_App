import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PizzaViewComponent } from './pizza-view.component';

describe('PizzaViewComponent', () => {
  let component: PizzaViewComponent;
  let fixture: ComponentFixture<PizzaViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PizzaViewComponent]
    });
    fixture = TestBed.createComponent(PizzaViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
