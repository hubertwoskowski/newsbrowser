import {Component, OnInit} from '@angular/core';
import {News} from '../model/news.interface';
import {NewsService} from '../service/news.service';

@Component({
  selector: 'app-news-browser',
  templateUrl: './news-browser.component.html',
  styleUrls: ['./news-browser.component.scss']
})
export class NewsBrowserComponent implements OnInit {

  news: News;

  constructor(private newsService: NewsService) {
  }

  ngOnInit() {
    this.newsService.getNews('pl', 'technology').subscribe(
      news => {
        this.news = news;
      }
    );
  }

}
