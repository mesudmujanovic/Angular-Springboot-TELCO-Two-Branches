import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CartComponent } from './cart.component';
import { CartService } from 'src/app/service/cart.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { CalculatorService } from 'src/app/service/calculator.service';

describe('CartComponent', () => {
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
   
    
  
  })
});
