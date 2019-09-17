import { TestBed } from '@angular/core/testing';

import { CatalogListService } from './catalog-list.service';

describe('CatalogListService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CatalogListService = TestBed.get(CatalogListService);
    expect(service).toBeTruthy();
  });
});
