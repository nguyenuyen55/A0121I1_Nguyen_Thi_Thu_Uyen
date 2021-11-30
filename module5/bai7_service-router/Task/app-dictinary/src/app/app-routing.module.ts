import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {PreloadAllModules, RouterModule, Routes} from '@angular/router';
import {DictinaryPageComponent} from './dictinary-page/dictinary-page.component';
import {DictinaryDetailComponent} from './dictinary-detail/dictinary-detail.component';

const routes: Routes = [
  {
    path: 'dictionary',
    component: DictinaryPageComponent,
    children: [
      {
        path: ':key',
        component: DictinaryDetailComponent,
      }
    ]
  },
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
