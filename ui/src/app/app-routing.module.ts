import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { AspirationsPageComponent } from './pages/aspirations-page/aspirations-page.component';
import { NamesPageComponent } from './pages/names-page/names-page.component';


const routes: Routes = [
  { path: 'names', component: NamesPageComponent },
  { path: 'aspirations', component: AspirationsPageComponent },
  { path: '', component: HomePageComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
