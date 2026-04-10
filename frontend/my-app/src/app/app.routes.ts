import { Routes } from '@angular/router';
import { ListagemComputadores } from './components/listagem-computadores/listagem-computadores';
import { Home } from './pages/home/home';

export const routes: Routes = [
  { path: "home", component: Home},
  { path: '**', redirectTo: "home"}
];
