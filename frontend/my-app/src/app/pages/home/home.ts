import { Component, inject, OnInit, signal } from '@angular/core';
import { ListagemComputadores } from '../../components/listagem-computadores/listagem-computadores';
import { Periferico } from '../../components/periferico/periferico';
import { Listagem } from '../../services/listagem';
import { Computador } from '../../models/computador';

@Component({
  selector: 'app-home',
  imports: [ListagemComputadores],
  templateUrl: './home.html',
  styleUrl: './home.css',
})
export class Home implements OnInit {
  private service = inject(Listagem);

  // computadoresList = signal<Computador[]>([]);
  computadoresList:Computador[] = [];


  ngOnInit(): void {
    this.listarComputadores()
  }

  listarComputadores(){
    this.service.getComputadores().subscribe({
      next: (res) =>{
        this.computadoresList = res;
        // this.computadoresList.set(res);
      },
      error: (err) =>{
      }
    })
  }



}
