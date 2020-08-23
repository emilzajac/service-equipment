import { Component, OnInit }                  from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router }                             from '@angular/router';
import { AlertService }                       from '../../alert/alert.service';
import { first }                              from 'rxjs/operators';
import { ElectronicEquipmentService }         from '../electronic-equipment.service';
import { CategoryEnum }                       from '../category.enum';

@Component({
  selector: 'app-electronic-equipment-new',
  templateUrl: './electronic-equipment-new.component.html',
  styleUrls: ['./electronic-equipment-new.component.css']
})
export class ElectronicEquipmentNewComponent implements OnInit {
  electronicAddForm: FormGroup;
  loading = false;
  submitted = false;

  categories: any = CategoryEnum;
  keys: any[];

  constructor(private formBuilder: FormBuilder,
              private router: Router,
              private alertService: AlertService,
              private equipmentService: ElectronicEquipmentService) {
  }

  get field(): any {
    return this.electronicAddForm.controls;
  }

  ngOnInit(): void {
    this.electronicAddForm = this.formBuilder.group({
      name: ['', Validators.required],
      categoryEnum: ['', Validators.required],
      producer: ['', Validators.required],
      identifier: ['', Validators.required],
      color: ['', Validators.required],
      repairStatusEnum: ['BROKEN', Validators.required],
    });
    this.keys = Object.keys(this.categories).filter(Number);
  }

  onSubmit(): void {
    this.submitted = true;
    this.alertService.clear();
    if (this.electronicAddForm.invalid) {
      return;
    }
    this.loading = true;
    this.equipmentService.add(this.electronicAddForm.value)
      .pipe(first())
      .subscribe(
        () => {
          this.alertService.success('New electronic was added to the list', true);
          this.router.navigate(['/electronic-equipment/list']);
        },
        error => {
          this.alertService.error(error);
          this.loading = false;
        });
  }

}
