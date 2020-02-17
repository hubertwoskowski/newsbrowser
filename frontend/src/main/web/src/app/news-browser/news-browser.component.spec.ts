import {HttpClientTestingModule} from '@angular/common/http/testing';
import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {ArticleTileComponent} from '../article-tile/article-tile.component';
import {LowResolutionMessageComponent} from '../low-resolution-message/low-resolution-message.component';
import {Article, News} from '../model/news.interface';
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
    component.news = newsMock;
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should compare component with expected values', () => {
    fixture.detectChanges();
    let title = fixture.nativeElement.querySelector('.browser__title');
    expect(title.innerText).toEqual('Przeglądarka newsów');
    let tile = fixture.nativeElement.querySelector('.tile');
    expect(tile.innerText).toBeDefined();
  });
});

const articleMock: Article = {
  author: 'author',
  title: 'title',
  description: 'description',
  date: '2020-01-01',
  sourceName: 'sourceName',
  articleUrl: 'http://article-url/',
  imageUrl: 'http://image-url/'
};

const newsMock: News = {
  country: 'pl',
  category: 'category',
  articles: [articleMock]
};
