import {Injectable} from '@angular/core';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {ErrorModalComponent} from './error-modal.component';

@Injectable({
  providedIn: 'root'
})
export class ErrorModalService {

  constructor(private modalService: NgbModal) {}

  open(error) {
    const modalRef = this.modalService.open(ErrorModalComponent);
    modalRef.componentInstance.error = error;
  }

}
