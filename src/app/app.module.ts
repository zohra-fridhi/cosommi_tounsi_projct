import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponentComponent } from './home-component/home-component.component';
import { NavaBarComponentComponent } from './nava-bar-component/nava-bar-component.component';
import { SideBarComponentComponent } from './side-bar-component/side-bar-component.component';
import { GetProductComponent } from './get-product/get-product.component';
import {HttpClientModule} from '@angular/common/http';
import { AddProductComponent } from './add-product/add-product.component';
import {FormsModule} from '@angular/forms';
import {NgModule} from '@angular/core';
import { UpdateProductComponent } from './update-product/update-product.component';
import { SearchProductComponent } from './search-product/search-product.component';
import { CategoriesComponent } from './categories/categories.component';
import { ProductNameComponent } from './product-name/product-name.component';
import { GetPubComponent } from './get-pub/get-pub.component';
import { UserComponent } from './user/user.component';
import { PubUserComponent } from './pub-user/pub-user.component';
import {SafeHtml} from '../assets/pipeTransform.pipe';
import { UpdatePubComponent } from './update-pub/update-pub.component';
import { CountComponent } from './count/count.component';
import { ResultComponent } from './result/result.component';
import { AffectProdComponent } from './affect-prod/affect-prod.component';
import { AddCategoryComponent } from './add-category/add-category.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponentComponent,
    NavaBarComponentComponent,
    SideBarComponentComponent,
    GetProductComponent,
    AddProductComponent,
    UpdateProductComponent,
    SearchProductComponent,
    CategoriesComponent,
    ProductNameComponent,
    GetPubComponent,
    UserComponent,
    PubUserComponent,
    SafeHtml,
    UpdatePubComponent,
    CountComponent,
    ResultComponent,
    AffectProdComponent,
    AddCategoryComponent
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
