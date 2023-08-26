import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllRoutersComponent } from './all-routers.component';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { AllRoutersService } from 'src/app/service/all-routers.service';
import { IRouters } from 'src/app/Interface/iRouters';
import { of, throwError } from 'rxjs';

fdescribe('AllRoutersComponent', () => {
  let component: AllRoutersComponent;
  let fixture: ComponentFixture<AllRoutersComponent>;
  let allRoutersService: AllRoutersService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllRoutersComponent ],
      imports:[HttpClientTestingModule,
               ],
      providers:[AllRoutersService]
    })
    .compileComponents();
    fixture = TestBed.createComponent(AllRoutersComponent);
    component = fixture.componentInstance;
    allRoutersService = TestBed.inject(AllRoutersService)
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should return allRouters', () =>{
   const mockAllRouters: IRouters[] = [{ id:1,
     description:"description", price: 222 }]
   spyOn(allRoutersService, 'getAllRouters').and.returnValue(of(mockAllRouters));

   component.allRouters().subscribe( users => {
    expect(users).toEqual(mockAllRouters);
   });
   expect(allRoutersService.getAllRouters).toHaveBeenCalled();
  });

  it('should handle erros', () =>{
    const errorMessage = 'Doslo je do greske';
    spyOn(allRoutersService, 'getAllRouters').and.returnValue(throwError(errorMessage));
    
    component.allRouters().subscribe( () =>{
      fail('Metoda treba da vrati gresku')
    },
     (error) =>{
      console.error('Grreska prilikom dohvatanja',error);
      expect(error).toEqual(errorMessage);
     }
    );
    expect(allRoutersService.getAllRouters).toHaveBeenCalled();
  })


});
