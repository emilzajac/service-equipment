import { Component, OnInit }            from '@angular/core';
import { ElectronicEquipmentService }   from '../electronic-equipment.service';
import { ElectronicEquipmentInterface } from './electronic-equipment.interface';
import { Router }                       from '@angular/router';

@Component({
  selector: 'app-electronic-equipment-list',
  templateUrl: './electronic-equipment-list.component.html',
  styleUrls: ['./electronic-equipment-list.component.css']
})
export class ElectronicEquipmentListComponent implements OnInit {

  electronicEquipment: ElectronicEquipmentInterface[];

  constructor(private electronicEquipmentService: ElectronicEquipmentService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.electronicEquipmentService.getAll()
      .subscribe((equipment: ElectronicEquipmentInterface[]) => this.electronicEquipment = equipment);
  }

  commentsList(identifier: string): void {
    this.router.navigate([`/comment/list/${identifier}`]);
  }

  addNewElectronic(): void {
    this.router.navigate([`electronic-equipment/add`]);
  }

  details(identifier: string): void {
    this.router.navigate([`/details/list/${identifier}`]);
  }
}
