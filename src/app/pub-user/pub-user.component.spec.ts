import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PubUserComponent } from './pub-user.component';

describe('PubUserComponent', () => {
  let component: PubUserComponent;
  let fixture: ComponentFixture<PubUserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PubUserComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PubUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
