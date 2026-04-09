import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListagemComputadores } from './listagem-computadores';

describe('ListagemComputadores', () => {
  let component: ListagemComputadores;
  let fixture: ComponentFixture<ListagemComputadores>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListagemComputadores],
    }).compileComponents();

    fixture = TestBed.createComponent(ListagemComputadores);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
