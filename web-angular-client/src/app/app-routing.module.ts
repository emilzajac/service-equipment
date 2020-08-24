import { NgModule }                            from '@angular/core';
import { RouterModule, Routes }                from '@angular/router';
import { environment }                         from '../environments/environment';
import { HomeComponent }                       from './home/home.component';
import { ElectronicEquipmentListComponent }    from './electronic-equipment/electronic-equipment-list/electronic-equipment-list.component';
import { ElectronicEquipmentNewComponent }     from './electronic-equipment/electronic-equipment-new/electronic-equipment-new.component';
import { CommentAddComponent }                 from './electronic-equipment/comments/comment-add/comment-add.component';
import { CommentListComponent }                from './electronic-equipment/comments/comment-list/comment-list.component';
import { ElectronicEquipmentDetailsComponent } from './electronic-equipment/electronic-equipment-details/electronic-equipment-details.component';

const routes: Routes = [

  {path: '', component: HomeComponent},
  {path: 'home', component: HomeComponent},
  {path: 'electronic-equipment/list', component: ElectronicEquipmentListComponent},
  {path: 'electronic-equipment/add', component: ElectronicEquipmentNewComponent},
  {path: 'comment/add/:electronic-equipment-id', component: CommentAddComponent},
  {path: 'comment/list/:electronic-equipment-id', component: CommentListComponent},
  {path: 'details/list/:electronic-equipment-id', component: ElectronicEquipmentDetailsComponent},

];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, {
      useHash: !environment.production
    }),
  ],
  exports: [RouterModule],
})
export class AppRoutingModule {
}
