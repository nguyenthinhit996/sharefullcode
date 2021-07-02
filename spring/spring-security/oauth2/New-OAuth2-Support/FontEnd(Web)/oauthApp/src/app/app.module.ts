import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { RouterModule }   from '@angular/router';
import { AppComponent } from './app.component';
import { HomeComponent } from './home.component';
import { StudentComponent } from './student.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    StudentComponent   
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot([
      { path: '', component: HomeComponent, pathMatch: 'full' }], {onSameUrlNavigation: 'reload'})
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
