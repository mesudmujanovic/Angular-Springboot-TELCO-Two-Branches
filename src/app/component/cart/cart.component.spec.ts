import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CartComponent } from './cart.component';
import { CartService } from 'src/app/service/cart.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { CalculatorService } from 'src/app/service/calculator.service';
import { Observable, of } from 'rxjs';
import { priceCalculate } from 'src/app/Interface/interPrice';
import { ITariff } from 'src/app/Interface/ITariff';
import { IRouters } from 'src/app/Interface/iRouters';

fdescribe('CartComponent', () => {
  let component: CartComponent;
  let fixture: ComponentFixture<CartComponent>;
  let cartService: CartService;
  let calculatorService: CalculatorService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CartComponent ],
      imports:[HttpClientTestingModule],
      providers:[CalculatorService]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CartComponent);
    component = fixture.componentInstance;
    cartService = TestBed.inject(CartService);
    calculatorService = TestBed.inject(CalculatorService)
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should call calculatorService.calculateRouterAndTariff with correct arguments and set result', () => {
    const router = 1;
    const tariff = 1;
    const calculatedPrice = 2;
    const mockResponse: priceCalculate = {price:tariff, discount:tariff, calculatedPrice: calculatedPrice}
    spyOn(calculatorService,'calculateRouterAndTariff').and.returnValue(of(mockResponse));
    component.routerTariffTotal();
    expect(component.result).toBe(calculatedPrice);
  });

  it('should add Tariff In Cart and return observables', ()=>{
    const tariff: ITariff ={
      id:1, name:"tariff", speed:"222", priceList:[
      {
        id:1,
        price:"222",
        contractDuration: 22,
        oneTime: false,
        name:"tariff",
        discount: 1
      }
      ]
    };
 
   spyOn(cartService,'adaTariffInCart').and.returnValue(of(tariff));
    const obsFunckiotn = component.addTariffInCart();
    expect( obsFunckiotn instanceof Observable).toBeTruthy();
    let result: any;
    obsFunckiotn.subscribe( (response) =>{
      result = response;
    });
    expect(result).toEqual(tariff);
  });

  it('should add Router in cart', ()=>{
    const router:IRouters = 
    {  id: 1,
      description: "routers",
      price: 222
    };

    spyOn(cartService, 'adaRouterInCart').and.returnValue(of(router));
    const routerFunction = component.addRouterInCart();
    expect(routerFunction instanceof Observable).toBeTruthy();
    let result: any;
    routerFunction.subscribe( (routers) =>{
      result = routers;
    });
    
    expect(result).toEqual(router);
  })

  it('should click button = !showCart', () =>{
    const button = fixture.nativeElement.querySelector('.btnCart');
    expect(component.showCart).toBe(false);

    button.click();
    fixture.detectChanges();
    expect(component.showCart).toBe(true);
  });

  it('should call hidePopUp1() on mouse leave', () => {
    spyOn(component, 'hidePopUp1');
    component.showCart = true;
    fixture.detectChanges();
    const cartShopElement = fixture.nativeElement.querySelector('.cartShop');
    component.showCart = true;
    cartShopElement.dispatchEvent(new Event('mouseleave'));
    expect(component.hidePopUp1).toHaveBeenCalled();
  });

});
