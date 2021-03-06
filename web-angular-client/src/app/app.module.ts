import { BrowserModule } from '@angular/platform-browser';
import { NgModule }      from '@angular/core';

import { AppComponent }                        from './app.component';
import { ElectronicEquipmentNewComponent }     from './electronic-equipment/electronic-equipment-new/electronic-equipment-new.component';
import { ElectronicEquipmentListComponent }    from './electronic-equipment/electronic-equipment-list/electronic-equipment-list.component';
import { NgbModule }                           from '@ng-bootstrap/ng-bootstrap';
import { HttpClientModule }                    from '@angular/common/http';
import { HomeComponent }                       from './home/home.component';
import { AppRoutingModule }                    from './app-routing.module';
import { AlertComponent }                      from './alert/alert.component';
import { FormsModule, ReactiveFormsModule }    from '@angular/forms';
import { NavigationComponent }                 from './navigation/navigation.component';
import { CommentAddComponent }                 from './electronic-equipment/comments/comment-add/comment-add.component';
import { CommentListComponent }                from './electronic-equipment/comments/comment-list/comment-list.component';
import { ElectronicEquipmentDetailsComponent } from './electronic-equipment/electronic-equipment-details/electronic-equipment-details.component';

@NgModule({
  declarations: [
    AppComponent,
    AlertComponent,
    ElectronicEquipmentNewComponent,
    ElectronicEquipmentListComponent,
    NavigationComponent,
    HomeComponent,
    CommentAddComponent,
    CommentListComponent,
    ElectronicEquipmentDetailsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    NgbModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
