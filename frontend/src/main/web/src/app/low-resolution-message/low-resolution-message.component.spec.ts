import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {LowResolutionMessageComponent} from './low-resolution-message.component';

describe('LowResolutionMessageComponent', () => {
  let component: LowResolutionMessageComponent;
  let fixture: ComponentFixture<LowResolutionMessageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [LowResolutionMessageComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LowResolutionMessageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
