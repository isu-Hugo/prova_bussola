import { Component, inject } from '@angular/core';
import { Listagem } from '../../services/listagem';

@Component({
  selector: 'app-listagem-computadores',
  imports: [],
  templateUrl: './listagem-computadores.html',
  styleUrl: './listagem-computadores.css',
})
export class ListagemComputadores {
  private service = inject(Listagem);

  computadores = [{}];

  listarComputadores(){
    this.service.getComputadores().subscribe({
      next: (res) =>{
        this.computadores = res;
        console.log(res)
      },
      error: (er) =>{
        console.error(er);
      }
    })
  }

}
