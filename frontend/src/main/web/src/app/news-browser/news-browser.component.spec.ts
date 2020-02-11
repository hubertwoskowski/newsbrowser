import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {NewsBrowserComponent} from './news-browser.component';

describe('NewsBrowserComponent', () => {
  let component: NewsBrowserComponent;
  let fixture: ComponentFixture<NewsBrowserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [NewsBrowserComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewsBrowserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
