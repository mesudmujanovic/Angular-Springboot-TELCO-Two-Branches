package com.Digital.Digital.Controllers;

import com.Digital.Digital.Infrastructure.Dto.CalculatorDiscountTariffDto;
import com.Digital.Digital.Infrastructure.Request.CalculatorDiscountTariffRequest;
import com.Digital.Digital.Infrastructure.Response.CalculatorDiscountTariffResponse;
import com.Digital.Digital.Service.CalculatorDiscountTariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CalculatorDiscountTariffController {

    @Autowired
    private CalculatorDiscountTariffService calculatorService;

        @PostMapping("/calculate")
        public ResponseEntity<CalculatorDiscountTariffResponse> calculatePrice(@RequestBody CalculatorDiscountTariffRequest calculatorRequest) {
            CalculatorDiscountTariffDto calculatorDto = CalculatorDiscountTariffDto.requestToDto(calculatorRequest);
            CalculatorDiscountTariffDto saveCalc = calculatorService.getCalculator(calculatorDto);
            return ResponseEntity.ok( saveCalc.dtoToResponse() );
        }

    @PostMapping("/calculateAll")
    public ResponseEntity<CalculatorDiscountTariffResponse> calculatePriceAll(@RequestBody CalculatorDiscountTariffRequest calculatorRequest) {
        CalculatorDiscountTariffDto calculatorDto = CalculatorDiscountTariffDto.requestToDto(calculatorRequest);
        CalculatorDiscountTariffDto saveCalc = calculatorService.getCalculatorFinish(calculatorDto);
        return ResponseEntity.ok( saveCalc.dtoToResponse() );
    }

}
