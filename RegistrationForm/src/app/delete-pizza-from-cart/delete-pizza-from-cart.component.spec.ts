import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeletePizzaFromCartComponent } from './delete-pizza-from-cart.component';

describe('DeletePizzaFromCartComponent', () => {
  let component: DeletePizzaFromCartComponent;
  let fixture: ComponentFixture<DeletePizzaFromCartComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DeletePizzaFromCartComponent]
    });
    fixture = TestBed.createComponent(DeletePizzaFromCartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
