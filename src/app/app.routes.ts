import { Routes } from '@angular/router';
import {InsertnewstuffModule} from "./insertnewstuff/insertnewstuff.module";

export const routes: Routes = [
  {path:"insert",loadChildren:()=>InsertnewstuffModule}
];
