import { Component, OnInit }                  from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router }             from '@angular/router';
import { AlertService }                       from '../../../alert/alert.service';
import { CommentService }                     from '../comment.service';
import { first }                              from 'rxjs/operators';

@Component({
  selector: 'app-comment-add',
  templateUrl: './comment-add.component.html',
  styleUrls: ['./comment-add.component.css']
})
export class CommentAddComponent implements OnInit {
  commentAddForm: FormGroup;
  loading = false;
  submitted = false;
  identifier: string;

  constructor(private formBuilder: FormBuilder,
              private router: Router,
              private route: ActivatedRoute,
              private alertService: AlertService,
              private commentService: CommentService) {
  }

  get field(): any {
    return this.commentAddForm.controls;
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe(value => {
      if (value.has('electronic-equipment-id')) {
        this.identifier = value.get('electronic-equipment-id');
      }
    });

    this.commentAddForm = this.formBuilder.group({
      description: ['', Validators.required],
      electronicEquipmentId: [this.identifier, Validators.required],
    });
  }

  onSubmit(): void {
    this.submitted = true;
    this.alertService.clear();
    if (this.commentAddForm.invalid) {
      return;
    }
    this.loading = true;
    this.commentService.add(this.commentAddForm.value)
      .pipe(first())
      .subscribe(
        () => {
          this.alertService.success('New comment was added to the list', true);
          this.router.navigate([`/comment/list/${this.identifier}`]);
        },
        error => {
          this.alertService.error(error);
          this.loading = false;
        });
  }

}
