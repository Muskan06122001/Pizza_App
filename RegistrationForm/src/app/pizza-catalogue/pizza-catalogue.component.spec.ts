import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PizzaCatalogueComponent } from './pizza-catalogue.component';

describe('PizzaCatalogueComponent', () => {
  let component: PizzaCatalogueComponent;
  let fixture: ComponentFixture<PizzaCatalogueComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PizzaCatalogueComponent]
    });
    fixture = TestBed.createComponent(PizzaCatalogueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
