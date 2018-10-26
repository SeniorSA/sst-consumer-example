import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MessageService } from 'primeng/api';
import { Observable, throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';

@Injectable()
export class AppService {
  constructor(
    private httpClient: HttpClient,
    private messageService: MessageService
  ) {}

  getPendenciesList(): Observable<any> {
    return this.httpClient
      .get('http://localhost:8099/employeeEntities')
      .pipe(
        map(
          (data: any) =>
            data && data._embedded && data._embedded.employeeEntities
        ),
        catchError((error: any) => this.showError(error))
      );
  }

  showError(error) {
    setTimeout(() => {
      this.messageService.add({
        severity: 'error',
        summary: 'Erro ao obter as pendencias',
        detail: error && error.message
      });
    }, 0);
    return throwError(error);
  }
}
