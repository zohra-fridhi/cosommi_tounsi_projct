import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SideBarComponentComponent } from './side-bar-component.component';

describe('SideBarComponentComponent', () => {
  let component: SideBarComponentComponent;
  let fixture: ComponentFixture<SideBarComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SideBarComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SideBarComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
