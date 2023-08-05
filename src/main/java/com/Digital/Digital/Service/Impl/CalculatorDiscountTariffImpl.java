package com.Digital.Digital.Service.Impl;

import com.Digital.Digital.Entity.CalculatorDiscountTariff;
import com.Digital.Digital.Infrastructure.Dto.CalculatorDiscountTariffDto;
import com.Digital.Digital.Repository.CalculatorDiscountRepo;
import com.Digital.Digital.Service.CalculatorDiscountTariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorDiscountTariffImpl implements CalculatorDiscountTariffService {

    @Autowired
    private CalculatorDiscountRepo calculatorRepo;

    @Override
    public CalculatorDiscountTariffDto getCalculator(CalculatorDiscountTariffDto calculatorDto) {
       int calc = calculatorDto.getPrice() - calculatorDto.getDiscount();
       calculatorDto.setCalculatedPrice(calc);
       CalculatorDiscountTariff saveCalc = calculatorRepo.save(calculatorDto.dtoToEntity(calculatorDto));
       return calculatorDto.entityToDto(saveCalc);
    }

    @Override
    public CalculatorDiscountTariffDto getCalculatorFinish(CalculatorDiscountTariffDto calculatorDto) {
        int calculator = calculatorDto.getPrice() + calculatorDto.getDiscount();
        calculatorDto.setCalculatedPrice(calculator);
        CalculatorDiscountTariff calculatorAll = calculatorRepo.save(calculatorDto.dtoToEntity(calculatorDto));
        return calculatorDto.entityToDto(calculatorAll);
    }
}
