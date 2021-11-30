import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DictinaryPageComponent } from './dictinary-page.component';

describe('DictinaryPageComponent', () => {
  let component: DictinaryPageComponent;
  let fixture: ComponentFixture<DictinaryPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DictinaryPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DictinaryPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
