import { Component, OnInit }            from '@angular/core';
import { ElectronicEquipmentService }   from '../electronic-equipment.service';
import { ElectronicEquipmentInterface } from './electronic-equipment.interface';

@Component({
  selector: 'app-electronic-equipment-list',
  templateUrl: './electronic-equipment-list.component.html',
  styleUrls: ['./electronic-equipment-list.component.css']
})
export class ElectronicEquipmentListComponent implements OnInit {

  electronicEquipment: ElectronicEquipmentInterface[];

  constructor(private electronicEquipmentService: ElectronicEquipmentService) {
  }

  ngOnInit(): void {
    this.electronicEquipmentService.getAll()
      .subscribe((equipment: ElectronicEquipmentInterface[]) => this.electronicEquipment = equipment);
  }

}
