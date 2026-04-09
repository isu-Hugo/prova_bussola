import { Component, inject, signal } from '@angular/core';
import { Listagem } from '../../services/listagem';
import { JsonPipe } from '@angular/common';

@Component({
  selector: 'app-listagem-computadores',
  imports: [JsonPipe],
  templateUrl: './listagem-computadores.html',
  styleUrl: './listagem-computadores.css',
})
export class ListagemComputadores {
  private service = inject(Listagem);



  computadores = signal([]);

  listarComputadores(){
    this.service.getComputadores().subscribe({
      next: (res) =>{
        this.computadores.set(res);
        console.log(res)
      },
      error: (er) =>{
        console.error(er);
      }
    })
  }

}
