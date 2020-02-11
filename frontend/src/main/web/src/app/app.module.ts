import {HttpClientModule} from '@angular/common/http';
import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {NewsBrowserComponent} from './news-browser/news-browser.component';
import {ArticleTileComponent} from './article-tile/article-tile.component';

@NgModule({
  declarations: [
    AppComponent,
    NewsBrowserComponent,
    ArticleTileComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
