
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CatalogoDispositivo } from './catalogo-dispositivo.model';
import { CategoriaDispositivo } from './categoria-dispositivo.model';

@Injectable({
  providedIn: 'root'
})
export class CatalogService {

  headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private httpClient: HttpClient) { }

  list(): Observable<any> {
    return this.httpClient.get<Array<CatalogoDispositivo>>('/ri-cpeapi/1.0/catalog');
  }

  findById(catalogoId: number): Observable<any> {
    return this.httpClient.get<CatalogoDispositivo>(`/ri-cpeapi/1.0/catalog/${catalogoId}`);
  }

  save(catalogo: CatalogoDispositivo): Observable<any> {
      return this.httpClient.post(`/ri-cpeapi/1.0/catalog`, catalogo, {headers:this.headers});
  }

  delete(catalogoId: number): Observable<any> {
    return this.httpClient.delete(`/ri-cpeapi/1.0/catalog/${catalogoId}`, {headers:this.headers});
  }

  listCategories(): Observable<any> {
    return this.httpClient.get<Array<CategoriaDispositivo>>(`/ri-cpeapi/1.0/catalog/categories`);
  }

  listVendors(): Observable<any> {
    return this.httpClient.get<Array<string>>(`/ri-cpeapi/1.0/catalog/vendors`);
  }
}
