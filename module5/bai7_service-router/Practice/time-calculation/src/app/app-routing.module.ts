import {NgModule} from "@angular/core";
import {PreloadAllModules, RouterModule, Routes} from "@angular/router";
import {TimelinesComponent} from "./timelines/timelines.component";

const routes: Routes = [
  {
    path: '',
    component: TimelinesComponent

  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
