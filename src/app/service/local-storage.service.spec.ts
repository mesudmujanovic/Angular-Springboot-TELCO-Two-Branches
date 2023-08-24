import { TestBed } from '@angular/core/testing';

import { LocalStorageService } from './local-storage.service';

fdescribe('LocalStorageService', () => {
  let service: LocalStorageService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers:[LocalStorageService]
    });
    service = TestBed.inject(LocalStorageService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should set and get a value in local storage', ()=>{
    const key = 'testKey';
    const value = {name:'Mesud', age:30};
    service.setLocalStorage(key, value);
    const returnSet =  service.getLocalStorage(key);
    expect(returnSet).toEqual(value)
  });

  it('should return null for a non-existent key', ()=>{
    const key = 'nonExist';
    const returnSet = service.getLocalStorage(key);
    expect(returnSet).toBeNull();
  })
});
