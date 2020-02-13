import {HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable, throwError} from 'rxjs';
import {catchError, tap} from 'rxjs/operators';
import {ErrorModalService} from '../error-modal/error-modal.service';

@Injectable()
export class ErrorInterceptorService implements HttpInterceptor {

  constructor(private errorModalService: ErrorModalService) {
  }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return next.handle(request)
      .pipe(
        tap(),
        catchError((error: HttpErrorResponse) => {
            this.errorModalService.open(error.message);

            return throwError(error);
          }
        ));
  }

}
