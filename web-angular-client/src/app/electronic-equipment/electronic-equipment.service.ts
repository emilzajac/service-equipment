import { Injectable }                       from '@angular/core';
import { HttpClient }                       from '@angular/common/http';
import { ElectronicEquipmentFormInterface } from './electronic-equipment-new/electronic-equipment-form.interface';
import { ElectronicEquipmentInterface }     from './electronic-equipment-list/electronic-equipment.interface';
import { Observable }                       from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ElectronicEquipmentService {

  constructor(private http: HttpClient) {
  }

  add(equipment: ElectronicEquipmentFormInterface): Observable<ElectronicEquipmentInterface> {
    return this.http.post<ElectronicEquipmentInterface>(`/api/electronics`, equipment);
  }

  getAll(): Observable<ElectronicEquipmentInterface[]> {
    return this.http.get<ElectronicEquipmentInterface[]>(`/api/electronics`);
  }

  findByIdentifier(identifier: string): Observable<ElectronicEquipmentInterface> {
    return this.http.get<ElectronicEquipmentInterface>(`/api/electronics/${identifier}`);
  }

  update(equipment: ElectronicEquipmentInterface): Observable<ElectronicEquipmentInterface> {
    return this.http.put<ElectronicEquipmentInterface>(`/api/electronics`, JSON.stringify(equipment));
  }

  delete(identifier: string): void {
    this.http.delete(`/api/electronics/${identifier}`);
  }

}
