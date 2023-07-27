package com.Digital.Digital.Infrastructure.Dto;

import com.Digital.Digital.Entity.Calculator;
import com.Digital.Digital.Infrastructure.Request.CalculatorRequest;
import com.Digital.Digital.Infrastructure.Response.CalculatorResponse;
import lombok.Data;

@Data
public class CalculatorDto {

    private Long id;

    private int price;
    private int discount;
    private int calculatedPrice;

    public static CalculatorDto requestToDto(CalculatorRequest calculatorRequest){
        CalculatorDto calculator = new CalculatorDto();
        calculator.setDiscount(calculatorRequest.getDiscount());
        calculator.setPrice(calculatorRequest.getPrice());
        return calculator;
    }

    public CalculatorResponse dtoToResponse(){
        CalculatorResponse calculatorResponse = new CalculatorResponse();
        calculatorResponse.setId(this.getId());
        calculatorResponse.setDiscount(this.getDiscount());
        calculatorResponse.setPrice(this.getPrice());
        calculatorResponse.setCalculatedPrice(this.getCalculatedPrice());
        return calculatorResponse;
    }

    public CalculatorDto entityToDto(Calculator calculator){
        CalculatorDto calculatorDto = new CalculatorDto();
        calculatorDto.setId(calculator.getId());
        calculatorDto.setDiscount(calculator.getDiscount());
        calculatorDto.setPrice(calculator.getPrice());
        calculatorDto.setCalculatedPrice(calculator.getCalculatedPrice());
        return calculatorDto;
    }

    public Calculator dtoToEntity(CalculatorDto calculatorDto){
        Calculator calculator = new Calculator();
        calculator.setId(calculatorDto.getId());
        calculator.setPrice(calculatorDto.getPrice());
        calculator.setDiscount(calculatorDto.getDiscount());
        calculator.setCalculatedPrice(calculatorDto.getCalculatedPrice());
        return calculator;
    }


}
