import { Periferico } from "../components/periferico/periferico"
import { PerifericoModel } from "./periferico";

export interface Computador {
  id: number;
  nome: string;
  cor: string;
  dataFabricacao: number;
  perifericos: PerifericoModel[] | [];
}
