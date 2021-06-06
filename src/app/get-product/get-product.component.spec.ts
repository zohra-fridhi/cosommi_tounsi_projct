import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetProductComponent } from './get-product.component';

describe('GetProductComponent', () => {
  let component: GetProductComponent;
  let fixture: ComponentFixture<GetProductComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetProductComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
