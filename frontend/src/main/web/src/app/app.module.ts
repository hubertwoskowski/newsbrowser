import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {ArticleTileComponent} from './article-tile/article-tile.component';
import {ErrorInterceptorService} from './error-interceptor/error-interceptor.service';
import {ErrorModalComponent} from './error-modal/error-modal.component';
import {LowResolutionMessageComponent} from './low-resolution-message/low-resolution-message.component';
import {NewsBrowserComponent} from './news-browser/news-browser.component';

@NgModule({
  declarations: [
    AppComponent,
    NewsBrowserComponent,
    ArticleTileComponent,
    LowResolutionMessageComponent,
    ErrorModalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: ErrorInterceptorService,
      multi: true
    }
  ],
  bootstrap: [AppComponent],
  entryComponents: [ErrorModalComponent]
})
export class AppModule {
}
