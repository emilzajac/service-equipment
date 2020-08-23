import { NgModule }                         from '@angular/core';
import { RouterModule, Routes }             from '@angular/router';
import { environment }                      from '../environments/environment';
import { HomeComponent }                    from './home/home.component';
import { ElectronicEquipmentListComponent } from './electronic-equipment/electronic-equipment-list/electronic-equipment-list.component';
import { ElectronicEquipmentNewComponent }  from './electronic-equipment/electronic-equipment-new/electronic-equipment-new.component';


const routes: Routes = [

  {path: '', component: HomeComponent},
  {path: 'home', component: HomeComponent},
  {path: 'electronic-equipment/list', component: ElectronicEquipmentListComponent},
  {path: 'electronic-equipment/add', component: ElectronicEquipmentNewComponent},

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
