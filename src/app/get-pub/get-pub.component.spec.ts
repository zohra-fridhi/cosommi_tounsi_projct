import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetPubComponent } from './get-pub.component';

describe('GetPubComponent', () => {
  let component: GetPubComponent;
  let fixture: ComponentFixture<GetPubComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetPubComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetPubComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
