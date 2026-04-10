import { Component, inject, Input, signal } from '@angular/core';
import { Listagem } from '../../services/listagem';
import { JsonPipe } from '@angular/common';
import { Computador } from '../../models/computador';

@Component({
  selector: 'app-listagem-computadores',
  imports: [],
  templateUrl: './listagem-computadores.html',
  styleUrl: './listagem-computadores.css',
  standalone:true
})
export class ListagemComputadores  {
  private service = inject(Listagem);

  @Input()
  computadoresList = signal<Computador[]>([]);
  // computadoresList:Computador[] = [];


  ngOnInit(): void {
    this.listarComputadores()
  }

  listarComputadores(){
    this.service.getComputadores().subscribe({
      next: (res) =>{
        // this.computadoresList = res;
        this.computadoresList.set(res);
        console.log(this.computadoresList);
      },
      error: (err) =>{
        console.error(err);
      }
    })
  }

  deleteComputador(id:number){
    this.service.deleteComputador(id).subscribe({
      next: () =>{
        this.listarComputadores()
      }
    })
  }

  criarComputador(){
    var nome = prompt("nome") ?? "";
    var cor = prompt("cor") ?? "";
    var ano = Number.parseInt(prompt("ano") ?? "0");

    this.service.createComputador({
      nome: nome,
      cor: cor,
      dataFabricacao: ano
    }).subscribe({
      next: () =>{
        this.listarComputadores()
      }
    })




  }

  deletePeriferico(idComp:number, idPer:number){
    this.service.deletePeriferico(idComp, idPer).subscribe({
      next: ()=>{
        this.listarComputadores()
      }
    });
  }

  novoPeriferico(id:number){
        var nome = prompt("nome") ?? "";
        this.service.createPeriferico(id, {nome:nome}).subscribe({
          next: () =>{
            this.listarComputadores()
          }
        })
  }

  updatePeriferico(id:number){
    var n = prompt("nome") ?? "";
    this.service.updatePeriferico(id, {nome:n}).subscribe({
      next:()=>{
        this.listarComputadores()
      }
    })
  }

  updateComputador(id:number){
    var nome = prompt("nome") ?? "";
    var cor = prompt("cor") ?? "";
    var ano = Number.parseInt(prompt("ano") ?? "0");

    this.service.updateComputador(id, {nome: nome, cor: cor, dataFabricacao:ano}).subscribe({
      next:()=>{
        this.listarComputadores()
      }
    })
  }
}
