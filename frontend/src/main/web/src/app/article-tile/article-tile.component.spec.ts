import {async, ComponentFixture, TestBed} from '@angular/core/testing';
import {Article} from '../model/news.interface';

import {ArticleTileComponent} from './article-tile.component';

describe('ArticleTileComponent', () => {
  let component: ArticleTileComponent;
  let fixture: ComponentFixture<ArticleTileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ArticleTileComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ArticleTileComponent);
    component = fixture.componentInstance;
    component.article = articleMock;
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should compare component with expected values', () => {
    fixture.detectChanges();
    let imageUrl = fixture.nativeElement.querySelector('.tile__img');
    expect(imageUrl.src).toEqual(articleMock.imageUrl);
    let title = fixture.nativeElement.querySelector('.tile__title');
    expect(title.innerText).toEqual(articleMock.title);
    let description = fixture.nativeElement.querySelector('.tile__description');
    expect(description.innerText).toEqual(articleMock.description);
    let author = fixture.nativeElement.querySelector('.tile__footer');
    expect(author.innerText).toContain(articleMock.author);
    let date = fixture.nativeElement.querySelector('.tile__footer');
    expect(date.innerText).toContain(articleMock.date);
    let sourceName = fixture.nativeElement.querySelector('.tile__footer');
    expect(sourceName.innerText).toContain(articleMock.sourceName);
    let articleUrl = fixture.nativeElement.querySelector('.tile__articleUrl');
    expect(articleUrl.href).toEqual(articleMock.articleUrl);
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
