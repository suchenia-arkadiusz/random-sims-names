import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { PopupComponent } from './components/popup/popup.component';
import { AddNewNameComponent } from './components/add-new-name/add-new-name.component';
import { DrawNameComponent } from './components/draw-name/draw-name.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { NamesPageComponent } from './pages/names-page/names-page.component';
import { AspirationsPageComponent } from './pages/aspirations-page/aspirations-page.component';

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    HeaderComponent,
    FooterComponent,
    PopupComponent,
    AddNewNameComponent,
    DrawNameComponent,
    NamesPageComponent,
    AspirationsPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
