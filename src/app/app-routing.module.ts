import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {GetProductComponent} from './get-product/get-product.component';
import {AddProductComponent} from './add-product/add-product.component';
import {UpdateProductComponent} from './update-product/update-product.component';
import {SearchProductComponent} from './search-product/search-product.component';
import {CategoriesComponent} from './categories/categories.component';
import {ProductNameComponent} from './product-name/product-name.component';
import {GetPubComponent} from './get-pub/get-pub.component';
import {UserComponent} from './user/user.component';
import {PubUserComponent} from './pub-user/pub-user.component';
import { UpdatePubComponent } from './update-pub/update-pub.component';
import {CountComponent} from './count/count.component';
import {ResultComponent} from './result/result.component';
import {AddCategoryComponent} from './add-category/add-category.component';


const routes: Routes = [
  {path: 'listProduct' , component: GetProductComponent},
  {path: 'add' , component: AddProductComponent},
  {path: 'update-Product/:id' , component: UpdateProductComponent},
  {path: 'search-Product' , component: SearchProductComponent},
  {path: 'listCategories' , component: CategoriesComponent},
  {path: 'product-Name/:catId' , component: ProductNameComponent},
  {path: 'listPublicities', component: GetPubComponent},
  {path: 'listUser', component: UserComponent},
  {path: 'pubUser/:age', component: PubUserComponent},
  {path: 'updatePub/:id', component: UpdatePubComponent},
  {path: 'count', component: CountComponent},
  {path: 'result/:startAgeCible/:endAgeCible/:genderCible', component: ResultComponent},
  {path:'addCategory', component: AddCategoryComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
