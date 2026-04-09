import { Routes } from '@angular/router';
import { ListagemComputadores } from './components/listagem-computadores/listagem-computadores';

export const routes: Routes = [
  { path: "computadores", component: ListagemComputadores},
  { path: '**', redirectTo: "computadores"}
];
