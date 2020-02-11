import {Component, Input, OnInit} from '@angular/core';
import {Article} from '../model/news.interface';

@Component({
  selector: 'app-article-tile',
  templateUrl: './article-tile.component.html',
  styleUrls: ['./article-tile.component.scss']
})
export class ArticleTileComponent implements OnInit {

  @Input() article: Article;

  constructor() {
  }

  ngOnInit() {
  }

}
