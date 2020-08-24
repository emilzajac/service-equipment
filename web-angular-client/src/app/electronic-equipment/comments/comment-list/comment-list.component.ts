import { Component, OnInit }      from '@angular/core';
import { CommentInterface }       from './comment.interface';
import { CommentService }         from '../comment.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-comment-list',
  templateUrl: './comment-list.component.html',
  styleUrls: ['./comment-list.component.css']
})
export class CommentListComponent implements OnInit {

  comments: CommentInterface[];
  identifier: string;

  constructor(private commentService: CommentService,
              private route: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe(value => {
      if (value.has('electronic-equipment-id')) {
        this.getByElectronic(value.get('electronic-equipment-id'));
      }
    });
  }

  addComment(identifier: string): void {
    this.router.navigate([`/comment/add/${identifier}`]);
  }

  private getByElectronic(identifier: string): void {
    this.identifier = identifier;
    this.commentService.getByElectronicIdentifier(identifier)
      .subscribe((comment: CommentInterface[]) => this.comments = comment);
  }
}
