package com.Digital.Digital.Infrastructure.Dto;

import com.Digital.Digital.Entity.CalculatorDiscountTariff;
import com.Digital.Digital.Infrastructure.Request.CalculatorDiscountTariffRequest;
import com.Digital.Digital.Infrastructure.Response.CalculatorDiscountTariffResponse;
import lombok.Data;

@Data
public class CalculatorDiscountTariffDto {

    private Long id;

    private int price;
    private int discount;
    private int calculatedPrice;


    public static CalculatorDiscountTariffDto requestToDto(CalculatorDiscountTariffRequest calculatorRequest){
        CalculatorDiscountTariffDto calculator = new CalculatorDiscountTariffDto();
        calculator.setDiscount(calculatorRequest.getDiscount());
        calculator.setPrice(calculatorRequest.getPrice());
        return calculator;
    }

    public CalculatorDiscountTariffResponse dtoToResponse(){
        CalculatorDiscountTariffResponse calculatorResponse = new CalculatorDiscountTariffResponse();
        calculatorResponse.setId(this.getId());
        calculatorResponse.setDiscount(this.getDiscount());
        calculatorResponse.setPrice(this.getPrice());
        calculatorResponse.setCalculatedPrice(this.getCalculatedPrice());
        return calculatorResponse;
    }

    public CalculatorDiscountTariffDto entityToDto(CalculatorDiscountTariff calculator){
        CalculatorDiscountTariffDto calculatorDto = new CalculatorDiscountTariffDto();
        calculatorDto.setId(calculator.getId());
        calculatorDto.setDiscount(calculator.getDiscount());
        calculatorDto.setPrice(calculator.getPrice());
        calculatorDto.setCalculatedPrice(calculator.getCalculatedPrice());
        return calculatorDto;
    }

    public CalculatorDiscountTariff dtoToEntity(CalculatorDiscountTariffDto calculatorDto){
        CalculatorDiscountTariff calculator = new CalculatorDiscountTariff();
        calculator.setId(calculatorDto.getId());
        calculator.setPrice(calculatorDto.getPrice());
        calculator.setDiscount(calculatorDto.getDiscount());
        calculator.setCalculatedPrice(calculatorDto.getCalculatedPrice());
        return calculator;
    }


}
