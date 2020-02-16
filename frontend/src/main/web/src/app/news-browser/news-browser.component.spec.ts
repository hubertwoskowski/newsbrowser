import {HttpClientTestingModule} from '@angular/common/http/testing';
import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {ArticleTileComponent} from '../article-tile/article-tile.component';
import {LowResolutionMessageComponent} from '../low-resolution-message/low-resolution-message.component';
import {NewsBrowserComponent} from './news-browser.component';

describe('NewsBrowserComponent', () => {
  let component: NewsBrowserComponent;
  let fixture: ComponentFixture<NewsBrowserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        NewsBrowserComponent,
        ArticleTileComponent,
        LowResolutionMessageComponent
      ],
      imports: [
        HttpClientTestingModule
      ]
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
