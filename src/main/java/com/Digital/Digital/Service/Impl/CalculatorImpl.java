package com.Digital.Digital.Service.Impl;

import com.Digital.Digital.Entity.Calculator;
import com.Digital.Digital.Infrastructure.Dto.CalculatorDto;
import com.Digital.Digital.Repository.CalculatorRepo;
import com.Digital.Digital.Service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorImpl implements CalculatorService {

    @Autowired
    private CalculatorRepo calculatorRepo;

    @Override
    public CalculatorDto getCalculator(CalculatorDto calculatorDto) {
       int calc = calculatorDto.getPrice() - calculatorDto.getDiscount();
       calculatorDto.setCalculatedPrice(calc);
       Calculator saveCalc = calculatorRepo.save(calculatorDto.dtoToEntity(calculatorDto));
       return calculatorDto.entityToDto(saveCalc);
    }
}
