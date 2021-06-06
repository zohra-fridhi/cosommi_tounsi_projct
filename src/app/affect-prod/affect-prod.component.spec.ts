import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AffectProdComponent } from './affect-prod.component';

describe('AffectProdComponent', () => {
  let component: AffectProdComponent;
  let fixture: ComponentFixture<AffectProdComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AffectProdComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AffectProdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
