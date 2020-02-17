import {HttpClientTestingModule} from '@angular/common/http/testing';
import {TestBed} from '@angular/core/testing';

import {NewsService} from './news.service';

describe('NewsService', () => {
  beforeEach(() => TestBed.configureTestingModule({
    imports: [
      HttpClientTestingModule
    ]
  }));

  it('should be created', () => {
    const service: NewsService = TestBed.get(NewsService);
    expect(service.getNews('pl', 'category')).toBeTruthy();
  });
});
