import { Component, OnInit, Output, EventEmitter, Inject, Input } from '@angular/core';
import { Observable } from 'rxjs';
import { startWith, map } from 'rxjs/operators';
import { FormControl } from '@angular/forms';
import { CatalogoDispositivo } from '../catalogo-dispositivo.model';

@Component({
  selector: 'app-catalog-list-filters',
  templateUrl: './catalog-list-filters.component.html',
  styleUrls: ['./catalog-list-filters.component.scss'],
})
export class CatalogListFiltersComponent implements OnInit {

  @Output() filter: EventEmitter<any> = new EventEmitter();
  @Output() close: EventEmitter<any> = new EventEmitter();

  @Input() list: Array<CatalogoDispositivo>;

  // Filtros
  fabricantes: string[];
  modelos: string[];
  redes: string[];
  tecnologias: string[];
  categorias: string[];

  ctrlFabricante = new FormControl();
  ctrlModelo = new FormControl();
  ctrlRede = new FormControl();
  ctrlTecnologia = new FormControl();
  ctrlCategoria = new FormControl();

  filteredFabricante: Observable<string[]>;
  filteredModelo: Observable<string[]>;
  filteredTecnologia: Observable<string[]>;
  filteredCategoria: Observable<string[]>;

  isLoading: boolean;
  isCatchError: boolean;


  constructor() {}

  ngOnInit() {
  }

  private createFilter() {
    this.filteredFabricante = this.ctrlFabricante.valueChanges.pipe(
      startWith(''),
      map(x => this.fabricantes.filter(option => option && option.toLowerCase().includes(x.toLowerCase())))
    );
    this.filteredModelo = this.ctrlModelo.valueChanges.pipe(
      startWith(''),
      map(x => this.modelos.filter(option => option && option.toLowerCase().includes(x.toLowerCase())))
    );
    this.filteredTecnologia = this.ctrlTecnologia.valueChanges.pipe(
      startWith(''),
      map(x => this.tecnologias.filter(option => option && option.toLowerCase().includes(x.toLowerCase())))
    );
    this.filteredCategoria = this.ctrlCategoria.valueChanges.pipe(
      startWith(''),
      map(x => this.categorias.filter(option => option && option.toLowerCase().includes(x.toLowerCase())))
    );
  }

  mountFilters() {
    if (this.list) {
      this.fabricantes = Array.from(new Set(this.list.map(x => x.fabricante))).sort();
      this.modelos = Array.from(new Set(this.list.map(x => x.modelo))).sort();
      this.redes = Array.from(new Set(this.list.map(x => x.rede))).sort();
      this.tecnologias = Array.from(new Set(this.list.map(x => this.getTecnologiaValor(x)))).sort();
      this.categorias = Array.from(new Set(this.list.map(x => x.categoriaDispositivo.nomeCategoria))).sort();

      this.createFilter();
    }
  }

  caracteristicaTecnologiaFind(caracteristica) {
    return (caracteristica.nome === "Tecnologia");
  }

  private getTecnologiaValor(catalago: CatalogoDispositivo) {
    if (catalago.caracteristicas.find(this.caracteristicaTecnologiaFind)) {
      catalago['tecnologia'] = catalago.caracteristicas.find(this.caracteristicaTecnologiaFind).valor;
      return catalago.caracteristicas.filter(c => this.caracteristicaTecnologiaFind)[0].valor
    }
    return null;
  }

  doFilter() {
    const filteredList = this.list.filter(x => {
      if ((x.fabricante === this.ctrlFabricante.value || !this.ctrlFabricante.value)
        && (x.modelo === this.ctrlModelo.value || !this.ctrlModelo.value)
        && (x.rede === this.ctrlRede.value || !this.ctrlRede.value)
        && (this.getTecnologiaValor(x) === this.ctrlTecnologia.value || !this.ctrlTecnologia.value)
        && (x.categoriaDispositivo.nomeCategoria === this.ctrlCategoria.value || !this.ctrlCategoria.value)) {
        return true;
      }
    })
    this.filter.emit(filteredList);
  }

  doClear() {
    this.ctrlFabricante.setValue("");
    this.ctrlModelo.setValue("");
    this.ctrlRede.setValue("");
    this.ctrlTecnologia.setValue("");
    this.ctrlCategoria.setValue("");
  }

  doClose() {
    this.close.emit();
  }
}
