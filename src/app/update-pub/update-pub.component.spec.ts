import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatePubComponent } from './update-pub.component';

describe('UpdatePubComponent', () => {
  let component: UpdatePubComponent;
  let fixture: ComponentFixture<UpdatePubComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdatePubComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdatePubComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
