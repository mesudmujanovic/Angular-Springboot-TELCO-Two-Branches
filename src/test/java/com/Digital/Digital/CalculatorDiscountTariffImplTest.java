package com.Digital.Digital;
import com.Digital.Digital.Entity.CalculatorDiscountTariff;
import com.Digital.Digital.Infrastructure.Dto.CalculatorDiscountTariffDto;
import com.Digital.Digital.Repository.CalculatorRepository.CalculatorDiscountRepo;
import com.Digital.Digital.Service.CalculatorService.CalculatorDiscountTariffService;
import com.Digital.Digital.Service.ServiceImplemetations.CalculatorImpl.CalculatorDiscountTariffImpl;
import org.junit.Before;
import static org.mockito.Mockito.mock;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import org.junit.Test;

public class CalculatorDiscountTariffImplTest {

    private CalculatorDiscountTariffService calculatorService;
    private CalculatorDiscountRepo calculatorRepo;

    @Before
    public void setUp() {
        calculatorRepo = mock(CalculatorDiscountRepo.class);
        calculatorService = new CalculatorDiscountTariffImpl(calculatorRepo);
    }

    @Test
    public void testGetCalculator() {
        CalculatorDiscountTariffDto calcDto = new CalculatorDiscountTariffDto();
        calcDto.setPrice(100);
        calcDto.setDiscount(20);
        CalculatorDiscountTariff inputEntity = calcDto.dtoToEntity(calcDto);
        when(calculatorRepo.save(any())).thenReturn(inputEntity);
        CalculatorDiscountTariffDto result = calculatorService.getCalculator(calcDto);
        CalculatorDiscountTariffDto expectedResult = calcDto.entityToDto(inputEntity);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetCalculatorFinish() {
        CalculatorDiscountTariffDto inputDto = new CalculatorDiscountTariffDto();
        inputDto.setPrice(100);
        inputDto.setDiscount(20);
        CalculatorDiscountTariff inputEntity = inputDto.dtoToEntity(inputDto);
        when(calculatorRepo.save(any())).thenReturn(inputEntity);
        CalculatorDiscountTariffDto result = calculatorService.getCalculatorFinish(inputDto);
        CalculatorDiscountTariffDto expectedResult = inputDto.entityToDto(inputEntity);
        assertEquals(expectedResult, result);
    }
}