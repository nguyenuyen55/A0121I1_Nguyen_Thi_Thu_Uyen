import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DictinaryDetailComponent } from './dictinary-detail.component';

describe('DictinaryDetailComponent', () => {
  let component: DictinaryDetailComponent;
  let fixture: ComponentFixture<DictinaryDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DictinaryDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DictinaryDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
