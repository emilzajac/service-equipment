import { Injectable }           from '@angular/core';
import { Observable }           from 'rxjs';
import { HttpClient }           from '@angular/common/http';
import { CommentFormInterface } from './comment-add/comment-form.interface';
import { CommentInterface }     from './comment-list/comment.interface';

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  constructor(private http: HttpClient) {
  }

  add(comment: CommentFormInterface): Observable<number> {
    return this.http.post<number>(`/api/comments`, comment);
  }

  getByElectronicIdentifier(identifier: string): Observable<CommentInterface[]> {
    return this.http.get<CommentInterface[]>(`/api/comments/electronic/${identifier}`);
  }

  update(comment: CommentInterface): Observable<CommentInterface> {
    return this.http.put<CommentInterface>(`/api/comments`, JSON.stringify(comment));
  }

  delete(id: string): void {
    this.http.delete(`/api/comments/${id}`);
  }

}
