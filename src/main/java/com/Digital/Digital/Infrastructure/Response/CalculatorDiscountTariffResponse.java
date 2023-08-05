package com.Digital.Digital.Infrastructure.Response;

import lombok.Data;

@Data
public class CalculatorDiscountTariffResponse {

    private Long id;
    private int price;
    private int discount;
    private int calculatedPrice;

}
