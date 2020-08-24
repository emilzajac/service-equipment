import { Injectable }          from '@angular/core';
import { HttpClient }          from '@angular/common/http';
import { Observable }          from 'rxjs';
import { ParametersInterface } from './electronic-equipment-details/parameters.interface';

@Injectable({
  providedIn: 'root'
})
export class ParametersService {

  constructor(private http: HttpClient) {
  }

  getAllByElectronicIdentifier(identifier: string): Observable<ParametersInterface[]> {
    return this.http.get<ParametersInterface[]>(`/api/parameters/electronic/${identifier}`);
  }

}
