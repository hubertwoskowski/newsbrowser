import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {News} from '../model/news.interface';

@Injectable({
  providedIn: 'root'
})
export class NewsService {

  constructor(private httpClient: HttpClient) {
  }

  public getNews(country: string, category: string): Observable<News> {
    return this.httpClient.get<News>(`/news/${country}/${category}`);
  }
}
