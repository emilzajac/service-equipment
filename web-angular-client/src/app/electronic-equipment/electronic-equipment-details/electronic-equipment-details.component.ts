import { Component, OnInit }            from '@angular/core';
import { ElectronicEquipmentService }   from '../electronic-equipment.service';
import { ActivatedRoute }               from '@angular/router';
import { ParametersService }            from '../parameters.service';
import { ElectronicEquipmentInterface } from '../electronic-equipment-list/electronic-equipment.interface';
import { ParametersInterface }          from './parameters.interface';

@Component({
  selector: 'app-electronic-equipment-details',
  templateUrl: './electronic-equipment-details.component.html',
  styleUrls: ['./electronic-equipment-details.component.css']
})
export class ElectronicEquipmentDetailsComponent implements OnInit {

  identifier: string;
  electronicEquipment: ElectronicEquipmentInterface;
  parameters: ParametersInterface[];

  constructor(private electronicEquipmentService: ElectronicEquipmentService,
              private parametersService: ParametersService,
              private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe(value => {
      if (value.has('electronic-equipment-id')) {
        this.getByElectronicIdentifier(value.get('electronic-equipment-id'));
      }
    });
  }

  private getByElectronicIdentifier(identifier: string): void {
    this.identifier = identifier;
    this.electronicEquipmentService.findByIdentifier(this.identifier)
      .subscribe((equipment: ElectronicEquipmentInterface) => this.electronicEquipment = equipment);
    this.parametersService.getAllByElectronicIdentifier(this.identifier)
      .subscribe((parameters: ParametersInterface[]) => this.parameters = parameters);
  }

}
