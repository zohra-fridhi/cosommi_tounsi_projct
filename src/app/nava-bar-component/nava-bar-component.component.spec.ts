import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NavaBarComponentComponent } from './nava-bar-component.component';

describe('NavaBarComponentComponent', () => {
  let component: NavaBarComponentComponent;
  let fixture: ComponentFixture<NavaBarComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NavaBarComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NavaBarComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
