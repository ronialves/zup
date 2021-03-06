import { CategoriaDispositivo } from './categoria-dispositivo.model';
import { CaracteristicaDispositivo } from './caracteristica-dispositivo.model';

export class CatalogoDispositivo {
    constructor(
        public id: number,
        public modelo: string,
        public fabricante: string,
        public rede: string,
        public descricao: string,
        public sku: string,
        public categoriaDispositivo: CategoriaDispositivo,
        public caracteristicas: Array<CaracteristicaDispositivo>,
        public hasAssociatedDevices: boolean
    ) { }

}
